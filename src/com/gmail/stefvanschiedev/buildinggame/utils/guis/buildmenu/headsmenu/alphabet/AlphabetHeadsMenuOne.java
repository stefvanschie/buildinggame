package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.alphabet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class AlphabetHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Alphabet");
		
		ItemStack arrowUp = SkullItem.getSkull("http://textures.minecraft.net/texture/d48b768c623432dfb259fb3c3978e98dec111f79dbd6cd88f21155374b70b3c");
		ItemMeta arrowUpMeta = arrowUp.getItemMeta();
		arrowUpMeta.setDisplayName(ChatColor.GOLD + "Arrow Up");
		arrowUp.setItemMeta(arrowUpMeta);
		
		ItemStack arrowDown = SkullItem.getSkull("http://textures.minecraft.net/texture/2dadd755d08537352bf7a93e3bb7dd4d733121d39f2fb67073cd471f561194dd");
		ItemMeta arrowDownMeta = arrowDown.getItemMeta();
		arrowDownMeta.setDisplayName(ChatColor.GOLD + "Arrow Down");
		arrowDown.setItemMeta(arrowDownMeta);
		
		ItemStack arrowRight = SkullItem.getSkull("http://textures.minecraft.net/texture/1b6f1a25b6bc199946472aedb370522584ff6f4e83221e5946bd2e41b5ca13b");
		ItemMeta arrowRightMeta = arrowRight.getItemMeta();
		arrowRightMeta.setDisplayName(ChatColor.GOLD + "Arrow Right");
		arrowRight.setItemMeta(arrowRightMeta);
		
		ItemStack arrowLeft = SkullItem.getSkull("http://textures.minecraft.net/texture/3ebf907494a935e955bfcadab81beafb90fb9be49c7026ba97d798d5f1a23");
		ItemMeta arrowLeftMeta = arrowLeft.getItemMeta();
		arrowLeftMeta.setDisplayName(ChatColor.GOLD + "Arrow Left");
		arrowLeft.setItemMeta(arrowLeftMeta);
		
		ItemStack question = SkullItem.getSkull("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6");
		ItemMeta questionMeta = question.getItemMeta();
		questionMeta.setDisplayName(ChatColor.GOLD + "Question");
		question.setItemMeta(questionMeta);
		
		ItemStack exclamation = SkullItem.getSkull("http://textures.minecraft.net/texture/6a53bdd1545531c9ebb9c6f895bc576012f61820e6f489885988a7e8709a3f48");
		ItemMeta exclamationMeta = exclamation.getItemMeta();
		exclamationMeta.setDisplayName(ChatColor.GOLD + "Exclamation");
		exclamation.setItemMeta(exclamationMeta);
		
		ItemStack dot = SkullItem.getSkull("http://textures.minecraft.net/texture/733aa24916c88696ee71db7ac8cd306ad73096b5b6ffd868e1c384b1d62cfb3c");
		ItemMeta dotMeta = dot.getItemMeta();
		dotMeta.setDisplayName(ChatColor.GOLD + "Dot");
		dot.setItemMeta(dotMeta);
		
		ItemStack slash = SkullItem.getSkull("http://textures.minecraft.net/texture/7f95d7c1bbf3afa285d8d96757bb5572259a3ae854f5389dc53207699d94fd8");
		ItemMeta slashMeta = slash.getItemMeta();
		slashMeta.setDisplayName(ChatColor.GOLD + "Slash");
		slash.setItemMeta(slashMeta);
		
		ItemStack a = SkullItem.getSkull("http://textures.minecraft.net/texture/a67d813ae7ffe5be951a4f41f2aa619a5e3894e85ea5d4986f84949c63d7672e");
		ItemMeta aMeta = a.getItemMeta();
		aMeta.setDisplayName(ChatColor.GOLD + "A");
		a.setItemMeta(aMeta);
		
		ItemStack b = SkullItem.getSkull("http://textures.minecraft.net/texture/50c1b584f13987b466139285b2f3f28df6787123d0b32283d8794e3374e23");
		ItemMeta bMeta = b.getItemMeta();
		bMeta.setDisplayName(ChatColor.GOLD + "B");
		b.setItemMeta(bMeta);
		
		ItemStack c = SkullItem.getSkull("http://textures.minecraft.net/texture/abe983ec478024ec6fd046fcdfa4842676939551b47350447c77c13af18e6f");
		ItemMeta cMeta = c.getItemMeta();
		cMeta.setDisplayName(ChatColor.GOLD + "C");
		c.setItemMeta(cMeta);
		
		ItemStack d = SkullItem.getSkull("http://textures.minecraft.net/texture/3193dc0d4c5e80ff9a8a05d2fcfe269539cb3927190bac19da2fce61d71");
		ItemMeta dMeta = d.getItemMeta();
		dMeta.setDisplayName(ChatColor.GOLD + "D");
		d.setItemMeta(dMeta);
		
		ItemStack e = SkullItem.getSkull("http://textures.minecraft.net/texture/dbb2737ecbf910efe3b267db7d4b327f360abc732c77bd0e4eff1d510cdef");
		ItemMeta eMeta = e.getItemMeta();
		eMeta.setDisplayName(ChatColor.GOLD + "E");
		e.setItemMeta(eMeta);
		
		ItemStack f = SkullItem.getSkull("http://textures.minecraft.net/texture/b183bab50a3224024886f25251d24b6db93d73c2432559ff49e459b4cd6a");
		ItemMeta fMeta = f.getItemMeta();
		fMeta.setDisplayName(ChatColor.GOLD + "F");
		f.setItemMeta(fMeta);
		
		ItemStack g = SkullItem.getSkull("http://textures.minecraft.net/texture/1ca3f324beeefb6a0e2c5b3c46abc91ca91c14eba419fa4768ac3023dbb4b2");
		ItemMeta gMeta = g.getItemMeta();
		gMeta.setDisplayName(ChatColor.GOLD + "G");
		g.setItemMeta(gMeta);
		
		ItemStack h = SkullItem.getSkull("http://textures.minecraft.net/texture/31f3462a473549f1469f897f84a8d4119bc71d4a5d852e85c26b588a5c0c72f");
		ItemMeta hMeta = h.getItemMeta();
		hMeta.setDisplayName(ChatColor.GOLD + "H");
		h.setItemMeta(hMeta);
		
		ItemStack i = SkullItem.getSkull("http://textures.minecraft.net/texture/46178ad51fd52b19d0a3888710bd92068e933252aac6b13c76e7e6ea5d3226");
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "I");
		i.setItemMeta(iMeta);
		
		ItemStack j = SkullItem.getSkull("http://textures.minecraft.net/texture/3a79db9923867e69c1dbf17151e6f4ad92ce681bcedd3977eebbc44c206f49");
		ItemMeta jMeta = j.getItemMeta();
		jMeta.setDisplayName(ChatColor.GOLD + "J");
		j.setItemMeta(jMeta);
		
		ItemStack k = SkullItem.getSkull("http://textures.minecraft.net/texture/9461b38c8e45782ada59d16132a4222c193778e7d70c4542c9536376f37be42");
		ItemMeta kMeta = k.getItemMeta();
		kMeta.setDisplayName(ChatColor.GOLD + "K");
		k.setItemMeta(kMeta);
		
		ItemStack l = SkullItem.getSkull("http://textures.minecraft.net/texture/319f50b432d868ae358e16f62ec26f35437aeb9492bce1356c9aa6bb19a386");
		ItemMeta lMeta = l.getItemMeta();
		lMeta.setDisplayName(ChatColor.GOLD + "L");
		l.setItemMeta(lMeta);
		
		ItemStack m = SkullItem.getSkull("http://textures.minecraft.net/texture/49c45a24aaabf49e217c15483204848a73582aba7fae10ee2c57bdb76482f");
		ItemMeta mMeta = m.getItemMeta();
		mMeta.setDisplayName(ChatColor.GOLD + "M");
		m.setItemMeta(mMeta);
		
		ItemStack n = SkullItem.getSkull("http://textures.minecraft.net/texture/35b8b3d8c77dfb8fbd2495c842eac94fffa6f593bf15a2574d854dff3928");
		ItemMeta nMeta = n.getItemMeta();
		nMeta.setDisplayName(ChatColor.GOLD + "N");
		n.setItemMeta(nMeta);
		
		ItemStack o = SkullItem.getSkull("http://textures.minecraft.net/texture/d11de1cadb2ade61149e5ded1bd885edf0df6259255b33b587a96f983b2a1");
		ItemMeta oMeta = o.getItemMeta();
		oMeta.setDisplayName(ChatColor.GOLD + "O");
		o.setItemMeta(oMeta);
		
		ItemStack p = SkullItem.getSkull("http://textures.minecraft.net/texture/a0a7989b5d6e621a121eedae6f476d35193c97c1a7cb8ecd43622a485dc2e912");
		ItemMeta pMeta = p.getItemMeta();
		pMeta.setDisplayName(ChatColor.GOLD + "P");
		p.setItemMeta(pMeta);
		
		ItemStack q = SkullItem.getSkull("http://textures.minecraft.net/texture/43609f1faf81ed49c5894ac14c94ba52989fda4e1d2a52fd945a55ed719ed4");
		ItemMeta qMeta = q.getItemMeta();
		qMeta.setDisplayName(ChatColor.GOLD + "Q");
		q.setItemMeta(qMeta);
		
		ItemStack r = SkullItem.getSkull("http://textures.minecraft.net/texture/a5ced9931ace23afc351371379bf05c635ad186943bc136474e4e5156c4c37");
		ItemMeta rMeta = r.getItemMeta();
		rMeta.setDisplayName(ChatColor.GOLD + "R");
		r.setItemMeta(rMeta);
		
		ItemStack s = SkullItem.getSkull("http://textures.minecraft.net/texture/3e41c60572c533e93ca421228929e54d6c856529459249c25c32ba33a1b1517");
		ItemMeta sMeta = s.getItemMeta();
		sMeta.setDisplayName(ChatColor.GOLD + "S");
		s.setItemMeta(sMeta);
		
		ItemStack t = SkullItem.getSkull("http://textures.minecraft.net/texture/1562e8c1d66b21e459be9a24e5c027a34d269bdce4fbee2f7678d2d3ee4718");
		ItemMeta tMeta = t.getItemMeta();
		tMeta.setDisplayName(ChatColor.GOLD + "T");
		t.setItemMeta(tMeta);
		
		ItemStack u = SkullItem.getSkull("http://textures.minecraft.net/texture/607fbc339ff241ac3d6619bcb68253dfc3c98782baf3f1f4efdb954f9c26");
		ItemMeta uMeta = u.getItemMeta();
		uMeta.setDisplayName(ChatColor.GOLD + "U");
		u.setItemMeta(uMeta);
		
		ItemStack v = SkullItem.getSkull("http://textures.minecraft.net/texture/cc9a138638fedb534d79928876baba261c7a64ba79c424dcbafcc9bac7010b8");
		ItemMeta vMeta = v.getItemMeta();
		vMeta.setDisplayName(ChatColor.GOLD + "V");
		v.setItemMeta(vMeta);
		
		ItemStack w = SkullItem.getSkull("http://textures.minecraft.net/texture/269ad1a88ed2b074e1303a129f94e4b710cf3e5b4d995163567f68719c3d9792");
		ItemMeta wMeta = w.getItemMeta();
		wMeta.setDisplayName(ChatColor.GOLD + "W");
		w.setItemMeta(wMeta);
		
		ItemStack x = SkullItem.getSkull("http://textures.minecraft.net/texture/5a6787ba32564e7c2f3a0ce64498ecbb23b89845e5a66b5cec7736f729ed37");
		ItemMeta xMeta = x.getItemMeta();
		xMeta.setDisplayName(ChatColor.GOLD + "X");
		x.setItemMeta(xMeta);
		
		ItemStack y = SkullItem.getSkull("http://textures.minecraft.net/texture/c52fb388e33212a2478b5e15a96f27aca6c62ac719e1e5f87a1cf0de7b15e918");
		ItemMeta yMeta = y.getItemMeta();
		yMeta.setDisplayName(ChatColor.GOLD + "Y");
		y.setItemMeta(yMeta);
		
		ItemStack z = SkullItem.getSkull("http://textures.minecraft.net/texture/90582b9b5d97974b11461d63eced85f438a3eef5dc3279f9c47e1e38ea54ae8d");
		ItemMeta zMeta = z.getItemMeta();
		zMeta.setDisplayName(ChatColor.GOLD + "Z");
		z.setItemMeta(zMeta);
		
		ItemStack one = SkullItem.getSkull("http://textures.minecraft.net/texture/71bc2bcfb2bd3759e6b1e86fc7a79585e1127dd357fc202893f9de241bc9e530");
		ItemMeta oneMeta = one.getItemMeta();
		oneMeta.setDisplayName(ChatColor.GOLD + "1");
		one.setItemMeta(oneMeta);
		
		ItemStack two = SkullItem.getSkull("http://textures.minecraft.net/texture/4cd9eeee883468881d83848a46bf3012485c23f75753b8fbe8487341419847");
		ItemMeta twoMeta = two.getItemMeta();
		twoMeta.setDisplayName(ChatColor.GOLD + "2");
		two.setItemMeta(twoMeta);
		
		ItemStack three = SkullItem.getSkull("http://textures.minecraft.net/texture/1d4eae13933860a6df5e8e955693b95a8c3b15c36b8b587532ac0996bc37e5");
		ItemMeta threeMeta = three.getItemMeta();
		threeMeta.setDisplayName(ChatColor.GOLD + "3");
		three.setItemMeta(threeMeta);
		
		ItemStack four = SkullItem.getSkull("http://textures.minecraft.net/texture/d2e78fb22424232dc27b81fbcb47fd24c1acf76098753f2d9c28598287db5");
		ItemMeta fourMeta = four.getItemMeta();
		fourMeta.setDisplayName(ChatColor.GOLD + "Four");
		four.setItemMeta(fourMeta);
		
		ItemStack five = SkullItem.getSkull("http://textures.minecraft.net/texture/6d57e3bc88a65730e31a14e3f41e038a5ecf0891a6c243643b8e5476ae2");
		ItemMeta fiveMeta = five.getItemMeta();
		fiveMeta.setDisplayName(ChatColor.GOLD + "Five");
		five.setItemMeta(fiveMeta);
		
		ItemStack six = SkullItem.getSkull("http://textures.minecraft.net/texture/334b36de7d679b8bbc725499adaef24dc518f5ae23e716981e1dcc6b2720ab");
		ItemMeta sixMeta = six.getItemMeta();
		sixMeta.setDisplayName(ChatColor.GOLD + "Six");
		six.setItemMeta(sixMeta);
		
		ItemStack seven = SkullItem.getSkull("http://textures.minecraft.net/texture/6db6eb25d1faabe30cf444dc633b5832475e38096b7e2402a3ec476dd7b9");
		ItemMeta sevenMeta = seven.getItemMeta();
		sevenMeta.setDisplayName(ChatColor.GOLD + "Seven");
		seven.setItemMeta(sevenMeta);
		
		ItemStack eight = SkullItem.getSkull("http://textures.minecraft.net/texture/59194973a3f17bda9978ed6273383997222774b454386c8319c04f1f4f74c2b5");
		ItemMeta eightMeta = eight.getItemMeta();
		eightMeta.setDisplayName(ChatColor.GOLD + "8");
		eight.setItemMeta(eightMeta);
		
		ItemStack nine = SkullItem.getSkull("http://textures.minecraft.net/texture/e67caf7591b38e125a8017d58cfc6433bfaf84cd499d794f41d10bff2e5b840");
		ItemMeta nineMeta = nine.getItemMeta();
		nineMeta.setDisplayName(ChatColor.GOLD + "9");
		nine.setItemMeta(nineMeta);
		
		ItemStack zero = SkullItem.getSkull("http://textures.minecraft.net/texture/0ebe7e5215169a699acc6cefa7b73fdb108db87bb6dae2849fbe24714b27");
		ItemMeta zeroMeta = zero.getItemMeta();
		zeroMeta.setDisplayName(ChatColor.GOLD + "0");
		zero.setItemMeta(zeroMeta);
		
		ItemStack arrowUp2 = SkullItem.getSkull("http://textures.minecraft.net/texture/58fe251a40e4167d35d081c27869ac151af96b6bd16dd2834d5dc7235f47791d");
		ItemMeta arrowUp2Meta = arrowUp2.getItemMeta();
		arrowUp2Meta.setDisplayName(ChatColor.GOLD + "Arrow Up");
		arrowUp2.setItemMeta(arrowUp2Meta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(ChatColor.GREEN + "Next Page");
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
		inventory.setItem(0, arrowUp);
		inventory.setItem(1, arrowDown);
		inventory.setItem(2, arrowRight);
		inventory.setItem(3, arrowLeft);
		inventory.setItem(4, question);
		inventory.setItem(5, exclamation);
		inventory.setItem(6, dot);
		inventory.setItem(7, slash);
		inventory.setItem(8, a);
		inventory.setItem(9, b);
		inventory.setItem(10, c);
		inventory.setItem(11, d);
		inventory.setItem(12, e);
		inventory.setItem(13, f);
		inventory.setItem(14, g);
		inventory.setItem(15, h);
		inventory.setItem(16, i);
		inventory.setItem(17, j);
		inventory.setItem(18, k);
		inventory.setItem(19, l);
		inventory.setItem(20, m);
		inventory.setItem(21, n);
		inventory.setItem(22, o);
		inventory.setItem(23, p);
		inventory.setItem(24, q);
		inventory.setItem(25, r);
		inventory.setItem(26, s);
		inventory.setItem(27, t);
		inventory.setItem(28, u);
		inventory.setItem(29, v);
		inventory.setItem(30, w);
		inventory.setItem(31, x);
		inventory.setItem(32, y);
		inventory.setItem(33, z);
		inventory.setItem(34, one);
		inventory.setItem(35, two);
		inventory.setItem(36, three);
		inventory.setItem(37, four);
		inventory.setItem(38, five);
		inventory.setItem(39, six);
		inventory.setItem(40, seven);
		inventory.setItem(41, eight);
		inventory.setItem(42, nine);
		inventory.setItem(43, zero);
		inventory.setItem(44, arrowUp);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}