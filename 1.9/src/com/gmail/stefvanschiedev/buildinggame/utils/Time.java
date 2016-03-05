package com.gmail.stefvanschiedev.buildinggame.utils;

public enum Time {

	MIDNIGHT,
	AM2,
	AM4,
	AM6,
	AM8,
	AM10,
	MIDDAY,
	PM2,
	PM4,
	PM6,
	PM8,
	PM10;
	
	public int decode(Time time) {
		switch (time) {
			case MIDNIGHT:
				return 18000;
			case AM2:
				return 20000;
			case AM4:
				return 22000;
			case AM6:
				return 0;
			case AM8:
				return 2000;
			case AM10:
				return 4000;
			case MIDDAY:
				return 6000;
			case PM2:
				return 8000;
			case PM4:
				return 10000;
			case PM6:
				return 12000;
			case PM8:
				return 14000;
			case PM10:
				return 16000;
		}
		return 0;
	}
	
}
