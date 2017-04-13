package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.SubjectVote;

public class SubjectMenu extends Gui {

	private final List<String> subjects = new ArrayList<>();
	private String forcedTheme;
	
	private final Map<String, SubjectVote> votes = new HashMap<>();
	
	private static final YamlConfiguration CONFIG = SettingsManager.getInstance().getConfig();
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	public SubjectMenu() {
		super(null, 36, MessageManager.translate(MESSAGES.getString("subject-gui.title")), CONFIG.getInt("subject-gui.subject-amount") == -1 ? (int) Math.ceil(CONFIG.getStringList("subjects").size()/ 27.0) : (int) Math.ceil(CONFIG.getInt("subject-gui.subject-amount")/ 27.0));
	
		int amountOfSubjects = CONFIG.getInt("subject-gui.subject-amount");
		
		if (amountOfSubjects == -1)
			subjects.addAll(CONFIG.getStringList("subjects"));
		else {
			for (int i = 0; i < amountOfSubjects; i++)
				subjects.add(CONFIG.getStringList("subjects").get(ThreadLocalRandom.current().nextInt(amountOfSubjects)));
		}
		
		for (String s : subjects)
			votes.put(s, new SubjectVote(0));
	}
		
	@Override
	public void open(Player player, int page) {
		clear();
		
		setStartingPoint((page - 1) * 36);
		
		for (int index = 0; index < 27; index++) {
			if (subjects.size() - 1 < index + ((page - 1) * 27))
				break;
			
			final String subject = ChatColor.stripColor(subjects.get(index + ((page - 1) * 27)));
			
			if (!votes.containsKey(subject))
				votes.put(subject, new SubjectVote(0));
			
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.subject.name")
					.replace("%subject%", subject)));
			List<String> lores = new ArrayList<>();
				
			for (String lore : MESSAGES.getStringList("subject-gui.subject.lores"))
				lores.add(MessageManager.translate(lore
					.replace("%votes%", votes.get(subject).getVotes() + "")));
				
			meta.setLore(lores);
			item.setItemMeta(meta);
			
			addItem(item, new GuiAction() {
					
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
						
					InventoryClickEvent event = (InventoryClickEvent) e;
						
					addVote((Player) event.getWhoClicked(), subject);
					update();
						
					return true;
				}
			});
		}
			
		if (page - 1 > 0) {
			//previous page
			ItemStack prevItem = new ItemStack(Material.SUGAR_CANE);
			ItemMeta prevMeta = prevItem.getItemMeta();
			prevMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.previous-page.name")));
			List<String> prevLores = new ArrayList<>();
			
			for (String lore : MESSAGES.getStringList("subject-gui.previous-page.lores"))
				prevLores.add(MessageManager.translate(lore));
			
			prevMeta.setLore(prevLores);
			prevItem.setItemMeta(prevMeta);
				
			setItem(prevItem, new GuiAction() {
					
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
						
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
						
					open(player, getPage(player) - 1 == 0 ? 1 : getPage(player) - 1);
						
					return true;
				}
					
			}, 29 + ((page - 1) * 36));
		}
			
		ItemStack closeItem = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = closeItem.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.close-menu.name")));
		List<String> closeLores = new ArrayList<>();
			
		for (String lore : MESSAGES.getStringList("subject-gui.close-menu.lores"))
			closeLores.add(MessageManager.translate(lore));
			
		closeMeta.setLore(closeLores);
		closeItem.setItemMeta(closeMeta);
			
		setItem(closeItem, new GuiAction() {
				
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
					
				InventoryClickEvent event = (InventoryClickEvent) e;
				HumanEntity humanEntity = event.getWhoClicked();
					
				humanEntity.closeInventory();
				removePlayer((Player) humanEntity);
				return true;
			}
		}, 31 + ((page - 1) * 36));
			
		if (subjects.size() > 27 * page) {
			//next page
			ItemStack nextItem = new ItemStack(Material.SUGAR_CANE);
			ItemMeta nextMeta = nextItem.getItemMeta();
			nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("subject-gui.next-page.name")));
			List<String> nextLores = new ArrayList<>();
			
			for (String lore : MESSAGES.getStringList("subject-gui.next-page.lores"))
				nextLores.add(MessageManager.translate(lore));
			
			nextMeta.setLore(nextLores);
			nextItem.setItemMeta(nextMeta);
				
			setItem(nextItem, new GuiAction() {
					
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
						
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
						
					open(player, getPage(player) + 1);
						
					return true;
				}
			}, 33 + ((page - 1) * 36));
		}
		
		super.open(player, page);
	}
	
	private void addVote(Player player, String subject) {
		subject = ChatColor.stripColor(subject);
		
		for (Map.Entry<String, SubjectVote> entry : votes.entrySet()) {
			if (entry.getValue().getPlayers().contains(player)) {
                entry.getValue().removePlayer(player);
                entry.getValue().setVotes(entry.getValue().getVotes() - 1);
			}
		}
		
		votes.get(subject).addPlayer(player);
		votes.get(subject).setVotes(votes.get(subject).getVotes() + 1);
	}
	
	public void forceTheme(String theme) {
		forcedTheme = theme;
	}
	
	public String getHighestVote() {
		if (forcedTheme != null)
			return forcedTheme;
		
		int highest = -1;

        for (Map.Entry<String, SubjectVote> entry : votes.entrySet()) {
			if (entry.getValue().getVotes() > highest) {
				highest = entry.getValue().getVotes();
			}
		}

        List<String> subjects = new ArrayList<>();
        for (Map.Entry<String, SubjectVote> entry : votes.entrySet()) {
			if (entry.getValue().getVotes() == highest)
				subjects.add(entry.getKey());
		}
		
		return subjects.get(ThreadLocalRandom.current().nextInt(subjects.size()));
	}
}