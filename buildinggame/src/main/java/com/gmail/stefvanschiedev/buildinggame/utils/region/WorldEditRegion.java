package com.gmail.stefvanschiedev.buildinggame.utils.region;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.worldedit.WorldBackedClipboard;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.util.io.Closer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedOutputStream;
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

        Runnable runnable = () -> {
            try (var closer = Closer.create()) {
                var fileOutputStream = closer.register(new FileOutputStream(file));
                var bufferedOutputStream = closer.register(new BufferedOutputStream(fileOutputStream));
                var builtInClipboardFormat = BuiltInClipboardFormat.SPONGE_SCHEMATIC;
                var clipboardWriter = builtInClipboardFormat.getWriter(bufferedOutputStream);

                var lowVector = BlockVector3.at(getLowX(), getLowY(), getLowZ());
                var highVector = BlockVector3.at(getHighX(), getHighY(), getHighZ());
                var bukkitWorld = new BukkitWorld(world);

                var cuboidRegion = new CuboidRegion(bukkitWorld, lowVector, highVector);
                var blockArrayClipboard = new WorldBackedClipboard(cuboidRegion);

                closer.register(clipboardWriter).write(blockArrayClipboard);
            } catch (IOException exception) {
                exception.printStackTrace();
                return;
            }

            if (runAfter != null) {
                runAfter.run();
            }
        };

        if (Bukkit.isPrimaryThread()) {
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), runnable);
        } else {
            runnable.run();
        }
    }
}
