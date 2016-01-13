package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class PokemonHeadsMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Pokemon");
		
		ItemStack magikarp = SkullItem.getSkull("http://textures.minecraft.net/texture/2f58fb7cbf9f8dcfc3bc9d61c7cb5b229bf49db1101336ffdc2d087c0b94162");
		ItemMeta magikarpMeta = magikarp.getItemMeta();
		magikarpMeta.setDisplayName(ChatColor.GOLD + "Magikarp");
		magikarp.setItemMeta(magikarpMeta);
		
		ItemStack squirtle = SkullItem.getSkull("http://textures.minecraft.net/texture/f53ebc976cb6771f3e95117b326842ff7812c740bece96bb8858346d841");
		ItemMeta squirtleMeta = squirtle.getItemMeta();
		squirtleMeta.setDisplayName(ChatColor.GOLD + "Squirtle");
		squirtle.setItemMeta(squirtleMeta);
		
		ItemStack unfezant = SkullItem.getSkull("http://textures.minecraft.net/texture/f1fd1c83af7e7e5221efb1f4149f7d16f5980a251f0a5d71abe36690228a");
		ItemMeta unfezantMeta = unfezant.getItemMeta();
		unfezantMeta.setDisplayName(ChatColor.GOLD + "Unfezant");
		unfezant.setItemMeta(unfezantMeta);
		
		ItemStack hydreigon = SkullItem.getSkull("http://textures.minecraft.net/texture/63975aaad2dbc317e3787bdebab9fb1eb4526b382fccdfeb181339b2154fba3");
		ItemMeta hydreigonMeta = hydreigon.getItemMeta();
		hydreigonMeta.setDisplayName(ChatColor.GOLD + "Hydreigon");
		hydreigon.setItemMeta(hydreigonMeta);
		
		ItemStack elektross = SkullItem.getSkull("http://textures.minecraft.net/texture/fe5ef634c7ee973cb04fe41e1dbb2f062b12c0726143d3bf232b2381f24b");
		ItemMeta elektrossMeta = elektross.getItemMeta();
		elektrossMeta.setDisplayName(ChatColor.GOLD + "Elektross");
		elektross.setItemMeta(elektrossMeta);
		
		ItemStack swanna = SkullItem.getSkull("http://textures.minecraft.net/texture/4c612d54332ecdaa438f21f7afd5443e91355cd1c6844f68a57bec6a93c3fa1");
		ItemMeta swannaMeta = swanna.getItemMeta();
		swannaMeta.setDisplayName(ChatColor.GOLD + "Swanna");
		swanna.setItemMeta(swannaMeta);
		
		ItemStack magmar = SkullItem.getSkull("http://textures.minecraft.net/texture/a644660e54cc1fe315a99b94e199115c54cd77cbf7c6aef2470dbef4f68f327");
		ItemMeta magmarMeta = magmar.getItemMeta();
		magmarMeta.setDisplayName(ChatColor.GOLD + "Magmar");
		magmar.setItemMeta(magmarMeta);
		
		ItemStack liepard = SkullItem.getSkull("http://textures.minecraft.net/texture/ce8524f6ac7624895bca23ae7d6777da5ac1ad0d726bf4e5684ca6fdbc2929b");
		ItemMeta liepardMeta = liepard.getItemMeta();
		liepardMeta.setDisplayName(ChatColor.GOLD + "Liepard");
		liepard.setItemMeta(liepardMeta);
		
		ItemStack lilligant = SkullItem.getSkull("http://textures.minecraft.net/texture/93e1faa993a47bda9bc7de0c693ca6c82726626bd25a7c064d7af779636a");
		ItemMeta lilligantMeta = lilligant.getItemMeta();
		lilligantMeta.setDisplayName(ChatColor.GOLD + "Lilligant");
		lilligant.setItemMeta(lilligantMeta);
		
		ItemStack bisharp = SkullItem.getSkull("http://textures.minecraft.net/texture/a5fe877042de302f88db7de2ac07cecdd3cb8b771d4c055a3723033215d5c");
		ItemMeta bisharpMeta = bisharp.getItemMeta();
		bisharpMeta.setDisplayName(ChatColor.GOLD + "Bisharp");
		bisharp.setItemMeta(bisharpMeta);
		
		ItemStack gyarados = SkullItem.getSkull("http://textures.minecraft.net/texture/1ab93af668cb83e379e9edbcdc4532f1294f90cb13de6a582efab87696c36dd");
		ItemMeta gyaradosMeta = gyarados.getItemMeta();
		gyaradosMeta.setDisplayName(ChatColor.GOLD + "Gyarados");
		gyarados.setItemMeta(gyaradosMeta);
		
		ItemStack beartic = SkullItem.getSkull("http://textures.minecraft.net/texture/7b608ed4523825a61f4baab896e38ebdbb83ee149d440b9a4e12bc9effb4a");
		ItemMeta bearticMeta = beartic.getItemMeta();
		bearticMeta.setDisplayName(ChatColor.GOLD + "Beartic");
		beartic.setItemMeta(bearticMeta);
		
		ItemStack scrafty = SkullItem.getSkull("http://textures.minecraft.net/texture/2e519598c376db51c2ddd3387829d05c3569a0c7f19c501fdc96756761ed1");
		ItemMeta scraftyMeta = scrafty.getItemMeta();
		scraftyMeta.setDisplayName(ChatColor.GOLD + "Scrafty");
		scrafty.setItemMeta(scraftyMeta);
		
		ItemStack darmanitan = SkullItem.getSkull("http://textures.minecraft.net/texture/9ebeffa46355758795a153639fc1411fdfdd91ec13c1266ce6b87585e2fc1");
		ItemMeta darmanitanMeta = darmanitan.getItemMeta();
		darmanitanMeta.setDisplayName(ChatColor.GOLD + "Darmanitan");
		darmanitan.setItemMeta(darmanitanMeta);
		
		ItemStack axew = SkullItem.getSkull("http://textures.minecraft.net/texture/d17cc1cb8492493548c90d714c23e8e71a1fcd0d47a43c11499d2c2bc422");
		ItemMeta axewMeta = axew.getItemMeta();
		axewMeta.setDisplayName(ChatColor.GOLD + "Axew");
		axew.setItemMeta(axewMeta);
		
		ItemStack nurseJoy = SkullItem.getSkull("http://textures.minecraft.net/texture/b3de38a1ceea6d9493df19a8b55bb238711cd5da4f435d2ec026376d874647");
		ItemMeta nurseJoyMeta = nurseJoy.getItemMeta();
		nurseJoyMeta.setDisplayName(ChatColor.GOLD + "Nurse Joy");
		nurseJoy.setItemMeta(nurseJoyMeta);
		
		ItemStack patrat = SkullItem.getSkull("http://textures.minecraft.net/texture/2bfe4a59b164548732fd5b754f266411969a2c2feb08a89b40a1293244abec");
		ItemMeta patratMeta = patrat.getItemMeta();
		patratMeta.setDisplayName(ChatColor.GOLD + "Patrat");
		patrat.setItemMeta(patratMeta);
		
		ItemStack throh = SkullItem.getSkull("http://textures.minecraft.net/texture/59f3acb937eea5ff447e4d45308635f6ac7923b0a504ccd2c8f671853b2edc");
		ItemMeta throhMeta = throh.getItemMeta();
		throhMeta.setDisplayName(ChatColor.GOLD + "Throh");
		throh.setItemMeta(throhMeta);
		
		ItemStack sawk = SkullItem.getSkull("http://textures.minecraft.net/texture/1ef9c1d5f3bb4b19723bdd85f219675da0fc9dec5d8ab2e94a3d9fcab2d576");
		ItemMeta sawkMeta = sawk.getItemMeta();
		sawkMeta.setDisplayName(ChatColor.GOLD + "Sawk");
		sawk.setItemMeta(sawkMeta);
		
		ItemStack zebstrika = SkullItem.getSkull("http://textures.minecraft.net/texture/34e8a47e55294eae66e250274baa15c11554c0624b633cc1d1787875e4b126");
		ItemMeta zebstrikaMeta = zebstrika.getItemMeta();
		zebstrikaMeta.setDisplayName(ChatColor.GOLD + "Zebstrika");
		zebstrika.setItemMeta(zebstrikaMeta);
		
		inventory.setItem(0, magikarp);
		inventory.setItem(1, squirtle);
		inventory.setItem(2, unfezant);
		inventory.setItem(3, hydreigon);
		inventory.setItem(4, elektross);
		inventory.setItem(5, swanna);
		inventory.setItem(6, magmar);
		inventory.setItem(7, liepard);
		inventory.setItem(8, lilligant);
		inventory.setItem(9, bisharp);
		inventory.setItem(10, gyarados);
		inventory.setItem(11, beartic);
		inventory.setItem(12, scrafty);
		inventory.setItem(13, darmanitan);
		inventory.setItem(14, axew);
		inventory.setItem(15, nurseJoy);
		inventory.setItem(16, patrat);
		inventory.setItem(17, throh);
		inventory.setItem(18, sawk);
		inventory.setItem(19, zebstrika);
	}
}