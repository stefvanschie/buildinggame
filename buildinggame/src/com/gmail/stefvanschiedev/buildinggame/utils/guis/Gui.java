package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A base gui class for all guis and menus
 *
 * @since 4.0.0
 */
public class Gui implements Listener {

    /**
     * The inventory object this gui is linked to
     */
	private final Inventory inventory;

	/**
     * An array of gui items going from left to right, top to bottom, ascending pages
     */
	private GuiItem[] items;

	/**
     * A map containing the pages each player is looking at
     */
	private final Map<Player, Integer> playerPages;

	/**
     * The size of one gui page
     */
	private final int size;

	/**
     * The amount of pages this gui has
     */
	protected final int pages;

    /**
     * The index where it'll start to add items from
     */
	private int startingPoint;

	/**
     * Constructs a new Gui
     *
     * @param inventoryHolder the holder of this inventory
     * @param size the size of one gui page (must be dividable by 9)
     * @param title the title of this inventory
     * @param pages the amount of pages this gui has
     */
	protected Gui(InventoryHolder inventoryHolder, int size, String title, int pages) {
		inventory = Bukkit.createInventory(inventoryHolder, size, title);
		
		items = new GuiItem[size * pages];
		playerPages = new HashMap<>();
		
		this.size = size;
		this.pages = pages;
		
		this.startingPoint = 0;
		
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}

