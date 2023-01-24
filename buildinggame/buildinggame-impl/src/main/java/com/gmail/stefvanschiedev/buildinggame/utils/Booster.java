package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

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
     * The object which activated this booster
     */
    @NotNull
    private final CommandSender activator;

    /**
     * The multiplier for this booster
     */
    private final float multiplier;

    /**
     * The remaining time for this booster
     */
    private int remainingTime;

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
    public Booster(@NotNull CommandSender activator, float multiplier, int remainingTime, @Nullable Player player) {
        this.activator = activator;
        this.multiplier = multiplier;
        this.player = player;
        this.remainingTime = remainingTime;
    }

    /**
     * Returns the object which activated this booster
     *
     * @return the activator
     * @since 5.5.2
     */
    @NotNull
    @Contract(pure = true)
    public CommandSender getActivator() {
        return activator;
    }

    /**
     * Returns the multiplier of this booster
     *
     * @return the multiplier
     * @since 5.4.3
     */
    @Contract(pure = true)
    private float getMultiplier() {
        return multiplier;
    }

    /**
     * Returns the player this booster belongs to or null if the booster is global
     *
     * @return the player
     * @since 5.4.3
     */
    @Nullable
    @Contract(pure = true)
    private Player getPlayer() {
        return player;
    }

    /**
     * Returns the amount of time this booster has left in seconds
     *
     * @return the remaining time
     * @since 5.5.2
     */
    @Contract(pure = true)
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * Starts the booster
     *
     * @since 5.4.3
     */
    public void start() {
        Booster booster = this;

        BOOSTERS.add(booster);

        new BukkitRunnable() {
            @Override
            public void run() {
                remainingTime--;

                if (remainingTime == 0) {
                    BOOSTERS.remove(booster);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 20);
    }

    /**
     * Returns a set of boosters applicable for the specified player
     *
     * @param player the player
     * @return the boosters
     */
    @NotNull
    @Contract(pure = true)
    public static Collection<Booster> getBoosters(@NotNull Player player) {
        return BOOSTERS.stream().filter(booster -> player.equals(booster.getPlayer()) || booster.getPlayer() == null)
            .collect(Collectors.toSet());
    }

    /**
     * Returns the multiplier for the player
     *
     * @param player the player
     * @return the multiplier
     * @since 5.4.3
     */
    @Contract(pure = true)
    public static float getMultiplier(@NotNull Player player) {
        return (float) getBoosters(player).stream().mapToDouble(booster -> booster.getMultiplier()).reduce(1,
            (a, b) -> a * b);
    }

    /**
     * Returns true if the player has an active booster, false otherwise
     *
     * @param player the player to check for
     * @return whether a player has a booster
     * @since 5.5.1
     */
    public static boolean hasBooster(Player player) {
        return !getBoosters(player).isEmpty();
    }
}