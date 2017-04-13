package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class ItemBuilder extends ItemStack implements Listener {
	
	private ClickEvent event;
	private boolean moveable;
	
	private static final Map<Player, ItemBuilder> REGISTERED_ITEMS = new HashMap<>();
	
	public ItemBuilder(Player player, Material material) {
		this(player, material, 1);
	}
	
	private ItemBuilder(Player player, Material material, int amount) {
		this(player, material, amount, (short) 0);
	}
	
	public ItemBuilder(Player player, Material material, int amount, short damage) {
		setType(material);
		setAmount(amount);
		setDurability(damage);
		
		REGISTERED_ITEMS.put(player, this);
		
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
	
	public ItemBuilder moveable(boolean moveable) {
		this.moveable = moveable;
		return this;
	}
	
	public ItemBuilder setClickEvent(ClickEvent event) {
		this.event = event;
		return this;
	}
	
	public ItemBuilder setDisplayName(String name) {
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(name);
		setItemMeta(meta);
		return this;
	}
	
	public ItemBuilder setLore(List<String> lores) {
		ItemMeta meta = getItemMeta();
		meta.setLore(lores);
		setItemMeta(meta);
		return this;
	}
	
	private void unregister() {
		HandlerList.unregisterAll(this);
	}
	
	public static void check(Player player) {
		ItemBuilder builder = REGISTERED_ITEMS.get(player);
		
		if (builder == null)
			return;
		
		if (!player.getInventory().contains(builder))
			builder.unregister();
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getItem() == null || !this.isSimilar(e.getItem()) || event == null)
			return;
		
		if (e.getHand() == EquipmentSlot.HAND)
			e.setCancelled(this.event.onClick(e));
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null || !e.getCurrentItem().equals(this))
			return;
		
		if (!moveable)
			e.setCancelled(true);
	}
	
	@FunctionalInterface
    public interface ClickEvent {
		
		boolean onClick(PlayerInteractEvent event);
		
	}
}