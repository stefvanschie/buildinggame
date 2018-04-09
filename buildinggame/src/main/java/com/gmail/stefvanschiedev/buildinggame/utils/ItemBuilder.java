package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.*;
import java.util.function.Consumer;

import me.ialistannen.mininbt.ItemNBTUtil;
import me.ialistannen.mininbt.NBTWrappers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Easily allows you to create items with click events
 *
 * @since 4.0.6
 */
public class ItemBuilder implements Listener {

    /**
     * The click event assigned to this item
     */
	private Consumer<PlayerInteractEvent> event;

    /**
     * Whether you can move the item around
     */
	private boolean movable;

    /**
     * The player this item belongs to
     */
    @NotNull
	private final Player player;

    /**
     * The item we're making
     */
    private ItemStack item;

    /**
     * A map containing all players with their registered items
     */
	private static final Map<Player, Set<ItemBuilder>> REGISTERED_ITEMS = new HashMap<>();

    /**
     * Constructs a new ItemBuilder
     *
     * @param player the player for whom the item is meant
     * @param material the item's material
     */
	public ItemBuilder(@NotNull Player player, Material material) {
		this(player, material, 1, (short) 0);
	}

    /**
     * Constructs a new ItemBuilder
     *
     * @param player the player for whom the item is meant
     * @param material the item's material
     * @param amount the amount of items there should be
     * @param damage the damage value of the item
     */
	public ItemBuilder(@NotNull Player player, Material material, int amount, short damage) {
	    this.item = new ItemStack(material, amount, damage);
		this.player = player;

		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}

    /**
     * Builds the item stack
     *
     * @return the itemstack
     * @since 5.6.1
     */
    public ItemStack build() {
        NBTWrappers.NBTTagCompound nbtTagCompound = new NBTWrappers.NBTTagCompound();

        nbtTagCompound.setBoolean("movable", movable);
        nbtTagCompound.setString("player", player.getUniqueId().toString());

        this.item = ItemNBTUtil.setNBTTag(nbtTagCompound, item);

        if (!REGISTERED_ITEMS.containsKey(player))
            REGISTERED_ITEMS.put(player, new HashSet<>());

        REGISTERED_ITEMS.get(player).add(this);

        return item;
    }

    /**
     * Returns the player who belongs to this instance
     *
     * @return the player
     */
    @NotNull
    @Contract(pure = true)
	private Player getPlayer() {
	    return player;
    }

    /**
     * Sets whether this item should be able to be moved
     *
     * @param movable the new movable state
     * @return this instance
     * @since 4.0.6
     */
	public ItemBuilder movable(boolean movable) {
		this.movable = movable;
		return this;
	}

    /**
     * Sets the click event for this item
     *
     * @param event the new click event
     * @return this instance
     * @since 4.0.6
     */
	public ItemBuilder setClickEvent(Consumer<PlayerInteractEvent> event) {
		this.event = event;
		return this;
	}

    /**
     * Sets the display name of this item
     *
     * @param name the new display name
     * @return this instance
     * @since 4.0.6
     */
	public ItemBuilder setDisplayName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

    /**
     * Sets the lore of this item
     *
     * @param lores sets the new lore
     * @return this item
     * @since 4.0.6
     */
	public ItemBuilder setLore(List<String> lores) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lores);
		item.setItemMeta(meta);
		return this;
	}

    /**
     * Returns the item that belongs to this builder
     *
     * @return the item
     * @since 5.6.1
     */
    private ItemStack getItem() {
        return item;
    }

    /**
     * Checks to see if the specified player still has this item in their inventory
     *
     * @param player the player to check
     * @since 4.0.6
     */
	public static void check(Player player) {
		Set<ItemBuilder> builders = REGISTERED_ITEMS.get(player);
		
		if (builders == null)
			return;

		for (Iterator<ItemBuilder> iterator = builders.iterator(); iterator.hasNext();) {
		    ItemBuilder builder = iterator.next();

            if (!player.getInventory().contains(builder.getItem())) {
                HandlerList.unregisterAll(builder);
                iterator.remove();
            }
        }
	}

    /**
     * Handles the interaction between player and their item
     *
     * @param e the event that occurs
     * @since 4.0.6
     */
	@Contract("null -> fail")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getItem() == null || !this.item.isSimilar(e.getItem()) || event == null || !e.getPlayer().equals(player))
			return;

		if (e.getHand() == EquipmentSlot.HAND)
			this.event.accept(e);
	}

    /**
     * Handles the movement of items
     *
     * @param e the event that occurs
     * @since 4.0.6
     */
	@Contract("null -> fail")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null)
			return;

        NBTWrappers.NBTTagCompound tag = ItemNBTUtil.getTag(e.getCurrentItem());

        if (tag != null && tag.getString("player") != null &&
            e.getWhoClicked().getUniqueId().equals(UUID.fromString(tag.getString("player"))) &&
            !tag.getBoolean("movable"))
            e.setCancelled(true);
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public int hashCode() {
        return 31 * super.hashCode() + player.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Contract(pure = true, value = "null -> false")
    @Override
    public boolean equals(Object obj) {
	    return super.equals(obj) && obj instanceof ItemBuilder && player.equals(((ItemBuilder) obj).getPlayer());
    }
}