package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

/**
 * This class handles the MySQL database
 *
 * @author TomVerschueren
 * @since 4.0.6
 */
public class MySQLDatabase {

    /**
     * The connection manager managing this database
     */
    private ConnectionManager manager;

    /**
     * The main plugin
     */
    private final JavaPlugin plugin;


    /**
     * Creates table in the database if it doesn't exist yet.
     *
     * @param javaPlugin main instance of plugin.
     * @since 4.0.6
     */
    MySQLDatabase(JavaPlugin javaPlugin){
        this.plugin = javaPlugin;
    }

    /**
     * Creates the database if it doesn't exist yet
     *
     * @return whether the database was setup correctly
     * @since 4.0.6
     */
    public boolean setup() {
        this.manager = new ConnectionManager(plugin);
        plugin.getLogger().info("Configuring connection pool...");
        
        if (!manager.configureConnPool())
        	return false;

        Connection connection = null;
        Statement statement = null;

        try {
            connection = manager.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `buildinggamestats` (\n" +
                    "  `UUID` varchar(36) NOT NULL PRIMARY KEY,\n" +
                    "  `plays` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `first` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `second` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `third` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `broken` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `placed` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `walked` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `points_received` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `points_given` int(11) NOT NULL DEFAULT '0'\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException e) {
        	plugin.getLogger().info("Failed to create table in database! Returning to file stats.");
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Table exists
        return true;
    }

    /**
     * Updates database with new information
     *
     * @param query SQL command to be performed.
     * @since 4.0.6
     */
    private void executeUpdate(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = manager.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate(query);
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to execute update: " + query);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Get information from the database
     *
     * @param query SQL command to be performed
     * @return Returns a resultset which gives you the information that is asked
     * @since 4.0.6
     */
    @Nullable
    private ResultSet executeQuery(String query){
        Connection connection = null;
        Statement statement = null;

        try {
            connection = manager.getConnection();
            //noinspection JDBCResourceOpenedButNotSafelyClosed
            statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException exception){
            exception.printStackTrace();
            plugin.getLogger().warning("Failed to execute request: "+query);

            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * Insert a new player in the table that is not there yet
     * WARNING: Use this in a Async task!
     *
     * @param UUID UUID from player
     * @since 4.0.6
     */
    public void insertPlayer(String UUID) {
        ResultSet set = null;

    	try {
            set = executeQuery("SELECT UUID FROM buildinggamestats WHERE UUID='" + UUID + '\'');

    	    if (set == null)
                return;

            if (!set.next())
                executeUpdate("INSERT INTO buildinggamestats (UUID,walked) VALUES ('" + UUID + "',0)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(set);
        }
    }

    /**
     * Reset stat to the desired amount
     * WARNING: Use this in a Async task!
     *
     * @param UUID UUID from player
     * @param statType the stat type to update
     * @param number Reset to this amount
     * @since 4.0.6
     */
    public void setStat(String UUID, StatType statType, int number) {
        String statName = statType.toString().toLowerCase(Locale.getDefault());

        executeUpdate("UPDATE buildinggamestats SET " + statName + '=' + number + " WHERE UUID='" + UUID + '\'');
    }

    /**
     * Retrieve stat from database
     * WARNING: Use this in a Async task!
     *
     * @param UUID UUID from player
     * @param stat String from stat to be retrieved
     * @return returns an int which represents the stat
     * @since 4.0.6
     */
    public int getStat(String UUID, String stat) {
        ResultSet set = null;

        try {
            set = executeQuery("SELECT "+stat+" FROM buildinggamestats WHERE UUID='"+UUID+ '\'');

            if (set == null || !set.next())
                return 0;

            return set.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return 0;
        } finally {
            closeResultSet(set);
        }
    }

    /**
     * Retrieves a set of all UUIDs currently in the database
     *
     * @return a set of all UUIDs in the database
     */
    Set<UUID> getAllPlayers() {
    	var uuids = new HashSet<UUID>();
        ResultSet set = null;

    	try {
    	    set = executeQuery("SELECT UUID FROM buildinggamestats");

            if (set == null)
                return uuids;

            while (set.next())
                uuids.add(UUID.fromString(set.getString(1)));
        } catch (SQLException e) {
            plugin.getLogger().warning("Error while retrieving data from database");
            e.printStackTrace();
        } finally {
            closeResultSet(set);
        }
    	
    	return uuids;
    }

    /**
     * Releases the result set from the database
     *
     * @param set the result set to release
     * @since 4.0.6
     */
    private static void closeResultSet(ResultSet set) {
        try {
            set.close();
            set.getStatement().close();
            set.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}