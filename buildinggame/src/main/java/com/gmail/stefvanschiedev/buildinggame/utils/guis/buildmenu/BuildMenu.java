package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu.BaseColorBannerMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * The gui for plot settings and tools
 *
 * @since 2.1.0
 */
public class BuildMenu extends ChestGui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * YAML Configuration for the config.yml
     */
	private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();

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
     * The items inside this pane
     */
    private final GuiItem particles, floor, time, rain, flySpeed, heads, banners, biome;

	/**
     * Constructs a new build menu for the specified plot
     *
     * @param plot the plot this menu belongs to
     * @see Plot
     */
    public BuildMenu(Plot plot) {
        super(5, MessageManager.translate(MESSAGES.getString("gui.options-title")));

		particlesMenu = new ParticlesMenu();
		floorMenu = new FloorMenu(plot);
		timeMenu = new TimeMenu();
		flySpeedMenu = new SpeedMenu();
		headsMenu = new HeadsMenu();
		bannerMenu = new BaseColorBannerMenu();
		biomeMenu = new BiomeMenu(plot);

        var pane = new StaticPane(0, 0, 9, 5);

        //particles
        Material particlesMaterial = SettingsManager.getInstance().getMaterial("gui.particles.id",
            Material.BARRIER);

        var particles = new ItemStack(particlesMaterial);
        var particlesMeta = particles.getItemMeta();
        particlesMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.name")));
        particlesMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.lores")));
        particles.setItemMeta(particlesMeta);

        pane.addItem((this.particles = new GuiItem(particles, event -> {
            particlesMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 1, 1);

        //floor
        Material floorMaterial = SettingsManager.getInstance().getMaterial("gui.floor.id", Material.BARRIER);

        var floor = new ItemStack(floorMaterial);
        var floorMeta = floor.getItemMeta();
        floorMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.name")));
        floorMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.lores")));
        floor.setItemMeta(floorMeta);

        pane.addItem((this.floor = new GuiItem(floor, event -> {
            var player = (Player) event.getWhoClicked();

            int cooldown = (int) CONFIG.getDouble("gui.floor.cooldown") * 1000;

            if (cooldown > 0 && System.currentTimeMillis() - floorMenu.getLastFloorChange() < cooldown) {
                MessageManager.getInstance().send(player, ChatColor.YELLOW + "You have to wait " +
                    (((cooldown - System.currentTimeMillis()) + floorMenu.getLastFloorChange()) / 1000.0) +
                    " seconds before you can change the floor again");
                event.setCancelled(true);
                return;
            }

            if (ArenaManager.getInstance().getArena(player) == null) {
                return;
            }

            if (event.getCursor().getType() == Material.AIR) {
                floorMenu.show(player);
                floorMenu.setLastFloorChange(System.currentTimeMillis());
                event.setCancelled(true);
                return;
            }

            for (String materialString : CONFIG.getStringList("blocks.blocked")) {
                Material material = Material.matchMaterial(materialString);

                if (material == null) {
                    Logger logger = Main.getInstance().getLogger();
                    logger.warning("Invalid material found in the config.yml in 'blocks.blocked' ('" +
                        materialString + "')");
                }

                if (material == event.getCursor().getType()) {
                    MessageManager.getInstance().send(player, MESSAGES.getStringList("plots.floor.blocked"));

                    event.setCancelled(true);
                    return;
                }
            }


            if (event.getCursor().getType() == Material.WATER_BUCKET) {
                plot.getFloor().getAllBlocks().forEach(block -> block.setType(Material.WATER));

                floorMenu.setLastFloorChange(System.currentTimeMillis());

                event.setCancelled(true);
                return;
            }

            if (event.getCursor().getType() == Material.LAVA_BUCKET) {
                plot.getFloor().getAllBlocks().forEach(block -> block.setType(Material.LAVA));

                floorMenu.setLastFloorChange(System.currentTimeMillis());

                event.setCancelled(true);
                return;
            }

            if (!event.getCursor().getType().isBlock()) {
                MessageManager.getInstance().send(player, MESSAGES.getStringList("plots.floor.incorrect"));

                event.setCancelled(true);
                return;
            }

            plot.getFloor().getAllBlocks().stream()
                .filter(block -> block.getType() != event.getCursor().getType())
                .forEach(block -> block.setType(event.getCursor().getType()));

            floorMenu.setLastFloorChange(System.currentTimeMillis());

            event.setCancelled(true);
        })), 3, 1);

        //time
        Material timeMaterial = SettingsManager.getInstance().getMaterial("gui.time.id", Material.BARRIER);

        var time = new ItemStack(timeMaterial);
        var timeMeta = time.getItemMeta();
        timeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.name")));
        timeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.lores")));
        time.setItemMeta(timeMeta);

        pane.addItem((this.time = new GuiItem(time, event -> {
            timeMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 5, 1);

        //rain
        Material rainMaterial = SettingsManager.getInstance().getMaterial("gui.rain.id", Material.BARRIER);

        var rain = new ItemStack(rainMaterial);
        var rainMeta = rain.getItemMeta();
        rainMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.rain.name")));
        rainMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.rain.lores")));
        rain.setItemMeta(rainMeta);

        pane.addItem((this.rain = new GuiItem(rain, event -> {
            plot.setRaining(!plot.isRaining());

            event.setCancelled(true);
        })), 7, 1);

        //fly speed
        Material flySpeedMaterial = SettingsManager.getInstance().getMaterial("gui.fly-speed.id",
            Material.BARRIER);

        var flySpeed = new ItemStack(flySpeedMaterial);
        var flySpeedMeta = flySpeed.getItemMeta();
        flySpeedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.name")));
        flySpeedMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.lores")));
        flySpeed.setItemMeta(flySpeedMeta);

        pane.addItem((this.flySpeed = new GuiItem(flySpeed, event -> {
            flySpeedMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 1, 2);

        //heads
        Material headsMaterial = SettingsManager.getInstance().getMaterial("gui.heads.id", Material.BARRIER);

        var heads = new ItemStack(headsMaterial);
        var headsMeta = heads.getItemMeta();
        headsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.name")));
        headsMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.lores")));
        heads.setItemMeta(headsMeta);

        pane.addItem((this.heads = new GuiItem(heads, event -> {
            headsMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 3, 2);

        //banners
        Material bannersMaterial = SettingsManager.getInstance().getMaterial("gui.banners.id",
            Material.BARRIER);

        var banners = new ItemStack(bannersMaterial);
        var bannersMeta = banners.getItemMeta();
        bannersMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.banners.name")));
        bannersMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.banners.lores")));
        banners.setItemMeta(bannersMeta);

        pane.addItem((this.banners = new GuiItem(banners, event -> {
            bannerMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 5, 2);

        //biome
        Material biomeMaterial = SettingsManager.getInstance().getMaterial("gui.biome.id", Material.BARRIER);

        var biome = new ItemStack(biomeMaterial);
        var biomeMeta = biome.getItemMeta();
        biomeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.name")));
        biomeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.lores")));
        biome.setItemMeta(biomeMeta);

        pane.addItem((this.biome = new GuiItem(biome, event -> {
            biomeMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), 7, 2);

        //close menu
        var close = new ItemStack(Material.BOOK);
        var closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.close-menu.name")));
        closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.close-menu.lores")));
        close.setItemMeta(closeMeta);

        pane.addItem(new GuiItem(close, event -> {
            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
        }), 4, 3);

        addPane(pane);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(HumanEntity humanEntity) {
        particles.setVisible(humanEntity.hasPermission("bg.buildmenu.particles"));
        floor.setVisible(humanEntity.hasPermission("bg.buildmenu.floor"));
        time.setVisible(humanEntity.hasPermission("bg.buildmenu.time"));
        rain.setVisible(humanEntity.hasPermission("bg.buildmenu.rain"));
        flySpeed.setVisible(humanEntity.hasPermission("bg.buildmenu.flyspeed"));
        heads.setVisible(humanEntity.hasPermission("bg.buildmenu.heads"));
        banners.setVisible(humanEntity.hasPermission("bg.buildmenu.banners"));
        biome.setVisible(humanEntity.hasPermission("bg.buildmenu.biome"));

        super.show(humanEntity);
    }

    /**
     * Gets the floor menu
     *
     * @return the floor menu
     * @since 7.1.0
     */
    @NotNull
    @Contract(pure = true)
    public FloorMenu getFloorMenu() {
        return floorMenu;
    }
}