package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class MessagingChannel {
	
	public void connect(Player player, String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);

		player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getBlockStates(Location high, Location low) {
		//returns a value so there need to be listened
		try {
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("Forward");
			out.writeUTF("ALL");
			out.writeUTF("BuildingGame");
		
			ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
			DataOutputStream msgout = new DataOutputStream(msgbytes);
			msgout.writeUTF("getBlockState"); 
			msgout.writeUTF(high.getWorld().getName());
			msgout.writeDouble(high.getX());
			msgout.writeDouble(high.getY());
			msgout.writeDouble(high.getZ());
			msgout.writeUTF(low.getWorld().getName());
			msgout.writeDouble(low.getX());
			msgout.writeDouble(low.getY());
			msgout.writeDouble(low.getZ());

			out.writeShort(msgbytes.toByteArray().length);
			out.write(msgbytes.toByteArray());
			
			Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getIp(Player player) {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("IP");

		player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getPlayerCount(String server) {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerCount");
		out.writeUTF(server);

		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getPlayerList(String server) {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerList");
		out.writeUTF(server);

		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getServers() {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("GetServers");

		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void sendMessage(Player player, String message) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Message");
		out.writeUTF(player.getName());
		out.writeUTF(message);
		  
		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getServer() {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("GetServer");

		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getUUID(Player player) {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("UUID");
		
		player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void getServerIp(String server) {
		//returns a value so there need to be listened
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("ServerIP");
		out.writeUTF(server);

		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
	
	public void kick(Player player, String reason) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("KickPlayer");
		out.writeUTF(player.getName());
		out.writeUTF(reason);
		  
		Bukkit.getServer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
}