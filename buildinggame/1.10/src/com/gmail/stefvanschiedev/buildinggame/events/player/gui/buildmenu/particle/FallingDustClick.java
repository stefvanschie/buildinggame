package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;

public class FallingDustClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		ItemStack currentItem = e.getCurrentItem();
		ItemStack cursor = e.getCursor();
		
		if (ArenaManager.getInstance().getArena(player) == null || !e.getInventory().getName().equals(MessageManager.translate(messages.getString("gui.particles.title"))) || currentItem == null || currentItem.getType() != Material.SAND || !currentItem.hasItemMeta() || !currentItem.getItemMeta().getDisplayName().equals(MessageManager.translate(messages.getString("gui.particles.falling-dust.name"))))
			return;
		
		if (cursor != null)
			ArenaManager.getInstance().getArena(player).getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.FALLING_DUST, e.getCursor().getData()), player);
		else
			ArenaManager.getInstance().getArena(player).getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.FALLING_DUST), player);
		e.setCancelled(true);
	}
}