	/**
     * Adds an item to the first empty slot in the gui
     *
     * @param itemStack the item to add to the gui
     * @since 4.0.0
     */
	protected void addItem(ItemStack itemStack) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack);
	}

	/**
     * Adds an item to the first empty slot in the gui and assigns a click action to it
     *
     * @param itemStack the item to add to the gui
     * @param action the action that'll be called whenever a player clicks on the item
     * @since 4.0.0
     */
	protected void addItem(ItemStack itemStack, GuiAction action) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack, action);
	}

	/**
     * Clears the entire gui
     */
	void clear() {
		items = new GuiItem[items.length];
	}

	/**
     * Clears the specific position in the gui
     *
     * @param position the position to clear
     * @since 4.0.0
     */
	protected void clear(int position) {
		items[position] = null;
	}

	/**
     * Returns the first empty slot in the gui from the specified starting point
     *
     * @param startingPoint the point to start looking from
     * @return the first index that's empty
     * @since 4.0.0
     */
	@Contract(pure = true)
    private int getFirstEmptySlot(int startingPoint) {
		int firstNotNull = -1;
        int length = items.length;

		for (int i = startingPoint; i < length; i++) {
			if (items[i] == null) {
				firstNotNull = i;
				break;
			}
		}
		
		return firstNotNull;
	}

	/**
     * Returns the page the specified player is looking at
     *
     * @param player the player to request the page for
     * @return the page this player is looking at
     * @since 4.0.0
     */
	@Contract(pure = true)
	int getPage(Player player) {
		return playerPages.get(player);
	}

	/**
     * Opens the gui for the specified player on page one
     *
     * @param player the player to open the gui for
     * @since 4.0.0
     */
	@Contract("null -> fail")
	public void open(Player player) {
		open(player, 1);
	}

	/**
     * Opens the gui for the specified player on the specified page
     *
     * @param player the player to open the gui for
     * @param page the page to open for the player
     * @since 4.0.0
     */
	@Contract("null, _ -> fail")
	public void open(Player player, int page) {
		GuiItem[] splittedItems = new GuiItem[size];
		System.arraycopy(items, (page - 1) * splittedItems.length, splittedItems, 0, splittedItems.length);
		
		ItemStack[] newItems = new ItemStack[size];

		int length = splittedItems.length;
		for (int i = 0; i < length; i++) {
			if (splittedItems[i] == null)
				continue;
			
			newItems[i] = splittedItems[i].getItemStack();
		}
		
		inventory.clear();
		inventory.setContents(newItems);
		
		player.openInventory(inventory);

		if (!playerPages.containsKey(player) || playerPages.get(player) != page)
		    playerPages.put(player, page);
	}

	/**
     * Removes the player from the gui. This doesn't close the gui for them however.
     *
     * @param player the player to remove from the gui
     * @since 4.0.0
     */
	public void removePlayer(Player player) {
		playerPages.remove(player);
	}

	/**
     * Sets an item and an assigned action to the specified position
     *
     * @param itemStack the item to add
     * @param action the action assigned to the item
     * @param position the position to put the item in
     * @since 4.0.0
     */
	protected void setItem(ItemStack itemStack, GuiAction action, int position) {
		items[position] = new GuiItem(itemStack, action);
	}

    /**
     * Sets an item to the specified position
     *
     * @param itemStack the item to add
     * @param position the position to put the item in
     * @since 4.0.0
     */
    protected void setItem(ItemStack itemStack, int position) {
        items[position] = new GuiItem(itemStack);
    }

	/**
     * Sets the starting point for the gui. This is the position that new items via {@link #addItem(ItemStack)} and
     * {@link #addItem(ItemStack, GuiAction)} will be added.
     *
     * @param startingPoint the new starting point
     * @since 4.0.0
     */
	protected void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	/**
     * Updates the gui for each player
     *
     * @since 4.0.0
     */
	synchronized void update() {
	    //safe from cme
	    new HashSet<>(playerPages.keySet()).forEach(this::update);
	}

	/**
     * Updates the gui for the specified player
     *
     * @param player the player to update the gui for
     * @since 4.0.0
     */
	private void update(Player player) {
		if (!playerPages.containsKey(player))
			return;
		
		open(player, playerPages.get(player));
	}

	/**
     * Called whenever a player clicks in an inventory
     *
     * @param e the event representing the click in the ivnentory
     * @since 4.0.0
     */
	@Contract("null -> fail")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getInventory().getName().equals(inventory.getName()))
			return;
		
		Player player = (Player) e.getWhoClicked();
		
		if (!playerPages.containsKey(player))
			return;
		
		if (e.getCurrentItem() == null)
			return;
		
		int slot = e.getSlot() + (size * (playerPages.get(player) - 1));
		
		if (items[slot] == null)
			return;
		
		if (items[slot].getGuiAction().actionPerformed(GuiActionType.CLICK, e))
			e.setCancelled(true);
	}

	/**
     * Called whenever a player closes their inventory
     *
     * @param e the event representing an inventory that's been closed
     * @since 4.0.0
     */
	@Contract("null -> fail")
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if (!e.getInventory().getName().equals(inventory.getName()))
			return;

		//noinspection SuspiciousMethodCalls
		playerPages.remove(e.getPlayer());
	}

	/**
     * The different actions for the GuiAction
     *
     * @since 4.0.0
     */
	public enum GuiActionType {

	    /**
         * A click action type
         *
         * @since 4.0.0
         */
		CLICK
    }

    /**
     * A class containing an item and an action assigned to that item
     *
     * @since 4.0.0
     */
	class GuiItem {

	    /**
         * The item linked to this class
         */
		private final ItemStack itemStack;

		/**
         * The action assigned to the item
         */
		private final GuiAction guiAction;

		/**
         * Constructs a new GuiItem
         *
         * @param itemStack the item to display
         */
		GuiItem(ItemStack itemStack) {
			this(itemStack, new GuiAction());
		}

        /**
         * Constructs a new GuiItem
         *
         * @param itemStack the item to display
         * @param guiAction the action assigned to the item
         */
		GuiItem(ItemStack itemStack, GuiAction guiAction) {
			this.itemStack = itemStack;
			this.guiAction = guiAction;
		}

		/**
         * Returns the item for this gui item
         *
         * @return the item
         * @since 4.0.0
         */
		@NotNull
		@Contract(pure = true)
		ItemStack getItemStack() {
			return itemStack;
		}

		/**
         * Returns the action assigned to the item
         *
         * @return the action
         * @since 4.0.0
         */
        @NotNull
		@Contract(pure = true)
		GuiAction getGuiAction() {
			return guiAction;
		}
	}

	/**
     * A class for an action happening in the gui
     *
     * @since 4.0.0
     */
	public class GuiAction {

	    /**
         * Called whenever an action is performed on an item
         *
         * @param type the action type
         * @param event the inventory event linked to this action
         * @return true if this event should be cancelled, false if not
         * @since 4.0.0
         */
		public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
			return false;
		}
	}
}