package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import org.jetbrains.annotations.NotNull;

/**
 * An menu to choose an open arena
 *
 * @since 4.0.4
 */
public class ArenaSelection extends Gui {

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

        ArenaManager.getInstance().getArenas().stream()
            .filter(arena ->
                (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING) && !arena.isFull())
            .forEach(arena -> {
                var item = new ItemStack(Material.LIME_WOOL);
                var itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(ChatColor.GREEN + arena.getName());
                item.setItemMeta(itemMeta);

                outlinePane.addItem(new GuiItem(item, event -> {
                    arena.join((Player) humanEntity);

                    event.setCancelled(true);
                }));
            });

		addPane(outlinePane);
		
		super.show(humanEntity);
	}
}