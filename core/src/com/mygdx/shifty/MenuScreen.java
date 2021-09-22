package com.mygdx.shifty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


public class MenuScreen implements Screen{
	
	private ShiftyGame parent;
	private Stage stage;
	private Texture background;
	
	/**
	 * creates MenuScreen instance for Shifty class
	 * @param screen
	 */
	public MenuScreen(ShiftyGame screen) {
		parent = screen;
		
		//create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
	}
	
	/**
	 * Builds UI for the menu screen, has table with a new game button, a settings button, and an exit button
	 */
	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		//Creates table that fills the screen. Everything else will go inside table
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);
		
		//temp till asset manager
		Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
		
		//buttons for menu
		TextButton newGame = new TextButton("New Game", skin);
		TextButton settings = new TextButton("Settings", skin);
		TextButton exit = new TextButton("Exit", skin);
		
		//buttons added to table
		table.add(newGame).fillX().uniformX();
		table.row().pad(10,0,10,0);
		table.add(settings).fillX().uniformX();
		table.row();
		table.add(exit).fillX().uniformX();
		
		//button listeners
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
		
		settings.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ShiftyGame.SETTINGS);
			}
			
		});
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ShiftyGame.MAINSCREEN);
			}
		});	
	}
	
	/**
	 * renders screen for user to see
	 */
	@Override
	public void render(float delta) {
		//clear screen and ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f,  0f,  0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		background = new Texture(Gdx.files.internal("Background/Background/Background.png"));
		stage.draw();
	}
	
	/**
	 * updates screen when resized
	 */
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	@Override
	public void pause() {
		//TODO
	}
	
	@Override
	public void resume() {
		//TODO
	}
	
	@Override
	public void hide() {
		//TODO
	}
	
	@Override
	public void dispose() {
		// dispose of assets when not needed anymore
		stage.dispose();
	}
}
