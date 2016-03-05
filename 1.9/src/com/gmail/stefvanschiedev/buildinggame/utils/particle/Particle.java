package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import org.bukkit.Location;

public class Particle {

	private Location location;
	private ParticleType type;
	
	public Particle(Location location, ParticleType type) {
		this.location = location;
		this.type = type;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public ParticleType getType() {
		return type;
	}
	
	public void render() {
		if (getType() == ParticleType.ANGRY_VILLAGER)
			location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_ANGRY, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.DAMAGE_INDICATOR)
			location.getWorld().spawnParticle(org.bukkit.Particle.DAMAGE_INDICATOR, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.DRAGON_BREATH)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRAGON_BREATH, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.ENCHANTMENT)
			location.getWorld().spawnParticle(org.bukkit.Particle.ENCHANTMENT_TABLE, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.END_ROD)
			location.getWorld().spawnParticle(org.bukkit.Particle.END_ROD, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.FLAMES)
			location.getWorld().spawnParticle(org.bukkit.Particle.FLAME, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.HAPPY_VILLAGER)
			location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_HAPPY, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.HEARTS)
			location.getWorld().spawnParticle(org.bukkit.Particle.HEART, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.LAVA_DRIP)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_LAVA, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.MAGIC_CRIT)
			location.getWorld().spawnParticle(org.bukkit.Particle.CRIT_MAGIC, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.REDSTONE_MAGIC)
			location.getWorld().spawnParticle(org.bukkit.Particle.REDSTONE, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.SMOKE)
			location.getWorld().spawnParticle(org.bukkit.Particle.SMOKE_NORMAL, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.SNOWBALL_POOF)
			location.getWorld().spawnParticle(org.bukkit.Particle.SNOWBALL, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.SPELL)
			location.getWorld().spawnParticle(org.bukkit.Particle.SPELL, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.SWEEP_ATTACK)
			location.getWorld().spawnParticle(org.bukkit.Particle.SWEEP_ATTACK, location, 100, .5, .5, .5);
		else if (getType() == ParticleType.WATER_DRIP)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_WATER, location, 100, .5, .5, .5);
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setType(ParticleType type) {
		this.type = type;
	}
}
