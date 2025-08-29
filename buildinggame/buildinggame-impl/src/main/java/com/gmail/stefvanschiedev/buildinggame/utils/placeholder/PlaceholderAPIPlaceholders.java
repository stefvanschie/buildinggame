package com.gmail.stefvanschiedev.buildinggame.utils.placeholder;

import com.gmail.stefvanschiedev.buildinggame.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.antlr.v4.runtime.*;
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

    @Nullable
    @Contract(pure = true)
    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        var fullIdentifier = getIdentifier() + "_" + identifier;
        var stream = new CommonTokenStream(new PlaceholdersLexer(CharStreams.fromString(fullIdentifier)));

        return new PlaceholdersReplacer(player).visit(new PlaceholdersParser(stream).placeholder());
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
