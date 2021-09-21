package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract class Entity for Player.
 * Contains all the movement for Player.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public abstract class Entity {
	/**
	 * Stores Vector pos for Entity.
	 */
    protected static Vector2 pos;
    
    /**
	 * Stores EnemyType for Entity.
	 */
    protected static EntityType type;
    
    /**
     * Stores player y velocity.
     */
    protected float velocityY = 0;
    
    /**
     * Stores Gamemap map for Entity.
     */
    protected GameMap map;
    
    /**
     * Stores whether player is grounded.
     */
    protected boolean grounded = false;

    /**
     * Constructs a player entity with given x and y coordinates, an EntityType, and GameMap.
     * @param x
     * @param y
     * @param type
     * @param map
     */
    public Entity(float x, float y, EntityType type, GameMap map) {
        this.pos = new Vector2(x, y);
        this.type = type;
        this.map = map;
    }

    /**
     * Updates player entity velocity.
     * @param deltaTime
     * @param gravity
     */
    public void update(float deltaTime, float gravity) {
    	float newY = pos.y;
    	
    	this.velocityY += gravity * deltaTime * getWeight();
    	newY += this.velocityY * deltaTime;
    	
    	if (map.doesRectCollideWithMap(pos.x, newY, getWidth(), getHeight())) {
    		if (velocityY < 0) {
    			this.pos.y = (float) Math.floor(pos.y);
    			grounded = true;
    		}
    		this.velocityY = 0;
    	}
    	else {
    		this.pos.y = newY;
    		grounded = false;
    	}
    }

    /**
     * Abstract method to render SpriteBatch.
     * @param batch
     */
    public abstract void render(SpriteBatch batch);

    /**
     * Controls the x movement of Player.
     * @param amount
     */
    protected void moveX(float amount) {
    	float newX = this.pos.x + amount;
    	if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight())) {
    		this.pos.x = newX;
    	}
    }

    /**
     * Returns the Vector2 pos for Player.
     * @return
     */
    public Vector2 getPos() {
        return pos;
    }

    /**
     * Returns the EnemyType for Player.
     * @return
     */
    public EntityType getType() {
        return type;
    }

    /**
     * Returns the x coordinate of Player.
     * @return
     */
    public static float getX() {
        return pos.x;
    }

    /**
     * Returns the y coordinate of Player.
     * @return
     */
    public static float getY() {
        return pos.y;
    }

    /**
     * Returns whether Player is grounded or not.
     * @return
     */
    public boolean isGrounded() {
        return grounded;
    }

    /**
     * Returns the width of Player.
     * @return
     */
    public static int getWidth() {
        return type.getWidth();
    }

    /**
     * Returns the height of Player.
     * @return
     */
    public static int getHeight() {
        return type.getHeight();
    }

    /**
     * Returns the weight of Player.
     * @return
     */
    public float getWeight() {
        return type.getWeight();
    }
}