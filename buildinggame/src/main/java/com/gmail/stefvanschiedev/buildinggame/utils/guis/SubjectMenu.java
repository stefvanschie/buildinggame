package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.Orientable;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.github.stefvanschie.inventoryframework.pane.component.PercentageBar;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.SubjectVote;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A menu for voting on a theme
 *
 * @since 2.1.0
 */
public class SubjectMenu {

	/**
     * The subject that is forced to be chosen
     */
	private String forcedTheme;

	/**
     * A map containing all votes for all subjects
     */
	private final Collection<SubjectVote> votes = new HashSet<>();

    /**
     * The subjects players can pick from
     */
	private final List<String> subjects = new ArrayList<>();

    /**
     * The moment this theme gui should be accessible
     */
	private final When when;

    /**
     * Whether this menu should open automatically when possible.
     */
	private final boolean openInstantly;

    /**
     * All guis of this class with their paginated pane that are currently open
     */
    @NotNull
	private final Map<ChestGui, PaginatedPane> openGuis = new HashMap<>();

	/**
     * YAML Configuration for the config.yml
     */
	private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();

	/**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new SubjectMenu
     */
	public SubjectMenu() {
		var amountOfSubjects = CONFIG.getInt("subject-gui.subject-amount");

        when = When.fromName(CONFIG.getString("subject-gui.when"));
        openInstantly = CONFIG.getBoolean("subject-gui.open-instantly");

        if (amountOfSubjects == -1)
			subjects.addAll(CONFIG.getStringList("subjects"));
		else {
			for (int i = 0; i < amountOfSubjects; i++)
				subjects.add(CONFIG.getStringList("subjects").get(ThreadLocalRandom.current()
                        .nextInt(amountOfSubjects)));
		}

		subjects.forEach(s -> votes.add(new SubjectVote(s, 0)));
    }

