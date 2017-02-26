package com.gmail.stefvanschiedev.buildinggame;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.events.block.BlockBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockDispenseItem;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockPlace;
import com.gmail.stefvanschiedev.buildinggame.events.block.LiquidFlow;
import com.gmail.stefvanschiedev.buildinggame.events.block.PistonBlockMove;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.JoinSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.JoinSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.LeaveSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.StatSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.signs.StatSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.bungeecord.ReceiveMessage;
import com.gmail.stefvanschiedev.buildinggame.events.entity.ChickenSpawnByEgg;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntityExplode;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntitySpawn;
import com.gmail.stefvanschiedev.buildinggame.events.player.Chat;
import com.gmail.stefvanschiedev.buildinggame.events.player.CommandBlocker;
import com.gmail.stefvanschiedev.buildinggame.events.player.Drop;
import com.gmail.stefvanschiedev.buildinggame.events.player.EntityDamage;
import com.gmail.stefvanschiedev.buildinggame.events.player.Leave;
import com.gmail.stefvanschiedev.buildinggame.events.player.LeaveClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.LoseFood;
import com.gmail.stefvanschiedev.buildinggame.events.player.Move;
import com.gmail.stefvanschiedev.buildinggame.events.player.PlaceBucket;
import com.gmail.stefvanschiedev.buildinggame.events.player.TakeDamage;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.GuiRemove;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.OptionsMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.OpenSpectatorMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.CloseSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.OpenSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.teamselection.OpenTeamSelection;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickJoinSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickLeaveSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.Interact;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.InventoryMove;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.VoteEvent;
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardJoinShow;
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardWorldChange;
import com.gmail.stefvanschiedev.buildinggame.events.stats.database.JoinPlayerStats;
import com.gmail.stefvanschiedev.buildinggame.events.stats.database.QuitPlayerStats;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.BreakStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.FirstStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.MoveStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.PlaceStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.PlaysStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.SecondStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.saved.ThirdStat;
import com.gmail.stefvanschiedev.buildinggame.events.stats.unsaved.UnsavedStatsPlace;
import com.gmail.stefvanschiedev.buildinggame.events.structure.TreeGrow;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaModeManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.BuildTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MinPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.VoteTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.WinTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.commands.CommandManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.timers.EntityTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.LoadCooldown;
import com.gmail.stefvanschiedev.buildinggame.timers.ParticleRender;
import com.gmail.stefvanschiedev.buildinggame.timers.ScoreboardUpdater;
import com.gmail.stefvanschiedev.buildinggame.timers.StatSaveTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.metrics.Metrics;

public class Main extends JavaPlugin {

