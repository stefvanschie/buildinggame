package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import com.google.gson.annotations.Expose;
import com.google.gson.stream.JsonReader;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Represents a hologram used for displaying top statistics
 *
 * @since 6.2.0
 */
public class TopStatHologram {

    /**
     * A set of all currently registered holograms
     */
    @NotNull
    private static final Set<TopStatHologram> HOLOGRAMS = new HashSet<>();

    /**
     * The hologram this class is a wrapper for
     */
    @NotNull
    private final Hologram hologram;

    /**
     * The name of this hologram
     */
    @Expose
    @NotNull
    private final String name;

    /**
     * The type of stat to show on the hologram
     */
    @Expose
    @NotNull
    private final StatType type;

    /**
     * The amount of values to be displayed on the hologram
     */
    @Expose
    private final int values;

    /**
     * The location of the hologram
     */
    @Expose
    @NotNull
    private final Location location;

    /**
     * Creates a new top stat hologram, but doesn't register it. Use {@link #register()} for registering the hologram.
     * This does however initialize the hologram's lines as if {@link #update()} was called.
     *
     * @param name the name of the hologram to be registered
     * @param type the type of stat to show for this hologram, see {@link #type}
     * @param values the amount of values to display, see {@link #values}
     * @param location the location of the hologram, see {@link #hologram}
     * @since 6.2.0
     */
    public TopStatHologram(@NotNull String name, @NotNull StatType type, int values, @NotNull Location location) {
        this.name = name;
        this.type = type;
        this.values = values;
        this.location = location;

        this.hologram = HologramsAPI.createHologram(Main.getInstance(), location);

        update();
    }

    /**
     * Updates all lines of this hologram
     *
     * @since 6.2.0
     */
    private void update() {
        var stats = StatManager.getInstance().getStats(type);

        if (stats == null)
            return;

        hologram.clearLines();

        for (var i = 0; i < Math.min(values, stats.size()); i++) {
            var stat = stats.get(i);

            hologram.appendTextLine(ChatColor.GOLD + "#" + (i + 1) + ' ' + ChatColor.RED + stat.getPlayer()
                .getName() + ChatColor.LIGHT_PURPLE + " - " + ChatColor.GREEN + stat.getValue() +
                ' ' + type.toString().replace("_", " ").toLowerCase(Locale.getDefault()));
        }
    }

    /**
     * Deletes this hologram and unregisters it. The contents in the file will be removed next time the hologram file is
     * saved.
     *
     * @since 6.2.0
     */
    public void delete() {
        hologram.delete();

        HOLOGRAMS.remove(this);
    }

    /**
     * Registers this hologram. This will do nothing if the hologram was already registered.
     *
     * @since 6.2.0
     */
    public void register() {
        HOLOGRAMS.add(this);
    }

    /**
     * Gets the name of this hologram
     *
     * @return the name
     * @since 6.2.0
     */
    @NotNull
    @Contract(pure = true)
    public String getName() {
        return name;
    }

    /**
     * Loads a single top stat hologram from a json reader. It is assumed the json reader is directly before the first
     * opening brace of the object.
     *
     * @param reader the json reader to read from
     * @since 6.2.0
     */
    @Contract("null -> fail")
    public static void load(@NotNull JsonReader reader) throws IOException {
        reader.beginObject();

        String name = null;
        StatType type = null;
        var values = 0;
        Location location = null;

        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case "name":
                    name = reader.nextString();
                    break;
                case "type":
                    type = StatType.valueOf(reader.nextString());
                    break;
                case "values":
                    values = reader.nextInt();
                    break;
                case "location":
                    location = JsonReaderUtil.parseLocation(reader);
                    break;
                default:
                    break;
            }
        }

        new TopStatHologram(name, type, values, location).register();

        reader.endObject();
    }

    /**
     * Updates all {@link TopStatHologram}s with the specified stat type.
     *
     * @param type the type to find the holograms by
     * @since 6.2.0
     */
    public static void update(@NotNull StatType type) {
        HOLOGRAMS.stream().filter(hologram -> hologram.type == type).forEach(TopStatHologram::update);
    }

    /**
     * Clears all the {@link TopStatHologram}s currently registered.
     *
     * @since 6.5.1
     */
    public static void clearAll() {
        HOLOGRAMS.clear();
    }

    /**
     * Gets a set of all currently registered holograms
     *
     * @return all holograms
     * @since 6.2.0
     */
    @NotNull
    @Contract(pure = true)
    public static Set<TopStatHologram> getHolograms() {
        return HOLOGRAMS;
    }
}
