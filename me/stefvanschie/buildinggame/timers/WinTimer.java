package me.stefvanschie.buildinggame.timers;

import me.stefvanschie.buildinggame.timers.utils.Timer;
import me.stefvanschie.buildinggame.utils.arena.Arena;

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
