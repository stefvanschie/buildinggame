package com.gmail.stefvanschiedev.buildinggame.events.player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.PlayerInventory;

/**
 * An event that makes it so players can place blocks through spectators. This makes it easier for players to build and
 * people now can't troll others by blocking their view.
 * 
 * @since 5.0.4
 */
public class PlaceIgnoreSpectators implements Listener {

    /**
     * Handles players trying to place a block where a spectator is in the way
     *
     * @param e the event used for this algorithm
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        var player = e.getPlayer();
        var arena = ArenaManager.getInstance().getArena(player);
        Block clickedBlock = e.getClickedBlock();

        //check if the player is actually playing and the clicked entity is a player
        if (arena == null || clickedBlock == null)
            return;

        boolean nearbySpectator = false;
        var relativeBlock = clickedBlock.getRelative(e.getBlockFace());
        var blockLocation = relativeBlock.getLocation();

        //check if there's a spectator nearby
        for (GamePlayer spectator : arena.getPlot(player).getSpectators()) {
            var location = spectator.getPlayer().getLocation();

            //check if the locations are in the same world before measuring the distance
            if (!location.getWorld().equals(blockLocation.getWorld()))
                continue;

            //the value 1.8 is the result of the pythagorean theorem applied in 3 dimensional space.
            //The actual value is a little lower than 1.8 (1.771...), but overestimating the value isn't a problem in
            //this case, as the result will be the same (the player won't place the block, but we'll do it for them)
            if (location.distanceSquared(blockLocation) <= 1.8)
                nearbySpectator = true;
        }

        if (!nearbySpectator)
            return;

        PlayerInventory inventory = player.getInventory();

        //set block
        relativeBlock.setType((e.getHand() == EquipmentSlot.HAND ? inventory.getItemInMainHand() :
                inventory.getItemInOffHand()).getType());
    }
}