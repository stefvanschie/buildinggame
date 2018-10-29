package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
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
    private HikariPool connectionPool;

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
            plugin.getLogger().info("Creating HikariCP Configuration...");
            var hikariConfig = new HikariConfig();

            hikariConfig.setJdbcUrl(config.getString("stats.database.address"));
            hikariConfig.setUsername(config.getString("stats.database.user"));
            hikariConfig.setPassword(config.getString("stats.database.password"));
            hikariConfig.setMaximumPoolSize(config.getInt("stats.database.maximum-pool-size"));
            hikariConfig.setConnectionTimeout(config.getLong("stats.database.connection-timeout"));
            hikariConfig.setMaxLifetime(config.getLong("stats.database.max-lifetime"));

            plugin.getLogger().info("Setting up MySQL Connection pool...");
            connectionPool = new HikariPool(hikariConfig); // setup the connection pool
            plugin.getLogger().info("Connection pool successfully configured. ");
        } catch (ClassNotFoundException e) {
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
    @Nullable
    Connection getConnection() {
        try {
            return connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}