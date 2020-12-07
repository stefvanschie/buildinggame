package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * An menu to choose an open arena
 *
 * @since 4.0.4
 */
public class ArenaSelection extends ChestGui {

    /**
     * Constructs a new ArenaSelection
     */
	public ArenaSelection() {
		super(6, ChatColor.GREEN + "Select an arena");
	}

	/**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
	@Override
	public void show(@NotNull HumanEntity humanEntity) {
		var outlinePane = new OutlinePane(0, 0, 9, 6);

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            if (arena.canJoin()) {
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