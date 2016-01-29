package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.characters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class CharactersHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Characters");
		
		ItemStack toyChica = SkullItem.getSkull("http://textures.minecraft.net/texture/cc37668d5eae18ba766cd5c8ebc75c48de1ba44cbe489d829a5eca8691bf556");
		ItemMeta toyChicaMeta = toyChica.getItemMeta();
		toyChicaMeta.setDisplayName(ChatColor.GOLD + "Toy Chica");
		toyChica.setItemMeta(toyChicaMeta);
		
		ItemStack zoidberg = SkullItem.getSkull("http://textures.minecraft.net/texture/8238c114b27ca9ffd6e7754fec582c7e369928283b2d7fce149eaa312bd2");
		ItemMeta zoidbergMeta = zoidberg.getItemMeta();
		zoidbergMeta.setDisplayName(ChatColor.GOLD + "Zoidberg");
		zoidberg.setItemMeta(zoidbergMeta);
		
		ItemStack ewok = SkullItem.getSkull("http://textures.minecraft.net/texture/f33eca699384f3d1fc6cd1d1ed5a8b8c34798c6568eb1844e53cbdc3598");
		ItemMeta ewokMeta = ewok.getItemMeta();
		ewokMeta.setDisplayName(ChatColor.GOLD + "Ewok");
		ewok.setItemMeta(ewokMeta);
		
		ItemStack mangle = SkullItem.getSkull("http://textures.minecraft.net/texture/4e1159e1aad239597dea98629e094654015c6ddb9ced2c9b0f3bc12d9e63af8");
		ItemMeta mangleMeta = mangle.getItemMeta();
		mangleMeta.setDisplayName(ChatColor.GOLD + "Mangle");
		mangle.setItemMeta(mangleMeta);
		
		ItemStack zelda = SkullItem.getSkull("http://textures.minecraft.net/texture/fc96a14dc1cb943b8ff3c92aacb0102c2389eedef50d36b714d0db98b27a");
		ItemMeta zeldaMeta = zelda.getItemMeta();
		zeldaMeta.setDisplayName(ChatColor.GOLD + "Zelda");
		zelda.setItemMeta(zeldaMeta);
		
		ItemStack freddyFazbear = SkullItem.getSkull("http://textures.minecraft.net/texture/ed3f3e114c631cadc8a5606021b4b4f9e15fa6ec89d3eeeb1cec825cf29b883");
		ItemMeta freddyFazbearMeta = freddyFazbear.getItemMeta();
		freddyFazbearMeta.setDisplayName(ChatColor.GOLD + "Freddy Fazbear");
		freddyFazbear.setItemMeta(freddyFazbearMeta);
		
		ItemStack bonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/2f3faca3d13e6ec373d7a28dab8959fc2b7ccce5fb617b1c563aadbb03932");
		ItemMeta bonnieMeta = bonnie.getItemMeta();
		bonnieMeta.setDisplayName(ChatColor.GOLD + "Bonnie");
		bonnie.setItemMeta(bonnieMeta);
		
		ItemStack chica = SkullItem.getSkull("http://textures.minecraft.net/texture/17a1d42ef71187577291d6ae93a4beb8b161a43bc26562201ca25152b6ff387");
		ItemMeta chicaMeta = chica.getItemMeta();
		chicaMeta.setDisplayName(ChatColor.GOLD + "Chica");
		chica.setItemMeta(chicaMeta);
		
		ItemStack foxie = SkullItem.getSkull("http://textures.minecraft.net/texture/b2812aaa954773f2ada5a2f77e32ba2f7d8d1f5d1bb4a30f86279642d3d8bb8");
		ItemMeta foxieMeta = foxie.getItemMeta();
		foxieMeta.setDisplayName(ChatColor.GOLD + "Foxie");
		foxie.setItemMeta(foxieMeta);
		
		ItemStack marionette = SkullItem.getSkull("http://textures.minecraft.net/texture/7ecae8fdd9233b82dc2f7a9445450b4a52f1c383a2417991c82ed71bf795ac1");
		ItemMeta marionetteMeta = marionette.getItemMeta();
		marionetteMeta.setDisplayName(ChatColor.GOLD + "Marionette");
		marionette.setItemMeta(marionetteMeta);
		
		ItemStack mangle2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c73ad1ebeb9b7525708a933bdae086599a8dcd66d8b414531ce63bf9953bd3e");
		ItemMeta mangle2Meta = mangle2.getItemMeta();
		mangle2Meta.setDisplayName(ChatColor.GOLD + "Mangle");
		mangle2.setItemMeta(mangle2Meta);
		
		ItemStack link = SkullItem.getSkull("http://textures.minecraft.net/texture/daa05966dbb39f780e7ea63a29560d8eb48e0c2497a818a89564a5a14a33ef");
		ItemMeta linkMeta = link.getItemMeta();
		linkMeta.setDisplayName(ChatColor.GOLD + "Link");
		link.setItemMeta(linkMeta);
		
		ItemStack stitch = SkullItem.getSkull("http://textures.minecraft.net/texture/16a8cbe9b5b656345ae034befead26b93677febc88725490416ce7babbd59f3d");
		ItemMeta stitchMeta = stitch.getItemMeta();
		stitchMeta.setDisplayName(ChatColor.GOLD + "Stitch");
		stitch.setItemMeta(stitchMeta);
		
		ItemStack groot = SkullItem.getSkull("http://textures.minecraft.net/texture/23c71a85eeb3cd6449159675aa89278a2a1d587b4d0b768174fc2e15c9be4d");
		ItemMeta grootMeta = groot.getItemMeta();
		grootMeta.setDisplayName(ChatColor.GOLD + "Groot");
		groot.setItemMeta(grootMeta);
		
		ItemStack starLord = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b81e1747b3040801069768b7cee85a32fe0ea578d7a488783c7778e72d7e7");
		ItemMeta starLordMeta = starLord.getItemMeta();
		starLordMeta.setDisplayName(ChatColor.GOLD + "Star Lord");
		starLord.setItemMeta(starLordMeta);
		
		ItemStack bobaFett = SkullItem.getSkull("http://textures.minecraft.net/texture/fbfef5e06533979d57caa4fbce260ec1e4f24174aa772f60f068a0f9ac63ee");
		ItemMeta bobaFettMeta = bobaFett.getItemMeta();
		bobaFettMeta.setDisplayName(ChatColor.GOLD + "Boba Fett");
		bobaFett.setItemMeta(bobaFettMeta);
		
		ItemStack stormTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/e32c336da84a7ba610c881aa995f9664f19dc2c40bd11449e20c6c3a3e751");
		ItemMeta stormTrooperMeta = stormTrooper.getItemMeta();
		stormTrooperMeta.setDisplayName(ChatColor.GOLD + "Storm Trooper");
		stormTrooper.setItemMeta(stormTrooperMeta);
		
		ItemStack cloneTrooper = SkullItem.getSkull("http://textures.minecraft.net/texture/77e0d72cf441cce94cce3cb3bccec6fec5f8ac2d79bc963d8b74d54a2062");
		ItemMeta cloneTrooperMeta = cloneTrooper.getItemMeta();
		cloneTrooperMeta.setDisplayName(ChatColor.GOLD + "Clone Trooper");
		cloneTrooper.setItemMeta(cloneTrooperMeta);
		
		ItemStack r2D2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7cebc97798c2e360551cab3dd5db6d53497fe63040941c9ac491a59cbf383a7a");
		ItemMeta r2D2Meta = r2D2.getItemMeta();
		r2D2Meta.setDisplayName(ChatColor.GOLD + "R2D2");
		r2D2.setItemMeta(r2D2Meta);
		
		ItemStack darthVader = SkullItem.getSkull("http://textures.minecraft.net/texture/c1c3e1f224b446ccac6a6cc3cd9891019a122f99691c3907992a3af99a21b0");
		ItemMeta darthVaderMeta = darthVader.getItemMeta();
		darthVaderMeta.setDisplayName(ChatColor.GOLD + "Darth Vader");
		darthVader.setItemMeta(darthVaderMeta);
		
		ItemStack patrick = SkullItem.getSkull("http://textures.minecraft.net/texture/b971b927729c6eace16593b33a986d61943d62f6961de6db599a818b2af32");
		ItemMeta patrickMeta = patrick.getItemMeta();
		patrickMeta.setDisplayName(ChatColor.GOLD + "Patrick");
		patrick.setItemMeta(patrickMeta);
		
		ItemStack spongebob = SkullItem.getSkull("http://textures.minecraft.net/texture/5e71ef39af4e33ebcf69a4be6379543c5015aaec76bab6fc3d862a75dfe3c47");
		ItemMeta spongebobMeta = spongebob.getItemMeta();
		spongebobMeta.setDisplayName(ChatColor.GOLD + "Spongebob");
		spongebob.setItemMeta(spongebobMeta);
		
		ItemStack iceKing = SkullItem.getSkull("http://textures.minecraft.net/texture/c2cee62b99d804dddedcfe7a71a10c2d7c8c1616aacb91db82e47a22dd314");
		ItemMeta iceKingMeta = iceKing.getItemMeta();
		iceKingMeta.setDisplayName(ChatColor.GOLD + "Ice King");
		iceKing.setItemMeta(iceKingMeta);
		
		ItemStack jake = SkullItem.getSkull("http://textures.minecraft.net/texture/53d1877be95a9edb86df2256f23958324c2ec19ef94277ce2fb5c3301841dc");
		ItemMeta jakeMeta = jake.getItemMeta();
		jakeMeta.setDisplayName(ChatColor.GOLD + "Jake");
		jake.setItemMeta(jakeMeta);
		
		ItemStack finn = SkullItem.getSkull("http://textures.minecraft.net/texture/b51d5966ea472c43ef52a5f657ff859203bea28fe4bedce5a1cd789b3ac4ba");
		ItemMeta finnMeta = finn.getItemMeta();
		finnMeta.setDisplayName(ChatColor.GOLD + "Finn");
		finn.setItemMeta(finnMeta);
		
		ItemStack sonic = SkullItem.getSkull("http://textures.minecraft.net/texture/c5f5c9ff94c0dd5cbb1e271a817e6e9c552e3928b159519dd226efabdd");
		ItemMeta sonicMeta = sonic.getItemMeta();
		sonicMeta.setDisplayName(ChatColor.GOLD + "Sonic");
		sonic.setItemMeta(sonicMeta);
		
		ItemStack metaknight = SkullItem.getSkull("http://textures.minecraft.net/texture/146449373682381a65cae65a2253d8b36b293776412c5df8dea4d964393af7a");
		ItemMeta metaknightMeta = metaknight.getItemMeta();
		metaknightMeta.setDisplayName(ChatColor.GOLD + "Metaknight");
		metaknight.setItemMeta(metaknightMeta);
		
		ItemStack ness = SkullItem.getSkull("http://textures.minecraft.net/texture/19577a9bda64f716a169222299add56fc746cfd85560b3971d9762a48366");
		ItemMeta nessMeta = ness.getItemMeta();
		nessMeta.setDisplayName(ChatColor.GOLD + "Ness");
		ness.setItemMeta(nessMeta);
		
		ItemStack wario = SkullItem.getSkull("http://textures.minecraft.net/texture/ca8b3a1af2d8fc37729f6f63fdba5d5e209758ded4b2fcf6add4b85bf67edd72");
		ItemMeta warioMeta = wario.getItemMeta();
		warioMeta.setDisplayName(ChatColor.GOLD + "Wario");
		wario.setItemMeta(warioMeta);
		
		ItemStack princessPeach = SkullItem.getSkull("http://textures.minecraft.net/texture/feb9331acdf3cb76bd3a56ddd59b8b1398a54952f534551df81422abbe94f");
		ItemMeta princessPeachMeta = princessPeach.getItemMeta();
		princessPeachMeta.setDisplayName(ChatColor.GOLD + "Princess Peach");
		princessPeach.setItemMeta(princessPeachMeta);
		
		ItemStack foxMccloud = SkullItem.getSkull("http://textures.minecraft.net/texture/71be29750ddec80994bda79653e21ed70d5b2eb793da51d5a87b89bf67dcb96");
		ItemMeta foxMccloudMeta = foxMccloud.getItemMeta();
		foxMccloudMeta.setDisplayName(ChatColor.GOLD + "Fox McCloud");
		foxMccloud.setItemMeta(foxMccloudMeta);
		
		ItemStack bowser = SkullItem.getSkull("http://textures.minecraft.net/texture/e860610ed30785e6229e82e2897b42fdabb1df6296d3731fac2744e56a9eb9");
		ItemMeta bowserMeta = bowser.getItemMeta();
		bowserMeta.setDisplayName(ChatColor.GOLD + "Bowser");
		bowser.setItemMeta(bowserMeta);
		
		ItemStack mario = SkullItem.getSkull("http://textures.minecraft.net/texture/6f7eb75e5542cc4937aaad5bb8657393eaf0265006eac1dc96691f32e16437");
		ItemMeta marioMeta = mario.getItemMeta();
		marioMeta.setDisplayName(ChatColor.GOLD + "Mario");
		mario.setItemMeta(marioMeta);
		
		ItemStack luigi = SkullItem.getSkull("http://textures.minecraft.net/texture/ff1533871e49ddab8f1ca82edb1153a5e2ed3764fd1ce029bf829f4b3caac3");
		ItemMeta luigiMeta = luigi.getItemMeta();
		luigiMeta.setDisplayName(ChatColor.GOLD + "Luigi");
		luigi.setItemMeta(luigiMeta);
		
		ItemStack yoshi = SkullItem.getSkull("http://textures.minecraft.net/texture/671ebc11bdd151410da70d931259c4e969528e6f5889e9c4bb2dd763b9eafd");
		ItemMeta yoshiMeta = yoshi.getItemMeta();
		yoshiMeta.setDisplayName(ChatColor.GOLD + "Yoshi");
		yoshi.setItemMeta(yoshiMeta);
		
		ItemStack ashKetchum = SkullItem.getSkull("http://textures.minecraft.net/texture/dc23586f51fc98b55450bb9a37a066caac2765c1d471cb891094a8ec032befb");
		ItemMeta ashKetchumMeta = ashKetchum.getItemMeta();
		ashKetchumMeta.setDisplayName(ChatColor.GOLD + "Ash Ketchum");
		ashKetchum.setItemMeta(ashKetchumMeta);
		
		ItemStack samus = SkullItem.getSkull("http://textures.minecraft.net/texture/3a8d314cc31ca8adf2ee99be39b32732be6d6be8510ba8ed4af1b8fab2ef0f9");
		ItemMeta samusMeta = samus.getItemMeta();
		samusMeta.setDisplayName(ChatColor.GOLD + "Samus");
		samus.setItemMeta(samusMeta);
		
		ItemStack ganondorf = SkullItem.getSkull("http://textures.minecraft.net/texture/3b785436914d448886f876be0f487cf4c332d696f66570a84e86f8fa67f");
		ItemMeta ganondorfMeta = ganondorf.getItemMeta();
		ganondorfMeta.setDisplayName(ChatColor.GOLD + "Ganondorf");
		ganondorf.setItemMeta(ganondorfMeta);
		
		ItemStack toyBonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/b695b4c797d64e4f492e56b8259c5be6448616b9d59f06c199261da359fa5d");
		ItemMeta toyBonnieMeta = toyBonnie.getItemMeta();
		toyBonnieMeta.setDisplayName(ChatColor.GOLD + "Toy Bonnie");
		toyBonnie.setItemMeta(toyBonnieMeta);
		
		ItemStack toyFreddie = SkullItem.getSkull("http://textures.minecraft.net/texture/445792e943f184878cafc8a271c2cfb3b0f7bb76c2b19a1292b440db367557");
		ItemMeta toyFreddieMeta = toyFreddie.getItemMeta();
		toyFreddieMeta.setDisplayName(ChatColor.GOLD + "Toy Freddie");
		toyFreddie.setItemMeta(toyFreddieMeta);
		
		ItemStack toyChica2 = SkullItem.getSkull("http://textures.minecraft.net/texture/6c46284c4948bfd17c1eb6d96cdfaf4b13080c476811a1ef7b9d75ab3c185d1");
		ItemMeta toyChica2Meta = toyChica2.getItemMeta();
		toyChica2Meta.setDisplayName(ChatColor.GOLD + "Toy Chica");
		toyChica2.setItemMeta(toyChica2Meta);
		
		ItemStack toyMangle = SkullItem.getSkull("http://textures.minecraft.net/texture/fbd284997752a4802b8ceb4b4651338b44b6d477965b737f1985b6faf5e22ab");
		ItemMeta toyMangleMeta = toyMangle.getItemMeta();
		toyMangleMeta.setDisplayName(ChatColor.GOLD + "Toy Mangle");
		toyMangle.setItemMeta(toyMangleMeta);
		
		ItemStack balloonBoy = SkullItem.getSkull("http://textures.minecraft.net/texture/8a48dd4ad18afb22fe572852706b8019a78d8f159486e742ff761c638d202f5b");
		ItemMeta balloonBoyMeta = balloonBoy.getItemMeta();
		balloonBoyMeta.setDisplayName(ChatColor.GOLD + "Balloon Boy Meta");
		balloonBoy.setItemMeta(balloonBoyMeta);
		
		ItemStack vegetta = SkullItem.getSkull("http://textures.minecraft.net/texture/4fc1d88be2528168f67da16a19b14f04e1e4963a99dfcb4e49d984a351313c");
		ItemMeta vegettaMeta = vegetta.getItemMeta();
		vegettaMeta.setDisplayName(ChatColor.GOLD + "Vegetta");
		vegetta.setItemMeta(vegettaMeta);
		
		ItemStack masterchief = SkullItem.getSkull("http://textures.minecraft.net/texture/2548844c48b082df57cb4aadc6b23a4af49e3be028f216c62ef539ab84ccbc0");
		ItemMeta masterchiefMeta = masterchief.getItemMeta();
		masterchiefMeta.setDisplayName(ChatColor.GOLD + "Masterchief");
		masterchief.setItemMeta(masterchiefMeta);
		
		ItemStack bender = SkullItem.getSkull("http://textures.minecraft.net/texture/6e23d607e92e729af9664bfa26be958b4b2f9f3e012eed833f9a35ea4c4b0");
		ItemMeta benderMeta = bender.getItemMeta();
		benderMeta.setDisplayName(ChatColor.GOLD + "Bender");
		bender.setItemMeta(benderMeta);
		
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
		
		inventory.setItem(0, toyChica);
		inventory.setItem(1, zoidberg);
		inventory.setItem(2, ewok);
		inventory.setItem(3, mangle);
		inventory.setItem(4, freddyFazbear);
		inventory.setItem(5, bonnie);
		inventory.setItem(6, chica);
		inventory.setItem(7, foxie);
		inventory.setItem(8, marionette);
		inventory.setItem(9, mangle2);
		inventory.setItem(10, link);
		inventory.setItem(11, stitch);
		inventory.setItem(12, groot);
		inventory.setItem(13, starLord);
		inventory.setItem(14, bobaFett);
		inventory.setItem(15, stormTrooper);
		inventory.setItem(16, cloneTrooper);
		inventory.setItem(17, r2D2);
		inventory.setItem(18, darthVader);
		inventory.setItem(19, patrick);
		inventory.setItem(20, spongebob);
		inventory.setItem(21, iceKing);
		inventory.setItem(22, jake);
		inventory.setItem(23, finn);
		inventory.setItem(24, sonic);
		inventory.setItem(25, metaknight);
		inventory.setItem(26, ness);
		inventory.setItem(27, wario);
		inventory.setItem(28, princessPeach);
		inventory.setItem(29, foxMccloud);
		inventory.setItem(30, bowser);
		inventory.setItem(31, mario);
		inventory.setItem(32, luigi);
		inventory.setItem(33, yoshi);
		inventory.setItem(34, ashKetchum);
		inventory.setItem(35, samus);
		inventory.setItem(36, ganondorf);
		inventory.setItem(37, toyBonnie);
		inventory.setItem(38, toyFreddie);
		inventory.setItem(39, toyChica2);
		inventory.setItem(40, toyMangle);
		inventory.setItem(41, balloonBoy);
		inventory.setItem(42, vegetta);
		inventory.setItem(43, masterchief);
		inventory.setItem(44, bender);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}