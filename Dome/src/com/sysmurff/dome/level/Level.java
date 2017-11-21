package com.sysmurff.dome.level;

import com.sysmurff.dome.graphics.Screen;
import com.sysmurff.dome.level.tiles.Tile;

public class Level {

	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int aWidth, int aHeight) {
		this.width = aWidth;
		this.height = aHeight;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String aPath) {
		loadLevel(aPath);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String aPath) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		// Define the render region of screen
		// i.e. corner pins
		int x0 = xScroll >> 4;							// when move left 
		int x1 = (xScroll + screen._width+16) >> 4;	// when move right
		int y0 = yScroll >> 4;							// when move up
		int y1 = (yScroll + screen._height) >> 4;	// when move down
			
		for (int y=y0; y<y1; y++) {
			for (int x=x0; x<x1; x++) {
				getTile(x,y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x + y * width] == 0) return Tile.grass;
		if(tiles[x + y * width] == 1) return Tile.stone;
		if(tiles[x + y * width] == 2) return Tile.water;
		return Tile.water;
	}
}
