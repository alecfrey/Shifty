package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract class EnemyEntity2 for Enemy2.
 * Contains all the movement for Enemy2.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 * 
 */
public abstract class EnemyEntity2 {
	/**
	 * Stores Vector pos for EnemyEntity2.
	 */
	protected Vector2 pos;
	
	/**
	 * Stores EnemyType for EnemyEntity2.
	 */
    protected EnemyType type;
    
    /**
     * Stores Gamemap map for EnemyEntity2.
     */
    protected GameMap map;
    
    /**
     * Constructs an EnemyEntity2 with given x and y coordinations, EnemyType, and GameMap.
     * @param x
     * @param y
     * @param type
     * @param map
     */
	public EnemyEntity2(float x, float y, EnemyType type, GameMap map) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map;
	}
	
	/**
	 * Updates EnemyEntity2.
	 * @param deltaTime
	 */
	public void update(float deltaTime) {}
	
	/**
	 * Abstract method to be implemented by subclass to render SpriteBatch.
	 * @param batch
	 */
	public abstract void render(SpriteBatch batch);

	/**
	 * Controls all the movement along the x direction for the Enemy.
	 * Switches direction of Enemy 2 movement whenever it reaches the end of the platform it's on.
	 * If the player collides with Enemy 2, the player is reset at the start.
	 * @param amount
	 */
    protected void moveX(float amount) {
    	float newX = this.pos.x + amount;

    	if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight())) {
    		this.pos.x = newX;
    	}
    	
    	if (newX >= 304) {
    		Enemy2.turnAround();
    	}
    	
    	if (newX <= 210) {
    		Enemy2.turnAround();
    	}
    	
    	int enemyXMax = (int)newX + 20;
    	int enemyXMin = (int)newX - 20;
    	
    	int enemyYMax = (int)getY() + 20;
    	int enemyYMin = (int)getY() - 20;

    	if ((enemyXMax > (int)Entity.getX() && enemyXMin < (int)Entity.getX()) && (enemyYMax > (int)Entity.getY() && enemyYMin < (int)Entity.getY())) {
			Player.setLocation(125, 65);
    	}
    }

    /**
     * Returns the Vector2 pos for Enemy2.
     * @return
     */
    public Vector2 getPos() {
        return pos;
    }
    
    /**
     * Returns the EnemyType for Enemy2.
     * @return
     */
    public EnemyType getType() {
        return type;
    }

    /**
     * Returns the x coordinate of Enemy2.
     * @return
     */
    public float getX() {
        return pos.x;
    }

    /**
     * Returns the y coordinate of Enemy2.
     * @return
     */
    public float getY() {
        return pos.y;
    }

    /**
     * Returns the width of Enemy2.
     * @return
     */
    public int getWidth() {
        return type.getWidth();
    }
    
    /**
     * Returns the height of Enemy2.
     * @return
     */
    public int getHeight() {
        return type.getHeight();
    }

    /**
     * Returns the weight of Enemy2.
     * @return
     */
    public float getWeight() {
        return type.getWeight();
    }
}
