package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.id.IDDecompiler;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.nbt.item.NBTItem;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamSelection {

	private Arena arena;
	
	public TeamSelection(Arena arena) {
		this.arena = arena;
	}
	
	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, round(arena.getPlots().size()), messages.getString("team-gui.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		
		int iteration = 0;
		for (Plot plot : arena.getPlots()) {
			ItemStack item = new ItemStack(IDDecompiler.getInstance().decompile(config.getString("team-selection.team." + (iteration + 1) + ".id")).getMaterial());
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(messages.getString("team-gui.team.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replace("%plot%", plot.getID() + "")
					.replace("%plot_players%", plot.getPlayers() + "")
					.replace("%plot_max_players%", plot.getMaxPlayers() + "")
					.replaceAll("&", "§"));
			
			List<String> lores = new ArrayList<String>();
			if (!config.getBoolean("team-selection.show-names-as-lore")) {
				for (String lore : messages.getStringList("team-gui.team.lores")) {
					lores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
			} else {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					lores.add(gamePlayer.getPlayer().getName());
				}
			}
			itemMeta.setLore(lores);
			
			item.setItemMeta(itemMeta);
			
			NBTItem nbtItem = new NBTItem(item);
			nbtItem.setInteger("team", iteration + 1);
			item = nbtItem.getItem();
			
			inventory.setItem(iteration, item);
			
			iteration++;
		}
		
		player.openInventory(inventory);
	}
	
	public int round(int i) {
		while (i % 9 != 0) {
			i++;
		}
		return i;
	}
}