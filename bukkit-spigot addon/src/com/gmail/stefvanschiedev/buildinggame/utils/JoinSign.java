package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Base class for join signs
 */
public class JoinSign {

    private static final Collection<JoinSign> SIGNS = new HashSet<>();

    private final String arenaName;
    private final Sign sign;

    private JoinSign(String arenaName, Sign sign) {
        this.arenaName = arenaName;
        this.sign = sign;
    }

    public String getArenaName() {
        return arenaName;
    }

    public Sign getSign() {
        return sign;
    }

    public static void load() {
        YamlConfiguration signs = SettingsManager.getInstance().getSigns();

        getSigns().clear();

        for (String key : signs.getKeys(false)) {
            World world = Bukkit.getWorld(signs.getString(key + ".world"));
            if (world == null) {
                signs.set(key, null);
                continue;
            }

            BlockState blockState = new Location(world, signs.getInt(key + ".x"), signs.getInt(key + ".y"),
                    signs.getInt(key + ".z")).getBlock().getState();

            if (!(blockState instanceof Sign)) {
                signs.set(key, null);
                continue;
            }

            getSigns().add(new JoinSign(signs.getString(key + ".arena"), (Sign) blockState));
        }
    }

    public static Collection<JoinSign> getSigns() {
        return SIGNS;
    }

    public static Set<JoinSign> getSigns(String arenaName) {
        Set<JoinSign> joinSigns = new HashSet<>();

        for (JoinSign joinSign : SIGNS) {
            if (joinSign.getArenaName().equals(arenaName))
                joinSigns.add(joinSign);
        }

        return joinSigns;
    }
}
