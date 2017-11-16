package com.sysmurff.dome.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Events implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean UP, DOWN, LEFT, RIGHT, SHOOT;
	
	public void update() {
		UP = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		DOWN = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		LEFT= keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		RIGHT = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		SHOOT = keys[KeyEvent.VK_SPACE];
		
		for (int k=0; k<keys.length; k++) {
			if(keys[k])
			{
				System.out.println("KEY: " + k);
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
