package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * A target that can be used with commands to specify the objects that will execute the specified command
 *
 * @since 5.5.4
 */
public final class Target {

    /**
     * A list of targets that belong to the parsed target
     */
    private final Collection<CommandSender> targets = new ArrayList<>();

    /**
     * A map listing all possible functions mapped to their respective names
     */
    private static final Map<String, Supplier<List<CommandSender>>> FUNCTIONS = new HashMap<>();

    /**
     * Creates a new Target. Shouldn't be called outside this class.
     */
    private Target() {}

    /**
     * Executes the specified command for every target
     *
     * @param command the command to execute
     * @since 5.5.4
     */
    public void execute(String command) {
        targets.forEach(target -> Bukkit.dispatchCommand(target, command));
    }

    /**
     * Returns the list of targets
     *
     * @return the list of targets
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private Collection<CommandSender> getTargets() {
        return targets;
    }

    /**
     * Parses a target from a piece of text
     *
     * @param command the command from which the target should be parsed
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    public static Target parse(String command) {
        var target = new Target();

        //remove at sign
        command = command.substring(1);

        //look for target
        for (var entry : FUNCTIONS.entrySet()) {
            if (!entry.getKey().equals(command))
                continue;

            target.getTargets().addAll(entry.getValue().get());
        }

        return target;
    }

    static {
        FUNCTIONS.put("console", () -> Collections.singletonList(Bukkit.getConsoleSender()));
        FUNCTIONS.put("game-players", () -> ArenaManager.getInstance().getArenas().stream().flatMap(arena ->
            arena.getPlots().stream()).flatMap(plot -> plot.getGamePlayers().stream()).map(GamePlayer::getPlayer)
            .collect(Collectors.toList()));
    }
}
