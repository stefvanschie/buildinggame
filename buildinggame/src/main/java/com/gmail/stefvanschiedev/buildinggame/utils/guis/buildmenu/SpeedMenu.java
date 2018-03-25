package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui for changing the fly speed
 *
 * @since 2.1.0
 */
class SpeedMenu {

    /**
     * The gui
     */
    private final Gui gui;

	/**
     * Constructs a new SpeedMenu
     */
	SpeedMenu() {
		this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/speedmenu.xml"));
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
     * Called whenever a user clicks on a speed item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
	public void speedClick(InventoryClickEvent event, float flySpeed) {
        ((Player) event.getWhoClicked()).setFlySpeed(flySpeed);

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