package com.gmail.stefvanschiedev.buildinggame.events.player.voting;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class VoteEvent implements Listener {

	@EventHandler
	public void onVote(PlayerInteractEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getVotingPlot();
		
		if (!player.getInventory().getItemInMainHand().hasItemMeta()) {
			return;
		}
		
		ItemStack item = player.getInventory().getItemInMainHand();
		
		ItemStack two = IDDecompiler.getInstance().decompile(config.getString("voting.second-slot.id"));
		ItemStack three = IDDecompiler.getInstance().decompile(config.getString("voting.third-slot.id"));
		ItemStack four = IDDecompiler.getInstance().decompile(config.getString("voting.fourth-slot.id"));
		ItemStack five = IDDecompiler.getInstance().decompile(config.getString("voting.fifth-slot.id"));
		ItemStack six = IDDecompiler.getInstance().decompile(config.getString("voting.sixth-slot.id"));
		ItemStack seven = IDDecompiler.getInstance().decompile(config.getString("voting.seventh-slot.id"));
		ItemStack eight = IDDecompiler.getInstance().decompile(config.getString("voting.eighth-slot.id"));
		
		if (item.getType() == two.getType() && item.getDurability() == two.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.second-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == three.getType() && item.getDurability() == three.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.third-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.third-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == four.getType() && item.getDurability() == four.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.fourth-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.fourth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == five.getType() && item.getDurability() == five.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.fifth-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.fifth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == six.getType() && item.getDurability() == six.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.sixth-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.sixth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == seven.getType() && item.getDurability() == seven.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.seventh-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.seventh-slot.points"), player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == eight.getType() && item.getDurability() == eight.getDurability() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.eighth-slot-block")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(config.getInt("voting.eighth-slot.points"), player));
			e.setCancelled(true);
			return;
		} else {
			return;
		}
	}
}