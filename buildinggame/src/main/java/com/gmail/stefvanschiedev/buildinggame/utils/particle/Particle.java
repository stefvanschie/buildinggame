package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

/**
 * A wrapper class for particles
 */
public class Particle {

    /**
     * The location of the particle
     */
	private final Location location;

	/**
     * The particle type
     */
	private final ParticleType type;

	/**
     * The particle data in case needed
     */
	private BlockData data;

	/**
     * Constructs a new Particle
     *
     * @param location the location this particle is located
     * @param type the type of this particle
     */
	public Particle(Location location, ParticleType type) {
		this.location = location;
		this.type = type;
	}

	/**
     * Constructs a new Particle
     *
     * @param location the location this particle is located
     * @param type the type of this particle
     * @param data the data of this particle
     */
	public Particle(Location location, ParticleType type, BlockData data) {
		this(location, type);
		this.data = data;
	}

	/**
     * Renders (spawns) the particle at the specified location
     *
     * @since 2.1.0
     */
	public void render() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		int amount = config.getInt("particles.amount");
		double offsetX = config.getDouble("particles.offset.x");
		double offsetY = config.getDouble("particles.offset.y");
		double offsetZ = config.getDouble("particles.offset.z");

        switch (type) {
            case ANGRY_VILLAGER:
                location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_ANGRY, location, amount, offsetX,
                        offsetY, offsetZ);
                break;
            case DAMAGE_INDICATOR:
                location.getWorld().spawnParticle(org.bukkit.Particle.DAMAGE_INDICATOR, location, amount, offsetX,
                        offsetY, offsetZ);
                break;
            case DRAGON_BREATH:
                location.getWorld().spawnParticle(org.bukkit.Particle.DRAGON_BREATH, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case ENCHANTMENT:
                location.getWorld().spawnParticle(org.bukkit.Particle.ENCHANTMENT_TABLE, location, amount, offsetX,
                        offsetY, offsetZ);
                break;
            case END_ROD:
                location.getWorld().spawnParticle(org.bukkit.Particle.END_ROD, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case FALLING_DUST:
                if (data != null)
                    location.getWorld().spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX,
                            offsetY, offsetZ, data);
                else
                    location.getWorld().spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX,
                            offsetY, offsetZ);
                break;
            case FLAMES:
                location.getWorld().spawnParticle(org.bukkit.Particle.FLAME, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case HAPPY_VILLAGER:
                location.getWorld().spawnParticle(org.bukkit.Particle.VILLAGER_HAPPY, location, amount, offsetX,
                        offsetY, offsetZ);
                break;
            case HEARTS:
                location.getWorld().spawnParticle(org.bukkit.Particle.HEART, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case LAVA_DRIP:
                location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_LAVA, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case MAGIC_CRIT:
                location.getWorld().spawnParticle(org.bukkit.Particle.CRIT_MAGIC, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case REDSTONE_MAGIC:
                location.getWorld().spawnParticle(org.bukkit.Particle.REDSTONE, location, amount, offsetX, offsetY,
                        offsetZ, new org.bukkit.Particle.DustOptions(Color.RED, 1f));
                break;
            case SMOKE:
                location.getWorld().spawnParticle(org.bukkit.Particle.SMOKE_NORMAL, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case SNOWBALL_POOF:
                location.getWorld().spawnParticle(org.bukkit.Particle.SNOWBALL, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case SPELL:
                location.getWorld().spawnParticle(org.bukkit.Particle.SPELL, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case SWEEP_ATTACK:
                location.getWorld().spawnParticle(org.bukkit.Particle.SWEEP_ATTACK, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case TOTEM:
                location.getWorld().spawnParticle(org.bukkit.Particle.TOTEM, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
            case WATER_DRIP:
                location.getWorld().spawnParticle(org.bukkit.Particle.DRIP_WATER, location, amount, offsetX, offsetY,
                        offsetZ);
                break;
        }
	}
}
