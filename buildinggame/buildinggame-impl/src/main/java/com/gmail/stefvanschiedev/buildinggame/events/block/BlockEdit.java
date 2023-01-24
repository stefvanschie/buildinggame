package com.gmail.stefvanschiedev.buildinggame.events.block;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * Handles players editing blocks
 *
 * @since 2.1.0
 */
public class BlockEdit implements Listener {

    /**
     * Handles behavioral code for when a player edits a block.
     *
     * @param player the player that edited a block
     * @param e the event that was called because of this edit
     * @param <T> a type to ensure the event passed is both cancellable and a block event
     * @since 7.0.1
     */
    private <T extends BlockEvent & Cancellable> void blockEdit(@NotNull Player player, @NotNull T e) {
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
            return;

        var plot = arena.getPlot(player);

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

        var block = e.getBlock();

        if (!plot.getBoundary().isInside(block.getLocation())) {
            MessageManager.getInstance().send(player,
                SettingsManager.getInstance().getMessages().getStringList("in-game.build-out-bounds"));
            e.setCancelled(true);
        }
    }

    /**
     * Handles players placing blocks
     *
     * @param e an event indicating that a block is broken
     * @see BlockPlaceEvent
     * @since 2.1.0
     */
    @EventHandler
    public void onBlockPlace(@NotNull BlockPlaceEvent e) {
        blockEdit(e.getPlayer(), e);

        for (String materialString : SettingsManager.getInstance().getConfig().getStringList("blocks.blocked")) {
            Material material = Material.matchMaterial(materialString);

            if (material == null) {
                Logger logger = Main.getInstance().getLogger();
                logger.warning("Invalid material found in the config.yml in 'blocks.blocked' ('" +
                    materialString + "')");
            }

            if (material == e.getBlock().getType()) {
                e.setCancelled(true);
                break;
            }
        }
    }

    /**
     * Handles players breaking blocks
     *
     * @param e an event indicating that a block is broken
     * @see BlockBreakEvent
     * @since 2.1.0
     */
    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent e) {
        blockEdit(e.getPlayer(), e);
    }
}
