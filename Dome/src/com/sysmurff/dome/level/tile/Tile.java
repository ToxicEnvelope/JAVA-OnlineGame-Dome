package com.sysmurff.dome.level.tile;

import com.sysmurff.dome.graphics.Screen;
import com.sysmurff.dome.graphics.Sprite;

public class Tile {

	protected int x, y;
	protected Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	
	public Tile(Sprite aSprite) {
		this.sprite = aSprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean isSolid() {
		return false;
	}
}
