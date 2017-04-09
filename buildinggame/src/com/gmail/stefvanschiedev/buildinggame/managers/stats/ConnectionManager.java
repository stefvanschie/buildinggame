package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;

class ConnectionManager {

    private BoneCP connectionPool = null;
    private final JavaPlugin plugin;

    public ConnectionManager(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public boolean configureConnPool() {
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

            boneCPConfig.setJdbcUrl(config.getString("stats.database.address"));
            boneCPConfig.setUsername(config.getString("stats.database.user"));
            boneCPConfig.setPassword(config.getString("stats.database.password"));
            boneCPConfig.setMinConnectionsPerPartition(config.getInt("stats.database.min-connections")); //if you say 5 here, there will be 10 connection available
            boneCPConfig.setMaxConnectionsPerPartition(config.getInt("stats.database.max-connections"));
            boneCPConfig.setPartitionCount(2); //2*5 = 10 connection will be available
            //config.setLazyInit(true); //depends on the application usage you should chose lazy or not
            //setting Lazy true means BoneCP won't open any connections before you request a one from it.
            plugin.getLogger().info("Setting up MySQL Connection pool...");
            connectionPool = new BoneCP(boneCPConfig); // setup the connection pool
            plugin.getLogger().info("Connection pool successfully configured. ");
            plugin.getLogger().info("Total connections ==> " + connectionPool.getTotalCreatedConnections());


        } catch (ClassNotFoundException | SQLException e) {
        	plugin.getLogger().info("Connection failed! Returning to file stats.");
            e.printStackTrace(); //you should use exception wrapping on real-production code
            return false;
        }
        
        return true;
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

    public void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close(); //release the connection - the name is tricky but connection is not closed it is released
            //and it will stay in pool
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private BoneCP getConnectionPool() {
        return connectionPool;
    }
}