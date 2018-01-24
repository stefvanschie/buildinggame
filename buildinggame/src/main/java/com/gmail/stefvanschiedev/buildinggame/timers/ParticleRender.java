package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;

/**
 * Renders all particles for each plot
 *
 * @since 2.1.0
 */
public class ParticleRender extends BukkitRunnable {

    /**
     * Renders all particles again
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
        ArenaManager.getInstance().getArenas().forEach(arena -> arena.getPlots().forEach(plot ->
                plot.getParticles().forEach(Particle::render)));
	}
}