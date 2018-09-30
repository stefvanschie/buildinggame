package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

/**
 * Handles players breaking statistic signs
 *
 * @since 5.4.0
 */
public class SignBreak implements Listener {

    /**
     * Handles players breaking statistic signs
     *
     * @param e an event indicating that a block is broken
     * @see BlockBreakEvent
     * @since 5.4.0
     */
	@EventHandler
	public static void onBlockBreak(BlockBreakEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		var block = e.getBlock();
		
		if (!(block.getState() instanceof Sign))
			return;

		var location = block.getLocation();

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