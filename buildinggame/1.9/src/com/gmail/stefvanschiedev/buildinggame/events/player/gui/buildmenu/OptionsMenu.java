package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.BuildMenu;

public class OptionsMenu implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
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
		
		BuildMenu menu = new BuildMenu();
		menu.show(player);
		e.setCancelled(true);
	}
}