package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * A class with utility methods for handling commands
 *
 * @since 7.0.1
 */
public final class CommandUtil {

    /**
     * The command map
     */
    private static final CommandMap COMMAND_MAP = getCommandMap();

    /**
     * Private constructor to avoid instantiating this utility class.
     *
     * @since 7.0.1
     */
    @Contract(pure = true)
    private CommandUtil() {}

    /**
     * Creates a temporary command. When the command is executed the {@code onCalled} {@link Consumer} will be called
     * with the {@link CommandSender} who executed the command. This command will automatically be destroyed when the
     * command has been ran once, or after 60 seconds.
     *
     * @param onCalled when the command is being executed, this will be called.
     * @return the name of the command
     * @since 7.1.0
     */
    public static String createTempCommand(Consumer<CommandSender> onCalled) {
        UUID uuid = UUID.randomUUID();

        Command command = new Command(uuid.toString()) {
            @Override
            public boolean execute(@NotNull CommandSender commandSender, @NotNull String label,
                                   @NotNull String[] args) {
                onCalled.accept(commandSender);

                try {
                    Field field = SimpleCommandMap.class.getDeclaredField("knownCommands");
                    field.setAccessible(true);
                    //noinspection unchecked: this is safe, because the field is a HashMap<String, Command>
                    ((Map<String, Command>) field.get(COMMAND_MAP)).remove(uuid.toString());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                unregister(COMMAND_MAP);

                return true;
            }
        };

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            try {
                Field field = SimpleCommandMap.class.getDeclaredField("knownCommands");
                field.setAccessible(true);
                //noinspection unchecked: this is safe, because the field is a HashMap<String, Command>
                ((Map<String, Command>) field.get(COMMAND_MAP)).remove(uuid.toString());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }, 1200);

        COMMAND_MAP.register(uuid.toString(), command);

        return uuid.toString();
    }

    /**
     * Dispatches the specified command, with respect for any optionally specified target.
     *
     * @param command the command to dispatch
     * @since 7.0.1
     */
    public static void dispatch(@NotNull String command) {
        if (!command.isEmpty() && command.charAt(0) == '@') {
            String targetText = command.split(" ")[0];

            Target.parse(targetText).execute(command.substring(targetText.length() + 1));
        } else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }

    /**
     * Gets the command map currently in use
     *
     * @return the command map
     * @since 7.1.0
     */
    @Nullable
    @Contract(pure = true)
    private static CommandMap getCommandMap() {
        try {
            Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            return (CommandMap) field.get(Bukkit.getPluginManager());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();

            return null;
        }
    }
}
