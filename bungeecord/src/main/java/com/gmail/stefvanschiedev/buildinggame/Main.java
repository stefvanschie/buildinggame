package com.gmail.stefvanschiedev.buildinggame;

import java.util.*;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import simplenet.Client;
import simplenet.Server;
import simplenet.packet.Packet;

/**
 * Main class for this plugin
 */
public class Main extends Plugin implements Listener {

    /**
     * The server
     */
    private final Server server = new Server();

    /**
     * A collection of clients
     */
	private Collection<Client> clients;

    /**
     * A map of the connections which still have to be send to a server
     */
	private Map<UUID, Map.Entry<Client, String>> pendingConnections;

    /**
     * Called whenever this plugin is being enabled
     *
     * @since 2.1.0
     */
	@Override
	public void onEnable() {
	    server.onConnect(client -> {
	        getLogger().info("An instance has connected.");

	        clients.add(client);

	        client.readStringAlways(value -> onMessageReceived(value, client));

	        client.onDisconnect(() -> getLogger().info("An instance has disconnected."));
        });

	    server.bind("localhost", 26048);

	    getProxy().getPluginManager().registerListener(this, this);

		clients = new HashSet<>();
		pendingConnections = new HashMap<>();

		getLogger().info("BuildingGame - BungeeCord AddOn has been enabled");
	}

    /**
     * Called whenever this plugin is being disabled
     *
     * @since 2.1.0
     */
	@Override
	public void onDisable() {
		getLogger().info("BuildingGame - BungeeCord AddOn has been disabled");
	}

    /**
     * Called whenever a player is connected to a server
     *
     * @param e the event that occurs
     * @since 4.0.6
     */
    @SuppressWarnings("unused")
    @EventHandler
    public void onServerDisconnect(ServerDisconnectEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();

        if (!pendingConnections.containsKey(uuid))
            return;

        var entry = pendingConnections.get(uuid);

        Packet.builder().putString(entry.getValue()).writeAndFlush(entry.getKey());
        pendingConnections.remove(uuid);
    }

    /**
     * Called whenever BungeeCord receives information from a server
     *
     * @param message the message received
     * @since 6.2.0
     */
	@Contract("null, _ -> fail")
	private void onMessageReceived(@NotNull String message, @NotNull Client client) {
	    //encode data
        String[] data = message.split(";");

        if (data[0].startsWith("response")) {
            //bungee doesn't send stuff by itself
            clients.forEach(c -> Packet.builder().putString(message).writeAndFlush(c));

            return;
        }

        if (data[1].split(":")[1].equals(Receiver.BUNGEE))
            //has to be a connect statement
            connect(data[0].split(":")[1], client, data.length > 2 ? data[2] : null);
        else
            //send to other servers
            clients.forEach(c -> Packet.builder().putString(message).writeAndFlush(c));
	}

    /**
     * Connects the player to a server, based on the given response
     *
     * @param response the response gotten from the server
     * @param client the client which sent this message
     * @param uuid the uuid of the callable on the sending server
     * @since 4.0.6
     */
	private void connect(@NotNull String response, Client client, String uuid) {
        String[] data = response.replace("connect:", "").trim().split(", ");

        var proxiedPlayer = getProxy().getPlayer(data[0]);
        var serverInfo = getProxy().getServerInfo(data[1]);

        if (proxiedPlayer != null && serverInfo != null) {
            proxiedPlayer.connect(serverInfo);
            pendingConnections.put(proxiedPlayer.getUniqueId(), new AbstractMap.SimpleEntry<>(client,
                "response:success" + (uuid != null ? ';' + uuid : "")));

            return;
        }

        Packet.builder().putString("response:failed" + (uuid != null ? ';' + uuid : "")).writeAndFlush(client);
    }

    /**
     * Represents different names for receivers
     *
     * @since 4.0.6
     */
    final class Receiver {
        /**
         * The name of the BungeeCord receiver
         */
        static final String BUNGEE = "bungee";

        /**
         * To keep this class a utility class
         */
        private Receiver() {}
    }
}