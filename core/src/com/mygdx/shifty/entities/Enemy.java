package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The Enemy class creates the first enemy.
 * The Enemy texture, movement, and animations are described below.
 * 
 * The Enemy class extends EnemyEntity.
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class Enemy extends EnemyEntity {
	/**
	 * Stores Enemy 1 speed.
	 */
	public static int SPEED = 110;
	
	/**
	 * Stores Enemy 1 animations.
	 */
	private Animation<TextureRegion> animation;
	
	/**
	 * Stores the texture atlas for Enemy 1.
	 */
	private TextureAtlas textureAtlas;
	
	/**
	 * Stores time needed for animation of Enemy 1.
	 */
	private float elapsedTime = 0;

	/**
	 * Constructs Enemy 1 with the given x and y coordinates and the game map, using the super class.
	 * @param x
	 * @param y
	 * @param map
	 */
	public Enemy(float x, float y, GameMap map) {
		super(x, y, EnemyType.ENEMY, map);
	}
	
	/**
	 * Updates the movement of Enemy 1.
	 */
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		moveX(SPEED * deltaTime);
	}

	/**
	 * Renders the animations of Enemy 1.
	 */
	@Override
	public void render(SpriteBatch batch) {
		if (SPEED > 0) {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy1/Battle_turtle_walk_right.atlas"));
			animation = new Animation<TextureRegion>(1/22f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		} else {
			textureAtlas = new TextureAtlas(Gdx.files.internal("Atlas/Enemy1/Battle_turtle_walk_left.atlas"));
			animation = new Animation<TextureRegion>(1/22f, textureAtlas.getRegions());
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y, getWidth(), getHeight());
		}
	}
	
	/**
	 * Changes the direction of Enemy 1.
	 * @return -SPEED
	 */
	public static int turnAround() {
		return SPEED = -SPEED;
	}
}
