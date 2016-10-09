package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

    private BoneCP connectionPool = null;
    private JavaPlugin plugin;
    private int MIN_CONNECTIONS = 5;
    private int MAX_CONNECTIONS = 10;

    public ConnectionManager(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public void configureConnPool() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        try {

            Class.forName("com.mysql.jdbc.Driver"); //also you need the MySQL driver
            plugin.getLogger().info("Creating BoneCP Configuration...");
            BoneCPConfig boneCPConfig = new BoneCPConfig();

            /* Already handled by settingsManager

            if(!config.contains("address")){
                config.set("address", "jdbc:mysql://localhost:3306/<databasename>");
                config.set("user","<user>");
                config.set("password","<password>");
                config.set("min-connections",5);
                config.set("max-connections",10);
                config.save(ConfigurationManager.getFile("MySQL"));
                plugin.getServer().shutdown();
                return;
            }
            */

            boneCPConfig.setJdbcUrl(config.getString("address"));
            boneCPConfig.setUsername(config.getString("user"));
            boneCPConfig.setPassword(config.getString("password"));
            boneCPConfig.setMinConnectionsPerPartition(config.getInt("min-connections")); //if you say 5 here, there will be 10 connection available
            boneCPConfig.setMaxConnectionsPerPartition(config.getInt("max-connections"));
            boneCPConfig.setPartitionCount(2); //2*5 = 10 connection will be available
            //config.setLazyInit(true); //depends on the application usage you should chose lazy or not
            //setting Lazy true means BoneCP won't open any connections before you request a one from it.
            plugin.getLogger().info("Setting up MySQL Connection pool...");
            connectionPool = new BoneCP(boneCPConfig); // setup the connection pool
            plugin.getLogger().info("Connection pool successfully configured. ");
            plugin.getLogger().info("Total connections ==> " + connectionPool.getTotalCreatedConnections());


        }   catch (Exception e) {

            e.printStackTrace(); //you should use exception wrapping on real-production code
        }

    }

    public void shutdownConnPool() {

        try {

            plugin.getLogger().info("Shutting down connection pool. Trying to close all connections.");
            if (connectionPool != null) {
                connectionPool.shutdown(); //this method must be called only once when the application stops.
                //you don't need to call it every time when you get a connection from the Connection Pool
                plugin.getLogger().info("Pool successfully shutdown. ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {



        Connection conn = null;
        try {
            conn = getConnectionPool().getConnection();
            //will get a thread-safe connection from the BoneCP connection pool.
            //synchronization of the method will be done inside BoneCP source

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

    public void closeStatement(Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeResultSet(ResultSet rSet) {
        try {
            if (rSet != null)
                rSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close(); //release the connection - the name is tricky but connection is not closed it is released
            //and it will stay in pool
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public BoneCP getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(BoneCP connectionPool) {
        connectionPool = connectionPool;
    }

}
