package com.example.game.test.vorlageFerheng;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class FrameSettings extends JPanel implements Runnable {
	
	//Screenauflösung und tilesize bestimmen
	final int bit = 16;
	final int resize = 3;
	
	final int tile = bit * resize;
	final int maxCol = 40;
	final double maxRow = 22.5;
	
	final int Screenwidth = tile*maxCol;
	final double Screenhight = tile*maxRow;
	
	
	Thread gameThread;
	
	// Player anfangsposition und speed
	int px = 100;
	int py = 100;
	int pSpeed = 4;
	int pSpeed_diagonal = 3;
	
	// FPS
	int FPS = 60;
	
	KeyBinding keyBind = new KeyBinding();
	
	
	public FrameSettings() {
		
		
		

		setPreferredSize(new Dimension(Screenwidth,(int) Screenhight));
		setBackground(Color.black);
		setDoubleBuffered(true);
		
		addKeyListener(keyBind);
		setFocusable(true);
	}
	
	//gameThread sorgt dafür dass das spiel die ganze zeit runned auch ohne inpudt
	public void gameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	// wird gebraucht um updates und repaints zu mache
	public void run() {
		//draw limit damit die inputs nicht durchdrehen
		double intervale = 1000000000/FPS; 
		double nextDrawTime = System.nanoTime()+ intervale; 
		
		while(gameThread!=null) {
			update();
			
			repaint();
			
			// Was das hier macht ist einfach einen sleep modus für den gamThread zu machen damit das game nicht ständig läuft so verhindert man dass zbsp der character bei einem kurzen antippen 10km weit weg geht  
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime /1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
			
				nextDrawTime+= intervale;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		
	}
	
	//wird benötigt um objecte zu bewegen
	public void update() {
		if(keyBind.upPressed == true && keyBind.leftPressed) {
			py-=pSpeed_diagonal;
			px-=pSpeed_diagonal;
		}else if(keyBind.upPressed == true && keyBind.rightPressed) {
			py -= pSpeed_diagonal;
			px +=pSpeed_diagonal;
		}else if(keyBind.downPressed == true && keyBind.leftPressed) {
			py+= pSpeed_diagonal;
			px-=pSpeed_diagonal;
		}else if(keyBind.downPressed == true && keyBind.rightPressed) {
			py+= pSpeed;
			px+=pSpeed;
		}else if (keyBind.upPressed == true) {
			py -= pSpeed;
		}else if(keyBind.downPressed == true) {
			py += pSpeed;
		}else if(keyBind.leftPressed == true) {
			px-= pSpeed;
		}else if(keyBind.rightPressed == true) {
			px+=pSpeed;
		}
	}
	
	
	//wird benötigt um graphische object neu zu zeichnen falls sie sich bewegen
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(px, py, tile, tile);
		
		g2.dispose();
	}
	
}
