package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ClickLeaveSign implements Listener {

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
		
		if (!SignManager.getInstance().getLeaveSigns().contains(sign))
			return;

		Arena arena = ArenaManager.getInstance().getArena(player);

		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return;
		}
		
		arena.leave(player);
	}
}