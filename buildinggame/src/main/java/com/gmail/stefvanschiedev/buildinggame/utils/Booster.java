package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;

/**
 * A booster which makes you gain extra money at the end of a match.
 *
 * @since 5.4.3
 */
public class Booster {

    /**
     * A collection of all current active boosters
     */
    private static final Collection<Booster> BOOSTERS = new HashSet<>();

    /**
     * The multiplier for this booster
     */
    private final float multiplier;

    /**
     * The player this booster is assigned to, may be null if the booster is global
     */
    @Nullable
    private final Player player;

    /**
     * Constructs a new boosters
     *
     * @param multiplier the multiplier for this booster
     * @param player the player this booster is for, when null this booster is global
     */
    public Booster(float multiplier, @Nullable Player player) {
        this.multiplier = multiplier;
        this.player = player;
    }

    /**
     * Returns the multiplier of this booster
     *
     * @return the multiplier
     */
    @Contract(pure = true)
    private float getMultiplier() {
        return multiplier;
    }

    /**
     * Returns the player this booster belongs to or null if the booster is global
     *
     * @return the player
     */
    @Nullable
    @Contract(pure = true)
    private Player getPlayer() {
        return player;
    }

    /**
     * Starts the booster
     *
     * @param time the time this booster is active in seconds
     */
    public void start(int time) {
        Booster booster = this;

        BOOSTERS.add(booster);

        new BukkitRunnable() {
            @Override
            public void run() {
                BOOSTERS.remove(booster);
            }
        }.runTaskLater(Main.getInstance(), time * 20);
    }

    /**
     * Returns the multiplier for the player
     *
     * @param player the player
     * @return the multiplier
     */
    @Contract(pure = true)
    public static float getMultiplier(@NotNull Player player) {
        return (float) BOOSTERS.stream()
                .filter(booster -> player.equals(booster.getPlayer()) || booster.getPlayer() == null)
                .mapToDouble(booster -> booster.getMultiplier()).reduce(1, (a, b) -> a * b);
    }
}