package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;

public final class SDVault {

	private SDVault() {}
	
	private static final SDVault INSTANCE = new SDVault();
	private static Economy econ;
	private boolean enabled;
	
	@Contract(pure = true)
    public static SDVault getInstance() {
		return INSTANCE;
	}
	
	public void setup() {
		if (!setupEconomy()) {
			Main.getInstance().getLogger().info("Disabled Vault");
			return;
		}
		enabled = true;
	}
	
	private static boolean setupEconomy() {
		if (Main.getInstance().getServer().getPluginManager().getPlugin("Vault") == null)
			return false;
		RegisteredServiceProvider<Economy> rsp = Main.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null)
			return false;
		econ = rsp.getProvider();
		return econ != null;
	}
    
	@Contract(pure = true)
    public static Economy getEconomy() {
		return econ;
	}
	
	@Contract(pure = true)
    public boolean isEnabled() {
		return enabled;
	}
}
