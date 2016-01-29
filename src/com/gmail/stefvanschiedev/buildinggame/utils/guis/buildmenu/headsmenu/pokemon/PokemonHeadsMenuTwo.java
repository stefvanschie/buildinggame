package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.pokemon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class PokemonHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Pokemon");
	
		ItemStack darkrai = SkullItem.getSkull("http://textures.minecraft.net/texture/d4ee7ed3f6eddc1017ab8cb5583e17fb7279d656a9da0c2838db36d217d39");
		ItemMeta darkraiMeta = darkrai.getItemMeta();
		darkraiMeta.setDisplayName(ChatColor.GOLD + "Darkrai");
		darkrai.setItemMeta(darkraiMeta);
		
		ItemStack giratina = SkullItem.getSkull("http://textures.minecraft.net/texture/416e2950e78ac0d1b19abac9d66bd4deb0dc59ac444f1841e8a7de8316eaab24");
		ItemMeta giratinaMeta = giratina.getItemMeta();
		giratinaMeta.setDisplayName(ChatColor.GOLD + "Giratina");
		giratina.setItemMeta(giratinaMeta);
		
		ItemStack palkia = SkullItem.getSkull("http://textures.minecraft.net/texture/5ca89418ecef16f5e489bb2874bfb2b0b31184c4144b3e78e534edba35689211");
		ItemMeta palkiaMeta = palkia.getItemMeta();
		palkiaMeta.setDisplayName(ChatColor.GOLD + "Palkia");
		palkia.setItemMeta(palkiaMeta);
		
		ItemStack dialga = SkullItem.getSkull("http://textures.minecraft.net/texture/9aaed84ea4c3e06aba392a351555e4e94297166baeed514c927918e564e65834");
		ItemMeta dialgaMeta = dialga.getItemMeta();
		dialgaMeta.setDisplayName(ChatColor.GOLD + "Dialga");
		dialga.setItemMeta(dialgaMeta);
		
		ItemStack empoleon = SkullItem.getSkull("http://textures.minecraft.net/texture/42621d766c4e69f85928be4ceda0b996e95f5a20fe96232bd02ed42750d");
		ItemMeta empoleonMeta = empoleon.getItemMeta();
		empoleonMeta.setDisplayName(ChatColor.GOLD + "Empoleon");
		empoleon.setItemMeta(empoleonMeta);
		
		ItemStack piplup = SkullItem.getSkull("http://textures.minecraft.net/texture/fa3ce7cae835b9d677a6753e25c688966ab670219b6a57888d2ef7d2833ddb68");
		ItemMeta piplupMeta = piplup.getItemMeta();
		piplupMeta.setDisplayName(ChatColor.GOLD + "Piplup");
		piplup.setItemMeta(piplupMeta);
		
		ItemStack infernape = SkullItem.getSkull("http://textures.minecraft.net/texture/20dc8af9cc68ff1f2d7b4c680751f20ddcc20f1663ecc902b5d2b4f7b74d1f6");
		ItemMeta infernapeMeta = infernape.getItemMeta();
		infernapeMeta.setDisplayName(ChatColor.GOLD + "Infernape");
		infernape.setItemMeta(infernapeMeta);
		
		ItemStack torterra = SkullItem.getSkull("http://textures.minecraft.net/texture/bdc571a5e8285dc8f2fb61c918fa479e2779c86d16c982519dd751cce50");
		ItemMeta torterraMeta = torterra.getItemMeta();
		torterraMeta.setDisplayName(ChatColor.GOLD + "Torterra");
		torterra.setItemMeta(torterraMeta);
		
		ItemStack deoxys = SkullItem.getSkull("http://textures.minecraft.net/texture/d59b284b39737d324935728a771ed1edbbbe34a298af6fc17bf07c2735f48");
		ItemMeta deoxysMeta = deoxys.getItemMeta();
		deoxysMeta.setDisplayName(ChatColor.GOLD + "Deoxys");
		deoxys.setItemMeta(deoxysMeta);
		
		ItemStack rayquaza = SkullItem.getSkull("http://textures.minecraft.net/texture/3a3eb5977d7d2df7cf06be17e1f6d0eed5bbc5ba34338cf2bbb8984a5d5ab");
		ItemMeta rayquazaMeta = rayquaza.getItemMeta();
		rayquazaMeta.setDisplayName(ChatColor.GOLD + "Rayquaza");
		rayquaza.setItemMeta(rayquazaMeta);
		
		ItemStack groudon = SkullItem.getSkull("http://textures.minecraft.net/texture/b8465e86ffdab8ebf7b8cd3aff5d44f3a3c9be188ee7166eb540dc68f19bb8");
		ItemMeta groudonMeta = groudon.getItemMeta();
		groudonMeta.setDisplayName(ChatColor.GOLD + "Groudon");
		groudon.setItemMeta(groudonMeta);
		
		ItemStack kyogre = SkullItem.getSkull("http://textures.minecraft.net/texture/bae97e627caf313cd9bf8dded41753e22a7f4381d13e3e622a16c0a04785636c");
		ItemMeta kyogreMeta = kyogre.getItemMeta();
		kyogreMeta.setDisplayName(ChatColor.GOLD + "Kyogre");
		kyogre.setItemMeta(kyogreMeta);
		
		ItemStack latios = SkullItem.getSkull("http://textures.minecraft.net/texture/517f45947c9b2753e593456b87c8cfdadb08c7b9a67c7535d9d3794ca6e36a");
		ItemMeta latiosMeta = latios.getItemMeta();
		latiosMeta.setDisplayName(ChatColor.GOLD + "Latios");
		latios.setItemMeta(latiosMeta);
		
		ItemStack latias = SkullItem.getSkull("http://textures.minecraft.net/texture/3a738cf54ecba8abfe8fdbb2540779889122ea1a71f6c70d42ed4e18eed4ba");
		ItemMeta latiasMeta = latias.getItemMeta();
		latiasMeta.setDisplayName(ChatColor.GOLD + "Latias");
		latias.setItemMeta(latiasMeta);
		
		ItemStack salamence = SkullItem.getSkull("http://textures.minecraft.net/texture/ee648a6e69887d328188270f665525ba399e34487571589b8f3f5696418efc");
		ItemMeta salamenceMeta = salamence.getItemMeta();
		salamenceMeta.setDisplayName(ChatColor.GOLD + "Salamence");
		salamence.setItemMeta(salamenceMeta);
		
		ItemStack blaziken = SkullItem.getSkull("http://textures.minecraft.net/texture/4edc5ac9c9447e3a7a926fbc54dcf66d5e373b4921083a1fff0742395c92c");
		ItemMeta blazikenMeta = blaziken.getItemMeta();
		blazikenMeta.setDisplayName(ChatColor.GOLD + "Blaziken");
		blaziken.setItemMeta(blazikenMeta);
		
		ItemStack sceptile = SkullItem.getSkull("http://textures.minecraft.net/texture/9f8b6acfc8c718b775769476b38f2c3c072dd30ed2a35a280c0d3d8f3c4e18");
		ItemMeta sceptileMeta = sceptile.getItemMeta();
		sceptileMeta.setDisplayName(ChatColor.GOLD + "Sceptile");
		sceptile.setItemMeta(sceptileMeta);
		
		ItemStack hoOh = SkullItem.getSkull("http://textures.minecraft.net/texture/eebfbfe7a4fccbf566c9cf49de56e784bf6421c86a3524aaf54b6568942d");
		ItemMeta hoOhMeta = hoOh.getItemMeta();
		hoOhMeta.setDisplayName(ChatColor.GOLD + "Ho-Oh");
		hoOh.setItemMeta(hoOhMeta);
		
		ItemStack lugia = SkullItem.getSkull("http://textures.minecraft.net/texture/669f4acbdcf32593a0a9c97efbddc01fba1a31a41beb9db13555139386fb337");
		ItemMeta lugiaMeta = lugia.getItemMeta();
		lugiaMeta.setDisplayName(ChatColor.GOLD + "Lugia");
		lugia.setItemMeta(lugiaMeta);
		
		ItemStack suicune = SkullItem.getSkull("http://textures.minecraft.net/texture/222bc95af0557a5940462025f253e9494cfcc56c5ff405e18805d133a87efd2");
		ItemMeta suicuneMeta = suicune.getItemMeta();
		suicuneMeta.setDisplayName(ChatColor.GOLD + "Suicune");
		suicune.setItemMeta(suicuneMeta);
		
		ItemStack entei = SkullItem.getSkull("http://textures.minecraft.net/texture/da4aee3f52e827185b9b982f5fa654fcbdda3657261ce7b5314c1b2576a8a85");
		ItemMeta enteiMeta = entei.getItemMeta();
		enteiMeta.setDisplayName(ChatColor.GOLD + "Entei");
		entei.setItemMeta(enteiMeta);
		
		ItemStack raikou = SkullItem.getSkull("http://textures.minecraft.net/texture/b59c811c34d3cee4d5138317f753ce2e8dd1b7bade88bcdbbb5d74f5a21a828d");
		ItemMeta raikouMeta = raikou.getItemMeta();
		raikouMeta.setDisplayName(ChatColor.GOLD + "Raikou");
		raikou.setItemMeta(raikouMeta);
		
		ItemStack typhlosion = SkullItem.getSkull("http://textures.minecraft.net/texture/cfe14acce9069f65edb34e3ad32f4d338116f71ea7a841e6c5643628c39f1b7");
		ItemMeta typhlosionMeta = typhlosion.getItemMeta();
		typhlosionMeta.setDisplayName(ChatColor.GOLD + "Typhlosion");
		typhlosion.setItemMeta(typhlosionMeta);
		
		ItemStack meganium = SkullItem.getSkull("http://textures.minecraft.net/texture/bab68f63c55ad3aeb16167a2f98894c15eb8eaf2c35a93bec4a773d64ca9baf");
		ItemMeta meganiumMeta = meganium.getItemMeta();
		meganiumMeta.setDisplayName(ChatColor.GOLD + "Meganium");
		meganium.setItemMeta(meganiumMeta);
		
		ItemStack mewtwo = SkullItem.getSkull("http://textures.minecraft.net/texture/5d2c4b481f327f44022bab393a418874b3f45acfc3bdf0609a889444b346");
		ItemMeta mewtwoMeta = mewtwo.getItemMeta();
		mewtwoMeta.setDisplayName(ChatColor.GOLD + "Mewtwo");
		mewtwo.setItemMeta(mewtwoMeta);
		
		ItemStack dragonite = SkullItem.getSkull("http://textures.minecraft.net/texture/b15164dcedf88eb266c675bfd75c567c37b36b27e06469f3a44ce2697ed154");
		ItemMeta dragoniteMeta = dragonite.getItemMeta();
		dragoniteMeta.setDisplayName(ChatColor.GOLD + "Dragonite");
		dragonite.setItemMeta(dragoniteMeta);
		
		ItemStack blastoise = SkullItem.getSkull("http://textures.minecraft.net/texture/41df2bb91f4390aacfa2c3aabfe3de0269f4eb8b8f2dfdba2efa8cafc93ddd");
		ItemMeta blastoiseMeta = blastoise.getItemMeta();
		blastoiseMeta.setDisplayName(ChatColor.GOLD + "Blastoise");
		blastoise.setItemMeta(blastoiseMeta);
		
		ItemStack venusaur = SkullItem.getSkull("http://textures.minecraft.net/texture/27331c53145c6b1766c5e4ad7d9824b28fa8fee277533c8f451f9c5070228a42");
		ItemMeta venusaurMeta = venusaur.getItemMeta();
		venusaurMeta.setDisplayName(ChatColor.GOLD + "Venusaur");
		venusaur.setItemMeta(venusaurMeta);
		
		ItemStack charizard = SkullItem.getSkull("http://textures.minecraft.net/texture/8937fba0b1e9885fb4a84c9150513dee8b217cd04f140d2505cab8ae39b5d4");
		ItemMeta charizardMeta = charizard.getItemMeta();
		charizardMeta.setDisplayName(ChatColor.GOLD + "Charizard");
		charizard.setItemMeta(charizardMeta);
		
		ItemStack lucario = SkullItem.getSkull("http://textures.minecraft.net/texture/b9d8366592d9e2ba84cf52102f72397f7ccd286bac62133c0a71091febe");
		ItemMeta lucarioMeta = lucario.getItemMeta();
		lucarioMeta.setDisplayName(ChatColor.GOLD + "Lucario");
		lucario.setItemMeta(lucarioMeta);
		
		ItemStack feraligatr = SkullItem.getSkull("http://textures.minecraft.net/texture/ef919e7a55f95c27cf995b7a5a3cdec22ab997f8dffd4141ea08df66c60cd5d");
		ItemMeta feraligatrMeta = feraligatr.getItemMeta();
		feraligatrMeta.setDisplayName(ChatColor.GOLD + "Feraligatr");
		feraligatr.setItemMeta(feraligatrMeta);
		
		ItemStack pidgeot = SkullItem.getSkull("http://textures.minecraft.net/texture/26c96aef6558f29b247bc8e38d93206143f1314475c5fcd11e2efcc5db55e85");
		ItemMeta pidgeotMeta = pidgeot.getItemMeta();
		pidgeotMeta.setDisplayName(ChatColor.GOLD + "Pidgeot");
		pidgeot.setItemMeta(pidgeotMeta);
		
		ItemStack pidgey = SkullItem.getSkull("http://textures.minecraft.net/texture/016f595e8f6791bc154659a8976f6a8ffd9847cf75a2bf63992e3a655e0");
		ItemMeta pidgeyMeta = pidgey.getItemMeta();
		pidgeyMeta.setDisplayName(ChatColor.GOLD + "Pidgey");
		pidgey.setItemMeta(pidgeyMeta);
		
		ItemStack metapod = SkullItem.getSkull("http://textures.minecraft.net/texture/a1eee2ace8b4a89572bd1a57d47fc1927b89abd60cc79cb8c77faa7458144e");
		ItemMeta metapodMeta = metapod.getItemMeta();
		metapodMeta.setDisplayName(ChatColor.GOLD + "Metapod");
		metapod.setItemMeta(metapodMeta);
		
		ItemStack butterfree = SkullItem.getSkull("http://textures.minecraft.net/texture/5e2a53c27f72ff84795245bad23298d8a59a0613defbed626353fc66a95b");
		ItemMeta butterfreeMeta = butterfree.getItemMeta();
		butterfreeMeta.setDisplayName(ChatColor.GOLD + "Butterfree");
		butterfree.setItemMeta(butterfreeMeta);
		
		ItemStack wartortle = SkullItem.getSkull("http://textures.minecraft.net/texture/47a0fd16ebfdbc51f9398e33835cee0c664a08142ee79f8ffc57d6b7eb518ef");
		ItemMeta wartortleMeta = wartortle.getItemMeta();
		wartortleMeta.setDisplayName(ChatColor.GOLD + "Wartortle");
		wartortle.setItemMeta(wartortleMeta);
		
		ItemStack bulbasaur = SkullItem.getSkull("http://textures.minecraft.net/texture/13e86a8a4231d1cee83714eb5e939c6d3078ea6832bf93eba66d12dc25ea95a");
		ItemMeta bulbasaurMeta = bulbasaur.getItemMeta();
		bulbasaurMeta.setDisplayName(ChatColor.GOLD + "Bulbasaur");
		bulbasaur.setItemMeta(bulbasaurMeta);
		
		ItemStack ivysaur = SkullItem.getSkull("http://textures.minecraft.net/texture/c99ec943b48c6f82f32acd9e8626546de8416cce4da41cbaa02c69feefbea");
		ItemMeta ivysaurMeta = ivysaur.getItemMeta();
		ivysaurMeta.setDisplayName(ChatColor.GOLD + "Ivysaur");
		ivysaur.setItemMeta(ivysaurMeta);
		
		ItemStack swampert = SkullItem.getSkull("http://textures.minecraft.net/texture/b7fbd3667d3258c3c2a291497f427ab2b3ceaa5df0eff62edc3219dcd71570");
		ItemMeta swampertMeta = swampert.getItemMeta();
		swampertMeta.setDisplayName(ChatColor.GOLD + "Swampert");
		swampert.setItemMeta(swampertMeta);
		
		ItemStack growlithe = SkullItem.getSkull("http://textures.minecraft.net/texture/815213d385268ad3bd179e613f1fac99fa8392831fc9f6f10db599cf59ceffb");
		ItemMeta growlitheMeta = growlithe.getItemMeta();
		growlitheMeta.setDisplayName(ChatColor.GOLD + "Growlithe");
		growlithe.setItemMeta(growlitheMeta);
		
		ItemStack greninja = SkullItem.getSkull("http://textures.minecraft.net/texture/492fd264cfc02f58cca7adf0fa698aaf8ef2339b2ee497c3bcff74eb9aeba912");
		ItemMeta greninjaMeta = greninja.getItemMeta();
		greninjaMeta.setDisplayName(ChatColor.GOLD + "Greninja");
		greninja.setItemMeta(greninjaMeta);
		
		ItemStack charmander = SkullItem.getSkull("http://textures.minecraft.net/texture/538992fa71d5d98789d5061ddd68e2b7af9efc253b39e1b346343d7789f8dc");
		ItemMeta charmanderMeta = charmander.getItemMeta();
		charmanderMeta.setDisplayName(ChatColor.GOLD + "Charmander");
		charmander.setItemMeta(charmanderMeta);
		
		ItemStack chespin = SkullItem.getSkull("http://textures.minecraft.net/texture/c56adf85cd8b886ec75b72d7612e5b6d2fd7d52e657316cb66f6d9d6826935a2");
		ItemMeta chespinMeta = chespin.getItemMeta();
		chespinMeta.setDisplayName(ChatColor.GOLD + "Chespin");
		chespin.setItemMeta(chespinMeta);
		
		ItemStack terrakion = SkullItem.getSkull("http://textures.minecraft.net/texture/6dfb5e6f8c8267679b78280d5a10cd4122e50a97be29fa0f4f1c61ffd3fda");
		ItemMeta terrakionMeta = terrakion.getItemMeta();
		terrakionMeta.setDisplayName(ChatColor.GOLD + "Terrakion");
		terrakion.setItemMeta(terrakionMeta);
		
		ItemStack virizion = SkullItem.getSkull("http://textures.minecraft.net/texture/edbf3a8ee9918e9c1c079ad6963e84ae82427cf4ea20fdc62aa1d640ceba");
		ItemMeta virizionMeta = virizion.getItemMeta();
		virizionMeta.setDisplayName(ChatColor.GOLD + "Virizion");
		virizion.setItemMeta(virizionMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(ChatColor.GREEN + "Previous Page");
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
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
		nextNbt.setInteger("page", 3);
		next = nextNbt.getItem();
		
		inventory.setItem(0, darkrai);
		inventory.setItem(1, giratina);
		inventory.setItem(2, palkia);
		inventory.setItem(3, dialga);
		inventory.setItem(4, empoleon);
		inventory.setItem(5, piplup);
		inventory.setItem(6, infernape);
		inventory.setItem(7, torterra);
		inventory.setItem(8, deoxys);
		inventory.setItem(9, rayquaza);
		inventory.setItem(10, groudon);
		inventory.setItem(11, kyogre);
		inventory.setItem(12, latios);
		inventory.setItem(13, latias);
		inventory.setItem(14, salamence);
		inventory.setItem(15, blaziken);
		inventory.setItem(16, sceptile);
		inventory.setItem(17, hoOh);
		inventory.setItem(18, lugia);
		inventory.setItem(19, suicune);
		inventory.setItem(20, entei);
		inventory.setItem(21, raikou);
		inventory.setItem(22, typhlosion);
		inventory.setItem(23, meganium);
		inventory.setItem(24, mewtwo);
		inventory.setItem(25, dragonite);
		inventory.setItem(26, blastoise);
		inventory.setItem(27, venusaur);
		inventory.setItem(28, charizard);
		inventory.setItem(29, lucario);
		inventory.setItem(30, feraligatr);
		inventory.setItem(31, pidgeot);
		inventory.setItem(32, pidgey);
		inventory.setItem(33, metapod);
		inventory.setItem(34, butterfree);
		inventory.setItem(35, wartortle);
		inventory.setItem(36, bulbasaur);
		inventory.setItem(37, ivysaur);
		inventory.setItem(38, swampert);
		inventory.setItem(39, growlithe);
		inventory.setItem(40, greninja);
		inventory.setItem(41, charmander);
		inventory.setItem(42, chespin);
		inventory.setItem(43, terrakion);
		inventory.setItem(44, virizion);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}