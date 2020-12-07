package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import java.util.List;
import java.util.stream.Collectors;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for selecting a team
 *
 * @since 2.1.0
 */
public class TeamSelection extends ChestGui {

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
		super((int) Math.max(Math.ceil(arena.getPlots().size() / 9.0), 6),
            MessageManager.translate(MESSAGES.getString("team-gui.title")));

		this.arena = arena;
	}

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
	@Override
    public void show(@NotNull HumanEntity humanEntity) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        int iteration = 0;

        var outlinePane =
            new OutlinePane(0, 0, 9, (int) Math.max(Math.ceil(arena.getPlots().size() / 9.0), 6));

        for (final var plot : arena.getPlots()) {
            Material material = SettingsManager.getInstance().getMaterial("team-selection.team." + (iteration + 1) + ".id",
                Material.BARRIER);

            var item = new ItemStack(material);
            var itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("team-gui.team.name")
                    .replace("%plot%", plot.getId() + "")
                    .replace("%plot_players%", plot.getPlayers() + "")
                    .replace("%plot_max_players%", plot.getMaxPlayers() + ""), (Player) humanEntity));

            List<String> lores = config.getBoolean("team-selection.show-names-as-lore") ?
                plot.getGamePlayers().stream()
                    .map(gamePlayer -> gamePlayer.getPlayer().getName())
                    .collect(Collectors.toList()) :
                MESSAGES.getStringList("team-gui.team.lores").stream()
                    .map(lore -> MessageManager.translate(lore, (Player) humanEntity))
                    .collect(Collectors.toList());

            itemMeta.setLore(lores);
            item.setItemMeta(itemMeta);
            outlinePane.addItem(new GuiItem(item, event -> {
                Player p = (Player) event.getWhoClicked();
                var previousPlot = arena.getPlot(p);
                var gamePlayer = previousPlot.getGamePlayer(p);

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