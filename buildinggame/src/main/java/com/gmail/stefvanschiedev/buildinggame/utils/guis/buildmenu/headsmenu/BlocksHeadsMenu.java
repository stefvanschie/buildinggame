package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.SkullItem;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The gui for the heads in the blocks category
 *
 * @since 4.0.0
 */
public class BlocksHeadsMenu extends Gui {

    /**
     * Yaml Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new menu and adds all items to it
     *
     * @since 4.0.0
     */
	@SuppressWarnings("deprecation")
    public BlocksHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.blocks.title")), 3);
		
		//page one
		ItemStack lightBlueStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/87bc8f5ac2bf3369741a962de2addbaa17d15cc4dadb19aef6e944817e6c24");
		ItemMeta lightBlueStainedClayMeta = lightBlueStainedClay.getItemMeta();
		lightBlueStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.light-blue-stained-clay.name")));
		lightBlueStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.light-blue-stained-clay.lores")));
		lightBlueStainedClay.setItemMeta(lightBlueStainedClayMeta);
		
		addItem(lightBlueStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blueWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3f3e406291174d24cdf0f953f8a174a82bb3489dce8f679a443ef1aae0169061");
		ItemMeta blueWoolMeta = blueWool.getItemMeta();
		blueWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.blue-wool.name")));
		blueWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.blue-wool.lores")));
		blueWool.setItemMeta(blueWoolMeta);
		
		addItem(blueWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blackWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3ab0263bdd76f3e418dba5bf481b921ced397d8b8a34a5561fb7beaa46ece1");
		ItemMeta blackWoolMeta = blackWool.getItemMeta();
		blackWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.black-wool.name")));
		blackWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.black-wool.lores")));
		blackWool.setItemMeta(blackWoolMeta);
		
		addItem(blackWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack woodPlank = SkullItem.getSkull("http://textures.minecraft.net/texture/a0e9d2beb84b32e3f15e380cc2c5510642911a512105fa2ec679bc540fd8184");
		ItemMeta woodPlankMeta = woodPlank.getItemMeta();
		woodPlankMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.wood-plank.name")));
		woodPlankMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.wood-plank.lores")));
		woodPlank.setItemMeta(woodPlankMeta);
		
		addItem(woodPlank, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack podzol = SkullItem.getSkull("http://textures.minecraft.net/texture/a4195f9a439c6d0ffd1961657f6f0aa8e3a2f8a2493afa662ab5e4193e0");
		ItemMeta podzolMeta = podzol.getItemMeta();
		podzolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.podzol.name")));
		podzolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.podzol.lores")));
		podzol.setItemMeta(podzolMeta);
		
		addItem(podzol, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack grass = SkullItem.getSkull("http://textures.minecraft.net/texture/349c63bc508723328a19e597f40862d27ad5c1d545663ac24466582f568d9");
		ItemMeta grassMeta = grass.getItemMeta();
		grassMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.grass.name")));
		grassMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.grass.lores")));
		grass.setItemMeta(grassMeta);
		
		addItem(grass, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack snowGrass = SkullItem.getSkull("http://textures.minecraft.net/texture/43c52eae747cad5b4fd19b1a23b39a336b62ed422797a622d045f43e5d38");
		ItemMeta snowGrassMeta = snowGrass.getItemMeta();
		snowGrassMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.snow-grass.name")));
		snowGrassMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.snow-grass.lores")));
		snowGrass.setItemMeta(snowGrassMeta);
		
		addItem(snowGrass, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dirt = SkullItem.getSkull("http://textures.minecraft.net/texture/1ab43b8c3d34f125e5a3f8b92cd43dfd14c62402c33298461d4d4d7ce2d3aea");
		ItemMeta dirtMeta = dirt.getItemMeta();
		dirtMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dirt.name")));
		dirtMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dirt.lores")));
		dirt.setItemMeta(dirtMeta);
		
		addItem(dirt, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mycellium = SkullItem.getSkull("http://textures.minecraft.net/texture/7eb4c41f481e816cf4b507b0a17595f2ba1f24664dc432be347d4e7a4eb3");
		ItemMeta mycelliumMeta = mycellium.getItemMeta();
		mycelliumMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.mycellium.name")));
		mycelliumMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.mycellium.lores")));
		mycellium.setItemMeta(mycelliumMeta);
		
		addItem(mycellium, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redSand = SkullItem.getSkull("http://textures.minecraft.net/texture/4ce41e6879dff0785d14cb7694ea6b0df192b96b8816013eb455e71552fce6a");
		ItemMeta redSandMeta = redSand.getItemMeta();
		redSandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.red-sand.name")));
		redSandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.red-sand.lores")));
		redSand.setItemMeta(redSandMeta);
		
		addItem(redSand, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sand = SkullItem.getSkull("http://textures.minecraft.net/texture/d7d7d72e78f35decd2b08ea9b74790e5cd7e26484cf2449bdeca4f78ba3");
		ItemMeta sandMeta = sand.getItemMeta();
		sandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.sand.name")));
		sandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.sand.lores")));
		sand.setItemMeta(sandMeta);
		
		addItem(sand, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack soulsand = SkullItem.getSkull("http://textures.minecraft.net/texture/1ea6f932b45fdf3b693d9e44bd05bca364eb5b9aff497226fdb52abb2436422");
		ItemMeta soulsandMeta = soulsand.getItemMeta();
		soulsandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.soulsand.name")));
		soulsandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.soulsand.lores")));
		soulsand.setItemMeta(soulsandMeta);
		
		addItem(soulsand, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack netherrack = SkullItem.getSkull("http://textures.minecraft.net/texture/5ece8e8383563bcef5d5ae0b1bffed1d6158b9ab7c1ac8344c18ac48f6b6a2");
		ItemMeta netherrackMeta = netherrack.getItemMeta();
		netherrackMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.netherrack.name")));
		netherrackMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.netherrack.lores")));
		netherrack.setItemMeta(netherrackMeta);
		
		addItem(netherrack, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mobSpawner = SkullItem.getSkull("http://textures.minecraft.net/texture/647e2e5d55b6d04943519bed2557c6329e33b60b909dee8923cd88b115210");
		ItemMeta mobSpawnerMeta = mobSpawner.getItemMeta();
		mobSpawnerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.mob-spawner.name")));
		mobSpawnerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.mob-spawner.lores")));
		mobSpawner.setItemMeta(mobSpawnerMeta);
		
		addItem(mobSpawner, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack netherbrick = SkullItem.getSkull("http://textures.minecraft.net/texture/c60b2f9145215a3a5065dca2d89bb8b4ca44b9222dd22060b51c38d9bf587");
		ItemMeta netherbrickMeta = netherbrick.getItemMeta();
		netherbrickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.netherbrick.name")));
		netherbrickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.netherbrick.lores")));
		netherbrick.setItemMeta(netherbrickMeta);
		
		addItem(netherbrick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack quartzOre = SkullItem.getSkull("http://textures.minecraft.net/texture/26de58d583c103c1cd34824380c8a477e898fde2eb9a74e71f1a985053b96");
		ItemMeta quartzOreMeta = quartzOre.getItemMeta();
		quartzOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.quartz-ore.name")));
		quartzOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.quartz-ore.lores")));
		quartzOre.setItemMeta(quartzOreMeta);
		
		addItem(quartzOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack enderpearl = SkullItem.getSkull("http://textures.minecraft.net/texture/8d388aed9b72a65ef3254809a4e7b91d5bc4eb255801eaf18ab537ba921e2");
		ItemMeta enderpearlMeta = enderpearl.getItemMeta();
		enderpearlMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.enderpearl.name")));
		enderpearlMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.enderpearl.lores")));
		enderpearl.setItemMeta(enderpearlMeta);
		
		addItem(enderpearl, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack endereye = SkullItem.getSkull("http://textures.minecraft.net/texture/872d341d77dbde6d53dad61bf192524dbdb96af1358e0748feea1481b1f8");
		ItemMeta endereyeMeta = endereye.getItemMeta();
		endereyeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.endereye.name")));
		endereyeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.endereye.lores")));
		endereye.setItemMeta(endereyeMeta);
		
		addItem(endereye, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack enderPortal = SkullItem.getSkull("http://textures.minecraft.net/texture/a4a319deafefd6adb37f21449ea56d3ea5a83857fb9616fa7d4f9ea625177");
		ItemMeta enderPortalMeta = enderPortal.getItemMeta();
		enderPortalMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.ender-portal.name")));
		enderPortalMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.ender-portal.lores")));
		enderPortal.setItemMeta(enderPortalMeta);
		
		addItem(enderPortal, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack iceBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/872d9b98a6b34a2762aac1af915873c066c43c2b2b8d689d27626cc5afcb11");
		ItemMeta iceBlockMeta = iceBlock.getItemMeta();
		iceBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.ice-block.name")));
		iceBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.ice-block.lores")));
		iceBlock.setItemMeta(iceBlockMeta);
		
		addItem(iceBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack water = SkullItem.getSkull("http://textures.minecraft.net/texture/5c7ecbfd6d33e873a1cf9a92f57f146152b52d9d7311694602671111a302f");
		ItemMeta waterMeta = water.getItemMeta();
		waterMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.water.name")));
		waterMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.water.lores")));
		water.setItemMeta(waterMeta);
		
		addItem(water, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lava = SkullItem.getSkull("http://textures.minecraft.net/texture/b6965e6a58684c277d18717cec959f2833a72dfa95661019dbcdf3dbf66b048");
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.lava.name")));
		lavaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.lava.lores")));
		lava.setItemMeta(lavaMeta);
		
		addItem(lava, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack emeraldBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/af121f7c1ab1567ff21983ff7a9e55c40c0b865f050d37e5d35defbaa");
		ItemMeta emeraldBlockMeta = emeraldBlock.getItemMeta();
		emeraldBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.emerald-block.name")));
		emeraldBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.emerald-block.lores")));
		emeraldBlock.setItemMeta(emeraldBlockMeta);
		
		addItem(emeraldBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack diamondBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/ef7ece624667b94526999dcfaeb7b360c6836be9a773aca9d2eec0d78e9ad5");
		ItemMeta diamondBlockMeta = diamondBlock.getItemMeta();
		diamondBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.diamond-block.name")));
		diamondBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.diamond-block.lores")));
		diamondBlock.setItemMeta(diamondBlockMeta);
		
		addItem(diamondBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack goldBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/c1a1c1bb36c426c53a7fbfec3cd1f0f2189279c6b98eb881963f32f619159");
		ItemMeta goldBlockMeta = goldBlock.getItemMeta();
		goldBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.gold-block.name")));
		goldBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.gold-block.lores")));
		goldBlock.setItemMeta(goldBlockMeta);
		
		addItem(goldBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack ironBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/bba8459145d83ffc44ad58c3260e74ca5a0f634c7eeb59a1ad3234849c933c");
		ItemMeta ironBlockMeta = ironBlock.getItemMeta();
		ironBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.iron-block.name")));
		ironBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.iron-block.lores")));
		ironBlock.setItemMeta(ironBlockMeta);
		
		addItem(ironBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack emeraldOre = SkullItem.getSkull("http://textures.minecraft.net/texture/4fc495d1e6eb54a386068c6cb121c5875e031b7f61d7236d5f24b77db7da7f");
		ItemMeta emeraldOreMeta = emeraldOre.getItemMeta();
		emeraldOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.emerald-ore.name")));
		emeraldOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.emerald-ore.lores")));
		emeraldOre.setItemMeta(emeraldOreMeta);
		
		addItem(emeraldOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneOre = SkullItem.getSkull("http://textures.minecraft.net/texture/e8deee5866ab199eda1bdd7707bdb9edd693444f1e3bd336bd2c767151cf2");
		ItemMeta redstoneOreMeta = redstoneOre.getItemMeta();
		redstoneOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-ore.name")));
		redstoneOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-ore.lores")));
		redstoneOre.setItemMeta(redstoneOreMeta);
		
		addItem(redstoneOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack diamondOre = SkullItem.getSkull("http://textures.minecraft.net/texture/31cbd5383bac3cb78bc62efc8c44b36a6cf86bff9f4dcc2ce5ccf666d3a971");
		ItemMeta diamondOreMeta = diamondOre.getItemMeta();
		diamondOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.diamond-ore.name")));
		diamondOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.diamond-ore.lores")));
		diamondOre.setItemMeta(diamondOreMeta);
		
		addItem(diamondOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack ironOre = SkullItem.getSkull("http://textures.minecraft.net/texture/db97bdf92b61926e39f5cddf12f8f7132929dee541771e0b592c8b82c9ad52d");
		ItemMeta ironOreMeta = ironOre.getItemMeta();
		ironOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.iron-ore.name")));
		ironOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.iron-ore.lores")));
		ironOre.setItemMeta(ironOreMeta);
		
		addItem(ironOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack goldOre = SkullItem.getSkull("http://textures.minecraft.net/texture/e4df892293a9236f73f48f9efe979fe07dbd91f7b5d239e4acfd394f6eca");
		ItemMeta goldOreMeta = goldOre.getItemMeta();
		goldOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.gold-ore.name")));
		goldOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.gold-ore.lores")));
		goldOre.setItemMeta(goldOreMeta);
		
		addItem(goldOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cobblestone = SkullItem.getSkull("http://textures.minecraft.net/texture/195534e02c59b33ece5619280331979777e025fa5fa81ae75e99fd8efdebb8");
		ItemMeta cobblestoneMeta = cobblestone.getItemMeta();
		cobblestoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.cobblestone.name")));
		cobblestoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.cobblestone.lores")));
		cobblestone.setItemMeta(cobblestoneMeta);
		
		addItem(cobblestone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack stone = SkullItem.getSkull("http://textures.minecraft.net/texture/de9b8aae7f9cc76d625ccb8abc686f30d38f9e6c42533098b9ad577f91c333c");
		ItemMeta stoneMeta = stone.getItemMeta();
		stoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.stone.name")));
		stoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.stone.lores")));
		stone.setItemMeta(stoneMeta);
		
		addItem(stone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack stoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/c7a2c18ffa4d3f4216b2414179ecd88ae79e6b1e0e89c7bf25dd35994f7b96");
		ItemMeta stoneBrickMeta = stoneBrick.getItemMeta();
		stoneBrickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.stone-brick.name")));
		stoneBrickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.stone-brick.lores")));
		stoneBrick.setItemMeta(stoneBrickMeta);
		
		addItem(stoneBrick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack stoneBrick2 = SkullItem.getSkull("http://textures.minecraft.net/texture/6a3bb93b9933689bc5088dec730bbe859d826b6dad5ffd773c2d2b8f847f5f");
		ItemMeta stoneBrick2Meta = stoneBrick2.getItemMeta();
		stoneBrick2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.stone-brick-2.name")));
		stoneBrick2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.stone-brick-2.lores")));
		stoneBrick2.setItemMeta(stoneBrick2Meta);
		
		addItem(stoneBrick2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack chimney = SkullItem.getSkull("http://textures.minecraft.net/texture/3058ec4d3920adbfa86550f5852422e1af55054a15afc9c2c922d58765faa5b");
		ItemMeta chimneyMeta = chimney.getItemMeta();
		chimneyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.chimney.name")));
		chimneyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.chimney.lores")));
		chimney.setItemMeta(chimneyMeta);
		
		addItem(chimney, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack bedrock = SkullItem.getSkull("http://textures.minecraft.net/texture/bb99e036a4b27b3b58b72f8663c502cab8cfa46db393d8487119ca57979e3fd");
		ItemMeta bedrockMeta = bedrock.getItemMeta();
		bedrockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.bedrock.name")));
		bedrockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.bedrock.lores")));
		bedrock.setItemMeta(bedrockMeta);
		
		addItem(bedrock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brick = SkullItem.getSkull("http://textures.minecraft.net/texture/290d4fcb2ce03b94d920f0a9e7a54b32cfc7a1d33a6dfe9757d8678cbb591");
		ItemMeta brickMeta = brick.getItemMeta();
		brickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.brick.name")));
		brickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.brick.lores")));
		brick.setItemMeta(brickMeta);
		
		addItem(brick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack quartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/e5e2b2ed298b53cc84783cd785ec57da49ceaabdcff31b25fe5256b3429b412");
		ItemMeta quartzBlockMeta = quartzBlock.getItemMeta();
		quartzBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.quartz-block.name")));
		quartzBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.quartz-block.lores")));
		quartzBlock.setItemMeta(quartzBlockMeta);
		
		addItem(quartzBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack slimeBall = SkullItem.getSkull("http://textures.minecraft.net/texture/4934a9f5ab1789a7d8dd96d32493cdacff577d8c81e7b23917dff2e32bd0bc10");
		ItemMeta slimeBallMeta = slimeBall.getItemMeta();
		slimeBallMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.slime-ball.name")));
		slimeBallMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.slime-ball.lores")));
		slimeBall.setItemMeta(slimeBallMeta);
		
		addItem(slimeBall, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneLampOn = SkullItem.getSkull("http://textures.minecraft.net/texture/1aff93ebecc1f8fbd13ba7839ec7bdcdecab7c07fd8ba78ee78ad0bd3accbe");
		ItemMeta redstoneLampOnMeta = redstoneLampOn.getItemMeta();
		redstoneLampOnMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-lamp-on.name")));
		redstoneLampOnMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-lamp-on.lores")));
		redstoneLampOn.setItemMeta(redstoneLampOnMeta);
		
		addItem(redstoneLampOn, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack piston = SkullItem.getSkull("http://textures.minecraft.net/texture/dac9672ff65c2d27ac61b94d174cf1cc70729ec7f5663397e2dd4726a7bcd5");
		ItemMeta pistonMeta = piston.getItemMeta();
		pistonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.piston.name")));
		pistonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.piston.lores")));
		piston.setItemMeta(pistonMeta);
		
		addItem(piston, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack stickyPiston = SkullItem.getSkull("http://textures.minecraft.net/texture/7ca4d218df9d32cd47d9c1d294877122be5919b418a6cc3d089162b133f2db");
		ItemMeta stickyPistonMeta = stickyPiston.getItemMeta();
		stickyPistonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.sticky-piston.name")));
		stickyPistonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.sticky-piston.lores")));
		stickyPiston.setItemMeta(stickyPistonMeta);
		
		addItem(stickyPiston, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack slimePiston = SkullItem.getSkull("http://textures.minecraft.net/texture/b711315e3701d66c53154aac995d64ff7f80be8e11d2712d9298dbabd71d6");
		ItemMeta slimePistonMeta = slimePiston.getItemMeta();
		slimePistonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.slime-piston.name")));
		slimePistonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.slime-piston.lores")));
		slimePiston.setItemMeta(slimePistonMeta);
		
		addItem(slimePiston, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack halfPiston = SkullItem.getSkull("http://textures.minecraft.net/texture/aa868ce917c09af8e4c350a5807041f6509bf2b89aca45e591fbbd7d4b117d");
		ItemMeta halfPistonMeta = halfPiston.getItemMeta();
		halfPistonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.half-piston.name")));
		halfPistonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.half-piston.lores")));
		halfPiston.setItemMeta(halfPistonMeta);
		
		addItem(halfPiston, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.close.lores")));
		close.setItemMeta(closeMeta);
		
		setItem(close, event -> {
            Player player = (Player) event.getWhoClicked();

            player.closeInventory();
            removePlayer(player);

            event.setCancelled(true);
		}, 49);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.next-page.name")));
		nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, event -> {
            open((Player) event.getWhoClicked(), 2);

            event.setCancelled(true);
		}, 51);
		
		setStartingPoint(54);
		
		//page two
		ItemStack dropper = SkullItem.getSkull("http://textures.minecraft.net/texture/6326f0e739353d2d7c8e9ab4e91e1fbec607cad0fe10296afd21d633b9ecee");
		ItemMeta dropperMeta = dropper.getItemMeta();
		dropperMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dropper.name")));
		dropperMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dropper.lores")));
		dropper.setItemMeta(dropperMeta);
		
		addItem(dropper, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dropper2 = SkullItem.getSkull("http://textures.minecraft.net/texture/25e9152efd892f60d7e0d7e53369e04779ed3111e2fb2752b6f4c26df540aedc");
		ItemMeta dropper2Meta = dropper2.getItemMeta();
		dropper2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dropper-2.name")));
		dropper2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dropper-2.lores")));
		dropper2.setItemMeta(dropper2Meta);
		
		addItem(dropper2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneTorch = SkullItem.getSkull("http://textures.minecraft.net/texture/c2b0a2709ad27c5783ba7acbdae8787d17673f0888f1b6d4e24ee13298d4");
		ItemMeta redstoneTorchMeta = redstoneTorch.getItemMeta();
		redstoneTorchMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-torch.name")));
		redstoneTorchMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-torch.lores")));
		redstoneTorch.setItemMeta(redstoneTorchMeta);
		
		addItem(redstoneTorch, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneTorch2 = SkullItem.getSkull("http://textures.minecraft.net/texture/5c9e37f599c55698d3873c8714d9f3a408751c01271a789e2ce3e7e9a2dc4");
		ItemMeta redstoneTorch2Meta = redstoneTorch2.getItemMeta();
		redstoneTorch2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-torch-2.name")));
		redstoneTorch2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-torch-2.lores")));
		redstoneTorch2.setItemMeta(redstoneTorch2Meta);
		
		addItem(redstoneTorch2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/d08ee6edfa98db5eae9b9c9936e94489b2d4bbbd3d2b4b6b4885a32240613c");
		ItemMeta redstoneBlockMeta = redstoneBlock.getItemMeta();
		redstoneBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-block.name")));
		redstoneBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-block.lores")));
		redstoneBlock.setItemMeta(redstoneBlockMeta);
		
		addItem(redstoneBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack tnt = SkullItem.getSkull("http://textures.minecraft.net/texture/d08ee6edfa98db5eae9b9c9936e94489b2d4bbbd3d2b4b6b4885a32240613c");
		ItemMeta tntMeta = tnt.getItemMeta();
		tntMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.tnt.name")));
		tntMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.tnt.lores")));
		tnt.setItemMeta(tntMeta);
		
		addItem(tnt, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack tnt2 = SkullItem.getSkull("http://textures.minecraft.net/texture/eb994b41f07f87b328186acfcbdabc699d5b1847fabb2e49d5abc27865143a4e");
		ItemMeta tnt2Meta = tnt2.getItemMeta();
		tnt2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.tnt-2.name")));
		tnt2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.tnt-2.lores")));
		tnt2.setItemMeta(tnt2Meta);
		
		addItem(tnt2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack jukebox = SkullItem.getSkull("http://textures.minecraft.net/texture/6de4b53b78ec1c74d5b01f7f3b55832892b047fac155f534a74e717821c2ad");
		ItemMeta jukeboxMeta = jukebox.getItemMeta();
		jukeboxMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.jukebox.name")));
		jukeboxMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.jukebox.lores")));
		jukebox.setItemMeta(jukeboxMeta);
		
		addItem(jukebox, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack jukebox2 = SkullItem.getSkull("http://textures.minecraft.net/texture/cc7d1b18398acd6e7e692a833a2217aea6b5a770f42c43513e4358cacd1b9c");
		ItemMeta jukebox2Meta = jukebox2.getItemMeta();
		jukebox2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.jukebox-2.name")));
		jukebox2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.jukebox-2.lores")));
		jukebox2.setItemMeta(jukebox2Meta);
		
		addItem(jukebox2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sponge = SkullItem.getSkull("http://textures.minecraft.net/texture/9613fdab43d76838b7b8c19244163f1765db874bdf151696bdcb654eb2e52");
		ItemMeta spongeMeta = sponge.getItemMeta();
		spongeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.sponge.name")));
		spongeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.sponge.lores")));
		sponge.setItemMeta(spongeMeta);
		
		addItem(sponge, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mossyStoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/6748ea7080afcdf07b1510fdce777665a76a6c6e2c166d39e1c345a6bb9c5f1e");
		ItemMeta mossyStoneBrickMeta = mossyStoneBrick.getItemMeta();
		mossyStoneBrickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.mossy-stone-brick.name")));
		mossyStoneBrickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.mossy-stone-brick.lores")));
		mossyStoneBrick.setItemMeta(mossyStoneBrickMeta);
		
		addItem(mossyStoneBrick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hydratedFarmland = SkullItem.getSkull("http://textures.minecraft.net/texture/9a656926adcd507ff079ce42f5177435c28ef369359cf7ca6f9d825f5767db");
		ItemMeta hydratedFarmlandMeta = hydratedFarmland.getItemMeta();
		hydratedFarmlandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.hydrated-farmland.name")));
		hydratedFarmlandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.hydrated-farmland.lores")));
		hydratedFarmland.setItemMeta(hydratedFarmlandMeta);
		
		addItem(hydratedFarmland, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack prismarine = SkullItem.getSkull("http://textures.minecraft.net/texture/97e56140686e476aef5520acbabc239535ff97e24b14d87f4982f13675c");
		ItemMeta prismarineMeta = prismarine.getItemMeta();
		prismarineMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.prismarine.name")));
		prismarineMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.prismarine.lores")));
		prismarine.setItemMeta(prismarineMeta);
		
		addItem(prismarine, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack enchantmentTable = SkullItem.getSkull("http://textures.minecraft.net/texture/1762a15b04692a2e4b3fb3663bd4b78434dce1732b8eb1c7a9f7c0fbf6f");
		ItemMeta enchantmentTableMeta = enchantmentTable.getItemMeta();
		enchantmentTableMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.enchantment-table.name")));
		enchantmentTableMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.enchantment-table.lores")));
		enchantmentTable.setItemMeta(enchantmentTableMeta);
		
		addItem(enchantmentTable, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cocoaPod = SkullItem.getSkull("http://textures.minecraft.net/texture/5083ec2b01dc0fee79aa32188d9429acc68ecf71408dca04aaab53ad8bea0");
		ItemMeta cocoaPodMeta = cocoaPod.getItemMeta();
		cocoaPodMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.cocoa-pod.name")));
		cocoaPodMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.cocoa-pod.lores")));
		cocoaPod.setItemMeta(cocoaPodMeta);
		
		addItem(cocoaPod, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack commandBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/8514d225b262d847c7e557b474327dcef758c2c5882e41ee6d8c5e9cd3bc914");
		ItemMeta commandBlockMeta = commandBlock.getItemMeta();
		commandBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.command-block.name")));
		commandBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.command-block.lores")));
		commandBlock.setItemMeta(commandBlockMeta);
		
		addItem(commandBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack prismarineBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/37cba233ffc457b3305228b25f35c02335611c9efb76698b5e94c0d541b5f4");
		ItemMeta prismarineBrickMeta = prismarineBrick.getItemMeta();
		prismarineBrickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.prismarine-brick.name")));
		prismarineBrickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.prismarine-brick.lores")));
		prismarineBrick.setItemMeta(prismarineBrickMeta);
		
		addItem(prismarineBrick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hayBale = SkullItem.getSkull("http://textures.minecraft.net/texture/4e3ca5b390d1e5f297283257ce90ac6f8783d786ecaee095b49cc6b944d72d");
		ItemMeta hayBaleMeta = hayBale.getItemMeta();
		hayBaleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.hay-bale.name")));
		hayBaleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.hay-bale.lores")));
		hayBale.setItemMeta(hayBaleMeta);
		
		addItem(hayBale, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hayBale2 = SkullItem.getSkull("http://textures.minecraft.net/texture/51ac5c4ef7501ab1eb9a2789ad6e65acdf6a27318d8de5356fe2475173a618f");
		ItemMeta hayBale2Meta = hayBale2.getItemMeta();
		hayBale2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.hay-bale-2.name")));
		hayBale2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.hay-bale-2.lores")));
		hayBale2.setItemMeta(hayBale2Meta);
		
		addItem(hayBale2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack glowstone = SkullItem.getSkull("http://textures.minecraft.net/texture/65d7bed8df714cea063e457ba5e87931141de293dd1d9b9146b0f5ab383866");
		ItemMeta glowstoneMeta = glowstone.getItemMeta();
		glowstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.glowstone.name")));
		glowstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.glowstone.lores")));
		glowstone.setItemMeta(glowstoneMeta);
		
		addItem(glowstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gravel = SkullItem.getSkull("http://textures.minecraft.net/texture/f32a1a50bbe431dc2ff71e8b26bb6dea155f72e2f469dda14f108c6083a7ecda");
		ItemMeta gravelMeta = gravel.getItemMeta();
		gravelMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.gravel.name")));
		gravelMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.gravel.lores")));
		gravel.setItemMeta(gravelMeta);
		
		addItem(gravel, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack greenWool = SkullItem.getSkull("http://textures.minecraft.net/texture/484684344ae098529fc941aa84e195bdca3748d69acfee2bac1332135edd98c");
		ItemMeta greenWoolMeta = greenWool.getItemMeta();
		greenWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.green-wool.name")));
		greenWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.green-wool.lores")));
		greenWool.setItemMeta(greenWoolMeta);
		
		addItem(greenWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack grayWool = SkullItem.getSkull("http://textures.minecraft.net/texture/e9e6917f2fb4ea08e7132df30961d2b5c523abba19ce43f835fc14c568f4");
		ItemMeta grayWoolMeta = grayWool.getItemMeta();
		grayWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.gray-wool.name")));
		grayWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.gray-wool.lores")));
		grayWool.setItemMeta(grayWoolMeta);
		
		addItem(grayWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack granite = SkullItem.getSkull("http://textures.minecraft.net/texture/a0285bea3c8a02db139fa8ec5cc588615a98550725f8e676c93fdbc33b6b");
		ItemMeta graniteMeta = granite.getItemMeta();
		graniteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.granite.name")));
		graniteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.granite.lores")));
		granite.setItemMeta(graniteMeta);
		
		addItem(granite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack polishedGranite = SkullItem.getSkull("http://textures.minecraft.net/texture/9ae4cf22f45bb77aefa5afa1f864dd3c5f9d3e92f43b3588fd162b2aa8c");
		ItemMeta polishedGraniteMeta = polishedGranite.getItemMeta();
		polishedGraniteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.polished-granite.name")));
		polishedGraniteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.polished-granite.lores")));
		polishedGranite.setItemMeta(polishedGraniteMeta);
		
		addItem(polishedGranite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack diorite = SkullItem.getSkull("http://textures.minecraft.net/texture/13fa5265a336abde301a9d59af4783e82a10dad0817716ead2962ab7c6d3dff");
		ItemMeta dioriteMeta = diorite.getItemMeta();
		dioriteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.diorite.name")));
		dioriteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.diorite.lores")));
		diorite.setItemMeta(dioriteMeta);
		
		addItem(diorite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack polishedDiorite = SkullItem.getSkull("http://textures.minecraft.net/texture/31a281f4945286c31fa077121f9b32c588fb94064de7f908cf0e9677cdda8b1");
		ItemMeta polishedDioriteMeta = polishedDiorite.getItemMeta();
		polishedDioriteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.polished-diorite.name")));
		polishedDioriteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.polished-diorite.lores")));
		polishedDiorite.setItemMeta(polishedDioriteMeta);
		
		addItem(polishedDiorite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack andesite = SkullItem.getSkull("http://textures.minecraft.net/texture/b513543a77118f8201f49b7c8b632dcfd38037ebfc601a1bc91aedc4caba");
		ItemMeta andesiteMeta = andesite.getItemMeta();
		andesiteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.andesite.name")));
		andesiteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.andesite.lores")));
		andesite.setItemMeta(andesiteMeta);
		
		addItem(andesite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack polishedAndesite = SkullItem.getSkull("http://textures.minecraft.net/texture/ca979f76633f5dda89496511716948e9d7b8592f6e1e480c5de1c83238d3e32");
		ItemMeta polishedAndesiteMeta = polishedAndesite.getItemMeta();
		polishedAndesiteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.polished-andesite.name")));
		polishedAndesiteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.polished-andesite.lores")));
		polishedAndesite.setItemMeta(polishedAndesiteMeta);
		
		addItem(polishedAndesite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack wetSponge = SkullItem.getSkull("http://textures.minecraft.net/texture/c28bdd34810f866527daaf283da71826a8378286b2a43a626615fa1b3639e");
		ItemMeta wetSpongeMeta = wetSponge.getItemMeta();
		wetSpongeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.wet-sponge.name")));
		wetSpongeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.wet-sponge.lores")));
		wetSponge.setItemMeta(wetSpongeMeta);
		
		addItem(wetSponge, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lapisLazuliBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/2d848dc6f694cbf35441722b1a27a195da56e4960231824fd7ec5b1315cc2a");
		ItemMeta lapisLazuliBlockMeta = lapisLazuliBlock.getItemMeta();
		lapisLazuliBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.lapis-lazuli-block.name")));
		lapisLazuliBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.lapis-lazuli-block.lores")));
		lapisLazuliBlock.setItemMeta(lapisLazuliBlockMeta);
		
		addItem(lapisLazuliBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lapisLazuliOre = SkullItem.getSkull("http://textures.minecraft.net/texture/2aa0d0fea1afaee334cab4d29d869652f5563c635253c0cbed797ed3cf57de0");
		ItemMeta lapisLazuliOreMeta = lapisLazuliOre.getItemMeta();
		lapisLazuliOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.lapis-lazuli-ore.name")));
		lapisLazuliOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.lapis-lazuli-ore.lores")));
		lapisLazuliOre.setItemMeta(lapisLazuliOreMeta);
		
		addItem(lapisLazuliOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/cf38117c157f2cce27f566fb6242ddcc34dabc39cdd1d54e66128a4ec8a3ca4c");
		ItemMeta sandstoneMeta = sandstone.getItemMeta();
		sandstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.sandstone.name")));
		sandstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.sandstone.lores")));
		sandstone.setItemMeta(sandstoneMeta);
		
		addItem(sandstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack smoothSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/d36e9862832a6fcc4855fa79c1aae5e73b9197ec6bbd38f6312efac680c63285");
		ItemMeta smoothSandstoneMeta = smoothSandstone.getItemMeta();
		smoothSandstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.smooth-sandstone.name")));
		smoothSandstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.smooth-sandstone.lores")));
		smoothSandstone.setItemMeta(smoothSandstoneMeta);
		
		addItem(smoothSandstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cyanWool = SkullItem.getSkull("http://textures.minecraft.net/texture/88efad74b254e57c799763dceee4511fa2f85ae9fa556eaa97d45bf67e0b6b3");
		ItemMeta cyanWoolMeta = cyanWool.getItemMeta();
		cyanWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.cyan-wool.name")));
		cyanWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.cyan-wool.lores")));
		cyanWool.setItemMeta(cyanWoolMeta);
		
		addItem(cyanWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brownWool = SkullItem.getSkull("http://textures.minecraft.net/texture/32e36f6a654de74583d8030177ad6e3ac6755d7435d9123e8ebdff74b2d90cb");
		ItemMeta brownWoolMeta = brownWool.getItemMeta();
		brownWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.brown-wool.name")));
		brownWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.brown-wool.lores")));
		brownWool.setItemMeta(brownWoolMeta);
		
		addItem(brownWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lightBlueWool = SkullItem.getSkull("http://textures.minecraft.net/texture/f1af46febd45c0f4d81e8fa1b66b275d89e272b2ad55c978553a99c733e1ff");
		ItemMeta lightBlueWoolMeta = lightBlueWool.getItemMeta();
		lightBlueWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.light-blue-wool.name")));
		lightBlueWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.light-blue-wool.lores")));
		lightBlueWool.setItemMeta(lightBlueWoolMeta);
		
		addItem(lightBlueWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack limeWool = SkullItem.getSkull("http://textures.minecraft.net/texture/d67470a0c18f6851e914353719e795877d29b3252f7e6bd4a1b865765bd74feb");
		ItemMeta limeWoolMeta = limeWool.getItemMeta();
		limeWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.lime-wool.name")));
		limeWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.lime-wool.lores")));
		limeWool.setItemMeta(limeWoolMeta);
		
		addItem(limeWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack magentaWool = SkullItem.getSkull("http://textures.minecraft.net/texture/abb4386bcda84e353c31d778d3b11bcd26fea494dd63496b8a82c7c78a4ad");
		ItemMeta magentaWoolMeta = magentaWool.getItemMeta();
		magentaWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.magenta-wool.name")));
		magentaWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.magenta-wool.lores")));
		magentaWool.setItemMeta(magentaWoolMeta);
		
		addItem(magentaWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack orangeWool = SkullItem.getSkull("http://textures.minecraft.net/texture/cbf7797a24a6af875f5c8271c5b8c425e19f372a415e0552fc247763f2859d1");
		ItemMeta orangeWoolMeta = orangeWool.getItemMeta();
		orangeWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.orange-wool.name")));
		orangeWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.orange-wool.lores")));
		orangeWool.setItemMeta(orangeWoolMeta);
		
		addItem(orangeWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pinkWool = SkullItem.getSkull("http://textures.minecraft.net/texture/6becfb3879936b899e420bfcd3a74f8a1bf9dd54c58ec7fb9f81d9a5d988e");
		ItemMeta pinkWoolMeta = pinkWool.getItemMeta();
		pinkWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.pink-wool.name")));
		pinkWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.pink-wool.lores")));
		pinkWool.setItemMeta(pinkWoolMeta);
		
		addItem(pinkWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack purpleWool = SkullItem.getSkull("http://textures.minecraft.net/texture/ba94cb25de628ca359b2f6ea5a8868cbe26595eedb2bffb750967ad1ee1850");
		ItemMeta purpleWoolMeta = purpleWool.getItemMeta();
		purpleWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.purple-wool.name")));
		purpleWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.purple-wool.lores")));
		purpleWool.setItemMeta(purpleWoolMeta);
		
		addItem(purpleWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redWool = SkullItem.getSkull("http://textures.minecraft.net/texture/86d35a963d5987894b6bc214e328b39cd2382426ff9c8e082b0b6a6e044d3a3");
		ItemMeta redWoolMeta = redWool.getItemMeta();
		redWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.red-wool.name")));
		redWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.red-wool.lores")));
		redWool.setItemMeta(redWoolMeta);
		
		addItem(redWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lightGrayWool = SkullItem.getSkull("http://textures.minecraft.net/texture/998ba2b374cfc89454c1b8c32db458a270675439a495496c96771c989116162");
		ItemMeta lightGrayWoolMeta = lightGrayWool.getItemMeta();
		lightGrayWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.light-gray-wool.name")));
		lightGrayWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.light-gray-wool.lores")));
		lightGrayWool.setItemMeta(lightGrayWoolMeta);
		
		addItem(lightGrayWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack whiteWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3faf4c29f1e7405f4680c5c2b03ef9384f1aecfe2986ad50138c605fefff2f15");
		ItemMeta whiteWoolMeta = whiteWool.getItemMeta();
		whiteWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.white-wool.name")));
		whiteWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.white-wool.lores")));
		whiteWool.setItemMeta(whiteWoolMeta);
		
		addItem(whiteWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, event -> {
            open((Player) event.getWhoClicked());

            event.setCancelled(true);
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.close.name")));
		close2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.close.lores")));
		close2.setItemMeta(close2Meta);
		
		setItem(close2, event -> {
            Player player = (Player) event.getWhoClicked();

            player.closeInventory();
            removePlayer(player);

            event.setCancelled(true);
		}, 103);
		
		//next page
		ItemStack next2 = new ItemStack(Material.SUGAR_CANE);
		ItemMeta next2Meta = next2.getItemMeta();
		next2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.next-page.name")));
		next2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.next-page.lores")));
		next2.setItemMeta(next2Meta);
		
		setItem(next2, event -> {
            open((Player) event.getWhoClicked(), 3);

            event.setCancelled(true);
		}, 105);
		
		setStartingPoint(108);
		
		//page three
		ItemStack yellowWool = SkullItem.getSkull("http://textures.minecraft.net/texture/27bbd0b2911c96b5d87b2df76691a51b8b12c6fefd523146d8ac5ef1b8ee");
		ItemMeta yellowWoolMeta = yellowWool.getItemMeta();
		yellowWoolMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.yellow-wool.name")));
		yellowWoolMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.yellow-wool.lores")));
		yellowWool.setItemMeta(yellowWoolMeta);
		
		addItem(yellowWool, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack crackedStoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/39a46b2ab32f216e2d922c7237ba2319f91b71fa24fe451ad2ca81423ea3c8");
		ItemMeta crackedStoneBrickMeta = crackedStoneBrick.getItemMeta();
		crackedStoneBrickMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.cracked-stone-brick.name")));
		crackedStoneBrickMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.cracked-stone-brick.lores")));
		crackedStoneBrick.setItemMeta(crackedStoneBrickMeta);
		
		addItem(crackedStoneBrick, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mossyStoneBrick2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7237333339cbc6b469452c96211fa23e1951e8795076f9eed96a13824a879");
		ItemMeta mossyStoneBrick2Meta = mossyStoneBrick2.getItemMeta();
		mossyStoneBrick2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.mossy-stone-brick-2.name")));
		mossyStoneBrick2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.mossy-stone-brick-2.lores")));
		mossyStoneBrick2.setItemMeta(mossyStoneBrick2Meta);
		
		addItem(mossyStoneBrick2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack stoneSlab = SkullItem.getSkull("http://textures.minecraft.net/texture/8dd0cd158c2bb6618650e3954b2d29237f5b4c0ddc7d258e17380ab6979f071");
		ItemMeta stoneSlabMeta = stoneSlab.getItemMeta();
		stoneSlabMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.stone-slab.name")));
		stoneSlabMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.stone-slab.lores")));
		stoneSlab.setItemMeta(stoneSlabMeta);
		
		addItem(stoneSlab, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack snowBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/5dd6fe267a418dcc7f37a8f76855b5328b1303897b342a107cf162f14fe3d");
		ItemMeta snowBlockMeta = snowBlock.getItemMeta();
		snowBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.snow-block.name")));
		snowBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.snow-block.lores")));
		snowBlock.setItemMeta(snowBlockMeta);
		
		addItem(snowBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack slimeBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/90e65e6e5113a5187dad46dfad3d3bf85e8ef807f82aac228a59c4a95d6f6a");
		ItemMeta slimeBlockMeta = slimeBlock.getItemMeta();
		slimeBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.slime-block.name")));
		slimeBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.slime-block.lores")));
		slimeBlock.setItemMeta(slimeBlockMeta);
		
		addItem(slimeBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack obsidian = SkullItem.getSkull("http://textures.minecraft.net/texture/7840b87d52271d2a755dedc82877e0ed3df67dcc42ea479ec146176b02779a5");
		ItemMeta obsidianMeta = obsidian.getItemMeta();
		obsidianMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.obsidian.name")));
		obsidianMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.obsidian.lores")));
		obsidian.setItemMeta(obsidianMeta);
		
		addItem(obsidian, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack smoothRedSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/a2da7aa1ae6cc9d6c36c18a460d2398162edc2207fdfc9e28a7bf84d7441b8a2");
		ItemMeta smoothRedSandstoneMeta = smoothRedSandstone.getItemMeta();
		smoothRedSandstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.smooth-red-sandstone.name")));
		smoothRedSandstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.smooth-red-sandstone.lores")));
		smoothRedSandstone.setItemMeta(smoothRedSandstoneMeta);
		
		addItem(smoothRedSandstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/db31be197ac7d78b30c34dac2665dbf1a74f96a79e52cb8ed5088ad70ee9348");
		ItemMeta redSandstoneMeta = redSandstone.getItemMeta();
		redSandstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.red-sandstone.name")));
		redSandstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.red-sandstone.lores")));
		redSandstone.setItemMeta(redSandstoneMeta);
		
		addItem(redSandstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack noteBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/4ceeb77d4d25724a9caf2c7cdf2d88399b1417c6b9ff5213659b653be4376e3");
		ItemMeta noteBlockMeta = noteBlock.getItemMeta();
		noteBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.note-block.name")));
		noteBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.note-block.lores")));
		noteBlock.setItemMeta(noteBlockMeta);
		
		addItem(noteBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack packedIceBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/56aab58fa01fce9af469ed747aed811d7ba18c476f5a7f9088e129c31b45f3");
		ItemMeta packedIceBlockMeta = packedIceBlock.getItemMeta();
		packedIceBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.packed-ice-block.name")));
		packedIceBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.packed-ice-block.lores")));
		packedIceBlock.setItemMeta(packedIceBlockMeta);
		
		addItem(packedIceBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack netherPortal = SkullItem.getSkull("http://textures.minecraft.net/texture/b0bfc2577f6e26c6c6f7365c2c4076bccee653124989382ce93bca4fc9e39b");
		ItemMeta netherPortalMeta = netherPortal.getItemMeta();
		netherPortalMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.nether-portal.name")));
		netherPortalMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.nether-portal.lores")));
		netherPortal.setItemMeta(netherPortalMeta);
		
		addItem(netherPortal, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack endStone = SkullItem.getSkull("http://textures.minecraft.net/texture/19f21f5d883316fd65a9366f32a33013182e3381dec21c17c78355d9bf4f0");
		ItemMeta endStoneMeta = endStone.getItemMeta();
		endStoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.end-stone.name")));
		endStoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.end-stone.lores")));
		endStone.setItemMeta(endStoneMeta);
		
		addItem(endStone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mossyCobblestone = SkullItem.getSkull("http://textures.minecraft.net/texture/4d9238efc93493b14a582639eb0aa8834eaa48e10bd4c234eb1a4c363b43d5b");
		ItemMeta mossyCobblestoneMeta = mossyCobblestone.getItemMeta();
		mossyCobblestoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.mossy-cobblestone.name")));
		mossyCobblestoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.mossy-cobblestone.lores")));
		mossyCobblestone.setItemMeta(mossyCobblestoneMeta);
		
		addItem(mossyCobblestone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brick2 = SkullItem.getSkull("http://textures.minecraft.net/texture/5ec0ebea1821c292fdff45d359b3a9e2122717e83d55dc07fc3bb1ce32935e");
		ItemMeta brick2Meta = brick2.getItemMeta();
		brick2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.brick.name")));
		brick2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.brick.lores")));
		brick2.setItemMeta(brick2Meta);
		
		addItem(brick2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack clay = SkullItem.getSkull("http://textures.minecraft.net/texture/67826829eab5ad62f0c11d9faafdc9954364871160dd839e1ab5a3b213a33");
		ItemMeta clayMeta = clay.getItemMeta();
		clayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.clay.name")));
		clayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.clay.lores")));
		clay.setItemMeta(clayMeta);
		
		addItem(clay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack coalOre = SkullItem.getSkull("http://textures.minecraft.net/texture/7788f5ddaf52c5842287b9427a74dac8f0919eb2fdb1b51365ab25eb392c47");
		ItemMeta coalOreMeta = coalOre.getItemMeta();
		coalOreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.coal-ore.name")));
		coalOreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.coal-ore.lores")));
		coalOre.setItemMeta(coalOreMeta);
		
		addItem(coalOre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack coalBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/f6c5ecac942c77b95ab4620df5b85e38064c974f9c5c576b843622806a4557");
		ItemMeta coalBlockMeta = coalBlock.getItemMeta();
		coalBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.coal-block.name")));
		coalBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.coal-block.lores")));
		coalBlock.setItemMeta(coalBlockMeta);
		
		addItem(coalBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack darkPrismarine = SkullItem.getSkull("http://textures.minecraft.net/texture/fd918598989549594446e83f33873891178da9db42f912e5272e1fb240312a");
		ItemMeta darkPrismarineMeta = darkPrismarine.getItemMeta();
		darkPrismarineMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dark-prismarine.name")));
		darkPrismarineMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dark-prismarine.lores")));
		darkPrismarine.setItemMeta(darkPrismarineMeta);
		
		addItem(darkPrismarine, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dispenser = SkullItem.getSkull("http://textures.minecraft.net/texture/e82e6aa950117384eb4bf55217283a78f57b8c85c089aad03bac5caa83c3020");
		ItemMeta dispenserMeta = dispenser.getItemMeta();
		dispenserMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dispenser.name")));
		dispenserMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dispenser.lores")));
		dispenser.setItemMeta(dispenserMeta);
		
		addItem(dispenser, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack beacon = SkullItem.getSkull("http://textures.minecraft.net/texture/9dbdaa755099edd7efa1f12882c7a51b5815db52e0b164aef6df9a1f53eca23");
		ItemMeta beaconMeta = beacon.getItemMeta();
		beaconMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.beacon.name")));
		beaconMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.beacon.lores")));
		beacon.setItemMeta(beaconMeta);
		
		addItem(beacon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pillarQuartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/61fab0225e20e8458e8b75399713388d929856b551b0149081dbb0121e2a1664");
		ItemMeta pillarQuartzBlockMeta = pillarQuartzBlock.getItemMeta();
		pillarQuartzBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.pillar-quartz-block.name")));
		pillarQuartzBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.pillar-quartz-block.lores")));
		pillarQuartzBlock.setItemMeta(pillarQuartzBlockMeta);
		
		addItem(pillarQuartzBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack chiseledQuartzBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/852cf1aef4b6adbc38f196dfba536db5a0b068f1ab91769ad8c6d2f74d3a5d4e");
		ItemMeta chiseledQuartzBlockMeta = chiseledQuartzBlock.getItemMeta();
		chiseledQuartzBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.chiseled-quartz-block.name")));
		chiseledQuartzBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.chiseled-quartz-block.lores")));
		chiseledQuartzBlock.setItemMeta(chiseledQuartzBlockMeta);
		
		addItem(chiseledQuartzBlock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack seaLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/824c6ff1714eb2c3b844d46d2e5ea2f26d273a33eaaa744abf645b060b47d7");
		ItemMeta seaLanternMeta = seaLantern.getItemMeta();
		seaLanternMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.sea-lantern.name")));
		seaLanternMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.sea-lantern.lores")));
		seaLantern.setItemMeta(seaLanternMeta);
		
		addItem(seaLantern, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dryFarmland = SkullItem.getSkull("http://textures.minecraft.net/texture/11530f790e972e0bcc63a54dc55532902568def8dedf2e22e759bbcbc55c0");
		ItemMeta dryFarmlandMeta = dryFarmland.getItemMeta();
		dryFarmlandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.dry-farmland.name")));
		dryFarmlandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.dry-farmland.lores")));
		dryFarmland.setItemMeta(dryFarmlandMeta);
		
		addItem(dryFarmland, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack coarseDirt = SkullItem.getSkull("http://textures.minecraft.net/texture/2fa764b3c1d462f8124478ff543c7633fa19baf9913ee228513e81a3633d");
		ItemMeta coarseDirtMeta = coarseDirt.getItemMeta();
		coarseDirtMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.coarse-dirt.name")));
		coarseDirtMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.coarse-dirt.lores")));
		coarseDirt.setItemMeta(coarseDirtMeta);
		
		addItem(coarseDirt, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redstoneLampOff = SkullItem.getSkull("http://textures.minecraft.net/texture/bd58d459165d5978753eab5f44bd609f3db84ee3bb016932052389d38b895");
		ItemMeta redstoneLampOffMeta = redstoneLampOff.getItemMeta();
		redstoneLampOffMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.redstone-lamp-off.name")));
		redstoneLampOffMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.redstone-lamp-off.lores")));
		redstoneLampOff.setItemMeta(redstoneLampOffMeta);
		
		addItem(redstoneLampOff, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hardenedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/82d5fefe20daf31c238ee227dd141827ada5ef8482d8d357bbe5a7cf40af85");
		ItemMeta hardenedClayMeta = hardenedClay.getItemMeta();
		hardenedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.hardened-clay.name")));
		hardenedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.hardened-clay.lores")));
		hardenedClay.setItemMeta(hardenedClayMeta);
		
		addItem(hardenedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blackStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/e17ff8babb91b4dbad7524e58eed4b2f71565745989af9a2ccfcf3328f61bd2");
		ItemMeta blackStainedClayMeta = blackStainedClay.getItemMeta();
		blackStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.black-stained-clay.name")));
		blackStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.black-stained-clay.lores")));
		blackStainedClay.setItemMeta(blackStainedClayMeta);
		
		addItem(blackStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blueStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7c116694731fbd272c1ffa4352a5359b6c3a4cb5864a74a5dbe0f665f8385c");
		ItemMeta blueStainedClayMeta = blueStainedClay.getItemMeta();
		blueStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.blue-stained-clay.name")));
		blueStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.blue-stained-clay.lores")));
		blueStainedClay.setItemMeta(blueStainedClayMeta);
		
		addItem(blueStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brownStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/54b932f117c87e11189f1c4c40cfd92be9119b1137cd610c68edd41ac58f14");
		ItemMeta brownStainedClayMeta = brownStainedClay.getItemMeta();
		brownStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.brown-stained-clay.name")));
		brownStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.brown-stained-clay.lores")));
		brownStainedClay.setItemMeta(brownStainedClayMeta);
		
		addItem(brownStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cyanStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/4463811fd0c48fcd73abcb7bbe5aa5ec6bc2809ffc5577d3f4559df30765f");
		ItemMeta cyanStainedClayMeta = cyanStainedClay.getItemMeta();
		cyanStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.cyan-stained-clay.name")));
		cyanStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.cyan-stained-clay.lores")));
		cyanStainedClay.setItemMeta(cyanStainedClayMeta);
		
		addItem(cyanStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack grayStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/9efa7b5e5e63d46d14615c61bed15427d90b261c7ca5e8159c466f09561da");
		ItemMeta grayStainedClayMeta = grayStainedClay.getItemMeta();
		grayStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.gray-stained-clay.name")));
		grayStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.gray-stained-clay.lores")));
		grayStainedClay.setItemMeta(grayStainedClayMeta);
		
		addItem(grayStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack greenStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/b55d5019c8d55bcb9dc3494ccc3419757f89c3384cf3c9abec3f18831f35b0");
		ItemMeta greenStainedClayMeta = greenStainedClay.getItemMeta();
		greenStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.green-stained-clay.name")));
		greenStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.green-stained-clay.lores")));
		greenStainedClay.setItemMeta(greenStainedClayMeta);
		
		addItem(greenStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack limeStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/55a117e161f7a291d0a3a168e77a21b09d39ffdf5773d22ac02f5fa6611db67");
		ItemMeta limeStainedClayMeta = limeStainedClay.getItemMeta();
		limeStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.lime-stained-clay.name")));
		limeStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.lime-stained-clay.lores")));
		limeStainedClay.setItemMeta(limeStainedClayMeta);
		
		addItem(limeStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack magentaStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/3441528d288b2b79736cb2248878fb91efb4462d43bebd711f7326afbbf85");
		ItemMeta magentaStainedClayMeta = magentaStainedClay.getItemMeta();
		magentaStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.magenta-stained-clay.name")));
		magentaStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.magenta-stained-clay.lores")));
		magentaStainedClay.setItemMeta(magentaStainedClayMeta);
		
		addItem(magentaStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack orangeStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7316c16b1ac470d2c114434ff8730f1815709383db6f3cf720c39b6dce2116");
		ItemMeta orangeStainedClayMeta = orangeStainedClay.getItemMeta();
		orangeStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.orange-stained-clay.name")));
		orangeStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.orange-stained-clay.lores")));
		orangeStainedClay.setItemMeta(orangeStainedClayMeta);
		
		addItem(orangeStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pinkStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/f75db81e1592f32d771dd5dbc6c3a51e7a0d66b22dfe296b96868505ceec");
		ItemMeta pinkStainedClayMeta = pinkStainedClay.getItemMeta();
		pinkStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.pink-stained-clay.name")));
		pinkStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.pink-stained-clay.lores")));
		pinkStainedClay.setItemMeta(pinkStainedClayMeta);
		
		addItem(pinkStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack redStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/9e42f682e430b55b61204a6f8b76d5227d278ed9ec4d98bda4a7a4830a4b6");
		ItemMeta redStainedClayMeta = redStainedClay.getItemMeta();
		redStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.red-stained-clay.name")));
		redStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.red-stained-clay.lores")));
		redStainedClay.setItemMeta(redStainedClayMeta);
		
		addItem(redStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack purpleStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/e6f54f82836a55924ee85dec56bbbd8ca14633daa9bfe3565592edf39a6de");
		ItemMeta purpleStainedClayMeta = purpleStainedClay.getItemMeta();
		purpleStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.purple-stained-clay.name")));
		purpleStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.purple-stained-clay.lores")));
		purpleStainedClay.setItemMeta(purpleStainedClayMeta);
		
		addItem(purpleStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack whiteStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/7159594388bf013a4e3e6869faabcb95d31dd3f4a258a535e7cbd92c9986b7");
		ItemMeta whiteStainedClayMeta = whiteStainedClay.getItemMeta();
		whiteStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.white-stained-clay.name")));
		whiteStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.white-stained-clay.lores")));
		whiteStainedClay.setItemMeta(whiteStainedClayMeta);
		
		addItem(whiteStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lightGrayStainedClay = SkullItem.getSkull("http://textures.minecraft.net/texture/5cde99b72728ef881640fa5068d122e61dd9cf718dbb3709fc5b326f1af5d");
		ItemMeta lightGrayStainedClayMeta = lightGrayStainedClay.getItemMeta();
		lightGrayStainedClayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.light-gray-stained-clay.name")));
		lightGrayStainedClayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.light-gray-stained-clay.lores")));
		lightGrayStainedClay.setItemMeta(lightGrayStainedClayMeta);
		
		addItem(lightGrayStainedClay, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack chiseledSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/491e7f9033765cec968f272fc58b7344c434a1721f9537b25a6aff4c24576c5");
		ItemMeta chiseledSandstoneMeta = chiseledSandstone.getItemMeta();
		chiseledSandstoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.chiseled-sandstone.name")));
		chiseledSandstoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.chiseled-sandstone.lores")));
		chiseledSandstone.setItemMeta(chiseledSandstoneMeta);
		
		addItem(chiseledSandstone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//previous page
		ItemStack previous3 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous3Meta = previous3.getItemMeta();
		previous3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.previous-page.name")));
		previous3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.previous-page.lores")));
		previous3.setItemMeta(previous3Meta);
		
		setItem(previous3, event -> {
            open((Player) event.getWhoClicked(), 2);

            event.setCancelled(true);
		}, 155);
		
		//close
		ItemStack close3 = new ItemStack(Material.BOOK);
		ItemMeta close3Meta = close3.getItemMeta();
		close3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.blocks.close.name")));
		close3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.blocks.close.lores")));
		close3.setItemMeta(close3Meta);
		
		setItem(close3, event -> {
            Player player = (Player) event.getWhoClicked();

            player.closeInventory();
            removePlayer(player);

            event.setCancelled(true);
		}, 157);
	}
}