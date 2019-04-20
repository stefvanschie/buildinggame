package com.gmail.stefvanschiedev.buildinggame.utils.itemtagtypes;

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDItemTagType implements ItemTagType<byte[], UUID> {

    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<UUID> getComplexType() {
        return UUID.class;
    }

    @NotNull
    @Override
    public byte[] toPrimitive(@NotNull UUID uuid, @NotNull ItemTagAdapterContext itemTagAdapterContext) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    @NotNull
    @Override
    public UUID fromPrimitive(@NotNull byte[] bytes, @NotNull ItemTagAdapterContext itemTagAdapterContext) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }
}
