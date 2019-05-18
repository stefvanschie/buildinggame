package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * A utility class which can supply placeholder replacements to other plugins.
 *
 * @since 7.0.0
 */
public final class PlaceholderSupplier {

    private PlaceholderSupplier() {}

    /**
     * A Map containing the placeholder identifiers and a {@link BiFunction} which returns the replaced value according
     * to the given {@link OfflinePlayer}.
     */
    private static final Map<String, BiFunction<OfflinePlayer, String, String>> PLACEHOLDER_REPLACEMENTS =
        new HashMap<>();

    /**
     * Gets a map of all placeholder with their respective function for updating these
     *
     * @return all placeholders
     * @see #PLACEHOLDER_REPLACEMENTS
     * @since 7.0.0
     */
    public static Map<String, BiFunction<OfflinePlayer, String, String>> getPlaceholderReplacements() {
        return PLACEHOLDER_REPLACEMENTS;
    }

    static {
        PLACEHOLDER_REPLACEMENTS.put("buildinggame_players", (offlinePlayer, placeholder) ->
            String.valueOf(ArenaManager.getInstance().getArenas().stream().mapToInt(Arena::getPlayers).sum()));
        PLACEHOLDER_REPLACEMENTS.put("buildinggame_has_booster", (offlinePlayer, placeholder) -> {
            YamlConfiguration messages = SettingsManager.getInstance().getMessages();

            var falseMessage = messages.getString("placeholder-api.has-booster.result.false");

            if (offlinePlayer == null || !offlinePlayer.isOnline())
                return falseMessage;

            return Booster.hasBooster(offlinePlayer.getPlayer()) ?
                messages.getString("placeholder-api.has-booster.result.true") : falseMessage;
        });
        PLACEHOLDER_REPLACEMENTS.put("buildinggame_booster_multiplier", (offlinePlayer, placeholder) -> {
            if (offlinePlayer == null || !offlinePlayer.isOnline())
                return "0.0";

            return String.valueOf(Booster.getMultiplier(offlinePlayer.getPlayer()));
        });
        PLACEHOLDER_REPLACEMENTS.put("buildinggame_booster_time_left", (offlinePlayer, placeholder) -> {
            if (offlinePlayer == null || !offlinePlayer.isOnline())
                return "0";

            return String.valueOf(Booster.getBoosters(offlinePlayer.getPlayer()).stream()
                .mapToInt(Booster::getRemainingTime)
                .max()
                .orElse(0));
        });
        PLACEHOLDER_REPLACEMENTS.put("buildinggame_booster_activator", (offlinePlayer, placeholder) -> {
            if (offlinePlayer == null || !offlinePlayer.isOnline())
                return "";

            var boosters = Booster.getBoosters(offlinePlayer.getPlayer());

            if (boosters.isEmpty())
                return "";

            StringBuilder activators = new StringBuilder();
            boosters.stream()
                .map(booster -> booster.getActivator().getName())
                .distinct()
                .forEach(name -> activators.append(name).append(", "));

            int length = activators.length();
            int commaIndex = activators.lastIndexOf(", ");

            if (boosters.stream().map(booster -> booster.getActivator().getName()).distinct().count() == 1)
                return activators.substring(0, length - 2);

            return activators
                .replace(length - 2, length, "")
                .replace(commaIndex, commaIndex + 2, " and ")
                .toString();
        });

        for (var statType : StatType.values()) {
            var name = statType.toString().toLowerCase(Locale.getDefault());

            PLACEHOLDER_REPLACEMENTS.put("buildinggame_stat_" + name, (offlinePlayer, placeholder) -> {
                Stat stat = StatManager.getInstance().getStat(offlinePlayer, statType);

                return stat == null ? "0" : String.valueOf(stat.getValue());
            });
            PLACEHOLDER_REPLACEMENTS.put("buildinggame_stat_" + name + "_top", (offlinePlayer, placeholder) -> {
                var stats = StatManager.getInstance().getStats(statType);

                if (stats == null)
                    return "-1";

                return String.valueOf(stats.get(0).getValue());
            });
        }
    }
}
