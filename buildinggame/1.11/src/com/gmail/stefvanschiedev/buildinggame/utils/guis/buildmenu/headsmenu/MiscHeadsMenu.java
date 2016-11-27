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

public class MiscHeadsMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public MiscHeadsMenu() {
		super(null, 54, MessageManager.translate(messages.getString("gui.heads.misc.title")), 2);
		
		ItemStack goldPot = SkullItem.getSkull("http://textures.minecraft.net/texture/aa976f6dfcf188995a327e55ce34c60e6dcd1ff63e68dd1fc3ad75d2d1bf");
		ItemMeta goldPotMeta = goldPot.getItemMeta();
		goldPotMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.gold-pot.name")));
		goldPotMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.gold-pot.lores")));
		goldPot.setItemMeta(goldPotMeta);
		
		addItem(goldPot, new Action());
		
		ItemStack lavaBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/8d5427a83540a08a3fa2e655c2964a07243514584a71ec35d6b9e184dfbe318");
		ItemMeta lavaBucketMeta = lavaBucket.getItemMeta();
		lavaBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.lava-bucket.name")));
		lavaBucketMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.lava-bucket.lores")));
		lavaBucket.setItemMeta(lavaBucketMeta);
		
		addItem(lavaBucket, new Action());
		
		ItemStack milkBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/f58c975661c3e94fc35115648158e3ee9f80df74a4399e4d31ca5dbbcaf29b6");
		ItemMeta milkBucketMeta = milkBucket.getItemMeta();
		milkBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.milk-bucket.name")));
		milkBucketMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.milk-bucket.lores")));
		milkBucket.setItemMeta(milkBucketMeta);
		
		addItem(milkBucket, new Action());
		
		ItemStack emptyBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/21ea825150b06e65e2ceb593afe342dca56dda12bf6c9696fb82f90dcd423ab");
		ItemMeta emptyBucketMeta = emptyBucket.getItemMeta();
		emptyBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.empty-bucket.name")));
		emptyBucketMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.empty-bucket.lores")));
		emptyBucket.setItemMeta(emptyBucketMeta);
		
		addItem(emptyBucket, new Action());
		
		ItemStack waterBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/49f1f07e2b1c32bb64a128e529f3af1e5286e518544edf8cbaa6c4065b476b");
		ItemMeta waterBucketMeta = waterBucket.getItemMeta();
		waterBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.water-bucket.name")));
		waterBucketMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.water-bucket.lores")));
		waterBucket.setItemMeta(waterBucketMeta);
		
		addItem(waterBucket, new Action());
		
		ItemStack mailbox = SkullItem.getSkull("http://textures.minecraft.net/texture/4c7f684d3ac3a59a9c766233423b46451bff7b9642bb589a7edc5aef457e7");
		ItemMeta mailboxMeta = mailbox.getItemMeta();
		mailboxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.mailbox.name")));
		mailboxMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.mailbox.lores")));
		mailbox.setItemMeta(mailboxMeta);
		
		addItem(mailbox, new Action());
		
		ItemStack spaceHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/3e8aad673157c92317a88b1f86f5271f1cd7397d7fc8ec3281f733f751634");
		ItemMeta spaceHelmetMeta = spaceHelmet.getItemMeta();
		spaceHelmetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.space-helmet.name")));
		spaceHelmetMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.space-helmet.lores")));
		spaceHelmet.setItemMeta(spaceHelmetMeta);
		
		addItem(spaceHelmet, new Action());
		
		ItemStack spaceHelmet2 = SkullItem.getSkull("http://textures.minecraft.net/texture/302e22f6503c363df69bf9e9448fe89d2f05bae30534b8bb19d268f0989b96");
		ItemMeta spaceHelmet2Meta = spaceHelmet2.getItemMeta();
		spaceHelmet2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.space-helmet-2.name")));
		spaceHelmet2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.space-helmet-2.lores")));
		spaceHelmet2.setItemMeta(spaceHelmet2Meta);
		
		addItem(spaceHelmet2, new Action());
		
		ItemStack footballHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/4d7b62aca28445b8e11ea1750eeacd97932fa37ba744768573e8dc58a6af1");
		ItemMeta footballHelmetMeta = footballHelmet.getItemMeta();
		footballHelmetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.football-helmet.name")));
		footballHelmetMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.football-helmet.lores")));
		footballHelmet.setItemMeta(footballHelmetMeta);
		
