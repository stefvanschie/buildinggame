package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions;

import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A gui for changing whether an entity is adult or baby
 *
 * @since 5.3.0
 */
public class BabyMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public BabyMenu(Plot plot, Entity entity) {
        super(plot, entity);

        ItemStack baby = new ItemStack(Material.EGG);
        ItemMeta babyMeta = baby.getItemMeta();
        babyMeta.setDisplayName(ChatColor.GREEN + "Change to baby/adult");
        baby.setItemMeta(babyMeta);

        insertItem(baby, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (entity instanceof Ageable) {
                    Ageable ageable = (Ageable) entity;
                    if (ageable.isAdult())
                        ageable.setBaby();
                    else
                        ageable.setAdult();
                } else if (entity instanceof Zombie) {
                    Zombie zombie = (Zombie) entity;
                    zombie.setBaby(!zombie.isBaby());
                }

                return true;
            }
        }, 0);
    }
}
