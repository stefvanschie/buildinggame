package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;

/**
 * Waits for other plugins to get loaded first. That way there are no incorrectly loaded worlds and other important
 * aspects.
 *
 * @since 2.1.0
 */
public class LoadCooldown extends BukkitRunnable {

    /**
     * Checks to see if all other plugins are already loaded
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		for (var plugin : Bukkit.getPluginManager().getPlugins()) {
			if (!plugin.isEnabled())
				return;
		}

		Main.getInstance().loadPlugin(false);
		this.cancel();
	}
}