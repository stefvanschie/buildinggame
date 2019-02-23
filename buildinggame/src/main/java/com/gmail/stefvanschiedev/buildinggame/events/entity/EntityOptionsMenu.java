package com.gmail.stefvanschiedev.buildinggame.events.entity;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.ChestMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.*;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse.HorseMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama.LlamaMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom.MooshroomMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot.ParrotMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pufferfish.PufferfishMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit.RabbitMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish.TropicalFishMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike.VillagerlikeMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size.SizeMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

/**
 * Handles opening the options menu for entities
 */
public class EntityOptionsMenu implements Listener {

    /**
     * Called whenever a player interacts with an entity
     *
     * @param e the event that is called when a player interacts with an entity
     * @since 5.3.0
     */
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        if (e.getHand() != EquipmentSlot.HAND)
            return;

        var entity = e.getRightClicked();
        Plot plot = null;

        loop:
        for (var arena : ArenaManager.getInstance().getArenas()) {
            for (Plot p : arena.getUsedPlots()) {
                if (p.getEntities().containsKey(entity)) {
                    plot = p;
                    break loop;
                }
            }
        }

        if (plot == null)
            return;

        var player = e.getPlayer();

        switch (entity.getType()) {
            case CHICKEN:
            case COW:
            case OCELOT:
            case SKELETON_HORSE:
            case POLAR_BEAR:
            case PIG_ZOMBIE:
            case HUSK:
            case ZOMBIE:
            case TURTLE:
                new BabyMenu(plot, entity).show(player);
                break;
            case DONKEY:
            case MULE:
                new ChestMenu(plot, (ChestedHorse) entity).show(player);
                break;
            case VILLAGER:
            case ZOMBIE_VILLAGER:
                new VillagerlikeMenu(plot, (Creature) entity).show(player);
                break;
            case PHANTOM:
            case MAGMA_CUBE:
            case SLIME:
                new SizeMenu(plot, (Mob) entity).show(player);
                break;
            case PIG:
                new PigMenu(plot, (Pig) entity).show(player);
                break;
            case RABBIT:
                new RabbitMenu(plot, (Rabbit) entity).show(player);
                break;
            case SHEEP:
                new SheepMenu(plot, (Sheep) entity).show(player);
                break;
            case CREEPER:
                new CreeperMenu(plot, (Creeper) entity).show(player);
                break;
            case SHULKER:
                new ShulkerMenu(plot, (Shulker) entity).show(player);
                break;
            case HORSE:
                new HorseMenu(plot, (Horse) entity).show(player);
                break;
            case LLAMA:
                new LlamaMenu(plot, (Llama) entity).show(player);
                break;
            case PARROT:
                new ParrotMenu(plot, (Parrot) entity).show(player);
                break;
            case WOLF:
                new ColorMenu(plot, (Animals) entity).show(player);
                break;
            case SNOWMAN:
                new SnowGolemMenu(plot, (Snowman) entity).show(player);
                break;
            case PUFFERFISH:
                new PufferfishMenu(plot, (PufferFish) entity).show(player);
                break;
            case TROPICAL_FISH:
                new TropicalFishMenu(plot, (TropicalFish) entity).show(player);
                break;
            case MUSHROOM_COW:
                new MooshroomMenu(plot, (MushroomCow) entity).show(player);
                break;
            //TODO: Add case for the PANDA
            //TODO: Add case for the CAT
            //TODO: Add case for the FOX
            default:
                new RemoveMenu(plot, entity).show(player);
                break;
        }

        e.setCancelled(true);
    }
}
