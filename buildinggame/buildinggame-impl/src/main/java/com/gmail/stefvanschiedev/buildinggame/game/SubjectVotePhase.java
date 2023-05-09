package com.gmail.stefvanschiedev.buildinggame.game;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.SubjectVoting;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ClickEvent;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The game phase in which people vote for a subject, after the lobby phase is over, but before the building phase.
 * Subject voting during the lobby phase is handled there.
 *
 * @since 12.2.0
 */
public class SubjectVotePhase extends TimedGamePhase<Arena> implements SubjectVoting {

    /**
     * The subject menu
     */
    @NotNull
    private final SubjectMenu subjectMenu = new SubjectMenu();

    /**
     * Creates a new timed game phase. Once this time is over, the game will transition to the next game phase.
     *
     * @param arena the transition system managing this game phase
     * @since 12.2.0
     */
    public SubjectVotePhase(@NotNull Arena arena) {
        super(arena, 10);

        this.startTimer();
    }

    @Override
    public void onPhaseStart() {
        super.onPhaseStart();

        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                Player player = gamePlayer.getPlayer();

                PotentialLocation location = plot.getLocation();

                if (location == null) {
                    throw new IllegalStateException("Plot location not set");
                }

                location.teleport(player);

                giveSubjectMenuItem(player);

                if (this.subjectMenu.opensInstantly()) {
                    this.subjectMenu.show(player);
                }
            }
        }
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public DyeColor getColor() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        if (!config.contains("signs.glass-colors." + getName())) {
            return DyeColor.GREEN;
        }

        return DyeColor.valueOf(config.getString("signs.glass-colors." + getName(), "").toUpperCase());
    }

    @Override
    public void forceEnd() {
        super.forceEnd();

        this.transitionSystem.transition(new LobbyGamePhase(this.transitionSystem));
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public GamePhase getNextPhase() {
        return new BuildingGamePhase(this.transitionSystem, this.subjectMenu.getHighestVote());
    }

    @NotNull
    @Override
    public SubjectMenu getSubjectMenu() {
        return subjectMenu;
    }

    @NotNull
    @Contract(pure  = true)
    @Override
    public String getName() {
        return "lobby";
    }

    @Override
    public boolean canJoin() {
        return true;
    }

    /**
     * This will give the subject menu item to the specified player.
     *
     * @param player the player who should receive the subject menu item
     * @since 12.2.0
     */
    private void giveSubjectMenuItem(@NotNull Player player) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        int slot = config.getInt("subject-gui.slot");
        ItemStack item = player.getInventory().getItem(slot);

        if (item != null && item.getType() != Material.AIR) {
            Main.getInstance().getLogger().warning(
                "Subject gui item overrides a different item. This other item will not be visible. Please " +
                    "change the slots in the config.yml file to fix this."
            );
        }

        Material material = SettingsManager.getInstance().getMaterial("subject-gui.item.id", Material.BARRIER);

        player.getInventory().setItem(
            slot,
            new ItemBuilder(player, material)
                .setDisplayName(MessageManager.translate(messages.getString("subject-gui.item.name"),
                    player))
                .setLore(MessageManager.translate(messages.getStringList("subject-gui.item.lores"),
                    player))
                .addContext("arena", ArenaDataType.getInstance(), this.transitionSystem)
                .setClickEvent(ClickEvent.SUBJECT_GUI_CLICK)
                .build()
        );
    }
}
