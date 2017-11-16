package com.sysmurff.dome.graphics;

public class Sprite {

	
	protected final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 1, 11, SpriteSheet.tiles);
	
	public Sprite(int aSize, int x, int y, SpriteSheet aSheet) {
		this.SIZE = aSize;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = aSheet;
		load();
	}
	
	private void load() {
		for (int y=0; y<SIZE; y++) {
			for (int x=0; x<SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y) * sheet.SIZE];
			}
		}
	}
}
