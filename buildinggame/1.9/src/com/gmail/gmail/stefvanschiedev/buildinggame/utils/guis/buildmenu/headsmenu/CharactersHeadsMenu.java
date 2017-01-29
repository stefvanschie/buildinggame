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

public class CharactersHeadsMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public CharactersHeadsMenu() {
		super(null, 54, MessageManager.translate(messages.getString("gui.heads.characters.title")), 2);
	
		//page one
		ItemStack toyChica = SkullItem.getSkull("http://textures.minecraft.net/texture/cc37668d5eae18ba766cd5c8ebc75c48de1ba44cbe489d829a5eca8691bf556");
		ItemMeta toyChicaMeta = toyChica.getItemMeta();
		toyChicaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-chica.name")));
		toyChicaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-chica.lores")));
		toyChica.setItemMeta(toyChicaMeta);
		
		addItem(toyChica, new Action());
		
		ItemStack zoidberg = SkullItem.getSkull("http://textures.minecraft.net/texture/8238c114b27ca9ffd6e7754fec582c7e369928283b2d7fce149eaa312bd2");
		ItemMeta zoidbergMeta = zoidberg.getItemMeta();
		zoidbergMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.zoidberg.name")));
		zoidbergMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.zoidberg.lores")));
		zoidberg.setItemMeta(zoidbergMeta);
		
		addItem(zoidberg, new Action());
		
		ItemStack ewok = SkullItem.getSkull("http://textures.minecraft.net/texture/f33eca699384f3d1fc6cd1d1ed5a8b8c34798c6568eb1844e53cbdc3598");
		ItemMeta ewokMeta = ewok.getItemMeta();
		ewokMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.ewok.name")));
		ewokMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.ewok.lores")));
		ewok.setItemMeta(ewokMeta);
		
		addItem(ewok, new Action());
		
		ItemStack mangle = SkullItem.getSkull("http://textures.minecraft.net/texture/4e1159e1aad239597dea98629e094654015c6ddb9ced2c9b0f3bc12d9e63af8");
		ItemMeta mangleMeta = mangle.getItemMeta();
		mangleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.mangle.name")));
		mangleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.mangle.lores")));
		mangle.setItemMeta(mangleMeta);
		
		addItem(mangle, new Action());
		
		ItemStack zelda = SkullItem.getSkull("http://textures.minecraft.net/texture/fc96a14dc1cb943b8ff3c92aacb0102c2389eedef50d36b714d0db98b27a");
		ItemMeta zeldaMeta = zelda.getItemMeta();
		zeldaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.zelda.name")));
		zeldaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.zelda.lores")));
		zelda.setItemMeta(zeldaMeta);
		
		addItem(zelda, new Action());
		
		ItemStack freddyFazbear = SkullItem.getSkull("http://textures.minecraft.net/texture/ed3f3e114c631cadc8a5606021b4b4f9e15fa6ec89d3eeeb1cec825cf29b883");
		ItemMeta freddyFazbearMeta = freddyFazbear.getItemMeta();
		freddyFazbearMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.freddy-fazbear.name")));
		freddyFazbearMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.freddy-fazbear.lores")));
		freddyFazbear.setItemMeta(freddyFazbearMeta);
		
		addItem(freddyFazbear, new Action());
		
		ItemStack bonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/2f3faca3d13e6ec373d7a28dab8959fc2b7ccce5fb617b1c563aadbb03932");
		ItemMeta bonnieMeta = bonnie.getItemMeta();
		bonnieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.bonnie.name")));
		bonnieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.bonnie.lores")));
		bonnie.setItemMeta(bonnieMeta);
		
		addItem(bonnie, new Action());
		
		ItemStack chica = SkullItem.getSkull("http://textures.minecraft.net/texture/17a1d42ef71187577291d6ae93a4beb8b161a43bc26562201ca25152b6ff387");
		ItemMeta chicaMeta = chica.getItemMeta();
		chicaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.chica.name")));
		chicaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.chica.lores")));
		chica.setItemMeta(chicaMeta);

		addItem(chica, new Action());

		ItemStack foxie = SkullItem.getSkull("http://textures.minecraft.net/texture/b2812aaa954773f2ada5a2f77e32ba2f7d8d1f5d1bb4a30f86279642d3d8bb8");
		ItemMeta foxieMeta = foxie.getItemMeta();
		foxieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.foxie.name")));
		foxieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.foxie.lores")));
		foxie.setItemMeta(foxieMeta);
		
