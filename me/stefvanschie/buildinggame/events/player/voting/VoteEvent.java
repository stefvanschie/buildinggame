package me.stefvanschie.buildinggame.events.player.voting;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.id.IDDecompiler;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.CustomBlock;
import me.stefvanschie.buildinggame.utils.Vote;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

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
		
		if (!player.getItemInHand().hasItemMeta()) {
			return;
		}
		
		ItemStack item = player.getItemInHand();
		
		CustomBlock two = IDDecompiler.getInstance().decompile(config.getString("voting.two-points-id"));
		CustomBlock three = IDDecompiler.getInstance().decompile(config.getString("voting.three-points-id"));
		CustomBlock four = IDDecompiler.getInstance().decompile(config.getString("voting.four-points-id"));
		CustomBlock five = IDDecompiler.getInstance().decompile(config.getString("voting.five-points-id"));
		CustomBlock six = IDDecompiler.getInstance().decompile(config.getString("voting.six-points-id"));
		CustomBlock seven = IDDecompiler.getInstance().decompile(config.getString("voting.seven-points-id"));
		CustomBlock eight = IDDecompiler.getInstance().decompile(config.getString("voting.eight-points-id"));
		
		if (item.getType() == two.getMaterial() && item.getDurability() == two.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.two-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(2, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == three.getMaterial() && item.getDurability() == three.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.three-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(3, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == four.getMaterial() && item.getDurability() == four.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.four-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(4, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == five.getMaterial() && item.getDurability() == five.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.five-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(5, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == six.getMaterial() && item.getDurability() == six.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.six-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(6, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == seven.getMaterial() && item.getDurability() == seven.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.seven-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(7, player));
			e.setCancelled(true);
			return;
		} else if (item.getType() == eight.getMaterial() && item.getDurability() == eight.getData() && item.getItemMeta().getDisplayName().equalsIgnoreCase(messages.getString("voting.eight-points-block")
				.replaceAll("&", "§"))) {
			plot.addVote(new Vote(8, player));
			e.setCancelled(true);
			return;
		} else {
			return;
		}
	}
}
