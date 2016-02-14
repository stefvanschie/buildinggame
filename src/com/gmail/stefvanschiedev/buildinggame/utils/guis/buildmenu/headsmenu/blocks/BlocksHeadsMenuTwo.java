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

public class BlocksHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.blocks.page-2.title")));
		
		ItemStack dropper = SkullItem.getSkull("http://textures.minecraft.net/texture/25e9152efd892f60d7e0d7e53369e04779ed3111e2fb2752b6f4c26df540aedc");
		ItemMeta dropperMeta = dropper.getItemMeta();
		dropperMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.dropper.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.dropper.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dropperMeta.setLore(lores);
		}
		dropper.setItemMeta(dropperMeta);
		
		ItemStack redstoneTorch = SkullItem.getSkull("http://textures.minecraft.net/texture/c2b0a2709ad27c5783ba7acbdae8787d17673f0888f1b6d4e24ee13298d4");
		ItemMeta redstoneTorchMeta = redstoneTorch.getItemMeta();
		redstoneTorchMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.redstone-torch.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.redstone-torch.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redstoneTorchMeta.setLore(lores);
		}
		redstoneTorch.setItemMeta(redstoneTorchMeta);
		
		ItemStack redstoneTorch2 = SkullItem.getSkull("http://textures.minecraft.net/texture/5c9e37f599c55698d3873c8714d9f3a408751c01271a789e2ce3e7e9a2dc4");
		ItemMeta redstoneTorch2Meta = redstoneTorch2.getItemMeta();
		redstoneTorch2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.redstone-torch-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.redstone-torch-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redstoneTorch2Meta.setLore(lores);
		}
		redstoneTorch2.setItemMeta(redstoneTorch2Meta);
		
		ItemStack redstoneBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/d08ee6edfa98db5eae9b9c9936e94489b2d4bbbd3d2b4b6b4885a32240613c");
		ItemMeta redstoneBlockMeta = redstoneBlock.getItemMeta();
		redstoneBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.redstone-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.redstone-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redstoneBlockMeta.setLore(lores);
		}
		redstoneBlock.setItemMeta(redstoneBlockMeta);
		
		ItemStack tnt = SkullItem.getSkull("http://textures.minecraft.net/texture/d08ee6edfa98db5eae9b9c9936e94489b2d4bbbd3d2b4b6b4885a32240613c");
		ItemMeta tntMeta = tnt.getItemMeta();
		tntMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.tnt.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.tnt.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tntMeta.setLore(lores);
		}
		tnt.setItemMeta(tntMeta);
		
		ItemStack tnt2 = SkullItem.getSkull("http://textures.minecraft.net/texture/eb994b41f07f87b328186acfcbdabc699d5b1847fabb2e49d5abc27865143a4e");
		ItemMeta tnt2Meta = tnt2.getItemMeta();
		tnt2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.tnt-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.tnt-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tnt2Meta.setLore(lores);
		}
		tnt2.setItemMeta(tnt2Meta);
		
		ItemStack jukebox = SkullItem.getSkull("http://textures.minecraft.net/texture/6de4b53b78ec1c74d5b01f7f3b55832892b047fac155f534a74e717821c2ad");
		ItemMeta jukeboxMeta = jukebox.getItemMeta();
		jukeboxMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.jukebox.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.jukebox.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			jukeboxMeta.setLore(lores);
		}
		jukebox.setItemMeta(jukeboxMeta);
		
		ItemStack jukebox2 = SkullItem.getSkull("http://textures.minecraft.net/texture/cc7d1b18398acd6e7e692a833a2217aea6b5a770f42c43513e4358cacd1b9c");
		ItemMeta jukebox2Meta = jukebox2.getItemMeta();
		jukebox2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.jukebox-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.jukebox-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			jukebox2Meta.setLore(lores);
		}
		jukebox2.setItemMeta(jukebox2Meta);
		
		ItemStack sponge = SkullItem.getSkull("http://textures.minecraft.net/texture/9613fdab43d76838b7b8c19244163f1765db874bdf151696bdcb654eb2e52");
		ItemMeta spongeMeta = sponge.getItemMeta();
		spongeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.sponge.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.sponge.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			spongeMeta.setLore(lores);
		}
		sponge.setItemMeta(spongeMeta);
		
		ItemStack mossyStoneBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/6748ea7080afcdf07b1510fdce777665a76a6c6e2c166d39e1c345a6bb9c5f1e");
		ItemMeta mossyStoneBrickMeta = mossyStoneBrick.getItemMeta();
		mossyStoneBrickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.mossy-stone-brick.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.mossy-stone-brick.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mossyStoneBrickMeta.setLore(lores);
		}
		mossyStoneBrick.setItemMeta(mossyStoneBrickMeta);
		
		ItemStack hydratedFarmland = SkullItem.getSkull("http://textures.minecraft.net/texture/9a656926adcd507ff079ce42f5177435c28ef369359cf7ca6f9d825f5767db");
		ItemMeta hydratedFarmlandMeta = hydratedFarmland.getItemMeta();
		hydratedFarmlandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.hydrated-farmland.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.hydrated-farmland.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hydratedFarmlandMeta.setLore(lores);
		}
		hydratedFarmland.setItemMeta(hydratedFarmlandMeta);
		
		ItemStack prismarine = SkullItem.getSkull("http://textures.minecraft.net/texture/97e56140686e476aef5520acbabc239535ff97e24b14d87f4982f13675c");
		ItemMeta prismarineMeta = prismarine.getItemMeta();
		prismarineMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.prismarine.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.prismarine.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			prismarineMeta.setLore(lores);
		}
		prismarine.setItemMeta(prismarineMeta);
		
		ItemStack enchantmentTable = SkullItem.getSkull("http://textures.minecraft.net/texture/1762a15b04692a2e4b3fb3663bd4b78434dce1732b8eb1c7a9f7c0fbf6f");
		ItemMeta enchantmentTableMeta = enchantmentTable.getItemMeta();
		enchantmentTableMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.enchantment-table.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.enchantment-table.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			enchantmentTableMeta.setLore(lores);
		}
		enchantmentTable.setItemMeta(enchantmentTableMeta);
		
		ItemStack cocoaPod = SkullItem.getSkull("http://textures.minecraft.net/texture/5083ec2b01dc0fee79aa32188d9429acc68ecf71408dca04aaab53ad8bea0");
		ItemMeta cocoaPodMeta = cocoaPod.getItemMeta();
		cocoaPodMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.cocoa-pod.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.cocoa-pod.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cocoaPodMeta.setLore(lores);
		}
		cocoaPod.setItemMeta(cocoaPodMeta);
		
		ItemStack commandBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/8514d225b262d847c7e557b474327dcef758c2c5882e41ee6d8c5e9cd3bc914");
		ItemMeta commandBlockMeta = commandBlock.getItemMeta();
		commandBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.command-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.command-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			commandBlockMeta.setLore(lores);
		}
		commandBlock.setItemMeta(commandBlockMeta);
		
		ItemStack prismarineBrick = SkullItem.getSkull("http://textures.minecraft.net/texture/37cba233ffc457b3305228b25f35c02335611c9efb76698b5e94c0d541b5f4");
		ItemMeta prismarineBrickMeta = prismarineBrick.getItemMeta();
		prismarineBrickMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.prismarine-brick.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.prismarine-brick.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			prismarineBrickMeta.setLore(lores);
		}
		prismarineBrick.setItemMeta(prismarineBrickMeta);
		
		ItemStack hayBale = SkullItem.getSkull("http://textures.minecraft.net/texture/4e3ca5b390d1e5f297283257ce90ac6f8783d786ecaee095b49cc6b944d72d");
		ItemMeta hayBaleMeta = hayBale.getItemMeta();
		hayBaleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.hay-bale.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.hay-bale.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hayBaleMeta.setLore(lores);
		}
		hayBale.setItemMeta(hayBaleMeta);
		
		ItemStack hayBale2 = SkullItem.getSkull("http://textures.minecraft.net/texture/51ac5c4ef7501ab1eb9a2789ad6e65acdf6a27318d8de5356fe2475173a618f");
		ItemMeta hayBale2Meta = hayBale2.getItemMeta();
		hayBale2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.hay-bale-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.hay-bale-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hayBaleMeta.setLore(lores);
		}
		hayBale2.setItemMeta(hayBale2Meta);
		
		ItemStack glowstone = SkullItem.getSkull("http://textures.minecraft.net/texture/65d7bed8df714cea063e457ba5e87931141de293dd1d9b9146b0f5ab383866");
		ItemMeta glowstoneMeta = glowstone.getItemMeta();
		glowstoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.glowstone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.glowstone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			glowstoneMeta.setLore(lores);
		}
		glowstone.setItemMeta(glowstoneMeta);
		
		ItemStack gravel = SkullItem.getSkull("http://textures.minecraft.net/texture/f32a1a50bbe431dc2ff71e8b26bb6dea155f72e2f469dda14f108c6083a7ecda");
		ItemMeta gravelMeta = gravel.getItemMeta();
		gravelMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.gravel.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.gravel.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gravelMeta.setLore(lores);
		}
		gravel.setItemMeta(gravelMeta);
		
		ItemStack greenWool = SkullItem.getSkull("http://textures.minecraft.net/texture/484684344ae098529fc941aa84e195bdca3748d69acfee2bac1332135edd98c");
		ItemMeta greenWoolMeta = greenWool.getItemMeta();
		greenWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.green-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.green-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenWoolMeta.setLore(lores);
		}
		greenWool.setItemMeta(greenWoolMeta);
		
		ItemStack grayWool = SkullItem.getSkull("http://textures.minecraft.net/texture/e9e6917f2fb4ea08e7132df30961d2b5c523abba19ce43f835fc14c568f4");
		ItemMeta grayWoolMeta = grayWool.getItemMeta();
		grayWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.gray-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.gray-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			grayWoolMeta.setLore(lores);
		}
		grayWool.setItemMeta(grayWoolMeta);
		
		ItemStack granite = SkullItem.getSkull("http://textures.minecraft.net/texture/a0285bea3c8a02db139fa8ec5cc588615a98550725f8e676c93fdbc33b6b");
		ItemMeta graniteMeta = granite.getItemMeta();
		graniteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.granite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.granite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			graniteMeta.setLore(lores);
		}
		granite.setItemMeta(graniteMeta);
		
		ItemStack polishedGranite = SkullItem.getSkull("http://textures.minecraft.net/texture/9ae4cf22f45bb77aefa5afa1f864dd3c5f9d3e92f43b3588fd162b2aa8c");
		ItemMeta polishedGraniteMeta = polishedGranite.getItemMeta();
		polishedGraniteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.polished-granite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.polished-granite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			polishedGraniteMeta.setLore(lores);
		}
		polishedGranite.setItemMeta(polishedGraniteMeta);
		
		ItemStack diorite = SkullItem.getSkull("http://textures.minecraft.net/texture/13fa5265a336abde301a9d59af4783e82a10dad0817716ead2962ab7c6d3dff");
		ItemMeta dioriteMeta = diorite.getItemMeta();
		dioriteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.diorite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.diorite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dioriteMeta.setLore(lores);
		}
		diorite.setItemMeta(dioriteMeta);
		
		ItemStack polishedDiorite = SkullItem.getSkull("http://textures.minecraft.net/texture/31a281f4945286c31fa077121f9b32c588fb94064de7f908cf0e9677cdda8b1");
		ItemMeta polishedDioriteMeta = polishedDiorite.getItemMeta();
		polishedDioriteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.polished-diorite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.polished-diorite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			polishedDioriteMeta.setLore(lores);
		}
		polishedDiorite.setItemMeta(polishedDioriteMeta);
		
		ItemStack andesite = SkullItem.getSkull("http://textures.minecraft.net/texture/b513543a77118f8201f49b7c8b632dcfd38037ebfc601a1bc91aedc4caba");
		ItemMeta andesiteMeta = andesite.getItemMeta();
		andesiteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.andesite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.andesite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			andesiteMeta.setLore(lores);
		}
		andesite.setItemMeta(andesiteMeta);
		
		ItemStack polishedAndesite = SkullItem.getSkull("http://textures.minecraft.net/texture/ca979f76633f5dda89496511716948e9d7b8592f6e1e480c5de1c83238d3e32");
		ItemMeta polishedAndesiteMeta = polishedAndesite.getItemMeta();
		polishedAndesiteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.polished-andesite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.polished-andesite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			polishedAndesiteMeta.setLore(lores);
		}
		polishedAndesite.setItemMeta(polishedAndesiteMeta);
		
		ItemStack wetSponge = SkullItem.getSkull("http://textures.minecraft.net/texture/c28bdd34810f866527daaf283da71826a8378286b2a43a626615fa1b3639e");
		ItemMeta wetSpongeMeta = wetSponge.getItemMeta();
		wetSpongeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.wet-sponge.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.wet-sponge.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wetSpongeMeta.setLore(lores);
		}
		wetSponge.setItemMeta(wetSpongeMeta);
		
		ItemStack lapisLazuliBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/2d848dc6f694cbf35441722b1a27a195da56e4960231824fd7ec5b1315cc2a");
		ItemMeta lapisLazuliBlockMeta = lapisLazuliBlock.getItemMeta();
		lapisLazuliBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.lapis-lazuli-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.lapis-lazuli-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lapisLazuliBlockMeta.setLore(lores);
		}
		lapisLazuliBlock.setItemMeta(lapisLazuliBlockMeta);
		
		ItemStack lapisLazuliOre = SkullItem.getSkull("http://textures.minecraft.net/texture/2aa0d0fea1afaee334cab4d29d869652f5563c635253c0cbed797ed3cf57de0");
		ItemMeta lapisLazuliOreMeta = lapisLazuliOre.getItemMeta();
		lapisLazuliOreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.lapis-lazuli-ore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.lapis-lazuli-ore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lapisLazuliOreMeta.setLore(lores);
		}
		lapisLazuliOre.setItemMeta(lapisLazuliOreMeta);
		
		ItemStack sandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/cf38117c157f2cce27f566fb6242ddcc34dabc39cdd1d54e66128a4ec8a3ca4c");
		ItemMeta sandstoneMeta = sandstone.getItemMeta();
		sandstoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.sandstone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.sandstone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sandstoneMeta.setLore(lores);
		}
		sandstone.setItemMeta(sandstoneMeta);
		
		ItemStack smoothSandstone = SkullItem.getSkull("http://textures.minecraft.net/texture/d36e9862832a6fcc4855fa79c1aae5e73b9197ec6bbd38f6312efac680c63285");
		ItemMeta smoothSandstoneMeta = smoothSandstone.getItemMeta();
		smoothSandstoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.smooth-sandstone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.smooth-sandstone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			smoothSandstoneMeta.setLore(lores);
		}
		smoothSandstone.setItemMeta(smoothSandstoneMeta);
		
		ItemStack cyanWool = SkullItem.getSkull("http://textures.minecraft.net/texture/88efad74b254e57c799763dceee4511fa2f85ae9fa556eaa97d45bf67e0b6b3");
		ItemMeta cyanWoolMeta = cyanWool.getItemMeta();
		cyanWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.cyan-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.cyan-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cyanWoolMeta.setLore(lores);
		}
		cyanWool.setItemMeta(cyanWoolMeta);
		
		ItemStack brownWool = SkullItem.getSkull("http://textures.minecraft.net/texture/32e36f6a654de74583d8030177ad6e3ac6755d7435d9123e8ebdff74b2d90cb");
		ItemMeta brownWoolMeta = brownWool.getItemMeta();
		brownWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.brown-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.brown-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brownWoolMeta.setLore(lores);
		}
		brownWool.setItemMeta(brownWoolMeta);
		
		ItemStack lightBlueWool = SkullItem.getSkull("http://textures.minecraft.net/texture/f1af46febd45c0f4d81e8fa1b66b275d89e272b2ad55c978553a99c733e1ff");
		ItemMeta lightBlueWoolMeta = lightBlueWool.getItemMeta();
		lightBlueWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.light-blue-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.light-blue-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightBlueWoolMeta.setLore(lores);
		}
		lightBlueWool.setItemMeta(lightBlueWoolMeta);
		
		ItemStack limeWool = SkullItem.getSkull("http://textures.minecraft.net/texture/d67470a0c18f6851e914353719e795877d29b3252f7e6bd4a1b865765bd74feb");
		ItemMeta limeWoolMeta = limeWool.getItemMeta();
		limeWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.lime-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.lime-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			limeWoolMeta.setLore(lores);
		}
		limeWool.setItemMeta(limeWoolMeta);
		
		ItemStack magentaWool = SkullItem.getSkull("http://textures.minecraft.net/texture/abb4386bcda84e353c31d778d3b11bcd26fea494dd63496b8a82c7c78a4ad");
		ItemMeta magentaWoolMeta = magentaWool.getItemMeta();
		magentaWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.magenta-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.magenta-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			magentaWoolMeta.setLore(lores);
		}
		magentaWool.setItemMeta(magentaWoolMeta);
		
		ItemStack orangeWool = SkullItem.getSkull("http://textures.minecraft.net/texture/cbf7797a24a6af875f5c8271c5b8c425e19f372a415e0552fc247763f2859d1");
		ItemMeta orangeWoolMeta = orangeWool.getItemMeta();
		orangeWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.orange-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.orange-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			orangeWoolMeta.setLore(lores);
		}
		orangeWool.setItemMeta(orangeWoolMeta);
		
		ItemStack pinkWool = SkullItem.getSkull("http://textures.minecraft.net/texture/6becfb3879936b899e420bfcd3a74f8a1bf9dd54c58ec7fb9f81d9a5d988e");
		ItemMeta pinkWoolMeta = pinkWool.getItemMeta();
		pinkWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.pink-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.pink-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pinkWoolMeta.setLore(lores);
		}
		pinkWool.setItemMeta(pinkWoolMeta);
		
		ItemStack purpleWool = SkullItem.getSkull("http://textures.minecraft.net/texture/ba94cb25de628ca359b2f6ea5a8868cbe26595eedb2bffb750967ad1ee1850");
		ItemMeta purpleWoolMeta = purpleWool.getItemMeta();
		purpleWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.purple-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.purple-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			purpleWoolMeta.setLore(lores);
		}
		purpleWool.setItemMeta(purpleWoolMeta);
		
		ItemStack redWool = SkullItem.getSkull("http://textures.minecraft.net/texture/86d35a963d5987894b6bc214e328b39cd2382426ff9c8e082b0b6a6e044d3a3");
		ItemMeta redWoolMeta = redWool.getItemMeta();
		redWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.red-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.red-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redWoolMeta.setLore(lores);
		}
		redWool.setItemMeta(redWoolMeta);
		
		ItemStack lightGrayWool = SkullItem.getSkull("http://textures.minecraft.net/texture/998ba2b374cfc89454c1b8c32db458a270675439a495496c96771c989116162");
		ItemMeta lightGrayWoolMeta = lightGrayWool.getItemMeta();
		lightGrayWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.light-gray-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.light-gray-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lightGrayWoolMeta.setLore(lores);
		}
		lightGrayWool.setItemMeta(lightGrayWoolMeta);
		
		ItemStack whiteWool = SkullItem.getSkull("http://textures.minecraft.net/texture/3faf4c29f1e7405f4680c5c2b03ef9384f1aecfe2986ad50138c605fefff2f15");
		ItemMeta whiteWoolMeta = whiteWool.getItemMeta();
		whiteWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.white-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.white-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			whiteWoolMeta.setLore(lores);
		}
		whiteWool.setItemMeta(whiteWoolMeta);
		
		ItemStack yellowWool = SkullItem.getSkull("http://textures.minecraft.net/texture/27bbd0b2911c96b5d87b2df76691a51b8b12c6fefd523146d8ac5ef1b8ee");
		ItemMeta yellowWoolMeta = yellowWool.getItemMeta();
		yellowWoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.yellow-wool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.yellow-wool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			yellowWoolMeta.setLore(lores);
		}
		yellowWool.setItemMeta(yellowWoolMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.blocks.page-2.next-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.blocks.page-2.next-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nextMeta.setLore(lores);
		}
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 3);
		next = nextNbt.getItem();
		
		inventory.setItem(0, dropper);
		inventory.setItem(1, redstoneTorch);
		inventory.setItem(2, redstoneTorch2);
		inventory.setItem(3, redstoneBlock);
		inventory.setItem(4, tnt);
		inventory.setItem(5, tnt2);
		inventory.setItem(6, jukebox);
		inventory.setItem(7, jukebox2);
		inventory.setItem(8, sponge);
		inventory.setItem(9, mossyStoneBrick);
		inventory.setItem(10, hydratedFarmland);
		inventory.setItem(11, prismarine);
		inventory.setItem(12, enchantmentTable);
		inventory.setItem(13, cocoaPod);
		inventory.setItem(14, commandBlock);
		inventory.setItem(15, prismarineBrick);
		inventory.setItem(16, hayBale);
		inventory.setItem(17, hayBale2);
		inventory.setItem(18, glowstone);
		inventory.setItem(19, gravel);
		inventory.setItem(20, greenWool);
		inventory.setItem(21, grayWool);
		inventory.setItem(22, granite);
		inventory.setItem(23, polishedGranite);
		inventory.setItem(24, diorite);
		inventory.setItem(25, polishedDiorite);
		inventory.setItem(26, andesite);
		inventory.setItem(27, polishedAndesite);
		inventory.setItem(28, wetSponge);
		inventory.setItem(29, lapisLazuliBlock);
		inventory.setItem(30, lapisLazuliOre);
		inventory.setItem(31, sandstone);
		inventory.setItem(32, smoothSandstone);
		inventory.setItem(33, cyanWool);
		inventory.setItem(34, brownWool);
		inventory.setItem(35, lightBlueWool);
		inventory.setItem(36, limeWool);
		inventory.setItem(37, magentaWool);
		inventory.setItem(38, orangeWool);
		inventory.setItem(39, pinkWool);
		inventory.setItem(40, purpleWool);
		inventory.setItem(41, redWool);
		inventory.setItem(42, lightGrayWool);
		inventory.setItem(43, whiteWool);
		inventory.setItem(44, yellowWool);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}