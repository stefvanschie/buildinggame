package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.utils.ChunkCoordinates;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Updates signs that are in a chunk that just loaded.
 *
 * @since 10.0.3
 */
public class UpdateLoadedSigns implements Listener {

    /**
     * Handles updating signs when a chunk loads.
     *
     * @param event the fired event
     * @since 10.0.3
     */
    @EventHandler
    public void onChunkLoad(@NotNull ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();

        SignManager.getInstance().updateSigns(new ChunkCoordinates(chunk.getX(), chunk.getZ()));
    }
}
