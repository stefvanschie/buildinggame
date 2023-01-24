package com.gmail.stefvanschiedev.buildinggame.utils.math.util;

import com.gmail.stefvanschiedev.buildinggame.utils.math.MathElement;
import org.jetbrains.annotations.Nullable;

/**
 * Builds psi elements
 *
 * @param <T> the element this factory builds
 * @since 5.5.1
 */
@FunctionalInterface
public interface MathFactory<T extends MathElement> {

    /**
     * Instantiates the element based on the input, returns null if it couldn't be parsed
     *
     * @param input the input text
     * @return the element
     * @since 5.5.1
     */
    @Nullable
    T instantiate(String input);
}