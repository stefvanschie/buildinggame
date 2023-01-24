package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when the arena is in build state
 *
 * @since 2.1.0
 */
public class BuildScoreboard extends ArenaScoreboard {

    /**
     * Constructs a new BuildScoreboard.
     *
     * @param arena the arena this scoreboard belongs to
     */
	public BuildScoreboard(Arena arena) {
		super(arena);
	}

    /**
     * {@inheritDoc}
     */
    @Nls
    @NotNull
    @Contract(pure = true)
    @Override
    public String getHeader() {
        return MessageManager.translate(SettingsManager.getInstance().getMessages()
                .getString("scoreboards.build.header"));
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.build.text");
    }
}