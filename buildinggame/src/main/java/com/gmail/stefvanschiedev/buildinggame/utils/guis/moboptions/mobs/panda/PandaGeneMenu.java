package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Panda;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;

/**
 * A menu for changing the personality of a panda
 *
 * @since 7.0.0
 */
class PandaGeneMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    PandaGeneMenu(Panda panda) {
        super(1, ChatColor.GREEN + "Change the panda's personality");

        var pane = new OutlinePane(1, 0, 7, 1);

        //lazy
        ItemStack lazy = getSkull(
            "7818b681cace1c641919f53edadecb142330d089a826b56219138c33b7a5e0db"
        );
        ItemMeta lazyMeta = lazy.getItemMeta();
        lazyMeta.setDisplayName(ChatColor.GREEN + "Lazy");
        lazy.setItemMeta(lazyMeta);

        pane.addItem(new GuiItem(lazy, event -> {
            panda.setMainGene(Panda.Gene.LAZY);
            panda.setHiddenGene(Panda.Gene.LAZY);

            event.setCancelled(true);
        }));

        //worried
        ItemStack worried = getSkull(
            "c8e921c57e54dd07337ffba629e72caf3850d836b76562b1bc3bc5949f2d41d"
        );
        ItemMeta worriedMeta = worried.getItemMeta();
        worriedMeta.setDisplayName(ChatColor.GREEN + "Worried");
        worried.setItemMeta(worriedMeta);

        pane.addItem(new GuiItem(worried, event -> {
            panda.setMainGene(Panda.Gene.WORRIED);
            panda.setHiddenGene(Panda.Gene.WORRIED);

            event.setCancelled(true);
        }));

        //playful
        ItemStack playful = getSkull(
            "b6463e64ce29764db3cb46806cee606afc24bdf0ce14b6660c270a96c787426"
        );
        ItemMeta playfulMeta = playful.getItemMeta();
        playfulMeta.setDisplayName(ChatColor.GREEN + "Playful");
        playful.setItemMeta(playfulMeta);

        pane.addItem(new GuiItem(playful, event -> {
            panda.setMainGene(Panda.Gene.PLAYFUL);
            panda.setHiddenGene(Panda.Gene.PLAYFUL);

            event.setCancelled(true);
        }));

        pane.addItem(new GuiItem(new ItemStack(Material.AIR)));

        //aggressive
        ItemStack aggressive = getSkull(
            "83fe1e782ae96a30336a03ef74681ce3a6905fcc673fa56c046aaee6aa28307d"
        );
        ItemMeta aggressiveMeta = aggressive.getItemMeta();
        aggressiveMeta.setDisplayName(ChatColor.GREEN + "Aggressive");
        aggressive.setItemMeta(aggressiveMeta);

        pane.addItem(new GuiItem(aggressive, event -> {
            panda.setMainGene(Panda.Gene.AGGRESSIVE);
            panda.setHiddenGene(Panda.Gene.AGGRESSIVE);

            event.setCancelled(true);
        }));

        //weak
        ItemStack weak = getSkull(
            "5c2d25e956337d82791fa0e6617a40086f02d6ebfbfd5a6459889cf206fca787"
        );
        ItemMeta weakMeta = weak.getItemMeta();
        weakMeta.setDisplayName(ChatColor.GREEN + "Weak");
        weak.setItemMeta(weakMeta);

        pane.addItem(new GuiItem(weak, event -> {
            panda.setMainGene(Panda.Gene.WEAK);
            panda.setHiddenGene(Panda.Gene.WEAK);

            event.setCancelled(true);
        }));

        //brown
        ItemStack brown = new ItemStack(Material.BROWN_DYE);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            panda.setMainGene(Panda.Gene.BROWN);
            panda.setHiddenGene(Panda.Gene.BROWN);

            event.setCancelled(true);
        }));

        addPane(pane);
    }

    /**
     * Gets a skull as an itemstack from the given id. The id has to be the id after the https://textures.minecraft.net/
     * domain.
     *
     * @param id the id to create the skull from
     * @return the itemstack
     * @since 7.0.0
     */
    @NotNull
    @Contract(pure = true)
    private ItemStack getSkull(@NotNull String id) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta skullMeta = itemStack.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        String fullUrl = "http://textures.minecraft.net/texture/" + id;
        byte[] bytes = String.format("{textures:{SKIN:{url:\"%s\"}}}", fullUrl).getBytes();
        byte[] encodedData = Base64.getEncoder().encode(bytes);

        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }

        itemStack.setItemMeta(skullMeta);

        return itemStack;
    }
}
