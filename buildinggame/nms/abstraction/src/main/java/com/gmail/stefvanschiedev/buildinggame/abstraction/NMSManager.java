package com.gmail.stefvanschiedev.buildinggame.abstraction;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * A manager to interface with NMS.
 *
 * @since 12.1.0
 */
public interface NMSManager {

    /**
     * Refreshes the specified chunks for the specified player.
     *
     * @param player the player to refresh the chunk for
     * @param chunks the chunks to refresh
     * @since 14.2.0
     */
    void refreshChunks(@NotNull Player player, @NotNull Collection<? extends Chunk> chunks);
}
