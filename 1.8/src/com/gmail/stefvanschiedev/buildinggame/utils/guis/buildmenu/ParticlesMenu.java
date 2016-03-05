package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class ParticlesMenu {

	public ParticlesMenu() {}
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 18, messages.getString("gui.particles.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		
		//flames
		ItemStack flames = new ItemStack(Material.FLINT_AND_STEEL, 1);
		{
			ItemMeta flamesMeta = flames.getItemMeta();
			flamesMeta.setDisplayName(messages.getString("gui.particles.flames.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> flamesLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.flames.lores")) {
					flamesLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				flamesMeta.setLore(flamesLores);
			}
			flames.setItemMeta(flamesMeta);
		}
		
		//magic crit
		ItemStack magicCrit = new ItemStack(Material.DIAMOND_SWORD, 1);
		{
			ItemMeta magicCritMeta = magicCrit.getItemMeta();
			magicCritMeta.setDisplayName(messages.getString("gui.particles.magic-crit.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> magicCritLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.magic-crit.lores")) {
					magicCritLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				magicCritMeta.setLore(magicCritLores);
			}
			magicCrit.setItemMeta(magicCritMeta);
		}
		
		//lava drip
		ItemStack lavaDrip = new ItemStack(Material.LAVA_BUCKET, 1);
		{
			ItemMeta lavaDripMeta = lavaDrip.getItemMeta();
			lavaDripMeta.setDisplayName(messages.getString("gui.particles.lava-drip.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> lavaDripLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.lava-drip.lores")) {
					lavaDripLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				lavaDripMeta.setLore(lavaDripLores);
			}
			lavaDrip.setItemMeta(lavaDripMeta);
		}
		
		//water drip
		ItemStack waterDrip = new ItemStack(Material.WATER_BUCKET, 1);
		{
			ItemMeta waterDripMeta = waterDrip.getItemMeta();
			waterDripMeta.setDisplayName(messages.getString("gui.particles.water-drip.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> waterDripLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.water-drip.lores")) {
					waterDripLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				waterDripMeta.setLore(waterDripLores);
			}
			waterDrip.setItemMeta(waterDripMeta);
		}
		
		//enchantment
		ItemStack enchantment = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
		{
			ItemMeta enchantmentMeta = enchantment.getItemMeta();
			enchantmentMeta.setDisplayName(messages.getString("gui.particles.enchantment.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> enchantmentLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.enchantment.lores")) {
					enchantmentLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				enchantmentMeta.setLore(enchantmentLores);
			}
			enchantment.setItemMeta(enchantmentMeta);
		}
		
		//hearts
		ItemStack hearts = new ItemStack(Material.RED_ROSE, 1);
		{
			ItemMeta heartsMeta = hearts.getItemMeta();
			heartsMeta.setDisplayName(messages.getString("gui.particles.hearts.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> heartsLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.hearts.lores")) {
					heartsLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				heartsMeta.setLore(heartsLores);
			}
			hearts.setItemMeta(heartsMeta);
		}
		
		//angry villager
		ItemStack angryVillager = new ItemStack(Material.CLAY, 1);
		{
			ItemMeta angryVillagerMeta = angryVillager.getItemMeta();
			angryVillagerMeta.setDisplayName(messages.getString("gui.particles.angry-villager.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> angryVillagerLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.angry-villager.lores")) {
					angryVillagerLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				angryVillagerMeta.setLore(angryVillagerLores);
			}
			angryVillager.setItemMeta(angryVillagerMeta);
		}
		
		//happy villager
		ItemStack happyVillager = new ItemStack(Material.EMERALD, 1);
		{
			ItemMeta happyVillagerMeta = happyVillager.getItemMeta();
			happyVillagerMeta.setDisplayName(messages.getString("gui.particles.happy-villager.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> happyVillagerLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.happy-villager.lores")) {
					happyVillagerLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				happyVillagerMeta.setLore(happyVillagerLores);
			}
			happyVillager.setItemMeta(happyVillagerMeta);
		}
		
		//redstone magic
		ItemStack redstoneMagic = new ItemStack(Material.REDSTONE, 1);
		{
			ItemMeta redstoneMagicMeta = redstoneMagic.getItemMeta();
			redstoneMagicMeta.setDisplayName(messages.getString("gui.particles.redstone-magic.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> redstoneMagicLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.redstone-magic.lores")) {
					redstoneMagicLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				redstoneMagicMeta.setLore(redstoneMagicLores);
			}
			redstoneMagic.setItemMeta(redstoneMagicMeta);
		}
		
		//spell
		ItemStack spell = new ItemStack(Material.POTION, 1);
		{
			ItemMeta spellMeta = spell.getItemMeta();
			spellMeta.setDisplayName(messages.getString("gui.particles.spell.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> spellLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.spell.lores")) {
					spellLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				spellMeta.setLore(spellLores);
			}
			spell.setItemMeta(spellMeta);
		}
		
		//snowball poof
		ItemStack snowballPoof = new ItemStack(Material.SNOW_BALL, 1);
		{
			ItemMeta snowballPoofMeta = snowballPoof.getItemMeta();
			snowballPoofMeta.setDisplayName(messages.getString("gui.particles.snowball-poof.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> snowballPoofLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.snowball-poof.lores")) {
					snowballPoofLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				snowballPoofMeta.setLore(snowballPoofLores);
			}
			snowballPoof.setItemMeta(snowballPoofMeta);
		}
		
		//smoke
		ItemStack smoke = new ItemStack(Material.FURNACE, 1);
		{
			ItemMeta smokeMeta = smoke.getItemMeta();
			smokeMeta.setDisplayName(messages.getString("gui.particles.smoke.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> smokeLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.smoke.lores")) {
					smokeLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				smokeMeta.setLore(smokeLores);
			}
			smoke.setItemMeta(smokeMeta);
		}
		
		//clear particles
		ItemStack clearParticles = new ItemStack(Material.BARRIER, 1);
		{
			ItemMeta clearParticlesMeta = clearParticles.getItemMeta();
			clearParticlesMeta.setDisplayName(messages.getString("gui.particles.clear-particles.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> clearParticlesLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.clear-particles.lores")) {
					clearParticlesLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				clearParticlesMeta.setLore(clearParticlesLores);
			}
			clearParticles.setItemMeta(clearParticlesMeta);
		}
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		{
			ItemMeta backMeta = back.getItemMeta();
			backMeta.setDisplayName(messages.getString("gui.particles.back.name")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			{
				List<String> backLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.particles.back.lores")) {
					backLores.add(lore
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
				}
				backMeta.setLore(backLores);
			}
			back.setItemMeta(backMeta);
		}
		
		inventory.setItem(0, flames);
		inventory.setItem(1, magicCrit);
		inventory.setItem(2, lavaDrip);
		inventory.setItem(3, waterDrip);
		inventory.setItem(4, enchantment);
		inventory.setItem(5, hearts);
		inventory.setItem(6, angryVillager);
		inventory.setItem(7, happyVillager);
		inventory.setItem(8, redstoneMagic);
		inventory.setItem(9, spell);
		inventory.setItem(10, snowballPoof);
		inventory.setItem(11, smoke);
		inventory.setItem(16, clearParticles);
		inventory.setItem(17, back);
		
		player.openInventory(inventory);
	}
	
}
