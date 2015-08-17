package me.stefvanschie;

public class VersionSetup {
	
	public static void setup() {
		BuildingGame.main.getDescription().getVersion();
		switch (BuildingGame.main.config.getString("version")) {
			case "0.12.1":
				BuildingGame.main.config.set("money.first", 20);
				BuildingGame.main.config.set("money.second", 10);
				BuildingGame.main.config.set("money.third", 5);
				break;
			default:
				break;
		}
	}
	
}