		addItem(footballHelmet, new Action());
		
		ItemStack eye = SkullItem.getSkull("http://textures.minecraft.net/texture/2cef87772afd85b468f4c7fb9571e31435ef765ad413fe460262150423e2021");
		ItemMeta eyeMeta = eye.getItemMeta();
		eyeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.eye.name")));
		eyeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.eye.lores")));
		eye.setItemMeta(eyeMeta);
		
		addItem(eye, new Action());
		
		ItemStack redMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/732dbd6612e9d3f42947b5ca8785bfb334258f3ceb83ad69a5cdeebea4cd65");
		ItemMeta redMushroomMeta = redMushroom.getItemMeta();
		redMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.red-mushroom.name")));
		redMushroomMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.red-mushroom.lores")));
		redMushroom.setItemMeta(redMushroomMeta);
		
		addItem(redMushroom, new Action());
		
		ItemStack pineCone = SkullItem.getSkull("http://textures.minecraft.net/texture/1988ec65c51a85772c8d86d74ea8e0e572523bf8edc8cba5ad11952fbebe660");
		ItemMeta pineConeMeta = pineCone.getItemMeta();
		pineConeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.pine-cone.name")));
		pineConeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.pine-cone.lores")));
		pineCone.setItemMeta(pineConeMeta);
		
		addItem(pineCone, new Action());
		
		ItemStack cannonball = SkullItem.getSkull("http://textures.minecraft.net/texture/22523e15e9986355a1f851f43f750ee3f23c89ae123631da241f872ba7a781");
		ItemMeta cannonballMeta = cannonball.getItemMeta();
		cannonballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cannonball.name")));
		cannonballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cannonball.lores")));
		cannonball.setItemMeta(cannonballMeta);
		
		addItem(cannonball, new Action());
		
		ItemStack cannonball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/996754d330435345aae3a9f063cfca42afb28b7c5c4bb9f294ed2527d961");
		ItemMeta cannonball2Meta = cannonball2.getItemMeta();
		cannonball2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cannonball-2.name")));
		cannonball2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cannonball-2.lores")));
		cannonball2.setItemMeta(cannonball2Meta);
		
		addItem(cannonball2, new Action());
		
		ItemStack target = SkullItem.getSkull("http://textures.minecraft.net/texture/86fcaefa19669d8be02cf5ba9a7f2cf6d27e636410496ffcfa62b03dceb9d378");
		ItemMeta targetMeta = target.getItemMeta();
		targetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.target.name")));
		targetMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.target.lores")));
		target.setItemMeta(targetMeta);
		
		addItem(target, new Action());
		
		ItemStack cactus = SkullItem.getSkull("http://textures.minecraft.net/texture/38c9a730269ce1de3e9fa064afb370cbcd0766d729f3e29e4f320a433b098b5");
		ItemMeta cactusMeta = cactus.getItemMeta();
		cactusMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cactus.name")));
		cactusMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cactus.lores")));
		cactus.setItemMeta(cactusMeta);

		addItem(cactus, new Action());
		
		ItemStack facebook = SkullItem.getSkull("http://textures.minecraft.net/texture/deb46126904463f07ecfc972aaa37373a22359b5ba271821b689cd5367f75762");
		ItemMeta facebookMeta = facebook.getItemMeta();
		facebookMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.facebook.name")));
		facebookMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.facebook.lores")));
		facebook.setItemMeta(facebookMeta);

		addItem(facebook, new Action());
		
		ItemStack twitter = SkullItem.getSkull("http://textures.minecraft.net/texture/3685a0be743e9067de95cd8c6d1ba21ab21d37371b3d597211bb75e43279");
		ItemMeta twitterMeta = twitter.getItemMeta();
		twitterMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.twitter.name")));
		twitterMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.twitter.lores")));
		twitter.setItemMeta(twitterMeta);

		addItem(twitter, new Action());
		
		ItemStack youtube = SkullItem.getSkull("http://textures.minecraft.net/texture/b4353fd0f86314353876586075b9bdf0c484aab0331b872df11bd564fcb029ed");
		ItemMeta youtubeMeta = youtube.getItemMeta();
		youtubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.youtube.name")));
		youtubeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.youtube.lores")));
		youtube.setItemMeta(youtubeMeta);
		
