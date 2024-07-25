package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.nms.Version;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.FallingDustParticle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.RedstoneParticle;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.InputStream;

/**
 * The gui for particles
 *
 * @since 2.1.0
 */
public class ParticlesMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The gui
     */
	private final ChestGui gui;

	/**
     * Constructs a new Particles menu
     */
	ParticlesMenu() {
        Version version = Version.getVersion();
        InputStream resource;

        if (version.is1_19()) {
            resource = Main.getInstance().getResource("gui/buildmenu/particles/particlesmenu_1_19.xml");
        } else if (version.is1_20()) {
            resource = Main.getInstance().getResource("gui/buildmenu/particles/particlesmenu_1_20.xml");
        } else {
            throw new UnsupportedOperationException("Unknown version '" + version + "'");
        }

        this.gui = ChestGui.load(this, resource);

        var title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
		    gui.setTitle(MessageManager.translate(MESSAGES.getString(ChatColor.stripColor(title.substring(1)))));

		gui.getItems().forEach(item -> {
            var itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            var displayName = itemMeta.getDisplayName();

            if (!displayName.isEmpty() && displayName.charAt(0) == '*')
		        itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString(displayName.substring(1))));

            String lore = itemMeta.getLore().get(0);

            if (!lore.isEmpty() && lore.charAt(0) == '*')
                itemMeta.setLore(MessageManager.translate(MESSAGES.getStringList(lore.substring(1))));

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
     * Called whenever a user clicks on a particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void particleClick(InventoryClickEvent event, org.bukkit.Particle particleType) {
        var player = (Player) event.getWhoClicked();
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
            return;

        Location location = player.getLocation();
        Plot plot = arena.getPlot(player);

        if (particleType == org.bukkit.Particle.FALLING_DUST) {
            Particle particle;

            if (event.getCursor() == null) {
                particle = new FallingDustParticle(location, Bukkit.createBlockData(Material.SAND));
            } else {
                particle = new FallingDustParticle(location, Bukkit.createBlockData(event.getCursor().getType()));
            }

            plot.addParticle(particle, player);
        //Spigot will remap this to DUST for modern versions
        } else if (particleType == org.bukkit.Particle.valueOf("REDSTONE")) {
            plot.addParticle(new RedstoneParticle(location), player);
        } else {
            plot.addParticle(new Particle(location, particleType), player);
        }

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the clear particle item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void clearParticlesClick(InventoryClickEvent event) {
        var player = (Player) event.getWhoClicked();
        var arena = ArenaManager.getInstance().getArena(player);

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
        var player = (Player) event.getWhoClicked();

        ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().show(player);

        event.setCancelled(true);
    }
}