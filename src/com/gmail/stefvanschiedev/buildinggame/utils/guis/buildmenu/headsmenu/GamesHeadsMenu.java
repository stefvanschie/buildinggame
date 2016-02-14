package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

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
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class GamesHeadsMenu {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.games.page-1.title")));
		
		ItemStack beachball = SkullItem.getSkull("http://textures.minecraft.net/texture/5a5ab05ea254c32e3c48f3fdcf9fd9d77d3cba04e6b5ec2e68b3cbdcfac3fd");
		ItemMeta beachballMeta = beachball.getItemMeta();
		beachballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.beachball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.beachball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			beachballMeta.setLore(lores);
		}
		beachball.setItemMeta(beachballMeta);
		
		ItemStack soccerball = SkullItem.getSkull("http://textures.minecraft.net/texture/8e4a70b7bbcd7a8c322d522520491a27ea6b83d60ecf961d2b4efbbf9f605d");
		ItemMeta soccerballMeta = soccerball.getItemMeta();
		soccerballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.soccerball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.soccerball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			soccerballMeta.setLore(lores);
		}
		soccerball.setItemMeta(soccerballMeta);
		
		ItemStack bowlingball = SkullItem.getSkull("http://textures.minecraft.net/texture/6c82e21a9320953d78daee85477de3bb82d5dfa6b19494d37733265d2d030a8");
		ItemMeta bowlingballMeta = bowlingball.getItemMeta();
		bowlingballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.bowlingball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.bowlingball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlingballMeta.setLore(lores);
		}
		bowlingball.setItemMeta(bowlingballMeta);
		
		ItemStack bowlingball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9cc861c52486bfc19d28be0644a85b4c712bf71c7b26365ae1b54b9a7173cd0");
		ItemMeta bowlingball2Meta = bowlingball2.getItemMeta();
		bowlingball2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.bowlingball-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.bowlingball-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlingball2Meta.setLore(lores);
		}
		bowlingball2.setItemMeta(bowlingball2Meta);
		
		ItemStack bowlingball3 = SkullItem.getSkull("http://textures.minecraft.net/texture/c4455d18bc2a6b5a83b69a7290406194fd152c89d9619c08fd88763f136");
		ItemMeta bowlingball3Meta = bowlingball3.getItemMeta();
		bowlingball3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.bowlingball-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.bowlingball-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bowlingball3Meta.setLore(lores);
		}
		bowlingball3.setItemMeta(bowlingball3Meta);
		
		ItemStack checkerboard = SkullItem.getSkull("http://textures.minecraft.net/texture/f870a65992c2dd8ad738b98d6d3596e45a2dd14efbace4b21122aeaff777f5");
		ItemMeta checkerboardMeta = checkerboard.getItemMeta();
		checkerboardMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.checkerboard.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.checkerboard.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			checkerboardMeta.setLore(lores);
		}
		checkerboard.setItemMeta(checkerboardMeta);
		
		ItemStack pokeBall = SkullItem.getSkull("http://textures.minecraft.net/texture/d43d4b7ac24a1d650ddf73bd140f49fc12d2736fc14a8dc25c0f3f29d85f8f");
		ItemMeta pokeBallMeta = pokeBall.getItemMeta();
		pokeBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.poke-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.poke-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pokeBallMeta.setLore(lores);
		}
		pokeBall.setItemMeta(pokeBallMeta);
		
		ItemStack glados = SkullItem.getSkull("http://textures.minecraft.net/texture/a5bec76d65a868a5be5173d3b9e1775b54046f62035c1552440ede9973a90e1");
		ItemMeta gladosMeta = glados.getItemMeta();
		gladosMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.glados.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.glados.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gladosMeta.setLore(lores);
		}
		glados.setItemMeta(gladosMeta);
		
		ItemStack turret = SkullItem.getSkull("http://textures.minecraft.net/texture/fa2c3e79d5f35a9dcab19e43c3e3a6519e426b64a61213cd2f1d28b57036f6");
		ItemMeta turretMeta = turret.getItemMeta();
		turretMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.turret.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.turret.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			turretMeta.setLore(lores);
		}
		turret.setItemMeta(turretMeta);
		
		ItemStack companionCube = SkullItem.getSkull("http://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4");
		ItemMeta companionCubeMeta = companionCube.getItemMeta();
		companionCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.companion-cube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.companion-cube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			companionCubeMeta.setLore(lores);
		}
		companionCube.setItemMeta(companionCubeMeta);
		
		ItemStack weightedCube = SkullItem.getSkull("http://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b");
		ItemMeta weightedCubeMeta = weightedCube.getItemMeta();
		weightedCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.weighted-cube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.weighted-cube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			weightedCubeMeta.setLore(lores);
		}
		weightedCube.setItemMeta(weightedCubeMeta);
		
		ItemStack whiteDice = SkullItem.getSkull("http://textures.minecraft.net/texture/797955462e4e576664499ac4a1c572f6143f19ad2d6194776198f8d136fdb2");
		ItemMeta whiteDiceMeta = whiteDice.getItemMeta();
		whiteDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.white-dice.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.white-dice.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			whiteDiceMeta.setLore(lores);
		}
		whiteDice.setItemMeta(whiteDiceMeta);
		
		ItemStack redDice = SkullItem.getSkull("http://textures.minecraft.net/texture/5131de8e951fdd7b9a3d239d7cc3aa3e8655a336b999b9edbb4fb329cbd87");
		ItemMeta redDiceMeta = redDice.getItemMeta();
		redDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.red-dice.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.red-dcie.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			redDiceMeta.setLore(lores);
		}
		redDice.setItemMeta(redDiceMeta);
		
		ItemStack blackDice = SkullItem.getSkull("http://textures.minecraft.net/texture/915f7c313bca9c2f958e68ab14ab393867d67503affff8f20cb13fbe917fd31");
		ItemMeta blackDiceMeta = blackDice.getItemMeta();
		blackDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.black-dice.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.black-dice.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			blackDiceMeta.setLore(lores);
		}
		blackDice.setItemMeta(blackDiceMeta);
		
		ItemStack portalCoreWheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta portalCoreWheatleyMeta = portalCoreWheatley.getItemMeta();
		portalCoreWheatleyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.portal-core-wheatley.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.portal-core-wheatley.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			portalCoreWheatleyMeta.setLore(lores);
		}
		portalCoreWheatley.setItemMeta(portalCoreWheatleyMeta);
		
		ItemStack greatBall = SkullItem.getSkull("http://textures.minecraft.net/texture/ecfaf610275f433a34e5317573ce1f9a0f667ce10cdf1d06c9eba5d9cb57047");
		ItemMeta greatBallMeta = greatBall.getItemMeta();
		greatBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.great-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.great-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greatBallMeta.setLore(lores);
		}
		greatBall.setItemMeta(greatBallMeta);
		
		ItemStack ultraBall = SkullItem.getSkull("http://textures.minecraft.net/texture/3d85c96efaefef11a1a35b117ca2f231c696e4e693b73a1bae77221607011e");
		ItemMeta ultraBallMeta = ultraBall.getItemMeta();
		ultraBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.ultra-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.ultra-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			ultraBallMeta.setLore(lores);
		}
		ultraBall.setItemMeta(ultraBallMeta);
		
		ItemStack masterBall = SkullItem.getSkull("http://textures.minecraft.net/texture/1879e64fd2e2d15d1b7e47ae40fa528fc72086a312d6a6ed3f7e552af9d5");
		ItemMeta masterBallMeta = masterBall.getItemMeta();
		masterBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.master-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.master-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			masterBallMeta.setLore(lores);
		}
		masterBall.setItemMeta(masterBallMeta);
		
		ItemStack basketball = SkullItem.getSkull("http://textures.minecraft.net/texture/edf84715a64dc45586f7a6079f8e49a9477c0fe96589b4cfd71cba32254ac8");
		ItemMeta basketballMeta = basketball.getItemMeta();
		basketballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.basketball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.basketball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			basketballMeta.setLore(lores);
		}
		basketball.setItemMeta(basketballMeta);
		
		ItemStack masterchiefHalo = SkullItem.getSkull("http://textures.minecraft.net/texture/b775a17c2941ae6a2a5f1840509b9ab0c0d96859a9bc249798b86f1952b0832e");
		ItemMeta masterchiefHaloMeta = masterchiefHalo.getItemMeta();
		masterchiefHaloMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.masterchief-halo.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.masterchief-halo.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			masterchiefHaloMeta.setLore(lores);
		}
		masterchiefHalo.setItemMeta(masterchiefHaloMeta);
		
		ItemStack yoshi = SkullItem.getSkull("http://textures.minecraft.net/texture/671ebc11bdd151410da70d931259c4e969528e6f5889e9c4bb2dd763b9eafd");
		ItemMeta yoshiMeta = yoshi.getItemMeta();
		yoshiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.yoshi.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.yoshi.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			yoshiMeta.setLore(lores);
		}
		yoshi.setItemMeta(yoshiMeta);
		
		ItemStack batman = SkullItem.getSkull("http://textures.minecraft.net/texture/f256f71735ef458581c9dacf394185eed9b33cb6ec5cd594a57153a8b566560");
		ItemMeta batmanMeta = batman.getItemMeta();
		batmanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.batman.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.batman.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			batmanMeta.setLore(lores);
		}
		batman.setItemMeta(batmanMeta);
		
		ItemStack luigi = SkullItem.getSkull("http://textures.minecraft.net/texture/ff1533871e49ddab8f1ca82edb1153a5e2ed3764fd1ce029bf829f4b3caac3");
		ItemMeta luigiMeta = luigi.getItemMeta();
		luigiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.luigi.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.luigi.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			luigiMeta.setLore(lores);
		}
		luigi.setItemMeta(luigiMeta);
		
		ItemStack mario = SkullItem.getSkull("http://textures.minecraft.net/texture/dba8d8e53d8a5a75770b62cce73db6bab701cc3de4a9b654d213d54af9615");
		ItemMeta marioMeta = mario.getItemMeta();
		marioMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.mario.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.mario.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			marioMeta.setLore(lores);
		}
		mario.setItemMeta(marioMeta);
		
		ItemStack solvedRubiksCube = SkullItem.getSkull("http://textures.minecraft.net/texture/8f1a277beb9e4faa6e7e356c74786e966155736a6858bf5bb5ad29df5bab61a1");
		ItemMeta solvedRubiksCubeMeta = solvedRubiksCube.getItemMeta();
		solvedRubiksCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.solved-rubiks-cube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.solved-rbuiks-cube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			solvedRubiksCubeMeta.setLore(lores);
		}
		solvedRubiksCube.setItemMeta(solvedRubiksCubeMeta);
		
		ItemStack scrambledRubiksCube = SkullItem.getSkull("http://textures.minecraft.net/texture/5d86e7bd28c146f71514c782cac055860d1f372b4a9be3fe65cfe1104733ba");
		ItemMeta scrambledRubiksCubeMeta = scrambledRubiksCube.getItemMeta();
		scrambledRubiksCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.scrambled-rubiks-cube.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.scrambled-rubiks-cube.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			scrambledRubiksCubeMeta.setLore(lores);
		}
		scrambledRubiksCube.setItemMeta(scrambledRubiksCubeMeta);
		
		ItemStack chessBoard = SkullItem.getSkull("http://textures.minecraft.net/texture/94094effee4ba2ab1c2fc6c8ed1c4690fba19c86617e9227db1f58d8dd5d");
		ItemMeta chessBoardMeta = chessBoard.getItemMeta();
		chessBoardMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.chess-board.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.chess-board.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chessBoardMeta.setLore(lores);
		}
		chessBoard.setItemMeta(chessBoardMeta);
		
		ItemStack safariBall = SkullItem.getSkull("http://textures.minecraft.net/texture/72eac5f499e312165364f1af152660cd3f18d94e2ed55b27dafe8cf842a794f1");
		ItemMeta safariBallMeta = safariBall.getItemMeta();
		safariBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.safari-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.safari-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			safariBallMeta.setLore(lores);
		}
		safariBall.setItemMeta(safariBallMeta);
		
		ItemStack premierBall = SkullItem.getSkull("http://textures.minecraft.net/texture/db5c8d73fc7a143baca4a18bdcc705176762fa010e313b14d81f8b5ebdc4c47");
		ItemMeta premierBallMeta = premierBall.getItemMeta();
		premierBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.premier-ball.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.premier-ball.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			premierBallMeta.setLore(lores);
		}
		premierBall.setItemMeta(premierBallMeta);
		
		ItemStack warpPipe = SkullItem.getSkull("http://textures.minecraft.net/texture/61954456197fdec22f480ac53e71c6a68a1a8627c6080df57db83dfc3466f");
		ItemMeta warpPipeMeta = warpPipe.getItemMeta();
		warpPipeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.warp-pipe.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.warp-pipe.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			warpPipeMeta.setLore(lores);
		}
		warpPipe.setItemMeta(warpPipeMeta);
		
		ItemStack goomba = SkullItem.getSkull("http://textures.minecraft.net/texture/de6217128c9878390e53c96b8137012249a7ca6896c303c5fb782ace59d9e4a");
		ItemMeta goombaMeta = goomba.getItemMeta();
		goombaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.goomba.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.goomba.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			goombaMeta.setLore(lores);
		}
		goomba.setItemMeta(goombaMeta);
		
		ItemStack orangeCore = SkullItem.getSkull("http://textures.minecraft.net/texture/85c4effba4d99f437314c8a8755856713fd85dcd15b3690c749ce1e44474");
		ItemMeta orangeCoreMeta = orangeCore.getItemMeta();
		orangeCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.orange-core.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.orange-core.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			orangeCoreMeta.setLore(lores);
		}
		orangeCore.setItemMeta(orangeCoreMeta);
		
		ItemStack greenCore = SkullItem.getSkull("http://textures.minecraft.net/texture/335a21d95e8597759fb259c951ea68e1ad3374ca41e56ef126ffabfe03c1e0");
		ItemMeta greenCoreMeta = greenCore.getItemMeta();
		greenCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.green-core.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.green-core.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			greenCoreMeta.setLore(lores);
		}
		greenCore.setItemMeta(greenCoreMeta);
		
		ItemStack illusionBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/cc2c59fcd92625ec4d578159a5fd5bd4247e382d4947284cf50f999c84116c0");
		ItemMeta illusionBlockMeta = illusionBlock.getItemMeta();
		illusionBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.illusion-block.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.illusion-block.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			illusionBlockMeta.setLore(lores);
		}
		illusionBlock.setItemMeta(illusionBlockMeta);
		
		ItemStack illusionBlock2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b462ddfa553ce78683be477b8d8654f3dfc3aa2969808478c987ab88c376a0");
		ItemMeta illusionBlock2Meta = illusionBlock2.getItemMeta();
		illusionBlock2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.illusion-block-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.illusion-block-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			illusionBlock2Meta.setLore(lores);
		}
		illusionBlock2.setItemMeta(illusionBlock2Meta);
		
		ItemStack dragonBall1 = SkullItem.getSkull("http://textures.minecraft.net/texture/49299dc02c35f1bc1a6895d7fc28de77ca890d0663cec5dcd6ea8460af1121");
		ItemMeta dragonBall1Meta = dragonBall1.getItemMeta();
		dragonBall1Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-1.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-1.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall1Meta.setLore(lores);
		}
		dragonBall1.setItemMeta(dragonBall1Meta);
		
		ItemStack dragonBall2 = SkullItem.getSkull("http://textures.minecraft.net/texture/806ac82e3c7427bbcf15821e882d73aeb80eebcc6b455828328aeb70d71a");
		ItemMeta dragonBall2Meta = dragonBall2.getItemMeta();
		dragonBall2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-2.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-2.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall2Meta.setLore(lores);
		}
		dragonBall2.setItemMeta(dragonBall2Meta);
		
		ItemStack dragonBall3 = SkullItem.getSkull("http://textures.minecraft.net/texture/3999254a7ca8d8ba1faddcbab9da323749a1a0f65c89a016f682342768495");
		ItemMeta dragonBall3Meta = dragonBall3.getItemMeta();
		dragonBall3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-3.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-3.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall3Meta.setLore(lores);
		}
		dragonBall3.setItemMeta(dragonBall3Meta);
		
		ItemStack dragonBall4 = SkullItem.getSkull("http://textures.minecraft.net/texture/6a431a5ee3be79b8eb57ab95c8c96d7d751932d6dbd92727f6e372e7c5f");
		ItemMeta dragonBall4Meta = dragonBall4.getItemMeta();
		dragonBall4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-4.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-4.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall4Meta.setLore(lores);
		}
		dragonBall4.setItemMeta(dragonBall4Meta);
		
		ItemStack dragonBall5 = SkullItem.getSkull("http://textures.minecraft.net/texture/4b73257e9bc47bccbafaa54373ca11b875e5ac35c9d5973b581054cc9bba88");
		ItemMeta dragonBall5Meta = dragonBall5.getItemMeta();
		dragonBall5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-5.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-5.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall5Meta.setLore(lores);
		}
		dragonBall5.setItemMeta(dragonBall5Meta);
		
		ItemStack dragonBall6 = SkullItem.getSkull("http://textures.minecraft.net/texture/b7fb6a5ada47056c8bf97566498f5ea4173339fa7819cbce97009e9050de");
		ItemMeta dragonBall6Meta = dragonBall6.getItemMeta();
		dragonBall6Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-6.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-6.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall6Meta.setLore(lores);
		}
		dragonBall6.setItemMeta(dragonBall6Meta);
		
		ItemStack dragonBall7 = SkullItem.getSkull("http://textures.minecraft.net/texture/5c1a7e193f37c2c54e358f22a8a2d0289793dd3b2d6c799e8424b926a3951");
		ItemMeta dragonBall7Meta = dragonBall7.getItemMeta();
		dragonBall7Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.dragon-ball-7.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.dragon-ball-7.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dragonBall7Meta.setLore(lores);
		}
		dragonBall7.setItemMeta(dragonBall7Meta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.page-1.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.games.page-1.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
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
		inventory.setItem(17, masterBall);
		inventory.setItem(18, basketball);
		inventory.setItem(19, masterchiefHalo);
		inventory.setItem(20, yoshi);
		inventory.setItem(21, batman);
		inventory.setItem(22, luigi);
		inventory.setItem(23, mario);
		inventory.setItem(24, solvedRubiksCube);
		inventory.setItem(25, chessBoard);
		inventory.setItem(26, safariBall);
		inventory.setItem(27, premierBall);
		inventory.setItem(28, warpPipe);
		inventory.setItem(29, goomba);
		inventory.setItem(30, orangeCore);
		inventory.setItem(31, greenCore);
		inventory.setItem(32, illusionBlock);
		inventory.setItem(33, illusionBlock2);
		inventory.setItem(34, dragonBall1);
		inventory.setItem(35, dragonBall2);
		inventory.setItem(36, dragonBall3);
		inventory.setItem(37, dragonBall4);
		inventory.setItem(38, dragonBall5);
		inventory.setItem(39, dragonBall6);
		inventory.setItem(40, dragonBall7);
		
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}