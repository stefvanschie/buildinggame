package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The gui for particles
 *
 * @since 2.1.0
 */
class ParticlesMenu {

    /**
     * The gui
     */
	private final Gui gui;

	/**
     * Constructs a new Particles menu
     */
	ParticlesMenu() {
		this.gui = Gui.load(this, Main.getInstance().getResource("gui/buildmenu/particlesmenu.xml"));
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
     * Called whenever a user clicks on a particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void particleClick(InventoryClickEvent event, ParticleType particleType) {
        Player player = (Player) event.getWhoClicked();
        Arena arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
            return;

        if (particleType == ParticleType.FALLING_DUST)
            arena.getPlot(player).addParticle(event.getCursor() != null ?
                new Particle(player.getLocation(), ParticleType.FALLING_DUST, event.getCursor().getData()) :
                new Particle(player.getLocation(), ParticleType.FALLING_DUST), player);
        else
            arena.getPlot(player).addParticle(new Particle(player.getLocation(), particleType), player);

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the clear particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void clearParticlesClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Arena arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
            return;

        arena.getPlot(player).getParticles().clear();

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the clear particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void backClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().show(player);

        event.setCancelled(true);
    }
}