		addItem(foxie, new Action());
		
		ItemStack marionette = SkullItem.getSkull("http://textures.minecraft.net/texture/7ecae8fdd9233b82dc2f7a9445450b4a52f1c383a2417991c82ed71bf795ac1");
		ItemMeta marionetteMeta = marionette.getItemMeta();
		marionetteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.marionette.name")));
		marionetteMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.marionette.lores")));
		marionette.setItemMeta(marionetteMeta);
		
		addItem(marionette, new Action());
		
		ItemStack mangle2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c73ad1ebeb9b7525708a933bdae086599a8dcd66d8b414531ce63bf9953bd3e");
		ItemMeta mangle2Meta = mangle2.getItemMeta();
		mangle2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.mangle-2.name")));
		mangle2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.mangle-2.lores")));
		mangle2.setItemMeta(mangle2Meta);
		
		addItem(mangle2, new Action());
		
		ItemStack link = SkullItem.getSkull("http://textures.minecraft.net/texture/daa05966dbb39f780e7ea63a29560d8eb48e0c2497a818a89564a5a14a33ef");
		ItemMeta linkMeta = link.getItemMeta();
		linkMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.link.name")));
		linkMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.link.lores")));
		link.setItemMeta(linkMeta);
		
		addItem(link, new Action());
		
		ItemStack stitch = SkullItem.getSkull("http://textures.minecraft.net/texture/16a8cbe9b5b656345ae034befead26b93677febc88725490416ce7babbd59f3d");
		ItemMeta stitchMeta = stitch.getItemMeta();
		stitchMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.stitch.name")));
		stitchMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.stitch.lores")));
		stitch.setItemMeta(stitchMeta);
		
		addItem(stitch, new Action());
		
		ItemStack groot = SkullItem.getSkull("http://textures.minecraft.net/texture/23c71a85eeb3cd6449159675aa89278a2a1d587b4d0b768174fc2e15c9be4d");
		ItemMeta grootMeta = groot.getItemMeta();
		grootMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.groot.name")));
		grootMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.groot.lores")));
		groot.setItemMeta(grootMeta);
		
		addItem(groot, new Action());
		
		ItemStack starLord = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b81e1747b3040801069768b7cee85a32fe0ea578d7a488783c7778e72d7e7");
		ItemMeta starLordMeta = starLord.getItemMeta();
		starLordMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.star-lord.name")));
		starLordMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.star-lord.lores")));
		starLord.setItemMeta(starLordMeta);
		
		addItem(starLord, new Action());
		
		ItemStack bobaFett = SkullItem.getSkull("http://textures.minecraft.net/texture/fbfef5e06533979d57caa4fbce260ec1e4f24174aa772f60f068a0f9ac63ee");
		ItemMeta bobaFettMeta = bobaFett.getItemMeta();
		bobaFettMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.boba-fett.name")));
		bobaFettMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.boba-fett.lores")));
		bobaFett.setItemMeta(bobaFettMeta);
		
		addItem(bobaFett, new Action());
		
		ItemStack stormTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/e32c336da84a7ba610c881aa995f9664f19dc2c40bd11449e20c6c3a3e751");
		ItemMeta stormTrooperMeta = stormTrooper.getItemMeta();
		stormTrooperMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.storm-trooper.name")));
		stormTrooperMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.storm-trooper.lores")));
		stormTrooper.setItemMeta(stormTrooperMeta);
		
		addItem(stormTrooper, new Action());
		
		ItemStack cloneTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/77e0d72cf441cce94cce3cb3bccec6fec5f8ac2d79bc963d8b74d54a2062");
		ItemMeta cloneTrooperMeta = cloneTrooper.getItemMeta();
		cloneTrooperMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.clone-trooper.name")));
		cloneTrooperMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.clone-trooper.lores")));
		cloneTrooper.setItemMeta(cloneTrooperMeta);
		
		addItem(cloneTrooper, new Action());
		
		ItemStack r2D2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7cebc97798c2e360551cab3dd5db6d53497fe63040941c9ac491a59cbf383a7a");
		ItemMeta r2D2Meta = r2D2.getItemMeta();
		r2D2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.r2d2.name")));
		r2D2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.r2d2.lores")));
		r2D2.setItemMeta(r2D2Meta);
		
