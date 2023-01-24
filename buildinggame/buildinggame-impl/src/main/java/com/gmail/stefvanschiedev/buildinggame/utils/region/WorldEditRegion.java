package com.gmail.stefvanschiedev.buildinggame.utils.region;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.BlockArrayClipboard;
import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardWriter;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * The same as {@link Region}, but this one is used when WorldEdit is present, so we can do WorldEdit dependent method
 * calls.
 *
 * @since 7.0.0
 */
public class WorldEditRegion extends Region {

    /**
     * {@inheritDoc}
     */
    WorldEditRegion(Supplier<World> worldSupplier, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
        super(worldSupplier, highX, highY, highZ, lowX, lowY, lowZ);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSchematic(@NotNull File file, @Nullable Runnable runAfter) {
        World world = getWorld().get();

        if (world == null) {
            return;
        }

        var lowVector = BlockVector3.at(getLowX(), getLowY(), getLowZ());
        var highVector = BlockVector3.at(getHighX(), getHighY(), getHighZ());
        var bukkitWorld = new BukkitWorld(world);

        var cuboidRegion = new CuboidRegion(bukkitWorld, lowVector, highVector);
        var clipboard = new BlockArrayClipboard(cuboidRegion);

        EditSession editSession = WorldEdit.getInstance().newEditSessionBuilder()
            .world(bukkitWorld)
            .build();

        var forwardExtentCopy = new ForwardExtentCopy(editSession, cuboidRegion, clipboard, cuboidRegion.getMinimumPoint());
        forwardExtentCopy.setCopyingEntities(true);

        try {
            Operations.complete(forwardExtentCopy);
        } catch (WorldEditException exception) {
            exception.printStackTrace();
            return;
        }

        Runnable runnable = () -> {
            try (ClipboardWriter writer = BuiltInClipboardFormat.SPONGE_SCHEMATIC.getWriter(new FileOutputStream(file))) {
                writer.write(clipboard);
            } catch (IOException exception) {
                exception.printStackTrace();
                return;
            }

            if (runAfter != null) {
                Bukkit.getScheduler().runTask(Main.getInstance(), runAfter);
            }
        };

        if (Bukkit.isPrimaryThread()) {
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), runnable);
        } else {
            runnable.run();
        }
    }
}
