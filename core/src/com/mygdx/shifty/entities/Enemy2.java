package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The Enemy class creates the second enemy.
 * The Enemy texture, movement, and animations are described below.
 * 
 * The Enemy2 class extends EnemyEntity2.
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class Enemy2 extends EnemyEntity2 {
	/**
	 * Stores Enemy 2 speed.
	 */
	public static int SPEED = 60;
	
	/**
	 * Stores Enemy 2 animations.
	 */
	private Animation<TextureRegion> animation;
	
	/**
	 * Stores the texture atlas for Enemy 2.
	 */
	private TextureAtlas textureAtlas;
	
	/**
	 * Stores time needed for animation of Enemy 2.
	 */
	private float elapsedTime = 0;

	/**
	 * Constructs Enemy 2 with the given x and y coordinates and the game map, using the super class.
	 * @param x
	 * @param y
	 * @param map
	 */
	public Enemy2(float x, float y, GameMap map) {
		super(x, y, EnemyType.ENEMY, map);
	}
	
	/**
	 * Updates the movement of Enemy 2.
	 */
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		moveX(SPEED * deltaTime);
	}
	
	/**
	 * Renders the animations of Enemy 2.
	 */
	@Override
	public void render(SpriteBatch batch) {
		if (SPEED > 0) {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy2/Centipede_walk_right.atlas"));
			animation = new Animation<TextureRegion>(1/5f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		} else {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy2/Centipede_walk_left.atlas"));
			animation = new Animation<TextureRegion>(1/5f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		}
	}
	
	/**
	 * Changes the direction of Enemy 2.
	 * @return -SPEED
	 */
	public static int turnAround() {
		return SPEED = -SPEED;
	}
}
