package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.*;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.timers.FileCheckerTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.ArenaSelection;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.ParticlesMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu.BaseColorBannerMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * This class handles all subcommands for the buildinggame command
 *
 * @since 2.1.0
 */
@CommandAlias("buildinggame|bg")
public class CommandManager extends BaseCommand {

    /**
     * The arenas YAML configuration
     */
    private static final YamlConfiguration ARENAS = SettingsManager.getInstance().getArenas();

    /**
     * The config YAML configuration
     */
    private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();

    /**
     * The messages YAML configuration
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Called whenever a command sender wants to start a booster
     *
     * @param sender the command sender
     * @param multiplier the booster multiplier
     * @param duration the duration of the booster
     * @param player the player for which the booster is intended, when null, the booster is global
     * @since 5.8.0
     */
    @Subcommand("booster")
    @Description("Activate a booster")
    @CommandPermission("bg.booster")
    @CommandCompletion("@nothing @nothing @players")
    public void onBooster(CommandSender sender, float multiplier, int duration, @Optional Player player) {
        new Booster(sender, multiplier, duration, player).start();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Activated " +
            (player == null ? "global booster" : "booster for " + player.getName()) + " for " + duration + " seconds");
    }

    /**
     * Called whenever a command sender wants to create a new arena
     *
     * @param sender the command sender
     * @param name the arena name
     * @since 5.8.0
     */
    @Subcommand("createarena")
    @Description("Create an arena")
    @CommandPermission("bg.createarena")
    public void onCreateArena(CommandSender sender, @Conditions("arenanotexist") @Single String name) {
        ARENAS.set(name + ".mode", "SOLO");
        ARENAS.set(name + ".timer", CONFIG.getInt("timers.build"));
        ARENAS.set(name + ".lobby-timer", CONFIG.getInt("timers.lobby"));
        ARENAS.set(name + ".vote-timer", CONFIG.getInt("timers.vote"));
        ARENAS.set(name + ".win-timer", CONFIG.getInt("timers.win"));
        SettingsManager.getInstance().save();

        ArenaManager.getInstance().setup();
        LobbyTimerManager.getInstance().setup();
        BuildTimerManager.getInstance().setup();
        VoteTimerManager.getInstance().setup();
        WinTimerManager.getInstance().setup();

        MESSAGES.getStringList("commands.createarena.success").forEach(message ->
            MessageManager.getInstance().send(sender, message.replace("%arena%", name)));
    }

    /**
     * Called whenever a command sender wants to delete an arena
     *
     * @param sender the command sender
     * @param arena the arena to delete
     * @since 5.8.0
     */
    @Subcommand("deletearena")
    @Description("Delete an arena")
    @CommandPermission("bg.deletearena")
    @CommandCompletion("@arenas")
    public void onDeleteArena(CommandSender sender, Arena arena) {
        ARENAS.set(arena.getName(), null);
        SettingsManager.getInstance().save();

        ArenaManager.getInstance().setup();
        LobbyManager.getInstance().setup();
        MaxPlayersManager.getInstance().setup();
        MinPlayersManager.getInstance().setup();

        PlotManager.getInstance().setup();
        LocationManager.getInstance().setup();
        BoundaryManager.getInstance().setup();
        FloorManager.getInstance().setup();

        MESSAGES.getStringList("commands.deletearena.success").forEach(message ->
            MessageManager.getInstance().send(sender, message.replace("%arena%", arena.getName())));
    }

    /**
     * Called whenever a command sender wants to delete a spawn
     *
     * @param sender the command sender
     * @param arena the arena
     * @param spawn the spawn point to delete
     * @since 5.8.0
     */
    @Subcommand("deletespawn")
    @Description("Delete a spawn")
    @CommandPermission("bg.deletespawn")
    @CommandCompletion("@arenas @nothing")
    public void onDeleteSpawn(CommandSender sender, Arena arena, int spawn) {
        var plot = arena.getPlot(spawn);

        if (plot == null) {
            MessageManager.getInstance().send(sender,
                ChatColor.RED + "That's not a valid plot. Try to create one first.");
            return;
        }

        var maxPlayers = ARENAS.getInt(arena.getName() + ".maxplayers");

        for (var i = plot.getID(); i < maxPlayers; i++)
            ARENAS.set(arena.getName() + '.' + i, ARENAS.getConfigurationSection(arena.getName() + '.' + i + 1));

        ARENAS.set(arena.getName() + '.' + maxPlayers, null);
        ARENAS.set(arena.getName() + ".maxplayers", maxPlayers - 1);

        SettingsManager.getInstance().save();

        MaxPlayersManager.getInstance().setup();

        PlotManager.getInstance().setup();
        LocationManager.getInstance().setup();
        BoundaryManager.getInstance().setup();
        FloorManager.getInstance().setup();

        MESSAGES.getStringList("commands.deletespawn.success").forEach(message ->
            MessageManager.getInstance().send(sender, message.replace("%place%", plot.getID() + "")));
    }

    /**
     * Called whenever a command sender wants to enable or disable money in a given arena
     *
     * @param sender the command sender
     * @param arena the arena
     * @param enableMoney whether money should be enabled
     * @since 5.8.0
     */
    @Subcommand("enablemoney")
    @Description("Enable or disable money for an arena")
    @CommandPermission("bg.enablemoney")
    @CommandCompletion("@arenas true|false")
    public void onEnableMoney(CommandSender sender, Arena arena, boolean enableMoney) {
        ARENAS.set(arena.getName() + ".enable-money", enableMoney);

        arena.setMoneyEnabled(enableMoney);

        SettingsManager.getInstance().save();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + (enableMoney ? "Enabled" : "Disabled") +
            " money for " + arena.getName());
    }

    /**
     * Called whenever a command sender wants to start an arena
     *
     * @param sender the command sender
     * @param arena the arena, if the sender is a player and the player is in an arena, this may be null
     */
    @Subcommand("forcestart")
    @Description("Force an arena to start")
    @CommandPermission("bg.forcestart")
    @CommandCompletion("@arenas")
    public void onForceStart(CommandSender sender, @Optional Arena arena) {
        if (sender instanceof Player) {
            var player = (Player) sender;
            var playerArena = ArenaManager.getInstance().getArena(player);

            if (playerArena != null && arena == null) {
                playerArena.getWaitTimer().setSeconds(0);
                return;
            }

        }

        if (arena == null) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an arena");
            return;
        }

        if (arena.getPlayers() < 1) {
            MessageManager.getInstance().send(sender,
                ChatColor.RED + "Arena could not start. There are no players!");
            return;
        }

        if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING &&
            arena.getState() != GameState.FULL) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "The arena is already in game");
            return;
        }

        arena.getWaitTimer().setSeconds(0);
    }

    /**
     * Called whenever a players wants to specify a theme
     *
     * @param player the player
     * @param theme the theme
     * @since 5.8.0
     */
    @Subcommand("forcetheme")
    @Description("Force a them to be chosen")
    @CommandPermission("bg.forcetheme")
    @CommandCompletion("@arenas @nothing")
    public void onForceTheme(Player player, String theme) {
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You aren't in an arena");
            return;
        }

        arena.getSubjectMenu().forceTheme(theme);

        MESSAGES.getStringList("commands.forcetheme.success").forEach(message ->
            MessageManager.getInstance().send(player, message.replace("%theme%", theme)));
    }

    /**
     * Called whenever a player wants to join an arena
     *
     * @param player the player
     * @param arena the arena to join
     * @since 5.8.0
     */
    @Subcommand("join")
    @Description("Join an arena")
    @CommandPermission("bg.join")
    @CommandCompletion("@arenas")
    public void onJoin(Player player, @Optional Arena arena) {
        if (arena == null) {
            List<Arena> arenas = ArenaManager.getInstance().getArenas().stream()
                .filter(a -> !a.isFull() && (a.getState() == GameState.WAITING || a.getState() == GameState.STARTING))
                .collect(Collectors.toList());

            if (arenas.isEmpty()) {
                MessageManager.getInstance().send(player, MESSAGES.getStringList("join.no-arena"));
                return;
            }

            new ArenaSelection().show(player);
            return;
        }

        arena.join(player);
    }

    /**
     * Called whenever a player wants to leave the currently joined arena
     *
     * @param player the player who wants to leave
     * @since 5.8.0
     */
    @Subcommand("leave")
    @Description("Leave the arena you're in")
    @CommandPermission("bg.leave")
    public void onLeave(Player player) {
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
            return;
        }

        arena.leave(player);
    }

    /**
     * Called whenever a command sender wants to view a list of all arenas
     *
     * @param sender the command sender who wants to view all arenas
     * @since 5.8.0
     */
    @Subcommand("list")
    @Description("List all arenas")
    @CommandPermission("bg.list")
    public void onList(CommandSender sender) {
        ArenaManager.getInstance().getArenas().forEach(arena ->
            MessageManager.getInstance().send(sender, ChatColor.DARK_AQUA + " - " + arena.getName() +
                ChatColor.DARK_GREEN + " - " + arena.getState().toString().toLowerCase(Locale.getDefault())));
    }

    /**
     * Called whenever a command sender wants to reload the plugin
     *
     * @param sender the command sender
     * @since 5.8.0
     */
    @Subcommand("reload")
    @Description("Reload the plugin")
    @CommandPermission("bg.reload")
    public void onReload(CommandSender sender) {
        ArenaManager.getInstance().getArenas().stream().filter(arena -> arena.getPlayers() > 0).forEach(Arena::stop);

        StatManager instance = StatManager.getInstance();

        if (instance.getMySQLDatabase() == null)
            instance.saveToFile();
        else
            instance.saveToDatabase();

        FileCheckerTimer runnable = SettingsManager.getInstance().getRunnable();

        if (!runnable.isCancelled())
            runnable.cancel();

        Main.getInstance().loadPlugin(true);

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Reloaded the plugin!");
    }

    /**
     * Called whenever a player wants to set the boundary of a plot
     *
     * @param player the player
     * @param arena the arena
     * @param id the plot id to set the boundary of
     * @since 5.8.0
     */
    @Subcommand("setbounds")
    @Description("Set the boundary of a plot (inclusive)")
    @CommandPermission("bg.setbounds")
    @CommandCompletion("@arenas @nothing")
    public void onSetBounds(Player player, Arena arena, int id) {
        final var plot = arena.getPlot(id);

        if (plot == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid plot");
            return;
        }

        player.getInventory().setItemInMainHand(new ItemBuilder(player, Material.STICK)
            .setDisplayName(ChatColor.LIGHT_PURPLE + "Wand").setClickEvent(new Consumer<>() {
                private Location previousLocation;

                @Override
                public void accept(PlayerInteractEvent event) {
                    YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
                    YamlConfiguration messages = SettingsManager.getInstance().getMessages();

                    var player = event.getPlayer();
                    var action = event.getAction();

                    if (action != Action.LEFT_CLICK_BLOCK && action != Action.RIGHT_CLICK_BLOCK)
                        return;

                    if (previousLocation == null) {
                        previousLocation = event.getClickedBlock().getLocation();

                        MessageManager.getInstance().send(player,
                            ChatColor.GREEN + "Now click on the other corner");
                    } else {
                        //second time
                        var location = event.getClickedBlock().getLocation();
                        String name = arena.getName();
                        int plotID = plot.getID();

                        if (previousLocation.getWorld().equals(location.getWorld())) {
                            arenas.set(name + '.' + plotID + ".high.world", location.getWorld().getName());
                            arenas.set(name + '.' + plotID + ".low.world", previousLocation.getWorld().getName());
                        } else {
                            MessageManager.getInstance().send(player,
                                ChatColor.RED + "The world has to be the same");
                            event.setCancelled(true);
                            return;
                        }

                        //x
                        if (previousLocation.getBlockX() < location.getBlockX()) {
                            arenas.set(name + '.' + plotID + ".high.x", location.getBlockX());
                            arenas.set(name + '.' + plotID + ".low.x", previousLocation.getBlockX());
                        } else {
                            arenas.set(name + '.' + plotID + ".low.x", location.getBlockX());
                            arenas.set(name + '.' + plotID + ".high.x", previousLocation.getBlockX());
                        }

                        //y
                        if (previousLocation.getBlockY() < location.getBlockY()) {
                            arenas.set(name + '.' + plotID + ".high.y", location.getBlockY());
                            arenas.set(name + '.' + plotID + ".low.y", previousLocation.getBlockY());
                        } else {
                            arenas.set(name + '.' + plotID + ".low.y", location.getBlockY());
                            arenas.set(name + '.' + plotID + ".high.y", previousLocation.getBlockY());
                        }

                        //z
                        if (previousLocation.getBlockZ() < location.getBlockZ()) {
                            arenas.set(name + '.' + plotID + ".high.z", location.getBlockZ());
                            arenas.set(name + '.' + plotID + ".low.z", previousLocation.getBlockZ());
                        } else {
                            arenas.set(name + '.' + plotID + ".low.z", location.getBlockZ());
                            arenas.set(name + '.' + plotID + ".high.z", previousLocation.getBlockZ());
                        }

                        SettingsManager.getInstance().save();
                        BoundaryManager.getInstance().setup();

                        messages.getStringList("commands.setbounds.success").forEach(message ->
                            MessageManager.getInstance().send(player, message
                                .replace("%place%", plotID + "")
                                .replace("%arena%", name))
                        );

                        previousLocation = null;

                        player.getInventory().setItemInMainHand(null);
                    }

                    event.setCancelled(true);
                }
            }).build());

        MessageManager.getInstance().send(player, ChatColor.GREEN + "Please click on one corner");
    }

    /**
     * Called whenever a player wants to set the floor of a plot
     *
     * @param player the player
     * @param arena the arena
     * @param id the plot id to set the floor of
     * @since 5.8.0
     */
    @Subcommand("setfloor")
    @Description("Set the floor of a plot (inclusive)")
    @CommandPermission("bg.setfloor")
    @CommandCompletion("@arenas @nothing")
    public void onSetFloor(Player player, Arena arena, int id) {
        final var plot = arena.getPlot(id);

        if (plot == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid plot");
            return;
        }

        player.getInventory().setItemInMainHand(new ItemBuilder(player, Material.STICK)
            .setDisplayName(ChatColor.LIGHT_PURPLE + "Wand").setClickEvent(new Consumer<>() {
                private Location previousLocation;

                @Override
                public void accept(PlayerInteractEvent event) {
                    YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

                    var player = event.getPlayer();
                    var action = event.getAction();

                    if (action != Action.LEFT_CLICK_BLOCK && action != Action.RIGHT_CLICK_BLOCK)
                        return;

                    if (previousLocation == null) {
                        previousLocation = event.getClickedBlock().getLocation();

                        MessageManager.getInstance().send(player,
                            ChatColor.GREEN + "Now click on the other corner");
                    } else {
                        //second time
                        var location = event.getClickedBlock().getLocation();
                        String name = arena.getName();
                        int plotID = plot.getID();

                        if (previousLocation.getWorld().equals(location.getWorld())) {
                            arenas.set(name + '.' + plotID + ".floor.high.world", location.getWorld().getName());
                            arenas.set(name + '.' + plotID + ".floor.low.world", previousLocation.getWorld().getName());
                        } else {
                            MessageManager.getInstance().send(player,
                                ChatColor.RED + "The world has to be the same");
                            event.setCancelled(true);
                            return;
                        }

                        //x
                        if (previousLocation.getBlockX() < location.getBlockX()) {
                            arenas.set(name + '.' + plotID + ".floor.high.x", location.getBlockX());
                            arenas.set(name + '.' + plotID + ".floor.low.x", previousLocation.getBlockX());
                        } else {
                            arenas.set(name + '.' + plotID + ".floor.low.x", location.getBlockX());
                            arenas.set(name + '.' + plotID + ".floor.high.x", previousLocation.getBlockX());
                        }

                        //y
                        if (previousLocation.getBlockY() < location.getBlockY()) {
                            arenas.set(name + '.' + plotID + ".floor.high.y", location.getBlockY());
                            arenas.set(name + '.' + plotID + ".floor.low.y", previousLocation.getBlockY());
                        } else {
                            arenas.set(name + '.' + plotID + ".floor.low.y", location.getBlockY());
                            arenas.set(name + '.' + plotID + ".floor.high.y", previousLocation.getBlockY());
                        }

                        //z
                        if (previousLocation.getBlockZ() < location.getBlockZ()) {
                            arenas.set(name + '.' + plotID + ".floor.high.z", location.getBlockZ());
                            arenas.set(name + '.' + plotID + ".floor.low.z", previousLocation.getBlockZ());
                        } else {
                            arenas.set(name + '.' + plotID + ".floor.low.z", location.getBlockZ());
                            arenas.set(name + '.' + plotID + ".floor.high.z", previousLocation.getBlockZ());
                        }

                        SettingsManager.getInstance().save();
                        FloorManager.getInstance().setup();

                        MessageManager.getInstance().send(player, ChatColor.GREEN + "Floor set!");

                        previousLocation = null;

                        player.getInventory().setItemInMainHand(null);
                    }

                    event.setCancelled(true);
                }
            }).build());

        MessageManager.getInstance().send(player, ChatColor.GREEN + "Please click on one corner");
    }

    /**
     * Called whenever a command sender wants to change the game mode of an arena
     *
     * @param sender the command sender
     * @param arena the arena
     * @param arenaMode the new arena mode
     * @since 5.8.0
     */
    @Subcommand("setgamemode")
    @Description("Set the game mode of an arena")
    @CommandPermission("bg.setgamemode")
    @CommandCompletion("@arenas @arenamodes")
    public void onSetGameMode(CommandSender sender, Arena arena, ArenaMode arenaMode) {
        ARENAS.set(arena.getName() + ".mode", arenaMode.toString());
        SettingsManager.getInstance().save();

        ArenaModeManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN +
            "Successfully changed game mode of arena " + arena.getName() + " to " +
            arenaMode.toString().toLowerCase(Locale.getDefault()));
    }

    /**
     * Called whenever a player wants to set the lobby of an arena
     *
     * @param player the player
     * @param arena the arena which lobby will be changed
     * @since 5.8.0
     */
    @Subcommand("setlobby")
    @Description("Set the lobby")
    @CommandPermission("bg.setlobby")
    @CommandCompletion("@arenas")
    public void onSetLobby(Player player, Arena arena) {
        ARENAS.set(arena.getName() + ".lobby.server", player.getServer().getName());
        ARENAS.set(arena.getName() + ".lobby.world", player.getLocation().getWorld().getName());
        ARENAS.set(arena.getName() + ".lobby.x", player.getLocation().getBlockX());
        ARENAS.set(arena.getName() + ".lobby.y", player.getLocation().getBlockY());
        ARENAS.set(arena.getName() + ".lobby.z", player.getLocation().getBlockZ());
        ARENAS.set(arena.getName() + ".lobby.pitch", player.getLocation().getPitch());
        ARENAS.set(arena.getName() + ".lobby.yaw", player.getLocation().getYaw());
        SettingsManager.getInstance().save();

        LobbyManager.getInstance().setup();

        MessageManager.getInstance().send(player, MESSAGES.getStringList("commands.setlobby.success"));
    }

    /**
     * Called whenever a command sender wants to set the lobby timer
     *
     * @param sender the command sender
     * @param arena the arena
     * @param seconds the amount of seconds the lobby timer should last
     * @since 5.8.0
     */
    @Subcommand("setlobbytimer")
    @Description("Change the lobby timer")
    @CommandPermission("bg.setlobbytimer")
    @CommandCompletion("@arenas @nothing")
    public void onSetLobbyTimer(CommandSender sender, Arena arena, int seconds) {
        ARENAS.set(arena.getName() + ".lobby-timer", seconds);
        SettingsManager.getInstance().save();
        LobbyTimerManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Lobby timer setting for arena '" +
            arena.getName() + "' changed to '" + seconds + '\'');
    }

    /**
     * Called whenever a player wants to set the main spawn
     *
     * @param player the player
     * @since 5.8.0
     */
    @Subcommand("setmainspawn")
    @Description("Set the main spawn")
    @CommandPermission("bg.setmainspawn")
    public void onSetMainSpawn(Player player) {
        List<String> worlds = CONFIG.getStringList("scoreboards.main.worlds.enable");

        if (ARENAS.contains("main-spawn.world"))
            worlds.remove(ARENAS.getString("main-spawn.world"));

        worlds.add(player.getLocation().getWorld().getName());
        CONFIG.set("scoreboards.main.worlds.enable", worlds);

        ARENAS.set("main-spawn.server", player.getServer().getName());
        ARENAS.set("main-spawn.world", player.getLocation().getWorld().getName());
        ARENAS.set("main-spawn.x", player.getLocation().getBlockX());
        ARENAS.set("main-spawn.y", player.getLocation().getBlockY());
        ARENAS.set("main-spawn.z", player.getLocation().getBlockZ());
        ARENAS.set("main-spawn.pitch", player.getLocation().getPitch());
        ARENAS.set("main-spawn.yaw", player.getLocation().getYaw());
        SettingsManager.getInstance().save();

        MainSpawnManager.getInstance().setMainSpawn(player.getLocation());
        MessageManager.getInstance().send(player, MESSAGES.getStringList("commands.setmainspawn.success"));
    }

    /**
     * Called whenever a command sender wants to set the amount of matches
     *
     * @param sender the command sender
     * @param arena the arena
     * @param matches the new amount of matches
     * @since 5.8.0
     */
    @Subcommand("setmatches")
    @Description("Set the amount of matches to play")
    @CommandPermission("bg.setmatches")
    @CommandCompletion("@arenas @nothing")
    public void onSetMatches(CommandSender sender, Arena arena, int matches) {
        if (!arena.isEmpty()) {
            MessageManager.getInstance().send(sender, ChatColor.RED +
                "The arena isn't empty, changing the matches now is likely to cause problems. Please wait until the arena is empty.");
            return;
        }

        ARENAS.set(arena.getName() + ".matches", matches);
        SettingsManager.getInstance().save();

        MatchesManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Amount of matches changed!");
    }

    /**
     * Called whenever a command sender wants to set the maximum amount of players
     *
     * @param sender the command sender
     * @param arena the arena
     * @param maxPlayers the maximum amount of players
     * @since 5.8.0
     */
    @Subcommand("setmaxplayers")
    @Description("Set the maximum amount of players in an arena")
    @CommandPermission("bg.setmaxplayers")
    @CommandCompletion("@arenas @nothing")
    public void onSetMaxPlayers(CommandSender sender, Arena arena, int maxPlayers) {
        if (arena.getMode() == ArenaMode.SOLO) {
            MessageManager.getInstance().send(sender,
                ChatColor.RED + "You can only modify the maximum amount of players from arenas which are in team mode");
            return;
        }

        if (arena.getPlots().isEmpty()) {
            MessageManager.getInstance().send(sender,
                ChatColor.RED + "You first need to create plots before setting the max players");
            return;
        }

        if (maxPlayers % arena.getPlots().size() != 0) {
            MessageManager.getInstance().send(sender, ChatColor.RED +
                "Your max players has to be a number divisible by " + arena.getPlots().size());
            return;
        }

        ARENAS.set(arena.getName() + ".maxplayers", maxPlayers);

        //add parts to config
        for (int i = 0; i < maxPlayers; i++) {
            if (CONFIG.contains("team-selection.team." + i))
                continue;

            CONFIG.set("team-selection.team." + i + ".id", "paper");
        }

        SettingsManager.getInstance().save();

        MaxPlayersManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Max players changed!");
    }

    /**
     * Called whenever a command sender wants to set the minimum amount of players
     *
     * @param sender the command sender
     * @param arena the arena
     * @param maxPlayers the maximum amount of players
     * @since 5.8.0
     */
    @Subcommand("setminplayers")
    @Description("Set the minimum amount of players")
    @CommandPermission("bg.setminplayers")
    @CommandCompletion("@arenas @nothing")
    public void onSetMinPlayers(CommandSender sender, Arena arena, int maxPlayers) {
        ARENAS.set(arena.getName() + ".minplayers", maxPlayers);
        SettingsManager.getInstance().save();

        MinPlayersManager.getInstance().setup();

        MessageManager.getInstance().send(sender, MESSAGES.getStringList("commands.setminplayers.success"));
    }

    /**
     * Called whenever a player wants to set a new spawn
     *
     * @param player the player
     * @param arena the arena
     * @since 5.8.0
     */
    @Subcommand("setspawn")
    @Description("Set a new spawn")
    @CommandPermission("bg.setspawn")
    @CommandCompletion("@arenas")
    public void onSetSpawn(Player player, Arena arena) {
        int place = arena.getMaxPlayers() + 1;
        String name = arena.getName();

        ARENAS.set(name + '.' + place + ".server", player.getServer().getName());
        ARENAS.set(name + '.' + place + ".world", player.getLocation().getWorld().getName());
        ARENAS.set(name + '.' + place + ".x", player.getLocation().getBlockX());
        ARENAS.set(name + '.' + place + ".y", player.getLocation().getBlockY());
        ARENAS.set(name + '.' + place + ".z", player.getLocation().getBlockZ());
        ARENAS.set(name + '.' + place + ".pitch", player.getLocation().getPitch());
        ARENAS.set(name + '.' + place + ".yaw", player.getLocation().getYaw());
        ARENAS.set(name + ".maxplayers", place);
        SettingsManager.getInstance().save();

        PlotManager.getInstance().setup();
        LocationManager.getInstance().setup();
        MaxPlayersManager.getInstance().setup();

        MESSAGES.getStringList("commands.setspawn.success").forEach(message ->
            MessageManager.getInstance().send(player, message.replace("%place%", place + "")));
    }

    /**
     * Called whenever a command sender wants to change the timer
     *
     * @param sender the command sender
     * @param arena the arena
     * @param seconds the new amount of seconds
     * @since 5.8.0
     */
    @Subcommand("settimer")
    @Description("Change the timer")
    @CommandPermission("bg.settimer")
    @CommandCompletion("@arenas @nothing")
    public void onSetTimer(CommandSender sender, Arena arena, int seconds) {
        ARENAS.set(arena.getName() + ".timer", seconds);
        SettingsManager.getInstance().save();
        BuildTimerManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Timer setting for arena '" +
            arena.getName() + "' changed to '" + seconds + '\'');
    }

    /**
     * Called whenever a command sender wants to change a setting
     *
     * @param sender the command sender
     * @param path the path in the config file
     * @param args the arguments
     * @since 5.8.0
     */
    @Subcommand("setting")
    @Description("Change a setting")
    @CommandPermission("bg.setting")
    public void onSetting(CommandSender sender, String path, @Split(" ") String[] args) {
        if (!CONFIG.contains(path)) {
            MessageManager.getInstance().send(sender, ChatColor.RED + "That setting doesn't exist");
            return;
        }

        if (CONFIG.isList(path)) {
            if (args.length < 2) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                    "Please specify if you want to add or remove this value and the value");
                return;
            }

            if (args[0].equalsIgnoreCase("add")) {
                //add the value
                List<String> list = CONFIG.getStringList(path);
                list.add(args[1]);
                CONFIG.set(path, list);

                MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value added to config");
            } else if (args[0].equalsIgnoreCase("remove")) {
                //remove the value
                List<String> list = CONFIG.getStringList(path);
                list.remove(args[1]);
                CONFIG.set(path, list);

                MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value removed from config");
            }

            SettingsManager.getInstance().save();
            return;
        }

        //whole bunch of checking
        if (CONFIG.isBoolean(path))
            CONFIG.set(path, Boolean.parseBoolean(args[0]));
        else if (CONFIG.isDouble(path)) {
            try {
                CONFIG.set(path, Double.parseDouble(args[0]));
            } catch (NumberFormatException e) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                    "Value type isn't the same as in the config, it should be a double");
                return;
            }
        } else if (CONFIG.isInt(path)) {
            try {
                CONFIG.set(path, Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                    "Value type isn't the same as in the config, it should be an integer");
                return;
            }
        } else if (CONFIG.isLong(path)) {
            try {
                CONFIG.set(path, Long.parseLong(args[0]));
            } catch (NumberFormatException e) {
                MessageManager.getInstance().send(sender, ChatColor.RED +
                    "Value type isn't the same as in the config, it should be a long");
                return;
            }
        } else if (CONFIG.isString(path))
            CONFIG.set(path, args[0]);
        else {
            MessageManager.getInstance().send(sender, ChatColor.YELLOW +
                "Unable to change setting with commands, please change this setting by hand");
            return;
        }

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Value changed in config");
        SettingsManager.getInstance().save();
    }

    /**
     * Called whenever a command sender wants to change the vote timer
     *
     * @param sender the command sender
     * @param arena the arena
     * @param seconds the amount of seconds
     * @since 5.8.0
     */
    @Subcommand("setvotetimer")
    @Description("Change the vote timer")
    @CommandPermission("bg.setvotetimer")
    @CommandCompletion("@arenas @nothing")
    public void onSetVoteTimer(CommandSender sender, Arena arena, int seconds) {
        ARENAS.set(arena.getName() + ".vote-timer", seconds);
        SettingsManager.getInstance().save();
        VoteTimerManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Vote timer setting for arena '" +
            arena.getName() + "' changed to '" + seconds + '\'');
    }

    /**
     * Called whenever a command sender wants to change the win timer
     *
     * @param sender the command sender
     * @param arena the arena
     * @param seconds the amount of seconds
     * @since 5.8.0
     */
    @Subcommand("setwintimer")
    @Description("Change the win timer")
    @CommandPermission("bg.setwintimer")
    @CommandCompletion("@arenas @nothing")
    public void onSetWinTimer(CommandSender sender, Arena arena, int seconds) {
        ARENAS.set(arena.getName() + ".win-timer", seconds);
        SettingsManager.getInstance().save();
        WinTimerManager.getInstance().setup();

        MessageManager.getInstance().send(sender, ChatColor.GREEN + "Win timer setting for arena '" +
            arena.getName() + "' changed to '" + seconds + '\'');
    }

    /**
     * Called whenever a player wants to spectate
     *
     * @param player the player
     * @param toSpectate the player to spectate
     * @since 5.8.0
     */
    @Subcommand("spectate")
    @Description("Spectate a player")
    @CommandPermission("bg.spectate")
    public void onSpectate(Player player, Player toSpectate) {
        var arena = ArenaManager.getInstance().getArena(toSpectate);

        if (arena == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "Arena not found");
            return;
        }

        if (arena.getState() != GameState.BUILDING) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You can't spectate right now");
            return;
        }

        GamePlayer toSpectateGamePlayer = arena.getUsedPlots().stream()
            .flatMap(plot -> plot.getAllGamePlayers().stream())
            .filter(gamePlayer -> gamePlayer.getPlayer().equals(toSpectate))
            .findAny()
            .orElse(null);

        if (toSpectateGamePlayer == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "Couldn't find the player to spectate");
            return;
        }

        if (toSpectateGamePlayer.getGamePlayerType() == GamePlayerType.SPECTATOR) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You can't spectate a spectator");
            return;
        }

        //check if the player is playing the game
        if (ArenaManager.getInstance().getArena(player) != null &&
            ArenaManager.getInstance().getArena(player).getPlot(player).getGamePlayer(player)
                .getGamePlayerType() == GamePlayerType.PLAYER) {
            MessageManager.getInstance().send(player,
                ChatColor.RED + "You can't spectate while you're in game");
            return;
        }

        //check if we are already spectating
        Plot spectating = null;
        for (Arena a : ArenaManager.getInstance().getArenas()) {
            for (Plot plot : a.getUsedPlots()) {
                for (GamePlayer gamePlayer : plot.getSpectators()) {
                    if (gamePlayer.getPlayer().equals(player))
                        spectating = plot;
                }
            }
        }

        if (spectating != null)
            //noinspection ConstantConditions
            spectating.removeSpectator(spectating.getGamePlayer(player));

        arena.getPlot(toSpectateGamePlayer.getPlayer()).addSpectator(player, toSpectateGamePlayer);

        MessageManager.getInstance().send(player, ChatColor.GREEN + "Now spectating " +
            toSpectateGamePlayer.getPlayer().getName() + '!');
    }

    /**
     * Called whenever a player wants to view his/her statistics
     *
     * @param player the player
     * @since 5.8.0
     */
    @Subcommand("stats")
    @Description("Show your stats")
    @CommandPermission("bg.stats")
    public void onStats(Player player) {
        StatManager statManager = StatManager.getInstance();

        var playsStat = statManager.getStat(player, StatType.PLAYS);
        var firstStat = statManager.getStat(player, StatType.FIRST);
        var secondStat = statManager.getStat(player, StatType.SECOND);
        var thirdStat = statManager.getStat(player, StatType.THIRD);
        var placedStat = statManager.getStat(player, StatType.PLACED);
        var brokenStat = statManager.getStat(player, StatType.BROKEN);
        var walkedStat = statManager.getStat(player, StatType.WALKED);
        var pointsGivenStat = statManager.getStat(player, StatType.POINTS_GIVEN);
        var pointsReceivedStat = statManager.getStat(player, StatType.POINTS_RECEIVED);

        MessageManager.translate(MESSAGES.getStringList("commands.stats.success")).forEach(message ->
            MessageManager.getInstance().send(player, message
                .replace("%stat_plays%", playsStat == null ? "0" : String.valueOf(playsStat.getValue()))
                .replace("%stat_first%", firstStat == null ? "0" : String.valueOf(firstStat.getValue()))
                .replace("%stat_second%", secondStat == null ? "0" : String.valueOf(secondStat.getValue()))
                .replace("%stat_third%", thirdStat == null ? "0" : String.valueOf(thirdStat.getValue()))
                .replace("%stat_placed%", placedStat == null ? "0" : String.valueOf(placedStat.getValue()))
                .replace("%stat_broken%", brokenStat == null ? "0" : String.valueOf(brokenStat.getValue()))
                .replace("%stat_walked%", walkedStat == null ? "0" : String.valueOf(walkedStat.getValue()))
                .replace("%stat_points_given%", pointsGivenStat == null ? "0" :
                    String.valueOf(pointsGivenStat.getValue()))
                .replace("%stat_points_received%", pointsReceivedStat == null ? "0" :
                    String.valueOf(pointsReceivedStat.getValue()))));
    }

    /**
     * Called whenever a player wants to vote on a plot
     *
     * @param player the player
     * @param points the amount of points to award
     * @since 5.8.0
     */
    @Subcommand("vote")
    @Description("Vote on someone's plot")
    @CommandPermission("bg.vote")
    @CommandCompletion("@range:1-10")
    public void onVote(Player player, int points) {
        if (points < 1 || points > 10) {
            MessageManager.getInstance().send(player, ChatColor.RED + "Points can only be between 1 and 10");
            return;
        }

        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
            return;
        }

        if (arena.getPlot(player).getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
            MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't vote");
            return;
        }

        if (arena.getState() != GameState.VOTING) {
            MessageManager.getInstance().send(player, ChatColor.RED + "You can't vote at this moment");
            return;
        }

        var plot = arena.getVotingPlot();
        plot.addVote(new Vote(points, player));

        MessageManager.getInstance().send(player, MESSAGES.getString("vote.message")
            .replace("%playerplot%", plot.getPlayerFormat())
            .replace("%points%", points + ""));
    }

    /**
     * Contains methods for commands regarding holograms
     *
     * @since 6.2.0
     */
    @Subcommand("hologram")
    public class HologramCommand extends BaseCommand {

        /**
         * Creates and registers a new hologram at the position of the player
         *
         * @param player the player who executed the command
         * @param name the name of the hologram to create, see {@link TopStatHologram#getName()}
         * @param type the type of statistic to track,
         * @param values the amount of values to display on the hologram
         * @since 6.2.0
         */
        @Subcommand("create")
        @Description("Create a new top statistics hologram")
        @CommandPermission("bg.hologram.create")
        @CommandCompletion("@nothing @stattypes @nothing")
        @Conditions("hdenabled")
        public void onCreate(Player player, String name, StatType type, int values) {
            if (TopStatHologram.getHolograms().stream()
                .anyMatch(hologram -> hologram.getName().equalsIgnoreCase(name))) {
                player.sendMessage(ChatColor.RED + "A hologram with the name '" + name + "' already exists.");
                return;
            }

            new TopStatHologram(name, type, values, player.getLocation()).register();
            SettingsManager.getInstance().save();
            player.sendMessage(ChatColor.GREEN + "A hologram named '" + name + "' has been created.");
        }

        /**
         * Deletes an already existing hologram
         *
         * @param sender the sender which executed the command
         * @param name the name of the hologram to delete, see {@link TopStatHologram#getName()}
         * @since 6.2.0
         */
        @Subcommand("delete")
        @Description("Delete a top statistics hologram")
        @CommandPermission("bg.hologram.delete")
        @CommandCompletion("@holograms")
        @Conditions("hdenabled")
        public void onDelete(CommandSender sender, String name) {
            TopStatHologram hologram = TopStatHologram.getHolograms().stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);

            if (hologram == null) {
                sender.sendMessage(ChatColor.RED + "No hologram with the name '" + name + "' exists.");
                return;
            }

            hologram.delete();
            SettingsManager.getInstance().save();
            sender.sendMessage(ChatColor.GREEN + "The hologram named '" + name + "' has been deleted.");
        }
    }

    /**
     * Shows an automatically generated help display to the sender
     *
     * @param sender the sender which should see the help menu
     * @param help the command supplied for the help system
     * @since 5.9.0
     */
    @HelpCommand
    public void doHelp(CommandSender sender, CommandHelp help) {
        help.showHelp();
    }
}