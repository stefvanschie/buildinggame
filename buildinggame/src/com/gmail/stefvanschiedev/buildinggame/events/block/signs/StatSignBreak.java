package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatSign;

public class StatSignBreak implements Listener {

	@EventHandler
	public void onBlockbreak(BlockBreakEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		Block block = e.getBlock();
		
		if (!(block.getState() instanceof Sign))
			return;
		
		for (StatSign s : SignManager.getInstance().getStatSigns()) {
			Sign sign = s.getSign();
			
			for (String line : signs.getKeys(false)) {
				if (!signs.getString(line + ".world").equals(sign.getWorld().getName()))
					continue;
					
				if (signs.getInt(line + ".x") != sign.getX())
					continue;
					
				if (signs.getInt(line + ".y") != sign.getY())
					continue;
					
				if (signs.getInt(line + ".z") != sign.getZ())
					continue;
					
				signs.set(line, null);
				SettingsManager.getInstance().save();
					
				SignManager.getInstance().setup();
				break;
			}
		}
	}
}