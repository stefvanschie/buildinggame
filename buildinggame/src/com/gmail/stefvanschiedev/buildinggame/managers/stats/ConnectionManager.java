package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class handles the connection with the database
 *
 * @author TomVerschueren
 * @since 4.0.6
 */
class ConnectionManager {

    /**
     * The connection pool
     */
    private BoneCP connectionPool;

    /**
     * The main plugin
     */
    private final JavaPlugin plugin;

    /**
     * Constructs a new ConnectionManager
     *
     * @param plugin the main plugin
     */
    ConnectionManager(JavaPlugin plugin){
        this.plugin = plugin;
    }

    /**
     * Configures the connection pool
     *
     * @return true if the connection pool was setup correctly, false otherwise
     * @since 4.0.6
     */
    boolean configureConnPool() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        try {
            Class.forName("com.mysql.jdbc.Driver"); //also you need the MySQL driver
            plugin.getLogger().info("Creating BoneCP Configuration...");
            BoneCPConfig boneCPConfig = new BoneCPConfig();

            boneCPConfig.setJdbcUrl(config.getString("stats.database.address"));
            boneCPConfig.setUsername(config.getString("stats.database.user"));
            boneCPConfig.setPassword(config.getString("stats.database.password"));
            boneCPConfig.setMinConnectionsPerPartition(config.getInt("stats.database.min-connections")); //if you say 5 here, there will be 10 connection available
            boneCPConfig.setMaxConnectionsPerPartition(config.getInt("stats.database.max-connections"));
            boneCPConfig.setPartitionCount(2); //2*5 = 10 connection will be available

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

    /**
     * Returns the MySQL connection from the current connection pool
     *
     * @return the MySQL connection
     * @since 4.0.6
     */
    public Connection getConnection() {
        try (BoneCP connectionPool = getConnectionPool(); Connection conn = connectionPool.getConnection()) {
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the current connection pool or null if the connection pool wasn't setup correctly
     *
     * @return the connection pool
     * @since 4.0.6
     */
    @Nullable
    @Contract(pure = true)
    private BoneCP getConnectionPool() {
        return connectionPool;
    }
}