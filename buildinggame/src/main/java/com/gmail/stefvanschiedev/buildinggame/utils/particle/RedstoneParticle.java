package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A redstone particle.
 *
 * @since 10.0.1
 */
public class RedstoneParticle extends Particle {

    /**
     * The color of the particle. This is only set for redstone particle.
     */
    @NotNull
    private final Color color;

    /**
     * Creates a redstone particle at the specified location
     *
     * @param location the location
     * @since 10.0.1
     */
    public RedstoneParticle(@NotNull Location location) {
        super(location, org.bukkit.Particle.REDSTONE);

        this.color = Color.fromRGB(ThreadLocalRandom.current().nextInt(1 << 24));
    }

    @Override
    public void render() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        var amount = config.getInt("particles.amount");
        var offsetX = config.getDouble("particles.offset.x");
        var offsetY = config.getDouble("particles.offset.y");
        var offsetZ = config.getDouble("particles.offset.z");

        var world = location.getWorld();

        var dustOptions = new org.bukkit.Particle.DustOptions(color, amount);

        world.spawnParticle(org.bukkit.Particle.REDSTONE, location, amount, offsetX, offsetY, offsetZ, dustOptions);
    }
}
