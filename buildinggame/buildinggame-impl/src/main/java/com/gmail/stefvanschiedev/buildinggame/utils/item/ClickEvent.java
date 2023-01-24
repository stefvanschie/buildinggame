package com.gmail.stefvanschiedev.buildinggame.utils.item;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Report;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu.SpectatorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.LocationDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.PlotDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import com.gmail.stefvanschiedev.buildinggame.utils.region.RegionFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * An enum containing various click events for items.
 *
 * @since 11.0.1
 */
public enum ClickEvent {

    /**
     * The click event for setting a boundary.
     *
     * @since 11.0.1
     */
    BOUNDS_CLICK((event, contextBag) -> {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        var player = event.getPlayer();
        var action = event.getAction();

        if (action != Action.LEFT_CLICK_BLOCK && action != Action.RIGHT_CLICK_BLOCK)
            return;

        Plot plot = contextBag.getContext("plot", PlotDataType.getInstance());

        if (plot == null) {
            return;
        }

        Location previousLocation = contextBag.getContext("location", LocationDataType.getInstance());

        if (previousLocation == null) {
            contextBag.addContext("location", LocationDataType.getInstance(), event.getClickedBlock().getLocation());

            MessageManager.getInstance().send(player,
                ChatColor.GREEN + "Now click on the other corner");
        } else {
            //second time
            var location = event.getClickedBlock().getLocation();
            String name = plot.getArena().getName();
            int plotID = plot.getId();
            World world = location.getWorld();

            if (previousLocation.getWorld().equals(world)) {
                arenas.set(name + '.' + plotID + ".high.world", world.getName());
                arenas.set(name + '.' + plotID + ".low.world", previousLocation.getWorld().getName());
            } else {
                MessageManager.getInstance().send(player,
                    ChatColor.RED + "The world has to be the same");
                event.setCancelled(true);
                return;
            }

            int highestX = Math.max(previousLocation.getBlockX(), location.getBlockX());
            int lowestX = Math.min(previousLocation.getBlockX(), location.getBlockX());

            int highestY = Math.max(previousLocation.getBlockY(), location.getBlockY());
            int lowestY = Math.min(previousLocation.getBlockY(), location.getBlockY());

            int highestZ = Math.max(previousLocation.getBlockZ(), location.getBlockZ());
            int lowestZ = Math.min(previousLocation.getBlockZ(), location.getBlockZ());

            //x
            arenas.set(name + '.' + plotID + ".high.x", highestX);
            arenas.set(name + '.' + plotID + ".low.x", lowestX);

            //y
            arenas.set(name + '.' + plotID + ".high.y", highestY);
            arenas.set(name + '.' + plotID + ".low.y", lowestY);

            //z
            arenas.set(name + '.' + plotID + ".high.z", highestZ);
            arenas.set(name + '.' + plotID + ".low.z", lowestZ);

            SettingsManager.getInstance().save();

            String worldName = world.getName();
            Supplier<World> worldSupplier = () -> Bukkit.getWorld(worldName);

            Region region = RegionFactory.createRegion(worldSupplier, highestX, highestY, highestZ, lowestX,
                lowestY, lowestZ);

            plot.setBoundary(region);

            messages.getStringList("commands.setbounds.success").forEach(message ->
                MessageManager.getInstance().send(player, message
                    .replace("%place%", plotID + "")
                    .replace("%arena%", name))
            );

            player.getInventory().setItemInMainHand(null);
        }

        event.setCancelled(true);
    }),

    /**
     * The click event for setting a floor.
     *
     * @since 11.0.1
     */
    FLOOR_CLICK((event, contextBag) -> {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        var player = event.getPlayer();
        var action = event.getAction();

        if (action != Action.LEFT_CLICK_BLOCK && action != Action.RIGHT_CLICK_BLOCK)
            return;

        Plot plot = contextBag.getContext("plot", PlotDataType.getInstance());

        if (plot == null) {
            return;
        }

        Location previousLocation = contextBag.getContext("location", LocationDataType.getInstance());

        if (previousLocation == null) {
            contextBag.addContext("location", LocationDataType.getInstance(), event.getClickedBlock().getLocation());

            MessageManager.getInstance().send(player,
                ChatColor.GREEN + "Now click on the other corner");
        } else {
            //second time
            var location = event.getClickedBlock().getLocation();
            String name = plot.getArena().getName();
            int plotID = plot.getId();
            World world = location.getWorld();

            if (previousLocation.getWorld().equals(world)) {
                arenas.set(name + '.' + plotID + ".floor.high.world", world.getName());
                arenas.set(name + '.' + plotID + ".floor.low.world", previousLocation.getWorld().getName());
            } else {
                MessageManager.getInstance().send(player,
                    ChatColor.RED + "The world has to be the same");
                event.setCancelled(true);
                return;
            }

            int highestX = Math.max(previousLocation.getBlockX(), location.getBlockX());
            int lowestX = Math.min(previousLocation.getBlockX(), location.getBlockX());

            int highestY = Math.max(previousLocation.getBlockY(), location.getBlockY());
            int lowestY = Math.min(previousLocation.getBlockY(), location.getBlockY());

            int highestZ = Math.max(previousLocation.getBlockZ(), location.getBlockZ());
            int lowestZ = Math.min(previousLocation.getBlockZ(), location.getBlockZ());

            //x
            arenas.set(name + '.' + plotID + ".floor.high.x", highestX);
            arenas.set(name + '.' + plotID + ".floor.low.x", lowestX);

            //y
            arenas.set(name + '.' + plotID + ".floor.high.y", highestY);
            arenas.set(name + '.' + plotID + ".floor.low.y", lowestY);

            //z
            arenas.set(name + '.' + plotID + ".floor.high.z", highestZ);
            arenas.set(name + '.' + plotID + ".floor.low.z", lowestZ);

            SettingsManager.getInstance().save();

            String worldName = world.getName();
            Supplier<World> worldSupplier = () -> Bukkit.getWorld(worldName);

            Region region = RegionFactory.createRegion(worldSupplier, highestX, highestY, highestZ, lowestX,
                lowestY, lowestZ);

            plot.setFloor(region);

            MessageManager.getInstance().send(player, ChatColor.GREEN + "Floor set!");

            player.getInventory().setItemInMainHand(null);
        }

        event.setCancelled(true);
    }),

