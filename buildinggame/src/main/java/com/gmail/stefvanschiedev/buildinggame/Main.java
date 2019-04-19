package com.gmail.stefvanschiedev.buildinggame;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.ConditionFailedException;
import co.aikar.commands.InvalidCommandArgument;
import com.github.stefvanschie.inventoryframework.Gui;
import com.gmail.stefvanschiedev.buildinggame.events.softdependencies.PerWorldInventoryCancel;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.*;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntityOptionsMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.*;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickSpectateSign;
import com.gmail.stefvanschiedev.buildinggame.events.softdependencies.WorldEditBoundaryAssertion;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.*;
import com.gmail.stefvanschiedev.buildinggame.managers.commands.CommandManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.PlaceholderAPIPlaceholders;
import com.gmail.stefvanschiedev.buildinggame.timers.*;
import com.gmail.stefvanschiedev.buildinggame.utils.Achievement;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.TopStatHologram;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.ConfirmationMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import com.sk89q.worldedit.WorldEdit;
import org.bstats.bukkit.MetricsLite;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.events.block.BlockBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockDispenseItem;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockPlace;
import com.gmail.stefvanschiedev.buildinggame.events.block.LiquidFlow;
import com.gmail.stefvanschiedev.buildinggame.events.block.PistonBlockMove;
import com.gmail.stefvanschiedev.buildinggame.events.entity.ChickenSpawnByEgg;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntityExplode;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntitySpawn;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickJoinSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickLeaveSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.Interact;
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardJoinShow;
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardWorldChange;
import com.gmail.stefvanschiedev.buildinggame.events.stats.database.JoinPlayerStats;
import com.gmail.stefvanschiedev.buildinggame.events.stats.database.QuitPlayerStats;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.BreakStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.FirstStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.PlaceStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.PlaysStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.SecondStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.ThirdStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.unsaved.UnsavedStatsPlace;
import com.gmail.stefvanschiedev.buildinggame.events.structure.TreeGrow;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The main class of this plugin
 *
 * @since 2.1.0
 */
public class Main extends JavaPlugin {

    /**
     * An instance of this class
     */
	private static Main instance;

    /**
     * The delay for loading this plugin
     */
	private final LoadCooldown load = new LoadCooldown();

    /**
     * Whether the listeners have been loaded
     */
	private boolean loadedListeners;

    /**
     * Whether the commands have been loaded
     */
	private boolean loadedCommands;

    /**
     * Called whenever this plugin is being enabled
     *
     * @since 2.1.0
     */
	@Override
	public void onEnable() {
		instance = this;

		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this, true);

        String version = Bukkit.getBukkitVersion().split("\\.")[1];
        if (!version.substring(0, version.length() < 2 ? version.length() : 2).equals("13")) {
			getLogger().info("Incorrect Bukkit/Spigot version, not loading plugin.");
			return;
		}

		//loading metrics
		getLogger().info("Loading metrics");
        new MetricsLite(this);
		
