package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

/**
 * A gui for selecting the pattern to apply in combination with the previously chosen color
 *
 * @since 5.2.0
 */
class PatternBannerMenu extends ChestGui {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * {@inheritDoc}
     */
    PatternBannerMenu(ItemStack banner, DyeColor dyeColor) {
        super(6, MessageManager.translate(MESSAGES.getString("gui.banners.pattern.title")));

        var outlinePane = new OutlinePane(0, 0, 9, 6);

        //base pattern
        var baseBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var baseBannerMeta = (BannerMeta) baseBanner.getItemMeta();
        baseBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_BOTTOM));
        baseBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base.name")));
        baseBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base.lore")));
        baseBanner.setItemMeta(baseBannerMeta);

        outlinePane.addItem(new GuiItem(baseBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_BOTTOM));
            banner.setItemMeta(bannerMeta);

            Bukkit.getScheduler().runTask(Main.getInstance(), () ->
                new ColorBannerMenu(banner).show(event.getWhoClicked()));

            event.setCancelled(true);
        }));

        //chief pattern
        var chiefBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var chiefBannerMeta = (BannerMeta) chiefBanner.getItemMeta();
        chiefBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_TOP));
        chiefBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief.name")));
        chiefBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief.lore")));
        chiefBanner.setItemMeta(chiefBannerMeta);

        outlinePane.addItem(new GuiItem(chiefBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_TOP));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //pale dexter pattern
        var paleDexterBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var paleDexterBannerMeta = (BannerMeta) paleDexterBanner.getItemMeta();
        paleDexterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_LEFT));
        paleDexterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale-dexter.name")));
        paleDexterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale-dexter.lore")));
        paleDexterBanner.setItemMeta(paleDexterBannerMeta);

        outlinePane.addItem(new GuiItem(paleDexterBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_LEFT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //pale sinister pattern
        var paleSinisterBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var paleSinisterBannerMeta = (BannerMeta) paleSinisterBanner.getItemMeta();
        paleSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_RIGHT));
        paleSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale-sinister.name")));
        paleSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale-sinister.lore")));
        paleSinisterBanner.setItemMeta(paleSinisterBannerMeta);

        outlinePane.addItem(new GuiItem(paleSinisterBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_RIGHT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //pale pattern
        var paleBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var paleBannerMeta = (BannerMeta) paleBanner.getItemMeta();
        paleBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_CENTER));
        paleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale.name")));
        paleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale.lore")));
        paleBanner.setItemMeta(paleBannerMeta);

        outlinePane.addItem(new GuiItem(paleBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_CENTER));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //fess pattern
        var fessBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var fessBannerMeta = (BannerMeta) fessBanner.getItemMeta();
        fessBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_MIDDLE));
        fessBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.fess.name")));
        fessBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.fess.lore")));
        fessBanner.setItemMeta(fessBannerMeta);

        outlinePane.addItem(new GuiItem(fessBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_MIDDLE));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //bend pattern
        var bendBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var bendBannerMeta = (BannerMeta) bendBanner.getItemMeta();
        bendBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNRIGHT));
        bendBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bend.name")));
        bendBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bend.lore")));
        bendBanner.setItemMeta(bendBannerMeta);

        outlinePane.addItem(new GuiItem(bendBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNRIGHT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //bend sinister pattern
        var bendSinisterBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var bendSinisterBannerMeta = (BannerMeta) bendSinisterBanner.getItemMeta();
        bendSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNLEFT));
        bendSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bend-sinister.name")));
        bendSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bend-sinister.lore")));
        bendSinisterBanner.setItemMeta(bendSinisterBannerMeta);

        outlinePane.addItem(new GuiItem(bendSinisterBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNLEFT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //paly pattern
        var palyBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var palyBannerMeta = (BannerMeta) palyBanner.getItemMeta();
        palyBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_SMALL));
        palyBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.paly.name")));
        palyBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.paly.lore")));
        palyBanner.setItemMeta(palyBannerMeta);

        outlinePane.addItem(new GuiItem(palyBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_SMALL));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //saltire pattern
        var saltireBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var saltireBannerMeta = (BannerMeta) saltireBanner.getItemMeta();
        saltireBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CROSS));
        saltireBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.saltire.name")));
        saltireBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.saltire.lore")));
        saltireBanner.setItemMeta(saltireBannerMeta);

        outlinePane.addItem(new GuiItem(saltireBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CROSS));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //cross pattern
        var crossBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var crossBannerMeta = (BannerMeta) crossBanner.getItemMeta();
        crossBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRAIGHT_CROSS));
        crossBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.cross.name")));
        crossBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.cross.lore")));
        crossBanner.setItemMeta(crossBannerMeta);

        outlinePane.addItem(new GuiItem(crossBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRAIGHT_CROSS));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per bend sinister pattern
        var perBendSinisterBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perBendSinisterBannerMeta = (BannerMeta) perBendSinisterBanner.getItemMeta();
        perBendSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT));
        perBendSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-sinister.name")));
        perBendSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-sinister.lore")));
        perBendSinisterBanner.setItemMeta(perBendSinisterBannerMeta);

        outlinePane.addItem(new GuiItem(perBendSinisterBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per bend pattern
        var perBendBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perBendBannerMeta = (BannerMeta) perBendBanner.getItemMeta();
        perBendBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT_MIRROR));
        perBendBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend.name")));
        perBendBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend.lore")));
        perBendBanner.setItemMeta(perBendBannerMeta);

        outlinePane.addItem(new GuiItem(perBendBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT_MIRROR));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per bend inverted pattern
        var perBendInvertedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perBendInvertedBannerMeta = (BannerMeta) perBendInvertedBanner.getItemMeta();
        perBendInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT_MIRROR));
        perBendInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-inverted.name")));
        perBendInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-inverted.lore")));
        perBendInvertedBanner.setItemMeta(perBendInvertedBannerMeta);

        outlinePane.addItem(new GuiItem(perBendInvertedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT_MIRROR));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per bend sinister inverted pattern
        var perBendSinisterInvertedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perBendSinisterInvertedBannerMeta = (BannerMeta) perBendSinisterInvertedBanner.getItemMeta();
        perBendSinisterInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT));
        perBendSinisterInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-sinister-inverted.name")));
        perBendSinisterInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-sinister-inverted.lore")));
        perBendSinisterInvertedBanner.setItemMeta(perBendSinisterInvertedBannerMeta);

        outlinePane.addItem(new GuiItem(perBendSinisterInvertedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per pale pattern
        var perPaleBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perPaleBannerMeta = (BannerMeta) perPaleBanner.getItemMeta();
        perPaleBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL));
        perPaleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-pale.name")));
        perPaleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-pale.lore")));
        perPaleBanner.setItemMeta(perPaleBannerMeta);

        outlinePane.addItem(new GuiItem(perPaleBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per pale inverted pattern
        var perPaleInvertedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perPaleInvertedBannerMeta = (BannerMeta) perPaleInvertedBanner.getItemMeta();
        perPaleInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL_MIRROR));
        perPaleInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-pale-inverted.name")));
        perPaleInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-pale-inverted.lore")));
        perPaleInvertedBanner.setItemMeta(perPaleInvertedBannerMeta);

        outlinePane.addItem(new GuiItem(perPaleInvertedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL_MIRROR));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per fess pattern
        var perFessBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perFessBannerMeta = (BannerMeta) perFessBanner.getItemMeta();
        perFessBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL));
        perFessBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-fess.name")));
        perFessBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-fess.lore")));
        perFessBanner.setItemMeta(perFessBannerMeta);

        outlinePane.addItem(new GuiItem(perFessBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //per fess inverted pattern
        var perFessInvertedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var perFessInvertedBannerMeta = (BannerMeta) perFessInvertedBanner.getItemMeta();
        perFessInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL_MIRROR));
        perFessInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-fess-inverted.name")));
        perFessInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-fess-inverted.lore")));
        perFessInvertedBanner.setItemMeta(perFessInvertedBannerMeta);

        outlinePane.addItem(new GuiItem(perFessInvertedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL_MIRROR));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //base dexter canton pattern
        var baseDexterCantonBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var baseDexterCantonBannerMeta = (BannerMeta) baseDexterCantonBanner.getItemMeta();
        baseDexterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_LEFT));
        baseDexterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-dexter-canton.name")));
        baseDexterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-dexter-canton.lore")));
        baseDexterCantonBanner.setItemMeta(baseDexterCantonBannerMeta);

        outlinePane.addItem(new GuiItem(baseDexterCantonBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_LEFT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //base sinister canton pattern
        var baseSinisterCantonBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var baseSinisterCantonBannerMeta = (BannerMeta) baseSinisterCantonBanner.getItemMeta();
        baseSinisterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_RIGHT));
        baseSinisterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-sinister-canton.name")));
        baseSinisterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-sinister-canton.lore")));
        baseSinisterCantonBanner.setItemMeta(baseSinisterCantonBannerMeta);

        outlinePane.addItem(new GuiItem(baseSinisterCantonBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_RIGHT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //chief dexter canton pattern
        var chiefDexterCantonBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var chiefDexterCantonBannerMeta = (BannerMeta) chiefDexterCantonBanner.getItemMeta();
        chiefDexterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_LEFT));
        chiefDexterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-dexter-canton.name")));
        chiefDexterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-dexter-canton.lore")));
        chiefDexterCantonBanner.setItemMeta(chiefDexterCantonBannerMeta);

        outlinePane.addItem(new GuiItem(chiefDexterCantonBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_LEFT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //chief sinister canton pattern
        var chiefSinisterCantonBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var chiefSinisterCantonBannerMeta = (BannerMeta) chiefSinisterCantonBanner.getItemMeta();
        chiefSinisterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_RIGHT));
        chiefSinisterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-sinister-canton.name")));
        chiefSinisterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-sinister-canton.lore")));
        chiefSinisterCantonBanner.setItemMeta(chiefSinisterCantonBannerMeta);

        outlinePane.addItem(new GuiItem(chiefSinisterCantonBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_RIGHT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //chevron pattern
        var chevronBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var chevronBannerMeta = (BannerMeta) chevronBanner.getItemMeta();
        chevronBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_BOTTOM));
        chevronBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chevron.name")));
        chevronBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chevron.lore")));
        chevronBanner.setItemMeta(chevronBannerMeta);

        outlinePane.addItem(new GuiItem(chevronBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_BOTTOM));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //inverted chevron pattern
        var invertedChevronBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var invertedChevronBannerMeta = (BannerMeta) invertedChevronBanner.getItemMeta();
        invertedChevronBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_TOP));
        invertedChevronBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.inverted-chevron.name")));
        invertedChevronBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.inverted-chevron.lore")));
        invertedChevronBanner.setItemMeta(invertedChevronBannerMeta);

        outlinePane.addItem(new GuiItem(invertedChevronBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_TOP));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //base indented pattern
        var baseIndentedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var baseIndentedBannerMeta = (BannerMeta) baseIndentedBanner.getItemMeta();
        baseIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_BOTTOM));
        baseIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-indented.name")));
        baseIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-indented.lore")));
        baseIndentedBanner.setItemMeta(baseIndentedBannerMeta);

        outlinePane.addItem(new GuiItem(baseIndentedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_BOTTOM));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //chief indented pattern
        var chiefIndentedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var chiefIndentedBannerMeta = (BannerMeta) chiefIndentedBanner.getItemMeta();
        chiefIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_TOP));
        chiefIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-indented.name")));
        chiefIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-indented.lore")));
        chiefIndentedBanner.setItemMeta(chiefIndentedBannerMeta);

        outlinePane.addItem(new GuiItem(chiefIndentedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_TOP));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //roundel pattern
        var roundelBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var roundelBannerMeta = (BannerMeta) roundelBanner.getItemMeta();
        roundelBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CIRCLE_MIDDLE));
        roundelBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.roundel.name")));
        roundelBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.roundel.lore")));
        roundelBanner.setItemMeta(roundelBannerMeta);

        outlinePane.addItem(new GuiItem(roundelBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CIRCLE_MIDDLE));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //lozenge pattern
        var lozengeBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var lozengeBannerMeta = (BannerMeta) lozengeBanner.getItemMeta();
        lozengeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.RHOMBUS_MIDDLE));
        lozengeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.lozenge.name")));
        lozengeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.lozenge.lore")));
        lozengeBanner.setItemMeta(lozengeBannerMeta);

        outlinePane.addItem(new GuiItem(lozengeBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.RHOMBUS_MIDDLE));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //bordure pattern
        var bordureBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var bordureBannerMeta = (BannerMeta) bordureBanner.getItemMeta();
        bordureBannerMeta.addPattern(new Pattern(dyeColor, PatternType.BORDER));
        bordureBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bordure.name")));
        bordureBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bordure.lore")));
        bordureBanner.setItemMeta(bordureBannerMeta);

        outlinePane.addItem(new GuiItem(bordureBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.BORDER));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //bordure indented pattern
        var dyedBordureIndentedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedBordureIndentedBannerMeta = (BannerMeta) dyedBordureIndentedBanner.getItemMeta();
        dyedBordureIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CURLY_BORDER));
        dyedBordureIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-bordure-indented.name")));
        dyedBordureIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-bordure-indented.lore")));
        dyedBordureIndentedBanner.setItemMeta(dyedBordureIndentedBannerMeta);

        outlinePane.addItem(new GuiItem(dyedBordureIndentedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CURLY_BORDER));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //dyed field masoned pattern
        var dyedFieldMasonedBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedFiledMasonedBannerMeta = (BannerMeta) dyedFieldMasonedBanner.getItemMeta();
        dyedFiledMasonedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.BRICKS));
        dyedFiledMasonedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-field-masoned.name")));
        dyedFiledMasonedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-field-masoned.lore")));
        dyedFieldMasonedBanner.setItemMeta(dyedFiledMasonedBannerMeta);

        outlinePane.addItem(new GuiItem(dyedFieldMasonedBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.BRICKS));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //gradient pattern
        var gradientBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var gradientBannerMeta = (BannerMeta) gradientBanner.getItemMeta();
        gradientBannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT));
        gradientBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.gradient.name")));
        gradientBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.gradient.lore")));
        gradientBanner.setItemMeta(gradientBannerMeta);

        outlinePane.addItem(new GuiItem(gradientBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //base gradient pattern
        var baseGradientBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var baseGradientBannerMeta = (BannerMeta) baseGradientBanner.getItemMeta();
        baseGradientBannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT_UP));
        baseGradientBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-gradient.name")));
        baseGradientBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-gradient.lore")));
        baseGradientBanner.setItemMeta(baseGradientBannerMeta);

        outlinePane.addItem(new GuiItem(baseGradientBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT_UP));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //dyed creeper charge pattern
        var dyedCreeperChargeBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedCreeperChargeBannerMeta = (BannerMeta) dyedCreeperChargeBanner.getItemMeta();
        dyedCreeperChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CREEPER));
        dyedCreeperChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-creeper-charge.name")));
        dyedCreeperChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-creeper-charge.lore")));
        dyedCreeperChargeBanner.setItemMeta(dyedCreeperChargeBannerMeta);

        outlinePane.addItem(new GuiItem(dyedCreeperChargeBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CREEPER));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        //dyed skull charge pattern
        var dyedSkullChargeBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedSkullChargeBannerMeta = (BannerMeta) dyedSkullChargeBanner.getItemMeta();
        dyedSkullChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SKULL));
        dyedSkullChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-skull-charge.name")));
        dyedSkullChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-skull-charge.lore")));
        dyedSkullChargeBanner.setItemMeta(dyedSkullChargeBannerMeta);

        outlinePane.addItem(new GuiItem(dyedSkullChargeBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SKULL));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }));

        StaticPane staticPane = new StaticPane(0, 4, 9, 2);

        //dyed flower charge pattern
        var dyedFlowerChargeBanner =
            new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedFlowerChargeBannerMeta = (BannerMeta) dyedFlowerChargeBanner.getItemMeta();
        dyedFlowerChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.FLOWER));
        dyedFlowerChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-flower-charge.name")));
        dyedFlowerChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-flower-charge.lore")));
        dyedFlowerChargeBanner.setItemMeta(dyedFlowerChargeBannerMeta);

        staticPane.addItem(new GuiItem(dyedFlowerChargeBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.FLOWER));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 1, 0);

        //dyed thing pattern
        var dyedThingBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var dyedThingBannerMeta = (BannerMeta) dyedThingBanner.getItemMeta();
        dyedThingBannerMeta.addPattern(new Pattern(dyeColor, PatternType.MOJANG));
        dyedThingBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-thing.name")));
        dyedThingBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-thing.lore")));
        dyedThingBanner.setItemMeta(dyedThingBannerMeta);

        staticPane.addItem(new GuiItem(dyedThingBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.MOJANG));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 3, 0);

        var globeBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        var globeBannerMeta = (BannerMeta) globeBanner.getItemMeta();
        globeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.GLOBE));
        globeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
            .getString("gui.banners.pattern.globe.name")));
        globeBannerMeta.setLore(MessageManager.translate(MESSAGES
            .getStringList("gui.banners.pattern.globe.lore")));
        globeBanner.setItemMeta(globeBannerMeta);

        staticPane.addItem(new GuiItem(globeBanner, event -> {
            var bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.GLOBE));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 5, 0);

        //piglin pattern
        var piglinBanner = new ItemStack(dyeColor == DyeColor.WHITE ? Material.BLACK_BANNER : Material.WHITE_BANNER);
        BannerMeta piglinBannerMeta = (BannerMeta) piglinBanner.getItemMeta();
        piglinBannerMeta.addPattern(new Pattern(dyeColor, PatternType.PIGLIN));
        piglinBannerMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.banners.pattern.piglin.name")));
        piglinBannerMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.banners.pattern.piglin.lore")));
        piglinBanner.setItemMeta(piglinBannerMeta);

        staticPane.addItem(new GuiItem(piglinBanner, event -> {
            BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
            bannerMeta.addPattern(new Pattern(dyeColor, PatternType.PIGLIN));
            banner.setItemMeta(bannerMeta);

            new ColorBannerMenu(banner).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 7, 0);

        //preview
        staticPane.addItem(new GuiItem(banner, event -> {
            var humanEntity = event.getWhoClicked();

            humanEntity.getInventory().addItem(banner);
            humanEntity.closeInventory();

            event.setCancelled(true);
        }), 4, 1);

        addPane(outlinePane);
        addPane(staticPane);
    }
}
