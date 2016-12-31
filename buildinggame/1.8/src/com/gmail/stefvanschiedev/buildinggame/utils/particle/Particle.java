package com.gmail.stefvanschiedev.buildinggame.utils.particle;

import java.lang.reflect.Constructor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class Particle {

	private Location location;
	private ParticleType type;
	
	public Particle(Location location, ParticleType type) {
		this.location = location;
		this.type = type;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public ParticleType getType() {
		return type;
	}
	
	public void render() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
	
		int amount = config.getInt("particles.amount");
		double offsetX = config.getDouble("particles.offset.x");
		double offsetY = config.getDouble("particles.offset.y");
		double offsetZ = config.getDouble("particles.offset.z");
		
		Constructor<?> particles = null;
		try {
			particles = getNMSClass("PacketPlayOutWorldParticles").getConstructor(getNMSClass("EnumParticle"),
					boolean.class, float.class, float.class, float.class, float.class, float.class, float.class,
					float.class, int.class, int[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (getType() == ParticleType.ANGRY_VILLAGER) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("VILLAGER_ANGRY").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType, 				
						true,							
						(float) getLocation().getX(),	
						(float) getLocation().getY() + 1,	
						(float) getLocation().getZ(),	
						(float) offsetX,								
						(float) offsetY,								
						(float) offsetZ,								
						0,								
						amount,							
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.ENCHANTMENT) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("ENCHANTMENT_TABLE").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType, 				
						true,							
						(float) getLocation().getX(),	
						(float) getLocation().getY() + 1,	
						(float) getLocation().getZ(),	
						(float) offsetX,								
						(float) offsetY,								
						(float) offsetZ,								
						0,								
						amount,							
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.FLAMES) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("FLAME").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.HAPPY_VILLAGER) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("VILLAGER_HAPPY").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.HEARTS) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("HEART").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.LAVA_DRIP) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("DRIP_LAVA").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.MAGIC_CRIT) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("CRIT_MAGIC").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.REDSTONE_MAGIC) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("REDSTONE").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.SMOKE) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("SMOKE_NORMAL").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.SNOWBALL_POOF) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("SNOWBALL").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.SPELL) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("SPELL").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (getType() == ParticleType.WATER_DRIP) {
			try {
				Object enumParticleType = getNMSClass("EnumParticle").getField("DRIP_WATER").get(null);
				
				Object packet = particles.newInstance(
						enumParticleType,
						true,
						(float) getLocation().getX(),
						(float) getLocation().getY() + 1,
						(float) getLocation().getZ(),
						(float) offsetX,
						(float) offsetY,
						(float) offsetZ,
						0,
						amount,
						null);
				for (Arena arena : ArenaManager.getInstance().getArenas()) {
					for (Plot plot : arena.getUsedPlots()) {
						for (GamePlayer gamePlayer : plot.getGamePlayers()) {
							sendPacket(gamePlayer.getPlayer(), packet);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setType(ParticleType type) {
		this.type = type;
	}
	
	private void sendPacket(Player player, Object packet) {
		try {
			Object handle = player.getClass().getMethod("getHandle").invoke(player);
			Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
			playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection,
					packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Class<?> getNMSClass(String name) {
		String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		try {
			return Class.forName("net.minecraft.server." + version + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
