package com.gmail.stefvanschiedev.buildinggame.utils.placeholder;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * A visitor which takes the parsed placeholder and returns the corresponding value.
 *
 * @since 0.1.0
 */
public class PlaceholdersReplacer extends PlaceholdersBaseVisitor<String> {

    /**
     * The player for whom the placeholder is being parsed.
     */
    @Nullable
    private final OfflinePlayer player;

    /**
     * Creates a new replacer for the specified player.
     *
     * @param player the player for whom to parse the placeholder
     * @since 0.1.0
     */
    public PlaceholdersReplacer(@Nullable OfflinePlayer player) {
        this.player = player;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String visitPlayers(PlaceholdersParser.PlayersContext ctx) {
        super.visitPlayers(ctx);

        long sum = 0;

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            sum += arena.getPlayers();
        }

        return String.valueOf(sum);
    }

    @Override
    public String visitHas_booster(PlaceholdersParser.Has_boosterContext ctx) {
        super.visitHas_booster(ctx);

        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        ConfigurationSection section = messages.getConfigurationSection(
            "placeholder-api.has-booster.result");

        assert section != null; //handled by configuration system

        String falseMessage = section.getString("false");

        if (this.player == null || !this.player.isOnline()) {
            return falseMessage;
        }

        if (Booster.hasBooster(this.player.getPlayer())) {
            return section.getString("true");
        }

        return falseMessage;
    }

    @Override
    public String visitBooster_multiplier(PlaceholdersParser.Booster_multiplierContext ctx) {
        super.visitBooster_multiplier(ctx);

        if (this.player == null || !this.player.isOnline()) {
            return "0.0";
        }

        Player p = this.player.getPlayer();

        assert p != null; //checked by player.isOnline above

        return String.valueOf(Booster.getMultiplier(p));
    }

    @Override
    public String visitBooster_time_left(PlaceholdersParser.Booster_time_leftContext ctx) {
        super.visitBooster_time_left(ctx);

        if (this.player == null || !this.player.isOnline()) {
            return "0";
        }

        Player p = this.player.getPlayer();

        assert p != null; //checked by player.isOnline above

        int maxTime = 0;

        for (Booster booster : Booster.getBoosters(p)) {
            int remainingTime = booster.getRemainingTime();

            if (remainingTime > maxTime) {
                maxTime = remainingTime;
            }
        }

        return String.valueOf(maxTime);
    }

    @Override
    public String visitBooster_activator(PlaceholdersParser.Booster_activatorContext ctx) {
        super.visitBooster_activator(ctx);

        if (this.player == null || !this.player.isOnline()) {
            return "";
        }

        Player p = this.player.getPlayer();

        assert p != null; //checked by player.isOnline above

        var boosters = Booster.getBoosters(p);

        if (boosters.isEmpty()) {
            return "";
        }

        StringBuilder activators = new StringBuilder();
        boosters.stream()
            .map(booster -> booster.getActivator().getName())
            .distinct()
            .forEach(name -> activators.append(name).append(", "));

        int length = activators.length();

        activators.replace(length - 2, length, "");

        int commaIndex = activators.lastIndexOf(", ");

        if (commaIndex == -1) {
            return activators.toString();
        }

        return activators.replace(commaIndex, commaIndex + 2, " and ").toString();
    }

    @Override
    public String visitStat(PlaceholdersParser.StatContext ctx) {
        super.visitStat(ctx);

        StatType statType;

        try {
            statType = StatType.valueOf(ctx.identifier().getText().toUpperCase());
        } catch (IllegalArgumentException exception) {
            return ctx.getText();
        }

        Stat stat = StatManager.getInstance().getStat(this.player, statType);

        return stat == null ? "0" : String.valueOf(stat.getValue());
    }

    @Override
    public String visitStat_top(PlaceholdersParser.Stat_topContext ctx) {
        super.visitStat_top(ctx);

        StatType statType;

        try {
            statType = StatType.valueOf(ctx.identifier().getText().toUpperCase());
        } catch (IllegalArgumentException exception) {
            return ctx.getText();
        }

        int number;

        try {
            number = Integer.parseInt(ctx.number().getText());
        } catch (NumberFormatException exception) {
            return ctx.getText();
        }

        List<Stat> stats = StatManager.getInstance().getStats(statType);

        if (stats == null) {
            return "0";
        }

        Optional<Integer> value = stats.stream()
            .map(Stat::getValue)
            .sorted(Comparator.reverseOrder())
            .skip(number)
            .findFirst();

        if (value.isEmpty()) {
            return "0";
        }

        return String.valueOf(value.get());
    }
}
