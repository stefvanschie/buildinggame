package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A gui for selecting the color for the next pattern
 *
 * @since 5.2.0
 */
class ColorBannerMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * {@inheritDoc}
     */
    ColorBannerMenu(ItemStack banner) {
        super(null, 27,
                MessageManager.translate(MESSAGES.getString("gui.banners.color.title")), 1);

        //black banner
        ItemStack blackBanner = new ItemStack(Material.INK_SACK);
        ItemMeta blackBannerMeta = blackBanner.getItemMeta();
        blackBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.black.name")));
        blackBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.black.lore")));

        addItem(blackBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.BLACK).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //red banner
        ItemStack redBanner = new ItemStack(Material.INK_SACK, 1, (short) 1);
        ItemMeta redBannerMeta = redBanner.getItemMeta();
        redBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.red.name")));
        redBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.red.lore")));

        addItem(redBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.RED).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //green banner
        ItemStack greenBanner = new ItemStack(Material.INK_SACK, 1, (short) 2);
        ItemMeta greenBannerMeta = greenBanner.getItemMeta();
        greenBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.green.name")));
        greenBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.green.lore")));

        addItem(greenBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.GREEN).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //brown banner
        ItemStack brownBanner = new ItemStack(Material.INK_SACK, 1, (short) 3);
        ItemMeta brownBannerMeta = brownBanner.getItemMeta();
        brownBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.brown.name")));
        brownBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.brown.lore")));

        addItem(brownBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.BROWN).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //blue banner
        ItemStack blueBanner = new ItemStack(Material.INK_SACK, 1, (short) 4);
        ItemMeta blueBannerMeta = blueBanner.getItemMeta();
        blueBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.blue.name")));
        blueBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.blue.lore")));

        addItem(blueBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.BLUE).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //purple banner
        ItemStack purpleBanner = new ItemStack(Material.INK_SACK, 1, (short) 5);
        ItemMeta purpleBannerMeta = purpleBanner.getItemMeta();
        purpleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.purple.name")));
        purpleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.purple.lore")));

        addItem(purpleBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.PURPLE).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //cyan banner
        ItemStack cyanBanner = new ItemStack(Material.INK_SACK, 1, (short) 6);
        ItemMeta cyanBannerMeta = cyanBanner.getItemMeta();
        cyanBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.cyan.name")));
        cyanBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.cyan.lore")));

        addItem(cyanBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.CYAN).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //light gray banner
        ItemStack lightGrayBanner = new ItemStack(Material.INK_SACK, 1, (short) 7);
        ItemMeta lightGrayBannerMeta = lightGrayBanner.getItemMeta();
        lightGrayBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.light-gray.name")));
        lightGrayBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.light-gray.lore")));

        addItem(lightGrayBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.SILVER).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //gray banner
        ItemStack grayBanner = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta grayBannerMeta = grayBanner.getItemMeta();
        grayBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.gray.name")));
        grayBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.gray.lore")));

        addItem(grayBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.GRAY).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        setStartingPoint(10);

        //pink banner
        ItemStack pinkBanner = new ItemStack(Material.INK_SACK, 1, (short) 9);
        ItemMeta pinkBannerMeta = pinkBanner.getItemMeta();
        pinkBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.pink.name")));
        pinkBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.pink.lore")));

        addItem(pinkBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.PINK).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //lime banner
        ItemStack limeBanner = new ItemStack(Material.INK_SACK, 1, (short) 10);
        ItemMeta limeBannerMeta = limeBanner.getItemMeta();
        limeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.lime.name")));
        limeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.lime.lore")));

        addItem(limeBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.LIME).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //yellow banner
        ItemStack yellowBanner = new ItemStack(Material.INK_SACK, 1, (short) 11);
        ItemMeta yellowBannerMeta = yellowBanner.getItemMeta();
        yellowBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.yellow.name")));
        yellowBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.yellow.lore")));

        addItem(yellowBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.YELLOW).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //light blue banner
        ItemStack lightBlueBanner = new ItemStack(Material.INK_SACK, 1, (short) 12);
        ItemMeta lightBlueBannerMeta = lightBlueBanner.getItemMeta();
        lightBlueBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.light-blue.name")));
        lightBlueBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.light-blue.lore")));

        addItem(lightBlueBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.LIGHT_BLUE).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //magenta banner
        ItemStack magentaBanner = new ItemStack(Material.INK_SACK, 1, (short) 13);
        ItemMeta magentaBannerMeta = magentaBanner.getItemMeta();
        magentaBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.magenta.name")));
        magentaBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.magenta.lore")));

        addItem(magentaBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.MAGENTA).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //orange banner
        ItemStack orangeBanner = new ItemStack(Material.INK_SACK, 1, (short) 14);
        ItemMeta orangeBannerMeta = orangeBanner.getItemMeta();
        orangeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.orange.name")));
        orangeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.orange.lore")));

        addItem(orangeBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.ORANGE).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //white banner
        ItemStack whiteBanner = new ItemStack(Material.INK_SACK, 1, (short) 15);
        ItemMeta whiteBannerMeta = whiteBanner.getItemMeta();
        whiteBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.color.white.name")));
        whiteBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.color.white.lore")));

        addItem(whiteBanner, event -> {
            new PatternBannerMenu(banner, DyeColor.WHITE).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //finish
        setItem(banner, event -> {
            HumanEntity player = event.getWhoClicked();

            player.getInventory().addItem(banner);
            player.closeInventory();

            event.setCancelled(true);
        }, 22);
    }
}
