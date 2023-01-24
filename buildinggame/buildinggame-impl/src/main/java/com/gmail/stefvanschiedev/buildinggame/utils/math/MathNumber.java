package com.gmail.stefvanschiedev.buildinggame.utils.math;

import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathFactory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a basic number
 */
public final class MathNumber implements MathElement {

    /**
     * The number this element represents
     */
    private final double number;

    /**
     * Creates a new math element
     *
     * @param number the number
     * @since 5.5.1
     */
    private MathNumber(double number) {
        this.number = number;
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Contract(pure = true)
    @Override
    public double compute() {
        return number;
    }

    /**
     * Builds number statements
     *
     * @since 5.5.1
     */
    public static class Factory implements MathFactory<MathNumber> {

        /**
         * {@inheritDoc}
         *
         * @since 5.5.1
         */
        @Nullable
        @Override
        public MathNumber instantiate(String input) {
            double number;

            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                return null;
            }

            return new MathNumber(number);
        }
    }
}
