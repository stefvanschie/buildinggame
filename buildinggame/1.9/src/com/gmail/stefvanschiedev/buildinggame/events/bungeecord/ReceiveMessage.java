package com.gmail.stefvanschiedev.buildinggame.events.bungeecord;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

import fr.rhaz.socketapi.Bukkit.BukkitSocketJSONEvent;

public class ReceiveMessage implements Listener {

	@EventHandler
	public void onBukkitSocketJSON(BukkitSocketJSONEvent e) {
		if (!e.getChannel().equals("BuildingGame"))
			return;
		
		//encode data
		String rawData = e.getData();
		
		if (rawData.startsWith("write:")) {
			//someone has executed a command
			rawData = rawData.replace("write:", "").trim();
			
			String[] data = rawData.split(", ");
			YamlConfiguration file;
			
			if (data[0].equals("arenas.yml"))
				file = SettingsManager.getInstance().getArenas();
			else if (data[0].equals("config.yml"))
				file = SettingsManager.getInstance().getConfig();
			else if (data[0].equals("messages.yml"))
				file = SettingsManager.getInstance().getMessages();
			else if (data[0].equals("signs.yml"))
				file = SettingsManager.getInstance().getSigns();
			else
				return;
			
			Object value;
			if (data[2].startsWith("(int)"))
					value = Integer.parseInt(data[2].replace("(int)", "").trim());
			else
				value = data[2];
			
			file.set(data[1], value);
		} else if (rawData.startsWith("save"))
			SettingsManager.getInstance().save();
		else if (rawData.startsWith("join:")) {
			rawData = rawData.replace("join:", "");
			
			String[] data = rawData.split(", ");
			
			final Player player = Bukkit.getPlayer(data[0].trim());
			final Arena arena = ArenaManager.getInstance().getArena(data[1].trim());
			
			if (player == null) {
				System.out.println("Couldn't find player");
				return;
			} else if (arena == null) {
				System.out.println("Couldn't find arena");
				return;
			}
			
			BukkitRunnable task = new BukkitRunnable() {
				@Override
				public void run() {
					arena.join(player);
				}
			};
			
			task.runTask(Main.getInstance());
		}
		
		System.out.println("Received command");
	}
}