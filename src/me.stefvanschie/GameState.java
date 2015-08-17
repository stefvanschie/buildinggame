package me.stefvanschie;

import java.util.HashMap;

public enum GameState {

	In_Game(),
	Full(),
	Starting(),
	Waiting();
	
	static HashMap<String, GameState> gameStates = new HashMap<String, GameState>();
	
	public static GameState getState(String arena) {
		return gameStates.get(arena);
	}
	public static void setState(String arena, GameState state) {
		gameStates.put(arena, state);
	}
}
