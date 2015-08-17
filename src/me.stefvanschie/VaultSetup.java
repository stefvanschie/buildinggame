package me.stefvanschie;

import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class VaultSetup {

	private BuildingGame main;
	private Economy econ = null;
	
	public VaultSetup(BuildingGame main, Economy econ) {
		this.main = main;
		this.econ = econ;
	}
	
	public Economy setup() {
		if (!setupEconomy()) {
			main.getLogger().info("Disabled Vault");
			return null;
		}
		return econ;
	}
	
	private boolean setupEconomy() {
		if (main.getServer().getPluginManager().getPlugin("Vault") == null)
			return false;
		RegisteredServiceProvider<Economy> rsp = main.getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null)
			return false;
		econ = rsp.getProvider();
		return econ != null;
	}
	
}
