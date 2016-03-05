package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.food;

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

public class FoodHeadsMenuThree {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.food.page-3.title")));

		ItemStack mountainDew = SkullItem.getSkull("http://textures.minecraft.net/texture/86e5bf657ab897ad5e54867a4c3c2e71b2da24e7518b2f834488da76f62f5216");
		ItemMeta mountainDewMeta = mountainDew.getItemMeta();
		mountainDewMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.mountain-dew.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.mountain-dew.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mountainDewMeta.setLore(lores);
		}
		mountainDew.setItemMeta(mountainDewMeta);
		
		ItemStack tomato = SkullItem.getSkull("http://textures.minecraft.net/texture/d186863fdf3f3e2979ec6d978a088d8a4f8664c50b5b6d29ad4a7ac264a017");
		ItemMeta tomatoMeta = tomato.getItemMeta();
		tomatoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.tomato.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.tomato.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tomatoMeta.setLore(lores);
		}
		tomato.setItemMeta(tomatoMeta);
		
		ItemStack ripeTomato = SkullItem.getSkull("http://textures.minecraft.net/texture/69147172072f072483529767fe47554a95a0e0fd9b6cc531b25958a399ef3");
		ItemMeta ripeTomatoMeta = ripeTomato.getItemMeta();
		ripeTomatoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.ripe-tomato.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.ripe-tomato.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			ripeTomatoMeta.setLore(lores);
		}
		ripeTomato.setItemMeta(ripeTomatoMeta);
		
		ItemStack raspberry = SkullItem.getSkull("http://textures.minecraft.net/texture/487bde7cb6618be1c1c903f6875ea976e5733544248fd505f516a18f29235");
		ItemMeta raspberryMeta = raspberry.getItemMeta();
		raspberryMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.raspberry.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.raspberry.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			raspberryMeta.setLore(lores);
		}
		raspberry.setItemMeta(raspberryMeta);
		
		ItemStack raspberry2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b12ef1b486e97e4cb124aa7629aceb91edc51d63338c91a012885493c5d9c");
		ItemMeta raspberry2Meta = raspberry2.getItemMeta();
		raspberry2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.raspberry-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.raspberry-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			raspberry2Meta.setLore(lores);
		}
		raspberry2.setItemMeta(raspberry2Meta);
		
		ItemStack apple = SkullItem.getSkull("http://textures.minecraft.net/texture/cc9eba63a9d12cb6fde63badbe289d888f57219f4122c2820ea654fbe6350a5");
		ItemMeta appleMeta = apple.getItemMeta();
		appleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.apple.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.apple.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			appleMeta.setLore(lores);
		}
		apple.setItemMeta(appleMeta);
		
		ItemStack apple2 = SkullItem.getSkull("http://textures.minecraft.net/texture/8564797cd62664448ed028e487acd95d57075dce49a356fcc65655b2b525ddb");
		ItemMeta apple2Meta = apple2.getItemMeta();
		apple2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.apple-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.apple-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			apple2Meta.setLore(lores);
		}
		apple2.setItemMeta(apple2Meta);
		
		ItemStack apple3 = SkullItem.getSkull("http://textures.minecraft.net/texture/63e8659478dd28b1ade6ebe7d3e1d6758e219f438db784a5addeda86ed1a38a");
		ItemMeta apple3Meta = apple3.getItemMeta();
		apple3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.apple-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.apple-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			apple3Meta.setLore(lores);
		}
		apple3.setItemMeta(apple3Meta);
		
		ItemStack apple4 = SkullItem.getSkull("http://textures.minecraft.net/texture/2fb0e221fd81b98b8b569b3522d5231cf8b367732f37b381e7acea29a6e84");
		ItemMeta apple4Meta = apple4.getItemMeta();
		apple4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.apple-4.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.apple-4.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			apple4Meta.setLore(lores);
		}
		apple4.setItemMeta(apple4Meta);
		
		ItemStack apple5 = SkullItem.getSkull("http://textures.minecraft.net/texture/e2b35bda5ebdf135f4e71ce49726fbec5739f0adedf01c519e2aea7f51951ea2");
		ItemMeta apple5Meta = apple5.getItemMeta();
		apple5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.apple-5.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.apple-5.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			apple5Meta.setLore(lores);
		}
		apple5.setItemMeta(apple5Meta);
		
		ItemStack cookedShrimp = SkullItem.getSkull("http://textures.minecraft.net/texture/336a9add25645bfcc377c25ef0c2e9901d19493c3e981ebc6ba7a1a1b6466ce4");
		ItemMeta cookedShrimpMeta = cookedShrimp.getItemMeta();
		cookedShrimpMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.cooked-shrimp.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.cooked-shrimp.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cookedShrimpMeta.setLore(lores);
		}
		cookedShrimp.setItemMeta(cookedShrimpMeta);
		
		ItemStack sushiSalmon = SkullItem.getSkull("http://textures.minecraft.net/texture/ae9d22d9ada63e281420ae33691880869fa1a14bfdf87d8e538e998a8f29595b");
		ItemMeta sushiSalmonMeta = sushiSalmon.getItemMeta();
		sushiSalmonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.sushi-salmon.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.sushi-salmon.name")) {
				lores.add(MessageManager.translate(lore));
			}
			sushiSalmonMeta.setLore(lores);
		}
		sushiSalmon.setItemMeta(sushiSalmonMeta);
		
		ItemStack sushi = SkullItem.getSkull("http://textures.minecraft.net/texture/cb82d3c9eedc718c07519254f7921a59ff3a6f245939665c9cb017112ce670");
		ItemMeta sushiMeta = sushi.getItemMeta();
		sushiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.sushi.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.sushi.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sushiMeta.setLore(lores);
		}
		sushi.setItemMeta(sushiMeta);
		
		ItemStack sushi2 = SkullItem.getSkull("http://textures.minecraft.net/texture/23ca3f926e7a9ab9555fecb69a802743c122d9efc565a2fe5545118fa91d1");
		ItemMeta sushi2Meta = sushi2.getItemMeta();
		sushi2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.sushi-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.sushi-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sushi2Meta.setLore(lores);
		}
		sushi2.setItemMeta(sushi2Meta);
		
		ItemStack plasticCup = SkullItem.getSkull("http://textures.minecraft.net/texture/9179ce4849723434e84747ec85fbbfb1121456c8aeb2e9171fb8328921d45");
		ItemMeta plasticCupMeta = plasticCup.getItemMeta();
		plasticCupMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.plastic-cup.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.plastic-cup.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			plasticCupMeta.setLore(lores);
		}
		plasticCup.setItemMeta(plasticCupMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 2);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-3.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-3.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, mountainDew);
		inventory.setItem(1, tomato);
		inventory.setItem(2, ripeTomato);
		inventory.setItem(3, raspberry);
		inventory.setItem(4, raspberry2);
		inventory.setItem(5, apple);
		inventory.setItem(6, apple2);
		inventory.setItem(7, apple3);
		inventory.setItem(8, apple4);
		inventory.setItem(9, apple5);
		inventory.setItem(10, cookedShrimp);
		inventory.setItem(11, sushiSalmon);
		inventory.setItem(12, sushi);
		inventory.setItem(13, sushi2);
		inventory.setItem(14, plasticCup);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}