package com.sysmurff.dome.level.tiles;

import com.sysmurff.dome.graphics.Screen;
import com.sysmurff.dome.graphics.Sprite;

public class Tile {

	protected int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile stone = new StoneTile(Sprite.stone);
	public static Tile water = new WaterTile(Sprite.water);
	
	public Tile(Sprite aSprite) {
		this.sprite = aSprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean isSolid() {
		return false;
	}
}
