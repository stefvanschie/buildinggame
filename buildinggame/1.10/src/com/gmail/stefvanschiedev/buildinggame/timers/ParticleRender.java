package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

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