		if (SettingsManager.getInstance().getConfig().getBoolean("loading.load-after-plugins")) {
			getLogger().info("Waiting until other plugins are loaded");
		
			load.runTaskTimer(this, 20L, 20L);
		} else
			loadPlugin();
	}

    /**
     * Called whenever this plugin is being disabled
     *
     * @since 2.1.0
     */
	@Override
	public void onDisable() {
		for (var arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getPlayers() > 0)
				arena.stop();
		}
		
		if (StatManager.getInstance().getMySQLDatabase() == null)
			StatManager.getInstance().saveToFile();
		else
			StatManager.getInstance().saveToDatabase();

        if (!SettingsManager.getInstance().getRunnable().isCancelled())
            SettingsManager.getInstance().getRunnable().cancel();

        getLogger().info("BuildingGame has been disabled");

        instance = null;
	}

    /**
     * Loads the entire plugin
     *
     * @since 2.1.0
     */
	public void loadPlugin() {
		long start = System.currentTimeMillis();

		//this has to be done quite early
        Gui.registerProperty("particle-type", ParticleType::valueOf);
        Gui.registerProperty("biome", Biome::valueOf);
        Gui.registerProperty("dye-color", DyeColor::valueOf);
        Gui.registerProperty("material", Material::valueOf);
        Gui.registerProperty("response", ConfirmationMenu.Response::valueOf);
		
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this, false);
		
		getLogger().info("Loading arenas");
		ArenaManager.getInstance().setup();
		ArenaModeManager.getInstance().setup();
		BuildTimerManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		LobbyTimerManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
        MatchesManager.getInstance().setup();
		VoteTimerManager.getInstance().setup();
		WinTimerManager.getInstance().setup();
		
		getLogger().info("Loading plots");
		PlotManager.getInstance().setup();
		//has to be down here for some config stuff
        MaxPlayersManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		getLogger().info("Loading main spawn");
		MainSpawnManager.getInstance().setup();

        PluginManager pm = Bukkit.getPluginManager();

		getLogger().info("Loading soft dependencies");
		if (pm.isPluginEnabled("Vault"))
			SDVault.getInstance().setup();

        if (pm.isPluginEnabled("PlaceholderAPI")) {
            try {
                String version = pm.getPlugin("PlaceholderAPI").getDescription().getVersion();
                var number = Integer.parseInt(version.replace(".", ""));

                //Make sure every version has at least three parts (e.g. 2.9.0 instead of 2.9).
                //This ensures the versions don't get mixed up (e.g. 2.7.5 being bigger than 2.9).
                for (var i = version.split("\\.").length; i < 3; i++)
                    number *= 10;

                //290 is the first version with offline player support
                if (number >= 290) {
                    if (!new PlaceholderAPIPlaceholders().register())
                        getLogger().warning("Unable to register placeholders for PlaceholderAPI");
                } else
                    getLogger().warning(
                        "PlaceholderAPI is outdated, update to a later version to keep BuildingGame compatible with PlaceholderAPI."
                    );
            } catch (NumberFormatException e) {
                getLogger().warning(
                    "Unable to get PlaceholderAPI version, contact the plugin author about this."
                );
                e.printStackTrace();
            }
        }

        if (pm.isPluginEnabled("MVdWPlaceholderAPI")) {
            PlaceholderAPI.registerPlaceholder(this, "buildinggame_players", event ->
                String.valueOf(ArenaManager.getInstance().getArenas().stream().mapToInt(Arena::getPlayers).sum()));

            PlaceholderAPI.registerPlaceholder(this, "buildinggame_has_booster", event -> {
                YamlConfiguration messages = SettingsManager.getInstance().getMessages();

                var player = event.getPlayer();
                var falseMessage = messages.getString("placeholder-api.has-booster.result.false");

                if (player == null)
                    return falseMessage;

                return Booster.hasBooster(player) ?
                    messages.getString("placeholder-api.has-booster.result.true") : falseMessage;
            });

            PlaceholderAPI.registerPlaceholder(this, "buildinggame_booster_multiplier", event -> {
                var player = event.getPlayer();

                if (player == null)
                    return "0.0";

                return String.valueOf(Booster.getMultiplier(player));
            });

            PlaceholderAPI.registerPlaceholder(this, "buildinggame_booster_time_left", event -> {
                var player = event.getPlayer();

                if (player == null)
                    return "0";

                return String.valueOf(Booster.getBoosters(player).stream().mapToInt(Booster::getRemainingTime).max()
                    .orElse(0));
            });

            PlaceholderAPI.registerPlaceholder(this, "buildinggame_booster_activator", event -> {
                var player = event.getPlayer();

                if (player == null)
                    return "";

                var boosters = Booster.getBoosters(player);

                if (boosters.isEmpty())
                    return "";

                StringBuilder activators = new StringBuilder();
                boosters.stream().map(booster -> booster.getActivator().getName()).distinct().forEach(name -> activators
                    .append(name).append(", "));

                if (boosters.stream().map(booster -> booster.getActivator().getName()).distinct().count() == 1)
                    return activators.substring(0, activators.length() - 2);

                return activators.replace(activators.length() - 2, activators.length(), "").replace(activators
                    .lastIndexOf(", "), activators.lastIndexOf(", ") + 2, " and ").toString();
            });

            for (var statType : StatType.values()) {
                var name = statType.toString().toLowerCase(Locale.getDefault());

                PlaceholderAPI.registerPlaceholder(this, "buildinggame_stat_" + name, event -> {
                    Stat stat = StatManager.getInstance().getStat(event.getOfflinePlayer(), statType);

                    return stat == null ? "0" : String.valueOf(stat.getValue());
                });

                PlaceholderAPI.registerPlaceholder(this, "buildinggame_stat_" + name + "_top",
                    event -> {
                        List<Stat> stats = StatManager.getInstance().getStats(statType);

                        if (stats == null)
                            return "-1";

                        return String.valueOf(stats.get(0).getValue());
                    }
                );
            }
        }

		getLogger().info("Loading commands");
		if (!loadedCommands) {
            var manager = new BukkitCommandManager(this);

            //noinspection deprecation
            manager.enableUnstableAPI("help");

            //register contexts
            manager.getCommandContexts().registerContext(Arena.class, context -> {
                var arena = ArenaManager.getInstance().getArena(context.popFirstArg());

                if (arena == null)
                    throw new InvalidCommandArgument("This arena doesn't exist");

                return arena;
            });
            manager.getCommandContexts().registerContext(ArenaMode.class, context -> {
                var mode = ArenaMode.valueOf(context.popFirstArg().toUpperCase(Locale.getDefault()));

                if (mode == null)
                    throw new InvalidCommandArgument("This game mode doesn't exist");

                return mode;
            });
            manager.getCommandContexts().registerContext(StatType.class, context -> {
                var type = StatType.valueOf(context.popFirstArg().toUpperCase(Locale.getDefault()));

                if (type == null)
                    throw new InvalidCommandArgument("This statistic type doesn't exist");

                return type;
            });

            //register completions
            manager.getCommandCompletions().registerCompletion("arenas", context ->
                ArenaManager.getInstance().getArenas().stream()
                    .map(Arena::getName)
                    .collect(Collectors.toList()));
            manager.getCommandCompletions().registerCompletion("arenamodes", context ->
                Stream.of(ArenaMode.values())
                    .map(mode -> mode.toString().toUpperCase(Locale.getDefault()))
                    .collect(Collectors.toList()));
            manager.getCommandCompletions().registerCompletion("stattypes", context ->
                Stream.of(StatType.values()).map(Enum::toString).collect(Collectors.toList()));
            manager.getCommandCompletions().registerCompletion("holograms", context ->
                TopStatHologram.getHolograms().stream().map(TopStatHologram::getName).collect(Collectors.toList()));

            //register conditions
            manager.getCommandConditions().addCondition(String.class, "arenanotexist",
                (context, executionContext, string) -> {
                    if (ArenaManager.getInstance().getArena(string) != null || string.equals("main-spawn"))
                        throw new ConditionFailedException("Arena already exists");
                });
            //hd stands for Holographic Displays, but it's shorten to hd since the full name is a bit long
            manager.getCommandConditions().addCondition("hdenabled", context ->
                pm.isPluginEnabled("HolographicDisplays"));
            manager.registerCommand(new CommandManager());

            loadedCommands = true;
        }
		
		getLogger().info("Loading stats");
		StatManager.getInstance().setup();

		//loading achievements should happen after the statistics have been loaded
        Achievement.loadAchievements();

		getLogger().info("Loading listeners");
		if (!loadedListeners) {
			pm.registerEvents(new BlockBreak(), this);
			pm.registerEvents(new BlockDispenseItem(), this);
			pm.registerEvents(new BlockPlace(), this);
			pm.registerEvents(new JoinSignCreate(), this);
			pm.registerEvents(new LeaveSignCreate(), this);
			pm.registerEvents(new StatSignCreate(), this);
			pm.registerEvents(new SpectateSignCreate(), this);
			pm.registerEvents(new SignBreak(), this);
			pm.registerEvents(new LiquidFlow(), this);
			pm.registerEvents(new PistonBlockMove(), this);
			
			//starts the connection to bungeecord
            if (SettingsManager.getInstance().getConfig().getBoolean("bungeecord.enable"))
			    BungeeCordHandler.getInstance();

			//per world inventory compatibility fix
            if (pm.isPluginEnabled("PerWorldInventory")) {
                try {
                    String version = pm.getPlugin("PerWorldInventory").getDescription().getVersion();
                    var number = Integer.parseInt(version.replace(".", ""));

                    //Make sure every version has at least three parts (e.g. 1.11.0 instead of 1.11).
                    //This ensures the versions don't get mixed up (e.g. 1.7.5 being bigger than 1.11).
                    for (var i = version.split("\\.").length; i < 3; i++)
                        number *= 10;

                    //200 is the first version with the new package name
                    if (number >= 200)
                        pm.registerEvents(new PerWorldInventoryCancel(), this);
                    else
                        getLogger().warning(
                                "PerWorldInventory is outdated, update to a later version to keep BuildingGame compatible with PerWorldInventory."
                        );
                } catch (NumberFormatException e) {
                    getLogger().warning(
                            "Unable to get PerWorldInventory version, contact the plugin author about this."
                    );
                    e.printStackTrace();
                }
            }

            if (pm.isPluginEnabled("WorldEdit"))
                WorldEdit.getInstance().getEventBus().register(new WorldEditBoundaryAssertion());

			pm.registerEvents(new ClickJoinSign(), this);
			pm.registerEvents(new ClickLeaveSign(), this);
			pm.registerEvents(new ClickSpectateSign(), this);
			pm.registerEvents(new Drop(), this);
			pm.registerEvents(new Interact(), this);
			pm.registerEvents(new Leave(), this);
			pm.registerEvents(new Move(), this);
			pm.registerEvents(new PlaceBucket(), this);
			pm.registerEvents(new PlaceIgnoreSpectators(), this);
			if (SettingsManager.getInstance().getConfig().getBoolean("chat.adjust"))
				pm.registerEvents(new Chat(), this);
			pm.registerEvents(new CommandBlocker(), this);
			pm.registerEvents(new EntityDamage(), this);
			pm.registerEvents(new TakeDamage(), this);
			pm.registerEvents(new LoseFood(), this);
			
			//entity events
			pm.registerEvents(new ChickenSpawnByEgg(), this);
			pm.registerEvents(new EntityExplode(), this);
			pm.registerEvents(new EntityOptionsMenu(), this);
			pm.registerEvents(new EntitySpawn(), this);

			//scoreboards
			pm.registerEvents(new MainScoreboardJoinShow(), this);
			pm.registerEvents(new MainScoreboardWorldChange(), this);
			
			//stats
			//saved
			pm.registerEvents(new BreakStat(), this);
			pm.registerEvents(new FirstStat(), this);
			pm.registerEvents(new PlaceStat(), this);
			pm.registerEvents(new PlaysStat(), this);
			pm.registerEvents(new SecondStat(), this);
			pm.registerEvents(new ThirdStat(), this);
			//unsaved
			pm.registerEvents(new UnsavedStatsPlace(), this);
			
			//structure
			pm.registerEvents(new TreeGrow(), this);
		
			if (StatManager.getInstance().getMySQLDatabase() != null) {
				pm.registerEvents(new JoinPlayerStats(), this);
				pm.registerEvents(new QuitPlayerStats(), this);
			}
			
			loadedListeners = true;
		}
		
		getLogger().info("Loading signs");
		SignManager.getInstance().setup();
		
		getLogger().info("Loading timer");
		new ParticleRender().runTaskTimer(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimer(this, 0L, SettingsManager.getInstance().getConfig()
                .getLong("scoreboard-update-delay"));
		new StatSaveTimer().runTaskTimerAsynchronously(this, 0L, SettingsManager.getInstance().getConfig()
                .getLong("stats.save-delay"));
		new EntityTimer().runTaskTimer(this, 0L, 20L);
		new StatSignUpdater().runTaskTimerAsynchronously(this, 0L, 1L);
		
		long end = System.currentTimeMillis();

		long duration = end - start;
		String time;

		if (duration < 1000) {
		    time = duration + " milliseconds";
        } else if (duration < 60000) {
		    time = duration / 1000.0 + " seconds";
        } else {
		    time = (duration / 60) + ":" + (duration % 60) / 1000.0 + " minutes";
        }

		getLogger().info("BuildingGame has been enabled in " + time + '!');
	}

    /**
     * Returns an instance of this plugin for the singleton principle
     *
     * @return an instance of this plugin
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    public static Main getInstance() {
		return instance;
	}
}