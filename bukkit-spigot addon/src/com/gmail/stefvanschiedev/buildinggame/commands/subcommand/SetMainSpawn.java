package com.gmail.stefvanschiedev.buildinggame.commands.subcommand;

import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.SubCommand;

public class SetMainSpawn extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
        BungeeCordHandler.getInstance().write(BungeeCordHandler.Receiver.MAIN, "arenas.yml",
                "main-spawn.server", player.getServer().getServerName(), null);
        BungeeCordHandler.getInstance().write(BungeeCordHandler.Receiver.MAIN, "arenas.yml",
                "main-spawn.world", player.getWorld().getName(), null);
        BungeeCordHandler.getInstance().write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.x",
                "(int)" + player.getLocation().getBlockX(), null);
        BungeeCordHandler.getInstance().write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.y",
                "(int)" + player.getLocation().getBlockY(), null);
        BungeeCordHandler.getInstance().write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.z",
                "(int)" + player.getLocation().getBlockZ(), null);

        BungeeCordHandler.getInstance().save(BungeeCordHandler.Receiver.MAIN, null);
		
		player.sendMessage(ChatColor.GREEN + "Main spawn set!");
	}
	
	@Override
	public String getName() {
		return "setmainspawn";
	}
}