package com.gmail.stefvanschiedev.buildinggame.utils.math;

import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests parsing math numbers
 */
class MathNumberParseTest {

    /**
     * Parses a variety of numbers and see if they are parsed correctly
     */
    @Test
    void testWhetherNumbersAreParsedCorrectly() {
        MathFactory<MathNumber> factory = new MathNumber.Factory();

        assertEquals(1, factory.instantiate("1").compute());
        assertEquals(49, factory.instantiate("49").compute());
        assertEquals(-1, factory.instantiate("-1").compute());
        assertEquals(-47, factory.instantiate("-47").compute());
        assertEquals(6.6, factory.instantiate("6.6").compute());
        assertEquals(33.2, factory.instantiate("33.2").compute());
        assertEquals(5.52, factory.instantiate("5.52").compute());
        assertEquals(64.45, factory.instantiate("64.45").compute());
        assertEquals(-2.3, factory.instantiate("-2.3").compute());
        assertEquals(-48.8, factory.instantiate("-48.8").compute());
        assertEquals(-6.62, factory.instantiate("-6.62").compute());
        assertEquals(-24.62, factory.instantiate("-24.62").compute());
    }
}
