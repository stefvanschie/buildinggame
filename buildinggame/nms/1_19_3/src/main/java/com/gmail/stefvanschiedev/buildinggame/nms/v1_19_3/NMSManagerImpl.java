package com.gmail.stefvanschiedev.buildinggame.nms.v1_19_3;

import com.gmail.stefvanschiedev.buildinggame.abstraction.NMSManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R2.CraftChunk;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * An NMS manager for 1.19.3.
 *
 * @since 12.1.0
 */
public class NMSManagerImpl implements NMSManager {

    @Override
    public void refreshChunk(@NotNull Player player, @NotNull Chunk chunk) {
        if (!(chunk instanceof CraftChunk)) {
            throw new IllegalStateException("Unable to refresh chunks due to invalid chunk");
        }

        World world = chunk.getWorld();

        if (!(world instanceof CraftWorld)) {
            throw new IllegalStateException("Unable to refresh chunks due to invalid world");
        }

        sendPacket(player, new ClientboundForgetLevelChunkPacket(chunk.getX(), chunk.getZ()));
        sendPacket(player, new ClientboundLevelChunkWithLightPacket(
            ((CraftChunk) chunk).getHandle(),
            ((CraftWorld) world).getHandle().getLightEngine(),
            null,
            null,
            true,
            true
        ));
    }

    /**
     * Send the specified packet to the specified player.
     *
     * @param player the player to send the packet to
     * @param packet the packet to send
     * @since 12.1.0
     */
    private void sendPacket(@NotNull Player player, @NotNull Packet<?> packet) {
        if (!(player instanceof CraftPlayer)) {
            throw new IllegalStateException("Unable to send packet due to invalid player");
        }

        ((CraftPlayer) player).getHandle().connection.send(packet);
    }
}
