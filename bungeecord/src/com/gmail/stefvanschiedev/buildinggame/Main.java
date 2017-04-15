package com.gmail.stefvanschiedev.buildinggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.rhaz.socket4mc.Bungee.BungeeSocketHandshakeEvent;
import fr.rhaz.socket4mc.Bungee.BungeeSocketJSONEvent;
import fr.rhaz.socketapi.SocketAPI.Server.SocketMessenger;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {

	private final Collection<SocketMessenger> socketMessengers = new ArrayList<>();
	
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, this);
		
		getLogger().info("BuildingGame - BungeeCord AddOn has been enabled");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("BuildingGame - BungeeCord AddOn has been disabled");
	}
	
	@SuppressWarnings("unused")
    @EventHandler
	public void onBungeeSocketHandshake(BungeeSocketHandshakeEvent e) {
		socketMessengers.add(e.getMessenger());
	}
	
	@SuppressWarnings("unused")
    @EventHandler
	public void onBungeeSocketJSON(BungeeSocketJSONEvent e) {
		//send the information through
		if (!e.getChannel().equals("BuildingGame"))
			return;
		
		if (e.getData().startsWith("connect:")) {
			String[] data = e.getData().replace("connect:", "").trim().split(", ");
			
			/*data[0] = player
			  data[1] = server*/
			
			ProxiedPlayer proxiedPlayer = getProxy().getPlayer(data[0]);
			ServerInfo serverInfo = getProxy().getServerInfo(data[1]);
			
			System.out.println(proxiedPlayer == null ? "proxiedplayer == null" : "proxiedplayer != null");
			System.out.println(serverInfo == null ? "serverinfo == null" : "serverinfo != null");

			if (proxiedPlayer != null)
				proxiedPlayer.connect(serverInfo);
		}
		
		for (SocketMessenger socketMessenger : socketMessengers)
			socketMessenger.writeJSON("BuildingGame", e.getData());
	}
}