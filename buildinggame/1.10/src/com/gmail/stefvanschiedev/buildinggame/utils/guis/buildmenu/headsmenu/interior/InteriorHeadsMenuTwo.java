package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.interior;

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

public class InteriorHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.interior.page-2.title")));
		
		ItemStack present = SkullItem.getSkull("http://textures.minecraft.net/texture/bd7a9f6ed08dd217fdf09f4652bf6b7af621e1d5f8963605349da73998a443");
		ItemMeta presentMeta = present.getItemMeta();
		presentMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.page-2.present.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.interior.page-2.present.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			presentMeta.setLore(lores);
		}
		present.setItemMeta(presentMeta);
		
		ItemStack present2 = SkullItem.getSkull("http://textures.minecraft.net/texture/64abe81e6f4961e0f6bd82f2d4135b6b5fc845739e71cfe3b8943531d921e");
		ItemMeta present2Meta = present2.getItemMeta();
		present2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.page-2.present-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.interior.page-2.present-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			present2Meta.setLore(lores);
		}
		present2.setItemMeta(present2Meta);
		
		ItemStack cdCase = SkullItem.getSkull("http://textures.minecraft.net/texture/c2412548ebd6897e808c1fcbbf5bf7a625fe15fa48fbff4cf822b0c8e57a8");
		ItemMeta cdCaseMeta = cdCase.getItemMeta();
		cdCaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.page-2.cd-case.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.interior.page-2.cd-case.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cdCaseMeta.setLore(lores);
		}
		cdCase.setItemMeta(cdCaseMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.interior.page-2.previous-page.lores")) {
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
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.interior.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, present);
		inventory.setItem(1, present2);
		inventory.setItem(2, cdCase);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}