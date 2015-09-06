package me.stefvanschie.buildinggame.commands.subcommands.settings.subjects;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Add extends SubCommand{

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the subject");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		String subject = "";
		
		for (String arg : args) {
			subject += arg + " ";
		}
		
		subject.trim();
		
		config.set("subjects", config.getStringList("subjects").add(subject));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Added subject " + subject);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "add";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Add a subject";
	}

	@Override
	public String getPermission() {
		return "bg.setting.subjects.add";
	}

}
