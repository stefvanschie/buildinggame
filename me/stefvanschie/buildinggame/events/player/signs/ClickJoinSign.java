package me.stefvanschie.buildinggame.events.player.signs;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickJoinSign implements Listener {

	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		if (!(e.getClickedBlock().getState() instanceof Sign)) {
			return;
		}
		
		Sign sign = (Sign) e.getClickedBlock().getState();
		
		Arena arena = null;
		
		for (Arena a : ArenaManager.getInstance().getArenas()) {
			if (a.getSigns().contains(sign)) {
				arena = a;
			}
		}
		
		if (arena == null) {
			return;
		}
		
		if (ArenaManager.getInstance().getArena(player) != null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're already in an arena");
			return;
		}
		
		arena.join(player);
	}
}