package com.mygdx.shifty.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * TiledGameMap class that extends GameMap
 * Overrides methods from GameMap and implemented the abstract methods.
 * 
 * @author Alec Frey, Tyler Atkinson, Nathan Cook
 *
 */
public class TiledGameMap extends GameMap {

	/**
	 * Stores TiledMap.
	 */
	private TiledMap tiledMap;
	
	/**
	 * Stores OrthogonalTiledMapRenderer.
	 */
	private OrthogonalTiledMapRenderer tiledMapRenderer;
	
	/**
	 * Constructs the TiledGameMap.
	 * Initializes the tiledMap with the game map tiled file, and initializes the tiledMapRenderer using the tileMap.
	 */
	public TiledGameMap() {
		tiledMap = new TmxMapLoader().load("shiftymap_correctresolution.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

	}

	/**
	 * Renders the tiledMapRenderer.
	 */
	@Override
	public void render(OrthographicCamera cam, SpriteBatch batch) {
		tiledMapRenderer.setView(cam);
		tiledMapRenderer.render();
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		super.render(cam, batch);
		batch.end();
	}

	/**
	 * Updates entities using super class and given delta.
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
	}

	/**
	 * Disposes tiledMap.
	 */
	@Override
	public void dispose() {
		tiledMap.dispose();
	}

	/**
	 * Returns tile type with given layer and col and row.
	 * Returns null if not found.
	 */
	@Override
	public TileType getTileTypeByCoordinate(int layer, int col, int row) {
		Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(col, row);
		
		if (cell != null) {
			TiledMapTile tile = cell.getTile();
			if (tile != null) {
				int id = tile.getId();
				return TileType.getTileTypeById(id);
			}
		}
		return null;
	}

	/**
	 * Returns width of tiled map layer.
	 */
	@Override
	public int getWidth() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
	}

	/**
	 * Returns height of tiled map layer.
	 */
	@Override
	public int getHeight() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
	}

	/**
	 * Returns number of layers in tiled map.
	 */
	@Override
	public int getLayers() {
		return tiledMap.getLayers().getCount();
	}

}
