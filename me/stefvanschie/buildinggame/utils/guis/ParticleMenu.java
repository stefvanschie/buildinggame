package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParticlesMenu {

	public ParticlesMenu() {}
	
	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Particles");
		
		//flames
		ItemStack flames = new ItemStack(Material.FLINT_AND_STEEL, 1);
		{
			ItemMeta flamesMeta = flames.getItemMeta();
			flamesMeta.setDisplayName(ChatColor.GREEN + "Flames");
			{
				List<String> flamesLores = new ArrayList<String>();
				flamesLores.add(ChatColor.GRAY + "Place a flames particle effect");
				flamesMeta.setLore(flamesLores);
			}
			flames.setItemMeta(flamesMeta);
		}
		
		//magic crit
		ItemStack magicCrit = new ItemStack(Material.DIAMOND_SWORD, 1);
		{
			ItemMeta magicCritMeta = magicCrit.getItemMeta();
			magicCritMeta.setDisplayName(ChatColor.GREEN + "Magic crit");
			{
				List<String> magicCritLores = new ArrayList<String>();
				magicCritLores.add(ChatColor.GRAY + "Place a magic crit particle effect");
				magicCritMeta.setLore(magicCritLores);
			}
			magicCrit.setItemMeta(magicCritMeta);
		}
		
		//lava drip
		ItemStack lavaDrip = new ItemStack(Material.LAVA_BUCKET, 1);
		{
			ItemMeta lavaDripMeta = lavaDrip.getItemMeta();
			lavaDripMeta.setDisplayName(ChatColor.GREEN + "Lava drip");
			{
				List<String> lavaDripLores = new ArrayList<String>();
				lavaDripLores.add(ChatColor.GRAY + "Place a lava drip particle effect");
				lavaDripMeta.setLore(lavaDripLores);
			}
			lavaDrip.setItemMeta(lavaDripMeta);
		}
		
		//water drip
		ItemStack waterDrip = new ItemStack(Material.WATER_BUCKET, 1);
		{
			ItemMeta waterDripMeta = waterDrip.getItemMeta();
			waterDripMeta.setDisplayName(ChatColor.GREEN + "Water drip");
			{
				List<String> waterDripLores = new ArrayList<String>();
				waterDripLores.add(ChatColor.GRAY + "Place a water drip particle effect");
				waterDripMeta.setLore(waterDripLores);
			}
			waterDrip.setItemMeta(waterDripMeta);
		}
		
		//enchantment
		ItemStack enchantment = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
		{
			ItemMeta enchantmentMeta = enchantment.getItemMeta();
			enchantmentMeta.setDisplayName(ChatColor.GREEN + "Enchantment");
			{
				List<String> enchantmentLores = new ArrayList<String>();
				enchantmentLores.add(ChatColor.GRAY + "Place an enchantment particle effect");
				enchantmentMeta.setLore(enchantmentLores);
			}
			enchantment.setItemMeta(enchantmentMeta);
		}
		
		//hearts
		ItemStack hearts = new ItemStack(Material.RED_ROSE, 1);
		{
			ItemMeta heartsMeta = hearts.getItemMeta();
			heartsMeta.setDisplayName(ChatColor.GREEN + "Hearts");
			{
				List<String> heartsLores = new ArrayList<String>();
				heartsLores.add(ChatColor.GRAY + "Place a hearts particle effect");
				heartsMeta.setLore(heartsLores);
			}
			hearts.setItemMeta(heartsMeta);
		}
		
		//angry villager
		ItemStack angryVillager = new ItemStack(Material.CLAY, 1);
		{
			ItemMeta angryVillagerMeta = angryVillager.getItemMeta();
			angryVillagerMeta.setDisplayName(ChatColor.GREEN + "Angry villager");
			{
				List<String> angryVillagerLores = new ArrayList<String>();
				angryVillagerLores.add(ChatColor.GRAY + "Place an angry villager particle effect");
				angryVillagerMeta.setLore(angryVillagerLores);
			}
			angryVillager.setItemMeta(angryVillagerMeta);
		}
		
		//happy villager
		ItemStack happyVillager = new ItemStack(Material.EMERALD, 1);
		{
			ItemMeta happyVillagerMeta = happyVillager.getItemMeta();
			happyVillagerMeta.setDisplayName(ChatColor.GREEN + "Happy villager");
			{
				List<String> happyVillagerLores = new ArrayList<String>();
				happyVillagerLores.add(ChatColor.GRAY + "Place an happy villager particle effect");
				happyVillagerMeta.setLore(happyVillagerLores);
			}
			happyVillager.setItemMeta(happyVillagerMeta);
		}
		
		//redstone magic
		ItemStack redstoneMagic = new ItemStack(Material.REDSTONE, 1);
		{
			ItemMeta redstoneMagicMeta = redstoneMagic.getItemMeta();
			redstoneMagicMeta.setDisplayName(ChatColor.GREEN + "Redstone magic");
			{
				List<String> redstoneMagicLores = new ArrayList<String>();
				redstoneMagicLores.add(ChatColor.GRAY + "Place a redstone magic particle effect");
				redstoneMagicMeta.setLore(redstoneMagicLores);
			}
			redstoneMagic.setItemMeta(redstoneMagicMeta);
		}
		
		//spell
		ItemStack spell = new ItemStack(Material.POTION, 1);
		{
			ItemMeta spellMeta = spell.getItemMeta();
			spellMeta.setDisplayName(ChatColor.GREEN + "Spell");
			{
				List<String> spellLores = new ArrayList<String>();
				spellLores.add(ChatColor.GRAY + "Place a spell particle effect");
				spellMeta.setLore(spellLores);
			}
			spell.setItemMeta(spellMeta);
		}
		
		//snowball poof
		ItemStack snowballPoof = new ItemStack(Material.SNOW_BALL, 1);
		{
			ItemMeta snowballPoofMeta = snowballPoof.getItemMeta();
			snowballPoofMeta.setDisplayName(ChatColor.GREEN + "Snowball poof");
			{
				List<String> snowballPoofLores = new ArrayList<String>();
				snowballPoofLores.add(ChatColor.GRAY + "Place a snowball poof particle effect");
				snowballPoofMeta.setLore(snowballPoofLores);
			}
			snowballPoof.setItemMeta(snowballPoofMeta);
		}
		
		//smoke
		ItemStack smoke = new ItemStack(Material.FURNACE, 1);
		{
			ItemMeta smokeMeta = smoke.getItemMeta();
			smokeMeta.setDisplayName(ChatColor.GREEN + "Smoke");
			{
				List<String> smokeLores = new ArrayList<String>();
				smokeLores.add(ChatColor.GRAY + "Place a smoke particle effect");
				smokeMeta.setLore(smokeLores);
			}
			smoke.setItemMeta(smokeMeta);
		}
		
		//clear particles
		ItemStack clearParticles = new ItemStack(Material.BARRIER, 1);
		{
			ItemMeta clearParticlesMeta = clearParticles.getItemMeta();
			clearParticlesMeta.setDisplayName(ChatColor.RED + "Clear particles");
			{
				List<String> clearParticlesLores = new ArrayList<String>();
				clearParticlesLores.add(ChatColor.GRAY + "Clear all the particles on your plot");
				clearParticlesLores.add(ChatColor.RED + "Warning: " + ChatColor.GRAY + "Cannot be undone!");
				clearParticlesMeta.setLore(clearParticlesLores);
			}
			clearParticles.setItemMeta(clearParticlesMeta);
		}
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		{
			ItemMeta backMeta = back.getItemMeta();
			backMeta.setDisplayName(ChatColor.GREEN + "Back");
			{
				List<String> backLores = new ArrayList<String>();
				backLores.add(ChatColor.GRAY + "Go back to the options menu");
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
