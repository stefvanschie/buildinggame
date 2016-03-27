package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class SweepAttackClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (!inventory.getName().equals(MessageManager.translate(messages.getString("gui.particles.title"))))
			return;
		
		if (e.getCurrentItem() == null)
			return;
		
		ItemStack currentItem = e.getCurrentItem();
		
		if (currentItem.getType() != Material.SHIELD) 
			return;
		
		if (!currentItem.hasItemMeta()) 
			return;
		
		if (!currentItem.getItemMeta().getDisplayName().equals(MessageManager.translate(messages.getString("gui.particles.sweep-attack.name"))))
			return;
		
		plot.addParticle(new Particle(player.getLocation(), ParticleType.SWEEP_ATTACK), player);
		e.setCancelled(true);
	}
}
