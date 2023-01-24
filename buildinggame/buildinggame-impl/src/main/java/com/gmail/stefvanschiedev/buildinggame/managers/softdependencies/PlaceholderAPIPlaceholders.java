package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.PlaceholderSupplier;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiFunction;

/**
 * Registers placeholder for PlaceholderAPI
 *
 * @since 5.5.1
 */
public class PlaceholderAPIPlaceholders extends PlaceholderExpansion {

    @Nullable
    @Contract(pure = true)
    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        String fullIdentifier = "buildinggame_" + identifier;

        Map<String, BiFunction<OfflinePlayer, String, String>> replacements = PlaceholderSupplier.getPlaceholderReplacements();
        BiFunction<OfflinePlayer, String, String> replacer = replacements.get(fullIdentifier);

        if (replacer == null) {
            return null;
        }

        return replacer.apply(player, fullIdentifier);
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String getAuthor() {
        return String.join(", ", Main.getInstance().getDescription().getAuthors());
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String getIdentifier() {
        return "buildinggame";
    }

    @Contract(pure = true)
    @Override
    public boolean persist() {
        return true;
    }
}
