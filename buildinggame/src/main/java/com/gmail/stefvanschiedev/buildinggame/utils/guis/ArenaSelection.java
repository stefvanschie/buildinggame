package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
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
		super(6, ChatColor.GREEN + "Select an arena");
	}

	/**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
	@Override
	public void show(@NotNull HumanEntity humanEntity) {
		OutlinePane outlinePane = new OutlinePane(new GuiLocation(0, 0), 9, 6);
		
		for (final Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING && !arena.isFull())
				continue;
			
			ItemStack item = new ItemStack(Material.WOOL, 1, (short) 5);
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