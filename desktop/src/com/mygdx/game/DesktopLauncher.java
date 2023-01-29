package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.FlappyBirdGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowSizeLimits(800, 600, 800, 600);		
		config.setForegroundFPS(60);
		config.setTitle("flappy-bird");
		config.setWindowedMode(800, 600);
		new Lwjgl3Application(new FlappyBirdGame(), config);
	}
}
