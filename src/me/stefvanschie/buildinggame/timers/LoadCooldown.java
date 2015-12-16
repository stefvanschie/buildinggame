package me.stefvanschie.buildinggame.timers;

import me.stefvanschie.buildinggame.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LoadCooldown extends BukkitRunnable {

	@Override
	public void run() {
		for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
			if (!plugin.isEnabled()) {
				return;
			}
		}
		Main.getInstance().loadPlugin();
		this.cancel();
	}
}