		addItem(youtube, new Action());
		
		ItemStack firecharge = SkullItem.getSkull("http://textures.minecraft.net/texture/9c2e9d8395cacd9922869c15373cf7cb16da0a5ce5f3c632b19ceb3929c9a11");
		ItemMeta firechargeMeta = firecharge.getItemMeta();
		firechargeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.firecharge.name")));
		firechargeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.firecharge.lores")));
		firecharge.setItemMeta(firechargeMeta);
		
		addItem(firecharge, new Action());
		
		ItemStack portableGrill = SkullItem.getSkull("http://textures.minecraft.net/texture/318e35ec4b4b4c1591c5177386de18797454298b7455982e3ae83bacced0f1a2");
		ItemMeta portableGrillMeta = portableGrill.getItemMeta();
		portableGrillMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.portable-grill.name")));
		portableGrillMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.portable-grill.lores")));
		portableGrill.setItemMeta(portableGrillMeta);
		
		addItem(portableGrill, new Action());
		
		ItemStack wilsonCastaway = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonCastawayMeta = wilsonCastaway.getItemMeta();
		wilsonCastawayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.wilson-castaway.name")));
		wilsonCastawayMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.wilson-castaway.lores")));
		wilsonCastaway.setItemMeta(wilsonCastawayMeta);
		
		addItem(wilsonCastaway, new Action());
		
		ItemStack mailbox2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dacbbca567372a9b2b36c8f68154851bda5ee1d53e2bc208a1152d9a18d2cb");
		ItemMeta mailbox2Meta = mailbox2.getItemMeta();
		mailbox2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.mailbox-2.name")));
		mailbox2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.mailbox-2.lores")));
		mailbox2.setItemMeta(mailbox2Meta);
		
		addItem(mailbox2, new Action());
		
		ItemStack skull = SkullItem.getSkull("http://textures.minecraft.net/texture/1ae3855f952cd4a03c148a946e3f812a5955ad35cbcb52627ea4acd47d3081");
		ItemMeta skullMeta = skull.getItemMeta();
		skullMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.skull.name")));
		skullMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.skull.lores")));
		skull.setItemMeta(skullMeta);
		
		addItem(skull, new Action());
		
		ItemStack missingTexture = SkullItem.getSkull("http://textures.minecraft.net/texture/e9eb9da26cf2d3341397a7f4913ba3d37d1ad10eae30ab25fa39ceb84bc");
		ItemMeta missingTextureMeta = missingTexture.getItemMeta();
		missingTextureMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.missing-texture.name")));
		missingTextureMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.missing-texture.lores")));
		missingTexture.setItemMeta(missingTextureMeta);
		
		addItem(missingTexture, new Action());
		
		ItemStack greenOre = SkullItem.getSkull("http://textures.minecraft.net/texture/58c206e29924b9916d4d24dfbbc38f28b44d6d3cfa23adec9ed3a8fce1b7b2");
		ItemMeta greenOreMeta = greenOre.getItemMeta();
		greenOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.green-ore.name")));
		greenOreMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.green-ore.lores")));
		greenOre.setItemMeta(greenOreMeta);
		
		addItem(greenOre, new Action());
		
		ItemStack cactusflower = SkullItem.getSkull("http://textures.minecraft.net/texture/904f1a55943c594e7119e884c5da2a2bca8e7e6516a0649aa7e55658e0e9");
		ItemMeta cactusflowerMeta = cactusflower.getItemMeta();
		cactusflowerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cactusflower.name")));
		cactusflowerMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cactusflower.lores")));
		cactusflower.setItemMeta(cactusflowerMeta);
		
		addItem(cactusflower, new Action());
		
		ItemStack moltenCore = SkullItem.getSkull("http://textures.minecraft.net/texture/5bb28bb0bf1ad217d2a81191effcc69fe174714a432fd71fa60aa50f3712b97");
		ItemMeta moltenCoreMeta = moltenCore.getItemMeta();
		moltenCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.molten-core.name")));
		moltenCoreMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.molten-core.lores")));
		moltenCore.setItemMeta(moltenCoreMeta);

		addItem(moltenCore, new Action());
		
