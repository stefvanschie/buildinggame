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
import org.jetbrains.annotations.Contract;

/**
 * Called whenever a player clicks on a join sign
 *
 * @since 2.1.0
 */
public class ClickJoinSign implements Listener {

    /**
     * Called whenever a player interacts with its environment
     *
     * @param e the event that occurred
     * @since 2.1.0
     */
    @Contract("null -> fail")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !(e.getClickedBlock().getState() instanceof Sign))
			return;

		BlockState sign = e.getClickedBlock().getState();
		
		JoinSign.getSigns().stream().filter(joinSign -> joinSign.getSign().equals(sign)).forEach(joinSign -> {
			var player = e.getPlayer();
			var playerName = player.getName();

            BungeeCordHandler.getInstance().connect(BungeeCordHandler.Receiver.BUNGEE, player,
                SettingsManager.getInstance().getConfig().getString("arena-server.name"),
                new IdentifiedCallable() {
                    @Override
                    public void call(String response) {
                        BungeeCordHandler.getInstance()
                            .join(BungeeCordHandler.Receiver.MAIN, playerName, joinSign.getArenaName(), null);
                    }
                }
            );
		});
	}
}