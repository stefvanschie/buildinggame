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
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.SkullItem;

public class AlphabetHeadsMenu extends Gui {

	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	public AlphabetHeadsMenu() {
		super(null, 54, MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.title")), 3);
		
		//page one
		ItemStack arrowUp = SkullItem.getSkull("http://textures.minecraft.net/texture/d48b768c623432dfb259fb3c3978e98dec111f79dbd6cd88f21155374b70b3c");
		ItemMeta arrowUpMeta = arrowUp.getItemMeta();
		arrowUpMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-up.name")));
		arrowUpMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-up.lores")));
		arrowUp.setItemMeta(arrowUpMeta);
		
		addItem(arrowUp, new Action());
		
		ItemStack arrowDown = SkullItem.getSkull("http://textures.minecraft.net/texture/2dadd755d08537352bf7a93e3bb7dd4d733121d39f2fb67073cd471f561194dd");
		ItemMeta arrowDownMeta = arrowDown.getItemMeta();
		arrowDownMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-down.name")));
		arrowDownMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-down.lores")));
		arrowDown.setItemMeta(arrowDownMeta);
		
		addItem(arrowDown, new Action());
		
		ItemStack arrowRight = SkullItem.getSkull("http://textures.minecraft.net/texture/1b6f1a25b6bc199946472aedb370522584ff6f4e83221e5946bd2e41b5ca13b");
		ItemMeta arrowRightMeta = arrowRight.getItemMeta();
		arrowRightMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-right.name")));
		arrowRightMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-right.lores")));
		arrowRight.setItemMeta(arrowRightMeta);
		
		addItem(arrowRight, new Action());
		
		ItemStack arrowLeft = SkullItem.getSkull("http://textures.minecraft.net/texture/3ebf907494a935e955bfcadab81beafb90fb9be49c7026ba97d798d5f1a23");
		ItemMeta arrowLeftMeta = arrowLeft.getItemMeta();
		arrowLeftMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-left.name")));
		arrowLeftMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-left.lores")));
		arrowLeft.setItemMeta(arrowLeftMeta);
		
		addItem(arrowLeft, new Action());
		
		ItemStack question = SkullItem.getSkull("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6");
		ItemMeta questionMeta = question.getItemMeta();
		questionMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.question.name")));
		questionMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.question.lores")));
		question.setItemMeta(questionMeta);
		
		addItem(question, new Action());
		
		ItemStack exclamation = SkullItem.getSkull("http://textures.minecraft.net/texture/6a53bdd1545531c9ebb9c6f895bc576012f61820e6f489885988a7e8709a3f48");
		ItemMeta exclamationMeta = exclamation.getItemMeta();
		exclamationMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.exclamation.name")));
		exclamationMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.exclamation.lores")));
		exclamation.setItemMeta(exclamationMeta);
		
		addItem(exclamation, new Action());
		
		ItemStack dot = SkullItem.getSkull("http://textures.minecraft.net/texture/733aa24916c88696ee71db7ac8cd306ad73096b5b6ffd868e1c384b1d62cfb3c");
		ItemMeta dotMeta = dot.getItemMeta();
		dotMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.dot.name")));
		dotMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.dot.lores")));
		dot.setItemMeta(dotMeta);
		
		addItem(dot, new Action());
		
		ItemStack slash = SkullItem.getSkull("http://textures.minecraft.net/texture/7f95d7c1bbf3afa285d8d96757bb5572259a3ae854f5389dc53207699d94fd8");
		ItemMeta slashMeta = slash.getItemMeta();
		slashMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.slash.name")));
		slashMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.slash.lores")));
		slash.setItemMeta(slashMeta);
		
		addItem(slash, new Action());
		
		ItemStack a = SkullItem.getSkull("http://textures.minecraft.net/texture/a67d813ae7ffe5be951a4f41f2aa619a5e3894e85ea5d4986f84949c63d7672e");
		ItemMeta aMeta = a.getItemMeta();
		aMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.a.name")));
		aMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.a.lores")));
		a.setItemMeta(aMeta);
		
		addItem(a, new Action());
		
		ItemStack b = SkullItem.getSkull("http://textures.minecraft.net/texture/50c1b584f13987b466139285b2f3f28df6787123d0b32283d8794e3374e23");
		ItemMeta bMeta = b.getItemMeta();
		bMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.b.name")));
		bMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.b.lores")));
		b.setItemMeta(bMeta);
		
		addItem(b, new Action());
		
		ItemStack c = SkullItem.getSkull("http://textures.minecraft.net/texture/abe983ec478024ec6fd046fcdfa4842676939551b47350447c77c13af18e6f");
		ItemMeta cMeta = c.getItemMeta();
		cMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.c.name")));
		cMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.c.lores")));
		c.setItemMeta(cMeta);
		
		addItem(c, new Action());
		
		ItemStack d = SkullItem.getSkull("http://textures.minecraft.net/texture/3193dc0d4c5e80ff9a8a05d2fcfe269539cb3927190bac19da2fce61d71");
		ItemMeta dMeta = d.getItemMeta();
		dMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.d.name")));
		dMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.d.lores")));
		d.setItemMeta(dMeta);
		
		addItem(d, new Action());
		
		ItemStack e = SkullItem.getSkull("http://textures.minecraft.net/texture/dbb2737ecbf910efe3b267db7d4b327f360abc732c77bd0e4eff1d510cdef");
		ItemMeta eMeta = e.getItemMeta();
		eMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.e.name")));
		eMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.e.lores")));
		e.setItemMeta(eMeta);
		
		addItem(e, new Action());
		
		ItemStack f = SkullItem.getSkull("http://textures.minecraft.net/texture/b183bab50a3224024886f25251d24b6db93d73c2432559ff49e459b4cd6a");
		ItemMeta fMeta = f.getItemMeta();
		fMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.f.name")));
		fMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.f.lores")));
		f.setItemMeta(fMeta);
		
		addItem(f, new Action());
		
		ItemStack g = SkullItem.getSkull("http://textures.minecraft.net/texture/1ca3f324beeefb6a0e2c5b3c46abc91ca91c14eba419fa4768ac3023dbb4b2");
		ItemMeta gMeta = g.getItemMeta();
		gMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.g.name")));
		gMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.g.lores")));
		g.setItemMeta(gMeta);
		
		addItem(g, new Action());
		
		ItemStack h = SkullItem.getSkull("http://textures.minecraft.net/texture/31f3462a473549f1469f897f84a8d4119bc71d4a5d852e85c26b588a5c0c72f");
		ItemMeta hMeta = h.getItemMeta();
		hMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.h.name")));
		hMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.h.lores")));
		h.setItemMeta(hMeta);
		
		addItem(h, new Action());
		
		ItemStack i = SkullItem.getSkull("http://textures.minecraft.net/texture/46178ad51fd52b19d0a3888710bd92068e933252aac6b13c76e7e6ea5d3226");
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.i.name")));
		iMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.i.lores")));
		i.setItemMeta(iMeta);
		
		addItem(i, new Action());
		
		ItemStack j = SkullItem.getSkull("http://textures.minecraft.net/texture/3a79db9923867e69c1dbf17151e6f4ad92ce681bcedd3977eebbc44c206f49");
		ItemMeta jMeta = j.getItemMeta();
		jMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.j.name")));
		jMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.j.lores")));
		j.setItemMeta(jMeta);
		
		addItem(j, new Action());
		
		ItemStack k = SkullItem.getSkull("http://textures.minecraft.net/texture/9461b38c8e45782ada59d16132a4222c193778e7d70c4542c9536376f37be42");
		ItemMeta kMeta = k.getItemMeta();
		kMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.k.name")));
		kMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.k.lores")));
		k.setItemMeta(kMeta);
		
		addItem(k, new Action());
		
		ItemStack l = SkullItem.getSkull("http://textures.minecraft.net/texture/319f50b432d868ae358e16f62ec26f35437aeb9492bce1356c9aa6bb19a386");
		ItemMeta lMeta = l.getItemMeta();
		lMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.l.name")));
		lMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.l.lores")));
		l.setItemMeta(lMeta);
		
		addItem(l, new Action());
		
		ItemStack m = SkullItem.getSkull("http://textures.minecraft.net/texture/49c45a24aaabf49e217c15483204848a73582aba7fae10ee2c57bdb76482f");
		ItemMeta mMeta = m.getItemMeta();
		mMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.m.name")));
		mMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet1.m.lores")));
		m.setItemMeta(mMeta);
		
		addItem(m, new Action());
		
		ItemStack n = SkullItem.getSkull("http://textures.minecraft.net/texture/35b8b3d8c77dfb8fbd2495c842eac94fffa6f593bf15a2574d854dff3928");
		ItemMeta nMeta = n.getItemMeta();
		nMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.n.name")));
		nMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.n.lores")));
		n.setItemMeta(nMeta);
		
		addItem(n, new Action());
		
		ItemStack o = SkullItem.getSkull("http://textures.minecraft.net/texture/d11de1cadb2ade61149e5ded1bd885edf0df6259255b33b587a96f983b2a1");
		ItemMeta oMeta = o.getItemMeta();
		oMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.o.name")));
		oMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.o.lores")));
		o.setItemMeta(oMeta);
		
		addItem(o, new Action());
		
		ItemStack p = SkullItem.getSkull("http://textures.minecraft.net/texture/a0a7989b5d6e621a121eedae6f476d35193c97c1a7cb8ecd43622a485dc2e912");
		ItemMeta pMeta = p.getItemMeta();
		pMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.p.name")));
		pMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.p.lores")));
		p.setItemMeta(pMeta);
		
		addItem(p, new Action());
		
		ItemStack q = SkullItem.getSkull("http://textures.minecraft.net/texture/43609f1faf81ed49c5894ac14c94ba52989fda4e1d2a52fd945a55ed719ed4");
		ItemMeta qMeta = q.getItemMeta();
		qMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.q.name")));
		qMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.q.lores")));
		q.setItemMeta(qMeta);
		
		addItem(q, new Action());
		
		ItemStack r = SkullItem.getSkull("http://textures.minecraft.net/texture/a5ced9931ace23afc351371379bf05c635ad186943bc136474e4e5156c4c37");
		ItemMeta rMeta = r.getItemMeta();
		rMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.r.name")));
		rMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.r.lores")));
		r.setItemMeta(rMeta);
		
		addItem(r, new Action());
		
		ItemStack s = SkullItem.getSkull("http://textures.minecraft.net/texture/3e41c60572c533e93ca421228929e54d6c856529459249c25c32ba33a1b1517");
		ItemMeta sMeta = s.getItemMeta();
		sMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.s.name")));
		sMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.s.lores")));
		s.setItemMeta(sMeta);
		
		addItem(s, new Action());
		
		ItemStack t = SkullItem.getSkull("http://textures.minecraft.net/texture/1562e8c1d66b21e459be9a24e5c027a34d269bdce4fbee2f7678d2d3ee4718");
		ItemMeta tMeta = t.getItemMeta();
		tMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.t.name")));
		tMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.t.lores")));
		t.setItemMeta(tMeta);
		
		addItem(t, new Action());
		
		ItemStack u = SkullItem.getSkull("http://textures.minecraft.net/texture/607fbc339ff241ac3d6619bcb68253dfc3c98782baf3f1f4efdb954f9c26");
		ItemMeta uMeta = u.getItemMeta();
		uMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.u.name")));
		uMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.u.lores")));
		u.setItemMeta(uMeta);
		
		addItem(u, new Action());
		
		ItemStack v = SkullItem.getSkull("http://textures.minecraft.net/texture/cc9a138638fedb534d79928876baba261c7a64ba79c424dcbafcc9bac7010b8");
		ItemMeta vMeta = v.getItemMeta();
		vMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.v.name")));
		vMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.v.lores")));
		v.setItemMeta(vMeta);
		
		addItem(v, new Action());
		
		ItemStack w = SkullItem.getSkull("http://textures.minecraft.net/texture/269ad1a88ed2b074e1303a129f94e4b710cf3e5b4d995163567f68719c3d9792");
		ItemMeta wMeta = w.getItemMeta();
		wMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.w.name")));
		wMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.w.lores")));
		w.setItemMeta(wMeta);
		
		addItem(w, new Action());
		
		ItemStack x = SkullItem.getSkull("http://textures.minecraft.net/texture/5a6787ba32564e7c2f3a0ce64498ecbb23b89845e5a66b5cec7736f729ed37");
		ItemMeta xMeta = x.getItemMeta();
		xMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.x.name")));
		xMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.x.lores")));
		x.setItemMeta(xMeta);
		
		addItem(x, new Action());
		
		ItemStack y = SkullItem.getSkull("http://textures.minecraft.net/texture/c52fb388e33212a2478b5e15a96f27aca6c62ac719e1e5f87a1cf0de7b15e918");
		ItemMeta yMeta = y.getItemMeta();
		yMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.y.name")));
		yMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.y.lores")));
		y.setItemMeta(yMeta);
		
		addItem(x, new Action());
		
		ItemStack z = SkullItem.getSkull("http://textures.minecraft.net/texture/90582b9b5d97974b11461d63eced85f438a3eef5dc3279f9c47e1e38ea54ae8d");
		ItemMeta zMeta = z.getItemMeta();
		zMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.z.name")));
		zMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.z.lores")));
		z.setItemMeta(zMeta);
		
		addItem(z, new Action());
		
		ItemStack one = SkullItem.getSkull("http://textures.minecraft.net/texture/71bc2bcfb2bd3759e6b1e86fc7a79585e1127dd357fc202893f9de241bc9e530");
		ItemMeta oneMeta = one.getItemMeta();
		oneMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.1.name")));
		oneMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.1.lores")));
		one.setItemMeta(oneMeta);
		
		addItem(one, new Action());
		
		ItemStack two = SkullItem.getSkull("http://textures.minecraft.net/texture/4cd9eeee883468881d83848a46bf3012485c23f75753b8fbe8487341419847");
		ItemMeta twoMeta = two.getItemMeta();
		twoMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.2.name")));
		twoMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.2.lores")));
		two.setItemMeta(twoMeta);
		
		addItem(two, new Action());
		
		ItemStack three = SkullItem.getSkull("http://textures.minecraft.net/texture/1d4eae13933860a6df5e8e955693b95a8c3b15c36b8b587532ac0996bc37e5");
		ItemMeta threeMeta = three.getItemMeta();
		threeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.3.name")));
		threeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.3.lores")));
		three.setItemMeta(threeMeta);
		
		addItem(three, new Action());
		
		ItemStack four = SkullItem.getSkull("http://textures.minecraft.net/texture/d2e78fb22424232dc27b81fbcb47fd24c1acf76098753f2d9c28598287db5");
		ItemMeta fourMeta = four.getItemMeta();
		fourMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.4.name")));
		fourMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.4.lores")));
		four.setItemMeta(fourMeta);
		
		addItem(four, new Action());
		
		ItemStack five = SkullItem.getSkull("http://textures.minecraft.net/texture/6d57e3bc88a65730e31a14e3f41e038a5ecf0891a6c243643b8e5476ae2");
		ItemMeta fiveMeta = five.getItemMeta();
		fiveMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.5.name")));
		fiveMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.5.lores")));
		five.setItemMeta(fiveMeta);
		
		addItem(five, new Action());
		
		ItemStack six = SkullItem.getSkull("http://textures.minecraft.net/texture/334b36de7d679b8bbc725499adaef24dc518f5ae23e716981e1dcc6b2720ab");
		ItemMeta sixMeta = six.getItemMeta();
		sixMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.6.name")));
		sixMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.6.lores")));
		six.setItemMeta(sixMeta);
		
		addItem(six, new Action());
		
		ItemStack seven = SkullItem.getSkull("http://textures.minecraft.net/texture/6db6eb25d1faabe30cf444dc633b5832475e38096b7e2402a3ec476dd7b9");
		ItemMeta sevenMeta = seven.getItemMeta();
		sevenMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.7.name")));
		sevenMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.7.lores")));
		seven.setItemMeta(sevenMeta);
		
		addItem(seven, new Action());
		
		ItemStack eight = SkullItem.getSkull("http://textures.minecraft.net/texture/59194973a3f17bda9978ed6273383997222774b454386c8319c04f1f4f74c2b5");
		ItemMeta eightMeta = eight.getItemMeta();
		eightMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.8.name")));
		eightMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.8.lores")));
		eight.setItemMeta(eightMeta);
		
		addItem(eight, new Action());
		
		ItemStack nine = SkullItem.getSkull("http://textures.minecraft.net/texture/e67caf7591b38e125a8017d58cfc6433bfaf84cd499d794f41d10bff2e5b840");
		ItemMeta nineMeta = nine.getItemMeta();
		nineMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.9.name")));
		nineMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.9.lores")));
		nine.setItemMeta(nineMeta);
		
		addItem(nine, new Action());
		
		ItemStack zero = SkullItem.getSkull("http://textures.minecraft.net/texture/0ebe7e5215169a699acc6cefa7b73fdb108db87bb6dae2849fbe24714b27");
		ItemMeta zeroMeta = zero.getItemMeta();
		zeroMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.0.name")));
		zeroMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.0.lores")));
		zero.setItemMeta(zeroMeta);
		
		addItem(zero, new Action());
		
		ItemStack arrowUp2 = SkullItem.getSkull("http://textures.minecraft.net/texture/58fe251a40e4167d35d081c27869ac151af96b6bd16dd2834d5dc7235f47791d");
		ItemMeta arrowUp2Meta = arrowUp2.getItemMeta();
		arrowUp2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-up-2.name")));
		arrowUp2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-up-2.lores")));
		arrowUp2.setItemMeta(arrowUp2Meta);
		
		addItem(arrowUp2, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.close.name")));
		closeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.close.lores")));
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
		
		//next page
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.next-page.name")));
		nextMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 2);
				return true;
			}
		}, 51);
		
		setStartingPoint(54);
		
		//page 2
		ItemStack arrowDown2 = SkullItem.getSkull("http://textures.minecraft.net/texture/9b7ce683d0868aa4378aeb60caa5ea80596bcffdab6b5af2d12595837a84853");
		ItemMeta arrowDown2Meta = arrowDown2.getItemMeta();
		arrowDown2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-down-2.name")));
		arrowDown2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-down-2.lores")));
		arrowDown2.setItemMeta(arrowDown2Meta);
		
		addItem(arrowDown2, new Action());
		
		ItemStack arrowRight2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f2f3a2dfce0c3dab7ee10db385e5229f1a39534a8ba2646178e37c4fa93b");
		ItemMeta arrowRight2Meta = arrowRight2.getItemMeta();
		arrowRight2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-right-2.name")));
		arrowRight2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-right-2.lores")));
		arrowRight2.setItemMeta(arrowRight2Meta);
		
		addItem(arrowRight2, new Action());
		
		ItemStack arrowLeft2 = SkullItem.getSkull("http://textures.minecraft.net/texture/bb0f6e8af46ac6faf88914191ab66f261d6726a7999c637cf2e4159fe1fc477");
		ItemMeta arrowLeft2Meta = arrowLeft2.getItemMeta();
		arrowLeft2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.arrow-left-2.name")));
		arrowLeft2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.arrow-left-2.lores")));
		arrowLeft2.setItemMeta(arrowLeft2Meta);
		
		addItem(arrowLeft2, new Action());
		
		ItemStack question2 = SkullItem.getSkull("http://textures.minecraft.net/texture/3aab272840d790c2ed2be5c860289f95d88e316b65c456ff6a35180d2e5bff6");
		ItemMeta question2Meta = question2.getItemMeta();
		question2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.question-2.name")));
		question2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.question-2.lores")));
		question2.setItemMeta(question2Meta);
		
		addItem(question2, new Action());
		
		ItemStack exclamation2 = SkullItem.getSkull("http://textures.minecraft.net/texture/87d19aabfcfd99ffaba4214caef299516ce52e6d13bf2dda125985e481b72f9");
		ItemMeta exclamation2Meta = exclamation2.getItemMeta();
		exclamation2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.exclamation-2.name")));
		exclamation2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.exclamation-2.lores")));
		exclamation2.setItemMeta(exclamation2Meta);
		
		addItem(exclamation2, new Action());
		
		ItemStack dot2 = SkullItem.getSkull("http://textures.minecraft.net/texture/6ff99ff279a2cf25deb4bd5b66c3576b824cc96c36781027af727ed3a4c1308e");
		ItemMeta dot2Meta = dot2.getItemMeta();
		dot2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.dot-2.name")));
		dot2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.dot-2.lores")));
		dot2.setItemMeta(dot2Meta);
		
		addItem(dot2, new Action());
		
		ItemStack slash2 = SkullItem.getSkull("http://textures.minecraft.net/texture/2d593f0945cbb85a8e0be7d9a526010ee774810f2bc428cd4a23e4d232eff8");
		ItemMeta slash2Meta = slash2.getItemMeta();
		slash2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.slash-2.name")));
		slash2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.slash-2.lores")));
		slash2.setItemMeta(slash2Meta);
		
		addItem(slash2, new Action());
		
		ItemStack a2 = SkullItem.getSkull("http://textures.minecraft.net/texture/2ac58b1a3b53b9481e317a1ea4fc5eed6bafca7a25e741a32e4e3c2841278c");
		ItemMeta a2Meta = a2.getItemMeta();
		a2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.a-2.name")));
		a2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.a-2.lores")));
		a2.setItemMeta(a2Meta);
		
		addItem(a2, new Action());
		
		ItemStack b2 = SkullItem.getSkull("http://textures.minecraft.net/texture/d4c711571e7e214ee78dfe4ee0e1263b92516e418de8fc8f3257ae0901431");
		ItemMeta b2Meta = b2.getItemMeta();
		b2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.b-2.name")));
		b2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.b-2.lores")));
		b2.setItemMeta(b2Meta);
		
		addItem(b2, new Action());
		
		ItemStack c2 = SkullItem.getSkull("http://textures.minecraft.net/texture/fff5aabead6feafaaecf4422cdd7837cbb36b03c9841dd1b1d2d3edb7825e851");
		ItemMeta c2Meta = c2.getItemMeta();
		c2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.c-2.name")));
		c2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.c-2.lores")));
		c2.setItemMeta(c2Meta);
		
		addItem(c2, new Action());
		
		ItemStack d2 = SkullItem.getSkull("http://textures.minecraft.net/texture/893e622b581975792f7c119ec6f40a4f16e552bb98776b0c7ae2bdfd4154fe7");
		ItemMeta d2Meta = d2.getItemMeta();
		d2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.d-2.name")));
		d2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.d-2.lores")));
		d2.setItemMeta(d2Meta);
		
		addItem(d2, new Action());
		
		ItemStack e2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a157d65b19921c760ff4910b3404455b9c2ee36afc202d8538baefec676953");
		ItemMeta e2Meta = e2.getItemMeta();
		e2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.e-2.name")));
		e2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.e-2.lores")));
		e2.setItemMeta(e2Meta);
		
		addItem(e2, new Action());
		
		ItemStack f2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a157d65b19921c760ff4910b3404455b9c2ee36afc202d8538baefec676953");
		ItemMeta f2Meta = f2.getItemMeta();
		f2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.f-2.name")));
		f2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.f-2.lores")));
		f2.setItemMeta(f2Meta);
		
		addItem(f2, new Action());
		
		ItemStack g2 = SkullItem.getSkull("http://textures.minecraft.net/texture/d3c9f8a74ca01ba8c54de1edc82e1fc07a83923e66574b6ffe606919240c6");
		ItemMeta g2Meta = g2.getItemMeta();
		g2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.g-2.name")));
		g2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.g-2.lores")));
		g2.setItemMeta(g2Meta);
		
		addItem(g2, new Action());
		
		ItemStack h2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f8c58c509034617bf81ee0db9be0ba3e85ca15568163914c87669edb2fd7");
		ItemMeta h2Meta = h2.getItemMeta();
		h2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.h-2.name")));
		h2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.h-2.lores")));
		h2.setItemMeta(h2Meta);
		
		addItem(h2, new Action());
		
		ItemStack i2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4246323c9fb319326ee2bf3f5b63ec3d99df76a12439bf0b4c3ab32d13fd9");
		ItemMeta i2Meta = i2.getItemMeta();
		i2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.i-2.name")));
		i2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.i-2.lores")));
		i2.setItemMeta(i2Meta);
		
		addItem(i2, new Action());
		
		ItemStack j2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c58456cd9bb8a7e978591ae0cb26af1aadad4fa7a16725b295145e09bed8064");
		ItemMeta j2Meta = j2.getItemMeta();
		j2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.j-2.name")));
		j2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.j-2.lores")));
		j2.setItemMeta(j2Meta);
		
		addItem(j2, new Action());
		
		ItemStack k2 = SkullItem.getSkull("http://textures.minecraft.net/texture/af49fb708369e7bc2944ad706963fb6ac6ce6d4c67081ddadecfe5da51");
		ItemMeta k2Meta = k2.getItemMeta();
		k2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.k-2.name")));
		k2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.k-2.lores")));
		k2.setItemMeta(k2Meta);
		
		addItem(k2, new Action());
		
		ItemStack l2 = SkullItem.getSkull("http://textures.minecraft.net/texture/8c84f75416e853a74f6c70fc7e1093d53961879955b433bd8c7c6d5a6df");
		ItemMeta l2Meta = l2.getItemMeta();
		l2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.l-2.name")));
		l2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.l-2.lores")));
		l2.setItemMeta(l2Meta);
		
		addItem(l2, new Action());
		
		ItemStack m2 = SkullItem.getSkull("http://textures.minecraft.net/texture/31fde91b19b9309913724fea9e85311271c67bcb78578d461bf65d9613074");
		ItemMeta m2Meta = m2.getItemMeta();
		m2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.m-2.name")));
		m2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.m-2.lores")));
		m2.setItemMeta(m2Meta);
		
		addItem(m2, new Action());
		
		ItemStack n2 = SkullItem.getSkull("http://textures.minecraft.net/texture/1c7c972e6785d6b0aceb779abdd7702d98341c24c2a71e702930eca58055");
		ItemMeta n2Meta = n2.getItemMeta();
		n2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.n-2.name")));
		n2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.n-2.lores")));
		n2.setItemMeta(n2Meta);
		
		addItem(n2, new Action());
		
		ItemStack o2 = SkullItem.getSkull("http://textures.minecraft.net/texture/8073bb44f9345f9bb31a679027e7939e461842a8c27486d7a6b842c39eb38c4e");
		ItemMeta o2Meta = o2.getItemMeta();
		o2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.o-2.name")));
		o2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.o-2.lores")));
		o2.setItemMeta(o2Meta);
		
		addItem(o2, new Action());
		
		ItemStack p2 = SkullItem.getSkull("http://textures.minecraft.net/texture/64b231a8d55870cfb5a9f4e65db06dd7f8e34282f1416f95878b19acc34ac95");
		ItemMeta p2Meta = p2.getItemMeta();
		p2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.p-2.name")));
		p2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.p-2.lores")));
		p2.setItemMeta(p2Meta);
		
		addItem(p2, new Action());
		
		ItemStack q2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ffedd6f9efdb156b86935699b2b4834df0f5d214513c01d38af3bd031cbcc92");
		ItemMeta q2Meta = q2.getItemMeta();
		q2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.q-2.name")));
		q2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.q-2.lores")));
		q2.setItemMeta(q2Meta);
		
		addItem(q2, new Action());
		
		ItemStack r2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c03a1cd583cbbffde08f943e56ac3e3afafecaede834221a81e6db6c64667f7d");
		ItemMeta r2Meta = r2.getItemMeta();
		r2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.r-2.name")));
		r2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.r-2.lores")));
		r2.setItemMeta(r2Meta);
		
		addItem(r2, new Action());
		
		ItemStack s2 = SkullItem.getSkull("http://textures.minecraft.net/texture/b6572e655725d78375a9817eb9ee8b37829ca1fea93b6095cc7aa19e5eac");
		ItemMeta s2Meta = s2.getItemMeta();
		s2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.s-2.name")));
		s2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.s-2.lores")));
		s2.setItemMeta(s2Meta);
		
		addItem(s2, new Action());
		
		ItemStack t2 = SkullItem.getSkull("http://textures.minecraft.net/texture/708c9ef3a3751e254e2af1ad8b5d668ccf5c6ec3ea2641877cba575807d39");
		ItemMeta t2Meta = t2.getItemMeta();
		t2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.t-2.name")));
		t2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.t-2.lores")));
		t2.setItemMeta(t2Meta);
		
		addItem(t2, new Action());
		
		ItemStack u2 = SkullItem.getSkull("http://textures.minecraft.net/texture/55a6e3ae5ae625923524838fac9fef5b42527f5027c9ca149e6c207792eb");
		ItemMeta u2Meta = u2.getItemMeta();
		u2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.u-2.name")));
		u2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.u-2.lores")));
		u2.setItemMeta(u2Meta);
		
		addItem(u2, new Action());
		
		ItemStack v2 = SkullItem.getSkull("http://textures.minecraft.net/texture/975121f7d9c68da0e5b6a96ac615298b12b2ee5bd19989436ee647879da5b");
		ItemMeta v2Meta = v2.getItemMeta();
		v2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.v-2.name")));
		v2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.v-2.lores")));
		v2.setItemMeta(v2Meta);
		
		addItem(v2, new Action());
		
		ItemStack w2 = SkullItem.getSkull("http://textures.minecraft.net/texture/67e165c3edc5541d4654c4728871e6908f613fc0ec46e823c96eac82ac62e62");
		ItemMeta w2Meta = w2.getItemMeta();
		w2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.w-2.name")));
		w2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.w-2.lores")));
		w2.setItemMeta(w2Meta);
		
		addItem(w2, new Action());
		
		ItemStack x2 = SkullItem.getSkull("http://textures.minecraft.net/texture/1919d1594bf809db7b44b3782bf90a69f449a87ce5d18cb40eb653fdec2722");
		ItemMeta x2Meta = x2.getItemMeta();
		x2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.x-2.name")));
		x2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.x-2.lores")));
		x2.setItemMeta(x2Meta);
		
		addItem(x2, new Action());
		
		ItemStack y2 = SkullItem.getSkull("http://textures.minecraft.net/texture/e35424bb86305d7747604b13e924d74f1efe38906e4e458dd18dcc67b6ca48");
		ItemMeta y2Meta = y2.getItemMeta();
		y2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.y-2.name")));
		y2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.y-2.lores")));
		y2.setItemMeta(y2Meta);
		
		addItem(y2, new Action());
		
		ItemStack z2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4e91200df1cae51acc071f85c7f7f5b8449d39bb32f363b0aa51dbc85d133e");
		ItemMeta z2Meta = z2.getItemMeta();
		z2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.z-2.name")));
		z2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.z-2.lores")));
		z2.setItemMeta(z2Meta);
		
		addItem(z2, new Action());
		
		ItemStack one2 = SkullItem.getSkull("http://textures.minecraft.net/texture/31a9463fd3c433d5e1d9fec6d5d4b09a83a970b0b74dd546ce67a73348caab");
		ItemMeta one2Meta = one2.getItemMeta();
		one2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.1-2.name")));
		one2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.1-2.lores")));
		one2.setItemMeta(one2Meta);
		
		addItem(one2, new Action());
		
		ItemStack two2 = SkullItem.getSkull("http://textures.minecraft.net/texture/acb419d984d8796373c9646233c7a02664bd2ce3a1d3476dd9b1c5463b14ebe");
		ItemMeta two2Meta = two2.getItemMeta();
		two2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.2-2.name")));
		two2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.2-2.lores")));
		two2.setItemMeta(two2Meta);
		
		addItem(two2, new Action());
		
		ItemStack three2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f8ebab57b7614bb22a117be43e848bcd14daecb50e8f5d0926e4864dff470");
		ItemMeta three2Meta = three2.getItemMeta();
		three2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.3-2.name")));
		three2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.3-2.lores")));
		three2.setItemMeta(three2Meta);
		
		addItem(three2, new Action());
		
		ItemStack four2 = SkullItem.getSkull("http://textures.minecraft.net/texture/62bfcfb489da867dce96e3c3c17a3db7c79cae8ac1f9a5a8c8ac95e4ba3");
		ItemMeta four2Meta = four2.getItemMeta();
		four2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.4-2.name")));
		four2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.4-2.lores")));
		four2.setItemMeta(four2Meta);
		
		addItem(four2, new Action());
		
		ItemStack five2 = SkullItem.getSkull("http://textures.minecraft.net/texture/ef4ecf110b0acee4af1da343fb136f1f2c216857dfda6961defdbee7b9528");
		ItemMeta five2Meta = five2.getItemMeta();
		five2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.5-2.name")));
		five2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.5-2.lores")));
		five2.setItemMeta(five2Meta);
		
		addItem(five2, new Action());
		
		ItemStack six2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f331a6a6fcd6995b62088d353bfb68d9b89ae258325caf3f2886464f54a7329");
		ItemMeta six2Meta = six2.getItemMeta();
		six2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.6-2.name")));
		six2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.6-2.lores")));
		six2.setItemMeta(six2Meta);
		
		addItem(six2, new Action());
		
		ItemStack seven2 = SkullItem.getSkull("http://textures.minecraft.net/texture/d4ba6ac07d422377a855793f36dea2ed240223f52fd1648181612ecd1a0cfd5");
		ItemMeta seven2Meta = seven2.getItemMeta();
		seven2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.7-2.name")));
		seven2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.7-2.lores")));
		seven2.setItemMeta(seven2Meta);
		
		addItem(seven2, new Action());
		
		ItemStack eight2 = SkullItem.getSkull("http://textures.minecraft.net/texture/c61a8a641437be9aea207253dd3f25440d954ea2b5866c552f386b29ac4d049");
		ItemMeta eight2Meta = eight2.getItemMeta();
		eight2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.8-2.name")));
		eight2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.8-2.lores")));
		eight2.setItemMeta(eight2Meta);
		
		addItem(eight2, new Action());
		
		ItemStack nine2 = SkullItem.getSkull("http://textures.minecraft.net/texture/a1928e1bfd86a9b79397c4cb4b65ef99af49b7d5f7957ad62c0c699a622cfbe");
		ItemMeta nine2Meta = nine2.getItemMeta();
		nine2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.9-2.name")));
		nine2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.9-2.lores")));
		nine2.setItemMeta(nine2Meta);
		
		addItem(nine2, new Action());
		
		ItemStack zero2 = SkullItem.getSkull("http://textures.minecraft.net/texture/55a224807693978ed834355f9e5145f9c56ef68cf6f2c9e1734a46e246aae1");
		ItemMeta zero2Meta = zero2.getItemMeta();
		zero2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.0-2.name")));
		zero2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.0-2.lores")));
		zero2.setItemMeta(zero2Meta);
		
		addItem(zero2, new Action());
		
		ItemStack colon = SkullItem.getSkull("http://textures.minecraft.net/texture/bd898c40e47c5d2d76924065360768065d624ee5b9ee0be9e12b98fb77c76");
		ItemMeta colonMeta = colon.getItemMeta();
		colonMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.colon.name")));
		colonMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.colon.lores")));
		colon.setItemMeta(colonMeta);
		
		addItem(colon, new Action());
		
		ItemStack diaeresisA = SkullItem.getSkull("http://textures.minecraft.net/texture/4c9c2bbd7b7f7204dceb5729a6fba7fd45d6f193f3760ec59a6807533e63b");
		ItemMeta diaeresisAMeta = diaeresisA.getItemMeta();
		diaeresisAMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.diaeresis-a.name")));
		diaeresisAMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.diaeresis-a.lores")));
		diaeresisA.setItemMeta(diaeresisAMeta);
		
		addItem(diaeresisA, new Action());
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked());
				return true;
			}
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.close.name")));
		close2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.close.lores")));
		close2.setItemMeta(close2Meta);
		
		setItem(close2, new GuiAction() {
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
		}, 103);
		
		//next page
		ItemStack next2 = new ItemStack(Material.SUGAR_CANE);
		ItemMeta next2Meta = next2.getItemMeta();
		next2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.next-page.name")));
		next2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.next-page.lores")));
		next2.setItemMeta(next2Meta);
		
		setItem(next2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 3);
				return true;
			}
		}, 105);
		
		
		setStartingPoint(108);
		
		//page 3
		ItemStack diaeresisU = SkullItem.getSkull("http://textures.minecraft.net/texture/caec53e4a6d221afd7297b65e55be87913cf9cb7f4f4547f7186120701d8d");
		ItemMeta diaeresisUMeta = diaeresisU.getItemMeta();
		diaeresisUMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.diaeresis-u.name")));
		diaeresisUMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.diaeresis-u.lores")));
		diaeresisU.setItemMeta(diaeresisUMeta);
		
		addItem(diaeresisU, new Action());
		
		ItemStack diaeresisO = SkullItem.getSkull("http://textures.minecraft.net/texture/c83d42bcb9b8e66c16166ccf261e2f9f78c68ee7886da225e43895cdbcaf5f");
		ItemMeta diaeresisOMeta = diaeresisO.getItemMeta();
		diaeresisOMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.diaeresis-o.name")));
		diaeresisOMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.diaresis-o.lores")));
		diaeresisO.setItemMeta(diaeresisOMeta);
		
		addItem(diaeresisO, new Action());
		
		ItemStack a3 = SkullItem.getSkull("http://textures.minecraft.net/texture/9c60da2944a177dd08268fbec04e40812d1d929650be66529b1ee5e1e7eca");
		ItemMeta a3Meta = a3.getItemMeta();
		a3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.a-3.name")));
		a3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.a-3.lores")));
		a3.setItemMeta(a3Meta);
		
		addItem(a3, new Action());
		
		ItemStack b3 = SkullItem.getSkull("http://textures.minecraft.net/texture/8041f5e86983d36eaec4e167b2bbb5a3727607cde88f7555ca1b522a039bb");
		ItemMeta b3Meta = b3.getItemMeta();
		b3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.b-3.name")));
		b3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.b-3.lores")));
		b3.setItemMeta(b3Meta);
		
		addItem(b3, new Action());
		
		ItemStack c3 = SkullItem.getSkull("http://textures.minecraft.net/texture/d945996c8ae91e376196d4dc676fec31feac790a2f195b2981a703ca1d16cb6");
		ItemMeta c3Meta = c3.getItemMeta();
		c3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.c-3.name")));
		c3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.c-3.lores")));
		c3.setItemMeta(c3Meta);
		
		addItem(c3, new Action());
		
		ItemStack d3 = SkullItem.getSkull("http://textures.minecraft.net/texture/1641150f481e8492f7128c948996254d2d91fc90f5a8ff4d8ac5c39a6a88a");
		ItemMeta d3Meta = d3.getItemMeta();
		d3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.d-3.name")));
		d3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.d-3.lores")));
		d3.setItemMeta(d3Meta);
		
		addItem(d3, new Action());
		
		ItemStack e3 = SkullItem.getSkull("http://textures.minecraft.net/texture/db251487ff8eef2ebc7a57dab6e3d9f1db7fc926ddc66fea14afe3dff15a45");
		ItemMeta e3Meta = e3.getItemMeta();
		e3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.e-3.name")));
		e3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.e-3.lores")));
		e3.setItemMeta(e3Meta);
		
		addItem(e3, new Action());
		
		ItemStack f3 = SkullItem.getSkull("http://textures.minecraft.net/texture/7e433656b443668ed03dac8c442722a2a41221be8bb48e23b35bd8c2e59f63");
		ItemMeta f3Meta = f3.getItemMeta();
		f3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.f-3.name")));
		f3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.f-3.lores")));
		f3.setItemMeta(f3Meta);
		
		addItem(f3, new Action());
		
		ItemStack g3 = SkullItem.getSkull("http://textures.minecraft.net/texture/995863b73637605feacbb173b77d5e155e65204c78d5c7911f738f28deb60");
		ItemMeta g3Meta = g3.getItemMeta();
		g3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.g-3.name")));
		g3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.g-3.lores")));
		g3.setItemMeta(g3Meta);
		
		addItem(g3, new Action());
		
		ItemStack h3 = SkullItem.getSkull("http://textures.minecraft.net/texture/3c1d358d927074289cc26bff5b1240746f9f4f0cc46f942f5981c6595f72dd");
		ItemMeta h3Meta = h3.getItemMeta();
		h3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.h-3.name")));
		h3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.h-3.lores")));
		h3.setItemMeta(h3Meta);
		
		addItem(h3, new Action());
		
		ItemStack i3 = SkullItem.getSkull("http://textures.minecraft.net/texture/8f2295865bda4e47979d36b8a887a75a13b034e6988f78670b64a1e6442c");
		ItemMeta i3Meta = i3.getItemMeta();
		i3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.i-3.name")));
		i3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.i-3.lores")));
		i3.setItemMeta(i3Meta);
		
		addItem(i3, new Action());
		
		ItemStack j3 = SkullItem.getSkull("http://textures.minecraft.net/texture/e34462b55d7f5823680ad13f2adbd7d1ed46ba5101017ed4b37aeeeb775d");
		ItemMeta j3Meta = j3.getItemMeta();
		j3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.j-3.name")));
		j3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.j-3.lores")));
		j3.setItemMeta(j3Meta);
		
		addItem(j3, new Action());
		
		ItemStack k3 = SkullItem.getSkull("http://textures.minecraft.net/texture/773325a935c067b6ef227367f62ca4bf49f67adb9f6da32091e2d32c5dde328");
		ItemMeta k3Meta = k3.getItemMeta();
		k3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.k-3.name")));
		k3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.k-3.lores")));
		k3.setItemMeta(k3Meta);
		
		addItem(k3, new Action());
		
		ItemStack l3 = SkullItem.getSkull("http://textures.minecraft.net/texture/25a1e3328c571aa495d9c5f494815cca176c3acb184feb5a7b9c96ce8e52fce");
		ItemMeta l3Meta = l3.getItemMeta();
		l3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.l-3.name")));
		l3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.l-3.lores")));
		l3.setItemMeta(l3Meta);
		
		addItem(l3, new Action());
		
		ItemStack m3 = SkullItem.getSkull("http://textures.minecraft.net/texture/d467bf6be95e5c8e9d01977a2f0c487ed5b0de5c87963a2eb15411c442fb2b");
		ItemMeta m3Meta = m3.getItemMeta();
		m3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.m-3.name")));
		m3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.m-3.lores")));
		m3.setItemMeta(m3Meta);
		
		addItem(m3, new Action());
		
		ItemStack n3 = SkullItem.getSkull("http://textures.minecraft.net/texture/823e434d6395fe7e63492431bdee5782bd5ee5bc8cab7559467bdd1f93b925a");
		ItemMeta n3Meta = n3.getItemMeta();
		n3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.n-3.name")));
		n3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.n-3.lores")));
		n3.setItemMeta(n3Meta);
		
		addItem(n3, new Action());
		
		ItemStack o3 = SkullItem.getSkull("http://textures.minecraft.net/texture/88445466bdc5ad5bcea82239c4e1b510f6ea5262d82d8a96d7291c342fb89");
		ItemMeta o3Meta = o3.getItemMeta();
		o3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.o-3.name")));
		o3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.o-3.lores")));
		o3.setItemMeta(o3Meta);
		
		addItem(o3, new Action());
		
		ItemStack p3 = SkullItem.getSkull("http://textures.minecraft.net/texture/f9de601dee3ffeca4d54595f844201d0ed2091acec4548c696bb16a8a158f6");
		ItemMeta p3Meta = p3.getItemMeta();
		p3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.p-3.name")));
		p3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.p-3.lores")));
		p3.setItemMeta(p3Meta);
		
		ItemStack q3 = SkullItem.getSkull("http://textures.minecraft.net/texture/66ca769bde25d4cc41e19e42adc35ab4c1557b76af232649acc9967ff198f13");
		ItemMeta q3Meta = q3.getItemMeta();
		q3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.q-3.name")));
		q3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.q-3.lores")));
		q3.setItemMeta(q3Meta);
		
		addItem(q3, new Action());
		
		ItemStack r3 = SkullItem.getSkull("http://textures.minecraft.net/texture/67a188805162ca5dd4f4649c661d3f6d23c42662aef01645b1a97f78b3f13219");
		ItemMeta r3Meta = r3.getItemMeta();
		r3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.r-3.name")));
		r3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.r-3.lores")));
		r3.setItemMeta(r3Meta);
		
		addItem(r3, new Action());
		
		ItemStack s3 = SkullItem.getSkull("http://textures.minecraft.net/texture/60d09dfd9f5de6243233e0e3325b6c3479335e7ccf13f2448d4e1f7fc4a0df");
		ItemMeta s3Meta = s3.getItemMeta();
		s3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.s-3.name")));
		s3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.s-3.lores")));
		s3.setItemMeta(s3Meta);
		
		addItem(s3, new Action());
		
		ItemStack t3 = SkullItem.getSkull("http://textures.minecraft.net/texture/64c75619b91d241f678350ad9237c134c5e08d87d6860741ede306a4ef91");
		ItemMeta t3Meta = t3.getItemMeta();
		t3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.t-3.name")));
		t3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.t-3.lores")));
		t3.setItemMeta(t3Meta);
		
		addItem(t3, new Action());
		
		ItemStack u3 = SkullItem.getSkull("http://textures.minecraft.net/texture/e9f6d2c6d5285f882ae55d1e91b8f9efdfc9b377208bf4c83f88dd156415e");
		ItemMeta u3Meta = u3.getItemMeta();
		u3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.u-3.name")));
		u3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.u-3.lores")));
		u3.setItemMeta(u3Meta);
		
		addItem(u3, new Action());
		
		ItemStack v3 = SkullItem.getSkull("http://textures.minecraft.net/texture/dce27a153635f835237d85c6bf74f5b1f2e638c48fee8c83038d0558d41da7");
		ItemMeta v3Meta = v3.getItemMeta();
		v3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.v-3.name")));
		v3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.v-3.lores")));
		v3.setItemMeta(v3Meta);
		
		addItem(v3, new Action());
		
		ItemStack w3 = SkullItem.getSkull("http://textures.minecraft.net/texture/aedcf4ffcb53b56d42baac9d0dfb118e343462327442dd9b29d49f50a7d38b");
		ItemMeta w3Meta = w3.getItemMeta();
		w3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.w-3.name")));
		w3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.w-3.lores")));
		w3.setItemMeta(w3Meta);
		
		addItem(w3, new Action());
		
		ItemStack x3 = SkullItem.getSkull("http://textures.minecraft.net/texture/83618ff1217640bec5b525fa2a8e671c75d2a7d7cb2ddc31d79d9d895eab1");
		ItemMeta x3Meta = x3.getItemMeta();
		x3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.x-3.name")));
		x3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.x-3.lores")));
		x3.setItemMeta(x3Meta);
		
		addItem(x3, new Action());
		
		ItemStack y3 = SkullItem.getSkull("http://textures.minecraft.net/texture/d9c1d29a38bcf113b7e8c34e148a79f9fe41edf41aa8b1de873bb1d433b3861");
		ItemMeta y3Meta = y3.getItemMeta();
		y3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.y-3.name")));
		y3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.y-3.lores")));
		y3.setItemMeta(y3Meta);
		
		addItem(y3, new Action());
		
		ItemStack z3 = SkullItem.getSkull("http://textures.minecraft.net/texture/b9295734195d2c7fa389b98757e9686ce6437c16c58bdf2b4cd538389b5912");
		ItemMeta z3Meta = z3.getItemMeta();
		z3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.z-3.name")));
		z3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.z-3.lores")));
		z3.setItemMeta(z3Meta);
		
		addItem(z3, new Action());
		
		//previous page
		ItemStack previous3 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous3Meta = previous3.getItemMeta();
		previous3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.previous-page.name")));
		previous3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.previous-page.lores")));
		previous3.setItemMeta(previous3Meta);
		
		setItem(previous3, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 2);
				return true;
			}
		}, 155);
		
		//close
		ItemStack close3 = new ItemStack(Material.BOOK);
		ItemMeta close3Meta = close3.getItemMeta();
		close3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.heads.alphabet.close.name")));
		close3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.heads.alphabet.close.lores")));
		close3.setItemMeta(close3Meta);
		
		setItem(close3, new GuiAction() {
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
		}, 157);
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