package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.SkullItem;

/**
 * The gui for the heads in the colors category
 *
 * @since 4.0.0
 */
public class ColorsHeadsMenu extends Gui {

    /**
     * Yaml Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new menu and adds all items to it
     *
     * @since 4.0.0
     */
	public ColorsHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.colors.title")), 1);
		
		ItemStack skyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/c1482b755858657fb51b7d3fbf4cd8c090c05e35bd8cdba98b19499d7833acb2");
		ItemMeta skyBlueMeta = skyBlue.getItemMeta();
		skyBlueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.sky-blue.name")));
		skyBlueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.sky-blue.lores")));
		skyBlue.setItemMeta(skyBlueMeta);
		
		addItem(skyBlue, new Action());
		
		ItemStack skyBlue2 = SkullItem.getSkull("http://textures.minecraft.net/texture/489ce89526fc12624678f305493aa65da8a1b360546a505d118eb1fad775");
		ItemMeta skyBlue2Meta = skyBlue2.getItemMeta();
		skyBlue2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.sky-blue-2.name")));
		skyBlue2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.sky-blue-2.lores")));
		skyBlue2.setItemMeta(skyBlue2Meta);
		
		addItem(skyBlue2, new Action());
		
		ItemStack babyBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/7d31d21cb54294ee3a2056137d123b576f78bfc4878cd8144cd51e1931c39b5");
		ItemMeta babyBlueMeta = babyBlue.getItemMeta();
		babyBlueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.baby-blue.name")));
		babyBlueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.baby-blue.lores")));
		babyBlue.setItemMeta(babyBlueMeta);
		
		addItem(babyBlue, new Action());
		
		ItemStack brightGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
		ItemMeta brightGreenMeta = brightGreen.getItemMeta();
		brightGreenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.bright-green.name")));
		brightGreenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.bright-green.lores")));
		brightGreen.setItemMeta(brightGreenMeta);
		
		addItem(brightGreen, new Action());
		
		ItemStack green = SkullItem.getSkull("http://textures.minecraft.net/texture/36f69f7b7538b41dc3439f3658abbd59facca366f190bcf1d6d0a026c8f96");
		ItemMeta greenMeta = green.getItemMeta();
		greenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.green.name")));
		greenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.green.lores")));
		green.setItemMeta(greenMeta);
		
		addItem(green, new Action());
		
		ItemStack grassGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/c94092014d8fa7981e79029f957b6884c4c2a53a935afc36ae114d279ce58");
		ItemMeta grassGreenMeta = grassGreen.getItemMeta();
		grassGreenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.grass-green.name")));
		grassGreenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.grass-green.lores")));
		grassGreen.setItemMeta(grassGreenMeta);
		
		addItem(grassGreen, new Action());
		
		ItemStack mediumGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/7dc61bfe3f5255c1266751173177dbd389ad80f5c16344beddf2871bf2baa2");
		ItemMeta mediumGreenMeta = mediumGreen.getItemMeta();
		mediumGreenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.medium-green.name")));
		mediumGreenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.medium-green.lores")));
		mediumGreen.setItemMeta(mediumGreenMeta);
		
		addItem(mediumGreen, new Action());
		
		ItemStack darkGreen = SkullItem.getSkull("http://textures.minecraft.net/texture/1cf3e422b322b1e9245b4b368433045c7b43c909e5dd6c792e4b6beda54303c");
		ItemMeta darkGreenMeta = darkGreen.getItemMeta();
		darkGreenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.dark-green.name")));
		darkGreenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.dark-green.lores")));
		darkGreen.setItemMeta(darkGreenMeta);
		
		addItem(darkGreen, new Action());
		
		ItemStack darkYellow = SkullItem.getSkull("http://textures.minecraft.net/texture/d45b44fd19d72fb3d6e189c4978b1ca687dbd6580b18ddd8aa710edffa5");
		ItemMeta darkYellowMeta = darkYellow.getItemMeta();
		darkYellowMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.dark-yellow.name")));
		darkYellowMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.dark-yellow.lores")));
		darkYellow.setItemMeta(darkYellowMeta);
		
