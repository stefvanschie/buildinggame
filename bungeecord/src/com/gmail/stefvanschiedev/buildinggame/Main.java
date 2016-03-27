package com.gmail.stefvanschiedev.buildinggame;

import java.util.ArrayList;
import java.util.List;

import fr.rhaz.socketapi.Bungee.BungeeSocketHandshakeEvent;
import fr.rhaz.socketapi.Bungee.BungeeSocketJSONEvent;
import fr.rhaz.socketapi.SocketAPI.Server.SocketMessenger;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {

	private List<SocketMessenger> socketMessengers = new ArrayList<SocketMessenger>();
	
	@Override
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, this);
		
		getLogger().info("BuildingGane - BungeeCord AddOn has been enabled");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("BuildingGame - BungeeCord AddOn has been disabled");
	}
	
	@EventHandler
	public void onBungeeSocketHandshake(BungeeSocketHandshakeEvent e) {
		socketMessengers.add(e.getMessenger());
	}
	
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
			
			proxiedPlayer.connect(serverInfo);
		}
		
		for (SocketMessenger socketMessenger : socketMessengers)
			socketMessenger.writeJSON("BuildingGame", e.getData());
	}
}