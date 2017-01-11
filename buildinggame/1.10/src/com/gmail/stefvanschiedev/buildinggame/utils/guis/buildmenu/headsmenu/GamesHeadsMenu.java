package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class GamesHeadsMenu extends Gui {
	
	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public GamesHeadsMenu() {
		super(null, 54, MessageManager.translate(messages.getString("gui.heads.games.title")), 1);
		
		ItemStack beachball = SkullItem.getSkull("http://textures.minecraft.net/texture/5a5ab05ea254c32e3c48f3fdcf9fd9d77d3cba04e6b5ec2e68b3cbdcfac3fd");
		ItemMeta beachballMeta = beachball.getItemMeta();
		beachballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.beachball.name")));
		beachballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.beachball.lores")));
		beachball.setItemMeta(beachballMeta);
		
		addItem(beachball, new Action());
		
		ItemStack soccerball = SkullItem.getSkull("http://textures.minecraft.net/texture/8e4a70b7bbcd7a8c322d522520491a27ea6b83d60ecf961d2b4efbbf9f605d");
		ItemMeta soccerballMeta = soccerball.getItemMeta();
		soccerballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.soccerball.name")));
		soccerballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.soccerball.lores")));
		soccerball.setItemMeta(soccerballMeta);
		
		addItem(soccerball, new Action());
		
		ItemStack bowlingball = SkullItem.getSkull("http://textures.minecraft.net/texture/6c82e21a9320953d78daee85477de3bb82d5dfa6b19494d37733265d2d030a8");
		ItemMeta bowlingballMeta = bowlingball.getItemMeta();
		bowlingballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.bowlingball.name")));
		bowlingballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.bowlingball.lores")));
		bowlingball.setItemMeta(bowlingballMeta);
		
		addItem(bowlingball, new Action());
		
		ItemStack bowlingball2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9cc861c52486bfc19d28be0644a85b4c712bf71c7b26365ae1b54b9a7173cd0");
		ItemMeta bowlingball2Meta = bowlingball2.getItemMeta();
		bowlingball2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.bowlingball-2.name")));
		bowlingball2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.bowlingball-2.lores")));
		bowlingball2.setItemMeta(bowlingball2Meta);
		
		addItem(bowlingball2, new Action());
		
		ItemStack bowlingball3 = SkullItem.getSkull("http://textures.minecraft.net/texture/c4455d18bc2a6b5a83b69a7290406194fd152c89d9619c08fd88763f136");
		ItemMeta bowlingball3Meta = bowlingball3.getItemMeta();
		bowlingball3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.bowlingball-3.name")));
		bowlingball3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.bowlingball-3.lores")));
		bowlingball3.setItemMeta(bowlingball3Meta);
		
		addItem(bowlingball3, new Action());
		
		ItemStack checkerboard = SkullItem.getSkull("http://textures.minecraft.net/texture/f870a65992c2dd8ad738b98d6d3596e45a2dd14efbace4b21122aeaff777f5");
		ItemMeta checkerboardMeta = checkerboard.getItemMeta();
		checkerboardMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.checkerboard.name")));
		checkerboardMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.checkerboard.lores")));
		checkerboard.setItemMeta(checkerboardMeta);
		
		addItem(checkerboard, new Action());
		
		ItemStack pokeBall = SkullItem.getSkull("http://textures.minecraft.net/texture/d43d4b7ac24a1d650ddf73bd140f49fc12d2736fc14a8dc25c0f3f29d85f8f");
		ItemMeta pokeBallMeta = pokeBall.getItemMeta();
		pokeBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.poke-ball.name")));
		pokeBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.poke-ball.lores")));
		pokeBall.setItemMeta(pokeBallMeta);
		
		addItem(pokeBall, new Action());
		
		ItemStack glados = SkullItem.getSkull("http://textures.minecraft.net/texture/a5bec76d65a868a5be5173d3b9e1775b54046f62035c1552440ede9973a90e1");
		ItemMeta gladosMeta = glados.getItemMeta();
		gladosMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.glados.name")));
		gladosMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.glados.lores")));
		glados.setItemMeta(gladosMeta);
		
		addItem(glados, new Action());
		
		ItemStack turret = SkullItem.getSkull("http://textures.minecraft.net/texture/fa2c3e79d5f35a9dcab19e43c3e3a6519e426b64a61213cd2f1d28b57036f6");
		ItemMeta turretMeta = turret.getItemMeta();
		turretMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.turret.name")));
		turretMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.turret.lores")));
		turret.setItemMeta(turretMeta);
		
		addItem(turret, new Action());
		
		ItemStack companionCube = SkullItem.getSkull("http://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4");
		ItemMeta companionCubeMeta = companionCube.getItemMeta();
		companionCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.companion-cube.name")));
		companionCubeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.companion-cube.lores")));
		companionCube.setItemMeta(companionCubeMeta);
		
		addItem(companionCube, new Action());
		
		ItemStack weightedCube = SkullItem.getSkull("http://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b");
		ItemMeta weightedCubeMeta = weightedCube.getItemMeta();
		weightedCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.weighted-cube.name")));
		weightedCubeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.weighted-cube.lores")));
		weightedCube.setItemMeta(weightedCubeMeta);
		
		addItem(weightedCube, new Action());
		
		ItemStack whiteDice = SkullItem.getSkull("http://textures.minecraft.net/texture/797955462e4e576664499ac4a1c572f6143f19ad2d6194776198f8d136fdb2");
		ItemMeta whiteDiceMeta = whiteDice.getItemMeta();
		whiteDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.white-dice.name")));
		whiteDiceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.white-dice.lores")));
		whiteDice.setItemMeta(whiteDiceMeta);
		
		addItem(whiteDice, new Action());
		
		ItemStack redDice = SkullItem.getSkull("http://textures.minecraft.net/texture/5131de8e951fdd7b9a3d239d7cc3aa3e8655a336b999b9edbb4fb329cbd87");
		ItemMeta redDiceMeta = redDice.getItemMeta();
		redDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.red-dice.name")));
		redDiceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.red-dcie.lores")));
		redDice.setItemMeta(redDiceMeta);
		
		addItem(redDice, new Action());
		
		ItemStack blackDice = SkullItem.getSkull("http://textures.minecraft.net/texture/915f7c313bca9c2f958e68ab14ab393867d67503affff8f20cb13fbe917fd31");
		ItemMeta blackDiceMeta = blackDice.getItemMeta();
		blackDiceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.black-dice.name")));
		blackDiceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.black-dice.lores")));
		blackDice.setItemMeta(blackDiceMeta);
		
		addItem(blackDice, new Action());
		
		ItemStack portalCoreWheatley = SkullItem.getSkull("http://textures.minecraft.net/texture/6684f4a6ed142865db0938e487676849a54d64378e2e9e7f713b9b1e9d041");
		ItemMeta portalCoreWheatleyMeta = portalCoreWheatley.getItemMeta();
		portalCoreWheatleyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.portal-core-wheatley.name")));
		portalCoreWheatleyMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.portal-core-wheatley.lores")));
		portalCoreWheatley.setItemMeta(portalCoreWheatleyMeta);
		
		addItem(portalCoreWheatley, new Action());
		
		ItemStack greatBall = SkullItem.getSkull("http://textures.minecraft.net/texture/ecfaf610275f433a34e5317573ce1f9a0f667ce10cdf1d06c9eba5d9cb57047");
		ItemMeta greatBallMeta = greatBall.getItemMeta();
		greatBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.great-ball.name")));
		greatBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.great-ball.lores")));
		greatBall.setItemMeta(greatBallMeta);
		
		addItem(greatBall, new Action());
		
		ItemStack ultraBall = SkullItem.getSkull("http://textures.minecraft.net/texture/3d85c96efaefef11a1a35b117ca2f231c696e4e693b73a1bae77221607011e");
		ItemMeta ultraBallMeta = ultraBall.getItemMeta();
		ultraBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.ultra-ball.name")));
		ultraBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.ultra-ball.lores")));
		ultraBall.setItemMeta(ultraBallMeta);
		
		addItem(ultraBall, new Action());
		
		ItemStack masterBall = SkullItem.getSkull("http://textures.minecraft.net/texture/1879e64fd2e2d15d1b7e47ae40fa528fc72086a312d6a6ed3f7e552af9d5");
		ItemMeta masterBallMeta = masterBall.getItemMeta();
		masterBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.master-ball.name")));
		masterBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.master-ball.lores")));
		masterBall.setItemMeta(masterBallMeta);
		
		addItem(masterBall, new Action());
		
		ItemStack basketball = SkullItem.getSkull("http://textures.minecraft.net/texture/edf84715a64dc45586f7a6079f8e49a9477c0fe96589b4cfd71cba32254ac8");
		ItemMeta basketballMeta = basketball.getItemMeta();
		basketballMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.basketball.name")));
		basketballMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.basketball.lores")));
		basketball.setItemMeta(basketballMeta);
		
		addItem(basketball, new Action());
		
		ItemStack masterchiefHalo = SkullItem.getSkull("http://textures.minecraft.net/texture/b775a17c2941ae6a2a5f1840509b9ab0c0d96859a9bc249798b86f1952b0832e");
		ItemMeta masterchiefHaloMeta = masterchiefHalo.getItemMeta();
		masterchiefHaloMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.masterchief-halo.name")));
		masterchiefHaloMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.masterchief-halo.lores")));
		masterchiefHalo.setItemMeta(masterchiefHaloMeta);
		
		addItem(masterchiefHalo, new Action());
		
		ItemStack yoshi = SkullItem.getSkull("http://textures.minecraft.net/texture/671ebc11bdd151410da70d931259c4e969528e6f5889e9c4bb2dd763b9eafd");
		ItemMeta yoshiMeta = yoshi.getItemMeta();
		yoshiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.yoshi.name")));
		yoshiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.yoshi.lores")));
		yoshi.setItemMeta(yoshiMeta);
		
		addItem(yoshi, new Action());
		
		ItemStack batman = SkullItem.getSkull("http://textures.minecraft.net/texture/f256f71735ef458581c9dacf394185eed9b33cb6ec5cd594a57153a8b566560");
		ItemMeta batmanMeta = batman.getItemMeta();
		batmanMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.batman.name")));
		batmanMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.batman.lores")));
		batman.setItemMeta(batmanMeta);
		
		addItem(batman, new Action());
		
		ItemStack luigi = SkullItem.getSkull("http://textures.minecraft.net/texture/ff1533871e49ddab8f1ca82edb1153a5e2ed3764fd1ce029bf829f4b3caac3");
		ItemMeta luigiMeta = luigi.getItemMeta();
		luigiMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.luigi.name")));
		luigiMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.luigi.lores")));
		luigi.setItemMeta(luigiMeta);
		
		addItem(luigi, new Action());
		
		ItemStack mario = SkullItem.getSkull("http://textures.minecraft.net/texture/dba8d8e53d8a5a75770b62cce73db6bab701cc3de4a9b654d213d54af9615");
		ItemMeta marioMeta = mario.getItemMeta();
		marioMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.mario.name")));
		marioMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.mario.lores")));
		mario.setItemMeta(marioMeta);
		
		addItem(mario, new Action());
		
		ItemStack solvedRubiksCube = SkullItem.getSkull("http://textures.minecraft.net/texture/8f1a277beb9e4faa6e7e356c74786e966155736a6858bf5bb5ad29df5bab61a1");
		ItemMeta solvedRubiksCubeMeta = solvedRubiksCube.getItemMeta();
		solvedRubiksCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.solved-rubiks-cube.name")));
		solvedRubiksCubeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.solved-rubiks-cube.lores")));
		solvedRubiksCube.setItemMeta(solvedRubiksCubeMeta);
		
		addItem(solvedRubiksCube, new Action());
		
		ItemStack scrambledRubiksCube = SkullItem.getSkull("http://textures.minecraft.net/texture/5d86e7bd28c146f71514c782cac055860d1f372b4a9be3fe65cfe1104733ba");
		ItemMeta scrambledRubiksCubeMeta = scrambledRubiksCube.getItemMeta();
		scrambledRubiksCubeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.scrambled-rubiks-cube.name")));
		scrambledRubiksCubeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.scrambled-rubiks-cube.lores")));
		scrambledRubiksCube.setItemMeta(scrambledRubiksCubeMeta);
		
		addItem(scrambledRubiksCube, new Action());
		
		ItemStack chessBoard = SkullItem.getSkull("http://textures.minecraft.net/texture/94094effee4ba2ab1c2fc6c8ed1c4690fba19c86617e9227db1f58d8dd5d");
		ItemMeta chessBoardMeta = chessBoard.getItemMeta();
		chessBoardMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.chess-board.name")));
		chessBoardMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.chess-board.lores")));
		chessBoard.setItemMeta(chessBoardMeta);
		
		addItem(chessBoard, new Action());
		
		ItemStack safariBall = SkullItem.getSkull("http://textures.minecraft.net/texture/72eac5f499e312165364f1af152660cd3f18d94e2ed55b27dafe8cf842a794f1");
		ItemMeta safariBallMeta = safariBall.getItemMeta();
		safariBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.safari-ball.name")));
		safariBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.safari-ball.lores")));
		safariBall.setItemMeta(safariBallMeta);
		
		addItem(safariBall, new Action());
		
		ItemStack premierBall = SkullItem.getSkull("http://textures.minecraft.net/texture/db5c8d73fc7a143baca4a18bdcc705176762fa010e313b14d81f8b5ebdc4c47");
		ItemMeta premierBallMeta = premierBall.getItemMeta();
		premierBallMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.premier-ball.name")));
		premierBallMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.premier-ball.lores")));
		premierBall.setItemMeta(premierBallMeta);
		
		addItem(premierBall, new Action());
		
		ItemStack warpPipe = SkullItem.getSkull("http://textures.minecraft.net/texture/61954456197fdec22f480ac53e71c6a68a1a8627c6080df57db83dfc3466f");
		ItemMeta warpPipeMeta = warpPipe.getItemMeta();
		warpPipeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.warp-pipe.name")));
		warpPipeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.warp-pipe.lores")));
		warpPipe.setItemMeta(warpPipeMeta);
		
		addItem(warpPipe, new Action());
		
		ItemStack goomba = SkullItem.getSkull("http://textures.minecraft.net/texture/de6217128c9878390e53c96b8137012249a7ca6896c303c5fb782ace59d9e4a");
		ItemMeta goombaMeta = goomba.getItemMeta();
		goombaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.goomba.name")));
		goombaMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.goomba.lores")));
		goomba.setItemMeta(goombaMeta);
		
		addItem(goomba, new Action());
		
		ItemStack orangeCore = SkullItem.getSkull("http://textures.minecraft.net/texture/85c4effba4d99f437314c8a8755856713fd85dcd15b3690c749ce1e44474");
		ItemMeta orangeCoreMeta = orangeCore.getItemMeta();
		orangeCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.orange-core.name")));
		orangeCoreMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.orange-core.lores")));
		orangeCore.setItemMeta(orangeCoreMeta);
		
		addItem(orangeCore, new Action());
		
		ItemStack greenCore = SkullItem.getSkull("http://textures.minecraft.net/texture/335a21d95e8597759fb259c951ea68e1ad3374ca41e56ef126ffabfe03c1e0");
		ItemMeta greenCoreMeta = greenCore.getItemMeta();
		greenCoreMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.green-core.name")));
		greenCoreMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.green-core.lores")));
		greenCore.setItemMeta(greenCoreMeta);
		
		addItem(greenCore, new Action());
		
		ItemStack illusionBlock = SkullItem.getSkull("http://textures.minecraft.net/texture/cc2c59fcd92625ec4d578159a5fd5bd4247e382d4947284cf50f999c84116c0");
		ItemMeta illusionBlockMeta = illusionBlock.getItemMeta();
		illusionBlockMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.illusion-block.name")));
		illusionBlockMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.illusion-block.lores")));
		illusionBlock.setItemMeta(illusionBlockMeta);
		
		addItem(illusionBlock, new Action());
		
		ItemStack illusionBlock2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b462ddfa553ce78683be477b8d8654f3dfc3aa2969808478c987ab88c376a0");
		ItemMeta illusionBlock2Meta = illusionBlock2.getItemMeta();
		illusionBlock2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.illusion-block-2.name")));
		illusionBlock2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.illusion-block-2.lores")));
		illusionBlock2.setItemMeta(illusionBlock2Meta);
		
		addItem(illusionBlock2, new Action());
		
		ItemStack dragonBall1 = SkullItem.getSkull("http://textures.minecraft.net/texture/49299dc02c35f1bc1a6895d7fc28de77ca890d0663cec5dcd6ea8460af1121");
		ItemMeta dragonBall1Meta = dragonBall1.getItemMeta();
		dragonBall1Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-1.name")));
		dragonBall1Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-1.lores")));
		dragonBall1.setItemMeta(dragonBall1Meta);
		
		addItem(dragonBall1, new Action());
		
		ItemStack dragonBall2 = SkullItem.getSkull("http://textures.minecraft.net/texture/806ac82e3c7427bbcf15821e882d73aeb80eebcc6b455828328aeb70d71a");
		ItemMeta dragonBall2Meta = dragonBall2.getItemMeta();
		dragonBall2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-2.name")));
		dragonBall2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-2.lores")));
		dragonBall2.setItemMeta(dragonBall2Meta);
		
		addItem(dragonBall2, new Action());
		
		ItemStack dragonBall3 = SkullItem.getSkull("http://textures.minecraft.net/texture/3999254a7ca8d8ba1faddcbab9da323749a1a0f65c89a016f682342768495");
		ItemMeta dragonBall3Meta = dragonBall3.getItemMeta();
		dragonBall3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-3.name")));
		dragonBall3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-3.lores")));
		dragonBall3.setItemMeta(dragonBall3Meta);
		
		addItem(dragonBall3, new Action());
		
		ItemStack dragonBall4 = SkullItem.getSkull("http://textures.minecraft.net/texture/6a431a5ee3be79b8eb57ab95c8c96d7d751932d6dbd92727f6e372e7c5f");
		ItemMeta dragonBall4Meta = dragonBall4.getItemMeta();
		dragonBall4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-4.name")));
		dragonBall4Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-4.lores")));
		dragonBall4.setItemMeta(dragonBall4Meta);
		
		addItem(dragonBall4, new Action());
		
		ItemStack dragonBall5 = SkullItem.getSkull("http://textures.minecraft.net/texture/4b73257e9bc47bccbafaa54373ca11b875e5ac35c9d5973b581054cc9bba88");
		ItemMeta dragonBall5Meta = dragonBall5.getItemMeta();
		dragonBall5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-5.name")));
		dragonBall5Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-5.lores")));
		dragonBall5.setItemMeta(dragonBall5Meta);
		
		addItem(dragonBall5, new Action());
		
		ItemStack dragonBall6 = SkullItem.getSkull("http://textures.minecraft.net/texture/b7fb6a5ada47056c8bf97566498f5ea4173339fa7819cbce97009e9050de");
		ItemMeta dragonBall6Meta = dragonBall6.getItemMeta();
		dragonBall6Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-6.name")));
		dragonBall6Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-6.lores")));
		dragonBall6.setItemMeta(dragonBall6Meta);
		
		addItem(dragonBall6, new Action());
		
		ItemStack dragonBall7 = SkullItem.getSkull("http://textures.minecraft.net/texture/5c1a7e193f37c2c54e358f22a8a2d0289793dd3b2d6c799e8424b926a3951");
		ItemMeta dragonBall7Meta = dragonBall7.getItemMeta();
		dragonBall7Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.dragon-ball-7.name")));
		dragonBall7Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.dragon-ball-7.lores")));
		dragonBall7.setItemMeta(dragonBall7Meta);
		
		addItem(dragonBall7, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.games.close.name")));
		closeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.games.close.lores")));
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 49);
	}
	
	public class Action extends GuiAction {
		@SuppressWarnings("deprecation")
		@Override
		public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
			if (type != GuiActionType.CLICK)
				return false;
			
			InventoryClickEvent event = (InventoryClickEvent) e;
			event.setCursor(event.getCurrentItem());
			return true;
		}
	}
}