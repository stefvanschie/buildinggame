package me.stefvanschie.buildinggame.timers;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.particle.Particle;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.scheduler.BukkitRunnable;

public class ParticleRender extends BukkitRunnable {

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