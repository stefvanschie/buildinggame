package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui for changing the time
 *
 * @since 2.1.0
 */
class TimeMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The gui
     */
    private final ChestGui gui;

	/**
     * Constructs a new TimeMenu
     */
	TimeMenu() {
		this.gui = ChestGui.load(this, Main.getInstance().getResource("gui/buildmenu/timemenu.xml"));

        var title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
            gui.setTitle(MessageManager.translate(MESSAGES.getString(ChatColor.stripColor(title.substring(1)))));

        gui.getItems().forEach(item -> {
            var itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            var displayName = itemMeta.getDisplayName();

            if (!displayName.isEmpty() && displayName.charAt(0) == '*')
                itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString(displayName.substring(1))));

            String lore = itemMeta.getLore().get(0);

            if (!lore.isEmpty() && lore.charAt(0) == '*')
                itemMeta.setLore(MessageManager.translate(MESSAGES.getStringList(lore.substring(1))));

            item.getItem().setItemMeta(itemMeta);
        });
	}

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.show(humanEntity);
    }

    /**
     * Called whenever a user clicks on a time item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
	public void timeClick(InventoryClickEvent event, long time) {
        var player = (Player) event.getWhoClicked();
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
            return;

        arena.getPlot(player).setTime(time);

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the back item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void backClick(InventoryClickEvent event) {
        var player = (Player) event.getWhoClicked();

        ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().show(player);

        event.setCancelled(true);
    }
}