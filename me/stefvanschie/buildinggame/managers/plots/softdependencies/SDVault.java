package me.stefvanschie.buildinggame.managers.softdependencies;

import me.stefvanschie.buildinggame.Main;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

public class SDVault {

	public SDVault() {}
	
	public static SDVault instance = new SDVault();
	public static Economy econ;
	public boolean enabled = false;
	
	public static SDVault getInstance() {
		return instance;
	}
	
	public Economy setup() {
		if (!setupEconomy()) {
			Main.getInstance().getLogger().info("Disabled Vault");
			return null;
		}
		enabled = true;
		return econ;
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
		
	public Economy getVault() {
		return econ;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
