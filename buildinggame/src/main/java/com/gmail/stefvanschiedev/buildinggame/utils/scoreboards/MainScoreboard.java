package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.google.common.primitives.Chars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when you're in the main hub
 *
 * @since 3.1.1
 */
public class MainScoreboard {

    /**
     * The scoreboard this class is a wrapper for
     */
	private final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

    /**
     * The objective used for this scoreboard
     */
    private final Objective objective = scoreboard.registerNewObjective("bg-main", "dummy");

    /**
     * A list of the text to display on the scoreboard after the basic placeholders have been parsed
     */
    private final List<String> strings = new ArrayList<>();

    /**
     * A list of teams that's used to hold the text
     */
    private final List<Team> teams = new ArrayList<>();

    /**
     * The player that this scoreboard is meant for
     */
    private final Player player;

    /**
     * A map of replacements for placeholders
     */
    private final Map<String, Supplier<String>> replacements = new HashMap<>();

    /**
     * The pattern that will be used when matching {@link #replacements}
     */
    private static final Pattern PATTERN = Pattern.compile("%([^%]+)%");

    /**
     * Constructs a new MainScoreboard
     *
     * @param player the player this scoreboard is meant for
     */
	public MainScoreboard(Player player) {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        this.player = player;

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(MessageManager.translate(messages.getString("scoreboards.main.header"), player));
		
		List<String> strings = messages.getStringList("scoreboards.main.text");
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = scoreboard.registerNewTeam(i + "");
			team.addEntry(ChatColor.values()[i].toString());
			team.setDisplayName("");
			
			teams.add(team);
			this.strings.add(MessageManager.translate(strings.get(i), player));
		}

		replacements.put("stat_plays", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.PLAYS);

            return stat == null ? "0" : String.valueOf(stat.getValue());
		});
		replacements.put("stat_first", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.FIRST);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
		replacements.put("stat_second", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.SECOND);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_third", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.THIRD);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_broken", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.BROKEN);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_placed", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.PLACED);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_walked", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.WALKED);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_points_received", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.POINTS_RECEIVED);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("stat_points_given", () -> {
            Stat stat = StatManager.getInstance().getStat(player, StatType.POINTS_GIVEN);

            return stat == null ? "0" : String.valueOf(stat.getValue());
        });
        replacements.put("date_day_of_month", () -> String.valueOf(LocalDateTime.now().getDayOfMonth()));
        replacements.put("date_day_of_week", () -> String.valueOf(LocalDateTime.now().getDayOfWeek()));
        replacements.put("date_day_of_year", () -> String.valueOf(LocalDateTime.now().getDayOfYear()));
        replacements.put("date_hour", () -> String.valueOf(LocalDateTime.now().getHour()));
        replacements.put("date_minute", () -> String.valueOf(LocalDateTime.now().getMinute()));
        replacements.put("date_month", () -> LocalDateTime.now().getMonth().getDisplayName(TextStyle.FULL, Locale
            .getDefault()));
        replacements.put("date_month_numeric", () -> String.valueOf(LocalDateTime.now().getMonthValue()));
        replacements.put("date_second", () -> String.valueOf(LocalDateTime.now().getSecond()));
        replacements.put("date_year", () -> String.valueOf(LocalDateTime.now().getYear()));
	}

    /**
     * Returns the player this scoreboard is tracking
     *
     * @return the player
     * @since 5.0.4
     */
	@NotNull
	@Contract(pure = true)
	public Player getPlayer() {
	    return player;
    }

    /**
     * Shows the scoreboard for the player
     *
     * @since 2.3.0
     */
	public void show() {
		if (!player.isOnline())
			return;

		for (int i = 0; i < strings.size(); i++) {
			Team team = teams.get(i);
			String text = replace(strings.get(i));
			int length = text.length();
			
			team.setPrefix(text.substring(0, length > 16 ? 16 : length));
			
			if (length > 16)
				team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + text.substring(16, length > 32 ? 32 :
                        length));
			
			objective.getScore(ChatColor.values()[i].toString()).setScore(strings.size() - i);
		}

		player.setScoreboard(scoreboard);
	}

    /**
     * Replaces all values in the input with the corresponding values from the {@link #replacements}
     *
     * @param input the input string
     * @return the new string
     * @since 5.3.0
     */
    @NotNull
    @Contract(value = "null -> fail", pure = true)
    private String replace(@NotNull String input) {
        List<Character> list = new ArrayList<>(Chars.asList(input.toCharArray()));
        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            list.subList(matcher.start(), matcher.end()).clear();

            Supplier<String> supplier = replacements.get(matcher.group(1));

            if (supplier == null)
                continue;

            char[] replacement = supplier.get().toCharArray();

            int length = replacement.length;
            for (int i = 0; i < length; i++)
                list.add(matcher.start() + i, replacement[i]);

            StringBuilder builder = new StringBuilder();

            for (char c : list)
                builder.append(c);

            input = builder.toString();

            matcher.reset(input);
        }

        return input;
    }
}