package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

/**
 * A gui for selecting the pattern to apply in combination with the previously chosen color
 *
 * @since 5.2.0
 */
class PatternBannerMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * {@inheritDoc}
     */
    PatternBannerMenu(ItemStack banner, DyeColor dyeColor) {
        super(null, 54,
                MessageManager.translate(MESSAGES.getString("gui.banners.pattern.title")), 1);

        //base pattern
        ItemStack baseBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta baseBannerMeta = (BannerMeta) baseBanner.getItemMeta();
        baseBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_BOTTOM));
        baseBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base.name")));
        baseBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base.lore")));
        baseBanner.setItemMeta(baseBannerMeta);

        addItem(baseBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_BOTTOM));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //chief pattern
        ItemStack chiefBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta chiefBannerMeta = (BannerMeta) chiefBanner.getItemMeta();
        chiefBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_TOP));
        chiefBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief.name")));
        chiefBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief.lore")));
        chiefBanner.setItemMeta(chiefBannerMeta);

        addItem(chiefBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_TOP));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //pale dexter pattern
        ItemStack paleDexterBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta paleDexterBannerMeta = (BannerMeta) paleDexterBanner.getItemMeta();
        paleDexterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_LEFT));
        paleDexterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale-dexter.name")));
        paleDexterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale-dexter.lore")));
        paleDexterBanner.setItemMeta(paleDexterBannerMeta);

        addItem(paleDexterBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_LEFT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //pale sinister pattern
        ItemStack paleSinisterBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta paleSinisterBannerMeta = (BannerMeta) paleSinisterBanner.getItemMeta();
        paleSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_RIGHT));
        paleSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale-sinister.name")));
        paleSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale-sinister.lore")));
        paleSinisterBanner.setItemMeta(paleSinisterBannerMeta);

        addItem(paleSinisterBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_RIGHT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //pale pattern
        ItemStack paleBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta paleBannerMeta = (BannerMeta) paleBanner.getItemMeta();
        paleBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_CENTER));
        paleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.pale.name")));
        paleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.pale.lore")));
        paleBanner.setItemMeta(paleBannerMeta);

        addItem(paleBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_CENTER));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //fess pattern
        ItemStack fessBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta fessBannerMeta = (BannerMeta) fessBanner.getItemMeta();
        fessBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_MIDDLE));
        fessBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.fess.name")));
        fessBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.fess.lore")));
        fessBanner.setItemMeta(fessBannerMeta);

        addItem(fessBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_MIDDLE));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //bend pattern
        ItemStack bendBanner = new ItemStack(Material.BANNER, 1,dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta bendBannerMeta = (BannerMeta) bendBanner.getItemMeta();
        bendBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNRIGHT));
        bendBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bend.name")));
        bendBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bend.lore")));
        bendBanner.setItemMeta(bendBannerMeta);

        addItem(bendBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNRIGHT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //bend sinister pattern
        ItemStack bendSinisterBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta bendSinisterBannerMeta = (BannerMeta) bendSinisterBanner.getItemMeta();
        bendSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNLEFT));
        bendSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bend-sinister.name")));
        bendSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bend-sinister.lore")));
        bendSinisterBanner.setItemMeta(bendSinisterBannerMeta);

        addItem(bendSinisterBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_DOWNLEFT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //paly pattern
        ItemStack palyBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta palyBannerMeta = (BannerMeta) palyBanner.getItemMeta();
        palyBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_SMALL));
        palyBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.paly.name")));
        palyBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.paly.lore")));
        palyBanner.setItemMeta(palyBannerMeta);

        addItem(palyBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRIPE_SMALL));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //saltire pattern
        ItemStack saltireBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta saltireBannerMeta = (BannerMeta) saltireBanner.getItemMeta();
        saltireBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CROSS));
        saltireBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.saltire.name")));
        saltireBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.saltire.lore")));
        saltireBanner.setItemMeta(saltireBannerMeta);

        addItem(saltireBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CROSS));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //cross pattern
        ItemStack crossBanner = new ItemStack(Material.BANNER, 1, dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta crossBannerMeta = (BannerMeta) crossBanner.getItemMeta();
        crossBannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRAIGHT_CROSS));
        crossBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.cross.name")));
        crossBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.cross.lore")));
        crossBanner.setItemMeta(crossBannerMeta);

        addItem(crossBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.STRAIGHT_CROSS));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per bend sinister pattern
        ItemStack perBendSinisterBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perBendSinisterBannerMeta = (BannerMeta) perBendSinisterBanner.getItemMeta();
        perBendSinisterBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT));
        perBendSinisterBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-sinister.name")));
        perBendSinisterBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-sinister.lore")));
        perBendSinisterBanner.setItemMeta(perBendSinisterBannerMeta);

        addItem(perBendSinisterBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per bend pattern
        ItemStack perBendBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perBendBannerMeta = (BannerMeta) perBendBanner.getItemMeta();
        perBendBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT_MIRROR));
        perBendBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend.name")));
        perBendBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend.lore")));
        perBendBanner.setItemMeta(perBendBannerMeta);

        addItem(perBendBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT_MIRROR));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per bend inverted pattern
        ItemStack perBendInvertedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perBendInvertedBannerMeta = (BannerMeta) perBendInvertedBanner.getItemMeta();
        perBendInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT_MIRROR));
        perBendInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-inverted.name")));
        perBendInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-inverted.lore")));
        perBendInvertedBanner.setItemMeta(perBendInvertedBannerMeta);

        addItem(perBendInvertedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_LEFT_MIRROR));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per bend sinister inverted pattern
        ItemStack perBendSinisterInvertedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perBendSinisterInvertedBannerMeta = (BannerMeta) perBendSinisterInvertedBanner.getItemMeta();
        perBendSinisterInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT));
        perBendSinisterInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-bend-sinister-inverted.name")));
        perBendSinisterInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-bend-sinister-inverted.lore")));
        perBendSinisterInvertedBanner.setItemMeta(perBendSinisterInvertedBannerMeta);

        addItem(perBendSinisterInvertedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.DIAGONAL_RIGHT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per pale pattern
        ItemStack perPaleBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perPaleBannerMeta = (BannerMeta) perPaleBanner.getItemMeta();
        perPaleBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL));
        perPaleBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-pale.name")));
        perPaleBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-pale.lore")));
        perPaleBanner.setItemMeta(perPaleBannerMeta);

        addItem(perPaleBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per pale inverted pattern
        ItemStack perPaleInvertedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perPaleInvertedBannerMeta = (BannerMeta) perPaleInvertedBanner.getItemMeta();
        perPaleInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL_MIRROR));
        perPaleInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-pale-inverted.name")));
        perPaleInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-pale-inverted.lore")));
        perPaleInvertedBanner.setItemMeta(perPaleInvertedBannerMeta);

        addItem(perPaleInvertedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_VERTICAL_MIRROR));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per fess pattern
        ItemStack perFessBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perFessBannerMeta = (BannerMeta) perFessBanner.getItemMeta();
        perFessBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL));
        perFessBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-fess.name")));
        perFessBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-fess.lore")));
        perFessBanner.setItemMeta(perFessBannerMeta);

        addItem(perFessBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //per fess inverted pattern
        ItemStack perFessInvertedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta perFessInvertedBannerMeta = (BannerMeta) perFessInvertedBanner.getItemMeta();
        perFessInvertedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL_MIRROR));
        perFessInvertedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.per-fess-inverted.name")));
        perFessInvertedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.per-fess-inverted.lore")));
        perFessInvertedBanner.setItemMeta(perFessInvertedBannerMeta);

        addItem(perFessInvertedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.HALF_HORIZONTAL_MIRROR));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //base dexter canton pattern
        ItemStack baseDexterCantonBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta baseDexterCantonBannerMeta = (BannerMeta) baseDexterCantonBanner.getItemMeta();
        baseDexterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_LEFT));
        baseDexterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-dexter-canton.name")));
        baseDexterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-dexter-canton.lore")));
        baseDexterCantonBanner.setItemMeta(baseDexterCantonBannerMeta);

        addItem(baseDexterCantonBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_LEFT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //base sinister canton pattern
        ItemStack baseSinisterCantonBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta baseSinisterCantonBannerMeta = (BannerMeta) baseSinisterCantonBanner.getItemMeta();
        baseSinisterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_RIGHT));
        baseSinisterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-sinister-canton.name")));
        baseSinisterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-sinister-canton.lore")));
        baseSinisterCantonBanner.setItemMeta(baseSinisterCantonBannerMeta);

        addItem(baseSinisterCantonBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_BOTTOM_RIGHT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //chief dexter canton pattern
        ItemStack chiefDexterCantonBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta chiefDexterCantonBannerMeta = (BannerMeta) chiefDexterCantonBanner.getItemMeta();
        chiefDexterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_LEFT));
        chiefDexterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-dexter-canton.name")));
        chiefDexterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-dexter-canton.lore")));
        chiefDexterCantonBanner.setItemMeta(chiefDexterCantonBannerMeta);

        addItem(chiefDexterCantonBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_LEFT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //chief sinister canton pattern
        ItemStack chiefSinisterCantonBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta chiefSinisterCantonBannerMeta = (BannerMeta) chiefSinisterCantonBanner.getItemMeta();
        chiefSinisterCantonBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_RIGHT));
        chiefSinisterCantonBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-sinister-canton.name")));
        chiefSinisterCantonBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-sinister-canton.lore")));
        chiefSinisterCantonBanner.setItemMeta(chiefSinisterCantonBannerMeta);

        addItem(chiefSinisterCantonBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SQUARE_TOP_RIGHT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //chevron pattern
        ItemStack chevronBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta chevronBannerMeta = (BannerMeta) chevronBanner.getItemMeta();
        chevronBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_BOTTOM));
        chevronBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chevron.name")));
        chevronBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chevron.lore")));
        chevronBanner.setItemMeta(chevronBannerMeta);

        addItem(chevronBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_BOTTOM));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //inverted chevron pattern
        ItemStack invertedChevronBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta invertedChevronBannerMeta = (BannerMeta) invertedChevronBanner.getItemMeta();
        invertedChevronBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_TOP));
        invertedChevronBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.inverted-chevron.name")));
        invertedChevronBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.inverted-chevron.lore")));
        invertedChevronBanner.setItemMeta(invertedChevronBannerMeta);

        addItem(invertedChevronBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLE_TOP));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //base indented pattern
        ItemStack baseIndentedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta baseIndentedBannerMeta = (BannerMeta) baseIndentedBanner.getItemMeta();
        baseIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_BOTTOM));
        baseIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-indented.name")));
        baseIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-indented.lore")));
        baseIndentedBanner.setItemMeta(baseIndentedBannerMeta);

        addItem(baseIndentedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_BOTTOM));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //chief indented pattern
        ItemStack chiefIndentedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta chiefIndentedBannerMeta = (BannerMeta) chiefIndentedBanner.getItemMeta();
        chiefIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_TOP));
        chiefIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.chief-indented.name")));
        chiefIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.chief-indented.lore")));
        chiefIndentedBanner.setItemMeta(chiefIndentedBannerMeta);

        addItem(chiefIndentedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.TRIANGLES_TOP));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //roundel pattern
        ItemStack roundelBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta roundelBannerMeta = (BannerMeta) roundelBanner.getItemMeta();
        roundelBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CIRCLE_MIDDLE));
        roundelBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.roundel.name")));
        roundelBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.roundel.lore")));
        roundelBanner.setItemMeta(roundelBannerMeta);

        addItem(roundelBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CIRCLE_MIDDLE));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //lozenge pattern
        ItemStack lozengeBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta lozengeBannerMeta = (BannerMeta) lozengeBanner.getItemMeta();
        lozengeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.RHOMBUS_MIDDLE));
        lozengeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.lozenge.name")));
        lozengeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.lozenge.lore")));
        lozengeBanner.setItemMeta(lozengeBannerMeta);

        addItem(lozengeBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.RHOMBUS_MIDDLE));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //bordure pattern
        ItemStack bordureBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta bordureBannerMeta = (BannerMeta) bordureBanner.getItemMeta();
        bordureBannerMeta.addPattern(new Pattern(dyeColor, PatternType.BORDER));
        bordureBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.bordure.name")));
        bordureBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.bordure.lore")));
        bordureBanner.setItemMeta(bordureBannerMeta);

        addItem(bordureBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.BORDER));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //bordure indented pattern
        ItemStack dyedBordureIndentedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedBordureIndentedBannerMeta = (BannerMeta) dyedBordureIndentedBanner.getItemMeta();
        dyedBordureIndentedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CURLY_BORDER));
        dyedBordureIndentedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-bordure-indented.name")));
        dyedBordureIndentedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-bordure-indented.lore")));
        dyedBordureIndentedBanner.setItemMeta(dyedBordureIndentedBannerMeta);

        addItem(dyedBordureIndentedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CURLY_BORDER));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //dyed field masoned pattern
        ItemStack dyedFieldMasonedBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedFiledMasonedBannerMeta = (BannerMeta) dyedFieldMasonedBanner.getItemMeta();
        dyedFiledMasonedBannerMeta.addPattern(new Pattern(dyeColor, PatternType.BRICKS));
        dyedFiledMasonedBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-field-masoned.name")));
        dyedFiledMasonedBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-field-masoned.lore")));
        dyedFieldMasonedBanner.setItemMeta(dyedFiledMasonedBannerMeta);

        addItem(dyedFieldMasonedBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.BRICKS));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //gradient pattern
        ItemStack gradientBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta gradientBannerMeta = (BannerMeta) gradientBanner.getItemMeta();
        gradientBannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT));
        gradientBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.gradient.name")));
        gradientBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.gradient.lore")));
        gradientBanner.setItemMeta(gradientBannerMeta);

        addItem(gradientBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //base gradient pattern
        ItemStack baseGradientBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta baseGradientBannerMeta = (BannerMeta) baseGradientBanner.getItemMeta();
        baseGradientBannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT_UP));
        baseGradientBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.base-gradient.name")));
        baseGradientBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.base-gradient.lore")));
        baseGradientBanner.setItemMeta(baseGradientBannerMeta);

        addItem(baseGradientBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.GRADIENT_UP));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //dyed creeper charge pattern
        ItemStack dyedCreeperChargeBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedCreeperChargeBannerMeta = (BannerMeta) dyedCreeperChargeBanner.getItemMeta();
        dyedCreeperChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.CREEPER));
        dyedCreeperChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-creeper-charge.name")));
        dyedCreeperChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-creeper-charge.lore")));
        dyedCreeperChargeBanner.setItemMeta(dyedCreeperChargeBannerMeta);

        addItem(dyedCreeperChargeBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.CREEPER));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //dyed skull charge pattern
        ItemStack dyedSkullChargeBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedSkullChargeBannerMeta = (BannerMeta) dyedSkullChargeBanner.getItemMeta();
        dyedSkullChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.SKULL));
        dyedSkullChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-skull-charge.name")));
        dyedSkullChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-skull-charge.lore")));
        dyedSkullChargeBanner.setItemMeta(dyedSkullChargeBannerMeta);

        addItem(dyedSkullChargeBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.SKULL));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        });

        //dyed flower charge pattern
        ItemStack dyedFlowerChargeBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedFlowerChargeBannerMeta = (BannerMeta) dyedFlowerChargeBanner.getItemMeta();
        dyedFlowerChargeBannerMeta.addPattern(new Pattern(dyeColor, PatternType.FLOWER));
        dyedFlowerChargeBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-flower-charge.name")));
        dyedFlowerChargeBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-flower-charge.lore")));
        dyedFlowerChargeBanner.setItemMeta(dyedFlowerChargeBannerMeta);

        setItem(dyedFlowerChargeBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.FLOWER));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 39);

        //dyed thing pattern
        ItemStack dyedThingBanner = new ItemStack(Material.BANNER, 1,
                dyeColor == DyeColor.WHITE ? 0 : (short) 15);
        BannerMeta dyedThingBannerMeta = (BannerMeta) dyedThingBanner.getItemMeta();
        dyedThingBannerMeta.addPattern(new Pattern(dyeColor, PatternType.MOJANG));
        dyedThingBannerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.banners.pattern.dyed-thing.name")));
        dyedThingBannerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.banners.pattern.dyed-thing.lore")));
        dyedThingBanner.setItemMeta(dyedThingBannerMeta);

        setItem(dyedThingBanner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
                bannerMeta.addPattern(new Pattern(dyeColor, PatternType.MOJANG));
                banner.setItemMeta(bannerMeta);

                new ColorBannerMenu(banner).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 41);

        //preview
        setItem(banner, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (!(event instanceof InventoryClickEvent))
                    return false;

                HumanEntity player = ((InventoryInteractEvent) event).getWhoClicked();

                player.getInventory().addItem(banner);
                player.closeInventory();

                return true;
            }
        },49);
    }
}
