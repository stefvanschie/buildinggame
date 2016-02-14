package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.alphabet;

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

public class AlphabetHeadsMenuThree {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.title")));
		
		ItemStack diaeresisU = SkullItem.getSkull("http://textures.minecraft.net/texture/caec53e4a6d221afd7297b65e55be87913cf9cb7f4f4547f7186120701d8d");
		ItemMeta diaeresisUMeta = diaeresisU.getItemMeta();
		diaeresisUMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.diaeresis-u.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.diaeresis-u.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			diaeresisUMeta.setLore(lores);
		}
		diaeresisU.setItemMeta(diaeresisUMeta);
		
		ItemStack diaeresisO = SkullItem.getSkull("http://textures.minecraft.net/texture/c83d42bcb9b8e66c16166ccf261e2f9f78c68ee7886da225e43895cdbcaf5f");
		ItemMeta diaeresisOMeta = diaeresisO.getItemMeta();
		diaeresisOMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.diaeresis-o.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.diaresis-o.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			diaeresisOMeta.setLore(lores);
		}
		diaeresisO.setItemMeta(diaeresisOMeta);
		
		ItemStack a = SkullItem.getSkull("http://textures.minecraft.net/texture/9c60da2944a177dd08268fbec04e40812d1d929650be66529b1ee5e1e7eca");
		ItemMeta aMeta = a.getItemMeta();
		aMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.a.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.a.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			aMeta.setLore(lores);
		}
		a.setItemMeta(aMeta);
		
		ItemStack b = SkullItem.getSkull("http://textures.minecraft.net/texture/8041f5e86983d36eaec4e167b2bbb5a3727607cde88f7555ca1b522a039bb");
		ItemMeta bMeta = b.getItemMeta();
		bMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.b.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.b.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bMeta.setLore(lores);
		}
		b.setItemMeta(bMeta);
		
		ItemStack c = SkullItem.getSkull("http://textures.minecraft.net/texture/d945996c8ae91e376196d4dc676fec31feac790a2f195b2981a703ca1d16cb6");
		ItemMeta cMeta = c.getItemMeta();
		cMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.c.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.c.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cMeta.setLore(lores);
		}
		c.setItemMeta(cMeta);
		
		ItemStack d = SkullItem.getSkull("http://textures.minecraft.net/texture/1641150f481e8492f7128c948996254d2d91fc90f5a8ff4d8ac5c39a6a88a");
		ItemMeta dMeta = d.getItemMeta();
		dMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.d.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.d.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			dMeta.setLore(lores);
		}
		d.setItemMeta(dMeta);
		
		ItemStack e = SkullItem.getSkull("http://textures.minecraft.net/texture/db251487ff8eef2ebc7a57dab6e3d9f1db7fc926ddc66fea14afe3dff15a45");
		ItemMeta eMeta = e.getItemMeta();
		eMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.e.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.e.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			eMeta.setLore(lores);
		}
		e.setItemMeta(eMeta);
		
		ItemStack f = SkullItem.getSkull("http://textures.minecraft.net/texture/7e433656b443668ed03dac8c442722a2a41221be8bb48e23b35bd8c2e59f63");
		ItemMeta fMeta = f.getItemMeta();
		fMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.f.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.f.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			fMeta.setLore(lores);
		}
		f.setItemMeta(fMeta);
		
		ItemStack g = SkullItem.getSkull("http://textures.minecraft.net/texture/995863b73637605feacbb173b77d5e155e65204c78d5c7911f738f28deb60");
		ItemMeta gMeta = g.getItemMeta();
		gMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.g.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.g.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gMeta.setLore(lores);
		}
		g.setItemMeta(gMeta);
		
		ItemStack h = SkullItem.getSkull("http://textures.minecraft.net/texture/3c1d358d927074289cc26bff5b1240746f9f4f0cc46f942f5981c6595f72dd");
		ItemMeta hMeta = h.getItemMeta();
		hMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.h.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.h.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			hMeta.setLore(lores);
		}
		h.setItemMeta(hMeta);
		
		ItemStack i = SkullItem.getSkull("http://textures.minecraft.net/texture/8f2295865bda4e47979d36b8a887a75a13b034e6988f78670b64a1e6442c");
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.i.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.i.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			iMeta.setLore(lores);
		}
		i.setItemMeta(iMeta);
		
		ItemStack j = SkullItem.getSkull("http://textures.minecraft.net/texture/e34462b55d7f5823680ad13f2adbd7d1ed46ba5101017ed4b37aeeeb775d");
		ItemMeta jMeta = j.getItemMeta();
		jMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.j.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.j.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			jMeta.setLore(lores);
		}
		j.setItemMeta(jMeta);
		
		ItemStack k = SkullItem.getSkull("http://textures.minecraft.net/texture/773325a935c067b6ef227367f62ca4bf49f67adb9f6da32091e2d32c5dde328");
		ItemMeta kMeta = k.getItemMeta();
		kMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.k.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.k.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			kMeta.setLore(lores);
		}
		k.setItemMeta(kMeta);
		
		ItemStack l = SkullItem.getSkull("http://textures.minecraft.net/texture/25a1e3328c571aa495d9c5f494815cca176c3acb184feb5a7b9c96ce8e52fce");
		ItemMeta lMeta = l.getItemMeta();
		lMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.l.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.l.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			lMeta.setLore(lores);
		}
		l.setItemMeta(lMeta);
		
		ItemStack m = SkullItem.getSkull("http://textures.minecraft.net/texture/d467bf6be95e5c8e9d01977a2f0c487ed5b0de5c87963a2eb15411c442fb2b");
		ItemMeta mMeta = m.getItemMeta();
		mMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.m.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.m.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mMeta.setLore(lores);
		}
		m.setItemMeta(mMeta);
		
		ItemStack n = SkullItem.getSkull("http://textures.minecraft.net/texture/823e434d6395fe7e63492431bdee5782bd5ee5bc8cab7559467bdd1f93b925a");
		ItemMeta nMeta = n.getItemMeta();
		nMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.n.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.n.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			nMeta.setLore(lores);
		}
		n.setItemMeta(nMeta);
		
		ItemStack o = SkullItem.getSkull("http://textures.minecraft.net/texture/88445466bdc5ad5bcea82239c4e1b510f6ea5262d82d8a96d7291c342fb89");
		ItemMeta oMeta = o.getItemMeta();
		oMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.o.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.o.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			oMeta.setLore(lores);
		}
		o.setItemMeta(oMeta);
		
		ItemStack p = SkullItem.getSkull("http://textures.minecraft.net/texture/f9de601dee3ffeca4d54595f844201d0ed2091acec4548c696bb16a8a158f6");
		ItemMeta pMeta = p.getItemMeta();
		pMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.p.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.p.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pMeta.setLore(lores);
		}
		p.setItemMeta(pMeta);
		
		ItemStack q = SkullItem.getSkull("http://textures.minecraft.net/texture/66ca769bde25d4cc41e19e42adc35ab4c1557b76af232649acc9967ff198f13");
		ItemMeta qMeta = q.getItemMeta();
		qMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.q.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.q.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			qMeta.setLore(lores);
		}
		q.setItemMeta(qMeta);
		
		ItemStack r = SkullItem.getSkull("http://textures.minecraft.net/texture/67a188805162ca5dd4f4649c661d3f6d23c42662aef01645b1a97f78b3f13219");
		ItemMeta rMeta = r.getItemMeta();
		rMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.r.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.r.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			rMeta.setLore(lores);
		}
		r.setItemMeta(rMeta);
		
		ItemStack s = SkullItem.getSkull("http://textures.minecraft.net/texture/60d09dfd9f5de6243233e0e3325b6c3479335e7ccf13f2448d4e1f7fc4a0df");
		ItemMeta sMeta = s.getItemMeta();
		sMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.s.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.s.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			sMeta.setLore(lores);
		}
		s.setItemMeta(sMeta);
		
		ItemStack t = SkullItem.getSkull("http://textures.minecraft.net/texture/64c75619b91d241f678350ad9237c134c5e08d87d6860741ede306a4ef91");
		ItemMeta tMeta = t.getItemMeta();
		tMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.t.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.t.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			tMeta.setLore(lores);
		}
		t.setItemMeta(tMeta);
		
		ItemStack u = SkullItem.getSkull("http://textures.minecraft.net/texture/e9f6d2c6d5285f882ae55d1e91b8f9efdfc9b377208bf4c83f88dd156415e");
		ItemMeta uMeta = u.getItemMeta();
		uMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.u.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.u.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			uMeta.setLore(lores);
		}
		u.setItemMeta(uMeta);
		
		ItemStack v = SkullItem.getSkull("http://textures.minecraft.net/texture/dce27a153635f835237d85c6bf74f5b1f2e638c48fee8c83038d0558d41da7");
		ItemMeta vMeta = v.getItemMeta();
		vMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.v.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.v.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			vMeta.setLore(lores);
		}
		v.setItemMeta(vMeta);
		
		ItemStack w = SkullItem.getSkull("http://textures.minecraft.net/texture/aedcf4ffcb53b56d42baac9d0dfb118e343462327442dd9b29d49f50a7d38b");
		ItemMeta wMeta = w.getItemMeta();
		wMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.w.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.w.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wMeta.setLore(lores);
		}
		w.setItemMeta(wMeta);
		
		ItemStack x = SkullItem.getSkull("http://textures.minecraft.net/texture/83618ff1217640bec5b525fa2a8e671c75d2a7d7cb2ddc31d79d9d895eab1");
		ItemMeta xMeta = x.getItemMeta();
		xMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.x.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.x.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			xMeta.setLore(lores);
		}
		x.setItemMeta(xMeta);
		
		ItemStack y = SkullItem.getSkull("http://textures.minecraft.net/texture/d9c1d29a38bcf113b7e8c34e148a79f9fe41edf41aa8b1de873bb1d433b3861");
		ItemMeta yMeta = y.getItemMeta();
		yMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.y.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.y.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			yMeta.setLore(lores);
		}
		y.setItemMeta(yMeta);
		
		ItemStack z = SkullItem.getSkull("http://textures.minecraft.net/texture/b9295734195d2c7fa389b98757e9686ce6437c16c58bdf2b4cd538389b5912");
		ItemMeta zMeta = z.getItemMeta();
		zMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.z.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.z.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			zMeta.setLore(lores);
		}
		z.setItemMeta(zMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 2);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.alphabet.page-3.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
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
		
		player.openInventory(inventory);
	}
}