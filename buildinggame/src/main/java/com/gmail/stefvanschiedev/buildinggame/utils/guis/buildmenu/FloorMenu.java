package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
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
public class FloorMenu extends ChestGui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The last time the floor was changed (according to System.currentMillis())
     */
    private long floorChange;

	/**
     * An array of materials which should not be included in the menu
     */
	private static final Material[] SKIP_MATERIALS = {
		Material.ACACIA_DOOR,
        Material.ACACIA_WALL_SIGN,
		Material.AIR,
        Material.ATTACHED_MELON_STEM,
        Material.ATTACHED_PUMPKIN_STEM,
        Material.BAMBOO_SAPLING,
        Material.BEETROOTS,
		Material.BIRCH_DOOR,
        Material.BIRCH_WALL_SIGN,
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
        Material.DARK_OAK_WALL_SIGN,
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
        Material.JUNGLE_WALL_SIGN,
        Material.KELP_PLANT,
		Material.LAVA,
        Material.LIGHT_BLUE_WALL_BANNER,
        Material.LIGHT_GRAY_WALL_BANNER,
        Material.LIME_WALL_BANNER,
        Material.MAGENTA_WALL_BANNER,
		Material.MELON_STEM,
		Material.MOVING_PISTON,
		Material.NETHER_PORTAL,
        Material.OAK_WALL_SIGN,
        Material.ORANGE_WALL_BANNER,
        Material.PINK_WALL_BANNER,
        Material.PISTON_HEAD,
        Material.PLAYER_WALL_HEAD,
        Material.POPPED_CHORUS_FRUIT,
        Material.POPPY,
		Material.POTATO,
        Material.POTATOES,
        Material.POTTED_ACACIA_SAPLING,
        Material.POTTED_ALLIUM,
        Material.POTTED_AZURE_BLUET,
        Material.POTTED_BAMBOO,
        Material.POTTED_BIRCH_SAPLING,
        Material.POTTED_BLUE_ORCHID,
        Material.POTTED_BROWN_MUSHROOM,
        Material.POTTED_CACTUS,
        Material.POTTED_CORNFLOWER,
        Material.POTTED_DANDELION,
        Material.POTTED_DARK_OAK_SAPLING,
        Material.POTTED_DEAD_BUSH,
        Material.POTTED_FERN,
        Material.POTTED_JUNGLE_SAPLING,
        Material.POTTED_LILY_OF_THE_VALLEY,
        Material.POTTED_OAK_SAPLING,
        Material.POTTED_ORANGE_TULIP,
        Material.POTTED_OXEYE_DAISY,
        Material.POTTED_PINK_TULIP,
        Material.POTTED_POPPY,
        Material.POTTED_RED_MUSHROOM,
        Material.POTTED_RED_TULIP,
        Material.POTTED_SPRUCE_SAPLING,
        Material.POTTED_WHITE_TULIP,
        Material.POTTED_WITHER_ROSE,
		Material.PUMPKIN_STEM,
        Material.PURPLE_WALL_BANNER,
        Material.RED_WALL_BANNER,
        Material.REDSTONE_WALL_TORCH,
		Material.REDSTONE_WIRE,
        Material.SKELETON_WALL_SKULL,
		Material.SPRUCE_DOOR,
        Material.SPRUCE_WALL_SIGN,
        Material.SWEET_BERRY_BUSH,
        Material.TALL_SEAGRASS,
		Material.TRIPWIRE,
        Material.TUBE_CORAL_WALL_FAN,
        Material.VOID_AIR,
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
		super(6, MessageManager.translate(MESSAGES.getString("gui.floor.title")));

        var paginatedPane = new PaginatedPane(0, 0, 9, 5);

        for (var page = 0; page < Math.ceil(getBlocks().size() / 45.0); page++) {
            var outlinePane = new OutlinePane(0, 0, 9, 5);

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

        var previous = new OutlinePane(2, 5, 1, 1);
        var back = new OutlinePane(4, 5, 1, 1);
        var next = new OutlinePane(6, 5, 1, 1);

        var previousPage = new ItemStack(Material.SUGAR_CANE);
        ItemMeta previousPageMeta = previousPage.getItemMeta();
        previousPageMeta.setDisplayName(MessageManager.translate(MESSAGES
            .getString("gui.floor.previous-page.name")));
        previousPageMeta.setLore(MessageManager.translate(MESSAGES
            .getStringList("gui.floor.previous-page.lores")));
        previousPage.setItemMeta(previousPageMeta);

        previous.addItem(new GuiItem(previousPage, event -> {
            paginatedPane.setPage(paginatedPane.getPage() - 1);

            if (paginatedPane.getPage() == 0)
                previous.setVisible(false);

            next.setVisible(true);

            update();

            event.setCancelled(true);
        }));

        previous.setVisible(false);

        var closeMenu = new ItemStack(Material.BOOK);
        ItemMeta closeMenuMeta = closeMenu.getItemMeta();
        closeMenuMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.close-menu.name")));
        closeMenuMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.close-menu.lores")));
        closeMenu.setItemMeta(closeMenuMeta);

        back.addItem(new GuiItem(closeMenu, event -> {
            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
        }));

        var nextPage = new ItemStack(Material.SUGAR_CANE);
        ItemMeta nextPageMeta = nextPage.getItemMeta();
        nextPageMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.floor.next-page.name")));
        nextPageMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.floor.next-page.lores")));
        nextPage.setItemMeta(nextPageMeta);

        next.addItem(new GuiItem(nextPage, event -> {
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

    /**
     * Sets the last time the floor was changed specified as milliseconds elapsed since the UNIX epoch.
     *
     * @param lastFloorChange the last time the floor was changed
     * @since 7.1.0
     */
	public void setLastFloorChange(long lastFloorChange) {
	    this.floorChange = lastFloorChange;
    }

    /**
     * Gets the last time the floor was changed as milliseconds elapsed since the UNIX epoch.
     *
     * @return the time the floor was last changed
     * @since 7.1.0
     */
	@Contract(pure = true)
	public long getLastFloorChange() {
	    return floorChange;
    }
}