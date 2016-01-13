package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.mobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class MobsHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Mobs");
		
		ItemStack blaze = SkullItem.getSkull("http://textures.minecraft.net/texture/67e7ae12195c8c97a7706efc7bfc2851666c9f1d53b6ce075569922b4263bd");
		ItemMeta blazeMeta = blaze.getItemMeta();
		blazeMeta.setDisplayName(ChatColor.GOLD + "Blaze");
		blaze.setItemMeta(blazeMeta);
		
		ItemStack caveSpider = SkullItem.getSkull("http://textures.minecraft.net/texture/41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224");
		ItemMeta caveSpiderMeta = caveSpider.getItemMeta();
		caveSpiderMeta.setDisplayName(ChatColor.GOLD + "Cave Spider");
		caveSpider.setItemMeta(caveSpiderMeta);
		
		ItemStack ghast = SkullItem.getSkull("http://textures.minecraft.net/texture/8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0");
		ItemMeta ghastMeta = ghast.getItemMeta();
		ghastMeta.setDisplayName(ChatColor.GOLD + "Ghast");
		ghast.setItemMeta(ghastMeta);
		
		ItemStack pigzombie = SkullItem.getSkull("http://textures.minecraft.net/texture/74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb");
		ItemMeta pigzombieMeta = pigzombie.getItemMeta();
		pigzombieMeta.setDisplayName(ChatColor.GOLD + "Pigzombie");
		pigzombie.setItemMeta(pigzombieMeta);
		
		ItemStack enderman = SkullItem.getSkull("http://textures.minecraft.net/texture/7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf");
		ItemMeta endermanMeta = enderman.getItemMeta();
		endermanMeta.setDisplayName(ChatColor.GOLD + "Enderman");
		enderman.setItemMeta(endermanMeta);
		
		ItemStack lavaSlime = SkullItem.getSkull("http://textures.minecraft.net/texture/b396fbf43413c0168697349953ec6daeffb7816e9acbbeaaf77c1ff3137f2ba3");
		ItemMeta lavaSlimeMeta = lavaSlime.getItemMeta();
		lavaSlimeMeta.setDisplayName(ChatColor.GOLD + "Lava Slime");
		lavaSlime.setItemMeta(lavaSlimeMeta);
		
		ItemStack slime = SkullItem.getSkull("http://textures.minecraft.net/texture/cb38f01fb5fd75b7c2674a74c70f83cf8ccf96b799d605711b638d556c");
		ItemMeta slimeMeta = slime.getItemMeta();
		slimeMeta.setDisplayName(ChatColor.GOLD + "Slime");
		slime.setItemMeta(slimeMeta);
		
		ItemStack spider = SkullItem.getSkull("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
		ItemMeta spiderMeta = spider.getItemMeta();
		spiderMeta.setDisplayName(ChatColor.GOLD + "Spider");
		spider.setItemMeta(spiderMeta);
		
		ItemStack chicken = SkullItem.getSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893");
		ItemMeta chickenMeta = chicken.getItemMeta();
		chickenMeta.setDisplayName(ChatColor.GOLD + "Chicken");
		chicken.setItemMeta(chickenMeta);
		
		ItemStack pig = SkullItem.getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
		ItemMeta pigMeta = pig.getItemMeta();
		pigMeta.setDisplayName(ChatColor.GOLD + "Pig");
		pig.setItemMeta(pigMeta);
		
		ItemStack sheep = SkullItem.getSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
		ItemMeta sheepMeta = sheep.getItemMeta();
		sheepMeta.setDisplayName(ChatColor.GOLD + "Sheep");
		sheep.setItemMeta(sheepMeta);
		
		ItemStack cow = SkullItem.getSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5");
		ItemMeta cowMeta = cow.getItemMeta();
		cowMeta.setDisplayName(ChatColor.GOLD + "Cow");
		cow.setItemMeta(cowMeta);
		
		ItemStack squid = SkullItem.getSkull("http://textures.minecraft.net/texture/01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac");
		ItemMeta squidMeta = squid.getItemMeta();
		squidMeta.setDisplayName(ChatColor.GOLD + "Squid");
		squid.setItemMeta(squidMeta);
		
		ItemStack villager = SkullItem.getSkull("http://textures.minecraft.net/texture/822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b");
		ItemMeta villagerMeta = villager.getItemMeta();
		villagerMeta.setDisplayName(ChatColor.GOLD + "Villager");
		villager.setItemMeta(villagerMeta);
		
		ItemStack golem = SkullItem.getSkull("http://textures.minecraft.net/texture/89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714");
		ItemMeta golemMeta = golem.getItemMeta();
		golemMeta.setDisplayName(ChatColor.GOLD + "Golem");
		golem.setItemMeta(golemMeta);
		
		ItemStack herobrine = SkullItem.getSkull("http://textures.minecraft.net/texture/98b7ca3c7d314a61abed8fc18d797fc30b6efc8445425c4e250997e52e6cb");
		ItemMeta herobrineMeta = herobrine.getItemMeta();
		herobrineMeta.setDisplayName(ChatColor.GOLD + "Herobrine");
		herobrine.setItemMeta(herobrineMeta);
		
		ItemStack mushroomCow = SkullItem.getSkull("http://textures.minecraft.net/texture/d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db");
		ItemMeta mushroomCowMeta = mushroomCow.getItemMeta();
		mushroomCowMeta.setDisplayName(ChatColor.GOLD + "Mushroom Cow");
		mushroomCow.setItemMeta(mushroomCowMeta);
		
		ItemStack ocelot = SkullItem.getSkull("http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1");
		ItemMeta ocelotMeta = ocelot.getItemMeta();
		ocelotMeta.setDisplayName(ChatColor.GOLD + "Ocelot");
		ocelot.setItemMeta(ocelotMeta);
		
		ItemStack horseHead = SkullItem.getSkull("http://textures.minecraft.net/texture/e1a62ddc5c7ef643fb264df7ededea3769eeb6484e35b906e99f1fbdc33");
		ItemMeta horseHeadMeta = horseHead.getItemMeta();
		horseHeadMeta.setDisplayName(ChatColor.GOLD + "Horse Head");
		horseHead.setItemMeta(horseHeadMeta);
		
		ItemStack guardian = SkullItem.getSkull("http://textures.minecraft.net/texture/932c24524c82ab3b3e57c2052c533f13dd8c0beb8bdd06369bb2554da86c123");
		ItemMeta guardianMeta = guardian.getItemMeta();
		guardianMeta.setDisplayName(ChatColor.GOLD + "Guardian");
		guardian.setItemMeta(guardianMeta);
		
		ItemStack monkey = SkullItem.getSkull("textures.minecraft.net/texture/e9f2dcbcde8a227cd3d285799a3b2d4bffe3b4db20203c90bea1afcf24176bd");
		ItemMeta monkeyMeta = monkey.getItemMeta();
		monkeyMeta.setDisplayName(ChatColor.GOLD + "Monkey");
		monkey.setItemMeta(monkeyMeta);
		
		ItemStack polarBear = SkullItem.getSkull("http://textures.minecraft.net/texture/d46d23f04846369fa2a3702c10f759101af7bfe8419966429533cd81a11d2b");
		ItemMeta polarBearMeta = polarBear.getItemMeta();
		polarBearMeta.setDisplayName(ChatColor.GOLD + "Polar Bear");
		polarBear.setItemMeta(polarBearMeta);
		
		ItemStack penguin = SkullItem.getSkull("http://textures.minecraft.net/texture/d3c57facbb3a4db7fd55b5c0dc7d19c19cb0813c748ccc9710c714727551f5b9");
		ItemMeta penguinMeta = penguin.getItemMeta();
		penguinMeta.setDisplayName(ChatColor.GOLD + "Penguin");
		penguin.setItemMeta(penguinMeta);
		
		ItemStack walrus = SkullItem.getSkull("http://textures.minecraft.net/texture/d7baedaf9ad95474eb1be58924445dfc77bbdc252cc1c81644cf7154c441");
		ItemMeta walrusMeta = walrus.getItemMeta();
		walrusMeta.setDisplayName(ChatColor.GOLD + "Walrus");
		walrus.setItemMeta(walrusMeta);
		
		ItemStack tiger = SkullItem.getSkull("http://textures.minecraft.net/texture/b6b96bbc8ad9bae0e254d35fdfb1db48e822ed97cf5f739d3e9545dd6ce");
		ItemMeta tigerMeta = tiger.getItemMeta();
		tigerMeta.setDisplayName(ChatColor.GOLD + "Tiger");
		tiger.setItemMeta(tigerMeta);
		
		ItemStack panda = SkullItem.getSkull("http://textures.minecraft.net/texture/d188c980aacfa94cf33088512b1b9517ba826b154d4cafc262aff6977be8a");
		ItemMeta pandaMeta = panda.getItemMeta();
		pandaMeta.setDisplayName(ChatColor.GOLD + "Panda");
		panda.setItemMeta(pandaMeta);
		
		ItemStack cat = SkullItem.getSkull("http://textures.minecraft.net/texture/4469bcc3a6d4e44b704349b3f0a416e1e1f9eeb3991e945a99184e09a66b");
		ItemMeta catMeta = cat.getItemMeta();
		catMeta.setDisplayName(ChatColor.GOLD + "Cat");
		cat.setItemMeta(catMeta);
		
		ItemStack angryWolf = SkullItem.getSkull("http://textures.minecraft.net/texture/e95cbb4f75ea87617f2f713c6d49dac3209ba1bd4b9369654b1459ea15317");
		ItemMeta angryWolfMeta = angryWolf.getItemMeta();
		angryWolfMeta.setDisplayName(ChatColor.GOLD + "Angry Wolf");
		angryWolf.setItemMeta(angryWolfMeta);
		
		ItemStack rabbit = SkullItem.getSkull("http://textures.minecraft.net/texture/dc7a317ec5c1ed7788f89e7f1a6af3d2eeb92d1e9879c05343c57f9d863de130");
		ItemMeta rabbitMeta = rabbit.getItemMeta();
		rabbitMeta.setDisplayName(ChatColor.GOLD + "Rabbit");
		rabbit.setItemMeta(rabbitMeta);
		
		ItemStack koala = SkullItem.getSkull("http://textures.minecraft.net/texture/ca35eb10b94e888427fb23c783082658ceb81f3cf5d0aad25d7d41a194b26");
		ItemMeta koalaMeta = koala.getItemMeta();
		koalaMeta.setDisplayName(ChatColor.GOLD + "Koala");
		koala.setItemMeta(koalaMeta);
		
		ItemStack chineseDragon = SkullItem.getSkull("http://textures.minecraft.net/texture/91641d038eb3862b1e022c5e0588d96366da1c944ee5e6ee13e0f5dd7b427b");
		ItemMeta chineseDragonMeta = chineseDragon.getItemMeta();
		chineseDragonMeta.setDisplayName(ChatColor.GOLD + "Chinese Dragon");
		chineseDragon.setItemMeta(chineseDragonMeta);
		
		ItemStack villagerHead = SkullItem.getSkull("http://textures.minecraft.net/texture/c7e575cff11014a5acadf33ee488568cc89e43193511ca74efc83eebb76f4");
		ItemMeta villagerHeadMeta = villagerHead.getItemMeta();
		villagerHeadMeta.setDisplayName(ChatColor.GOLD + "Villager head");
		villagerHead.setItemMeta(villagerHeadMeta);
		
		ItemStack pufferfish = SkullItem.getSkull("http://textures.minecraft.net/texture/a9559388993fe782f67bd58d98c4df56bcd430edcb2f66ef5777a73c27de3");
		ItemMeta pufferfishMeta = pufferfish.getItemMeta();
		pufferfishMeta.setDisplayName(ChatColor.GOLD + "Pufferfish");
		pufferfish.setItemMeta(pufferfishMeta);
		
		ItemStack witherBoss = SkullItem.getSkull("http://textures.minecraft.net/texture/cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f");
		ItemMeta witherBossMeta = witherBoss.getItemMeta();
		witherBossMeta.setDisplayName(ChatColor.GOLD + "Wither Boss");
		witherBoss.setItemMeta(witherBossMeta);
		
		ItemStack snowhead = SkullItem.getSkull("http://textures.minecraft.net/texture/1fdfd1f7538c040258be7a91446da89ed845cc5ef728eb5e690543378fcf4");
		ItemMeta snowheadMeta = snowhead.getItemMeta();
		snowheadMeta.setDisplayName(ChatColor.GOLD + "Snowhead");
		snowhead.setItemMeta(snowheadMeta);
		
		ItemStack snowhead2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a528df1653962e4e995dfd064a72b2cbff9b7197912880143f941a37db46c");
		ItemMeta snowhead2Meta = snowhead2.getItemMeta();
		snowhead2Meta.setDisplayName(ChatColor.GOLD + "Snowhead");
		snowhead2.setItemMeta(snowhead2Meta);
		
		ItemStack clownfish = SkullItem.getSkull("http://textures.minecraft.net/texture/36d149e4d499929672e2768949e6477959c21e65254613b327b538df1e4df");
		ItemMeta clownfishMeta = clownfish.getItemMeta();
		clownfishMeta.setDisplayName(ChatColor.GOLD +  "Clownfish");
		clownfish.setItemMeta(clownfishMeta);
		
		ItemStack bird = SkullItem.getSkull("http://textures.minecraft.net/texture/b9627370fedbd0bae7bae6d6f8583555763789c1bd93fa639cfa3dfd48e34850");
		ItemMeta birdMeta = bird.getItemMeta();
		birdMeta.setDisplayName(ChatColor.GOLD + "Bird");
		bird.setItemMeta(birdMeta);
		
		ItemStack bee = SkullItem.getSkull("http://textures.minecraft.net/texture/947322f831e3c168cfbd3e28fe925144b261e79eb39c771349fac55a8126473");
		ItemMeta beeMeta = bee.getItemMeta();
		beeMeta.setDisplayName(ChatColor.GOLD + "Bee");
		bee.setItemMeta(beeMeta);
		
		ItemStack enderdragon = SkullItem.getSkull("http://textures.minecraft.net/texture/74ecc040785e54663e855ef0486da72154d69bb4b7424b7381ccf95b095a");
		ItemMeta enderdragonMeta = enderdragon.getItemMeta();
		enderdragonMeta.setDisplayName(ChatColor.GOLD + "Enderdragon");
		enderdragon.setItemMeta(enderdragonMeta);
		
		ItemStack hermitCrab = SkullItem.getSkull("http://textures.minecraft.net/texture/185e6834a4bf26a6526f7cac4f6eaa9f7fa77db8c14353a81582b5f699");
		ItemMeta hermitCrabMeta = hermitCrab.getItemMeta();
		hermitCrabMeta.setDisplayName(ChatColor.GOLD + "Hermit Crab");
		hermitCrab.setItemMeta(hermitCrabMeta);
		
		ItemStack regularFish = SkullItem.getSkull("http://textures.minecraft.net/texture/6f99b580d45a784e7a964e7d3b1f97cece74911173bd21c1d7c56acdc385ed5");
		ItemMeta regularFishMeta = regularFish.getItemMeta();
		regularFishMeta.setDisplayName(ChatColor.GOLD + "Regular Fish");
		regularFish.setItemMeta(regularFishMeta);
		
		ItemStack salmonFish = SkullItem.getSkull("textures.minecraft.net/texture/adfc57d09059e4799fa92c15e28512bcfaa1315577fe3a27aed389e4f752289a");
		ItemMeta salmonFishMeta = salmonFish.getItemMeta();
		salmonFishMeta.setDisplayName(ChatColor.GOLD + "Salmon Fish");
		salmonFish.setItemMeta(salmonFishMeta);
		
		ItemStack tortoise = SkullItem.getSkull("http://textures.minecraft.net/texture/12e548408ab75d7df8e6d5d2446d90b6ec62aa4f7feb7930d1ee71eefddf6189");
		ItemMeta tortoiseMeta = tortoise.getItemMeta();
		tortoiseMeta.setDisplayName(ChatColor.GOLD + "Tortoise");
		tortoise.setItemMeta(tortoiseMeta);
		
		ItemStack seagull = SkullItem.getSkull("http://textures.minecraft.net/texture/c3bde43111f69a7fda6ec6faf2263c827961f390d7c6163ed1231035d1b0b9");
		ItemMeta seagullMeta = seagull.getItemMeta();
		seagullMeta.setDisplayName(ChatColor.GOLD + "Seagull");
		seagull.setItemMeta(seagullMeta);
		
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
		
		inventory.setItem(0, blaze);
		inventory.setItem(1, caveSpider);
		inventory.setItem(2, ghast);
		inventory.setItem(3, pigzombie);
		inventory.setItem(4, enderman);
		inventory.setItem(5, lavaSlime);
		inventory.setItem(6, slime);
		inventory.setItem(7, spider);
		inventory.setItem(8, chicken);
		inventory.setItem(9, pig);
		inventory.setItem(10, sheep);
		inventory.setItem(11, cow);
		inventory.setItem(12, squid);
		inventory.setItem(13, villager);
		inventory.setItem(14, golem);
		inventory.setItem(15, herobrine);
		inventory.setItem(16, mushroomCow);
		inventory.setItem(17, ocelot);
		inventory.setItem(18, horseHead);
		inventory.setItem(19, guardian);
		inventory.setItem(20, monkey);
		inventory.setItem(21, polarBear);
		inventory.setItem(22, penguin);
		inventory.setItem(23, walrus);
		inventory.setItem(24, tiger);
		inventory.setItem(25, panda);
		inventory.setItem(26, cat);
		inventory.setItem(27, angryWolf);
		inventory.setItem(28, rabbit);
		inventory.setItem(29, koala);
		inventory.setItem(30, chineseDragon);
		inventory.setItem(31, villagerHead);
		inventory.setItem(32, pufferfish);
		inventory.setItem(33, witherBoss);
		inventory.setItem(34, snowhead);
		inventory.setItem(35, snowhead2);
		inventory.setItem(36, clownfish);
		inventory.setItem(37, bird);
		inventory.setItem(38, bee);
		inventory.setItem(39, enderdragon);
		inventory.setItem(40, hermitCrab);
		inventory.setItem(41, regularFish);
		inventory.setItem(42, salmonFish);
		inventory.setItem(43, tortoise);
		inventory.setItem(44, seagull);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}