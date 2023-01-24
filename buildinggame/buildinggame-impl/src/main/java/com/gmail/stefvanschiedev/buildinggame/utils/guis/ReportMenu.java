package com.gmail.stefvanschiedev.buildinggame.utils.guis;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Report;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.session.ClipboardHolder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A report menu for viewing reports
 *
 * @since 6.5.0
 */
public class ReportMenu extends ChestGui {

    /**
     * Constructs a new report menu
     */
    public ReportMenu() {
        super(6, ChatColor.GREEN + "Reports");

        var paginatedPane = new PaginatedPane(0, 0, 9, 5);

        List<OfflinePlayer> players = Report.getReports().stream()
            .map(Report::getReportee)
            .distinct()
            .sorted(Comparator.comparingInt(player -> Report.getReports(player).size()))
            .collect(Collectors.toList());

        int paginatedPaneArea = paginatedPane.getHeight() * paginatedPane.getLength();

        for (int page = 0; page < Math.max(1, Math.ceil((double) players.size() / paginatedPaneArea)); page++) {
            var outlinePane = new OutlinePane(0, 0, 9, 5);

            for (int i = 0; i < paginatedPaneArea; i++) {
                int index = i + (page * paginatedPaneArea);

                if (index >= players.size()) {
                    break;
                }

                OfflinePlayer player = players.get(index);
                var reports = Report.getReports(player);

                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                headMeta.setDisplayName((player.isOnline() ? ChatColor.GREEN : ChatColor.RED) + player.getName());
                headMeta.setLore(Collections.singletonList(ChatColor.AQUA + "Reports: " + reports.size()));
                headMeta.setOwningPlayer(player);
                head.setItemMeta(headMeta);

                outlinePane.addItem(new GuiItem(head, event -> {
                    HumanEntity clicker = event.getWhoClicked();

                    if (event.isLeftClick()) {
                        playerReportsGui(player).show(clicker);
                    } else if (event.isRightClick()) {
                        new ConfirmationMenu(ChatColor.GREEN +
                            "Delete all reports for " + player.getName() + '?', click ->
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (click == ConfirmationMenu.Response.ACCEPT) {
                                        Report.delete(reports);

                                        new ReportMenu().show(clicker);
                                    } else if (click == ConfirmationMenu.Response.DENY) {
                                        show(clicker);
                                    } else {
                                        throw new IllegalStateException("Unknown confirmation click type");
                                    }
                                }
                            }.runTaskLater(Main.getInstance(), 1L)).show(clicker);
                    }

                    event.setCancelled(true);
                }));
            }

