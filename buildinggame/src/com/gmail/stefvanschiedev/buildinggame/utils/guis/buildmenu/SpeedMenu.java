package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The gui for changing the fly speed
 *
 * @since 2.1.0
 */
class SpeedMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new SpeedMenu
     */
	SpeedMenu() {
		super(null, 18, MessageManager.translate(MESSAGES.getString("gui.fly-speed.title")),
                1);
		
		//fly speed 1
		ItemStack speed1 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed1Meta = speed1.getItemMeta();
		speed1Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-1.name")));
		speed1Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-1.lores")));
		speed1.setItemMeta(speed1Meta);
		
		setItem(speed1, event -> {
            ((Player) event.getWhoClicked()).setFlySpeed(.1F);

            event.setCancelled(true);
		}, 2);
		
		//fly speed 2
		ItemStack speed2 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed2Meta = speed2.getItemMeta();
		speed2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-2.name")));
		speed2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-2.lores")));
		speed2.setItemMeta(speed2Meta);
		
		setItem(speed2, event -> {
            ((Player) event.getWhoClicked()).setFlySpeed(.2F);

            event.setCancelled(true);
		}, 3);
		
		//fly speed 3
		ItemStack speed3 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed3Meta = speed3.getItemMeta();
		speed3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-3.name")));
		speed3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-3.lores")));
		speed3.setItemMeta(speed3Meta);
		
		setItem(speed3, event -> {
            ((Player) event.getWhoClicked()).setFlySpeed(.3F);

            event.setCancelled(true);
		}, 4);
		
		//fly speed 4
		ItemStack speed4 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed4Meta = speed4.getItemMeta();
		speed4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-4.name")));
		speed4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-4.lores")));
		speed4.setItemMeta(speed4Meta);
		
		setItem(speed4, event -> {
            ((Player) event.getWhoClicked()).setFlySpeed(.4F);

            event.setCancelled(true);
		}, 5);
		
		//fly speed 5
		ItemStack speed5 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed5Meta = speed5.getItemMeta();
		speed5Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-5.name")));
		speed5Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-5.lores")));
		speed5.setItemMeta(speed5Meta);
		
		setItem(speed5, event -> {
            ((Player) event.getWhoClicked()).setFlySpeed(.5F);

            event.setCancelled(true);
		}, 6);
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.back.name")));
		backMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.back.lores")));
		back.setItemMeta(backMeta);
		
		setItem(back, event -> {
            Player player = (Player) event.getWhoClicked();

            ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().open(player);
            removePlayer(player);

            event.setCancelled(true);
		}, 17);
	}
}