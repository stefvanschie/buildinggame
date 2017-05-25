package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;

public class TeamSelection extends Gui {

	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	public TeamSelection(final Arena arena) {
		super(null, round(arena.getPlots().size()), MessageManager.translate(MESSAGES.getString("team-gui.title")), 1);

		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		int iteration = 0;
		
		for (final Plot plot : arena.getPlots()) {
			ItemStack item = IDDecompiler.getInstance().decompile(config.getString("team-selection.team." + (iteration + 1) + ".id"));
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("team-gui.team.name")
					.replace("%plot%", plot.getID() + "")
					.replace("%plot_players%", plot.getPlayers() + "")
					.replace("%plot_max_players%", plot.getMaxPlayers() + "")));
			
			List<String> lores = new ArrayList<>();
			
			if (!config.getBoolean("team-selection.show-names-as-lore")) {
				for (String lore : MESSAGES.getStringList("team-gui.team.lores"))
					lores.add(MessageManager.translate(lore));
			} else {
				for (GamePlayer gamePlayer : plot.getGamePlayers())
					lores.add(gamePlayer.getPlayer().getName());
			}
			
			itemMeta.setLore(lores);
			item.setItemMeta(itemMeta);
			setItem(item, new GuiAction() {
				
				private final Plot p = plot;
				
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					Player player = (Player) event.getWhoClicked();
					Plot previousPlot = arena.getPlot(player);
					GamePlayer gamePlayer = previousPlot.getGamePlayer(player);
					
					if (p.join(gamePlayer))
						previousPlot.leave(gamePlayer);
					
					player.closeInventory();
					return true;
				}
			}, iteration);
			
			iteration++;
		}
	}
	
	@Contract(pure = true)
    private static int round(int i) {
		while (i % 9 != 0 || i == 0)
			i++;
		return i;
	}
}