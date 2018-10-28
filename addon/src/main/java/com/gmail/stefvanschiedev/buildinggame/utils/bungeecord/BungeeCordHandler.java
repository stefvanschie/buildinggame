package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.JoinSign;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import simplenet.Client;
import simplenet.packet.Packet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Handles all BungeeCord calls
 *
 * @since 4.0.6
 */
public final class BungeeCordHandler {

    /**
     * The client
     */
    private final Client client = new Client();

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

        Packet.builder().putString(message + (callable == null ? "" : ";uuid:" + callable.getUuid()))
            .writeAndFlush(client);
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
    public void connect(String receiver, @NotNull AnimalTamer player, String server, IdentifiedCallable callable) {
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
     * @param message the message returned
     * @since 6.2.0
     */
    @Contract("null -> fail")
    private void onMessageReceived(@NotNull String message) {
        //decode data
        String[] data = message.split(";");

        if (data[0].startsWith("response") && data.length > 1)
            getCallable(UUID.fromString(data[1].split(":")[1])).call(data[0].split(":")[1]);
        else if (data[0].startsWith("teleport"))
            send(teleport(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("sign"))
            send(sign(data[0].split("[^\\\\]:")[1]) + ';' + (data.length > 2 ? data[2] : ""),
                null);
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
    private String teleport(@NotNull String input) {
        String[] data = input.split(", ");

        var player = Bukkit.getPlayer(data[0]);

        if (player == null)
            return "response:failed";

        var world = Bukkit.getWorld(data[1]);

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
    private String sign(@NotNull String input) {
        //undo escaping of special ':' character
        String[] data = input.replace("\\:", ":").split(", ");

        JoinSign.getSigns(data[0]).forEach(joinSign -> {
            var sign = joinSign.getSign();

            sign.setLine(0, data[1]);
            sign.setLine(1, data[2]);
            sign.setLine(2, data[3]);
            sign.setLine(3, data[4]);
            sign.update();
        });

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
        return callables.stream().filter(callable -> callable.getUuid().equals(uuid)).findAny().orElse(null);
    }

    /**
     * Private constructor to keep this class a singleton
     */
    private BungeeCordHandler() {
        client.onConnect(() -> {
            Main.getInstance().getLogger().info("This server has connected to BungeeCord.");

            client.readStringAlways(this::onMessageReceived);
        });

        client.onDisconnect(() -> {
            Main.getInstance().getLogger().info("This server has been disconnected from BungeeCord.");

            connectClient();
        });

        connectClient();
    }

    /**
     * Attempts to connect the client. If no connection has been established after 30 seconds, this method will retry
     * again. This will continue until a connection has been made.
     *
     * @since 6.2.0
     */
    private void connectClient() {
        ConfigurationSection config = SettingsManager.getInstance().getConfig();

        client.connect(
            config.getString("bungeecord.server.address"),
            config.getInt("bungeecord.server.port"),
            30L,
            TimeUnit.SECONDS,
            this::connectClient
        );
    }

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
