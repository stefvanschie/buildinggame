package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.events.player.create.Floors;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class SetFloor extends PlayerCommand {

	HashMap<String, Plot> editingPlot = new HashMap<String, Plot>();
	HashMap<String, Arena> editingArena = new HashMap<String, Arena>();
	Map<String, Location> previousLocation = new HashMap<String, Location>();
	
	@Override
	public CommandResult onCommand(Player player, String[] args) {
		if (args.length < 2) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arena and plot");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid arena");
			return CommandResult.ERROR;
		}
		
		try {
			Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid plot");
			return CommandResult.ERROR;
		}
		
		int ID = Integer.parseInt(args[1]);
		
		Plot plot = arena.getPlot(ID);
		
		if (plot == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid plot");
			return CommandResult.ERROR;
		}
		
		ItemStack wand = new ItemStack(Material.STICK, 1);
		ItemMeta wandItemMeta = wand.getItemMeta();
		wandItemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Wand");
		wand.setItemMeta(wandItemMeta);
		
		player.getInventory().setItemInMainHand(wand);
		
		editingPlot.put(player.getName(), plot);
		editingArena.put(player.getName(), arena);
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Please click on one corner");
		
		Bukkit.getPluginManager().registerEvents(new Floors(player, arena, plot), Main.getInstance());
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setfloor";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the floor of the plot";
	}

	@Override
	public String getPermission() {
		return "bg.setfloor";
	}

}
