package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ClickJoinSign implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		
		if (!(e.getClickedBlock().getState() instanceof Sign))
			return;
		
		Sign sign = (Sign) e.getClickedBlock().getState();

		Arena arena = null;

		for (Arena a : ArenaManager.getInstance().getArenas()) {
            if (a.getSigns().contains(sign))
                arena = a;
        }

		if (arena == null) {
		    if (SignManager.getInstance().getRandomJoinSigns().contains(sign)) {
                arena = getRandomArena();

                if (arena == null)
                    MessageManager.getInstance().send(player, ChatColor.RED + "Unable to join an arena right now");
                else if (ArenaManager.getInstance().getArena(player) != null)
                    MessageManager.getInstance().send(player, ChatColor.RED + "You're already in an arena");
                else
                    arena.join(player);
            }
        } else {
            if (ArenaManager.getInstance().getArena(player) != null)
                MessageManager.getInstance().send(player, ChatColor.RED + "You're already in an arena");
            else
                arena.join(player);
        }
	}

	private static Arena getRandomArena() {
	    Arena arena = null;

	    for (Arena a : ArenaManager.getInstance().getArenas()) {
	        if ((a.getState() != GameState.WAITING && a.getState() != GameState.STARTING) || a.isFull() || a.getPlayers() < (arena == null ? 0 : arena.getPlayers()))
	            continue;

	        arena = a;
        }

        return arena;
    }
}