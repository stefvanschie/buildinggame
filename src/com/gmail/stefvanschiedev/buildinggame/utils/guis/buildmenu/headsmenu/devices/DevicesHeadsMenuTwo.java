package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.devices;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class DevicesHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Devices");
		
		ItemStack blackClock = SkullItem.getSkull("http://textures.minecraft.net/texture/ba10da526e5111cfb6e3ebd47693e162dd52d41a2182028daa7c2b19aa3143");
		ItemMeta blackClockMeta = blackClock.getItemMeta();
		blackClockMeta.setDisplayName(ChatColor.GOLD + "Black Clock");
		blackClock.setItemMeta(blackClockMeta);
		
		ItemStack hotToaster = SkullItem.getSkull("http://textures.minecraft.net/texture/9ed6ff4d0f2fd91847a836e476acf8d4afbadf4d841e0cd48746f7347cf42");
		ItemMeta hotToasterMeta = hotToaster.getItemMeta();
		hotToasterMeta.setDisplayName(ChatColor.GOLD + "Hot Toaster");
		hotToaster.setItemMeta(hotToasterMeta);
		
		ItemStack keypad = SkullItem.getSkull("http://textures.minecraft.net/texture/b01a568eba7e453b55f15545f5e35ffab8791aacf9034afbbbe4bddb21fa50");
		ItemMeta keypadMeta = keypad.getItemMeta();
		keypadMeta.setDisplayName(ChatColor.GOLD + "Keypad");
		keypad.setItemMeta(keypadMeta);
		
		ItemStack speakers = SkullItem.getSkull("http://textures.minecraft.net/texture/2e99f669725d2358636ae2f5bc3439d667849daa8462af93a42e212af12b2a");
		ItemMeta speakersMeta = speakers.getItemMeta();
		speakersMeta.setDisplayName(ChatColor.GOLD + "Speakers");
		speakers.setItemMeta(speakersMeta);
		
		ItemStack blender = SkullItem.getSkull("http://textures.minecraft.net/texture/98636123b1a3755abd8aef6d85b2a85bf10f486edefdd1a3cef7679d825");
		ItemMeta blenderMeta = blender.getItemMeta();
		blenderMeta.setDisplayName(ChatColor.GOLD + "Blender");
		blender.setItemMeta(blenderMeta);
		
		inventory.setItem(0, blackClock);
		inventory.setItem(1, hotToaster);
		inventory.setItem(2, keypad);
		inventory.setItem(3, speakers);
		inventory.setItem(4, blender);
		
		player.openInventory(inventory);
	}
}