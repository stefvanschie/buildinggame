package me.stefvanschie.buildinggame.events.player.gui.teamselection;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.nbt.NBTItem;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
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
		
		if (item.getType() != Material.PAPER) {
			return;
		}
		
		GamePlayer gamePlayer = arena.getPlot(player).getGamePlayer(player);
		
		NBTItem nbtItem = new NBTItem(item);
		
		boolean succes = arena.getPlot(nbtItem.getInteger("team")).join(gamePlayer);
		if (succes) {
			plot.leave(gamePlayer);
		}
		
		player.closeInventory();
		e.setCancelled(true);
	}
}