package me.stefvanschie.buildinggame.events.player.signs;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickLeaveSign implements Listener {

	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		if (!(e.getClickedBlock().getState() instanceof Sign)) {
			return;
		}
		
		Sign sign = (Sign) e.getClickedBlock().getState();
		
		if (!sign.getLine(0).equals(messages.getString("leave-sign.line-1")
				.replaceAll("&", "§"))) {
			return;
		}
		if (!sign.getLine(1).equals(messages.getString("leave-sign.line-2")
				.replaceAll("&", "§"))) {
			return;
		}
		if (!sign.getLine(2).equals(messages.getString("leave-sign.line-3")
				.replaceAll("&", "§"))) {
			return;
		}
		if (!sign.getLine(3).equals(messages.getString("leave-sign.line-4")
				.replaceAll("&", "§"))) {
			return;
		}

		Arena arena = ArenaManager.getInstance().getArena(player);

		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return;
		}
		
		arena.leave(player);
	}
}