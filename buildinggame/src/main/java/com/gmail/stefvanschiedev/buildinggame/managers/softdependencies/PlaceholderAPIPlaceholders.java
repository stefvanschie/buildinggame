package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Registers placeholder for PlaceholderAPI
 *
 * @since 5.5.1
 */
public class PlaceholderAPIPlaceholders extends PlaceholderExpansion {

    /**
     * YAML configuration for messages.yml
     */
    private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Nullable
    @Contract(pure = true, value = "_, null -> fail")
    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        if (identifier.equalsIgnoreCase("players"))
            return players();

        if (identifier.toLowerCase(Locale.getDefault()).startsWith("stat_")) {
            for (var statType : StatType.values()) {
                String type = statType.toString().toLowerCase(Locale.getDefault());

                if (!identifier.startsWith("stat_" + type + "_top_"))
                    continue;

                int number;

                try {
                    number = Integer.parseInt(identifier.substring(("stat_" + type + "_top_").length()));
                } catch (NumberFormatException ignore) {
                    return null;
                }

                return statTop(statType, number);
            }

            return null;
        }

        //divider between non-player dependent placeholders and player dependent placeholders
        if (player == null)
            return null;

        if (identifier.toLowerCase(Locale.getDefault()).startsWith("stat_")) {
            for (var statType : StatType.values()) {
                if (!identifier.equalsIgnoreCase("stat_" + statType.toString().toLowerCase(Locale
                    .getDefault())))
                    continue;

                return stat(player, statType);
            }

            return null;
        }

        if (identifier.equalsIgnoreCase("has_booster"))
            return player instanceof Player ? hasBooster((Player) player) :
                messages.getString("placeholder-api.has-booster.result.false");

        if (identifier.equalsIgnoreCase("booster_multiplier"))
            return player instanceof Player ? boosterMultiplier((Player) player) : "0.0";

        if (identifier.equalsIgnoreCase("booster_time_left"))
            return player instanceof Player ? boosterTimeLeft((Player) player) : "0";

        if (identifier.equalsIgnoreCase("booster_activator"))
            return player instanceof Player ? boosterActivator((Player) player) : "";

        return null;
    }

    /**
     * Evaluates %buildinggame_players% placeholders
     *
     * @return the amount of players
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String players() {
        return String.valueOf(ArenaManager.getInstance().getArenas().stream().mapToInt(Arena::getPlayers).sum());
    }

    /**
     * Evaluates %buildinggame_stat_<stat>% placeholders
     *
     * @param player the player to evaluate this placeholder for
     * @param statType the statistic type
     * @return the value for the specified stat
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String stat(OfflinePlayer player, StatType statType) {
        var stat = StatManager.getInstance().getStat(player, statType);

        return stat == null ? "0" : String.valueOf(stat.getValue());
    }

    /**
     * Evaluates %buildinggame_has_booster% placeholders
     *
     * @param player the player to evaluate this placeholder for
     * @return the translated string for true/false
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String hasBooster(Player player) {
        return Booster.hasBooster(player) ? messages.getString("placeholder-api.has-booster.result.true") :
            messages.getString("placeholder-api.has-booster.result.false");
    }

    /**
     * Evaluates %buildinggame_booster_multiplier% placeholders
     *
     * @param player the player to evaluate this placeholder for
     * @return the total multiplier
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String boosterMultiplier(Player player) {
        return String.valueOf(Booster.getMultiplier(player));
    }

    /**
     * Evaluates %buildinggame_booster_time_left% placeholders
     *
     * @param player the player to evaluate this placeholder for
     * @return the time remaining on the currently longest during booster
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String boosterTimeLeft(Player player) {
        return String.valueOf(Booster.getBoosters(player).stream().mapToInt(Booster::getRemainingTime).max()
            .orElse(0));
    }

    /**
     * Evaluates %buildinggame_booster_activator% placeholders
     *
     * @param player the player to evaluate this placeholder for
     * @return the activators of all boosters for the player
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String boosterActivator(Player player) {
        var boosters = Booster.getBoosters(player);

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

    /**
     * Returns the value for the given stat in the specified spot given a descending based ordering
     *
     * @param type the stat type
     * @param number the index
     * @return the stat value
     * @since 5.5.4
     */
    @NotNull
    @Contract(pure = true)
    private String statTop(StatType type, int number) {
        Map<OfflinePlayer, Integer> stats = new HashMap<>();

        StatManager.getInstance().getStats(type).forEach(stat -> stats.put(stat.getPlayer(), stat.getValue()));

        List<Integer> values = new ArrayList<>(stats.values());
        Collections.sort(values);
        Collections.reverse(values);

        int value = -1;

        if (values.size() >= number)
            value = values.get(number - 1);

        return String.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return String.join(", ", Main.getInstance().getDescription().getAuthors());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIdentifier() {
        return "buildinggame";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean persist() {
        return true;
    }
}
