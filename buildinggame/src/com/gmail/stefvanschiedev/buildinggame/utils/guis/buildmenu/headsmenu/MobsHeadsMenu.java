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
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.SkullItem;

/**
 * The gui for the heads in the mobs category
 *
 * @since 4.0.0
 */
public class MobsHeadsMenu extends Gui {

    /**
     * Yaml Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new menu and adds all items to it
     *
     * @since 4.0.0
     */
	public MobsHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.mobs.title")), 2);
		
		//page one
		ItemStack blaze = SkullItem.getSkull("http://textures.minecraft.net/texture/67e7ae12195c8c97a7706efc7bfc2851666c9f1d53b6ce075569922b4263bd");
		ItemMeta blazeMeta = blaze.getItemMeta();
		blazeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.blaze.name")));
		blazeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.blaze.lores")));
		blaze.setItemMeta(blazeMeta);
		
		addItem(blaze, new Action());
		
		ItemStack caveSpider = SkullItem.getSkull("http://textures.minecraft.net/texture/41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224");
		ItemMeta caveSpiderMeta = caveSpider.getItemMeta();
		caveSpiderMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.cave-spider.name")));
		caveSpiderMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.cave-spider.lores")));
		caveSpider.setItemMeta(caveSpiderMeta);
		
		addItem(caveSpider, new Action());
		
		ItemStack ghast = SkullItem.getSkull("http://textures.minecraft.net/texture/8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0");
		ItemMeta ghastMeta = ghast.getItemMeta();
		ghastMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.ghast.name")));
		ghastMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.ghast.lores")));
		ghast.setItemMeta(ghastMeta);
		
		addItem(ghast, new Action());
		
		ItemStack pigzombie = SkullItem.getSkull("http://textures.minecraft.net/texture/74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb");
		ItemMeta pigzombieMeta = pigzombie.getItemMeta();
		pigzombieMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.pigzombie.name")));
		pigzombieMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.pigzombie.lores")));
		pigzombie.setItemMeta(pigzombieMeta);
		
		addItem(pigzombie, new Action());
		
		ItemStack enderman = SkullItem.getSkull("http://textures.minecraft.net/texture/7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf");
		ItemMeta endermanMeta = enderman.getItemMeta();
		endermanMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.enderman.name")));
		endermanMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.enderman.lores")));
		enderman.setItemMeta(endermanMeta);
		
		addItem(enderman, new Action());
		
		ItemStack lavaSlime = SkullItem.getSkull("http://textures.minecraft.net/texture/b396fbf43413c0168697349953ec6daeffb7816e9acbbeaaf77c1ff3137f2ba3");
		ItemMeta lavaSlimeMeta = lavaSlime.getItemMeta();
		lavaSlimeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.lava-slime.name")));
		lavaSlimeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.lava-slime.lores")));
		lavaSlime.setItemMeta(lavaSlimeMeta);
		
		addItem(lavaSlime, new Action());
		
		ItemStack slime = SkullItem.getSkull("http://textures.minecraft.net/texture/cb38f01fb5fd75b7c2674a74c70f83cf8ccf96b799d605711b638d556c");
		ItemMeta slimeMeta = slime.getItemMeta();
		slimeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.slime.name")));
		slimeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.slime.lores")));
		slime.setItemMeta(slimeMeta);
		
		addItem(slime, new Action());
		