		ItemStack reddit = SkullItem.getSkull("http://textures.minecraft.net/texture/4d9bd4b2fa8da8247a82c3d1fa246715f9b6d98c778374da6efc10c89cd64");
		ItemMeta redditMeta = reddit.getItemMeta();
		redditMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.reddit.name")));
		redditMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.reddit.lores")));
		reddit.setItemMeta(redditMeta);
		
		addItem(reddit, new Action());
		
		ItemStack diamondSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/10b8eb333622ae7de9b53b3602f41f63db9c2528b5be231ac96516611fb1a");
		ItemMeta diamondSteveHeadMeta = diamondSteveHead.getItemMeta();
		diamondSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.diamond-steve-head.name")));
		diamondSteveHeadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.diamond-steve-head.lores")));
		diamondSteveHead.setItemMeta(diamondSteveHeadMeta);
		
		addItem(diamondSteveHead, new Action());
		
		ItemStack goldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/f937e1c45bb8da29b2c564dd9a7da780dd2fe54468a5dfb4113b4ff658f043e1");
		ItemMeta goldSteveHeadMeta = goldSteveHead.getItemMeta();
		goldSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.gold-steve-head.name")));
		goldSteveHeadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.gold-steve-head.lores")));
		goldSteveHead.setItemMeta(goldSteveHeadMeta);
		
		addItem(goldSteveHead, new Action());
		
		ItemStack mushroomStem = SkullItem.getSkull("http://textures.minecraft.net/texture/f55fa642d5ebcba2c5246fe6499b1c4f6803c10f14f5299c8e59819d5dc");
		ItemMeta mushroomStemMeta = mushroomStem.getItemMeta();
		mushroomStemMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.mushroom-stem.name")));
		mushroomStemMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.mushroom-stem.lores")));
		mushroomStem.setItemMeta(mushroomStemMeta);
		
		addItem(mushroomStem, new Action());
		
		ItemStack brownMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/fa49eca0369d1e158e539d78149acb1572949b88ba921d9ee694fea4c726b3");
		ItemMeta brownMushroomMeta = brownMushroom.getItemMeta();
		brownMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.brown-mushroom.name")));
		brownMushroomMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.brown-mushroom.lores")));
		brownMushroom.setItemMeta(brownMushroomMeta);
		
		addItem(brownMushroom, new Action());
		
		ItemStack cocoaBean = SkullItem.getSkull("http://textures.minecraft.net/texture/5083ec2b01dc0fee79aa32188d9429acc68ecf71408dca04aaab53ad8bea0");
		ItemMeta cocoaBeanMeta = cocoaBean.getItemMeta();
		cocoaBeanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cocoa-bean.name")));
		cocoaBeanMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cocoa-bean.lores")));
		cocoaBean.setItemMeta(cocoaBeanMeta);
		
		addItem(cocoaBean, new Action());
		
		ItemStack lightBrownMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/3fa39ccf4788d9179a8795e6b72382d49297b39217146eda68ae78384355b13");
		ItemMeta lightBrownMushroomMeta = lightBrownMushroom.getItemMeta();
		lightBrownMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.light-brown-mushroom.name")));
		lightBrownMushroomMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.light-brown-mushroom.lores")));
		lightBrownMushroom.setItemMeta(lightBrownMushroomMeta);
		
		addItem(lightBrownMushroom, new Action());
		
		ItemStack greenOre2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dc6bacd36ed60f533138e759c425946222b78eda6b616216f6dcc08e90d33e");
		ItemMeta greenOre2Meta = greenOre2.getItemMeta();
		greenOre2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.green-ore-2.name")));
		greenOre2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.green-ore-2.lores")));
		greenOre2.setItemMeta(greenOre2Meta);
		
		addItem(greenOre2, new Action());
		
		ItemStack bundleOfBurntTorches = SkullItem.getSkull("http://textures.minecraft.net/texture/86793bac4a1f974142ef8916642710949d7e38f87aebd380742ccc374f1de1");
		ItemMeta bundleOfBurntTorchesMeta = bundleOfBurntTorches.getItemMeta();
		bundleOfBurntTorchesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.bundle-of-burnt-torches.name")));
		bundleOfBurntTorchesMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.bundle-of-burnt-torches.lores")));
		bundleOfBurntTorches.setItemMeta(bundleOfBurntTorchesMeta);

		addItem(bundleOfBurntTorches);
		
