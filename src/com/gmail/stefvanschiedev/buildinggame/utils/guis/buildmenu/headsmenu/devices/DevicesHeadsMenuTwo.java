package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.devices;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class DevicesHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.devices.page-2.title")));
		
		ItemStack hotToaster = SkullItem.getSkull("http://textures.minecraft.net/texture/9ed6ff4d0f2fd91847a836e476acf8d4afbadf4d841e0cd48746f7347cf42");
		ItemMeta hotToasterMeta = hotToaster.getItemMeta();
		hotToasterMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.hot-toaster.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.hot-toaster.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hotToasterMeta.setLore(lores);
		}
		hotToaster.setItemMeta(hotToasterMeta);
		
		ItemStack keypad = SkullItem.getSkull("http://textures.minecraft.net/texture/b01a568eba7e453b55f15545f5e35ffab8791aacf9034afbbbe4bddb21fa50");
		ItemMeta keypadMeta = keypad.getItemMeta();
		keypadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.keypad.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.keypad.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			keypadMeta.setLore(lores);
		}
		keypad.setItemMeta(keypadMeta);
		
		ItemStack speakers = SkullItem.getSkull("http://textures.minecraft.net/texture/2e99f669725d2358636ae2f5bc3439d667849daa8462af93a42e212af12b2a");
		ItemMeta speakersMeta = speakers.getItemMeta();
		speakersMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.speakers.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.speakers.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			speakersMeta.setLore(lores);
		}
		speakers.setItemMeta(speakersMeta);
		
		ItemStack blender = SkullItem.getSkull("http://textures.minecraft.net/texture/98636123b1a3755abd8aef6d85b2a85bf10f486edefdd1a3cef7679d825");
		ItemMeta blenderMeta = blender.getItemMeta();
		blenderMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.blender.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.blender.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blenderMeta.setLore(lores);
		}
		blender.setItemMeta(blenderMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, hotToaster);
		inventory.setItem(1, keypad);
		inventory.setItem(2, speakers);
		inventory.setItem(3, blender);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}