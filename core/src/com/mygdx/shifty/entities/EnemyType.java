package com.mygdx.shifty.entities;

/**
 * EnemyType enum used by all three enemies.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public enum EnemyType {
	/**
	 * Creates Enemy of given size.
	 */
	ENEMY("Enemy", 50, 50, 50);
	
	/**
	 * Stores EnemyType String id.
	 */
	private String id;
	
	/**
	 * Stores width and height of EnemyType.
	 */
    private int width, height;
    
    /**
     * Stores weight of EnemyType.
     */
    private float weight;

    /**
     * Constructs EnemyType with given id, width, height, and weight.
     * @param id
     * @param width
     * @param height
     * @param weight
     */
    private EnemyType(String id, int width, int height, float weight) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Returns EnemyType Id.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Returns EnemyType width.
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns EnemyType height.
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns EnemyType weight.
     * @return
     */
    public float getWeight() {
        return weight;
    }
}
