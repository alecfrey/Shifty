package com.mygdx.shifty.entities;

import com.mygdx.shifty.world.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract class EnemyEntity for Enemy1.
 * Contains all the movement for Enemy1.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 * 
 */
public abstract class EnemyEntity {
	/**
	 * Stores Vector pos for EnemyEntity.
	 */
	protected Vector2 pos;
	
	/**
	 * Stores EnemyType for EnemyEntity.
	 */
    protected EnemyType type;
    
    /**
     * Stores Gamemap map for EnemyEntity.
     */
    protected GameMap map;
    
    /**
     * Constructs an EnemyEntity with given x and y coordinations, EnemyType, and GameMap.
     * @param x
     * @param y
     * @param type
     * @param map
     */
	public EnemyEntity(float x, float y, EnemyType type, GameMap map) {
		this.pos = new Vector2(x, y);
		this.type = type;
		this.map = map;
	}
	
	/**
	 * Updates EnemyEntity.
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
	 * Switches direction of Enemy 1 movement whenever it reaches the end of the platform it's on.
	 * If the player collides with Enemy 1, the player is reset at the start.
	 * @param amount
	 */
    protected void moveX(float amount) {
    	float newX = this.pos.x + amount;

    	if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight())) {
    		this.pos.x = newX;
    	} else {
    		Enemy.turnAround();
    	}
    	
    	if (newX >= 620) {
    		Enemy.turnAround();
    	}
    	
    	int enemyXMax = (int)newX + 17;
    	int enemyXMin = (int)newX - 17;
    	
    	int enemyYMax = (int)getY() + 17;
    	int enemyYMin = (int)getY() - 17;

    	if ((enemyXMax > (int)Entity.getX() && enemyXMin < (int)Entity.getX()) && (enemyYMax > (int)Entity.getY() && enemyYMin < (int)Entity.getY())) {
			Player.setLocation(125, 65);
    	}
    	
    }
    
    /**
     * Returns the Vector2 pos for Enemy1.
     * @return
     */
    public Vector2 getPos() {
        return pos;
    }

    /**
     * Returns the EnemyType for Enemy1.
     * @return
     */
    public EnemyType getType() {
        return type;
    }

    /**
     * Returns the x coordinate of Enemy1.
     * @return
     */
    public float getX() {
        return pos.x;
    }

    /**
     * Returns the y coordinate of Enemy1.
     * @return
     */
    public float getY() {
        return pos.y;
    }

    /**
     * Returns the width of Enemy1.
     * @return
     */
    public int getWidth() {
        return type.getWidth();
    }

    /**
     * Returns the height of Enemy1.
     * @return
     */
    public int getHeight() {
        return type.getHeight();
    }

    /**
     * Returns the weight of Enemy1.
     * @return
     */
    public float getWeight() {
        return type.getWeight();
    }
}
