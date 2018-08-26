package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MappedMaterialUtil {

    /**
     * A collection containing entries for all wool material colors and their corresponding dye color
     */
    public static final Collection<Map.Entry<Material, DyeColor>> WOOL_DYE_COLOR_ITEMS = new ArrayList<>();

    /**
     * Private constructor to prevent initialization, since this is a utility class
     *
     * @since 6.0.0
     */
    private MappedMaterialUtil() {}

    static {
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.WHITE_WOOL, DyeColor.WHITE));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.ORANGE_WOOL, DyeColor.ORANGE));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.MAGENTA_WOOL, DyeColor.MAGENTA));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.LIGHT_BLUE_WOOL, DyeColor.LIGHT_BLUE));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.YELLOW_WOOL, DyeColor.YELLOW));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.LIME_WOOL, DyeColor.LIME));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.PINK_WOOL, DyeColor.PINK));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.GRAY_WOOL, DyeColor.GRAY));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.LIGHT_GRAY_WOOL, DyeColor.LIGHT_GRAY));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.CYAN_WOOL, DyeColor.CYAN));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.PURPLE_WOOL, DyeColor.PURPLE));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.BLUE_WOOL, DyeColor.BLUE));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.BROWN_WOOL, DyeColor.BROWN));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.GREEN_WOOL, DyeColor.GREEN));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.RED_WOOL, DyeColor.RED));
        WOOL_DYE_COLOR_ITEMS.add(new AbstractMap.SimpleEntry<>(Material.BLACK_WOOL, DyeColor.BLACK));
    }
}
