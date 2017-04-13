package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

import fr.rhaz.socket4mc.Socket4MC;

public class GamePlayer {

	private final float exp;
	private final float flySpeed;
	private final int foodLevel;
	private final GameMode gameMode;
	private GamePlayer spectates;
	private final GamePlayerType gamePlayerType;
	private final int levels;
	private int blocksPlaced;
	private final Player player;
	private final ItemStack[] inventory;
	private final ItemStack[] armor;
	private final Scoreboard scoreboard;
	
	//titles and subtitle
	private final List<String> titles;
	private final List<String> subtitles;
	
	private TitleCountdown titleCountdown;
	private SubtitleCountdown subtitleCountdown;
	
	public GamePlayer(Player player, GamePlayerType gamePlayerType) {
		exp = player.getExp();
		foodLevel = player.getFoodLevel();
		flySpeed = player.getFlySpeed();
		gameMode = player.getGameMode();
		this.gamePlayerType = gamePlayerType;
		levels = player.getLevel();
		this.player = player;
		inventory = player.getInventory().getContents();
		armor = player.getInventory().getArmorContents();
		scoreboard = player.getScoreboard();
		
		titles = new ArrayList<>();
		subtitles = new ArrayList<>();
	}

	private void addSubtitle(String subtitle) {
		if (getSubtitleCountdown() != null)
			subtitles.add(subtitle);
		
		if (getSubtitleCountdown() == null) {
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			//start new countdown	
			sendSubtitle(subtitle);	
			setSubtitleCountdown(new SubtitleCountdown(this));
			getSubtitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade_in") + config.getInt("title.stay") + config.getInt("title.fade_out"));
		}
	}
	
	private void addTitle(String title) {
		if (getTitleCountdown() != null)
			titles.add(title);
		
		if (getTitleCountdown() == null) {
			//start new countdown
			YamlConfiguration config = SettingsManager.getInstance().getConfig();

			
			sendTitle(title);	
			setTitleCountdown(new TitleCountdown(this));
			getTitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade_in") + config.getInt("title.stay") + config.getInt("title.fade_out"));
		}
	}
	
	public void addTitleAndSubtitle(String title, String subtitle) {
		if (title.isEmpty() && subtitle.isEmpty())
			return;
		
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (!config.getBoolean("title.syncronize")) {
			addTitle(title);
			addSubtitle(subtitle);
		} else
			sendTitleAndSubtitle(title, subtitle);
	}
	
	public void connect(String server, final Location location) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (Bukkit.getPluginManager().isPluginEnabled("SocketAPI") && config.getBoolean("bungeecord.enable")) {
			if (!player.getServer().getServerName().equals(server))
				Socket4MC.bukkit().getSocketClient().writeJSON("BuildingGame", "connect: " + getPlayer().getName() + ", " + server);
			
			BukkitRunnable task = new BukkitRunnable() {
				@Override
				public void run() {
					Socket4MC.bukkit().getSocketClient().writeJSON("BuildingGame", "teleport: " +
							getPlayer().getName() + ", " +
							location.getWorld().getName() + ", " +
							location.getBlockX() + ", " +
							location.getBlockY() + ", " +
							location.getBlockZ());
				}
			};
			task.runTaskLater(Main.getInstance(), 10L);
		} else if (location != null)
			getPlayer().teleport(location);
    }
	
	public int getBlocksPlaced() {
		return blocksPlaced;
	}
	
	public GamePlayerType getGamePlayerType() {
		return gamePlayerType;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public GamePlayer getSpectates() {
		return spectates;
	}
	
	public SubtitleCountdown getSubtitleCountdown() {
		return subtitleCountdown;
	}
	
	public List<String> getSubtitles() {
		return subtitles;
	}
	
	@SuppressWarnings("ConstantConditions")
	private void setTimes(int fadeIn, int stay, int fadeOut) {
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"),
							int.class,
							int.class,
							int.class);
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
			
			Object packet = constructor.newInstance(enumTitle, null, fadeIn, stay, fadeOut);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TitleCountdown getTitleCountdown() {
		return titleCountdown;
	}
	
	public List<String> getTitles() {
		return titles;
	}
	
	public void restore() {
		player.getInventory().setArmorContents(armor);
		setBlocksPlaced(0);
		player.setExp(exp);
		player.setFoodLevel(foodLevel);
		player.setFlySpeed(flySpeed);
		player.setGameMode(gameMode);
		player.getInventory().setContents(inventory);
		player.setLevel(levels);
		player.setScoreboard(scoreboard);
	}
	
	@SuppressWarnings("ConstantConditions")
	public void sendSubtitle(String subtitle) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"));
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + MessageManager.translate(subtitle) + "\"}"));
			
			setTimes(config.getInt("title.fade_in"), config.getInt("title.stay"), config.getInt("title.fade_out"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("ConstantConditions")
	public void sendTitle(String title) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"));
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + title
							.replace("%:a%", "�")
							.replace("%:e%", "�")
							.replace("%:i%", "�")
							.replace("%:o%", "�")
							.replace("%:u%", "�")
							.replace("%ss%", "�") + "\"}"));
			
			setTimes(config.getInt("title.fade_in"), config.getInt("title.stay"), config.getInt("title.fade_out"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendTitleAndSubtitle(String title, String subtitle) {
		if (title.isEmpty() && subtitle.isEmpty())
			return;
		
		sendTitle(title);
		sendSubtitle(subtitle);
	}
	
	public void setBlocksPlaced(int blocksPlaced) {
		this.blocksPlaced = blocksPlaced;
	}
	
	public void setSpectates(GamePlayer spectates) {
		this.spectates = spectates;
	}
	
	public void setSubtitleCountdown(SubtitleCountdown subtitleCountdown) {
		this.subtitleCountdown = subtitleCountdown;
	}
	
	public void setTitleCountdown(TitleCountdown titleCountdown) {
		this.titleCountdown = titleCountdown;
	}
	
	private void sendPacket(Object packet) {
		try {
			Object handle = getPlayer().getClass().getMethod("getHandle").invoke(getPlayer());
			Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
			playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Class<?> getNMSClass(String name) {
		try {
			return Class.forName("net.minecraft.server." + getVersion() + '.' + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}
}
