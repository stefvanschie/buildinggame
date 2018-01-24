package com.gmail.stefvanschiedev.buildinggame.commands.subcommand;

import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.SubCommand;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The command for setting the main spawn
 *
 * @since 2.1.0
 */
public class SetMainSpawn extends SubCommand {

    /**
     * Called whenever a player executes this command
     *
     * @param player the player who executed the command
     * @param args the arguments entered
     * @since 2.1.0
     */
    @Contract("null, _ -> fail")
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

    /**
     * Returns the name of this command
     *
     * @return the name
     * @since 2.1.0
     */
    @NotNull
    @Contract(pure = true)
	@Override
	public String getName() {
		return "setmainspawn";
	}
}