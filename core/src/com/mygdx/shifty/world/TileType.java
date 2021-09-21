package com.mygdx.shifty.world;

import java.util.HashMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;

/**
 * TileType enum used by tiled game map.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public enum TileType {

	/**
	 * Start platform tile id that is collidable.
	 */
	Start(182, true, "Starting Platform"),
	
	/**
	 * Start platform tile id that is collidable.
	 */
	RightStartBlock(183, true, "Right corner of Starting Platform"),

	/**
	 * First platform tile id that is collidable.
	 */
	FirstPlatform(211, true, "First Platform Jump"),
	
	/**
	 * Second platform tile id that is collidable.
	 */
	SecondPlatform(187, true, "Second Platform Jump"),
	
	/**
	 * Pillar platform tile id that is collidable.
	 */
	Slope(181, true, "First slope"),
	
	/**
	 * Leaf platform tile id that is collidable.
	 */
	LeafPlatform(189, true, "Leaf platform on right"),
	
	/**
	 * Middle Chest Obstacle tile id that is collidable.
	 */
	MiddleChestObstacle2(191, true, "Middle Chest Obstacle 2"),
	
	/**
	 * Middle Chest Obstacle tile id that is collidable.
	 */
	MiddleChestObstacle3(203, true, "Middle Chest Obstacle 3"),
	
	/**
	 * Middle Chest Obstacle tile id that is collidable.
	 */
	MiddleChestObstacle4(193, true, "Middle Chest Obstacle 4"),
	
	/**
	 * Chest platform tile id that is collidable.
	 */
	ChestPlatform(212, true, "Chest  Platform"),
	
	/**
	 * Chest platform tile id that is collidable.
	 */
	ChestPlatform2(213, true, "Chest  Platform"),
	
	/**
	 * Chest platform tile id that is collidable.
	 */
	ChestPlatform3(214, true, "Chest  Platform");
	
	/**
	 * Stores constant tile size.
	 */
	public static final int TILE_SIZE = 32;
	
	/**
	 * Stores tile id.
	 */
	private int id;
	
	/**
	 * Stores whether tile is collidable or not.
	 */
	private boolean collidable;
	
	/**
	 * Stores name of tile.
	 */
	private String name;
	
	/**
	 * Stores damage.
	 */
	private float damage;
	
	/**
	 * Constructs TileType with given id, collidable boolean, and name.
	 * @param id
	 * @param collidable
	 * @param name
	 */
	private TileType(int id, boolean collidable, String name) {
		this(id, collidable, name, 0);
	}
	
	/**
	 * Constructs TileType with given id, collidable boolean, name, and damage.
	 * @param id
	 * @param collidable
	 * @param name
	 * @param damage
	 */
	private TileType(int id, boolean collidable, String name, float damage) {
		this.id = id;
		this.collidable = collidable;
		this.name = name;
		
		this.damage = damage;
	}

	/**
	 * Returns TileType id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Stores whether TileType is collidable or not.
	 * @return
	 */
	public boolean isCollidable() {
		return collidable;
	}

	/**
	 * Returns name of TileType.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns damage of TileType if applicable.
	 * @return
	 */
	public float getDamage() {
		return damage;
	}
	
	/**
	 * Creates new HashMap arraylist and fills it with tile type id and tile types.
	 * Integer = key
	 * TileType = value
	 */
	private static HashMap<Integer, TileType> tileMap;
	
	static {
		tileMap = new HashMap<Integer, TileType>();
		for (TileType tileType : TileType.values()) {
			tileMap.put(tileType.getId(), tileType);
		}
	}
	
	/**
	 * Returns TileType with given id.
	 * @param id
	 * @return
	 */
	public static TileType getTileTypeById(int id) {
		return tileMap.get(id);
	}
}
