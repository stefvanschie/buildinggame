package com.gmail.stefvanschiedev.buildinggame.managers.softdependencies;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class SDVault {

	private SDVault() {}
	
	private static final SDVault INSTANCE = new SDVault();
	private static Economy econ;
	private boolean enabled = false;
	
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
	
	private boolean setupEconomy() {
		if (Main.getInstance().getServer().getPluginManager().getPlugin("Vault") == null)
			return false;
		RegisteredServiceProvider<Economy> rsp = Main.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null)
			return false;
		econ = rsp.getProvider();
		return econ != null;
	}
    
	public Economy getEconomy() {
		return econ;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
