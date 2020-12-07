package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A menu for selecting the level of a villager-like.
 *
 * @since 7.0.0
 */
class LevelSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    LevelSelectionMenu(@NotNull Creature villagerLike) {
        super(1, ChatColor.GREEN + "Change the level");

        Object nmsVillager = null;
        Object villagerData = null;

        try {
            if (villagerLike instanceof ZombieVillager) {
                nmsVillager = CRAFT_VILLAGER_ZOMBIE_GET_HANDLE.invoke(villagerLike);
                villagerData = ENTITY_ZOMBIE_VILLAGER_GET_VILLAGER_DATA.invoke(nmsVillager);
            } else if (!(villagerLike instanceof Villager)){
                throw new UnsupportedOperationException(
                    "Can't set the level of anything other than a Villager or ZombieVillager"
                );
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        final Object finalNMSVillager = nmsVillager;
        final Object finalVillagerData = villagerData;

        var pane = new OutlinePane(2, 0, 5, 1);

        //level 1
        ItemStack level1 = new ItemStack(Material.STONE);
        ItemMeta level1Meta = level1.getItemMeta();
        level1Meta.setDisplayName(ChatColor.GREEN + "Level 1");
        level1.setItemMeta(level1Meta);

        pane.addItem(new GuiItem(level1, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerLevel(1);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_LEVEL.invoke(finalVillagerData, 1);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //level 2
        ItemStack level2 = new ItemStack(Material.IRON_INGOT);
        ItemMeta level2Meta = level2.getItemMeta();
        level2Meta.setDisplayName(ChatColor.GREEN + "Level 2");
        level2.setItemMeta(level2Meta);

        pane.addItem(new GuiItem(level2, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerLevel(2);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_LEVEL.invoke(finalVillagerData, 2);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //level 3
        ItemStack level3 = new ItemStack(Material.GOLD_INGOT);
        ItemMeta level3Meta = level3.getItemMeta();
        level3Meta.setDisplayName(ChatColor.GREEN + "Level 3");
        level3.setItemMeta(level3Meta);

        pane.addItem(new GuiItem(level3, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerLevel(3);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_LEVEL.invoke(finalVillagerData, 3);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //level 4
        ItemStack level4 = new ItemStack(Material.EMERALD);
        ItemMeta level4Meta = level4.getItemMeta();
        level4Meta.setDisplayName(ChatColor.GREEN + "Level 4");
        level4.setItemMeta(level4Meta);

        pane.addItem(new GuiItem(level4, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerLevel(4);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_LEVEL.invoke(finalVillagerData, 4);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //level 5
        ItemStack level5 = new ItemStack(Material.DIAMOND);
        ItemMeta level5Meta = level5.getItemMeta();
        level5Meta.setDisplayName(ChatColor.GREEN + "Level 5");
        level5.setItemMeta(level5Meta);

        pane.addItem(new GuiItem(level5, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerLevel(5);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_LEVEL.invoke(finalVillagerData, 5);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        addPane(pane);
    }

    //OBC / NMS helpers
    /**
     * A method that returns the EntityZombieVillager corresponding to the given CraftZombieVillager
     *
     * Returns: EntityZombieVillager
     */
    private static Method CRAFT_VILLAGER_ZOMBIE_GET_HANDLE;

    /**
     * A method that returns the VillagerData for the given EntityZombieVillager
     *
     * Returns: VillagerData
     */
    private static Method ENTITY_ZOMBIE_VILLAGER_GET_VILLAGER_DATA;

    /**
     * A method that sets the VillagerData for the given EntityZombieVillager
     *
     * Parameters: VillagerData
     */
    private static Method ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA;

    /**
     * A method that sets the level of the VillagerData and returns the now updated VillagerData
     *
     * Parameters: int
     * Returns: VillagerData
     */
    private static Method VILLAGER_DATA_WITH_LEVEL;

    static {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            String baseOBCClassName = "org.bukkit.craftbukkit." + version;

            Class<?> craftVillagerZombieClass = Class.forName(baseOBCClassName + ".entity.CraftVillagerZombie");
            CRAFT_VILLAGER_ZOMBIE_GET_HANDLE = craftVillagerZombieClass.getMethod("getHandle");

            String baseNMSClassName = "net.minecraft.server." + version;

            Class<?> entityZombieVillagerClass = Class.forName(baseNMSClassName + ".EntityZombieVillager");
            ENTITY_ZOMBIE_VILLAGER_GET_VILLAGER_DATA = entityZombieVillagerClass.getMethod("getVillagerData");

            Class<?> villagerDataClass = Class.forName(baseNMSClassName + ".VillagerData");
            ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA = entityZombieVillagerClass.getMethod("setVillagerData",
                villagerDataClass);

            VILLAGER_DATA_WITH_LEVEL = villagerDataClass.getMethod("withLevel", int.class);
        } catch (NoSuchMethodException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
