package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import me.robin.leaderheads.api.LeaderHeadsAPI;
import me.robin.leaderheads.datacollectors.DataCollector;
import me.robin.leaderheads.objects.BoardType;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.*;

/**
 * Base class for all tracked LeaderHeads statistics for this plugin
 *
 * @since 5.1.0
 */
public class LeaderHeadsStatistic extends DataCollector {

    /**
     * YAML configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The statistic type of this statistic
     */
    private final StatType statType;

    /**
     * Constructs a new leader heads statistic
     *
     * @param statType the statistic type this statistic refers to
     */
    public LeaderHeadsStatistic(StatType statType) {
        super("bg-" + statType.toString().toLowerCase(Locale.getDefault()), Main.getInstance().getName(),
                BoardType.DEFAULT, MessageManager.translate(MESSAGES.getString("leader-heads." + statType
                        .toString().toLowerCase(Locale.getDefault()).replace("_", "-") + ".title")),
                "bglh-" + statType.toString().toLowerCase(Locale.getDefault()), Arrays.asList(
                        MessageManager.translate(MESSAGES.getString("leader-heads." + statType.toString()
                                .toLowerCase(Locale.getDefault()).replace("_", "-") +
                                ".lines.line-1")),
                        MessageManager.translate(MESSAGES.getString("leader-heads." + statType.toString()
                                .toLowerCase(Locale.getDefault()).replace("_", "-") +
                                ".lines.line-2")),
                        MessageManager.translate(MESSAGES.getString("leader-heads." + statType.toString()
                                .toLowerCase(Locale.getDefault()).replace("_", "-") +
                                ".lines.line-3")),
                        MessageManager.translate(MESSAGES.getString("leader-heads." + statType.toString()
                                .toLowerCase(Locale.getDefault()).replace("_", "-") +
                                ".lines.line-4"))), true, UUID.class);

        this.statType = statType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map.Entry<?, Double>> requestAll() {
        Map<UUID, Double> map = new HashMap<>();

        StatManager.getInstance().getStats(statType).forEach(stat -> map.put(stat.getPlayer().getUniqueId(),
                (double) stat.getValue()));

        return LeaderHeadsAPI.sortMap(map);
    }
}
