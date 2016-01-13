package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class GamesHeadsMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Games");
		
		ItemStack beachball = SkullItem.getSkull("http://textures.minecraft.net/texture/5a5ab05ea254c32e3c48f3fdcf9fd9d77d3cba04e6b5ec2e68b3cbdcfac3fd");
		ItemMeta beachballMeta = beachball.getItemMeta();
		beachballMeta.setDisplayName(ChatColor.GOLD + "Beachball");
		beachball.setItemMeta(beachballMeta);
		
		ItemStack soccerball = SkullItem.getSkull("http://textures.minecraft.net/texture/8e4a70b7bbcd7a8c322d522520491a27ea6b83d60ecf961d2b4efbbf9f605d");
		ItemMeta soccerballMeta = soccerball.getItemMeta();
		soccerballMeta.setDisplayName(ChatColor.GOLD + "Soccerball");
		soccerball.setItemMeta(soccerballMeta);
		
		ItemStack bowlingball = SkullItem.getSkull("http://textures.minecraft.net/texture/6c82e21a9320953d78daee85477de3bb82d5dfa6b19494d37733265d2d030a8");
		ItemMeta bowlingballMeta = bowlingball.getItemMeta();
		bowlingballMeta.setDisplayName(ChatColor.GOLD + "Bowlingball");
		bowlingball.setItemMeta(bowlingballMeta);
		
		ItemStack bowlingball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9cc861c52486bfc19d28be0644a85b4c712bf71c7b26365ae1b54b9a7173cd0");
		ItemMeta bowlingball2Meta = bowlingball2.getItemMeta();
		bowlingball2Meta.setDisplayName(ChatColor.GOLD + "Bowlingball");
		bowlingball2.setItemMeta(bowlingball2Meta);
		
		ItemStack bowlingball3 = SkullItem.getSkull("http://textures.minecraft.net/texture/c4455d18bc2a6b5a83b69a7290406194fd152c89d9619c08fd88763f136");
		ItemMeta bowlingball3Meta = bowlingball3.getItemMeta();
		bowlingball3Meta.setDisplayName(ChatColor.GOLD + "Bowlingball");
		bowlingball3.setItemMeta(bowlingball3Meta);
		
		ItemStack checkerboard = SkullItem.getSkull("http://textures.minecraft.net/texture/f870a65992c2dd8ad738b98d6d3596e45a2dd14efbace4b21122aeaff777f5");
		ItemMeta checkerboardMeta = checkerboard.getItemMeta();
		checkerboardMeta.setDisplayName(ChatColor.GOLD + "Checkerboard");
		checkerboard.setItemMeta(checkerboardMeta);
		
		ItemStack pokeBall = SkullItem.getSkull("http://textures.minecraft.net/texture/d43d4b7ac24a1d650ddf73bd140f49fc12d2736fc14a8dc25c0f3f29d85f8f");
		ItemMeta pokeBallMeta = pokeBall.getItemMeta();
		pokeBallMeta.setDisplayName(ChatColor.GOLD + "Poke Ball");
		pokeBall.setItemMeta(pokeBallMeta);
		
		ItemStack glados = SkullItem.getSkull("textures.minecraft.net/texture/a5bec76d65a868a5be5173d3b9e1775b54046f62035c1552440ede9973a90e1");
		ItemMeta gladosMeta = glados.getItemMeta();
		gladosMeta.setDisplayName(ChatColor.GOLD + "Glados");
		glados.setItemMeta(gladosMeta);
		
		ItemStack turret = SkullItem.getSkull("http://textures.minecraft.net/texture/fa2c3e79d5f35a9dcab19e43c3e3a6519e426b64a61213cd2f1d28b57036f6");
		ItemMeta turretMeta = turret.getItemMeta();
		turretMeta.setDisplayName(ChatColor.GOLD + "Turret");
		turret.setItemMeta(turretMeta);
		
		ItemStack companionCube = SkullItem.getSkull("http://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4");
		ItemMeta companionCubeMeta = companionCube.getItemMeta();
		companionCubeMeta.setDisplayName(ChatColor.GOLD + "Companion Cube");
		companionCube.setItemMeta(companionCubeMeta);
		
		ItemStack weightedCube = SkullItem.getSkull("http://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b");
		ItemMeta weightedCubeMeta = weightedCube.getItemMeta();
		weightedCubeMeta.setDisplayName(ChatColor.GOLD + "Weighted Cube");
		weightedCube.setItemMeta(weightedCubeMeta);
		
		ItemStack whiteDice = SkullItem.getSkull("http://textures.minecraft.net/texture/797955462e4e576664499ac4a1c572f6143f19ad2d6194776198f8d136fdb2");
		ItemMeta whiteDiceMeta = whiteDice.getItemMeta();
		whiteDiceMeta.setDisplayName(ChatColor.GOLD + "White Dice");
		whiteDice.setItemMeta(whiteDiceMeta);
		
		ItemStack redDice = SkullItem.getSkull("http://textures.minecraft.net/texture/5131de8e951fdd7b9a3d239d7cc3aa3e8655a336b999b9edbb4fb329cbd87");
		ItemMeta redDiceMeta = redDice.getItemMeta();
		redDiceMeta.setDisplayName(ChatColor.GOLD + "Red Dice");
		redDice.setItemMeta(redDiceMeta);
		
		ItemStack blackDice = SkullItem.getSkull("http://textures.minecraft.net/texture/915f7c313bca9c2f958e68ab14ab393867d67503affff8f20cb13fbe917fd31");
		ItemMeta blackDiceMeta = blackDice.getItemMeta();
		blackDiceMeta.setDisplayName(ChatColor.GOLD + "Black Dice");
		blackDice.setItemMeta(blackDiceMeta);
		
		ItemStack portalCoreWheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta portalCoreWheatleyMeta = portalCoreWheatley.getItemMeta();
		portalCoreWheatleyMeta.setDisplayName(ChatColor.GOLD + "Portal Core - Wheatley");
		portalCoreWheatley.setItemMeta(portalCoreWheatleyMeta);
		
		ItemStack greatBall = SkullItem.getSkull("http://textures.minecraft.net/texture/ecfaf610275f433a34e5317573ce1f9a0f667ce10cdf1d06c9eba5d9cb57047");
		ItemMeta greatBallMeta = greatBall.getItemMeta();
		greatBallMeta.setDisplayName(ChatColor.GOLD + "Great Ball");
		greatBall.setItemMeta(greatBallMeta);
		
		ItemStack ultraBall = SkullItem.getSkull("http://textures.minecraft.net/texture/3d85c96efaefef11a1a35b117ca2f231c696e4e693b73a1bae77221607011e");
		ItemMeta ultraBallMeta = ultraBall.getItemMeta();
		ultraBallMeta.setDisplayName(ChatColor.GOLD + "Ultra Ball");
		ultraBall.setItemMeta(ultraBallMeta);
		
		inventory.setItem(0, beachball);
		inventory.setItem(1, soccerball);
		inventory.setItem(2, bowlingball);
		inventory.setItem(3, bowlingball2);
		inventory.setItem(4, bowlingball3);
		inventory.setItem(5, checkerboard);
		inventory.setItem(6, pokeBall);
		inventory.setItem(7, glados);
		inventory.setItem(8, turret);
		inventory.setItem(9, companionCube);
		inventory.setItem(10, weightedCube);
		inventory.setItem(11, whiteDice);
		inventory.setItem(12, redDice);
		inventory.setItem(13, blackDice);
		inventory.setItem(14, portalCoreWheatley);
		inventory.setItem(15, greatBall);
		inventory.setItem(16, ultraBall);
	}
}