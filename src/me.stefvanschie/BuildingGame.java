package me.stefvanschie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public class BuildingGame extends JavaPlugin
{
	//GameTimer timer;
	
	int counter = 0;
	List<Player> players = new ArrayList<Player>();
	List<Player> playersdone = new ArrayList<Player>();
	List<Player> playervoted = new ArrayList<Player>();
	HashMap<Player, Integer> votes = new HashMap<Player, Integer>();
	//permissions
	public Permission setmainspawn = new Permission("bg.setmainspawn");
	public Permission createarena = new Permission("bg.createarena");
	public Permission setspawn = new Permission("bg.setspawn");
	public Permission join = new Permission("bg.join");
	public Permission leave = new Permission("bg.leave");
	public Permission settingtimer = new Permission("bg.setting.timer");
	public Permission settingsubjectsadd = new Permission("bg.setting.subjects.add");
	public Permission settingsubjectsremove = new Permission("bg.setting.subjects.remove");
	public Permission reload = new Permission("bg.reload");
	public Permission reloadconfig = new Permission("bg.reload.config");
	public Permission reloadarenas = new Permission("bg.reload.arenas");
	//files
	File arenasFile = new File("arenas.yml");
	File configFile = new File("config.yml");
	YamlConfiguration arenas = YamlConfiguration.loadConfiguration(arenasFile);
	YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	@Override
	public void onEnable()
	{
		//files
		arenas = new YamlConfiguration();
		config = new YamlConfiguration();
		arenasFile = new File(getDataFolder(), "arenas.yml");
		configFile = new File(getDataFolder(), "config.yml");
		if (!arenasFile.exists())
		{
			try
			{
				arenasFile.createNewFile();
			}
			catch (IOException e)
			{
				getLogger().info("Building Game failed to create the arenas.yml file");
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
				getLogger().info("Building Game failed to create the config.yml file");
			}
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
			config.set("subjects", setsubjects);
		}
		loadYamls();
		
		//timer = new GameTimer(this);
		//other things
		getLogger().info("Building Game has been enabled succesfully!");
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(setmainspawn);
		pm.addPermission(createarena);
		pm.addPermission(setspawn);
		pm.addPermission(join);
		pm.addPermission(leave);
		pm.addPermission(settingtimer);
		pm.addPermission(settingsubjectsadd);
		pm.addPermission(settingsubjectsremove);
		pm.addPermission(reload);
		pm.addPermission(reloadconfig);
		pm.addPermission(reloadarenas);
		saveYamls();
	}
	@Override
	public void onDisable()
	{
		getLogger().info("Building Game has been disabled succesfully!");
		saveYamls();
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("bg"))
		{
			if (args[0].equalsIgnoreCase("setmainspawn") && sender instanceof Player)
			{
				if (player.hasPermission("setmainspawn"))
				{
					arenas.set("main-spawn.world", player.getLocation().getWorld().getName());
					arenas.set("main-spawn.x", player.getLocation().getBlockX());
					arenas.set("main-spawn.y", player.getLocation().getBlockY());
					arenas.set("main-spawn.z", player.getLocation().getBlockZ());
					saveYamls();
					player.sendMessage(ChatColor.GREEN + "Buildinggame main spawn has been set!");
				}
				else if (!player.hasPermission("setmainspawn"))
				{
					player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setmainspawn.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("createarena"))
			{
				if (player.hasPermission("createarena"))
				{
					if (args.length == 2)
					{
						arenas.set(args[1], null);
						saveYamls();
						player.sendMessage(ChatColor.GREEN + "Arena " + args[1] + " created!");
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
				else if (!player.hasPermission("createarena"))
				{
					player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occurred. Error: bg.createarena.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("setspawn") && sender instanceof Player)
			{
				if (player.hasPermission("setspawn"))
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
						player.sendMessage(ChatColor.GREEN + "Spawn " + counter + " set!");
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
				else if (!player.hasPermission("setspawn"))
				{
					player.sendMessage(ChatColor.RED + "You don't have the permission for that");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setspawn.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("join") && sender instanceof Player)
			{
				if (args.length == 2)
				{
					if (player.hasPermission("join"))
					{
						if (players.size() < arenas.getInt(args[1] + ".maxplayers"))
						{
							player.sendMessage(ChatColor.GOLD + "You have joined the game");
							for (Player p : players)
							{
								p.sendMessage(ChatColor.GOLD + "" + player.getName() + " joined the game!");
							}
							players.add(player);
							if (players.size() == arenas.getInt(args[1] + ".maxplayers"))
							{
								List<String> subjects = new ArrayList<String>(); 
								subjects = config.getStringList("subjects");
								Random rndm = new Random();
								int subjectint = rndm.nextInt(subjects.size());
								String subject = subjects.get(subjectint);
								int places = 1;
								for (Player pl : players)
								{
									String worldstr = arenas.getString(args[1] + "." + places + ".world");
									World world = getServer().getWorld(worldstr);
									int x = arenas.getInt(args[1] + "." + places + ".x");
									int y = arenas.getInt(args[1] + "." + places + ".y");
									int z = arenas.getInt(args[1] + "." + places + ".z");
									Location location = new Location(world, x, y, z);
									pl.teleport(location);
									places++;
									pl.sendMessage(ChatColor.GOLD + "The game has started!");
									pl.sendMessage(ChatColor.GOLD + "The subject is " + subject);
								}
								timer();
							}
						}
						else if (players.size() >= getConfig().getInt(args[1] + ".maxplayers"))
						{
							player.sendMessage(ChatColor.RED + "This arena is currently full");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.join.playersingame");
						}
					}
					else if (!player.hasPermission("join"))
					{
						player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.join.permission");
					}
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
				if (player.hasPermission("leave"))
				{
					String worldstr = arenas.getString("main-spawn.world");
					World world = getServer().getWorld(worldstr);
					Location location = new Location(world, arenas.getInt("main-spawn.x"), arenas.getInt("main-spawn.y"), arenas.getInt("main-spawn.z"));
					if (players.contains(player))
					{
						players.remove(player);
						player.teleport(location);
						player.sendMessage(ChatColor.GOLD + "You have left the game!");
						for (Player pl : players)
						{
							pl.sendMessage(ChatColor.GOLD + "" + player.getName() + " has left the arena!");
						}
					}
					else
					{
						player.sendMessage(ChatColor.GOLD + "You're not in a game!");
					}
				}
				else if (!player.hasPermission("leave"))
				{
					player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.leave.permission");
				}
			}
			else if (args[0].equalsIgnoreCase("help"))
			{
				player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
				player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
				player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
				player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
				player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
				player.sendMessage(ChatColor.GOLD + "/bg done" + ChatColor.DARK_GRAY + " - Mark your building as done");
			}
			else if (args[0].equalsIgnoreCase("setting"))
			{
				if (args[1].equalsIgnoreCase("timer"))
				{
					if (player.hasPermission("bg.setting.timer"))
					{
						if (isInt(args[2]))
						{
							config.set("timer", args[2]);
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
					}
					else if (!player.hasPermission("bg.setting.timer"))
					{
						player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.timer.permission");
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
									subject = subject + "_"; 
								}
								subject = subject + args[i];
							}
							subjects.add(subject);
						}
						else if (!player.hasPermission("bg.setting.subjects.add"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
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
									subject = subject + "_"; 
								}
								subject = subject + args[i];
							}
							subjects.remove(subject);
						}
						else if (!player.hasPermission("bg.setting.subjects.remove"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.setting.subjects.remove.permission");
						}
					}
					else
					{
						player.sendMessage(ChatColor.RED + "That option is not available");
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
							YamlConfiguration.loadConfiguration(configFile);
							player.sendMessage(ChatColor.GREEN + "Configuration reloaded!");
						}
						else if (!player.hasPermission("bg.reload.config"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
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
							YamlConfiguration.loadConfiguration(arenasFile);
							player.sendMessage(ChatColor.GREEN + "Arenas reloaded!");
						}
						else if (player.hasPermission("bg.reload.arenas"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
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
				{;
					if (player.hasPermission("bg.reload") || (player.hasPermission("bg.reload.config") && player.hasPermission("bg.reload.arenas")))
					{
						YamlConfiguration.loadConfiguration(configFile);
						YamlConfiguration.loadConfiguration(arenasFile);
						player.sendMessage(ChatColor.GREEN + "All the files have been reloaded!");
					}
					else if (!player.hasPermission("bg.reload") || !player.hasPermission("bg.reload.config") || !player.hasPermission("bg.reload.arenas"))
					{
						player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
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
			else if (args.length == 0)
			{
				player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
				player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
				player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
				player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
				player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
				player.sendMessage(ChatColor.GOLD + "/bg done" + ChatColor.DARK_GRAY + " - Mark your building as done");
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	// for the files
	public void saveYamls()
	{
	    try
	    {
	        arenas.save(arenasFile);
	        config.save(configFile);
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
	public void loadYamls() {
	    try
	    {
	        arenas.load(arenasFile);
	        config.load(configFile);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	//check if is integer
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
	public void cancelTimer(int s)
	{
		getServer().getScheduler().cancelTask(s);
	}
	boolean firstrun = true;
	int seconds;
	public void timer()
	{
		if (firstrun == true)
		{
			seconds = config.getInt("timer");
		}
		Bukkit.getScheduler().runTaskLater(this, new Runnable()
		{
			@Override
        	public void run()
			{
				firstrun = false;
				if (seconds == 60 || seconds == 30 || seconds == 15 || (seconds >= 1 && seconds <= 10))
				{
					for (Player pl : players)
					{
						pl.sendMessage(ChatColor.GOLD + "You have " + seconds + " seconds left!");
					}
					seconds--;
					timer();
				}
				else if (seconds == 0)
				{
					for (Player pl : players)
					{
						pl.sendMessage(ChatColor.GOLD + "The time to build is over!");
					}
					String worldstr = arenas.getString("main-spawn.world");
					World world = getServer().getWorld(worldstr);
					int x = arenas.getInt("main-spawn.x");
					int y = arenas.getInt("main-spawn.y");
					int z = arenas.getInt("main-spawn.z");
					Location location = new Location(world, x, y, z);
					players.clear();
					for (Player pl : players)
					{
						pl.teleport(location);
						pl.sendMessage(ChatColor.GOLD + "Game done!");
					}
					players.clear();
					seconds = config.getInt("timer");
					firstrun = false;
				}
				else
				{
					seconds--;
					timer();
				}
			}
		}, 20L);
	}
}
