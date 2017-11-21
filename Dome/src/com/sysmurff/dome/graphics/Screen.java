package com.sysmurff.dome.graphics;

import java.util.Random;

import com.sysmurff.dome.level.tiles.Tile;

public class Screen {

	// FIELDS
	public int _width, _height;
	public int[] pixels;
	private final int MAP_SIZE = 64;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	// CONSTRUCTOR
	public Screen(int aWidth, int aHeight) {
		this._width = aWidth;
		this._height = aHeight;
		pixels = new int[_width * _height];
		
		for (int i=0; i<MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
			pixels[0] = 0;
		}
	}
	
	public void clear() {
		for (int i=0; i<pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y=0; y<tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x=0; x<tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= _width || ya < 0 || ya >= _width) break;
				if(xa < 0) xa = 0;
				try {
					pixels[xa + ya * _width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				}
				catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}      
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
}
