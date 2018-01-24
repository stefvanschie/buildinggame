package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import com.gmail.stefvanschiedev.buildinggame.utils.JoinSign;
import fr.rhaz.socket4mc.Bukkit;
import fr.rhaz.socket4mc.Socket4MC;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Handles all BungeeCord calls
 *
 * @since 4.0.6
 */
public final class BungeeCordHandler implements Listener {

    /**
     * The channel name
     */
    private static final String CHANNEL = "BuildingGame";

    /**
     * Utility class for different types of receivers
     *
     * @since 4.0.6
     */
    public final class Receiver {

        /**
         * BungeeCord receiver
         */
        public static final String BUNGEE = "bungee";

        /**
         * Main server receiver
         */
        public static final String MAIN = "main";

        /**
         * Private constructor to keep this class a utility class
         */
        private Receiver() {}
    }

    /**
     * A collection of all callables that aren't called yet
     */
    private final Collection<IdentifiedCallable> callables = new HashSet<>();

    /**
     * Sends a message to the BungeeCord server
     *
     * @param message the message to be send
     * @param callable the callable that should be called
     * @since 4.0.6
     */
    private void send(String message, IdentifiedCallable callable) {
        if (callable != null)
            callables.add(callable);
        Socket4MC.bukkit().getSocketClient().writeJSON(CHANNEL, message + (callable == null ? "" : ";uuid:" +
                callable.getUuid()));
    }

    /**
     * Connects a player to a different server
     *
     * @param receiver the server that should receive this message
     * @param player the player that should be moved
     * @param server the new server
     * @param callable the callable that should be called after this is successful
     * @since 4.0.6
     */
    public void connect(String receiver, AnimalTamer player, String server, IdentifiedCallable callable) {
        send("connect:" + player.getName() + ", " + server + ";receiver:" + receiver, callable);
    }

    /**
     * Writes a key/value pair to a file on another server
     *
     * @param receiver the server that should receive this message
     * @param file the file to write to
     * @param key the key that should be added
     * @param value the value that belongs to the key
     * @param callable the callable that should be called after this is successful
     * @since 4.0.6
     */
    public void write(String receiver, String file, String key, String value, IdentifiedCallable callable) {
        send("write:" + file + ", " + key + ", " + value + ";receiver:" + receiver, callable);
    }

    /**
     * Saves all files on a different server
     *
     * @param receiver the server that should receive this message
     * @param callable the callable that should be called after this is successful
     * @since 4.0.6
     */
    public void save(String receiver, IdentifiedCallable callable) {
        send("save;receiver:" + receiver, callable);
    }

    /**
     * Makes a player join an arena on a different server
     *
     * @param receiver the server that should receive this message
     * @param playerName the name of the player to join
     * @param arena the arena that the player should join
     * @param callable the callable that should be called after this is successful
     * @since 4.0.6
     */
    public void join(String receiver, String playerName, String arena, IdentifiedCallable callable) {
        send("join:" + playerName + ", " + arena + ";receiver:" + receiver, callable);
    }

    /**
     * Called whenever a message is received
     *
     * @param e the event that occurs
     */
    @Contract("null -> fail")
    @EventHandler
    public void onBukkitSocketJSON(Bukkit.BukkitSocketJSONEvent e) {
        if (!e.getChannel().equals("BuildingGame"))
            return;

        //decode data
        String[] data = e.getData().split(";");

        if (data[0].startsWith("response") && data.length > 1)
            getCallable(UUID.fromString(data[1].split(":")[1])).call(data[0].split(":")[1]);
        else if (data[0].startsWith("teleport"))
            send(teleport(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("sign"))
            send(sign(data[0].split("[^\\\\]:")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
    }

    /**
     * Called whenever a teleport command has been received
     *
     * @param input the message received
     * @return the response message
     * @since 4.0.6
     */
    @NotNull
    @Contract("null -> fail")
    private String teleport(String input) {
        String[] data = input.split(", ");

        Player player = org.bukkit.Bukkit.getPlayer(data[0]);
        if (player == null)
            return "response:failed";

        World world = org.bukkit.Bukkit.getWorld(data[1]);
        if (world == null)
            return "response:failed";

        int x, y, z;
        try {
            x = Integer.parseInt(data[2]);
            y = Integer.parseInt(data[3]);
            z = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            return "response:failed";
        }

        player.teleport(new Location(world, x, y, z));
        return "response:success";
    }

    /**
     * Called whenever a sign command has been received
     *
     * @param input the message received
     * @return the response message
     * @since 4.0.6
     */
    @NotNull
    @Contract("null -> fail")
    private String sign(String input) {
        //undo escaping of special ':' character
        String[] data = input.replace("\\:", ":").split(", ");

        Set<JoinSign> joinSigns = JoinSign.getSigns(data[0]);
        for (JoinSign joinSign : joinSigns) {
            Sign sign = joinSign.getSign();

            sign.setLine(0, data[1]);
            sign.setLine(1, data[2]);
            sign.setLine(2, data[3]);
            sign.setLine(3, data[4]);
            sign.update();
        }

        return "response: success";
    }

    /**
     * Returns the callable by the given UUID
     *
     * @param uuid the UUID of the callable
     * @return the callable that belongs to this UUID
     * @since 4.0.6
     */
    @Nullable
    @Contract(pure = true)
    private IdentifiedCallable getCallable(UUID uuid) {
        for (IdentifiedCallable callable : callables) {
            if (callable.getUuid().equals(uuid))
                return callable;
        }

        return null;
    }

    /**
     * Private constructor to keep this class a singleton
     */
    private BungeeCordHandler() {}

    /**
     * Instance of this class for the singleton pattern
     */
    private static BungeeCordHandler INSTANCE;

    /**
     * Returns an instance of this class
     *
     * @return this class
     * @since 4.0.6
     */
    @NotNull
    public static BungeeCordHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BungeeCordHandler();
        return INSTANCE;
    }
}
