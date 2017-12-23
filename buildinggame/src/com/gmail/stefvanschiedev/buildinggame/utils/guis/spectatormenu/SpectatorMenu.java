package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;

/**
 * Represents a gui to change the fly speed for spectators
 *
 * @since 3.0.0
 */
public class SpectatorMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new SpectatorMenu
     */
	public SpectatorMenu() {
		super(null, 36, MessageManager.translate(MESSAGES.getString("spectator-gui.title")),
                1);
		
		ItemStack speed = new ItemStack(Material.FEATHER);
		ItemMeta speedMeta = speed.getItemMeta();
		speedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.name")));
		List<String> speedLores = MessageManager.translate(MESSAGES
                .getStringList("spectator-gui.fly-speed.lores"));
		speedMeta.setLore(speedLores);
		speed.setItemMeta(speedMeta);
		
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.close-menu.name")));
		List<String> closeLores = MessageManager.translate(MESSAGES
                .getStringList("spectator-gui.close-menu.lores"));
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		setItem(speed, event -> {
            new SpeedMenu().open((Player) event.getWhoClicked());

            event.setCancelled(true);
		}, 13);
		
		setItem(close, event -> {
            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
		}, 22);
	}
}