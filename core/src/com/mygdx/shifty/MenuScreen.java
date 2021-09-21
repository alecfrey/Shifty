package com.mygdx.shifty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

<<<<<<< HEAD
public class MenuScreen implements Screen {

	private ShiftyGame parent;
	private Stage stage;
	private Texture background;

	/**
	 * Creates MenuScreen instance for Shifty class
	 * 
=======

public class MenuScreen implements Screen{
	
	private ShiftyGame parent;
	private Stage stage;
	private Texture background;
	
	/**
	 * creates MenuScreen instance for Shifty class
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @param screen
	 */
	public MenuScreen(ShiftyGame screen) {
		parent = screen;
<<<<<<< HEAD

		// create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
	}

	/**
	 * Builds UI for the menu screen, has table with a new game button, a settings
	 * button, and an exit button
=======
		
		//create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
	}
	
	/**
	 * Builds UI for the menu screen, has table with a new game button, a settings button, and an exit button
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
<<<<<<< HEAD
		// Creates table that fills the screen. Everything else will go inside table
		Table table = new Table();
		table.setFillParent(true);
		// table.setDebug(true);
		stage.addActor(table);

		// temp till asset manager
		Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));

		// buttons for menu
		TextButton newGame = new TextButton("New Game", skin);
		TextButton settings = new TextButton("Settings", skin);
		TextButton exit = new TextButton("Exit", skin);

		// buttons added to table
		table.add(newGame).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(settings).fillX().uniformX();
		table.row();
		table.add(exit).fillX().uniformX();

		// button listeners
=======
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
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
		settings.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ShiftyGame.SETTINGS);
			}
<<<<<<< HEAD

=======
			
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
		});
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ShiftyGame.MAINSCREEN);
			}
<<<<<<< HEAD
		});
	}

	/**
	 * Renders screen for user to see
	 */
	@Override
	public void render(float delta) {
		// clear screen and ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		background = new Texture(Gdx.files.internal("Background/Background/Background.png"));
		stage.draw();
	}

	/**
	 * Updates screen when resized
=======
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
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
<<<<<<< HEAD

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

=======
	
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
	
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	@Override
	public void dispose() {
		// dispose of assets when not needed anymore
		stage.dispose();
	}
<<<<<<< HEAD
}
=======
}

>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
