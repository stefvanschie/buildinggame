package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class VoteBlocks {

	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public void give(final Player player) {
	    Plot plot = ArenaManager.getInstance().getArena(player).getVotingPlot();

		try {
			player.getInventory().setItem(1, IDDecompiler.getInstance().decompile(player, config.getString("voting.second-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.second-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
                return true;
            }));
			
			player.getInventory().setItem(2, IDDecompiler.getInstance().decompile(player, config.getString("voting.third-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.third-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
                return true;
            }));
		
			player.getInventory().setItem(3, IDDecompiler.getInstance().decompile(player, config.getString("voting.fourth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.fourth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.fourth-slot.points"), player));
                return true;
            }));
			
			player.getInventory().setItem(4, IDDecompiler.getInstance().decompile(player, config.getString("voting.fifth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.fifth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.fifth-slot.points"), player));
                return true;
            }));
			
			player.getInventory().setItem(5, IDDecompiler.getInstance().decompile(player, config.getString("voting.sixth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.sixth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.sixth-slot.points"), player));
                return true;
            }));
			
			player.getInventory().setItem(6, IDDecompiler.getInstance().decompile(player, config.getString("voting.seventh-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.seventh-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.seventh-slot.points"), player));
                return true;
            }));
			
			player.getInventory().setItem(7, IDDecompiler.getInstance().decompile(player, config.getString("voting.eighth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.eighth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.eighth-slot.points"), player));
                return true;
            }));
		} catch (NullPointerException npe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to receive the blocks.");
		}
	}
}