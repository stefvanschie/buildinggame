package me.stefvanschie;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildingGame extends JavaPlugin
{
	int counter = 0;
	List<Player> players = new ArrayList<Player>();
	List<Player> playersdone = new ArrayList<Player>();
	public Permission setmainspawn = new Permission("bg.setmainspawn");
	public Permission createarena = new Permission("bg.createarena");
	public Permission setspawn = new Permission("bg.setspawn");
	public Permission join = new Permission("bg.join");
	public Permission leave = new Permission("bg.leave");
	public Permission done = new Permission("bg.done");
	public void onEnable()
	{
		getLogger().info("Building Game has been enabled succesfully!");
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(setmainspawn);
		pm.addPermission(createarena);
		pm.addPermission(setspawn);
		pm.addPermission(join);
		pm.addPermission(leave);
		pm.addPermission(done);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	public void onDisable()
	{
		getLogger().info("Building Game has been disabled succesfully!");
		saveConfig();
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("bg"))
		{
			if (args[0].equalsIgnoreCase("setmainspawn"))
			{
				if (player.hasPermission("setmainspawn"))
				{
					getConfig().set("main-spawn.world", player.getLocation().getWorld().getName());
					getConfig().set("main-spawn.x", Integer.valueOf(player.getLocation().getBlockX()));
					getConfig().set("main-spawn.y", Integer.valueOf(player.getLocation().getBlockY()));
					getConfig().set("main-spawn.z", Integer.valueOf(player.getLocation().getBlockZ()));
					saveConfig();
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
						getConfig().set(args[1], null);
						saveConfig();
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
			else if (args[0].equalsIgnoreCase("setspawn"))
			{
				if (player.hasPermission("setspawn"))
				{
					if (args.length == 2)
					{
						counter++;
						getConfig().set(args[1] + "." + counter + ".world", player.getLocation().getWorld().getName());
						getConfig().set(args[1] + "." + counter + ".x", Integer.valueOf(player.getLocation().getBlockX()));
						getConfig().set(args[1] + "." + counter + ".y", Integer.valueOf(player.getLocation().getBlockY()));
						getConfig().set(args[1] + "." + counter + ".z", Integer.valueOf(player.getLocation().getBlockZ()));
						getConfig().set(args[1] + ".maxplayers", Integer.valueOf(this.counter));
						saveConfig();
						player.sendMessage(ChatColor.GREEN + "Spawn " + this.counter + " set!");
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
			else
			{
				if (args[0].equalsIgnoreCase("join"))
				{
					if (args.length == 2)
					{
						if (player.hasPermission("join"))
						{
							if (players.size() < getConfig().getInt(args[1] + ".maxplayers"))
							{
								player.sendMessage(ChatColor.GOLD + "You have joined the game");
								for (Player p : players)
								{
									p.sendMessage(ChatColor.GOLD + player.getName() + " joined the game!");
								}
								players.add(player);
								if (players.size() == getConfig().getInt(args[1] + ".maxplayers"))
								{
									int places = 1;
									for (Player pl : players)
									{
										String worldstr = getConfig().getString(args[1] + "." + places + ".world");
										World world = getServer().getWorld(worldstr);
										int x = getConfig().getInt(args[1] + "." + places + ".x");
										int y = getConfig().getInt(args[1] + "." + places + ".y");
										int z = getConfig().getInt(args[1] + "." + places + ".z");
										Location location = new Location(world, x, y, z);
										pl.teleport(location);
										places++;
										pl.sendMessage(ChatColor.GOLD + "The game has started!");
									}
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
				else
				{
					if (args[0].equalsIgnoreCase("leave"))
					{
						if (player.hasPermission("leave"))
						{
							String worldstr = getConfig().getString("main-spawn.world");
							World world = getServer().getWorld(worldstr);
							Location location = new Location(world, getConfig().getInt("main-spawn.x"), getConfig().getInt("main-spawn.y"), getConfig().getInt("main-spawn.z"));
							if (players.contains(player))
							{
								players.remove(player);
								player.teleport(location);
								player.sendMessage(ChatColor.GOLD + "You have left the game!");
								for (Player pl : this.players)
								{
									pl.sendMessage(ChatColor.GOLD + player.getName() + " has left the arena!");
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
					else if (args[0].equalsIgnoreCase("done"))
					{
						if (player.hasPermission("done"))
						{
							player.sendMessage(ChatColor.GOLD + "You marked yourself as done!");
							playersdone.add(player);
							for (Player p : playersdone)
							{
								p.sendMessage(ChatColor.GOLD + player.getName() + " has marked himself as done!");
							}
							if (playersdone.size() == players.size())
							{
								String worldstr = getConfig().getString("main-spawn.world");
								World world = getServer().getWorld(worldstr);
								int x = getConfig().getInt("main-spawn.x");
								int y = getConfig().getInt("main-spawn.y");
								int z = getConfig().getInt("main-spawn.z");
								Location location = new Location(world, x, y, z);
								players.clear();
								for (Player pl : playersdone)
								{
									pl.teleport(location);
									pl.sendMessage(ChatColor.GOLD + "Game done!");
								}
								playersdone.clear();
							}
						}
						else if (!player.hasPermission("done"))
						{
							player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
						}
						else
						{
							player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.done.permission");
						}
					}
					else
					{
						player.sendMessage(ChatColor.DARK_GRAY + "---------------------" + ChatColor.GOLD + "BuildingGame" + ChatColor.DARK_GRAY + "---------------------");
						player.sendMessage(ChatColor.GOLD + "/bg setmainspawn" + ChatColor.DARK_GRAY + " - Sets the main spawn location for the buildinggame");
						player.sendMessage(ChatColor.GOLD + "/bg createarena <arenaname>" + ChatColor.DARK_GRAY + " - Create a new arena");
						player.sendMessage(ChatColor.GOLD + "/bg setspawn <arenaname>" + ChatColor.DARK_GRAY + " - Set a new spawn location");
						player.sendMessage(ChatColor.GOLD + "/bg join <arenaname>" + ChatColor.DARK_GRAY + " - Join an arena");
						player.sendMessage(ChatColor.GOLD + "/bg leave" + ChatColor.DARK_GRAY + " - Leave your game");
						player.sendMessage(ChatColor.GOLD + "/bg done" + ChatColor.DARK_GRAY + " - Mark your building as done");
					}
				}
			}
		}
		return false;
	}
}
