package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatSign;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiFunction;

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

            if (sign.getType().isEnabled(config)) {
                var stats = StatManager.getInstance().getStats(sign.getType());

                if (stats == null)
                    return;

                OfflinePlayer offlinePlayer = null;
                int value = -1;

                if (stats.size() > sign.getNumber() - 1) {
                    Stat stat = stats.get(sign.getNumber() - 1);

                    offlinePlayer = stat.getPlayer();
                    value = stat.getValue();
                }

                for (int i = 0; i < 4; i++)
                    lines[i] = replace(MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()).replace("_", "-") + ".line-" +
                        (i + 1))), sign, offlinePlayer, value);

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
                    PotentialBlockPosition blockPos = statSign.getBlockPosition();

                    Block block = blockPos.getBlock();

                    if (block == null || !(block.getState() instanceof Sign)) {
                        return;
                    }

                    Sign sign = (Sign) block.getState();
                    var length = lines.length;

                    for (var i = 0; i < length; i++)
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
    private String replace(String input, StatSign sign, @Nullable OfflinePlayer player, int value) {
        var pair = new AbstractMap.SimpleEntry<>(player, value);

        for (Map.Entry<String, BiFunction<StatSign, Map.Entry<OfflinePlayer, Integer>, String>> entry : REPLACEMENTS
            .entrySet()) {
            input = input.replace('%' + entry.getKey() + '%', entry.getValue().apply(sign, pair));
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

            var name = player.getName();

            return name == null ? "missingno" : name;
        });
        REPLACEMENTS.put("amount", (sign, entry) -> String.valueOf(entry.getValue()));
    }
}
