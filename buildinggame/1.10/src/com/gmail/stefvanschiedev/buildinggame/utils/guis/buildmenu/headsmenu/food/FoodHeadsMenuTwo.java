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

public class FoodHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.food.page-2.title")));
		
		ItemStack riceball = SkullItem.getSkull("http://textures.minecraft.net/texture/69c2ddf2bd74a4655e8f0153a7453e67db2a21dbfac6756789481adbec483a");
		ItemMeta riceballMeta = riceball.getItemMeta();
		riceballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.riceball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.riceball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			riceballMeta.setLore(lores);
		}
		riceball.setItemMeta(riceballMeta);
		
		ItemStack cornBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/99dfac171e3c2029676ecf8d3a0fd9b7bb2857b95efdefc59e0f252576b5c68");
		ItemMeta cornBlockMeta = cornBlock.getItemMeta();
		cornBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.corn-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.corn-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cornBlockMeta.setLore(lores);
		}
		cornBlock.setItemMeta(cornBlockMeta);
		
		ItemStack hamCheeseSandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/baee84d19c85aff796c88abda21ec4c92c655e2d67b72e5e77b5aa5e99ed");
		ItemMeta hamCheeseSandwichMeta = hamCheeseSandwich.getItemMeta();
		hamCheeseSandwichMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.ham-cheese-sandwich.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.ham-cheese-sandiwch.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hamCheeseSandwichMeta.setLore(lores);
		}
		hamCheeseSandwich.setItemMeta(hamCheeseSandwichMeta);
		
		ItemStack glassOfBeer = SkullItem.getSkull("http://textures.minecraft.net/texture/4053e26867bb57538e9789137dbbb53774e18eda6fef51cb2edf426b37264");
		ItemMeta glassOfBeerMeta = glassOfBeer.getItemMeta();
		glassOfBeerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.glass-of-beer.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.glass-of-beer.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			glassOfBeerMeta.setLore(lores);
		}
		glassOfBeer.setItemMeta(glassOfBeerMeta);
		
		ItemStack medievalBeer = SkullItem.getSkull("http://textures.minecraft.net/texture/229603d82963056be13522cfb7d4520c76ba687f396a0dab125e63b5dacea8");
		ItemMeta medievalBeerMeta = medievalBeer.getItemMeta();
		medievalBeerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.medieval-beer.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.medieval-beer.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			medievalBeerMeta.setLore(lores);
		}
		medievalBeer.setItemMeta(medievalBeerMeta);
		
		ItemStack ham = SkullItem.getSkull("http://textures.minecraft.net/texture/26336f5bb9975bf57e14db6615c1896c5c4b9c39aad17b17e4ee20b231cf6");
		ItemMeta hamMeta = ham.getItemMeta();
		hamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.ham.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.ham.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hamMeta.setLore(lores);
		}
		ham.setItemMeta(hamMeta);
		
		ItemStack mushroomStew = SkullItem.getSkull("http://textures.minecraft.net/texture/cc14144f61c4e66b3c443660debc73cb2125d0140c51b5522c8a68b789414");
		ItemMeta mushroomStewMeta = mushroomStew.getItemMeta();
		mushroomStewMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.mushroom-stew.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.mushroom-stew.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mushroomStewMeta.setLore(lores);
		}
		mushroomStew.setItemMeta(mushroomStewMeta);
		
		ItemStack sweetRoll = SkullItem.getSkull("http://textures.minecraft.net/texture/ec6eb8f15ba0d7993bf8708fa1dd86c1e8fde741a7dde9195f22891e02153");
		ItemMeta sweetRollMeta = sweetRoll.getItemMeta();
		sweetRollMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.sweet-roll.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.sweet-roll.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sweetRollMeta.setLore(lores);
		}
		sweetRoll.setItemMeta(sweetRollMeta);
		
		ItemStack iceCream = SkullItem.getSkull("http://textures.minecraft.net/texture/d8e3b53bc8fab19c6fd0f8abf13bf2303581d81691141f15973b4777e039f73");
		ItemMeta iceCreamMeta = iceCream.getItemMeta();
		iceCreamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.ice-cream.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.ice-cream.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			iceCreamMeta.setLore(lores);
		}
		iceCream.setItemMeta(iceCreamMeta);
		
		ItemStack lemon = SkullItem.getSkull("http://textures.minecraft.net/texture/957fd56ca15978779324df519354b6639a8d9bc1192c7c3de925a329baef6c");
		ItemMeta lemonMeta = lemon.getItemMeta();
		lemonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.lemon.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.lemon.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lemonMeta.setLore(lores);
		}
		lemon.setItemMeta(lemonMeta);
		
		ItemStack plum = SkullItem.getSkull("http://textures.minecraft.net/texture/5cc016f568d1433860d82fa3379d784cbbd52e56b55f78be7291f8618da38c8");
		ItemMeta plumMeta = plum.getItemMeta();
		plumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.plum.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.plum.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			plumMeta.setLore(lores);
		}
		plum.setItemMeta(plumMeta);
		
		ItemStack salad = SkullItem.getSkull("http://textures.minecraft.net/texture/1fe92e11a67b56935446a214caa3723d29e6db56c55fa8d43179a8a3176c6c1");
		ItemMeta saladMeta = salad.getItemMeta();
		saladMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.salad.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.salad.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			saladMeta.setLore(lores);
		}
		salad.setItemMeta(saladMeta);
		
		ItemStack whiteFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/d07b8c51acec2a508bb2fa652fb6e4a08b19485159a099f5982ccb88df1fe27e");
		ItemMeta whiteFrostedDonutMeta = whiteFrostedDonut.getItemMeta();
		whiteFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.white-frosted-donut.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.white-frosted-donut.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			whiteFrostedDonutMeta.setLore(lores);
		}
		whiteFrostedDonut.setItemMeta(whiteFrostedDonutMeta);
		
		ItemStack pinkFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/837c9b82b186656e9f6363a2a1c6a4b5b93cfa9ef4dad6f16b94ebb5e362678");
		ItemMeta pinkFrostedDonutMeta = pinkFrostedDonut.getItemMeta();
		pinkFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.pink-frosted-donut.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.pink-frosted-donut.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pinkFrostedDonutMeta.setLore(lores);
		}
		pinkFrostedDonut.setItemMeta(pinkFrostedDonutMeta);
		
		ItemStack chocolateFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/59da54ff366e738e31de92919986abb4d50ca944fa9926af63758b7448f18");
		ItemMeta chocolateFrostedDonutMeta = chocolateFrostedDonut.getItemMeta();
		chocolateFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.chocolate-frosted-donut.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.chocolate-frosted-donut.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chocolateFrostedDonutMeta.setLore(lores);
		}
		chocolateFrostedDonut.setItemMeta(chocolateFrostedDonutMeta);
		
		ItemStack turkey = SkullItem.getSkull("http://textures.minecraft.net/texture/f06555706b641fdaf436c07663f923afc5ee72146f90195fb337b9de766588d");
		ItemMeta turkeyMeta = turkey.getItemMeta();
		turkeyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.turkey.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.turkey.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			turkeyMeta.setLore(lores);
		}
		turkey.setItemMeta(turkeyMeta);
		
		ItemStack bentoBox = SkullItem.getSkull("http://textures.minecraft.net/texture/fe3052c535e14597a413ec32b32aafdd28686fdab6eed73030e1b94f7c38ff");
		ItemMeta bentoBoxMeta = bentoBox.getItemMeta();
		bentoBoxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.bento-box.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.bento-box.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bentoBoxMeta.setLore(lores);
		}
		bentoBox.setItemMeta(bentoBoxMeta);
		
		ItemStack coconut = SkullItem.getSkull("http://textures.minecraft.net/texture/32c62fd8e474d09940604f82712a44abb249d63aff87f998374ca849ab17412");
		ItemMeta coconutMeta = coconut.getItemMeta();
		coconutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.coconut.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.coconut.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			coconutMeta.setLore(lores);
		}
		coconut.setItemMeta(coconutMeta);
		
		ItemStack coconut2 = SkullItem.getSkull("http://textures.minecraft.net/texture/bf61259a7ed75dfc15f4328f69fa5d549ef1ba9c7aa85c53b8c76173fac3c69");
		ItemMeta coconut2Meta = coconut2.getItemMeta();
		coconut2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.coconut-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.coconut-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			coconut2Meta.setLore(lores);
		}
		coconut2.setItemMeta(coconut2Meta);
		
		ItemStack plateOfCookies = SkullItem.getSkull("http://textures.minecraft.net/texture/6368a69c94b45dd0a435de217c29cdbd433c7b447391faa33c241dc08271");
		ItemMeta plateOfCookiesMeta = plateOfCookies.getItemMeta();
		plateOfCookiesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.plate-of-cookies.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.plate-of-cookies.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			plateOfCookiesMeta.setLore(lores);
		}
		plateOfCookies.setItemMeta(plateOfCookiesMeta);
		
		ItemStack marshmallow = SkullItem.getSkull("http://textures.minecraft.net/texture/b7855166984a725becfac1eab5cfbdcbee7e426466ddc3bee4c71cfd72cb5888");
		ItemMeta marshmallowMeta = marshmallow.getItemMeta();
		marshmallowMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.marshmallow.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.marshmallow.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			marshmallowMeta.setLore(lores);
		}
		marshmallow.setItemMeta(marshmallowMeta);
		
		ItemStack hamburger = SkullItem.getSkull("http://textures.minecraft.net/texture/c5e27988a6538010efc0e24756bc3e3eea24d7536b20932c17e0404e5cc55f");
		ItemMeta hamburgerMeta = hamburger.getItemMeta();
		hamburgerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.hamburger.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.hamburger.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hamburgerMeta.setLore(lores);
		}
		hamburger.setItemMeta(hamburgerMeta);
		
		ItemStack bowlOfRice = SkullItem.getSkull("http://textures.minecraft.net/texture/c377e3d6c379fe34a2e6afabba32e7aecf77bcd31a1c3836ec354a935a7e9");
		ItemMeta bowlOfRiceMeta = bowlOfRice.getItemMeta();
		bowlOfRiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.bowl-of-rice.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.bowl-of-rice.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlOfRiceMeta.setLore(lores);
		}
		bowlOfRice.setItemMeta(bowlOfRiceMeta);
		
		ItemStack sushiRoll = SkullItem.getSkull("http://textures.minecraft.net/texture/50405181d39e76197a262be4cc6541e8e3ed24633384c873adb91dfe3901c");
		ItemMeta sushiRollMeta = sushiRoll.getItemMeta();
		sushiRollMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.sushi-roll.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.sushi-roll.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sushiRollMeta.setLore(lores);
		}
		sushiRoll.setItemMeta(sushiRollMeta);
		
		ItemStack bowlOfSpaghetti = SkullItem.getSkull("http://textures.minecraft.net/texture/347fe65eb745468e86873a1bda48a5a489fef91cc522d85e0364b55d53f867e");
		ItemMeta bowlOfSpaghettiMeta = bowlOfSpaghetti.getItemMeta();
		bowlOfSpaghettiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.bowl-of-spaghetti.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.bowl-of-spaghetti.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlOfSpaghettiMeta.setLore(lores);
		}
		bowlOfSpaghetti.setItemMeta(bowlOfSpaghettiMeta);
		
		ItemStack bowlOfNoodles = SkullItem.getSkull("http://textures.minecraft.net/texture/26834b5b25426de63538ec82ca8fbecfcbb3e682d8063643d2e67a7621bd");
		ItemMeta bowlOfNoodlesMeta = bowlOfNoodles.getItemMeta();
		bowlOfNoodlesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.bowl-of-noodles.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.bowl-of-noodles.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlOfNoodlesMeta.setLore(lores);
		}
		bowlOfNoodles.setItemMeta(bowlOfNoodlesMeta);
		
		ItemStack bowlOfNoodles2 = SkullItem.getSkull("http://textures.minecraft.net/texture/e9485663e65264a3dc30472e6a6931446bed32c2e899905facf18b2919689c1");
		ItemMeta bowlOfNoodles2Meta = bowlOfNoodles2.getItemMeta();
		bowlOfNoodles2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.bowl-of-noodles-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.bowl-of-noodles-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlOfNoodles2Meta.setLore(lores);
		}
		bowlOfNoodles2.setItemMeta(bowlOfNoodles2Meta);
		
		ItemStack chineseTakeOutBox = SkullItem.getSkull("http://textures.minecraft.net/texture/6e42286da33a238e4f27fe703fc8a087201b6940fc23744df9663fb985da024");
		ItemMeta chineseTakeOutBoxMeta = chineseTakeOutBox.getItemMeta();
		chineseTakeOutBoxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.chinese-take-out-box.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.chinese-take-out-box.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chineseTakeOutBoxMeta.setLore(lores);
		}
		chineseTakeOutBox.setItemMeta(chineseTakeOutBoxMeta);
		
		ItemStack tomato = SkullItem.getSkull("http://textures.minecraft.net/texture/99172226d276070dc21b75ba25cc2aa5649da5cac745ba977695b59aebd");
		ItemMeta tomatoMeta = tomato.getItemMeta();
		tomatoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.tomato.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.tomato.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tomatoMeta.setLore(lores);
		}
		tomato.setItemMeta(tomatoMeta);
		
		ItemStack orange = SkullItem.getSkull("http://textures.minecraft.net/texture/87b3d291d3b99bcd4c37a1839dc160d885ecd4e237b3aea1baf0adbb1775cd64");
		ItemMeta orangeMeta = orange.getItemMeta();
		orangeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.orange.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.orange.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			orangeMeta.setLore(lores);
		}
		orange.setItemMeta(orangeMeta);
		
		ItemStack greenApple = SkullItem.getSkull("http://textures.minecraft.net/texture/c4c05dd5d7a92889d8d22d4df0f1a1fe2bee3eddf192f78fc44e02e14dbf629");
		ItemMeta greenAppleMeta = greenApple.getItemMeta();
		greenAppleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.green-apple.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.green-apple.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenAppleMeta.setLore(lores);
		}
		greenApple.setItemMeta(greenAppleMeta);
		
		ItemStack lettuce = SkullItem.getSkull("http://textures.minecraft.net/texture/477dd842c975d8fb03b1add66db8377a18ba987052161f22591e6a4ede7f5");
		ItemMeta lettuceMeta = lettuce.getItemMeta();
		lettuceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.lettuce.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.lettuce.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lettuceMeta.setLore(lores);
		}
		lettuce.setItemMeta(lettuceMeta);
		
		ItemStack purpleGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/ee5935863c53a996f5334e90f55de538e83ffc5f6b0b8e83a4dc4f6e6b1208");
		ItemMeta purpleGrapesMeta = purpleGrapes.getItemMeta();
		purpleGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.purple-grapes.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.purple-grapes.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			purpleGrapesMeta.setLore(lores);
		}
		purpleGrapes.setItemMeta(purpleGrapesMeta);
		
		ItemStack greenGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/8cdcf38a8438ed3a547f8d5b47e0801559c595f0e26c45656a76b5bf8a56f");
		ItemMeta greenGrapesMeta = greenGrapes.getItemMeta();
		greenGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.green-grapes.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.green-grapes.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenGrapesMeta.setLore(lores);
		}
		greenGrapes.setItemMeta(greenGrapesMeta);
		
		ItemStack redGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/d511a5ee4d17682a25f7e8a5da6ff7cd9ad9c4844c258a6de23e7f84f27f9b4");
		ItemMeta redGrapesMeta = redGrapes.getItemMeta();
		redGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.red-grapes.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.red-grapes.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redGrapesMeta.setLore(lores);
		}
		redGrapes.setItemMeta(redGrapesMeta);
		
		ItemStack sandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/9496589fb5c1f69387b7fb17d92312058ff6e8ebeb3eb89e4f73e78196113b");
		ItemMeta sandwichMeta = sandwich.getItemMeta();
		sandwichMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.sandwich.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.sandwich.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sandwichMeta.setLore(lores);
		}
		sandwich.setItemMeta(sandwichMeta);
		
		ItemStack cherryPie = SkullItem.getSkull("http://textures.minecraft.net/texture/d53c1e87e537f1ab2774ddafb83439b336f4a777b47ad82bcb30d5fcbdf9bc");
		ItemMeta cherryPieMeta = cherryPie.getItemMeta();
		cherryPieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.cherry-pie.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.cherry-pie.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cherryPieMeta.setLore(lores);
		}
		cherryPie.setItemMeta(cherryPieMeta);
		
		ItemStack pie = SkullItem.getSkull("http://textures.minecraft.net/texture/6483912fb2a30d73361c03844611775b1c33218b3a56bded6ae792c2e439881");
		ItemMeta pieMeta = pie.getItemMeta();
		pieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.pie.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.pie.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pieMeta.setLore(lores);
		}
		pie.setItemMeta(pieMeta);
		
		ItemStack chocolateCake = SkullItem.getSkull("http://textures.minecraft.net/texture/9119fca4f28a755d37fbe5dcf6d8c3ef50fe394c1a7850bc7e2b71ee78303c4c");
		ItemMeta chocolateCakeMeta = chocolateCake.getItemMeta();
		chocolateCakeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.chocolate-cake.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.chocolate-cake.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chocolateCakeMeta.setLore(lores);
		}
		chocolateCake.setItemMeta(chocolateCakeMeta);
		
		ItemStack honeyPot = SkullItem.getSkull("http://textures.minecraft.net/texture/18c2cddeed624a538f349d8c7035fef918e6d7a1781631eac51ec182712a54da");
		ItemMeta honeyPotMeta = honeyPot.getItemMeta();
		honeyPotMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.honey-pot.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.honey-pot.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			honeyPotMeta.setLore(lores);
		}
		honeyPot.setItemMeta(honeyPotMeta);

		ItemStack pepsi = SkullItem.getSkull("http://textures.minecraft.net/texture/2bbae6df99dc82beaf49d064df74a1bbc15e8e376533276912c8c8fe59cb4f4");
		ItemMeta pepsiMeta = pepsi.getItemMeta();
		pepsiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.pepsi.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.pepsi.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pepsiMeta.setLore(lores);
		}
		pepsi.setItemMeta(pepsiMeta);

		ItemStack cocaCola = SkullItem.getSkull("http://textures.minecraft.net/texture/93b01fb2f6ba47c9d7638491f37cd8582a937731186df4d1eccd59b65bf37");
		ItemMeta cocaColaMeta = cocaCola.getItemMeta();
		cocaColaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.coca-cola.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.coca-cola.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cocaColaMeta.setLore(lores);
		}
		cocaCola.setItemMeta(cocaColaMeta);

		ItemStack sprite = SkullItem.getSkull("http://textures.minecraft.net/texture/b8a34d86a7bb13d45afdc50d3dce5eed95e1844fbdee0cca753c6d3346e339e");
		ItemMeta spriteMeta = sprite.getItemMeta();
		spriteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.sprite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.sprite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			spriteMeta.setLore(lores);
		}
		sprite.setItemMeta(spriteMeta);

		ItemStack melloYello = SkullItem.getSkull("http://textures.minecraft.net/texture/f86b51fb30b5138a4344cc3e6397da28df396241341be92121d5baeef997fb4");
		ItemMeta melloYelloMeta = melloYello.getItemMeta();
		melloYelloMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.mello-yello.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.mello-yello.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			melloYelloMeta.setLore(lores);
		}
		melloYello.setItemMeta(melloYelloMeta);

		ItemStack fanta = SkullItem.getSkull("http://textures.minecraft.net/texture/2be9505a38a14d1512c7892fc44d3d7ce6338b1bf0f9123721b121a14b095a3");
		ItemMeta fantaMeta = fanta.getItemMeta();
		fantaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.fanta.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.fanta.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			fantaMeta.setLore(lores);
		}
		fanta.setItemMeta(fantaMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.page-2.next-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.food.page-2.next-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nextMeta.setLore(lores);
		}
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 3);
		next = nextNbt.getItem();
		
		inventory.setItem(0, riceball);
		inventory.setItem(1, cornBlock);
		inventory.setItem(2, hamCheeseSandwich);
		inventory.setItem(3, glassOfBeer);
		inventory.setItem(4, medievalBeer);
		inventory.setItem(5, ham);
		inventory.setItem(6, mushroomStew);
		inventory.setItem(7, sweetRoll);
		inventory.setItem(8, iceCream);
		inventory.setItem(9, lemon);
		inventory.setItem(10, plum);
		inventory.setItem(11, salad);
		inventory.setItem(12, whiteFrostedDonut);
		inventory.setItem(13, pinkFrostedDonut);
		inventory.setItem(14, chocolateFrostedDonut);
		inventory.setItem(15, turkey);
		inventory.setItem(16, bentoBox);
		inventory.setItem(17, coconut);
		inventory.setItem(18, coconut2);
		inventory.setItem(19, plateOfCookies);
		inventory.setItem(20, marshmallow);
		inventory.setItem(21, hamburger);
		inventory.setItem(22, bowlOfRice);
		inventory.setItem(23, sushiRoll);
		inventory.setItem(24, bowlOfSpaghetti);
		inventory.setItem(25, bowlOfNoodles);
		inventory.setItem(26, bowlOfNoodles2);
		inventory.setItem(27, chineseTakeOutBox);
		inventory.setItem(28, tomato);
		inventory.setItem(29, orange);
		inventory.setItem(30, greenApple);
		inventory.setItem(31, lettuce);
		inventory.setItem(32, purpleGrapes);
		inventory.setItem(33, greenGrapes);
		inventory.setItem(34, redGrapes);
		inventory.setItem(35, sandwich);
		inventory.setItem(36, cherryPie);
		inventory.setItem(37, pie);
		inventory.setItem(38, chocolateCake);
		inventory.setItem(39, honeyPot);
		inventory.setItem(40, pepsi);
		inventory.setItem(41, cocaCola);
		inventory.setItem(42, sprite);
		inventory.setItem(43, melloYello);
		inventory.setItem(44, fanta);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}