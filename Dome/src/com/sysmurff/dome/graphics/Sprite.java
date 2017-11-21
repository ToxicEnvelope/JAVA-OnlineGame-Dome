package com.sysmurff.dome.graphics;

public class Sprite {

	
	protected final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 1, 11, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(16, 4, 6, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 3, 10, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0);
	
	public Sprite(int aSize, int x, int y, SpriteSheet aSheet) {
		this.SIZE = aSize;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = aSheet;
		load();
	}
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void load() {
		for (int y=0; y<SIZE; y++) {
			for (int x=0; x<SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y) * sheet.SIZE];
			}
		}
	}
	
	private void setColor(int color) {
		for (int n=0; n<SIZE*SIZE; n++) {
			pixels[n] = color;
		}
	}
}
