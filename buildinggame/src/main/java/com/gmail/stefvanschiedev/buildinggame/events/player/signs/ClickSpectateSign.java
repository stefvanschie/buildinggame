package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Handles players clicking on a leave sign
 *
 * @since 2.1.0
 */
public class ClickSpectateSign implements Listener {

    /**
     * Handles players clicking on a leave sign
     *
     * @param e an event representing a player interacting
     * @see PlayerInteractEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		var player = e.getPlayer();
        var clickedBlock = e.getClickedBlock();

        if (clickedBlock == null)
		    return;

        BlockState state = clickedBlock.getState();

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !(state instanceof Sign))
			return;

        for (Map.Entry<PotentialBlockPosition, OfflinePlayer> entry :
            SignManager.getInstance().getSpectateSigns().entrySet()) {
            Block block = entry.getKey().getBlock();

            if (block == null || !block.equals(clickedBlock)) {
                continue;
            }

            OfflinePlayer offlinePlayer = entry.getValue();

            if (!offlinePlayer.isOnline()) {
                MessageManager.getInstance().send(player, ChatColor.RED + offlinePlayer.getName() + " is offline");
                return;
            }

            Arena arena = ArenaManager.getInstance().getArena(offlinePlayer.getPlayer());

            if (arena == null) {
                MessageManager.getInstance().send(player, ChatColor.RED + "This player is not in an arena");
                return;
            }

            arena.getPlot(offlinePlayer.getPlayer()).addSpectator(player, getPlayer(arena, offlinePlayer.getPlayer()));
            break;
        }
	}

    /**
     * Returns a gameplayer by the player object and the arena the player is in
     *
     * @param arena the arena to look in
     * @param player the player to look for
     * @return the gameplayer by the given name
     * @since 5.4.0
     */
    @Nullable
    @Contract(pure = true, value = "null, _ -> fail; !null, null -> null")
    private static GamePlayer getPlayer(Arena arena, Player player) {
        for (var plot : arena.getUsedPlots()) {
            for (var gamePlayer : plot.getAllGamePlayers()) {
                if (gamePlayer.getPlayer().equals(player))
                    return gamePlayer;
            }
        }

        return null;
    }
}