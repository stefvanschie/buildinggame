package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing villager's and villager-like creatures, like {@link org.bukkit.entity.ZombieVillager}s
 *
 * @since 7.0.0
 */
public class VillagerlikeMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public VillagerlikeMenu(Plot plot, Creature creature) {
        super(plot, creature);

        //profession
        var profession = new ItemStack(Material.EMERALD);
        var professionMeta = profession.getItemMeta();
        professionMeta.setDisplayName(ChatColor.GREEN + "Change the profession");
        profession.setItemMeta(professionMeta);

        pane.insertItem(new GuiItem(profession, event -> {
            new ProfessionSelectionMenu(creature).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);

        //skin type
        var skinType = new ItemStack(Material.OAK_SAPLING);
        var skinTypeMeta = skinType.getItemMeta();
        skinTypeMeta.setDisplayName(ChatColor.GREEN + "Change the skin type");
        skinType.setItemMeta(skinTypeMeta);

        pane.insertItem(new GuiItem(skinType, event -> {
            new SkinTypeSelectionMenu(creature).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 1);

        //level
        var level = new ItemStack(Material.EXPERIENCE_BOTTLE);
        var levelMeta = level.getItemMeta();
        levelMeta.setDisplayName(ChatColor.GREEN + "Change the level");
        level.setItemMeta(levelMeta);

        pane.insertItem(new GuiItem(level, event -> {
            new LevelSelectionMenu(creature).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 2);
    }
}
