package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.IdentifiedCallable;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A wrapper class for players which contains useful methods for sending titles and keeping track of stats. This wrapper
 * is created once a player joins an arena and deleted once they leave it or the game belonging to that arena is over.
 *
 * @since 2.1.0
 */
public class GamePlayer {

    /**
     * The amount of exp before the player joined an arena
     */
	private final float exp;

	/**
     * The fly speed before the player joined an arena
     */
	private final float flySpeed;

	/**
     * The amount of food before the player joined an arena
     */
	private final int foodLevel;

	/**
     * The game mode before the player joined the arena
     */
	private final GameMode gameMode;

	/**
     * The player this player is spectating if any
     */
	private GamePlayer spectates;

	/**
     * The type of game player this is (player / spectator)
     */
	private final GamePlayerType gamePlayerType;

	/**
     * The amount of exp levels this player had before joining an arena
     */
	private final int levels;

	/**
     * The amount of blocks placed in this game (across all matches)
     */
	private int blocksPlaced;

	/**
     * The player this instance is a wrapper for
     */
	private final Player player;

	/**
     * The inventory before the player joined an arena
     */
	private final ItemStack[] inventory;

	/**
     * The armor before the player joined an arena
     */
	private final ItemStack[] armor;

	/**
     * The scoreboard before the player joined an arena
     */
	private final Scoreboard scoreboard;

    /**
     * The previous amount of centimeters walked in order to determine the amount of block walked during the game
     */
	private final int walkOnceCM;

    /**
     * A list of titles that still need to be send
     */
	private final List<String> titles;

	/**
     * A list of subtitles that still need to be send
     */
	private final List<String> subtitles;

	/**
     * A countdown for the current title
     */
	private TitleCountdown titleCountdown;

	/**
     * A countdown for the current subtitle
     */
	private SubtitleCountdown subtitleCountdown;

	/**
     * Constructs a new game player with the given player and game player type
     *
     * @param player the player this class will be a wrapper for
     * @param gamePlayerType the type of game player
     */
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

		walkOnceCM = player.getStatistic(Statistic.WALK_ONE_CM);
		
