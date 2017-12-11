package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu.BaseColorBannerMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

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
     * The las time the floor was changed (according to System.currentMillis())
     */
	private long floorChange;

	/**
     * Constructs a new build menu for the specified plot
     *
     * @param plot the plot this menu belongs to
     * @see Plot
     */
    public BuildMenu(Plot plot) {
		super(null, 45, MessageManager.translate(MESSAGES.getString("gui.options-title")), 1);

		particlesMenu = new ParticlesMenu();
		floorMenu = new FloorMenu(plot);
		timeMenu = new TimeMenu();
		flySpeedMenu = new SpeedMenu();
		headsMenu = new HeadsMenu();
		bannerMenu = new BaseColorBannerMenu();
		biomeMenu = new BiomeMenu(plot);
		
		if (CONFIG.getBoolean("gui.particles.enabled")) {
			ItemStack particle = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.particles.id"));
			ItemMeta particleMeta = particle.getItemMeta();
			particleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.name")));
			List<String> particleLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.particles.lores"))
				particleLores.add(MessageManager.translate(lore));
			particleMeta.setLore(particleLores);
			particle.setItemMeta(particleMeta);
			
			setItem(particle, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					particlesMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 10);
		}
		
		if (CONFIG.getBoolean("gui.floor.enabled")) {
			ItemStack floor = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.floor.id"));
			ItemMeta floorMeta = floor.getItemMeta();
			floorMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.name")));
			List<String> floorLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.floor.lores"))
				floorLores.add(MessageManager.translate(lore));
			floorMeta.setLore(floorLores);
			floor.setItemMeta(floorMeta);
			
			setItem(floor, new GuiAction() {
				@SuppressWarnings("deprecation")
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;

                    InventoryClickEvent event = (InventoryClickEvent) e;
                    Player player = (Player) event.getWhoClicked();

                    int cooldown = (int) CONFIG.getDouble("gui.floor.cooldown") * 1000;

					if (cooldown > 0 && System.currentTimeMillis() - floorChange < cooldown) {
					    MessageManager.getInstance().send(player, ChatColor.YELLOW + "You have to wait " +
                                (((cooldown - System.currentTimeMillis()) + floorChange) / 1000.0) +
                                " seconds before you can change the floor again");
                        return true;
					}
					
					if (ArenaManager.getInstance().getArena(player) == null)
						return false;
					
					if (event.getCursor().getType() == Material.AIR) {
						floorMenu.open(player);
						floorChange = System.currentTimeMillis();
						return true;
					}
					
					for (String material : CONFIG.getStringList("blocks.blocked")) {
						if (IDDecompiler.getInstance().matches(material, event.getCursor())) {
							for (String message : MessageManager.translate(MESSAGES.getStringList("plots.floor.blocked")))
								player.sendMessage(message);
							
							return true;
						}
					}


					if (event.getCursor().getType() == Material.WATER_BUCKET) {
						for (Block block : plot.getFloor().getAllBlocks())
							block.setType(Material.WATER);

                        floorChange = System.currentTimeMillis();

						return true;
					}
					
					if (event.getCursor().getType() == Material.LAVA_BUCKET) {
						for (Block block : plot.getFloor().getAllBlocks())
							block.setType(Material.LAVA);

                        floorChange = System.currentTimeMillis();

						return true;
					}
					
					if (!event.getCursor().getType().isBlock()) {
						for (String message : MessageManager.translate(MESSAGES.getStringList("plots.floor.incorrect")))
							player.sendMessage(message);
						
						return true;
					}
					
					for (Block block : plot.getFloor().getAllBlocks()) {
						if (block.getType() == event.getCursor().getType() && block.getData() == event.getCursor().getData().getData())
							continue;
						
						block.setType(event.getCursor().getType());
						block.setData(event.getCursor().getData().getData());
					}

                    floorChange = System.currentTimeMillis();

					return true;
				}
			}, 12);
		}
		
		if (CONFIG.getBoolean("gui.time.enabled")) {
			ItemStack time = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.time.id"));
			ItemMeta timeMeta = time.getItemMeta();
			timeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.name")));
			List<String> timeLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.time.lores"))
				timeLores.add(MessageManager.translate(lore));
			timeMeta.setLore(timeLores);
			time.setItemMeta(timeMeta);
			
			setItem(time, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					timeMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 14);
		}
		
		if (CONFIG.getBoolean("gui.rain.enabled")) {
			ItemStack rain = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.rain.id"));
			ItemMeta rainMeta = rain.getItemMeta();
			rainMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.rain.name")));
			List<String> rainLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.rain.lores"))
				rainLores.add(MessageManager.translate(lore));
			rainMeta.setLore(rainLores);
			rain.setItemMeta(rainMeta);
			
			setItem(rain, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
					
					if (ArenaManager.getInstance().getArena(player) == null)
						return false;
					
					Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
					
					plot.setRaining(!plot.isRaining());
					return true;
				}
			}, 16);
		}
		
		if (CONFIG.getBoolean("gui.fly-speed.enabled")) {
			ItemStack speed = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.fly-speed.id"));
			ItemMeta speedMeta = speed.getItemMeta();
			speedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.name")));
			List<String> speedLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.fly-speed.lores"))
				speedLores.add(MessageManager.translate(lore));
			speedMeta.setLore(speedLores);
			speed.setItemMeta(speedMeta);
			
			setItem(speed, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					flySpeedMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 19);
		}
		
		if (CONFIG.getBoolean("gui.heads.enabled")) {
			ItemStack heads = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.heads.id"));
			ItemMeta headsMeta = heads.getItemMeta();
			headsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.name")));
			List<String> headsLores = new ArrayList<>();
			for (String lore : MESSAGES.getStringList("gui.heads.lores"))
				headsLores.add(MessageManager.translate(lore));
			headsMeta.setLore(headsLores);
			heads.setItemMeta(headsMeta);
			
			setItem(heads, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					headsMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 21);
		}

        if (CONFIG.getBoolean("gui.banners.enabled")) {
            ItemStack banners = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.banners.id"));
            ItemMeta bannersMeta = banners.getItemMeta();
            bannersMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.banners.name")));
            bannersMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.banners.lore")));
            banners.setItemMeta(bannersMeta);

            setItem(banners, new GuiAction() {
                @Override
                public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
                    if (type != GuiActionType.CLICK)
                        return false;

                    InventoryClickEvent event = (InventoryClickEvent) e;

                    bannerMenu.open((Player) event.getWhoClicked());
                    return true;
                }
            }, 23);
        }

        if (CONFIG.getBoolean("gui.biome.enabled")) {
            ItemStack biome = IDDecompiler.getInstance().decompile(CONFIG.getString("gui.biome.id"));
            ItemMeta biomeMeta = biome.getItemMeta();
            biomeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.name")));
            biomeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.lores")));
            biome.setItemMeta(biomeMeta);

            setItem(biome, new GuiAction() {
                @Override
                public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
                    if (type != GuiActionType.CLICK)
                        return false;

                    InventoryClickEvent event = (InventoryClickEvent) e;

                    biomeMenu.open((Player) event.getWhoClicked());
                    return true;
                }
            }, 25);
        }

		ItemStack close = new ItemStack(Material.BOOK, 1);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.close-menu.name")));
		List<String> closeLores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("gui.close-menu.lores"))
			closeLores.add(MessageManager.translate(lore));
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent e = (InventoryClickEvent) event;
				
				e.getWhoClicked().closeInventory();
				removePlayer((Player) e.getWhoClicked());
				return true;
			}
		}, 31);
	}

	/**
     * Called whenever the gui is being opened
     *
     * @param player the player who's opening the gui
     * @param page the page to open the gui at
     * @since 4.0.0
     */
	@Override
	public void open(Player player, int page) {
		if (!player.hasPermission("bg.buildmenu.particles"))
			clear(10);
		if (!player.hasPermission("bg.buildmenu.floor"))
			clear(12);
		if (!player.hasPermission("bg.buildmenu.time"))
			clear(14);
		if (!player.hasPermission("bg.buildmenu.rain"))
			clear(16);
		if (!player.hasPermission("bg.buildmenu.flyspeed"))
			clear(19);
		if (!player.hasPermission("bg.buildmenu.heads"))
			clear(21);
        if (!player.hasPermission("bg.buildmenu.banners"))
            clear(23);
        if (!player.hasPermission("bg.buildmenu.biome"))
            clear(25);

		
		super.open(player, page);
	}
}