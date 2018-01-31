package com.gmail.stefvanschiedev.buildinggame.utils.math;

import org.jetbrains.annotations.Contract;

/**
 * A math element
 *
 * @since 5.5.1
 */
@FunctionalInterface
public interface MathElement {

    /**
     * Computes this element
     *
     * @return the value this computation yields
     * @since 5.5.1
     */
    @Contract(pure = true)
    double compute();
}