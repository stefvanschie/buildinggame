package com.gmail.stefvanschiedev.buildinggame.events.entity;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.ChestMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.*;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.axolotl.AxolotlMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cat.CatMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.fox.FoxMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse.HorseMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.irongolem.IronGolemMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama.LlamaMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom.MooshroomMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda.PandaMenu;
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
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.EnumSet;

/**
 * Handles opening the options menu for entities
 */
public class EntityOptionsMenu implements Listener {

    /**
     * Represents the entity types for which the options menu only opens in case you hold shift.
     *
     * @since 9.1.0
     */
    @NotNull
    private static final Collection<EntityType> SHIFT_CLICK_TYPES = EnumSet.of(
        EntityType.BOAT,
        EntityType.ITEM_FRAME,
        EntityType.MINECART
    );

    /**
     * Called whenever a player interacts with an entity
     *
     * @param e the event that is called when a player interacts with an entity
     * @since 5.3.0
     */
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        SettingsManager settingsManager = SettingsManager.getInstance();

        if (e.getHand() != EquipmentSlot.HAND || !settingsManager.getConfig().getBoolean("mobs.options.enable")) {
            return;
        }

        var entity = e.getRightClicked();
        EntityType entityType = entity.getType();
        Player player = e.getPlayer();

        if (SHIFT_CLICK_TYPES.contains(entityType) && !player.isSneaking()) {
            return;
        }

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

        if (plot == null || plot.getArena().getState() != GameState.BUILDING) {
            return;
        }

        switch (entityType) {
            case CHICKEN:
            case COW:
            case GOAT:
            case OCELOT:
            case SKELETON_HORSE:
            case POLAR_BEAR:
            case HUSK:
            case ZOMBIE:
            case TURTLE:
            case PIGLIN:
            case HOGLIN:
            case STRIDER:
            case ZOGLIN:
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
            case AXOLOTL:
                new AxolotlMenu(plot, (Axolotl) entity).show(player);
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
            case PANDA:
                new PandaMenu(plot, (Panda) entity).show(player);
                break;
            case CAT:
                new CatMenu(plot, (Cat) entity).show(player);
                break;
            case FOX:
                new FoxMenu(plot, (Fox) entity).show(player);
                break;
            case BEE:
                new BeeMenu(plot, (Bee) entity).show(player);
                break;
            case IRON_GOLEM:
                new IronGolemMenu(plot, (IronGolem) entity).show(player);
                break;
            default:
                new RemoveMenu(plot, entity).show(player);
                break;
        }

        e.setCancelled(true);
    }
}
