package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.DyeColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests whether the materials are mapped correctly
 */
class MappedMaterialUtilTest {

    /**
     * Tests whether the wool items belong to the correct dye color
     *
     * @since 6.2.0
     */
    @Test
    void testCorrectMaterialMappings() {
        MappedMaterialUtil.WOOL_DYE_COLOR_ITEMS.forEach(entry -> {
            DyeColor dyeColor = entry.getValue();

            switch (entry.getKey()) {
                case WHITE_WOOL:
                    assertEquals(dyeColor, DyeColor.WHITE);
                    break;
                case ORANGE_WOOL:
                    assertEquals(dyeColor, DyeColor.ORANGE);
                    break;
                case MAGENTA_WOOL:
                    assertEquals(dyeColor, DyeColor.MAGENTA);
                    break;
                case LIGHT_BLUE_WOOL:
                    assertEquals(dyeColor, DyeColor.LIGHT_BLUE);
                    break;
                case YELLOW_WOOL:
                    assertEquals(dyeColor, DyeColor.YELLOW);
                    break;
                case LIME_WOOL:
                    assertEquals(dyeColor, DyeColor.LIME);
                    break;
                case PINK_WOOL:
                    assertEquals(dyeColor, DyeColor.PINK);
                    break;
                case GRAY_WOOL:
                    assertEquals(dyeColor, DyeColor.GRAY);
                    break;
                case LIGHT_GRAY_WOOL:
                    assertEquals(dyeColor, DyeColor.LIGHT_GRAY);
                    break;
                case CYAN_WOOL:
                    assertEquals(dyeColor, DyeColor.CYAN);
                    break;
                case PURPLE_WOOL:
                    assertEquals(dyeColor, DyeColor.PURPLE);
                    break;
                case BLUE_WOOL:
                    assertEquals(dyeColor, DyeColor.BLUE);
                    break;
                case BROWN_WOOL:
                    assertEquals(dyeColor, DyeColor.BROWN);
                    break;
                case GREEN_WOOL:
                    assertEquals(dyeColor, DyeColor.GREEN);
                    break;
                case RED_WOOL:
                    assertEquals(dyeColor, DyeColor.RED);
                    break;
                case BLACK_WOOL:
                    assertEquals(dyeColor, DyeColor.BLACK);
                    break;
                default:
                    fail("Unrecognized material type");
                    break;
            }
        });
    }
}
