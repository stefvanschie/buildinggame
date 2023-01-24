package com.gmail.stefvanschiedev.buildinggame.abstraction;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * A manager to interface with NMS.
 *
 * @since 12.1.0
 */
public interface NMSManager {

    /**
     * Refreshes the specified chunk for the specified player.
     *
     * @param player the player to refresh the chunk for
     * @param chunk the chunk to refresh
     * @since 12.1.0
     */
    void refreshChunk(@NotNull Player player, @NotNull Chunk chunk);
}