		addItem(r2D2, new Action());
		
		ItemStack darthVader = SkullItem.getSkull("http://textures.minecraft.net/texture/c1c3e1f224b446ccac6a6cc3cd9891019a122f99691c3907992a3af99a21b0");
		ItemMeta darthVaderMeta = darthVader.getItemMeta();
		darthVaderMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.darth-vader.name")));
		darthVaderMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.darth-vader.lores")));
		darthVader.setItemMeta(darthVaderMeta);
		
		addItem(darthVader, new Action());
		
		ItemStack patrick = SkullItem.getSkull("http://textures.minecraft.net/texture/b971b927729c6eace16593b33a986d61943d62f6961de6db599a818b2af32");
		ItemMeta patrickMeta = patrick.getItemMeta();
		patrickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.patrick.name")));
		patrickMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.patrick.lores")));
		patrick.setItemMeta(patrickMeta);
		
		addItem(patrick, new Action());
		
		ItemStack spongebob = SkullItem.getSkull("http://textures.minecraft.net/texture/5e71ef39af4e33ebcf69a4be6379543c5015aaec76bab6fc3d862a75dfe3c47");
		ItemMeta spongebobMeta = spongebob.getItemMeta();
		spongebobMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.spongebob.name")));
		spongebobMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.spongebob.lores")));
		spongebob.setItemMeta(spongebobMeta);
		
		addItem(spongebob, new Action());
		
		ItemStack iceKing = SkullItem.getSkull("http://textures.minecraft.net/texture/c2cee62b99d804dddedcfe7a71a10c2d7c8c1616aacb91db82e47a22dd314");
		ItemMeta iceKingMeta = iceKing.getItemMeta();
		iceKingMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.ice-king.name")));
		iceKingMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.ice-king.lores")));
		iceKing.setItemMeta(iceKingMeta);
		
		addItem(iceKing, new Action());
		
		ItemStack jake = SkullItem.getSkull("http://textures.minecraft.net/texture/53d1877be95a9edb86df2256f23958324c2ec19ef94277ce2fb5c3301841dc");
		ItemMeta jakeMeta = jake.getItemMeta();
		jakeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.jake.name")));
		jakeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.jake.lores")));
		jake.setItemMeta(jakeMeta);
		
		addItem(jake, new Action());
		
		ItemStack finn = SkullItem.getSkull("http://textures.minecraft.net/texture/b51d5966ea472c43ef52a5f657ff859203bea28fe4bedce5a1cd789b3ac4ba");
		ItemMeta finnMeta = finn.getItemMeta();
		finnMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.finn.name")));
		finnMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.finn.lores")));
		finn.setItemMeta(finnMeta);
		
		addItem(finn, new Action());
		
		ItemStack sonic = SkullItem.getSkull("http://textures.minecraft.net/texture/c5f5c9ff94c0dd5cbb1e271a817e6e9c552e3928b159519dd226efabdd");
		ItemMeta sonicMeta = sonic.getItemMeta();
		sonicMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.sonic.name")));
		sonicMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.sonic.lores")));
		sonic.setItemMeta(sonicMeta);
		
		addItem(sonic, new Action());
		
		ItemStack metaknight = SkullItem.getSkull("http://textures.minecraft.net/texture/146449373682381a65cae65a2253d8b36b293776412c5df8dea4d964393af7a");
		ItemMeta metaknightMeta = metaknight.getItemMeta();
		metaknightMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.metaknight.name")));
		metaknightMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.metaknight.lores")));
		metaknight.setItemMeta(metaknightMeta);
		
		addItem(metaknight, new Action());
		
		ItemStack ness = SkullItem.getSkull("http://textures.minecraft.net/texture/19577a9bda64f716a169222299add56fc746cfd85560b3971d9762a48366");
		ItemMeta nessMeta = ness.getItemMeta();
		nessMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.ness.name")));
		nessMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.ness.lores")));
		ness.setItemMeta(nessMeta);
		
		addItem(ness, new Action());
		
		ItemStack wario = SkullItem.getSkull("http://textures.minecraft.net/texture/ca8b3a1af2d8fc37729f6f63fdba5d5e209758ded4b2fcf6add4b85bf67edd72");
		ItemMeta warioMeta = wario.getItemMeta();
		warioMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.wario.name")));
		warioMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.wario.lores")));
		wario.setItemMeta(warioMeta);
		
