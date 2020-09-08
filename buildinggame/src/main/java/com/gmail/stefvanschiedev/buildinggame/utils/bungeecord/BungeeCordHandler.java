package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import com.github.simplenet.Client;
import com.github.simplenet.packet.Packet;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Handles all bungeecord calls
 *
 * @since 4.0.6
 */
public final class BungeeCordHandler {

    /**
     * The client
     */
    private final Client client = new Client();

    /**
     * A utility class for the names of people who can receive a message
     */
    public static final class Receiver {
        public static final String BUNGEE = "bungee";
        public static final String SUB_SERVER = "main";

        private Receiver() {}
    }

    /**
     * A collection of all callables that haven't been answered yet
     */
    private final Collection<IdentifiedCallable> callables = new HashSet<>();

    /**
     * Sends the provided message and will return a message to the specified callable if any exists
     *
     * @param message the message to send; the provided methods should be used for this
     * @param callable the callable that should be called once there is a response
     * @since 4.0.6
     */
    private void send(String message, IdentifiedCallable callable) {
        if (callable != null)
            callables.add(callable);

        Packet.builder().putString(message + (callable == null ? "" : ";uuid:" + callable.getUuid()))
            .queueAndFlush(client);
    }

    /**
     * Connect a player with a different server
     *
     * @param receiver the server that should receive this message
     * @param player the player to connect to a different server
     * @param server the name of the server the player should connect to
     * @param callable the callable that should be called once there is a response
     * @since 4.0.6
     */
    public void connect(String receiver, @NotNull AnimalTamer player, String server, IdentifiedCallable callable) {
        send("connect:" + player.getName() + ", " + server + ";receiver:" + receiver, callable);
    }

    /**
     * Teleports a player on a different server to a different location
     *
     * @param receiver the server that should receive this message
     * @param playerName the name of the player who should be teleported
     * @param world the world this player should teleport to
     * @param x the x position this player should teleport to
     * @param y the y position this player should teleport to
     * @param z the z position this player should teleport to
     * @param callable the callable that should be called once there is a response
     * @since 4.0.6
     */
    public void teleport(String receiver, String playerName, String world, double x, double y, double z,
                                IdentifiedCallable callable) {
        send("teleport:" + playerName + ", " + world + ", " + x + ", " + y + ", " + z + ";receiver:" +
                receiver, callable);
    }

    /**
     * Sends a join sign update to the server
     *
     * @param receiver the server that should receive this message
     * @param arena the arena for which the signs should update
     * @param line1 the new first line of the sign
     * @param line2 the new second line of the sign
     * @param line3 the new third line of the sign
     * @param line4 the new fourth line of the sign
     * @param callable the callable that should be called once there is a response
     * @since 4.0.6
     */
    public void sign(String receiver, @NotNull Arena arena, @NotNull String line1, @NotNull String line2,
                     @NotNull String line3, @NotNull String line4, IdentifiedCallable callable) {
        //escape the special ':' character
        send("sign:" + arena.getName() + ", " + line1.replace(":", "\\:") + ", " + line2
                .replace(":", "\\:") + ", " + line3.replace(":", "\\:") + ", " +
                line4.replace(":", "\\:") + ";receiver:" + receiver, callable);
    }

    /**
     * Called whenever a message is received
     *
     * @param message the message returned
     * @since 6.2.0
     */
    @Contract("null -> fail")
    private void onMessageReceived(@NotNull String message) {
        //encode data
        String[] data = message.split(";");

        if (data[0].startsWith("response") && data.length > 1)
            getCallable(UUID.fromString(data[1].split(":")[1])).call(data[0].split(":")[1]);
        else if (data[0].startsWith("write"))
            send(write(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("save"))
            send(save() + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("join"))
            send(join(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
    }

    /**
     * Writes raw input to a file
     *
     * @param input the input to write
     * @return a response message
     * @since 4.0.6
     */
    @NotNull
    private String write(@NotNull String input) {
        String[] data = input.split(", ");
        YamlConfiguration file;

        switch (data[0]) {
            case "arenas.yml":
                file = SettingsManager.getInstance().getArenas();
                break;
            case "config.yml":
                file = SettingsManager.getInstance().getConfig();
                break;
            case "messages.yml":
                file = SettingsManager.getInstance().getMessages();
                break;
            case "signs.yml":
                file = SettingsManager.getInstance().getSigns();
                break;
            default:
                return "response:failed";
        }

        file.set(data[1], data[2].startsWith("(int)") ? Integer.parseInt(data[2].replace("(int)", "")
                .trim()) : data[2]);

        return "response:success";
    }

    /**
     * Saves all files
     *
     * @return a response message
     * @since 4.0.6
     */
    @NotNull
    private String save() {
        SettingsManager.getInstance().save();

        return "response:success";
    }

    /**
     * Joins a player to an arena
     *
     * @param input the raw received input
     * @return a response message
     * @since 4.0.6
     */
    @NotNull
    private String join(@NotNull String input) {
        String[] data = input.split(", ");

        var player = Bukkit.getPlayer(data[0].trim());
        var arena = ArenaManager.getInstance().getArena(data[1].trim());

        if (player == null || arena == null)
            return "response:failed";

        new BukkitRunnable() {
            @Override
            public void run() {
                arena.join(player);
            }
        }.runTask(Main.getInstance());

        return "response:success";
    }

    /**
     * Returns the callable by the specified uuid
     *
     * @param uuid the uuid to look for
     * @return the identified callable with the given uuid
     * @since 4.0.6
     */
    @Nullable
    @Contract(pure = true)
    private IdentifiedCallable getCallable(UUID uuid) {
        return callables.stream().filter(callable -> callable.getUuid().equals(uuid)).findAny().orElse(null);
    }

    /**
     * A private constructor to keep this class a singleton
     */
    private BungeeCordHandler() {
        client.onConnect(() -> {
            Main.getInstance().getLogger().info("This server has connected to BungeeCord.");

            client.readStringAlways(this::onMessageReceived);
        });

        client.postDisconnect(() -> {
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
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        client.connect(
            config.getString("bungeecord.server.address"),
            config.getInt("bungeecord.server.port"),
            30L,
            TimeUnit.SECONDS,
            this::connectClient
        );
    }

    /**
     * An instance of this class
     */
    private static BungeeCordHandler INSTANCE;

    /**
     * Returns an instance of this singleton class or creates one if it doesn't exist yet
     *
     * @return an instance of this class
     * @since 4.0.6
     */
    @NotNull
    public static BungeeCordHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BungeeCordHandler();

        return INSTANCE;
    }
}
