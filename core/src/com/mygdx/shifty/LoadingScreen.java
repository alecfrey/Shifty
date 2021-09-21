package com.mygdx.shifty;

import com.badlogic.gdx.Screen;

<<<<<<< HEAD
/**
 * LoadingScreen class used between title screen and game screen.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class LoadingScreen implements Screen {
	private ShiftyGame parent;

	public LoadingScreen(ShiftyGame screen) {
		parent = screen;
	}

	@Override
	public void show() {

	}

	/**
	 * Changes screen to main menu after application starts
=======
public class LoadingScreen implements Screen{
	private ShiftyGame parent;
	
	public LoadingScreen(ShiftyGame screen) {
		parent = screen;
	}
	
	@Override
	public void show() {
		
	}
	/**
	 * changes screen to main menu after application starts
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void render(float delta) {
		parent.changeScreen(ShiftyGame.MENU);
	}
<<<<<<< HEAD

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
=======
	
	@Override
	public void resize(int width, int height) {
		
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void hide() {
		
	}
	
	@Override
	public void dispose() {
		
	}
}
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
