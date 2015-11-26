package me.stefvanschie.buildinggame;

import me.stefvanschie.buildinggame.events.block.BlockBreak;
import me.stefvanschie.buildinggame.events.block.BlockPlace;
import me.stefvanschie.buildinggame.events.block.JoinSignBreak;
import me.stefvanschie.buildinggame.events.block.JoinSignCreate;
import me.stefvanschie.buildinggame.events.block.LeaveSignCreate;
import me.stefvanschie.buildinggame.events.entity.EntityExplode;
import me.stefvanschie.buildinggame.events.player.BonemealEvent;
import me.stefvanschie.buildinggame.events.player.CommandBlocker;
import me.stefvanschie.buildinggame.events.player.Drop;
import me.stefvanschie.buildinggame.events.player.EntityDamage;
import me.stefvanschie.buildinggame.events.player.Leave;
import me.stefvanschie.buildinggame.events.player.LoseFood;
import me.stefvanschie.buildinggame.events.player.Move;
import me.stefvanschie.buildinggame.events.player.PlaceBucket;
import me.stefvanschie.buildinggame.events.player.TakeDamage;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.CloseMenu;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.OptionsMenu;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.floor.FloorClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.AngryVillagerClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.ClearParticlesClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.EnchantmentClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.FlamesClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.HappyVillagerClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.HeartsClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.LavaDripClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.MagicCritClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.ParticleBackClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.ParticleClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.RedstoneMagicClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.SmokeClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.SnowballPoofClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.SpellClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.particle.WaterDripClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.rain.RainClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.Speed1Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.Speed2Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.Speed3Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.Speed4Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.Speed5Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.SpeedBackClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.speed.SpeedClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.AM10Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.AM2Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.AM4Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.AM6Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.AM8Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.MiddayClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.MidnightClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.PM10Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.PM2Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.PM4Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.PM6Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.PM8Click;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.TimeBackClick;
import me.stefvanschie.buildinggame.events.player.gui.buildmenu.time.TimeClick;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.CloseSubjectMenu;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.ExitSubjectMenu;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.NextPage;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.OpenSubjectMenu;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.PreviousPage;
import me.stefvanschie.buildinggame.events.player.gui.subjectmenu.VoteSubjectMenu;
import me.stefvanschie.buildinggame.events.player.signs.ClickJoinSign;
import me.stefvanschie.buildinggame.events.player.signs.ClickLeaveSign;
import me.stefvanschie.buildinggame.events.player.voting.Interact;
import me.stefvanschie.buildinggame.events.player.voting.InventoryMove;
import me.stefvanschie.buildinggame.events.player.voting.VoteEvent;
import me.stefvanschie.buildinggame.events.stats.unsaved.blocksplaced.UnsavedStatsPlace;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.LobbyManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.arenas.MinPlayersManager;
import me.stefvanschie.buildinggame.managers.arenas.SignManager;
import me.stefvanschie.buildinggame.managers.commands.CommandManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.mainspawn.MainSpawnManager;
import me.stefvanschie.buildinggame.managers.plots.BoundaryManager;
import me.stefvanschie.buildinggame.managers.plots.FloorManager;
import me.stefvanschie.buildinggame.managers.plots.LocationManager;
import me.stefvanschie.buildinggame.managers.plots.PlotManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDBarApi;
import me.stefvanschie.buildinggame.managers.softdependencies.SDVault;
import me.stefvanschie.buildinggame.timers.ParticleRender;
import me.stefvanschie.buildinggame.timers.ScoreboardUpdater;
import me.stefvanschie.buildinggame.utils.Arena;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		long start = System.currentTimeMillis();
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this);
		
		getLogger().info("Loading arenas");
		ArenaManager.getInstance().setup();
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
		
		//gui, long long list... :(
		//going from top to bottom
		//options menu
		Bukkit.getPluginManager().registerEvents(new CloseMenu(), this);
		Bukkit.getPluginManager().registerEvents(new OptionsMenu(), this);
		//floor
		Bukkit.getPluginManager().registerEvents(new FloorClick(), this);
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
		
		Bukkit.getPluginManager().registerEvents(new UnsavedStatsPlace(), this);
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getLogger().info("Loading timer");
		new ParticleRender().runTaskTimer(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimer(this, 0L, SettingsManager.getInstance().getConfig().getLong("scoreboard-update-delay"));
		
		getCommand("bg").setExecutor(command);
		getCommand("buildinggame").setExecutor(command);
		
		long end = System.currentTimeMillis();
		
		getLogger().info("BuildingGame has been enabled in " + (end - start) + " milliseconds!");
		
	}
	
	public void onDisable() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			arena.stop();
		}
		getLogger().info("BuildingGame has been disabled");
		
		instance = null;
	}
	
	public static Main getInstance() {
		return instance;
	}
}
