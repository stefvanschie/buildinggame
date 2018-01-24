package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.SubjectVote;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * A menu for voting on a theme
 *
 * @since 2.1.0
 */
public class SubjectMenu extends Gui {

    /**
     * A list of all subjects
     */
	private final List<String> subjects = new ArrayList<>();

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
		super(null, 36, MessageManager.translate(MESSAGES.getString("subject-gui.title")),
                CONFIG.getInt("subject-gui.subject-amount") == -1 ?
                        (int) Math.ceil(CONFIG.getStringList("subjects").size() / 27.0) :
                        (int) Math.ceil(CONFIG.getInt("subject-gui.subject-amount") / 27.0));
	
		int amountOfSubjects = CONFIG.getInt("subject-gui.subject-amount");
		
		if (amountOfSubjects == -1)
			subjects.addAll(CONFIG.getStringList("subjects"));
		else {
			for (int i = 0; i < amountOfSubjects; i++)
				subjects.add(CONFIG.getStringList("subjects").get(ThreadLocalRandom.current()
                        .nextInt(amountOfSubjects)));
		}
		
		for (String s : subjects)
			votes.add(new SubjectVote(s, 0));
	}

	/**
     * Called whenever a player wants or is forced to open the gui
     *
     * @param player the player to show the gui for
     * @param page the page this gui should open at
     * @since 4.0.0
     */
	@Override
	public void open(Player player, int page) {
		clear();
		
		setStartingPoint((page - 1) * 36);
		
		for (int index = 0; index < 27; index++) {
			if (subjects.size() - 1 < index + ((page - 1) * 27))
				break;
			
			final String subject = ChatColor.stripColor(subjects.get(index + ((page - 1) * 27)));
			
			if (getSubjectVote(subject) == null)
				votes.add(new SubjectVote(subject, 0));
			
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.subject.name")
					.replace("%subject%", subject), player));
			List<String> lores = new ArrayList<>();
				
			for (String lore : MESSAGES.getStringList("subject-gui.subject.lores"))
				lores.add(MessageManager.translate(lore
					.replace("%votes%", getSubjectVote(subject).getVotes() + ""), player));
				
			meta.setLore(lores);
			item.setItemMeta(meta);
			
			addItem(item, event ->  {
                addVote((Player) event.getWhoClicked(), subject);
                update();

                event.setCancelled(true);
			});
		}
			
		if (page - 1 > 0) {
			//previous page
			ItemStack prevItem = new ItemStack(Material.SUGAR_CANE);
			ItemMeta prevMeta = prevItem.getItemMeta();
			prevMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.previous-page.name"),
                    player));
			List<String> prevLores = new ArrayList<>();
			
			for (String lore : MESSAGES.getStringList("subject-gui.previous-page.lores"))
				prevLores.add(MessageManager.translate(lore, player));
			
			prevMeta.setLore(prevLores);
			prevItem.setItemMeta(prevMeta);
				
			setItem(prevItem, event -> {
                Player p = (Player) event.getWhoClicked();

                open(p, getPage(p) - 1 == 0 ? 1 : getPage(p) - 1);

                event.setCancelled(true);
			}, 29 + ((page - 1) * 36));
		}
			
		ItemStack closeItem = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = closeItem.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.close-menu.name"),
                player));
		List<String> closeLores = new ArrayList<>();
			
		for (String lore : MESSAGES.getStringList("subject-gui.close-menu.lores"))
			closeLores.add(MessageManager.translate(lore, player));
			
		closeMeta.setLore(closeLores);
		closeItem.setItemMeta(closeMeta);
			
		setItem(closeItem, event -> {
            HumanEntity humanEntity = event.getWhoClicked();

            humanEntity.closeInventory();
            removePlayer((Player) humanEntity);

            event.setCancelled(true);
		}, 31 + ((page - 1) * 36));
			
		if (subjects.size() > 27 * page) {
			//next page
			ItemStack nextItem = new ItemStack(Material.SUGAR_CANE);
			ItemMeta nextMeta = nextItem.getItemMeta();
			nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.next-page.name"),
                    player));
			List<String> nextLores = new ArrayList<>();
			
			for (String lore : MESSAGES.getStringList("subject-gui.next-page.lores"))
				nextLores.add(MessageManager.translate(lore, player));
			
			nextMeta.setLore(nextLores);
			nextItem.setItemMeta(nextMeta);
				
			setItem(nextItem, event -> {
                Player p = (Player) event.getWhoClicked();

                open(p, getPage(p) + 1);

                event.setCancelled(true);
			}, 33 + ((page - 1) * 36));
		}
		
		super.open(player, page);
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