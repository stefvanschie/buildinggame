package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.food;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class FoodHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Food");
		
		ItemStack nutella = SkullItem.getSkull("http://textures.minecraft.net/texture/515dcb2da02cf734829e1e273e3025617d8071516f953251b52545da8d3e8db8");
		ItemMeta nutellaMeta = nutella.getItemMeta();
		nutellaMeta.setDisplayName(ChatColor.GOLD + "Nutella");
		nutella.setItemMeta(nutellaMeta);
		
		ItemStack vegemite = SkullItem.getSkull("http://textures.minecraft.net/texture/ae8890874a3066f426e66e37438f45ab29a5bf2582db73cb4cff6954a578ef");
		ItemMeta vegemiteMeta = vegemite.getItemMeta();
		vegemiteMeta.setDisplayName(ChatColor.GOLD + "Vegemite");
		vegemite.setItemMeta(vegemiteMeta);
		
		ItemStack bread = SkullItem.getSkull("http://textures.minecraft.net/texture/f3487d457f9062d787a3e6ce1c4664bf7402ec67dd111256f19b38ce4f670");
		ItemMeta breadMeta = bread.getItemMeta();
		breadMeta.setDisplayName(ChatColor.GOLD + "Bread");
		bread.setItemMeta(breadMeta);
		
		ItemStack cheese = SkullItem.getSkull("http://textures.minecraft.net/texture/955d611a878e821231749b2965708cad942650672db09e26847a88e2fac2946");
		ItemMeta cheeseMeta = cheese.getItemMeta();
		cheeseMeta.setDisplayName(ChatColor.GOLD + "Cheese");
		cheese.setItemMeta(cheeseMeta);
		
		ItemStack strawberryJam = SkullItem.getSkull("http://textures.minecraft.net/texture/c0b8b5889ee1c6388dc6c2c5dbd70b6984aefe54319a095e64db7638097b821");
		ItemMeta strawberryJamMeta = strawberryJam.getItemMeta();
		strawberryJamMeta.setDisplayName(ChatColor.GOLD + "Strawberry Jam");
		strawberryJam.setItemMeta(strawberryJamMeta);
		
		ItemStack pancakes = SkullItem.getSkull("http://textures.minecraft.net/texture/347f4f5a74c6691280cd80e7148b49b2ce17dcf64fd55368627f5d92a976a6a8");
		ItemMeta pancakesMeta = pancakes.getItemMeta();
		pancakesMeta.setDisplayName(ChatColor.GOLD + "Pancakes");
		pancakes.setItemMeta(pancakesMeta);
		
		ItemStack cake = SkullItem.getSkull("http://textures.minecraft.net/texture/f9136514f342e7c5208a1422506a866158ef84d2b249220139e8bf6032e193");
		ItemMeta cakeMeta = cake.getItemMeta();
		cakeMeta.setDisplayName(ChatColor.GOLD + "Cake");
		cake.setItemMeta(cakeMeta);
		
		ItemStack cake2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4561ded8d8385b913a091aef4783fccbfd3d38edd90b2e89b723b5a57434bf4");
		ItemMeta cake2Meta = cake2.getItemMeta();
		cake2Meta.setDisplayName(ChatColor.GOLD + "Cake");
		cake2.setItemMeta(cake2Meta);
		
		ItemStack canOfSoup = SkullItem.getSkull("http://textures.minecraft.net/texture/fc91f9507b48b6f719714fbaba77cf68534aa5b728371b11866d55ff833a7f");
		ItemMeta canOfSoupMeta = canOfSoup.getItemMeta();
		canOfSoupMeta.setDisplayName(ChatColor.GOLD + "Can of Soup");
		canOfSoup.setItemMeta(canOfSoupMeta);
		
		ItemStack cupOfMilk = SkullItem.getSkull("http://textures.minecraft.net/texture/d7ab62fb77189352541dd95a8ee7e3631f7c1658f463f661680c283493d8a");
		ItemMeta cupOfMilkMeta = cupOfMilk.getItemMeta();
		cupOfMilkMeta.setDisplayName(ChatColor.GOLD + "Cup of Milk");
		cupOfMilk.setItemMeta(cupOfMilkMeta);
		
		ItemStack chocolateMuffin = SkullItem.getSkull("http://textures.minecraft.net/texture/83794c736fc76e45706830325b95969466d86f8d7b28fce8edb2c75e2ab25c");
		ItemMeta chocolateMuffinMeta = chocolateMuffin.getItemMeta();
		chocolateMuffinMeta.setDisplayName(ChatColor.GOLD + "Chocolate Muffin");
		chocolateMuffin.setItemMeta(chocolateMuffinMeta);
		
		ItemStack muffin = SkullItem.getSkull("http://textures.minecraft.net/texture/343216b3ad2f4757a23c3a24cdaf8ce87bc421d4b6e8bc2ce642aa4803e99");
		ItemMeta muffinMeta = muffin.getItemMeta();
		muffinMeta.setDisplayName(ChatColor.GOLD + "Muffin");
		muffin.setItemMeta(muffinMeta);
		
		ItemStack oreoSandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/dfd71e20fc50abf0de2ef7decfc01ce27ad51955759e072ceaab96355f594f0");
		ItemMeta oreoSandwichMeta = oreoSandwich.getItemMeta();
		oreoSandwichMeta.setDisplayName(ChatColor.GOLD + "Oreo Sandwich");
		oreoSandwich.setItemMeta(oreoSandwichMeta);
		
		ItemStack cookie = SkullItem.getSkull("http://textures.minecraft.net/texture/b592cf9f42a5a8c995968493fdd1b11e0b69aad6473ff45384abe58b7fc7c7");
		ItemMeta cookieMeta = cookie.getItemMeta();
		cookieMeta.setDisplayName(ChatColor.GOLD + "Cookie");
		cookie.setItemMeta(cookieMeta);
		
		ItemStack candyCane = SkullItem.getSkull("http://textures.minecraft.net/texture/4cc3f781c923a2887f14c1eea11050166966f2602578401f1451e6097b979df");
		ItemMeta candyCaneMeta = candyCane.getItemMeta();
		candyCaneMeta.setDisplayName(ChatColor.GOLD + "Candy Cane");
		candyCane.setItemMeta(candyCaneMeta);
		
		ItemStack chocolatebar = SkullItem.getSkull("http://textures.minecraft.net/texture/819f948d17718adace5dd6e050c586229653fef645d7113ab94d17b639cc466");
		ItemMeta chocolatebarMeta = chocolatebar.getItemMeta();
		chocolatebarMeta.setDisplayName(ChatColor.GOLD + "Chocolatebar");
		chocolatebar.setItemMeta(chocolatebarMeta);
		
		ItemStack chocolatebar2 = SkullItem.getSkull("http://textures.minecraft.net/texture/1ed55260dccc8da59338c75e41d544a2e1e7dbef31a69fe42c01b3298bf2d");
		ItemMeta chocolatebar2Meta = chocolatebar2.getItemMeta();
		chocolatebar2Meta.setDisplayName(ChatColor.GOLD + "Chocolatebar");
		chocolatebar2.setItemMeta(chocolatebar2Meta);
		
		ItemStack slicedLemonCitrusFruit = SkullItem.getSkull("http://textures.minecraft.net/texture/edf410fdf212964a5606ca0a1b47730922775ca7f9763e5aea9a3ab449b6ec");
		ItemMeta slicedLemonCitrusFruitMeta = slicedLemonCitrusFruit.getItemMeta();
		slicedLemonCitrusFruitMeta.setDisplayName(ChatColor.GOLD + "Sliced Lemon (Citrus Fruit)");
		slicedLemonCitrusFruit.setItemMeta(slicedLemonCitrusFruitMeta);
		
		ItemStack cherry = SkullItem.getSkull("http://textures.minecraft.net/texture/d525707696bcd15a173056fa39296e80ff41168bb0add552f4523e2558a3119");
		ItemMeta cherryMeta = cherry.getItemMeta();
		cherryMeta.setDisplayName(ChatColor.GOLD + "Cherry");
		cherry.setItemMeta(cherryMeta);
		
		ItemStack apple = SkullItem.getSkull("http://textures.minecraft.net/texture/cbb311f3ba1c07c3d1147cd210d81fe11fd8ae9e3db212a0fa748946c3633");
		ItemMeta appleMeta = apple.getItemMeta();
		appleMeta.setDisplayName(ChatColor.GOLD + "Apple");
		apple.setItemMeta(appleMeta);
		
		ItemStack melon = SkullItem.getSkull("http://textures.minecraft.net/texture/c3fed514c3e238ca7ac1c94b897ff6711b1dbe50174afc235c8f80d029");
		ItemMeta melonMeta = melon.getItemMeta();
		melonMeta.setDisplayName(ChatColor.GOLD + "Melon");
		melon.setItemMeta(melonMeta);
		
		ItemStack melon2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7e96cedc8b5683bea01673936b6ea96fe948a2b6cb444dc29e1fcff4d2e2cf4");
		ItemMeta melon2Meta = melon2.getItemMeta();
		melon2Meta.setDisplayName(ChatColor.GOLD + "Melon");
		melon2.setItemMeta(melon2Meta);
		
		ItemStack melon3 = SkullItem.getSkull("http://textures.minecraft.net/texture/241412b8c6fd57e4e162166ddfd74b148a596f9eb1d1593c0469638c8d714");
		ItemMeta melon3Meta = melon3.getItemMeta();
		melon3Meta.setDisplayName(ChatColor.GOLD + "Melon");
		melon3.setItemMeta(melon3Meta);
		
		ItemStack melon4 = SkullItem.getSkull("http://textures.minecraft.net/texture/f3903066ccc4695e113fee314c96a544eb919622eee7daa1d1966374f3fe848");
		ItemMeta melon4Meta = melon4.getItemMeta();
		melon4Meta.setDisplayName(ChatColor.GOLD + "Melon");
		melon4.setItemMeta(melon4Meta);
		
		ItemStack carvedPumpkin = SkullItem.getSkull("http://textures.minecraft.net/texture/fec415d702f3292a82f1471c8794cf63122d449d28ab886d4dc58fafd66");
		ItemMeta carvedPumpkinMeta = carvedPumpkin.getItemMeta();
		carvedPumpkinMeta.setDisplayName(ChatColor.GOLD + "Carved Pumpkin");
		carvedPumpkin.setItemMeta(carvedPumpkinMeta);
		
		ItemStack pumpkin = SkullItem.getSkull("http://textures.minecraft.net/texture/d7d7ad2dcb57dfa9f023dbb99b698fc53075c3e9d654506139a647ac907fddc5");
		ItemMeta pumpkinMeta = pumpkin.getItemMeta();
		pumpkinMeta.setDisplayName(ChatColor.GOLD + "Pumpkin");
		pumpkin.setItemMeta(pumpkinMeta);
		
		ItemStack strawberry = SkullItem.getSkull("http://textures.minecraft.net/texture/cbc826aaafb8dbf67881e68944414f13985064a3f8f044d8edfb4443e76ba");
		ItemMeta strawberryMeta = strawberry.getItemMeta();
		strawberryMeta.setDisplayName(ChatColor.GOLD + "Strawberry");
		strawberry.setItemMeta(strawberryMeta);
		
		ItemStack coconut = SkullItem.getSkull("http://textures.minecraft.net/texture/e9b0e969cf3fcced36b712350ffb46d8ed761fe5efb10e3b6a9795e6656da97");
		ItemMeta coconutMeta = coconut.getItemMeta();
		coconutMeta.setDisplayName(ChatColor.GOLD + "Coconut");
		coconut.setItemMeta(coconutMeta);
		
		ItemStack carrot = SkullItem.getSkull("http://textures.minecraft.net/texture/3063513ecb1a91bbb3481fabd1dc3ac4f131d1c74f61c226df4194812cf3c312");
		ItemMeta carrotMeta = carrot.getItemMeta();
		carrotMeta.setDisplayName(ChatColor.GOLD + "Carrot");
		carrot.setItemMeta(carrotMeta);
		
		ItemStack sugarcane = SkullItem.getSkull("http://textures.minecraft.net/texture/33ca9d8b1d5f2c26547644034a55a4a2463e166f60feb0c7c5af3f724bae");
		ItemMeta sugarcaneMeta = sugarcane.getItemMeta();
		sugarcaneMeta.setDisplayName(ChatColor.GOLD + "Sugarcane");
		sugarcane.setItemMeta(sugarcaneMeta);
		
		ItemStack hotChocolate = SkullItem.getSkull("http://textures.minecraft.net/texture/411511bdd55bcb82803c8039f1c155fd43062636e23d4d46c4d761c04d22c2");
		ItemMeta hotChocolateMeta = hotChocolate.getItemMeta();
		hotChocolateMeta.setDisplayName(ChatColor.GOLD + "Hot Chocolate");
		hotChocolate.setItemMeta(hotChocolateMeta);
		
		ItemStack cupOfTea = SkullItem.getSkull("http://textures.minecraft.net/texture/d8e94ddd769a5bea748376b4ec7383fd36d267894d7c3bee011e8e4f5fcd7");
		ItemMeta cupOfTeaMeta = cupOfTea.getItemMeta();
		cupOfTeaMeta.setDisplayName(ChatColor.GOLD + "Cup of Tea");
		cupOfTea.setItemMeta(cupOfTeaMeta);
		
		ItemStack taco = SkullItem.getSkull("http://textures.minecraft.net/texture/98ced74a22021a535f6bce21c8c632b273dc2d9552b71a38d57269b3538cf");
		ItemMeta tacoMeta = taco.getItemMeta();
		tacoMeta.setDisplayName(ChatColor.GOLD + "Taco");
		taco.setItemMeta(tacoMeta);
		
		ItemStack taco2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ea1f3585f54849b41da5d326a943956a25494364bb961d2458c430be9a6b27");
		ItemMeta taco2Meta = taco2.getItemMeta();
		taco2Meta.setDisplayName(ChatColor.GOLD + "Taco");
		taco2.setItemMeta(taco2Meta);
		
		ItemStack bakedPotatoe = SkullItem.getSkull("http://textures.minecraft.net/texture/6f312a243aa4e69a5edc67e54e44f76eb84f66ec824089557a64bea71f6dc");
		ItemMeta bakedPotatoeMeta = bakedPotatoe.getItemMeta();
		bakedPotatoeMeta.setDisplayName(ChatColor.GOLD + "Baked Potatoe");
		bakedPotatoe.setItemMeta(bakedPotatoeMeta);
		
		ItemStack bacon = SkullItem.getSkull("http://textures.minecraft.net/texture/e7ba22d5df21e821a6de4b8c9d373a3aa187d8ae74f288a82d2b61f272e5");
		ItemMeta baconMeta = bacon.getItemMeta();
		baconMeta.setDisplayName(ChatColor.GOLD + "Bacon");
		bacon.setItemMeta(baconMeta);
		
		ItemStack fries = SkullItem.getSkull("http://textures.minecraft.net/texture/a0eacac41a9eaf051376ef2f959701e1bbe1bf4aa6715adc34b6dc29a13ea9");
		ItemMeta friesMeta = fries.getItemMeta();
		friesMeta.setDisplayName(ChatColor.GOLD + "Fries");
		fries.setItemMeta(friesMeta);
		
		ItemStack hamburger = SkullItem.getSkull("http://textures.minecraft.net/texture/a6ef1c25f516f2e7d6f7667420e33adcf3cdf938cb37f9a41a8b35869f569b");
		ItemMeta hamburgerMeta = hamburger.getItemMeta();
		hamburgerMeta.setDisplayName(ChatColor.GOLD + "Hamburger");
		hamburger.setItemMeta(hamburgerMeta);
		
		ItemStack hamburger2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b0e38c176dbf7df9b0632c256eeb6c5aaca99e1c8c1a530656eaff0417aed22");
		ItemMeta hamburger2Meta = hamburger2.getItemMeta();
		hamburger2Meta.setDisplayName(ChatColor.GOLD + "Hamburger");
		hamburger2.setItemMeta(hamburger2Meta);
		
		ItemStack hamburger3 = SkullItem.getSkull("http://textures.minecraft.net/texture/cdadf1744433e1c79d1d59d2777d939de159a24cf57e8a61c82bc4fe3777553c");
		ItemMeta hamburger3Meta = hamburger3.getItemMeta();
		hamburger3Meta.setDisplayName(ChatColor.GOLD + "Hamburger");
		hamburger3.setItemMeta(hamburger3Meta);
		
		ItemStack popcorn = SkullItem.getSkull("http://textures.minecraft.net/texture/1497b147cfae52205597f72e3c4ef52512e9677020e4b4fa7512c3c6acdd8c1");
		ItemMeta popcornMeta = popcorn.getItemMeta();
		popcornMeta.setDisplayName(ChatColor.GOLD + "Popcorn");
		popcorn.setItemMeta(popcornMeta);

		ItemStack glassOfCocaCola = SkullItem.getSkull("http://textures.minecraft.net/texture/e9b41e9fe543f2375d0a97dd5922e4d65b8a523baf2265d42398d64c364ef95");
		ItemMeta glassOfCocaColaMeta = glassOfCocaCola.getItemMeta();
		glassOfCocaColaMeta.setDisplayName(ChatColor.GOLD + "Glass of Coca-Cola");
		glassOfCocaCola.setItemMeta(glassOfCocaColaMeta);
		
		ItemStack sushiMackerel = SkullItem.getSkull("http://textures.minecraft.net/texture/846d3172e7d6ad6df6a2189755ce0b2dc85a1f9ccd109dc932985867ba6");
		ItemMeta sushiMackerelMeta = sushiMackerel.getItemMeta();
		sushiMackerelMeta.setDisplayName(ChatColor.GOLD + "Sushi Mackerel");
		sushiMackerel.setItemMeta(sushiMackerelMeta);
		
		ItemStack sushiSalmon = SkullItem.getSkull("http://textures.minecraft.net/texture/23bf8fca2af3592c5574b13e3bcf61e2fae829788535f0ddeaa7a2e45b6ba4");
		ItemMeta sushiSalmonMeta = sushiSalmon.getItemMeta();
		sushiSalmonMeta.setDisplayName(ChatColor.GOLD + "Sushi Salmon");
		sushiSalmon.setItemMeta(sushiSalmonMeta);
		
		ItemStack sushiRoll = SkullItem.getSkull("http://textures.minecraft.net/texture/2e12f267953e76ae66a8dd025a3286aecbc64b4ad98eeb10b3c67a69aae15");
		ItemMeta sushiRollMeta = sushiRoll.getItemMeta();
		sushiRollMeta.setDisplayName(ChatColor.GOLD + "Sushi Roll");
		sushiRoll.setItemMeta(sushiRollMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(ChatColor.GREEN + "Next Page");
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
		inventory.setItem(0, nutella);
		inventory.setItem(1, vegemite);
		inventory.setItem(2, bread);
		inventory.setItem(3, cheese);
		inventory.setItem(4, strawberryJam);
		inventory.setItem(5, pancakes);
		inventory.setItem(6, cake);
		inventory.setItem(7, cake2);
		inventory.setItem(8, canOfSoup);
		inventory.setItem(9, cupOfMilk);
		inventory.setItem(10, chocolateMuffin);
		inventory.setItem(11, muffin);
		inventory.setItem(12, oreoSandwich);
		inventory.setItem(13, cookie);
		inventory.setItem(14, candyCane);
		inventory.setItem(15, chocolatebar);
		inventory.setItem(16, chocolatebar2);
		inventory.setItem(17, slicedLemonCitrusFruit);
		inventory.setItem(18, cherry);
		inventory.setItem(19, apple);
		inventory.setItem(20, melon);
		inventory.setItem(21, melon2);
		inventory.setItem(22, melon3);
		inventory.setItem(23, melon4);
		inventory.setItem(24, carvedPumpkin);
		inventory.setItem(25, pumpkin);
		inventory.setItem(26, strawberry);
		inventory.setItem(27, coconut);
		inventory.setItem(28, carrot);
		inventory.setItem(29, sugarcane);
		inventory.setItem(30, hotChocolate);
		inventory.setItem(31, cupOfTea);
		inventory.setItem(32, taco);
		inventory.setItem(33, taco2);
		inventory.setItem(34, bakedPotatoe);
		inventory.setItem(35, bacon);
		inventory.setItem(36, fries);
		inventory.setItem(37, hamburger);
		inventory.setItem(38, hamburger2);
		inventory.setItem(39, hamburger3);
		inventory.setItem(40, popcorn);
		inventory.setItem(41, glassOfCocaCola);
		inventory.setItem(42, sushiMackerel);
		inventory.setItem(43, sushiSalmon);
		inventory.setItem(44, sushiRoll);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}