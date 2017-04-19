package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MatchesManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class SetMatches extends ConsoleCommand {

    @Override
    public CommandResult onCommand(CommandSender sender, String[] args) {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        if (args.length < 2) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena name and the amount of matches");
            return CommandResult.ARGUMENTEXCEPTION;
        }

        Arena arena = ArenaManager.getInstance().getArena(args[0]);

        if (arena == null) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
            return CommandResult.ERROR;
        }

        if (!arena.isEmpty()) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "The arena isn't empty, changing the matches now is likely to cause problems. Please wait until the arena is empty.");
            return CommandResult.ERROR;
        }

        int matches;

        try {
            matches = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a number");
            return CommandResult.ERROR;
        }

        arenas.set(arena.getName() + ".matches", matches);
        SettingsManager.getInstance().save();

        MatchesManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Amount of matches changed!");

        return null;
    }

    @Override
    public String getName() {
        return "setmatches";
    }

    @Override
    public String[] getAliases() {
        return null;
    }

    @Override
    public String getInfo() {
        return "Set the amount of matches to play";
    }

    @Override
    public String getPermission() {
        return "bg.setmatches";
    }
}
