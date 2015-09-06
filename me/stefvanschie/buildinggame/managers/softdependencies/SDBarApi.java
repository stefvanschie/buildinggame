package me.stefvanschie.buildinggame.managers.softdependencies;

public class SDBarApi {

	public SDBarApi() {}
	
	public static SDBarApi instance = new SDBarApi();
	public boolean enabled = false;
	
	public static SDBarApi getInstance() {
		return instance;
	}
	
	public void setup() {
		enabled = true;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