    /**
     * Initializes the pages for this gui
     *
     * @param gui the gui for which to initialize pages
     * @param paginatedPane the paginated pane
     * @since 5.6.0
     */
    private void initializePages(@NotNull ChestGui gui, @NotNull PaginatedPane paginatedPane) {
        paginatedPane.clear();

        for (var page = 0;
             page < Math.ceil((float) subjects.size() / (paginatedPane.getHeight() * paginatedPane.getLength()));
             page++) {
            var pane = new OutlinePane(0, 0, paginatedPane.getLength(), paginatedPane.getHeight());

            pane.setOrientation(Orientable.Orientation.valueOf(
                CONFIG.getString("subject-gui.vote-items.orientation").toUpperCase(Locale.getDefault())
            ));

            for (var index = 0; index < paginatedPane.getLength() * paginatedPane.getHeight(); index++) {
                if (subjects.size() - 1 < index + (page * paginatedPane.getLength() * paginatedPane.getHeight()))
                    break;

                final String subject = ChatColor
                    .stripColor(subjects.get(index + (page * paginatedPane.getLength() * paginatedPane.getHeight())));

                if (getSubjectVote(subject) == null)
                    votes.add(new SubjectVote(subject, 0));

                Material material = SettingsManager.getInstance().getMaterial("subject-gui.vote-items.item.id",
                    Material.BARRIER);

                var item = new ItemStack(material);
                var meta = item.getItemMeta();
                meta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.subject.name")
                    .replace("%subject%", subject)));
                var lores = new ArrayList<String>();

                MESSAGES.getStringList("subject-gui.subject.lores").forEach(lore ->
                    lores.add(MessageManager.translate(lore
                        .replace("%votes%", getSubjectVote(subject).getVotes() + ""))));

                meta.setLore(lores);
                item.setItemMeta(meta);

                pane.addItem(new GuiItem(item, event -> {
                    addVote((Player) event.getWhoClicked(), subject);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            initializePages(gui, paginatedPane);

                            update();
                        }
                    }.runTaskLater(Main.getInstance(), 1L);

                    event.setCancelled(true);
                }));

                if (CONFIG.getBoolean("subject-gui.percentage-bars.enable")) {
                    int x;
                    int y;

                    if (pane.getOrientation() == Orientable.Orientation.HORIZONTAL) {
                        x = index % pane.getLength();
                        y = (int) Math.floor((double) index / pane.getLength());
                    } else if (pane.getOrientation() == Orientable.Orientation.VERTICAL) {
                        x = (int) Math.floor((double) index / pane.getHeight());
                        y = index % pane.getHeight();
                    } else {
                        throw new UnsupportedOperationException("Unknown orientation found");
                    }

                    int xOffset = CONFIG.getInt("subject-gui.percentage-bars.offset.x");
                    int yOffset = CONFIG.getInt("subject-gui.percentage-bars.offset.y");

                    int totalVotes = votes.stream().mapToInt(SubjectVote::getVotes).sum();
                    int userVotes = getSubjectVote(subject).getVotes();

                    var percentageBar = new PercentageBar(x + xOffset, y + yOffset, 7, 1);
                    percentageBar.setPercentage(totalVotes == 0 ? 0 : (float) userVotes / totalVotes);

                    gui.addPane(percentageBar);
                }
            }

            paginatedPane.addPane(page, pane);
        }
    }

    /**
     * Opens this gui for the specified human entity
     *
     * @param humanEntity the human entity to open the gui for
     * @since 9.0.3
     */
    public void show(@NotNull HumanEntity humanEntity) {
        ChestGui gui = new ChestGui(CONFIG.getInt("subject-gui.rows"),
            MessageManager.translate(MESSAGES.getString("subject-gui.title")));

        int rows = gui.getRows();
        var paginatedPane = new PaginatedPane(0, 0, 9, rows - 1);

        initializePages(gui, paginatedPane);

        if (paginatedPane.getPages() == 1 && !CONFIG.getBoolean("subject-gui.close-item.enable")) {
            paginatedPane.setHeight(gui.getRows());

            initializePages(gui, paginatedPane);
        }

        gui.addPane(paginatedPane);

        if (paginatedPane.getPages() != 1) {
            var previousPane = new OutlinePane(2, rows - 1, 1, 1);
            var nextPane = new OutlinePane(6, rows - 1, 1, 1);

            //previous page
            var prevItem = new ItemStack(Material.SUGAR_CANE);
            var prevMeta = prevItem.getItemMeta();
            prevMeta
                .setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.previous-page.name")));
            prevMeta.setLore(MessageManager.translate(MESSAGES.getStringList("subject-gui.previous-page.lores")));
            prevItem.setItemMeta(prevMeta);

            previousPane.addItem(new GuiItem(prevItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() - 1);

                if (paginatedPane.getPage() == 0)
                    previousPane.setVisible(false);

                nextPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            previousPane.setVisible(false);

            gui.addPane(previousPane);

            //next page
            var nextItem = new ItemStack(Material.SUGAR_CANE);
            var nextMeta = nextItem.getItemMeta();
            nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.next-page.name")));
            nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("subject-gui.next-page.lores")));
            nextItem.setItemMeta(nextMeta);

            nextPane.addItem(new GuiItem(nextItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() + 1);

                if (paginatedPane.getPage() == paginatedPane.getPages() - 1)
                    nextPane.setVisible(false);

                previousPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            gui.addPane(nextPane);
        }

        if (CONFIG.getBoolean("subject-gui.close-item.enable")) {
            var closePane = new OutlinePane(4, rows - 1, 1, 1);

            var closeItem = new ItemStack(Material.BOOK);
            var closeMeta = closeItem.getItemMeta();
            closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.close-menu.name")));
            closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("subject-gui.close-menu.lores")));
            closeItem.setItemMeta(closeMeta);

            closePane.addItem(new GuiItem(closeItem, event -> {
                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
            }));

            gui.addPane(closePane);
        }

        //additional items
        CONFIG.getConfigurationSection("subject-gui.additional-items").getKeys(false).forEach(section -> {
            String baseNode = "subject-gui.additional-items." + section;

            int x = CONFIG.getInt(baseNode + ".x") - 1;
            int y = CONFIG.getInt(baseNode + ".y") - 1;

            var pane = new OutlinePane(x, y, 1, 1);

            Material material = SettingsManager.getInstance().getMaterial(baseNode + ".id", Material.BARRIER);

            var item = new ItemStack(material);
            var itemMeta = item.getItemMeta();

            var name = MESSAGES.getString(baseNode + ".name");

            if (name == null) {
                var baseName = item.getType().name().substring(1).replace('_', ' ');
                var lowerCaseName = baseName.toLowerCase(Locale.getDefault());
                var prettyName = Character.toUpperCase(item.getType().name().charAt(0)) + lowerCaseName;

                MESSAGES.set(baseNode + ".name", prettyName);
                name = MESSAGES.getString(baseNode + ".name");
            }

            itemMeta.setDisplayName(MessageManager.translate(name));

            var lore = MESSAGES.getStringList(baseNode + ".lore");

            if (lore == null) {
                MESSAGES.set(baseNode + ".name", new ArrayList<String>());
                lore = new ArrayList<>();
            }

            itemMeta.setLore(MessageManager.translate(lore));
            item.setItemMeta(itemMeta);

            pane.addItem(new GuiItem(item, event -> event.setCancelled(true)));

            gui.addPane(pane);
        });

        gui.setOnClose(event -> openGuis.remove(gui));

        gui.show(humanEntity);

        openGuis.put(gui, paginatedPane);
    }

	/**
     * Adds a vote for the specified theme
     *
     * @param player the player that voted for the theme
     * @param subject the them the player voted for
     * @since 2.1.0
     */
	private void addVote(Player player, String subject) {
		subject = ChatColor.stripColor(subject);

		votes.stream().filter(subjectVote -> subjectVote.getPlayers().contains(player)).forEach(subjectVote -> {
            subjectVote.removePlayer(player);
            subjectVote.setVotes(subjectVote.getVotes() - 1);
        });

        var subjectVote = getSubjectVote(subject);

        subjectVote.addPlayer(player);
        subjectVote.setVotes(subjectVote.getVotes() + 1);
	}

	/**
     * Forces a specific theme to be chosen
     *
     * @param theme the theme that's forced to be chosen
     * @since 4.0.4
     */
	public void forceTheme(String theme) {
		forcedTheme = theme;
	}

	/**
     * Returns the theme that received the most votes. If there are multiple themes with the highest amount of votes,
     * one of those will be picked at random.
     *
     * @return the theme that received the highest amount of votes
     */
	@Nullable
	@Contract(pure = true)
	public String getHighestVote() {
		if (forcedTheme != null)
			return forcedTheme;

		int highest = -1;

        for (SubjectVote subjectVote : votes) {
			if (subjectVote.getVotes() > highest)
				highest = subjectVote.getVotes();
		}

        List<String> subjects = new ArrayList<>();
        for (SubjectVote subjectVote : votes) {
			if (subjectVote.getVotes() == highest)
				subjects.add(subjectVote.getSubject());
		}

		return subjects.get(ThreadLocalRandom.current().nextInt(subjects.size()));
	}

    /**
     * Returns the subject vote by the given subject
     *
     * @param subject the subject to look for
     * @return the subject vote corresponding with the subject
     * @since 5.2.0
     */
	@Nullable
    @Contract(pure = true)
	private SubjectVote getSubjectVote(String subject) {
	    return votes.stream()
            .filter(subjectVote -> subjectVote.getSubject().equals(subject))
            .findAny()
            .orElse(null);
    }

    /**
     * Updates all open guis belonging to this object
     *
     * @since 9.0.3
     */
    private void update() {
        for (Map.Entry<ChestGui, PaginatedPane> entry : openGuis.entrySet()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    ChestGui gui = entry.getKey();
                    initializePages(gui, entry.getValue());

                    gui.update();
                }
            }.runTaskLater(Main.getInstance(), 1L);
        }
    }

    /**
     * Gets the time when the menu should be accessible
     *
     * @return when the menu should be accessible
     * @see When
     * @since 6.4.0
     */
    @NotNull
    @Contract(pure = true)
    public When getWhen() {
	    return when;
    }

    /**
     * Gets whether this menu should be opened immediately when possible
     *
     * @return true if this menu should open directly, false otherwise
     * @since 6.4.0
     */
    @Contract(pure = true)
    public boolean opensInstantly() {
        return openInstantly;
    }

    /**
     * An enum for the possible timings when the theme gui can be accessed
     *
     * @since 6.4.0
     */
    public enum When {

        /**
         * The subject menu will be accessible while waiting in the lobby
         *
         * @since 6.4.0
         */
	    LOBBY,

        /**
         * The subject menu will be accessible right before building
         *
         * @since 6.4.0
         */
        BEFORE_BUILD;

        /**
         * Gets an enum value from this enum by the given name.
         *
         * @param name the name of the enum value
         * @return the enum value
         * @since 6.4.0
         */
        @NotNull
        @Contract(pure = true)
        static When fromName(@NotNull String name) {
            return When.valueOf(name
                .trim()
                .toUpperCase(Locale.getDefault())
                .replace('-', '_')
                .replace(' ', '_'));
        }
    }
}