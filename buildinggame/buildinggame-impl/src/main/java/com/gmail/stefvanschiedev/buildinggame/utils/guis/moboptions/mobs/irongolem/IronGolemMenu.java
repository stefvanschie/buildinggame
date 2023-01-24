package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.irongolem;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.IronGolem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The menu used for iron golems
 *
 * @since 8.0.0
 */
public class IronGolemMenu extends RemoveMenu {

    /**
     * The amount of damage it takes for an iron chestplate to go from no damage to breaking completely
     */
    static final int MAX_DAMAGE = 241;

    /**
     * {@inheritDoc}
     */
    public IronGolemMenu(@NotNull Plot plot, @NotNull IronGolem ironGolem) {
        super(plot, ironGolem);

        var cracked = new ItemStack(Material.IRON_CHESTPLATE);
        var crackedMeta = cracked.getItemMeta();
        ((Damageable) crackedMeta).setDamage(ThreadLocalRandom.current().nextInt(MAX_DAMAGE));
        crackedMeta.setDisplayName(ChatColor.GREEN + "Set the cracked state");
        cracked.setItemMeta(crackedMeta);

        pane.insertItem(new GuiItem(cracked, event -> {
            new IronGolemCrackedMenu(ironGolem).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
