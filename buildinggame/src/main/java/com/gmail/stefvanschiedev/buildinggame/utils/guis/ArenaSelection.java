package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * An menu to choose an open arena
 *
 * @since 4.0.4
 */
public class ArenaSelection extends Gui {

    /**
     * The config YAML configuration
     */
    private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();

    /**
     * Constructs a new ArenaSelection
     */
	public ArenaSelection() {
		super(Main.getInstance(), 6, ChatColor.GREEN + "Select an arena");
	}

	/**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
	@Override
	public void show(@NotNull HumanEntity humanEntity) {
		var outlinePane = new OutlinePane(0, 0, 9, 6);

        boolean joinInGame = CONFIG.getBoolean("join-during-game");

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            GameState state = arena.getState();

            if (arena.isFull() ||
                (state != GameState.STARTING && state != GameState.WAITING && state != GameState.BUILDING) ||
                (!joinInGame && state == GameState.BUILDING)) {
                continue;
            }

            var item = new ItemStack(Material.LIME_WOOL);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(ChatColor.GREEN + arena.getName());
            item.setItemMeta(itemMeta);

            outlinePane.addItem(new GuiItem(item, event -> {
                arena.join((Player) humanEntity);

                event.setCancelled(true);
            }));
        }

		addPane(outlinePane);
		
		super.show(humanEntity);
	}
}