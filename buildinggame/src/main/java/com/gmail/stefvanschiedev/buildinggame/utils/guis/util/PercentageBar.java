package com.gmail.stefvanschiedev.buildinggame.utils.guis.util;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PercentageBar extends Pane {

    /**
     * The green and the red parts of the percentage bar
     */
    @NotNull
    private final OutlinePane greenPane, redPane;

    /**
     * The green and red items used in the {@link #redPane} and {@link #greenPane}
     */
    @NotNull
    private final GuiItem greenItem, redItem;

    /**
     * The percentage this bar is at
     */
    private float percentage;

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    private PercentageBar(int x, int y, int length, int height, @NotNull Priority priority) {
        this(length, height);

        this.x = x;
        this.y = y;

        setPriority(priority);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    public PercentageBar(int x, int y, int length, int height) {
        this(x, y, length, height, Priority.NORMAL);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    private PercentageBar(int length, int height) {
        super(length, height);

        this.percentage = 0F;

        this.greenPane = new OutlinePane(x, y, 0, height);
        this.redPane = new OutlinePane(x, y, length, height);

        var greenItemStack = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        var greenItemStackMeta = greenItemStack.getItemMeta();
        greenItemStackMeta.setDisplayName(ChatColor.GREEN + "0.0%");
        greenItemStack.setItemMeta(greenItemStackMeta);

        this.greenItem = new GuiItem(greenItemStack, event -> event.setCancelled(true));

        var redItemStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        var redItemStackMeta = redItemStack.getItemMeta();
        redItemStackMeta.setDisplayName(ChatColor.RED + "0.0%");
        redItemStack.setItemMeta(redItemStackMeta);

        this.redItem = new GuiItem(redItemStack, event -> event.setCancelled(true));

        this.greenPane.addItem(greenItem);
        this.redPane.addItem(redItem);

        this.greenPane.setRepeat(true);
        this.redPane.setRepeat(true);
    }

    /**
     * Sets the percentage of this bar. The percentage has to be in (0,1). If not, this method will throw an
     * {@link IllegalArgumentException}.
     *
     * @param percentage the new percentage.
     * @throws IllegalArgumentException when the percentage is out of range
     * @since 6.4.0
     */
    public void setPercentage(float percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Percentage is out of range (0,1)");
        }

        this.percentage = percentage;

        updateLengthsAndPositions();

        NumberFormat percentFormatter = DecimalFormat.getPercentInstance();
        percentFormatter.setMinimumFractionDigits(0);
        percentFormatter.setMaximumFractionDigits(1);

        var greenItemStack = this.greenItem.getItem();
        var greenItemStackMeta = greenItemStack.getItemMeta();
        greenItemStackMeta.setDisplayName(ChatColor.GREEN + percentFormatter.format(percentage));
        greenItemStack.setItemMeta(greenItemStackMeta);

        var redItemStack = this.redItem.getItem();
        var redItemStackMeta = redItemStack.getItemMeta();
        redItemStackMeta.setDisplayName(ChatColor.RED + percentFormatter.format(percentage));
        redItemStack.setItemMeta(redItemStackMeta);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public boolean click(@NotNull InventoryClickEvent event, int paneOffsetX, int paneOffsetY, int maxLength,
                         int maxHeight) {
        int length = Math.min(this.length, maxLength);
        int height = Math.min(this.height, maxHeight);

        int slot = event.getSlot();

        int x = (slot % 9) - getX();
        int y = (slot / 9) - getY();

        if (x < 0 || x >= length || y < 0 || y >= height) {
            return false;
        }

        if (onLocalClick != null) {
            onLocalClick.accept(event);
        }

        int newPaneOffsetX = paneOffsetX + getX();
        int newPaneOffsetY = paneOffsetY + getY();

        return this.greenPane.click(event, newPaneOffsetX, newPaneOffsetY, length, height) ||
            this.redPane.click(event, newPaneOffsetX, newPaneOffsetY, length, height);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public void display(@NotNull Inventory inventory, int paneOffsetX, int paneOffsetY, int maxLength, int maxHeight) {
        int newPaneOffsetX = paneOffsetX + getX();
        int newPaneOffsetY = paneOffsetY + getY();
        int newMaxLength = Math.min(maxLength, getLength());
        int newMaxHeight = Math.min(maxHeight, getHeight());

        this.greenPane.display(inventory, newPaneOffsetX, newPaneOffsetY, newMaxLength, newMaxHeight);
        this.redPane.display(inventory, newPaneOffsetX, newPaneOffsetY, newMaxLength, newMaxHeight);
    }

    /**
     * Updates the lengths and the positions of panes after resizing or change of percentage
     *
     * @since 6.4.0
     */
    private void updateLengthsAndPositions() {
        this.greenPane.setLength(Math.round(getLength() * percentage));

        this.redPane.setLength(getLength() - this.greenPane.getLength());
        this.redPane.setX(this.greenPane.getX() + this.greenPane.getLength());
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public void setX(int x) {
        super.setX(x);

        this.greenPane.setX(x);
        this.redPane.setX(this.greenPane.getX() + this.greenPane.getLength());
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public void setHeight(int height) {
        super.setHeight(height);

        this.greenPane.setHeight(height);
        this.redPane.setHeight(height);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public void setY(int y) {
        super.setY(y);

        this.greenPane.setY(y);
        this.redPane.setY(y);
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @Override
    public void setLength(int length) {
        super.setLength(length);

        updateLengthsAndPositions();
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @NotNull
    @Override
    public Collection<GuiItem> getItems() {
        return getPanes().stream().flatMap(pane -> pane.getItems().stream()).collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     *
     * @since 6.4.0
     */
    @NotNull
    @Override
    public Collection<Pane> getPanes() {
        return Stream.of(this.greenPane, this.redPane).collect(Collectors.toSet());
    }
}
