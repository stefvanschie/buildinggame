package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class MiscHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Misc");
		
		ItemStack kissy = SkullItem.getSkull("http://textures.minecraft.net/texture/545bd18a2aaf469fad72e52cde6cfb02bfbaa5bfed2a8151277f779ebcdcec1");
		ItemMeta kissyMeta = kissy.getItemMeta();
		kissyMeta.setDisplayName(ChatColor.GOLD + "Kissy");
		kissy.setItemMeta(kissyMeta);
		
		ItemStack sad = SkullItem.getSkull("http://textures.minecraft.net/texture/14968ac5af3146826fa2b0d4dd114fda197f8b28f4750553f3f88836a21fac9");
		ItemMeta sadMeta = sad.getItemMeta();
		sadMeta.setDisplayName(ChatColor.GOLD + "Sad");
		sad.setItemMeta(sadMeta);
		
		ItemStack cool = SkullItem.getSkull("http://textures.minecraft.net/texture/868f4cef949f32e33ec5ae845f9c56983cbe13375a4dec46e5bbfb7dcb6");
		ItemMeta coolMeta = cool.getItemMeta();
		coolMeta.setDisplayName(ChatColor.GOLD + "Cool");
		cool.setItemMeta(coolMeta);
		
		ItemStack surprised = SkullItem.getSkull("http://textures.minecraft.net/texture/bc2b9b9ae622bd68adff7180f8206ec4494abbfa130e94a584ec692e8984ab2");
		ItemMeta surprisedMeta = surprised.getItemMeta();
		surprisedMeta.setDisplayName(ChatColor.GOLD + "Surprised");
		surprised.setItemMeta(surprisedMeta);
		
		ItemStack dead = SkullItem.getSkull("http://textures.minecraft.net/texture/b371e4e1cf6a1a36fdae27137fd9b8748e6169299925f9af2be301e54298c73");
		ItemMeta deadMeta = dead.getItemMeta();
		deadMeta.setDisplayName(ChatColor.GOLD + "Dead");
		dead.setItemMeta(deadMeta);
		
		ItemStack foreverCrying = SkullItem.getSkull("http://textures.minecraft.net/texture/1f1b875de49c587e3b4023ce24d472ff27583a1f054f37e73a1154b5b5498");
		ItemMeta foreverCryingMeta = foreverCrying.getItemMeta();
		foreverCryingMeta.setDisplayName(ChatColor.GOLD + "Forever Crying");
		foreverCrying.setItemMeta(foreverCryingMeta);

		ItemStack bigGrin = SkullItem.getSkull("http://textures.minecraft.net/texture/5059d59eb4e59c31eecf9ece2f9cf3934e45c0ec476fc86bfaef8ea913ea710");
		ItemMeta bigGrinMeta = bigGrin.getItemMeta();
		bigGrinMeta.setDisplayName(ChatColor.GOLD + "Big Grin");
		bigGrin.setItemMeta(bigGrinMeta);
		
		ItemStack wink = SkullItem.getSkull("http://textures.minecraft.net/texture/f4ea2d6f939fefeff5d122e63dd26fa8a427df90b2928bc1fa89a8252a7e");
		ItemMeta winkMeta = wink.getItemMeta();
		winkMeta.setDisplayName(ChatColor.GOLD + "Wink");
		wink.setItemMeta(winkMeta);
		
		ItemStack derp = SkullItem.getSkull("textures.minecraft.net/texture/3baabe724eae59c5d13f442c7dc5d2b1c6b70c2f83364a488ce5973ae80b4c3");
		ItemMeta derpMeta = derp.getItemMeta();
		derpMeta.setDisplayName(ChatColor.GOLD + "Derp");
		derp.setItemMeta(derpMeta);
		
		ItemStack mustache = SkullItem.getSkull("textures.minecraft.net/texture/3636f2724aa6aa4de7ac46c19f3c845fb14847a518c8f7e03d792c82effb1");
		ItemMeta mustacheMeta = mustache.getItemMeta();
		mustacheMeta.setDisplayName(ChatColor.GOLD + "Mustache");
		mustache.setItemMeta(mustacheMeta);
		
		ItemStack bigSmile = SkullItem.getSkull("http://textures.minecraft.net/texture/7ffaccf17879b17891fc5ef66472cc066a85bfa31b6d786c32afee4796068d");
		ItemMeta bigSmileMeta = bigSmile.getItemMeta();
		bigSmileMeta.setDisplayName(ChatColor.GOLD + "Big Smile");
		bigSmile.setItemMeta(bigSmileMeta);
		
		ItemStack smile = SkullItem.getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8");
		ItemMeta smileMeta = smile.getItemMeta();
		smileMeta.setDisplayName(ChatColor.GOLD + "Smile");
		smile.setItemMeta(smileMeta);
		
		ItemStack beehive = SkullItem.getSkull("http://textures.minecraft.net/texture/20342dc9c2ad886acfe3ca2e987b7e28a87c774ca5f3d8cb2bfabe131cafe8");
		ItemMeta beehiveMeta = beehive.getItemMeta();
		beehiveMeta.setDisplayName(ChatColor.GOLD + "Beehive");
		beehive.setItemMeta(beehiveMeta);
		
		ItemStack netherlands = SkullItem.getSkull("http://textures.minecraft.net/texture/c23cf210edea396f2f5dfbced69848434f93404eefeabf54b23c073b090adf");
		ItemMeta netherlandsMeta = netherlands.getItemMeta();
		netherlandsMeta.setDisplayName(ChatColor.GOLD + "Netherlands");
		netherlands.setItemMeta(netherlandsMeta);
		
		ItemStack norway = SkullItem.getSkull("http://textures.minecraft.net/texture/e0596e165ec3f389b59cfdda93dd6e363e97d9c6456e7c2e123973fa6c5fda");
		ItemMeta norwayMeta = norway.getItemMeta();
		norwayMeta.setDisplayName(ChatColor.GOLD + "Norway");
		norway.setItemMeta(norwayMeta);
		
		ItemStack sweden = SkullItem.getSkull("http://textures.minecraft.net/texture/e910904bff9c86f6ed47688e9429c26e8d9c5d5743bd3ebb8e6f5040be192998");
		ItemMeta swedenMeta = sweden.getItemMeta();
		swedenMeta.setDisplayName(ChatColor.GOLD + "Sweden");
		sweden.setItemMeta(swedenMeta);
		
		ItemStack egypt = SkullItem.getSkull("http://textures.minecraft.net/texture/826e742b32f0f8db59c07b1bcdde6f8a93f85c929e598c7e9273b9211f2ce78");
		ItemMeta egyptMeta = egypt.getItemMeta();
		egyptMeta.setDisplayName(ChatColor.GOLD + "Egypt");
		egypt.setItemMeta(egyptMeta);
		
		ItemStack chile = SkullItem.getSkull("http://textures.minecraft.net/texture/ed1dddc665614c9f6487ba9c666da7579561589a494ef744aaf8f4f88a16");
		ItemMeta chileMeta = chile.getItemMeta();
		chileMeta.setDisplayName(ChatColor.GOLD + "Chile");
		chile.setItemMeta(chileMeta);
		
		ItemStack monaco = SkullItem.getSkull("http://textures.minecraft.net/texture/5db2678ccaba7934412cb97ee16d416463a392574c5906352f18dea42895ee");
		ItemMeta monacoMeta = monaco.getItemMeta();
		monacoMeta.setDisplayName(ChatColor.GOLD + "Monaco");
		monaco.setItemMeta(monacoMeta);
		
		ItemStack canada = SkullItem.getSkull("http://textures.minecraft.net/texture/f241a697f6dfb1c57cda327baa6732a7828c398be4ebfdbd166c232bcae2b");
		ItemMeta canadaMeta = canada.getItemMeta();
		canadaMeta.setDisplayName(ChatColor.GOLD + "Canada");
		canada.setItemMeta(canadaMeta);
		
		ItemStack unitedStatesOfAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7d15d566202ac0e76cd897759df5d01c11f991bd46c5c9a04357ea89ee75");
		ItemMeta unitedStatesOfAmericaMeta = unitedStatesOfAmerica.getItemMeta();
		unitedStatesOfAmericaMeta.setDisplayName(ChatColor.GOLD + "United States of America");
		unitedStatesOfAmerica.setItemMeta(unitedStatesOfAmericaMeta);
		
		ItemStack belgium = SkullItem.getSkull("http://textures.minecraft.net/texture/5c78aae42ef9ee9faa67b64bb974cea275ce702655d35f841b6017416ee1c393");
		ItemMeta belgiumMeta = belgium.getItemMeta();
		belgiumMeta.setDisplayName(ChatColor.GOLD + "Belgium");
		belgium.setItemMeta(belgiumMeta);
		
		ItemStack italy = SkullItem.getSkull("http://textures.minecraft.net/texture/a56c5cc17319a6c9ec847252e4d274552d97da95e1085072dba49d117cf3");
		ItemMeta italyMeta = italy.getItemMeta();
		italyMeta.setDisplayName(ChatColor.GOLD + "Italy");
		italy.setItemMeta(italyMeta);
		
		ItemStack england = SkullItem.getSkull("http://textures.minecraft.net/texture/bee5c850afbb7d8843265a146211ac9c615f733dcc5a8e2190e5c247dea32");
		ItemMeta englandMeta = england.getItemMeta();
		englandMeta.setDisplayName(ChatColor.GOLD + "England");
		england.setItemMeta(englandMeta);
		
		ItemStack romania = SkullItem.getSkull("http://textures.minecraft.net/texture/84d380aa9d66a2a966eb1cfc17608f28fbfe3a75f6a18a8be544682586c41c4");
		ItemMeta romaniaMeta = romania.getItemMeta();
		romaniaMeta.setDisplayName(ChatColor.GOLD + "Romania");
		romania.setItemMeta(romaniaMeta);
		
		ItemStack germany = SkullItem.getSkull("http://textures.minecraft.net/texture/5e7899b4806858697e283f084d9173fe487886453774626b24bd8cfecc77b3f");
		ItemMeta germanyMeta = germany.getItemMeta();
		germanyMeta.setDisplayName(ChatColor.GOLD + "Germany");
		germany.setItemMeta(germanyMeta);
		
		ItemStack singapore = SkullItem.getSkull("http://textures.minecraft.net/texture/8b5ed11f797f3fc61eaf8dafb6bf3234d31b96ab7596bd2df722d2ef3473c27");
		ItemMeta singaporeMeta = singapore.getItemMeta();
		singaporeMeta.setDisplayName(ChatColor.GOLD + "Singapore");
		singapore.setItemMeta(singaporeMeta);
		
		ItemStack northKorea = SkullItem.getSkull("http://textures.minecraft.net/texture/1969d12662faebfaca6f4b0442fcb251fd60b61a9fcdceea2bdc21e025eb21");
		ItemMeta northKoreaMeta = northKorea.getItemMeta();
		northKoreaMeta.setDisplayName(ChatColor.GOLD + "North Korea");
		northKorea.setItemMeta(northKoreaMeta);
		
		ItemStack france = SkullItem.getSkull("http://textures.minecraft.net/texture/ba25287d1140fb1741d4b6f7e65672f9e64fffe80ea7371c7f3ec5a6f04039");
		ItemMeta franceMeta = france.getItemMeta();
		franceMeta.setDisplayName(ChatColor.GOLD + "France");
		france.setItemMeta(franceMeta);
		
		ItemStack crown = SkullItem.getSkull("http://textures.minecraft.net/texture/c2baf0c589a6b583511d83c268240842d3364774ec9f566d1fd4d349cf42fb");
		ItemMeta crownMeta = crown.getItemMeta();
		crownMeta.setDisplayName(ChatColor.GOLD + "Crown");
		crown.setItemMeta(crownMeta);
		
		ItemStack emeraldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b656da666d2759e8195642142e119e6585852c6619e2ad79ae2ad181465");
		ItemMeta emeraldSteveHeadMeta = emeraldSteveHead.getItemMeta();
		emeraldSteveHeadMeta.setDisplayName(ChatColor.GOLD + "Emerald Steve Head");
		emeraldSteveHead.setItemMeta(emeraldSteveHeadMeta);
		
		inventory.setItem(0, kissy);
		inventory.setItem(1, sad);
		inventory.setItem(2, cool);
		inventory.setItem(3, surprised);
		inventory.setItem(4, dead);
		inventory.setItem(5, foreverCrying);
		inventory.setItem(6, bigGrin);
		inventory.setItem(7, wink);
		inventory.setItem(8, derp);
		inventory.setItem(9, mustache);
		inventory.setItem(10, bigSmile);
		inventory.setItem(11, smile);
		inventory.setItem(12, beehive);
		inventory.setItem(13, netherlands);
		inventory.setItem(14, norway);
		inventory.setItem(15, sweden);
		inventory.setItem(16, egypt);
		inventory.setItem(17, chile);
		inventory.setItem(18, monaco);
		inventory.setItem(19, canada);
		inventory.setItem(20, unitedStatesOfAmerica);
		inventory.setItem(21, belgium);
		inventory.setItem(22, italy);
		inventory.setItem(23, england);
		inventory.setItem(24, romania);
		inventory.setItem(25, germany);
		inventory.setItem(26, singapore);
		inventory.setItem(27, northKorea);
		inventory.setItem(28, france);
		inventory.setItem(29, crown);
		inventory.setItem(30, emeraldSteveHead);
	}
}