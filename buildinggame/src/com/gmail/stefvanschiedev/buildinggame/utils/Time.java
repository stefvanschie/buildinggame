package com.gmail.stefvanschiedev.buildinggame.utils;

import org.jetbrains.annotations.Contract;

public enum Time {

	MIDNIGHT(18000),
	AM2(20000),
	AM4(22000),
	AM6(0),
	AM8(2000),
	AM10(4000),
	MIDDAY(6000),
	PM2(8000),
	PM4(10000),
	PM6(12000),
	PM8(14000),
	PM10(16000);

	private final int value;

    Time(int value) {
	    this.value = value;
    }

	@Contract(pure = true)
    public int decode() {
		return value;
	}
}