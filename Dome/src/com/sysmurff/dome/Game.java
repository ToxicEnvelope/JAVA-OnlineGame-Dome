package com.sysmurff.dome;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.sysmurff.dome.graphics.Screen;
import com.sysmurff.dome.input.Events;
import com.sysmurff.dome.level.Level;
import com.sysmurff.dome.level.RandomLevel;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L; 
	
	// FIELDS
	public static int WIDTH = 300;				// window screen width
	public static int HEIGHT = WIDTH / 16 * 9;  // window screen height on 16:9 ratio
	public static int SCALE = 3;				// use to scale the window size 
	public static String title = "Dome";
	 
	private Thread gameThread;					// the games thread
	private Screen screen;
	private JFrame frame;						// JFrame object to create a window
	private Events key;  
	private Level level;
	private boolean running = false;			// use as FLAG to game loop
	
	// Use as the View image
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	// get the pixels data
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	int x=0, y=0;
	// CONSTRUCTOR
	public Game() {
		// create a Dimension object as size of 900x506 scale 
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		// set the size of the Component window
		super.setPreferredSize(size);
		this.screen = new Screen(WIDTH, HEIGHT);
		// create a new JFrame object
		this.frame = new JFrame();
		// create a new Event object
		this.key = new Events();
		this.level = new RandomLevel(64, 64);
		super.addKeyListener(key);
		
		
	}
	
	// Start gameThread synchronously 
	public synchronized void start() {
		// set FLAG to true;
		running = true;
		// make new Thread object
		gameThread = new Thread(this, "Display");
		gameThread.start();  // start the thread
	}
	
	// Stop the gameThread
	public synchronized void stop() {
		try {
			// set FLAG to false;
			running = false;
			// try to join all threads associated 
			gameThread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace(); // print stack trace in case of an error
		}
	}

	// will run as soon as the game starts, 
	// executed by 'gameThread.start()' method
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0; 
		int frames = 0;
		int updates = 0;
		super.requestFocus();
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(Game.title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
		
	}
	
	public void update() {
		key.update();
		if (key.UP) y--;
		if (key.DOWN) y++;
		if (key.LEFT) x--;
		if (key.RIGHT) x++;
	}
	
	public void render() {
		// instance BufferStrategy object
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)		// as long as bs NOT null
		{	
			// create a new BufferStrategy object using TripleBuffer
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		level.render(x, y, screen);
		
		for (int n=0; n<pixels.length; n++) {
			pixels[n] = screen.pixels[n];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	// --- MAIN --- \\
	public static void main(String[] args) {
		
		Game game = new Game();						// create a new Game object
		game.frame.setResizable(false);				// force window to not being resizable
		game.frame.setTitle(Game.title);			// set title
		game.frame.add(game);						// add the game to the frame
		game.frame.pack();							// pack as process
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// force process to be closed on "x" button
		game.frame.setLocationRelativeTo(null);		// set the window in CENTER
		game.frame.setVisible(true);				// make window visible
		
		game.start();
	}
}
