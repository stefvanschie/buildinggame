package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when the arena is in lobby state
 *
 * @since 2.3.0
 */
public class LobbyScoreboard extends ArenaScoreboard {

    /**
     * Constructs a new LobbyScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public LobbyScoreboard(Arena arena) {
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
                .getString("scoreboards.lobby.header"));
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.lobby.text");
    }
}