    /**
     * The event for a player clicking on the item to open the options gui.
     *
     * @since 11.0.1
     */
    OPTIONS_GUI_CLICK((event, contextBag) -> {
        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        Player player = event.getPlayer();

        arena.getPlot(player).getBuildMenu().show(player);
        event.setCancelled(true);
    }),

    /**
     * The event for a player leaving an arena via the leave item.
     *
     * @since 11.0.1
     */
    PLAYER_LEAVE_CLICK((event, contextBag) -> {
        if (event.useItemInHand() == Event.Result.DENY) {
            return;
        }

        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        arena.leave(event.getPlayer());
        event.setCancelled(true);
    }),

    /**
     * The event for a player clicking the report item.
     *
     * @since 11.0.1
     */
    REPORT_CLICK((event, contextBag) -> {
        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        StringBuilder players = new StringBuilder();

        for (GamePlayer gamePlayer : arena.getVotingPlot().getGamePlayers()) {
            players.append('-').append(gamePlayer.getPlayer().getName());
        }

        var dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd_HH-mm-ss");
        var fileName = LocalDateTime.now().format(dateTimeFormatter) + players + ".schem";
        var file = new File(SettingsManager.getInstance().getReportsSchematicsFolder(), fileName);

        arena.getVotingPlot().getBoundary().saveSchematic(file, () ->
            MessageManager.getInstance().send(
                event.getPlayer(),
                ChatColor.GREEN + "Your report has been saved."
            ));

        for (GamePlayer gamePlayer : arena.getVotingPlot().getGamePlayers()) {
            Report.add(new Report(gamePlayer.getPlayer(), event.getPlayer(), ZonedDateTime.now(), file));
        }
    }),

    /**
     * The event for a spectator clicking on the item to open the spectator gui.
     *
     * @since 11.0.1
     */
    SPECTATOR_GUI_CLICK((event, contextBag) -> {
        new SpectatorMenu().show(event.getPlayer());

        event.setCancelled(true);
    }),

    /**
     * The event for a spectator clicking on the item to stop spectating.
     *
     * @since 11.0.1
     */
    SPECTATOR_STOP_CLICK((event, contextBag) -> {
        Plot plot = contextBag.getContext("plot", PlotDataType.getInstance());

        if (plot == null) {
            return;
        }

        Player player = event.getPlayer();
        GamePlayer gamePlayer = plot.getGamePlayer(player);

        if (gamePlayer == null) {
            return;
        }

        MainSpawnManager mainSpawnManager = MainSpawnManager.getInstance();

        gamePlayer.connect(mainSpawnManager.getServer(), mainSpawnManager.getMainSpawn());
        plot.removeSpectator(gamePlayer);

        MessageManager.getInstance().send(player, ChatColor.GREEN + "Stopped spectating");

        event.setCancelled(true);
    }),

    /**
     * The event for a player clicking on the item to open the subject gui.
     *
     * @since 11.0.1
     */
    SUBJECT_GUI_CLICK((event, contextBag) -> {
        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        arena.getSubjectMenu().show(event.getPlayer());
        event.setCancelled(true);
    }),

    /**
     * The event for a player clicking on the item to open the team gui.
     *
     * @since 11.0.1
     */
    TEAM_GUI_CLICK((event, contextBag) -> {
        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        arena.getTeamSelection().show(event.getPlayer());
        event.setCancelled(true);
    }),

    /**
     * The event for a player clicking on a vote item to vote on a plot.
     *
     * @since 11.0.1
     */
    VOTE_CLICK((event, contextBag) -> {
        Arena arena = contextBag.getContext("arena", ArenaDataType.getInstance());

        if (arena == null) {
            return;
        }

        //due to boxing, this may be null; to properly check for this, we don't unbox it, so we can perform a null check
        Integer points = contextBag.getContext("points", PersistentDataType.INTEGER);

        if (points == null) {
            return;
        }

        arena.getVotingPlot().addVote(new Vote(points, event.getPlayer()));
        event.setCancelled(true);
    });

    /**
     * A consumer taking a {@link PlayerInteractEvent} and a {@link ContextBag}. This is invoked whenever a player
     * clicks on an item with this consumer attached.
     */
    private final BiConsumer<? super PlayerInteractEvent, ? super ContextBag> consumer;

    /**
     * Creates a new click event with a biconsumer representing the action for this event.
     *
     * @param consumer the consumer representing the event
     * @since 11.0.1
     */
    ClickEvent(BiConsumer<? super PlayerInteractEvent, ? super ContextBag> consumer) {
        this.consumer = consumer;
    }

    /**
     * This invokes the action corresponding to this event.
     *
     * @param event the event from which this vinocation originates
     * @param bag the context for this invocation
     * @since 11.0.1
     */
    public void invoke(PlayerInteractEvent event, ContextBag bag) {
        this.consumer.accept(event, bag);
    }
}
