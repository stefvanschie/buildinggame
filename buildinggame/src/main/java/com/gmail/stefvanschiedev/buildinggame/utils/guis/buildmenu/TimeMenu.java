package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Time;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
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
     * The gui
     */
    private final Gui gui;

	/**
     * Constructs a new TimeMenu
     */
	TimeMenu() {
		this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/timemenu.xml"));
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
	public void timeClick(InventoryClickEvent event, Time time) {
        Player player = (Player) event.getWhoClicked();
        Arena arena = ArenaManager.getInstance().getArena(player);

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
        Player player = (Player) event.getWhoClicked();

        ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().show(player);

        event.setCancelled(true);
    }
}