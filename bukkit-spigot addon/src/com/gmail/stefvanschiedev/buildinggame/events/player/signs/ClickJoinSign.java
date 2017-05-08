package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import com.gmail.stefvanschiedev.buildinggame.utils.JoinSign;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.IdentifiedCallable;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class ClickJoinSign implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		if (!(e.getClickedBlock().getState() instanceof Sign))
			return;

		BlockState sign = e.getClickedBlock().getState();
		
		for (JoinSign joinSign : JoinSign.getSigns()) {
			if (!joinSign.getSign().equals(sign))
			    continue;

			Player player = e.getPlayer();
			String playerName = player.getName();

            BungeeCordHandler.getInstance().connect(BungeeCordHandler.Receiver.BUNGEE, player, SettingsManager.getInstance().getConfig().getString("main-plugin.server-name"), new IdentifiedCallable() {
                @Override
                public void call(String response) {
                    BungeeCordHandler.getInstance().join(BungeeCordHandler.Receiver.MAIN, playerName, joinSign.getArenaName(), null);
                }
            });
		}
	}
}