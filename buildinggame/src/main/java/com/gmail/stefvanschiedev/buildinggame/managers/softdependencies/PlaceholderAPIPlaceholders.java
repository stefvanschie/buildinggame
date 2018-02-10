package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Locale;

/**
 * Registers placeholder for PlaceholderAPI
 *
 * @since 5.5.1
 */
public class PlaceholderAPIPlaceholders extends EZPlaceholderHook {

    /**
     * YAML configuration for messages.yml
     */
    private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

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
            return Booster.hasBooster(player) ? messages.getString("placeholder-api.has-booster.result.true") :
                messages.getString("placeholder-api.has-booster.result.false");

        Collection<Booster> boosters = Booster.getBoosters(player);
        if (identifier.equalsIgnoreCase("booster_time_left"))
            return String.valueOf(boosters.stream().mapToInt(Booster::getRemainingTime).max()
                .orElse(0));

        if (identifier.equalsIgnoreCase("booster_activator")) {
            if (boosters.isEmpty())
                return "";

            StringBuilder activators = new StringBuilder();
            boosters.stream().map(booster -> booster.getActivator().getName()).distinct().forEach(name -> activators
                .append(name).append(", "));

            if (boosters.stream().map(booster -> booster.getActivator().getName()).distinct().count() == 1)
                return activators.substring(0, activators.length() - 2);

            return activators.replace(activators.length() - 2, activators.length(), "").replace(activators
                .lastIndexOf(", "), activators.lastIndexOf(", ") + 2, " and ").toString();
        }

        return null;
    }
}
