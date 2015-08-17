package me.stefvanschie.listeners.players;

import me.stefvanschie.BuildingGame;
import me.stefvanschie.FileCheck;
import me.stefvanschie.Join;
import me.stefvanschie.Leave;
import me.stefvanschie.Vote;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
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
					e.getPlayer().sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
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
					e.getPlayer().sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("global.permissionNode")
							.replaceAll("&", "§"));
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
		// voting
		try {
		Player player = e.getPlayer();
		if (!e.getAction().equals(Action.RIGHT_CLICK_AIR) && !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			return;
		}
		if (player.getItemInHand().getType() == Material.COAL_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.coal-block", "&4Very Bad", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.coal-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 2);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.IRON_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.iron-block", "&cBad", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.iron-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 3);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.LAPIS_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.lapis-block", "&aMwoah", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.lapis-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 4);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.redstone-block", "&2Good", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.redstone-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 5);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.GOLD_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.gold-block", "&eVery Good", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.gold-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 6);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.DIAMOND_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.diamond-block", "&dAwesome", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.diamond-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 7);
					e.setCancelled(true);
				}
			}
		} else if (player.getItemInHand().getType() == Material.EMERALD_BLOCK) {
			if (player.getItemInHand().hasItemMeta()) {
				FileCheck.check("voting.emerald-block", "&5Excellent", BuildingGame.main.messages, BuildingGame.main);
				if (player.getItemInHand().getItemMeta().getDisplayName().equals(BuildingGame.main.messages.getString("voting.emerald-block")
						.replaceAll("&", "§"))) {
					Vote.vote(player, 8);
					e.setCancelled(true);
				}
			}
		}
		} catch (Exception ex) {}
	}
}