		addItem(wario, new Action());
		
		ItemStack princessPeach = SkullItem.getSkull("http://textures.minecraft.net/texture/feb9331acdf3cb76bd3a56ddd59b8b1398a54952f534551df81422abbe94f");
		ItemMeta princessPeachMeta = princessPeach.getItemMeta();
		princessPeachMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.princess-peach.name")));
		princessPeachMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.princess-peach.lores")));
		princessPeach.setItemMeta(princessPeachMeta);
		
		addItem(princessPeach, new Action());
		
		ItemStack foxMccloud = SkullItem.getSkull("http://textures.minecraft.net/texture/71be29750ddec80994bda79653e21ed70d5b2eb793da51d5a87b89bf67dcb96");
		ItemMeta foxMccloudMeta = foxMccloud.getItemMeta();
		foxMccloudMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.fox-mccloud.name")));
		foxMccloudMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.fox-mccloud.lores")));
		foxMccloud.setItemMeta(foxMccloudMeta);
		
		addItem(foxMccloud, new Action());
		
		ItemStack bowser = SkullItem.getSkull("http://textures.minecraft.net/texture/e860610ed30785e6229e82e2897b42fdabb1df6296d3731fac2744e56a9eb9");
		ItemMeta bowserMeta = bowser.getItemMeta();
		bowserMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.bowser.name")));
		bowserMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.bowser.lores")));
		bowser.setItemMeta(bowserMeta);
		
		addItem(bowser, new Action());
		
		ItemStack mario = SkullItem.getSkull("http://textures.minecraft.net/texture/6f7eb75e5542cc4937aaad5bb8657393eaf0265006eac1dc96691f32e16437");
		ItemMeta marioMeta = mario.getItemMeta();
		marioMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.mario.name")));
		marioMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.mario.lores")));
		mario.setItemMeta(marioMeta);
		
		addItem(mario, new Action());
		
		ItemStack luigi = SkullItem.getSkull("http://textures.minecraft.net/texture/ff1533871e49ddab8f1ca82edb1153a5e2ed3764fd1ce029bf829f4b3caac3");
		ItemMeta luigiMeta = luigi.getItemMeta();
		luigiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.luigi.name")));
		luigiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.luigi.lores")));
		luigi.setItemMeta(luigiMeta);
		
		addItem(luigi, new Action());
		
		ItemStack yoshi = SkullItem.getSkull("http://textures.minecraft.net/texture/671ebc11bdd151410da70d931259c4e969528e6f5889e9c4bb2dd763b9eafd");
		ItemMeta yoshiMeta = yoshi.getItemMeta();
		yoshiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.yoshi.name")));
		yoshiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.yoshi.lores")));
		yoshi.setItemMeta(yoshiMeta);
		
		addItem(yoshi, new Action());
		
		ItemStack ashKetchum = SkullItem.getSkull("http://textures.minecraft.net/texture/dc23586f51fc98b55450bb9a37a066caac2765c1d471cb891094a8ec032befb");
		ItemMeta ashKetchumMeta = ashKetchum.getItemMeta();
		ashKetchumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.ash-ketchum.name")));
		ashKetchumMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.ash-ketchum.lores")));
		ashKetchum.setItemMeta(ashKetchumMeta);
		
		addItem(ashKetchum, new Action());
		
		ItemStack samus = SkullItem.getSkull("http://textures.minecraft.net/texture/3a8d314cc31ca8adf2ee99be39b32732be6d6be8510ba8ed4af1b8fab2ef0f9");
		ItemMeta samusMeta = samus.getItemMeta();
		samusMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.samus.name")));
		samusMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.samus.lores")));
		samus.setItemMeta(samusMeta);
		
		addItem(samus, new Action());
		
		ItemStack ganondorf = SkullItem.getSkull("http://textures.minecraft.net/texture/3b785436914d448886f876be0f487cf4c332d696f66570a84e86f8fa67f");
		ItemMeta ganondorfMeta = ganondorf.getItemMeta();
		ganondorfMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.ganondorf.name")));
		ganondorfMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.ganondorf.lores")));
		ganondorf.setItemMeta(ganondorfMeta);
		
		addItem(ganondorf, new Action());
		
