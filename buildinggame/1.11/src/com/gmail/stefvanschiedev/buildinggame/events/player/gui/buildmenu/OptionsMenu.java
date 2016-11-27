package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class OptionsMenu implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (e.getHand() != EquipmentSlot.HAND)
			return;
		
		if (!player.getInventory().getItemInMainHand().hasItemMeta()) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getType() != Material.EMERALD) {
			return;
		}
		if (!player.getInventory().getItemInMainHand().hasItemMeta()) {
			return;
		}
		if (!player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(MessageManager.translate(messages.getString("gui.options-emerald")))) {
			return;
		}
		
		arena.getPlot(player).getBuildMenu().open(player);
		e.setCancelled(true);
	}
}