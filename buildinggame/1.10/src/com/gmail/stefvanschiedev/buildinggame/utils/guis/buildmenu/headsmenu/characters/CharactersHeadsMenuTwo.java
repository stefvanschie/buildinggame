package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.characters;

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
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class CharactersHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.characters.page-2.title")));
		
		ItemStack wheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta wheatleyMeta = wheatley.getItemMeta();
		wheatleyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.wheatley.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.wheatley.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wheatleyMeta.setLore(lores);
		}
		wheatley.setItemMeta(wheatleyMeta);
		
		ItemStack wilson = SkullItem.getSkull("http://textures.minecraft.net/texture/e98d4fe5176a3accdebb1c3fb0b26cf3a181fffc160ea52a028cb41f34cfe1");
		ItemMeta wilsonMeta = wilson.getItemMeta();
		wilsonMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.wilson.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.wilson.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wilsonMeta.setLore(lores);
		}
		wilson.setItemMeta(wilsonMeta);
		
		ItemStack masterchief = SkullItem.getSkull("http://textures.minecraft.net/texture/b775a17c2941ae6a2a5f1840509b9ab0c0d96859a9bc249798b86f1952b0832e");
		ItemMeta masterchiefMeta = masterchief.getItemMeta();
		masterchiefMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.masterchief.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.masterchief.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			masterchiefMeta.setLore(lores);
		}
		masterchief.setItemMeta(masterchiefMeta);
		
		ItemStack batman = SkullItem.getSkull("http://textures.minecraft.net/texture/f256f71735ef458581c9dacf394185eed9b33cb6ec5cd594a57153a8b566560");
		ItemMeta batmanMeta = batman.getItemMeta();
		batmanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.batman.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.batman.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			batmanMeta.setLore(lores);
		}
		batman.setItemMeta(batmanMeta);
		
		ItemStack joker = SkullItem.getSkull("http://textures.minecraft.net/texture/af4f6825ef6d5e46d794697d1bf86d144bf6fb3da4e55f7cf55271f637eaa7");
		ItemMeta jokerMeta = joker.getItemMeta();
		jokerMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.joker.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.joker.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			jokerMeta.setLore(lores);
		}
		joker.setItemMeta(jokerMeta);
		
		ItemStack bender = SkullItem.getSkull("http://textures.minecraft.net/texture/b15fe247d9c61a6c137544de7e6220f84759e33335b0b551832fa1f8a262c23a");
		ItemMeta benderMeta = bender.getItemMeta();
		benderMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.bender.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.bender.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			benderMeta.setLore(lores);
		}
		bender.setItemMeta(benderMeta);
		
		ItemStack captainAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7ec527713d34c1167eed0cd1e969dbfad5d44a752154ccaf64c1c7ab6bc3f3f");
		ItemMeta captainAmericaMeta = captainAmerica.getItemMeta();
		captainAmericaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.captain-america.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.captain-america.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			captainAmericaMeta.setLore(lores);
		}
		captainAmerica.setItemMeta(captainAmericaMeta);
		
		ItemStack deadpool = SkullItem.getSkull("http://textures.minecraft.net/texture/dc15c31639e93f2bb274cf29d244a8a2906e80ab8bd2c0121c7fd1e2624d53");
		ItemMeta deadpoolMeta = deadpool.getItemMeta();
		deadpoolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.deadpool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.deadpool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			deadpoolMeta.setLore(lores);
		}
		deadpool.setItemMeta(deadpoolMeta);
		
		ItemStack doge = SkullItem.getSkull("http://textures.minecraft.net/texture/b9afb2e5f0b977c4c683e017d2b47fcd1488ab56397766e5b380405a139260");
		ItemMeta dogeMeta = doge.getItemMeta();
		dogeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.doge.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.doge.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dogeMeta.setLore(lores);
		}
		doge.setItemMeta(dogeMeta);
		
		ItemStack toyFreddy = SkullItem.getSkull("http://textures.minecraft.net/texture/dc3f2e93d03294d4aa931e9967f2d5bcd2af909bfe38ee81d1bda7f682fdc3");
		ItemMeta toyFreddyMeta = toyFreddy.getItemMeta();
		toyFreddyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.toy-freddy.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.toy-freddy.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			toyFreddyMeta.setLore(lores);
		}
		toyFreddy.setItemMeta(toyFreddyMeta);
		
		ItemStack toyBonnie = SkullItem.getSkull("http://textures.minecraft.net/texture/a75dbe970d547b2561f8b658130359176246f89e74a4abdc6834155c8c4c81a");
		ItemMeta toyBonnieMeta = toyBonnie.getItemMeta();
		toyBonnieMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.toy-bonnie.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.toy-bonnie.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			toyBonnieMeta.setLore(lores);
		}
		toyBonnie.setItemMeta(toyBonnieMeta);
		
		ItemStack goomba = SkullItem.getSkull("http://textures.minecraft.net/texture/aecf94f4bcbbf6eadcb25aa3d069aa678ebdb5241eb82e8e26889caf3275570");
		ItemMeta goombaMeta = goomba.getItemMeta();
		goombaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.goomba.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.goomba.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goombaMeta.setLore(lores);
		}
		goomba.setItemMeta(goombaMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 1);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.characters.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.characters.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, wheatley);
		inventory.setItem(1, wilson);
		inventory.setItem(2, masterchief);
		inventory.setItem(3, batman);
		inventory.setItem(4, joker);
		inventory.setItem(5, bender);
		inventory.setItem(6, captainAmerica);
		inventory.setItem(7, deadpool);
		inventory.setItem(8, doge);
		inventory.setItem(9, toyFreddy);
		inventory.setItem(10, toyBonnie);
		inventory.setItem(11, goomba);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}