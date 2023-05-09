package com.gmail.stefvanschiedev.buildinggame.game.util.timed;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.TransitionSystem;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Represents a game phase which has a timer baking it. Once the timer ends, the game is transitioned to the next phase.
 * This class will invoke method annotated by {@link At} and {@link Every}. For each time, any method is only invoked
 * once. For example, when a method has both annotations and both annotations are applicable, only one will be invoked.
 *
 * @since 12.2.0
 */
public abstract class TimedGamePhase<T extends TransitionSystem> extends GamePhase {

    /**
     * A transition system managing this game phase.
     */
    @NotNull
    protected final T transitionSystem;

    /**
     * The amount of time that is still remaining, specified in seconds.
     */
    private int remainingTime;

    /**
     * The amount of time this timer will start or has started from, in seconds.
     */
    private final int originalTime;

    /**
     * Whether the timer is currently active.
     */
    private boolean isRunning = false;

    /**
     * A map containing all the times when the attached method should be invoked.
     */
    @NotNull
    private final Map<? super Integer, Collection<Method>> scheduledInvocations = new HashMap<>();

    /**
     * The underlying timer. May be null if this phase hasn't started yet.
     */
    @Nullable
    private BukkitTask task;

    /**
     * The amount of ticks there are in a single second.
     */
    private static final int TICKS_PER_SECOND = 20;

    /**
     * Creates a new timed game phase, which lasts the specified amount of time. This time is given in seconds. Once
     * this time is over, the game will transition to the next game phase as returned by {@link #getNextPhase()}. This
     * timer does not start automatically upon calling this constructor.
     *
     * @param transitionSystem the transition system managing this game phase
     * @param time how long it takes for this timer to end
     * @since 12.2.0
     */
    public TimedGamePhase(@NotNull T transitionSystem, int time) {
        this.transitionSystem = transitionSystem;
        this.originalTime = time;
        this.remainingTime = time;

        for (Method method : getClass().getMethods()) {
            At annotation = method.getAnnotation(At.class);

            if (annotation == null) {
                continue;
            }

            String name = method.getName();

            if (method.getParameterCount() != 0) {
                throw new IllegalStateException("Method '" + name +
                    "' annotated by At may not have any parameter types");
            }

            int[] remainingTimes = annotation.value();

            for (int remainingTime : remainingTimes) {
                if (remainingTime < 0) {
                    throw new IllegalStateException("At annotation on method '" + name +
                        "' may not contain times lower than zero");
                }
            }

            for (int index = 0; index < remainingTimes.length; index++) {
                for (int j = 0; j < index; j++) {
                    if (remainingTimes[j] == remainingTimes[index]) {
                        throw new IllegalStateException("At annotation on method '" + name +
                            "' may not contain duplicate times");
                    }
                }
            }

            for (int remainingTime : remainingTimes) {
                this.scheduledInvocations.computeIfAbsent(remainingTime, (key) -> new HashSet<>()).add(method);
            }
        }

        for (Method method : getClass().getMethods()) {
            Every annotation = method.getAnnotation(Every.class);

            if (annotation == null) {
                continue;
            }

            String name = method.getName();

            if (method.getParameterCount() != 0) {
                throw new IllegalStateException("Method '" + name +
                    "' annotated by Every may not have any parameter types");
            }

            int timeInterval = annotation.value();

            if (timeInterval <= 0) {
                throw new IllegalStateException("Every annotation on method '" + name +
                    "' may not have a time of zero or lower");
            }

            for (int interval = timeInterval; interval <= time; interval += timeInterval) {
                this.scheduledInvocations.computeIfAbsent(interval, (key) -> new HashSet<>()).add(method);
            }
        }
    }

    @Override
    public void onPhaseStart() {
        this.task = new BukkitRunnable() {
            @Override
            public void run() {
                if (!TimedGamePhase.this.isRunning) {
                    return;
                }

                Collection<Method> methods = TimedGamePhase.this.scheduledInvocations.getOrDefault(
                    TimedGamePhase.this.remainingTime,
                    Collections.emptySet()
                );

                invokeMethods(methods);

                if (TimedGamePhase.this.remainingTime == 0) {
                    endPhase();
                }

                TimedGamePhase.this.remainingTime--;
            }
        }.runTaskTimer(Main.getInstance(), 0, TICKS_PER_SECOND);
    }

    /**
     * {@inheritDoc}
     *
     * This will also be invoked when the timer has ended. If this is the case, this method will be invoked after the
     * transition to the next phase has occurred. If the phase has not started yet, this will throw an
     * {@link IllegalStateException}.
     *
     * @since 12.2.0
     */
    @Override
    public void onPhaseEnd() {
        if (this.task == null) {
            throw new IllegalStateException("Phase hasn't started yet");
        }

        this.task.cancel();
    }

    @Override
    public void forceEnd() {
        if (this.task != null) {
            this.task.cancel();
        }
    }

    /**
     * Resets the timer, stopping it if it was active.
     *
     * @since 12.2.0
     */
    public void resetTimer() {
        this.isRunning = false;
        this.remainingTime = this.originalTime;
    }

    /**
     * Ends the timer, proceeding to the next state at the next interval.
     *
     * @since 12.2.0
     */
    public void endTimer() {
        endPhase();
    }

    /**
     * This starts the timer. If the timer was paused before, this will resume the timer. If the timer was already
     * running, this will silently do nothing.
     *
     * @since 12.2.0
     */
    public void startTimer() {
        this.isRunning = true;
    }

    /**
     * This pauses the timer. If the timer was already paused, this will throw an {@link IllegalStateException}.
     *
     * @since 12.2.0
     */
    public void pauseTimer() {
        this.isRunning = false;
    }

    /**
     * Gets the remaining time that is left before this timer finishes.
     *
     * @return the remaining time
     * @since 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    public Duration getRemainingTime() {
        return Duration.of(this.remainingTime, ChronoUnit.SECONDS);
    }

    /**
     * Gets the original time this timer will start or has started at.
     *
     * @return the remaining time
     * @since 12.2.0
     */
    public int getOriginalTime() {
        return originalTime;
    }

    /**
     * Gets the game phase to transition to after this timer has finished.
     *
     * @return the next game phase
     * @since 12.2.0
     */
    @NotNull
    public abstract GamePhase getNextPhase();

    /**
     * Ends this phase.
     *
     * @since 12.2.0
     */
    private void endPhase() {
        onPhaseEnd();

        this.transitionSystem.transition(getNextPhase());
    }

    /**
     * Invokes all the methods in the provided collection. These methods must not have any parameters. The methods will
     * be invoked from this instance.
     *
     * @param toInvoke the methods to invoke
     * @since 12.2.0
     */
    private void invokeMethods(@NotNull Collection<? extends Method> toInvoke) {
        for (Method method : toInvoke) {
            if (method.getParameterCount() != 0) {
                throw new IllegalArgumentException("Unable to invoke method with parameters");
            }

            try {
                method.invoke(this);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
