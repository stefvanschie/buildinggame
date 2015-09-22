package me.stefvanschie.buildinggame.utils;

import java.lang.reflect.Constructor;

import me.stefvanschie.buildinggame.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerData {

	private int levels;
	private float exp;
	private Player player;
	private ItemStack[] inventory;
	private float flySpeed;
	
	public PlayerData(Player player) {
		exp = player.getExp();
		flySpeed = player.getFlySpeed();
		levels = player.getLevel();
		this.player = player;
		inventory = player.getInventory().getContents();
	}

	public float getExp() {
		return exp;
	}
	
	public float getFlySpeed() {
		return flySpeed;
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
	
	public void sendSubtitle(String subtitle) {
		if (!getVersion().startsWith("v1_8R") || getVersion().replace("v1_8_R", "").equals("1")) {
			Main.getInstance().getLogger().info("Version outdated for title use!");
			return;
		}
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"),
							int.class,
							int.class,
							int.class);
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + subtitle + "\"}"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer, 0, 20, 20);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void sendTitle(String title) {
		if (!getVersion().startsWith("v1_8_R") || getVersion().replace("v1_8_R", "").equals("1")) {
			Main.getInstance().getLogger().info("Version outdated for title use!");
			return;
		}
		try {
			Constructor<?> constructor = getNMSClass("PacketPlayOutTitle")
					.getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0],
							getNMSClass("IChatBaseComponent"),
							int.class,
							int.class,
							int.class);
			
			Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
			Object chatSerializer = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0]
					.getMethod("a", String.class).invoke(null, ChatColor.translateAlternateColorCodes('&', "{\"text\":\"" + title + "\"}"));
			
			Object packet = constructor.newInstance(enumTitle, chatSerializer, 0, 20, 20);
			sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void setFlySpeed(float flySpeed) {
		this.flySpeed = flySpeed;
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
