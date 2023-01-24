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
 * A menu for selecting the skin type of villager-like creatures.
 *
 * @since 7.0.0
 */
class SkinTypeSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    SkinTypeSelectionMenu(@NotNull Creature villagerLike) {
        super(1, ChatColor.GREEN + "Select skin type");

        Object nmsVillager = null;
        Object villagerData = null;

        try {
            if (villagerLike instanceof ZombieVillager) {
                nmsVillager = CRAFT_VILLAGER_ZOMBIE_GET_HANDLE.invoke(villagerLike);
                villagerData = ENTITY_ZOMBIE_VILLAGER_GET_VILLAGER_DATA.invoke(nmsVillager);
            } else if (!(villagerLike instanceof Villager)){
                throw new UnsupportedOperationException(
                    "Can't set the skin of anything other than a Villager or ZombieVillager"
                );
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        final Object finalNMSVillager = nmsVillager;
        final Object finalVillagerData = villagerData;

        var pane = new OutlinePane(1, 0, 7, 1);

        //plains
        ItemStack plains = new ItemStack(Material.GRASS);
        ItemMeta plainsMeta = plains.getItemMeta();
        plainsMeta.setDisplayName(ChatColor.GREEN + "Plains");
        plains.setItemMeta(plainsMeta);

        pane.addItem(new GuiItem(plains, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.PLAINS);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_C);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //desert
        ItemStack desert = new ItemStack(Material.SAND);
        ItemMeta desertMeta = desert.getItemMeta();
        desertMeta.setDisplayName(ChatColor.GREEN + "Desert");
        desert.setItemMeta(desertMeta);

        pane.addItem(new GuiItem(desert, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.DESERT);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_A);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //savanna
        ItemStack savanna = new ItemStack(Material.ACACIA_LOG);
        ItemMeta savannaMeta = savanna.getItemMeta();
        savannaMeta.setDisplayName(ChatColor.GREEN + "Savanna");
        savanna.setItemMeta(savannaMeta);

        pane.addItem(new GuiItem(savanna, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.SAVANNA);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_D);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //taiga
        ItemStack taiga = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta taigaMeta = taiga.getItemMeta();
        taigaMeta.setDisplayName(ChatColor.GREEN + "Taiga");
        taiga.setItemMeta(taigaMeta);

        pane.addItem(new GuiItem(taiga, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.TAIGA);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_G);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //snowy tundra
        ItemStack snowyTundra = new ItemStack(Material.ICE);
        ItemMeta snowyTundraMeta = snowyTundra.getItemMeta();
        snowyTundraMeta.setDisplayName(ChatColor.GREEN + "Snowy Tundra");
        snowyTundra.setItemMeta(snowyTundraMeta);

        pane.addItem(new GuiItem(snowyTundra, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.SNOW);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_E);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //jungle
        ItemStack jungle = new ItemStack(Material.VINE);
        ItemMeta jungleMeta = jungle.getItemMeta();
        jungleMeta.setDisplayName(ChatColor.GREEN + "Jungle");
        jungle.setItemMeta(jungleMeta);

        pane.addItem(new GuiItem(jungle, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.JUNGLE);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_B);
                    ENTITY_ZOMBIE_VILLAGER_SET_VILLAGER_DATA.invoke(finalNMSVillager, newVillagerData);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            event.setCancelled(true);
        }));

        //swamp
        ItemStack swamp = new ItemStack(Material.LILY_PAD);
        ItemMeta swampMeta = swamp.getItemMeta();
        swampMeta.setDisplayName(ChatColor.GREEN + "Swamp");
        swamp.setItemMeta(swampMeta);

        pane.addItem(new GuiItem(swamp, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setVillagerType(Villager.Type.SWAMP);
            } else if (villagerLike instanceof ZombieVillager) {
                try {
                    Object newVillagerData = VILLAGER_DATA_WITH_TYPE.invoke(finalVillagerData, VILLAGER_TYPE_F);
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
     * A method that sets the type of the VillagerData and returns the now updated VillagerData
     *
     * Parameters: VillagerType
     * Returns: VillagerData
     */
    private static Method VILLAGER_DATA_WITH_TYPE;

    /**
     * An object which indicates the VillagerType of desert
     */
    private static Object VILLAGER_TYPE_A;

    /**
     * An object which indicates the VillagerType of jungle
     */
    private static Object VILLAGER_TYPE_B;

    /**
     * An object which indicates the VillagerType of plains
     */
    private static Object VILLAGER_TYPE_C;

    /**
     * An object which indicates the VillagerType of savanna
     */
    private static Object VILLAGER_TYPE_D;

    /**
     * An object which indicates the VillagerType of snow
     */
    private static Object VILLAGER_TYPE_E;

    /**
     * An object which indicates the VillagerType of swamp
     */
    private static Object VILLAGER_TYPE_F;

    /**
     * An object which indicates the VillagerType of taiga
     */
    private static Object VILLAGER_TYPE_G;

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

            Class<?> villagerTypeClass = Class.forName(baseNMSClassName + ".VillagerType");
            VILLAGER_DATA_WITH_TYPE = villagerDataClass.getMethod("withType", villagerTypeClass);

            VILLAGER_TYPE_A = villagerTypeClass.getDeclaredField("a").get(null);
            VILLAGER_TYPE_B = villagerTypeClass.getDeclaredField("b").get(null);
            VILLAGER_TYPE_C = villagerTypeClass.getDeclaredField("c").get(null);
            VILLAGER_TYPE_D = villagerTypeClass.getDeclaredField("d").get(null);
            VILLAGER_TYPE_E = villagerTypeClass.getDeclaredField("e").get(null);
            VILLAGER_TYPE_F = villagerTypeClass.getDeclaredField("f").get(null);
            VILLAGER_TYPE_G = villagerTypeClass.getDeclaredField("g").get(null);
        } catch (NoSuchMethodException | ClassNotFoundException | NoSuchFieldException |
            IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}
