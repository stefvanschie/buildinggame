package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import com.gmail.stefvanschiedev.buildinggame.utils.BungeeCordHandler;
import com.gmail.stefvanschiedev.buildinggame.utils.IdentifiedCallable;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class ClickJoinSign implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		if (!(e.getClickedBlock().getState() instanceof Sign))
			return;

		BlockState sign = e.getClickedBlock().getState();
		
		for (String key : signs.getKeys(false)) {
			if (!signs.getString(key + ".world").equals(sign.getWorld().getName()))
				continue;
			if (signs.getInt(key + ".x") != sign.getX())
				continue;
			if (signs.getInt(key + ".y") != sign.getY())
				continue;
			if (signs.getInt(key + ".z") != sign.getZ())
				continue;
			
			String arenaName = signs.getString(key + ".arena");
			String playerName = e.getPlayer().getName();

            BungeeCordHandler.getInstance().connect(BungeeCordHandler.Receiver.BUNGEE, e.getPlayer(), SettingsManager.getInstance().getConfig().getString("main-plugin.server-name"), new IdentifiedCallable() {
                @Override
                public void call(String response) {
                    BungeeCordHandler.getInstance().join(BungeeCordHandler.Receiver.MAIN, playerName, arenaName, null);

                    System.out.println("Callback called");
                }
            });
		}
	}
}