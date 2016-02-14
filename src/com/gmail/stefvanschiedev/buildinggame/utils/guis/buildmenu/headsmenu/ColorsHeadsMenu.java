package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

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
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class ColorsHeadsMenu {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.colors.page-1.title")));
		
		ItemStack skyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/c1482b755858657fb51b7d3fbf4cd8c090c05e35bd8cdba98b19499d7833acb2");
		ItemMeta skyBlueMeta = skyBlue.getItemMeta();
		skyBlueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.sky-blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.sky-blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			skyBlueMeta.setLore(lores);
		}
		skyBlue.setItemMeta(skyBlueMeta);
		
		ItemStack skyBlue2 = SkullItem.getSkull("http://textures.minecraft.net/texture/489ce89526fc12624678f305493aa65da8a1b360546a505d118eb1fad775");
		ItemMeta skyBlue2Meta = skyBlue2.getItemMeta();
		skyBlue2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.sky-blue-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.sky-blue-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			skyBlue2Meta.setLore(lores);
		}
		skyBlue2.setItemMeta(skyBlue2Meta);
		
		ItemStack babyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/7d31d21cb54294ee3a2056137d123b576f78bfc4878cd8144cd51e1931c39b5");
		ItemMeta babyBlueMeta = babyBlue.getItemMeta();
		babyBlueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.baby-blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.baby-blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			babyBlueMeta.setLore(lores);
		}
		babyBlue.setItemMeta(babyBlueMeta);
		
		ItemStack brightGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
		ItemMeta brightGreenMeta = brightGreen.getItemMeta();
		brightGreenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.bright-green.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.bright-green.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brightGreenMeta.setLore(lores);
		}
		brightGreen.setItemMeta(brightGreenMeta);
		
		ItemStack green = SkullItem.getSkull("http://textures.minecraft.net/texture/36f69f7b7538b41dc3439f3658abbd59facca366f190bcf1d6d0a026c8f96");
		ItemMeta greenMeta = green.getItemMeta();
		greenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.green.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.green.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenMeta.setLore(lores);
		}
		green.setItemMeta(greenMeta);
		
		ItemStack grassGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/c94092014d8fa7981e79029f957b6884c4c2a53a935afc36ae114d279ce58");
		ItemMeta grassGreenMeta = grassGreen.getItemMeta();
		grassGreenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.grass-green.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.grass-green.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			grassGreenMeta.setLore(lores);
		}
		grassGreen.setItemMeta(grassGreenMeta);
		
		ItemStack mediumGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/7dc61bfe3f5255c1266751173177dbd389ad80f5c16344beddf2871bf2baa2");
		ItemMeta mediumGreenMeta = mediumGreen.getItemMeta();
		mediumGreenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.medium-green.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.medium-green.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mediumGreenMeta.setLore(lores);
		}
		mediumGreen.setItemMeta(mediumGreenMeta);
		
		ItemStack darkGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/1cf3e422b322b1e9245b4b368433045c7b43c909e5dd6c792e4b6beda54303c");
		ItemMeta darkGreenMeta = darkGreen.getItemMeta();
		darkGreenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.dark-green.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.dark-green.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkGreenMeta.setLore(lores);
		}
		darkGreen.setItemMeta(darkGreenMeta);
		
		ItemStack darkYellow = SkullItem.getSkull("http://textures.minecraft.net/texture/d45b44fd19d72fb3d6e189c4978b1ca687dbd6580b18ddd8aa710edffa5");
		ItemMeta darkYellowMeta = darkYellow.getItemMeta();
		darkYellowMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.dark-yellow.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.dark-yellow.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkYellowMeta.setLore(lores);
		}
		darkYellow.setItemMeta(darkYellowMeta);
		
		ItemStack yellow = SkullItem.getSkull("http://textures.minecraft.net/texture/63e1c697e3106443976da0f53ece9d60a25bd4d4fce461951286ef59bd9091");
		ItemMeta yellowMeta = yellow.getItemMeta();
		yellowMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.yellow.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.yellow.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			yellowMeta.setLore(lores);
		}
		yellow.setItemMeta(yellowMeta);
		
		ItemStack lightOrange = SkullItem.getSkull("http://textures.minecraft.net/texture/26db6648cab054aaea7feff6518e25e4fb7d2f6f272e2502cc3177dd7836c8b");
		ItemMeta lightOrangeMeta = lightOrange.getItemMeta();
		lightOrangeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.light-orange.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.lgiht-orange.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightOrangeMeta.setLore(lores);
		}
		lightOrange.setItemMeta(lightOrangeMeta);
		
		ItemStack orange = SkullItem.getSkull("http://textures.minecraft.net/texture/fea590b681589fb9b0e8664ee945b41eb3851faf66aaf48525fba169c34270");
		ItemMeta orangeMeta = orange.getItemMeta();
		orangeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.orange.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.orange.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			orangeMeta.setLore(lores);
		}
		orange.setItemMeta(orangeMeta);
		
		ItemStack lightRed = SkullItem.getSkull("http://textures.minecraft.net/texture/4bac77520b9eee65068ef1cd8abeadb013b4de3953fd29ac68e90e4866227");
		ItemMeta lightRedMeta = lightRed.getItemMeta();
		lightRedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.light-red.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.light-red.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightRedMeta.setLore(lores);
		}
		lightRed.setItemMeta(lightRedMeta);
		
		ItemStack red = SkullItem.getSkull("http://textures.minecraft.net/texture/97c1f1ead4d531caa4a5b0d69edbce29af789a2550e5ddbd23775be05e2df2c4");
		ItemMeta redMeta = red.getItemMeta();
		redMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.red.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.red.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redMeta.setLore(lores);
		}
		red.setItemMeta(redMeta);
		
		ItemStack red2 = SkullItem.getSkull("http://textures.minecraft.net/texture/3f42564720c8e5598eff2cde218b4665f2b6aa4e59a5b4f3fd15ef875648fe");
		ItemMeta red2Meta = red2.getItemMeta();
		red2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.red-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.red-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			red2Meta.setLore(lores);
		}
		red2.setItemMeta(red2Meta);
		
		ItemStack darkRed = SkullItem.getSkull("http://textures.minecraft.net/texture/51014e4f41d7729928f215555da2eaf158ce83d9e0c9961bef5eb7613d37e");
		ItemMeta darkRedMeta = darkRed.getItemMeta();
		darkRedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.dark-red.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.dark-red.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkRedMeta.setLore(lores);
		}
		darkRed.setItemMeta(darkRedMeta);
		
		ItemStack azureBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/3b19dc4d467882dbca1b5c37465f0cfc70ff1f829ecf4a865796b8e5c2809a");
		ItemMeta azureBlueMeta = azureBlue.getItemMeta();
		azureBlueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.azure-blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.azure-blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			azureBlueMeta.setLore(lores);
		}
		azureBlue.setItemMeta(azureBlueMeta);
		
		ItemStack cyan = SkullItem.getSkull("http://textures.minecraft.net/texture/6f43d885df889c8a16e44ab4661b65fcb73fe22305cfdcc247d21767b0c24d");
		ItemMeta cyanMeta = cyan.getItemMeta();
		cyanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.cyan.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.cyan.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cyanMeta.setLore(lores);
		}
		cyan.setItemMeta(cyanMeta);
		
		ItemStack darkishBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/8d2774cbcfd7f29fc5b7e5d322846d1d9d077b2fa5fb347328cdb8944fe417");
		ItemMeta darkishBlueMeta = darkishBlue.getItemMeta();
		darkishBlueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.darkish-blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.darkish-blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkishBlueMeta.setLore(lores);
		}
		darkishBlue.setItemMeta(darkishBlueMeta);
		
		ItemStack blue = SkullItem.getSkull("http://textures.minecraft.net/texture/f2588972477e807b989983ca27a48fe27c5151b226b6204d92b4b83b9c11ed");
		ItemMeta blueMeta = blue.getItemMeta();
		blueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blueMeta.setLore(lores);
		}
		blue.setItemMeta(blueMeta);
		
		ItemStack darkCyan = SkullItem.getSkull("http://textures.minecraft.net/texture/b784c152bfc3e2e313ef23fc46d44fce41e4adad9421bac2da3894511cc03b");
		ItemMeta darkCyanMeta = darkCyan.getItemMeta();
		darkCyanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.dark-cyan.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.dark-cyan.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkCyanMeta.setLore(lores);
		}
		darkCyan.setItemMeta(darkCyanMeta);
		
		ItemStack darkBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/12306a98787e526ce973bd56124e645a2e2329d563dcfa68a1be65767f29b5");
		ItemMeta darkBlueMeta = darkBlue.getItemMeta();
		darkBlueMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.dark-blue.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.dark-blue.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			darkBlueMeta.setLore(lores);
		}
		darkBlue.setItemMeta(darkBlueMeta);
		
		ItemStack purple = SkullItem.getSkull("http://textures.minecraft.net/texture/641685f36a4e55a584964b24d668efcf3d94fad49c9ea46478f696e790c3c2");
		ItemMeta purpleMeta = purple.getItemMeta();
		purpleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.purple.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.purple.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			purpleMeta.setLore(lores);
		}
		purple.setItemMeta(purpleMeta);
		
		ItemStack pink = SkullItem.getSkull("http://textures.minecraft.net/texture/1fc25a5320f85c78dddb55fb2571f563ac48e3f53e62bbe1ffbaf6a8ff1b87");
		ItemMeta pinkMeta = pink.getItemMeta();
		pinkMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.pink.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.pink.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pinkMeta.setLore(lores);
		}
		pink.setItemMeta(pinkMeta);
		
		ItemStack magenta = SkullItem.getSkull("http://textures.minecraft.net/texture/67d52fdfbc44cac5735388c7bd9a6ef773e3c353182fa63784f1469edda921");
		ItemMeta magentaMeta = magenta.getItemMeta();
		magentaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.magenta.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.magenta.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			magentaMeta.setLore(lores);
		}
		magenta.setItemMeta(magentaMeta);
		
		ItemStack pink2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7557db5f15ca6f3701903cca402ce77ec6f885036b6812e8288abd7e94");
		ItemMeta pink2Meta = pink2.getItemMeta();
		pink2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.pink-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.pink-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pink2Meta.setLore(lores);
		}
		pink2.setItemMeta(pink2Meta);
		
		ItemStack pink3 = SkullItem.getSkull("http://textures.minecraft.net/texture/607326d31858ea57e7bc55f3e75e6c85b34ff4bfd28088f94f11eb8e0d1cf");
		ItemMeta pink3Meta = pink3.getItemMeta();
		pink3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.pink-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.pink-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pink3Meta.setLore(lores);
		}
		pink3.setItemMeta(pink3Meta);
		
		ItemStack cream = SkullItem.getSkull("http://textures.minecraft.net/texture/bf76294011cbdcd2e92941dafe6b3726dff02c3e1f84dfa57c6abab6fc33ce6");
		ItemMeta creamMeta = cream.getItemMeta();
		creamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.cream.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.cream.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			creamMeta.setLore(lores);
		}
		cream.setItemMeta(creamMeta);
		
		ItemStack mokka = SkullItem.getSkull("http://textures.minecraft.net/texture/bad5983dcabc931ab6a49d2fb8879ebc5295cb5ba2f278e3c8a3da7bc8b478");
		ItemMeta mokkaMeta = mokka.getItemMeta();
		mokkaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.mokka.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.mokka.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mokkaMeta.setLore(lores);
		}
		mokka.setItemMeta(mokkaMeta);
		
		ItemStack brown = SkullItem.getSkull("http://textures.minecraft.net/texture/4574a467737295bd9ddc82545a1a4e146a943d05ecc821f9cc6a543ffe9934a");
		ItemMeta brownMeta = brown.getItemMeta();
		brownMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.brown.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.brown.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brownMeta.setLore(lores);
		}
		brown.setItemMeta(brownMeta);
		
		ItemStack whiteBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/9fd3f28efeb068d53ba24b0324b9661b918c88f94b433dbff9a25e2f218b9");
		ItemMeta whiteBlockMeta = whiteBlock.getItemMeta();
		whiteBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.white-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.white-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			whiteBlockMeta.setLore(lores);
		}
		whiteBlock.setItemMeta(whiteBlockMeta);
		
		ItemStack lightGrey = SkullItem.getSkull("http://textures.minecraft.net/texture/31c45a59550143a44ed4e87ce2955e4a13e94cdfd4c64dee881dfb48dd92e");
		ItemMeta lightGreyMeta = lightGrey.getItemMeta();
		lightGreyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.light-grey.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.light-grey.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightGreyMeta.setLore(lores);
		}
		lightGrey.setItemMeta(lightGreyMeta);
		
		ItemStack grey = SkullItem.getSkull("http://textures.minecraft.net/texture/5e2e209b9990a63368de29bfa7b8522d54935d3c95cad9a81f4af2f3a7de");
		ItemMeta greyMeta = grey.getItemMeta();
		greyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.grey.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.grey.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greyMeta.setLore(lores);
		}
		grey.setItemMeta(greyMeta);
		
		ItemStack black = SkullItem.getSkull("http://textures.minecraft.net/texture/9ddebbb062f6a385a91ca05f18f5c0acbe33e2d06ee9e7416cef6ee43dfe2fb");
		ItemMeta blackMeta = black.getItemMeta();
		blackMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.black.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.black.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blackMeta.setLore(lores);
		}
		black.setItemMeta(blackMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.colors.page-1.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.colors.page-1.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
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