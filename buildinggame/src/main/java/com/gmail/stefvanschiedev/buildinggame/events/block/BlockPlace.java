package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * Handles players placing blocks
 *
 * @since 2.1.0
 */
public class BlockPlace implements Listener {

    /**
     * Handles players placing blocks
     *
     * @param e an event indicating that a block is broken
     * @see BlockPlaceEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
        Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null)
			return;

		Plot plot = arena.getPlot(player);
		
		if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't build");
			e.setCancelled(true);
			return;
		}
		
		if (arena.getState() != GameState.BUILDING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can not build right now");
			e.setCancelled(true);
			return;
		}

        Block block = e.getBlock();

        if (!plot.getBoundary().isInside(block.getLocation())) {
			MessageManager.getInstance().send(player,
                    SettingsManager.getInstance().getMessages().getStringList("in-game.build-out-bounds"));
			e.setCancelled(true);
			return;
		}
		
		for (String material : SettingsManager.getInstance().getConfig().getStringList("blocks.blocked")) {
			if (Material.matchMaterial(material) != block.getType())
			    continue;

            e.setCancelled(true);
            break;
		}
	}
}