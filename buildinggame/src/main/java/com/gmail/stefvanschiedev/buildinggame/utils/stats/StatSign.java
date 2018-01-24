package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.block.Sign;
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
	private final Sign sign;

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
     * @param sign the signs this class's a wrapper for
     * @param type the stat type this sign holds
     * @param number the position of the player
     */
	public StatSign(Sign sign, StatType type, int number) {
		this.sign = sign;
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
	public Sign getSign() {
		return sign;
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