		ItemStack toyBonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/b695b4c797d64e4f492e56b8259c5be6448616b9d59f06c199261da359fa5d");
		ItemMeta toyBonnieMeta = toyBonnie.getItemMeta();
		toyBonnieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-bonnie.name")));
		toyBonnieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-bonnie.lores")));
		toyBonnie.setItemMeta(toyBonnieMeta);
		
		addItem(toyBonnie, new Action());
		
		ItemStack toyFreddie = SkullItem.getSkull("http://textures.minecraft.net/texture/445792e943f184878cafc8a271c2cfb3b0f7bb76c2b19a1292b440db367557");
		ItemMeta toyFreddieMeta = toyFreddie.getItemMeta();
		toyFreddieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-freddie.name")));
		toyFreddieMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-freddie.lores")));
		toyFreddie.setItemMeta(toyFreddieMeta);
		
		addItem(toyFreddie, new Action());
		
		ItemStack toyChica2 = SkullItem.getSkull("http://textures.minecraft.net/texture/6c46284c4948bfd17c1eb6d96cdfaf4b13080c476811a1ef7b9d75ab3c185d1");
		ItemMeta toyChica2Meta = toyChica2.getItemMeta();
		toyChica2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-chica-2.name")));
		toyChica2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-chica-2.lores")));
		toyChica2.setItemMeta(toyChica2Meta);
		
		addItem(toyChica, new Action());
		
		ItemStack toyMangle = SkullItem.getSkull("http://textures.minecraft.net/texture/fbd284997752a4802b8ceb4b4651338b44b6d477965b737f1985b6faf5e22ab");
		ItemMeta toyMangleMeta = toyMangle.getItemMeta();
		toyMangleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-mangle.name")));
		toyMangleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-mangle.lores")));
		toyMangle.setItemMeta(toyMangleMeta);
		
		addItem(toyMangle, new Action());
		
		ItemStack balloonBoy = SkullItem.getSkull("http://textures.minecraft.net/texture/8a48dd4ad18afb22fe572852706b8019a78d8f159486e742ff761c638d202f5b");
		ItemMeta balloonBoyMeta = balloonBoy.getItemMeta();
		balloonBoyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.balloon-boy.name")));
		balloonBoyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.balloon-boy.lores")));
		balloonBoy.setItemMeta(balloonBoyMeta);
		
		addItem(balloonBoy, new Action());
		
		ItemStack vegetta = SkullItem.getSkull("http://textures.minecraft.net/texture/4fc1d88be2528168f67da16a19b14f04e1e4963a99dfcb4e49d984a351313c");
		ItemMeta vegettaMeta = vegetta.getItemMeta();
		vegettaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.vegetta.name")));
		vegettaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.vegetta.lores")));
		vegetta.setItemMeta(vegettaMeta);
		
		addItem(vegetta, new Action());
		
		ItemStack masterchief = SkullItem.getSkull("http://textures.minecraft.net/texture/2548844c48b082df57cb4aadc6b23a4af49e3be028f216c62ef539ab84ccbc0");
		ItemMeta masterchiefMeta = masterchief.getItemMeta();
		masterchiefMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.masterchief.name")));
		masterchiefMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.masterchief.lores")));
		masterchief.setItemMeta(masterchiefMeta);
		
