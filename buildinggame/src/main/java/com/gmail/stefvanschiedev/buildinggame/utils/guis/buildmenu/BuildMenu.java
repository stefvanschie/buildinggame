package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu.BaseColorBannerMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui for plot settings and tools
 *
 * @since 2.1.0
 */
public class BuildMenu {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * YAML Configuration for the config.yml
     */
	private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();

    /**
     * The plot this menu belongs to
     */
	private final Plot plot;

	/**
     * The particles menu
     */
	private final ParticlesMenu particlesMenu;

	/**
     * The floor menu
     */
	private final FloorMenu floorMenu;

	/**
     * The time menu
     */
	private final TimeMenu timeMenu;

	/**
     * The fly speed menu
     */
	private final SpeedMenu flySpeedMenu;

	/**
     * The heads menu
     */
	private final HeadsMenu headsMenu;

    /**
     * The banner menu
     */
    private final BaseColorBannerMenu bannerMenu;

    /**
     * The biome menu
     */
    private final BiomeMenu biomeMenu;

    /**
     * The last time the floor was changed (according to System.currentMillis())
     */
	private long floorChange;

    /**
     * The gui
     */
    private final Gui gui;

	/**
     * Constructs a new build menu for the specified plot
     *
     * @param plot the plot this menu belongs to
     * @see Plot
     */
    public BuildMenu(Plot plot) {
        this.plot = plot;
        this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/buildmenu.xml"));

		particlesMenu = new ParticlesMenu();
		floorMenu = new FloorMenu(plot);
		timeMenu = new TimeMenu();
		flySpeedMenu = new SpeedMenu();
		headsMenu = new HeadsMenu();
		bannerMenu = new BaseColorBannerMenu();
		biomeMenu = new BiomeMenu(plot);
	}

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.getItem("particles").setVisible(humanEntity.hasPermission("bg.buildmenu.particles"));
        gui.getItem("floor").setVisible(humanEntity.hasPermission("bg.buildmenu.floor"));
        gui.getItem("time").setVisible(humanEntity.hasPermission("bg.buildmenu.time"));
        gui.getItem("rain").setVisible(humanEntity.hasPermission("bg.buildmenu.rain"));
        gui.getItem("fly-speed").setVisible(humanEntity.hasPermission("bg.buildmenu.flyspeed"));
        gui.getItem("heads").setVisible(humanEntity.hasPermission("bg.buildmenu.heads"));
        gui.getItem("banners").setVisible(humanEntity.hasPermission("bg.buildmenu.banners"));
        gui.getItem("biome").setVisible(humanEntity.hasPermission("bg.buildmenu.biome"));

        gui.show(humanEntity);
    }

    /**
     * Called whenever a user clicks on the particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
	public void particlesClick(InventoryClickEvent event) {
        particlesMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the floor item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void floorClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        int cooldown = (int) CONFIG.getDouble("gui.floor.cooldown") * 1000;

        if (cooldown > 0 && System.currentTimeMillis() - floorChange < cooldown) {
            MessageManager.getInstance().send(player, ChatColor.YELLOW + "You have to wait " +
                (((cooldown - System.currentTimeMillis()) + floorChange) / 1000.0) +
                " seconds before you can change the floor again");
            event.setCancelled(true);
        }

        if (ArenaManager.getInstance().getArena(player) == null)
            return;

        if (event.getCursor().getType() == Material.AIR) {
            floorMenu.show(player);
            floorChange = System.currentTimeMillis();
            event.setCancelled(true);
            return;
        }

        for (String material : CONFIG.getStringList("blocks.blocked")) {
            if (IDDecompiler.getInstance().matches(material, event.getCursor())) {
                for (String message :
                    MessageManager.translate(MESSAGES.getStringList("plots.floor.blocked")))
                    player.sendMessage(message);

                event.setCancelled(true);
            }
        }


        if (event.getCursor().getType() == Material.WATER_BUCKET) {
            for (Block block : plot.getFloor().getAllBlocks())
                block.setType(Material.WATER);

            floorChange = System.currentTimeMillis();

            event.setCancelled(true);
        }

        if (event.getCursor().getType() == Material.LAVA_BUCKET) {
            for (Block block : plot.getFloor().getAllBlocks())
                block.setType(Material.LAVA);

            floorChange = System.currentTimeMillis();

            event.setCancelled(true);
        }

        if (!event.getCursor().getType().isBlock()) {
            for (String message :
                MessageManager.translate(MESSAGES.getStringList("plots.floor.incorrect")))
                player.sendMessage(message);

            event.setCancelled(true);
        }

        for (Block block : plot.getFloor().getAllBlocks()) {
            //noinspection deprecation
            if (block.getType() == event.getCursor().getType() &&
                block.getData() == event.getCursor().getData().getData())
                continue;

            block.setType(event.getCursor().getType());
            //noinspection deprecation
            block.setData(event.getCursor().getData().getData());
        }

        floorChange = System.currentTimeMillis();

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the time item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void timeClick(InventoryClickEvent event) {
        timeMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the rain item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void rainClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (ArenaManager.getInstance().getArena(player) == null)
            return;

        Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
        plot.setRaining(!plot.isRaining());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the fly speed item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void flySpeedClick(InventoryClickEvent event) {
        flySpeedMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the heads item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void headsClick(InventoryClickEvent event) {
        headsMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the banners item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void bannersClick(InventoryClickEvent event) {
        bannerMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the biome item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void biomeClick(InventoryClickEvent event) {
        biomeMenu.show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the close menu item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void closeMenuClick(InventoryClickEvent event) {
        event.getWhoClicked().closeInventory();

        event.setCancelled(true);
    }
}