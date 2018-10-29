package com.gmail.stefvanschiedev.buildinggame.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/**
 * The main Building Game command
 *
 * @since 2.1.0
 */
@CommandAlias("buildinggame|bg")
public class BuildingGameCommand extends BaseCommand {

    @Subcommand("setmainspawn")
    @Description("Set the main spawn")
    @CommandPermission("bg.setmainspawn")
    //ACF may not function correctly when Player is changed to Entity due to the reliance on reflection
    @SuppressWarnings("TypeMayBeWeakened")
    public void onSetMainSpawn(Player player) {
        ConfigurationSection config = SettingsManager.getInstance().getConfig();

        BungeeCordHandler instance = BungeeCordHandler.getInstance();
        var location = player.getLocation();

        instance.write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.server",
            config.getString("this-server.name"), null);
        instance.write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.world",
            player.getWorld().getName(), null);
        instance.write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.x",
            "(int)" + location.getBlockX(), null);
        instance.write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.y",
            "(int)" + location.getBlockY(), null);
        instance.write(BungeeCordHandler.Receiver.MAIN, "arenas.yml", "main-spawn.z",
            "(int)" + location.getBlockZ(), null);

        instance.save(BungeeCordHandler.Receiver.MAIN, null);

        player.sendMessage(ChatColor.GREEN + "Main spawn set!");
    }

}