	private static Main instance;
	private LoadCooldown load = new LoadCooldown();
	private boolean loadedListeners = false;
	private boolean loadedCommands = false;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this, true);
		
		if (!Bukkit.getBukkitVersion().split("\\.")[1].substring(0, 1).equals("9")) {
			getLogger().info("Incorrect Bukkit/Spigot version, not loading plugin.");
			return;
		}

		//loading metrics
		getLogger().info("Loading metrics");
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			getLogger().info("Couldn't enable Metrics");
		}
		
		if (SettingsManager.getInstance().getConfig().getBoolean("loading.load-after-plugins")) {
			getLogger().info("Waiting until other plugins are loaded");
		
			load.runTaskTimer(this, 20L, 20L);
		} else
			loadPlugin();
	}
	
	public void onDisable() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getPlayers() > 0) {
				arena.stop();
			}
		}
		
		if (StatManager.getInstance().getMySQLDatabase() == null)
			StatManager.getInstance().saveToFile();
		else
			StatManager.getInstance().saveToDatabase();
		
		getLogger().info("BuildingGame has been disabled");
		
		instance = null;
	}
	
	public void loadPlugin() {
		long start = System.currentTimeMillis();
		
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this, false);
		
		getLogger().info("Loading arenas");
		ArenaManager.getInstance().setup();
		ArenaModeManager.getInstance().setup();
		BuildTimerManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		LobbyTimerManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		VoteTimerManager.getInstance().setup();
		WinTimerManager.getInstance().setup();
		
		getLogger().info("Loading plots");
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		getLogger().info("Loading main spawn");
		MainSpawnManager.getInstance().setup();
		
		getLogger().info("Loading soft dependencies");
		if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			SDVault.getInstance().setup();
		}
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getLogger().info("Loading stats");
		StatManager.getInstance().setup();
		
		getLogger().info("Loading listeners");
		if (!loadedListeners) {
			PluginManager pm = Bukkit.getPluginManager();
			
			pm.registerEvents(new BlockBreak(), this);
			pm.registerEvents(new BlockDispenseItem(), this);
			pm.registerEvents(new BlockPlace(), this);
			pm.registerEvents(new VoteEvent(), this);
			pm.registerEvents(new JoinSignBreak(), this);
			pm.registerEvents(new JoinSignCreate(), this);
			pm.registerEvents(new LeaveSignCreate(), this);
			pm.registerEvents(new StatSignCreate(), this);
			pm.registerEvents(new StatSignBreak(), this);
			pm.registerEvents(new LiquidFlow(), this);
			pm.registerEvents(new PistonBlockMove(), this);
			
			//bungeecord
			if (pm.isPluginEnabled("SocketAPI"))
				pm.registerEvents(new ReceiveMessage(), this);
			
			pm.registerEvents(new ClickJoinSign(), this);
			pm.registerEvents(new ClickLeaveSign(), this);
			pm.registerEvents(new Drop(), this);
			pm.registerEvents(new Interact(), this);
			pm.registerEvents(new InventoryMove(), this);
			pm.registerEvents(new Leave(), this);
			pm.registerEvents(new Move(), this);
			pm.registerEvents(new PlaceBucket(), this);
			if (SettingsManager.getInstance().getConfig().getBoolean("chat.adjust"))
				pm.registerEvents(new Chat(), this);
			pm.registerEvents(new CommandBlocker(), this);
			pm.registerEvents(new EntityDamage(), this);
			pm.registerEvents(new TakeDamage(), this);
			pm.registerEvents(new LoseFood(), this);
			
			//entity events
			pm.registerEvents(new ChickenSpawnByEgg(), this);
			pm.registerEvents(new EntityExplode(), this);
			pm.registerEvents(new EntitySpawn(), this);
			
			//gui
			pm.registerEvents(new GuiRemove(), this);
			
			//options menu
			pm.registerEvents(new OptionsMenu(), this);
		
			//spectator menu
			pm.registerEvents(new OpenSpectatorMenu(), this);
			
			//subjectmenu
			pm.registerEvents(new CloseSubjectMenu(), this);
			pm.registerEvents(new OpenSubjectMenu(), this);
		
			pm.registerEvents(new OpenTeamSelection(), this);
		
			//spectator
			pm.registerEvents(new LeaveClick(), this);

			//scoreboards
			pm.registerEvents(new MainScoreboardJoinShow(), this);
			pm.registerEvents(new MainScoreboardWorldChange(), this);
			
			//stats
			//saved
			pm.registerEvents(new BreakStat(), this);
			pm.registerEvents(new FirstStat(), this);
			pm.registerEvents(new MoveStat(), this);
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
		new ParticleRender().runTaskTimerAsynchronously(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimer(this, 0L, SettingsManager.getInstance().getConfig().getLong("scoreboard-update-delay"));
		new StatSaveTimer().runTaskTimerAsynchronously(this, 0L, SettingsManager.getInstance().getConfig().getLong("stats.save-delay"));
		new EntityTimer().runTaskTimerAsynchronously(this, 0L, 1L);
		
		if (!loadedCommands) {
			getCommand("bg").setExecutor(command);
			getCommand("buildinggame").setExecutor(command);
			
			loadedCommands = true;
		}
		
		long end = System.currentTimeMillis();
		
		getLogger().info("BuildingGame has been enabled in " + (end - start) + " milliseconds!");
		
	}
	
	public static Main getInstance() {
		return instance;
	}
}