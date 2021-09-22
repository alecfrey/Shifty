package com.mygdx.shifty;

import com.badlogic.gdx.Screen;

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
	 */
	@Override
	public void render(float delta) {
		parent.changeScreen(ShiftyGame.MENU);
	}
	
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
