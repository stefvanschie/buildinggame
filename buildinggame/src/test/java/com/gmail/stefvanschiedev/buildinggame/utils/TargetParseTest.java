package com.gmail.stefvanschiedev.buildinggame.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests whether the Target class parses correctly
 */
class TargetParseTest {

    /**
     * Tests the Target class to see whether it parses text correctly
     */
    @Test
    void testWhetherTargetParsesCorrectly() {
        assertNotNull(Target.parse("console"));
        assertNotNull(Target.parse("game-players"));
    }
}
