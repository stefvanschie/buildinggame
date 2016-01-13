package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.alphabet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class AlphabetHeadsMenuThree {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Alphabet");
		
		ItemStack diaeresisU = SkullItem.getSkull("http://textures.minecraft.net/texture/caec53e4a6d221afd7297b65e55be87913cf9cb7f4f4547f7186120701d8d");
		ItemMeta diaeresisUMeta = diaeresisU.getItemMeta();
		diaeresisUMeta.setDisplayName(ChatColor.GOLD + "Ü");
		diaeresisU.setItemMeta(diaeresisUMeta);
		
		ItemStack diaeresisO = SkullItem.getSkull("http://textures.minecraft.net/texture/c83d42bcb9b8e66c16166ccf261e2f9f78c68ee7886da225e43895cdbcaf5f");
		ItemMeta diaeresisOMeta = diaeresisO.getItemMeta();
		diaeresisOMeta.setDisplayName(ChatColor.GOLD + "Ö");
		
		ItemStack a = SkullItem.getSkull("http://textures.minecraft.net/texture/9c60da2944a177dd08268fbec04e40812d1d929650be66529b1ee5e1e7eca");
		ItemMeta aMeta = a.getItemMeta();
		aMeta.setDisplayName(ChatColor.GOLD + "A");
		a.setItemMeta(aMeta);
		
		ItemStack b = SkullItem.getSkull("http://textures.minecraft.net/texture/8041f5e86983d36eaec4e167b2bbb5a3727607cde88f7555ca1b522a039bb");
		ItemMeta bMeta = b.getItemMeta();
		bMeta.setDisplayName(ChatColor.GOLD + "B");
		b.setItemMeta(bMeta);
		
		ItemStack c = SkullItem.getSkull("http://textures.minecraft.net/texture/d945996c8ae91e376196d4dc676fec31feac790a2f195b2981a703ca1d16cb6");
		ItemMeta cMeta = c.getItemMeta();
		cMeta.setDisplayName(ChatColor.GOLD + "C");
		c.setItemMeta(cMeta);
		
		ItemStack d = SkullItem.getSkull("http://textures.minecraft.net/texture/1641150f481e8492f7128c948996254d2d91fc90f5a8ff4d8ac5c39a6a88a");
		ItemMeta dMeta = d.getItemMeta();
		dMeta.setDisplayName(ChatColor.GOLD + "D");
		d.setItemMeta(dMeta);
		
		ItemStack e = SkullItem.getSkull("http://textures.minecraft.net/texture/db251487ff8eef2ebc7a57dab6e3d9f1db7fc926ddc66fea14afe3dff15a45");
		ItemMeta eMeta = e.getItemMeta();
		eMeta.setDisplayName(ChatColor.GOLD + "E");
		e.setItemMeta(eMeta);
		
		ItemStack f = SkullItem.getSkull("http://textures.minecraft.net/texture/7e433656b443668ed03dac8c442722a2a41221be8bb48e23b35bd8c2e59f63");
		ItemMeta fMeta = f.getItemMeta();
		fMeta.setDisplayName(ChatColor.GOLD + "F");
		f.setItemMeta(fMeta);
		
		ItemStack g = SkullItem.getSkull("http://textures.minecraft.net/texture/995863b73637605feacbb173b77d5e155e65204c78d5c7911f738f28deb60");
		ItemMeta gMeta = g.getItemMeta();
		gMeta.setDisplayName(ChatColor.GOLD + "G");
		g.setItemMeta(gMeta);
		
		ItemStack h = SkullItem.getSkull("http://textures.minecraft.net/texture/3c1d358d927074289cc26bff5b1240746f9f4f0cc46f942f5981c6595f72dd");
		ItemMeta hMeta = h.getItemMeta();
		hMeta.setDisplayName(ChatColor.GOLD + "H");
		h.setItemMeta(hMeta);
		
		ItemStack i = SkullItem.getSkull("http://textures.minecraft.net/texture/8f2295865bda4e47979d36b8a887a75a13b034e6988f78670b64a1e6442c");
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "I");
		i.setItemMeta(iMeta);
		
		ItemStack j = SkullItem.getSkull("http://textures.minecraft.net/texture/e34462b55d7f5823680ad13f2adbd7d1ed46ba5101017ed4b37aeeeb775d");
		ItemMeta jMeta = j.getItemMeta();
		jMeta.setDisplayName(ChatColor.GOLD + "J");
		j.setItemMeta(jMeta);
		
		ItemStack k = SkullItem.getSkull("http://textures.minecraft.net/texture/773325a935c067b6ef227367f62ca4bf49f67adb9f6da32091e2d32c5dde328");
		ItemMeta kMeta = k.getItemMeta();
		kMeta.setDisplayName(ChatColor.GOLD + "K");
		k.setItemMeta(kMeta);
		
		ItemStack l = SkullItem.getSkull("http://textures.minecraft.net/texture/25a1e3328c571aa495d9c5f494815cca176c3acb184feb5a7b9c96ce8e52fce");
		ItemMeta lMeta = l.getItemMeta();
		lMeta.setDisplayName(ChatColor.GOLD + "L");
		l.setItemMeta(lMeta);
		
		ItemStack m = SkullItem.getSkull("http://textures.minecraft.net/texture/d467bf6be95e5c8e9d01977a2f0c487ed5b0de5c87963a2eb15411c442fb2b");
		ItemMeta mMeta = m.getItemMeta();
		mMeta.setDisplayName(ChatColor.GOLD + "M");
		m.setItemMeta(mMeta);
		
		ItemStack n = SkullItem.getSkull("http://textures.minecraft.net/texture/823e434d6395fe7e63492431bdee5782bd5ee5bc8cab7559467bdd1f93b925a");
		ItemMeta nMeta = n.getItemMeta();
		nMeta.setDisplayName(ChatColor.GOLD + "N");
		n.setItemMeta(nMeta);
		
		ItemStack o = SkullItem.getSkull("http://textures.minecraft.net/texture/88445466bdc5ad5bcea82239c4e1b510f6ea5262d82d8a96d7291c342fb89");
		ItemMeta oMeta = o.getItemMeta();
		oMeta.setDisplayName(ChatColor.GOLD + "O");
		o.setItemMeta(oMeta);
		
		ItemStack p = SkullItem.getSkull("http://textures.minecraft.net/texture/f9de601dee3ffeca4d54595f844201d0ed2091acec4548c696bb16a8a158f6");
		ItemMeta pMeta = p.getItemMeta();
		pMeta.setDisplayName(ChatColor.GOLD + "P");
		p.setItemMeta(pMeta);
		
		ItemStack q = SkullItem.getSkull("http://textures.minecraft.net/texture/66ca769bde25d4cc41e19e42adc35ab4c1557b76af232649acc9967ff198f13");
		ItemMeta qMeta = q.getItemMeta();
		qMeta.setDisplayName(ChatColor.GOLD + "Q");
		q.setItemMeta(qMeta);
		
		ItemStack r = SkullItem.getSkull("http://textures.minecraft.net/texture/67a188805162ca5dd4f4649c661d3f6d23c42662aef01645b1a97f78b3f13219");
		ItemMeta rMeta = r.getItemMeta();
		rMeta.setDisplayName(ChatColor.GOLD + "R");
		r.setItemMeta(rMeta);
		
		ItemStack s = SkullItem.getSkull("http://textures.minecraft.net/texture/60d09dfd9f5de6243233e0e3325b6c3479335e7ccf13f2448d4e1f7fc4a0df");
		ItemMeta sMeta = s.getItemMeta();
		sMeta.setDisplayName(ChatColor.GOLD + "S");
		s.setItemMeta(sMeta);
		
		ItemStack t = SkullItem.getSkull("http://textures.minecraft.net/texture/64c75619b91d241f678350ad9237c134c5e08d87d6860741ede306a4ef91");
		ItemMeta tMeta = t.getItemMeta();
		tMeta.setDisplayName(ChatColor.GOLD + "T");
		t.setItemMeta(tMeta);
		
		ItemStack u = SkullItem.getSkull("http://textures.minecraft.net/texture/e9f6d2c6d5285f882ae55d1e91b8f9efdfc9b377208bf4c83f88dd156415e");
		ItemMeta uMeta = u.getItemMeta();
		uMeta.setDisplayName(ChatColor.GOLD + "U");
		u.setItemMeta(uMeta);
		
		ItemStack v = SkullItem.getSkull("http://textures.minecraft.net/texture/dce27a153635f835237d85c6bf74f5b1f2e638c48fee8c83038d0558d41da7");
		ItemMeta vMeta = v.getItemMeta();
		vMeta.setDisplayName(ChatColor.GOLD + "V");
		v.setItemMeta(vMeta);
		
		ItemStack w = SkullItem.getSkull("textures.minecraft.net/texture/aedcf4ffcb53b56d42baac9d0dfb118e343462327442dd9b29d49f50a7d38b");
		ItemMeta wMeta = w.getItemMeta();
		wMeta.setDisplayName(ChatColor.GOLD + "W");
		w.setItemMeta(wMeta);
		
		ItemStack x = SkullItem.getSkull("http://textures.minecraft.net/texture/83618ff1217640bec5b525fa2a8e671c75d2a7d7cb2ddc31d79d9d895eab1");
		ItemMeta xMeta = x.getItemMeta();
		xMeta.setDisplayName(ChatColor.GOLD + "X");
		x.setItemMeta(xMeta);
		
		ItemStack y = SkullItem.getSkull("http://textures.minecraft.net/texture/d9c1d29a38bcf113b7e8c34e148a79f9fe41edf41aa8b1de873bb1d433b3861");
		ItemMeta yMeta = y.getItemMeta();
		yMeta.setDisplayName(ChatColor.GOLD + "Y");
		y.setItemMeta(yMeta);
		
		ItemStack z = SkullItem.getSkull("http://textures.minecraft.net/texture/b9295734195d2c7fa389b98757e9686ce6437c16c58bdf2b4cd538389b5912");
		ItemMeta zMeta = z.getItemMeta();
		zMeta.setDisplayName(ChatColor.GOLD + "Z");
		z.setItemMeta(zMeta);
		
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
		
		inventory.setItem(0, diaeresisU);
		inventory.setItem(1, diaeresisO);
		inventory.setItem(2, a);
		inventory.setItem(3, b);
		inventory.setItem(4, c);
		inventory.setItem(5, d);
		inventory.setItem(6, e);
		inventory.setItem(7, f);
		inventory.setItem(8, g);
		inventory.setItem(9, h);
		inventory.setItem(10, i);
		inventory.setItem(11, j);
		inventory.setItem(12, k);
		inventory.setItem(13, l);
		inventory.setItem(14, m);
		inventory.setItem(15, n);
		inventory.setItem(16, o);
		inventory.setItem(17, p);
		inventory.setItem(18, q);
		inventory.setItem(19, r);
		inventory.setItem(20, s);
		inventory.setItem(21, t);
		inventory.setItem(22, u);
		inventory.setItem(23, v);
		inventory.setItem(24, w);
		inventory.setItem(25, x);
		inventory.setItem(26, y);
		inventory.setItem(27, z);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
	}
}