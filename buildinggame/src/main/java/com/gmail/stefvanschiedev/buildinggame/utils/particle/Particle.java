package com.gmail.stefvanschiedev.buildinggame.utils.particle;

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
	private final org.bukkit.Particle type;

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
	public Particle(Location location, org.bukkit.Particle type) {
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
	public Particle(Location location, org.bukkit.Particle type, BlockData data) {
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
		
		var amount = config.getInt("particles.amount");
		var offsetX = config.getDouble("particles.offset.x");
		var offsetY = config.getDouble("particles.offset.y");
		var offsetZ = config.getDouble("particles.offset.z");

        var world = location.getWorld();

        if (data == null) {
            world.spawnParticle(type, location, amount, offsetX, offsetY, offsetZ);
        } else {
            world.spawnParticle(type, location, amount, offsetX, offsetY, offsetZ, data);
        }
	}
}
