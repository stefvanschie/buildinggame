package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpeedMenu {

	public SpeedMenu() {}
	
	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 18, ChatColor.GRAY + "Fly speed selection");
		
		//fly speed 1
		ItemStack speed1 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed1Meta = speed1.getItemMeta();
			speed1Meta.setDisplayName(ChatColor.GREEN + "Fly speed 1");
			{
				List<String> speed1Lores = new ArrayList<String>();
				speed1Lores.add(ChatColor.GRAY + "Set your fly speed to 1");
				if (player.getFlySpeed() == (float) 0.1) {
					speed1Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				speed1Meta.setLore(speed1Lores);
			}
			speed1.setItemMeta(speed1Meta);
		}
		
		//fly speed 2
		ItemStack speed2 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed2Meta = speed2.getItemMeta();
			speed2Meta.setDisplayName(ChatColor.GREEN + "Fly speed 2");
			{
				List<String> speed2Lores = new ArrayList<String>();
				speed2Lores.add(ChatColor.GRAY + "Set your fly speed to 2");
				if (player.getFlySpeed() == (float) 0.2) {
					speed2Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				speed2Meta.setLore(speed2Lores);
			}
			speed2.setItemMeta(speed2Meta);
		}
		
		//fly speed 3
		ItemStack speed3 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed3Meta = speed3.getItemMeta();
			speed3Meta.setDisplayName(ChatColor.GREEN + "Fly speed 3");
			{
				List<String> speed3Lores = new ArrayList<String>();
				speed3Lores.add(ChatColor.GRAY + "Set your fly speed to 3");
				if (player.getFlySpeed() == (float) 0.3) {
					speed3Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				speed3Meta.setLore(speed3Lores);
			}
			speed3.setItemMeta(speed3Meta);
		}
		
		//fly speed 4
		ItemStack speed4 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed4Meta = speed4.getItemMeta();
			speed4Meta.setDisplayName(ChatColor.GREEN + "Fly speed 4");
			{
				List<String> speed4Lores = new ArrayList<String>();
				speed4Lores.add(ChatColor.GRAY + "Set your fly speed to 4");
				if (player.getFlySpeed() == (float) 0.4) {
					speed4Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				speed4Meta.setLore(speed4Lores);
			}
			speed4.setItemMeta(speed4Meta);
		}
		
		//fly speed 5
		ItemStack speed5 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed5Meta = speed5.getItemMeta();
			speed5Meta.setDisplayName(ChatColor.GREEN + "Fly speed 5");
			{
				List<String> speed5Lores = new ArrayList<String>();
				speed5Lores.add(ChatColor.GRAY + "Set your fly speed to 5");
				if (player.getFlySpeed() == (float) 0.5) {
					speed5Lores.add(ChatColor.GOLD + "Currently selected!");
				}
				speed5Meta.setLore(speed5Lores);
			}
			speed5.setItemMeta(speed5Meta);
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
		
		inventory.setItem(2, speed1);
		inventory.setItem(3, speed2);
		inventory.setItem(4, speed3);
		inventory.setItem(5, speed4);
		inventory.setItem(6, speed5);
		inventory.setItem(17, back);
		
		player.openInventory(inventory);
	}
	
}
