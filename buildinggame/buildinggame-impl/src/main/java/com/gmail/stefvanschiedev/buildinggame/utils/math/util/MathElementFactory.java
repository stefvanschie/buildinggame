package com.gmail.stefvanschiedev.buildinggame.utils.math.util;

import com.gmail.stefvanschiedev.buildinggame.utils.math.MathDoubleStatement;
import com.gmail.stefvanschiedev.buildinggame.utils.math.MathElement;
import com.gmail.stefvanschiedev.buildinggame.utils.math.MathNumber;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Factory for parsing text into math elements
 */
public final class MathElementFactory {

    /**
     * A private constructor since this is a utility class
     */
    private MathElementFactory() {}

    /**
     * An array of all possible factories
     */
    private static final MathFactory<?>[] FACTORIES = new MathFactory<?>[] {
        new MathNumber.Factory(),
        new MathDoubleStatement.AddSubFactory(),
        new MathDoubleStatement.MulDivFactory()
    };

    /**
     * Parses text into math elements
     *
     * @param input the input to parse
     * @return the element
     * @since 5.5.1
     */
    @Nullable
    @Contract("null -> fail")
    public static MathElement parseText(String input) {
        input = input.trim();

        for (MathFactory<?> factory : FACTORIES) {
            MathElement element = factory.instantiate(input);

            if (element != null)
                return element;
        }

        return null;
    }
}