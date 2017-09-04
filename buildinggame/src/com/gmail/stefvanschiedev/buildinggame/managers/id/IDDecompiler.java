package com.gmail.stefvanschiedev.buildinggame.managers.id;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.ItemBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class is used to turn config.yml strings into ItemStacks/Blocks and use them
 *
 * @since 2.1.0
 */
public final class IDDecompiler {

    /**
     * Constructs a new IDDecompiler. This shouldn't be called to keep this class a singleton.
     */
	private IDDecompiler() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final IDDecompiler INSTANCE = new IDDecompiler();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static IDDecompiler getInstance() {
		return INSTANCE;
	}

	/**
     * Creates an ItemBuilder based on the player and the block provided. The item builder is not registered yet.
     * If you're programming and wish we did register it in this class, because you don't make changes to the returned
     * object anyway, you're using this incorrectly, switch to normal ItemStacks. ItemBuilder should only be used over
     * ItemStack if you either want to disable movement or attach an event to it.
     *
     * @param player the player for whom the item is
     * @param block the CharSequence to parse the ItemBuilder from
     * @return an ItemBuilder or null if the CharSequence was incorrect
     * @see ItemBuilder
     * @since 4.0.6
     */
	@Nullable
    @Contract("_, null -> fail")
    @SuppressWarnings("MethodMayBeStatic")
    public ItemBuilder decompile(Player player, CharSequence block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(block);

		if (matcher.matches()) {
            return new ItemBuilder(player, Material.matchMaterial(matcher.group(1)), 1,
                    matcher.group(2) != null ? Short.parseShort(matcher.group(2).substring(1)) : 0);
        } else {
            Logger logger = Main.getInstance().getLogger();

            logger.warning("Failed to load id '" + block + '\'');
			logger.warning("If you're sure all your ids are right, please contact the plugin developer");
			logger.warning("There will likely be a stracktrace due to this");
		}

		return null;
	}

    /**
     * Creates an ItemStack based on the block provided
     *
     * @param block the CharSequence to parse the ItemBuilder from
     * @return an ItemStack or null if the CharSequence was incorrect
     * @see ItemStack
     * @since 4.0.6
     */
	@Nullable
    @Contract("null -> fail")
    @SuppressWarnings("MethodMayBeStatic")
    public ItemStack decompile(CharSequence block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(block);

		if (matcher.matches()) {
			return new ItemStack(Material.matchMaterial(matcher.group(1)), 1, 
					matcher.group(2) != null ? Short.parseShort(matcher.group(2).substring(1)) : 0);
		} else {
            Logger logger = Main.getInstance().getLogger();

            logger.warning("Failed to load id '" + block + '\'');
			logger.warning("If you're sure all your ids are right, please contact the plugin developer");
			logger.warning("There will likely be a stracktrace due to this");
		}

		return null;
	}

	/**
     * Checks the given string against the provided item for equality
     *
     * @param block the CharSequence to interpret
     * @param item the ItemStack to check the block against
     * @return a boolean indicating the equality of the given parameters
     * @since 4.0.6
     */
	@Contract("null, _ -> fail; _, null -> fail")
	public boolean matches(CharSequence block, ItemStack item) {
		ItemStack itemStack = decompile(block);
		
		return itemStack.getType() == item.getType() && itemStack.getDurability() == item.getDurability();
	}

    /**
     * Checks the given string against the provided block for equality
     *
     * @param item the CharSequence to interpret
     * @param block the Block to check the block against
     * @return a boolean indicating the equality of the given parameters
     * @since 4.0.6
     */
    @Contract("null, _ -> false")
	@SuppressWarnings({"deprecation", "MethodMayBeStatic"})
	public boolean matches(CharSequence item, Block block) {
        Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(item);

        return matcher.matches() && Material.matchMaterial(matcher.group(1)) == block.getType() &&
                (matcher.group(2) == null || Short.parseShort(matcher.group(2).substring(1)) == block.getData());
    }
}