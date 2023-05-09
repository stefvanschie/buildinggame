package com.gmail.stefvanschiedev.buildinggame.game.util;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Indicates that a game phase allows for subject voting.
 *
 * @since 12.2.0
 */
public interface SubjectVoting {

    /**
     * Gets the subject menu for this subject vote.
     *
     * @return the subject menu
     * @since 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    SubjectMenu getSubjectMenu();
}
