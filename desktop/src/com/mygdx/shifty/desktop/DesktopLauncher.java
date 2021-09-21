package com.mygdx.shifty.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.shifty.ShiftyGame;

/**
 * The DesktopLauncher class simply launches the game with the given width and height.
 * It also sets the FPS limit and title of the game that appears on the game window.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 0; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 0; // Setting to 0 disables background fps throttling
		
		config.title = "Shifty";
		
		config.width = 800;
		config.height = 608;
		
		new LwjglApplication(new ShiftyGame(), config);
	}
}
