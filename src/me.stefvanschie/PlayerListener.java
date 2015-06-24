package me.stefvanschie;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener
{
	public static PlayerListener playerListener;
	@EventHandler
	public void onSignChange (SignChangeEvent e)
	{
		if (e.getLine(0).equalsIgnoreCase("[BuildingGame]"))
		{
			if (e.getLine(1).equalsIgnoreCase("join"))
			{
				if (e.getPlayer().hasPermission("bg.sign.create"))
				{
					if (BuildingGame.main.arenas.contains(e.getLine(2)))
					{
						e.setLine(0, ChatColor.BOLD + "BuildingGame");
						e.setLine(1, ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join");
						e.setLine(2, ChatColor.UNDERLINE + "Map: " + e.getLine(2));
						if (BuildingGame.main.playersInArena.containsKey(e.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")))
						{
							e.setLine(3, BuildingGame.main.playersInArena.get(e.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")).toString() + "/" + BuildingGame.main.arenas.get(e.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "") + ".maxplayers").toString());
						}
						else if (!BuildingGame.main.playersInArena.containsKey(e.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")))
						{
							e.setLine(3, "0/" + BuildingGame.main.arenas.get(e.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "") + ".maxplayers").toString());
						}
						else
						{
							e.getPlayer().sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.PlayerListener.onSignChange.BuildingGame.main.playersInArena.containsKey");
						}
						e.getPlayer().sendMessage(ChatColor.GREEN + "Join sign created!");
					}
					else if (!BuildingGame.main.arenas.contains(e.getLine(2)))
					{
						e.getPlayer().sendMessage(ChatColor.RED + "This arena does not exist. Please create one first.");
					}
					else
					{
						e.getPlayer().sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.sign.create.config.contains");
					}
				}
				else if (!e.getPlayer().hasPermission("bg.sign.create"))
				{
					e.getPlayer().sendMessage(ChatColor.RED + "You don't have the required permission for that!");
				}
				else
				{
					e.getPlayer().sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.sign.create.permission");
				}
			}
			else if (e.getLine(1).equalsIgnoreCase("leave"))
			{
				if (e.getPlayer().hasPermission("bg.sign.create"))
				{
					e.setLine(0, ChatColor.BOLD + "BuildingGame");
					e.setLine(1, ChatColor.DARK_GRAY + ""  + ChatColor.ITALIC + "leave");
					e.getPlayer().sendMessage(ChatColor.GREEN + "Leave sign created!");
				}
				else if (!e.getPlayer().hasPermission("bg.sign.create"))
				{
					e.getPlayer().sendMessage(ChatColor.RED + "You don't have the required permission for that!");
				}
				else
				{
					e.getPlayer().sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.sign.create.permission");
				}
			}
		}
	}
	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent e)
	{
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (e.getClickedBlock().getState() instanceof Sign)
			{
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(0).equals(ChatColor.BOLD + "BuildingGame"))
				{
					if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join"))
					{
						Join.joinGame(e.getPlayer(), sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", ""));
						//update
						if (BuildingGame.main.playersInArena.containsKey(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")))
						{
							sign.setLine(3, BuildingGame.main.playersInArena.get(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")).toString() + "/" + BuildingGame.main.arenas.get(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "") + ".maxplayers").toString());
						}
						else if (!BuildingGame.main.playersInArena.containsKey(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")))
						{
							sign.setLine(3, "0/" + BuildingGame.main.arenas.get(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "") + ".maxplayers").toString());
						}
						else
						{
							e.getPlayer().sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.PlayerListener.onSignChange.BuildingGame.main.playersInArena.containsKey");
						}
						sign.update();
					}
					else if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "leave"))
					{
						Leave.leaveGame(e.getPlayer());
					}
				}
			}
		}
	}
}
