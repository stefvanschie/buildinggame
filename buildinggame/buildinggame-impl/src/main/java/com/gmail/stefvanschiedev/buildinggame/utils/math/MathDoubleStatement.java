package com.gmail.stefvanschiedev.buildinggame.utils.math;

import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathElementFactory;
import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathFactory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

/**
 * An arithmetic expression made with two elements (e.g. division, subtraction)
 *
 * @since 5.5.1
 */
public final class MathDoubleStatement implements MathElement {

    /**
     * The operator in between the elements
     */
    private final Operator operator;

    /**
     * The left and right hand side elements
     */
    private final MathElement left, right;

    /**
     * Creates a new math element
     *
     * @param left the left hand side element
     * @param right the right hand side element
     */
    private MathDoubleStatement(MathElement left, MathElement right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Contract(pure = true)
    @Override
    public double compute() {
        double left = this.left.compute();
        double right = this.right.compute();

        switch (operator) {
            case ADDITION:
                return left + right;
            case SUBTRACTION:
                return left - right;
            case MULTIPLICATION:
                return left * right;
            case DIVISION:
                return left / right;
        }

        return Double.NaN;
    }

    /**
     * Builds double statements which are either addition or subtraction
     *
     * @since 5.5.1
     */
    public static class AddSubFactory implements MathFactory<MathDoubleStatement> {

        /**
         * The pattern used for parsing this element
         */
        private final Pattern PATTERN = Pattern.compile("([\\s\\S]+)([+\\-])([\\s\\S]+)");

        /**
         * {@inheritDoc}
         *
         * @since 5.5.1
         */
        @Nullable
        @Override
        public MathDoubleStatement instantiate(String input) {
            var matcher = PATTERN.matcher(input);

            if (!matcher.matches())
                return null;

            Operator operator;
            var operatorString = matcher.group(2);

            switch (operatorString) {
                case "+":
                    operator = Operator.ADDITION;
                    break;
                case "-":
                    operator = Operator.SUBTRACTION;
                    break;
                default:
                    return null;
            }

            return new MathDoubleStatement(MathElementFactory.parseText(matcher.group(1)),
                MathElementFactory.parseText(matcher.group(3)), operator);
        }
    }

    /**
     * Builds double statements which are either multiplication or division
     *
     * @since 5.5.1
     */
    public static class MulDivFactory implements MathFactory<MathDoubleStatement> {

        /**
         * The pattern used for parsing this element
         */
        private final Pattern PATTERN = Pattern.compile("([\\s\\S]+)[*\\\\]([\\s\\S]+)");

        /**
         * {@inheritDoc}
         *
         * @since 5.5.1
         */
        @Nullable
        @Override
        public MathDoubleStatement instantiate(String input) {
            var matcher = PATTERN.matcher(input);

            if (!matcher.matches())
                return null;

            Operator operator;
            var operatorString = matcher.group(2);

            switch (operatorString) {
                case "*":
                    operator = Operator.MULTIPLICATION;
                    break;
                case "\\":
                    operator = Operator.DIVISION;
                    break;
                default:
                    return null;
            }

            return new MathDoubleStatement(MathElementFactory.parseText(matcher.group(1)),
                MathElementFactory.parseText(matcher.group(3)), operator);
        }
    }

    /**
     * Represents an operator in between a double statement
     *
     * @since 5.5.1
     */
    public enum Operator {

        /**
         * Represents addition
         *
         * @since 5.5.1
         */
        ADDITION,

        /**
         * Represents subtraction
         *
         * @since 5.5.1
         */
        SUBTRACTION,

        /**
         * Represents multiplication
         *
         * @since 5.5.1
         */
        MULTIPLICATION,

        /**
         * Represents division
         *
         * Since 5.5.1
         */
        DIVISION
    }
}