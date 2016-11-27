package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class FoodHeadsMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public FoodHeadsMenu() {
		super(null, 54, MessageManager.translate(messages.getString("gui.heads.food.title")), 3);
		
		//page one
		ItemStack nutella = SkullItem.getSkull("http://textures.minecraft.net/texture/515dcb2da02cf734829e1e273e3025617d8071516f953251b52545da8d3e8db8");
		ItemMeta nutellaMeta = nutella.getItemMeta();
		nutellaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.nutella.name")));
		nutellaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.nutella.lores")));
		nutella.setItemMeta(nutellaMeta);
		
		addItem(nutella, new Action());
		
		ItemStack vegemite = SkullItem.getSkull("http://textures.minecraft.net/texture/ae8890874a3066f426e66e37438f45ab29a5bf2582db73cb4cff6954a578ef");
		ItemMeta vegemiteMeta = vegemite.getItemMeta();
		vegemiteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.vegemite.name")));
		vegemiteMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.vegemite.lores")));
		vegemite.setItemMeta(vegemiteMeta);
		
		addItem(vegemite, new Action());
		
		ItemStack bread = SkullItem.getSkull("http://textures.minecraft.net/texture/f3487d457f9062d787a3e6ce1c4664bf7402ec67dd111256f19b38ce4f670");
		ItemMeta breadMeta = bread.getItemMeta();
		breadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bread.name")));
		breadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bread.lores")));
		bread.setItemMeta(breadMeta);
		
		addItem(bread, new Action());
		
		ItemStack cheese = SkullItem.getSkull("http://textures.minecraft.net/texture/955d611a878e821231749b2965708cad942650672db09e26847a88e2fac2946");
		ItemMeta cheeseMeta = cheese.getItemMeta();
		cheeseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cheese.name")));
		cheeseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cheese.lores")));
		cheese.setItemMeta(cheeseMeta);
		
		addItem(cheese, new Action());
		
		ItemStack strawberryJam = SkullItem.getSkull("http://textures.minecraft.net/texture/c0b8b5889ee1c6388dc6c2c5dbd70b6984aefe54319a095e64db7638097b821");
		ItemMeta strawberryJamMeta = strawberryJam.getItemMeta();
		strawberryJamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.strawberry-jam.name")));
		strawberryJamMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.strawberry-jam.lores")));
		strawberryJam.setItemMeta(strawberryJamMeta);
		
		addItem(strawberryJam, new Action());
		
		ItemStack pancakes = SkullItem.getSkull("http://textures.minecraft.net/texture/347f4f5a74c6691280cd80e7148b49b2ce17dcf64fd55368627f5d92a976a6a8");
		ItemMeta pancakesMeta = pancakes.getItemMeta();
		pancakesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.pancakes.name")));
		pancakesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.pancakes.lores")));
		pancakes.setItemMeta(pancakesMeta);
		
		addItem(pancakes, new Action());
		
		ItemStack cake = SkullItem.getSkull("http://textures.minecraft.net/texture/f9136514f342e7c5208a1422506a866158ef84d2b249220139e8bf6032e193");
		ItemMeta cakeMeta = cake.getItemMeta();
		cakeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cake.name")));
		cakeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cake.lores")));
		cake.setItemMeta(cakeMeta);
		
		addItem(cake, new Action());
		
		ItemStack cake2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4561ded8d8385b913a091aef4783fccbfd3d38edd90b2e89b723b5a57434bf4");
		ItemMeta cake2Meta = cake2.getItemMeta();
		cake2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cake-2.name")));
		cake2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cake-2.lores")));
		cake2.setItemMeta(cake2Meta);
		
		addItem(cake2, new Action());
		
		ItemStack canOfSoup = SkullItem.getSkull("http://textures.minecraft.net/texture/fc91f9507b48b6f719714fbaba77cf68534aa5b728371b11866d55ff833a7f");
		ItemMeta canOfSoupMeta = canOfSoup.getItemMeta();
		canOfSoupMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.can-of-soup.name")));
		canOfSoupMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.can-of-soup.lores")));
		canOfSoup.setItemMeta(canOfSoupMeta);
		
		addItem(canOfSoup, new Action());
		
		ItemStack cupOfMilk = SkullItem.getSkull("http://textures.minecraft.net/texture/d7ab62fb77189352541dd95a8ee7e3631f7c1658f463f661680c283493d8a");
		ItemMeta cupOfMilkMeta = cupOfMilk.getItemMeta();
		cupOfMilkMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cup-of-milk.name")));
		cupOfMilkMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cup-of-milk.lores")));
		cupOfMilk.setItemMeta(cupOfMilkMeta);
		
		addItem(cupOfMilk, new Action());
		
		ItemStack chocolateMuffin = SkullItem.getSkull("http://textures.minecraft.net/texture/83794c736fc76e45706830325b95969466d86f8d7b28fce8edb2c75e2ab25c");
		ItemMeta chocolateMuffinMeta = chocolateMuffin.getItemMeta();
		chocolateMuffinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chocolate-muffin.name")));
		chocolateMuffinMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chocolate-muffin.lores")));
		chocolateMuffin.setItemMeta(chocolateMuffinMeta);
		
		addItem(chocolateMuffin, new Action());
		
		ItemStack muffin = SkullItem.getSkull("http://textures.minecraft.net/texture/343216b3ad2f4757a23c3a24cdaf8ce87bc421d4b6e8bc2ce642aa4803e99");
		ItemMeta muffinMeta = muffin.getItemMeta();
		muffinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.muffin.name")));
		muffinMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.muffin.lores")));
		muffin.setItemMeta(muffinMeta);
		
		addItem(muffin, new Action());
		
		ItemStack oreoSandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/dfd71e20fc50abf0de2ef7decfc01ce27ad51955759e072ceaab96355f594f0");
		ItemMeta oreoSandwichMeta = oreoSandwich.getItemMeta();
		oreoSandwichMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.oreo-sandwich.name")));
		oreoSandwichMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.oreo-sandwich.lores")));
		oreoSandwich.setItemMeta(oreoSandwichMeta);
		
		addItem(oreoSandwich, new Action());
		
		ItemStack cookie = SkullItem.getSkull("http://textures.minecraft.net/texture/b592cf9f42a5a8c995968493fdd1b11e0b69aad6473ff45384abe58b7fc7c7");
		ItemMeta cookieMeta = cookie.getItemMeta();
		cookieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cookie.name")));
		cookieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cookie.lores")));
		cookie.setItemMeta(cookieMeta);
		
		addItem(cookie, new Action());
		
		ItemStack candyCane = SkullItem.getSkull("http://textures.minecraft.net/texture/4cc3f781c923a2887f14c1eea11050166966f2602578401f1451e6097b979df");
		ItemMeta candyCaneMeta = candyCane.getItemMeta();
		candyCaneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.candy-cane.name")));
		candyCaneMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.candy-cane.lores")));
		candyCane.setItemMeta(candyCaneMeta);
		
		addItem(candyCane, new Action());
		
		ItemStack chocolatebar = SkullItem.getSkull("http://textures.minecraft.net/texture/819f948d17718adace5dd6e050c586229653fef645d7113ab94d17b639cc466");
		ItemMeta chocolatebarMeta = chocolatebar.getItemMeta();
		chocolatebarMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chocolatebar.name")));
		chocolatebarMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chocolatebar.lores")));
		chocolatebar.setItemMeta(chocolatebarMeta);
		
		addItem(chocolatebar, new Action());
		
		ItemStack chocolatebar2 = SkullItem.getSkull("http://textures.minecraft.net/texture/1ed55260dccc8da59338c75e41d544a2e1e7dbef31a69fe42c01b3298bf2d");
		ItemMeta chocolatebar2Meta = chocolatebar2.getItemMeta();
		chocolatebar2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chocolatebar-2.name")));
		chocolatebar2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chocolatebar-2.lores")));
		chocolatebar2.setItemMeta(chocolatebar2Meta);
		
		addItem(chocolatebar2, new Action());
		
		ItemStack slicedLemonCitrusFruit = SkullItem.getSkull("http://textures.minecraft.net/texture/edf410fdf212964a5606ca0a1b47730922775ca7f9763e5aea9a3ab449b6ec");
		ItemMeta slicedLemonCitrusFruitMeta = slicedLemonCitrusFruit.getItemMeta();
		slicedLemonCitrusFruitMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sliced-lemon-citrus-fruit.name")));
		slicedLemonCitrusFruitMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sliced-lemon-citrus-fruit.lores")));
		slicedLemonCitrusFruit.setItemMeta(slicedLemonCitrusFruitMeta);
		
		addItem(slicedLemonCitrusFruit, new Action());
		
		ItemStack cherry = SkullItem.getSkull("http://textures.minecraft.net/texture/d525707696bcd15a173056fa39296e80ff41168bb0add552f4523e2558a3119");
		ItemMeta cherryMeta = cherry.getItemMeta();
		cherryMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cherry.name")));
		cherryMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cherry.lores")));
		cherry.setItemMeta(cherryMeta);
		
		addItem(cherry, new Action());
		
		ItemStack apple = SkullItem.getSkull("http://textures.minecraft.net/texture/cbb311f3ba1c07c3d1147cd210d81fe11fd8ae9e3db212a0fa748946c3633");
		ItemMeta appleMeta = apple.getItemMeta();
		appleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple.name")));
		appleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple.lores")));
		apple.setItemMeta(appleMeta);
		
		addItem(apple, new Action());
		
		ItemStack melon = SkullItem.getSkull("http://textures.minecraft.net/texture/c3fed514c3e238ca7ac1c94b897ff6711b1dbe50174afc235c8f80d029");
		ItemMeta melonMeta = melon.getItemMeta();
		melonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.melon.name")));
		melonMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.melon.lores")));
		melon.setItemMeta(melonMeta);
		
		addItem(melon, new Action());
		
		ItemStack melon2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7e96cedc8b5683bea01673936b6ea96fe948a2b6cb444dc29e1fcff4d2e2cf4");
		ItemMeta melon2Meta = melon2.getItemMeta();
		melon2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.melon-2.name")));
		melon2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.melon-2.lores")));
		melon2.setItemMeta(melon2Meta);
		
		addItem(melon2, new Action());
		
		ItemStack melon3 = SkullItem.getSkull("http://textures.minecraft.net/texture/241412b8c6fd57e4e162166ddfd74b148a596f9eb1d1593c0469638c8d714");
		ItemMeta melon3Meta = melon3.getItemMeta();
		melon3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.melon-3.name")));
		melon3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.melon-3.lores")));
		melon3.setItemMeta(melon3Meta);
		
		addItem(melon3, new Action());
		
		ItemStack melon4 = SkullItem.getSkull("http://textures.minecraft.net/texture/f3903066ccc4695e113fee314c96a544eb919622eee7daa1d1966374f3fe848");
		ItemMeta melon4Meta = melon4.getItemMeta();
		melon4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.melon-4.name")));
		melon4Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.melon-4.lores")));
		melon4.setItemMeta(melon4Meta);
		
		addItem(melon4, new Action());
		
		ItemStack carvedPumpkin = SkullItem.getSkull("http://textures.minecraft.net/texture/fec415d702f3292a82f1471c8794cf63122d449d28ab886d4dc58fafd66");
		ItemMeta carvedPumpkinMeta = carvedPumpkin.getItemMeta();
		carvedPumpkinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.carved-pumpkin.name")));
		carvedPumpkinMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.carved-pumpkin.lores")));
		carvedPumpkin.setItemMeta(carvedPumpkinMeta);
		
		addItem(carvedPumpkin, new Action());
		
		ItemStack pumpkin = SkullItem.getSkull("http://textures.minecraft.net/texture/d7d7ad2dcb57dfa9f023dbb99b698fc53075c3e9d654506139a647ac907fddc5");
		ItemMeta pumpkinMeta = pumpkin.getItemMeta();
		pumpkinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.pumpkin.name")));
		pumpkinMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.pumpkin.lores")));
		pumpkin.setItemMeta(pumpkinMeta);
		
		addItem(pumpkin, new Action());
		
		ItemStack strawberry = SkullItem.getSkull("http://textures.minecraft.net/texture/cbc826aaafb8dbf67881e68944414f13985064a3f8f044d8edfb4443e76ba");
		ItemMeta strawberryMeta = strawberry.getItemMeta();
		strawberryMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.strawberry.name")));
		strawberryMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.strawberry.lores")));
		strawberry.setItemMeta(strawberryMeta);
		
		addItem(strawberry, new Action());
		
		ItemStack coconut = SkullItem.getSkull("http://textures.minecraft.net/texture/e9b0e969cf3fcced36b712350ffb46d8ed761fe5efb10e3b6a9795e6656da97");
		ItemMeta coconutMeta = coconut.getItemMeta();
		coconutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.coconut.name")));
		coconutMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.coconut.lores")));
		coconut.setItemMeta(coconutMeta);
		
		addItem(coconut, new Action());
		
		ItemStack carrot = SkullItem.getSkull("http://textures.minecraft.net/texture/3063513ecb1a91bbb3481fabd1dc3ac4f131d1c74f61c226df4194812cf3c312");
		ItemMeta carrotMeta = carrot.getItemMeta();
		carrotMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.carrot.name")));
		carrotMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.carrot.lores")));
		carrot.setItemMeta(carrotMeta);
		
		addItem(carrot, new Action());
		
		ItemStack sugarcane = SkullItem.getSkull("http://textures.minecraft.net/texture/33ca9d8b1d5f2c26547644034a55a4a2463e166f60feb0c7c5af3f724bae");
		ItemMeta sugarcaneMeta = sugarcane.getItemMeta();
		sugarcaneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sugarcane.name")));
		sugarcaneMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sugarcane.lores")));
		sugarcane.setItemMeta(sugarcaneMeta);
		
		addItem(sugarcane, new Action());
		
		ItemStack hotChocolate = SkullItem.getSkull("http://textures.minecraft.net/texture/411511bdd55bcb82803c8039f1c155fd43062636e23d4d46c4d761c04d22c2");
		ItemMeta hotChocolateMeta = hotChocolate.getItemMeta();
		hotChocolateMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.hot-chocolate.name")));
		hotChocolateMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.hot-chocolate.lores")));
		hotChocolate.setItemMeta(hotChocolateMeta);
		
		addItem(hotChocolate, new Action());
		
		ItemStack cupOfTea = SkullItem.getSkull("http://textures.minecraft.net/texture/d8e94ddd769a5bea748376b4ec7383fd36d267894d7c3bee011e8e4f5fcd7");
		ItemMeta cupOfTeaMeta = cupOfTea.getItemMeta();
		cupOfTeaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cup-of-tea.name")));
		cupOfTeaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cup-of-tea.lores")));
		cupOfTea.setItemMeta(cupOfTeaMeta);
		
		addItem(cupOfTea, new Action());
		
		ItemStack taco = SkullItem.getSkull("http://textures.minecraft.net/texture/98ced74a22021a535f6bce21c8c632b273dc2d9552b71a38d57269b3538cf");
		ItemMeta tacoMeta = taco.getItemMeta();
		tacoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.taco.name")));
		tacoMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.taco.lores")));
		taco.setItemMeta(tacoMeta);
		
		addItem(taco, new Action());
		
		ItemStack taco2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ea1f3585f54849b41da5d326a943956a25494364bb961d2458c430be9a6b27");
		ItemMeta taco2Meta = taco2.getItemMeta();
		taco2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.taco-2.name")));
		taco2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.taco-2.lores")));
		taco2.setItemMeta(taco2Meta);
		
		addItem(taco2, new Action());
		
		ItemStack bakedPotatoe = SkullItem.getSkull("http://textures.minecraft.net/texture/6f312a243aa4e69a5edc67e54e44f76eb84f66ec824089557a64bea71f6dc");
		ItemMeta bakedPotatoeMeta = bakedPotatoe.getItemMeta();
		bakedPotatoeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.baked-potatoe.name")));
		bakedPotatoeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.baked-potatoe.lores")));
		bakedPotatoe.setItemMeta(bakedPotatoeMeta);
		
		addItem(bakedPotatoe, new Action());
		
		ItemStack bacon = SkullItem.getSkull("http://textures.minecraft.net/texture/e7ba22d5df21e821a6de4b8c9d373a3aa187d8ae74f288a82d2b61f272e5");
		ItemMeta baconMeta = bacon.getItemMeta();
		baconMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bacon.name")));
		baconMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bacon.lores")));
		bacon.setItemMeta(baconMeta);
		
		addItem(bacon, new Action());
		
		ItemStack fries = SkullItem.getSkull("http://textures.minecraft.net/texture/a0eacac41a9eaf051376ef2f959701e1bbe1bf4aa6715adc34b6dc29a13ea9");
		ItemMeta friesMeta = fries.getItemMeta();
		friesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.fries.name")));
		friesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.fries.lores")));
		fries.setItemMeta(friesMeta);
		
		addItem(fries, new Action());
		
		ItemStack hamburger = SkullItem.getSkull("http://textures.minecraft.net/texture/a6ef1c25f516f2e7d6f7667420e33adcf3cdf938cb37f9a41a8b35869f569b");
		ItemMeta hamburgerMeta = hamburger.getItemMeta();
		hamburgerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.hamburger.name")));
		hamburgerMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.hamburger.lores")));
		hamburger.setItemMeta(hamburgerMeta);
		
		addItem(hamburger, new Action());
		
		ItemStack hamburger2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b0e38c176dbf7df9b0632c256eeb6c5aaca99e1c8c1a530656eaff0417aed22");
		ItemMeta hamburger2Meta = hamburger2.getItemMeta();
		hamburger2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.hamburger-2.name")));
		hamburger2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.hamburger-2.lores")));
		hamburger2.setItemMeta(hamburger2Meta);
		
		addItem(hamburger2, new Action());
		
		ItemStack hamburger3 = SkullItem.getSkull("http://textures.minecraft.net/texture/cdadf1744433e1c79d1d59d2777d939de159a24cf57e8a61c82bc4fe3777553c");
		ItemMeta hamburger3Meta = hamburger3.getItemMeta();
		hamburger3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.hamburger-3.name")));
		hamburger3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.hamburger-3.lores")));
		hamburger3.setItemMeta(hamburger3Meta);
		
		addItem(hamburger3, new Action());
		
		ItemStack popcorn = SkullItem.getSkull("http://textures.minecraft.net/texture/1497b147cfae52205597f72e3c4ef52512e9677020e4b4fa7512c3c6acdd8c1");
		ItemMeta popcornMeta = popcorn.getItemMeta();
		popcornMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.popcorn.name")));
		popcornMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.popcorn.lores")));
		popcorn.setItemMeta(popcornMeta);

		addItem(popcorn, new Action());
		
		ItemStack glassOfCocaCola = SkullItem.getSkull("http://textures.minecraft.net/texture/e9b41e9fe543f2375d0a97dd5922e4d65b8a523baf2265d42398d64c364ef95");
		ItemMeta glassOfCocaColaMeta = glassOfCocaCola.getItemMeta();
		glassOfCocaColaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.glass-of-coca-cola.name")));
		glassOfCocaColaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.glass-of-coca-cola.lores")));
		glassOfCocaCola.setItemMeta(glassOfCocaColaMeta);
		
		addItem(glassOfCocaCola, new Action());
		
		ItemStack sushiMackerel = SkullItem.getSkull("http://textures.minecraft.net/texture/846d3172e7d6ad6df6a2189755ce0b2dc85a1f9ccd109dc932985867ba6");
		ItemMeta sushiMackerelMeta = sushiMackerel.getItemMeta();
		sushiMackerelMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-mackerel.name")));
		sushiMackerelMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-mackerel.lores")));
		sushiMackerel.setItemMeta(sushiMackerelMeta);
		
		addItem(sushiMackerel, new Action());
		
		ItemStack sushiSalmon = SkullItem.getSkull("http://textures.minecraft.net/texture/23bf8fca2af3592c5574b13e3bcf61e2fae829788535f0ddeaa7a2e45b6ba4");
		ItemMeta sushiSalmonMeta = sushiSalmon.getItemMeta();
		sushiSalmonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-salmon.name")));
		sushiSalmonMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-salmon.lores")));
		sushiSalmon.setItemMeta(sushiSalmonMeta);
		
		addItem(sushiSalmon);
		
		ItemStack sushiRoll = SkullItem.getSkull("http://textures.minecraft.net/texture/2e12f267953e76ae66a8dd025a3286aecbc64b4ad98eeb10b3c67a69aae15");
		ItemMeta sushiRollMeta = sushiRoll.getItemMeta();
		sushiRollMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-roll.name")));
		sushiRollMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-roll.lores")));
		sushiRoll.setItemMeta(sushiRollMeta);
		
		addItem(sushiRoll);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.close.name")));
		closeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.close.lores")));
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 49);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.next-page.name")));
		nextMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 2);
				return true;
			}
		}, 51);
		
		setStartingPoint(54);
		
		//page two
		ItemStack riceball = SkullItem.getSkull("http://textures.minecraft.net/texture/69c2ddf2bd74a4655e8f0153a7453e67db2a21dbfac6756789481adbec483a");
		ItemMeta riceballMeta = riceball.getItemMeta();
		riceballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.riceball.name")));
		riceballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.riceball.lores")));
		riceball.setItemMeta(riceballMeta);
		
		addItem(riceball, new Action());
		
		ItemStack cornBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/99dfac171e3c2029676ecf8d3a0fd9b7bb2857b95efdefc59e0f252576b5c68");
		ItemMeta cornBlockMeta = cornBlock.getItemMeta();
		cornBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.corn-block.name")));
		cornBlockMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.corn-block.lores")));
		cornBlock.setItemMeta(cornBlockMeta);
		
		addItem(cornBlock, new Action());
		
		ItemStack hamCheeseSandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/baee84d19c85aff796c88abda21ec4c92c655e2d67b72e5e77b5aa5e99ed");
		ItemMeta hamCheeseSandwichMeta = hamCheeseSandwich.getItemMeta();
		hamCheeseSandwichMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.ham-cheese-sandwich.name")));
		hamCheeseSandwichMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.ham-cheese-sandwich.lores")));
		hamCheeseSandwich.setItemMeta(hamCheeseSandwichMeta);
		
		addItem(hamCheeseSandwich, new Action());
		
		ItemStack glassOfBeer = SkullItem.getSkull("http://textures.minecraft.net/texture/4053e26867bb57538e9789137dbbb53774e18eda6fef51cb2edf426b37264");
		ItemMeta glassOfBeerMeta = glassOfBeer.getItemMeta();
		glassOfBeerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.glass-of-beer.name")));
		glassOfBeerMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.glass-of-beer.lores")));
		glassOfBeer.setItemMeta(glassOfBeerMeta);
		
		addItem(glassOfBeer, new Action());
		
		ItemStack medievalBeer = SkullItem.getSkull("http://textures.minecraft.net/texture/229603d82963056be13522cfb7d4520c76ba687f396a0dab125e63b5dacea8");
		ItemMeta medievalBeerMeta = medievalBeer.getItemMeta();
		medievalBeerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.medieval-beer.name")));
		medievalBeerMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.medieval-beer.lores")));
		medievalBeer.setItemMeta(medievalBeerMeta);
		
		addItem(medievalBeer, new Action());
		
		ItemStack ham = SkullItem.getSkull("http://textures.minecraft.net/texture/26336f5bb9975bf57e14db6615c1896c5c4b9c39aad17b17e4ee20b231cf6");
		ItemMeta hamMeta = ham.getItemMeta();
		hamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.ham.name")));
		hamMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.ham.lores")));
		ham.setItemMeta(hamMeta);
		
		addItem(ham, new Action());
		
		ItemStack mushroomStew = SkullItem.getSkull("http://textures.minecraft.net/texture/cc14144f61c4e66b3c443660debc73cb2125d0140c51b5522c8a68b789414");
		ItemMeta mushroomStewMeta = mushroomStew.getItemMeta();
		mushroomStewMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.mushroom-stew.name")));
		mushroomStewMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.mushroom-stew.lores")));
		mushroomStew.setItemMeta(mushroomStewMeta);
		
		addItem(mushroomStew, new Action());
		
		ItemStack sweetRoll = SkullItem.getSkull("http://textures.minecraft.net/texture/ec6eb8f15ba0d7993bf8708fa1dd86c1e8fde741a7dde9195f22891e02153");
		ItemMeta sweetRollMeta = sweetRoll.getItemMeta();
		sweetRollMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sweet-roll.name")));
		sweetRollMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sweet-roll.lores")));
		sweetRoll.setItemMeta(sweetRollMeta);
		
		addItem(sweetRoll, new Action());
		
		ItemStack iceCream = SkullItem.getSkull("http://textures.minecraft.net/texture/d8e3b53bc8fab19c6fd0f8abf13bf2303581d81691141f15973b4777e039f73");
		ItemMeta iceCreamMeta = iceCream.getItemMeta();
		iceCreamMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.ice-cream.name")));
		iceCreamMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.ice-cream.lores")));
		iceCream.setItemMeta(iceCreamMeta);
		
		addItem(iceCream, new Action());
		
		ItemStack lemon = SkullItem.getSkull("http://textures.minecraft.net/texture/957fd56ca15978779324df519354b6639a8d9bc1192c7c3de925a329baef6c");
		ItemMeta lemonMeta = lemon.getItemMeta();
		lemonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.lemon.name")));
		lemonMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.lemon.lores")));
		lemon.setItemMeta(lemonMeta);
		
		addItem(lemon, new Action());
		
		ItemStack plum = SkullItem.getSkull("http://textures.minecraft.net/texture/5cc016f568d1433860d82fa3379d784cbbd52e56b55f78be7291f8618da38c8");
		ItemMeta plumMeta = plum.getItemMeta();
		plumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.plum.name")));
		plumMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.plum.lores")));
		plum.setItemMeta(plumMeta);
		
		addItem(plum, new Action());
		
		ItemStack salad = SkullItem.getSkull("http://textures.minecraft.net/texture/1fe92e11a67b56935446a214caa3723d29e6db56c55fa8d43179a8a3176c6c1");
		ItemMeta saladMeta = salad.getItemMeta();
		saladMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.salad.name")));
		saladMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.salad.lores")));
		salad.setItemMeta(saladMeta);
		
		addItem(salad, new Action());
		
		ItemStack whiteFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/d07b8c51acec2a508bb2fa652fb6e4a08b19485159a099f5982ccb88df1fe27e");
		ItemMeta whiteFrostedDonutMeta = whiteFrostedDonut.getItemMeta();
		whiteFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.white-frosted-donut.name")));
		whiteFrostedDonutMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.white-frosted-donut.lores")));
		whiteFrostedDonut.setItemMeta(whiteFrostedDonutMeta);
		
		addItem(whiteFrostedDonut, new Action());
		
		ItemStack pinkFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/837c9b82b186656e9f6363a2a1c6a4b5b93cfa9ef4dad6f16b94ebb5e362678");
		ItemMeta pinkFrostedDonutMeta = pinkFrostedDonut.getItemMeta();
		pinkFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.pink-frosted-donut.name")));
		pinkFrostedDonutMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.pink-frosted-donut.lores")));
		pinkFrostedDonut.setItemMeta(pinkFrostedDonutMeta);
		
		addItem(pinkFrostedDonut, new Action());
		
		ItemStack chocolateFrostedDonut = SkullItem.getSkull("http://textures.minecraft.net/texture/59da54ff366e738e31de92919986abb4d50ca944fa9926af63758b7448f18");
		ItemMeta chocolateFrostedDonutMeta = chocolateFrostedDonut.getItemMeta();
		chocolateFrostedDonutMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chocolate-frosted-donut.name")));
		chocolateFrostedDonutMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chocolate-frosted-donut.lores")));
		chocolateFrostedDonut.setItemMeta(chocolateFrostedDonutMeta);
		
		addItem(chocolateFrostedDonut, new Action());
		
		ItemStack turkey = SkullItem.getSkull("http://textures.minecraft.net/texture/f06555706b641fdaf436c07663f923afc5ee72146f90195fb337b9de766588d");
		ItemMeta turkeyMeta = turkey.getItemMeta();
		turkeyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.turkey.name")));
		turkeyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.turkey.lores")));
		turkey.setItemMeta(turkeyMeta);
		
		addItem(turkey, new Action());
		
		ItemStack bentoBox = SkullItem.getSkull("http://textures.minecraft.net/texture/fe3052c535e14597a413ec32b32aafdd28686fdab6eed73030e1b94f7c38ff");
		ItemMeta bentoBoxMeta = bentoBox.getItemMeta();
		bentoBoxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bento-box.name")));
		bentoBoxMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bento-box.lores")));
		bentoBox.setItemMeta(bentoBoxMeta);
		
		addItem(bentoBox, new Action());
		
		ItemStack coconut2 = SkullItem.getSkull("http://textures.minecraft.net/texture/32c62fd8e474d09940604f82712a44abb249d63aff87f998374ca849ab17412");
		ItemMeta coconut2Meta = coconut2.getItemMeta();
		coconut2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.coconut-2.name")));
		coconut2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.coconut-2.lores")));
		coconut2.setItemMeta(coconut2Meta);
		
		addItem(coconut2, new Action());
		
		ItemStack coconut3 = SkullItem.getSkull("http://textures.minecraft.net/texture/bf61259a7ed75dfc15f4328f69fa5d549ef1ba9c7aa85c53b8c76173fac3c69");
		ItemMeta coconut3Meta = coconut3.getItemMeta();
		coconut3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.coconut-3.name")));
		coconut3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.coconut-3.lores")));
		coconut3.setItemMeta(coconut3Meta);
		
		addItem(coconut3, new Action());
		
		ItemStack plateOfCookies = SkullItem.getSkull("http://textures.minecraft.net/texture/6368a69c94b45dd0a435de217c29cdbd433c7b447391faa33c241dc08271");
		ItemMeta plateOfCookiesMeta = plateOfCookies.getItemMeta();
		plateOfCookiesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.plate-of-cookies.name")));
		plateOfCookiesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.plate-of-cookies.lores")));
		plateOfCookies.setItemMeta(plateOfCookiesMeta);
		
		addItem(plateOfCookies, new Action());
		
		ItemStack marshmallow = SkullItem.getSkull("http://textures.minecraft.net/texture/b7855166984a725becfac1eab5cfbdcbee7e426466ddc3bee4c71cfd72cb5888");
		ItemMeta marshmallowMeta = marshmallow.getItemMeta();
		marshmallowMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.marshmallow.name")));
		marshmallowMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.marshmallow.lores")));
		marshmallow.setItemMeta(marshmallowMeta);
		
		addItem(marshmallow, new Action());
		
		ItemStack hamburger4 = SkullItem.getSkull("http://textures.minecraft.net/texture/c5e27988a6538010efc0e24756bc3e3eea24d7536b20932c17e0404e5cc55f");
		ItemMeta hamburger4Meta = hamburger4.getItemMeta();
		hamburger4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.hamburger-4.name")));
		hamburger4Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.hamburger-4.lores")));
		hamburger4.setItemMeta(hamburger4Meta);
		
		addItem(hamburger4, new Action());
		
		ItemStack bowlOfRice = SkullItem.getSkull("http://textures.minecraft.net/texture/c377e3d6c379fe34a2e6afabba32e7aecf77bcd31a1c3836ec354a935a7e9");
		ItemMeta bowlOfRiceMeta = bowlOfRice.getItemMeta();
		bowlOfRiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bowl-of-rice.name")));
		bowlOfRiceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bowl-of-rice.lores")));
		bowlOfRice.setItemMeta(bowlOfRiceMeta);
		
		addItem(bowlOfRice, new Action());
		
		ItemStack sushiRoll2 = SkullItem.getSkull("http://textures.minecraft.net/texture/50405181d39e76197a262be4cc6541e8e3ed24633384c873adb91dfe3901c");
		ItemMeta sushiRoll2Meta = sushiRoll2.getItemMeta();
		sushiRoll2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-roll-2.name")));
		sushiRoll2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-roll-2.lores")));
		sushiRoll2.setItemMeta(sushiRoll2Meta);
		
		addItem(sushiRoll2, new Action());
		
		ItemStack bowlOfSpaghetti = SkullItem.getSkull("http://textures.minecraft.net/texture/347fe65eb745468e86873a1bda48a5a489fef91cc522d85e0364b55d53f867e");
		ItemMeta bowlOfSpaghettiMeta = bowlOfSpaghetti.getItemMeta();
		bowlOfSpaghettiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bowl-of-spaghetti.name")));
		bowlOfSpaghettiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bowl-of-spaghetti.lores")));
		bowlOfSpaghetti.setItemMeta(bowlOfSpaghettiMeta);
		
		addItem(bowlOfSpaghetti, new Action());
		
		ItemStack bowlOfNoodles = SkullItem.getSkull("http://textures.minecraft.net/texture/26834b5b25426de63538ec82ca8fbecfcbb3e682d8063643d2e67a7621bd");
		ItemMeta bowlOfNoodlesMeta = bowlOfNoodles.getItemMeta();
		bowlOfNoodlesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bowl-of-noodles.name")));
		bowlOfNoodlesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bowl-of-noodles.lores")));
		bowlOfNoodles.setItemMeta(bowlOfNoodlesMeta);
		
		addItem(bowlOfNoodles, new Action());
		
		ItemStack bowlOfNoodles2 = SkullItem.getSkull("http://textures.minecraft.net/texture/e9485663e65264a3dc30472e6a6931446bed32c2e899905facf18b2919689c1");
		ItemMeta bowlOfNoodles2Meta = bowlOfNoodles2.getItemMeta();
		bowlOfNoodles2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.bowl-of-noodles-2.name")));
		bowlOfNoodles2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.bowl-of-noodles-2.lores")));
		bowlOfNoodles2.setItemMeta(bowlOfNoodles2Meta);
		
		addItem(bowlOfNoodles2, new Action());
		
		ItemStack chineseTakeOutBox = SkullItem.getSkull("http://textures.minecraft.net/texture/6e42286da33a238e4f27fe703fc8a087201b6940fc23744df9663fb985da024");
		ItemMeta chineseTakeOutBoxMeta = chineseTakeOutBox.getItemMeta();
		chineseTakeOutBoxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chinese-take-out-box.name")));
		chineseTakeOutBoxMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chinese-take-out-box.lores")));
		chineseTakeOutBox.setItemMeta(chineseTakeOutBoxMeta);
		
		addItem(chineseTakeOutBox, new Action());
		
		ItemStack tomato = SkullItem.getSkull("http://textures.minecraft.net/texture/99172226d276070dc21b75ba25cc2aa5649da5cac745ba977695b59aebd");
		ItemMeta tomatoMeta = tomato.getItemMeta();
		tomatoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.tomato.name")));
		tomatoMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.tomato.lores")));
		tomato.setItemMeta(tomatoMeta);
		
		addItem(tomato, new Action());
		
		ItemStack orange = SkullItem.getSkull("http://textures.minecraft.net/texture/87b3d291d3b99bcd4c37a1839dc160d885ecd4e237b3aea1baf0adbb1775cd64");
		ItemMeta orangeMeta = orange.getItemMeta();
		orangeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.orange.name")));
		orangeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.orange.lores")));
		orange.setItemMeta(orangeMeta);
		
		addItem(orange, new Action());
		
		ItemStack greenApple = SkullItem.getSkull("http://textures.minecraft.net/texture/c4c05dd5d7a92889d8d22d4df0f1a1fe2bee3eddf192f78fc44e02e14dbf629");
		ItemMeta greenAppleMeta = greenApple.getItemMeta();
		greenAppleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.green-apple.name")));
		greenAppleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.green-apple.lores")));
		greenApple.setItemMeta(greenAppleMeta);
		
		addItem(greenApple, new Action());
		
		ItemStack lettuce = SkullItem.getSkull("http://textures.minecraft.net/texture/477dd842c975d8fb03b1add66db8377a18ba987052161f22591e6a4ede7f5");
		ItemMeta lettuceMeta = lettuce.getItemMeta();
		lettuceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.lettuce.name")));
		lettuceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.lettuce.lores")));
		lettuce.setItemMeta(lettuceMeta);
		
		addItem(lettuce, new Action());
		
		ItemStack purpleGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/ee5935863c53a996f5334e90f55de538e83ffc5f6b0b8e83a4dc4f6e6b1208");
		ItemMeta purpleGrapesMeta = purpleGrapes.getItemMeta();
		purpleGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.purple-grapes.name")));
		purpleGrapesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.purple-grapes.lores")));
		purpleGrapes.setItemMeta(purpleGrapesMeta);
		
		addItem(purpleGrapes, new Action());
		
		ItemStack greenGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/8cdcf38a8438ed3a547f8d5b47e0801559c595f0e26c45656a76b5bf8a56f");
		ItemMeta greenGrapesMeta = greenGrapes.getItemMeta();
		greenGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.green-grapes.name")));
		greenGrapesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.green-grapes.lores")));
		greenGrapes.setItemMeta(greenGrapesMeta);
		
		addItem(greenGrapes, new Action());
		
		ItemStack redGrapes = SkullItem.getSkull("http://textures.minecraft.net/texture/d511a5ee4d17682a25f7e8a5da6ff7cd9ad9c4844c258a6de23e7f84f27f9b4");
		ItemMeta redGrapesMeta = redGrapes.getItemMeta();
		redGrapesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.red-grapes.name")));
		redGrapesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.red-grapes.lores")));
		redGrapes.setItemMeta(redGrapesMeta);
		
		addItem(redGrapes, new Action());
		
		ItemStack sandwich = SkullItem.getSkull("http://textures.minecraft.net/texture/9496589fb5c1f69387b7fb17d92312058ff6e8ebeb3eb89e4f73e78196113b");
		ItemMeta sandwichMeta = sandwich.getItemMeta();
		sandwichMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sandwich.name")));
		sandwichMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sandwich.lores")));
		sandwich.setItemMeta(sandwichMeta);
		
		addItem(sandwich, new Action());
		
		ItemStack cherryPie = SkullItem.getSkull("http://textures.minecraft.net/texture/d53c1e87e537f1ab2774ddafb83439b336f4a777b47ad82bcb30d5fcbdf9bc");
		ItemMeta cherryPieMeta = cherryPie.getItemMeta();
		cherryPieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cherry-pie.name")));
		cherryPieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cherry-pie.lores")));
		cherryPie.setItemMeta(cherryPieMeta);
		
		addItem(cherryPie, new Action());
		
		ItemStack pie = SkullItem.getSkull("http://textures.minecraft.net/texture/6483912fb2a30d73361c03844611775b1c33218b3a56bded6ae792c2e439881");
		ItemMeta pieMeta = pie.getItemMeta();
		pieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.pie.name")));
		pieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.pie.lores")));
		pie.setItemMeta(pieMeta);
		
		addItem(pie, new Action());
		
		ItemStack chocolateCake = SkullItem.getSkull("http://textures.minecraft.net/texture/9119fca4f28a755d37fbe5dcf6d8c3ef50fe394c1a7850bc7e2b71ee78303c4c");
		ItemMeta chocolateCakeMeta = chocolateCake.getItemMeta();
		chocolateCakeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.chocolate-cake.name")));
		chocolateCakeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.chocolate-cake.lores")));
		chocolateCake.setItemMeta(chocolateCakeMeta);
		
		addItem(chocolateCake, new Action());
		
		ItemStack honeyPot = SkullItem.getSkull("http://textures.minecraft.net/texture/18c2cddeed624a538f349d8c7035fef918e6d7a1781631eac51ec182712a54da");
		ItemMeta honeyPotMeta = honeyPot.getItemMeta();
		honeyPotMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.honey-pot.name")));
		honeyPotMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.honey-pot.lores")));
		honeyPot.setItemMeta(honeyPotMeta);

		addItem(honeyPot, new Action());
		
		ItemStack pepsi = SkullItem.getSkull("http://textures.minecraft.net/texture/2bbae6df99dc82beaf49d064df74a1bbc15e8e376533276912c8c8fe59cb4f4");
		ItemMeta pepsiMeta = pepsi.getItemMeta();
		pepsiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.pepsi.name")));
		pepsiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.pepsi.lores")));
		pepsi.setItemMeta(pepsiMeta);

		addItem(pepsi, new Action());
		
		ItemStack cocaCola = SkullItem.getSkull("http://textures.minecraft.net/texture/93b01fb2f6ba47c9d7638491f37cd8582a937731186df4d1eccd59b65bf37");
		ItemMeta cocaColaMeta = cocaCola.getItemMeta();
		cocaColaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.coca-cola.name")));
		cocaColaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.coca-cola.lores")));
		cocaCola.setItemMeta(cocaColaMeta);

		addItem(cocaCola, new Action());
		
		ItemStack sprite = SkullItem.getSkull("http://textures.minecraft.net/texture/b8a34d86a7bb13d45afdc50d3dce5eed95e1844fbdee0cca753c6d3346e339e");
		ItemMeta spriteMeta = sprite.getItemMeta();
		spriteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sprite.name")));
		spriteMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sprite.lores")));
		sprite.setItemMeta(spriteMeta);

		addItem(sprite, new Action());
		
		ItemStack melloYello = SkullItem.getSkull("http://textures.minecraft.net/texture/f86b51fb30b5138a4344cc3e6397da28df396241341be92121d5baeef997fb4");
		ItemMeta melloYelloMeta = melloYello.getItemMeta();
		melloYelloMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.mello-yello.name")));
		melloYelloMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.mello-yello.lores")));
		melloYello.setItemMeta(melloYelloMeta);

		addItem(melloYello, new Action());
		
		ItemStack fanta = SkullItem.getSkull("http://textures.minecraft.net/texture/2be9505a38a14d1512c7892fc44d3d7ce6338b1bf0f9123721b121a14b095a3");
		ItemMeta fantaMeta = fanta.getItemMeta();
		fantaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.fanta.name")));
		fantaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.fanta.lores")));
		fanta.setItemMeta(fantaMeta);
		
		addItem(fanta, new Action());
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked());
				return true;
			}
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.close.name")));
		close2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.close.lores")));
		close2.setItemMeta(close2Meta);
		
		setItem(close2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 103);
		
		//next page
		ItemStack next2 = new ItemStack(Material.SUGAR_CANE);
		ItemMeta next2Meta = next2.getItemMeta();
		next2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.next-page.name")));
		next2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.next-page.lores")));
		next2.setItemMeta(next2Meta);
		
		setItem(next2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 3);
				return true;
			}
		}, 105);
		
		setStartingPoint(108);
		
		//page three
		ItemStack mountainDew = SkullItem.getSkull("http://textures.minecraft.net/texture/86e5bf657ab897ad5e54867a4c3c2e71b2da24e7518b2f834488da76f62f5216");
		ItemMeta mountainDewMeta = mountainDew.getItemMeta();
		mountainDewMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.mountain-dew.name")));
		mountainDewMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.mountain-dew.lores")));
		mountainDew.setItemMeta(mountainDewMeta);
		
		addItem(mountainDew, new Action());
		
		ItemStack tomato2 = SkullItem.getSkull("http://textures.minecraft.net/texture/d186863fdf3f3e2979ec6d978a088d8a4f8664c50b5b6d29ad4a7ac264a017");
		ItemMeta tomato2Meta = tomato2.getItemMeta();
		tomato2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.tomato-2.name")));
		tomato2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.tomato-2.lores")));
		tomato2.setItemMeta(tomato2Meta);
		
		addItem(tomato2, new Action());
		
		ItemStack ripeTomato = SkullItem.getSkull("http://textures.minecraft.net/texture/69147172072f072483529767fe47554a95a0e0fd9b6cc531b25958a399ef3");
		ItemMeta ripeTomatoMeta = ripeTomato.getItemMeta();
		ripeTomatoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.ripe-tomato.name")));
		ripeTomatoMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.ripe-tomato.lores")));
		ripeTomato.setItemMeta(ripeTomatoMeta);
		
		addItem(ripeTomato, new Action());
		
		ItemStack raspberry = SkullItem.getSkull("http://textures.minecraft.net/texture/487bde7cb6618be1c1c903f6875ea976e5733544248fd505f516a18f29235");
		ItemMeta raspberryMeta = raspberry.getItemMeta();
		raspberryMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.raspberry.name")));
		raspberryMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.raspberry.lores")));
		raspberry.setItemMeta(raspberryMeta);
		
		addItem(raspberry, new Action());
		
		ItemStack raspberry2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b12ef1b486e97e4cb124aa7629aceb91edc51d63338c91a012885493c5d9c");
		ItemMeta raspberry2Meta = raspberry2.getItemMeta();
		raspberry2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.raspberry-2.name")));
		raspberry2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.raspberry-2.lores")));
		raspberry2.setItemMeta(raspberry2Meta);
		
		addItem(raspberry2, new Action());
		
		ItemStack apple2 = SkullItem.getSkull("http://textures.minecraft.net/texture/cc9eba63a9d12cb6fde63badbe289d888f57219f4122c2820ea654fbe6350a5");
		ItemMeta apple2Meta = apple2.getItemMeta();
		apple2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple-2.name")));
		apple2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple-2.lores")));
		apple2.setItemMeta(apple2Meta);
		
		addItem(apple2, new Action());
		
		ItemStack apple3 = SkullItem.getSkull("http://textures.minecraft.net/texture/8564797cd62664448ed028e487acd95d57075dce49a356fcc65655b2b525ddb");
		ItemMeta apple3Meta = apple3.getItemMeta();
		apple3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple-3.name")));
		apple3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple-3.lores")));
		apple3.setItemMeta(apple3Meta);
		
		addItem(apple3, new Action());
		
		ItemStack apple4 = SkullItem.getSkull("http://textures.minecraft.net/texture/63e8659478dd28b1ade6ebe7d3e1d6758e219f438db784a5addeda86ed1a38a");
		ItemMeta apple4Meta = apple4.getItemMeta();
		apple4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple-4.name")));
		apple4Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple-4.lores")));
		apple4.setItemMeta(apple4Meta);
		
		addItem(apple4, new Action());
		
		ItemStack apple5 = SkullItem.getSkull("http://textures.minecraft.net/texture/2fb0e221fd81b98b8b569b3522d5231cf8b367732f37b381e7acea29a6e84");
		ItemMeta apple5Meta = apple5.getItemMeta();
		apple5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple-5.name")));
		apple5Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple-5.lores")));
		apple5.setItemMeta(apple5Meta);
		
		addItem(apple5, new Action());
		
		ItemStack apple6 = SkullItem.getSkull("http://textures.minecraft.net/texture/e2b35bda5ebdf135f4e71ce49726fbec5739f0adedf01c519e2aea7f51951ea2");
		ItemMeta apple6Meta = apple6.getItemMeta();
		apple6Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.apple-6.name")));
		apple6Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.apple-6.lores")));
		apple6.setItemMeta(apple6Meta);
		
		addItem(apple6, new Action());
		
		ItemStack cookedShrimp = SkullItem.getSkull("http://textures.minecraft.net/texture/336a9add25645bfcc377c25ef0c2e9901d19493c3e981ebc6ba7a1a1b6466ce4");
		ItemMeta cookedShrimpMeta = cookedShrimp.getItemMeta();
		cookedShrimpMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.cooked-shrimp.name")));
		cookedShrimpMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.cooked-shrimp.lores")));
		cookedShrimp.setItemMeta(cookedShrimpMeta);
		
		addItem(cookedShrimp, new Action());
		
		ItemStack sushiSalmon2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ae9d22d9ada63e281420ae33691880869fa1a14bfdf87d8e538e998a8f29595b");
		ItemMeta sushiSalmon2Meta = sushiSalmon2.getItemMeta();
		sushiSalmon2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-salmon-2.name")));
		sushiSalmon2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-salmon-2.name")));
		sushiSalmon2.setItemMeta(sushiSalmon2Meta);
		
		addItem(sushiSalmon, new Action());
		
		ItemStack sushi = SkullItem.getSkull("http://textures.minecraft.net/texture/cb82d3c9eedc718c07519254f7921a59ff3a6f245939665c9cb017112ce670");
		ItemMeta sushiMeta = sushi.getItemMeta();
		sushiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi.name")));
		sushiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi.lores")));
		sushi.setItemMeta(sushiMeta);
		
		addItem(sushi, new Action());
		
		ItemStack sushi2 = SkullItem.getSkull("http://textures.minecraft.net/texture/23ca3f926e7a9ab9555fecb69a802743c122d9efc565a2fe5545118fa91d1");
		ItemMeta sushi2Meta = sushi2.getItemMeta();
		sushi2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.sushi-2.name")));
		sushi2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.sushi-2.lores")));
		sushi2.setItemMeta(sushi2Meta);
		
		addItem(sushi2, new Action());
		
		ItemStack plasticCup = SkullItem.getSkull("http://textures.minecraft.net/texture/9179ce4849723434e84747ec85fbbfb1121456c8aeb2e9171fb8328921d45");
		ItemMeta plasticCupMeta = plasticCup.getItemMeta();
		plasticCupMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.plastic-cup.name")));
		plasticCupMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.plastic-cup.lores")));
		plasticCup.setItemMeta(plasticCupMeta);
		
		addItem(plasticCup, new Action());
		
		//previous page
		ItemStack previous3 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous3Meta = previous3.getItemMeta();
		previous3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.previous-page.name")));
		previous3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.previous-page.lores")));
		previous3.setItemMeta(previous3Meta);
		
		setItem(previous3, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 2);
				return true;
			}
		}, 155);
		
		//close
		ItemStack close3 = new ItemStack(Material.BOOK);
		ItemMeta close3Meta = close3.getItemMeta();
		close3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.food.close.name")));
		close3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.food.close.lores")));
		close3.setItemMeta(close3Meta);
		
		setItem(close3, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 157);
	}
	
	public class Action extends GuiAction {
		@SuppressWarnings("deprecation")
		@Override
		public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
			if (type != GuiActionType.CLICK)
				return false;
			
			InventoryClickEvent event = (InventoryClickEvent) e;
			event.setCursor(event.getCurrentItem());
			return true;
		}
	}
}