package com.gmail.stefvanschiedev.buildinggame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.events.block.BlockBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockPlace;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.block.LeaveSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntityExplode;
import com.gmail.stefvanschiedev.buildinggame.events.entity.EntitySpawn;
import com.gmail.stefvanschiedev.buildinggame.events.player.BonemealEvent;
import com.gmail.stefvanschiedev.buildinggame.events.player.CommandBlocker;
import com.gmail.stefvanschiedev.buildinggame.events.player.Drop;
import com.gmail.stefvanschiedev.buildinggame.events.player.EntityDamage;
import com.gmail.stefvanschiedev.buildinggame.events.player.Leave;
import com.gmail.stefvanschiedev.buildinggame.events.player.LoseFood;
import com.gmail.stefvanschiedev.buildinggame.events.player.Move;
import com.gmail.stefvanschiedev.buildinggame.events.player.PlaceBucket;
import com.gmail.stefvanschiedev.buildinggame.events.player.TakeDamage;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.CloseMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.OptionsMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.floor.FloorClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.FoodHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.HeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.AngryVillagerClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.ClearParticlesClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.EnchantmentClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.FlamesClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.HappyVillagerClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.HeartsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.LavaDripClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.MagicCritClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.ParticleBackClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.ParticleClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.RedstoneMagicClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.SmokeClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.SnowballPoofClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.SpellClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle.WaterDripClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.rain.RainClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.Speed1Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.Speed2Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.Speed3Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.Speed4Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.Speed5Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.SpeedBackClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.speed.SpeedClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.AM10Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.AM2Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.AM4Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.AM6Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.AM8Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.MiddayClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.MidnightClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.PM10Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.PM2Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.PM4Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.PM6Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.PM8Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.TimeBackClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.time.TimeClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.CloseSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.ExitSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.NextPage;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.OpenSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.PreviousPage;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu.VoteSubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.teamselection.OpenTeamSelection;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.teamselection.TeamClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickJoinSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickLeaveSign;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.Interact;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.InventoryMove;
import com.gmail.stefvanschiedev.buildinggame.events.player.voting.VoteEvent;
import com.gmail.stefvanschiedev.buildinggame.events.stats.unsaved.blocksplaced.UnsavedStatsPlace;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaModeManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MinPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.commands.CommandManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDBarApi;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.timers.LoadCooldown;
import com.gmail.stefvanschiedev.buildinggame.timers.ParticleRender;
import com.gmail.stefvanschiedev.buildinggame.timers.ScoreboardUpdater;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class Main extends JavaPlugin {

	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getLogger().info("Waiting until other plugins are loaded");
		
		new LoadCooldown().runTaskTimer(this, 20L, 20L);
	}
	
	public void onDisable() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getPlayers() > 0) {
				arena.stop();
			}
		}
		
		getLogger().info("BuildingGame has been disabled");
		
		instance = null;
	}
	
	public void loadPlugin() {
		long start = System.currentTimeMillis();
		
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this);
		
		getLogger().info("Loading arenas");
		ArenaManager.getInstance().setup();
		ArenaModeManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		SignManager.getInstance().setup();
		
		getLogger().info("Loading plots");
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		getLogger().info("Loading main spawn");
		MainSpawnManager.getInstance().setup();
		
		getLogger().info("Loading soft dependencies");
		if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
			SDBarApi.getInstance().setup();
		}
		if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			SDVault.getInstance().setup();
		}
		
		getLogger().info("Loading listeners");
		Bukkit.getPluginManager().registerEvents(new VoteEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinSignBreak(), this);
		Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveSignCreate(), this);
		Bukkit.getPluginManager().registerEvents(new ClickJoinSign(), this);
		Bukkit.getPluginManager().registerEvents(new ClickLeaveSign(), this);
		Bukkit.getPluginManager().registerEvents(new Drop(), this);
		Bukkit.getPluginManager().registerEvents(new Interact(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryMove(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
		Bukkit.getPluginManager().registerEvents(new Leave(), this);
		Bukkit.getPluginManager().registerEvents(new Move(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceBucket(), this);
		Bukkit.getPluginManager().registerEvents(new BonemealEvent(), this);
		Bukkit.getPluginManager().registerEvents(new CommandBlocker(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
		Bukkit.getPluginManager().registerEvents(new TakeDamage(), this);
		Bukkit.getPluginManager().registerEvents(new LoseFood(), this);
		
		//entity events
		Bukkit.getPluginManager().registerEvents(new EntityExplode(), this);
		Bukkit.getPluginManager().registerEvents(new EntitySpawn(), this);
		
		//gui, long long list... :(
		//going from top to bottom
		//options menu
		Bukkit.getPluginManager().registerEvents(new CloseMenu(), this);
		Bukkit.getPluginManager().registerEvents(new OptionsMenu(), this);
		//floor
		Bukkit.getPluginManager().registerEvents(new FloorClick(), this);
		//heads
		Bukkit.getPluginManager().registerEvents(new HeadsClick(), this);
		Bukkit.getPluginManager().registerEvents(new FoodHeadsClick(), this);
		//particles
		Bukkit.getPluginManager().registerEvents(new AngryVillagerClick(), this);
		Bukkit.getPluginManager().registerEvents(new ClearParticlesClick(), this);
		Bukkit.getPluginManager().registerEvents(new EnchantmentClick(), this);
		Bukkit.getPluginManager().registerEvents(new FlamesClick(), this);
		Bukkit.getPluginManager().registerEvents(new HappyVillagerClick(), this);
		Bukkit.getPluginManager().registerEvents(new HeartsClick(), this);
		Bukkit.getPluginManager().registerEvents(new LavaDripClick(), this);
		Bukkit.getPluginManager().registerEvents(new MagicCritClick(), this);
		Bukkit.getPluginManager().registerEvents(new ParticleBackClick(), this);
		Bukkit.getPluginManager().registerEvents(new ParticleClick(), this);
		Bukkit.getPluginManager().registerEvents(new RedstoneMagicClick(), this);
		Bukkit.getPluginManager().registerEvents(new SmokeClick(), this);
		Bukkit.getPluginManager().registerEvents(new SnowballPoofClick(), this);
		Bukkit.getPluginManager().registerEvents(new SpellClick(), this);
		Bukkit.getPluginManager().registerEvents(new WaterDripClick(), this);
		//rain
		Bukkit.getPluginManager().registerEvents(new RainClick(), this);
		//speed
		Bukkit.getPluginManager().registerEvents(new Speed1Click(), this);
		Bukkit.getPluginManager().registerEvents(new Speed2Click(), this);
		Bukkit.getPluginManager().registerEvents(new Speed3Click(), this);
		Bukkit.getPluginManager().registerEvents(new Speed4Click(), this);
		Bukkit.getPluginManager().registerEvents(new Speed5Click(), this);
		Bukkit.getPluginManager().registerEvents(new SpeedBackClick(), this);
		Bukkit.getPluginManager().registerEvents(new SpeedClick(), this);
		//time
		Bukkit.getPluginManager().registerEvents(new AM10Click(), this);
		Bukkit.getPluginManager().registerEvents(new AM2Click(), this);
		Bukkit.getPluginManager().registerEvents(new AM4Click(), this);
		Bukkit.getPluginManager().registerEvents(new AM6Click(), this);
		Bukkit.getPluginManager().registerEvents(new AM8Click(), this);
		Bukkit.getPluginManager().registerEvents(new MiddayClick(), this);
		Bukkit.getPluginManager().registerEvents(new MidnightClick(), this);
		Bukkit.getPluginManager().registerEvents(new PM10Click(), this);
		Bukkit.getPluginManager().registerEvents(new PM2Click(), this);
		Bukkit.getPluginManager().registerEvents(new PM4Click(), this);
		Bukkit.getPluginManager().registerEvents(new PM6Click(), this);
		Bukkit.getPluginManager().registerEvents(new PM8Click(), this);
		Bukkit.getPluginManager().registerEvents(new TimeBackClick(), this);
		Bukkit.getPluginManager().registerEvents(new TimeClick(), this);
		
		//subjectmenu
		Bukkit.getPluginManager().registerEvents(new CloseSubjectMenu(), this);
		Bukkit.getPluginManager().registerEvents(new ExitSubjectMenu(), this);
		Bukkit.getPluginManager().registerEvents(new NextPage(), this);
		Bukkit.getPluginManager().registerEvents(new OpenSubjectMenu(), this);
		Bukkit.getPluginManager().registerEvents(new PreviousPage(), this);
		Bukkit.getPluginManager().registerEvents(new VoteSubjectMenu(), this);
		
		Bukkit.getPluginManager().registerEvents(new OpenTeamSelection(), this);
		Bukkit.getPluginManager().registerEvents(new TeamClick(), this);
		
		Bukkit.getPluginManager().registerEvents(new UnsavedStatsPlace(), this);
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getLogger().info("Loading timer");
		new ParticleRender().runTaskTimer(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimer(this, 0L, SettingsManager.getInstance().getConfig().getLong("scoreboard-update-delay"));
		
		//getLogger().info("Loading bungeecord support");
		//getServer().getMessenger().registerOutgoingPluginChannel(Main.getInstance(), "BungeeCord");
		
		getCommand("bg").setExecutor(command);
		getCommand("buildinggame").setExecutor(command);
		
		long end = System.currentTimeMillis();
		
		getLogger().info("BuildingGame has been enabled in " + (end - start) + " milliseconds!");
		
	}
	
	public static Main getInstance() {
		return instance;
	}
}
