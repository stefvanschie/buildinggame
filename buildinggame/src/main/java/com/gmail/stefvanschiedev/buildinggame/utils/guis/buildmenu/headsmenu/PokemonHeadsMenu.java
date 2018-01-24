package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.SkullItem;

/**
 * The gui for the heads in the pokémon category
 *
 * @since 4.0.0
 */
public class PokemonHeadsMenu extends Gui {

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
    public PokemonHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.title")), 3);
		
		//page one
		ItemStack magikarp = SkullItem.getSkull("http://textures.minecraft.net/texture/2f58fb7cbf9f8dcfc3bc9d61c7cb5b229bf49db1101336ffdc2d087c0b94162");
		ItemMeta magikarpMeta = magikarp.getItemMeta();
		magikarpMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.magikarp.name")));
		magikarpMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.magikarp.lores")));
		magikarp.setItemMeta(magikarpMeta);
		
		addItem(magikarp, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack squirtle = SkullItem.getSkull("http://textures.minecraft.net/texture/f53ebc976cb6771f3e95117b326842ff7812c740bece96bb8858346d841");
		ItemMeta squirtleMeta = squirtle.getItemMeta();
		squirtleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.squirtle.name")));
		squirtleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.squirtle.lores")));
		squirtle.setItemMeta(squirtleMeta);
		
		addItem(squirtle, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack unfezant = SkullItem.getSkull("http://textures.minecraft.net/texture/f1fd1c83af7e7e5221efb1f4149f7d16f5980a251f0a5d71abe36690228a");
		ItemMeta unfezantMeta = unfezant.getItemMeta();
		unfezantMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.unfezant.name")));
		unfezantMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.unfezant.lores")));
		unfezant.setItemMeta(unfezantMeta);
		
		addItem(unfezant, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hydreigon = SkullItem.getSkull("http://textures.minecraft.net/texture/63975aaad2dbc317e3787bdebab9fb1eb4526b382fccdfeb181339b2154fba3");
		ItemMeta hydreigonMeta = hydreigon.getItemMeta();
		hydreigonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.hydreigon.name")));
		hydreigonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.hydreigon.lores")));
		hydreigon.setItemMeta(hydreigonMeta);
		
		addItem(hydreigon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack elektross = SkullItem.getSkull("http://textures.minecraft.net/texture/fe5ef634c7ee973cb04fe41e1dbb2f062b12c0726143d3bf232b2381f24b");
		ItemMeta elektrossMeta = elektross.getItemMeta();
		elektrossMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.elektross.name")));
		elektrossMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.elektross.lores")));
		elektross.setItemMeta(elektrossMeta);
		
		addItem(elektross, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack swanna = SkullItem.getSkull("http://textures.minecraft.net/texture/4c612d54332ecdaa438f21f7afd5443e91355cd1c6844f68a57bec6a93c3fa1");
		ItemMeta swannaMeta = swanna.getItemMeta();
		swannaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.swanna.name")));
		swannaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.swanna.lores")));
		swanna.setItemMeta(swannaMeta);
		
		addItem(swanna, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack magmar = SkullItem.getSkull("http://textures.minecraft.net/texture/a644660e54cc1fe315a99b94e199115c54cd77cbf7c6aef2470dbef4f68f327");
		ItemMeta magmarMeta = magmar.getItemMeta();
		magmarMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.magmar.name")));
		magmarMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.magmar.lores")));
		magmar.setItemMeta(magmarMeta);
		
		addItem(magmar, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack liepard = SkullItem.getSkull("http://textures.minecraft.net/texture/ce8524f6ac7624895bca23ae7d6777da5ac1ad0d726bf4e5684ca6fdbc2929b");
		ItemMeta liepardMeta = liepard.getItemMeta();
		liepardMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.liepard.name")));
		liepardMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.liepard.lores")));
		liepard.setItemMeta(liepardMeta);
		
		addItem(liepard, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lilligant = SkullItem.getSkull("http://textures.minecraft.net/texture/93e1faa993a47bda9bc7de0c693ca6c82726626bd25a7c064d7af779636a");
		ItemMeta lilligantMeta = lilligant.getItemMeta();
		lilligantMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.lilligant.name")));
		lilligantMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.lilligant.lores")));
		lilligant.setItemMeta(lilligantMeta);
		
		addItem(lilligant, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack bisharp = SkullItem.getSkull("http://textures.minecraft.net/texture/a5fe877042de302f88db7de2ac07cecdd3cb8b771d4c055a3723033215d5c");
		ItemMeta bisharpMeta = bisharp.getItemMeta();
		bisharpMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.bisharp.name")));
		bisharpMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.bisharp.lores")));
		bisharp.setItemMeta(bisharpMeta);
		
		addItem(bisharp, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gyarados = SkullItem.getSkull("http://textures.minecraft.net/texture/1ab93af668cb83e379e9edbcdc4532f1294f90cb13de6a582efab87696c36dd");
		ItemMeta gyaradosMeta = gyarados.getItemMeta();
		gyaradosMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.gyarados.name")));
		gyaradosMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.gyarados.lores")));
		gyarados.setItemMeta(gyaradosMeta);
		
		addItem(gyarados, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack beartic = SkullItem.getSkull("http://textures.minecraft.net/texture/7b608ed4523825a61f4baab896e38ebdbb83ee149d440b9a4e12bc9effb4a");
		ItemMeta bearticMeta = beartic.getItemMeta();
		bearticMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.beartic.name")));
		bearticMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.beartic.lores")));
		beartic.setItemMeta(bearticMeta);
		
		addItem(beartic, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack scrafty = SkullItem.getSkull("http://textures.minecraft.net/texture/2e519598c376db51c2ddd3387829d05c3569a0c7f19c501fdc96756761ed1");
		ItemMeta scraftyMeta = scrafty.getItemMeta();
		scraftyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.scrafty.name")));
		scraftyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.scrafty.lores")));
		scrafty.setItemMeta(scraftyMeta);
		
		addItem(scrafty, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack darmanitan = SkullItem.getSkull("http://textures.minecraft.net/texture/9ebeffa46355758795a153639fc1411fdfdd91ec13c1266ce6b87585e2fc1");
		ItemMeta darmanitanMeta = darmanitan.getItemMeta();
		darmanitanMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.darmanitan.name")));
		darmanitanMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.darmanitan.lores")));
		darmanitan.setItemMeta(darmanitanMeta);
		
		addItem(darmanitan, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack axew = SkullItem.getSkull("http://textures.minecraft.net/texture/d17cc1cb8492493548c90d714c23e8e71a1fcd0d47a43c11499d2c2bc422");
		ItemMeta axewMeta = axew.getItemMeta();
		axewMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.axew.name")));
		axewMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.axew.lores")));
		axew.setItemMeta(axewMeta);
		
		addItem(axew, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack nurseJoy = SkullItem.getSkull("http://textures.minecraft.net/texture/b3de38a1ceea6d9493df19a8b55bb238711cd5da4f435d2ec026376d874647");
		ItemMeta nurseJoyMeta = nurseJoy.getItemMeta();
		nurseJoyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.nurse-joy.name")));
		nurseJoyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.nurse-joy.lores")));
		nurseJoy.setItemMeta(nurseJoyMeta);
		
		addItem(nurseJoy, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack patrat = SkullItem.getSkull("http://textures.minecraft.net/texture/2bfe4a59b164548732fd5b754f266411969a2c2feb08a89b40a1293244abec");
		ItemMeta patratMeta = patrat.getItemMeta();
		patratMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.patrat.name")));
		patratMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.patrat.lores")));
		patrat.setItemMeta(patratMeta);
		
		addItem(patrat, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack throh = SkullItem.getSkull("http://textures.minecraft.net/texture/59f3acb937eea5ff447e4d45308635f6ac7923b0a504ccd2c8f671853b2edc");
		ItemMeta throhMeta = throh.getItemMeta();
		throhMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.throh.name")));
		throhMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.throh.lores")));
		throh.setItemMeta(throhMeta);
		
		addItem(throh, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sawk = SkullItem.getSkull("http://textures.minecraft.net/texture/1ef9c1d5f3bb4b19723bdd85f219675da0fc9dec5d8ab2e94a3d9fcab2d576");
		ItemMeta sawkMeta = sawk.getItemMeta();
		sawkMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.sawk.name")));
		sawkMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.sawk.lores")));
		sawk.setItemMeta(sawkMeta);
		
		addItem(sawk, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack zebstrika = SkullItem.getSkull("http://textures.minecraft.net/texture/34e8a47e55294eae66e250274baa15c11554c0624b633cc1d1787875e4b126");
		ItemMeta zebstrikaMeta = zebstrika.getItemMeta();
		zebstrikaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.zebstrika.name")));
		zebstrikaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.zebstrika.lores")));
		zebstrika.setItemMeta(zebstrikaMeta);
		
		addItem(zebstrika, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack charmeleon = SkullItem.getSkull("http://textures.minecraft.net/texture/d31711f33665b3e1e99ed8f5f50a63e3f6dec721af2391e34f83e15ce27af");
		ItemMeta charmeleonMeta = charmeleon.getItemMeta();
		charmeleonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.charmeleon.name")));
		charmeleonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.charmeleon.lores")));
		charmeleon.setItemMeta(charmeleonMeta);
		
		addItem(charmeleon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sylveon = SkullItem.getSkull("http://textures.minecraft.net/texture/d77a122e66286be8504e72979b47912bbe69136c2eac61baa2b7631d7e926b");
		ItemMeta sylveonMeta = sylveon.getItemMeta();
		sylveonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.sylveon.name")));
		sylveonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.sylveon.lores")));
		sylveon.setItemMeta(sylveonMeta);
		
		addItem(sylveon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack leafeon = SkullItem.getSkull("http://textures.minecraft.net/texture/b79daa21f9eeeb6dc7f656b055d6ac3090b3c586cbe411b91fb9829850da7c85");
		ItemMeta leafeonMeta = leafeon.getItemMeta();
		leafeonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.leafeon.name")));
		leafeonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.leafeon.lores")));
		leafeon.setItemMeta(leafeonMeta);
		
		addItem(leafeon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack glaceon = SkullItem.getSkull("http://textures.minecraft.net/texture/ddc53b753dee1af91819cf299bb44ee96829361149a887b01ad9741cc78b3e");
		ItemMeta glaceonMeta = glaceon.getItemMeta();
		glaceonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.glaceon.name")));
		glaceonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.glaceon.lores")));
		glaceon.setItemMeta(glaceonMeta);
		
		addItem(glaceon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack umbreon = SkullItem.getSkull("http://textures.minecraft.net/texture/25a8f67722bef093c67cce14587d67b375e27a82fa777a88218ba11af9c13b");
		ItemMeta umbreonMeta = umbreon.getItemMeta();
		umbreonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.umbreon.name")));
		umbreonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.umbreon.lores")));
		umbreon.setItemMeta(umbreonMeta);
		
		addItem(umbreon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack espeon = SkullItem.getSkull("http://textures.minecraft.net/texture/4cc375102ba41916297d72452cc482c75285b98e43db67ee5f4992aea043e2b1");
		ItemMeta espeonMeta = espeon.getItemMeta();
		espeonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.espeon.name")));
		espeonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.espeon.lores")));
		espeon.setItemMeta(espeonMeta);
		
		addItem(espeon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack flareon = SkullItem.getSkull("http://textures.minecraft.net/texture/5365872ebea5ea9d18049ab1cdb8f586f429e784610a37fbfb66b6dc6372");
		ItemMeta flareonMeta = flareon.getItemMeta();
		flareonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.flareon.name")));
		flareonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.flareon.lores")));
		flareon.setItemMeta(flareonMeta);
		
		addItem(flareon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack vlaporeon = SkullItem.getSkull("http://textures.minecraft.net/texture/61b79ee6b61c11e6a129b19c77bd307a482fec5ab363c66ab1f1e4265d32759");
		ItemMeta vlaporeonMeta = vlaporeon.getItemMeta();
		vlaporeonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.vlaporeon.name")));
		vlaporeonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.vlaporeon.lores")));
		vlaporeon.setItemMeta(vlaporeonMeta);
		
		addItem(vlaporeon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack jolteon = SkullItem.getSkull("http://textures.minecraft.net/texture/80d8c4853326f035b0105ed69801a909ca0b72e081fac0477c1fe5477024a5");
		ItemMeta jolteonMeta = jolteon.getItemMeta();
		jolteonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.jolteon.name")));
		jolteonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.jolteon.lores")));
		jolteon.setItemMeta(jolteonMeta);
		
		addItem(jolteon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pikachu = SkullItem.getSkull("http://textures.minecraft.net/texture/dfa695b59618b3616b6aaa910c5a10146195edd6367d25e9399a74ceef966");
		ItemMeta pikachuMeta = pikachu.getItemMeta();
		pikachuMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.pikachu.name")));
		pikachuMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.pikachu.lores")));
		pikachu.setItemMeta(pikachuMeta);
		
		addItem(pikachu, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cobalion = SkullItem.getSkull("http://textures.minecraft.net/texture/11c536c8fba596ae97ea50d683f1ebb895ddf662adceda91690bc597d3843");
		ItemMeta cobalionMeta = cobalion.getItemMeta();
		cobalionMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.cobalion.name")));
		cobalionMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.cobalion.lores")));
		cobalion.setItemMeta(cobalionMeta);
		
		addItem(cobalion, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack caterpie = SkullItem.getSkull("http://textures.minecraft.net/texture/8aa253fadd897a6a19aad3959c44fb4ceac5a8ca588f10e52ec8cfbb4144c6d");
		ItemMeta caterpieMeta = caterpie.getItemMeta();
		caterpieMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.caterpie.name")));
		caterpieMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.caterpie.lores")));
		caterpie.setItemMeta(caterpieMeta);
		
		addItem(caterpie, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack ash = SkullItem.getSkull("http://textures.minecraft.net/texture/a69ab8b0f19a1c99fe3ad86ea1a2ea2beeefba8e1b9343308743b7bcbd8");
		ItemMeta ashMeta = ash.getItemMeta();
		ashMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.ash.name")));
		ashMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.ash.lores")));
		ash.setItemMeta(ashMeta);
		
		addItem(ash, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack xerneas = SkullItem.getSkull("http://textures.minecraft.net/texture/73123f5959ce8d8210f672aa5491b6b50b97f27e3a846d55d352bc2f4c9eb");
		ItemMeta xerneasMeta = xerneas.getItemMeta();
		xerneasMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.xerneas.name")));
		xerneasMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.xerneas.lores")));
		xerneas.setItemMeta(xerneasMeta);
		
		addItem(xerneas, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack delphox = SkullItem.getSkull("http://textures.minecraft.net/texture/cb55c64b555c7f8654c55c7793a7e39abf5ee4d8cb7af98a8f197daafb6a0da");
		ItemMeta delphoxMeta = delphox.getItemMeta();
		delphoxMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.delphox.name")));
		delphoxMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.delphox.lores")));
		delphox.setItemMeta(delphoxMeta);
		
		addItem(delphox, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack chesnaught = SkullItem.getSkull("http://textures.minecraft.net/texture/4f86aec23f3a84782ade3e53baf7b8bf2b3a5113e24872ce2ddbf311f98d612d");
		ItemMeta chesnaughtMeta = chesnaught.getItemMeta();
		chesnaughtMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.chesnaught.name")));
		chesnaughtMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.chesnaught.lores")));
		chesnaught.setItemMeta(chesnaughtMeta);
		
		addItem(chesnaught, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack keldeo = SkullItem.getSkull("http://textures.minecraft.net/texture/c74eb1d592d62e92c1e6b77742810e32fd450f79bef9a9ef9d564f3ccb2990");
		ItemMeta keldeoMeta = keldeo.getItemMeta();
		keldeoMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.keldeo.name")));
		keldeoMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.keldeo.lores")));
		keldeo.setItemMeta(keldeoMeta);
		
		addItem(keldeo, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack kyurem = SkullItem.getSkull("http://textures.minecraft.net/texture/6b9f825dd7c9d58ac220bc94282517ce39ea9050e17a83e492d3aa1fb98edd81");
		ItemMeta kyuremMeta = kyurem.getItemMeta();
		kyuremMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.kyurem.name")));
		kyuremMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.kyurem.lores")));
		kyurem.setItemMeta(kyuremMeta);
		
		addItem(kyurem, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack zekrom = SkullItem.getSkull("http://textures.minecraft.net/texture/8fe7e1346aff253216ee0ce144f6c3d664d0d1dc6d9f6db47183cc679ce043");
		ItemMeta zekromMeta = zekrom.getItemMeta();
		zekromMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.zekrom.name")));
		zekromMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.zekrom.lores")));
		zekrom.setItemMeta(zekromMeta);
		
		addItem(zekrom, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack reshiram = SkullItem.getSkull("http://textures.minecraft.net/texture/1ff33de8876e3cdd89ae81835f3affc946bc498393c3644cfa04b6a6c89d2fd");
		ItemMeta reshiramMeta = reshiram.getItemMeta();
		reshiramMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.reshiram.name")));
		reshiramMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.reshiram.lores")));
		reshiram.setItemMeta(reshiramMeta);
		
		addItem(reshiram, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack scraggy = SkullItem.getSkull("http://textures.minecraft.net/texture/31be34e1e5421845c4c97cb9a9ef89f2fdccc92b1e2d4d9abb132339e90");
		ItemMeta scraggyMeta = scraggy.getItemMeta();
		scraggyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.scraggy.name")));
		scraggyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.scraggy.lores")));
		scraggy.setItemMeta(scraggyMeta);
		
		addItem(scraggy, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack samurott = SkullItem.getSkull("http://textures.minecraft.net/texture/c768bd25a2391ba9d27ff6e66efc8e346d1764b85b47b3c81e74481ece22ff");
		ItemMeta samurottMeta = samurott.getItemMeta();
		samurottMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.samurott.name")));
		samurottMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.samurott.lores")));
		samurott.setItemMeta(samurottMeta);
		
		addItem(samurott, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack emboar = SkullItem.getSkull("http://textures.minecraft.net/texture/771aa5f0114439d918f9eb2ea783d3a96f79192767d055fcca31eb6fb5114af2");
		ItemMeta emboarMeta = emboar.getItemMeta();
		emboarMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.emboar.name")));
		emboarMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.emboar.lores")));
		emboar.setItemMeta(emboarMeta);
		
		addItem(emboar, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack serperior = SkullItem.getSkull("http://textures.minecraft.net/texture/1d579c315f16dcc9b49d27ba1d6a0f3373dea9deebda43610c1a713ec884cd");
		ItemMeta serperiorMeta = serperior.getItemMeta();
		serperiorMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.serperior.name")));
		serperiorMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.serperior.lores")));
		serperior.setItemMeta(serperiorMeta);
		
		addItem(serperior, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack victini = SkullItem.getSkull("http://textures.minecraft.net/texture/1414854c864f7cb1b4b52509a2f42e93b2cadaedd289fb21ddeace6d877d59");
		ItemMeta victiniMeta = victini.getItemMeta();
		victiniMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.victini.name")));
		victiniMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.vicitini.lores")));
		victini.setItemMeta(victiniMeta);
		
		addItem(victini, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.close.lores")));
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
		nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.next-page.name")));
		nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, event -> {
            open((Player) event.getWhoClicked(), 2);

            event.setCancelled(true);
		}, 51);
		
		setStartingPoint(54);
		
		//page two
		ItemStack shaymin = SkullItem.getSkull("http://textures.minecraft.net/texture/bf58bf9f81637d364eae71037aa0a5c4c3a46b21697a6bdd1d1f653f5a");
		ItemMeta shayminMeta = shaymin.getItemMeta();
		shayminMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.shaymin.name")));
		shayminMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.shaymin.lores")));
		shaymin.setItemMeta(shayminMeta);
		
		addItem(shaymin, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack darkrai = SkullItem.getSkull("http://textures.minecraft.net/texture/d4ee7ed3f6eddc1017ab8cb5583e17fb7279d656a9da0c2838db36d217d39");
		ItemMeta darkraiMeta = darkrai.getItemMeta();
		darkraiMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.darkrai.name")));
		darkraiMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.darkrai.lores")));
		darkrai.setItemMeta(darkraiMeta);
		
		addItem(darkrai, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack giratina = SkullItem.getSkull("http://textures.minecraft.net/texture/416e2950e78ac0d1b19abac9d66bd4deb0dc59ac444f1841e8a7de8316eaab24");
		ItemMeta giratinaMeta = giratina.getItemMeta();
		giratinaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.giratina.name")));
		giratinaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.giratina.lores")));
		giratina.setItemMeta(giratinaMeta);
		
		addItem(giratina, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack palkia = SkullItem.getSkull("http://textures.minecraft.net/texture/5ca89418ecef16f5e489bb2874bfb2b0b31184c4144b3e78e534edba35689211");
		ItemMeta palkiaMeta = palkia.getItemMeta();
		palkiaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.palkia.name")));
		palkiaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.palkia.lores")));
		palkia.setItemMeta(palkiaMeta);
		
		addItem(palkia, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dialga = SkullItem.getSkull("http://textures.minecraft.net/texture/9aaed84ea4c3e06aba392a351555e4e94297166baeed514c927918e564e65834");
		ItemMeta dialgaMeta = dialga.getItemMeta();
		dialgaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.dialga.name")));
		dialgaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.dialga.lores")));
		dialga.setItemMeta(dialgaMeta);
		
		addItem(dialga, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack empoleon = SkullItem.getSkull("http://textures.minecraft.net/texture/42621d766c4e69f85928be4ceda0b996e95f5a20fe96232bd02ed42750d");
		ItemMeta empoleonMeta = empoleon.getItemMeta();
		empoleonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.empoleon.name")));
		empoleonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.empoleon.lores")));
		empoleon.setItemMeta(empoleonMeta);
		
		addItem(empoleon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack piplup = SkullItem.getSkull("http://textures.minecraft.net/texture/fa3ce7cae835b9d677a6753e25c688966ab670219b6a57888d2ef7d2833ddb68");
		ItemMeta piplupMeta = piplup.getItemMeta();
		piplupMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.piplup.name")));
		piplupMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.piplup.lores")));
		piplup.setItemMeta(piplupMeta);
		
		addItem(piplup, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack infernape = SkullItem.getSkull("http://textures.minecraft.net/texture/20dc8af9cc68ff1f2d7b4c680751f20ddcc20f1663ecc902b5d2b4f7b74d1f6");
		ItemMeta infernapeMeta = infernape.getItemMeta();
		infernapeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.infernape.name")));
		infernapeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.infernape.lores")));
		infernape.setItemMeta(infernapeMeta);
		
		addItem(infernape, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack torterra = SkullItem.getSkull("http://textures.minecraft.net/texture/bdc571a5e8285dc8f2fb61c918fa479e2779c86d16c982519dd751cce50");
		ItemMeta torterraMeta = torterra.getItemMeta();
		torterraMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.torterra.name")));
		torterraMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.torterra.lores")));
		torterra.setItemMeta(torterraMeta);
		
		addItem(torterra, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack deoxys = SkullItem.getSkull("http://textures.minecraft.net/texture/d59b284b39737d324935728a771ed1edbbbe34a298af6fc17bf07c2735f48");
		ItemMeta deoxysMeta = deoxys.getItemMeta();
		deoxysMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.deoxys.name")));
		deoxysMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.deoxys.lores")));
		deoxys.setItemMeta(deoxysMeta);
		
		addItem(deoxys, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack rayquaza = SkullItem.getSkull("http://textures.minecraft.net/texture/3a3eb5977d7d2df7cf06be17e1f6d0eed5bbc5ba34338cf2bbb8984a5d5ab");
		ItemMeta rayquazaMeta = rayquaza.getItemMeta();
		rayquazaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.rayquaza.name")));
		rayquazaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.rayquaza.lores")));
		rayquaza.setItemMeta(rayquazaMeta);
		
		addItem(rayquaza, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack groudon = SkullItem.getSkull("http://textures.minecraft.net/texture/b8465e86ffdab8ebf7b8cd3aff5d44f3a3c9be188ee7166eb540dc68f19bb8");
		ItemMeta groudonMeta = groudon.getItemMeta();
		groudonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.groudon.name")));
		groudonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.groudon.lores")));
		groudon.setItemMeta(groudonMeta);
		
		addItem(groudon, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack kyogre = SkullItem.getSkull("http://textures.minecraft.net/texture/bae97e627caf313cd9bf8dded41753e22a7f4381d13e3e622a16c0a04785636c");
		ItemMeta kyogreMeta = kyogre.getItemMeta();
		kyogreMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.kyogre.name")));
		kyogreMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.kyogre.lores")));
		kyogre.setItemMeta(kyogreMeta);
		
		addItem(kyogre, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack latios = SkullItem.getSkull("http://textures.minecraft.net/texture/517f45947c9b2753e593456b87c8cfdadb08c7b9a67c7535d9d3794ca6e36a");
		ItemMeta latiosMeta = latios.getItemMeta();
		latiosMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.latios.name")));
		latiosMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.latios.lores")));
		latios.setItemMeta(latiosMeta);
		
		addItem(latios, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack latias = SkullItem.getSkull("http://textures.minecraft.net/texture/3a738cf54ecba8abfe8fdbb2540779889122ea1a71f6c70d42ed4e18eed4ba");
		ItemMeta latiasMeta = latias.getItemMeta();
		latiasMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.latias.name")));
		latiasMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.latias.lores")));
		latias.setItemMeta(latiasMeta);
		
		addItem(latias, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack salamence = SkullItem.getSkull("http://textures.minecraft.net/texture/ee648a6e69887d328188270f665525ba399e34487571589b8f3f5696418efc");
		ItemMeta salamenceMeta = salamence.getItemMeta();
		salamenceMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.salamence.name")));
		salamenceMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.salamence.lores")));
		salamence.setItemMeta(salamenceMeta);
		
		addItem(salamence, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blaziken = SkullItem.getSkull("http://textures.minecraft.net/texture/4edc5ac9c9447e3a7a926fbc54dcf66d5e373b4921083a1fff0742395c92c");
		ItemMeta blazikenMeta = blaziken.getItemMeta();
		blazikenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.blaziken.name")));
		blazikenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.blaziken.lores")));
		blaziken.setItemMeta(blazikenMeta);
		
		addItem(blaziken, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack sceptile = SkullItem.getSkull("http://textures.minecraft.net/texture/9f8b6acfc8c718b775769476b38f2c3c072dd30ed2a35a280c0d3d8f3c4e18");
		ItemMeta sceptileMeta = sceptile.getItemMeta();
		sceptileMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.sceptile.name")));
		sceptileMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.sceptile.lores")));
		sceptile.setItemMeta(sceptileMeta);
		
		addItem(sceptile, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack hoOh = SkullItem.getSkull("http://textures.minecraft.net/texture/eebfbfe7a4fccbf566c9cf49de56e784bf6421c86a3524aaf54b6568942d");
		ItemMeta hoOhMeta = hoOh.getItemMeta();
		hoOhMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.ho-oh.name")));
		hoOhMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.ho-oh.lores")));
		hoOh.setItemMeta(hoOhMeta);
		
		addItem(hoOh, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lugia = SkullItem.getSkull("http://textures.minecraft.net/texture/669f4acbdcf32593a0a9c97efbddc01fba1a31a41beb9db13555139386fb337");
		ItemMeta lugiaMeta = lugia.getItemMeta();
		lugiaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.lugia.name")));
		lugiaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.lugia.lores")));
		lugia.setItemMeta(lugiaMeta);
		
		addItem(lugia, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack suicune = SkullItem.getSkull("http://textures.minecraft.net/texture/222bc95af0557a5940462025f253e9494cfcc56c5ff405e18805d133a87efd2");
		ItemMeta suicuneMeta = suicune.getItemMeta();
		suicuneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.suicune.name")));
		suicuneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.suicune.lores")));
		suicune.setItemMeta(suicuneMeta);
		
		addItem(suicune, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack entei = SkullItem.getSkull("http://textures.minecraft.net/texture/da4aee3f52e827185b9b982f5fa654fcbdda3657261ce7b5314c1b2576a8a85");
		ItemMeta enteiMeta = entei.getItemMeta();
		enteiMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.entei.name")));
		enteiMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.entei.lores")));
		entei.setItemMeta(enteiMeta);
		
		addItem(entei, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack raikou = SkullItem.getSkull("http://textures.minecraft.net/texture/b59c811c34d3cee4d5138317f753ce2e8dd1b7bade88bcdbbb5d74f5a21a828d");
		ItemMeta raikouMeta = raikou.getItemMeta();
		raikouMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.raikou.name")));
		raikouMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.raikou.lores")));
		raikou.setItemMeta(raikouMeta);
		
		addItem(raikou, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack typhlosion = SkullItem.getSkull("http://textures.minecraft.net/texture/cfe14acce9069f65edb34e3ad32f4d338116f71ea7a841e6c5643628c39f1b7");
		ItemMeta typhlosionMeta = typhlosion.getItemMeta();
		typhlosionMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.typhlosion.name")));
		typhlosionMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.typhlosion.lores")));
		typhlosion.setItemMeta(typhlosionMeta);
		
		addItem(typhlosion, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack meganium = SkullItem.getSkull("http://textures.minecraft.net/texture/bab68f63c55ad3aeb16167a2f98894c15eb8eaf2c35a93bec4a773d64ca9baf");
		ItemMeta meganiumMeta = meganium.getItemMeta();
		meganiumMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.meganium.name")));
		meganiumMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.meganium.lores")));
		meganium.setItemMeta(meganiumMeta);
		
		addItem(meganium, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mewtwo = SkullItem.getSkull("http://textures.minecraft.net/texture/5d2c4b481f327f44022bab393a418874b3f45acfc3bdf0609a889444b346");
		ItemMeta mewtwoMeta = mewtwo.getItemMeta();
		mewtwoMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.mewtwo.name")));
		mewtwoMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.mewtwo.lores")));
		mewtwo.setItemMeta(mewtwoMeta);
		
		addItem(mewtwo, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack dragonite = SkullItem.getSkull("http://textures.minecraft.net/texture/b15164dcedf88eb266c675bfd75c567c37b36b27e06469f3a44ce2697ed154");
		ItemMeta dragoniteMeta = dragonite.getItemMeta();
		dragoniteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.dragonite.name")));
		dragoniteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.dragonite.lores")));
		dragonite.setItemMeta(dragoniteMeta);
		
		addItem(dragonite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack blastoise = SkullItem.getSkull("http://textures.minecraft.net/texture/41df2bb91f4390aacfa2c3aabfe3de0269f4eb8b8f2dfdba2efa8cafc93ddd");
		ItemMeta blastoiseMeta = blastoise.getItemMeta();
		blastoiseMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.blastoise.name")));
		blastoiseMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.blastoise.lores")));
		blastoise.setItemMeta(blastoiseMeta);
		
		addItem(blastoise, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack venusaur = SkullItem.getSkull("http://textures.minecraft.net/texture/27331c53145c6b1766c5e4ad7d9824b28fa8fee277533c8f451f9c5070228a42");
		ItemMeta venusaurMeta = venusaur.getItemMeta();
		venusaurMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.venusaur.name")));
		venusaurMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.venusaur.lores")));
		venusaur.setItemMeta(venusaurMeta);
		
		addItem(venusaur, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack charizard = SkullItem.getSkull("http://textures.minecraft.net/texture/8937fba0b1e9885fb4a84c9150513dee8b217cd04f140d2505cab8ae39b5d4");
		ItemMeta charizardMeta = charizard.getItemMeta();
		charizardMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.charizard.name")));
		charizardMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.charizard.lores")));
		charizard.setItemMeta(charizardMeta);
		
		addItem(charizard, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack lucario = SkullItem.getSkull("http://textures.minecraft.net/texture/b9d8366592d9e2ba84cf52102f72397f7ccd286bac62133c0a71091febe");
		ItemMeta lucarioMeta = lucario.getItemMeta();
		lucarioMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.lucario.name")));
		lucarioMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.lucario.lores")));
		lucario.setItemMeta(lucarioMeta);
		
		addItem(lucario, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack feraligatr = SkullItem.getSkull("http://textures.minecraft.net/texture/ef919e7a55f95c27cf995b7a5a3cdec22ab997f8dffd4141ea08df66c60cd5d");
		ItemMeta feraligatrMeta = feraligatr.getItemMeta();
		feraligatrMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.feraligatr.name")));
		feraligatrMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.feraligatr.lores")));
		feraligatr.setItemMeta(feraligatrMeta);
		
		addItem(feraligatr, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pidgeot = SkullItem.getSkull("http://textures.minecraft.net/texture/26c96aef6558f29b247bc8e38d93206143f1314475c5fcd11e2efcc5db55e85");
		ItemMeta pidgeotMeta = pidgeot.getItemMeta();
		pidgeotMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.pidgeot.name")));
		pidgeotMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.pidgeot.lores")));
		pidgeot.setItemMeta(pidgeotMeta);
		
		addItem(pidgeot, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pidgey = SkullItem.getSkull("http://textures.minecraft.net/texture/016f595e8f6791bc154659a8976f6a8ffd9847cf75a2bf63992e3a655e0");
		ItemMeta pidgeyMeta = pidgey.getItemMeta();
		pidgeyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.pidgey.name")));
		pidgeyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.pidgey.lores")));
		pidgey.setItemMeta(pidgeyMeta);
		
		addItem(pidgey, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack metapod = SkullItem.getSkull("http://textures.minecraft.net/texture/a1eee2ace8b4a89572bd1a57d47fc1927b89abd60cc79cb8c77faa7458144e");
		ItemMeta metapodMeta = metapod.getItemMeta();
		metapodMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.metapod.name")));
		metapodMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.metapod.lores")));
		metapod.setItemMeta(metapodMeta);
		
		addItem(metapod, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack butterfree = SkullItem.getSkull("http://textures.minecraft.net/texture/5e2a53c27f72ff84795245bad23298d8a59a0613defbed626353fc66a95b");
		ItemMeta butterfreeMeta = butterfree.getItemMeta();
		butterfreeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.butterfree.name")));
		butterfreeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.butterfree.lores")));
		butterfree.setItemMeta(butterfreeMeta);
		
		addItem(butterfree, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack wartortle = SkullItem.getSkull("http://textures.minecraft.net/texture/47a0fd16ebfdbc51f9398e33835cee0c664a08142ee79f8ffc57d6b7eb518ef");
		ItemMeta wartortleMeta = wartortle.getItemMeta();
		wartortleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.wartortle.name")));
		wartortleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.wartortle.lores")));
		wartortle.setItemMeta(wartortleMeta);
		
		addItem(wartortle, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack bulbasaur = SkullItem.getSkull("http://textures.minecraft.net/texture/13e86a8a4231d1cee83714eb5e939c6d3078ea6832bf93eba66d12dc25ea95a");
		ItemMeta bulbasaurMeta = bulbasaur.getItemMeta();
		bulbasaurMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.bulbasaur.name")));
		bulbasaurMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.bulbasaur.lores")));
		bulbasaur.setItemMeta(bulbasaurMeta);
		
		addItem(bulbasaur, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack ivysaur = SkullItem.getSkull("http://textures.minecraft.net/texture/c99ec943b48c6f82f32acd9e8626546de8416cce4da41cbaa02c69feefbea");
		ItemMeta ivysaurMeta = ivysaur.getItemMeta();
		ivysaurMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.ivysaur.name")));
		ivysaurMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.ivysaur.lores")));
		ivysaur.setItemMeta(ivysaurMeta);
		
		addItem(ivysaur, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack swampert = SkullItem.getSkull("http://textures.minecraft.net/texture/b7fbd3667d3258c3c2a291497f427ab2b3ceaa5df0eff62edc3219dcd71570");
		ItemMeta swampertMeta = swampert.getItemMeta();
		swampertMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.swampert.name")));
		swampertMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.swampert.lores")));
		swampert.setItemMeta(swampertMeta);
		
		addItem(swampert, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack growlithe = SkullItem.getSkull("http://textures.minecraft.net/texture/815213d385268ad3bd179e613f1fac99fa8392831fc9f6f10db599cf59ceffb");
		ItemMeta growlitheMeta = growlithe.getItemMeta();
		growlitheMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.growlithe.name")));
		growlitheMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.growlithe.lores")));
		growlithe.setItemMeta(growlitheMeta);
		
		addItem(growlithe, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack greninja = SkullItem.getSkull("http://textures.minecraft.net/texture/492fd264cfc02f58cca7adf0fa698aaf8ef2339b2ee497c3bcff74eb9aeba912");
		ItemMeta greninjaMeta = greninja.getItemMeta();
		greninjaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.greninja.name")));
		greninjaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.greninja.lores")));
		greninja.setItemMeta(greninjaMeta);
		
		addItem(greninja, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack charmander = SkullItem.getSkull("http://textures.minecraft.net/texture/538992fa71d5d98789d5061ddd68e2b7af9efc253b39e1b346343d7789f8dc");
		ItemMeta charmanderMeta = charmander.getItemMeta();
		charmanderMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.charmander.name")));
		charmanderMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.charmander.lores")));
		charmander.setItemMeta(charmanderMeta);
		
		addItem(charmander, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack chespin = SkullItem.getSkull("http://textures.minecraft.net/texture/c56adf85cd8b886ec75b72d7612e5b6d2fd7d52e657316cb66f6d9d6826935a2");
		ItemMeta chespinMeta = chespin.getItemMeta();
		chespinMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.chespin.name")));
		chespinMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.chespin.lores")));
		chespin.setItemMeta(chespinMeta);
		
		addItem(chespin, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack terrakion = SkullItem.getSkull("http://textures.minecraft.net/texture/6dfb5e6f8c8267679b78280d5a10cd4122e50a97be29fa0f4f1c61ffd3fda");
		ItemMeta terrakionMeta = terrakion.getItemMeta();
		terrakionMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.terrakion.name")));
		terrakionMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.terrakion.lores")));
		terrakion.setItemMeta(terrakionMeta);
		
		addItem(terrakion, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, event -> {
            open((Player) event.getWhoClicked());

            event.setCancelled(true);
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.close.name")));
		close2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.close.lores")));
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
		next2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.next-page.name")));
		next2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.next-page.lores")));
		next2.setItemMeta(next2Meta);
		
		setItem(next2, event -> {
            open((Player) event.getWhoClicked(), 3);

            event.setCancelled(true);
		}, 105);
		
		setStartingPoint(108);
		
		//page three
		ItemStack virizion = SkullItem.getSkull("http://textures.minecraft.net/texture/edbf3a8ee9918e9c1c079ad6963e84ae82427cf4ea20fdc62aa1d640ceba");
		ItemMeta virizionMeta = virizion.getItemMeta();
		virizionMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.virizion.name")));
		virizionMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.virizion.lores")));
		virizion.setItemMeta(virizionMeta);
		
		addItem(virizion, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack noivern = SkullItem.getSkull("http://textures.minecraft.net/texture/f3e87cbba27059f5e8c34f599c25aab9422063eaba802c32776b3d80aad74f69");
		ItemMeta noivernMeta = noivern.getItemMeta();
		noivernMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.noivern.name")));
		noivernMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.noivern.lores")));
		noivern.setItemMeta(noivernMeta);
		
		addItem(noivern, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack jigglypuff = SkullItem.getSkull("http://textures.minecraft.net/texture/ba6f12621e5363595bc6d68fa185cedfceaada3d82b60c13fdc4a03269");
		ItemMeta jigglypuffMeta = jigglypuff.getItemMeta();
		jigglypuffMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.jigglypuff.name")));
		jigglypuffMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.jigglypuff.lores")));
		jigglypuff.setItemMeta(jigglypuffMeta);
		
		addItem(jigglypuff, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack grovyle = SkullItem.getSkull("http://textures.minecraft.net/texture/755cae4913e97f49838d4a8ddf711f9598d562bcb58e39f3d41c60d3be721");
		ItemMeta grovyleMeta = grovyle.getItemMeta();
		grovyleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.grovyle.name")));
		grovyleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.grovyle.lores")));
		grovyle.setItemMeta(grovyleMeta);
		
		addItem(grovyle, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gabite = SkullItem.getSkull("http://textures.minecraft.net/texture/14832ce2e65ac196482afe46dffcfd8529bc4779ccb7e9a52dfa5cbda144d5c");
		ItemMeta gabiteMeta = gabite.getItemMeta();
		gabiteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.gabite.name")));
		gabiteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.gabite.lores")));
		gabite.setItemMeta(gabiteMeta);
		
		addItem(gabite, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack pokemonEgg = SkullItem.getSkull("http://textures.minecraft.net/texture/e2a850feabb07349cfe245b26a264ea36df73338f84cd2ee3833b185e1e2e2d8");
		ItemMeta pokemonEggMeta = pokemonEgg.getItemMeta();
		pokemonEggMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.pokemon-egg.name")));
		pokemonEggMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.pokemon-egg.lores")));
		pokemonEgg.setItemMeta(pokemonEggMeta);
		
		addItem(pokemonEgg, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack articuno = SkullItem.getSkull("http://textures.minecraft.net/texture/fd4b9867dede93e8f226ff91b77d7a3ccaf3f6b1ef5f486ce62d11e943");
		ItemMeta articunoMeta = articuno.getItemMeta();
		articunoMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.articuno.name")));
		articunoMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.articuno.lores")));
		articuno.setItemMeta(articunoMeta);
		
		addItem(articuno, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack luxray = SkullItem.getSkull("http://textures.minecraft.net/texture/406051fc28fcfdbefb543ad78a2b254b254dd6f171c7346b46a46dd3923f");
		ItemMeta luxrayMeta = luxray.getItemMeta();
		luxrayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.luxray.name")));
		luxrayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.luxray.lores")));
		luxray.setItemMeta(luxrayMeta);
		
		addItem(luxray, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack arcanine = SkullItem.getSkull("http://textures.minecraft.net/texture/c430bda19c47bc791be11f5c74bcbd83effc606d291bb4d36988b766f6c6");
		ItemMeta arcanineMeta = arcanine.getItemMeta();
		arcanineMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.arcanine.name")));
		arcanineMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.arcanine.lores")));
		arcanine.setItemMeta(arcanineMeta);
		
		addItem(arcanine, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mightyena = SkullItem.getSkull("http://textures.minecraft.net/texture/d755de85c6b376206f8011f9cdf59414ade201fe4349be0ea15a7897e7014fa");
		ItemMeta mightyenaMeta = mightyena.getItemMeta();
		mightyenaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.mightyena.name")));
		mightyenaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.mightyena.lores")));
		mightyena.setItemMeta(mightyenaMeta);
		
		addItem(mightyena, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack eevee = SkullItem.getSkull("http://textures.minecraft.net/texture/a044e9d19bef47933aff42bce4b458f431315090d613f54b6e795da59db9d0de");
		ItemMeta eeveeMeta = eevee.getItemMeta();
		eeveeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.eevee.name")));
		eeveeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.eevee.lores")));
		eevee.setItemMeta(eeveeMeta);
		
		addItem(eevee, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack vulpix = SkullItem.getSkull("http://textures.minecraft.net/texture/92b764a7317e901c7bd8c248cd1387e6af6bc8335b89d923f618f8febbfb95");
		ItemMeta vulpixMeta = vulpix.getItemMeta();
		vulpixMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.vulpix.name")));
		vulpixMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.vulpix.lores")));
		vulpix.setItemMeta(vulpixMeta);
		
		addItem(vulpix, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack gengar = SkullItem.getSkull("http://textures.minecraft.net/texture/1428bcb2ad62567e1bd0d4dac6f473fe9de175db117422144c46575ff5e1");
		ItemMeta gengarMeta = gengar.getItemMeta();
		gengarMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.gengar.name")));
		gengarMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.gengar.lores")));
		gengar.setItemMeta(gengarMeta);
		
		addItem(gengar, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack raichu = SkullItem.getSkull("http://textures.minecraft.net/texture/abf523f2bd90b3ff1944515b6a324338aad47ea1f2ce93f82d5564c4c9ade71");
		ItemMeta raichuMeta = raichu.getItemMeta();
		raichuMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.raichu.name")));
		raichuMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.raichu.lores")));
		raichu.setItemMeta(raichuMeta);
		
		addItem(raichu, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack beedrill = SkullItem.getSkull("http://textures.minecraft.net/texture/ac48ca1ce447c1daa399b4de63bb190667f887caf6e3e8ed537f090a5fb64b8");
		ItemMeta beedrillMeta = beedrill.getItemMeta();
		beedrillMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.beedrill.name")));
		beedrillMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.beedrill.lores")));
		beedrill.setItemMeta(beedrillMeta);
		
		addItem(beedrill, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cubchoo = SkullItem.getSkull("http://textures.minecraft.net/texture/a4f451523dd66c4e892ae59aa79e9ddcc52904547f5df5f683108ddd422fec");
		ItemMeta cubchooMeta = cubchoo.getItemMeta();
		cubchooMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.cubchoo.name")));
		cubchooMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.cubchoo.lores")));
		cubchoo.setItemMeta(cubchooMeta);
		
		addItem(cubchoo, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack bidoof = SkullItem.getSkull("http://textures.minecraft.net/texture/e7a5e52183e41b28de41d9038883d399dc587d4eb230e696d8f6be6d3e57cf");
		ItemMeta bidoofMeta = bidoof.getItemMeta();
		bidoofMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.bidoof.name")));
		bidoofMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.bidoof.lores")));
		bidoof.setItemMeta(bidoofMeta);
		
		addItem(bidoof, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack buizel = SkullItem.getSkull("http://textures.minecraft.net/texture/2440972f1dcb244872d2f1026daceb94dadb9851ca5932e15154ffe7e3be8");
		ItemMeta buizelMeta = buizel.getItemMeta();
		buizelMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.buizel.name")));
		buizelMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.buizel.lores")));
		buizel.setItemMeta(buizelMeta);
		
		addItem(buizel, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack arceus = SkullItem.getSkull("http://textures.minecraft.net/texture/3c7eade726b391f7f3ab5d8b5cfc7376558baa885de229d6dcbd6b64ec89aa70");
		ItemMeta arceusMeta = arceus.getItemMeta();
		arceusMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.arceus.name")));
		arceusMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.arceus.lores")));
		arceus.setItemMeta(arceusMeta);
		
		addItem(arceus, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack flaaffy = SkullItem.getSkull("http://textures.minecraft.net/texture/fa2137f3844b031432e3236317d5553fb247efe72ee686b859cdcc4f19e2c3");
		ItemMeta flaaffyMeta = flaaffy.getItemMeta();
		flaaffyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.flaaffy.name")));
		flaaffyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.flaaffy.lores")));
		flaaffy.setItemMeta(flaaffyMeta);
		
		addItem(flaaffy, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack deino = SkullItem.getSkull("http://textures.minecraft.net/texture/fb9a67c7905d1ae7c8653f6a6e9f54919f8926d3671423a5fafae6c95b9298");
		ItemMeta deinoMeta = deino.getItemMeta();
		deinoMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.deino.name")));
		deinoMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.deino.lores")));
		deino.setItemMeta(deinoMeta);
		
		addItem(deino, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack muk = SkullItem.getSkull("http://textures.minecraft.net/texture/9ae568ee5978349adc63a5bf37f082ef5512bb264cdb7598efecd71f42d13");
		ItemMeta mukMeta = muk.getItemMeta();
		mukMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.muk.name")));
		mukMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.muk.lores")));
		muk.setItemMeta(mukMeta);
		
		addItem(muk, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack oshawott = SkullItem.getSkull("http://textures.minecraft.net/texture/62b1b36b298597cda26f72652caf84e0e7ddfab54dff6f5259371743e2585");
		ItemMeta oshawottMeta = oshawott.getItemMeta();
		oshawottMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.oshawott.name")));
		oshawottMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.oshawott.lores")));
		oshawott.setItemMeta(oshawottMeta);
		
		addItem(oshawott, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cresselia = SkullItem.getSkull("http://textures.minecraft.net/texture/18c8da5a2a773ce4f5f529674c2df505e6fb8e85d71399b1f56640beb2fde7");
		ItemMeta cresseliaMeta = cresselia.getItemMeta();
		cresseliaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.cresselia.name")));
		cresseliaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.cresselia.lores")));
		cresselia.setItemMeta(cresseliaMeta);
		
		addItem(cresselia, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack yveltal = SkullItem.getSkull("http://textures.minecraft.net/texture/15ae64c87de451ff1128251493537eae3ed5362980aacd591cb5e12b5cf7a257");
		ItemMeta yveltalMeta = yveltal.getItemMeta();
		yveltalMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.yveltal.name")));
		yveltalMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.yveltal.lores")));
		yveltal.setItemMeta(yveltalMeta);
		
		addItem(yveltal, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack wailord = SkullItem.getSkull("http://textures.minecraft.net/texture/421142172424b210b17a9ca2f449a44495184adf83c964d385fa758a120");
		ItemMeta wailordMeta = wailord.getItemMeta();
		wailordMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.wailord.name")));
		wailordMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.wailord.lores")));
		wailord.setItemMeta(wailordMeta);
		
		addItem(wailord, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack moltres = SkullItem.getSkull("http://textures.minecraft.net/texture/2cf022a89ef21fada26d9f648e15cdf43f2edb74971f4423ceb5ac4a343a5f");
		ItemMeta moltresMeta = moltres.getItemMeta();
		moltresMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.moltres.name")));
		moltresMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.moltres.lores")));
		moltres.setItemMeta(moltresMeta);
		
		addItem(moltres, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack mew = SkullItem.getSkull("http://textures.minecraft.net/texture/35cd3c72dcc7eedcffcb2221b38b5b8ac4705ffdc457461a816538874b4cf");
		ItemMeta mewMeta = mew.getItemMeta();
		mewMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.mew.name")));
		mewMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.mew.lores")));
		mew.setItemMeta(mewMeta);
		
		addItem(mew, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack zygarde = SkullItem.getSkull("http://textures.minecraft.net/texture/5054a019f45d7aa619dd5be1d4e68c79c0dfacb260681439c7b413869c8dc7");
		ItemMeta zygardeMeta = zygarde.getItemMeta();
		zygardeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.zygarde.name")));
		zygardeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.zygarde.lores")));
		zygarde.setItemMeta(zygardeMeta);
		
		addItem(zygarde, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack zapdos = SkullItem.getSkull("http://textures.minecraft.net/texture/49a66f3d258d927f7e4818148bac67b23e7924a93b89f3c96b8754bfcb48f75");
		ItemMeta zapdosMeta = zapdos.getItemMeta();
		zapdosMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.zapdos.name")));
		zapdosMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.zapdos.lores")));
		zapdos.setItemMeta(zapdosMeta);
		
		addItem(zapdos, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack manaphy = SkullItem.getSkull("http://textures.minecraft.net/texture/c71f2f1d5e4feae6f893816a8cc789155366747264f9a36efc713bb8f9c3d6");
		ItemMeta manaphyMeta = manaphy.getItemMeta();
		manaphyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.manaphy.name")));
		manaphyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.manaphy.lores")));
		manaphy.setItemMeta(manaphyMeta);
		
		addItem(manaphy, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack koffing = SkullItem.getSkull("http://textures.minecraft.net/texture/f176dec49a931096a09b22add0402ab2c7f48987711091d018e02b4bb1e57");
		ItemMeta koffingMeta = koffing.getItemMeta();
		koffingMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.koffing.name")));
		koffingMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.koffing.lores")));
		koffing.setItemMeta(koffingMeta);
		
		addItem(koffing, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack omanyte = SkullItem.getSkull("http://textures.minecraft.net/texture/ac738fcb69c48ef60d654da4c2c493c75b7c29fbf8d836bdf5f98bcab8ba");
		ItemMeta omanyteMeta = omanyte.getItemMeta();
		omanyteMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.omanyte.name")));
		omanyteMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.omanyte.lores")));
		omanyte.setItemMeta(omanyteMeta);
		
		addItem(omanyte, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack cubone = SkullItem.getSkull("http://textures.minecraft.net/texture/7a4fa71ad28cd1e1b7ea93581730825cba96cac3cd3b1bc72a97ea54de534");
		ItemMeta cuboneMeta = cubone.getItemMeta();
		cuboneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.cubone.name")));
		cuboneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.cubone.lores")));
		cubone.setItemMeta(cuboneMeta);
		
		addItem(cubone, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack voltorb = SkullItem.getSkull("http://textures.minecraft.net/texture/e2f3f9cca77c725217e45ad4eeeeffa0565f82b866ac67999b43c3a97311628c");
		ItemMeta voltorbMeta = voltorb.getItemMeta();
		voltorbMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.voltorb.name")));
		voltorbMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.voltorb.lores")));
		voltorb.setItemMeta(voltorbMeta);
		
		addItem(voltorb, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack electrode = SkullItem.getSkull("http://textures.minecraft.net/texture/5eefe1191579957c83250a8ce8fefd55f4d76c50d81094c9209895f4bd600");
		ItemMeta electrodeMeta = electrode.getItemMeta();
		electrodeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.electrode.name")));
		electrodeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.electrode.lores")));
		electrode.setItemMeta(electrodeMeta);
		
		addItem(electrode, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack weedle = SkullItem.getSkull("http://textures.minecraft.net/texture/629659d11e2d4f30c3e5947a1fc9321a8d9c105ed72e927a50cb3e8d7291533");
		ItemMeta weedleMeta = weedle.getItemMeta();
		weedleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.weedle.name")));
		weedleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.weedle.lores")));
		weedle.setItemMeta(weedleMeta);
		
		addItem(weedle, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		ItemStack kakuna = SkullItem.getSkull("http://textures.minecraft.net/texture/9a9a801f119c631a9c9fa047a2c25bc0b6cbf908237d74cb1a41085107c597");
		ItemMeta kakunaMeta = kakuna.getItemMeta();
		kakunaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.kakuna.name")));
		kakunaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.kakuna.lores")));
		kakuna.setItemMeta(kakunaMeta);
		
		addItem(kakuna, event -> {
            event.setCursor(event.getCurrentItem());
            event.setCancelled(true);
        });
		
		//previous page
		ItemStack previous3 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous3Meta = previous3.getItemMeta();
		previous3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.previous-page.name")));
		previous3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.previous-page.lores")));
		previous3.setItemMeta(previous3Meta);
		
		setItem(previous3, event -> {
            open((Player) event.getWhoClicked(), 2);

            event.setCancelled(true);
		}, 155);
		
		//close
		ItemStack close3 = new ItemStack(Material.BOOK);
		ItemMeta close3Meta = close3.getItemMeta();
		close3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.pokemon.close.name")));
		close3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.pokemon.close.lores")));
		close3.setItemMeta(close3Meta);
		
		setItem(close3, event -> {
            Player player = (Player) event.getWhoClicked();

            player.closeInventory();
            removePlayer(player);

            event.setCancelled(true);
		}, 157);
	}
}