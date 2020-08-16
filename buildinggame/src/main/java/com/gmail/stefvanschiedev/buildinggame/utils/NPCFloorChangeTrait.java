package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * A trait for a citizens NPS that enables this NPC to open the floor change menu, or apply the block as in the player's
 * hand as the floor.
 *
 * @since 7.1.0
 */
public class NPCFloorChangeTrait extends Trait {

    /**
     * Creates a new instance of this trait.
     *
     * @since 7.1.0
     */
    public NPCFloorChangeTrait() {
        super("buildinggame:floorchange");
    }

    /**
     * Handles a player clicking on this NPC and applying the block as floor, or opening the floor menu.
     *
     * @param event the event that got fired when an {@link NPC} is clicked
     * @since 7.1.0
     */
    private void handleClick(@NotNull NPCClickEvent event) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (!event.getNPC().equals(getNPC())) {
            return;
        }

        var player = event.getClicker();
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
            return;
        }

        var plot = arena.getPlot(player);
        var floorMenu = plot.getBuildMenu().getFloorMenu();
        long floorChange = floorMenu.getLastFloorChange();

        int cooldown = (int) config.getDouble("gui.floor.cooldown") * 1000;

        if (cooldown > 0 && System.currentTimeMillis() - floorChange < cooldown) {
            MessageManager.getInstance().send(player, ChatColor.YELLOW + "You have to wait " +
                (((cooldown - System.currentTimeMillis()) + floorChange) / 1000.0) +
                " seconds before you can change the floor again");
            event.setCancelled(true);
            return;
        }

        Material materialInHand = player.getInventory().getItemInMainHand().getType();

        if (materialInHand == Material.AIR) {
            floorMenu.show(player);
            floorMenu.setLastFloorChange(System.currentTimeMillis());
            event.setCancelled(true);
            return;
        }

        for (String materialString : config.getStringList("blocks.blocked")) {
            Material material = Material.matchMaterial(materialString);

            if (material == null) {
                Logger logger = Main.getInstance().getLogger();
                logger.warning("Invalid material found in the config.yml in 'blocks.blocked' ('" +
                    materialString + "')");
            }

            if (material != materialInHand) {
                continue;
            }

            MessageManager.getInstance().send(player, messages.getStringList("plots.floor.blocked"));

            event.setCancelled(true);
            return;
        }

        if (materialInHand == Material.WATER_BUCKET) {
            plot.getFloor().getAllBlocks().forEach(block -> block.setType(Material.WATER));

            floorMenu.setLastFloorChange(System.currentTimeMillis());

            event.setCancelled(true);
            return;
        }

        if (materialInHand == Material.LAVA_BUCKET) {
            plot.getFloor().getAllBlocks().forEach(block -> block.setType(Material.LAVA));

            floorMenu.setLastFloorChange(System.currentTimeMillis());

            event.setCancelled(true);
            return;
        }

        if (!materialInHand.isBlock()) {
            MessageManager.getInstance().send(player, messages.getStringList("plots.floor.incorrect"));

            event.setCancelled(true);
            return;
        }

        plot.getFloor().getAllBlocks().stream()
            .filter(block -> block.getType() != materialInHand)
            .forEach(block -> block.setType(materialInHand));

        floorMenu.setLastFloorChange(System.currentTimeMillis());

        event.setCancelled(true);
    }

    /**
     * Handles players left clicking on NPCs.
     *
     * @param event the event called when a player left clicked on a NPC
     * @since 7.1.0
     */
    @EventHandler
    public void onLeftClick(@NotNull NPCLeftClickEvent event) {
        handleClick(event);
    }

    /**
     * Handles players right clicking on NPCs.
     *
     * @param event the event called when a player right clicked on a NPC
     * @since 7.1.0
     */
    @EventHandler
    public void onRightClick(@NotNull NPCRightClickEvent event) {
        handleClick(event);
    }
}
