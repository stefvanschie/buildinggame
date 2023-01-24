package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * A menu for showing confirmation guis to the player
 *
 * @since 6.5.0
 */
public class ConfirmationMenu {

    /**
     * The code that should be called once a response has arrived
     */
    @NotNull
    private final Consumer<Response> response;

    /**
     * The gui this class represents
     */
    @NotNull
    private final ChestGui gui;

    /**
     * Constructs a new GUI
     *
     * @param title the title/name of this gui.
     * @param response what should happen when a selection has been made
     * @since 6.5.0
     */
    ConfirmationMenu(@NotNull String title, @NotNull Consumer<Response> response) {
        gui = ChestGui.load(this, Main.getInstance().getResource("gui/confirmationmenu.xml"));

        gui.setTitle(title);

        this.response = response;
    }

    /**
     * @see Gui#show(HumanEntity)
     * @since 6.5.0
     */
    public void show(@NotNull HumanEntity humanEntity) {
        humanEntity.closeInventory();

        gui.show(humanEntity);
    }

    /**
     * Called by IF when an item has been clicked
     *
     * @param event the event that was fired due to clicking on the item
     * @param response the response of the click
     * @since 6.5.0
     */
    public void choice(@NotNull InventoryClickEvent event, @NotNull Response response) {
        event.getWhoClicked().closeInventory();

        this.response.accept(response);
    }

    /**
     * Called by IF when the inventory has ben closed
     *
     * @since 6.5.0
     */
    public void close() {
        this.response.accept(Response.DENY);
    }

    /**
     * Different types of responses based on the
     */
    public enum Response {
        /**
         * Used when the accept item was clicked
         */
        ACCEPT,

        /**
         * Used when the deny item was clicked
         */
        DENY
    }
}
