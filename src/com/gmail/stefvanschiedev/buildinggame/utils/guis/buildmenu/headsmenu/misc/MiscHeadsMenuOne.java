package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class MiscHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Misc");
		
		ItemStack goldPot = SkullItem.getSkull("http://textures.minecraft.net/texture/aa976f6dfcf188995a327e55ce34c60e6dcd1ff63e68dd1fc3ad75d2d1bf");
		ItemMeta goldPotMeta = goldPot.getItemMeta();
		goldPotMeta.setDisplayName(ChatColor.GOLD + "Gold Pot");
		goldPot.setItemMeta(goldPotMeta);
		
		ItemStack lavaBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/8d5427a83540a08a3fa2e655c2964a07243514584a71ec35d6b9e184dfbe318");
		ItemMeta lavaBucketMeta = lavaBucket.getItemMeta();
		lavaBucketMeta.setDisplayName(ChatColor.GOLD + "Lava Bucket");
		lavaBucket.setItemMeta(lavaBucketMeta);
		
		ItemStack milkBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/f58c975661c3e94fc35115648158e3ee9f80df74a4399e4d31ca5dbbcaf29b6");
		ItemMeta milkBucketMeta = milkBucket.getItemMeta();
		milkBucketMeta.setDisplayName(ChatColor.GOLD + "Milk Bucket");
		milkBucket.setItemMeta(milkBucketMeta);
		
		ItemStack emptyBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/21ea825150b06e65e2ceb593afe342dca56dda12bf6c9696fb82f90dcd423ab");
		ItemMeta emptyBucketMeta = emptyBucket.getItemMeta();
		emptyBucketMeta.setDisplayName(ChatColor.GOLD + "Empty Bucket");
		emptyBucket.setItemMeta(emptyBucketMeta);
		
		ItemStack waterBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/49f1f07e2b1c32bb64a128e529f3af1e5286e518544edf8cbaa6c4065b476b");
		ItemMeta waterBucketMeta = waterBucket.getItemMeta();
		waterBucketMeta.setDisplayName(ChatColor.GOLD + "Water Bucket");
		waterBucket.setItemMeta(waterBucketMeta);
		
		ItemStack mailbox = SkullItem.getSkull("http://textures.minecraft.net/texture/4c7f684d3ac3a59a9c766233423b46451bff7b9642bb589a7edc5aef457e7");
		ItemMeta mailboxMeta = mailbox.getItemMeta();
		mailboxMeta.setDisplayName(ChatColor.GOLD + "Mailbox");
		mailbox.setItemMeta(mailboxMeta);
		
		ItemStack spaceHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/3e8aad673157c92317a88b1f86f5271f1cd7397d7fc8ec3281f733f751634");
		ItemMeta spaceHelmetMeta = spaceHelmet.getItemMeta();
		spaceHelmetMeta.setDisplayName(ChatColor.GOLD + "Space Helmet");
		spaceHelmet.setItemMeta(spaceHelmetMeta);
		
		ItemStack spaceHelmet2 = SkullItem.getSkull("http://textures.minecraft.net/texture/302e22f6503c363df69bf9e9448fe89d2f05bae30534b8bb19d268f0989b96");
		ItemMeta spaceHelmet2Meta = spaceHelmet2.getItemMeta();
		spaceHelmet2Meta.setDisplayName(ChatColor.GOLD + "Space Helmet");
		spaceHelmet2.setItemMeta(spaceHelmet2Meta);
		
		ItemStack footballHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/4d7b62aca28445b8e11ea1750eeacd97932fa37ba744768573e8dc58a6af1");
		ItemMeta footballHelmetMeta = footballHelmet.getItemMeta();
		footballHelmetMeta.setDisplayName(ChatColor.GOLD + "Football Helmet");
		footballHelmet.setItemMeta(footballHelmetMeta);
		
		ItemStack eye = SkullItem.getSkull("http://textures.minecraft.net/texture/2cef87772afd85b468f4c7fb9571e31435ef765ad413fe460262150423e2021");
		ItemMeta eyeMeta = eye.getItemMeta();
		eyeMeta.setDisplayName(ChatColor.GOLD + "Eye");
		eye.setItemMeta(eyeMeta);
		
		ItemStack redMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/732dbd6612e9d3f42947b5ca8785bfb334258f3ceb83ad69a5cdeebea4cd65");
		ItemMeta redMushroomMeta = redMushroom.getItemMeta();
		redMushroomMeta.setDisplayName(ChatColor.GOLD + "Red Mushroom");
		redMushroom.setItemMeta(redMushroomMeta);
		
		ItemStack pineCone = SkullItem.getSkull("http://textures.minecraft.net/texture/1988ec65c51a85772c8d86d74ea8e0e572523bf8edc8cba5ad11952fbebe660");
		ItemMeta pineConeMeta = pineCone.getItemMeta();
		pineConeMeta.setDisplayName(ChatColor.GOLD + "Pine Cone");
		pineCone.setItemMeta(pineConeMeta);
		
		ItemStack cannonball = SkullItem.getSkull("http://textures.minecraft.net/texture/22523e15e9986355a1f851f43f750ee3f23c89ae123631da241f872ba7a781");
		ItemMeta cannonballMeta = cannonball.getItemMeta();
		cannonballMeta.setDisplayName(ChatColor.GOLD + "Cannonball");
		cannonball.setItemMeta(cannonballMeta);
		
		ItemStack cannonball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/996754d330435345aae3a9f063cfca42afb28b7c5c4bb9f294ed2527d961");
		ItemMeta cannonball2Meta = cannonball2.getItemMeta();
		cannonball2Meta.setDisplayName(ChatColor.GOLD + "Cannonball");
		cannonball2.setItemMeta(cannonball2Meta);
		
		ItemStack target = SkullItem.getSkull("http://textures.minecraft.net/texture/86fcaefa19669d8be02cf5ba9a7f2cf6d27e636410496ffcfa62b03dceb9d378");
		ItemMeta targetMeta = target.getItemMeta();
		targetMeta.setDisplayName(ChatColor.GOLD + "Target");
		target.setItemMeta(targetMeta);
		
		ItemStack cactus = SkullItem.getSkull("http://textures.minecraft.net/texture/38c9a730269ce1de3e9fa064afb370cbcd0766d729f3e29e4f320a433b098b5");
		ItemMeta cactusMeta = cactus.getItemMeta();
		cactusMeta.setDisplayName(ChatColor.GOLD + "Cactus");
		cactus.setItemMeta(cactusMeta);
		
		//"Facebook" is an application made by "Facebook Inc." and is not affiliated with this plugin
		
		ItemStack facebook = SkullItem.getSkull("http://textures.minecraft.net/texture/deb46126904463f07ecfc972aaa37373a22359b5ba271821b689cd5367f75762");
		ItemMeta facebookMeta = facebook.getItemMeta();
		facebookMeta.setDisplayName(ChatColor.GOLD + "Facebook");
		facebook.setItemMeta(facebookMeta);
		
		//"Twitter" is an application made by "Twitter, Inc." and is not affiliated with this plugin
		
		ItemStack twitter = SkullItem.getSkull("http://textures.minecraft.net/texture/3685a0be743e9067de95cd8c6d1ba21ab21d37371b3d597211bb75e43279");
		ItemMeta twitterMeta = twitter.getItemMeta();
		twitterMeta.setDisplayName(ChatColor.GOLD + "Twitter");
		twitter.setItemMeta(twitterMeta);
		
		//"Youtube" is an application made by "Google" and is not affiliated with this plugin
		
		ItemStack youtube = SkullItem.getSkull("http://textures.minecraft.net/texture/b4353fd0f86314353876586075b9bdf0c484aab0331b872df11bd564fcb029ed");
		ItemMeta youtubeMeta = youtube.getItemMeta();
		youtubeMeta.setDisplayName(ChatColor.GOLD + "Youtube");
		youtube.setItemMeta(youtubeMeta);
		
		ItemStack firecharge = SkullItem.getSkull("http://textures.minecraft.net/texture/9c2e9d8395cacd9922869c15373cf7cb16da0a5ce5f3c632b19ceb3929c9a11");
		ItemMeta firechargeMeta = firecharge.getItemMeta();
		firechargeMeta.setDisplayName(ChatColor.GOLD + "Firecharge");
		firecharge.setItemMeta(firechargeMeta);
		
		ItemStack portableGrill = SkullItem.getSkull("http://textures.minecraft.net/texture/318e35ec4b4b4c1591c5177386de18797454298b7455982e3ae83bacced0f1a2");
		ItemMeta portableGrillMeta = portableGrill.getItemMeta();
		portableGrillMeta.setDisplayName(ChatColor.GOLD + "Portable Grill");
		portableGrill.setItemMeta(portableGrillMeta);
		
		ItemStack wilsonCastaway = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonCastawayMeta = wilsonCastaway.getItemMeta();
		wilsonCastawayMeta.setDisplayName(ChatColor.GOLD + "Wilson - Castaway");
		wilsonCastaway.setItemMeta(wilsonCastawayMeta);
		
		ItemStack mailbox2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dacbbca567372a9b2b36c8f68154851bda5ee1d53e2bc208a1152d9a18d2cb");
		ItemMeta mailbox2Meta = mailbox2.getItemMeta();
		mailbox2Meta.setDisplayName(ChatColor.GOLD + "Mailbox");
		mailbox2.setItemMeta(mailbox2Meta);
		
		ItemStack skull = SkullItem.getSkull("http://textures.minecraft.net/texture/1ae3855f952cd4a03c148a946e3f812a5955ad35cbcb52627ea4acd47d3081");
		ItemMeta skullMeta = skull.getItemMeta();
		skullMeta.setDisplayName(ChatColor.GOLD + "Skull");
		skull.setItemMeta(skullMeta);
		
		ItemStack missingTexture = SkullItem.getSkull("http://textures.minecraft.net/texture/e9eb9da26cf2d3341397a7f4913ba3d37d1ad10eae30ab25fa39ceb84bc");
		ItemMeta missingTextureMeta = missingTexture.getItemMeta();
		missingTextureMeta.setDisplayName(ChatColor.GOLD + "Missing Texture");
		missingTexture.setItemMeta(missingTextureMeta);
		
		ItemStack greenOre = SkullItem.getSkull("http://textures.minecraft.net/texture/58c206e29924b9916d4d24dfbbc38f28b44d6d3cfa23adec9ed3a8fce1b7b2");
		ItemMeta greenOreMeta = greenOre.getItemMeta();
		greenOreMeta.setDisplayName(ChatColor.GOLD + "Green Ore");
		greenOre.setItemMeta(greenOreMeta);
		
		ItemStack cactusflower = SkullItem.getSkull("http://textures.minecraft.net/texture/904f1a55943c594e7119e884c5da2a2bca8e7e6516a0649aa7e55658e0e9");
		ItemMeta cactusflowerMeta = cactusflower.getItemMeta();
		cactusflowerMeta.setDisplayName(ChatColor.GOLD + "Cactusflower");
		cactusflower.setItemMeta(cactusflowerMeta);
		
		ItemStack moltenCore = SkullItem.getSkull("http://textures.minecraft.net/texture/5bb28bb0bf1ad217d2a81191effcc69fe174714a432fd71fa60aa50f3712b97");
		ItemMeta moltenCoreMeta = moltenCore.getItemMeta();
		moltenCoreMeta.setDisplayName(ChatColor.GOLD + "Molten Core");
		moltenCore.setItemMeta(moltenCoreMeta);
		
		//"Reddit" is an application made by "Advance Publications Inc." and is not affiliated with this plugin
		
		ItemStack reddit = SkullItem.getSkull("http://textures.minecraft.net/texture/4d9bd4b2fa8da8247a82c3d1fa246715f9b6d98c778374da6efc10c89cd64");
		ItemMeta redditMeta = reddit.getItemMeta();
		redditMeta.setDisplayName(ChatColor.GOLD + "Reddit");
		reddit.setItemMeta(redditMeta);
		
		ItemStack diamondSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/10b8eb333622ae7de9b53b3602f41f63db9c2528b5be231ac96516611fb1a");
		ItemMeta diamondSteveHeadMeta = diamondSteveHead.getItemMeta();
		diamondSteveHeadMeta.setDisplayName(ChatColor.GOLD + "Diamond Steve Head");
		diamondSteveHead.setItemMeta(diamondSteveHeadMeta);
		
		ItemStack goldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/f937e1c45bb8da29b2c564dd9a7da780dd2fe54468a5dfb4113b4ff658f043e1");
		ItemMeta goldSteveHeadMeta = goldSteveHead.getItemMeta();
		goldSteveHeadMeta.setDisplayName(ChatColor.GOLD + "Gold Steve Head");
		goldSteveHead.setItemMeta(goldSteveHeadMeta);
		
		ItemStack mushroomStem = SkullItem.getSkull("http://textures.minecraft.net/texture/f55fa642d5ebcba2c5246fe6499b1c4f6803c10f14f5299c8e59819d5dc");
		ItemMeta mushroomStemMeta = mushroomStem.getItemMeta();
		mushroomStemMeta.setDisplayName(ChatColor.GOLD + "Mushrrom Stem");
		mushroomStem.setItemMeta(mushroomStemMeta);
		
		ItemStack brownMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/fa49eca0369d1e158e539d78149acb1572949b88ba921d9ee694fea4c726b3");
		ItemMeta brownMushroomMeta = brownMushroom.getItemMeta();
		brownMushroomMeta.setDisplayName(ChatColor.GOLD + "Brown Mushroom");
		brownMushroom.setItemMeta(brownMushroomMeta);
		
		ItemStack cocoaBean = SkullItem.getSkull("http://textures.minecraft.net/texture/5083ec2b01dc0fee79aa32188d9429acc68ecf71408dca04aaab53ad8bea0");
		ItemMeta cocoaBeanMeta = cocoaBean.getItemMeta();
		cocoaBeanMeta.setDisplayName(ChatColor.GOLD + "Cocoa Bean");
		cocoaBean.setItemMeta(cocoaBeanMeta);
		
		ItemStack lightBrownMushroom = SkullItem.getSkull("textures.minecraft.net/texture/3fa39ccf4788d9179a8795e6b72382d49297b39217146eda68ae78384355b13");
		ItemMeta lightBrownMushroomMeta = lightBrownMushroom.getItemMeta();
		lightBrownMushroomMeta.setDisplayName(ChatColor.GOLD + "Light Brown Mushroom");
		lightBrownMushroom.setItemMeta(lightBrownMushroomMeta);
		
		ItemStack greenOre2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dc6bacd36ed60f533138e759c425946222b78eda6b616216f6dcc08e90d33e");
		ItemMeta greenOre2Meta = greenOre2.getItemMeta();
		greenOre2Meta.setDisplayName(ChatColor.GOLD + "Green Ore");
		greenOre2.setItemMeta(greenOre2Meta);
		
		ItemStack bundleOfBurntTorches = SkullItem.getSkull("http://textures.minecraft.net/texture/86793bac4a1f974142ef8916642710949d7e38f87aebd380742ccc374f1de1");
		ItemMeta bundleOfBurntTorchesMeta = bundleOfBurntTorches.getItemMeta();
		bundleOfBurntTorchesMeta.setDisplayName(ChatColor.GOLD + "Bundle of Burnt Torches");
		bundleOfBurntTorches.setItemMeta(bundleOfBurntTorchesMeta);
		
		//"Skype" is an application developed by "Microsoft" and is not affiliated with this plugin
		
		ItemStack skype = SkullItem.getSkull("http://textures.minecraft.net/texture/2ec182da7d3c0a8acc3be9b77c29be47e08c20b050b13fd4c4c7d71f66273");
		ItemMeta skypeMeta = skype.getItemMeta();
		skypeMeta.setDisplayName(ChatColor.GOLD + "Skype");
		skype.setItemMeta(skypeMeta);
		
		ItemStack tntMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/c4d7fc8e3a959ade7d9cf663f1e82db7975543e288ab8d11eb2541888213526");
		ItemMeta tntMinecartMeta = tntMinecart.getItemMeta();
		tntMinecartMeta.setDisplayName(ChatColor.GOLD + "TNT Minecart");
		tntMinecart.setItemMeta(tntMinecartMeta);
		
		ItemStack furnaceMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/e079abbafb981c795a9a2f82bab3fbd9f166b8c0dbf9a1751d769beac667b6");
		ItemMeta furnaceMinecartMeta = furnaceMinecart.getItemMeta();
		furnaceMinecartMeta.setDisplayName(ChatColor.GOLD + "Furnace Minecart");
		furnaceMinecart.setItemMeta(furnaceMinecartMeta);
		
		ItemStack chestMinecart  = SkullItem.getSkull("http://textures.minecraft.net/texture/4ced34211fed4010a8c85724a27fa5fb205d67684b3da517b6821279c6b65d3f");
		ItemMeta chestMinecartMeta = chestMinecart.getItemMeta();
		chestMinecartMeta.setDisplayName(ChatColor.GOLD + "Chest Minecart");
		chestMinecart.setItemMeta(chestMinecartMeta);
		
		ItemStack commandBlockMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/ba9053d2163d0f561145d33a513145d4ac1f8a458baa796be383e7525a05f45");
		ItemMeta commandBlockMinecartMeta = commandBlockMinecart.getItemMeta();
		commandBlockMinecartMeta.setDisplayName(ChatColor.GOLD + "Command Block Minecart");
		commandBlockMinecart.setItemMeta(commandBlockMinecartMeta);
		
		ItemStack scared = SkullItem.getSkull("http://textures.minecraft.net/texture/636e26c44659e8148ed58aa79e4d60db595f426442116f81b5415c2446ed8");
		ItemMeta scaredMeta = scared.getItemMeta();
		scaredMeta.setDisplayName(ChatColor.GOLD + "Scared");
		scared.setItemMeta(scaredMeta);
		
		ItemStack angel = SkullItem.getSkull("http://textures.minecraft.net/texture/3e1debc73231f8ed4b69d5c3ac1b1f18f3656a8988e23f2e1bdbc4e85f6d46a");
		ItemMeta angelMeta = angel.getItemMeta();
		angelMeta.setDisplayName(ChatColor.GOLD + "Angel");
		angel.setItemMeta(angelMeta);
		
		ItemStack embarrased = SkullItem.getSkull("http://textures.minecraft.net/texture/f720df911c052377065408db78a25c678f791eb944c063935ae86dbe51c71b");
		ItemMeta embarrasedMeta = embarrased.getItemMeta();
		embarrasedMeta.setDisplayName(ChatColor.GOLD + "Embarrased");
		embarrased.setItemMeta(embarrasedMeta);
		
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
		
		inventory.setItem(0, goldPot);
		inventory.setItem(1, lavaBucket);
		inventory.setItem(2, milkBucket);
		inventory.setItem(3, emptyBucket);
		inventory.setItem(4, waterBucket);
		inventory.setItem(5, mailbox);
		inventory.setItem(6, spaceHelmet);
		inventory.setItem(7, spaceHelmet2);
		inventory.setItem(8, footballHelmet);
		inventory.setItem(9, eye);
		inventory.setItem(10, redMushroom);
		inventory.setItem(11, pineCone);
		inventory.setItem(12, cannonball);
		inventory.setItem(13, cannonball2);
		inventory.setItem(14, target);
		inventory.setItem(15, cactus);
		inventory.setItem(16, facebook);
		inventory.setItem(17, twitter);
		inventory.setItem(18, youtube);
		inventory.setItem(19, firecharge);
		inventory.setItem(20, portableGrill);
		inventory.setItem(21, wilsonCastaway);
		inventory.setItem(22, mailbox2);
		inventory.setItem(23, skull);
		inventory.setItem(24, missingTexture);
		inventory.setItem(25, greenOre);
		inventory.setItem(26, cactusflower);
		inventory.setItem(27, moltenCore);
		inventory.setItem(28, reddit);
		inventory.setItem(29, diamondSteveHead);
		inventory.setItem(30, goldSteveHead);
		inventory.setItem(31, mushroomStem);
		inventory.setItem(32, brownMushroom);
		inventory.setItem(33, cocoaBean);
		inventory.setItem(34, lightBrownMushroom);
		inventory.setItem(35, greenOre);
		inventory.setItem(36, bundleOfBurntTorches);
		inventory.setItem(37, skype);
		inventory.setItem(38, tntMinecart);
		inventory.setItem(39, furnaceMinecart);
		inventory.setItem(40, chestMinecart);
		inventory.setItem(41, commandBlockMinecart);
		inventory.setItem(42, scared);
		inventory.setItem(43, angel);
		inventory.setItem(44, embarrased);
		
		inventory.setItem(49, next);
		inventory.setItem(51, close);
		
		player.openInventory(inventory);
	}
 }