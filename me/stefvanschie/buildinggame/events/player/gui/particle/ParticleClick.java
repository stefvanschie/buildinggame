package me.stefvanschie.buildinggame.events.player.gui.particle;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.guis.ParticlesMenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ParticleClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack currentItem = e.getCurrentItem();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		if (!inventory.getName().equals(ChatColor.GREEN + "Options menu")) {
			return;
		}
		if (currentItem.getType() != Material.RED_ROSE) {
			return;
		}
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Particles")) {
			return;
		}
		
		ParticlesMenu menu = new ParticlesMenu();
		menu.show(player);
		e.setCancelled(true);
	}
}
