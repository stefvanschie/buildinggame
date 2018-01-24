package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.google.common.primitives.Chars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The base class for all scoreboards that belong to an arena
 *
 * @since 5.1.0
 */
public abstract class ArenaScoreboard {

    /**
     * The global scoreboard manager
     */
    private final ScoreboardManager manager = Bukkit.getScoreboardManager();

    /**
     * The scoreboard this class is a wrapper for
     */
    final Scoreboard scoreboard = manager.getNewScoreboard();

    /**
     * The objective used for this scoreboard
     */
    final Objective objective = scoreboard.registerNewObjective("bg-build", "dummy");

    /**
     * A list of the text to display on the scoreboard after the basic placeholders have been parsed
     */
    private final List<String> strings = new ArrayList<>();

    /**
     * A list of teams that's used to hold the text
     */
    private final List<Team> teams = new ArrayList<>();

    /**
     * A map of replacements for placeholders
     */
    private final Map<String, Function<Player, String>> replacements = new HashMap<>();

    /**
     * Constructs a new arena scoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
    ArenaScoreboard(Arena arena) {
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(getHeader());

        List<String> strings = getLines();

        for (int i = 0; i < strings.size(); i++) {
            Team team = scoreboard.registerNewTeam(i + "");
            team.addEntry(ChatColor.values()[i].toString());
            team.setDisplayName("");

            teams.add(team);
            this.strings.add(MessageManager.translate(strings.get(i)));
        }

        //initialize replacements
        replacements.put("arena", player -> arena.getName());
        replacements.put("players", player -> String.valueOf(arena.getPlayers()));
        replacements.put("max_players", player -> String.valueOf(arena.getMaxPlayers()));
        replacements.put("subject", player -> arena.getSubject());
        replacements.put("seconds", player -> {
            Timer timer = arena.getActiveTimer();

            return timer == null ? "0" : String.valueOf(timer.getSeconds());
        });
        replacements.put("minutes", player -> {
            Timer timer = arena.getActiveTimer();

            return timer == null ? "0" : String.valueOf(timer.getMinutes());
        });
        replacements.put("plot", player -> String.valueOf(arena.getPlot(player).getID()));
        replacements.put("time", player -> {
            Timer timer = arena.getActiveTimer();

            return timer == null ? "0" : timer.getMinutes() + ":" + timer.getSecondsFromMinute();
        });
        replacements.put("seconds_from_minute", player -> {
            Timer timer = arena.getActiveTimer();

            return timer == null ? "0" : String.valueOf(timer.getSecondsFromMinute());
        });
        replacements.put("blocks_placed", player -> String.valueOf(arena.getPlot(player).getGamePlayer(player)
                .getBlocksPlaced()));
        replacements.put("money", player ->
                SDVault.getInstance().isEnabled() ? String.valueOf(SDVault.getEconomy().getBalance(player)) : "0");
        replacements.put("vote", player -> {
            Plot plot = arena.getVotingPlot();

            return plot == null ? "0" : plot.getVote(player) == null ? "0" : plot.getVote(player) + "";
        });
        replacements.put("playerplot", player -> {
            Plot votingPlot = arena.getVotingPlot();
            Plot plot = arena.getPlot(player);

            return votingPlot == null ? plot == null ? "?" : plot.getPlayerFormat() : votingPlot.getPlayerFormat();
        });
        replacements.put("date_day_of_month", player -> String.valueOf(LocalDateTime.now().getDayOfMonth()));
        replacements.put("date_day_of_week", player -> String.valueOf(LocalDateTime.now().getDayOfWeek()));
        replacements.put("date_day_of_year", player -> String.valueOf(LocalDateTime.now().getDayOfYear()));
        replacements.put("date_hour", player -> String.valueOf(LocalDateTime.now().getHour()));
        replacements.put("date_minute", player -> String.valueOf(LocalDateTime.now().getMinute()));
        replacements.put("date_month", player -> LocalDateTime.now().getMonth().getDisplayName(TextStyle.FULL,
                Locale.getDefault()));
        replacements.put("date_month_numeric", player -> String.valueOf(LocalDateTime.now().getMonthValue()));
        replacements.put("date_second", player -> String.valueOf(LocalDateTime.now().getSecond()));
        replacements.put("date_year", player -> String.valueOf(LocalDateTime.now().getYear()));
        replacements.put("vote_name", player -> {
            YamlConfiguration messages = SettingsManager.getInstance().getMessages();
            Plot votingPlot = arena.getVotingPlot();

            if (votingPlot == null)
                return "?";

            Vote vote = votingPlot.getVote(player);

            if (vote == null)
                return "?";

            switch (vote.getPoints()) {
                case 2:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.second-slot-block"));
                case 3:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.third-slot-block"));
                case 4:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.fourth-slot-block"));
                case 5:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.fifth-slot-block"));
                case 6:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.sixth-slot-block"));
                case 7:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.seventh-slot-block"));
                case 8:
                    return ChatColor.translateAlternateColorCodes('&', messages
                            .getString("voting.eighth-slot-block"));
                default:
                    return "?";
            }
        });
        replacements.put("first_players", player -> {
            Plot firstPlot = arena.getFirstPlot();

            return firstPlot == null ? "?" : firstPlot.getPlayerFormat();
        });
        replacements.put("second_players", player -> {
            Plot secondPlot = arena.getSecondPlot();

            return secondPlot == null ? "?" : secondPlot.getPlayerFormat();
        });
        replacements.put("third_players", player -> {
            Plot thirdPlot = arena.getThirdPlot();

            return thirdPlot == null ? "?" : thirdPlot.getPlayerFormat();
        });
    }

    /**
     * Updates/Shows the scoreboard for the specified player
     *
     * @param player the player to update the scoreboard for
     * @since 5.3.0
     */
    @Contract("null -> fail")
    public void show(Player player) {
        for (int i = 0; i < strings.size(); i++) {
            String text = replace(strings.get(i), player);

            int length = text.length();
            Team team = teams.get(i);

            team.setPrefix(text.substring(0, length > 16 ? 16 : length));

            if (length > 16)
                team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + text.substring(16, length > 32 ? 32 :
                        length));

            objective.getScore(ChatColor.values()[i].toString()).setScore(strings.size() - i);
        }

        player.setScoreboard(scoreboard);
    }

    /**
     * Replaces all values in the input with the corresponding values from the {@link ArenaScoreboard#replacements}
     *
     * @param input the input string
     * @param player the player
     * @return the new string
     * @since 5.3.0
     */
    @NotNull
    @Contract(value = "null, _ -> fail", pure = true)
    private String replace(String input, Player player) {
        List<Character> list = new ArrayList<>(Chars.asList(input.toCharArray()));
        Matcher matcher = Pattern.compile("%([^%]+)%").matcher(input);

        while (matcher.find()) {
            for (int i = matcher.start(); i < matcher.end(); i++)
                list.remove(matcher.start());

            Function<Player, String> function = replacements.get(matcher.group(1));

            if (function == null)
                continue;

            char[] replacement = function.apply(player).toCharArray();

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

    /**
     * Returns the header of this scoreboard
     *
     * @return the header
     * @since 5.1.0
     */
    @Nls
    @NotNull
    @Contract(pure = true)
    protected abstract String getHeader();

    /**
     * Returns a list of all displayed lines
     *
     * @return a list of lines
     * @since 5.1.0
     */
    @NotNull
    @Contract(pure = true)
    protected abstract List<String> getLines();
}