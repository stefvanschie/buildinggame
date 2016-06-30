package com.gmail.stefvanschiedev.buildinggame.events.player.gui.teamselection;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class TeamClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		Plot plot = arena.getPlot(player);
		
		if (!inventory.getName().equals(messages.getString("team-gui.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		NBTItem nbtItem = new NBTItem(item);
		
		String team = nbtItem.getInteger("team") + "";
		
		if (!IDDecompiler.getInstance().matches(config.getString("team-selection.team." + team + ".id"), item))
			return;
		
		GamePlayer gamePlayer = arena.getPlot(player).getGamePlayer(player);
		
		boolean succes = arena.getPlot(Integer.parseInt(team)).join(gamePlayer);
		if (succes) {
			plot.leave(gamePlayer);
		}
		
		player.closeInventory();
		e.setCancelled(true);
	}
}