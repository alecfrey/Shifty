package com.mygdx.shifty.world;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.shifty.entities.Enemy;
import com.mygdx.shifty.entities.Enemy2;
import com.mygdx.shifty.entities.Enemy3;
import com.mygdx.shifty.entities.EnemyEntity;
import com.mygdx.shifty.entities.EnemyEntity2;
import com.mygdx.shifty.entities.EnemyEntity3;
import com.mygdx.shifty.entities.Entity;
import com.mygdx.shifty.entities.Player;


/**
 * Abstract class GameMap for TiledGameMap.
 * All enemies and player entities are created and their collision with the map is constantly being checked.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public abstract class GameMap {
	
	/**
	 * Stores arraylist of Entity for player.
	 */
	protected ArrayList<Entity> entities;
	
	/**
	 * Stores arraylist of EnemyEntity for the first enemy (turtle).
	 */
	protected ArrayList<EnemyEntity> enemy;
	
	/**
	 * Stores arraylist of EnemyEntity2 for the second enemy (centipede).
	 */
	protected ArrayList<EnemyEntity2> centipede;
	
	/**
	 * Stores arraylist of EnemyEntity3 for the third enemy (bloated).
	 */
	protected ArrayList<EnemyEntity3> bloated;

	/**
	 * Constructs the GameMap and initializes all the entities at their respective locations on the map.
	 */
	public GameMap() {
		entities = new ArrayList<Entity>();
		enemy = new ArrayList<EnemyEntity>();
		centipede = new ArrayList<EnemyEntity2>();
		bloated = new ArrayList<EnemyEntity3>();

		entities.add(new Player(125, 65, this));
		enemy.add(new Enemy(525, 448, this));
		centipede.add(new Enemy2(260, 224, this));
		bloated.add(new Enemy3(570, 128, this));
	}
	
	/**
	 * Renders each entity using given orthographic camera and sprite batch.
	 * @param cam
	 * @param batch
	 */
	public void render (OrthographicCamera cam, SpriteBatch batch) {
		for (Entity entity : entities) {
			entity.render(batch);
		}
		
		for (EnemyEntity EnemyEntity : enemy) {
			EnemyEntity.render(batch);
		}
		
		for (EnemyEntity2 EnemyEntity2 : centipede) {
			EnemyEntity2.render(batch);
		}
		
		for (EnemyEntity3 EnemyEntity3 : bloated) {
			EnemyEntity3.render(batch);
		}
	}
	
	/**
	 * Updates the entity location based on given delta.
	 * @param delta
	 */
	public void update (float delta) {
		for (Entity entity : entities) {
			entity.update(delta, -9.8f);
		}
		
		for (EnemyEntity enemy : enemy) {
			enemy.update(delta);
		}
		
		for (EnemyEntity2 centipede : centipede) {
			centipede.update(delta);
		}
		
		for (EnemyEntity3 bloated : bloated) {
			bloated.update(delta);
		}
	}
	
	/**
	 * Abstract method to be implemented to dispose of objects.
	 */
	public abstract void dispose ();
	
	
	/**
	 * Gets a tile by pixel position within the game world at a specified layer
	 * @param layer
	 * @param x
	 * @param y
	 * @return
	 */
	public TileType getTileTypeByLocation(int layer, float x, float y) {
		return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
	}
	
	/**
	 * Gets a tile at its coordinates within the map at specified layer
	 * @param layer
	 * @param col
	 * @param row
	 * @return
	 */
	public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

	/**
	 * Constantly checks for to see if entities are colliding with map.
	 * If player touches chest box, player increases speed.
	 * If player falls into water, player dies.
	 * If player gets to top of level, player wins.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
		// Allows player to escape max height, triggering winner message
		if (x < 0 || y < 0 || x + width > getPixelWidth()) {
			return true;
		}
		
		for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++ ) {
			for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++ ) {
				for (int layer = 0; layer < getLayers(); layer++) {  
					TileType type = getTileTypeByCoordinate(layer, col, row);
					
					if (y >= 611) {
						System.out.println("Winner!");
						System.exit(0); 
					} else if (y <= 5) {
						Player.setLocation(125, 65);
						Player.setSpeed(95);
						//System.out.println("Loser!");
						//System.exit(0); 
					}
					
					if (type != null && type.isCollidable()) {
						return true;
					}
					
					if ((x > 430 && x < 450) && (y > 0 & y < 50)) {
						System.out.println("Chest box items retrieved!");    
						Player.setSpeed(120);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Abstract method to get width.
	 * @return
	 */
	public abstract int getWidth();
	
	/**
	 * Abstract method to get Height.
	 * @return
	 */
	public abstract int getHeight();
	
	/**
	 * Abstract method to get Layers.
	 * @return
	 */
	public abstract int getLayers();

	/**
	 * Returns pixel width.
	 * @return
	 */
	public int getPixelWidth() {
		return this.getWidth() * TileType.TILE_SIZE;
	}
	
	/**
	 * Returns pixel height.
	 * @return
	 */
	public int getPixelHeight() {
		return this.getHeight() * TileType.TILE_SIZE;
	}	
}
