package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class WinTimer extends Timer {

	private Arena arena;
	private boolean running = false;
	private int seconds;
	
	public WinTimer(int seconds, Arena arena) {
		this.arena = arena;
		this.seconds = seconds;
	}
	
	@Override
	public void run() {
		if (!isActive())
			running = true;
		if (seconds <= 0) {
			arena.stop();
			running = false;
			this.cancel();
			return;
		}
		seconds--;
	}

	@Override
	public int getSeconds() {
		return seconds;
	}

	@Override
	public boolean isActive() {
		return running;
	}

	@Override
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}