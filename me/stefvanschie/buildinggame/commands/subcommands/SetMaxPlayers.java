package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.arena.ArenaMode;

public class SetMaxPlayers extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and the max players");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		if (arena.getMode() == ArenaMode.SOLO) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "You can only modify the maxplayers from arenas, which are in team mode");
			return CommandResult.ERROR;
		}
		
		try {
			Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a whole number");
			return CommandResult.ERROR;
		}
		
		int maxPlayers = Integer.parseInt(args[1]);
		
		if (maxPlayers % arena.getPlots().size() != 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Your max players has to be a number dividible by " + arena.getPlots().size());
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".maxplayers", maxPlayers);
		
		//add parts to config
		for (int i = 0; i < maxPlayers; i++) {
			if (config.contains("team-selection.team." + i)) {
				continue;
			}
			
			config.set("team-selection.team." + i + ".id", "paper");
		}
		SettingsManager.getInstance().save();
		
		MaxPlayersManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Max players changed!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setmaxplayers";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the max players in an arena";
	}

	@Override
	public String getPermission() {
		return "bg.setmaxplayers";
	}

}
