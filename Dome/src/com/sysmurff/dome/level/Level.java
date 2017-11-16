package com.sysmurff.dome.level;

import com.sysmurff.dome.graphics.Screen;

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
		
	}
	
}
