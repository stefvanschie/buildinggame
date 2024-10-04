package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * A utility class for working with skulls.
 *
 * @since 12.7.1
 */
public class SkullUtil {

    /**
     * A private constructor to prevent instantiation.
     *
     * @since 12.7.1.
     */
    private SkullUtil() {}

    /**
     * Sets the skull of an existing {@link ItemMeta} from the specified id. The id is the value from the
     * textures.minecraft.net website after the last '/' character.
     *
     * @param meta the meta to change
     * @param id the skull id
     * @since 12.7.1
     */
    public static void setSkull(@NotNull ItemMeta meta, @NotNull String id) {
        if (!(meta instanceof SkullMeta skullMeta)) {
            return;
        }

        PlayerProfile playerProfile = Bukkit.createPlayerProfile(UUID.randomUUID());

        PlayerTextures textures = playerProfile.getTextures();

        try {
            textures.setSkin(new URL("https://textures.minecraft.net/texture/" + id));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        playerProfile.setTextures(textures);

        skullMeta.setOwnerProfile(playerProfile);
    }
}
