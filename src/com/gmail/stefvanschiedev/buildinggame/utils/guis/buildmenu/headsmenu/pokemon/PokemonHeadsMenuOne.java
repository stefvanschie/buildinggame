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

public class PokemonHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Pokemon");
		
		ItemStack magikarp = SkullItem.getSkull("http://textures.minecraft.net/texture/2f58fb7cbf9f8dcfc3bc9d61c7cb5b229bf49db1101336ffdc2d087c0b94162");
		ItemMeta magikarpMeta = magikarp.getItemMeta();
		magikarpMeta.setDisplayName(ChatColor.GOLD + "Magikarp");
		magikarp.setItemMeta(magikarpMeta);
		
		ItemStack squirtle = SkullItem.getSkull("http://textures.minecraft.net/texture/f53ebc976cb6771f3e95117b326842ff7812c740bece96bb8858346d841");
		ItemMeta squirtleMeta = squirtle.getItemMeta();
		squirtleMeta.setDisplayName(ChatColor.GOLD + "Squirtle");
		squirtle.setItemMeta(squirtleMeta);
		
		ItemStack unfezant = SkullItem.getSkull("http://textures.minecraft.net/texture/f1fd1c83af7e7e5221efb1f4149f7d16f5980a251f0a5d71abe36690228a");
		ItemMeta unfezantMeta = unfezant.getItemMeta();
		unfezantMeta.setDisplayName(ChatColor.GOLD + "Unfezant");
		unfezant.setItemMeta(unfezantMeta);
		
		ItemStack hydreigon = SkullItem.getSkull("http://textures.minecraft.net/texture/63975aaad2dbc317e3787bdebab9fb1eb4526b382fccdfeb181339b2154fba3");
		ItemMeta hydreigonMeta = hydreigon.getItemMeta();
		hydreigonMeta.setDisplayName(ChatColor.GOLD + "Hydreigon");
		hydreigon.setItemMeta(hydreigonMeta);
		
		ItemStack elektross = SkullItem.getSkull("http://textures.minecraft.net/texture/fe5ef634c7ee973cb04fe41e1dbb2f062b12c0726143d3bf232b2381f24b");
		ItemMeta elektrossMeta = elektross.getItemMeta();
		elektrossMeta.setDisplayName(ChatColor.GOLD + "Elektross");
		elektross.setItemMeta(elektrossMeta);
		
		ItemStack swanna = SkullItem.getSkull("http://textures.minecraft.net/texture/4c612d54332ecdaa438f21f7afd5443e91355cd1c6844f68a57bec6a93c3fa1");
		ItemMeta swannaMeta = swanna.getItemMeta();
		swannaMeta.setDisplayName(ChatColor.GOLD + "Swanna");
		swanna.setItemMeta(swannaMeta);
		
		ItemStack magmar = SkullItem.getSkull("http://textures.minecraft.net/texture/a644660e54cc1fe315a99b94e199115c54cd77cbf7c6aef2470dbef4f68f327");
		ItemMeta magmarMeta = magmar.getItemMeta();
		magmarMeta.setDisplayName(ChatColor.GOLD + "Magmar");
		magmar.setItemMeta(magmarMeta);
		
		ItemStack liepard = SkullItem.getSkull("http://textures.minecraft.net/texture/ce8524f6ac7624895bca23ae7d6777da5ac1ad0d726bf4e5684ca6fdbc2929b");
		ItemMeta liepardMeta = liepard.getItemMeta();
		liepardMeta.setDisplayName(ChatColor.GOLD + "Liepard");
		liepard.setItemMeta(liepardMeta);
		
		ItemStack lilligant = SkullItem.getSkull("http://textures.minecraft.net/texture/93e1faa993a47bda9bc7de0c693ca6c82726626bd25a7c064d7af779636a");
		ItemMeta lilligantMeta = lilligant.getItemMeta();
		lilligantMeta.setDisplayName(ChatColor.GOLD + "Lilligant");
		lilligant.setItemMeta(lilligantMeta);
		
		ItemStack bisharp = SkullItem.getSkull("http://textures.minecraft.net/texture/a5fe877042de302f88db7de2ac07cecdd3cb8b771d4c055a3723033215d5c");
		ItemMeta bisharpMeta = bisharp.getItemMeta();
		bisharpMeta.setDisplayName(ChatColor.GOLD + "Bisharp");
		bisharp.setItemMeta(bisharpMeta);
		
		ItemStack gyarados = SkullItem.getSkull("http://textures.minecraft.net/texture/1ab93af668cb83e379e9edbcdc4532f1294f90cb13de6a582efab87696c36dd");
		ItemMeta gyaradosMeta = gyarados.getItemMeta();
		gyaradosMeta.setDisplayName(ChatColor.GOLD + "Gyarados");
		gyarados.setItemMeta(gyaradosMeta);
		
		ItemStack beartic = SkullItem.getSkull("http://textures.minecraft.net/texture/7b608ed4523825a61f4baab896e38ebdbb83ee149d440b9a4e12bc9effb4a");
		ItemMeta bearticMeta = beartic.getItemMeta();
		bearticMeta.setDisplayName(ChatColor.GOLD + "Beartic");
		beartic.setItemMeta(bearticMeta);
		
		ItemStack scrafty = SkullItem.getSkull("http://textures.minecraft.net/texture/2e519598c376db51c2ddd3387829d05c3569a0c7f19c501fdc96756761ed1");
		ItemMeta scraftyMeta = scrafty.getItemMeta();
		scraftyMeta.setDisplayName(ChatColor.GOLD + "Scrafty");
		scrafty.setItemMeta(scraftyMeta);
		
		ItemStack darmanitan = SkullItem.getSkull("http://textures.minecraft.net/texture/9ebeffa46355758795a153639fc1411fdfdd91ec13c1266ce6b87585e2fc1");
		ItemMeta darmanitanMeta = darmanitan.getItemMeta();
		darmanitanMeta.setDisplayName(ChatColor.GOLD + "Darmanitan");
		darmanitan.setItemMeta(darmanitanMeta);
		
		ItemStack axew = SkullItem.getSkull("http://textures.minecraft.net/texture/d17cc1cb8492493548c90d714c23e8e71a1fcd0d47a43c11499d2c2bc422");
		ItemMeta axewMeta = axew.getItemMeta();
		axewMeta.setDisplayName(ChatColor.GOLD + "Axew");
		axew.setItemMeta(axewMeta);
		
		ItemStack nurseJoy = SkullItem.getSkull("http://textures.minecraft.net/texture/b3de38a1ceea6d9493df19a8b55bb238711cd5da4f435d2ec026376d874647");
		ItemMeta nurseJoyMeta = nurseJoy.getItemMeta();
		nurseJoyMeta.setDisplayName(ChatColor.GOLD + "Nurse Joy");
		nurseJoy.setItemMeta(nurseJoyMeta);
		
		ItemStack patrat = SkullItem.getSkull("http://textures.minecraft.net/texture/2bfe4a59b164548732fd5b754f266411969a2c2feb08a89b40a1293244abec");
		ItemMeta patratMeta = patrat.getItemMeta();
		patratMeta.setDisplayName(ChatColor.GOLD + "Patrat");
		patrat.setItemMeta(patratMeta);
		
		ItemStack throh = SkullItem.getSkull("http://textures.minecraft.net/texture/59f3acb937eea5ff447e4d45308635f6ac7923b0a504ccd2c8f671853b2edc");
		ItemMeta throhMeta = throh.getItemMeta();
		throhMeta.setDisplayName(ChatColor.GOLD + "Throh");
		throh.setItemMeta(throhMeta);
		
		ItemStack sawk = SkullItem.getSkull("http://textures.minecraft.net/texture/1ef9c1d5f3bb4b19723bdd85f219675da0fc9dec5d8ab2e94a3d9fcab2d576");
		ItemMeta sawkMeta = sawk.getItemMeta();
		sawkMeta.setDisplayName(ChatColor.GOLD + "Sawk");
		sawk.setItemMeta(sawkMeta);
		
		ItemStack zebstrika = SkullItem.getSkull("http://textures.minecraft.net/texture/34e8a47e55294eae66e250274baa15c11554c0624b633cc1d1787875e4b126");
		ItemMeta zebstrikaMeta = zebstrika.getItemMeta();
		zebstrikaMeta.setDisplayName(ChatColor.GOLD + "Zebstrika");
		zebstrika.setItemMeta(zebstrikaMeta);
		
		ItemStack charmeleon = SkullItem.getSkull("http://textures.minecraft.net/texture/d31711f33665b3e1e99ed8f5f50a63e3f6dec721af2391e34f83e15ce27af");
		ItemMeta charmeleonMeta = charmeleon.getItemMeta();
		charmeleonMeta.setDisplayName(ChatColor.GOLD + "Charmeleon");
		charmeleon.setItemMeta(charmeleonMeta);
		
		ItemStack sylveon = SkullItem.getSkull("http://textures.minecraft.net/texture/d77a122e66286be8504e72979b47912bbe69136c2eac61baa2b7631d7e926b");
		ItemMeta sylveonMeta = sylveon.getItemMeta();
		sylveonMeta.setDisplayName(ChatColor.GOLD + "Sylveon");
		sylveon.setItemMeta(sylveonMeta);
		
		ItemStack leafeon = SkullItem.getSkull("http://textures.minecraft.net/texture/b79daa21f9eeeb6dc7f656b055d6ac3090b3c586cbe411b91fb9829850da7c85");
		ItemMeta leafeonMeta = leafeon.getItemMeta();
		leafeonMeta.setDisplayName(ChatColor.GOLD + "Leafeon");
		leafeon.setItemMeta(leafeonMeta);
		
		ItemStack glaceon = SkullItem.getSkull("http://textures.minecraft.net/texture/ddc53b753dee1af91819cf299bb44ee96829361149a887b01ad9741cc78b3e");
		ItemMeta glaceonMeta = glaceon.getItemMeta();
		glaceonMeta.setDisplayName(ChatColor.GOLD + "Glaceon");
		glaceon.setItemMeta(glaceonMeta);
		
		ItemStack umbreon = SkullItem.getSkull("http://textures.minecraft.net/texture/25a8f67722bef093c67cce14587d67b375e27a82fa777a88218ba11af9c13b");
		ItemMeta umbreonMeta = umbreon.getItemMeta();
		umbreonMeta.setDisplayName(ChatColor.GOLD + "Umbreon");
		umbreon.setItemMeta(umbreonMeta);
		
		ItemStack espeon = SkullItem.getSkull("http://textures.minecraft.net/texture/4cc375102ba41916297d72452cc482c75285b98e43db67ee5f4992aea043e2b1");
		ItemMeta espeonMeta = espeon.getItemMeta();
		espeonMeta.setDisplayName(ChatColor.GOLD + "Espeon");
		espeon.setItemMeta(espeonMeta);
		
		ItemStack flareon = SkullItem.getSkull("http://textures.minecraft.net/texture/5365872ebea5ea9d18049ab1cdb8f586f429e784610a37fbfb66b6dc6372");
		ItemMeta flareonMeta = flareon.getItemMeta();
		flareonMeta.setDisplayName(ChatColor.GOLD + "Flareon");
		flareon.setItemMeta(flareonMeta);
		
		ItemStack vlaporeon = SkullItem.getSkull("http://textures.minecraft.net/texture/61b79ee6b61c11e6a129b19c77bd307a482fec5ab363c66ab1f1e4265d32759");
		ItemMeta vlaporeonMeta = vlaporeon.getItemMeta();
		vlaporeonMeta.setDisplayName(ChatColor.GOLD + "Vlaporeon");
		vlaporeon.setItemMeta(vlaporeonMeta);
		
		ItemStack jolteon = SkullItem.getSkull("http://textures.minecraft.net/texture/80d8c4853326f035b0105ed69801a909ca0b72e081fac0477c1fe5477024a5");
		ItemMeta jolteonMeta = jolteon.getItemMeta();
		jolteonMeta.setDisplayName(ChatColor.GOLD + "Jolteon");
		jolteon.setItemMeta(jolteonMeta);
		
		ItemStack pikachu = SkullItem.getSkull("http://textures.minecraft.net/texture/dfa695b59618b3616b6aaa910c5a10146195edd6367d25e9399a74ceef966");
		ItemMeta pikachuMeta = pikachu.getItemMeta();
		pikachuMeta.setDisplayName(ChatColor.GOLD + "Pikachu");
		pikachu.setItemMeta(pikachuMeta);
		
		ItemStack cobalion = SkullItem.getSkull("http://textures.minecraft.net/texture/11c536c8fba596ae97ea50d683f1ebb895ddf662adceda91690bc597d3843");
		ItemMeta cobalionMeta = cobalion.getItemMeta();
		cobalionMeta.setDisplayName(ChatColor.GOLD + "Cobalion");
		cobalion.setItemMeta(cobalionMeta);
		
		ItemStack caterpie = SkullItem.getSkull("http://textures.minecraft.net/texture/8aa253fadd897a6a19aad3959c44fb4ceac5a8ca588f10e52ec8cfbb4144c6d");
		ItemMeta caterpieMeta = caterpie.getItemMeta();
		caterpieMeta.setDisplayName(ChatColor.GOLD + "Caterpie");
		caterpie.setItemMeta(caterpieMeta);
		
		ItemStack ash = SkullItem.getSkull("http://textures.minecraft.net/texture/a69ab8b0f19a1c99fe3ad86ea1a2ea2beeefba8e1b9343308743b7bcbd8");
		ItemMeta ashMeta = ash.getItemMeta();
		ashMeta.setDisplayName(ChatColor.GOLD + "Ash");
		ash.setItemMeta(ashMeta);
		
		ItemStack xerneas = SkullItem.getSkull("http://textures.minecraft.net/texture/73123f5959ce8d8210f672aa5491b6b50b97f27e3a846d55d352bc2f4c9eb");
		ItemMeta xerneasMeta = xerneas.getItemMeta();
		xerneasMeta.setDisplayName(ChatColor.GOLD + "Xerneas");
		xerneas.setItemMeta(xerneasMeta);
		
		ItemStack delphox = SkullItem.getSkull("http://textures.minecraft.net/texture/cb55c64b555c7f8654c55c7793a7e39abf5ee4d8cb7af98a8f197daafb6a0da");
		ItemMeta delphoxMeta = delphox.getItemMeta();
		delphoxMeta.setDisplayName(ChatColor.GOLD + "Delphox");
		delphox.setItemMeta(delphoxMeta);
		
		ItemStack chesnaught = SkullItem.getSkull("http://textures.minecraft.net/texture/4f86aec23f3a84782ade3e53baf7b8bf2b3a5113e24872ce2ddbf311f98d612d");
		ItemMeta chesnaughtMeta = chesnaught.getItemMeta();
		chesnaughtMeta.setDisplayName(ChatColor.GOLD + "Chesnaught");
		chesnaught.setItemMeta(chesnaughtMeta);
		
		ItemStack keldeo = SkullItem.getSkull("http://textures.minecraft.net/texture/c74eb1d592d62e92c1e6b77742810e32fd450f79bef9a9ef9d564f3ccb2990");
		ItemMeta keldeoMeta = keldeo.getItemMeta();
		keldeoMeta.setDisplayName(ChatColor.GOLD + "Keldeo");
		keldeo.setItemMeta(keldeoMeta);
		
		ItemStack kyurem = SkullItem.getSkull("http://textures.minecraft.net/texture/6b9f825dd7c9d58ac220bc94282517ce39ea9050e17a83e492d3aa1fb98edd81");
		ItemMeta kyuremMeta = kyurem.getItemMeta();
		kyuremMeta.setDisplayName(ChatColor.GOLD + "Kyurem");
		kyurem.setItemMeta(kyuremMeta);
		
		ItemStack zekrom = SkullItem.getSkull("http://textures.minecraft.net/texture/8fe7e1346aff253216ee0ce144f6c3d664d0d1dc6d9f6db47183cc679ce043");
		ItemMeta zekromMeta = zekrom.getItemMeta();
		zekromMeta.setDisplayName(ChatColor.GOLD + "Zekrom");
		zekrom.setItemMeta(zekromMeta);
		
		ItemStack reshiram = SkullItem.getSkull("http://textures.minecraft.net/texture/1ff33de8876e3cdd89ae81835f3affc946bc498393c3644cfa04b6a6c89d2fd");
		ItemMeta reshiramMeta = reshiram.getItemMeta();
		reshiramMeta.setDisplayName(ChatColor.GOLD + "Reshiram");
		reshiram.setItemMeta(reshiramMeta);
		
		ItemStack scraggy = SkullItem.getSkull("http://textures.minecraft.net/texture/31be34e1e5421845c4c97cb9a9ef89f2fdccc92b1e2d4d9abb132339e90");
		ItemMeta scraggyMeta = scraggy.getItemMeta();
		scraggyMeta.setDisplayName(ChatColor.GOLD + "Scraggy");
		scraggy.setItemMeta(scraggyMeta);
		
		ItemStack samurott = SkullItem.getSkull("http://textures.minecraft.net/texture/c768bd25a2391ba9d27ff6e66efc8e346d1764b85b47b3c81e74481ece22ff");
		ItemMeta samurottMeta = samurott.getItemMeta();
		samurottMeta.setDisplayName(ChatColor.GOLD + "Samurott");
		samurott.setItemMeta(samurottMeta);
		
		ItemStack emboar = SkullItem.getSkull("http://textures.minecraft.net/texture/771aa5f0114439d918f9eb2ea783d3a96f79192767d055fcca31eb6fb5114af2");
		ItemMeta emboarMeta = emboar.getItemMeta();
		emboarMeta.setDisplayName(ChatColor.GOLD + "Emboar");
		emboar.setItemMeta(emboarMeta);
		
		ItemStack serperior = SkullItem.getSkull("http://textures.minecraft.net/texture/1d579c315f16dcc9b49d27ba1d6a0f3373dea9deebda43610c1a713ec884cd");
		ItemMeta serperiorMeta = serperior.getItemMeta();
		serperiorMeta.setDisplayName(ChatColor.GOLD + "Serperior");
		serperior.setItemMeta(serperiorMeta);
		
		ItemStack victini = SkullItem.getSkull("http://textures.minecraft.net/texture/1414854c864f7cb1b4b52509a2f42e93b2cadaedd289fb21ddeace6d877d59");
		ItemMeta victiniMeta = victini.getItemMeta();
		victiniMeta.setDisplayName(ChatColor.GOLD + "Vicitini");
		victini.setItemMeta(victiniMeta);
		
		ItemStack shaymin = SkullItem.getSkull("http://textures.minecraft.net/texture/bf58bf9f81637d364eae71037aa0a5c4c3a46b21697a6bdd1d1f653f5a");
		ItemMeta shayminMeta = shaymin.getItemMeta();
		shayminMeta.setDisplayName(ChatColor.GOLD + "Shaymin");
		shaymin.setItemMeta(shayminMeta);
		
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
		
		inventory.setItem(0, magikarp);
		inventory.setItem(1, squirtle);
		inventory.setItem(2, unfezant);
		inventory.setItem(3, hydreigon);
		inventory.setItem(4, elektross);
		inventory.setItem(5, swanna);
		inventory.setItem(6, magmar);
		inventory.setItem(7, liepard);
		inventory.setItem(8, lilligant);
		inventory.setItem(9, bisharp);
		inventory.setItem(10, gyarados);
		inventory.setItem(11, beartic);
		inventory.setItem(12, scrafty);
		inventory.setItem(13, darmanitan);
		inventory.setItem(14, axew);
		inventory.setItem(15, nurseJoy);
		inventory.setItem(16, patrat);
		inventory.setItem(17, throh);
		inventory.setItem(18, sawk);
		inventory.setItem(19, zebstrika);
		inventory.setItem(20, charmeleon);
		inventory.setItem(21, sylveon);
		inventory.setItem(22, leafeon);
		inventory.setItem(22, glaceon);
		inventory.setItem(23, umbreon);
		inventory.setItem(24, espeon);
		inventory.setItem(25, flareon);
		inventory.setItem(26, vlaporeon);
		inventory.setItem(27, jolteon);
		inventory.setItem(28, pikachu);
		inventory.setItem(29, cobalion);
		inventory.setItem(30, caterpie);
		inventory.setItem(31, ash);
		inventory.setItem(32, xerneas);
		inventory.setItem(33, delphox);
		inventory.setItem(34, chesnaught);
		inventory.setItem(35, keldeo);
		inventory.setItem(36, kyurem);
		inventory.setItem(37, zekrom);
		inventory.setItem(38, reshiram);
		inventory.setItem(39, scraggy);
		inventory.setItem(40, samurott);
		inventory.setItem(41, emboar);
		inventory.setItem(42, serperior);
		inventory.setItem(43, victini);
		inventory.setItem(44, shaymin);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}