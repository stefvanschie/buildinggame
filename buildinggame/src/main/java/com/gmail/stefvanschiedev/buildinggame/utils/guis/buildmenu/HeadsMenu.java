package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.*;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui to get heads
 *
 * @since 2.1.0
 */
class HeadsMenu {

	/**
     * The food category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu foodMenu;

	/**
     * The devices category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu devicesMenu;


	/**
     * The miscellaneous category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu miscMenu;

	/**
     * The alphabet category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu alphabetMenu;

	/**
     * The interior category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu interiorMenu;

	/**
     * The colors category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu colorsMenu;

	/**
     * The blocks category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu blocksMenu;

	/**
     * The mobs category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu mobsMenu;

	/**
     * The games category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu gamesMenu;

	/**
     * The characters category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu charactersMenu;

	/**
     * The pokémon category
     */
	private final com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu pokemonMenu;

    /**
     * The gui
     */
    private final Gui gui;

	/**
     * Constructs a new HeadsMenu
     */
	HeadsMenu() {
		this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/headsmenu.xml"));

		foodMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/foodheadsmenu.xml");
		devicesMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/devicesheadsmenu.xml");
		miscMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/mischeadsmenu.xml");
		alphabetMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/alphabetheadsmenu.xml");
		interiorMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/interiorheadsmenu.xml");
		colorsMenu = new com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu(
		    "gui/buildmenu/heads/colorsheadsmenu.xml"
        );
		blocksMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/blocksheadsmenu.xml");
		mobsMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/mobsheadsmenu.xml");
		gamesMenu = new com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.HeadsMenu(
		    "gui/buildmenu/heads/gamesheadsmenu.xml"
        );
		charactersMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/charactersheadsmenu.xml");
		pokemonMenu = new PaginatedHeadsMenu("gui/buildmenu/heads/pokemonheadsmenu.xml");
	}

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.getItem("food").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.food"));
        gui.getItem("devices").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.devices"));
        gui.getItem("misc").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.misc"));
        gui.getItem("alphabet").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.alphabet"));
        gui.getItem("interior").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.interior"));
        gui.getItem("colors").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.colors"));
        gui.getItem("blocks").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.blocks"));
        gui.getItem("mobs").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.mobs"));
        gui.getItem("games").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.games"));
        gui.getItem("characters").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.characters"));
        gui.getItem("pokemon").setVisible(humanEntity.hasPermission("bg.buildmenu.heads.pokemon"));

        gui.show(humanEntity);
    }

    /**
     * Called whenever a user clicks on the food item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
	public void foodClick(InventoryClickEvent event) {
        foodMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the devices item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void devicesClick(InventoryClickEvent event) {
        devicesMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the misc item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void miscClick(InventoryClickEvent event) {
        miscMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the alphabet item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void alphabetClick(InventoryClickEvent event) {
        alphabetMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the interior item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void interiorClick(InventoryClickEvent event) {
        interiorMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the colors item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void colorsClick(InventoryClickEvent event) {
        colorsMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the blocks item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void blocksClick(InventoryClickEvent event) {
        blocksMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the mobs item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void mobsClick(InventoryClickEvent event) {
        mobsMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the games item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void gamesClick(InventoryClickEvent event) {
        gamesMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the characters item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void charactersClick(InventoryClickEvent event) {
        charactersMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the pokemon item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void pokemonClick(InventoryClickEvent event) {
        pokemonMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }
}