package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Enables or disables money for a specified arena
 *
 * @since 5.5.1
 */
public class EnableMoney extends ConsoleCommand {

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @NotNull
    @Override
    public CommandResult onCommand(CommandSender sender, String[] args) {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        if (args.length < 2) {
            MessageManager.getInstance().send(sender, ChatColor.RED +
                "Please specify an arena and true or false");
            return CommandResult.ARGUMENT_EXCEPTION;
        }

        Arena arena = ArenaManager.getInstance().getArena(args[0]);

        if (arena == null) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
            return CommandResult.ERROR;
        }

        boolean enableMoney = Boolean.parseBoolean(args[1]);

        arenas.set(arena.getName() + ".enable-money", enableMoney);

        arena.setMoneyEnabled(enableMoney);

        SettingsManager.getInstance().save();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + (enableMoney ? "Enabled" : "Disabled") +
            " money for " + arena.getName());

        return CommandResult.SUCCESS;
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @NotNull
    @Override
    public String getName() {
        return "enablemoney";
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Nls
    @NotNull
    @Override
    public String getInfo() {
        return "Enable/Disable money for an arena";
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @NotNull
    @Override
    public String getPermission() {
        return "bg.enablemoney";
    }
}