		titles = new ArrayList<>();
		subtitles = new ArrayList<>();
	}

	/**
     * Adds a subtitle to the countdown or constructs a new countdown if no one exists yet
     *
     * @param subtitle the subtitle to send to the player
     * @since 2.1.0
     */
	private void addSubtitle(String subtitle) {
		if (getSubtitleCountdown() != null)
			subtitles.add(subtitle);
		
		if (getSubtitleCountdown() == null) {
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			//start new countdown	
			sendSubtitle(subtitle);	
			setSubtitleCountdown(new SubtitleCountdown(this));
			getSubtitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade-in") +
                    config.getInt("title.stay") + config.getInt("title.fade-out"));
		}
	}

    /**
     * Adds a title to the countdown or constructs a new countdown if no one exists yet
     *
     * @param title the title to send to the player
     * @since 2.1.0
     */
	private void addTitle(String title) {
		if (getTitleCountdown() != null)
			titles.add(title);
		
		if (getTitleCountdown() == null) {
			//start new countdown
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			sendTitle(title);	
			setTitleCountdown(new TitleCountdown(this));
			getTitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade-in") +
                    config.getInt("title.stay") + config.getInt("title.fade-out"));
		}
	}

    /**
     * Adds a title and a subtitle to the countdown or constructs a new countdown if no one exists yet
     *
     * @param title the title to send to the player
     * @param subtitle the subtitle to send to the player
     * @since 2.1.0
     */
	public void addTitleAndSubtitle(String title, String subtitle) {
		if (title.isEmpty() && subtitle.isEmpty())
			return;
		
		if (!SettingsManager.getInstance().getConfig().getBoolean("title.synchronize")) {
			addTitle(title);
			addSubtitle(subtitle);
		} else
			sendTitleAndSubtitle(title, subtitle);
	}

	/**
     * Connects a player to a server and teleports it to the specified location
     *
     * @param server the server to connect this player to
     * @param location the location to teleport this player to after it has been connected to the other server
     * @since 4.0.6
     */
	public void connect(String server, final PotentialLocation location) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();

		World world = location.getWorld();

		if (config.getBoolean("bungeecord.enable") && world != null)
            BungeeCordHandler.getInstance().connect(BungeeCordHandler.Receiver.BUNGEE, player, server,
                    new IdentifiedCallable() {
                @Override
                public void call(String response) {
                    BungeeCordHandler.getInstance().teleport(BungeeCordHandler.Receiver.SUB_SERVER,
                        player.getName(), world.getName(), location.getX(), location.getY(), location.getZ(),
                        null);
                }
            });
		else if (location != null)
		    location.teleport(getPlayer());
    }

    /**
     * Returns the amount of blocks placed in this game
     *
     * @return the amount of blocks placed
     * @since 2.1.0
     */
    @Contract(pure = true)
	public int getBlocksPlaced() {
		return blocksPlaced;
	}

	/**
     * Returns the game player type
     *
     * @return the game player type
     * @see GamePlayerType
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public GamePlayerType getGamePlayerType() {
		return gamePlayerType;
	}

	/**
     * Returns the player who belongs to this game player
     *
     * @return the player who belongs to this instance
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public Player getPlayer() {
		return player;
	}

	/**
     * Returns the player who this player is spectating if any
     *
     * @return the player who this player is spectating or null if this player isn't spectating
     * @see GamePlayer
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public GamePlayer getSpectates() {
		return spectates;
	}

	/**
     * Returns the subtitle countdown if any exists
     *
     * @return the subtitle countdown
     * @see SubtitleCountdown
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
    SubtitleCountdown getSubtitleCountdown() {
		return subtitleCountdown;
	}

	/**
     * Returns a list of subtitles that still have to be shown
     *
     * @return a list of subtitles
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    List<String> getSubtitles() {
		return subtitles;
	}

	/**
     * Returns the title countdown if any exists
     *
     * @return the title countdown
     * @see TitleCountdown
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	TitleCountdown getTitleCountdown() {
		return titleCountdown;
	}

	/**
     * Returns a list of titles that still need to be send
     *
     * @return a list of titles
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	List<String> getTitles() {
		return titles;
	}

    /**
     * Refreshes the specified chunk for this game player
     *
     * @param chunk the chunk to refresh
     * @since 5.2.0
     */
	public void refreshChunk(Chunk chunk) {
        try {
            //unload the chunk (bukkit prevents you from unloading it with internal methods when the player is still there, so make use of packets)
            Class<?> unloadPacketClass = getClass("net.minecraft.network.protocol.game.PacketPlayOutUnloadChunk");

            sendPacket(unloadPacketClass.getConstructor(int.class, int.class).newInstance(chunk.getX(), chunk.getZ()));

            Class<?> chunkPacketClass = getClass("net.minecraft.network.protocol.game.PacketPlayOutMapChunk");
            Class<?> chunkClass = getClass("net.minecraft.world.level.chunk.Chunk");

            Object nmsChunk = chunk.getClass().getMethod("getHandle").invoke(chunk);

            //send the chunk again
            sendPacket(chunkPacketClass.getConstructor(chunkClass).newInstance(nmsChunk));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                InstantiationException e) {
            e.printStackTrace();
        }
    }

	/**
     * This restores the player to before it joined an arena and applies any necessary statistic updates
     *
     * @since 2.1.0
     */
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

		//apply walked statistic
        StatManager instance = StatManager.getInstance();

        var stat = instance.getStat(player, StatType.WALKED);

        instance.registerStat(
            player,
            StatType.WALKED,
            (stat == null ? 0 : stat.getValue()) + (player.getStatistic(Statistic.WALK_ONE_CM) - walkOnceCM) / 100
        );
	}

    /**
     * Sends an actionbar to the player
     *
     * @param text the text to send
     * @since 5.6.0
     */
	public void sendActionbar(@NotNull String text) {
        TextAdapter.sendActionBar(player, LegacyComponentSerializer.INSTANCE.deserialize(text));
    }

	/**
     * Sends a subtitle to the player
     *
     * @param subtitle the subtitle that'll be send
     * @since 2.1.0
     */
	@SuppressWarnings("ConstantConditions")
	void sendSubtitle(String subtitle) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();

        int fadeIn = config.getInt("title.fade-in");
        int stay = config.getInt("title.stay");
        int fadeOut = config.getInt("title.fade-out");

        this.player.sendTitle(null, MessageManager.translate(subtitle, player), fadeIn, stay, fadeOut);
	}

	/**
     * Sends a title to the player
     *
     * @param title the title that'll be send
     * @since 2.1.0
     */
	@SuppressWarnings("ConstantConditions")
	void sendTitle(String title) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        int fadeIn = config.getInt("title.fade-in");
        int stay = config.getInt("title.stay");
        int fadeOut = config.getInt("title.fade-out");

        this.player.sendTitle(MessageManager.translate(title, player), null, fadeIn, stay, fadeOut);
	}

	/**
     * Sends a title and a subtitle to the player
     *
     * @param title the title that'll be send
     * @param subtitle the subtitle that'll be send
     * @since 2.1.0
     */
	private void sendTitleAndSubtitle(String title, String subtitle) {
		if (title.isEmpty() && subtitle.isEmpty())
			return;
		
		sendTitle(title);
		sendSubtitle(subtitle);
	}

	/**
     * Sets the amount of blocks placed
     *
     * @param blocksPlaced the new amount of blocks placed
     * @since 2.1.0
     */
	public void setBlocksPlaced(int blocksPlaced) {
		this.blocksPlaced = blocksPlaced;
	}

	/**
     * Sets the player the player is currently spectating
     *
     * @param spectates the new spectator
     * @since 2.1.0
     */
	public void setSpectates(GamePlayer spectates) {
		this.spectates = spectates;
	}

	/**
     * Sets the subtitle countdown
     *
     * @param subtitleCountdown the new subtitle countdown
     * @since 2.1.0
     */
	void setSubtitleCountdown(SubtitleCountdown subtitleCountdown) {
		this.subtitleCountdown = subtitleCountdown;
	}

	/**
     * Sets the title countdown
     *
     * @param titleCountdown the new title countdown
     * @since 2.1.0
     */
	void setTitleCountdown(TitleCountdown titleCountdown) {
		this.titleCountdown = titleCountdown;
	}

	/**
     * Sends a packet to the player
     *
     * @param packet the packet to send
     * @since 2.1.0
     */
	private void sendPacket(Object packet) {
		try {
			Object handle = getPlayer().getClass().getMethod("getHandle").invoke(getPlayer());
			Object playerConnection = handle.getClass().getField("b").get(handle); //connection
            Class<?> packetClass = getClass("net.minecraft.network.protocol.Packet");

            playerConnection.getClass().getMethod("sendPacket", packetClass).invoke(playerConnection, packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Returns the NMS class by the given name
     *
     * @param name the name of the class
     * @return the class by the name
     * @since 2.1.0
     */
	@Nullable
    private static Class<?> getClass(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public boolean equals(Object obj) {
	    return obj instanceof GamePlayer && ((GamePlayer) obj).getPlayer().equals(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
	    return player.hashCode();
    }
}