		addItem(darkYellow, new Action());
		
		ItemStack yellow = SkullItem.getSkull("http://textures.minecraft.net/texture/63e1c697e3106443976da0f53ece9d60a25bd4d4fce461951286ef59bd9091");
		ItemMeta yellowMeta = yellow.getItemMeta();
		yellowMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.yellow.name")));
		yellowMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.yellow.lores")));
		yellow.setItemMeta(yellowMeta);
		
		addItem(yellow, new Action());
		
		ItemStack lightOrange = SkullItem.getSkull("http://textures.minecraft.net/texture/26db6648cab054aaea7feff6518e25e4fb7d2f6f272e2502cc3177dd7836c8b");
		ItemMeta lightOrangeMeta = lightOrange.getItemMeta();
		lightOrangeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.light-orange.name")));
		lightOrangeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.light-orange.lores")));
		lightOrange.setItemMeta(lightOrangeMeta);
		
		addItem(lightOrange, new Action());
		
		ItemStack orange = SkullItem.getSkull("http://textures.minecraft.net/texture/fea590b681589fb9b0e8664ee945b41eb3851faf66aaf48525fba169c34270");
		ItemMeta orangeMeta = orange.getItemMeta();
		orangeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.orange.name")));
		orangeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.orange.lores")));
		orange.setItemMeta(orangeMeta);
		
		addItem(orange, new Action());
		
		ItemStack lightRed = SkullItem.getSkull("http://textures.minecraft.net/texture/4bac77520b9eee65068ef1cd8abeadb013b4de3953fd29ac68e90e4866227");
		ItemMeta lightRedMeta = lightRed.getItemMeta();
		lightRedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.light-red.name")));
		lightRedMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.light-red.lores")));
		lightRed.setItemMeta(lightRedMeta);
		
		addItem(lightRed, new Action());
		
		ItemStack red = SkullItem.getSkull("http://textures.minecraft.net/texture/97c1f1ead4d531caa4a5b0d69edbce29af789a2550e5ddbd23775be05e2df2c4");
		ItemMeta redMeta = red.getItemMeta();
		redMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.red.name")));
		redMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.red.lores")));
		red.setItemMeta(redMeta);
		
		addItem(red, new Action());
		
		ItemStack red2 = SkullItem.getSkull("http://textures.minecraft.net/texture/3f42564720c8e5598eff2cde218b4665f2b6aa4e59a5b4f3fd15ef875648fe");
		ItemMeta red2Meta = red2.getItemMeta();
		red2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.red-2.name")));
		red2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.red-2.lores")));
		red2.setItemMeta(red2Meta);
		
		addItem(red2, new Action());
		
		ItemStack darkRed = SkullItem.getSkull("http://textures.minecraft.net/texture/51014e4f41d7729928f215555da2eaf158ce83d9e0c9961bef5eb7613d37e");
		ItemMeta darkRedMeta = darkRed.getItemMeta();
		darkRedMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.dark-red.name")));
		darkRedMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.dark-red.lores")));
		darkRed.setItemMeta(darkRedMeta);
		
		addItem(darkRed, new Action());
		
		ItemStack azureBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/3b19dc4d467882dbca1b5c37465f0cfc70ff1f829ecf4a865796b8e5c2809a");
		ItemMeta azureBlueMeta = azureBlue.getItemMeta();
		azureBlueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.azure-blue.name")));
		azureBlueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.azure-blue.lores")));
		azureBlue.setItemMeta(azureBlueMeta);
		
		addItem(azureBlue, new Action());
		
