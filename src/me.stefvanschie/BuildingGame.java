package me.stefvanschie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import me.confuser.barapi.BarAPI;
import me.stefvanschie.listeners.blocks.Bounds;
import me.stefvanschie.listeners.blocks.Break;
import me.stefvanschie.listeners.blocks.Place;
import me.stefvanschie.listeners.players.PlayerListener;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
public class BuildingGame extends JavaPlugin
{
	public static BuildingGame main;
	//Scoreboard
	Scoreboard scoreboard;
	//Scoreboard startScoreboard;
	Objective objective;
	//Objective startObjective;
	Score score;
	//Score startScore;
	ScoreboardManager manager;
	//other
	int first = 0;
	int second = 0;
	int third = 0;
	Player firstplayer;
	Player secondplayer;
	Player thirdplayer;
	String arena;
	int place;
	int counter = 0;
	HashMap<Player, Integer> playervotes = new HashMap<Player, Integer>();
	public HashMap<Player, String> players = new HashMap<Player, String>();
	public HashMap<Integer, Player> playernumbers = new HashMap<Integer, Player>();
	HashMap<Player, Integer> votes = new HashMap<Player, Integer>();
	public HashMap<String,Integer> playersInArena = new HashMap<String,Integer>();
	//files
	File arenasFile = new File("arenas.yml");
	File configFile = new File("config.yml");
	File messagesFile = new File ("messages.yml");
	
	public YamlConfiguration arenas = YamlConfiguration.loadConfiguration(arenasFile);
	YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	public YamlConfiguration messages = YamlConfiguration.loadConfiguration(messagesFile);
	
	private Economy econ = null;
	private boolean vault = false;
	
