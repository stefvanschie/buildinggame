package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.configuration.file.YamlConfiguration;

public class MatchesManager {

    private MatchesManager() {}
    private static final MatchesManager INSTANCE = new MatchesManager();
    public static MatchesManager getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings("MethodMayBeStatic")
    public void setup() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            if (arenas.contains(arena.getName() + ".matches"))
                arena.setMaxMatches(arenas.getInt(arena.getName() + ".matches"));
            else
                arena.setMaxMatches(1);

            if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
                Main.getInstance().getLogger().info("Loaded max matches for " + arena.getName());
        }
    }
}
