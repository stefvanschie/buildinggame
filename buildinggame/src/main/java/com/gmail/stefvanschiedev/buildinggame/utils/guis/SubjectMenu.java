package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.PaginatedPane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.SubjectVote;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A menu for voting on a theme
 *
 * @since 2.1.0
 */
public class SubjectMenu extends Gui {

	/**
     * The subject that is forced to be chosen
     */
	private String forcedTheme;

	/**
     * A map containing all votes for all subjects
     */
	private final Collection<SubjectVote> votes = new HashSet<>();

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
		super(4, MessageManager.translate(MESSAGES.getString("subject-gui.title")));

		int amountOfSubjects = CONFIG.getInt("subject-gui.subject-amount");
		List<String> subjects = new ArrayList<>();

		if (amountOfSubjects == -1)
			subjects.addAll(CONFIG.getStringList("subjects"));
		else {
			for (int i = 0; i < amountOfSubjects; i++)
				subjects.add(CONFIG.getStringList("subjects").get(ThreadLocalRandom.current()
                        .nextInt(amountOfSubjects)));
		}
		
		for (String s : subjects)
			votes.add(new SubjectVote(s, 0));

		//gui
        PaginatedPane paginatedPane = new PaginatedPane(new GuiLocation(0, 0), 9, 3,
            CONFIG.getInt("subject-gui.subject-amount") == -1 ?
                (int) Math.ceil(CONFIG.getStringList("subjects").size() / 27.0) :
                (int) Math.ceil(CONFIG.getInt("subject-gui.subject-amount") / 27.0));

        initializePages(paginatedPane, subjects);

        addPane(paginatedPane);

        OutlinePane previousPane = new OutlinePane(new GuiLocation(2, 3), 1, 1);
        OutlinePane closePane = new OutlinePane(new GuiLocation(4, 3), 1, 1);
        OutlinePane nextPane = new OutlinePane(new GuiLocation(6, 3), 1, 1);

        //previous page
        ItemStack prevItem = new ItemStack(Material.SUGAR_CANE);
        ItemMeta prevMeta = prevItem.getItemMeta();
        prevMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.previous-page.name")));
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

        ItemStack closeItem = new ItemStack(Material.BOOK);
        ItemMeta closeMeta = closeItem.getItemMeta();
        closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.close-menu.name")));
        closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("subject-gui.close-menu.lores")));
        closeItem.setItemMeta(closeMeta);

        closePane.addItem(new GuiItem(closeItem, event -> {
            event.getWhoClicked().closeInventory();
            event.setCancelled(true);
        }));

        //next page
        ItemStack nextItem = new ItemStack(Material.SUGAR_CANE);
        ItemMeta nextMeta = nextItem.getItemMeta();
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

        addPane(previousPane);
        addPane(closePane);
        addPane(nextPane);
    }

    /**
     * Initializes the pages for this gui
     *
     * @param paginatedPane the paginated pane
     * @param subjects the subjects
     * @since 5.6.0
     */
    @Contract("null, _ -> fail")
    private void initializePages(@NotNull PaginatedPane paginatedPane, List<String> subjects) {
        for (int page = 0; page < paginatedPane.getPages(); page++) {
            OutlinePane pane =
                new OutlinePane(new GuiLocation(0, 0), paginatedPane.getLength(), paginatedPane.getHeight());

            for (int index = 0; index < paginatedPane.getLength() * paginatedPane.getHeight(); index++) {
                if (subjects.size() - 1 < index + (page * paginatedPane.getLength() * paginatedPane.getHeight()))
                    break;

                final String subject = ChatColor
                    .stripColor(subjects.get(index + (page * paginatedPane.getLength() * paginatedPane.getHeight())));

                if (getSubjectVote(subject) == null)
                    votes.add(new SubjectVote(subject, 0));

                ItemStack item = new ItemStack(Material.PAPER);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.subject.name")
                    .replace("%subject%", subject)));
                List<String> lores = new ArrayList<>();

                for (String lore : MESSAGES.getStringList("subject-gui.subject.lores"))
                    lores.add(MessageManager.translate(lore
                        .replace("%votes%", getSubjectVote(subject).getVotes() + "")));

                meta.setLore(lores);
                item.setItemMeta(meta);

                pane.addItem(new GuiItem(item, event -> {
                    addVote((Player) event.getWhoClicked(), subject);

                    initializePages(paginatedPane, subjects);

                    update();

                    event.setCancelled(true);
                }));
            }

            paginatedPane.setPane(page, pane);
        }
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
		
		for (SubjectVote subjectVote : votes) {
			if (subjectVote.getPlayers().contains(player)) {
                subjectVote.removePlayer(player);
                subjectVote.setVotes(subjectVote.getVotes() - 1);
			}
		}

        SubjectVote subjectVote = getSubjectVote(subject);

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
	    for (SubjectVote subjectVote : votes) {
	        if (subjectVote.getSubject().equals(subject))
	            return subjectVote;
        }

        return null;
    }
}