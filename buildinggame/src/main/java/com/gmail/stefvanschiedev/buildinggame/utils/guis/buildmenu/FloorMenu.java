package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.Material;
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
        Material.ATTACHED_MELON_STEM,
        Material.ATTACHED_PUMPKIN_STEM,
        Material.BEETROOTS,
		Material.BIRCH_DOOR,
        Material.BLACK_WALL_BANNER,
        Material.BLUE_WALL_BANNER,
        Material.BRAIN_CORAL_WALL_FAN,
		Material.BREWING_STAND,
        Material.BROWN_WALL_BANNER,
        Material.BUBBLE_COLUMN,
        Material.BUBBLE_CORAL_WALL_FAN,
		Material.CARROT,
        Material.CARROTS,
		Material.CAULDRON,
        Material.CAVE_AIR,
		Material.COCOA,
        Material.CREEPER_WALL_HEAD,
        Material.CYAN_WALL_BANNER,
		Material.DARK_OAK_DOOR,
        Material.DEAD_BRAIN_CORAL_WALL_FAN,
        Material.DEAD_BUBBLE_CORAL_WALL_FAN,
        Material.DEAD_FIRE_CORAL_WALL_FAN,
        Material.DEAD_HORN_CORAL_WALL_FAN,
        Material.DEAD_TUBE_CORAL_WALL_FAN,
        Material.DRAGON_WALL_HEAD,
		Material.END_GATEWAY,
		Material.END_PORTAL,
		Material.FIRE,
        Material.FIRE_CORAL_WALL_FAN,
		Material.FLOWER_POT,
		Material.FROSTED_ICE,
        Material.GRAY_WALL_BANNER,
        Material.GREEN_WALL_BANNER,
        Material.HORN_CORAL_WALL_FAN,
		Material.JUNGLE_DOOR,
        Material.KELP_PLANT,
		Material.LAVA,
        Material.LIGHT_BLUE_WALL_BANNER,
        Material.LIGHT_GRAY_WALL_BANNER,
        Material.LIME_WALL_BANNER,
        Material.MAGENTA_WALL_BANNER,
		Material.MELON_STEM,
		Material.MOVING_PISTON,
		Material.NETHER_PORTAL,
        Material.ORANGE_WALL_BANNER,
        Material.PINK_WALL_BANNER,
        Material.PISTON_HEAD,
        Material.PLAYER_WALL_HEAD,
        Material.POPPY,
		Material.POTATO,
        Material.POTATOES,
        Material.POTTED_ACACIA_SAPLING,
        Material.POTTED_ALLIUM,
        Material.POTTED_AZURE_BLUET,
        Material.POTTED_BIRCH_SAPLING,
        Material.POTTED_BLUE_ORCHID,
        Material.POTTED_BROWN_MUSHROOM,
        Material.POTTED_CACTUS,
        Material.POTTED_DANDELION,
        Material.POTTED_DARK_OAK_SAPLING,
        Material.POTTED_DEAD_BUSH,
        Material.POTTED_FERN,
        Material.POTTED_JUNGLE_SAPLING,
        Material.POTTED_OAK_SAPLING,
        Material.POTTED_ORANGE_TULIP,
        Material.POTTED_OXEYE_DAISY,
        Material.POTTED_PINK_TULIP,
        Material.POTTED_POPPY,
        Material.POTTED_RED_MUSHROOM,
        Material.POTTED_RED_TULIP,
        Material.POTTED_SPRUCE_SAPLING,
        Material.POTTED_WHITE_TULIP,
		Material.PUMPKIN_STEM,
        Material.PURPLE_WALL_BANNER,
        Material.RED_WALL_BANNER,
        Material.REDSTONE_WALL_TORCH,
		Material.REDSTONE_WIRE,
        Material.SKELETON_WALL_SKULL,
		Material.SPRUCE_DOOR,
        Material.TALL_SEAGRASS,
		Material.TRIPWIRE,
        Material.TUBE_CORAL_WALL_FAN,
        Material.VOID_AIR,
		Material.WALL_SIGN,
        Material.WALL_TORCH,
		Material.WATER,
        Material.WHITE_WALL_BANNER,
        Material.WITHER_SKELETON_WALL_SKULL,
        Material.YELLOW_WALL_BANNER,
        Material.ZOMBIE_WALL_HEAD
	};

	/**
     * Constructs a new FloorMenu for the provided plot
     *
     * @param plot the plot this menu belongs to
     * @see Plot
     */
	FloorMenu(final Plot plot) {
		super(Main.getInstance(), 6, MessageManager.translate(MESSAGES.getString("gui.floor.title")));

        var paginatedPane = new PaginatedPane(new GuiLocation(0, 0), 9, 5);

        for (var page = 0; page < Math.ceil(getBlocks().size() / 45.0); page++) {
            var outlinePane = new OutlinePane(new GuiLocation(0, 0), 9, 5);

            for (var i = 0; i < 45; i++) {
                if (i + (45 * page) == getBlocks().size())
                    break;

                Material material = getBlocks().get(i + (45 * page));

                outlinePane.addItem(new GuiItem(new ItemStack(material), event -> {
                    plot.getFloor().getAllBlocks().forEach(b -> b.setType(material));

                    event.setCancelled(true);
                }));
            }

            paginatedPane.addPane(page, outlinePane);
        }

        var previous = new OutlinePane(new GuiLocation(2, 5), 1, 1);
        var back = new OutlinePane(new GuiLocation(4, 5), 1, 1);
        var next = new OutlinePane(new GuiLocation(6, 5), 1, 1);

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
		var blocks = new ArrayList<Material>();
		
		for (Material material : Material.values()) {
            //noinspection deprecation
            if (material.isBlock() && !material.isLegacy() && !Arrays.asList(SKIP_MATERIALS).contains(material) &&
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