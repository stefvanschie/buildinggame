package me.stefvanschie.buildinggame.events.player.create;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.plots.FloorManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Floors implements Listener {

	Player player;
	Arena arena;
	Plot plot;
	Location previousLocation;
	
	public Floors(Player player, Arena arena, Plot plot) {
		this.player = player;
		this.arena = arena;
		this.plot = plot;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getPlayer() != player) {
			return;
		}
		
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		Player player = e.getPlayer();
		
		if (!e.getPlayer().getItemInHand().hasItemMeta()) {
			return;
		}
		if (e.getPlayer().getItemInHand().getType() != Material.STICK) {
			return;
		}
		if (!e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Wand")) {
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
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.world", location.getWorld().getName());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.world", previousLocation.getWorld().getName());
			} else {
				player.sendMessage(ChatColor.RED + "The world has to be the same");
			}
			//x
			if (previousLocation.getBlockX() < location.getBlockX()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.x", location.getBlockX());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.x", previousLocation.getBlockX());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.x", location.getBlockX());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.x", previousLocation.getBlockX());
			}
			//y
			if (previousLocation.getBlockY() < location.getBlockY()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.y", location.getBlockY());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.y", previousLocation.getBlockY());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.y", location.getBlockY());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.y", previousLocation.getBlockY());
			}
			//z
			if (previousLocation.getBlockZ() < location.getBlockZ()) {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.z", location.getBlockZ());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.z", previousLocation.getBlockZ());
			} else {
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.low.z", location.getBlockZ());
				arenas.set(arena.getName() + "." + plot.getID() + ".floor.high.z", previousLocation.getBlockZ());
			}
			
			previousLocation = null;
			this.player = null;
			arena = null;
			plot = null;
			SettingsManager.getInstance().save();
			
			FloorManager.getInstance().setup();
			MessageManager.getInstance().send(player, ChatColor.GREEN + "Floor set!");
			
			e.setCancelled(true);
			
			System.gc();
			
			return;
		}
	}
}