/* Thanks to crolemol
 * Bukkit's user account: https://bukkit.org/members/crolemol.90797144/
 */
package com.gmail.stefvanschiedev.buildinggame.utils.nbt.item;

import java.lang.reflect.Field;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;

/**
 * Utility class for assigning URLs to head items
 *
 * @since 2.1.0
 */
@SuppressWarnings("UtilityClassCanBeEnum")
public final class SkullItem {

    /**
     * Private constructor to keep this class an utility class
     */
    private SkullItem() {}

    /**
     * Returns a head item with the URL assigned to it
     *
     * @param skinURL the URL to use for this head
     * @return the head with the URL assigned
     * @since 2.1.0
     */
    @Contract(value = "null -> fail", pure = true)
    @SuppressWarnings("ConstantConditions")
    public static ItemStack getSkull(String skinURL) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        if(skinURL.isEmpty()) {
        	return head;
        }
        
        ItemMeta headMeta = head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", skinURL).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        
        profileField.setAccessible(true);
        
        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        head.setItemMeta(headMeta);
        return head;
    }
}