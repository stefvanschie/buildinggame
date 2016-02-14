package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.blocks;

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

public class BlocksHeadsMenuOne {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.blocks.page-1.title")));
		
		ItemStack lightBlueStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/87bc8f5ac2bf3369741a962de2addbaa17d15cc4dadb19aef6e944817e6c24");
		ItemMeta lightBlueStainedClayMeta = lightBlueStainedClay.getItemMeta();
		lightBlueStainedClayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.light-blue-stained-clay.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.light-blue-stained-clay.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightBlueStainedClayMeta.setLore(lores);
		}
		lightBlueStainedClay.setItemMeta(lightBlueStainedClayMeta);
		
		ItemStack blueWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3f3e406291174d24cdf0f953f8a174a82bb3489dce8f679a443ef1aae0169061");
		ItemMeta blueWoolMeta = blueWool.getItemMeta();
		blueWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.blue-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.blue-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blueWoolMeta.setLore(lores);
		}
		blueWool.setItemMeta(blueWoolMeta);
		
		ItemStack blackWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3ab0263bdd76f3e418dba5bf481b921ced397d8b8a34a5561fb7beaa46ece1");
		ItemMeta blackWoolMeta = blackWool.getItemMeta();
		blackWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.black-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.black-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blackWoolMeta.setLore(lores);
		}
		blackWool.setItemMeta(blackWoolMeta);
		
		ItemStack woodPlank = SkullItem.getSkull("http://textures.minecraft.net/texture/a0e9d2beb84b32e3f15e380cc2c5510642911a512105fa2ec679bc540fd8184");
		ItemMeta woodPlankMeta = woodPlank.getItemMeta();
		woodPlankMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.wood-plank.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.wood-plank.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			woodPlankMeta.setLore(lores);
		}
		woodPlank.setItemMeta(woodPlankMeta);
		
		ItemStack podzol = SkullItem.getSkull("http://textures.minecraft.net/texture/a4195f9a439c6d0ffd1961657f6f0aa8e3a2f8a2493afa662ab5e4193e0");
		ItemMeta podzolMeta = podzol.getItemMeta();
		podzolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.podzol.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.podzol.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			podzolMeta.setLore(lores);
		}
		podzol.setItemMeta(podzolMeta);
		
		ItemStack grass = SkullItem.getSkull("http://textures.minecraft.net/texture/349c63bc508723328a19e597f40862d27ad5c1d545663ac24466582f568d9");
		ItemMeta grassMeta = grass.getItemMeta();
		grassMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.grass.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.grass.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			grassMeta.setLore(lores);
		}
		grass.setItemMeta(grassMeta);
		
		ItemStack snowGrass = SkullItem.getSkull("http://textures.minecraft.net/texture/43c52eae747cad5b4fd19b1a23b39a336b62ed422797a622d045f43e5d38");
		ItemMeta snowGrassMeta = snowGrass.getItemMeta();
		snowGrassMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.snow-grass.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.snow-grass.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			snowGrassMeta.setLore(lores);
		}
		snowGrass.setItemMeta(snowGrassMeta);
		
		ItemStack dirt = SkullItem.getSkull("http://textures.minecraft.net/texture/1ab43b8c3d34f125e5a3f8b92cd43dfd14c62402c33298461d4d4d7ce2d3aea");
		ItemMeta dirtMeta = dirt.getItemMeta();
		dirtMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.dirt.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.dirt.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dirtMeta.setLore(lores);
		}
		dirt.setItemMeta(dirtMeta);
		
		ItemStack mycellium = SkullItem.getSkull("http://textures.minecraft.net/texture/7eb4c41f481e816cf4b507b0a17595f2ba1f24664dc432be347d4e7a4eb3");
		ItemMeta mycelliumMeta = mycellium.getItemMeta();
		mycelliumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.mycellium.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.mycellium.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mycelliumMeta.setLore(lores);
		}
		mycellium.setItemMeta(mycelliumMeta);
		
		ItemStack redSand = SkullItem.getSkull("http://textures.minecraft.net/texture/4ce41e6879dff0785d14cb7694ea6b0df192b96b8816013eb455e71552fce6a");
		ItemMeta redSandMeta = redSand.getItemMeta();
		redSandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.red-sand.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.red-sand.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redSandMeta.setLore(lores);
		}
		redSand.setItemMeta(redSandMeta);
		
		ItemStack sand = SkullItem.getSkull("http://textures.minecraft.net/texture/d7d7d72e78f35decd2b08ea9b74790e5cd7e26484cf2449bdeca4f78ba3");
		ItemMeta sandMeta = sand.getItemMeta();
		sandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.sand.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.sand.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sandMeta.setLore(lores);
		}
		sand.setItemMeta(sandMeta);
		
		ItemStack soulsand = SkullItem.getSkull("http://textures.minecraft.net/texture/1ea6f932b45fdf3b693d9e44bd05bca364eb5b9aff497226fdb52abb2436422");
		ItemMeta soulsandMeta = soulsand.getItemMeta();
		soulsandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.soulsand.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.soulsand.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			soulsandMeta.setLore(lores);
		}
		soulsand.setItemMeta(soulsandMeta);
		
		ItemStack netherrack = SkullItem.getSkull("http://textures.minecraft.net/texture/5ece8e8383563bcef5d5ae0b1bffed1d6158b9ab7c1ac8344c18ac48f6b6a2");
		ItemMeta netherrackMeta = netherrack.getItemMeta();
		netherrackMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.netherrack.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.netherrack.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			netherrackMeta.setLore(lores);
		}
		netherrack.setItemMeta(netherrackMeta);
		
		ItemStack mobSpawner = SkullItem.getSkull("http://textures.minecraft.net/texture/647e2e5d55b6d04943519bed2557c6329e33b60b909dee8923cd88b115210");
		ItemMeta mobSpawnerMeta = mobSpawner.getItemMeta();
		mobSpawnerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.mob-spawner.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.mob-spawner.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mobSpawnerMeta.setLore(lores);
		}
		mobSpawner.setItemMeta(mobSpawnerMeta);
		
		ItemStack netherbrick = SkullItem.getSkull("http://textures.minecraft.net/texture/c60b2f9145215a3a5065dca2d89bb8b4ca44b9222dd22060b51c38d9bf587");
		ItemMeta netherbrickMeta = netherbrick.getItemMeta();
		netherbrickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.netherbrick.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.netherbrick.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			netherbrickMeta.setLore(lores);
		}
		netherbrick.setItemMeta(netherbrickMeta);
		
		ItemStack quartzOre = SkullItem.getSkull("http://textures.minecraft.net/texture/26de58d583c103c1cd34824380c8a477e898fde2eb9a74e71f1a985053b96");
		ItemMeta quartzOreMeta = quartzOre.getItemMeta();
		quartzOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.quartz-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.quartz-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			quartzOreMeta.setLore(lores);
		}
		quartzOre.setItemMeta(quartzOreMeta);
		
		ItemStack enderpearl = SkullItem.getSkull("http://textures.minecraft.net/texture/8d388aed9b72a65ef3254809a4e7b91d5bc4eb255801eaf18ab537ba921e2");
		ItemMeta enderpearlMeta = enderpearl.getItemMeta();
		enderpearlMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.enderpearl.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.enderpearl.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			enderpearlMeta.setLore(lores);
		}
		enderpearl.setItemMeta(enderpearlMeta);
		
		ItemStack endereye = SkullItem.getSkull("http://textures.minecraft.net/texture/872d341d77dbde6d53dad61bf192524dbdb96af1358e0748feea1481b1f8");
		ItemMeta endereyeMeta = endereye.getItemMeta();
		endereyeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.endereye.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.endereye.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			endereyeMeta.setLore(lores);
		}
		endereye.setItemMeta(endereyeMeta);
		
		ItemStack enderPortal = SkullItem.getSkull("http://textures.minecraft.net/texture/a4a319deafefd6adb37f21449ea56d3ea5a83857fb9616fa7d4f9ea625177");
		ItemMeta enderPortalMeta = enderPortal.getItemMeta();
		enderPortalMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.ender-portal.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.ender-portal.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			enderPortalMeta.setLore(lores);
		}
		enderPortal.setItemMeta(enderPortalMeta);
		
		ItemStack iceBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/872d9b98a6b34a2762aac1af915873c066c43c2b2b8d689d27626cc5afcb11");
		ItemMeta iceBlockMeta = iceBlock.getItemMeta();
		iceBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.ice-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.ice-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			iceBlockMeta.setLore(lores);
		}
		iceBlock.setItemMeta(iceBlockMeta);
		
		ItemStack water = SkullItem.getSkull("http://textures.minecraft.net/texture/5c7ecbfd6d33e873a1cf9a92f57f146152b52d9d7311694602671111a302f");
		ItemMeta waterMeta = water.getItemMeta();
		waterMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.water.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.water.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			waterMeta.setLore(lores);
		}
		water.setItemMeta(waterMeta);
		
		ItemStack lava = SkullItem.getSkull("http://textures.minecraft.net/texture/b6965e6a58684c277d18717cec959f2833a72dfa95661019dbcdf3dbf66b048");
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.lava.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.lava.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lavaMeta.setLore(lores);
		}
		lava.setItemMeta(lavaMeta);
		
		ItemStack emeraldBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/af121f7c1ab1567ff21983ff7a9e55c40c0b865f050d37e5d35defbaa");
		ItemMeta emeraldBlockMeta = emeraldBlock.getItemMeta();
		emeraldBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.emerald-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.emerald-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			emeraldBlockMeta.setLore(lores);
		}
		emeraldBlock.setItemMeta(emeraldBlockMeta);
		
		ItemStack diamondBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/ef7ece624667b94526999dcfaeb7b360c6836be9a773aca9d2eec0d78e9ad5");
		ItemMeta diamondBlockMeta = diamondBlock.getItemMeta();
		diamondBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.diamond-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.diamond-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			diamondBlockMeta.setLore(lores);
		}
		diamondBlock.setItemMeta(diamondBlockMeta);
		
		ItemStack goldBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/c1a1c1bb36c426c53a7fbfec3cd1f0f2189279c6b98eb881963f32f619159");
		ItemMeta goldBlockMeta = goldBlock.getItemMeta();
		goldBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.gold-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.gold-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goldBlockMeta.setLore(lores);
		}
		goldBlock.setItemMeta(goldBlockMeta);
		
		ItemStack ironBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/bba8459145d83ffc44ad58c3260e74ca5a0f634c7eeb59a1ad3234849c933c");
		ItemMeta ironBlockMeta = ironBlock.getItemMeta();
		ironBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.iron-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.iron-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			ironBlockMeta.setLore(lores);
		}
		ironBlock.setItemMeta(ironBlockMeta);
		
		ItemStack emeraldOre = SkullItem.getSkull("http://textures.minecraft.net/texture/4fc495d1e6eb54a386068c6cb121c5875e031b7f61d7236d5f24b77db7da7f");
		ItemMeta emeraldOreMeta = emeraldOre.getItemMeta();
		emeraldOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.emerald-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.emerald-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			emeraldOreMeta.setLore(lores);
		}
		emeraldOre.setItemMeta(emeraldOreMeta);
		
		ItemStack redstoneOre = SkullItem.getSkull("http://textures.minecraft.net/texture/e8deee5866ab199eda1bdd7707bdb9edd693444f1e3bd336bd2c767151cf2");
		ItemMeta redstoneOreMeta = redstoneOre.getItemMeta();
		redstoneOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.redstone-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.redstone-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redstoneOreMeta.setLore(lores);
		}
		redstoneOre.setItemMeta(redstoneOreMeta);
		
		ItemStack diamondOre = SkullItem.getSkull("http://textures.minecraft.net/texture/31cbd5383bac3cb78bc62efc8c44b36a6cf86bff9f4dcc2ce5ccf666d3a971");
		ItemMeta diamondOreMeta = diamondOre.getItemMeta();
		diamondOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.diamond-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.diamond-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			diamondOreMeta.setLore(lores);
		}
		diamondOre.setItemMeta(diamondOreMeta);
		
		ItemStack ironOre = SkullItem.getSkull("http://textures.minecraft.net/texture/db97bdf92b61926e39f5cddf12f8f7132929dee541771e0b592c8b82c9ad52d");
		ItemMeta ironOreMeta = ironOre.getItemMeta();
		ironOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.iron-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.iron-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			ironOreMeta.setLore(lores);
		}
		ironOre.setItemMeta(ironOreMeta);
		
		ItemStack goldOre = SkullItem.getSkull("http://textures.minecraft.net/texture/e4df892293a9236f73f48f9efe979fe07dbd91f7b5d239e4acfd394f6eca");
		ItemMeta goldOreMeta = goldOre.getItemMeta();
		goldOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.gold-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.gold-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goldOreMeta.setLore(lores);
		}
		goldOre.setItemMeta(goldOreMeta);
		
		ItemStack cobblestone = SkullItem.getSkull("http://textures.minecraft.net/texture/195534e02c59b33ece5619280331979777e025fa5fa81ae75e99fd8efdebb8");
		ItemMeta cobblestoneMeta = cobblestone.getItemMeta();
		cobblestoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.cobblestone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.cobblestone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cobblestoneMeta.setLore(lores);
		}
		cobblestone.setItemMeta(cobblestoneMeta);
		
		ItemStack stone = SkullItem.getSkull("http://textures.minecraft.net/texture/de9b8aae7f9cc76d625ccb8abc686f30d38f9e6c42533098b9ad577f91c333c");
		ItemMeta stoneMeta = stone.getItemMeta();
		stoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.stone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.stone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			stoneMeta.setLore(lores);
		}
		stone.setItemMeta(stoneMeta);
		
		ItemStack stoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/c7a2c18ffa4d3f4216b2414179ecd88ae79e6b1e0e89c7bf25dd35994f7b96");
		ItemMeta stoneBrickMeta = stoneBrick.getItemMeta();
		stoneBrickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.stone-brick.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.stone-brick.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			stoneBrickMeta.setLore(lores);
		}
		stoneBrick.setItemMeta(stoneBrickMeta);
		
		ItemStack stoneBrick2 = SkullItem.getSkull("http://textures.minecraft.net/texture/6a3bb93b9933689bc5088dec730bbe859d826b6dad5ffd773c2d2b8f847f5f");
		ItemMeta stoneBrick2Meta = stoneBrick2.getItemMeta();
		stoneBrick2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.stone-brick-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.stone-brick-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			stoneBrick2Meta.setLore(lores);
		}
		stoneBrick2.setItemMeta(stoneBrick2Meta);
		
		ItemStack chimney = SkullItem.getSkull("http://textures.minecraft.net/texture/3058ec4d3920adbfa86550f5852422e1af55054a15afc9c2c922d58765faa5b");
		ItemMeta chimneyMeta = chimney.getItemMeta();
		chimneyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.chimney.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.chimney.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chimneyMeta.setLore(lores);
		}
		chimney.setItemMeta(chimneyMeta);
		
		ItemStack bedrock = SkullItem.getSkull("http://textures.minecraft.net/texture/bb99e036a4b27b3b58b72f8663c502cab8cfa46db393d8487119ca57979e3fd");
		ItemMeta bedrockMeta = bedrock.getItemMeta();
		bedrockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.bedrock.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.bedrock.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bedrockMeta.setLore(lores);
		}
		bedrock.setItemMeta(bedrockMeta);
		
		ItemStack brick = SkullItem.getSkull("http://textures.minecraft.net/texture/290d4fcb2ce03b94d920f0a9e7a54b32cfc7a1d33a6dfe9757d8678cbb591");
		ItemMeta brickMeta = brick.getItemMeta();
		brickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.brick.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.brick.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brickMeta.setLore(lores);
		}
		brick.setItemMeta(brickMeta);
		
		ItemStack quartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/e5e2b2ed298b53cc84783cd785ec57da49ceaabdcff31b25fe5256b3429b412");
		ItemMeta quartzBlockMeta = quartzBlock.getItemMeta();
		quartzBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.quartz-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.quartz-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			quartzBlockMeta.setLore(lores);
		}
		quartzBlock.setItemMeta(quartzBlockMeta);
		
		ItemStack slimeBall = SkullItem.getSkull("http://textures.minecraft.net/texture/4934a9f5ab1789a7d8dd96d32493cdacff577d8c81e7b23917dff2e32bd0bc10");
		ItemMeta slimeBallMeta = slimeBall.getItemMeta();
		slimeBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.slime-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.slime-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			slimeBallMeta.setLore(lores);
		}
		slimeBall.setItemMeta(slimeBallMeta);
		
		ItemStack redstoneLampOn = SkullItem.getSkull("http://textures.minecraft.net/texture/1aff93ebecc1f8fbd13ba7839ec7bdcdecab7c07fd8ba78ee78ad0bd3accbe");
		ItemMeta redstoneLampOnMeta = redstoneLampOn.getItemMeta();
		redstoneLampOnMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.redstone-lamp-on.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.redstone-lamp-on.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redstoneLampOnMeta.setLore(lores);
		}
		redstoneLampOn.setItemMeta(redstoneLampOnMeta);
		
		ItemStack piston = SkullItem.getSkull("http://textures.minecraft.net/texture/dac9672ff65c2d27ac61b94d174cf1cc70729ec7f5663397e2dd4726a7bcd5");
		ItemMeta pistonMeta = piston.getItemMeta();
		pistonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.piston.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.piston.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pistonMeta.setLore(lores);
		}
		piston.setItemMeta(pistonMeta);
		
		ItemStack stickyPiston = SkullItem.getSkull("http://textures.minecraft.net/texture/7ca4d218df9d32cd47d9c1d294877122be5919b418a6cc3d089162b133f2db");
		ItemMeta stickyPistonMeta = stickyPiston.getItemMeta();
		stickyPistonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.sticky-piston.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.sticky-piston.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			stickyPistonMeta.setLore(lores);
		}
		stickyPiston.setItemMeta(stickyPistonMeta);
		
		ItemStack slimePiston = SkullItem.getSkull("http://textures.minecraft.net/texture/b711315e3701d66c53154aac995d64ff7f80be8e11d2712d9298dbabd71d6");
		ItemMeta slimePistonMeta = slimePiston.getItemMeta();
		slimePistonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.slime-piston.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.slime-piston.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			slimePistonMeta.setLore(lores);
		}
		slimePiston.setItemMeta(slimePistonMeta);
		
		ItemStack halfPiston = SkullItem.getSkull("http://textures.minecraft.net/texture/aa868ce917c09af8e4c350a5807041f6509bf2b89aca45e591fbbd7d4b117d");
		ItemMeta halfPistonMeta = halfPiston.getItemMeta();
		halfPistonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.half-piston.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.half-piston.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			halfPistonMeta.setLore(lores);
		}
		halfPiston.setItemMeta(halfPistonMeta);
		
		ItemStack dropper = SkullItem.getSkull("http://textures.minecraft.net/texture/6326f0e739353d2d7c8e9ab4e91e1fbec607cad0fe10296afd21d633b9ecee");
		ItemMeta dropperMeta = dropper.getItemMeta();
		dropperMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.dropper.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.dropper.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dropperMeta.setLore(lores);
		}
		dropper.setItemMeta(dropperMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-1.next-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-1.next-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nextMeta.setLore(lores);
		}
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
		inventory.setItem(0, lightBlueStainedClay);
		inventory.setItem(1, blueWool);
		inventory.setItem(2, blackWool);
		inventory.setItem(3, woodPlank);
		inventory.setItem(4, podzol);
		inventory.setItem(5, grass);
		inventory.setItem(6, snowGrass);
		inventory.setItem(7, dirt);
		inventory.setItem(8, mycellium);
		inventory.setItem(9, redSand);
		inventory.setItem(10, sand);
		inventory.setItem(11, soulsand);
		inventory.setItem(12, netherrack);
		inventory.setItem(13, mobSpawner);
		inventory.setItem(14, netherbrick);
		inventory.setItem(15, quartzOre);
		inventory.setItem(16, endereye);
		inventory.setItem(17, enderPortal);
		inventory.setItem(18, iceBlock);
		inventory.setItem(19, water);
		inventory.setItem(20, lava);
		inventory.setItem(21, emeraldBlock);
		inventory.setItem(22, diamondBlock);
		inventory.setItem(23, goldBlock);
		inventory.setItem(24, ironBlock);
		inventory.setItem(25, emeraldOre);
		inventory.setItem(26, redstoneOre);
		inventory.setItem(27, diamondOre);
		inventory.setItem(28, ironOre);
		inventory.setItem(29, goldOre);
		inventory.setItem(30, cobblestone);
		inventory.setItem(31, stone);
		inventory.setItem(32, stoneBrick);
		inventory.setItem(33, stoneBrick2);
		inventory.setItem(34, chimney);
		inventory.setItem(35, bedrock);
		inventory.setItem(36, brick);
		inventory.setItem(37, quartzBlock);
		inventory.setItem(38, slimeBall);
		inventory.setItem(39, redstoneLampOn);
		inventory.setItem(40, piston);
		inventory.setItem(41, stickyPiston);
		inventory.setItem(42, slimePiston);
		inventory.setItem(43, halfPiston);
		inventory.setItem(44, dropper);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}