		ItemStack skype = SkullItem.getSkull("http://textures.minecraft.net/texture/2ec182da7d3c0a8acc3be9b77c29be47e08c20b050b13fd4c4c7d71f66273");
		ItemMeta skypeMeta = skype.getItemMeta();
		skypeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.skype.name")));
		skypeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.skype.lores")));
		skype.setItemMeta(skypeMeta);
		
		addItem(skype, new Action());
		
		ItemStack tntMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/c4d7fc8e3a959ade7d9cf663f1e82db7975543e288ab8d11eb2541888213526");
		ItemMeta tntMinecartMeta = tntMinecart.getItemMeta();
		tntMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.tnt-minecart.name")));
		tntMinecartMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.tnt-minecart.lores")));
		tntMinecart.setItemMeta(tntMinecartMeta);
		
		addItem(tntMinecart, new Action());
		
		ItemStack furnaceMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/e079abbafb981c795a9a2f82bab3fbd9f166b8c0dbf9a1751d769beac667b6");
		ItemMeta furnaceMinecartMeta = furnaceMinecart.getItemMeta();
		furnaceMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.furnace-minecart.name")));
		furnaceMinecartMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.furnace-minecart.lores")));
		furnaceMinecart.setItemMeta(furnaceMinecartMeta);
		
		addItem(furnaceMinecart, new Action());
		
		ItemStack chestMinecart  = SkullItem.getSkull("http://textures.minecraft.net/texture/4ced34211fed4010a8c85724a27fa5fb205d67684b3da517b6821279c6b65d3f");
		ItemMeta chestMinecartMeta = chestMinecart.getItemMeta();
		chestMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.chest-minecart.name")));
		chestMinecartMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.chest-minecart.lores")));
		chestMinecart.setItemMeta(chestMinecartMeta);
		
		addItem(chestMinecart, new Action());
		
		ItemStack commandBlockMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/ba9053d2163d0f561145d33a513145d4ac1f8a458baa796be383e7525a05f45");
		ItemMeta commandBlockMinecartMeta = commandBlockMinecart.getItemMeta();
		commandBlockMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.command-block-minecart.name")));
		commandBlockMinecartMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.command-block-minecart.lores")));
		commandBlockMinecart.setItemMeta(commandBlockMinecartMeta);
		
		addItem(commandBlockMinecart, new Action());
		
		ItemStack scared = SkullItem.getSkull("http://textures.minecraft.net/texture/636e26c44659e8148ed58aa79e4d60db595f426442116f81b5415c2446ed8");
		ItemMeta scaredMeta = scared.getItemMeta();
		scaredMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.scared.name")));
		scaredMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.scared.lores")));
		scared.setItemMeta(scaredMeta);
		
		addItem(scared, new Action());
		
		ItemStack angel = SkullItem.getSkull("http://textures.minecraft.net/texture/3e1debc73231f8ed4b69d5c3ac1b1f18f3656a8988e23f2e1bdbc4e85f6d46a");
		ItemMeta angelMeta = angel.getItemMeta();
		angelMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.angel.name")));
		angelMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.angel.lores")));
		angel.setItemMeta(angelMeta);
		
		addItem(angel, new Action());
		
		ItemStack embarrased = SkullItem.getSkull("http://textures.minecraft.net/texture/f720df911c052377065408db78a25c678f791eb944c063935ae86dbe51c71b");
		ItemMeta embarrasedMeta = embarrased.getItemMeta();
		embarrasedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.embarrased.name")));
		embarrasedMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.embarrased.lores")));
		embarrased.setItemMeta(embarrasedMeta);
		
