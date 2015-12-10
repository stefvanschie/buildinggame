package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

public class SignManager {

	private SignManager() {}
	
	private static SignManager instance = new SignManager();
	
	public static SignManager getInstance() {
		return instance;
	}
	
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
			
			Arena arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));
			
			if (arena == null) {
				signs.set(string, null);
				continue;
			}
			
			arena.addSign(sign);
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
			}
		}
		updateJoinSigns();
	}
	
	public void updateJoinSigns() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Sign sign : arena.getSigns()) {
				//get design
				String line1 = messages.getString("join-sign.line-1");
				String line2 = messages.getString("join-sign.line-2");
				String line3 = messages.getString("join-sign.line-3");
				String line4 = messages.getString("join-sign.line-4");
				
				sign.setLine(0, line1
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replace("%arena%", arena.getName())
						.replace("%players%", arena.getPlayers() + "")
						.replace("%max_players%", arena.getMaxPlayers() + "")
						.replaceAll("&", "§"));
				sign.setLine(1, line2
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replace("%arena%", arena.getName())
						.replace("%players%", arena.getPlayers() + "")
						.replace("%max_players%", arena.getMaxPlayers() + "")
						.replaceAll("&", "§"));
				sign.setLine(2, line3
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replace("%arena%", arena.getName())
						.replace("%players%", arena.getPlayers() + "")
						.replace("%max_players%", arena.getMaxPlayers() + "")
						.replaceAll("&", "§"));
				sign.setLine(3, line4
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replace("%arena%", arena.getName())
						.replace("%players%", arena.getPlayers() + "")
						.replace("%max_players%", arena.getMaxPlayers() + "")
						.replaceAll("&", "§"));
				sign.update();
			}
		}
	}
	
	public void updateJoinSigns(Arena arena) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : arena.getSigns()) {
			//get design
			String line1 = messages.getString("join-sign.line-1");
			String line2 = messages.getString("join-sign.line-2");
			String line3 = messages.getString("join-sign.line-3");
			String line4 = messages.getString("join-sign.line-4");
				
			sign.setLine(0, line1
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replaceAll("&", "§"));
			sign.setLine(1, line2
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replaceAll("&", "§"));
			sign.setLine(2, line3
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replaceAll("&", "§"));
			sign.setLine(3, line4
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replaceAll("&", "§"));
			sign.update();	
		}
	}
}