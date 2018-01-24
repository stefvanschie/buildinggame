package com.gmail.stefvanschiedev.buildinggame.utils;

import org.jetbrains.annotations.Contract;

/**
 * Represents the different times a plot can be set to
 *
 * @since 2.1.0
 */
public enum Time {

    /**
     * Midnight
     *
     * @since 2.1.0
     */
	MIDNIGHT(18000),

    /**
     * 2 AM
     *
     * @since 2.1.0
     */
    AM2(20000),

    /**
     * 4 AM
     *
     * @since 2.1.0
     */
    AM4(22000),

    /**
     * 6 AM
     *
     * @since 2.1.0
     */
    AM6(0),

    /**
     * 8 AM
     *
     * @since 2.1.0
     */
    AM8(2000),

    /**
     * 10 AM
     *
     * @since 2.1.0
     */
    AM10(4000),

    /**
     * Midday
     *
     * @since 2.1.0
     */
    MIDDAY(6000),

    /**
     * 2 PM
     *
     * @since 2.1.0
     */
    PM2(8000),

    /**
     * 4 PM
     *
     * @since 2.1.0
     */
    PM4(10000),

    /**
     * 6 PM
     *
     * @since 2.1.0
     */
    PM6(12000),

    /**
     * 8 PM
     *
     * @since 2.1.0
     */
    PM8(14000),

    /**
     * 10 PM
     *
     * @since 2.1.0
     */
	PM10(16000);

    /**
     * The normal Minecraft time value
     */
	private final int value;

    /**
     * Constructs a new time with the given value
     *
     * @param value the normal time value
     */
    Time(int value) {
	    this.value = value;
    }

    /**
     * Returns the normal time value
     *
     * @return the normal time
     * @since 4.0.6
     */
	@Contract(pure = true)
    public int decode() {
		return value;
	}
}