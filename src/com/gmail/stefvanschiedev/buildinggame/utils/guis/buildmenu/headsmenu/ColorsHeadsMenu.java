package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class ColorsHeadsMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Colors");
		
		ItemStack skyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/c1482b755858657fb51b7d3fbf4cd8c090c05e35bd8cdba98b19499d7833acb2");
		ItemMeta skyBlueMeta = skyBlue.getItemMeta();
		skyBlueMeta.setDisplayName(ChatColor.GOLD + "Sky Blue");
		skyBlue.setItemMeta(skyBlueMeta);
		
		ItemStack skyBlue2 = SkullItem.getSkull("http://textures.minecraft.net/texture/489ce89526fc12624678f305493aa65da8a1b360546a505d118eb1fad775");
		ItemMeta skyBlue2Meta = skyBlue2.getItemMeta();
		skyBlue2Meta.setDisplayName(ChatColor.GOLD + "Sky Blue");
		skyBlue2.setItemMeta(skyBlue2Meta);
		
		ItemStack babyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/7d31d21cb54294ee3a2056137d123b576f78bfc4878cd8144cd51e1931c39b5");
		ItemMeta babyBlueMeta = babyBlue.getItemMeta();
		babyBlueMeta.setDisplayName(ChatColor.GOLD + "Baby Blue");
		babyBlue.setItemMeta(babyBlueMeta);
		
		ItemStack brightGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
		ItemMeta brightGreenMeta = brightGreen.getItemMeta();
		brightGreenMeta.setDisplayName(ChatColor.GOLD + "Bright Green");
		brightGreen.setItemMeta(brightGreenMeta);
		
		ItemStack green = SkullItem.getSkull("http://textures.minecraft.net/texture/36f69f7b7538b41dc3439f3658abbd59facca366f190bcf1d6d0a026c8f96");
		ItemMeta greenMeta = green.getItemMeta();
		greenMeta.setDisplayName(ChatColor.GREEN + "Green");
		green.setItemMeta(greenMeta);
		
		ItemStack grassGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/c94092014d8fa7981e79029f957b6884c4c2a53a935afc36ae114d279ce58");
		ItemMeta grassGreenMeta = grassGreen.getItemMeta();
		grassGreenMeta.setDisplayName(ChatColor.GOLD + "Grass Green");
		grassGreen.setItemMeta(grassGreenMeta);
		
		ItemStack mediumGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/7dc61bfe3f5255c1266751173177dbd389ad80f5c16344beddf2871bf2baa2");
		ItemMeta mediumGreenMeta = mediumGreen.getItemMeta();
		mediumGreenMeta.setDisplayName(ChatColor.GOLD + "Medium Green");
		mediumGreen.setItemMeta(mediumGreenMeta);
		
		ItemStack darkGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/1cf3e422b322b1e9245b4b368433045c7b43c909e5dd6c792e4b6beda54303c");
		ItemMeta darkGreenMeta = darkGreen.getItemMeta();
		darkGreenMeta.setDisplayName(ChatColor.GOLD + "Dark Green");
		darkGreen.setItemMeta(darkGreenMeta);
		
		ItemStack darkYellow = SkullItem.getSkull("http://textures.minecraft.net/texture/d45b44fd19d72fb3d6e189c4978b1ca687dbd6580b18ddd8aa710edffa5");
		ItemMeta darkYellowMeta = darkYellow.getItemMeta();
		darkYellowMeta.setDisplayName(ChatColor.GOLD + "Dark Yellow");
		darkYellow.setItemMeta(darkYellowMeta);
		
		ItemStack yellow = SkullItem.getSkull("http://textures.minecraft.net/texture/63e1c697e3106443976da0f53ece9d60a25bd4d4fce461951286ef59bd9091");
		ItemMeta yellowMeta = yellow.getItemMeta();
		yellowMeta.setDisplayName(ChatColor.GOLD + "Yellow");
		yellow.setItemMeta(yellowMeta);
		
		ItemStack lightOrange = SkullItem.getSkull("http://textures.minecraft.net/texture/26db6648cab054aaea7feff6518e25e4fb7d2f6f272e2502cc3177dd7836c8b");
		ItemMeta lightOrangeMeta = lightOrange.getItemMeta();
		lightOrangeMeta.setDisplayName(ChatColor.GOLD + "Light Orange");
		lightOrange.setItemMeta(lightOrangeMeta);
		
		ItemStack orange = SkullItem.getSkull("http://textures.minecraft.net/texture/fea590b681589fb9b0e8664ee945b41eb3851faf66aaf48525fba169c34270");
		ItemMeta orangeMeta = orange.getItemMeta();
		orangeMeta.setDisplayName(ChatColor.GOLD + "Orange");
		orange.setItemMeta(orangeMeta);
		
		ItemStack lightRed = SkullItem.getSkull("http://textures.minecraft.net/texture/4bac77520b9eee65068ef1cd8abeadb013b4de3953fd29ac68e90e4866227");
		ItemMeta lightRedMeta = lightRed.getItemMeta();
		lightRedMeta.setDisplayName(ChatColor.GOLD + "Light Red");
		lightRed.setItemMeta(lightRedMeta);
		
		ItemStack red = SkullItem.getSkull("http://textures.minecraft.net/texture/97c1f1ead4d531caa4a5b0d69edbce29af789a2550e5ddbd23775be05e2df2c4");
		ItemMeta redMeta = red.getItemMeta();
		redMeta.setDisplayName(ChatColor.GOLD + "Red");
		red.setItemMeta(redMeta);
		
		ItemStack red2 = SkullItem.getSkull("http://textures.minecraft.net/texture/3f42564720c8e5598eff2cde218b4665f2b6aa4e59a5b4f3fd15ef875648fe");
		ItemMeta red2Meta = red2.getItemMeta();
		red2Meta.setDisplayName(ChatColor.GOLD + "Red");
		red2.setItemMeta(red2Meta);
		
		ItemStack darkRed = SkullItem.getSkull("http://textures.minecraft.net/texture/51014e4f41d7729928f215555da2eaf158ce83d9e0c9961bef5eb7613d37e");
		ItemMeta darkRedMeta = darkRed.getItemMeta();
		darkRedMeta.setDisplayName(ChatColor.GOLD + "Dark Red");
		darkRed.setItemMeta(darkRedMeta);
		
		ItemStack azureBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/3b19dc4d467882dbca1b5c37465f0cfc70ff1f829ecf4a865796b8e5c2809a");
		ItemMeta azureBlueMeta = azureBlue.getItemMeta();
		azureBlueMeta.setDisplayName(ChatColor.GOLD + "Azure Blue");
		azureBlue.setItemMeta(azureBlueMeta);
		
		ItemStack cyan = SkullItem.getSkull("http://textures.minecraft.net/texture/6f43d885df889c8a16e44ab4661b65fcb73fe22305cfdcc247d21767b0c24d");
		ItemMeta cyanMeta = cyan.getItemMeta();
		cyanMeta.setDisplayName(ChatColor.GOLD + "Cyan");
		cyan.setItemMeta(cyanMeta);
		
		ItemStack darkishBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/8d2774cbcfd7f29fc5b7e5d322846d1d9d077b2fa5fb347328cdb8944fe417");
		ItemMeta darkishBlueMeta = darkishBlue.getItemMeta();
		darkishBlueMeta.setDisplayName(ChatColor.GOLD + "Darkish Blue");
		darkishBlue.setItemMeta(darkishBlueMeta);
		
		ItemStack blue = SkullItem.getSkull("http://textures.minecraft.net/texture/f2588972477e807b989983ca27a48fe27c5151b226b6204d92b4b83b9c11ed");
		ItemMeta blueMeta = blue.getItemMeta();
		blueMeta.setDisplayName(ChatColor.GOLD + "Blue");
		blue.setItemMeta(blueMeta);
		
		ItemStack darkCyan = SkullItem.getSkull("http://textures.minecraft.net/texture/b784c152bfc3e2e313ef23fc46d44fce41e4adad9421bac2da3894511cc03b");
		ItemMeta darkCyanMeta = darkCyan.getItemMeta();
		darkCyanMeta.setDisplayName(ChatColor.GOLD + "Dark Cyan");
		darkCyan.setItemMeta(darkCyanMeta);
		
		ItemStack darkBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/12306a98787e526ce973bd56124e645a2e2329d563dcfa68a1be65767f29b5");
		ItemMeta darkBlueMeta = darkBlue.getItemMeta();
		darkBlueMeta.setDisplayName(ChatColor.GOLD + "Dark Blue");
		darkBlue.setItemMeta(darkBlueMeta);
		
		ItemStack purple = SkullItem.getSkull("http://textures.minecraft.net/texture/641685f36a4e55a584964b24d668efcf3d94fad49c9ea46478f696e790c3c2");
		ItemMeta purpleMeta = purple.getItemMeta();
		purpleMeta.setDisplayName(ChatColor.GOLD + "Purple");
		purple.setItemMeta(purpleMeta);
		
		ItemStack pink = SkullItem.getSkull("http://textures.minecraft.net/texture/1fc25a5320f85c78dddb55fb2571f563ac48e3f53e62bbe1ffbaf6a8ff1b87");
		ItemMeta pinkMeta = pink.getItemMeta();
		pinkMeta.setDisplayName(ChatColor.GOLD + "Pink");
		pink.setItemMeta(pinkMeta);
		
		ItemStack magenta = SkullItem.getSkull("http://textures.minecraft.net/texture/67d52fdfbc44cac5735388c7bd9a6ef773e3c353182fa63784f1469edda921");
		ItemMeta magentaMeta = magenta.getItemMeta();
		magentaMeta.setDisplayName(ChatColor.GOLD + "Magenta");
		magenta.setItemMeta(magentaMeta);
		
		ItemStack pink2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7557db5f15ca6f3701903cca402ce77ec6f885036b6812e8288abd7e94");
		ItemMeta pink2Meta = pink2.getItemMeta();
		pink2Meta.setDisplayName(ChatColor.GOLD + "Pink");
		pink2.setItemMeta(pink2Meta);
		
		ItemStack pink3 = SkullItem.getSkull("http://textures.minecraft.net/texture/607326d31858ea57e7bc55f3e75e6c85b34ff4bfd28088f94f11eb8e0d1cf");
		ItemMeta pink3Meta = pink3.getItemMeta();
		pink3Meta.setDisplayName(ChatColor.GOLD + "Pink");
		pink3.setItemMeta(pink3Meta);
		
		ItemStack cream = SkullItem.getSkull("http://textures.minecraft.net/texture/bf76294011cbdcd2e92941dafe6b3726dff02c3e1f84dfa57c6abab6fc33ce6");
		ItemMeta creamMeta = cream.getItemMeta();
		creamMeta.setDisplayName(ChatColor.GOLD + "Cream");
		cream.setItemMeta(creamMeta);
		
		ItemStack mokka = SkullItem.getSkull("http://textures.minecraft.net/texture/bad5983dcabc931ab6a49d2fb8879ebc5295cb5ba2f278e3c8a3da7bc8b478");
		ItemMeta mokkaMeta = mokka.getItemMeta();
		mokkaMeta.setDisplayName(ChatColor.GOLD + "Mokka");
		mokka.setItemMeta(mokkaMeta);
		
		ItemStack brown = SkullItem.getSkull("http://textures.minecraft.net/texture/4574a467737295bd9ddc82545a1a4e146a943d05ecc821f9cc6a543ffe9934a");
		ItemMeta brownMeta = brown.getItemMeta();
		brownMeta.setDisplayName(ChatColor.GOLD + "Brown");
		brown.setItemMeta(brownMeta);
		
		ItemStack whiteBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/9fd3f28efeb068d53ba24b0324b9661b918c88f94b433dbff9a25e2f218b9");
		ItemMeta whiteBlockMeta = whiteBlock.getItemMeta();
		whiteBlockMeta.setDisplayName(ChatColor.GOLD + "White Block");
		whiteBlock.setItemMeta(whiteBlockMeta);
		
		ItemStack lightGrey = SkullItem.getSkull("http://textures.minecraft.net/texture/31c45a59550143a44ed4e87ce2955e4a13e94cdfd4c64dee881dfb48dd92e");
		ItemMeta lightGreyMeta = lightGrey.getItemMeta();
		lightGreyMeta.setDisplayName(ChatColor.GOLD + "Light Grey");
		lightGrey.setItemMeta(lightGreyMeta);
		
		ItemStack grey = SkullItem.getSkull("http://textures.minecraft.net/texture/5e2e209b9990a63368de29bfa7b8522d54935d3c95cad9a81f4af2f3a7de");
		ItemMeta greyMeta = grey.getItemMeta();
		greyMeta.setDisplayName(ChatColor.GOLD + "Grey");
		grey.setItemMeta(greyMeta);
		
		ItemStack black = SkullItem.getSkull("http://textures.minecraft.net/texture/9ddebbb062f6a385a91ca05f18f5c0acbe33e2d06ee9e7416cef6ee43dfe2fb");
		ItemMeta blackMeta = black.getItemMeta();
		blackMeta.setDisplayName(ChatColor.GOLD + "Black");
		black.setItemMeta(blackMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, skyBlue);
		inventory.setItem(1, skyBlue2);
		inventory.setItem(2, babyBlue);
		inventory.setItem(3, brightGreen);
		inventory.setItem(4, green);
		inventory.setItem(5, grassGreen);
		inventory.setItem(6, mediumGreen);
		inventory.setItem(7, darkGreen);
		inventory.setItem(8, darkYellow);
		inventory.setItem(9, yellow);
		inventory.setItem(10, lightOrange);
		inventory.setItem(11, orange);
		inventory.setItem(12, lightRed);
		inventory.setItem(13, red);
		inventory.setItem(14, darkRed);
		inventory.setItem(15, azureBlue);
		inventory.setItem(16, cyan);
		inventory.setItem(17, darkishBlue);
		inventory.setItem(18, blue);
		inventory.setItem(19, darkCyan);
		inventory.setItem(20, darkBlue);
		inventory.setItem(21, purple);
		inventory.setItem(22, pink);
		inventory.setItem(23, magenta);
		inventory.setItem(24, pink2);
		inventory.setItem(25, pink3);
		inventory.setItem(26, cream);
		inventory.setItem(27, mokka);
		inventory.setItem(28, brown);
		inventory.setItem(29, whiteBlock);
		inventory.setItem(30, lightGrey);
		inventory.setItem(31, grey);
		inventory.setItem(32, black);
		
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}