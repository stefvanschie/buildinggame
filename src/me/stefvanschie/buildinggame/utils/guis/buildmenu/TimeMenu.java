package me.stefvanschie.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TimeMenu {

	public TimeMenu() {}
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		Inventory inventory = Bukkit.createInventory(null, 18, messages.getString("gui.time.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		
		//midnight
		ItemStack midnight = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta midnightMeta = midnight.getItemMeta();
			midnightMeta.setDisplayName(messages.getString("gui.time.midnight.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> midnightLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.midnight.lores")) {
					midnightLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				midnightMeta.setLore(midnightLores);
			}
			midnight.setItemMeta(midnightMeta);
		}
		
		//2 AM
		ItemStack am2 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am2Meta = am2.getItemMeta();
			am2Meta.setDisplayName(messages.getString("gui.time.2am.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> am2Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.2am.lores")) {
					am2Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				am2Meta.setLore(am2Lores);
			}
			am2.setItemMeta(am2Meta);
		}
		
		//4 AM
		ItemStack am4 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am4Meta = am4.getItemMeta();
			am4Meta.setDisplayName(messages.getString("gui.time.4am.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> am4Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.4am.lores")) {
					am4Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				am4Meta.setLore(am4Lores);
			}
			am4.setItemMeta(am4Meta);
		}
		
		//6 AM
		ItemStack am6 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am6Meta = am6.getItemMeta();
			am6Meta.setDisplayName(messages.getString("gui.time.6am.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> am6Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.6am.lores")) {
					am6Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				am6Meta.setLore(am6Lores);
			}
			am6.setItemMeta(am6Meta);
		}
		
		//8 AM
		ItemStack am8 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am8Meta = am8.getItemMeta();
			am8Meta.setDisplayName(messages.getString("gui.time.8am.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> am8Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.8am.lores")) {
					am8Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				am8Meta.setLore(am8Lores);
			}
			am8.setItemMeta(am8Meta);
		}
		
		//10 AM
		ItemStack am10 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am10Meta = am10.getItemMeta();
			am10Meta.setDisplayName(messages.getString("gui.time.10am.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> am10Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.10am.lores")) {
					am10Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				am10Meta.setLore(am10Lores);
			}
			am10.setItemMeta(am10Meta);
		}
		
		//Midday
		ItemStack midday = new ItemStack(Material.WATCH, 1); 
		{
			ItemMeta middayMeta = midday.getItemMeta();
			middayMeta.setDisplayName(messages.getString("gui.time.midday.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> middayLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.midday.lores")) {
					middayLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				middayMeta.setLore(middayLores);
			}
			midday.setItemMeta(middayMeta);
		}
		
		//2 PM
		ItemStack pm2 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm2Meta = pm2.getItemMeta();
			pm2Meta.setDisplayName(messages.getString("gui.time.2pm.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> pm2Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.2pm.lores")) {
					pm2Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				pm2Meta.setLore(pm2Lores);
			}
			pm2.setItemMeta(pm2Meta);
		}
				
		//4 PM
		ItemStack pm4 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm4Meta = pm4.getItemMeta();
			pm4Meta.setDisplayName(messages.getString("gui.time.4pm.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> pm4Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.4pm.lores")) {
					pm4Lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				pm4Meta.setLore(pm4Lores);
			}
			pm4.setItemMeta(pm4Meta);
		}
				
		//6 PM
		ItemStack pm6 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm6Meta = pm6.getItemMeta();
			pm6Meta.setDisplayName(messages.getString("gui.time.6pm.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> pm6Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.6pm.lores")) {
					pm6Lores.add(lore
							.replaceAll("&", "§"));
				}
				pm6Meta.setLore(pm6Lores);
			}
			pm6.setItemMeta(pm6Meta);
		}
				
		//8 PM
		ItemStack pm8 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm8Meta = pm8.getItemMeta();
			pm8Meta.setDisplayName(messages.getString("gui.time.8pm.name")
					.replaceAll("&", "§"));
			{
				List<String> pm8Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.8pm.lores")) {
					pm8Lores.add(lore
							.replaceAll("&", "§"));
				}
				pm8Meta.setLore(pm8Lores);
			}
			pm8.setItemMeta(pm8Meta);
		}
				
		//10 PM
		ItemStack pm10 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm10Meta = pm10.getItemMeta();
			pm10Meta.setDisplayName(messages.getString("gui.time.10pm.name")
					.replaceAll("&", "§"));
			{
				List<String> pm10Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.10pm.lores")) {
					pm10Lores.add(lore
							.replaceAll("&", "§"));
				}
				pm10Meta.setLore(pm10Lores);
			}
			pm10.setItemMeta(pm10Meta);
		}
				
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		{
			ItemMeta backMeta = back.getItemMeta();
			backMeta.setDisplayName(messages.getString("gui.time.back.name")
					.replaceAll("&", "§"));
			{
				List<String> backLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.time.back.lores")) {
					backLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				backMeta.setLore(backLores);
			}
			back.setItemMeta(backMeta);
		}
		
		inventory.setItem(0, midnight);
		inventory.setItem(1, am2);
		inventory.setItem(2, am4);
		inventory.setItem(3, am6);
		inventory.setItem(4, am8);
		inventory.setItem(5, am10);
		inventory.setItem(6, midday);
		inventory.setItem(7, pm2);
		inventory.setItem(8, pm4);
		inventory.setItem(9, pm6);
		inventory.setItem(10, pm8);
		inventory.setItem(11, pm10);
		inventory.setItem(17, back);
		
		player.openInventory(inventory);
	}
}