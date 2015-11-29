package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.GuiPage;
import me.stefvanschie.buildinggame.utils.SubjectVote;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SubjectMenu {

	private Map<String, GuiPage> players = new HashMap<String, GuiPage>();
	private Map<String, SubjectVote> votes = new HashMap<String, SubjectVote>();
	
	public SubjectMenu() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (String s : config.getStringList("subjects")) {
			votes.put(s, new SubjectVote(0));
		}
	}
	
	public void show(Player player, GuiPage page) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
				
		Inventory inventory = Bukkit.createInventory(null, 36, messages.getString("subject-gui.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		
		for (int i = 0; i < 27; i++) {
			if (page.getPage() < 1) {
				return;
			}
			
			if (config.getStringList("subjects").size() - 1 < i + (page.getPage() - 1) * 27) {
				break;
			}
			
			String subject = ChatColor.stripColor(config.getStringList("subjects").get(i + (page.getPage() - 1) * 27));
			
			if (!votes.containsKey(subject)) {
				votes.put(subject, new SubjectVote(0));
			}
			
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(messages.getString("subject-gui.subject.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%subject%", subject)
					.replaceAll("&", "§"));
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("subject-gui.subject.lores")) {
				lores.add(lore
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replace("%votes%", votes.get(subject).getVotes() + "")
						.replaceAll("&", "§"));
			}
			meta.setLore(lores);
			item.setItemMeta(meta);
			
			inventory.setItem(i, item);
		}
		
		//previous page
		ItemStack prevItem = new ItemStack(Material.SUGAR_CANE);
		ItemMeta prevMeta = prevItem.getItemMeta();
		prevMeta.setDisplayName(messages.getString("subject-gui.previous-page.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		List<String> prevLores = new ArrayList<String>();
		for (String lore : messages.getStringList("subject-gui.previous-page.lores")) {
			prevLores.add(lore
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
		}
		prevMeta.setLore(prevLores);
		prevItem.setItemMeta(prevMeta);
		
		//close
		ItemStack closeItem = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = closeItem.getItemMeta();
		closeMeta.setDisplayName(messages.getString("subject-gui.close-menu.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		List<String> closeLores = new ArrayList<String>();
		for (String lore : messages.getStringList("subject-gui.close-menu.lores")) {
			closeLores.add(lore
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
		}
		closeMeta.setLore(closeLores);
		closeItem.setItemMeta(closeMeta);
		
		//next page
		ItemStack nextItem = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = nextItem.getItemMeta();
		nextMeta.setDisplayName(messages.getString("subject-gui.next-page.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		List<String> nextLores = new ArrayList<String>();
		for (String lore : messages.getStringList("subject-gui.next-page.lores")) {
			nextLores.add(lore
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
		}
		nextMeta.setLore(nextLores);
		nextItem.setItemMeta(nextMeta);
		
		inventory.setItem(29, prevItem);
		inventory.setItem(31, closeItem);
		inventory.setItem(33, nextItem);
		
		player.openInventory(inventory);
		
		players.put(player.getName(), page);
	}
	
	public void addPlayer(Player player) {
		players.put(player.getName(), new GuiPage(1));
	}
	
	public void addPlayer(Player player, GuiPage page) {
		players.put(player.getName(), page);
	}
	
	@SuppressWarnings("deprecation")
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
		
		for (String name : getPlayers().keySet()) {
			Player p = Bukkit.getPlayer(name);
			show(p, getPlayers().get(name));
		}
	}
	
	public GuiPage getPage(Player player) {
		return players.get(player.getName());
	}
	
	public Map<String, GuiPage> getPlayers() {
		return players;
	}
	
	public String getHighestVote() {
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
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
}
