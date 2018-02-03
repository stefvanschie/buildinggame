package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

import java.util.Locale;

/**
 * Registers placeholder for PlaceholderAPI
 *
 * @since 5.5.1
 */
public class PlaceholderAPIPlaceholders extends EZPlaceholderHook {

    /**
     * Creates a new placeholder api class
     */
    public PlaceholderAPIPlaceholders() {
        super(Main.getInstance(), "buildinggame");
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier.equalsIgnoreCase("players"))
            return String.valueOf(ArenaManager.getInstance().getArenas().stream().mapToInt(Arena::getPlayers).sum());

        //divider between non-player dependent placeholders and player dependent placeholders
        if (player == null)
            return null;

        if (identifier.toLowerCase(Locale.getDefault()).startsWith("stat_" )) {
            for (StatType statType : StatType.values()) {
                if (!identifier.equalsIgnoreCase("stat_" + statType.toString().toLowerCase(Locale
                    .getDefault())))
                    continue;

                Stat stat = StatManager.getInstance().getStat(player, statType);

                return stat == null ? "0" : String.valueOf(stat.getValue());
            }

            return null;
        }

        if (identifier.equalsIgnoreCase("has_booster"))
            return Booster.hasBooster(player) ? "true" : "false";

        return null;
    }
}
