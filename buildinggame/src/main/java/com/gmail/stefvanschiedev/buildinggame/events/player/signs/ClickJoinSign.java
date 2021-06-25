package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Handles players clicking on join signs
 *
 * @since 2.1.0
 */
public class ClickJoinSign implements Listener {

    /**
     * Handles players clicking on join signs
     *
     * @param e an event representing a player interacting
     * @see PlayerInteractEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	    if (e.getHand() != EquipmentSlot.HAND) {
	        return;
        }

		var player = e.getPlayer();
        var clickedBlock = e.getClickedBlock();

        if (clickedBlock == null)
		    return;

        BlockState state = clickedBlock.getState();

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !(state instanceof Sign))
			return;

		Arena arena = null;

		for (Arena a : ArenaManager.getInstance().getArenas()) {
            for (PotentialBlockPosition blockPos : a.getSigns()) {
                Block block = blockPos.getBlock();

                if (block != null && block.equals(clickedBlock)) {
                    arena = a;
                    break;
                }
            }
        }

        var playerArena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
		    for (PotentialBlockPosition blockPos : SignManager.getInstance().getRandomJoinSigns()) {
                Block block = blockPos.getBlock();

                if (block == null || !block.equals(clickedBlock)) {
		            continue;
                }

                arena = getRandomArena();

                if (arena == null)
                    MessageManager.getInstance().send(player,
                            ChatColor.RED + "Unable to join an arena right now");
                else if (playerArena != null)
                    MessageManager.getInstance().send(player, ChatColor.RED + "You're already in an arena");
                else
                    arena.join(player);
            }
        } else {
            if (playerArena != null)
                MessageManager.getInstance().send(player, ChatColor.RED + "You're already in an arena");
            else
                arena.join(player);
        }

        e.setCancelled(true);
	}

	/**
     * Returns a random arena which can be joined
     *
     * @return an open arena
     * @see Arena
     * @since 4.0.6
     */
	@Nullable
    @Contract(pure = true)
	private static Arena getRandomArena() {
	    Arena arena = null;

	    for (Arena a : ArenaManager.getInstance().getArenas()) {
	        if (!a.canJoin() || a.getPlayers() < (arena == null ? 0 : arena.getPlayers())) {
                continue;
            }

	        arena = a;
        }

        return arena;
    }
}