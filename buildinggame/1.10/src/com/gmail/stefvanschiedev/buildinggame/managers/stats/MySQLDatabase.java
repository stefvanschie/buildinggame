package com.gmail.stefvanschiedev.buildinggame.managers.stats;


import org.bukkit.plugin.java.JavaPlugin;
import java.sql.*;

public class MySQLDatabase {

    public ConnectionManager manager;
    JavaPlugin plugin;


    /**
     * Creates table in the database if it doesn't exist yet.
     * @param javaPlugin main instance of plugin.
     */
    public MySQLDatabase(JavaPlugin javaPlugin){
        this.plugin = javaPlugin;

    }

    public boolean setup(){
        this.manager = new ConnectionManager(plugin);
        plugin.getLogger().info("Configuring connection pool...");
        if(!manager.configureConnPool())
            return false;


        try {
            Connection connection = manager.getConnection();
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `buildinggamestats` (\n" +
                    "  `UUID` text NOT NULL,\n" +
                    "  `plays` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `first` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `second` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `third` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `broken` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `placed` int(11) NOT NULL DEFAULT '0',\n" +
                    "  `walked` int(11) NOT NULL DEFAULT '0'\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            manager.closeConnection(connection);
        } catch (SQLException e) {
            plugin.getLogger().info("Failed to create table in database! Returning to file stats.");
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
        return true;
        // Table exists


    }

    /**
     * Updates database with new information
     * @param query SQL command to be performed.
     */
    private void executeUpdate(String query){
        try {
            Connection connection = manager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            manager.closeConnection(connection);
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to execute update: "+query);
        }

    }


    /**
     *  Get information from the database
     * @param query SQL command to be performed
     * @return Returns a resultset which gives you the information that is asked
     */
    private ResultSet executeQuery(String query){
        try {
            Connection connection = manager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            manager.closeConnection(connection);
            return rs;
        } catch (SQLException exception){
            exception.printStackTrace();
            plugin.getLogger().warning("Failed to execute request: "+query);
            return null;
        }
    }

    /**
     *  Insert a new player in the table that is not there yet
     *  WARNING: Use this in a Async task!
     * @param UUID UUID from player
     */
    public void insertPlayer(String UUID){
        ResultSet set = executeQuery("SELECT UUID FROM buildinggamestats WHERE username='"+ UUID+ "'");
        try {
            if(set.next())
                executeUpdate("INSERT INTO buildinggamestats (UUID,walked) VALUES ('"+UUID+"',0)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the connection pool
     */
    public void closeDatabase(){
        manager.shutdownConnPool();
    }


    /**
     * Increase defined stat by the defined amount
     * WARNING: Use this in a Async task!
     * @param UUID UUID from player
     * @param stat  String from stat to be updated
     */
    public void addStat(String UUID, String stat){
        addStat(UUID, stat,1);
    }

    /**
     * Increase defined stat by the defined amount
     * WARNING: Use this in a Async task!
     * @param UUID UUID from player
     * @param stat String from stat to be updated
     * @param amount Amount to be increased
     */
    public void addStat(String UUID, String stat, int amount){
        executeUpdate("UPDATE buildinggamestats SET "+stat+"="+stat+"+"+amount+" WHERE UUID='"+UUID+"'");
    }

    /**
     *  Reset stat to the desired amount
     *  WARNING: Use this in a Async task!
     * @param UUID UUID from player
     * @param stat String from stat to be updated
     * @param number Reset to this amount
     */
    public void setStat(String UUID, String stat, int number){
        executeUpdate("UPDATE buildinggamestats SET "+stat+"="+number+" WHERE UUID='"+UUID+"'");
    }

    /**
     * Retrieve stat from database
     * WARNING: Use this in a Async task!
     * @param UUID UUID from player
     * @param stat String from stat to be retrieved
     * @return returns an int which represents the stat
     */
    public int getStat(String UUID, String stat){
        ResultSet set = executeQuery("SELECT "+stat+" FROM buildinggamestats WHERE UUID='"+UUID+"'");
        try {
            if(!set.next())
                return 0;
            return(set.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return 0;
        }

    }




}
