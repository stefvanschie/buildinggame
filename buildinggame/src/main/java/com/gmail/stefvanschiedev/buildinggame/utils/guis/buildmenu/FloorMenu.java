package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.PaginatedPane;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The gui to change the floor's material
 *
 * @since 4.0.0
 */
class FloorMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * An item stack for going to the previous page
     */
	private static final ItemStack PREVIOUS_PAGE;

	/**
     * An item stack for going to the next page
     */
	private static final ItemStack NEXT_PAGE;

	/**
     * An item stack for closing the menu
     */
	private static final ItemStack CLOSE_MENU;

	/**
     * An array of materials which should not be included in the menu
     */
	private static final Material[] SKIP_MATERIALS = {
		Material.ACACIA_DOOR,
		Material.AIR,
		Material.BED_BLOCK,
		Material.BEETROOT_BLOCK,
		Material.BIRCH_DOOR,
		Material.BREWING_STAND,
		Material.BURNING_FURNACE,
		Material.CAKE_BLOCK,
		Material.CARROT,
		Material.CAULDRON,
		Material.COCOA,
		Material.CROPS,
		Material.DARK_OAK_DOOR,
		Material.DAYLIGHT_DETECTOR_INVERTED,
		Material.DIODE_BLOCK_OFF,
		Material.DIODE_BLOCK_ON,
		Material.DOUBLE_STEP,
		Material.DOUBLE_STONE_SLAB2,
		Material.END_GATEWAY,
		Material.ENDER_PORTAL,
		Material.FIRE,
		Material.FLOWER_POT,
		Material.FROSTED_ICE,
		Material.GLOWING_REDSTONE_ORE,
		Material.IRON_DOOR_BLOCK,
		Material.JUNGLE_DOOR,
		Material.LAVA,
		Material.MELON_STEM,
		Material.NETHER_WARTS,
		Material.PISTON_EXTENSION,
		Material.PISTON_MOVING_PIECE,
		Material.PORTAL,
		Material.POTATO,
		Material.PUMPKIN_STEM,
		Material.PURPUR_DOUBLE_SLAB,
		Material.REDSTONE_COMPARATOR_OFF,
		Material.REDSTONE_COMPARATOR_ON,
		Material.REDSTONE_LAMP_ON,
		Material.REDSTONE_TORCH_OFF,
		Material.REDSTONE_WIRE,
		Material.SIGN_POST,
		Material.SKULL,
		Material.SPRUCE_DOOR,
		Material.STANDING_BANNER,
		Material.STATIONARY_LAVA,
		Material.STATIONARY_WATER,
		Material.SUGAR_CANE_BLOCK,
		Material.TRIPWIRE,
		Material.WALL_BANNER,
		Material.WALL_SIGN,
		Material.WATER,
		Material.WOOD_DOUBLE_STEP,
		Material.WOODEN_DOOR,
	};

	/**
     * Constructs a new FloorMenu for the provided plot
     *
     * @param plot the plot this menu belongs to
     * @see Plot
     */
	FloorMenu(final Plot plot) {
		super(6, MessageManager.translate(MESSAGES.getString("gui.floor.title")));

        PaginatedPane paginatedPane = new PaginatedPane(new GuiLocation(0, 0), 9, 5,
            (int) Math.ceil(getBlocks().size() / 45) + 1);

        for (int page = 0; page < paginatedPane.getPages(); page++) {
            OutlinePane outlinePane = new OutlinePane(new GuiLocation(0, 0), 9, 5);

            for (int i = 0; i < 45; i++) {
                if (i + (45 * page) == getBlocks().size())
                    break;

                Material material = getBlocks().get(i + (45 * page));

                outlinePane.addItem(new GuiItem(new ItemStack(material), event -> {
                    for (Block b : plot.getFloor().getAllBlocks())
                        b.setType(material);

                    event.setCancelled(true);
                }));
            }

            paginatedPane.setPane(page, outlinePane);
        }

        OutlinePane previous = new OutlinePane(new GuiLocation(2, 5), 1, 1);
        OutlinePane back = new OutlinePane(new GuiLocation(4, 5), 1, 1);
        OutlinePane next = new OutlinePane(new GuiLocation(6, 5), 1, 1);

        previous.addItem(new GuiItem(PREVIOUS_PAGE, event -> {
            paginatedPane.setPage(paginatedPane.getPage() - 1);

            if (paginatedPane.getPage() == 0)
                previous.setVisible(false);

            next.setVisible(true);

            update();

            event.setCancelled(true);
        }));

        previous.setVisible(false);

        back.addItem(new GuiItem(CLOSE_MENU, event -> {
            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
        }));

        next.addItem(new GuiItem(NEXT_PAGE, event -> {
            paginatedPane.setPage(paginatedPane.getPage() + 1);

            if (paginatedPane.getPage() == paginatedPane.getPages() - 1)
                next.setVisible(false);

            previous.setVisible(true);

            update();

            event.setCancelled(true);
        }));

        addPane(paginatedPane);

        addPane(previous);
        addPane(back);
        addPane(next);
	}

	/**
     * Returns a list of materials without the once that should be blocked from the menu specified in the config.yml and
     * the {@link #SKIP_MATERIALS} array
     *
     * @return a list of materials
     * @since 4.0.0
     */
	@NotNull
	@Contract(pure = true)
	private static List<Material> getBlocks() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		List<Material> blocks = new ArrayList<>();
		
		for (Material material : Material.values()) {
			if (material.isBlock() && !Arrays.asList(SKIP_MATERIALS).contains(material) &&
                    !config.getStringList("blocks.blocked").contains(material.toString()
                            .toLowerCase(Locale.getDefault())) &&
                    !config.getStringList("gui.floor.excluded-blocks").contains(material.toString()
                            .toLowerCase(Locale.getDefault())))
				blocks.add(material);
		}
		
		return blocks;
	}
	
	static {
		PREVIOUS_PAGE = new ItemStack(Material.SUGAR_CANE);
		ItemMeta previousPageMeta = PREVIOUS_PAGE.getItemMeta();
		previousPageMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.floor.previous-page.name")));
		previousPageMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.floor.previous-page.lores")));
		PREVIOUS_PAGE.setItemMeta(previousPageMeta);
		
		NEXT_PAGE = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextPageMeta = NEXT_PAGE.getItemMeta();
		nextPageMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.next-page.name")));
		nextPageMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.next-page.lores")));
		NEXT_PAGE.setItemMeta(nextPageMeta);
		
		CLOSE_MENU = new ItemStack(Material.BOOK);
		ItemMeta closeMenuMeta = CLOSE_MENU.getItemMeta();
		closeMenuMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.close-menu.name")));
		closeMenuMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.close-menu.lores")));
		CLOSE_MENU.setItemMeta(closeMenuMeta);
	}
}