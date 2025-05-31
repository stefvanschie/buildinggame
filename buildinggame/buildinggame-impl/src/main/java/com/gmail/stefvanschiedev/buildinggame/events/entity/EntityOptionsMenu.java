package com.gmail.stefvanschiedev.buildinggame.events.entity;

import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.game.BuildingGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.ChestMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.*;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.axolotl.AxolotlMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cat.CatMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.chicken.ChickenMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cow.CowMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.fox.FoxMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.frog.FrogMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse.HorseMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.irongolem.IronGolemMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama.LlamaMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom.MooshroomMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda.PandaMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot.ParrotMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pig.PigMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pufferfish.PufferfishMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit.RabbitMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish.TropicalFishMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike.VillagerlikeMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.wolf.WolfMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size.SizeMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.nms.Version;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Handles opening the options menu for entities
 */
public class EntityOptionsMenu implements Listener {

    /**
     * A mapping between an {@link EntityType} and a function which returns a {@link Gui} for the corresponding
     * {@link EntityType}. When calling the function from K/V pair, the {@link Entity} instance must be of the class
     * that corresponds with the {@link EntityType} from the key. For example, the function attached to
     * {@link EntityType#TROPICAL_FISH}, must be invoked with an {@link Entity} that is an instance of
     * {@link TropicalFish}.
     */
    @NotNull
    private static final Map<
        ? super EntityType,
        BiFunction<? super Plot, ? super Entity, ? extends Gui>
    > GUI_MAPPING = new HashMap<>(Map.ofEntries(
        Map.entry(EntityType.AXOLOTL, (Plot plot, Entity axolotl) -> new AxolotlMenu(plot, (Axolotl) axolotl)),
        Map.entry(EntityType.BEE, (Plot plot, Entity bee) -> new BeeMenu(plot, (Bee) bee)),
        Map.entry(EntityType.CAMEL, BabyMenu::new),
        Map.entry(EntityType.CAT, (Plot plot, Entity cat) -> new CatMenu(plot, (Cat) cat)),
        Map.entry(EntityType.CREEPER, (Plot plot, Entity creeper) -> new CreeperMenu(plot, (Creeper) creeper)),
        Map.entry(EntityType.DONKEY, (Plot plot, Entity donkey) -> new ChestMenu(plot, (ChestedHorse) donkey)),
        Map.entry(EntityType.FOX, (Plot plot, Entity fox) -> new FoxMenu(plot, (Fox) fox)),
        Map.entry(EntityType.FROG, (Plot plot, Entity frog) -> new FrogMenu(plot, (Frog) frog)),
        Map.entry(EntityType.GOAT, (Plot plot, Entity goat) -> new GoatMenu(plot, (Goat) goat)),
        Map.entry(EntityType.HOGLIN, BabyMenu::new),
        Map.entry(EntityType.HORSE, (Plot plot, Entity horse) -> new HorseMenu(plot, (Horse) horse)),
        Map.entry(EntityType.HUSK, BabyMenu::new),
        Map.entry(EntityType.IRON_GOLEM, (Plot plot, Entity ironGolem) ->
            new IronGolemMenu(plot, (IronGolem) ironGolem)),
        Map.entry(EntityType.LLAMA, (Plot plot, Entity llama) -> new LlamaMenu(plot, (Llama) llama)),
        Map.entry(EntityType.MAGMA_CUBE, (Plot plot, Entity magmaCube) -> new SizeMenu(plot, (Mob) magmaCube)),
        Map.entry(EntityType.MULE, (Plot plot, Entity mule) -> new ChestMenu(plot, (ChestedHorse) mule)),
        //Spigot will remap this to MOOSHROOM for modern versions
        Map.entry(EntityType.valueOf("MUSHROOM_COW"), (Plot plot, Entity mooshroom) ->
            new MooshroomMenu(plot, (MushroomCow) mooshroom)),
        Map.entry(EntityType.OCELOT, BabyMenu::new),
        Map.entry(EntityType.PANDA, (Plot plot, Entity panda) -> new PandaMenu(plot, (Panda) panda)),
        Map.entry(EntityType.PARROT, (Plot plot, Entity parrot) -> new ParrotMenu(plot, (Parrot) parrot)),
        Map.entry(EntityType.PHANTOM, (Plot plot, Entity phantom) -> new SizeMenu(plot, (Mob) phantom)),
        Map.entry(EntityType.PIG, (Plot plot, Entity pig) -> new PigMenu(plot, (Pig) pig)),
        Map.entry(EntityType.PIGLIN, BabyMenu::new),
        Map.entry(EntityType.POLAR_BEAR, BabyMenu::new),
        Map.entry(EntityType.PUFFERFISH, (Plot plot, Entity pufferfish) ->
            new PufferfishMenu(plot, (PufferFish) pufferfish)),
        Map.entry(EntityType.RABBIT, (Plot plot, Entity rabbit) -> new RabbitMenu(plot, (Rabbit) rabbit)),
        Map.entry(EntityType.SHEEP, (Plot plot, Entity sheep) -> new SheepMenu(plot, (Sheep) sheep)),
        Map.entry(EntityType.SHULKER, (Plot plot, Entity shulker) -> new ShulkerMenu(plot, (Shulker) shulker)),
        Map.entry(EntityType.SKELETON_HORSE, BabyMenu::new),
        Map.entry(EntityType.SLIME, (Plot plot, Entity slime) -> new SizeMenu(plot, (Mob) slime)),
        Map.entry(EntityType.SNIFFER, BabyMenu::new),
        //Spigot will remap this to SNOW_GOLEM for modern versions
        Map.entry(EntityType.valueOf("SNOWMAN"), (Plot plot, Entity snowGolem) ->
            new SnowGolemMenu(plot, (Snowman) snowGolem)),
        Map.entry(EntityType.STRIDER, BabyMenu::new),
        Map.entry(EntityType.TROPICAL_FISH, (Plot plot, Entity tropicalFish) ->
            new TropicalFishMenu(plot, (TropicalFish) tropicalFish)),
        Map.entry(EntityType.TURTLE, BabyMenu::new),
        Map.entry(EntityType.VILLAGER, (Plot plot, Entity villager) -> new VillagerlikeMenu(plot, (Creature) villager)),
        Map.entry(EntityType.WOLF, (Plot plot, Entity wolf) -> new WolfMenu(plot, (Wolf) wolf)),
        Map.entry(EntityType.ZOGLIN, BabyMenu::new),
        Map.entry(EntityType.ZOMBIE, BabyMenu::new),
        Map.entry(EntityType.ZOMBIE_VILLAGER, (Plot plot, Entity zombieVillager) ->
            new VillagerlikeMenu(plot, (Creature) zombieVillager))
    ));

