package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.misc;

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

public class MiscHeadsMenuTwo {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.misc.page-2.title")));
		
		ItemStack kissy = SkullItem.getSkull("http://textures.minecraft.net/texture/545bd18a2aaf469fad72e52cde6cfb02bfbaa5bfed2a8151277f779ebcdcec1");
		ItemMeta kissyMeta = kissy.getItemMeta();
		kissyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.kissy.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.kissy.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			kissyMeta.setLore(lores);
		}
		kissy.setItemMeta(kissyMeta);
		
		ItemStack sad = SkullItem.getSkull("http://textures.minecraft.net/texture/14968ac5af3146826fa2b0d4dd114fda197f8b28f4750553f3f88836a21fac9");
		ItemMeta sadMeta = sad.getItemMeta();
		sadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.sad.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.sad.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sadMeta.setLore(lores);
		}
		sad.setItemMeta(sadMeta);
		
		ItemStack cool = SkullItem.getSkull("http://textures.minecraft.net/texture/868f4cef949f32e33ec5ae845f9c56983cbe13375a4dec46e5bbfb7dcb6");
		ItemMeta coolMeta = cool.getItemMeta();
		coolMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.cool.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.cool.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			coolMeta.setLore(lores);
		}
		cool.setItemMeta(coolMeta);
		
		ItemStack surprised = SkullItem.getSkull("http://textures.minecraft.net/texture/bc2b9b9ae622bd68adff7180f8206ec4494abbfa130e94a584ec692e8984ab2");
		ItemMeta surprisedMeta = surprised.getItemMeta();
		surprisedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.surprised.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.surprised.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			surprisedMeta.setLore(lores);
		}
		surprised.setItemMeta(surprisedMeta);
		
		ItemStack dead = SkullItem.getSkull("http://textures.minecraft.net/texture/b371e4e1cf6a1a36fdae27137fd9b8748e6169299925f9af2be301e54298c73");
		ItemMeta deadMeta = dead.getItemMeta();
		deadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.dead.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.dead.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			deadMeta.setLore(lores);
		}
		dead.setItemMeta(deadMeta);
		
		ItemStack foreverCrying = SkullItem.getSkull("http://textures.minecraft.net/texture/1f1b875de49c587e3b4023ce24d472ff27583a1f054f37e73a1154b5b5498");
		ItemMeta foreverCryingMeta = foreverCrying.getItemMeta();
		foreverCryingMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.forever-crying.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.forever-crying.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			foreverCryingMeta.setLore(lores);
		}
		foreverCrying.setItemMeta(foreverCryingMeta);

		ItemStack bigGrin = SkullItem.getSkull("http://textures.minecraft.net/texture/5059d59eb4e59c31eecf9ece2f9cf3934e45c0ec476fc86bfaef8ea913ea710");
		ItemMeta bigGrinMeta = bigGrin.getItemMeta();
		bigGrinMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.big-grin.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.big-grin.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bigGrinMeta.setLore(lores);
		}
		bigGrin.setItemMeta(bigGrinMeta);
		
		ItemStack wink = SkullItem.getSkull("http://textures.minecraft.net/texture/f4ea2d6f939fefeff5d122e63dd26fa8a427df90b2928bc1fa89a8252a7e");
		ItemMeta winkMeta = wink.getItemMeta();
		winkMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.wink.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.wink.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			winkMeta.setLore(lores);
		}
		wink.setItemMeta(winkMeta);
		
		ItemStack derp = SkullItem.getSkull("http://textures.minecraft.net/texture/3baabe724eae59c5d13f442c7dc5d2b1c6b70c2f83364a488ce5973ae80b4c3");
		ItemMeta derpMeta = derp.getItemMeta();
		derpMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.derp.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.derp.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			derpMeta.setLore(lores);
		}
		derp.setItemMeta(derpMeta);
		
		ItemStack mustache = SkullItem.getSkull("http://textures.minecraft.net/texture/3636f2724aa6aa4de7ac46c19f3c845fb14847a518c8f7e03d792c82effb1");
		ItemMeta mustacheMeta = mustache.getItemMeta();
		mustacheMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.mustache.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.mustache.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mustacheMeta.setLore(lores);
		}
		mustache.setItemMeta(mustacheMeta);
		
		ItemStack bigSmile = SkullItem.getSkull("http://textures.minecraft.net/texture/7ffaccf17879b17891fc5ef66472cc066a85bfa31b6d786c32afee4796068d");
		ItemMeta bigSmileMeta = bigSmile.getItemMeta();
		bigSmileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.big-smile.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.big-smile.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bigSmileMeta.setLore(lores);
		}
		bigSmile.setItemMeta(bigSmileMeta);
		
		ItemStack smile = SkullItem.getSkull("http://textures.minecraft.net/texture/52e98165deef4ed621953921c1ef817dc638af71c1934a4287b69d7a31f6b8");
		ItemMeta smileMeta = smile.getItemMeta();
		smileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.smile.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.smile.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			smileMeta.setLore(lores);
		}
		smile.setItemMeta(smileMeta);
		
		ItemStack beehive = SkullItem.getSkull("http://textures.minecraft.net/texture/20342dc9c2ad886acfe3ca2e987b7e28a87c774ca5f3d8cb2bfabe131cafe8");
		ItemMeta beehiveMeta = beehive.getItemMeta();
		beehiveMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.beehive.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.beehive.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			beehiveMeta.setLore(lores);
		}
		beehive.setItemMeta(beehiveMeta);
		
		ItemStack netherlands = SkullItem.getSkull("http://textures.minecraft.net/texture/c23cf210edea396f2f5dfbced69848434f93404eefeabf54b23c073b090adf");
		ItemMeta netherlandsMeta = netherlands.getItemMeta();
		netherlandsMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.netherlands.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.netherlands.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			netherlandsMeta.setLore(lores);
		}
		netherlands.setItemMeta(netherlandsMeta);
		
		ItemStack norway = SkullItem.getSkull("http://textures.minecraft.net/texture/e0596e165ec3f389b59cfdda93dd6e363e97d9c6456e7c2e123973fa6c5fda");
		ItemMeta norwayMeta = norway.getItemMeta();
		norwayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.norway.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.norway.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			norwayMeta.setLore(lores);
		}
		norway.setItemMeta(norwayMeta);
		
		ItemStack sweden = SkullItem.getSkull("http://textures.minecraft.net/texture/e910904bff9c86f6ed47688e9429c26e8d9c5d5743bd3ebb8e6f5040be192998");
		ItemMeta swedenMeta = sweden.getItemMeta();
		swedenMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.sweden.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.sweden.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			swedenMeta.setLore(lores);
		}
		sweden.setItemMeta(swedenMeta);
		
		ItemStack egypt = SkullItem.getSkull("http://textures.minecraft.net/texture/826e742b32f0f8db59c07b1bcdde6f8a93f85c929e598c7e9273b9211f2ce78");
		ItemMeta egyptMeta = egypt.getItemMeta();
		egyptMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.egypt.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.egypt.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			egyptMeta.setLore(lores);
		}
		egypt.setItemMeta(egyptMeta);
		
		ItemStack chile = SkullItem.getSkull("http://textures.minecraft.net/texture/ed1dddc665614c9f6487ba9c666da7579561589a494ef744aaf8f4f88a16");
		ItemMeta chileMeta = chile.getItemMeta();
		chileMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.chile.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.chile.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			chileMeta.setLore(lores);
		}
		chile.setItemMeta(chileMeta);
		
		ItemStack monaco = SkullItem.getSkull("http://textures.minecraft.net/texture/5db2678ccaba7934412cb97ee16d416463a392574c5906352f18dea42895ee");
		ItemMeta monacoMeta = monaco.getItemMeta();
		monacoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.monaco.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.monaco.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			monacoMeta.setLore(lores);
		}
		monaco.setItemMeta(monacoMeta);
		
		ItemStack canada = SkullItem.getSkull("http://textures.minecraft.net/texture/f241a697f6dfb1c57cda327baa6732a7828c398be4ebfdbd166c232bcae2b");
		ItemMeta canadaMeta = canada.getItemMeta();
		canadaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.canada.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.canada.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			canadaMeta.setLore(lores);
		}
		canada.setItemMeta(canadaMeta);
		
		ItemStack unitedStatesOfAmerica = SkullItem.getSkull("http://textures.minecraft.net/texture/7d15d566202ac0e76cd897759df5d01c11f991bd46c5c9a04357ea89ee75");
		ItemMeta unitedStatesOfAmericaMeta = unitedStatesOfAmerica.getItemMeta();
		unitedStatesOfAmericaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.united-states-of-america.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.united-states-of-america.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			unitedStatesOfAmericaMeta.setLore(lores);
		}
		unitedStatesOfAmerica.setItemMeta(unitedStatesOfAmericaMeta);
		
		ItemStack belgium = SkullItem.getSkull("http://textures.minecraft.net/texture/5c78aae42ef9ee9faa67b64bb974cea275ce702655d35f841b6017416ee1c393");
		ItemMeta belgiumMeta = belgium.getItemMeta();
		belgiumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.belgium.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.belgium.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			belgiumMeta.setLore(lores);
		}
		belgium.setItemMeta(belgiumMeta);
		
		ItemStack italy = SkullItem.getSkull("http://textures.minecraft.net/texture/a56c5cc17319a6c9ec847252e4d274552d97da95e1085072dba49d117cf3");
		ItemMeta italyMeta = italy.getItemMeta();
		italyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.italy.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.italy.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			italyMeta.setLore(lores);
		}
		italy.setItemMeta(italyMeta);
		
		ItemStack england = SkullItem.getSkull("http://textures.minecraft.net/texture/bee5c850afbb7d8843265a146211ac9c615f733dcc5a8e2190e5c247dea32");
		ItemMeta englandMeta = england.getItemMeta();
		englandMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.england.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.england.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			englandMeta.setLore(lores);
		}
		england.setItemMeta(englandMeta);
		
		ItemStack romania = SkullItem.getSkull("http://textures.minecraft.net/texture/84d380aa9d66a2a966eb1cfc17608f28fbfe3a75f6a18a8be544682586c41c4");
		ItemMeta romaniaMeta = romania.getItemMeta();
		romaniaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.romania.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.romania.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			romaniaMeta.setLore(lores);
		}
		romania.setItemMeta(romaniaMeta);
		
		ItemStack germany = SkullItem.getSkull("http://textures.minecraft.net/texture/5e7899b4806858697e283f084d9173fe487886453774626b24bd8cfecc77b3f");
		ItemMeta germanyMeta = germany.getItemMeta();
		germanyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.germany.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.germany.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			germanyMeta.setLore(lores);
		}
		germany.setItemMeta(germanyMeta);
		
		ItemStack singapore = SkullItem.getSkull("http://textures.minecraft.net/texture/8b5ed11f797f3fc61eaf8dafb6bf3234d31b96ab7596bd2df722d2ef3473c27");
		ItemMeta singaporeMeta = singapore.getItemMeta();
		singaporeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.singapore.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.singapore.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			singaporeMeta.setLore(lores);
		}
		singapore.setItemMeta(singaporeMeta);
		
		ItemStack northKorea = SkullItem.getSkull("http://textures.minecraft.net/texture/1969d12662faebfaca6f4b0442fcb251fd60b61a9fcdceea2bdc21e025eb21");
		ItemMeta northKoreaMeta = northKorea.getItemMeta();
		northKoreaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.north-korea.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.north-korea.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			northKoreaMeta.setLore(lores);
		}
		northKorea.setItemMeta(northKoreaMeta);
		
		ItemStack france = SkullItem.getSkull("http://textures.minecraft.net/texture/ba25287d1140fb1741d4b6f7e65672f9e64fffe80ea7371c7f3ec5a6f04039");
		ItemMeta franceMeta = france.getItemMeta();
		franceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.france.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.france.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			franceMeta.setLore(lores);
		}
		france.setItemMeta(franceMeta);
		
		ItemStack crown = SkullItem.getSkull("http://textures.minecraft.net/texture/c2baf0c589a6b583511d83c268240842d3364774ec9f566d1fd4d349cf42fb");
		ItemMeta crownMeta = crown.getItemMeta();
		crownMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.crown.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.crown.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			crownMeta.setLore(lores);
		}
		crown.setItemMeta(crownMeta);
		
		ItemStack emeraldSteveHead = SkullItem.getSkull("http://textures.minecraft.net/texture/b5b656da666d2759e8195642142e119e6585852c6619e2ad79ae2ad181465");
		ItemMeta emeraldSteveHeadMeta = emeraldSteveHead.getItemMeta();
		emeraldSteveHeadMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.emerald-steve-head.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.emerald-steve-head.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			emeraldSteveHeadMeta.setLore(lores);
		}
		emeraldSteveHead.setItemMeta(emeraldSteveHeadMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.previous-page.lores")) {
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
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.misc.page-2.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.misc.page-2.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
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
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}