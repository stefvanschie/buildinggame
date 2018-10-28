package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Base class for join signs
 *
 * @since 4.0.6
 */
public final class JoinSign {

    /**
     * A collection fo all registered join signs
     */
    private static final Collection<JoinSign> SIGNS = new HashSet<>();

    /**
     * The arena name this join sign points to
     */
    private final String arenaName;

    /**
     * The sign this class is a wrapper for
     */
    private final Sign sign;

    /**
     * Constructs a new join sign with the given arena and sign
     *
     * @param arenaName the arena you'll join when clicking this sign
     * @param sign the sign this class's a wrapper for
     */
    private JoinSign(String arenaName, Sign sign) {
        this.arenaName = arenaName;
        this.sign = sign;
    }

    /**
     * Returns the arena name assigned to this join sign
     *
     * @return the arena name
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    public String getArenaName() {
        return arenaName;
    }

    /**
     * Returns the sign this class is a wrapper for
     *
     * @return the sign
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    public Sign getSign() {
        return sign;
    }

    /**
     * Reloads all signs from the signs.yml
     *
     * @since 4.0.6
     */
    public static void load() {
        YamlConfiguration signs = SettingsManager.getInstance().getSigns();

        getSigns().clear();

        signs.getKeys(false).forEach(key -> {
            var world = Bukkit.getWorld(signs.getString(key + ".world"));

            if (world == null) {
                signs.set(key, null);
                return;
            }

            var blockState = new Location(world, signs.getInt(key + ".x"), signs.getInt(key + ".y"),
                    signs.getInt(key + ".z")).getBlock().getState();

            if (!(blockState instanceof Sign)) {
                signs.set(key, null);
                return;
            }

            getSigns().add(new JoinSign(signs.getString(key + ".arena"), (Sign) blockState));
        });
    }

    /**
     * Returns a collection of all registered join signs
     *
     * @return all join signs
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    public static Collection<JoinSign> getSigns() {
        return SIGNS;
    }

    /**
     * Returns a set with all join signs that point to the provided arena name
     *
     * @param arenaName the arena name to collect signs for
     * @return all join signs with the given arena name
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    public static Set<JoinSign> getSigns(String arenaName) {
        return SIGNS.stream().filter(joinSign -> joinSign.getArenaName().equals(arenaName)).collect(Collectors.toSet());
    }
}