		addItem(masterchief, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.close.name")));
		closeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.close.lores")));
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
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.next-page.name")));
		nextMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.next-page.lores")));
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
		ItemStack bender = SkullItem.getSkull("http://textures.minecraft.net/texture/6e23d607e92e729af9664bfa26be958b4b2f9f3e012eed833f9a35ea4c4b0");
		ItemMeta benderMeta = bender.getItemMeta();
		benderMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.bender.name")));
		benderMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.bender.lores")));
		bender.setItemMeta(benderMeta);
		
		addItem(bender, new Action());
		
		ItemStack wheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta wheatleyMeta = wheatley.getItemMeta();
		wheatleyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.wheatley.name")));
		wheatleyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.wheatley.lores")));
		wheatley.setItemMeta(wheatleyMeta);
		
		addItem(wheatley, new Action());
		
		ItemStack wilson = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonMeta = wilson.getItemMeta();
		wilsonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.wilson.name")));
		wilsonMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.wilson.lores")));
		wilson.setItemMeta(wilsonMeta);
		
		addItem(wilson, new Action());
		
		ItemStack masterchief2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b775a17c2941ae6a2a5f1840509b9ab0c0d96859a9bc249798b86f1952b0832e");
		ItemMeta masterchief2Meta = masterchief2.getItemMeta();
		masterchief2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.masterchief-2.name")));
		masterchief2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.masterchief-2.lores")));
		masterchief2.setItemMeta(masterchief2Meta);
		
		addItem(masterchief2, new Action());
		
		ItemStack batman = SkullItem.getSkull("http://textures.minecraft.net/texture/f256f71735ef458581c9dacf394185eed9b33cb6ec5cd594a57153a8b566560");
		ItemMeta batmanMeta = batman.getItemMeta();
		batmanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.batman.name")));
		batmanMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.batman.lores")));
		batman.setItemMeta(batmanMeta);
		
		addItem(batman, new Action());
		
		ItemStack joker = SkullItem.getSkull("http://textures.minecraft.net/texture/af4f6825ef6d5e46d794697d1bf86d144bf6fb3da4e55f7cf55271f637eaa7");
		ItemMeta jokerMeta = joker.getItemMeta();
		jokerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.joker.name")));
		jokerMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.joker.lores")));
		joker.setItemMeta(jokerMeta);
		
		addItem(joker, new Action());
		
		ItemStack bender2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b15fe247d9c61a6c137544de7e6220f84759e33335b0b551832fa1f8a262c23a");
		ItemMeta bender2Meta = bender2.getItemMeta();
		bender2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.bender-2.name")));
		bender2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.bender-2.lores")));
		bender2.setItemMeta(bender2Meta);
		
		addItem(bender2, new Action());
		
		ItemStack captainAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7ec527713d34c1167eed0cd1e969dbfad5d44a752154ccaf64c1c7ab6bc3f3f");
		ItemMeta captainAmericaMeta = captainAmerica.getItemMeta();
		captainAmericaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.captain-america.name")));
		captainAmericaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.captain-america.lores")));
		captainAmerica.setItemMeta(captainAmericaMeta);
		
		addItem(captainAmerica, new Action());
		
		ItemStack deadpool = SkullItem.getSkull("http://textures.minecraft.net/texture/dc15c31639e93f2bb274cf29d244a8a2906e80ab8bd2c0121c7fd1e2624d53");
		ItemMeta deadpoolMeta = deadpool.getItemMeta();
		deadpoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.deadpool.name")));
		deadpoolMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.deadpool.lores")));
		deadpool.setItemMeta(deadpoolMeta);
		
		addItem(deadpool, new Action());
		
		ItemStack doge = SkullItem.getSkull("http://textures.minecraft.net/texture/b9afb2e5f0b977c4c683e017d2b47fcd1488ab56397766e5b380405a139260");
		ItemMeta dogeMeta = doge.getItemMeta();
		dogeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.doge.name")));
		dogeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.doge.lores")));
		doge.setItemMeta(dogeMeta);
		
		addItem(doge, new Action());
		
		ItemStack toyFreddy = SkullItem.getSkull("http://textures.minecraft.net/texture/dc3f2e93d03294d4aa931e9967f2d5bcd2af909bfe38ee81d1bda7f682fdc3");
		ItemMeta toyFreddyMeta = toyFreddy.getItemMeta();
		toyFreddyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-freddy.name")));
		toyFreddyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-freddy.lores")));
		toyFreddy.setItemMeta(toyFreddyMeta);
		
		addItem(toyFreddy, new Action());
		
		ItemStack toyBonnie2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a75dbe970d547b2561f8b658130359176246f89e74a4abdc6834155c8c4c81a");
		ItemMeta toyBonnie2Meta = toyBonnie2.getItemMeta();
		toyBonnie2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.toy-bonnie-2.name")));
		toyBonnie2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.toy-bonnie-2.lores")));
		toyBonnie2.setItemMeta(toyBonnie2Meta);
		
		addItem(toyBonnie2, new Action());
		
		ItemStack goomba = SkullItem.getSkull("http://textures.minecraft.net/texture/aecf94f4bcbbf6eadcb25aa3d069aa678ebdb5241eb82e8e26889caf3275570");
		ItemMeta goombaMeta = goomba.getItemMeta();
		goombaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.goomba.name")));
		goombaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.goomba.lores")));
		goomba.setItemMeta(goombaMeta);
		
		addItem(goomba, new Action());
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.previous-page.lores")));
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
		close2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.close.name")));
		close2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.characters.close.lores")));
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