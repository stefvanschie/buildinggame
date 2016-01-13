package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class HeadsMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 45, ChatColor.GREEN + "Heads");
		
		ItemStack food = SkullItem.getSkull("http://textures.minecraft.net/texture/edf410fdf212964a5606ca0a1b47730922775ca7f9763e5aea9a3ab449b6ec");
		ItemMeta foodMeta = food.getItemMeta();
		foodMeta.setDisplayName(ChatColor.GOLD + "Food");
		food.setItemMeta(foodMeta);

		ItemStack devices = SkullItem.getSkull("http://textures.minecraft.net/texture/15c292a24f54a7a43785266552dba7a184f9c50e0d94b337d8d3e76e9e9cce7");
		ItemMeta devicesMeta = devices.getItemMeta();
		devicesMeta.setDisplayName(ChatColor.GOLD + "Devices");
		devices.setItemMeta(devicesMeta);
		
		ItemStack misc = SkullItem.getSkull("http://textures.minecraft.net/texture/86793bac4a1f974142ef8916642710949d7e38f87aebd380742ccc374f1de1");
		ItemMeta miscMeta = misc.getItemMeta();
		miscMeta.setDisplayName(ChatColor.GOLD + "Misc");
		misc.setItemMeta(miscMeta);
		
		ItemStack alphabet = SkullItem.getSkull("http://textures.minecraft.net/texture/acb419d984d8796373c9646233c7a02664bd2ce3a1d3476dd9b1c5463b14ebe");
		ItemMeta alphabetMeta = alphabet.getItemMeta();
		alphabetMeta.setDisplayName(ChatColor.GOLD + "Alphabet");
		alphabet.setItemMeta(alphabetMeta);
		
		ItemStack interior = SkullItem.getSkull("http://textures.minecraft.net/texture/7acc61666adf1e4cd7cf57af3e1e17ba17310b2fcd8e3ed27cf88b7d0d88518");
		ItemMeta interiorMeta = interior.getItemMeta();
		interiorMeta.setDisplayName(ChatColor.GOLD + "Interior");
		interior.setItemMeta(interiorMeta);
		
		ItemStack color = SkullItem.getSkull("http://textures.minecraft.net/texture/d45b44fd19d72fb3d6e189c4978b1ca687dbd6580b18ddd8aa710edffa5");
		ItemMeta colorMeta = color.getItemMeta();
		colorMeta.setDisplayName(ChatColor.GOLD + "Color");
		color.setItemMeta(colorMeta);
		
		ItemStack blocks = SkullItem.getSkull("http://textures.minecraft.net/texture/c60b2f9145215a3a5065dca2d89bb8b4ca44b9222dd22060b51c38d9bf587");
		ItemMeta blocksMeta = blocks.getItemMeta();
		blocksMeta.setDisplayName(ChatColor.GOLD + "Blocks");
		blocks.setItemMeta(blocksMeta);
		
		ItemStack mobs = SkullItem.getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
		ItemMeta mobsMeta = mobs.getItemMeta();
		mobsMeta.setDisplayName(ChatColor.GOLD + "Mobs");
		mobs.setItemMeta(mobsMeta);
		
		ItemStack games = SkullItem.getSkull("http://textures.minecraft.net/texture/6c82e21a9320953d78daee85477de3bb82d5dfa6b19494d37733265d2d030a8");
		ItemMeta gamesMeta = games.getItemMeta();
		gamesMeta.setDisplayName(ChatColor.GOLD + "Games");
		games.setItemMeta(gamesMeta);
		
		ItemStack characters = SkullItem.getSkull("http://textures.minecraft.net/texture/71be29750ddec80994bda79653e21ed70d5b2eb793da51d5a87b89bf67dcb96");
		ItemMeta charactersMeta = characters.getItemMeta();
		charactersMeta.setDisplayName(ChatColor.GOLD + "Characters");
		characters.setItemMeta(charactersMeta);
		
		ItemStack pokemon = SkullItem.getSkull("http://textures.minecraft.net/texture/222bc95af0557a5940462025f253e9494cfcc56c5ff405e18805d133a87efd2");
		ItemMeta pokemonMeta = pokemon.getItemMeta();
		pokemonMeta.setDisplayName(ChatColor.GOLD + "Pokemon");
		pokemon.setItemMeta(pokemonMeta);
		
		inventory.setItem(10, food);
		inventory.setItem(12, devices);
		inventory.setItem(14, misc);
		inventory.setItem(16, alphabet);
		inventory.setItem(20, interior);
		inventory.setItem(22, color);
		inventory.setItem(24, blocks);
		inventory.setItem(28, mobs);
		inventory.setItem(30, games);
		inventory.setItem(32, characters);
		inventory.setItem(34, pokemon);
		
		player.openInventory(inventory);
	}
}