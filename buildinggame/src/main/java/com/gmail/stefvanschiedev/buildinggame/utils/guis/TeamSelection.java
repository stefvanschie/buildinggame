package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * A menu for selecting a team
 *
 * @since 2.1.0
 */
public class TeamSelection extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The arena this team selection gui belongs to
     */
	private final Arena arena;

	/**
     * Constructs a new TeamSelection
     *
     * @param arena the arena this team selection menu is for
     */
	public TeamSelection(Arena arena) {
		super(Main.getInstance(), (int) Math.max(Math.ceil(arena.getPlots().size() / 9.0), 6),
            MessageManager.translate(MESSAGES.getString("team-gui.title")));

		this.arena = arena;
	}

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
	@Override
    public void show(HumanEntity humanEntity) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        int iteration = 0;

        OutlinePane outlinePane = new OutlinePane(new GuiLocation(0, 0), 9,
            (int) Math.max(Math.ceil(arena.getPlots().size() / 9.0), 6));

        for (final Plot plot : arena.getPlots()) {
            ItemStack item = IDDecompiler.getInstance().decompile(config.getString("team-selection.team." +
                    (iteration + 1) + ".id"));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("team-gui.team.name")
                    .replace("%plot%", plot.getID() + "")
                    .replace("%plot_players%", plot.getPlayers() + "")
                    .replace("%plot_max_players%", plot.getMaxPlayers() + ""), (Player) humanEntity));

            List<String> lores = new ArrayList<>();

            if (!config.getBoolean("team-selection.show-names-as-lore")) {
                for (String lore : MESSAGES.getStringList("team-gui.team.lores"))
                    lores.add(MessageManager.translate(lore, (Player) humanEntity));
            } else {
                for (GamePlayer gamePlayer : plot.getGamePlayers())
                    lores.add(gamePlayer.getPlayer().getName());
            }

            itemMeta.setLore(lores);
            item.setItemMeta(itemMeta);
            outlinePane.addItem(new GuiItem(item, event -> {
                Player p = (Player) event.getWhoClicked();
                Plot previousPlot = arena.getPlot(p);
                GamePlayer gamePlayer = previousPlot.getGamePlayer(p);

                if (plot.join(gamePlayer))
                    previousPlot.leave(gamePlayer);

                p.closeInventory();

                update();

                event.setCancelled(true);
            }));

            iteration++;
        }

        addPane(outlinePane);

	    super.show(humanEntity);
    }
}