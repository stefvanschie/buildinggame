package com.gmail.stefvanschiedev.buildinggame.events.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.util.eventbus.Subscribe;
import com.sk89q.worldedit.world.block.BlockStateHolder;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * Implements necessary checks to assure that edits made by WorldEdit are in the boundary of the given plot. Is only
 * active when WorldEdit is installed and enabled.
 *
 * @since 5.8.0
 */
public class WorldEditBoundaryAssertion {

    /**
     * Cancels any edits being made for blocks outside the plot the actor is (possibly) on.
     *
     * @param event the event fired when a session is being edited
     * @since 5.8.0
     */
    @Subscribe
    public void onEditSession(EditSessionEvent event) {
        if (event.getActor() == null || !event.getActor().isPlayer())
            return;

        var player = Bukkit.getPlayer(event.getActor().getUniqueId());
        var arena = ArenaManager.getInstance().getArena(player);

        //don't do anything if the player isn't in an arena
        if (arena == null)
            return;

        event.setExtent(new AbstractDelegateExtent(event.getExtent()) {
            @Override
            public boolean setBlock(BlockVector3 vector, BlockStateHolder block) throws WorldEditException {
                var world = Bukkit.getWorld(event.getWorld().getName());
                var loc = new Location(world, vector.getX(), vector.getY(), vector.getZ());

                if (!arena.getPlot(player).getBoundary().isInside(loc)) {
                    return false;
                }

                return super.setBlock(vector, block);
            }
        });
    }
}
