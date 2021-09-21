package com.mygdx.shifty;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.shifty.world.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.shifty.world.GameMap;
import com.mygdx.shifty.world.TileType;
import com.mygdx.shifty.world.TiledGameMap;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

<<<<<<< HEAD
public class MainScreen extends ApplicationAdapter implements Screen {

	private ShiftyGame parent;

	private Stage stage;

=======
public class MainScreen extends ApplicationAdapter implements Screen{
	
	private ShiftyGame parent;
	
	private Stage stage;
	
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	private Texture player;
	private Music music;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Viewport viewport;
	private GameMap gameMap;
<<<<<<< HEAD

	/**
	 * Constructs Screen that holds the game and is used by the Shifty class to
	 * change screens
	 * 
=======
	
	/**
	 * Constructs Screen that holds the game and is used by the Shifty class to change screens
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 * @param screen
	 */
	public MainScreen(ShiftyGame screen) {
		parent = screen;
<<<<<<< HEAD
		// create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
	}

	@Override
	public void create() {
	}

	/**
	 * Renders the screen and camera so game will show on screen
	 */
	@Override
	public void render(float delta) {

		// clear screen and ready for next set of images to be drawn
		// Values to clear screen with
		// Red, green, blue, and alpha (transparency)
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(camera, batch);

		// tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		stage.draw();
	}

	@Override
	public void render() {
	}

	/**
	 * Gets rid of the music, player, and entities when game closes
	 */
	@Override
	public void dispose() {
=======
		//create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
	}
	
	@Override
	public void create () {	

	}
	/**
	 * renders the screen and camera so game will show on screen
	 */
	@Override
	public void render(float delta) {
		
		//clear screen and ready for next set of images to be drawn
		// Values to clear screen with 
		// Red, green, blue, and alpha (transparency)
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		
		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(camera, batch);
		
		//tell stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
		stage.draw();
	}
	@Override
	public void render () {
		

	}
	/**
	 * Gets rid of the music, player, and entities when game closes 
	 */
	@Override
	public void dispose () {
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
		music.dispose();
		player.dispose();
		batch.dispose();
	}
<<<<<<< HEAD

	/**
	 * Projects game onto screen for user to see
=======
	
	/**
	 * projects game onto screen for user to see
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	 */
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
<<<<<<< HEAD

		camera = new OrthographicCamera();

		batch = new SpriteBatch();

		gameMap = new TiledGameMap();

		viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// load music
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/retro.mp3"));

=======
		
		camera = new OrthographicCamera();
		
		batch = new SpriteBatch();
		
		gameMap = new TiledGameMap();
		
		viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// load music
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/retro.mp3"));
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
		// start playing background music
		music.setLooping(true);
		music.setVolume(parent.getPreferences().getMusicVolume());
		music.play();
<<<<<<< HEAD

		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		stage.clear();
=======
		
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		stage.clear();
		
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
	}

	@Override
	public void hide() {
<<<<<<< HEAD
	}
}
=======
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> c38133729d121c25fe36687fd48987b5320cd1f1
