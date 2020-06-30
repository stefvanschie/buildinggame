package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

/**
 * Checks to settings.yml and messages.yml files to see if anything has changed. If so, it will update the files
 * accordingly.
 *
 * @since 5.8.4
 */
public class FileCheckerTimer extends BukkitRunnable {

    /**
     * The watch service used to listen for file changes
     */
    @Nullable
    private WatchService watchService;

    /**
     * The last time the config.yml and messages.yml were updated as per the modified timestamp on the file
     */
    private long configLastModified = Long.MIN_VALUE, messagesLastModified = Long.MIN_VALUE;

    /**
     * The settings manager instance
     */
    @NotNull
    private static final SettingsManager SETTINGS_MANAGER = SettingsManager.getInstance();

    /**
     * The logger for this plugin
     */
    @NotNull
    private static final Logger LOGGER = Main.getInstance().getLogger();

    /**
     * Will construct a new timer which will check for files
     */
    public FileCheckerTimer() {
        try {
            watchService = FileSystems.getDefault().newWatchService();

            Main.getInstance().getDataFolder().toPath().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        WatchKey key = watchService.poll();

        if (key == null)
            return;

        key.pollEvents().forEach(event -> {
            Path context = (Path) event.context();
            boolean debug = SETTINGS_MANAGER.getConfig().getBoolean("debug");
            long lastModified = Main.getInstance().getDataFolder().toPath().resolve(context).toFile().lastModified();

            if (context.endsWith("config.yml")) {
                if (lastModified <= this.configLastModified) {
                    return;
                }

                if (debug)
                    LOGGER.info("Detected changes in the config.yml");

                SETTINGS_MANAGER.refreshConfig();

                this.configLastModified = lastModified;
            } else if (context.endsWith("messages.yml")) {
                if (lastModified <= this.messagesLastModified) {
                    return;
                }

                if (debug)
                    LOGGER.info("Detected changes in the messages.yml");

                SETTINGS_MANAGER.refreshMessages();

                this.messagesLastModified = lastModified;
            }
        });

        key.reset();
    }
}
