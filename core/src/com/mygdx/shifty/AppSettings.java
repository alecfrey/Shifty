package com.mygdx.shifty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

<<<<<<< HEAD
/**
 * AppSettings class that configures the settings for Shifty.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
=======
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
public class AppSettings {
	private static final String PREF_MUSIC_VOLUME = "Volume";
	private static final String PREF_SOUND_VOL = "sound";
	private static final String PREFS_NAME = "b2dtut";
<<<<<<< HEAD

	protected Preferences getPreferences() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}

	/**
	 * Gets music volume and returns to the caller
	 * 
=======
	
	protected Preferences getPreferences() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}	
	/**
	 * gets music volume and returns to the caller
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @return
	 */
	public float getMusicVolume() {
		return getPreferences().getFloat(PREF_MUSIC_VOLUME, 0.5f);
	}
<<<<<<< HEAD

	/**
	 * Sets music volume off the slider adjusted in the settings
	 * 
=======
	
	/**
	 * sets music volume off the slider adjusted in the settings
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @param volume
	 */
	public void setMusicVolume(float volume) {
		getPreferences().putFloat(PREF_MUSIC_VOLUME, volume);
		getPreferences().flush();
	}
<<<<<<< HEAD

	/**
	 * Returns sound volume to caller
	 * 
=======
	
	/**
	 * returns sound volume to caller
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @return
	 */
	public float getSoundVolume() {
		return getPreferences().getFloat(PREF_SOUND_VOL, 0.5f);
	}
<<<<<<< HEAD

	/**
	 * Sets sound volume from settings screen
	 * 
=======
	
	/**
	 * sets sound volume from settings screen
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @param volume
	 */
	public void setSoundVolume(float volume) {
		getPreferences().putFloat(PREF_SOUND_VOL, volume);
		getPreferences().flush();
	}
<<<<<<< HEAD
}
=======
	
}
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
