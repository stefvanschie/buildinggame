package com.gmail.stefvanschiedev.buildinggame;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.events.block.BlockBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.BlockPlace;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.block.LeaveSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.block.LiquidFlow;
import com.gmail.stefvanschiedev.buildinggame.events.bungeecord.ReceiveMessage;
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
		SignManager.getInstance().setup();
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
			Bukkit.getPluginManager().registerEvents(new VoteEvent(), this);
			Bukkit.getPluginManager().registerEvents(new JoinSignBreak(), this);
			Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), this);
			Bukkit.getPluginManager().registerEvents(new LeaveSignCreate(), this);
			Bukkit.getPluginManager().registerEvents(new LiquidFlow(), this);
			
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
			Bukkit.getPluginManager().registerEvents(new Chat(), this);
			Bukkit.getPluginManager().registerEvents(new CommandBlocker(), this);
			Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
			Bukkit.getPluginManager().registerEvents(new TakeDamage(), this);
			Bukkit.getPluginManager().registerEvents(new LoseFood(), this);
			
			//bungeecord
			if (Bukkit.getPluginManager().isPluginEnabled("SocketAPI"))
				Bukkit.getPluginManager().registerEvents(new ReceiveMessage(), this);
			
			//entity events
			Bukkit.getPluginManager().registerEvents(new EntityExplode(), this);
			Bukkit.getPluginManager().registerEvents(new EntitySpawn(), this);
			
			//gui, long long list... :(
			//going from top to bottom
			Bukkit.getPluginManager().registerEvents(new GuiRemove(), this);
			
			//options menu
			Bukkit.getPluginManager().registerEvents(new CloseMenu(), this);
			Bukkit.getPluginManager().registerEvents(new OptionsMenu(), this);
			//floor
			Bukkit.getPluginManager().registerEvents(new FloorClick(), this);
			//heads
			Bukkit.getPluginManager().registerEvents(new HeadsClick(), this);
			
			Bukkit.getPluginManager().registerEvents(new AlphabetHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new BlocksHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new CharactersHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new ColorsHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new DevicesHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new FoodHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new GamesHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new InteriorHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new MiscHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new MobsHeadsClick(), this);
			Bukkit.getPluginManager().registerEvents(new PokemonHeadsClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new AlphabetHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new AlphabetHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new AlphabetHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new BlocksHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new BlocksHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new BlocksHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new CharactersHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new CharactersHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new CharactersHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new ColorsHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new ColorsHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new DevicesHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new DevicesHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new DevicesHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new FoodHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new FoodHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new FoodHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new GamesHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new GamesHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new InteriorHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new InteriorHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new InteriorHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new MiscHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new MiscHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new MiscHeadsSkullClick(), this);
		
			Bukkit.getPluginManager().registerEvents(new MobsHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new MobsHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new MobsHeadsSkullClick(), this);
			
			Bukkit.getPluginManager().registerEvents(new PokemonHeadsCloseClick(), this);
			Bukkit.getPluginManager().registerEvents(new PokemonHeadsPageClick(), this);
			Bukkit.getPluginManager().registerEvents(new PokemonHeadsSkullClick(), this);
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
		
			//spectator
			Bukkit.getPluginManager().registerEvents(new LeaveClick(), this);
			
			//strc
			
			//stats
			//saved
			Bukkit.getPluginManager().registerEvents(new BreakStat(), this);
			Bukkit.getPluginManager().registerEvents(new FirstStat(), this);
			Bukkit.getPluginManager().registerEvents(new MoveStat(), this);
			Bukkit.getPluginManager().registerEvents(new PlaceStat(), this);
			Bukkit.getPluginManager().registerEvents(new PlaysStat(), this);
			Bukkit.getPluginManager().registerEvents(new SecondStat(), this);
			Bukkit.getPluginManager().registerEvents(new ThirdStat(), this);
			//unsaved
			Bukkit.getPluginManager().registerEvents(new UnsavedStatsPlace(), this);
			
			//structure
			Bukkit.getPluginManager().registerEvents(new TreeGrow(), this);
		
			loadedListeners = true;
		}
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getLogger().info("Loading timer");
		new ParticleRender().runTaskTimerAsynchronously(this, 0L, 10L);
		new ScoreboardUpdater().runTaskTimerAsynchronously(this, 0L, SettingsManager.getInstance().getConfig().getLong("scoreboard-update-delay"));
		new StatSaveTimer().runTaskLaterAsynchronously(this, SettingsManager.getInstance().getConfig().getLong("stats.save-delay"));

		getLogger().info("Loading stats");
		StatManager.getInstance().setup();
		
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