package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatSign;
import com.google.common.primitives.Chars;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class which updates the statistic signs every tick. Can be ran async.
 *
 * @since 5.8.5
 */
public class StatSignUpdater extends BukkitRunnable {

    /**
     * A map of all replacements and their values
     */
    private static final Map<String, BiFunction<StatSign, Map.Entry<OfflinePlayer, Integer>, String>> REPLACEMENTS;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        Map<StatSign, String[]> signTexts = new HashMap<>();

        SignManager.getInstance().getStatSigns().forEach(sign -> {
            String[] lines = new String[4];
            Sign s = sign.getSign();

            if (config.getBoolean("stats.enable." + sign.getType().toString().toLowerCase(Locale.getDefault())
                .replace("_", "-"))) {
                List<Stat> stats = StatManager.getInstance().getStats(sign.getType());

                if (stats == null)
                    return;

                Stat stat = stats.get(sign.getNumber() - 1);

                for (int i = 0; i < 4; i++)
                    lines[i] = replace(MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()).replace("_", "-") + ".line-" +
                        (i + 1))), sign, stat.getPlayer(), stat.getValue());

            } else {
                lines[0] = "";
                lines[1] = ChatColor.RED + "Stat type";
                lines[2] = ChatColor.RED + "is disabled";
                lines[3] = "";
            }

            signTexts.put(sign, lines);
        });

        if (!Main.getInstance().isEnabled())
            return;

        new BukkitRunnable() {
            @Override
            public void run() {
                signTexts.forEach((statSign, lines) -> {
                    Sign sign = statSign.getSign();
                    int length = lines.length;

                    for (int i = 0; i < length; i++)
                        sign.setLine(i, lines[i]);

                    sign.update();
                });
            }
        }.runTask(Main.getInstance());
    }

    /**
     * Replaces all values in the input with the corresponding values from the {@link #REPLACEMENTS}
     *
     * @param input the input string
     * @param sign the sign to modify
     * @param player the offline player to use
     * @param value the value that belongs to the player
     * @return the new string
     * @since 5.3.0
     */
    @NotNull
    @Contract(value = "null, _, _, _ -> fail", pure = true)
    private String replace(String input, StatSign sign, OfflinePlayer player, int value) {
        List<Character> list = new ArrayList<>(Chars.asList(input.toCharArray()));
        Matcher matcher = Pattern.compile("%([^%]+)%").matcher(input);

        while (matcher.find()) {
            list.subList(matcher.start(), matcher.end()).clear();

            BiFunction<StatSign, Map.Entry<OfflinePlayer, Integer>, String> function = REPLACEMENTS
                .get(matcher.group(1));

            if (function == null)
                continue;

            char[] replacement = function.apply(sign, new AbstractMap.SimpleEntry<>(player, value)).toCharArray();

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

    static {
        REPLACEMENTS = new HashMap<>();
        REPLACEMENTS.put("number", (sign, entry) -> String.valueOf(sign.getNumber()));
        REPLACEMENTS.put("player", (sign, entry) -> {
            OfflinePlayer player = entry.getKey();

            if (player == null)
                return "missingno";

            String name = player.getName();

            return name == null ? "missingno" : name;
        });
        REPLACEMENTS.put("amount", (sign, entry) -> String.valueOf(entry.getValue()));
    }
}
