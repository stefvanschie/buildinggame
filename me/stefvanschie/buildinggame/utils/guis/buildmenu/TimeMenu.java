package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.Time;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TimeMenu {

	public TimeMenu() {}
	
	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Time selection");
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		//midnight
		ItemStack midnight = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta midnightMeta = midnight.getItemMeta();
			midnightMeta.setDisplayName(ChatColor.GREEN + "Midnight");
			{
				List<String> midnightLores = new ArrayList<String>();
				midnightLores.add(ChatColor.GRAY + "Set the time of your build to Midnight");
				if (plot.getTime() == Time.MIDNIGHT) {
					midnightLores.add(ChatColor.GOLD + "Currently selected!");
				}
				midnightMeta.setLore(midnightLores);
			}
			midnight.setItemMeta(midnightMeta);
		}
		
		//2 AM
		ItemStack am2 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am2Meta = am2.getItemMeta();
			am2Meta.setDisplayName(ChatColor.GREEN + "2 AM");
			{
				List<String> am2Lores = new ArrayList<String>();
				am2Lores.add(ChatColor.GRAY + "Set the time of your build to 2 AM");
				if (plot.getTime() == Time.AM2) {
					am2Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				am2Meta.setLore(am2Lores);
			}
			am2.setItemMeta(am2Meta);
		}
		
		//4 AM
		ItemStack am4 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am4Meta = am4.getItemMeta();
			am4Meta.setDisplayName(ChatColor.GREEN + "4 AM");
			{
				List<String> am4Lores = new ArrayList<String>();
				am4Lores.add(ChatColor.GRAY + "Set the time of your build to 4 AM");
				if (plot.getTime() == Time.AM4) {
					am4Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				am4Meta.setLore(am4Lores);
			}
			am4.setItemMeta(am4Meta);
		}
		
		//6 AM
		ItemStack am6 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am6Meta = am6.getItemMeta();
			am6Meta.setDisplayName(ChatColor.GREEN + "6 AM");
			{
				List<String> am6Lores = new ArrayList<String>();
				am6Lores.add(ChatColor.GRAY + "Set the time of your build to 6 AM");
				if (plot.getTime() == Time.AM6) {
					am6Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				am6Meta.setLore(am6Lores);
			}
			am6.setItemMeta(am6Meta);
		}
		
		//8 AM
		ItemStack am8 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am8Meta = am8.getItemMeta();
			am8Meta.setDisplayName(ChatColor.GREEN + "8 AM");
			{
				List<String> am8Lores = new ArrayList<String>();
				am8Lores.add(ChatColor.GRAY + "Set the time of your build to 8 AM");
				if (plot.getTime() == Time.AM8) {
					am8Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				am8Meta.setLore(am8Lores);
			}
			am8.setItemMeta(am8Meta);
		}
		
		//10 AM
		ItemStack am10 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta am10Meta = am10.getItemMeta();
			am10Meta.setDisplayName(ChatColor.GREEN + "10 AM");
			{
				List<String> am10Lores = new ArrayList<String>();
				am10Lores.add(ChatColor.GRAY + "Set the time of your build to 10 AM");
				if (plot.getTime() == Time.AM10) {
					am10Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				am10Meta.setLore(am10Lores);
			}
			am10.setItemMeta(am10Meta);
		}
		
		//Midday
		ItemStack midday = new ItemStack(Material.WATCH, 1); 
		{
			ItemMeta middayMeta = midday.getItemMeta();
			middayMeta.setDisplayName(ChatColor.GREEN + "Midday");
			{
				List<String> middayLores = new ArrayList<String>();
				middayLores.add(ChatColor.GRAY + "Set the time of your build to Midday");
				if (plot.getTime() == Time.MIDDAY) {
					middayLores.add(ChatColor.GOLD + "Currently selected!");
				}
				middayMeta.setLore(middayLores);
			}
			midday.setItemMeta(middayMeta);
		}
		
		//2 PM
		ItemStack pm2 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm2Meta = pm2.getItemMeta();
			pm2Meta.setDisplayName(ChatColor.GREEN + "2 PM");
			{
				List<String> pm2Lores = new ArrayList<String>();
				pm2Lores.add(ChatColor.GRAY + "Set the time of your build to 2 PM");
				if (plot.getTime() == Time.PM2) {
					pm2Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				pm2Meta.setLore(pm2Lores);
			}
			pm2.setItemMeta(pm2Meta);
		}
				
		//4 PM
		ItemStack pm4 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm4Meta = pm4.getItemMeta();
			pm4Meta.setDisplayName(ChatColor.GREEN + "4 PM");
			{
				List<String> pm4Lores = new ArrayList<String>();
				pm4Lores.add(ChatColor.GRAY + "Set the time of your build to 4 PM");
				if (plot.getTime() == Time.PM4) {
					pm4Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				pm4Meta.setLore(pm4Lores);
			}
			pm4.setItemMeta(pm4Meta);
		}
				
		//6 PM
		ItemStack pm6 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm6Meta = pm6.getItemMeta();
			pm6Meta.setDisplayName(ChatColor.GREEN + "6 PM");
			{
				List<String> pm6Lores = new ArrayList<String>();
				pm6Lores.add(ChatColor.GRAY + "Set the time of your build to 6 PM");
				if (plot.getTime() == Time.PM6) {
					pm6Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				pm6Meta.setLore(pm6Lores);
			}
			pm6.setItemMeta(pm6Meta);
		}
				
		//8 PM
		ItemStack pm8 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm8Meta = pm8.getItemMeta();
			pm8Meta.setDisplayName(ChatColor.GREEN + "8 PM");
			{
				List<String> pm8Lores = new ArrayList<String>();
				pm8Lores.add(ChatColor.GRAY + "Set the time of your build to 8 PM");
				if (plot.getTime() == Time.PM8) {
					pm8Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				pm8Meta.setLore(pm8Lores);
			}
			pm8.setItemMeta(pm8Meta);
		}
				
		//10 PM
		ItemStack pm10 = new ItemStack(Material.WATCH, 1);
		{
			ItemMeta pm10Meta = pm10.getItemMeta();
			pm10Meta.setDisplayName(ChatColor.GREEN + "10 PM");
			{
				List<String> pm10Lores = new ArrayList<String>();
				pm10Lores.add(ChatColor.GRAY + "Set the time of your build to 10 PM");
				if (plot.getTime() == Time.PM10) {
					pm10Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				pm10Meta.setLore(pm10Lores);
			}
			pm10.setItemMeta(pm10Meta);
		}
				
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		{
			ItemMeta backMeta = back.getItemMeta();
			backMeta.setDisplayName(ChatColor.GREEN + "Back");
			{
				List<String> backLores = new ArrayList<String>();
				backLores.add(ChatColor.GRAY + "Go back to the options menu");
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