		ItemStack spider = SkullItem.getSkull("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
		ItemMeta spiderMeta = spider.getItemMeta();
		spiderMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.spider.name")));
		spiderMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.spider.lores")));
		spider.setItemMeta(spiderMeta);
		
		addItem(spider, new Action());
		
		ItemStack chicken = SkullItem.getSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893");
		ItemMeta chickenMeta = chicken.getItemMeta();
		chickenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.chicken.name")));
		chickenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.chicken.lores")));
		chicken.setItemMeta(chickenMeta);
		
		addItem(chicken, new Action());
		
		ItemStack pig = SkullItem.getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
		ItemMeta pigMeta = pig.getItemMeta();
		pigMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.pig.name")));
		pigMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.pig.lores")));
		pig.setItemMeta(pigMeta);
		
		addItem(pig, new Action());
		
		ItemStack sheep = SkullItem.getSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
		ItemMeta sheepMeta = sheep.getItemMeta();
		sheepMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.sheep.name")));
		sheepMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.sheep.lores")));
		sheep.setItemMeta(sheepMeta);
		
		addItem(sheep, new Action());
		
		ItemStack cow = SkullItem.getSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5");
		ItemMeta cowMeta = cow.getItemMeta();
		cowMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.cow.name")));
		cowMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.cow.lores")));
		cow.setItemMeta(cowMeta);
		
		addItem(cow, new Action());
		
		ItemStack squid = SkullItem.getSkull("http://textures.minecraft.net/texture/01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac");
		ItemMeta squidMeta = squid.getItemMeta();
		squidMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.squid.name")));
		squidMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.squid.lores")));
		squid.setItemMeta(squidMeta);
		
		addItem(squid, new Action());
		
		ItemStack villager = SkullItem.getSkull("http://textures.minecraft.net/texture/822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b");
		ItemMeta villagerMeta = villager.getItemMeta();
		villagerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.villager.name")));
		villagerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.villager.lores")));
		villager.setItemMeta(villagerMeta);
		
		addItem(villager, new Action());
		
		ItemStack golem = SkullItem.getSkull("http://textures.minecraft.net/texture/89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714");
		ItemMeta golemMeta = golem.getItemMeta();
		golemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.golem.name")));
		golemMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.golem.lores")));
		golem.setItemMeta(golemMeta);
		
		addItem(golem, new Action());
		
		ItemStack herobrine = SkullItem.getSkull("http://textures.minecraft.net/texture/98b7ca3c7d314a61abed8fc18d797fc30b6efc8445425c4e250997e52e6cb");
		ItemMeta herobrineMeta = herobrine.getItemMeta();
		herobrineMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.herobrine.name")));
		herobrineMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.herobrine.lores")));
		herobrine.setItemMeta(herobrineMeta);
		
		addItem(herobrine, new Action());
		
		ItemStack mushroomCow = SkullItem.getSkull("http://textures.minecraft.net/texture/d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db");
		ItemMeta mushroomCowMeta = mushroomCow.getItemMeta();
		mushroomCowMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.mushroom-cow.name")));
		mushroomCowMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.mushroom-cow.lores")));
		mushroomCow.setItemMeta(mushroomCowMeta);
		
		addItem(mushroomCow, new Action());
		
		ItemStack ocelot = SkullItem.getSkull("http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1");
		ItemMeta ocelotMeta = ocelot.getItemMeta();
		ocelotMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.ocelot.name")));
		ocelotMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.ocelot.lores")));
		ocelot.setItemMeta(ocelotMeta);

		addItem(ocelot, new Action());
		
		ItemStack horseHead = SkullItem.getSkull("http://textures.minecraft.net/texture/e1a62ddc5c7ef643fb264df7ededea3769eeb6484e35b906e99f1fbdc33");
		ItemMeta horseHeadMeta = horseHead.getItemMeta();
		horseHeadMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.horse-head.name")));
		horseHeadMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.horse-head.lores")));
		horseHead.setItemMeta(horseHeadMeta);
		
		addItem(horseHead, new Action());
		
		ItemStack guardian = SkullItem.getSkull("http://textures.minecraft.net/texture/932c24524c82ab3b3e57c2052c533f13dd8c0beb8bdd06369bb2554da86c123");
		ItemMeta guardianMeta = guardian.getItemMeta();
		guardianMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.guardian.name")));
		guardianMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.guardian.lores")));
		guardian.setItemMeta(guardianMeta);
		
		addItem(guardian, new Action());
		
		ItemStack monkey = SkullItem.getSkull("http://textures.minecraft.net/texture/e9f2dcbcde8a227cd3d285799a3b2d4bffe3b4db20203c90bea1afcf24176bd");
		ItemMeta monkeyMeta = monkey.getItemMeta();
		monkeyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.monkey.name")));
		monkeyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.monkey.lores")));
		monkey.setItemMeta(monkeyMeta);

		addItem(monkey, new Action());
		
		ItemStack polarBear = SkullItem.getSkull("http://textures.minecraft.net/texture/d46d23f04846369fa2a3702c10f759101af7bfe8419966429533cd81a11d2b");
		ItemMeta polarBearMeta = polarBear.getItemMeta();
		polarBearMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.polar-bear.name")));
		polarBearMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.polar-bear.lores")));
		polarBear.setItemMeta(polarBearMeta);
		
		addItem(polarBear, new Action());
		
		ItemStack penguin = SkullItem.getSkull("http://textures.minecraft.net/texture/d3c57facbb3a4db7fd55b5c0dc7d19c19cb0813c748ccc9710c714727551f5b9");
		ItemMeta penguinMeta = penguin.getItemMeta();
		penguinMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.penguin.name")));
		penguinMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.penguin.lores")));
		penguin.setItemMeta(penguinMeta);
		
		addItem(penguin, new Action());
		
		ItemStack walrus = SkullItem.getSkull("http://textures.minecraft.net/texture/d7baedaf9ad95474eb1be58924445dfc77bbdc252cc1c81644cf7154c441");
		ItemMeta walrusMeta = walrus.getItemMeta();
		walrusMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.walrus.name")));
		walrusMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.walrus.lores")));
		walrus.setItemMeta(walrusMeta);
		
		addItem(walrus, new Action());
		
		ItemStack tiger = SkullItem.getSkull("http://textures.minecraft.net/texture/b6b96bbc8ad9bae0e254d35fdfb1db48e822ed97cf5f739d3e9545dd6ce");
		ItemMeta tigerMeta = tiger.getItemMeta();
		tigerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.tiger.name")));
		tigerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.tiger.lores")));
		tiger.setItemMeta(tigerMeta);
		
		addItem(tiger, new Action());
		
		ItemStack panda = SkullItem.getSkull("http://textures.minecraft.net/texture/d188c980aacfa94cf33088512b1b9517ba826b154d4cafc262aff6977be8a");
		ItemMeta pandaMeta = panda.getItemMeta();
		pandaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.panda.name")));
		pandaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.panda.lores")));
		panda.setItemMeta(pandaMeta);
		
		addItem(panda, new Action());
		
		ItemStack cat = SkullItem.getSkull("http://textures.minecraft.net/texture/4469bcc3a6d4e44b704349b3f0a416e1e1f9eeb3991e945a99184e09a66b");
		ItemMeta catMeta = cat.getItemMeta();
		catMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.cat.name")));
		catMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.cat.lores")));
		cat.setItemMeta(catMeta);
		
		addItem(cat, new Action());
		
		ItemStack angryWolf = SkullItem.getSkull("http://textures.minecraft.net/texture/e95cbb4f75ea87617f2f713c6d49dac3209ba1bd4b9369654b1459ea15317");
		ItemMeta angryWolfMeta = angryWolf.getItemMeta();
		angryWolfMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.angry-wolf.name")));
		angryWolfMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.angry-wolf.lores")));
		angryWolf.setItemMeta(angryWolfMeta);
		
		addItem(angryWolf, new Action());
		
		ItemStack rabbit = SkullItem.getSkull("http://textures.minecraft.net/texture/dc7a317ec5c1ed7788f89e7f1a6af3d2eeb92d1e9879c05343c57f9d863de130");
		ItemMeta rabbitMeta = rabbit.getItemMeta();
		rabbitMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.rabbit.name")));
		rabbitMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.rabbit.lores")));
		rabbit.setItemMeta(rabbitMeta);
		
		addItem(rabbit, new Action());
		
		ItemStack koala = SkullItem.getSkull("http://textures.minecraft.net/texture/ca35eb10b94e888427fb23c783082658ceb81f3cf5d0aad25d7d41a194b26");
		ItemMeta koalaMeta = koala.getItemMeta();
		koalaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.koala.name")));
		koalaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.koala.lores")));
		koala.setItemMeta(koalaMeta);
		
		addItem(koala, new Action());
		
		ItemStack chineseDragon = SkullItem.getSkull("http://textures.minecraft.net/texture/91641d038eb3862b1e022c5e0588d96366da1c944ee5e6ee13e0f5dd7b427b");
		ItemMeta chineseDragonMeta = chineseDragon.getItemMeta();
		chineseDragonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.chinese-dragon.name")));
		chineseDragonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.chinese-dragon.lores")));
		chineseDragon.setItemMeta(chineseDragonMeta);
		
		addItem(chineseDragon, new Action());
		
		ItemStack villagerHead = SkullItem.getSkull("http://textures.minecraft.net/texture/c7e575cff11014a5acadf33ee488568cc89e43193511ca74efc83eebb76f4");
		ItemMeta villagerHeadMeta = villagerHead.getItemMeta();
		villagerHeadMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.villager-head.name")));
		villagerHeadMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.villager-head.lores")));
		villagerHead.setItemMeta(villagerHeadMeta);
		
		addItem(villagerHead, new Action());
		
		ItemStack pufferfish = SkullItem.getSkull("http://textures.minecraft.net/texture/a9559388993fe782f67bd58d98c4df56bcd430edcb2f66ef5777a73c27de3");
		ItemMeta pufferfishMeta = pufferfish.getItemMeta();
		pufferfishMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.pufferfish.name")));
		pufferfishMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.pufferfish.lores")));
		pufferfish.setItemMeta(pufferfishMeta);
		
		addItem(pufferfish, new Action());
		
		ItemStack witherBoss = SkullItem.getSkull("http://textures.minecraft.net/texture/cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f");
		ItemMeta witherBossMeta = witherBoss.getItemMeta();
		witherBossMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.wither-boss.name")));
		witherBossMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.wither-boss.lores")));
		witherBoss.setItemMeta(witherBossMeta);
		
		addItem(witherBoss, new Action());
		
		ItemStack snowhead = SkullItem.getSkull("http://textures.minecraft.net/texture/1fdfd1f7538c040258be7a91446da89ed845cc5ef728eb5e690543378fcf4");
		ItemMeta snowheadMeta = snowhead.getItemMeta();
		snowheadMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.snowhead.name")));
		snowheadMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.snowhead.lores")));
		snowhead.setItemMeta(snowheadMeta);
		
		addItem(snowhead, new Action());
		
		ItemStack snowhead2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a528df1653962e4e995dfd064a72b2cbff9b7197912880143f941a37db46c");
		ItemMeta snowhead2Meta = snowhead2.getItemMeta();
		snowhead2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.snowhead-2.name")));
		snowhead2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.snowhead-2.lores")));
		snowhead2.setItemMeta(snowhead2Meta);
		
		addItem(snowhead2, new Action());
		
		ItemStack clownfish = SkullItem.getSkull("http://textures.minecraft.net/texture/36d149e4d499929672e2768949e6477959c21e65254613b327b538df1e4df");
		ItemMeta clownfishMeta = clownfish.getItemMeta();
		clownfishMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.clownfish.name")));
		clownfishMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.clownfish.lores")));
		clownfish.setItemMeta(clownfishMeta);
		
		addItem(clownfish, new Action());
		
		ItemStack bird = SkullItem.getSkull("http://textures.minecraft.net/texture/b9627370fedbd0bae7bae6d6f8583555763789c1bd93fa639cfa3dfd48e34850");
		ItemMeta birdMeta = bird.getItemMeta();
		birdMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.bird.name")));
		birdMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.bird.lores")));
		bird.setItemMeta(birdMeta);
		
		addItem(bird, new Action());
		
		ItemStack bee = SkullItem.getSkull("http://textures.minecraft.net/texture/947322f831e3c168cfbd3e28fe925144b261e79eb39c771349fac55a8126473");
		ItemMeta beeMeta = bee.getItemMeta();
		beeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.bee.name")));
		beeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.bee.lores")));
		bee.setItemMeta(beeMeta);
		
		addItem(bee, new Action());
		
		ItemStack enderdragon = SkullItem.getSkull("http://textures.minecraft.net/texture/74ecc040785e54663e855ef0486da72154d69bb4b7424b7381ccf95b095a");
		ItemMeta enderdragonMeta = enderdragon.getItemMeta();
		enderdragonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.enderdragon.name")));
		enderdragonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.enderdragon.lores")));
		enderdragon.setItemMeta(enderdragonMeta);
		
		addItem(enderdragon, new Action());
		
		ItemStack hermitCrab = SkullItem.getSkull("http://textures.minecraft.net/texture/185e6834a4bf26a6526f7cac4f6eaa9f7fa77db8c14353a81582b5f699");
		ItemMeta hermitCrabMeta = hermitCrab.getItemMeta();
		hermitCrabMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.hermit-crab.name")));
		hermitCrabMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.hermit-crab.lores")));
		hermitCrab.setItemMeta(hermitCrabMeta);
		
		addItem(hermitCrab, new Action());
		
		ItemStack regularFish = SkullItem.getSkull("http://textures.minecraft.net/texture/6f99b580d45a784e7a964e7d3b1f97cece74911173bd21c1d7c56acdc385ed5");
		ItemMeta regularFishMeta = regularFish.getItemMeta();
		regularFishMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.regular-fish.name")));
		regularFishMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.regular-fish.lores")));
		regularFish.setItemMeta(regularFishMeta);
		
		addItem(regularFish, new Action());
		
		ItemStack salmonFish = SkullItem.getSkull("http://textures.minecraft.net/texture/adfc57d09059e4799fa92c15e28512bcfaa1315577fe3a27aed389e4f752289a");
		ItemMeta salmonFishMeta = salmonFish.getItemMeta();
		salmonFishMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.salmon-fish.name")));
		salmonFishMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.salmon-fish.lores")));
		salmonFish.setItemMeta(salmonFishMeta);
		
		addItem(salmonFish, new Action());
		
		ItemStack tortoise = SkullItem.getSkull("http://textures.minecraft.net/texture/12e548408ab75d7df8e6d5d2446d90b6ec62aa4f7feb7930d1ee71eefddf6189");
		ItemMeta tortoiseMeta = tortoise.getItemMeta();
		tortoiseMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.tortoise.name")));
		tortoiseMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.tortoise.lores")));
		tortoise.setItemMeta(tortoiseMeta);
		
		addItem(tortoise, new Action());
		
		ItemStack seagull = SkullItem.getSkull("http://textures.minecraft.net/texture/c3bde43111f69a7fda6ec6faf2263c827961f390d7c6163ed1231035d1b0b9");
		ItemMeta seagullMeta = seagull.getItemMeta();
		seagullMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.seagull.name")));
		seagullMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.seagull.lores")));
		seagull.setItemMeta(seagullMeta);
		
		addItem(seagull, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.close.lores")));
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
		nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.next-page.name")));
		nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.next-page.lores")));
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
		ItemStack ferret = SkullItem.getSkull("http://textures.minecraft.net/texture/236edf7de9adca72308a94d1c38c358acc82918fe8fced25d474820f4cb784");
		ItemMeta ferretMeta = ferret.getItemMeta();
		ferretMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.ferret.name")));
		ferretMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.ferret.lores")));
		ferret.setItemMeta(ferretMeta);
		
		addItem(ferret, new Action());
		
		ItemStack elephant = SkullItem.getSkull("http://textures.minecraft.net/texture/7071a76f669db5ed6d32b48bb2dba55d5317d7f45225cb3267ec435cfa514");
		ItemMeta elephantMeta = elephant.getItemMeta();
		elephantMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.elephant.name")));
		elephantMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.elephant.lores")));
		elephant.setItemMeta(elephantMeta);
		
		addItem(elephant, new Action());
		
		ItemStack furby = SkullItem.getSkull("http://textures.minecraft.net/texture/7bff527562889e16a544f2f996fba3d9541d0aacf81462bffc9fb5cad8aedd5");
		ItemMeta furbyMeta = furby.getItemMeta();
		furbyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.furby.name")));
		furbyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.furby.lores")));
		furby.setItemMeta(furbyMeta);
		
		addItem(furby, new Action());
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.previous-page.lores")));
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
		close2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.mobs.close.name")));
		close2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.mobs.close.lores")));
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
	}

    /**
     * The action that belongs to the heads
     *
     * @since 4.0.0
     */
	public class Action extends GuiAction {

        /**
         * Called whenever a player clicks on an item in the menu
         *
         * @since 4.0.0
         */
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