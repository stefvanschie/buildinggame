package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

import fr.rhaz.socketapi.SocketAPI;

public class GamePlayer {

	private float exp;
	private float flySpeed;
	private int foodLevel;
	private GameMode gameMode;
	private GamePlayer spectates;
	private GamePlayerType gamePlayerType;
	private int levels;
	private int blocksPlaced = 0;
	private Player player;
	private ItemStack[] inventory;
	private ItemStack[] armor;
	
	//titles and subtitle
	private List<String> titles;
	private List<String> subtitles;
	
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
		
		titles = new ArrayList<String>();
		subtitles = new ArrayList<String>();
	}

	public void addSubtitle(String subtitle) {	
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
	
	public void addTitle(String title) {
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
		if (title.equals("") && subtitle.equals(""))
			return;
		
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (!config.getBoolean("title.syncronize")) {
			addTitle(title);
			addSubtitle(subtitle);
		} else
			sendTitleAndSubtitle(title, subtitle);
	}
	
	public boolean connect(String server) {
		if (player.getServer().getServerName().equals(server))
			return true;
		
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "connect: " + getPlayer().getName() + ", " + server);
		return true;
	}
	
	public boolean connect(String server, final Location location) {
		if (Bukkit.getPluginManager().isPluginEnabled("SocketAPI")) {
			if (!player.getServer().getServerName().equals(server))
				SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "connect: " + getPlayer().getName() + ", " + server);
		
			BukkitRunnable task = new BukkitRunnable() {
				@Override
				public void run() {
					SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "teleport: " +
							getPlayer().getName() + ", " +
							location.getWorld().getName() + ", " +
							location.getBlockX() + ", " +
							location.getBlockY() + ", " +
							location.getBlockZ());
				}
			};
			task.runTaskLater(Main.getInstance(), 10L);
		} else
			getPlayer().teleport(location);
		return true;
	}
	
	public ItemStack[] getArmor() {
		return armor;
	}
	
	public int getBlocksPlaced() {
		return blocksPlaced;
	}
	
	public float getExp() {
		return exp;
	}
	
	public int getFoodLevel() {
		return foodLevel;
	}
	
	public float getFlySpeed() {
		return flySpeed;
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}
	
	public GamePlayerType getGamePlayerType() {
		return gamePlayerType;
	}
	
	public ItemStack[] getInventory() {
		return inventory;
	}
	
	public int getLevels() {
		return levels;
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
	
	public void setTimes(int fadeIn, int stay, int fadeOut) {
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
			return;
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
	}
	
	public void sendSubtitle(String subtitle) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"));
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + subtitle
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß") + "\"}"));
			
			setTimes(config.getInt("title.fade_in"), config.getInt("title.stay"), config.getInt("title.fade_out"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void sendTitle(String title) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"));
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + title
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß") + "\"}"));
			
			setTimes(config.getInt("title.fade_in"), config.getInt("title.stay"), config.getInt("title.fade_out"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void sendTitleAndSubtitle(String title, String subtitle) {
		if (title.equals("") && subtitle.equals(""))
			return;
		
		sendTitle(title);
		sendSubtitle(subtitle);
	}
	
	public void setArmor(ItemStack[] armor) {
		this.armor = armor;
	}
	
	public void setBlocksPlaced(int blocksPlaced) {
		this.blocksPlaced = blocksPlaced;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	public void setFlySpeed(float flySpeed) {
		this.flySpeed = flySpeed;
	}
	
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
	
	public void setInventory(ItemStack[] inventory) {
		this.inventory = inventory;
	}
	
	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
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
	
	private Class<?> getNMSClass(String name) {
		try {
			return Class.forName("net.minecraft.server." + getVersion() + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}
}
