package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class LoadCooldown extends BukkitRunnable implements Listener {
	
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