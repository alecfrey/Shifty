package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The Player class creates the player entity.
 * The Player texture, movement, and animations are described below.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class Player extends Entity {
	
	/**
	 * Stores speed of player.
	 */
	public static int SPEED = 95;
	
	/**
	 * Stores jump velocity of player.
	 */
	private static final double JUMP_VELOCITY = 4.9;
	
	/**
	 * Stores player texture.
	 */
	private Texture image;
	
	/**
	 * Stores arraylist of texture region for player animation.
	 */
	private Animation<TextureRegion> animation;
	
	/**
	 * Stores texture atlas.
	 */
	private TextureAtlas textureAtlas;
	
	/**
	 * Stores elapsed time for animations.
	 */
	private float elapsedTime = 0;
	
	/**
	 * Stores whether player is facing right or not.
	 */
	private static boolean isFacingRight = true;
	
	/**
	 * Constructs Player with given x and y coordinations, and the game map.
	 * @param x
	 * @param y
	 * @param map
	 */
	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("Player/Woodcutter/Woodcutter.png");
	}
	
	/**
	 * Updates the position of the player based on which key is pressed.
	 * Uses WASD keys and moves in appropriate direction.
	 */
	@Override
	public void update(float deltaTime, float gravity) {
		if (Gdx.input.isKeyPressed(Keys.SPACE) && grounded) {
			this.velocityY += JUMP_VELOCITY * getWeight();
		} else if (Gdx.input.isKeyPressed(Keys.SPACE) && !grounded && this.velocityY > 0) {
			this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
		}
		
		super.update(deltaTime, gravity);
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			moveX(-SPEED * deltaTime);
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			moveX(SPEED * deltaTime);
		}
	}

	/**
	 * Player is rendered using animations for each different direction the player may move in.
	 */
	@Override
	public void render(SpriteBatch batch) {		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			isFacingRight = true;
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Shifty/Woodcutter_runRight.atlas"));
			animation = new Animation<TextureRegion>(1/12f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		}
		
		else if (Gdx.input.isKeyPressed(Keys.A)) {
			isFacingRight = false;
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Shifty/Woodcutter_runLeft.atlas"));
			animation = new Animation<TextureRegion>(1/12f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		}
		
		else if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if(isFacingRight == true) {
				textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Shifty/Woodcutter_jumpRight.atlas"));
				animation = new Animation<TextureRegion>(1/12f, textureAtlas.getRegions());
				elapsedTime += Gdx.graphics.getDeltaTime();
				batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
			} else {
				textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Shifty/Woodcutter_jumpLeft.atlas"));
				animation = new Animation<TextureRegion>(1/12f, textureAtlas.getRegions());
				elapsedTime += Gdx.graphics.getDeltaTime();
				batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
			}
		}
			 
		
		else {
			if (isFacingRight == true) {
				image = new Texture(Gdx.files.internal("Player/Woodcutter/Woodcutter.png"));
				batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
			} else {
				image = new Texture(Gdx.files.internal("Player/Woodcutter/WoodcutterLeft.png"));
				batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
			}
		}
	}

	/**
	 * Set player speed.
	 * @param speed
	 * @return
	 */
	public static int setSpeed(int speed) {
		return SPEED = speed;
	}
	
	/**
	 * Check if player is facing right or not.
	 * @return
	 */
	public static boolean isFacingRight() {
		return isFacingRight;
	}
	
	/**
	 * Set player coordinates on game map.
	 * @param x
	 * @param y
	 */
	public static void setLocation(int x, int y) {
		pos.x = x;
		pos.y = y;
	}

}
