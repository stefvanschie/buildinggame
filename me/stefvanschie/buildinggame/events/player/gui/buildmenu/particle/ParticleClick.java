package me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.id.IDDecompiler;
import me.stefvanschie.buildinggame.utils.CustomBlock;
import me.stefvanschie.buildinggame.utils.guis.buildmenu.ParticlesMenu;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ParticleClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		if (!inventory.getName().equals(messages.getString("gui.options-title")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (e.getCurrentItem() == null) {
			return;
		}
		
		ItemStack currentItem = e.getCurrentItem();
		
		CustomBlock block = IDDecompiler.getInstance().decompile(config.getString("gui.particle-id"));
		
		if (currentItem.getType() != block.getMaterial()) {
			return;
		}
		
		if (currentItem.getDurability() != block.getData()) {
			return;
		}
		
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(messages.getString("gui.particles.name")
				.replaceAll("&", "§"))) {
			return;
		}
		
		ParticlesMenu menu = new ParticlesMenu();
		menu.show(player);
		e.setCancelled(true);
	}
}
