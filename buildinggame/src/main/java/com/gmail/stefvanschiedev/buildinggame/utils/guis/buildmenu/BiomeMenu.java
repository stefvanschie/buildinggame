package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.block.Biome;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;

/**
 * The gui to change the biome of your plot
 *
 * @since 5.2.0
 */
class BiomeMenu {
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
        this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/biomemenu.xml"));
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