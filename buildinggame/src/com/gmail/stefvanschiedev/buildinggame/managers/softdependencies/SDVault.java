package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles the vault soft dependency
 *
 * @since 2.1.0
 */
public final class SDVault {

    /**
     * Constructs a new SDVault. This shouldn't be called to keep this class a singleton.
     */
	private SDVault() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final SDVault INSTANCE = new SDVault();

	/**
     * The economy provider for this server session
     */
	private static Economy econ;

	/**
     * Whether vault is enabled or not
     */
	private boolean enabled;

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static SDVault getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads Vault
     *
     * @since 2.1.0
     */
	public void setup() {
		if (!setupEconomy()) {
			Main.getInstance().getLogger().info("Disabled Vault");
			return;
		}

		enabled = true;
	}

	/**
     * Loads the registered economy service
     *
     * @since 2.1.0
     */
	private static boolean setupEconomy() {
		if (Main.getInstance().getServer().getPluginManager().getPlugin("Vault") == null)
			return false;

		RegisteredServiceProvider<Economy> rsp = Main.getInstance().getServer().getServicesManager()
                .getRegistration(Economy.class);

		return rsp != null && (econ = rsp.getProvider()) != null;
	}

	/**
     * Returns the current economy service
     *
     * @return the economy
     * @since 2.1.0
     */
	@Nullable
	@Contract(pure = true)
    public static Economy getEconomy() {
		return econ;
	}

	/**
     * Returns whether Vault is enabled or not
     *
     * @return true if Vault is enabled, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
    public boolean isEnabled() {
		return enabled;
	}
}