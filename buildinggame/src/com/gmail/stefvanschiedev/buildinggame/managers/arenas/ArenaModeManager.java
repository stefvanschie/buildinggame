package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles the modes of all arenas
 *
 * @since 2.1.0
 */
public final class ArenaModeManager {

    /**
     * Constructs a new ArenaModeManager. This shouldn't be called to keep this class a singleton.
     */
	private ArenaModeManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final ArenaModeManager INSTANCE = new ArenaModeManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static ArenaModeManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all modes for every arena from the arenas.yml
     *
     * @since 2.1.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".mode")) {
				arenas.set(arena.getName() + ".mode", "SOLO");
			}
			
			arena.setMode(ArenaMode.valueOf(arenas.getString(arena.getName() + ".mode")));
			
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Loaded gamemode for " + arena.getName());
			}
		}
	}
}
