package com.gmail.stefvanschiedev.buildinggame.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests whether conditionals parse text correctly
 */
class ConditionalParseTest {

    /**
     * Tests to see whether conditionals parse correctly
     */
    @Test
    void testWhetherConditionalParsesCorrectly() {
        assertNotNull(Conditional.parse("$players==max-players"));
        assertNotNull(Conditional.parse("$players!=max-players"));
    }
}
