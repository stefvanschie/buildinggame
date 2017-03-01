package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

	private List<String> subjects = new ArrayList<>();
	private String forcedTheme;
	
	private Map<String, SubjectVote> votes = new HashMap<String, SubjectVote>();
	
	private static YamlConfiguration config = SettingsManager.getInstance().getConfig();
	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public SubjectMenu() {
		super(null, 36, MessageManager.translate(messages.getString("subject-gui.title")), config.getInt("subject-gui.subject-amount") == -1 ? (int) Math.ceil(config.getStringList("subjects").size() / 27.0) : (int) Math.ceil(config.getInt("subject-gui.subject-amount") / 27.0));
	
		int amountOfSubjects = config.getInt("subject-gui.subject-amount");
		
		if (amountOfSubjects == -1) {
			for (String s : config.getStringList("subjects"))
				subjects.add(s);
		} else {
			for (int i = 0; i < amountOfSubjects; i++)
				subjects.add(config.getStringList("subjects").get(ThreadLocalRandom.current().nextInt(amountOfSubjects)));
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
			meta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.subject.name")
					.replace("%subject%", subject)));
			List<String> lores = new ArrayList<String>();
				
			for (String lore : messages.getStringList("subject-gui.subject.lores"))
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
			prevMeta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.previous-page.name")));
			List<String> prevLores = new ArrayList<String>();
			
			for (String lore : messages.getStringList("subject-gui.previous-page.lores"))
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
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.close-menu.name")));
		List<String> closeLores = new ArrayList<String>();
			
		for (String lore : messages.getStringList("subject-gui.close-menu.lores"))
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
			nextMeta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.next-page.name")));
			List<String> nextLores = new ArrayList<String>();
			
			for (String lore : messages.getStringList("subject-gui.next-page.lores"))
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
	
	public void addVote(Player player, String subject) {
		subject = ChatColor.stripColor(subject);
		
		for (String s : votes.keySet()) {
			if (votes.get(s).getPlayers().contains(player)) {
				votes.get(s).removePlayer(player);
				votes.get(s).setVotes(votes.get(s).getVotes() - 1);
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
		List<String> subjects = new ArrayList<String>();
		
		for (String s : votes.keySet()) {
			if (votes.get(s).getVotes() > highest) {
				highest = votes.get(s).getVotes();
			}
		}
		
		for (String s : votes.keySet()) {
			if (votes.get(s).getVotes() == highest) {
				subjects.add(s);
			}
		}
		
		return subjects.get(new Random().nextInt(subjects.size()));
	}
}