		ItemStack cyan = SkullItem.getSkull("http://textures.minecraft.net/texture/6f43d885df889c8a16e44ab4661b65fcb73fe22305cfdcc247d21767b0c24d");
		ItemMeta cyanMeta = cyan.getItemMeta();
		cyanMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.cyan.name")));
		cyanMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.cyan.lores")));
		cyan.setItemMeta(cyanMeta);
		
		addItem(cyan, new Action());
		
		ItemStack darkishBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/8d2774cbcfd7f29fc5b7e5d322846d1d9d077b2fa5fb347328cdb8944fe417");
		ItemMeta darkishBlueMeta = darkishBlue.getItemMeta();
		darkishBlueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.darkish-blue.name")));
		darkishBlueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.darkish-blue.lores")));
		darkishBlue.setItemMeta(darkishBlueMeta);
		
		addItem(darkishBlue, new Action());
		
		ItemStack blue = SkullItem.getSkull("http://textures.minecraft.net/texture/f2588972477e807b989983ca27a48fe27c5151b226b6204d92b4b83b9c11ed");
		ItemMeta blueMeta = blue.getItemMeta();
		blueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.blue.name")));
		blueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.blue.lores")));
		blue.setItemMeta(blueMeta);
		
		addItem(blue, new Action());
		
		ItemStack darkCyan = SkullItem.getSkull("http://textures.minecraft.net/texture/b784c152bfc3e2e313ef23fc46d44fce41e4adad9421bac2da3894511cc03b");
		ItemMeta darkCyanMeta = darkCyan.getItemMeta();
		darkCyanMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.dark-cyan.name")));
		darkCyanMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.dark-cyan.lores")));
		darkCyan.setItemMeta(darkCyanMeta);
		
		addItem(darkCyan, new Action());
		
		ItemStack darkBlue = SkullItem.getSkull("http://textures.minecraft.net/texture/12306a98787e526ce973bd56124e645a2e2329d563dcfa68a1be65767f29b5");
		ItemMeta darkBlueMeta = darkBlue.getItemMeta();
		darkBlueMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.dark-blue.name")));
		darkBlueMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.dark-blue.lores")));
		darkBlue.setItemMeta(darkBlueMeta);
		
		addItem(darkBlue, new Action());
		
		ItemStack purple = SkullItem.getSkull("http://textures.minecraft.net/texture/641685f36a4e55a584964b24d668efcf3d94fad49c9ea46478f696e790c3c2");
		ItemMeta purpleMeta = purple.getItemMeta();
		purpleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.purple.name")));
		purpleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.purple.lores")));
		purple.setItemMeta(purpleMeta);
		
		addItem(purple, new Action());
		
		ItemStack pink = SkullItem.getSkull("http://textures.minecraft.net/texture/1fc25a5320f85c78dddb55fb2571f563ac48e3f53e62bbe1ffbaf6a8ff1b87");
		ItemMeta pinkMeta = pink.getItemMeta();
		pinkMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.pink.name")));
		pinkMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.pink.lores")));
		pink.setItemMeta(pinkMeta);
		
		addItem(pink, new Action());
		
		ItemStack magenta = SkullItem.getSkull("http://textures.minecraft.net/texture/67d52fdfbc44cac5735388c7bd9a6ef773e3c353182fa63784f1469edda921");
		ItemMeta magentaMeta = magenta.getItemMeta();
		magentaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.magenta.name")));
		magentaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.magenta.lores")));
		magenta.setItemMeta(magentaMeta);
		
		addItem(magenta, new Action());
		
		ItemStack pink2 = SkullItem.getSkull("http://textures.minecraft.net/texture/7557db5f15ca6f3701903cca402ce77ec6f885036b6812e8288abd7e94");
		ItemMeta pink2Meta = pink2.getItemMeta();
		pink2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.pink-2.name")));
		pink2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.pink-2.lores")));
		pink2.setItemMeta(pink2Meta);
		
		addItem(pink2, new Action());
		
