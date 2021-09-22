package com.mygdx.shifty;

import com.badlogic.gdx.Game;

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
				}	
			}
	/**
	 * creates loading screen and preferences on startup
	 */
	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		
		preferences = new AppSettings();
	}
	
	/**
	 * called by other classes to get preferences from AppSettings
	 * @return
	 */
	public AppSettings getPreferences() {
		return this.preferences;
	}
}
