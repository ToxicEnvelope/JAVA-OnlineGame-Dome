package com.sysmurff.dome.graphics;

import java.util.Random;

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
	
	
	
	
}
