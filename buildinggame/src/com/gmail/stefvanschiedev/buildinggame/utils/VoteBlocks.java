package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

/**
 * A utility class for giving a player a vote block
 *
 * @since 2.1.0
 */
public class VoteBlocks {

    /**
     * YAML configuration for the config.yml
     */
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();

    /**
     * YAML configuration for the messages.yml
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

    /**
     * Gives the player the voting blocks
     *
     * @param player the player to give the blocks to
     * @since 2.1.0
     */
	public void give(final Player player) {
	    Plot plot = ArenaManager.getInstance().getArena(player).getVotingPlot();

		try {
            ItemBuilder secondSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.second-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.second-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
                return true;
            });
            ItemBuilder.register(secondSlot);
            player.getInventory().setItem(1, secondSlot);

            ItemBuilder thirdSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.third-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.third-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.second-slot.points"), player));
                return true;
            });
            ItemBuilder.register(thirdSlot);
            player.getInventory().setItem(2, thirdSlot);

            ItemBuilder fourthSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.fourth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.fourth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.fourth-slot.points"), player));
                return true;
            });
            ItemBuilder.register(fourthSlot);
            player.getInventory().setItem(3, fourthSlot);

            ItemBuilder fifthSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.fifth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.fifth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.fifth-slot.points"), player));
                return true;
            });
            ItemBuilder.register(fifthSlot);
            player.getInventory().setItem(4, fifthSlot);

            ItemBuilder sixthSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.sixth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.sixth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.sixth-slot.points"), player));
                return true;
            });
            ItemBuilder.register(sixthSlot);
            player.getInventory().setItem(5, sixthSlot);

            ItemBuilder seventhSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.seventh-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.seventh-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.seventh-slot.points"), player));
                return true;
            });
            ItemBuilder.register(seventhSlot);
            player.getInventory().setItem(6, seventhSlot);

            ItemBuilder eighthSlot = IDDecompiler.getInstance().decompile(player, config.getString("voting.eighth-slot.id")).setDisplayName(MessageManager.translate(messages.getString("voting.eighth-slot-block"))).moveable(false).setClickEvent(event -> {
                plot.addVote(new Vote(config.getInt("voting.eighth-slot.points"), player));
                return true;
            });
            ItemBuilder.register(eighthSlot);
            player.getInventory().setItem(7, eighthSlot);
        } catch (NullPointerException npe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to receive the blocks.");
		}
	}
}