            paginatedPane.addPane(page, outlinePane);
        }

        addPane(paginatedPane);

        var backItemPane = new OutlinePane(4, 5, 1, 1);

        var backItem = new ItemStack(Material.BOOK);
        var backMeta = backItem.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Close");
        backItem.setItemMeta(backMeta);

        backItemPane.addItem(new GuiItem(backItem, event -> event.getWhoClicked().closeInventory()));

        addPane(backItemPane);

        if (paginatedPane.getPages() > 1) {
            var previousPageItemPane = new OutlinePane(2, 5, 1, 1);
            var nextPageItemPane = new OutlinePane(6, 5, 1, 1);

            var previousPageItem = new ItemStack(Material.SUGAR_CANE);
            var previousPageMeta = previousPageItem.getItemMeta();
            previousPageMeta.setDisplayName(ChatColor.GREEN + "Previous page");
            previousPageItem.setItemMeta(previousPageMeta);

            previousPageItemPane.addItem(new GuiItem(previousPageItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() - 1);

                if (paginatedPane.getPage() == 0) {
                    previousPageItemPane.setVisible(false);
                }

                nextPageItemPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            var nextPageItem = new ItemStack(Material.SUGAR_CANE);
            var nextPageMeta = nextPageItem.getItemMeta();
            nextPageMeta.setDisplayName(ChatColor.GREEN + "Next page");
            nextPageItem.setItemMeta(nextPageMeta);

            nextPageItemPane.addItem(new GuiItem(nextPageItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() + 1);

                if (paginatedPane.getPage() == paginatedPane.getPages() - 1) {
                    nextPageItemPane.setVisible(false);
                }

                previousPageItemPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            addPane(previousPageItemPane);
            addPane(nextPageItemPane);
        }
    }

    /**
     * Creates a reports gui where the reports are for the specified player.
     *
     * @param player the reportee of the reports gui
     * @return the gui created
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    private ChestGui playerReportsGui(@NotNull OfflinePlayer player) {
        ChestGui gui = new ChestGui(6, ChatColor.GREEN + player.getName() + "'s reports");

        var paginatedPane = new PaginatedPane(0, 0, 9, 5);

        int paginatedPaneArea = paginatedPane.getLength() * paginatedPane.getHeight();

        for (int page = 0; page < Math.min(1, Math.ceil((double) Report.getReports(player).size() / paginatedPaneArea)); page++) {
            var outlinePane = new OutlinePane(0, 0, 9, 5);

            for (int i = 0; i < paginatedPaneArea; i++) {
                var index = i + (page * paginatedPaneArea);

                if (index >= Report.getReports(player).size()) {
                    break;
                }

                var report = Report.getReports(player).get(index);

                var reportItem = new ItemStack(Material.PAPER);
                var reportMeta = reportItem.getItemMeta();
                reportMeta.setDisplayName(ChatColor.GOLD + "Report #" + (index + 1));
                reportMeta.setLore(Arrays.asList(
                    ChatColor.AQUA + "By: " + report.getReporter().getName(),
                    ChatColor.AQUA + "At: " + report.getDate().format(DateTimeFormatter.RFC_1123_DATE_TIME)
                ));
                reportItem.setItemMeta(reportMeta);

                outlinePane.addItem(new GuiItem(reportItem, event -> {
                    HumanEntity clicker = event.getWhoClicked();

                    if (event.isLeftClick()) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                try {
                                    var clipboard = report.loadSchematic();

                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            WorldEditPlugin plugin = WorldEditPlugin.getPlugin(WorldEditPlugin.class);
                                            LocalSession session = plugin.getSession((Player) clicker);

                                            session.setClipboard(new ClipboardHolder(clipboard));
                                            clicker.closeInventory();

                                            MessageManager.getInstance().send(clicker, ChatColor.GREEN +
                                                    "The schematic has been copied to your clipboard.");
                                        }
                                    }.runTask(Main.getInstance());
                                } catch (IOException exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }.runTaskAsynchronously(Main.getInstance());
                    } else if (event.isRightClick()) {
                        new ConfirmationMenu(
                            ChatColor.GREEN + "Are you sure you want to delete this report?", click ->
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (click == ConfirmationMenu.Response.ACCEPT) {
                                        Report.delete(report);

                                        playerReportsGui((OfflinePlayer) clicker).show(clicker);
                                    } else if (click == ConfirmationMenu.Response.DENY) {
                                        gui.show(clicker);
                                    } else {
                                        throw new IllegalStateException("Unknown confirmation click type");
                                    }
                                }
                            }.runTaskLater(Main.getInstance(), 1L)).show(clicker);
                    }

                    event.setCancelled(true);
                }));
            }

            paginatedPane.addPane(page, outlinePane);
        }

        gui.addPane(paginatedPane);

        var backItemPane = new OutlinePane(4, 5, 1, 1);

        var backItem = new ItemStack(Material.BOOK);
        var backMeta = backItem.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go back");
        backItem.setItemMeta(backMeta);

        backItemPane.addItem(new GuiItem(backItem, event -> show(event.getWhoClicked())));

        gui.addPane(backItemPane);

        if (paginatedPane.getPages() > 1) {
            var previousPageItemPane = new OutlinePane(2, 5, 1, 1);
            var nextPageItemPane = new OutlinePane(6, 5, 1, 1);

            var previousPageItem = new ItemStack(Material.SUGAR_CANE);
            var previousPageMeta = previousPageItem.getItemMeta();
            previousPageMeta.setDisplayName(ChatColor.GREEN + "Previous page");
            previousPageItem.setItemMeta(previousPageMeta);

            previousPageItemPane.addItem(new GuiItem(previousPageItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() - 1);

                if (paginatedPane.getPage() == 0) {
                    previousPageItemPane.setVisible(false);
                }

                nextPageItemPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            var nextPageItem = new ItemStack(Material.SUGAR_CANE);
            var nextPageMeta = nextPageItem.getItemMeta();
            nextPageMeta.setDisplayName(ChatColor.GREEN + "Next page");
            nextPageItem.setItemMeta(nextPageMeta);

            nextPageItemPane.addItem(new GuiItem(nextPageItem, event -> {
                paginatedPane.setPage(paginatedPane.getPage() + 1);

                if (paginatedPane.getPage() == paginatedPane.getPages() - 1) {
                    nextPageItemPane.setVisible(false);
                }

                previousPageItemPane.setVisible(true);

                update();

                event.setCancelled(true);
            }));

            gui.addPane(previousPageItemPane);
            gui.addPane(nextPageItemPane);
        }

        return gui;
    }
}
