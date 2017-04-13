package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.HashMap;
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

public class Gui implements Listener {
	
	private final Inventory inventory;
	private GuiItem[] items;
	
	private final Map<Player, Integer> playerPages;
	
	private final int size;
	protected final int pages;
	
	//the index where it'll start to add items from
	private int startingPoint;
	
	protected Gui(InventoryHolder inventoryHolder, int size, String title, int pages) {
		inventory = Bukkit.createInventory(inventoryHolder, size, title);
		
		items = new GuiItem[size * pages];
		playerPages = new HashMap<>();
		
		this.size = size;
		this.pages = pages;
		
		this.startingPoint = 0;
		
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
	
	protected void addItem(ItemStack itemStack) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack);
	}
	
	protected void addItem(ItemStack itemStack, GuiAction action) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack, action);
	}
	
	void clear() {
		items = new GuiItem[items.length];
	}
	
	protected void clear(int position) {
		items[position] = null;
	}
	
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
	
	int getPage(Player player) {
		return playerPages.get(player);
	}
	
	public void open(Player player) {
		open(player, 1);
	}
	
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
		
		playerPages.put(player, page);
	}
	
	public void removePlayer(Player player) {
		playerPages.remove(player);
	}
	
	protected void setItem(ItemStack itemStack, GuiAction action, int position) {
		items[position] = new GuiItem(itemStack, action);
	}
	
	protected void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	synchronized void update() {
        for (Player player : playerPages.keySet())
            update(player);
	}
	
	private void update(Player player) {
		if (!playerPages.containsKey(player))
			return;
		
		open(player, playerPages.get(player));
	}
	
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
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if (!e.getInventory().getName().equals(inventory.getName()))
			return;

		//noinspection SuspiciousMethodCalls
		playerPages.remove(e.getPlayer());
	}
	
	public enum GuiActionType {
		CLICK
    }
	
	public class GuiItem {
		
		private final ItemStack itemStack;
		private final GuiAction guiAction;
		
		public GuiItem(ItemStack itemStack) {
			this(itemStack, new GuiAction());
		}
		
		public GuiItem(ItemStack itemStack, GuiAction guiAction) {
			this.itemStack = itemStack;
			this.guiAction = guiAction;
		}
		
		public ItemStack getItemStack() {
			return itemStack;
		}
		
		public GuiAction getGuiAction() {
			return guiAction;
		}
	}
	
	public class GuiAction {
		
		public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
			return false;
		}
	}
}