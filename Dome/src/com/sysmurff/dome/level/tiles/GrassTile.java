package com.sysmurff.dome.level.tiles;

import com.sysmurff.dome.graphics.Screen;
import com.sysmurff.dome.graphics.Sprite;

public class GrassTile extends Tile {

	
	public GrassTile(Sprite aSprite) {
		super(aSprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
