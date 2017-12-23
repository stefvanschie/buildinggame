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
 * The gui for the heads in the devices category
 *
 * @since 4.0.0
 */
public class DevicesHeadsMenu extends Gui {

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
    public DevicesHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.devices.title")), 2);
		
		//page 1
		ItemStack clock = SkullItem.getSkull("http://textures.minecraft.net/texture/2de4e2783f85a391221dd91656ba688e7e42d16f6abbfbcfad9ca53617fca6");
		ItemMeta clockMeta = clock.getItemMeta();
		clockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.clock.name")));
		clockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.clock.lores")));
		clock.setItemMeta(clockMeta);
		
		addItem(clock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack goldenClock = SkullItem.getSkull("http://textures.minecraft.net/texture/d2c3569b62a1a9d28d279098b05764fed0648138be98f55dc26265fd08c40");
		ItemMeta goldenClockMeta = goldenClock.getItemMeta();
		goldenClockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.golden-clock.name")));
		goldenClockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.golden-clock.lores")));
		goldenClock.setItemMeta(goldenClockMeta);
		
		addItem(goldenClock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack antiqueClock = SkullItem.getSkull("http://textures.minecraft.net/texture/78472a2dcc239b4a483ac44c1dbf8fdba0fca1d253eb643fa0bd93af83a373");
		ItemMeta antiqueClockMeta = antiqueClock.getItemMeta();
		antiqueClockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.antique-clock.name")));
		antiqueClockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.antique-clock.lores")));
		antiqueClock.setItemMeta(antiqueClockMeta);
		
		addItem(antiqueClock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gamecube = SkullItem.getSkull("http://textures.minecraft.net/texture/cc1e2b82db10ad25ca41345e9245f5847e76760cd245c48e5af1fd8985ef915");
		ItemMeta gamecubeMeta = gamecube.getItemMeta();
		gamecubeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.gamecube.name")));
		gamecubeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.gamecube.lores")));
		gamecube.setItemMeta(gamecubeMeta);
		
		addItem(gamecube, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gamecube2 = SkullItem.getSkull("http://textures.minecraft.net/texture/e063a0ebb2d8010273b6c45b64e84d83b1e43e2ca5dfb2a6fd838c3f88827d");
		ItemMeta gamecube2Meta = gamecube.getItemMeta();
		gamecube2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.gamecube-2.name")));
		gamecube2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.gamecube-2.lores")));
		gamecube2.setItemMeta(gamecube2Meta);
		
		addItem(gamecube2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack securityCamera = SkullItem.getSkull("http://textures.minecraft.net/texture/2f159a1cbe173d927392fa65fcfe78553d81aa5dc29495b9fbbade362f8bf9");
		ItemMeta securityCameraMeta = securityCamera.getItemMeta();
		securityCameraMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.security-camera.name")));
		securityCameraMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.security-camera.lores")));
		securityCamera.setItemMeta(securityCameraMeta);
		
		addItem(securityCamera, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack camera = SkullItem.getSkull("http://textures.minecraft.net/texture/ea7d2a7fbb4d37b4d53fe87757128e5ef66ec23d7ff4fe9944546dbc8ce777");
		ItemMeta cameraMeta = camera.getItemMeta();
		cameraMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.camera.name")));
		cameraMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.camera.lores")));
		camera.setItemMeta(cameraMeta);
		
		addItem(camera, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack speaker = SkullItem.getSkull("http://textures.minecraft.net/texture/ff7becf1718e9a6096ee5f9cb7abeb6cfd9488c44a3116407c92ec33ad7d8521");
		ItemMeta speakerMeta = speaker.getItemMeta();
		speakerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.speaker.name")));
		speakerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.speaker.lores")));
		speaker.setItemMeta(speakerMeta);
		
		addItem(speaker, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack headlight = SkullItem.getSkull("http://textures.minecraft.net/texture/59e9c9246f1ba5a41e53efa68b2bd56a70da308f393487dcf6fe756799b3c7");
		ItemMeta headlightMeta = headlight.getItemMeta();
		headlightMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.headlight.name")));
		headlightMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.headlight.lores")));
		headlight.setItemMeta(headlightMeta);
		
		addItem(headlight, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack ceilingLamp = SkullItem.getSkull("http://textures.minecraft.net/texture/f0896390c4921bf889a29cfd1842abf9ef7f84e5a22fbce7e64891db41666bc");
		ItemMeta ceilingLampMeta = ceilingLamp.getItemMeta();
		ceilingLampMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.ceiling-lamp.name")));
		ceilingLampMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.ceiling-lamp.lores")));
		ceilingLamp.setItemMeta(ceilingLampMeta);
		
		addItem(ceilingLamp, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack microwave = SkullItem.getSkull("http://textures.minecraft.net/texture/a76fa636c54e36085fe2fa46dc966215c15722bb764a2eee84cfe8476caf71");
		ItemMeta microwaveMeta = microwave.getItemMeta();
		microwaveMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.microwave.name")));
		microwaveMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.microwave.lores")));
		microwave.setItemMeta(microwaveMeta);
		
		addItem(microwave, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer = SkullItem.getSkull("http://textures.minecraft.net/texture/8ae52ae8c98ac19fd07637a469ffa256ab0b3b10ece6243186188ba38df154");
		ItemMeta computerMeta = computer.getItemMeta();
		computerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer.name")));
		computerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer.lores")));
		computer.setItemMeta(computerMeta);
		
		addItem(computer, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9c9a91a74d3a1bb1d785f5bdc8d826de3b2fddc6a1fad12923fd06ec84f499e");
		ItemMeta computer2Meta = computer2.getItemMeta();
		computer2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-2.name")));
		computer2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-2.lores")));
		computer2.setItemMeta(computer2Meta);
		
		addItem(computer2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack monitor = SkullItem.getSkull("http://textures.minecraft.net/texture/a824bfc3d8813d7ae3cbc5f8b75f7239368ca87c85fef82244dbaf59cb225c3");
		ItemMeta monitorMeta = monitor.getItemMeta();
		monitorMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.monitor.name")));
		monitorMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.monitor.lores")));
		monitor.setItemMeta(monitorMeta);
		
		addItem(monitor, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack monitor2 = SkullItem.getSkull("http://textures.minecraft.net/texture/15c292a24f54a7a43785266552dba7a184f9c50e0d94b337d8d3e76e9e9cce7");
		ItemMeta monitor2Meta = monitor.getItemMeta();
		monitor2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.monitor-2.name")));
		monitor2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.monitor-2.lores")));
		monitor2.setItemMeta(monitor2Meta);
		
		addItem(monitor2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack oldRadio = SkullItem.getSkull("http://textures.minecraft.net/texture/4c3c8517516f8d8e8067781e7c62eea27de478b14c4a68c8e8c1ad8af1bae21");
		ItemMeta oldRadioMeta = oldRadio.getItemMeta();
		oldRadioMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.old-radio.name")));
		oldRadioMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.old-radio.lores")));
		oldRadio.setItemMeta(oldRadioMeta);
		
		addItem(oldRadio, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer3 = SkullItem.getSkull("http://textures.minecraft.net/texture/198dd1806a81ac069979199eb3f222341d671af507798527484d1e2fe1638");
		ItemMeta computer3Meta = computer3.getItemMeta();
		computer3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-3.name")));
		computer3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-3.lores")));
		computer3.setItemMeta(computer3Meta);
		
		addItem(computer3, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack monitor3 = SkullItem.getSkull("http://textures.minecraft.net/texture/6d6c65b44c34b1acc2ccb346752397125f0d9ffa0ab3c50a99d1db3b74c63");
		ItemMeta monitor3Meta = monitor3.getItemMeta();
		monitor3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.monitor-3.name")));
		monitor3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.monitor-3.lores")));
		monitor3.setItemMeta(monitor3Meta);
		
		addItem(monitor3, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack toaster = SkullItem.getSkull("http://textures.minecraft.net/texture/bb53e8d374b4f6f573d1286681bf841055b89a462f7cdd99e8e63d2f514e45");
		ItemMeta toasterMeta = toaster.getItemMeta();
		toasterMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.toaster.name")));
		toasterMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.toaster.lores")));
		toaster.setItemMeta(toasterMeta);
		
		addItem(toaster, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack toaster2 = SkullItem.getSkull("http://textures.minecraft.net/texture/543fe8802edb2e981ae6ed4dfaba3eab79aa8facf9abdc38126896debeb7c6b");
		ItemMeta toaster2Meta = toaster2.getItemMeta();
		toaster2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.toaster-2.name")));
		toaster2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.toaster-2.lores")));
		toaster2.setItemMeta(toaster2Meta);
		
		addItem(toaster2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack camera2 = SkullItem.getSkull("http://textures.minecraft.net/texture/207bd38f16b380c882f8c28315ebed2561adab2fdb996b2cc0d747f64bc4eb8");
		ItemMeta camera2Meta = camera2.getItemMeta();
		camera2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.camera-2.name")));
		camera2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.camera-2.lores")));
		camera2.setItemMeta(camera2Meta);
		
		addItem(camera2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack telephone = SkullItem.getSkull("http://textures.minecraft.net/texture/82442bbf7171b5cafca217c9ba44ce27647225df76cda9689d61a9f1c0a5f176");
		ItemMeta telephoneMeta = telephone.getItemMeta();
		telephoneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.telephone.name")));
		telephoneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.telephone.lores")));
		telephone.setItemMeta(telephoneMeta);
		
		addItem(telephone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack oldCamera = SkullItem.getSkull("http://textures.minecraft.net/texture/d3a0feb626e567e479576f4ff543e16e9b36a7304891b2f3293eaa8b68735a4");
		ItemMeta oldCameraMeta = oldCamera.getItemMeta();
		oldCameraMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.old-camera.name")));
		oldCameraMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.old-camera.lores")));
		oldCamera.setItemMeta(oldCameraMeta);
		
		addItem(oldCamera, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lantern = SkullItem.getSkull("http://textures.minecraft.net/texture/7cc217a9b9e3ce3cd0484c7e8ce49d1cf741281bdda5a4d6cb821f378752718");
		ItemMeta lanternMeta = lantern.getItemMeta();
		lanternMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.lantern.name")));
		lanternMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.lantern.lores")));
		lantern.setItemMeta(lanternMeta);
		
		addItem(lantern, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lanternOff = SkullItem.getSkull("http://textures.minecraft.net/texture/d2c81b435dc22d29d4778ffd22feb846a68b648dd1af5de818b517f0574d");
		ItemMeta lanternOffMeta = lanternOff.getItemMeta();
		lanternOffMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.lantern-off.name")));
		lanternOffMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.lantern-off.lores")));
		lanternOff.setItemMeta(lanternOffMeta);
		
		addItem(lanternOff, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack showerHead = SkullItem.getSkull("http://textures.minecraft.net/texture/1c49bd9019d05d1f7d201cf9ed10d25a33ac3ac5e8296636ec659f39143f8");
		ItemMeta showerHeadMeta = showerHead.getItemMeta();
		showerHeadMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.shower-head.name")));
		showerHeadMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.shower-head.lores")));
		showerHead.setItemMeta(showerHeadMeta);
		
		addItem(showerHead, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack aquarium = SkullItem.getSkull("http://textures.minecraft.net/texture/c2847cd5717e5f5a64e1ba9cb481dc9e22c78ca23f8516d553f55412fa113e0");
		ItemMeta aquariumMeta = aquarium.getItemMeta();
		aquariumMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.aquarium.name")));
		aquariumMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.aquarium.lores")));
		aquarium.setItemMeta(aquariumMeta);
		
		addItem(aquarium, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack instagram = SkullItem.getSkull("http://textures.minecraft.net/texture/25b3f2cfa0739c4e828316f39f90b05bc1f4ed27b1e35888511f558d4675");
		ItemMeta instagramMeta = instagram.getItemMeta();
		instagramMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.instagram.name")));
		instagramMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.instagram.lores")));
		instagram.setItemMeta(instagramMeta);
		
		addItem(instagram, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack siren = SkullItem.getSkull("http://textures.minecraft.net/texture/a6b221be89678d5856eaa68667f98683175bcce6741f82c62e73f044166367");
		ItemMeta sirenMeta = siren.getItemMeta();
		sirenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.siren.name")));
		sirenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.siren.lores")));
		siren.setItemMeta(sirenMeta);
		
		addItem(siren, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack policeSiren = SkullItem.getSkull("http://textures.minecraft.net/texture/d4bf643cfb41ee5f9e618de9789cc6d85c2e953f44567e4e2d3b19a79e843");
		ItemMeta policeSirenMeta = policeSiren.getItemMeta();
		policeSirenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.police-siren.name")));
		policeSirenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.police-siren.lores")));
		policeSiren.setItemMeta(policeSirenMeta);
		
		addItem(policeSiren, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer4 = SkullItem.getSkull("http://textures.minecraft.net/texture/8d19c68461666aacd7628e34a1e2ad39fe4f2bde32e231963ef3b35533");
		ItemMeta computer4Meta = computer4.getItemMeta();
		computer4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-4.name")));
		computer4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-4.lores")));
		computer4.setItemMeta(computer4Meta);
		
		addItem(computer4, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brokenTV = SkullItem.getSkull("http://textures.minecraft.net/texture/a247c876488167c74cb948ab1181e6bef9e4c8d7573c191aaab4e5cc75b09d");
		ItemMeta brokenTVMeta = brokenTV.getItemMeta();
		brokenTVMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.broken-tv.name")));
		brokenTVMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.broken-tv.lores")));
		brokenTV.setItemMeta(brokenTVMeta);
		
		addItem(brokenTV, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brokenTV2 = SkullItem.getSkull("http://textures.minecraft.net/texture/2017bc48fe3cdc9085a0e110fe1f628426a09775747398de5724e73586bd");
		ItemMeta brokenTV2Meta = brokenTV2.getItemMeta();
		brokenTV2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.broken-tv-2.name")));
		brokenTV2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.broken-tv-2.lores")));
		brokenTV2.setItemMeta(brokenTV2Meta);
		
		addItem(brokenTV2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brokenTV3 = SkullItem.getSkull("http://textures.minecraft.net/texture/cc99d8fbad11f9b73340bcc1adf6dd28f67f754b52ce4e502b4fe02b16b1834");
		ItemMeta brokenTV3Meta = brokenTV3.getItemMeta();
		brokenTV3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.broken-tv-3.name")));
		brokenTV3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.broken-tv-3.lores")));
		brokenTV3.setItemMeta(brokenTV3Meta);
		
		addItem(brokenTV3, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brokenTV4 = SkullItem.getSkull("http://textures.minecraft.net/texture/54a8dc1e9e12d58e2de63e1a1f7f89276ec13df062fbd28b267fd54e1c1d74");
		ItemMeta brokenTV4Meta = brokenTV4.getItemMeta();
		brokenTV4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.broken-tv-4.name")));
		brokenTV4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.broken-tv-4.lores")));
		brokenTV4.setItemMeta(brokenTV4Meta);
		
		addItem(brokenTV4, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack brokenTV5 = SkullItem.getSkull("http://textures.minecraft.net/texture/be3db27cbd1789310409081ad8c42d690b08961b55cadd45b42d46bca28b8");
		ItemMeta brokenTV5Meta = brokenTV5.getItemMeta();
		brokenTV5Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.broken-tv-5.name")));
		brokenTV5Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.broken-tv-5.lores")));
		brokenTV5.setItemMeta(brokenTV5Meta);
		
		addItem(brokenTV5, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack clock2 = SkullItem.getSkull("http://textures.minecraft.net/texture/da6ae5b34c4f79a5f9ed6ccc33bc981fc40acf2bfcd9522664fe1c524d2eb0");
		ItemMeta clock2Meta = clock2.getItemMeta();
		clock2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.clock-2.name")));
		clock2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.clock-2.lores")));
		clock2.setItemMeta(clock2Meta);
		
		addItem(clock2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack policeSiren2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ca35afa58631609791ffe25f3a879dfbffea1151f87bff62c5423ed6136ee0");
		ItemMeta policeSiren2Meta = policeSiren2.getItemMeta();
		policeSiren2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.police-siren-2.name")));
		policeSiren2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.police-siren-2.lores")));
		policeSiren2.setItemMeta(policeSiren2Meta);
		
		addItem(policeSiren2, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer5 = SkullItem.getSkull("http://textures.minecraft.net/texture/9ccefd5f2a94f242819858a96555a13baeba9dae8d467f4061974ee999b6959b");
		ItemMeta computer5Meta = computer5.getItemMeta();
		computer5Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-5.name")));
		computer5Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-5.lores")));
		computer5.setItemMeta(computer5Meta);
		
		addItem(computer5, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer6 = SkullItem.getSkull("http://textures.minecraft.net/texture/fed4ae757f23445b5c9335cc5a8f7f7c6f9a5aee85bb69fe97f581dafb18d30");
		ItemMeta computer6Meta = computer6.getItemMeta();
		computer6Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-6.name")));
		computer6Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-6.lores")));
		computer6.setItemMeta(computer6Meta);
		
		addItem(computer6, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack c4Explosive = SkullItem.getSkull("http://textures.minecraft.net/texture/8da332abde333a15a6c6fcfeca83f0159ea94b68e8f274bafc04892b6dbfc");
		ItemMeta c4ExplosiveMeta = c4Explosive.getItemMeta();
		c4ExplosiveMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.c4-explosive.name")));
		c4ExplosiveMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.c4-explosive.lores")));
		c4Explosive.setItemMeta(c4ExplosiveMeta);
		
		addItem(c4Explosive, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack monitor4 = SkullItem.getSkull("http://textures.minecraft.net/texture/c74170c66bf3140f234b322add724c5df6949a9209f807ebf86d4f9c8c1e178");
		ItemMeta monitor4Meta = monitor4.getItemMeta();
		monitor4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.monitor-4.name")));
		monitor4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.monitor-4.lores")));
		monitor4.setItemMeta(monitor4Meta);
		
		addItem(monitor4, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gamecube3 = SkullItem.getSkull("http://textures.minecraft.net/texture/1256f7ff52e7bfd8187b83dd34df34502952b8db9fafb7288ebebb6e78ef15f");
		ItemMeta gamecube3Meta = gamecube3.getItemMeta();
		gamecube3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.gamecube-3.name")));
		gamecube3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.gamecube-3.lores")));
		gamecube3.setItemMeta(gamecube3Meta);
		
		addItem(gamecube3, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack computer7 = SkullItem.getSkull("http://textures.minecraft.net/texture/53da39e556c927990384faa1feb3b825252dac78cd288779cde1117c37a8");
		ItemMeta computer7Meta = computer7.getItemMeta();
		computer7Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.computer-7.name")));
		computer7Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.computer-7.lores")));
		computer7.setItemMeta(computer7Meta);
		
		addItem(computer7, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack clock3 = SkullItem.getSkull("http://textures.minecraft.net/texture/bfe4ed837849dea840cd4f9929fdd1519d14b5dde3803559e7f63d27f1e6f29");
		ItemMeta clock3Meta = clock3.getItemMeta();
		clock3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.clock-3.name")));
		clock3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.clock-3.lores")));
		clock3.setItemMeta(clock3Meta);
		
		addItem(clock3, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.close.lores")));
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
		nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.next-page.name")));
		nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, event -> {
            open((Player) event.getWhoClicked(), 2);

            event.setCancelled(true);
		}, 51);
		
		setStartingPoint(54);
		
		ItemStack blackClock = SkullItem.getSkull("http://textures.minecraft.net/texture/ba10da526e5111cfb6e3ebd47693e162dd52d41a2182028daa7c2b19aa3143");
		ItemMeta blackClockMeta = blackClock.getItemMeta();
		blackClockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.black-clock.name")));
		blackClockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.black-clock.lores")));
		blackClock.setItemMeta(blackClockMeta);
		
		addItem(blackClock, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hotToaster = SkullItem.getSkull("http://textures.minecraft.net/texture/9ed6ff4d0f2fd91847a836e476acf8d4afbadf4d841e0cd48746f7347cf42");
		ItemMeta hotToasterMeta = hotToaster.getItemMeta();
		hotToasterMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.hot-toaster.name")));
		hotToasterMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.hot-toaster.lores")));
		hotToaster.setItemMeta(hotToasterMeta);
		
		addItem(hotToaster, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack keypad = SkullItem.getSkull("http://textures.minecraft.net/texture/b01a568eba7e453b55f15545f5e35ffab8791aacf9034afbbbe4bddb21fa50");
		ItemMeta keypadMeta = keypad.getItemMeta();
		keypadMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.keypad.name")));
		keypadMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.keypad.lores")));
		keypad.setItemMeta(keypadMeta);
		
		addItem(keypad, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack speakers = SkullItem.getSkull("http://textures.minecraft.net/texture/2e99f669725d2358636ae2f5bc3439d667849daa8462af93a42e212af12b2a");
		ItemMeta speakersMeta = speakers.getItemMeta();
		speakersMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.speakers.name")));
		speakersMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.speakers.lores")));
		speakers.setItemMeta(speakersMeta);
		
		addItem(speakers, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blender = SkullItem.getSkull("http://textures.minecraft.net/texture/98636123b1a3755abd8aef6d85b2a85bf10f486edefdd1a3cef7679d825");
		ItemMeta blenderMeta = blender.getItemMeta();
		blenderMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.blender.name")));
		blenderMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.blender.lores")));
		blender.setItemMeta(blenderMeta);
		
		addItem(blender, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, event -> {
            open((Player) event.getWhoClicked());

            event.setCancelled(true);
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.devices.close.name")));
		close2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.devices.close.lores")));
		close2.setItemMeta(close2Meta);
		
		setItem(close2, event -> {
            Player player = (Player) event.getWhoClicked();

            player.closeInventory();
            removePlayer(player);

            event.setCancelled(true);
		}, 103);
	}
}