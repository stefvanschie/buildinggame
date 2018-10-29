package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * A conditional that can be used in certain cases to allow or deny the usage of a specific part of the configuration
 *
 * @since 5.5.2
 */
public final class Conditional {

    /**
     * The operator in between the sides of the conditional
     */
    private Operator operator;

    /**
     * The left and right hand side functions
     */
    private Function<Arena, Integer> leftSide, rightSide;

    /**
     * A map listing all possible functions mapped to their respective names
     */
    private static final Map<String, Function<Arena, Integer>> FUNCTIONS = new HashMap<>();

    /**
     * Creates a new Conditional. Shouldn't be called outside this class.
     */
    private Conditional() {}

    /**
     * Evaluates this conditional, returns true if the conditional is true, false otherwise
     *
     * @param arena the arena this conditional is for
     * @return true if the conditional is true, false otherwise
     * @since 5.5.2
     */
    @Contract(pure = true)
    public boolean evaluate(Arena arena) {
        boolean equals = leftSide.apply(arena).equals(rightSide.apply(arena));

        if (operator == Operator.EQUAL)
            return equals;
        else if (operator == Operator.UNEQUAL)
            return !equals;

        throw new IllegalStateException("Conditional was incorrectly parse");
    }

    /**
     * Returns the left side of this conditional
     *
     * @return the left side
     * @since 5.5.2
     */
    @Nullable
    @Contract(pure = true)
    private Function<Arena, Integer> getLeftSide() {
        return leftSide;
    }

    /**
     * Returns the right side of this conditional
     *
     * @return the right side
     * @since 5.5.2
     */
    @Nullable
    @Contract(pure = true)
    private Function<Arena, Integer> getRightSide() {
        return rightSide;
    }

    /**
     * Sets the left side of this conditional
     *
     * @param function the new left side
     * @since 5.5.2
     */
    private void setLeftSide(Function<Arena, Integer> function) {
        this.leftSide = function;
    }

    /**
     * Sets the operator of this conditional
     *
     * @param operator the new operator
     * @since 5.5.2
     */
    private void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * Sets the right side of this conditional
     *
     * @param function the new right side
     * @since 5.5.2
     */
    private void setRightSide(Function<Arena, Integer> function) {
        this.rightSide = function;
    }

    /**
     * Parses a conditional from a piece of text
     *
     * @param input the text to parse
     * @return the conditional or null if the text couldn't be parsed
     * @since 5.5.2
     */
    @Nullable
    @Contract(pure = true)
    public static Conditional parse(@NotNull String input) {
        var conditional = new Conditional();

        //remove dollar sign in front of text
        input = input.substring(1);

        //check for left side argument
        for (var entry : FUNCTIONS.entrySet()) {
            var name = entry.getKey();

            if (!input.startsWith(name))
                continue;

            input = input.substring(name.length());

            conditional.setLeftSide(entry.getValue());
            break;
        }

        if (conditional.getLeftSide() == null)
            return null;

        //check for operator
        if (input.startsWith("=="))
            conditional.setOperator(Operator.EQUAL);
        else if (input.startsWith("!="))
            conditional.setOperator(Operator.UNEQUAL);
        else
            return null;

        input = input.substring(2);

        //check for right side argument
        for (var entry : FUNCTIONS.entrySet()) {
            var name = entry.getKey();

            if (!input.startsWith(name))
                continue;

            conditional.setRightSide(entry.getValue());
            break;
        }

        if (conditional.getRightSide() == null)
            return null;

        return conditional;
    }

    /**
     * Represents the possible operators for a conditional
     *
     * @since 5.5.2
     */
    public enum Operator {

        /**
         * Tests for equality in between objects
         *
         * @since 5.5.2
         */
        EQUAL,

        /**
         * Test for inequality in between objects
         *
         * Since 5.5.2
         */
        UNEQUAL
    }

    static {
        FUNCTIONS.put("players", Arena::getPlayers);
        FUNCTIONS.put("max-players", Arena::getMaxPlayers);
    }
}