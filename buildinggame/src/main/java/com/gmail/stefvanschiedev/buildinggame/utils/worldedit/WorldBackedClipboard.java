package com.gmail.stefvanschiedev.buildinggame.utils.worldedit;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.entity.BaseEntity;
import com.sk89q.worldedit.entity.Entity;
import com.sk89q.worldedit.extent.clipboard.BlockArrayClipboard;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.math.BlockVector2;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.biome.BiomeType;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.world.block.BlockStateHolder;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A clipbaord implementation that is directly backed by the world of the region. This is different than clipboards such
 * as {@link BlockArrayClipboard}, since it doesn't require the blocks and entities to be copied first.
 *
 * @since 6.5.0
 */
public class WorldBackedClipboard implements Clipboard {

    /**
     * The region that is used for defining this clipboard
     */
    @NotNull
    private final Region region;

    /**
     * The origin of this clipboard
     */
    @NotNull
    private BlockVector3 origin;

    /**
     * Creates a new world backed clipboard
     *
     * @param region the region used as backing, see {@link #region}
     * @since 6.5.0
     */
    public WorldBackedClipboard(@NotNull Region region) {
        this.region = region;

        this.origin = region.getMinimumPoint();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @NotNull
    @Override
    public Region getRegion() {
        return region;
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BlockVector3 getDimensions() {
        return region.getMaximumPoint().subtract(region.getMinimumPoint()).add(1, 1, 1);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public BlockVector3 getOrigin() {
        return origin;
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public void setOrigin(@NotNull BlockVector3 origin) {
        this.origin = origin;
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BlockVector3 getMinimumPoint() {
        return region.getMinimumPoint();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BlockVector3 getMaximumPoint() {
        return region.getMaximumPoint();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public List<? extends Entity> getEntities(Region region) {
        World world = BukkitAdapter.adapt(region.getWorld());

        return world.getEntities().stream().filter(entity -> {
            var entityLocation = entity.getLocation();
            var entityLocationX = entityLocation.getX();
            var entityLocationY = entityLocation.getY();
            var entityLocationZ = entityLocation.getZ();

            BlockVector3 minimumPoint = region.getMinimumPoint();
            BlockVector3 maximumPoint = region.getMaximumPoint();

            return entityLocationX >= minimumPoint.getX() && entityLocationX <= maximumPoint.getX() &&
                entityLocationY >= minimumPoint.getY() && entityLocationY <= maximumPoint.getY() &&
                entityLocationZ >= minimumPoint.getZ() && entityLocationZ <= maximumPoint.getZ();
        }).map(BukkitAdapter::adapt).collect(Collectors.toUnmodifiableList());
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public List<? extends Entity> getEntities() {
        return getEntities(region);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Nullable
    @Override
    public Entity createEntity(Location location, BaseEntity baseEntity) {
        return BukkitAdapter.adapt(BukkitAdapter.adapt(region.getWorld()).spawnEntity(BukkitAdapter.adapt(location),
            BukkitAdapter.adapt(baseEntity.getType())));
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BlockState getBlock(BlockVector3 blockVector3) {
        return BukkitAdapter.adapt(BukkitAdapter.adapt(
            region.getWorld()
        ).getBlockAt(blockVector3.getBlockX(), blockVector3.getBlockY(), blockVector3.getBlockZ()).getBlockData());
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BaseBlock getFullBlock(BlockVector3 blockVector3) {
        return getBlock(blockVector3).toBaseBlock();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public BiomeType getBiome(BlockVector2 blockVector2) {
        Biome biome = BukkitAdapter.adapt(region.getWorld()).getBiome(blockVector2.getX(), blockVector2.getZ());

        return BukkitAdapter.adapt(biome);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public <T extends BlockStateHolder<T>> boolean setBlock(BlockVector3 blockVector3, T t) {
        BukkitAdapter.adapt(region.getWorld()).getBlockAt(blockVector3.getX(), blockVector3.getY(), blockVector3.getZ())
            .setBlockData(BukkitAdapter.adapt(t));

        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Override
    public boolean setBiome(BlockVector2 blockVector2, BiomeType baseBiome) {
        World world = BukkitAdapter.adapt(region.getWorld());
        world.setBiome(blockVector2.getX(), blockVector2.getZ(), BukkitAdapter.adapt(baseBiome));

        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.5.0
     */
    @Nullable
    @Override
    public Operation commit() {
        return null;
    }
}
