package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

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
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				for (Particle particle : plot.getParticles()) {
					particle.render();
				}
			}
		}
	}
}