		ItemStack pink3 = SkullItem.getSkull("http://textures.minecraft.net/texture/607326d31858ea57e7bc55f3e75e6c85b34ff4bfd28088f94f11eb8e0d1cf");
		ItemMeta pink3Meta = pink3.getItemMeta();
		pink3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.pink-3.name")));
		pink3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.pink-3.lores")));
		pink3.setItemMeta(pink3Meta);
		
		addItem(pink3, new Action());
		
		ItemStack cream = SkullItem.getSkull("http://textures.minecraft.net/texture/bf76294011cbdcd2e92941dafe6b3726dff02c3e1f84dfa57c6abab6fc33ce6");
		ItemMeta creamMeta = cream.getItemMeta();
		creamMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.cream.name")));
		creamMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.cream.lores")));
		cream.setItemMeta(creamMeta);
		
		addItem(cream, new Action());
		
		ItemStack mokka = SkullItem.getSkull("http://textures.minecraft.net/texture/bad5983dcabc931ab6a49d2fb8879ebc5295cb5ba2f278e3c8a3da7bc8b478");
		ItemMeta mokkaMeta = mokka.getItemMeta();
		mokkaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.mokka.name")));
		mokkaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.mokka.lores")));
		mokka.setItemMeta(mokkaMeta);
		
		addItem(mokka, new Action());
		
		ItemStack brown = SkullItem.getSkull("http://textures.minecraft.net/texture/4574a467737295bd9ddc82545a1a4e146a943d05ecc821f9cc6a543ffe9934a");
		ItemMeta brownMeta = brown.getItemMeta();
		brownMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.brown.name")));
		brownMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.brown.lores")));
		brown.setItemMeta(brownMeta);
		
		addItem(brown, new Action());
		
		ItemStack whiteBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/9fd3f28efeb068d53ba24b0324b9661b918c88f94b433dbff9a25e2f218b9");
		ItemMeta whiteBlockMeta = whiteBlock.getItemMeta();
		whiteBlockMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.white-block.name")));
		whiteBlockMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.white-block.lores")));
		whiteBlock.setItemMeta(whiteBlockMeta);
		
		addItem(whiteBlock, new Action());
		
		ItemStack lightGrey = SkullItem.getSkull("http://textures.minecraft.net/texture/31c45a59550143a44ed4e87ce2955e4a13e94cdfd4c64dee881dfb48dd92e");
		ItemMeta lightGreyMeta = lightGrey.getItemMeta();
		lightGreyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.light-grey.name")));
		lightGreyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.light-grey.lores")));
		lightGrey.setItemMeta(lightGreyMeta);
		
		addItem(lightGrey, new Action());
		
		ItemStack grey = SkullItem.getSkull("http://textures.minecraft.net/texture/5e2e209b9990a63368de29bfa7b8522d54935d3c95cad9a81f4af2f3a7de");
		ItemMeta greyMeta = grey.getItemMeta();
		greyMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.grey.name")));
		greyMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.grey.lores")));
		grey.setItemMeta(greyMeta);
		
		addItem(grey, new Action());
		
		ItemStack black = SkullItem.getSkull("http://textures.minecraft.net/texture/9ddebbb062f6a385a91ca05f18f5c0acbe33e2d06ee9e7416cef6ee43dfe2fb");
		ItemMeta blackMeta = black.getItemMeta();
		blackMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.black.name")));
		blackMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.black.lores")));
		black.setItemMeta(blackMeta);
		
		addItem(black, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.colors.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.colors.close.lores")));
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 49);
	}

    /**
     * The action that belongs to the heads
     *
     * @since 4.0.0
     */
	public class Action extends GuiAction {

        /**
         * Called whenever a player clicks on an item in the menu
         *
         * @since 4.0.0
         */
		@SuppressWarnings("deprecation")
		@Override
		public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
			if (type != GuiActionType.CLICK)
				return false;
			
			InventoryClickEvent event = (InventoryClickEvent) e;
			event.setCursor(event.getCurrentItem());
			return true;
		}
	}
}