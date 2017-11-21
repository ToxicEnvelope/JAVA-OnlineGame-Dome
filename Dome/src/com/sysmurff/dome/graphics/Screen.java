package com.sysmurff.dome.graphics;

import java.util.Random;

import com.sysmurff.dome.level.tiles.Tile;

public class Screen {

	// FIELDS
	private int _width, _height;
	public int[] pixels;
	private final int MAP_SIZE = 64;
	//private final int MAP_SIZE_MASK = MAP_SIZE -1;
	
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
	
	public void render(int xOffset, int yOffset) {
		for (int y=0; y<_height; y++) {
			int yp = y +yOffset;
			if(yp < 0 || yp >= _height) continue;
			for (int x=0; x<_width; x++) {
				int xp = x +xOffset;
				if(xp < 0 || xp >= _width) continue;
				pixels[xp + yp * _width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE]; 
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		for (int y=0; y<tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x=0; x<tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= _width || ya < 0 || ya >= _width) break;
				pixels[xa + ya * _width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}      
		}
	}
	
	
}
