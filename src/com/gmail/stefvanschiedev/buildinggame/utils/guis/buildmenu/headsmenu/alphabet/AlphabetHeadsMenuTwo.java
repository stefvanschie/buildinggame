package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.alphabet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class AlphabetHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Alphabet");
		
		ItemStack arrowDown = SkullItem.getSkull("http://textures.minecraft.net/texture/9b7ce683d0868aa4378aeb60caa5ea80596bcffdab6b5af2d12595837a84853");
		ItemMeta arrowDownMeta = arrowDown.getItemMeta();
		arrowDownMeta.setDisplayName(ChatColor.GOLD + "Arrow Down");
		arrowDown.setItemMeta(arrowDownMeta);
		
		ItemStack arrowRight = SkullItem.getSkull("http://textures.minecraft.net/texture/f2f3a2dfce0c3dab7ee10db385e5229f1a39534a8ba2646178e37c4fa93b");
		ItemMeta arrowRightMeta = arrowRight.getItemMeta();
		arrowRightMeta.setDisplayName(ChatColor.GOLD + "Arrow Right");
		arrowRight.setItemMeta(arrowRightMeta);
		
		ItemStack arrowLeft = SkullItem.getSkull("http://textures.minecraft.net/texture/bb0f6e8af46ac6faf88914191ab66f261d6726a7999c637cf2e4159fe1fc477");
		ItemMeta arrowLeftMeta = arrowLeft.getItemMeta();
		arrowLeftMeta.setDisplayName(ChatColor.GOLD + "Arrow Left");
		arrowLeft.setItemMeta(arrowLeftMeta);
		
		ItemStack question = SkullItem.getSkull("http://textures.minecraft.net/texture/3aab272840d790c2ed2be5c860289f95d88e316b65c456ff6a35180d2e5bff6");
		ItemMeta questionMeta = question.getItemMeta();
		questionMeta.setDisplayName(ChatColor.GOLD + "Question");
		question.setItemMeta(questionMeta);
		
		ItemStack exclamation = SkullItem.getSkull("http://textures.minecraft.net/texture/87d19aabfcfd99ffaba4214caef299516ce52e6d13bf2dda125985e481b72f9");
		ItemMeta exclamationMeta = exclamation.getItemMeta();
		exclamationMeta.setDisplayName(ChatColor.GOLD + "Exclamation");
		exclamation.setItemMeta(exclamationMeta);
		
		ItemStack dot = SkullItem.getSkull("http://textures.minecraft.net/texture/6ff99ff279a2cf25deb4bd5b66c3576b824cc96c36781027af727ed3a4c1308e");
		ItemMeta dotMeta = dot.getItemMeta();
		dotMeta.setDisplayName(ChatColor.GOLD + "Dot");
		dot.setItemMeta(dotMeta);
		
		ItemStack slash = SkullItem.getSkull("http://textures.minecraft.net/texture/2d593f0945cbb85a8e0be7d9a526010ee774810f2bc428cd4a23e4d232eff8");
		ItemMeta slashMeta = slash.getItemMeta();
		slashMeta.setDisplayName(ChatColor.GOLD + "Slash");
		slash.setItemMeta(slashMeta);
		
		ItemStack a = SkullItem.getSkull("http://textures.minecraft.net/texture/2ac58b1a3b53b9481e317a1ea4fc5eed6bafca7a25e741a32e4e3c2841278c");
		ItemMeta aMeta = a.getItemMeta();
		aMeta.setDisplayName(ChatColor.GOLD + "A");
		a.setItemMeta(aMeta);
		
		ItemStack b = SkullItem.getSkull("http://textures.minecraft.net/texture/d4c711571e7e214ee78dfe4ee0e1263b92516e418de8fc8f3257ae0901431");
		ItemMeta bMeta = b.getItemMeta();
		bMeta.setDisplayName(ChatColor.GOLD + "B");
		b.setItemMeta(bMeta);
		
		ItemStack c = SkullItem.getSkull("http://textures.minecraft.net/texture/fff5aabead6feafaaecf4422cdd7837cbb36b03c9841dd1b1d2d3edb7825e851");
		ItemMeta cMeta = c.getItemMeta();
		cMeta.setDisplayName(ChatColor.GOLD + "C");
		c.setItemMeta(cMeta);
		
		ItemStack d = SkullItem.getSkull("http://textures.minecraft.net/texture/893e622b581975792f7c119ec6f40a4f16e552bb98776b0c7ae2bdfd4154fe7");
		ItemMeta dMeta = d.getItemMeta();
		dMeta.setDisplayName(ChatColor.GOLD + "D");
		d.setItemMeta(dMeta);
		
		ItemStack e = SkullItem.getSkull("http://textures.minecraft.net/texture/a157d65b19921c760ff4910b3404455b9c2ee36afc202d8538baefec676953");
		ItemMeta eMeta = e.getItemMeta();
		eMeta.setDisplayName(ChatColor.GOLD + "E");
		e.setItemMeta(eMeta);
		
		ItemStack f = SkullItem.getSkull("http://textures.minecraft.net/texture/a157d65b19921c760ff4910b3404455b9c2ee36afc202d8538baefec676953");
		ItemMeta fMeta = f.getItemMeta();
		fMeta.setDisplayName(ChatColor.GOLD + "F");
		f.setItemMeta(fMeta);
		
		ItemStack g = SkullItem.getSkull("http://textures.minecraft.net/texture/d3c9f8a74ca01ba8c54de1edc82e1fc07a83923e66574b6ffe606919240c6");
		ItemMeta gMeta = g.getItemMeta();
		gMeta.setDisplayName(ChatColor.GOLD + "G");
		g.setItemMeta(gMeta);
		
		ItemStack h = SkullItem.getSkull("http://textures.minecraft.net/texture/f8c58c509034617bf81ee0db9be0ba3e85ca15568163914c87669edb2fd7");
		ItemMeta hMeta = h.getItemMeta();
		hMeta.setDisplayName(ChatColor.GOLD + "H");
		h.setItemMeta(hMeta);
		
		ItemStack i = SkullItem.getSkull("http://textures.minecraft.net/texture/4246323c9fb319326ee2bf3f5b63ec3d99df76a12439bf0b4c3ab32d13fd9");
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "I");
		i.setItemMeta(iMeta);
		
		ItemStack j = SkullItem.getSkull("http://textures.minecraft.net/texture/c58456cd9bb8a7e978591ae0cb26af1aadad4fa7a16725b295145e09bed8064");
		ItemMeta jMeta = j.getItemMeta();
		jMeta.setDisplayName(ChatColor.GOLD + "J");
		j.setItemMeta(jMeta);
		
		ItemStack k = SkullItem.getSkull("http://textures.minecraft.net/texture/af49fb708369e7bc2944ad706963fb6ac6ce6d4c67081ddadecfe5da51");
		ItemMeta kMeta = k.getItemMeta();
		kMeta.setDisplayName(ChatColor.GOLD + "K");
		k.setItemMeta(kMeta);
		
		ItemStack l = SkullItem.getSkull("http://textures.minecraft.net/texture/8c84f75416e853a74f6c70fc7e1093d53961879955b433bd8c7c6d5a6df");
		ItemMeta lMeta = l.getItemMeta();
		lMeta.setDisplayName(ChatColor.GOLD + "L");
		l.setItemMeta(lMeta);
		
		ItemStack m = SkullItem.getSkull("http://textures.minecraft.net/texture/31fde91b19b9309913724fea9e85311271c67bcb78578d461bf65d9613074");
		ItemMeta mMeta = m.getItemMeta();
		mMeta.setDisplayName(ChatColor.GOLD + "M");
		m.setItemMeta(mMeta);
		
		ItemStack n = SkullItem.getSkull("http://textures.minecraft.net/texture/1c7c972e6785d6b0aceb779abdd7702d98341c24c2a71e702930eca58055");
		ItemMeta nMeta = n.getItemMeta();
		nMeta.setDisplayName(ChatColor.GOLD + "N");
		n.setItemMeta(nMeta);
		
		ItemStack o = SkullItem.getSkull("http://textures.minecraft.net/texture/8073bb44f9345f9bb31a679027e7939e461842a8c27486d7a6b842c39eb38c4e");
		ItemMeta oMeta = o.getItemMeta();
		oMeta.setDisplayName(ChatColor.GOLD + "O");
		o.setItemMeta(oMeta);
		
		ItemStack p = SkullItem.getSkull("http://textures.minecraft.net/texture/64b231a8d55870cfb5a9f4e65db06dd7f8e34282f1416f95878b19acc34ac95");
		ItemMeta pMeta = p.getItemMeta();
		pMeta.setDisplayName(ChatColor.GOLD + "P");
		p.setItemMeta(pMeta);
		
		ItemStack q = SkullItem.getSkull("http://textures.minecraft.net/texture/ffedd6f9efdb156b86935699b2b4834df0f5d214513c01d38af3bd031cbcc92");
		ItemMeta qMeta = q.getItemMeta();
		qMeta.setDisplayName(ChatColor.GOLD + "Q");
		q.setItemMeta(qMeta);
		
		ItemStack r = SkullItem.getSkull("http://textures.minecraft.net/texture/c03a1cd583cbbffde08f943e56ac3e3afafecaede834221a81e6db6c64667f7d");
		ItemMeta rMeta = r.getItemMeta();
		rMeta.setDisplayName(ChatColor.GOLD + "R");
		r.setItemMeta(rMeta);
		
		ItemStack s = SkullItem.getSkull("http://textures.minecraft.net/texture/b6572e655725d78375a9817eb9ee8b37829ca1fea93b6095cc7aa19e5eac");
		ItemMeta sMeta = s.getItemMeta();
		sMeta.setDisplayName(ChatColor.GOLD + "S");
		s.setItemMeta(sMeta);
		
		ItemStack t = SkullItem.getSkull("http://textures.minecraft.net/texture/708c9ef3a3751e254e2af1ad8b5d668ccf5c6ec3ea2641877cba575807d39");
		ItemMeta tMeta = t.getItemMeta();
		tMeta.setDisplayName(ChatColor.GOLD + "T");
		t.setItemMeta(tMeta);
		
		ItemStack u = SkullItem.getSkull("http://textures.minecraft.net/texture/55a6e3ae5ae625923524838fac9fef5b42527f5027c9ca149e6c207792eb");
		ItemMeta uMeta = u.getItemMeta();
		uMeta.setDisplayName(ChatColor.GOLD + "U");
		u.setItemMeta(uMeta);
		
		ItemStack v = SkullItem.getSkull("http://textures.minecraft.net/texture/975121f7d9c68da0e5b6a96ac615298b12b2ee5bd19989436ee647879da5b");
		ItemMeta vMeta = v.getItemMeta();
		vMeta.setDisplayName(ChatColor.GOLD + "V");
		v.setItemMeta(vMeta);
		
		ItemStack w = SkullItem.getSkull("http://textures.minecraft.net/texture/67e165c3edc5541d4654c4728871e6908f613fc0ec46e823c96eac82ac62e62");
		ItemMeta wMeta = w.getItemMeta();
		wMeta.setDisplayName(ChatColor.GOLD + "W");
		w.setItemMeta(wMeta);
		
		ItemStack x = SkullItem.getSkull("http://textures.minecraft.net/texture/1919d1594bf809db7b44b3782bf90a69f449a87ce5d18cb40eb653fdec2722");
		ItemMeta xMeta = x.getItemMeta();
		xMeta.setDisplayName(ChatColor.GOLD + "X");
		x.setItemMeta(xMeta);
		
		ItemStack y = SkullItem.getSkull("http://textures.minecraft.net/texture/e35424bb86305d7747604b13e924d74f1efe38906e4e458dd18dcc67b6ca48");
		ItemMeta yMeta = y.getItemMeta();
		yMeta.setDisplayName(ChatColor.GOLD + "Y");
		y.setItemMeta(yMeta);
		
		ItemStack z = SkullItem.getSkull("http://textures.minecraft.net/texture/4e91200df1cae51acc071f85c7f7f5b8449d39bb32f363b0aa51dbc85d133e");
		ItemMeta zMeta = z.getItemMeta();
		zMeta.setDisplayName(ChatColor.GOLD + "Z");
		z.setItemMeta(zMeta);
		
		ItemStack one = SkullItem.getSkull("http://textures.minecraft.net/texture/31a9463fd3c433d5e1d9fec6d5d4b09a83a970b0b74dd546ce67a73348caab");
		ItemMeta oneMeta = one.getItemMeta();
		oneMeta.setDisplayName(ChatColor.GOLD + "1");
		one.setItemMeta(oneMeta);
		
		ItemStack two = SkullItem.getSkull("http://textures.minecraft.net/texture/acb419d984d8796373c9646233c7a02664bd2ce3a1d3476dd9b1c5463b14ebe");
		ItemMeta twoMeta = two.getItemMeta();
		twoMeta.setDisplayName(ChatColor.GOLD + "2");
		two.setItemMeta(twoMeta);
		
		ItemStack three = SkullItem.getSkull("http://textures.minecraft.net/texture/f8ebab57b7614bb22a117be43e848bcd14daecb50e8f5d0926e4864dff470");
		ItemMeta threeMeta = three.getItemMeta();
		threeMeta.setDisplayName(ChatColor.GOLD + "3");
		three.setItemMeta(threeMeta);
		
		ItemStack four = SkullItem.getSkull("http://textures.minecraft.net/texture/62bfcfb489da867dce96e3c3c17a3db7c79cae8ac1f9a5a8c8ac95e4ba3");
		ItemMeta fourMeta = four.getItemMeta();
		fourMeta.setDisplayName(ChatColor.GOLD + "4");
		four.setItemMeta(fourMeta);
		
		ItemStack five = SkullItem.getSkull("http://textures.minecraft.net/texture/ef4ecf110b0acee4af1da343fb136f1f2c216857dfda6961defdbee7b9528");
		ItemMeta fiveMeta = five.getItemMeta();
		fiveMeta.setDisplayName(ChatColor.GOLD + "Five");
		five.setItemMeta(fiveMeta);
		
		ItemStack six = SkullItem.getSkull("http://textures.minecraft.net/texture/f331a6a6fcd6995b62088d353bfb68d9b89ae258325caf3f2886464f54a7329");
		ItemMeta sixMeta = six.getItemMeta();
		sixMeta.setDisplayName(ChatColor.GOLD + "6");
		six.setItemMeta(sixMeta);
		
		ItemStack seven = SkullItem.getSkull("http://textures.minecraft.net/texture/d4ba6ac07d422377a855793f36dea2ed240223f52fd1648181612ecd1a0cfd5");
		ItemMeta sevenMeta = seven.getItemMeta();
		sevenMeta.setDisplayName(ChatColor.GOLD + "7");
		seven.setItemMeta(sevenMeta);
		
		ItemStack eight = SkullItem.getSkull("http://textures.minecraft.net/texture/c61a8a641437be9aea207253dd3f25440d954ea2b5866c552f386b29ac4d049");
		ItemMeta eightMeta = eight.getItemMeta();
		eightMeta.setDisplayName(ChatColor.GOLD + "8");
		eight.setItemMeta(eightMeta);
		
		ItemStack nine = SkullItem.getSkull("http://textures.minecraft.net/texture/a1928e1bfd86a9b79397c4cb4b65ef99af49b7d5f7957ad62c0c699a622cfbe");
		ItemMeta nineMeta = nine.getItemMeta();
		nineMeta.setDisplayName(ChatColor.GOLD + "9");
		nine.setItemMeta(nineMeta);
		
		ItemStack zero = SkullItem.getSkull("http://textures.minecraft.net/texture/55a224807693978ed834355f9e5145f9c56ef68cf6f2c9e1734a46e246aae1");
		ItemMeta zeroMeta = zero.getItemMeta();
		zeroMeta.setDisplayName(ChatColor.GOLD + "0");
		zero.setItemMeta(zeroMeta);
		
		ItemStack dot2 = SkullItem.getSkull("http://textures.minecraft.net/texture/bd898c40e47c5d2d76924065360768065d624ee5b9ee0be9e12b98fb77c76");
		ItemMeta dot2Meta = dot2.getItemMeta();
		dot2Meta.setDisplayName(ChatColor.GOLD + "Dot 2");
		dot2.setItemMeta(dot2Meta);
		
		ItemStack diaeresisA = SkullItem.getSkull("http://textures.minecraft.net/texture/4c9c2bbd7b7f7204dceb5729a6fba7fd45d6f193f3760ec59a6807533e63b");
		ItemMeta diaeresisAMeta = diaeresisA.getItemMeta();
		diaeresisAMeta.setDisplayName(ChatColor.GOLD + "Ä");
		diaeresisA.setItemMeta(diaeresisAMeta);
		
		//previous page
		
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(ChatColor.GREEN + "Previous Page");
		previous.setItemMeta(previousMeta);
		
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
		
		inventory.setItem(0, arrowDown);
		inventory.setItem(1, arrowRight);
		inventory.setItem(2, arrowLeft);
		inventory.setItem(3, question);
		inventory.setItem(4, exclamation);
		inventory.setItem(5, dot);
		inventory.setItem(6, slash);
		inventory.setItem(7, a);
		inventory.setItem(8, b);
		inventory.setItem(9, c);
		inventory.setItem(10, d);
		inventory.setItem(11, e);
		inventory.setItem(12, f);
		inventory.setItem(13, g);
		inventory.setItem(14, h);
		inventory.setItem(15, i);
		inventory.setItem(16, j);
		inventory.setItem(17, k);
		inventory.setItem(18, l);
		inventory.setItem(19, m);
		inventory.setItem(20, n);
		inventory.setItem(21, o);
		inventory.setItem(22, p);
		inventory.setItem(23, q);
		inventory.setItem(24, r);
		inventory.setItem(25, s);
		inventory.setItem(26, t);
		inventory.setItem(27, u);
		inventory.setItem(28, v);
		inventory.setItem(29, w);
		inventory.setItem(30, x);
		inventory.setItem(31, y);
		inventory.setItem(32, z);
		inventory.setItem(33, one);
		inventory.setItem(34, two);
		inventory.setItem(35, three);
		inventory.setItem(36, four);
		inventory.setItem(37, five);
		inventory.setItem(38, six);
		inventory.setItem(39, seven);
		inventory.setItem(40, eight);
		inventory.setItem(41, nine);
		inventory.setItem(42, zero);
		inventory.setItem(43, dot2);
		inventory.setItem(44, diaeresisA);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}