package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class Gui implements Listener {
	
	protected Inventory inventory;
	protected GuiItem items[];
	protected GuiAction nonItemAction;
	
	protected Map<Player, Integer> playerPages;
	
	protected int size, pages;
	
	//the index where it'll start to add items from
	protected int startingPoint;
	
	public Gui(InventoryHolder inventoryHolder, int size, int pages) {
		this(inventoryHolder, size, ChatColor.DARK_GRAY + "Inventory", pages);
	}
	
	public Gui(InventoryHolder inventoryHolder, int size, String title, int pages) {
		inventory = Bukkit.createInventory(inventoryHolder, size, title);
		
		items = new GuiItem[size * pages];
		playerPages = new HashMap<>();
		
		this.size = size;
		this.pages = pages;
		
		this.startingPoint = 0;
		
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
	
	public void addItem(ItemStack itemStack) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack);
	}
	
	public void addItem(ItemStack itemStack, GuiAction action) {
		int firstNotNull = getFirstEmptySlot(startingPoint);
		
		if (firstNotNull == -1)
			return;
		
		items[firstNotNull] = new GuiItem(itemStack, action);
	}
	
	public void clear() {
		items = new GuiItem[items.length];
	}
	
	public void clear(int position) {
		items[position] = null;
	}
	
	public GuiItem[] getContents() {
		return items;
	}
	
	public GuiItem getItem(int position) {
		return items[position];
	}
	
	private int getFirstEmptySlot(int startingPoint) {
		int firstNotNull = -1;
		
		for (int i = startingPoint; i < items.length; i++) {
			if (items[i] == null) {
				firstNotNull = i;
				break;
			}
		}
		
		return firstNotNull;
	}
	
	public String getName() {
		return inventory.getName();
	}
	
	public int getPage(Player player) {
		return playerPages.get(player);
	}
	
	public int getSize() {
		return items.length;
	}
	
	public String getTitle() {
		return inventory.getTitle();
	}
	
	public InventoryType getType() {
		return inventory.getType();
	}
	
	public void open(Player player) {
		open(player, 1);
	}
	
	public void open(Player player, int page) {
		GuiItem[] splittedItems = new GuiItem[size];
		System.arraycopy(items, (page - 1) * splittedItems.length, splittedItems, 0, splittedItems.length);
		
		ItemStack[] newItems = new ItemStack[size];
		
		for (int i = 0; i < splittedItems.length; i++) {
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
	
	public void setItem(ItemStack itemStack, int position) {
		items[position] = new GuiItem(itemStack);
	}
	
	public void setItem(ItemStack itemStack, GuiAction action, int position) {
		items[position] = new GuiItem(itemStack, action);
	}
	
	public void setNonItemAction(GuiAction action) {
		this.nonItemAction = action;
	}
	
	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
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
		
		int slot = e.getSlot() + (size * (playerPages.get((Player) e.getWhoClicked()) - 1));
		
		if (items[slot] == null)
			return;
		
		if (items[slot].getGuiAction().actionPerformed(GuiActionType.CLICK, e))
			e.setCancelled(true);
	}
	
	public void update() {
		Map<Player, Integer> pages = playerPages;
		
		for (Player player : pages.keySet())
			update(player);
	}
	
	public void update(Player player) {
		if (!playerPages.containsKey(player))
			return;
		
		open(player, playerPages.get(player));
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if (!e.getInventory().getName().equals(inventory.getName()))
			return;
		
		if (nonItemAction != null)
			nonItemAction.actionPerformed(GuiActionType.CLOSE, e);
		
		playerPages.remove(e.getPlayer());
	}
	
	public enum GuiActionType {
		CLICK,
		CLOSE
	}
	
	public class GuiItem {
		
		private ItemStack itemStack;
		private GuiAction guiAction;
		
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