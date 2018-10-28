package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all matches for all arenas
 *
 * @since 4.0.6
 */
public final class MatchesManager {

    /**
     * Constructs a new MatchesManager. This shouldn't be called to keep this class a singleton.
     */
    private MatchesManager() {}

    /**
     * An instance of this class for the singleton principle
     */
    private static final MatchesManager INSTANCE = new MatchesManager();

    /**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    public static MatchesManager getInstance() {
        return INSTANCE;
    }

    /**
     * Loads/Reloads all matches for all arenas
     *
     * @since 4.0.6
     */
    @SuppressWarnings("MethodMayBeStatic")
    public void setup() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        for (var arena : ArenaManager.getInstance().getArenas()) {
            var name = arena.getName();

            arena.setMaxMatches(arenas.getInt(name + ".matches", 1));

            if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
                Main.getInstance().getLogger().info("Loaded max matches for " + name);
        }
    }
}
