package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.characters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class CharactersHeadsMenuTwo {
	
	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Characters");
		
		ItemStack wheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta wheatleyMeta = wheatley.getItemMeta();
		wheatleyMeta.setDisplayName(ChatColor.GOLD + "Wheatley");
		wheatley.setItemMeta(wheatleyMeta);
		
		ItemStack wilson = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonMeta = wilson.getItemMeta();
		wilsonMeta.setDisplayName(ChatColor.GOLD + "Wilson");
		wilson.setItemMeta(wilsonMeta);
		
		ItemStack masterchief = SkullItem.getSkull("http://textures.minecraft.net/texture/b775a17c2941ae6a2a5f1840509b9ab0c0d96859a9bc249798b86f1952b0832e");
		ItemMeta masterchiefMeta = masterchief.getItemMeta();
		masterchiefMeta.setDisplayName(ChatColor.GOLD + "Masterchief");
		masterchief.setItemMeta(masterchiefMeta);
		
		ItemStack batman = SkullItem.getSkull("http://textures.minecraft.net/texture/f256f71735ef458581c9dacf394185eed9b33cb6ec5cd594a57153a8b566560");
		ItemMeta batmanMeta = batman.getItemMeta();
		batmanMeta.setDisplayName(ChatColor.GOLD + "Batman");
		batman.setItemMeta(batmanMeta);
		
		ItemStack joker = SkullItem.getSkull("http://textures.minecraft.net/texture/af4f6825ef6d5e46d794697d1bf86d144bf6fb3da4e55f7cf55271f637eaa7");
		ItemMeta jokerMeta = joker.getItemMeta();
		jokerMeta.setDisplayName(ChatColor.GOLD + "Joker");
		joker.setItemMeta(jokerMeta);
		
		ItemStack bender = SkullItem.getSkull("http://textures.minecraft.net/texture/b15fe247d9c61a6c137544de7e6220f84759e33335b0b551832fa1f8a262c23a");
		ItemMeta benderMeta = bender.getItemMeta();
		benderMeta.setDisplayName(ChatColor.GOLD + "Bender");
		bender.setItemMeta(benderMeta);
		
		ItemStack captainAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7ec527713d34c1167eed0cd1e969dbfad5d44a752154ccaf64c1c7ab6bc3f3f");
		ItemMeta captainAmericaMeta = captainAmerica.getItemMeta();
		captainAmericaMeta.setDisplayName(ChatColor.GOLD + "Captain America");
		captainAmerica.setItemMeta(captainAmericaMeta);
		
		ItemStack deadpool = SkullItem.getSkull("http://textures.minecraft.net/texture/dc15c31639e93f2bb274cf29d244a8a2906e80ab8bd2c0121c7fd1e2624d53");
		ItemMeta deadpoolMeta = deadpool.getItemMeta();
		deadpoolMeta.setDisplayName(ChatColor.GOLD + "Deadpool");
		deadpool.setItemMeta(deadpoolMeta);
		
		ItemStack doge = SkullItem.getSkull("http://textures.minecraft.net/texture/b9afb2e5f0b977c4c683e017d2b47fcd1488ab56397766e5b380405a139260");
		ItemMeta dogeMeta = doge.getItemMeta();
		dogeMeta.setDisplayName(ChatColor.GOLD + "Doge");
		doge.setItemMeta(dogeMeta);
		
		ItemStack toyFreddy = SkullItem.getSkull("http://textures.minecraft.net/texture/dc3f2e93d03294d4aa931e9967f2d5bcd2af909bfe38ee81d1bda7f682fdc3");
		ItemMeta toyFreddyMeta = toyFreddy.getItemMeta();
		toyFreddyMeta.setDisplayName(ChatColor.GOLD + "Toy Freddy");
		toyFreddy.setItemMeta(toyFreddyMeta);
		
		ItemStack toyBonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/a75dbe970d547b2561f8b658130359176246f89e74a4abdc6834155c8c4c81a");
		ItemMeta toyBonnieMeta = toyBonnie.getItemMeta();
		toyBonnieMeta.setDisplayName(ChatColor.GOLD + "Toy Bonnie");
		toyBonnie.setItemMeta(toyBonnieMeta);
		
		ItemStack goomba = SkullItem.getSkull("http://textures.minecraft.net/texture/aecf94f4bcbbf6eadcb25aa3d069aa678ebdb5241eb82e8e26889caf3275570");
		ItemMeta goombaMeta = goomba.getItemMeta();
		goombaMeta.setDisplayName(ChatColor.GOLD + "Goomba");
		goomba.setItemMeta(goombaMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(ChatColor.GREEN + "Previous Page");
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, wheatley);
		inventory.setItem(1, wilson);
		inventory.setItem(2, masterchief);
		inventory.setItem(3, batman);
		inventory.setItem(4, joker);
		inventory.setItem(5, bender);
		inventory.setItem(6, captainAmerica);
		inventory.setItem(7, deadpool);
		inventory.setItem(8, doge);
		inventory.setItem(9, toyFreddy);
		inventory.setItem(10, toyBonnie);
		inventory.setItem(11, goomba);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}