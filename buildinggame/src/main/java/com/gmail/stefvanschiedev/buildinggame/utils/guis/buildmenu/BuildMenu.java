package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu.BaseColorBannerMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The gui for plot settings and tools
 *
 * @since 2.1.0
 */
public class BuildMenu extends Gui {

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
     * The last time the floor was changed (according to System.currentMillis())
     */
	private long floorChange;

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
        super(Main.getInstance(), 5, MessageManager.translate(MESSAGES.getString("gui.options-title")));

		particlesMenu = new ParticlesMenu();
		floorMenu = new FloorMenu(plot);
		timeMenu = new TimeMenu();
		flySpeedMenu = new SpeedMenu();
		headsMenu = new HeadsMenu();
		bannerMenu = new BaseColorBannerMenu();
		biomeMenu = new BiomeMenu(plot);

        StaticPane pane = new StaticPane(new GuiLocation(0, 0), 9, 5);

        //particles
        ItemStack particles = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.particles.id")));
        ItemMeta particlesMeta = particles.getItemMeta();
        particlesMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.name")));
        particlesMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.lores")));
        particles.setItemMeta(particlesMeta);

        pane.addItem((this.particles = new GuiItem(particles, event -> {
            particlesMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(1, 1));

        //floor
        ItemStack floor = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.floor.id")));
        ItemMeta floorMeta = floor.getItemMeta();
        floorMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.name")));
        floorMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.lores")));
        floor.setItemMeta(floorMeta);

        pane.addItem((this.floor = new GuiItem(floor, event -> {
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
                if (Material.matchMaterial(material) != event.getCursor().getType())
                    continue;

                for (String message : MessageManager.translate(MESSAGES.getStringList("plots.floor.blocked")))
                    player.sendMessage(message);

                event.setCancelled(true);
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
                if (block.getType() == event.getCursor().getType())
                    continue;

                block.setType(event.getCursor().getType());
            }

            floorChange = System.currentTimeMillis();

            event.setCancelled(true);
        })), new GuiLocation(3, 1));

        //time
        ItemStack time = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.time.id")));
        ItemMeta timeMeta = time.getItemMeta();
        timeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.name")));
        timeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.lores")));
        time.setItemMeta(timeMeta);

        pane.addItem((this.time = new GuiItem(time, event -> {
            timeMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(5, 1));

        //rain
        ItemStack rain = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.rain.id")));
        ItemMeta rainMeta = rain.getItemMeta();
        rainMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.rain.name")));
        rainMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.rain.lores")));
        rain.setItemMeta(rainMeta);

        pane.addItem((this.rain = new GuiItem(rain, event -> {
            plot.setRaining(!plot.isRaining());

            event.setCancelled(true);
        })), new GuiLocation(7, 1));

        //fly speed
        ItemStack flySpeed = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.fly-speed.id")));
        ItemMeta flySpeedMeta = flySpeed.getItemMeta();
        flySpeedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.name")));
        flySpeedMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.lores")));
        flySpeed.setItemMeta(flySpeedMeta);

        pane.addItem((this.flySpeed = new GuiItem(flySpeed, event -> {
            flySpeedMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(1, 2));

        //heads
        ItemStack heads = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.heads.id")));
        ItemMeta headsMeta = heads.getItemMeta();
        headsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.name")));
        headsMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.lores")));
        heads.setItemMeta(headsMeta);

        pane.addItem((this.heads = new GuiItem(heads, event -> {
            headsMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(3, 2));

        //banners
        ItemStack banners = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.banners.id")));
        ItemMeta bannersMeta = banners.getItemMeta();
        bannersMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.banners.name")));
        bannersMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.banners.lores")));
        banners.setItemMeta(bannersMeta);

        pane.addItem((this.banners = new GuiItem(banners, event -> {
            bannerMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(5, 2));

        //biome
        ItemStack biome = new ItemStack(Material.matchMaterial(CONFIG.getString("gui.biome.id")));
        ItemMeta biomeMeta = biome.getItemMeta();
        biomeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.name")));
        biomeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.lores")));
        biome.setItemMeta(biomeMeta);

        pane.addItem((this.biome = new GuiItem(biome, event -> {
            biomeMenu.show(event.getWhoClicked());

            event.setCancelled(true);
        })), new GuiLocation(7, 2));

        //close menu
        ItemStack close = new ItemStack(Material.BOOK);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.close-menu.name")));
        closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.close-menu.lores")));
        close.setItemMeta(closeMeta);

        pane.addItem(new GuiItem(close, event -> {
            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
        }), new GuiLocation(4, 3));

        addPane(pane);
	}

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
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
}