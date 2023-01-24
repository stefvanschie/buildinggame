package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.*;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui to get heads
 *
 * @since 2.1.0
 */
class HeadsMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

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
    private final ChestGui gui;

    /**
     * The items inside this pane
     */
    @SuppressWarnings("WeakerAccess")
    public GuiItem food, devices, misc, alphabet, interior, colors, blocks, mobs, games, characters, pokemon;

	/**
     * Constructs a new HeadsMenu
     */
	HeadsMenu() {
		this.gui = ChestGui.load(this, Main.getInstance().getResource("gui/buildmenu/headsmenu.xml"));

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
        food.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.food"));
        devices.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.devices"));
        misc.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.misc"));
        alphabet.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.alphabet"));
        interior.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.interior"));
        colors.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.colors"));
        blocks.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.blocks"));
        mobs.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.mobs"));
        games.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.games"));
        characters.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.characters"));
        pokemon.setVisible(humanEntity.hasPermission("bg.buildmenu.heads.pokemon"));

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