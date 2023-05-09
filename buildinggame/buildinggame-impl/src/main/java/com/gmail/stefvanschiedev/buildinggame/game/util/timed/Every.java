package com.gmail.stefvanschiedev.buildinggame.game.util.timed;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for methods in a {@link TimedGamePhase}. The methods annotated with this annotation will be called
 * every time there is a multiple of the specified amount of time remaining.
 *
 * @since 12.2.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Every {

    /**
     * Specifies the remaining time for which the method this annotation is attached to will be called, each time a
     * multiple of this value is left in a {@link TimedGamePhase}. For example, when 10 is specified, the method this
     * annotation is attached to will be called on every multiple of 10, such as 50, 40, and 20, but also 10 itself, but
     * not zero. The amount specified must be positive.
     *
     * @return the remaining seconds
     * @since 12.2.0
     */
    int value();
}