		addItem(embarrased, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.close.name")));
		closeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.close.lores")));
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
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.next-page.name")));
		nextMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.next-page.lores")));
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
		
		//second page
		ItemStack kissy = SkullItem.getSkull("http://textures.minecraft.net/texture/545bd18a2aaf469fad72e52cde6cfb02bfbaa5bfed2a8151277f779ebcdcec1");
		ItemMeta kissyMeta = kissy.getItemMeta();
		kissyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.kissy.name")));
		kissyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.kissy.lores")));
		kissy.setItemMeta(kissyMeta);
		
		addItem(kissy, new Action());
		
		ItemStack sad = SkullItem.getSkull("http://textures.minecraft.net/texture/14968ac5af3146826fa2b0d4dd114fda197f8b28f4750553f3f88836a21fac9");
		ItemMeta sadMeta = sad.getItemMeta();
		sadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.sad.name")));
		sadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.sad.lores")));
		sad.setItemMeta(sadMeta);
		
		addItem(sad, new Action());
		
		ItemStack cool = SkullItem.getSkull("http://textures.minecraft.net/texture/868f4cef949f32e33ec5ae845f9c56983cbe13375a4dec46e5bbfb7dcb6");
		ItemMeta coolMeta = cool.getItemMeta();
		coolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.cool.name")));
		coolMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.cool.lores")));
		cool.setItemMeta(coolMeta);
		
		addItem(cool, new Action());
		
		ItemStack surprised = SkullItem.getSkull("http://textures.minecraft.net/texture/bc2b9b9ae622bd68adff7180f8206ec4494abbfa130e94a584ec692e8984ab2");
		ItemMeta surprisedMeta = surprised.getItemMeta();
		surprisedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.surprised.name")));
		surprisedMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.surprised.lores")));
		surprised.setItemMeta(surprisedMeta);
		
		addItem(surprised, new Action());
		
		ItemStack dead = SkullItem.getSkull("http://textures.minecraft.net/texture/b371e4e1cf6a1a36fdae27137fd9b8748e6169299925f9af2be301e54298c73");
		ItemMeta deadMeta = dead.getItemMeta();
		deadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.dead.name")));
		deadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.dead.lores")));
		dead.setItemMeta(deadMeta);
		
		addItem(dead, new Action());
		
		ItemStack foreverCrying = SkullItem.getSkull("http://textures.minecraft.net/texture/1f1b875de49c587e3b4023ce24d472ff27583a1f054f37e73a1154b5b5498");
		ItemMeta foreverCryingMeta = foreverCrying.getItemMeta();
		foreverCryingMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.forever-crying.name")));
		foreverCryingMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.forever-crying.lores")));
		foreverCrying.setItemMeta(foreverCryingMeta);

		addItem(foreverCrying, new Action());
		
		ItemStack bigGrin = SkullItem.getSkull("http://textures.minecraft.net/texture/5059d59eb4e59c31eecf9ece2f9cf3934e45c0ec476fc86bfaef8ea913ea710");
		ItemMeta bigGrinMeta = bigGrin.getItemMeta();
		bigGrinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.big-grin.name")));
		bigGrinMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.big-grin.lores")));
		bigGrin.setItemMeta(bigGrinMeta);
		
		addItem(bigGrin, new Action());
		
		ItemStack wink = SkullItem.getSkull("http://textures.minecraft.net/texture/f4ea2d6f939fefeff5d122e63dd26fa8a427df90b2928bc1fa89a8252a7e");
		ItemMeta winkMeta = wink.getItemMeta();
		winkMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.wink.name")));
		winkMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.wink.lores")));
		wink.setItemMeta(winkMeta);
		
		addItem(wink, new Action());
		
		ItemStack derp = SkullItem.getSkull("http://textures.minecraft.net/texture/3baabe724eae59c5d13f442c7dc5d2b1c6b70c2f83364a488ce5973ae80b4c3");
		ItemMeta derpMeta = derp.getItemMeta();
		derpMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.derp.name")));
		derpMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.derp.lores")));
		derp.setItemMeta(derpMeta);
		
		addItem(derp, new Action());
		
		ItemStack mustache = SkullItem.getSkull("http://textures.minecraft.net/texture/3636f2724aa6aa4de7ac46c19f3c845fb14847a518c8f7e03d792c82effb1");
		ItemMeta mustacheMeta = mustache.getItemMeta();
		mustacheMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.mustache.name")));
		mustacheMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.mustache.lores")));
		mustache.setItemMeta(mustacheMeta);
		
		addItem(mustache, new Action());
		
		ItemStack bigSmile = SkullItem.getSkull("http://textures.minecraft.net/texture/7ffaccf17879b17891fc5ef66472cc066a85bfa31b6d786c32afee4796068d");
		ItemMeta bigSmileMeta = bigSmile.getItemMeta();
		bigSmileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.big-smile.name")));
		bigSmileMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.big-smile.lores")));
		bigSmile.setItemMeta(bigSmileMeta);
		
		addItem(bigSmile, new Action());
		
		ItemStack smile = SkullItem.getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8");
		ItemMeta smileMeta = smile.getItemMeta();
		smileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.smile.name")));
		smileMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.smile.lores")));
		smile.setItemMeta(smileMeta);
		
		addItem(smile, new Action());
		
		ItemStack beehive = SkullItem.getSkull("http://textures.minecraft.net/texture/20342dc9c2ad886acfe3ca2e987b7e28a87c774ca5f3d8cb2bfabe131cafe8");
		ItemMeta beehiveMeta = beehive.getItemMeta();
		beehiveMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.beehive.name")));
		beehiveMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.beehive.lores")));
		beehive.setItemMeta(beehiveMeta);
		
		addItem(beehive, new Action());
		
		ItemStack netherlands = SkullItem.getSkull("http://textures.minecraft.net/texture/c23cf210edea396f2f5dfbced69848434f93404eefeabf54b23c073b090adf");
		ItemMeta netherlandsMeta = netherlands.getItemMeta();
		netherlandsMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.netherlands.name")));
		netherlandsMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.netherlands.lores")));
		netherlands.setItemMeta(netherlandsMeta);
		
		addItem(netherlands, new Action());
		
		ItemStack norway = SkullItem.getSkull("http://textures.minecraft.net/texture/e0596e165ec3f389b59cfdda93dd6e363e97d9c6456e7c2e123973fa6c5fda");
		ItemMeta norwayMeta = norway.getItemMeta();
		norwayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.norway.name")));
		norwayMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.norway.lores")));
		norway.setItemMeta(norwayMeta);
		
		addItem(norway, new Action());
		
		ItemStack sweden = SkullItem.getSkull("http://textures.minecraft.net/texture/e910904bff9c86f6ed47688e9429c26e8d9c5d5743bd3ebb8e6f5040be192998");
		ItemMeta swedenMeta = sweden.getItemMeta();
		swedenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.sweden.name")));
		swedenMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.sweden.lores")));
		sweden.setItemMeta(swedenMeta);
		
		addItem(sweden, new Action());
		
		ItemStack egypt = SkullItem.getSkull("http://textures.minecraft.net/texture/826e742b32f0f8db59c07b1bcdde6f8a93f85c929e598c7e9273b9211f2ce78");
		ItemMeta egyptMeta = egypt.getItemMeta();
		egyptMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.egypt.name")));
		egyptMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.egypt.lores")));
		egypt.setItemMeta(egyptMeta);
		
		addItem(egypt, new Action());
		
		ItemStack chile = SkullItem.getSkull("http://textures.minecraft.net/texture/ed1dddc665614c9f6487ba9c666da7579561589a494ef744aaf8f4f88a16");
		ItemMeta chileMeta = chile.getItemMeta();
		chileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.chile.name")));
		chileMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.chile.lores")));
		chile.setItemMeta(chileMeta);
		
		addItem(chile, new Action());
		
		ItemStack monaco = SkullItem.getSkull("http://textures.minecraft.net/texture/5db2678ccaba7934412cb97ee16d416463a392574c5906352f18dea42895ee");
		ItemMeta monacoMeta = monaco.getItemMeta();
		monacoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.monaco.name")));
		monacoMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.monaco.lores")));
		monaco.setItemMeta(monacoMeta);
		
		addItem(monaco, new Action());
		
		ItemStack canada = SkullItem.getSkull("http://textures.minecraft.net/texture/f241a697f6dfb1c57cda327baa6732a7828c398be4ebfdbd166c232bcae2b");
		ItemMeta canadaMeta = canada.getItemMeta();
		canadaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.canada.name")));
		canadaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.canada.lores")));
		canada.setItemMeta(canadaMeta);
		
		addItem(canada, new Action());
		
		ItemStack unitedStatesOfAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7d15d566202ac0e76cd897759df5d01c11f991bd46c5c9a04357ea89ee75");
		ItemMeta unitedStatesOfAmericaMeta = unitedStatesOfAmerica.getItemMeta();
		unitedStatesOfAmericaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.united-states-of-america.name")));
		unitedStatesOfAmericaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.united-states-of-america.lores")));
		unitedStatesOfAmerica.setItemMeta(unitedStatesOfAmericaMeta);
		
		addItem(unitedStatesOfAmerica, new Action());
		
		ItemStack belgium = SkullItem.getSkull("http://textures.minecraft.net/texture/5c78aae42ef9ee9faa67b64bb974cea275ce702655d35f841b6017416ee1c393");
		ItemMeta belgiumMeta = belgium.getItemMeta();
		belgiumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.belgium.name")));
		belgiumMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.belgium.lores")));
		belgium.setItemMeta(belgiumMeta);
		
		addItem(belgium, new Action());
		
		ItemStack italy = SkullItem.getSkull("http://textures.minecraft.net/texture/a56c5cc17319a6c9ec847252e4d274552d97da95e1085072dba49d117cf3");
		ItemMeta italyMeta = italy.getItemMeta();
		italyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.italy.name")));
		italyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.italy.lores")));
		italy.setItemMeta(italyMeta);
		
		addItem(italy, new Action());
		
		ItemStack england = SkullItem.getSkull("http://textures.minecraft.net/texture/bee5c850afbb7d8843265a146211ac9c615f733dcc5a8e2190e5c247dea32");
		ItemMeta englandMeta = england.getItemMeta();
		englandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.england.name")));
		englandMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.england.lores")));
		england.setItemMeta(englandMeta);
		
		addItem(england, new Action());
		
		ItemStack romania = SkullItem.getSkull("http://textures.minecraft.net/texture/84d380aa9d66a2a966eb1cfc17608f28fbfe3a75f6a18a8be544682586c41c4");
		ItemMeta romaniaMeta = romania.getItemMeta();
		romaniaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.romania.name")));
		romaniaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.romania.lores")));
		romania.setItemMeta(romaniaMeta);
		
		addItem(romania, new Action());
		
		ItemStack germany = SkullItem.getSkull("http://textures.minecraft.net/texture/5e7899b4806858697e283f084d9173fe487886453774626b24bd8cfecc77b3f");
		ItemMeta germanyMeta = germany.getItemMeta();
		germanyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.germany.name")));
		germanyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.germany.lores")));
		germany.setItemMeta(germanyMeta);
		
		addItem(germany, new Action());
		
		ItemStack singapore = SkullItem.getSkull("http://textures.minecraft.net/texture/8b5ed11f797f3fc61eaf8dafb6bf3234d31b96ab7596bd2df722d2ef3473c27");
		ItemMeta singaporeMeta = singapore.getItemMeta();
		singaporeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.singapore.name")));
		singaporeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.singapore.lores")));
		singapore.setItemMeta(singaporeMeta);
		
		addItem(singapore, new Action());
		
		ItemStack northKorea = SkullItem.getSkull("http://textures.minecraft.net/texture/1969d12662faebfaca6f4b0442fcb251fd60b61a9fcdceea2bdc21e025eb21");
		ItemMeta northKoreaMeta = northKorea.getItemMeta();
		northKoreaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.north-korea.name")));
		northKoreaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.north-korea.lores")));
		northKorea.setItemMeta(northKoreaMeta);
		
		addItem(northKorea, new Action());
		
		ItemStack france = SkullItem.getSkull("http://textures.minecraft.net/texture/ba25287d1140fb1741d4b6f7e65672f9e64fffe80ea7371c7f3ec5a6f04039");
		ItemMeta franceMeta = france.getItemMeta();
		franceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.france.name")));
		franceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.france.lores")));
		france.setItemMeta(franceMeta);
		
		addItem(france, new Action());
		
		ItemStack crown = SkullItem.getSkull("http://textures.minecraft.net/texture/c2baf0c589a6b583511d83c268240842d3364774ec9f566d1fd4d349cf42fb");
		ItemMeta crownMeta = crown.getItemMeta();
		crownMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.crown.name")));
		crownMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.crown.lores")));
		crown.setItemMeta(crownMeta);
		
		addItem(crown, new Action());
		
		ItemStack emeraldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b656da666d2759e8195642142e119e6585852c6619e2ad79ae2ad181465");
		ItemMeta emeraldSteveHeadMeta = emeraldSteveHead.getItemMeta();
		emeraldSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.emerald-steve-head.name")));
		emeraldSteveHeadMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.emerald-steve-head.lores")));
		emeraldSteveHead.setItemMeta(emeraldSteveHeadMeta);
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.previous-page.lores")));
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
		close2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.close.name")));
		close2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.misc.close.lores")));
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