package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.devices;

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

public class DevicesHeadsMenuOne {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.devices.page-1.title")));
		
		ItemStack clock = SkullItem.getSkull("http://textures.minecraft.net/texture/2de4e2783f85a391221dd91656ba688e7e42d16f6abbfbcfad9ca53617fca6");
		ItemMeta clockMeta = clock.getItemMeta();
		clockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.clock.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.clock.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			clockMeta.setLore(lores);
		}
		clock.setItemMeta(clockMeta);
		
		ItemStack goldenClock = SkullItem.getSkull("http://textures.minecraft.net/texture/d2c3569b62a1a9d28d279098b05764fed0648138be98f55dc26265fd08c40");
		ItemMeta goldenClockMeta = goldenClock.getItemMeta();
		goldenClockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.golden-clock.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.golden-clock.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goldenClockMeta.setLore(lores);
		}
		goldenClock.setItemMeta(goldenClockMeta);
		
		ItemStack antiqueClock = SkullItem.getSkull("http://textures.minecraft.net/texture/78472a2dcc239b4a483ac44c1dbf8fdba0fca1d253eb643fa0bd93af83a373");
		ItemMeta antiqueClockMeta = antiqueClock.getItemMeta();
		antiqueClockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.antique-clock.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.antique-clock.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			antiqueClockMeta.setLore(lores);
		}
		antiqueClock.setItemMeta(antiqueClockMeta);
		
		ItemStack gamecube = SkullItem.getSkull("http://textures.minecraft.net/texture/cc1e2b82db10ad25ca41345e9245f5847e76760cd245c48e5af1fd8985ef915");
		ItemMeta gamecubeMeta = gamecube.getItemMeta();
		gamecubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.gamecube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.gamecube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gamecubeMeta.setLore(lores);
		}
		gamecube.setItemMeta(gamecubeMeta);
		
		ItemStack gamecube2 = SkullItem.getSkull("http://textures.minecraft.net/texture/e063a0ebb2d8010273b6c45b64e84d83b1e43e2ca5dfb2a6fd838c3f88827d");
		ItemMeta gamecube2Meta = gamecube.getItemMeta();
		gamecube2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.gamecube-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.gamecube-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gamecube2Meta.setLore(lores);
		}
		gamecube2.setItemMeta(gamecube2Meta);
		
		ItemStack securityCamera = SkullItem.getSkull("http://textures.minecraft.net/texture/2f159a1cbe173d927392fa65fcfe78553d81aa5dc29495b9fbbade362f8bf9");
		ItemMeta securityCameraMeta = securityCamera.getItemMeta();
		securityCameraMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.security-camera.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.security-camera.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			securityCameraMeta.setLore(lores);
		}
		securityCamera.setItemMeta(securityCameraMeta);
		
		ItemStack camera = SkullItem.getSkull("http://textures.minecraft.net/texture/ea7d2a7fbb4d37b4d53fe87757128e5ef66ec23d7ff4fe9944546dbc8ce777");
		ItemMeta cameraMeta = camera.getItemMeta();
		cameraMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.camera.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.camera.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cameraMeta.setLore(lores);
		}
		camera.setItemMeta(cameraMeta);
		
		ItemStack speaker = SkullItem.getSkull("http://textures.minecraft.net/texture/ff7becf1718e9a6096ee5f9cb7abeb6cfd9488c44a3116407c92ec33ad7d8521");
		ItemMeta speakerMeta = speaker.getItemMeta();
		speakerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.speaker.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.speaker.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			speakerMeta.setLore(lores);
		}
		speaker.setItemMeta(speakerMeta);
		
		ItemStack headlight = SkullItem.getSkull("http://textures.minecraft.net/texture/59e9c9246f1ba5a41e53efa68b2bd56a70da308f393487dcf6fe756799b3c7");
		ItemMeta headlightMeta = headlight.getItemMeta();
		headlightMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.headlight.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.headlight.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			headlightMeta.setLore(lores);
		}
		headlight.setItemMeta(headlightMeta);
		
		ItemStack ceilingLamp = SkullItem.getSkull("http://textures.minecraft.net/texture/f0896390c4921bf889a29cfd1842abf9ef7f84e5a22fbce7e64891db41666bc");
		ItemMeta ceilingLampMeta = ceilingLamp.getItemMeta();
		ceilingLampMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.ceiling-lamp.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.ceiling-lamp.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			ceilingLampMeta.setLore(lores);
		}
		ceilingLamp.setItemMeta(ceilingLampMeta);
		
		ItemStack microwave = SkullItem.getSkull("http://textures.minecraft.net/texture/a76fa636c54e36085fe2fa46dc966215c15722bb764a2eee84cfe8476caf71");
		ItemMeta microwaveMeta = microwave.getItemMeta();
		microwaveMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.microwave.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.microwave.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			microwaveMeta.setLore(lores);
		}
		microwave.setItemMeta(microwaveMeta);
		
		ItemStack computer = SkullItem.getSkull("http://textures.minecraft.net/texture/8ae52ae8c98ac19fd07637a469ffa256ab0b3b10ece6243186188ba38df154");
		ItemMeta computerMeta = computer.getItemMeta();
		computerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computerMeta.setLore(lores);
		}
		computer.setItemMeta(computerMeta);
		
		ItemStack computer2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9c9a91a74d3a1bb1d785f5bdc8d826de3b2fddc6a1fad12923fd06ec84f499e");
		ItemMeta computer2Meta = computer2.getItemMeta();
		computer2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer2Meta.setLore(lores);
		}
		computer2.setItemMeta(computer2Meta);
		
		ItemStack monitor = SkullItem.getSkull("http://textures.minecraft.net/texture/a824bfc3d8813d7ae3cbc5f8b75f7239368ca87c85fef82244dbaf59cb225c3");
		ItemMeta monitorMeta = monitor.getItemMeta();
		monitorMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.monitor.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.monitor.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			monitorMeta.setLore(lores);
		}
		monitor.setItemMeta(monitorMeta);
		
		ItemStack monitor2 = SkullItem.getSkull("http://textures.minecraft.net/texture/15c292a24f54a7a43785266552dba7a184f9c50e0d94b337d8d3e76e9e9cce7");
		ItemMeta monitor2Meta = monitor.getItemMeta();
		monitor2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.monitor-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.monitor-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			monitor2Meta.setLore(lores);
		}
		monitor2.setItemMeta(monitor2Meta);
		
		ItemStack oldRadio = SkullItem.getSkull("http://textures.minecraft.net/texture/4c3c8517516f8d8e8067781e7c62eea27de478b14c4a68c8e8c1ad8af1bae21");
		ItemMeta oldRadioMeta = oldRadio.getItemMeta();
		oldRadioMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.old-radio.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.old-radio.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			oldRadioMeta.setLore(lores);
		}
		oldRadio.setItemMeta(oldRadioMeta);
		
		ItemStack computer3 = SkullItem.getSkull("http://textures.minecraft.net/texture/198dd1806a81ac069979199eb3f222341d671af507798527484d1e2fe1638");
		ItemMeta computer3Meta = computer3.getItemMeta();
		computer3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer3Meta.setLore(lores);
		}
		computer3.setItemMeta(computer3Meta);
		
		ItemStack monitor3 = SkullItem.getSkull("http://textures.minecraft.net/texture/6d6c65b44c34b1acc2ccb346752397125f0d9ffa0ab3c50a99d1db3b74c63");
		ItemMeta monitor3Meta = monitor3.getItemMeta();
		monitor3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.monitor-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.monitor-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			monitor3Meta.setLore(lores);
		}
		monitor3.setItemMeta(monitor3Meta);
		
		ItemStack toaster = SkullItem.getSkull("http://textures.minecraft.net/texture/bb53e8d374b4f6f573d1286681bf841055b89a462f7cdd99e8e63d2f514e45");
		ItemMeta toasterMeta = toaster.getItemMeta();
		toasterMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.toaster.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.toaster.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			toasterMeta.setLore(lores);
		}
		toaster.setItemMeta(toasterMeta);
		
		ItemStack toaster2 = SkullItem.getSkull("http://textures.minecraft.net/texture/543fe8802edb2e981ae6ed4dfaba3eab79aa8facf9abdc38126896debeb7c6b");
		ItemMeta toaster2Meta = toaster2.getItemMeta();
		toaster2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.toaster-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.toaster-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			toaster2Meta.setLore(lores);
		}
		toaster2.setItemMeta(toaster2Meta);
		
		ItemStack camera2 = SkullItem.getSkull("http://textures.minecraft.net/texture/207bd38f16b380c882f8c28315ebed2561adab2fdb996b2cc0d747f64bc4eb8");
		ItemMeta camera2Meta = camera2.getItemMeta();
		camera2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.camera-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.camera-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			camera2Meta.setLore(lores);
		}
		camera2.setItemMeta(camera2Meta);
		
		ItemStack telephone = SkullItem.getSkull("http://textures.minecraft.net/texture/82442bbf7171b5cafca217c9ba44ce27647225df76cda9689d61a9f1c0a5f176");
		ItemMeta telephoneMeta = telephone.getItemMeta();
		telephoneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.telephone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.telephone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			telephoneMeta.setLore(lores);
		}
		telephone.setItemMeta(telephoneMeta);
		
		ItemStack oldCamera = SkullItem.getSkull("http://textures.minecraft.net/texture/d3a0feb626e567e479576f4ff543e16e9b36a7304891b2f3293eaa8b68735a4");
		ItemMeta oldCameraMeta = oldCamera.getItemMeta();
		oldCameraMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.old-camera.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.old-camera.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			oldCameraMeta.setLore(lores);
		}
		oldCamera.setItemMeta(oldCameraMeta);
		
		ItemStack lantern = SkullItem.getSkull("http://textures.minecraft.net/texture/7cc217a9b9e3ce3cd0484c7e8ce49d1cf741281bdda5a4d6cb821f378752718");
		ItemMeta lanternMeta = lantern.getItemMeta();
		lanternMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.lantern.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.lantern.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lanternMeta.setLore(lores);
		}
		lantern.setItemMeta(lanternMeta);
		
		ItemStack lanternOff = SkullItem.getSkull("http://textures.minecraft.net/texture/d2c81b435dc22d29d4778ffd22feb846a68b648dd1af5de818b517f0574d");
		ItemMeta lanternOffMeta = lanternOff.getItemMeta();
		lanternOffMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.lantern-off.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.lantern-off.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lanternOffMeta.setLore(lores);
		}
		lanternOff.setItemMeta(lanternOffMeta);
		
		ItemStack showerHead = SkullItem.getSkull("http://textures.minecraft.net/texture/1c49bd9019d05d1f7d201cf9ed10d25a33ac3ac5e8296636ec659f39143f8");
		ItemMeta showerHeadMeta = showerHead.getItemMeta();
		showerHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.shower-head.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.shower-head.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			showerHeadMeta.setLore(lores);
		}
		showerHead.setItemMeta(showerHeadMeta);
		
		ItemStack aquarium = SkullItem.getSkull("http://textures.minecraft.net/texture/c2847cd5717e5f5a64e1ba9cb481dc9e22c78ca23f8516d553f55412fa113e0");
		ItemMeta aquariumMeta = aquarium.getItemMeta();
		aquariumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.aquarium.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.aquarium.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			aquariumMeta.setLore(lores);
		}
		aquarium.setItemMeta(aquariumMeta);
		
		ItemStack instagram = SkullItem.getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675");
		ItemMeta instagramMeta = instagram.getItemMeta();
		instagramMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.instagram.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.instagram.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			instagramMeta.setLore(lores);
		}
		instagram.setItemMeta(instagramMeta);
		
		ItemStack siren = SkullItem.getSkull("http://textures.minecraft.net/texture/a6b221be89678d5856eaa68667f98683175bcce6741f82c62e73f044166367");
		ItemMeta sirenMeta = siren.getItemMeta();
		sirenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.siren.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.siren.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sirenMeta.setLore(lores);
		}
		siren.setItemMeta(sirenMeta);
		
		ItemStack policeSiren = SkullItem.getSkull("http://textures.minecraft.net/texture/d4bf643cfb41ee5f9e618de9789cc6d85c2e953f44567e4e2d3b19a79e843");
		ItemMeta policeSirenMeta = policeSiren.getItemMeta();
		policeSirenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.police-siren.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.police-siren.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			policeSirenMeta.setLore(lores);
		}
		policeSiren.setItemMeta(policeSirenMeta);
		
		ItemStack computer4 = SkullItem.getSkull("http://textures.minecraft.net/texture/8d19c68461666aacd7628e34a1e2ad39fe4f2bde32e231963ef3b35533");
		ItemMeta computer4Meta = computer4.getItemMeta();
		computer4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-4.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-4.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer4Meta.setLore(lores);
		}
		computer4.setItemMeta(computer4Meta);
		
		ItemStack brokenTV = SkullItem.getSkull("http://textures.minecraft.net/texture/a247c876488167c74cb948ab1181e6bef9e4c8d7573c191aaab4e5cc75b09d");
		ItemMeta brokenTVMeta = brokenTV.getItemMeta();
		brokenTVMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.broken-tv.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.broken-tv.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brokenTVMeta.setLore(lores);
		}
		brokenTV.setItemMeta(brokenTVMeta);
		
		ItemStack brokenTV2 = SkullItem.getSkull("http://textures.minecraft.net/texture/2017bc48fe3cdc9085a0e110fe1f628426a09775747398de5724e73586bd");
		ItemMeta brokenTV2Meta = brokenTV2.getItemMeta();
		brokenTV2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.broken-tv-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.broken-tv-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brokenTV2Meta.setLore(lores);
		}
		brokenTV2.setItemMeta(brokenTV2Meta);
		
		ItemStack brokenTV3 = SkullItem.getSkull("http://textures.minecraft.net/texture/cc99d8fbad11f9b73340bcc1adf6dd28f67f754b52ce4e502b4fe02b16b1834");
		ItemMeta brokenTV3Meta = brokenTV3.getItemMeta();
		brokenTV3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.broken-tv-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.broken-tv-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brokenTV3Meta.setLore(lores);
		}
		brokenTV3.setItemMeta(brokenTV3Meta);
		
		ItemStack brokenTV4 = SkullItem.getSkull("http://textures.minecraft.net/texture/54a8dc1e9e12d58e2de63e1a1f7f89276ec13df062fbd28b267fd54e1c1d74");
		ItemMeta brokenTV4Meta = brokenTV4.getItemMeta();
		brokenTV4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.broken-tv-4.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.broken-tv-4.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brokenTV4Meta.setLore(lores);
		}
		brokenTV4.setItemMeta(brokenTV4Meta);
		
		ItemStack brokenTV5 = SkullItem.getSkull("http://textures.minecraft.net/texture/be3db27cbd1789310409081ad8c42d690b08961b55cadd45b42d46bca28b8");
		ItemMeta brokenTV5Meta = brokenTV5.getItemMeta();
		brokenTV5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.broken-tv-5.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.broken-tv-5.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			brokenTV5Meta.setLore(lores);
		}
		brokenTV5.setItemMeta(brokenTV5Meta);
		
		ItemStack clock2 = SkullItem.getSkull("http://textures.minecraft.net/texture/da6ae5b34c4f79a5f9ed6ccc33bc981fc40acf2bfcd9522664fe1c524d2eb0");
		ItemMeta clock2Meta = clock2.getItemMeta();
		clock2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.clock-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.clock-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			clock2Meta.setLore(lores);
		}
		clock2.setItemMeta(clock2Meta);
		
		ItemStack policeSiren2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ca35afa58631609791ffe25f3a879dfbffea1151f87bff62c5423ed6136ee0");
		ItemMeta policeSiren2Meta = policeSiren2.getItemMeta();
		policeSiren2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.police-siren-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.police-siren-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			policeSiren2Meta.setLore(lores);
		}
		policeSiren2.setItemMeta(policeSiren2Meta);
		
		ItemStack computer5 = SkullItem.getSkull("http://textures.minecraft.net/texture/9ccefd5f2a94f242819858a96555a13baeba9dae8d467f4061974ee999b6959b");
		ItemMeta computer5Meta = computer5.getItemMeta();
		computer5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-5.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-5.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer5Meta.setLore(lores);
		}
		computer5.setItemMeta(computer5Meta);
		
		ItemStack computer6 = SkullItem.getSkull("http://textures.minecraft.net/texture/fed4ae757f23445b5c9335cc5a8f7f7c6f9a5aee85bb69fe97f581dafb18d30");
		ItemMeta computer6Meta = computer6.getItemMeta();
		computer6Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-6.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-6.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer6Meta.setLore(lores);
		}
		computer6.setItemMeta(computer6Meta);
		
		ItemStack c4Explosive = SkullItem.getSkull("http://textures.minecraft.net/texture/8da332abde333a15a6c6fcfeca83f0159ea94b68e8f274bafc04892b6dbfc");
		ItemMeta c4ExplosiveMeta = c4Explosive.getItemMeta();
		c4ExplosiveMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.c4-explosive.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.c4-explosive.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			c4ExplosiveMeta.setLore(lores);
		}
		c4Explosive.setItemMeta(c4ExplosiveMeta);
		
		ItemStack monitor4 = SkullItem.getSkull("http://textures.minecraft.net/texture/c74170c66bf3140f234b322add724c5df6949a9209f807ebf86d4f9c8c1e178");
		ItemMeta monitor4Meta = monitor4.getItemMeta();
		monitor4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.monitor-4.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.monitor-4.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			monitor4Meta.setLore(lores);
		}
		monitor4.setItemMeta(monitor4Meta);
		
		ItemStack gamecube3 = SkullItem.getSkull("http://textures.minecraft.net/texture/1256f7ff52e7bfd8187b83dd34df34502952b8db9fafb7288ebebb6e78ef15f");
		ItemMeta gamecube3Meta = gamecube3.getItemMeta();
		gamecube3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.gamecube-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.gamecube-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gamecube3Meta.setLore(lores);
		}
		gamecube3.setItemMeta(gamecube3Meta);
		
		ItemStack computer7 = SkullItem.getSkull("http://textures.minecraft.net/texture/53da39e556c927990384faa1feb3b825252dac78cd288779cde1117c37a8");
		ItemMeta computer7Meta = computer7.getItemMeta();
		computer7Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.computer-7.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.computer-7.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			computer7Meta.setLore(lores);
		}
		computer7.setItemMeta(computer7Meta);
		
		ItemStack clock3 = SkullItem.getSkull("http://textures.minecraft.net/texture/bfe4ed837849dea840cd4f9929fdd1519d14b5dde3803559e7f63d27f1e6f29");
		ItemMeta clock3Meta = clock3.getItemMeta();
		clock3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.clock-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.clock-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			clock3Meta.setLore(lores);
		}
		clock3.setItemMeta(clock3Meta);
		
		ItemStack blackClock = SkullItem.getSkull("http://textures.minecraft.net/texture/ba10da526e5111cfb6e3ebd47693e162dd52d41a2182028daa7c2b19aa3143");
		ItemMeta blackClockMeta = blackClock.getItemMeta();
		blackClockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.black-clock.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.black-clock.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blackClockMeta.setLore(lores);
		}
		blackClock.setItemMeta(blackClockMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
				
		//next page		
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.devices.page-1.next-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.devices.page-1.next-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nextMeta.setLore(lores);
		}
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
		inventory.setItem(0, clock);
		inventory.setItem(1, goldenClock);
		inventory.setItem(2, antiqueClock);
		inventory.setItem(3, gamecube);
		inventory.setItem(4, gamecube2);
		inventory.setItem(5, securityCamera);
		inventory.setItem(6, camera);
		inventory.setItem(7, speaker);
		inventory.setItem(8, headlight);
		inventory.setItem(9, ceilingLamp);
		inventory.setItem(10, microwave);
		inventory.setItem(11, computer);
		inventory.setItem(12, computer2);
		inventory.setItem(13, monitor);
		inventory.setItem(14, monitor2);
		inventory.setItem(15, oldRadio);
		inventory.setItem(16, computer3);
		inventory.setItem(17, monitor3);
		inventory.setItem(18, toaster);
		inventory.setItem(19, toaster2);
		inventory.setItem(20, camera2);
		inventory.setItem(21, telephone);
		inventory.setItem(22, oldCamera);
		inventory.setItem(23, lantern);
		inventory.setItem(24, lanternOff);
		inventory.setItem(25, showerHead);
		inventory.setItem(26, aquarium);
		inventory.setItem(27, instagram);
		inventory.setItem(28, siren);
		inventory.setItem(29, computer4);
		inventory.setItem(30, brokenTV);
		inventory.setItem(31, brokenTV2);
		inventory.setItem(32, brokenTV3);
		inventory.setItem(33, brokenTV4);
		inventory.setItem(34, brokenTV5);
		inventory.setItem(35, clock2);
		inventory.setItem(36, policeSiren2);
		inventory.setItem(37, computer5);
		inventory.setItem(38, computer6);
		inventory.setItem(39, c4Explosive);
		inventory.setItem(40, monitor4);
		inventory.setItem(41, gamecube3);
		inventory.setItem(42, computer7);
		inventory.setItem(43, clock3);
		inventory.setItem(44, blackClock);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}