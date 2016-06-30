package com.gmail.stefvanschiedev.buildinggame.events.player.create;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class Bounds implements Listener {

	Player player;
	Arena arena;
	Plot plot;
	Location previousLocation;
	
	public Bounds(Player player, Arena arena, Plot plot) {
		this.player = player;
		this.arena = arena;
		this.plot = plot;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (e.getPlayer() != player) {
			return;
		}
		
		Player player = e.getPlayer();
		
		if (!e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
			return;
		}
		if (e.getPlayer().getInventory().getItemInMainHand().getType() != Material.STICK) {
			return;
		}
		if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Wand")) {
			return;
		}
		if (e.getAction() != Action.LEFT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		if (previousLocation == null) {
			previousLocation = e.getClickedBlock().getLocation();
			
			MessageManager.getInstance().send(player, ChatColor.GREEN + "Now click on the other corner");
			e.setCancelled(true);
			return;
		} else {
			//second time
			
			Location location = e.getClickedBlock().getLocation();
			
			if (previousLocation.getWorld() == location.getWorld()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".high.world", location.getWorld().getName());
				arenas.set(arena.getName() + "." + plot.getID() + ".low.world", previousLocation.getWorld().getName());
			} else {
				player.sendMessage(ChatColor.RED + "The world has to be the same");
			}
			//x
			if (previousLocation.getBlockX() < location.getBlockX()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".high.x", location.getBlockX());
				arenas.set(arena.getName() + "." + plot.getID() + ".low.x", previousLocation.getBlockX());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".low.x", location.getBlockX());
				arenas.set(arena.getName() + "." + plot.getID() + ".high.x", previousLocation.getBlockX());
			}
			//y
			if (previousLocation.getBlockY() < location.getBlockY()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".high.y", location.getBlockY());
				arenas.set(arena.getName() + "." + plot.getID() + ".low.y", previousLocation.getBlockY());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".low.y", location.getBlockY());
				arenas.set(arena.getName() + "." + plot.getID() + ".high.y", previousLocation.getBlockY());
			}
			//z
			if (previousLocation.getBlockZ() < location.getBlockZ()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".high.z", location.getBlockZ());
				arenas.set(arena.getName() + "." + plot.getID() + ".low.z", previousLocation.getBlockZ());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".low.z", location.getBlockZ());
				arenas.set(arena.getName() + "." + plot.getID() + ".high.z", previousLocation.getBlockZ());
			}
			SettingsManager.getInstance().save();
			
			BoundaryManager.getInstance().setup();
			for (String message : messages.getStringList("setBounds.succes")) {
				MessageManager.getInstance().send(player, message
						.replace("%place%", plot.getID() + "")
						.replace("%arena%", arena.getName()));
			}
			
			e.setCancelled(true);
			
			System.gc();
			
			previousLocation = null;
			this.player = null;
			arena = null;
			plot = null;
			
			return;
		}
	}
}