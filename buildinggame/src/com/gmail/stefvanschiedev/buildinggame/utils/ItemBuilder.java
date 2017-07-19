package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
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
public class ItemBuilder extends ItemStack implements Listener {

    /**
     * The click event assigned to this item
     */
	private ClickEvent event;

    /**
     * Whether you can move the item around
     */
	private boolean moveable;

    /**
     * The player this item belongs to
     */
	private final Player player;

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
	public ItemBuilder(Player player, Material material) {
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
	public ItemBuilder(Player player, Material material, int amount, short damage) {
		setType(material);
		setAmount(amount);
		setDurability(damage);

		this.player = player;

		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
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
     * @param moveable the new movable state
     * @return this instance
     * @since 4.0.6
     */
	public ItemBuilder moveable(boolean moveable) {
		this.moveable = moveable;
		return this;
	}

    /**
     * Sets the click event for this item
     *
     * @param event the new click event
     * @return this instance
     * @since 4.0.6
     */
	public ItemBuilder setClickEvent(ClickEvent event) {
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
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(name);
		setItemMeta(meta);
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
		ItemMeta meta = getItemMeta();
		meta.setLore(lores);
		setItemMeta(meta);
		return this;
	}

    /**
     * Registers this instance
     *
     * @since 5.0.0
     */
	public static void register(ItemBuilder builder) {
	    Player player = builder.getPlayer();

        if (!REGISTERED_ITEMS.containsKey(player))
            REGISTERED_ITEMS.put(player, new HashSet<>());
	    REGISTERED_ITEMS.get(player).add(builder);
    }

    private static int getAll() {
	    int i = 0;

	    for (Set<ItemBuilder> sets : REGISTERED_ITEMS.values())
	        i += sets.size();

        return i;
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

            if (!player.getInventory().contains(builder)) {
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
		if (e.getItem() == null || !this.isSimilar(e.getItem()) || event == null || !e.getPlayer().equals(player))
			return;

		if (e.getHand() == EquipmentSlot.HAND)
			e.setCancelled(this.event.onClick(e));
	}

    /**
     * Handles the movement of items
     *
     * @param e the event that occurs
     * @since 4.0.6
     */
	@Contract("null -> fail")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null || !e.getCurrentItem().equals(this))
			return;
		
		if (!moveable)
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
    @Override
    public boolean equals(Object obj) {
	    return super.equals(obj) && obj instanceof ItemBuilder && player.equals(((ItemBuilder) obj).getPlayer());
    }

    /**
     * Used to represent click events
     *
     * @since 4.0.6
     */
	@FunctionalInterface
    public interface ClickEvent {

	    /**
         * Called whenever the item is being clicked on
         *
         * @param event the event that occurs
         * @return tue if the event should be cancelled, false if not
         * @since 4.0.6
         */
		@SuppressWarnings("MissingEventHandlerAnnotation")
        boolean onClick(PlayerInteractEvent event);
		
	}
}