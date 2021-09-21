package com.mygdx.shifty.entities;

/**
 * EntityType enum used by the player entity.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public enum EntityType {
	/**
	 * Creates player entity named Shifty of given size.
	 */
    PLAYER("shifty", 50, 50, 50);

	/**
	 * Stores EntityType String id.
	 */
    private String id;
    
    /**
     * Stores EntityType width and height.
     */
    private int width, height;
    
    /**
     * Stores EntityType weight.
     */
    private float weight;

    /**
     * Constructs EntityType with given id, width, height, and weight.
     * @param id
     * @param width
     * @param height
     * @param weight
     */
    private EntityType(String id, int width, int height, float weight) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Returns EntityType Id.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Returns EntityType width.
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns EntityType height.
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns EntityType weight.
     * @return
     */
    public float getWeight() {
        return weight;
    }
}