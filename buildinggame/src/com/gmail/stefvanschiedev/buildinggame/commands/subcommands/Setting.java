package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to change a setting in the config
 *
 * @since 2.1.0
 */
public class Setting extends ConsoleCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param sender the sender who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();

	    if (args.length < 2) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a path and a value");
            return CommandResult.ARGUMENTEXCEPTION;
        }

        if (!config.contains(args[0])) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "That setting doesn't exist");
            return CommandResult.ERROR;
        }

        if (config.isList(args[0])) {
	        if (args.length < 3) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                        "Please specify if you want to add or remove this value and the value");
                return CommandResult.ARGUMENTEXCEPTION;
            }

            if (args[1].equalsIgnoreCase("add")) {
	            //add the value
                List<String> list = config.getStringList(args[0]);
                list.add(args[2]);
                config.set(args[0], list);

                MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value added to config");
            } else if (args[1].equalsIgnoreCase("remove")) {
                //remove the value
                List<String> list = config.getStringList(args[0]);
                list.remove(args[2]);
                config.set(args[0], list);

                MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value removed from config");
            }

            SettingsManager.getInstance().save();
            return CommandResult.SUCCES;
        }

        //whole bunch of checking
        if (config.isBoolean(args[0]))
	        config.set(args[0], Boolean.parseBoolean(args[1]));
        else if (config.isDouble(args[0])) {
	        try {
	            config.set(args[0], Double.parseDouble(args[1]));
            } catch (NumberFormatException e) {
	            MessageManager.getInstance().send(sender, ChatColor.RED +
                        "Value type isn't the same as in the config, it should be a double");
	            return CommandResult.ERROR;
            }
        } else if (config.isInt(args[0])) {
            try {
                config.set(args[0], Integer.parseInt(args[1]));
            } catch (NumberFormatException e) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                        "Value type isn't the same as in the config, it should be an integer");
                return CommandResult.ERROR;
            }
        } else if (config.isLong(args[0])) {
            try {
                config.set(args[0], Long.parseLong(args[1]));
            } catch (NumberFormatException e) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                        "Value type isn't the same as in the config, it should be a long");
                return CommandResult.ERROR;
            }
        } else if (config.isString(args[0]))
	        config.set(args[0], args[1]);
        else {
	        MessageManager.getInstance().send(sender, ChatColor.YELLOW +
                    "Unable to change setting with commands, please change this setting by hand");
	        return CommandResult.ERROR;
        }

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value changed in config");
        SettingsManager.getInstance().save();

		return CommandResult.SUCCES;
	}

    /**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "setting";
	}

    /**
     * Returns the aliases for this sbucommand
     *
     * @return an array of aliases for this subcommand
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	@Override
	public String[] getAliases() {
		return null;
	}

    /**
     * Returns an informational message about this subcommand
     *
     * @return an informational message
     * @since 2.1.0
     */
	@Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Change the settings";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.setting";
	}
}