	@Override
	public void onEnable()
	{
		manager = Bukkit.getScoreboardManager();
		main = this;
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getServer().getPluginManager().registerEvents(new Bounds(), this);
		getServer().getPluginManager().registerEvents(new Break(), this);
		getServer().getPluginManager().registerEvents(new Place(), this);
		//files
		arenas = new YamlConfiguration();
		config = new YamlConfiguration();
		messages = new YamlConfiguration();
		arenasFile = new File(getDataFolder(), "arenas.yml");
		configFile = new File(getDataFolder(), "config.yml");
		messagesFile = new File(getDataFolder(), "messages.yml");
		loadYamls();
		if (!arenasFile.exists())
		{
			try
			{
				arenasFile.createNewFile();
			}
			catch (IOException e)
			{
				getLogger().warning("Building Game's arenas.yml had some problems.");
				getLogger().warning("If you don't see the arenas.yml file, please restart your server!");
			}
			arenasFile.getParentFile().mkdirs();
		}
		if (!configFile.exists())
		{
			try
			{
				configFile.createNewFile();
			}
			catch (IOException e)
			{
				getLogger().warning("Building Game's config.yml had some problems.");
				getLogger().warning("If you don't see the config.yml file, please restart your server!");
			}
			configFile.getParentFile().mkdirs();
			generateSettings();
			saveYamls();
		}
		if (!messagesFile.exists())
		{
			try
			{
				messagesFile.createNewFile();
			}
			catch (IOException e)
			{
				getLogger().warning("Building Game's messages.yml had some problems.");
				getLogger().warning("If you don't see the messages.yml file, please restart your server!");
			}
			generateMessages();
			saveYamls();
		}
		
		//vault setup
		VaultSetup vaultSetup = new VaultSetup(this, econ);
		econ = vaultSetup.setup();
		
		if (econ != null)
			vault = true;
		
		getLogger().info("Building Game has been enabled succesfully!");
		saveYamls();
		Scoreboardsetup.setup();
		
		if (!config.contains("version")) {
			config.set("version", getDescription().getVersion());
		} else if (config.getString("version") != getDescription().getVersion()) {
			VersionSetup.setup();
		}
	}
	@Override
	public void onDisable()
	{
		getLogger().info("Building Game has been disabled succesfully!");
		saveYamls();
		main = null;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("bg"))
		{
			if (args.length == 0) {
				player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
				player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
				player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
				player.sendMessage(ChatColor.GOLD + "/bg setlobby <arenaname>" + ChatColor.DARK_GRAY + " - Set the lobby");
				player.sendMessage(ChatColor.GOLD + "/bg setminplayers <arenaname> <amount>" + ChatColor.DARK_GRAY + " - Set the minimal amount of players");
				player.sendMessage(ChatColor.GOLD + "/bg setbounds <arenaname> <plotnumber>" + ChatColor.DARK_GRAY + " - Set the boundaries of a plot");
				player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
				player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
				player.sendMessage(ChatColor.GOLD + "/bg vote <1-10>" + ChatColor.DARK_GRAY + " - Vote on a player's building");
			} else if (args[0].equalsIgnoreCase("setmainspawn") && sender instanceof Player)
			{
				if (player.hasPermission("bg.setmainspawn"))
				{
					arenas.set("main-spawn.world", player.getLocation().getWorld().getName());
					arenas.set("main-spawn.x", player.getLocation().getBlockX());
					arenas.set("main-spawn.y", player.getLocation().getBlockY());
					arenas.set("main-spawn.z", player.getLocation().getBlockZ());
					saveYamls();
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("setMainSpawn.succes")
							.replaceAll("&", "§"));
				}
				else if (!player.hasPermission("bg.setmainspawn"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setmainspawn.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("createarena"))
			{
				if (player.hasPermission("bg.createarena"))
				{
					if (args.length == 2)
					{
						arenas.set(args[1], null);
						saveYamls();
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("createArena.succes")
								.replace("%arena%", args[1])
								.replaceAll("&", "§"));
					}
					else if (args.length < 2)
					{
						player.sendMessage(ChatColor.RED + "Please specify the arena name!");
					}
					else if (args.length > 2)
					{
						player.sendMessage(ChatColor.RED + "Please only specify the arena name!");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured! Error: bg.createarena.args.length");
					}
				}
				else if (!player.hasPermission("bg.createarena"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.createarena.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("setspawn") && sender instanceof Player)
			{
				if (player.hasPermission("bg.setspawn"))
				{
					if (args.length == 2)
					{
						counter++;
						arenas.set(args[1] + "." + counter + ".world", player.getLocation().getWorld().getName());
						arenas.set(args[1] + "." + counter + ".x", player.getLocation().getBlockX());
						arenas.set(args[1] + "." + counter + ".y", player.getLocation().getBlockY());
						arenas.set(args[1] + "." + counter + ".z", player.getLocation().getBlockZ());
						arenas.set(args[1] + ".maxplayers", counter);
						saveYamls();
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("setSpawn.succes")
								.replace("%place%", counter + "")
								.replaceAll("&", "§"));
					}
					else if (args.length > 2)
					{
						player.sendMessage(ChatColor.RED + "Please only specify the arenaname");
					}
					else if (args.length < 2)
					{
						player.sendMessage(ChatColor.RED + "Please specify the arenaname");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setspawn.args.length");
					}
				}
				else if (!player.hasPermission("bg.setspawn"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setspawn.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("setlobby") && sender instanceof Player)
			{
				if (player.hasPermission("bg.setlobby"))
				{
					if (args.length == 2)
					{
						Setlobby.setlobby(player, args[1]);
					}
					else if (args.length < 2)
					{
						player.sendMessage(ChatColor.RED + "Please specify the arena name");
					}
					else if (args.length > 2)
					{
						player.sendMessage(ChatColor.RED + "Please only specify the arena name");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.BuildingGame.onCommand.setlobby.args.length");
					}
				}
				else if (!player.hasPermission("bg.setlobby"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.BuildingGame.onCommand.setlobby.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("setminplayers"))
			{
				if (player.hasPermission("bg.setminplayers"))
				{
					if (args.length == 3)
					{
						if (isInt(args[2]))
						{
							Setminplayers.setminplayers(player, args[1], Integer.parseInt(args[2]));
						}
						else if (!isInt(args[2]))
						{
							player.sendMessage(ChatColor.RED + "The minimal amount of players can only be an integer");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. bg.BuildingGame.onCommand.setminplayers.isInt");
						}
					}
					else if (args.length < 3)
					{
						player.sendMessage(ChatColor.RED + "Please specify the arena name and the minimal amount of players");
					}
					else if (args.length > 3)
					{
						player.sendMessage(ChatColor.RED + "Please only specify the arena name and the minimal amount of players");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.BuildingGame.onCommand.setminplayers.args.length");
					}
				}
				else if (!player.hasPermission("bg.setminplayers"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.BuildingGame.onCommand.setminplayers.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("setbounds") && sender instanceof Player) {
				if (args.length == 3) {
					if (!isInt(args[2])) {
						player.sendMessage(ChatColor.RED + args[2] + " is not an integer!");
						return false;
					}
					if (player.hasPermission("bg.setbounds")) {
						SetBounds.set(Integer.parseInt(args[2]), args[1], player);
						return true;
					} else if (!player.hasPermission("bg.setbounds")) {
						player.sendMessage(messages.getString("global.permissionNode")
								.replaceAll("&", "§"));
						return false;
					}
				} else if (args.length < 3) {
					player.sendMessage(ChatColor.RED + "Please specify the arenaname and the plotnumber");
					return false;
				} else if (args.length > 3) {
					player.sendMessage(ChatColor.RED + "Please only specify the arenaname and the plotnumber");
					return false;
				} else {
					player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.BuildingGame.onCommand.setbounds.args.length");
					return false;
				}
			}
			else if (args[0].equalsIgnoreCase("join") && sender instanceof Player)
			{
				if (args.length == 2)
				{
					Join.joinGame(player, args[1]);
				}
				else if (args.length < 2)
				{
					player.sendMessage(ChatColor.RED + "Please specify the arena name!");
				}
				else if (args.length > 2)
				{
					player.sendMessage(ChatColor.RED + "Please only specify the arena name!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.join.args.length");
				}
			}
			else if (args[0].equalsIgnoreCase("leave") && sender instanceof Player)
			{
				Leave.leaveGame(player);
			}
			else if (args[0].equalsIgnoreCase("vote"))
			{
				int args1 = 0;
				try
				{
					args1 = Integer.parseInt(args[1]);
				}
				catch (NumberFormatException nfe)
				{
					player.sendMessage(ChatColor.RED + "This value must be an integer!");
				}
				Vote.vote(player, args1);
			}
			else if (args[0].equalsIgnoreCase("help"))
			{
				player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
				player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
				player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
				player.sendMessage(ChatColor.GOLD + "/bg setlobby <arenaname>" + ChatColor.DARK_GRAY + " - Set the lobby");
				player.sendMessage(ChatColor.GOLD + "/bg setminplayers <arenaname> <amount>" + ChatColor.DARK_GRAY + " - Set the minimal amount of players");
				player.sendMessage(ChatColor.GOLD + "/bg setbounds <arenaname> <plotnumber>" + ChatColor.DARK_GRAY + " - Set the boundaries of a plot");
				player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
				player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
				player.sendMessage(ChatColor.GOLD + "/bg vote <1-10>" + ChatColor.DARK_GRAY + " - Vote on a player's building");
			}
			else if (args[0].equalsIgnoreCase("setting"))
			{
				if (args[1].equalsIgnoreCase("timer"))
				{
					if (player.hasPermission("bg.setting.timer"))
					{
						if (args.length == 3) {
							if (isInt(args[2]))
							{
								config.set("timer", Integer.parseInt(args[2]));
								saveYamls();
								player.sendMessage(ChatColor.GREEN + "The timer setting has been set to " + args[2]);
							}
							else if (!isInt(args[2]))
							{
								player.sendMessage(ChatColor.RED + "This setting can only be an integer!");
							}
							else
							{
								player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.timer.integer");
							}
						} else if (args.length < 3) {
							player.sendMessage(ChatColor.RED + "Please specify the time!");
						} else if (args.length > 3) {
							player.sendMessage(ChatColor.RED + "Please only specify the time!");
						} else {
							player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.BuildingGame.onCommand.bg.setting.timer.args.length");
						}
					}
					else if (!player.hasPermission("bg.setting.timer"))
					{
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
								.replaceAll("&", "§"));
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.timer.permission");
					}
				}
				else if (args[1].equalsIgnoreCase("votetimer"))
				{
					if (player.hasPermission("bg.setting.votetimer"))
					{
						if (isInt(args[2]))
						{
							config.set("votetimer", Integer.parseInt(args[2]));
							saveYamls();
							player.sendMessage(ChatColor.GREEN + "The votetimer setting has been set to " + args[2]);
						}
						else if (!isInt(args[2]))
						{
							player.sendMessage(ChatColor.RED + "This setting can only be an integer!");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.votetimer.isInt");
						}
					}
					else if (!player.hasPermission("bg.setting.votetimer"))
					{
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
								.replaceAll("&", "§"));
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.votetimer.permission");
					}
				}
				else if (args[1].equalsIgnoreCase("waittimer"))
				{
					if (player.hasPermission("bg.setting.waittimer"))
					{
						if (isInt(args[2]))
						{
							config.set("waittimer", Integer.parseInt(args[2]));
							saveYamls();
							player.sendMessage(ChatColor.GREEN + "The waittimer setting has been set to " + args[2]);
						}
						else if (!isInt(args[2]))
						{
							player.sendMessage(ChatColor.RED + "This setting can only be an integer!");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.BuildingGame.onCommand.setting.waittimer.isInt");
						}
					}
					else if (!player.hasPermission("bg.setting.waittimer"))
					{
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
								.replaceAll("&", "§"));
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.BuildingGame.onCommand.setting.waittimer.permission");
					}
				} else if (args[1].equalsIgnoreCase("update-signs")) {
					if (args[2].equalsIgnoreCase("true")) {
						config.set("update-signs", true);
					} else if (args[2].equalsIgnoreCase("false")) {
						config.set("update-signs", false);
					} else {
						player.sendMessage(ChatColor.RED + "This setting can only be a boolean");
					}
				}
				else if (args[1].equalsIgnoreCase("subjects"))
				{
					if (args[2].equalsIgnoreCase("add"))
					{
						if (player.hasPermission("bg.setting.subjects.add"))
						{
							List<String> subjects = new ArrayList<String>();
							subjects = config.getStringList("subjects");
							String subject = "";
							for(int i = 4; i < args.length; i++)
							{ 
								if (subject != "")
								{
									subject = subject + " "; 
								}
								subject = subject + args[i];
							}
							subjects.add(subject);
							saveYamls();
						}
						else if (!player.hasPermission("bg.setting.subjects.add"))
						{
							player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
									.replaceAll("&", "§"));
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.subjects.add.permission");
						}
					}
					else if (args[2].equalsIgnoreCase("remove"))
					{
						if (player.hasPermission("bg.setting.subjects.remove"))
						{
							List<String> subjects = new ArrayList<String>();
							subjects = config.getStringList("subjects");
							String subject = "";
							for(int i = 4; i < args.length; i++)
							{ 
								if (subject != "")
								{
									subject = subject + " "; 
								}
								subject = subject + args[i];
							}
							subjects.remove(subject);
							saveYamls();
						}
						else if (!player.hasPermission("bg.setting.subjects.remove"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.subjects.remove.permission");
						}
					} else {
						player.sendMessage(ChatColor.RED + "That option is not available");
					}
				}
				else if (args[1].equalsIgnoreCase("money")) {
					if (args[2].equalsIgnoreCase("first")) {
						try {
							Double.parseDouble(args[3]);
						} catch (NumberFormatException e) {
							player.sendMessage(ChatColor.RED + "That's not a double!");
							return false;
						}
						double money = Double.parseDouble(args[3]);
						config.set("money.first", money);
					} else if (args[2].equalsIgnoreCase("second")) {
						try {
							Double.parseDouble(args[3]);
						} catch (NumberFormatException e) {
							player.sendMessage(ChatColor.RED + "That's not a double!");
							return false;
						}
						double money = Double.parseDouble(args[4]);
						config.set("money.second", money);
					} else if (args[2].equalsIgnoreCase("third")) {
						try {
							Double.parseDouble(args[3]);
						} catch (NumberFormatException e) {
							player.sendMessage(ChatColor.RED + "That's not a double!");
							return false;
						}
						double money = Double.parseDouble(args[3]);
						config.set("money.third", money);
					} else {
						player.sendMessage(ChatColor.RED + "That's not a valid option");
					}
				}
				else
				{
					player.sendMessage(ChatColor.RED + "That setting does not exist");
				}
			}
			else if (args[0].equalsIgnoreCase("reload"))
			{
				if (args.length == 2)
				{
					if (args[1].equalsIgnoreCase("config"))
					{
						if (player.hasPermission("bg.reload.config"))
						{
							saveYamls();
							YamlConfiguration.loadConfiguration(configFile);
							player.sendMessage(ChatColor.GREEN + "Configuration reloaded!");
						}
						else if (!player.hasPermission("bg.reload.config"))
						{
							player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
									.replaceAll("&", "§"));
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.reload.config.permission");
						}
					}
					else if (args[1].equalsIgnoreCase("arenas"))
					{
						if (player.hasPermission("bg.reload.arenas"))
						{
							saveYamls();
							YamlConfiguration.loadConfiguration(arenasFile);
							player.sendMessage(ChatColor.GREEN + "Arenas reloaded!");
						}
						else if (player.hasPermission("bg.reload.arenas"))
						{
							player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
									.replaceAll("&", "§"));
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.reload.arenas.permission");
						}
					}
					else
					{
						player.sendMessage(ChatColor.RED + "That's not a correct file");
					}
				}
				else if (args.length != 2)
				{
					if (player.hasPermission("bg.reload") || (player.hasPermission("bg.reload.config") && player.hasPermission("bg.reload.arenas")))
					{
						saveYamls();
						YamlConfiguration.loadConfiguration(configFile);
						YamlConfiguration.loadConfiguration(arenasFile);
						YamlConfiguration.loadConfiguration(messagesFile);
						player.sendMessage(ChatColor.GREEN + "All the files have been reloaded!");
					}
					else if (!player.hasPermission("bg.reload") || !player.hasPermission("bg.reload.config") || !player.hasPermission("bg.reload.arenas"))
					{
						player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
								.replaceAll("&", "§"));
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.reload.permission");
					}
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.reload.args.length");
				}
			}
			else if (args[0].equalsIgnoreCase("generatesettings"))
			{
				if (player.hasPermission("bg.generatesettings"))
				{
					if (args[1].equalsIgnoreCase("config"))
					{
						saveYamls();
						generateSettings();
						player.sendMessage(ChatColor.GREEN + "Default settings generated!");
					}
					else if (args[1].equalsIgnoreCase("messages"))
					{
						saveYamls();
						generateMessages();
						player.sendMessage(ChatColor.GREEN + "Default messages generated!");
					} else {
						saveYamls();
						generateSettings();
						generateMessages();
						player.sendMessage(ChatColor.GREEN + "All default settings generated!");
					}
				}
				else if (!player.hasPermission("bg.generatesettings"))
				{
					player.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.generatesettings.permission");
				}
			}
			else if (args.length == 0)
			{
				player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
				player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
				player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
				player.sendMessage(ChatColor.GOLD + "/bg setlobby <arenaname>" + ChatColor.DARK_GRAY + " - Set the lobby");
				player.sendMessage(ChatColor.GOLD + "/bg setminplayers <arenaname> <amount>" + ChatColor.DARK_GRAY + " - Set the minimal amount of players");
				player.sendMessage(ChatColor.GOLD + "/bg setbounds <arenaname> <plotnumber>" + ChatColor.DARK_GRAY + " - Set the boundaries of a plot");
				player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
				player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
				player.sendMessage(ChatColor.GOLD + "/bg vote <1-10>" + ChatColor.DARK_GRAY + " - Mark your building as done");
			}
		}
		return false;
	}
	public void saveYamls()
	{
	    try
	    {
	        arenas.save(arenasFile);
	        config.save(configFile);
	        messages.save(messagesFile);
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
	public void loadYamls()
	{
	    try
	    {
	        arenas.load(arenasFile);
	        config.load(configFile);
	        messages.load(messagesFile);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	public static boolean isInt(String s) {
	    try
	    {
	        Integer.parseInt(s);
	    }
	    catch (NumberFormatException nfe)
	    {
	        return false;
	    }
	    return true;
	}
	public void generateSettings()
	{
		List<String> setsubjects = new ArrayList<String>();
		setsubjects.add("carrot");
		setsubjects.add("frog");
		setsubjects.add("superhero");
		setsubjects.add("octopus");
		setsubjects.add("maze");
		setsubjects.add("dog house");
		setsubjects.add("spiderman");
		setsubjects.add("baseball");
		setsubjects.add("birthday");
		setsubjects.add("cannon");
		configFile.getParentFile().mkdirs();
		config.set("timer", 300);
		config.set("waittimer", 60);
		config.set("votetimer", 15);
		config.set("update-signs", true);
		config.set("subjects", setsubjects);
		saveYamls();
	}
	public void generateMessages()
	{
		messages.set("global.prefix", "&2[&9BuildingGame&2]&r ");
		messages.set("global.permissionNode", "&cYou don't have the required permission for that!");
		messages.set("global.scoreboardHeader", "&ePoints");
		messages.set("global.buildingScoreboardHeader", "&eBuilding Game");
		messages.set("setMainSpawn.succes", "&aBuildinggame main spawn has been set!");
		messages.set("createArena.succes", "&aArena %arena% created!");
		messages.set("setSpawn.succes", "&aSpawn %place% set!");
		messages.set("setLobby.succes", "&aLobby set!");
		messages.set("setMinPlayers.succes", "&aMinimal amount of players set!");
		messages.set("setBounds.succes", "&aBoundaries for plot %place% in arena %arena% set!");
		messages.set("leave.message", "&6You have left the game!");
		messages.set("leave.otherPlayers", "&6%player% has left the arena!");
		messages.set("vote.message", "&6You gave %playerlot%'s build a %points%");
		messages.set("join.message", "&6You have joined the game!");
		messages.set("join.otherPlayers", "&6%player% joined the game!");
		messages.set("lobbyCountdown.message", "&6The game starts in %seconds% seconds!");
		messages.set("gameStarts.message", "&6The game has started!");
		messages.set("gameStarts.subject", "&6 The subject is %subject%");
		messages.set("buildingCountdown.message", "&6You have %seconds% seconds left!");
		messages.set("voting.message", "&6%playerplot%'s plot!");
		messages.set("voting.coal-block", "&4Very Bad");
		messages.set("voting.iron-block", "&cBad");
		messages.set("voting.lapis-block", "&aMwoah");
		messages.set("voting.redstone-block", "&2Good");
		messages.set("voting.gold-block", "&eVery Good");
		messages.set("voting.diamond-block", "&dAwesome");
		messages.set("voting.emerald-block", "&5Excellent");
		messages.set("winner.first", "&aYou went first with %points%!");
		messages.set("winner.second", "&aYou went second with %points%!");
		messages.set("winner.third", "&aYou went third with %points%!");
		saveYamls();
	}
	boolean firstrun = true;
	int seconds;
	int originalSeconds;
	public void timer(final String arena)
	{
		if (firstrun == true)
		{
			seconds = config.getInt("timer");
			originalSeconds = config.getInt("timer");
			for (Player pl : players.keySet()) {
				if (players.get(pl).equals(arena)) {
					//pl.setScoreboard(startScoreboard);
					if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
						FileCheck.check("global.barHeader", "Time", messages, BuildingGame.main);
						BarAPI.setMessage(pl, (messages.getString("global.barHeader")
								.replaceAll("&", "§")), seconds);
					}
				}
			}
		}
		Bukkit.getScheduler().runTaskLater(this, new Runnable()
		{
			@Override
        	public void run()
			{
				firstrun = false;
				if ((seconds % 60 == 0 && seconds != originalSeconds && seconds != 0) || seconds == 30 || seconds == 15 || (seconds >= 1 && seconds <= 10))
				{
					for (Player pl : players.keySet())
					{
						if (players.get(pl).equals(arena))
						{
							pl.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("buildingCountdown.message")
									.replace("%seconds%", seconds + "")
									.replaceAll("&", "§"));
						}
					}
					seconds--;
					timer(arena);
					//ScoreboardUpdate.update(seconds, GameStartCountdown.subject, playersInArena.get(arena), arena);
				} else if (seconds == 0)
				{
					World world = getServer().getWorld(arenas.getString(arena + ".1.world"));
					int x = arenas.getInt(arena + ".1.x");
					int y = arenas.getInt(arena + ".1.y");
					int z = arenas.getInt(arena + ".1.z");
					Location location = new Location(world, x, y, z);
					for (Player pl : players.keySet())
					{
						if (players.get(pl).equals(arena))
						{
							votes.put(pl, 0);
							pl.teleport(location);
							pl.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("voting.message")
									.replace("%playerplot%", playernumbers.get(1).getName() + "")
									.replaceAll("&", "§"));
							if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
								if (BarAPI.hasBar(pl))
									BarAPI.removeBar(pl);
							}
						}
					}
					firstrun = true;
					voting(arena);
				}
				else
				{
					seconds--;
					timer(arena);
					for (Player pl : players.keySet()) {
						if (players.get(pl).equals(arena)) {
						}
					}
					//ScoreboardUpdate.update(seconds, GameStartCountdown.subject, playersInArena.get(arena), arena);
				}
			}
		}, 20L);
	}
	int voteseconds;
	boolean everyrun = true;
	boolean once = true;
	public void voting(final String arena)
	{
		if (everyrun == true)
		{
			voteseconds = config.getInt("votetimer");
		}
		if (once == true)
		{
			for (Player player : players.keySet())
			{
				if (players.get(player).equals(arena))
				{
					player.setScoreboard(scoreboard);
				}
			}
			place = 1;
			//give items
			for (Player player : players.keySet()) {
				if (players.get(player).equals(arena)) {
					//create items
					//coal
					player.getInventory().clear();
					ItemStack coal = new ItemStack(Material.COAL_BLOCK, 1);
					ItemMeta coalMeta = coal.getItemMeta();
					FileCheck.check("voting.coal-block", "&4Very Bad", messages, this);
					coalMeta.setDisplayName(messages.getString("voting.coal-block")
							.replaceAll("&", "§"));
					coal.setItemMeta(coalMeta);
					player.getInventory().setItem(1, coal);
					//iron
					ItemStack iron = new ItemStack(Material.IRON_BLOCK, 1);
					ItemMeta ironMeta = iron.getItemMeta();
					FileCheck.check("voting.iron-block", "&cBad", messages, this);
					ironMeta.setDisplayName(messages.getString("voting.iron-block")
							.replaceAll("&", "§"));
					iron.setItemMeta(ironMeta);
					player.getInventory().setItem(2, iron);
					//lapis
					ItemStack lapisLazuli = new ItemStack(Material.LAPIS_BLOCK, 1);
					ItemMeta lapisLazuliMeta = lapisLazuli.getItemMeta();
					FileCheck.check("voting.lapis-block", "&aMwoah", messages, this);
					lapisLazuliMeta.setDisplayName(messages.getString("voting.lapis-block")
							.replaceAll("&", "§"));
					lapisLazuli.setItemMeta(lapisLazuliMeta);
					player.getInventory().setItem(3, lapisLazuli);
					//redstone
					ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK, 1);
					ItemMeta redstoneMeta = redstone.getItemMeta();
					FileCheck.check("voting.redstone-block", "&2Good", messages, this);
					redstoneMeta.setDisplayName(messages.getString("voting.redstone-block")
							.replaceAll("&", "§"));
					redstone.setItemMeta(redstoneMeta);
					player.getInventory().setItem(4, redstone);
					//gold
					ItemStack gold = new ItemStack(Material.GOLD_BLOCK, 1);
					ItemMeta goldMeta = gold.getItemMeta();
					FileCheck.check("voting.gold-block", "&eVery Good", messages, this);
					goldMeta.setDisplayName(messages.getString("voting.gold-block")
							.replaceAll("&", "§"));
					gold.setItemMeta(goldMeta);
					player.getInventory().setItem(5, gold);
					//diamond
					ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
					ItemMeta diamondMeta = diamond.getItemMeta();
					FileCheck.check("voting.diamond-block", "&dAwesome", messages, this);
					diamondMeta.setDisplayName(messages.getString("voting.diamond-block")
							.replaceAll("&", "§"));
					diamond.setItemMeta(diamondMeta);
					player.getInventory().setItem(6, diamond);
					//emerald
					ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK, 1);
					ItemMeta emeraldMeta = emerald.getItemMeta();
					FileCheck.check("voting.emerald-block", "&5Excellent", messages, this);
					emeraldMeta.setDisplayName(messages.getString("voting.emerald-block")
							.replaceAll("&", "§"));
					emerald.setItemMeta(emeraldMeta);
					player.getInventory().setItem(7, emerald);
				}
			}
		}
		Bukkit.getScheduler().runTaskLater(this, new Runnable()
		{
			@Override
        	public void run()
			{
				once = false;
				everyrun = false;
				if (voteseconds == 0)
				{
					everyrun = true;
					place++;
					if (place > playersInArena.get(arena))
					{
						for (Player pl : players.keySet())
						{
							if (players.get(pl).equals(arena))
							{
								if (votes.get(pl) > first)
								{
									try
									{
										third = votes.get(secondplayer);
									}
									catch (NullPointerException e)
									{
									}
									thirdplayer = secondplayer;
									try
									{
										second = votes.get(firstplayer);
									}
									catch (NullPointerException e)
									{
									}
									secondplayer = firstplayer;
									first = votes.get(pl);
									firstplayer = pl;
								}
								else if (votes.get(pl) < first && votes.get(pl) > second)
								{
									try
									{
										third = votes.get(thirdplayer);
									}
									catch (NullPointerException e)
									{
									}
									thirdplayer = secondplayer;
									second = votes.get(pl);
									secondplayer = pl;
								}
								else if (votes.get(pl) < second && votes.get(pl) > third)
								{
									third = votes.get(pl);
									thirdplayer = pl;
								}
							}
						}
						String worldstr = arenas.getString("main-spawn.world");
						World world = getServer().getWorld(worldstr);
						int x = arenas.getInt("main-spawn.x");
						int y = arenas.getInt("main-spawn.y");
						int z = arenas.getInt("main-spawn.z");
						Location location = new Location(world, x, y, z);
						Iterator<Player> iterator = players.keySet().iterator();
						while (iterator.hasNext())
						{
							Player pl = iterator.next();
							if (players.get(pl).equals(arena))
							{
								pl.teleport(location);
								pl.sendMessage(ChatColor.GOLD + "Game done!");
								if (firstplayer == pl)
								{
									if (vault) {
										//vault
										try {
											FileCheck.check("money.first", 20, config);
											double money = config.getDouble("money.first");
											EconomyResponse r = econ.depositPlayer(pl, money);
							            
											if (r.transactionSuccess()) {
												FileCheck.check("vault.message", "&aYou've won %money%!", messages, BuildingGame.main);
												pl.sendMessage(messages.getString("global.prefix")
														.replaceAll("&", "§") + messages.getString("vault.message")
														.replace("%money%", money + "")
														.replaceAll("&", "§"));
											} else {
												pl.sendMessage(ChatColor.RED + "Couldn't withdraw money");
											}
										} catch (Exception e) {}
									}
									pl.sendMessage(messages.getString("global.prefix")
											.replaceAll("&", "§") + messages.getString("winner.first")
											.replace("%points%", first + "")
											.replaceAll("&", "§"));
									try {
										for (String command : config.getStringList("commands.first")) {
											pl.performCommand(command);
										}
									} catch (NullPointerException npe) {}
								}
								else if (secondplayer == pl)
								{
									//vault
									if (vault) {
										try {
											FileCheck.check("money.second", 10, config);
											double money = config.getDouble("money.second");
											EconomyResponse r = econ.depositPlayer(pl, money);
									
											if (r.transactionSuccess()) {
												FileCheck.check("vault.message", "&aYou've won %money%!", messages, BuildingGame.main);
												pl.sendMessage(messages.getString("global.prefix")
														.replaceAll("&", "§") + messages.getString("vault.message")
														.replace("%money%", money + "")
														.replaceAll("&", "§"));
											} else {
												pl.sendMessage(ChatColor.RED + "Couldn't withdraw money");
											}
										} catch (Exception e) {}
									}
									pl.sendMessage(messages.getString("global.prefix")
											.replaceAll("&", "§") + messages.getString("winner.second")
											.replace("%points%", second + "")
											.replaceAll("&", "§"));
									
									try {
										for (String command : config.getStringList("commands.second")) {
											pl.performCommand(command);
										}
									} catch (NullPointerException npe) {}
								}
								else if (thirdplayer == pl)
								{
									//vault
									if (vault) {
										try {
											FileCheck.check("money.third", 5, config);
											double money = config.getDouble("money.third");
											EconomyResponse r = econ.depositPlayer(pl, money);
										
											if (r.transactionSuccess()) {
												FileCheck.check("vault.message", "&aYou've won %money%!", messages, BuildingGame.main);
												pl.sendMessage(messages.getString("global.prefix")
														.replaceAll("&", "§") + messages.getString("vault.message")
														.replace("%money%", money + "")
														.replaceAll("&", "§"));
											} else {
												pl.sendMessage(ChatColor.RED + "Couldn't withdraw money");
											}
										} catch (Exception e) {}
									}
									
									pl.sendMessage(messages.getString("global.prefix")
											.replaceAll("&", "§") + messages.getString("winner.third")
											.replace("%points%", third + "")
											.replaceAll("&", "§"));
									
									try {
										for (String command : config.getStringList("commands.third")) {
											pl.performCommand(command);
										}
									} catch (NullPointerException npe) {}
								}
								votes.remove(pl);
								playernumbers.remove(pl);
								iterator.remove();
								scoreboard.resetScores(pl.getName());
								pl.setScoreboard(manager.getNewScoreboard());
								pl.getInventory().clear();
							}
						}
						first = 0;
						second = 0;
						third = 0;
						once = true;
						everyrun = true;
						voteseconds = config.getInt("votetimer");
						playersInArena.put(arena, 0);
						SignUpdate.update();
						Arena.restore(arena);
					}
					else
					{
						String worldstr = arenas.getString(arena + "." + place + ".world");
						World world = getServer().getWorld(worldstr);
						int x = arenas.getInt(arena + "." + place + ".x");
						int y = arenas.getInt(arena + "." + place + ".y");
						int z = arenas.getInt(arena + "." + place + ".z");
						Location location = new Location(world, x, y, z);
						for (Player pl : players.keySet())
						{
							if (players.get(pl).equals(arena))
							{
								pl.teleport(location);
								pl.sendMessage(messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("voting.message")
										.replace("%playerplot%", playernumbers.get(place).getName() + "")
										.replaceAll("&", "§"));
							}
						}
						voting(arena);
						everyrun = true;
					}
				}
				else
				{
					voteseconds--;
					voting(arena);
				}
			}
		}, 20L);
	}
}
