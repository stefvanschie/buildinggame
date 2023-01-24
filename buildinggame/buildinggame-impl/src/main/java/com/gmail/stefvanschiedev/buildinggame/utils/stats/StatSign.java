package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a sign sued to display statistics
 *
 * @since 3.1.0
 */
public class StatSign {

    /**
     * The sign this class is a wrapper for
     */
    @NotNull
	private final PotentialBlockPosition blockPos;

    /**
     * The statistic type this sign holds
     */
	private final StatType type;

    /**
     * The position of the player who should be shown
     */
	private final int number;

    /**
     * Constructs a new StatSign
     *
     * @param blockPos the potential block position at which this sign should reside
     * @param type the stat type this sign holds
     * @param number the position of the player
     */
	public StatSign(@NotNull PotentialBlockPosition blockPos, StatType type, int number) {
		this.blockPos = blockPos;
		this.type = type;
		this.number = number;
	}

    /**
     * Returns the position this sign should show
     *
     * @return the position of this sign
     */
    @Contract(pure = true)
	public int getNumber() {
		return number;
	}

    /**
     * Returns the sign this class is a wrapper for
     *
     * @return the sign
     */
	@NotNull
    @Contract(pure = true)
	public PotentialBlockPosition getBlockPosition() {
		return blockPos;
	}

    /**
     * Returns the statistic type of this sign
     *
     * @return the stat type
     */
	@NotNull
    @Contract(pure = true)
	public StatType getType() {
		return type;
	}
}