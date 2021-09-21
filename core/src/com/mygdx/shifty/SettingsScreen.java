package com.mygdx.shifty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Graphics.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.Preferences;

public class SettingsScreen implements Screen{
	private ShiftyGame parent;
	private Stage stage;
	
	private Label titleLabel;
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;
	
	/**
<<<<<<< HEAD
	 * Constructs setting screen, used by Shifty class
=======
	 * makes setting screen, used by Shifty class
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @param screen
	 */
	public SettingsScreen(ShiftyGame screen) {
		parent = screen;
		
		//create stage and set input processor
		stage = new Stage(new ScreenViewport());
	}
	
	/**
	 * Builds UI for settings screen
	 * Has a table with two sliders, a back button, and a title label
	 */
	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		//Create table that fills screen everything will go inside table
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);
		
		//asset add
		Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));

		//volume
		final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
		volumeMusicSlider.setValue( parent.getPreferences().getMusicVolume() );
		volumeMusicSlider.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setMusicVolume( volumeMusicSlider.getValue());
					return false;
			}
		});
			
		final Slider soundSlider = new Slider(0f, 1f, 0.1f, false, skin);
		soundSlider.setValue( parent.getPreferences().getSoundVolume() );
		soundSlider.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setSoundVolume( soundSlider.getValue());
					return false;
			}
		});
		//return to main screen button
		final TextButton backButton = new TextButton("Back", skin);
		//the extra argument set button to smaller version of usual version
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ShiftyGame.MENU);
			}
		});
		
		titleLabel = new Label("Settings", skin);
		volumeMusicLabel = new Label( "Music Volume", skin);
		volumeSoundLabel = new Label( "Sound Volume", skin);
		musicOnOffLabel = new Label( "Music", skin);
		soundOnOffLabel = new Label( "Sound" , skin);
			
		table.add(titleLabel).colspan(2);
		table.row();
		table.add(volumeMusicLabel).left();
		table.add(volumeMusicSlider);
		table.row();
		table.row();
		table.add(volumeSoundLabel).left();
		table.add(soundSlider);
		table.row();
		table.row();
<<<<<<< HEAD
		table.add(backButton).colspan(2);		
	}
	
	/**
	 * Renders stage for the screen to show
=======
		table.add(backButton).colspan(2);
		
			// TODO Auto-generated method stub
		
	}
	/**
	 * renders stage for the screen to show
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void render(float delta) {
		//clear screen and ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f,  0f,  0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
<<<<<<< HEAD
		stage.draw();		
=======
		stage.draw();
		// TODO Auto-generated method stub
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	}

	@Override
	public void resize(int width, int height) {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	}

	@Override
	public void pause() {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	}

	@Override
	public void resume() {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	}

	@Override
	public void hide() {
<<<<<<< HEAD
	}

	@Override
	public void dispose() {		
	}
}
=======
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
