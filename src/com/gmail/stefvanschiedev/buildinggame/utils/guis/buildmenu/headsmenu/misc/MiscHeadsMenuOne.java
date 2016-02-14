package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.misc;

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

public class MiscHeadsMenuOne {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.misc.page-1.title")));
		
		ItemStack goldPot = SkullItem.getSkull("http://textures.minecraft.net/texture/aa976f6dfcf188995a327e55ce34c60e6dcd1ff63e68dd1fc3ad75d2d1bf");
		ItemMeta goldPotMeta = goldPot.getItemMeta();
		goldPotMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.gold-pot.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.gold-pot.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goldPotMeta.setLore(lores);
		}
		goldPot.setItemMeta(goldPotMeta);
		
		ItemStack lavaBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/8d5427a83540a08a3fa2e655c2964a07243514584a71ec35d6b9e184dfbe318");
		ItemMeta lavaBucketMeta = lavaBucket.getItemMeta();
		lavaBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.lava-bucket.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.lava-bucket.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lavaBucketMeta.setLore(lores);
		}
		lavaBucket.setItemMeta(lavaBucketMeta);
		
		ItemStack milkBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/f58c975661c3e94fc35115648158e3ee9f80df74a4399e4d31ca5dbbcaf29b6");
		ItemMeta milkBucketMeta = milkBucket.getItemMeta();
		milkBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.milk-bucket.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.milk-bucket.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			milkBucketMeta.setLore(lores);
		}
		milkBucket.setItemMeta(milkBucketMeta);
		
		ItemStack emptyBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/21ea825150b06e65e2ceb593afe342dca56dda12bf6c9696fb82f90dcd423ab");
		ItemMeta emptyBucketMeta = emptyBucket.getItemMeta();
		emptyBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.empty-bucket.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.empty-bucket.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			emptyBucketMeta.setLore(lores);
		}
		emptyBucket.setItemMeta(emptyBucketMeta);
		
		ItemStack waterBucket = SkullItem.getSkull("http://textures.minecraft.net/texture/49f1f07e2b1c32bb64a128e529f3af1e5286e518544edf8cbaa6c4065b476b");
		ItemMeta waterBucketMeta = waterBucket.getItemMeta();
		waterBucketMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.water-bucket.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.water-bucket.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			waterBucketMeta.setLore(lores);
		}
		waterBucket.setItemMeta(waterBucketMeta);
		
		ItemStack mailbox = SkullItem.getSkull("http://textures.minecraft.net/texture/4c7f684d3ac3a59a9c766233423b46451bff7b9642bb589a7edc5aef457e7");
		ItemMeta mailboxMeta = mailbox.getItemMeta();
		mailboxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.mailbox.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.mailbox.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mailboxMeta.setLore(lores);
		}
		mailbox.setItemMeta(mailboxMeta);
		
		ItemStack spaceHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/3e8aad673157c92317a88b1f86f5271f1cd7397d7fc8ec3281f733f751634");
		ItemMeta spaceHelmetMeta = spaceHelmet.getItemMeta();
		spaceHelmetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.space-helmet.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.space-helmet.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			spaceHelmetMeta.setLore(lores);
		}
		spaceHelmet.setItemMeta(spaceHelmetMeta);
		
		ItemStack spaceHelmet2 = SkullItem.getSkull("http://textures.minecraft.net/texture/302e22f6503c363df69bf9e9448fe89d2f05bae30534b8bb19d268f0989b96");
		ItemMeta spaceHelmet2Meta = spaceHelmet2.getItemMeta();
		spaceHelmet2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.space-helmet-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.space-helmet-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			spaceHelmet2Meta.setLore(lores);
		}
		spaceHelmet2.setItemMeta(spaceHelmet2Meta);
		
		ItemStack footballHelmet = SkullItem.getSkull("http://textures.minecraft.net/texture/4d7b62aca28445b8e11ea1750eeacd97932fa37ba744768573e8dc58a6af1");
		ItemMeta footballHelmetMeta = footballHelmet.getItemMeta();
		footballHelmetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.football-helmet.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.football-helmet.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			footballHelmetMeta.setLore(lores);
		}
		footballHelmet.setItemMeta(footballHelmetMeta);
		
		ItemStack eye = SkullItem.getSkull("http://textures.minecraft.net/texture/2cef87772afd85b468f4c7fb9571e31435ef765ad413fe460262150423e2021");
		ItemMeta eyeMeta = eye.getItemMeta();
		eyeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.eye.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.eye.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			eyeMeta.setLore(lores);
		}
		eye.setItemMeta(eyeMeta);
		
		ItemStack redMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/732dbd6612e9d3f42947b5ca8785bfb334258f3ceb83ad69a5cdeebea4cd65");
		ItemMeta redMushroomMeta = redMushroom.getItemMeta();
		redMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.red-mushroom.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.red-mushroom.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redMushroomMeta.setLore(lores);
		}
		redMushroom.setItemMeta(redMushroomMeta);
		
		ItemStack pineCone = SkullItem.getSkull("http://textures.minecraft.net/texture/1988ec65c51a85772c8d86d74ea8e0e572523bf8edc8cba5ad11952fbebe660");
		ItemMeta pineConeMeta = pineCone.getItemMeta();
		pineConeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.pine-cone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.pine-cone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pineConeMeta.setLore(lores);
		}
		pineCone.setItemMeta(pineConeMeta);
		
		ItemStack cannonball = SkullItem.getSkull("http://textures.minecraft.net/texture/22523e15e9986355a1f851f43f750ee3f23c89ae123631da241f872ba7a781");
		ItemMeta cannonballMeta = cannonball.getItemMeta();
		cannonballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.cannonball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.cannonball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cannonballMeta.setLore(lores);
		}
		cannonball.setItemMeta(cannonballMeta);
		
		ItemStack cannonball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/996754d330435345aae3a9f063cfca42afb28b7c5c4bb9f294ed2527d961");
		ItemMeta cannonball2Meta = cannonball2.getItemMeta();
		cannonball2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.cannonball-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.cannonball-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cannonball2Meta.setLore(lores);
		}
		cannonball2.setItemMeta(cannonball2Meta);
		
		ItemStack target = SkullItem.getSkull("http://textures.minecraft.net/texture/86fcaefa19669d8be02cf5ba9a7f2cf6d27e636410496ffcfa62b03dceb9d378");
		ItemMeta targetMeta = target.getItemMeta();
		targetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.target.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.target.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			targetMeta.setLore(lores);
		}
		target.setItemMeta(targetMeta);
		
		ItemStack cactus = SkullItem.getSkull("http://textures.minecraft.net/texture/38c9a730269ce1de3e9fa064afb370cbcd0766d729f3e29e4f320a433b098b5");
		ItemMeta cactusMeta = cactus.getItemMeta();
		cactusMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.cactus.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.cactus.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cactusMeta.setLore(lores);
		}
		cactus.setItemMeta(cactusMeta);

		ItemStack facebook = SkullItem.getSkull("http://textures.minecraft.net/texture/deb46126904463f07ecfc972aaa37373a22359b5ba271821b689cd5367f75762");
		ItemMeta facebookMeta = facebook.getItemMeta();
		facebookMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.facebook.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.facebook.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			facebookMeta.setLore(lores);
		}
		facebook.setItemMeta(facebookMeta);

		ItemStack twitter = SkullItem.getSkull("http://textures.minecraft.net/texture/3685a0be743e9067de95cd8c6d1ba21ab21d37371b3d597211bb75e43279");
		ItemMeta twitterMeta = twitter.getItemMeta();
		twitterMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.twitter.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.twitter.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			twitterMeta.setLore(lores);
		}
		twitter.setItemMeta(twitterMeta);

		ItemStack youtube = SkullItem.getSkull("http://textures.minecraft.net/texture/b4353fd0f86314353876586075b9bdf0c484aab0331b872df11bd564fcb029ed");
		ItemMeta youtubeMeta = youtube.getItemMeta();
		youtubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.youtube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.youtube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			youtubeMeta.setLore(lores);
		}
		youtube.setItemMeta(youtubeMeta);
		
		ItemStack firecharge = SkullItem.getSkull("http://textures.minecraft.net/texture/9c2e9d8395cacd9922869c15373cf7cb16da0a5ce5f3c632b19ceb3929c9a11");
		ItemMeta firechargeMeta = firecharge.getItemMeta();
		firechargeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.firecharge.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.firecharge.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			firechargeMeta.setLore(lores);
		}
		firecharge.setItemMeta(firechargeMeta);
		
		ItemStack portableGrill = SkullItem.getSkull("http://textures.minecraft.net/texture/318e35ec4b4b4c1591c5177386de18797454298b7455982e3ae83bacced0f1a2");
		ItemMeta portableGrillMeta = portableGrill.getItemMeta();
		portableGrillMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.portable-grill.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.portable-grill.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			portableGrillMeta.setLore(lores);
		}
		portableGrill.setItemMeta(portableGrillMeta);
		
		ItemStack wilsonCastaway = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonCastawayMeta = wilsonCastaway.getItemMeta();
		wilsonCastawayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.wilson-castaway.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.wilson-castaway.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wilsonCastawayMeta.setLore(lores);
		}
		wilsonCastaway.setItemMeta(wilsonCastawayMeta);
		
		ItemStack mailbox2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dacbbca567372a9b2b36c8f68154851bda5ee1d53e2bc208a1152d9a18d2cb");
		ItemMeta mailbox2Meta = mailbox2.getItemMeta();
		mailbox2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.mailbox-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.mailbox-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mailbox2Meta.setLore(lores);
		}
		mailbox2.setItemMeta(mailbox2Meta);
		
		ItemStack skull = SkullItem.getSkull("http://textures.minecraft.net/texture/1ae3855f952cd4a03c148a946e3f812a5955ad35cbcb52627ea4acd47d3081");
		ItemMeta skullMeta = skull.getItemMeta();
		skullMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.skull.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.skull.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			skullMeta.setLore(lores);
		}
		skull.setItemMeta(skullMeta);
		
		ItemStack missingTexture = SkullItem.getSkull("http://textures.minecraft.net/texture/e9eb9da26cf2d3341397a7f4913ba3d37d1ad10eae30ab25fa39ceb84bc");
		ItemMeta missingTextureMeta = missingTexture.getItemMeta();
		missingTextureMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.missing-texture.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.missing-texture.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			missingTextureMeta.setLore(lores);
		}
		missingTexture.setItemMeta(missingTextureMeta);
		
		ItemStack greenOre = SkullItem.getSkull("http://textures.minecraft.net/texture/58c206e29924b9916d4d24dfbbc38f28b44d6d3cfa23adec9ed3a8fce1b7b2");
		ItemMeta greenOreMeta = greenOre.getItemMeta();
		greenOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.green-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.green-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenOreMeta.setLore(lores);
		}
		greenOre.setItemMeta(greenOreMeta);
		
		ItemStack cactusflower = SkullItem.getSkull("http://textures.minecraft.net/texture/904f1a55943c594e7119e884c5da2a2bca8e7e6516a0649aa7e55658e0e9");
		ItemMeta cactusflowerMeta = cactusflower.getItemMeta();
		cactusflowerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.cactusflower.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.cactusflower.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cactusflowerMeta.setLore(lores);
		}
		cactusflower.setItemMeta(cactusflowerMeta);
		
		ItemStack moltenCore = SkullItem.getSkull("http://textures.minecraft.net/texture/5bb28bb0bf1ad217d2a81191effcc69fe174714a432fd71fa60aa50f3712b97");
		ItemMeta moltenCoreMeta = moltenCore.getItemMeta();
		moltenCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.molten-core.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.molten-core.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			moltenCoreMeta.setLore(lores);
		}
		moltenCore.setItemMeta(moltenCoreMeta);

		ItemStack reddit = SkullItem.getSkull("http://textures.minecraft.net/texture/4d9bd4b2fa8da8247a82c3d1fa246715f9b6d98c778374da6efc10c89cd64");
		ItemMeta redditMeta = reddit.getItemMeta();
		redditMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.reddit.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.reddit.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redditMeta.setLore(lores);
		}
		reddit.setItemMeta(redditMeta);
		
		ItemStack diamondSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/10b8eb333622ae7de9b53b3602f41f63db9c2528b5be231ac96516611fb1a");
		ItemMeta diamondSteveHeadMeta = diamondSteveHead.getItemMeta();
		diamondSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.diamond-steve-head.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.diamond-steve-head.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			diamondSteveHeadMeta.setLore(lores);
		}
		diamondSteveHead.setItemMeta(diamondSteveHeadMeta);
		
		ItemStack goldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/f937e1c45bb8da29b2c564dd9a7da780dd2fe54468a5dfb4113b4ff658f043e1");
		ItemMeta goldSteveHeadMeta = goldSteveHead.getItemMeta();
		goldSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.gold-steve-head.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.gold-steve-head.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goldSteveHeadMeta.setLore(lores);
		}
		goldSteveHead.setItemMeta(goldSteveHeadMeta);
		
		ItemStack mushroomStem = SkullItem.getSkull("http://textures.minecraft.net/texture/f55fa642d5ebcba2c5246fe6499b1c4f6803c10f14f5299c8e59819d5dc");
		ItemMeta mushroomStemMeta = mushroomStem.getItemMeta();
		mushroomStemMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.mushroom-stem.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.mushroom-stem.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mushroomStemMeta.setLore(lores);
		}
		mushroomStem.setItemMeta(mushroomStemMeta);
		
		ItemStack brownMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/fa49eca0369d1e158e539d78149acb1572949b88ba921d9ee694fea4c726b3");
		ItemMeta brownMushroomMeta = brownMushroom.getItemMeta();
		brownMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.brown-mushroom.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.brown-mushroom.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brownMushroomMeta.setLore(lores);
		}
		brownMushroom.setItemMeta(brownMushroomMeta);
		
		ItemStack cocoaBean = SkullItem.getSkull("http://textures.minecraft.net/texture/5083ec2b01dc0fee79aa32188d9429acc68ecf71408dca04aaab53ad8bea0");
		ItemMeta cocoaBeanMeta = cocoaBean.getItemMeta();
		cocoaBeanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.cocoa-bean.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.cocoa-bean.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cocoaBeanMeta.setLore(lores);
		}
		cocoaBean.setItemMeta(cocoaBeanMeta);
		
		ItemStack lightBrownMushroom = SkullItem.getSkull("http://textures.minecraft.net/texture/3fa39ccf4788d9179a8795e6b72382d49297b39217146eda68ae78384355b13");
		ItemMeta lightBrownMushroomMeta = lightBrownMushroom.getItemMeta();
		lightBrownMushroomMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.light-brown-mushroom.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.light-brown-mushroom.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightBrownMushroomMeta.setLore(lores);
		}
		lightBrownMushroom.setItemMeta(lightBrownMushroomMeta);
		
		ItemStack greenOre2 = SkullItem.getSkull("http://textures.minecraft.net/texture/dc6bacd36ed60f533138e759c425946222b78eda6b616216f6dcc08e90d33e");
		ItemMeta greenOre2Meta = greenOre2.getItemMeta();
		greenOre2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.green-ore-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.green-ore-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenOre2Meta.setLore(lores);
		}
		greenOre2.setItemMeta(greenOre2Meta);
		
		ItemStack bundleOfBurntTorches = SkullItem.getSkull("http://textures.minecraft.net/texture/86793bac4a1f974142ef8916642710949d7e38f87aebd380742ccc374f1de1");
		ItemMeta bundleOfBurntTorchesMeta = bundleOfBurntTorches.getItemMeta();
		bundleOfBurntTorchesMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.bundle-of-burnt-torches.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.bundle-of-burnt-torches.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bundleOfBurntTorchesMeta.setLore(lores);
		}
		bundleOfBurntTorches.setItemMeta(bundleOfBurntTorchesMeta);

		ItemStack skype = SkullItem.getSkull("http://textures.minecraft.net/texture/2ec182da7d3c0a8acc3be9b77c29be47e08c20b050b13fd4c4c7d71f66273");
		ItemMeta skypeMeta = skype.getItemMeta();
		skypeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.skype.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.skype.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			skypeMeta.setLore(lores);
		}
		skype.setItemMeta(skypeMeta);
		
		ItemStack tntMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/c4d7fc8e3a959ade7d9cf663f1e82db7975543e288ab8d11eb2541888213526");
		ItemMeta tntMinecartMeta = tntMinecart.getItemMeta();
		tntMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.tnt-minecart.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.tnt-minecart.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tntMinecartMeta.setLore(lores);
		}
		tntMinecart.setItemMeta(tntMinecartMeta);
		
		ItemStack furnaceMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/e079abbafb981c795a9a2f82bab3fbd9f166b8c0dbf9a1751d769beac667b6");
		ItemMeta furnaceMinecartMeta = furnaceMinecart.getItemMeta();
		furnaceMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.furnace-minecart.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.furnace-minecart.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			furnaceMinecartMeta.setLore(lores);
		}
		furnaceMinecart.setItemMeta(furnaceMinecartMeta);
		
		ItemStack chestMinecart  = SkullItem.getSkull("http://textures.minecraft.net/texture/4ced34211fed4010a8c85724a27fa5fb205d67684b3da517b6821279c6b65d3f");
		ItemMeta chestMinecartMeta = chestMinecart.getItemMeta();
		chestMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.chest-minecart.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.chest-minecart.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chestMinecartMeta.setLore(lores);
		}
		chestMinecart.setItemMeta(chestMinecartMeta);
		
		ItemStack commandBlockMinecart = SkullItem.getSkull("http://textures.minecraft.net/texture/ba9053d2163d0f561145d33a513145d4ac1f8a458baa796be383e7525a05f45");
		ItemMeta commandBlockMinecartMeta = commandBlockMinecart.getItemMeta();
		commandBlockMinecartMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.command-block-minecart.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.command-block-minecart.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			commandBlockMinecartMeta.setLore(lores);
		}
		commandBlockMinecart.setItemMeta(commandBlockMinecartMeta);
		
		ItemStack scared = SkullItem.getSkull("http://textures.minecraft.net/texture/636e26c44659e8148ed58aa79e4d60db595f426442116f81b5415c2446ed8");
		ItemMeta scaredMeta = scared.getItemMeta();
		scaredMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.scared.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.scared.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			scaredMeta.setLore(lores);
		}
		scared.setItemMeta(scaredMeta);
		
		ItemStack angel = SkullItem.getSkull("http://textures.minecraft.net/texture/3e1debc73231f8ed4b69d5c3ac1b1f18f3656a8988e23f2e1bdbc4e85f6d46a");
		ItemMeta angelMeta = angel.getItemMeta();
		angelMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.angel.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.angel.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			angelMeta.setLore(lores);
		}
		angel.setItemMeta(angelMeta);
		
		ItemStack embarrased = SkullItem.getSkull("http://textures.minecraft.net/texture/f720df911c052377065408db78a25c678f791eb944c063935ae86dbe51c71b");
		ItemMeta embarrasedMeta = embarrased.getItemMeta();
		embarrasedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.embarrased.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.embarrased.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			embarrasedMeta.setLore(lores);
		}
		embarrased.setItemMeta(embarrasedMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
				
		//next page		
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-1.next-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-1.next-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nextMeta.setLore(lores);
		}
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
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
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
 }