package com.gmail.stefvanschiedev.buildinggame.utils;

import com.google.gson.stream.JsonReader;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * A utility class for json readers.
 *
 * @since 6.2.0
 */
public final class JsonReaderUtil {

    /**
     * A private constructor to ensure this class won't be instantiated.
     *
     * @since 6.2.0
     */
    private JsonReaderUtil() {}

    /**
     * Parses a location from a {@link JsonReader}. The reader should be just before the opening brace of the location
     * object.
     *
     * @param reader the reader to read the file with
     * @return the parsed location
     * @since 6.2.0
     */
    @NotNull
    @Contract(value = "null -> fail", pure = true)
    public static Location parseLocation(@NotNull JsonReader reader) throws IOException {
        reader.beginObject();

        World world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        float yaw = 0;
        float pitch = 0;

        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case "world":
                    world = Bukkit.getWorld(reader.nextString());
                    break;
                case "x":
                    x = reader.nextDouble();
                    break;
                case "y":
                    y = reader.nextDouble();
                    break;
                case "z":
                    z = reader.nextDouble();
                    break;
                case "yaw":
                    yaw = (float) reader.nextDouble();
                    break;
                case "pitch":
                    pitch = (float) reader.nextDouble();
                    break;
                default:
                    break;
            }
        }

        reader.endObject();

        return new Location(world, x, y, z, yaw, pitch);
    }
}
