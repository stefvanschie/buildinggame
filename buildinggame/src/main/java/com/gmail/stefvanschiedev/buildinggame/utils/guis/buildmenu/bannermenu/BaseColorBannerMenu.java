package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A gui for selecting the base color of your banner
 *
 * @since 5.2.0
 */
public class BaseColorBannerMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * {@inheritDoc}
     */
    public BaseColorBannerMenu() {
        super(null, 18,
                MessageManager.translate(MESSAGES.getString("gui.banners.base-color.title")), 1);

        //black banner
        ItemStack blackBanner = new ItemStack(Material.BANNER);
        ItemMeta blackBannerMeta = blackBanner.getItemMeta();
        blackBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.black.name")));
        blackBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.black.lore")));

        addItem(blackBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER)).open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //red banner
        ItemStack redBanner = new ItemStack(Material.BANNER, 1, (short) 1);
        ItemMeta redBannerMeta = redBanner.getItemMeta();
        redBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.red.name")));
        redBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.red.lore")));

        addItem(redBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 1))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //green banner
        ItemStack greenBanner = new ItemStack(Material.BANNER, 1, (short) 2);
        ItemMeta greenBannerMeta = greenBanner.getItemMeta();
        greenBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.green.name")));
        greenBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.green.lore")));

        addItem(greenBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 2))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //brown banner
        ItemStack brownBanner = new ItemStack(Material.BANNER, 1, (short) 3);
        ItemMeta brownBannerMeta = brownBanner.getItemMeta();
        brownBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.brown.name")));
        brownBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.brown.lore")));

        addItem(brownBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 3))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //blue banner
        ItemStack blueBanner = new ItemStack(Material.BANNER, 1, (short) 4);
        ItemMeta blueBannerMeta = blueBanner.getItemMeta();
        blueBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.blue.name")));
        blueBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.blue.lore")));

        addItem(blueBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 4))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //purple banner
        ItemStack purpleBanner = new ItemStack(Material.BANNER, 1, (short) 5);
        ItemMeta purpleBannerMeta = purpleBanner.getItemMeta();
        purpleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.purple.name")));
        purpleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.purple.lore")));

        addItem(purpleBanner, event -> {
                //create new instance of the item, because it will otherwise keep any patterns added to it previously
                new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 5))
                        .open((Player) event.getWhoClicked());

                event.setCancelled(true);
        });

        //cyan banner
        ItemStack cyanBanner = new ItemStack(Material.BANNER, 1, (short) 6);
        ItemMeta cyanBannerMeta = cyanBanner.getItemMeta();
        cyanBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.cyan.name")));
        cyanBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.cyan.lore")));

        addItem(cyanBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 6))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //light gray banner
        ItemStack lightGrayBanner = new ItemStack(Material.BANNER, 1, (short) 7);
        ItemMeta lightGrayBannerMeta = lightGrayBanner.getItemMeta();
        lightGrayBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.light-gray.name")));
        lightGrayBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.light-gray.lore")));

        addItem(lightGrayBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 7))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //gray banner
        ItemStack grayBanner = new ItemStack(Material.BANNER, 1, (short) 8);
        ItemMeta grayBannerMeta = grayBanner.getItemMeta();
        grayBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.gray.name")));
        grayBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.gray.lore")));

        addItem(grayBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 8))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        setStartingPoint(10);

        //pink banner
        ItemStack pinkBanner = new ItemStack(Material.BANNER, 1, (short) 9);
        ItemMeta pinkBannerMeta = pinkBanner.getItemMeta();
        pinkBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.pink.name")));
        pinkBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.pink.lore")));

        addItem(pinkBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 9))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //lime banner
        ItemStack limeBanner = new ItemStack(Material.BANNER, 1, (short) 10);
        ItemMeta limeBannerMeta = limeBanner.getItemMeta();
        limeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.lime.name")));
        limeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.lime.lore")));

        addItem(limeBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 10))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //yellow banner
        ItemStack yellowBanner = new ItemStack(Material.BANNER, 1, (short) 11);
        ItemMeta yellowBannerMeta = yellowBanner.getItemMeta();
        yellowBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.yellow.name")));
        yellowBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.yellow.lore")));

        addItem(yellowBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 11))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //light blue banner
        ItemStack lightBlueBanner = new ItemStack(Material.BANNER, 1, (short) 12);
        ItemMeta lightBlueBannerMeta = lightBlueBanner.getItemMeta();
        lightBlueBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.light-blue.name")));
        lightBlueBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.light-blue.lore")));

        addItem(lightBlueBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 12))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //magenta banner
        ItemStack magentaBanner = new ItemStack(Material.BANNER, 1, (short) 13);
        ItemMeta magentaBannerMeta = magentaBanner.getItemMeta();
        magentaBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.magenta.name")));
        magentaBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.magenta.lore")));

        addItem(magentaBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 13))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //orange banner
        ItemStack orangeBanner = new ItemStack(Material.BANNER, 1, (short) 14);
        ItemMeta orangeBannerMeta = orangeBanner.getItemMeta();
        orangeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.orange.name")));
        orangeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.orange.lore")));

        addItem(orangeBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 14))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });

        //white banner
        ItemStack whiteBanner = new ItemStack(Material.BANNER, 1, (short) 15);
        ItemMeta whiteBannerMeta = whiteBanner.getItemMeta();
        whiteBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.base-color.white.name")));
        whiteBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.base-color.white.lore")));

        addItem(whiteBanner, event -> {
            //create new instance of the item, because it will otherwise keep any patterns added to it previously
            new ColorBannerMenu(new ItemStack(Material.BANNER, 1, (short) 15))
                    .open((Player) event.getWhoClicked());

            event.setCancelled(true);
        });
    }
}