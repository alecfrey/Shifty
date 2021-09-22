package com.mygdx.shifty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppSettings {
	private static final String PREF_MUSIC_VOLUME = "Volume";
	private static final String PREF_SOUND_VOL = "sound";
	private static final String PREFS_NAME = "b2dtut";
	
	protected Preferences getPreferences() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}	
	/**
	 * gets music volume and returns to the caller
	 * @return
	 */
	public float getMusicVolume() {
		return getPreferences().getFloat(PREF_MUSIC_VOLUME, 0.5f);
	}
	
	/**
	 * sets music volume off the slider adjusted in the settings
	 * @param volume
	 */
	public void setMusicVolume(float volume) {
		getPreferences().putFloat(PREF_MUSIC_VOLUME, volume);
		getPreferences().flush();
	}
	
	/**
	 * returns sound volume to caller
	 * @return
	 */
	public float getSoundVolume() {
		return getPreferences().getFloat(PREF_SOUND_VOL, 0.5f);
	}
	
	/**
	 * sets sound volume from settings screen
	 * @param volume
	 */
	public void setSoundVolume(float volume) {
		getPreferences().putFloat(PREF_SOUND_VOL, volume);
		getPreferences().flush();
	}
}
