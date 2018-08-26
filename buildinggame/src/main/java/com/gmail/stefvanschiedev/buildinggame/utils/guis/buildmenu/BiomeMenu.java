package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * The gui to change the biome of your plot
 *
 * @since 5.2.0
 */
class BiomeMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * The plot this gui is for
     */
    private final Plot plot;

    /**
     * Constructs a new biome menu for the specified plot
     *
     * @param plot the plot this menu belongs to
     */
    BiomeMenu(Plot plot) {
        this.plot = plot;
        this.gui = Gui.load(Main.getInstance(), this,
            Main.getInstance().getResource("gui/buildmenu/biomemenu.xml"));

        String title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
            gui.setTitle(MessageManager.translate(MESSAGES.getString(ChatColor.stripColor(title.substring(1)))));

        gui.getItems().forEach(item -> {
            ItemMeta itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            String displayName = itemMeta.getDisplayName();

            if (displayName != null && !displayName.isEmpty() && displayName.charAt(0) == '*')
                itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString(displayName.substring(1))));

            List<String> lore = itemMeta.getLore();

            if (lore != null) {
                String line = lore.get(0);

                if (!line.isEmpty() && line.charAt(0) == '*')
                    itemMeta.setLore(MessageManager.translate(MESSAGES.getStringList(line.substring(1))));
            }

            item.getItem().setItemMeta(itemMeta);
        });
    }

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.show(humanEntity);
    }

    /**
     * Called whenever a user clicks on a biome item
     *
     * @param cancellable the cancellable form the event called when clicking
     * @since 5.6.0
     */
    public void biomeClick(Cancellable cancellable, Biome biome) {
        plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(biome));

        //just send it to all players directly, so we don't have to do weird trickery
        plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().stream().flatMap(p ->
            p.getAllGamePlayers().stream()).forEach(gamePlayer -> gamePlayer.refreshChunk(chunk)));

        cancellable.setCancelled(true);
    }
}