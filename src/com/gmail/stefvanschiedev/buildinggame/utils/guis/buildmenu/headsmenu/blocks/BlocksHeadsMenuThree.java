package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.blocks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class BlocksHeadsMenuThree {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Blocks");
		
		ItemStack crackedStoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/39a46b2ab32f216e2d922c7237ba2319f91b71fa24fe451ad2ca81423ea3c8");
		ItemMeta crackedStoneBrickMeta = crackedStoneBrick.getItemMeta();
		crackedStoneBrickMeta.setDisplayName(ChatColor.GOLD + "Cracked Stone Brick");
		crackedStoneBrick.setItemMeta(crackedStoneBrickMeta);
		
		ItemStack mossyStoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/7237333339cbc6b469452c96211fa23e1951e8795076f9eed96a13824a879");
		ItemMeta mossyStoneBrickMeta = mossyStoneBrick.getItemMeta();
		mossyStoneBrickMeta.setDisplayName(ChatColor.GOLD + "Mossy Stone Brick");
		mossyStoneBrick.setItemMeta(mossyStoneBrickMeta);
		
		ItemStack stoneSlab = SkullItem.getSkull("http://textures.minecraft.net/texture/8dd0cd158c2bb6618650e3954b2d29237f5b4c0ddc7d258e17380ab6979f071");
		ItemMeta stoneSlabMeta = stoneSlab.getItemMeta();
		stoneSlabMeta.setDisplayName(ChatColor.GOLD + "Stone Slab");
		stoneSlab.setItemMeta(stoneSlabMeta);
		
		ItemStack snowBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/5dd6fe267a418dcc7f37a8f76855b5328b1303897b342a107cf162f14fe3d");
		ItemMeta snowBlockMeta = snowBlock.getItemMeta();
		snowBlockMeta.setDisplayName(ChatColor.GOLD + "Snow Block");
		snowBlock.setItemMeta(snowBlockMeta);
		
		ItemStack slimeBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/90e65e6e5113a5187dad46dfad3d3bf85e8ef807f82aac228a59c4a95d6f6a");
		ItemMeta slimeBlockMeta = slimeBlock.getItemMeta();
		slimeBlockMeta.setDisplayName(ChatColor.GOLD + "Slime Block");
		slimeBlock.setItemMeta(slimeBlockMeta);
		
		ItemStack obsidian = SkullItem.getSkull("http://textures.minecraft.net/texture/7840b87d52271d2a755dedc82877e0ed3df67dcc42ea479ec146176b02779a5");
		ItemMeta obsidianMeta = obsidian.getItemMeta();
		obsidianMeta.setDisplayName(ChatColor.GOLD + "Obsidian");
		obsidian.setItemMeta(obsidianMeta);
		
		ItemStack smoothRedSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/a2da7aa1ae6cc9d6c36c18a460d2398162edc2207fdfc9e28a7bf84d7441b8a2");
		ItemMeta smoothRedSandstoneMeta = smoothRedSandstone.getItemMeta();
		smoothRedSandstoneMeta.setDisplayName(ChatColor.GOLD + "Smooth Red Sandstone");
		smoothRedSandstone.setItemMeta(smoothRedSandstoneMeta);
		
		ItemStack redSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/db31be197ac7d78b30c34dac2665dbf1a74f96a79e52cb8ed5088ad70ee9348");
		ItemMeta redSandstoneMeta = redSandstone.getItemMeta();
		redSandstoneMeta.setDisplayName(ChatColor.GOLD + "Red Standstone");
		redSandstone.setItemMeta(redSandstoneMeta);
		
		ItemStack noteBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/4ceeb77d4d25724a9caf2c7cdf2d88399b1417c6b9ff5213659b653be4376e3");
		ItemMeta noteBlockMeta = noteBlock.getItemMeta();
		noteBlockMeta.setDisplayName(ChatColor.GOLD + "Note Block");
		noteBlock.setItemMeta(noteBlockMeta);
		
		ItemStack packedIceBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/56aab58fa01fce9af469ed747aed811d7ba18c476f5a7f9088e129c31b45f3");
		ItemMeta packedIceBlockMeta = packedIceBlock.getItemMeta();
		packedIceBlockMeta.setDisplayName(ChatColor.GOLD + "Packed Ice Block");
		packedIceBlock.setItemMeta(packedIceBlockMeta);
		
		ItemStack netherPortal = SkullItem.getSkull("http://textures.minecraft.net/texture/b0bfc2577f6e26c6c6f7365c2c4076bccee653124989382ce93bca4fc9e39b");
		ItemMeta netherPortalMeta = netherPortal.getItemMeta();
		netherPortalMeta.setDisplayName(ChatColor.GOLD + "Nether Portal");
		netherPortal.setItemMeta(netherPortalMeta);
		
		ItemStack endStone = SkullItem.getSkull("http://textures.minecraft.net/texture/19f21f5d883316fd65a9366f32a33013182e3381dec21c17c78355d9bf4f0");
		ItemMeta endStoneMeta = endStone.getItemMeta();
		endStoneMeta.setDisplayName(ChatColor.GOLD + "End Stone");
		endStone.setItemMeta(endStoneMeta);
		
		ItemStack mossyCobblestone = SkullItem.getSkull("http://textures.minecraft.net/texture/4d9238efc93493b14a582639eb0aa8834eaa48e10bd4c234eb1a4c363b43d5b");
		ItemMeta mossyCobblestoneMeta = mossyCobblestone.getItemMeta();
		mossyCobblestoneMeta.setDisplayName(ChatColor.GOLD + "Mossy Cobblestone");
		mossyCobblestone.setItemMeta(mossyCobblestoneMeta);
		
		ItemStack brick = SkullItem.getSkull("http://textures.minecraft.net/texture/5ec0ebea1821c292fdff45d359b3a9e2122717e83d55dc07fc3bb1ce32935e");
		ItemMeta brickMeta = brick.getItemMeta();
		brickMeta.setDisplayName(ChatColor.GOLD + "Brick");
		brick.setItemMeta(brickMeta);
		
		ItemStack clay = SkullItem.getSkull("http://textures.minecraft.net/texture/67826829eab5ad62f0c11d9faafdc9954364871160dd839e1ab5a3b213a33");
		ItemMeta clayMeta = clay.getItemMeta();
		clayMeta.setDisplayName(ChatColor.GOLD + "Clay");
		clay.setItemMeta(clayMeta);
		
		ItemStack coalOre = SkullItem.getSkull("http://textures.minecraft.net/texture/7788f5ddaf52c5842287b9427a74dac8f0919eb2fdb1b51365ab25eb392c47");
		ItemMeta coalOreMeta = coalOre.getItemMeta();
		coalOreMeta.setDisplayName(ChatColor.GOLD + "Coal Ore");
		coalOre.setItemMeta(coalOreMeta);
		
		ItemStack coalBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/f6c5ecac942c77b95ab4620df5b85e38064c974f9c5c576b843622806a4557");
		ItemMeta coalBlockMeta = coalBlock.getItemMeta();
		coalBlockMeta.setDisplayName(ChatColor.GOLD + "Coal Block");
		coalBlock.setItemMeta(coalBlockMeta);
		
		ItemStack darkPrismarine = SkullItem.getSkull("textures.minecraft.net/texture/fd918598989549594446e83f33873891178da9db42f912e5272e1fb240312a");
		ItemMeta darkPrismarineMeta = darkPrismarine.getItemMeta();
		darkPrismarineMeta.setDisplayName(ChatColor.GOLD + "Dark Prismarine");
		darkPrismarine.setItemMeta(darkPrismarineMeta);
		
		ItemStack dispenser = SkullItem.getSkull("http://textures.minecraft.net/texture/e82e6aa950117384eb4bf55217283a78f57b8c85c089aad03bac5caa83c3020");
		ItemMeta dispenserMeta = dispenser.getItemMeta();
		dispenserMeta.setDisplayName(ChatColor.GOLD + "Dispenser");
		dispenser.setItemMeta(dispenserMeta);
		
		ItemStack beacon = SkullItem.getSkull("http://textures.minecraft.net/texture/9dbdaa755099edd7efa1f12882c7a51b5815db52e0b164aef6df9a1f53eca23");
		ItemMeta beaconMeta = beacon.getItemMeta();
		beaconMeta.setDisplayName(ChatColor.GOLD + "Beacon");
		beacon.setItemMeta(beaconMeta);
		
		ItemStack pillarQuartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/61fab0225e20e8458e8b75399713388d929856b551b0149081dbb0121e2a1664");
		ItemMeta pillarQuartzBlockMeta = pillarQuartzBlock.getItemMeta();
		pillarQuartzBlockMeta.setDisplayName(ChatColor.GOLD + "Pillar Quartz Block");
		pillarQuartzBlock.setItemMeta(pillarQuartzBlockMeta);
		
		ItemStack chiseledQuartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/852cf1aef4b6adbc38f196dfba536db5a0b068f1ab91769ad8c6d2f74d3a5d4e");
		ItemMeta chiseledQuartzBlockMeta = chiseledQuartzBlock.getItemMeta();
		chiseledQuartzBlockMeta.setDisplayName(ChatColor.GOLD + "Chiseled Quartz Block");
		chiseledQuartzBlock.setItemMeta(chiseledQuartzBlockMeta);
		
		ItemStack seaLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/824c6ff1714eb2c3b844d46d2e5ea2f26d273a33eaaa744abf645b060b47d7");
		ItemMeta seaLanternMeta = seaLantern.getItemMeta();
		seaLanternMeta.setDisplayName(ChatColor.GOLD + "Sea Lantern");
		seaLantern.setItemMeta(seaLanternMeta);
		
		ItemStack dryFarmland = SkullItem.getSkull("http://textures.minecraft.net/texture/11530f790e972e0bcc63a54dc55532902568def8dedf2e22e759bbcbc55c0");
		ItemMeta dryFarmlandMeta = dryFarmland.getItemMeta();
		dryFarmlandMeta.setDisplayName(ChatColor.GOLD + "Dry Farmland");
		dryFarmland.setItemMeta(dryFarmlandMeta);
		
		ItemStack coarseDirt = SkullItem.getSkull("http://textures.minecraft.net/texture/2fa764b3c1d462f8124478ff543c7633fa19baf9913ee228513e81a3633d");
		ItemMeta coarseDirtMeta = coarseDirt.getItemMeta();
		coarseDirtMeta.setDisplayName(ChatColor.GOLD + "Coarse Dirt");
		coarseDirt.setItemMeta(coarseDirtMeta);
		
		ItemStack redstoneLampOff = SkullItem.getSkull("http://textures.minecraft.net/texture/bd58d459165d5978753eab5f44bd609f3db84ee3bb016932052389d38b895");
		ItemMeta redstoneLampOffMeta = redstoneLampOff.getItemMeta();
		redstoneLampOffMeta.setDisplayName(ChatColor.GOLD + "Redstone Lamp (Off)");
		redstoneLampOff.setItemMeta(redstoneLampOffMeta);
		
		ItemStack hardenedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/82d5fefe20daf31c238ee227dd141827ada5ef8482d8d357bbe5a7cf40af85");
		ItemMeta hardenedClayMeta = hardenedClay.getItemMeta();
		hardenedClayMeta.setDisplayName(ChatColor.GOLD + "Hardened Clay");
		hardenedClay.setItemMeta(hardenedClayMeta);
		
		ItemStack blackStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/e17ff8babb91b4dbad7524e58eed4b2f71565745989af9a2ccfcf3328f61bd2");
		ItemMeta blackStainedClayMeta = blackStainedClay.getItemMeta();
		blackStainedClayMeta.setDisplayName(ChatColor.GOLD + "Black Stained Clay");
		blackStainedClay.setItemMeta(blackStainedClayMeta);
		
		ItemStack blueStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7c116694731fbd272c1ffa4352a5359b6c3a4cb5864a74a5dbe0f665f8385c");
		ItemMeta blueStainedClayMeta = blueStainedClay.getItemMeta();
		blueStainedClayMeta.setDisplayName(ChatColor.GOLD + "Blue Stianed Clay");
		blueStainedClay.setItemMeta(blueStainedClayMeta);
		
		ItemStack brownStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/54b932f117c87e11189f1c4c40cfd92be9119b1137cd610c68edd41ac58f14");
		ItemMeta brownStainedClayMeta = brownStainedClay.getItemMeta();
		brownStainedClayMeta.setDisplayName(ChatColor.GOLD + "Brown Stained Clay");
		brownStainedClay.setItemMeta(brownStainedClayMeta);
		
		ItemStack cyanStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/4463811fd0c48fcd73abcb7bbe5aa5ec6bc2809ffc5577d3f4559df30765f");
		ItemMeta cyanStainedClayMeta = cyanStainedClay.getItemMeta();
		cyanStainedClayMeta.setDisplayName(ChatColor.GOLD + "Cyan Stained Clay");
		cyanStainedClay.setItemMeta(cyanStainedClayMeta);
		
		ItemStack grayStainedClay = SkullItem.getSkull("textures.minecraft.net/texture/9efa7b5e5e63d46d14615c61bed15427d90b261c7ca5e8159c466f09561da");
		ItemMeta grayStainedClayMeta = grayStainedClay.getItemMeta();
		grayStainedClayMeta.setDisplayName(ChatColor.GOLD + "Gray Stained Clay");
		grayStainedClay.setItemMeta(grayStainedClayMeta);
		
		ItemStack greenStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/b55d5019c8d55bcb9dc3494ccc3419757f89c3384cf3c9abec3f18831f35b0");
		ItemMeta greenStainedClayMeta = greenStainedClay.getItemMeta();
		greenStainedClayMeta.setDisplayName(ChatColor.GOLD + "Green Stained Clay");
		greenStainedClay.setItemMeta(greenStainedClayMeta);
		
		ItemStack limeStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/55a117e161f7a291d0a3a168e77a21b09d39ffdf5773d22ac02f5fa6611db67");
		ItemMeta limeStainedClayMeta = limeStainedClay.getItemMeta();
		limeStainedClayMeta.setDisplayName(ChatColor.GOLD + "Lime Stained Clay");
		limeStainedClay.setItemMeta(limeStainedClayMeta);
		
		ItemStack magentaStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/3441528d288b2b79736cb2248878fb91efb4462d43bebd711f7326afbbf85");
		ItemMeta magentaStainedClayMeta = magentaStainedClay.getItemMeta();
		magentaStainedClayMeta.setDisplayName(ChatColor.GOLD + "Magenta Stained Clay");
		magentaStainedClay.setItemMeta(magentaStainedClayMeta);
		
		ItemStack orangeStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7316c16b1ac470d2c114434ff8730f1815709383db6f3cf720c39b6dce2116");
		ItemMeta orangeStainedClayMeta = orangeStainedClay.getItemMeta();
		orangeStainedClayMeta.setDisplayName(ChatColor.GOLD + "Orange Stained Clay");
		orangeStainedClay.setItemMeta(orangeStainedClayMeta);
		
		ItemStack pinkStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/f75db81e1592f32d771dd5dbc6c3a51e7a0d66b22dfe296b96868505ceec");
		ItemMeta pinkStainedClayMeta = pinkStainedClay.getItemMeta();
		pinkStainedClayMeta.setDisplayName(ChatColor.GOLD + "Pink Stained Clay");
		pinkStainedClay.setItemMeta(pinkStainedClayMeta);
		
		ItemStack redStainedClay = SkullItem.getSkull("textures.minecraft.net/texture/9e42f682e430b55b61204a6f8b76d5227d278ed9ec4d98bda4a7a4830a4b6");
		ItemMeta redStainedClayMeta = redStainedClay.getItemMeta();
		redStainedClayMeta.setDisplayName(ChatColor.GOLD + "Red Stained Clay");
		redStainedClay.setItemMeta(redStainedClayMeta);
		
		ItemStack purpleStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/e6f54f82836a55924ee85dec56bbbd8ca14633daa9bfe3565592edf39a6de");
		ItemMeta purpleStainedClayMeta = purpleStainedClay.getItemMeta();
		purpleStainedClayMeta.setDisplayName(ChatColor.GOLD + "Purple Stained Clay");
		purpleStainedClay.setItemMeta(purpleStainedClayMeta);
		
		ItemStack whiteStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7159594388bf013a4e3e6869faabcb95d31dd3f4a258a535e7cbd92c9986b7");
		ItemMeta whiteStainedClayMeta = whiteStainedClay.getItemMeta();
		whiteStainedClayMeta.setDisplayName(ChatColor.GOLD + "White Stained Clay");
		whiteStainedClay.setItemMeta(whiteStainedClayMeta);
		
		ItemStack lightGrayStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/5cde99b72728ef881640fa5068d122e61dd9cf718dbb3709fc5b326f1af5d");
		ItemMeta lightGrayStainedClayMeta = lightGrayStainedClay.getItemMeta();
		lightGrayStainedClayMeta.setDisplayName(ChatColor.GOLD + "Light Gray Stained Clay");
		lightGrayStainedClay.setItemMeta(lightGrayStainedClayMeta);
		
		ItemStack chiseledSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/491e7f9033765cec968f272fc58b7344c434a1721f9537b25a6aff4c24576c5");
		ItemMeta chiseledSandstoneMeta = chiseledSandstone.getItemMeta();
		chiseledSandstoneMeta.setDisplayName(ChatColor.GOLD + "Chiseled Sandstone");
		chiseledSandstone.setItemMeta(chiseledSandstoneMeta);
		
		inventory.setItem(0, crackedStoneBrick);
		inventory.setItem(1, mossyStoneBrick);
		inventory.setItem(2, stoneSlab);
		inventory.setItem(3, snowBlock);
		inventory.setItem(4, slimeBlock);
		inventory.setItem(5, obsidian);
		inventory.setItem(6, smoothRedSandstone);
		inventory.setItem(7, redSandstone);
		inventory.setItem(8, noteBlock);
		inventory.setItem(9, packedIceBlock);
		inventory.setItem(10, netherPortal);
		inventory.setItem(11, endStone);
		inventory.setItem(12, mossyCobblestone);
		inventory.setItem(13, brick);
		inventory.setItem(14, clay);
		inventory.setItem(15, coalOre);
		inventory.setItem(16, coalBlock);
		inventory.setItem(17, darkPrismarine);
		inventory.setItem(18, dispenser);
		inventory.setItem(19, beacon);
		inventory.setItem(20, pillarQuartzBlock);
		inventory.setItem(21, chiseledQuartzBlock);
		inventory.setItem(22, seaLantern);
		inventory.setItem(23, dryFarmland);
		inventory.setItem(24, coarseDirt);
		inventory.setItem(25, redstoneLampOff);
		inventory.setItem(26, hardenedClay);
		inventory.setItem(27, blackStainedClay);
		inventory.setItem(28, blueStainedClay);
		inventory.setItem(29, cyanStainedClay);
		inventory.setItem(30, grayStainedClay);
		inventory.setItem(31, greenStainedClay);
		inventory.setItem(32, limeStainedClay);
		inventory.setItem(33, magentaStainedClay);
		inventory.setItem(34, orangeStainedClay);
		inventory.setItem(35, pinkStainedClay);
		inventory.setItem(36, redStainedClay);
		inventory.setItem(37, purpleStainedClay);
		inventory.setItem(38, whiteStainedClay);
		inventory.setItem(39, lightGrayStainedClay);
		inventory.setItem(40, chiseledSandstone);
	}
}