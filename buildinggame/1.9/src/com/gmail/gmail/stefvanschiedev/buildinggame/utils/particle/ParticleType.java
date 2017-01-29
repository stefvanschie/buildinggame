package com.gmail.stefvanschiedev.buildinggame.utils.particle;

public enum ParticleType {

	DAMAGE_INDICATOR,
	DRAGON_BREATH,
	END_ROD,
	FALLING_DUST,
	FLAMES,
	MAGIC_CRIT,
	LAVA_DRIP,
	WATER_DRIP,
	ENCHANTMENT,
	HEARTS,
	ANGRY_VILLAGER,
	HAPPY_VILLAGER,
	REDSTONE_MAGIC,
	SPELL,
	SNOWBALL_POOF,
	SMOKE,
	SWEEP_ATTACK;
	
	private Class<?> data;
	
	private ParticleType() {
		data = Void.class;
	}
	
	private ParticleType(Class<?> data) {
		this.data = data;
	}
	
	public Class<?> getData() {
		return data;
	}
}