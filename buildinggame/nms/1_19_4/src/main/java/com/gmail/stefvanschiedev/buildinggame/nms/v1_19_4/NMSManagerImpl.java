package com.gmail.stefvanschiedev.buildinggame.nms.v1_19_4;

import com.gmail.stefvanschiedev.buildinggame.abstraction.NMSManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R3.CraftChunk;
import org.bukkit.craftbukkit.v1_19_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * An NMS manager for 1.19.4.
 *
 * @since 12.2.0
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

        int x = chunk.getX();
        int z = chunk.getZ();

        sendPacket(player, new ClientboundForgetLevelChunkPacket(x, z));

        ServerLevel serverLevel = ((CraftWorld) world).getHandle();

        //noinspection deprecation
        sendPacket(player, new ClientboundLevelChunkWithLightPacket(
            serverLevel.getChunk(x, z),
            serverLevel.getLightEngine(),
            null,
            null,
            true
        ));
    }

    /**
     * Send the specified packet to the specified player.
     *
     * @param player the player to send the packet to
     * @param packet the packet to send
     * @since 12.2.0
     */
    private void sendPacket(@NotNull Player player, @NotNull Packet<?> packet) {
        if (!(player instanceof CraftPlayer)) {
            throw new IllegalStateException("Unable to send packet due to invalid player");
        }

        ((CraftPlayer) player).getHandle().connection.send(packet);
    }
}
