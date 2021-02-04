package com.gmail.stefvanschiedev.buildinggame.managers.mainspawn;

import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles the main spawn
 *
 * @since 2.1.0
 */
public final class MainSpawnManager {

    /**
     * Constructs a new MainSpawnManager. This shouldn't be called to keep this class a singleton.
     */
	private MainSpawnManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final MainSpawnManager INSTANCE = new MainSpawnManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static MainSpawnManager getInstance() {
		return INSTANCE;
	}

	/**
     * The main spawn location
     */
	private PotentialLocation mainSpawn;

	/**
     * The server which contains the main spawn
     */
	private String server;

	/**
     * Loads/Reloads the main spawn
     */
	public void setup() {
		mainSpawn = null;
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

		try {
			if (!arenas.contains("main-spawn.server")) {
				arenas.set("main-spawn.server", Bukkit.getServer().getName());
				SettingsManager.getInstance().save();
			}
			
			setMainSpawn(new PotentialLocation(() -> Bukkit.getWorld(arenas.getString("main-spawn.world")),
                arenas.getInt("main-spawn.x"),
                arenas.getInt("main-spawn.y"),
                arenas.getInt("main-spawn.z"),
                (float) arenas.getDouble("main-spawn.yaw", 0),
                (float) arenas.getDouble("main-spawn.pitch", 0)));
			setServer(arenas.getString("main-spawn.server"));

			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                Main.getInstance().getLogger().info("Loaded main spawn");
            }
		} catch (NullPointerException | IllegalArgumentException e) {
			setMainSpawn(null);
		}
	}

	/**
     * Returns the main spawn or null if the main spawn isn't set or the yaml section is malformed
     *
     * @return the main spawn or null
     * @see Location
     * @since 2.1.0
     */
	@Nullable
	@Contract(pure = true)
    public PotentialLocation getMainSpawn() {
		return mainSpawn;
	}

	/**
     * Returns the server the main spawn is located, will return null if the server name hasn't been set
     *
     * @return the server of the main spawn
     * @since 2.1.0
     */
	@Nullable
	@Contract(pure = true)
    public String getServer() {
		return server;
	}

	/**
     * Change the main spawn location
     *
     * @param mainSpawn the new main spawn location
     */
	public void setMainSpawn(PotentialLocation mainSpawn) {
		this.mainSpawn = mainSpawn;
	}

	/**
     * Change the server of the main spawn
     *
     * @param server the new server of the main spawn
     */
	private void setServer(String server) {
		this.server = server;
	}
}