package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Activates a new booster
 *
 * @since 5.4.3
 */
public class BoosterCommand extends ConsoleCommand {

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public CommandResult onCommand(CommandSender sender, String[] args) {
        if (args.length < 2) {
            MessageManager.getInstance().send(sender,
                    ChatColor.RED + "Please specify the multiplier and the duration");
            return CommandResult.ARGUMENT_EXCEPTION;
        }

        float multiplier;

        try {
            multiplier = Float.parseFloat(args[0]);
        } catch (NumberFormatException e) {
            MessageManager.getInstance().send(sender,
                    ChatColor.RED + "'" + args[0] + "' isn't a valid number");
            return CommandResult.ERROR;
        }

        int duration;

        try {
            duration = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageManager.getInstance().send(sender,
                    ChatColor.RED + "'" + args[1] + "' isn't a valid number");
            return CommandResult.ERROR;
        }

        Player player = null;

        if (args.length > 2) {
            player = Bukkit.getPlayer(args[2]);

            if (player == null) {
                MessageManager.getInstance().send(sender,
                        ChatColor.RED + "Player '" + args[2] + "' doesn't exist");
                return CommandResult.ERROR;
            }
        }

        new Booster(sender, multiplier, duration, player).start();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Activated " +
                (player == null ? "global booster" : "booster for " + player.getName()) + " for " + duration +
                " seconds");

        return CommandResult.SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String getName() {
        return "booster";
    }

    /**
     * {@inheritDoc}
     */
    @Nls
    @NotNull
    @Override
    public String getInfo() {
        return "Activates a booster";
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String getPermission() {
        return "bg.booster";
    }
}
