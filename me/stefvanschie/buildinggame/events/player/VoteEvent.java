package me.stefvanschie.buildinggame.events.player;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Vote;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class VoteEvent implements Listener {

	@EventHandler
	public void onVote(PlayerInteractEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getVotingPlot();
		
		if (!player.getItemInHand().hasItemMeta()) {
			return;
		}
		
		String name = player.getItemInHand().getItemMeta().getDisplayName();
		Material type = player.getItemInHand().getType();
		
		if (type == Material.COAL_BLOCK && name.equals(messages.getString("voting.coal-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(2, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.IRON_BLOCK && name.equals(messages.getString("voting.iron-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(3, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.LAPIS_BLOCK && name.equals(messages.getString("voting.lapis-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(4, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.REDSTONE_BLOCK && name.equals(messages.getString("voting.redstone-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(5, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.GOLD_BLOCK && name.equals(messages.getString("voting.gold-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(6, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.DIAMOND_BLOCK && name.equals(messages.getString("voting.diamond-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(7, player));
			e.setCancelled(true);
			return;
		} else if (type == Material.EMERALD_BLOCK && name.equals(messages.getString("voting.emerald-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(8, player));
			e.setCancelled(true);
			return;
		} else {
			return;
		}
	}
}
