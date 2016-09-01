package com.gmail.stefvanschiedev.buildinggame;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.events.block.BlockBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockPlace;
import com.gmail.stefvanschiedev.buildinggame.events.block.LiquidFlow;
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
import com.gmail.stefvanschiedev.buildinggame.events.player.EntitySpawnByHuman;
import com.gmail.stefvanschiedev.buildinggame.events.player.Leave;
import com.gmail.stefvanschiedev.buildinggame.events.player.LeaveClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.LoseFood;
import com.gmail.stefvanschiedev.buildinggame.events.player.Move;
import com.gmail.stefvanschiedev.buildinggame.events.player.PlaceBucket;
import com.gmail.stefvanschiedev.buildinggame.events.player.TakeDamage;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.GuiRemove;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.CloseMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.OptionsMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.floor.FloorClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.AlphabetHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.BlocksHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.CharactersHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.ColorsHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.DevicesHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.FoodHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.GamesHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.HeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.InteriorHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.MiscHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.MobsHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.PokemonHeadsClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.alphabet.AlphabetHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.alphabet.AlphabetHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.alphabet.AlphabetHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.blocks.BlocksHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.blocks.BlocksHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.blocks.BlocksHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.characters.CharactersHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.characters.CharactersHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.characters.CharactersHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.colors.ColorsHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.colors.ColorsHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.devices.DevicesHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.devices.DevicesHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.devices.DevicesHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.food.FoodHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.food.FoodHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.food.FoodHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.games.GamesHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.games.GamesHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.interior.InteriorHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.interior.InteriorHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.interior.InteriorHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.misc.MiscHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.misc.MiscHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.misc.MiscHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.mobs.MobsHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.mobs.MobsHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.mobs.MobsHeadsSkullClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.pokemon.PokemonHeadsCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.pokemon.PokemonHeadsPageClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.pokemon.PokemonHeadsSkullClick;
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
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.OpenSpectatorMenu;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.SpectateCloseClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeed1Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeed2Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeed3Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeed4Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeed5Click;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeedBackClick;
import com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed.SpectateSpeedClick;
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
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardJoinShow;
import com.gmail.stefvanschiedev.buildinggame.events.scoreboards.MainScoreboardWorldChange;
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
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDBarApi;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
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
		
		if (!Bukkit.getBukkitVersion().split("\\.")[1].substring(0, 1).equals("8")) {
			getLogger().info("Incorrect Bukkit/Spigot version, not loading plugin");
			return;
		}
		
		getLogger().info("Loading metrics");
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			getLogger().info("Couldn't enable metrics");
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
		if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
			SDBarApi.getInstance().setup();
		}
		if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			SDVault.getInstance().setup();
		}
		
		getLogger().info("Loading listeners");
		if (!loadedListeners) {
			PluginManager pm = Bukkit.getPluginManager();
			
			pm.registerEvents(new VoteEvent(), this);
			pm.registerEvents(new JoinSignBreak(), this);
			pm.registerEvents(new JoinSignCreate(), this);
			pm.registerEvents(new LeaveSignCreate(), this);
			pm.registerEvents(new StatSignCreate(), this);
			pm.registerEvents(new StatSignBreak(), this);
			pm.registerEvents(new LiquidFlow(), this);
			
			pm.registerEvents(new ClickJoinSign(), this);
			pm.registerEvents(new ClickLeaveSign(), this);
			pm.registerEvents(new Drop(), this);
			pm.registerEvents(new Interact(), this);
			pm.registerEvents(new InventoryMove(), this);
			pm.registerEvents(new BlockBreak(), this);
			pm.registerEvents(new BlockPlace(), this);
			pm.registerEvents(new Leave(), this);
			pm.registerEvents(new Move(), this);
			pm.registerEvents(new PlaceBucket(), this);
			pm.registerEvents(new Chat(), this);
			pm.registerEvents(new CommandBlocker(), this);
			pm.registerEvents(new EntityDamage(), this);
			pm.registerEvents(new EntitySpawnByHuman(), this);
			pm.registerEvents(new TakeDamage(), this);
			pm.registerEvents(new LoseFood(), this);
			
			//bungeecord
			if (pm.isPluginEnabled("SocketAPI"))
				pm.registerEvents(new ReceiveMessage(), this);
			
			//entity events
			pm.registerEvents(new ChickenSpawnByEgg(), this);
			pm.registerEvents(new EntityExplode(), this);
			pm.registerEvents(new EntitySpawn(), this);
			
			//gui, long long list... :(
			//going from top to bottom
			pm.registerEvents(new GuiRemove(), this);
			
			//options menu
			pm.registerEvents(new CloseMenu(), this);
			pm.registerEvents(new OptionsMenu(), this);
			//floor
			pm.registerEvents(new FloorClick(), this);
			//heads
			pm.registerEvents(new HeadsClick(), this);
			
			pm.registerEvents(new AlphabetHeadsClick(), this);
			pm.registerEvents(new BlocksHeadsClick(), this);
			pm.registerEvents(new CharactersHeadsClick(), this);
			pm.registerEvents(new ColorsHeadsClick(), this);
			pm.registerEvents(new DevicesHeadsClick(), this);
			pm.registerEvents(new FoodHeadsClick(), this);
			pm.registerEvents(new GamesHeadsClick(), this);
			pm.registerEvents(new InteriorHeadsClick(), this);
			pm.registerEvents(new MiscHeadsClick(), this);
			pm.registerEvents(new MobsHeadsClick(), this);
			pm.registerEvents(new PokemonHeadsClick(), this);
		
			pm.registerEvents(new AlphabetHeadsCloseClick(), this);
			pm.registerEvents(new AlphabetHeadsPageClick(), this);
			pm.registerEvents(new AlphabetHeadsSkullClick(), this);
		
			pm.registerEvents(new BlocksHeadsCloseClick(), this);
			pm.registerEvents(new BlocksHeadsPageClick(), this);
			pm.registerEvents(new BlocksHeadsSkullClick(), this);
		
			pm.registerEvents(new CharactersHeadsCloseClick(), this);
			pm.registerEvents(new CharactersHeadsPageClick(), this);
			pm.registerEvents(new CharactersHeadsSkullClick(), this);
		
			pm.registerEvents(new ColorsHeadsCloseClick(), this);
			pm.registerEvents(new ColorsHeadsSkullClick(), this);
		
			pm.registerEvents(new DevicesHeadsCloseClick(), this);
			pm.registerEvents(new DevicesHeadsPageClick(), this);
			pm.registerEvents(new DevicesHeadsSkullClick(), this);
		
			pm.registerEvents(new FoodHeadsCloseClick(), this);
			pm.registerEvents(new FoodHeadsPageClick(), this);
			pm.registerEvents(new FoodHeadsSkullClick(), this);
		
			pm.registerEvents(new GamesHeadsCloseClick(), this);
			pm.registerEvents(new GamesHeadsSkullClick(), this);
		
			pm.registerEvents(new InteriorHeadsCloseClick(), this);
			pm.registerEvents(new InteriorHeadsPageClick(), this);
			pm.registerEvents(new InteriorHeadsSkullClick(), this);
		
			pm.registerEvents(new MiscHeadsCloseClick(), this);
			pm.registerEvents(new MiscHeadsPageClick(), this);
			pm.registerEvents(new MiscHeadsSkullClick(), this);
		
			pm.registerEvents(new MobsHeadsCloseClick(), this);
			pm.registerEvents(new MobsHeadsPageClick(), this);
			pm.registerEvents(new MobsHeadsSkullClick(), this);
			
			pm.registerEvents(new PokemonHeadsCloseClick(), this);
			pm.registerEvents(new PokemonHeadsPageClick(), this);
			pm.registerEvents(new PokemonHeadsSkullClick(), this);
			//particles
			pm.registerEvents(new AngryVillagerClick(), this);
			pm.registerEvents(new ClearParticlesClick(), this);
			pm.registerEvents(new EnchantmentClick(), this);
			pm.registerEvents(new FlamesClick(), this);
			pm.registerEvents(new HappyVillagerClick(), this);
			pm.registerEvents(new HeartsClick(), this);
			pm.registerEvents(new LavaDripClick(), this);
			pm.registerEvents(new MagicCritClick(), this);
			pm.registerEvents(new ParticleBackClick(), this);
			pm.registerEvents(new ParticleClick(), this);
			pm.registerEvents(new RedstoneMagicClick(), this);
			pm.registerEvents(new SmokeClick(), this);
			pm.registerEvents(new SnowballPoofClick(), this);
			pm.registerEvents(new SpellClick(), this);
			pm.registerEvents(new WaterDripClick(), this);
			//rain
			pm.registerEvents(new RainClick(), this);
			//speed
			pm.registerEvents(new Speed1Click(), this);
			pm.registerEvents(new Speed2Click(), this);
			pm.registerEvents(new Speed3Click(), this);
			pm.registerEvents(new Speed4Click(), this);
			pm.registerEvents(new Speed5Click(), this);
			pm.registerEvents(new SpeedBackClick(), this);
			pm.registerEvents(new SpeedClick(), this);
			//time
			pm.registerEvents(new AM10Click(), this);
			pm.registerEvents(new AM2Click(), this);
			pm.registerEvents(new AM4Click(), this);
			pm.registerEvents(new AM6Click(), this);
			pm.registerEvents(new AM8Click(), this);
			pm.registerEvents(new MiddayClick(), this);
			pm.registerEvents(new MidnightClick(), this);
			pm.registerEvents(new PM10Click(), this);
			pm.registerEvents(new PM2Click(), this);
			pm.registerEvents(new PM4Click(), this);
			pm.registerEvents(new PM6Click(), this);
			pm.registerEvents(new PM8Click(), this);
			pm.registerEvents(new TimeBackClick(), this);
			pm.registerEvents(new TimeClick(), this);
		
			//spectator menu
			pm.registerEvents(new OpenSpectatorMenu(), this);
			pm.registerEvents(new SpectateCloseClick(), this);
			pm.registerEvents(new SpectateSpeed1Click(), this);
			pm.registerEvents(new SpectateSpeed2Click(), this);
			pm.registerEvents(new SpectateSpeed3Click(), this);
			pm.registerEvents(new SpectateSpeed4Click(), this);
			pm.registerEvents(new SpectateSpeed5Click(), this);
			pm.registerEvents(new SpectateSpeedBackClick(), this);
			pm.registerEvents(new SpectateSpeedClick(), this);
			
			//subjectmenu
			pm.registerEvents(new CloseSubjectMenu(), this);
			pm.registerEvents(new ExitSubjectMenu(), this);
			pm.registerEvents(new NextPage(), this);
			pm.registerEvents(new OpenSubjectMenu(), this);
			pm.registerEvents(new PreviousPage(), this);
			pm.registerEvents(new VoteSubjectMenu(), this);
		
			pm.registerEvents(new OpenTeamSelection(), this);
			pm.registerEvents(new TeamClick(), this);
		
			//spectator
			pm.registerEvents(new LeaveClick(), this);
			
			//scoreboard
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
		
			loadedListeners = true;
		}
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getLogger().info("Loading stats");
		StatManager.getInstance().setup();
		
		getLogger().info("Loading signs");
		SignManager.getInstance().setup();
		
		getLogger().info("Loading timer");
		new ParticleRender().runTaskTimerAsynchronously(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimer(this, 0L, SettingsManager.getInstance().getConfig().getLong("scoreboard-update-delay"));
		new StatSaveTimer().runTaskLaterAsynchronously(this, SettingsManager.getInstance().getConfig().getLong("stats.save-delay"));
		
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