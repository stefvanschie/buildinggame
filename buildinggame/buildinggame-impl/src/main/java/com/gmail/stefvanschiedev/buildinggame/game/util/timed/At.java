package com.gmail.stefvanschiedev.buildinggame.game.util.timed;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for methods in a {@link TimedGamePhase}. The methods annotated with this annotation will be called when
 * there are exactly the specified amount of seconds remaining.
 *
 * @since 12.2.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface At {

    /**
     * An array of remaining times. For each of the specified times, the method this annotation is attached to will be
     * invoked when the timer has this many seconds remaining. The integers within the array must be unique and must be
     * non-negative. If this array includes the value 0, the method this annotation is attached to will be invoked when
     * the timer has ended, before {@link TimedGamePhase#onPhaseEnd()} will be called.
     *
     * @return the remaining seconds
     * @since 12.2.0
     */
    int[] value();

}
