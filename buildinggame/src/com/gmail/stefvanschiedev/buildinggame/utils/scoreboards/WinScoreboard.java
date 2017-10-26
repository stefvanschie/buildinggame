package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when the arena is in voting phase
 *
 * @since 2.3.0
 */
public class WinScoreboard extends ArenaScoreboard {

    /**
     * Constructs a new WinScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public WinScoreboard(Arena arena) {
        super(arena);
	}

    /**
     * {@inheritDoc}
     */
    @Nls
    @Contract(pure = true)
    @NotNull
    @Override
    public String getHeader() {
        return MessageManager.translate(SettingsManager.getInstance().getMessages()
                .getString("scoreboards.win.header"));
    }

    /**
     * {@inheritDoc}
     */
    @Contract(pure = true)
    @NotNull
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.win.text");
    }
}