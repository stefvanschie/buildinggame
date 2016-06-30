package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class SignManager {

	private SignManager() {}
	
	private static SignManager instance = new SignManager();
	
	public static SignManager getInstance() {
		return instance;
	}
	
	private List<Sign> leaveSigns = new ArrayList<>();
	
	public void setup() {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			arena.getSigns().clear();
		}
		
		for (String string : signs.getKeys(false)) {
			//location check
			Location location = new Location(Bukkit.getWorld(signs.getString(string + ".world")),
					signs.getInt(string + ".x"),
					signs.getInt(string + ".y"),
					signs.getInt(string + ".z"));
			if (!(location.getBlock().getState() instanceof Sign)) {
				signs.set(string, null);
				continue;
			}
			
			Sign sign = (Sign) location.getBlock().getState();
			
			if (!signs.contains(string + ".type"))
				signs.set(string + ".type", "join");
			
			if (signs.getString(string + ".type").equals("join")) {
				Arena arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));
			
				if (arena == null) {
					signs.set(string, null);
					continue;
				}
			
				arena.addSign(sign);
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
			} else if (signs.getString(string + ".type").equals("leave")) {
				leaveSigns.add(sign);
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found leave sign");
			}
		}
		updateSigns();
		
		SettingsManager.getInstance().save();
	}
	
	public void updateSigns() {
		updateLeaveSigns();
		updateJoinSigns();
	}
	
	public void updateJoinSigns() {
		for (Arena arena : ArenaManager.getInstance().getArenas())
			updateJoinSigns(arena);
	}
	
	public void updateJoinSigns(Arena arena) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : arena.getSigns()) {
			//get design
			String line1 = messages.getString("join-sign.line-1");
			String line2 = messages.getString("join-sign.line-2");
			String line3 = messages.getString("join-sign.line-3");
			String line4 = messages.getString("join-sign.line-4");
				
			sign.setLine(0, MessageManager.translate(line1
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", arena.getState().toString().toLowerCase())));
			sign.setLine(1, MessageManager.translate(line2
					.replace("%:a%", "ä")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", arena.getState().toString().toLowerCase())));
			sign.setLine(2, MessageManager.translate(line3
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", arena.getState().toString().toLowerCase())));
			sign.setLine(3, MessageManager.translate(line4
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%status%", arena.getState().toString().toLowerCase())));
			sign.update();	
		}
	}
	
	public void updateLeaveSigns() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : leaveSigns) {
			sign.setLine(0, MessageManager.translate(messages.getString("leave-sign.line-1")));
			sign.setLine(1, MessageManager.translate(messages.getString("leave-sign.line-2")));
			sign.setLine(2, MessageManager.translate(messages.getString("leave-sign.line-3")));
			sign.setLine(3, MessageManager.translate(messages.getString("leave-sign.line-4")));
		}
	}
	
	public List<Sign> getLeaveSigns() {
		return leaveSigns;
	}
	}