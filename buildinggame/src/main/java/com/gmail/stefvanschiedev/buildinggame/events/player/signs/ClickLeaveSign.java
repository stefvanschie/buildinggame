package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import org.bukkit.ChatColor;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.inventory.EquipmentSlot;

/**
 * Handles players clicking on a leave sign
 *
 * @since 2.1.0
 */
public class ClickLeaveSign implements Listener {

    /**
     * Handles players clicking on a leave sign
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
		
		var sign = (Sign) state;
		
		if (!SignManager.getInstance().getLeaveSigns().contains(sign))
			return;

		var arena = ArenaManager.getInstance().getArena(player);

		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return;
		}
		
		arena.leave(player);
	}
}