    /**
     * Represents the entity types for which the options menu only opens in case you hold shift.
     *
     * @since 9.1.0
     */
    @NotNull
    private static final Collection<EntityType> SHIFT_CLICK_TYPES = EnumSet.of(
        EntityType.valueOf("BOAT"),
        EntityType.valueOf("CHEST_BOAT"),
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

        if (plot == null || !(plot.getArena().getCurrentPhase() instanceof BuildingGamePhase)) {
            return;
        }

        BiFunction<? super Plot, ? super Entity, ? extends Gui> function = GUI_MAPPING.get(entityType);
        Gui gui;

        if (function == null) {
            gui = new RemoveMenu(plot, entity);
        } else {
            gui = function.apply(plot, entity);
        }

        gui.show(player);

        e.setCancelled(true);
    }

    static {
        Version version = Version.getVersion();

        if (version.isAtLeast(Version.V1_20_5)) {
            GUI_MAPPING.put(EntityType.valueOf("ARMADILLO"), BabyMenu::new);
        }

        if (version.isAtLeast(Version.V1_21_5)) {
            GUI_MAPPING.put(EntityType.CHICKEN, (Plot plot, Entity chicken) ->
                new ChickenMenu(plot, (Chicken) chicken));
            GUI_MAPPING.put(EntityType.COW, (Plot plot, Entity cow) -> new CowMenu(plot, (Cow) cow));
        } else {
            GUI_MAPPING.put(EntityType.CHICKEN, BabyMenu::new);
            GUI_MAPPING.put(EntityType.COW, BabyMenu::new);
        }
    }
}
