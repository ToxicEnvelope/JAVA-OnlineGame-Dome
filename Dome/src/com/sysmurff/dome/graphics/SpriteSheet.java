package com.sysmurff.dome.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	
	private String path;
	protected final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/texture/PathAndObjects.png",256);
	
	public SpriteSheet(String aPath, int aSize) {
		this.path = aPath;
		this.SIZE = aSize;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
}
