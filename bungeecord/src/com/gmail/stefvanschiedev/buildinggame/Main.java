package com.gmail.stefvanschiedev.buildinggame;

import java.util.*;

import fr.rhaz.socket4mc.Bungee.BungeeSocketHandshakeEvent;
import fr.rhaz.socket4mc.Bungee.BungeeSocketJSONEvent;
import fr.rhaz.socketapi.SocketAPI;
import fr.rhaz.socketapi.SocketAPI.Server.SocketMessenger;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * Main class for this plugin
 */
public class Main extends Plugin implements Listener {

    /**
     * A collection of socket messengers
     */
	private Collection<SocketMessenger> socketMessengers;

    /**
     * A map of the connections which still have to be send to a server
     */
	private Map<ProxiedPlayer, Map.Entry<SocketMessenger, String>> pendingConnections;

    /**
     * The channel name
     */
	private static final String CHANNEL = "BuildingGame";

    /**
     * Called whenever this plugin is being enabled
     *
     * @since 2.1.0
     */
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, this);

		socketMessengers = new HashSet<>();
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
     * Called whenever the server connects with BungeeCord correctly
     *
     * @param e the event that occurs
     * @since 2.1.0
     */
	@SuppressWarnings("unused")
    @EventHandler
	public void onBungeeSocketHandshake(BungeeSocketHandshakeEvent e) {
        socketMessengers.add(e.getMessenger());
	}

    /**
     * Called whenever a player is connected to a server
     *
     * @param e the event that occurs
     * @since 4.0.6
     */
    @SuppressWarnings("unused")
    @EventHandler
    public void onServerConnected(ServerConnectedEvent e) {
        ProxiedPlayer proxiedPlayer = e.getPlayer();

        if (!pendingConnections.containsKey(proxiedPlayer))
            return;

        Map.Entry<SocketAPI.Server.SocketMessenger, String> entry = pendingConnections.get(proxiedPlayer);

        entry.getKey().writeJSON(CHANNEL, entry.getValue());
        pendingConnections.remove(proxiedPlayer);
    }

    /**
     * Called whenever BungeeCord receives information from a server
     *
     * @param e the event that occurs
     * @since 2.1.0
     */
	@SuppressWarnings("unused")
    @EventHandler
	public void onBungeeSocketJSON(BungeeSocketJSONEvent e) {
		//send the information through
		if (!e.getChannel().equals("BuildingGame"))
			return;

        //encode data
        String[] data = e.getData().split(";");

        if (data[0].startsWith("response")) {
            //bungee doesn't send stuff by itself
            for (SocketMessenger messenger : socketMessengers)
                messenger.writeJSON(CHANNEL, e.getData());

            return;
        }

        if (data[1].split(":")[1].equals(Receiver.BUNGEE))
            //has to be a connect statement
            connect(data[0].split(":")[1], e.getMessenger(), data.length > 2 ? data[2] : null);
        else {
            //send to other servers
            for (SocketMessenger messenger : socketMessengers)
                messenger.writeJSON(CHANNEL, e.getData());
        }
	}

    /**
     * Connects the player to a server, based on the given response
     *
     * @param response the response gotten from the server
     * @param messenger the messenger which sent this message
     * @param uuid the uuid of the callable on the sending server
     * @since 4.0.6
     */
	private void connect(String response, SocketMessenger messenger, String uuid) {
        String[] data = response.replace("connect:", "").trim().split(", ");

        ProxiedPlayer proxiedPlayer = getProxy().getPlayer(data[0]);
        ServerInfo serverInfo = getProxy().getServerInfo(data[1]);

        if (proxiedPlayer != null && serverInfo != null) {
            proxiedPlayer.connect(serverInfo);
            pendingConnections.put(proxiedPlayer, new AbstractMap.SimpleEntry<>(messenger, "response:success" +
                    (uuid != null ? ';' + uuid : "")));

            return;
        }

        messenger.writeJSON(CHANNEL, "response:failed" + (uuid != null ? ';' + uuid : ""));
    }

    /**
     * Represents different names for receivers
     *
     * @since 4.0.6
     */
    public final class Receiver {
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