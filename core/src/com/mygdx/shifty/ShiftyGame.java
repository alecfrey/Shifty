package com.mygdx.shifty;

import com.badlogic.gdx.Game;

<<<<<<< HEAD
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * The ShiftyGame class creates and renders the backbone of the game.
 * The player texture is created and rendered, along with the game map, and background music.
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
import com.badlogic.gdx.Game;

=======
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
public class ShiftyGame extends Game {
	private AppSettings preferences;
	private LoadingScreen loadingScreen;
	private SettingsScreen settingsScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	
	public final static int MENU = 0;
	public final static int SETTINGS = 1;
	public final static int MAINSCREEN= 2;
	public final static int ENDGAME = 3;
	
	/**
	 * Constructor controls which screen is running and when. Used by other screens to change screen
	 * @param screen
	 */
	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
					this.setScreen(menuScreen);
					break;
			case SETTINGS:
				if(settingsScreen == null) settingsScreen = new SettingsScreen(this);
					this.setScreen(settingsScreen);
					break;
			case MAINSCREEN:
				if(mainScreen == null) mainScreen = new MainScreen(this);
					this.setScreen(mainScreen);
					break;
<<<<<<< HEAD
		}	
	}
	/**
	 * Creates loading screen and preferences on startup
=======
				}	
			}
	/**
	 * creates loading screen and preferences on startup
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		
		preferences = new AppSettings();
	}
	
	/**
<<<<<<< HEAD
	 * Called by other classes to get preferences from AppSettings
=======
	 * called by other classes to get preferences from AppSettings
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @return
	 */
	public AppSettings getPreferences() {
		return this.preferences;
	}

}
