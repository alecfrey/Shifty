package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The Enemy class creates the third enemy.
 * The Enemy texture, movement, and animations are described below.
 * 
 * The Enemy3 class extends EnemyEntity3.
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class Enemy3 extends EnemyEntity3 {
	/**
	 * Stores Enemy 3 speed.
	 */
	public static int SPEED = 80;
	
	/**
	 * Stores Enemy 3 animations.
	 */
	private Animation<TextureRegion> animation;
	
	/**
	 * Stores the texture atlas for Enemy 3.
	 */
	private TextureAtlas textureAtlas;
	
	/**
	 * Stores time needed for animation of Enemy 3.
	 */
	private float elapsedTime = 0;

	/**
	 * Constructs Enemy 3 with the given x and y coordinates and the game map, using the super class.
	 * @param x
	 * @param y
	 * @param map
	 */
	public Enemy3(float x, float y, GameMap map) {
		super(x, y, EnemyType.ENEMY, map);
	}
	
	/**
	 * Updates the movement of Enemy 3.
	 */
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		moveX(SPEED * deltaTime);
	}

	/**
	 * Renders the animations of Enemy 3.
	 */
	@Override
	public void render(SpriteBatch batch) {
		if (SPEED > 0) {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy3/Big_bloated_walk_right.atlas"));
			animation = new Animation<TextureRegion>(1/8f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		} else {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy3/Big_bloated_walk_left.atlas"));
			animation = new Animation<TextureRegion>(1/8f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		}
	}
	
	/**
	 * Changes the direction of Enemy 3.
	 * @return -SPEED
	 */
	public static int turnAround() {
		return SPEED = -SPEED;
	}

}
