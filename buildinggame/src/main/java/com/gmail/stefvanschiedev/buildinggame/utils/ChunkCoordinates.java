package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.Objects;

/**
 * A data class containing chunk coordinates.
 *
 * @since 10.0.3
 */
public class ChunkCoordinates {

    /**
     * The coordinates of the chunk
     */
    private final int x, z;

    /**
     * Creates a new pair of chunk coordinates.
     *
     * @param x the x coordinate of the chunk
     * @param z the z coordinate of the chunk
     * @since 10.0.3
     */
    public ChunkCoordinates(int x, int z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        ChunkCoordinates coordinates = (ChunkCoordinates) object;

        return x == coordinates.x && z == coordinates.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}
