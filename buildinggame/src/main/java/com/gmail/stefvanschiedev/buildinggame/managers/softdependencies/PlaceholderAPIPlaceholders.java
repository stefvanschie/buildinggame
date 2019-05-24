package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.PlaceholderSupplier;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Registers placeholder for PlaceholderAPI
 *
 * @since 5.5.1
 */
public class PlaceholderAPIPlaceholders extends PlaceholderExpansion {

    /**
     * {@inheritDoc}
     *
     * @since 5.5.1
     */
    @Nullable
    @Contract(pure = true)
    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        return PlaceholderSupplier.getPlaceholderReplacements().get(identifier).apply(player, identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return String.join(", ", Main.getInstance().getDescription().getAuthors());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIdentifier() {
        return "buildinggame";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean persist() {
        return true;
    }
}
