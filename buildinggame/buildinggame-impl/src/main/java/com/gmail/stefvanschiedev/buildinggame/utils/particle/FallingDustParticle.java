package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A falling dust particle.
 *
 * @since 10.0.1
 */
public class FallingDustParticle extends Particle {

    /**
     * The particle data in case needed
     */
    @Nullable
    private final BlockData data;

    /**
     * Creates a falling dust particle at the specified location
     *
     * @param location the location
     * @since 10.0.1
     */
    public FallingDustParticle(@NotNull Location location) {
        this(location, null);
    }

    /**
     * Creates a falling dust particle at the specified location
     *
     * @param location the location
     * @since 10.0.1
     */
    public FallingDustParticle(@NotNull Location location, @Nullable BlockData data) {
        super(location, org.bukkit.Particle.FALLING_DUST);

        this.data = data;
    }

    @Override
    public void render() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        var amount = config.getInt("particles.amount");
        var offsetX = config.getDouble("particles.offset.x");
        var offsetY = config.getDouble("particles.offset.y");
        var offsetZ = config.getDouble("particles.offset.z");

        var world = location.getWorld();

        if (data == null) {
            world.spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX, offsetY, offsetZ);
        } else {
            world.spawnParticle(org.bukkit.Particle.FALLING_DUST, location, amount, offsetX, offsetY, offsetZ, data);
        }
    }
}
