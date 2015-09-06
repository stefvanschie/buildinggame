package me.stefvanschie.buildinggame.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerData {

	private Player player;
	private ItemStack[] inventory;
	
	public PlayerData(Player player) {
		this.player = player;
		inventory = player.getInventory().getContents();
	}
	
	public ItemStack[] getInventory() {
		return inventory;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setInventory(ItemStack[] inventory) {
		this.inventory = inventory;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
