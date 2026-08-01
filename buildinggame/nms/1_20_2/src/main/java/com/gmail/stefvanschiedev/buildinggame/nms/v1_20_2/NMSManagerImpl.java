package com.gmail.stefvanschiedev.buildinggame.nms.v1_20_2;

import com.gmail.stefvanschiedev.buildinggame.abstraction.NMSManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundChunksBiomesPacket;
import net.minecraft.world.level.chunk.LevelChunk;
import org.bukkit.Chunk;
import org.bukkit.craftbukkit.v1_20_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An NMS manager for 1.20.2.
 *
 * @since 12.5.0
 */
public class NMSManagerImpl implements NMSManager {

    @Override
    public void refreshChunks(@NotNull Player player, @NotNull Collection<? extends Chunk> chunks) {
        var levelChunks = new ArrayList<LevelChunk>(chunks.size());

        for (Chunk chunk : chunks) {
            if (!(chunk.getWorld() instanceof CraftWorld craftWorld)) {
                throw new IllegalStateException("Unable to refresh chunk due to invalid world");
            }

            levelChunks.add(craftWorld.getHandle().getChunk(chunk.getX(), chunk.getZ()));
        }

        sendPacket(player, ClientboundChunksBiomesPacket.forChunks(levelChunks));
    }

    /**
     * Send the specified packet to the specified player.
     *
     * @param player the player to send the packet to
     * @param packet the packet to send
     * @since 12.5.0
     */
    //Restore annotation after JDK-8370800 is resolved
    private void sendPacket(@NotNull Player player, /*@NotNull*/ Packet<?> packet) {
        if (packet == null) {
            throw new IllegalArgumentException("packet must not be null");
        }

        if (!(player instanceof CraftPlayer)) {
            throw new IllegalStateException("Unable to send packet due to invalid player");
        }

        ((CraftPlayer) player).getHandle().connection.send(packet);
    }
}
