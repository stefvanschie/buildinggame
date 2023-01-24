package com.gmail.stefvanschiedev.buildinggame.events.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.NPCFloorChangeTrait;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import net.citizensnpcs.api.event.NPCSpawnEvent;
import net.citizensnpcs.api.event.PlayerCreateNPCEvent;
import net.citizensnpcs.api.npc.NPC;
import net.kyori.text.TextComponent;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.event.ClickEvent;
import net.kyori.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Listens to NPC creation to see if they are inside a plot and automatically asks you if you want to make it a floor
 * changer.
 *
 * @since 7.1.0
 */
public class NPCCreate implements Listener {

    /**
     * A map of {@link NPC}s and their spawners which have been created, but not yet spawned
     */
    private final Map<NPC, Player> toBeSpawned = new WeakHashMap<>();

    /**
     * Called when a {@link NPC} is created
     *
     * @param event the event fired when an {@link NPC} is created
     * @since 7.1.0
     */
    @EventHandler
    private void onNPCCreate(@NotNull PlayerCreateNPCEvent event) {
        toBeSpawned.put(event.getNPC(), event.getCreator());
    }

    /**
     * Called when a {@link NPC} is spawned
     *
     * @param event the event fired when an {@link NPC} is spawned
     * @since 7.1.0
     */
    @EventHandler
    private void onNPCSpawn(@NotNull NPCSpawnEvent event) {
        toBeSpawned.entrySet().stream()
            .filter(entry -> event.getNPC().equals(entry.getKey()))
            .findAny()
            .ifPresent(entry -> {
                NPC npc = entry.getKey();
                toBeSpawned.remove(npc);

                if (ArenaManager.getInstance().getArenas().stream()
                    .flatMap(arena -> arena.getPlots().stream())
                    .map(Plot::getBoundary)
                    .anyMatch(boundary -> boundary.isInside(event.getLocation()))) {
                    Player player = entry.getValue();

                    TextComponent textComponent = TextComponent.of(
                        "You have spawned an NPC inside a plot, would you like to allow players to use this NPC to change their plot's floor? Please click "
                    )
                        .color(TextColor.GOLD)
                        .append(TextComponent.of("here")
                            .color(TextColor.AQUA)
                            .clickEvent(ClickEvent.runCommand('/' + CommandUtil.createTempCommand(sender -> {
                                if (!sender.equals(player)) {
                                    return;
                                }

                                npc.addTrait(new NPCFloorChangeTrait());

                                MessageManager.getInstance().send(player, ChatColor.GREEN +
                                    "This NPC now allows players to change their plot's floor");
                            }))))
                        .append(TextComponent.of(
                            " if so, otherwise ignore this message. This will expire in 60 seconds."
                        )
                            .color(TextColor.GOLD));

                    TextAdapter.sendComponent(player, textComponent);
                }
            });
    }
}
