package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cat;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Cat;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing a cat's appearance
 *
 * @since 7.0.0
 */
class CatAppearanceMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
     CatAppearanceMenu(Cat cat) {
        super(2, ChatColor.GREEN + "Change the cat's appearance");

        var pane = new OutlinePane(0, 0, 9, 2);

        //tabby
        ItemStack tabby = new ItemStack(Material.BROWN_BANNER);
        BannerMeta tabbyMeta = (BannerMeta) tabby.getItemMeta();
        tabbyMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT));
        tabbyMeta.setDisplayName(ChatColor.GREEN + "Tabby");
        tabby.setItemMeta(tabbyMeta);

        pane.addItem(new GuiItem(tabby, event -> {
            cat.setCatType(Cat.Type.TABBY);

            event.setCancelled(true);
        }));

        //tuxedo
        ItemStack tuxedo = new ItemStack(Material.BLACK_BANNER);
        BannerMeta tuxedoMeta = (BannerMeta) tuxedo.getItemMeta();
        tuxedoMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT));
        tuxedoMeta.setDisplayName(ChatColor.GREEN + "Tuxedo");
        tuxedo.setItemMeta(tuxedoMeta);

        pane.addItem(new GuiItem(tuxedo, event -> {
            cat.setCatType(Cat.Type.BLACK);

            event.setCancelled(true);
        }));

        //red tabby
        ItemStack red = new ItemStack(Material.ORANGE_BANNER);
        BannerMeta redMeta = (BannerMeta) red.getItemMeta();
        redMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT));
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            cat.setCatType(Cat.Type.RED);

            event.setCancelled(true);
        }));

        //siamese
        ItemStack siamese = new ItemStack(Material.WHITE_BANNER);
        BannerMeta siameseMeta = (BannerMeta) siamese.getItemMeta();
        siameseMeta.addPattern(new Pattern(DyeColor.BROWN, PatternType.DIAGONAL_RIGHT));
        siameseMeta.setDisplayName(ChatColor.GREEN + "Siamese");
        siamese.setItemMeta(siameseMeta);

        pane.addItem(new GuiItem(siamese, event -> {
            cat.setCatType(Cat.Type.SIAMESE);

            event.setCancelled(true);
        }));

        //british shorthair
        ItemStack britishShorthair = new ItemStack(Material.LIGHT_GRAY_BANNER);
        ItemMeta britishShorthairMeta = britishShorthair.getItemMeta();
        britishShorthairMeta.setDisplayName(ChatColor.GREEN + "British shorthair");
        britishShorthair.setItemMeta(britishShorthairMeta);

        pane.addItem(new GuiItem(britishShorthair, event -> {
            cat.setCatType(Cat.Type.BRITISH_SHORTHAIR);

            event.setCancelled(true);
        }));

        //calico
        ItemStack calico = new ItemStack(Material.ORANGE_BANNER);
        BannerMeta calicoMeta = (BannerMeta) calico.getItemMeta();
        calicoMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
        calicoMeta.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_RIGHT));
        calicoMeta.setDisplayName(ChatColor.GREEN + "Calico");
        calico.setItemMeta(calicoMeta);

        pane.addItem(new GuiItem(calico, event -> {
            cat.setCatType(Cat.Type.CALICO);

            event.setCancelled(true);
        }));

        //persian
        ItemStack persian = new ItemStack(Material.WHITE_BANNER);
        ItemMeta persianMeta = persian.getItemMeta();
        persianMeta.setDisplayName(ChatColor.GREEN + "Persian");
        persian.setItemMeta(persianMeta);

        pane.addItem(new GuiItem(persian, event -> {
            cat.setCatType(Cat.Type.PERSIAN);

            event.setCancelled(true);
        }));

        //ragdoll
        ItemStack ragdoll = new ItemStack(Material.WHITE_BANNER);
        BannerMeta ragdollMeta = (BannerMeta) ragdoll.getItemMeta();
        ragdollMeta.addPattern(new Pattern(DyeColor.YELLOW, PatternType.DIAGONAL_RIGHT));
        ragdollMeta.setDisplayName(ChatColor.GREEN + "Ragdoll");
        ragdoll.setItemMeta(ragdollMeta);

        pane.addItem(new GuiItem(ragdoll, event -> {
            cat.setCatType(Cat.Type.RAGDOLL);

            event.setCancelled(true);
        }));

        //white
        ItemStack white = new ItemStack(Material.WHITE_BANNER);
        BannerMeta whiteMeta = (BannerMeta) white.getItemMeta();
        whiteMeta.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.DIAGONAL_RIGHT));
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            cat.setCatType(Cat.Type.WHITE);

            event.setCancelled(true);
        }));

        //all black
        ItemStack black = new ItemStack(Material.BLACK_BANNER);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        pane.addItem(new GuiItem(black, event -> {
            cat.setCatType(Cat.Type.ALL_BLACK);

            event.setCancelled(true);
        }));

        //jellie
        ItemStack jellie = new ItemStack(Material.GRAY_BANNER);
        BannerMeta jellieMeta = (BannerMeta) jellie.getItemMeta();
        jellieMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT));
        jellieMeta.setDisplayName(ChatColor.GREEN + "Jellie");
        jellie.setItemMeta(jellieMeta);

        pane.addItem(new GuiItem(jellie, event -> {
            cat.setCatType(Cat.Type.JELLIE);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
