package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class StatSignBreak implements Listener {

	@EventHandler
	public static void onBlockbreak(BlockBreakEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		Block block = e.getBlock();
		
		if (!(block.getState() instanceof Sign))
			return;

		Location location = block.getLocation();

        for (String line : signs.getKeys(false)) {
            if (!signs.getString(line + ".world").equals(location.getWorld().getName()))
                continue;

            if (signs.getInt(line + ".x") != location.getX())
                continue;

            if (signs.getInt(line + ".y") != location.getY())
                continue;

            if (signs.getInt(line + ".z") != location.getZ())
                continue;

            signs.set(line, null);
            SettingsManager.getInstance().save();

            SignManager.getInstance().setup();
            break;
        }
	}
}