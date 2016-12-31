package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.material.MaterialData;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class Particle {

	private Location location;
	private ParticleType type;
	private MaterialData data;
	
	public Particle(Location location, ParticleType type) {
		this.location = location;
		this.type = type;
	}
	
	public Particle(Location location, ParticleType type, MaterialData data) {
		this(location, type);
		this.data = data;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public ParticleType getType() {
		return type;
	}
	
	public void render() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		int amount = config.getInt("particles.amount");
		double offsetX = config.getDouble("particles.offset.x");
		double offsetY = config.getDouble("particles.offset.y");
		double offsetZ = config.getDouble("particles.offset.z");
		
		if (getType() == ParticleType.ANGRY_VILLAGER)
			location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_ANGRY, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.DAMAGE_INDICATOR)
			location.getWorld().spawnParticle(org.bukkit.Particle.DAMAGE_INDICATOR, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.DRAGON_BREATH)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRAGON_BREATH, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.ENCHANTMENT)
			location.getWorld().spawnParticle(org.bukkit.Particle.ENCHANTMENT_TABLE, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.END_ROD)
			location.getWorld().spawnParticle(org.bukkit.Particle.END_ROD, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.FALLING_DUST) {
			if (data != null)
				location.getWorld().spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX, offsetY, offsetZ, data);
			else
				location.getWorld().spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX, offsetY, offsetZ);
		} else if (getType() == ParticleType.FLAMES)
			location.getWorld().spawnParticle(org.bukkit.Particle.FLAME, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.HAPPY_VILLAGER)
			location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_HAPPY, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.HEARTS)
			location.getWorld().spawnParticle(org.bukkit.Particle.HEART, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.LAVA_DRIP)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_LAVA, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.MAGIC_CRIT)
			location.getWorld().spawnParticle(org.bukkit.Particle.CRIT_MAGIC, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.REDSTONE_MAGIC)
			location.getWorld().spawnParticle(org.bukkit.Particle.REDSTONE, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.SMOKE)
			location.getWorld().spawnParticle(org.bukkit.Particle.SMOKE_NORMAL, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.SNOWBALL_POOF)
			location.getWorld().spawnParticle(org.bukkit.Particle.SNOWBALL, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.SPELL)
			location.getWorld().spawnParticle(org.bukkit.Particle.SPELL, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.SWEEP_ATTACK)
			location.getWorld().spawnParticle(org.bukkit.Particle.SWEEP_ATTACK, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.TOTEM)
			location.getWorld().spawnParticle(org.bukkit.Particle.TOTEM, location, amount, offsetX, offsetY, offsetZ);
		else if (getType() == ParticleType.WATER_DRIP)
			location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_WATER, location, amount, offsetX, offsetY, offsetZ);
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setType(ParticleType type) {
		this.type = type;
	}
}
