package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a sign from which you can spectate a player.
 *
 * @since 10.0.3
 */
public class SpectateSign {

    /**
     * The position of this sign
     */
    @NotNull
    private final PotentialBlockPosition position;

    /**
     * The offline player to spectate via this sign
     */
    @NotNull
    private final OfflinePlayer offlinePlayer;

    /**
     * Creates a new spectate sign at the given position to spectate the given player.
     *
     * @param position the position of this sign
     * @param offlinePlayer the player to spectate via this signs
     * @since 10.0.3
     */
    public SpectateSign(@NotNull PotentialBlockPosition position, @NotNull OfflinePlayer offlinePlayer) {
        this.position = position;
        this.offlinePlayer = offlinePlayer;
    }

    /**
     * Gets the position of this sign.
     *
     * @return the potential block position
     * @since 10.0.3
     */
    @NotNull
    @Contract(pure = true)
    public PotentialBlockPosition getPotentialBlockPosition() {
        return position;
    }

    /**
     * Gets the offline player of this sign.
     *
     * @return the offline player
     * @since 10.0.3
     */
    @NotNull
    @Contract(pure = true)
    public OfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }
}
