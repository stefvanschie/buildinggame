package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class CharactersHeadsMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Characters");
		
		ItemStack toyChica = SkullItem.getSkull("http://textures.minecraft.net/texture/cc37668d5eae18ba766cd5c8ebc75c48de1ba44cbe489d829a5eca8691bf556");
		ItemMeta toyChicaMeta = toyChica.getItemMeta();
		toyChicaMeta.setDisplayName(ChatColor.GOLD + "Toy Chica");
		toyChica.setItemMeta(toyChicaMeta);
		
		ItemStack zoidberg = SkullItem.getSkull("http://textures.minecraft.net/texture/8238c114b27ca9ffd6e7754fec582c7e369928283b2d7fce149eaa312bd2");
		ItemMeta zoidbergMeta = zoidberg.getItemMeta();
		zoidbergMeta.setDisplayName(ChatColor.GOLD + "Zoidberg");
		zoidberg.setItemMeta(zoidbergMeta);
		
		ItemStack ewok = SkullItem.getSkull("http://textures.minecraft.net/texture/f33eca699384f3d1fc6cd1d1ed5a8b8c34798c6568eb1844e53cbdc3598");
		ItemMeta ewokMeta = ewok.getItemMeta();
		ewokMeta.setDisplayName(ChatColor.GOLD + "Ewok");
		ewok.setItemMeta(ewokMeta);
		
		ItemStack mangle = SkullItem.getSkull("http://textures.minecraft.net/texture/4e1159e1aad239597dea98629e094654015c6ddb9ced2c9b0f3bc12d9e63af8");
		ItemMeta mangleMeta = mangle.getItemMeta();
		mangleMeta.setDisplayName(ChatColor.GOLD + "Mangle");
		mangle.setItemMeta(mangleMeta);
		
		ItemStack zelda = SkullItem.getSkull("http://textures.minecraft.net/texture/fc96a14dc1cb943b8ff3c92aacb0102c2389eedef50d36b714d0db98b27a");
		ItemMeta zeldaMeta = zelda.getItemMeta();
		zeldaMeta.setDisplayName(ChatColor.GOLD + "Zelda");
		zelda.setItemMeta(zeldaMeta);
		
		ItemStack freddyFazbear = SkullItem.getSkull("http://textures.minecraft.net/texture/ed3f3e114c631cadc8a5606021b4b4f9e15fa6ec89d3eeeb1cec825cf29b883");
		ItemMeta freddyFazbearMeta = freddyFazbear.getItemMeta();
		freddyFazbearMeta.setDisplayName(ChatColor.GOLD + "Freddy Fazbear");
		freddyFazbear.setItemMeta(freddyFazbearMeta);
		
		ItemStack bonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/2f3faca3d13e6ec373d7a28dab8959fc2b7ccce5fb617b1c563aadbb03932");
		ItemMeta bonnieMeta = bonnie.getItemMeta();
		bonnieMeta.setDisplayName(ChatColor.GOLD + "Bonnie");
		bonnie.setItemMeta(bonnieMeta);
		
		ItemStack chica = SkullItem.getSkull("http://textures.minecraft.net/texture/17a1d42ef71187577291d6ae93a4beb8b161a43bc26562201ca25152b6ff387");
		ItemMeta chicaMeta = chica.getItemMeta();
		chicaMeta.setDisplayName(ChatColor.GOLD + "Chica");
		chica.setItemMeta(chicaMeta);
		
		ItemStack foxie = SkullItem.getSkull("http://textures.minecraft.net/texture/b2812aaa954773f2ada5a2f77e32ba2f7d8d1f5d1bb4a30f86279642d3d8bb8");
		ItemMeta foxieMeta = foxie.getItemMeta();
		foxieMeta.setDisplayName(ChatColor.GOLD + "Foxie");
		foxie.setItemMeta(foxieMeta);
		
		ItemStack marionette = SkullItem.getSkull("http://textures.minecraft.net/texture/7ecae8fdd9233b82dc2f7a9445450b4a52f1c383a2417991c82ed71bf795ac1");
		ItemMeta marionetteMeta = marionette.getItemMeta();
		marionetteMeta.setDisplayName(ChatColor.GOLD + "Marionette");
		marionette.setItemMeta(marionetteMeta);
		
		ItemStack mangle2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c73ad1ebeb9b7525708a933bdae086599a8dcd66d8b414531ce63bf9953bd3e");
		ItemMeta mangle2Meta = mangle2.getItemMeta();
		mangle2Meta.setDisplayName(ChatColor.GOLD + "Mangle");
		mangle2.setItemMeta(mangle2Meta);
		
		ItemStack link = SkullItem.getSkull("http://textures.minecraft.net/texture/daa05966dbb39f780e7ea63a29560d8eb48e0c2497a818a89564a5a14a33ef");
		ItemMeta linkMeta = link.getItemMeta();
		linkMeta.setDisplayName(ChatColor.GOLD + "Link");
		link.setItemMeta(linkMeta);
		
		ItemStack stitch = SkullItem.getSkull("http://textures.minecraft.net/texture/16a8cbe9b5b656345ae034befead26b93677febc88725490416ce7babbd59f3d");
		ItemMeta stitchMeta = stitch.getItemMeta();
		stitchMeta.setDisplayName(ChatColor.GOLD + "Stitch");
		stitch.setItemMeta(stitchMeta);
		
		ItemStack groot = SkullItem.getSkull("http://textures.minecraft.net/texture/23c71a85eeb3cd6449159675aa89278a2a1d587b4d0b768174fc2e15c9be4d");
		ItemMeta grootMeta = groot.getItemMeta();
		grootMeta.setDisplayName(ChatColor.GOLD + "Groot");
		groot.setItemMeta(grootMeta);
		
		ItemStack starLord = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b81e1747b3040801069768b7cee85a32fe0ea578d7a488783c7778e72d7e7");
		ItemMeta starLordMeta = starLord.getItemMeta();
		starLordMeta.setDisplayName(ChatColor.GOLD + "Star Lord");
		starLord.setItemMeta(starLordMeta);
		
		ItemStack bobaFett = SkullItem.getSkull("http://textures.minecraft.net/texture/fbfef5e06533979d57caa4fbce260ec1e4f24174aa772f60f068a0f9ac63ee");
		ItemMeta bobaFettMeta = bobaFett.getItemMeta();
		bobaFettMeta.setDisplayName(ChatColor.GOLD + "Boba Fett");
		bobaFett.setItemMeta(bobaFettMeta);
		
		ItemStack stormTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/e32c336da84a7ba610c881aa995f9664f19dc2c40bd11449e20c6c3a3e751");
		ItemMeta stormTrooperMeta = stormTrooper.getItemMeta();
		stormTrooperMeta.setDisplayName(ChatColor.GOLD + "Storm Trooper");
		stormTrooper.setItemMeta(stormTrooperMeta);
		
		ItemStack cloneTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/77e0d72cf441cce94cce3cb3bccec6fec5f8ac2d79bc963d8b74d54a2062");
		ItemMeta cloneTrooperMeta = cloneTrooper.getItemMeta();
		cloneTrooperMeta.setDisplayName(ChatColor.GOLD + "Clone Trooper");
		cloneTrooper.setItemMeta(cloneTrooperMeta);
		
		ItemStack r2D2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7cebc97798c2e360551cab3dd5db6d53497fe63040941c9ac491a59cbf383a7a");
		ItemMeta r2D2Meta = r2D2.getItemMeta();
		r2D2Meta.setDisplayName(ChatColor.GOLD + "R2D2");
		r2D2.setItemMeta(r2D2Meta);
		
		ItemStack darthVader = SkullItem.getSkull("http://textures.minecraft.net/texture/c1c3e1f224b446ccac6a6cc3cd9891019a122f99691c3907992a3af99a21b0");
		ItemMeta darthVaderMeta = darthVader.getItemMeta();
		darthVaderMeta.setDisplayName(ChatColor.GOLD + "Darth Vader");
		darthVader.setItemMeta(darthVaderMeta);
		
		ItemStack patrick = SkullItem.getSkull("http://textures.minecraft.net/texture/b971b927729c6eace16593b33a986d61943d62f6961de6db599a818b2af32");
		ItemMeta patrickMeta = patrick.getItemMeta();
		patrickMeta.setDisplayName(ChatColor.GOLD + "Patrick");
		patrick.setItemMeta(patrickMeta);
		
		inventory.setItem(0, toyChica);
		inventory.setItem(1, zoidberg);
		inventory.setItem(2, ewok);
		inventory.setItem(3, mangle);
		inventory.setItem(4, freddyFazbear);
		inventory.setItem(5, bonnie);
		inventory.setItem(6, chica);
		inventory.setItem(7, foxie);
		inventory.setItem(8, marionette);
		inventory.setItem(9, mangle2);
		inventory.setItem(10, link);
		inventory.setItem(11, stitch);
		inventory.setItem(12, groot);
		inventory.setItem(13, starLord);
		inventory.setItem(14, bobaFett);
		inventory.setItem(15, stormTrooper);
		inventory.setItem(16, cloneTrooper);
		inventory.setItem(17, r2D2);
		inventory.setItem(18, darthVader);
		inventory.setItem(19, patrick);
	}
}