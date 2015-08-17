package me.stefvanschie;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileCheck {

	public static void check(String path, String setting, YamlConfiguration file, BuildingGame main) {
		if (file.contains(path)) {
			return;
		} else if (!file.contains(path)) {
			file.set(path, setting);
			return;
		}
	}
	public static void check(String path, int setting, YamlConfiguration file) {
		if (file.contains(path)) {
			return;
		} else if (!file.contains(path)) {
			file.set(path, setting);
			return;
		}
	}
	public static void check(String path, boolean setting, YamlConfiguration file) {
		if (file.contains(path)) {
			return;
		} else if (!file.contains(path)) {
			file.set(path, setting);
			return;
		}
	}
	public static void check(String path, List<?> setting, YamlConfiguration file) {
		if (file.contains(path)) {
			return;
		} else if (!file.contains(path)) {
			file.set(path, setting);
			return;
		}
	}
}
