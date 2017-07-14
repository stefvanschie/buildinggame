package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

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
		super(null, 54, ChatColor.GREEN + "Select an arena", 1);
	}

	/**
     * Called when a player wants or is forced to open the menu
     *
     * @param player the player to show the menu
     * @param page the page to show
     * @since 4.0.4
     */
	@Override
	public void open(final Player player, int page) {
		clear();
		
		for (final Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING && !arena.isFull())
				continue;
			
			ItemStack item = new ItemStack(Material.WOOL, 1, (short) 5);
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ChatColor.GREEN + arena.getName());
			item.setItemMeta(itemMeta);
			
			addItem(item, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					arena.join(player);
					return true;
				}
			});
		}
		
		super.open(player, page);
	}
}