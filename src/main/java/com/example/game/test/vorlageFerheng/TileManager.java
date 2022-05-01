package com.example.game.test.vorlageFerheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.AWTException;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.FrameSettings;


public class TileManager {
	FrameSettings frameSettings;
	public Tile[] tile;
	
	int raum[][][] = new int[3][3][3];
	InputStream is ;
	
	int i = 0;
	int j = 0;
	
	public int mapTileNum[][];
	
	public TileManager(FrameSettings frameSettings) {
		
		this.frameSettings = frameSettings;
		
		tile = new Tile[10];
		mapTileNum = new int[frameSettings.maxCol][frameSettings.maxRow];
		
		getTileImage();
		
		
		
	}
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Crystal.png"));
			tile[3].collision = true;
			tile[3].destroyable = true;
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {

		//InputStream importiert die text datei w�hrend BufferedReader den context davon liest 
		if (j== 0) {
			switch(i) {
			case 0:
				is = getClass().getResourceAsStream("/raeume/Raum1.txt");
				break;
			case 1:
				is = getClass().getResourceAsStream("/raeume/Raum2.txt");
				break;
			case 2:
				is = getClass().getResourceAsStream("/raeume/Raum3.txt");
				break;
			}
		}else if(j>0) {
			switch(j) {
			case 1:
				is = getClass().getResourceAsStream("/raeume/Raum4.txt");
				break;
			}
		}
		
		
		
		
		
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while (col < frameSettings.maxCol && row < frameSettings.maxRow) {
				
				String line = br.readLine();
				
				while(col < frameSettings.maxCol) {
				
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num; //2d array
					col++;
				}
				if (col== frameSettings.maxCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		} catch (Exception e) {
			
		}
		
	}
	
	
	public void draw(Graphics2D g2) {
		loadMap();
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		System.out.println(frameSettings.rectangle.width);
		
		if (frameSettings.player.x<frameSettings.rectangle.x+45) {
			i = i-1;
			frameSettings.player.x += frameSettings.rectangle.width-frameSettings.player.x;
		}else if (frameSettings.player.x>frameSettings.rectangle.width) {
			i = i+1;
			frameSettings.player.x -= frameSettings.rectangle.width-48;
		}else if (frameSettings.player.y>frameSettings.rectangle.hight-48) {
			j= j-1;
			frameSettings.player.y -= frameSettings.player.y;
			
		}else if (frameSettings.player.y<frameSettings.rectangle.y-48) {
			j+= 1;
			frameSettings.player.y += frameSettings.rectangle.hight-frameSettings.player.y-48;
			
	
		}
		System.out.println(i);
		
		while(col < frameSettings.maxCol && row < frameSettings.maxRow) {
			int tileNum = mapTileNum[col][row];
			g2.drawImage(tile[tileNum].image, x, y, frameSettings.tileSize, frameSettings.tileSize, null);
			col++;
			x+= frameSettings.tileSize;
			
			
			if(col == frameSettings.maxCol) {
				col = 0; 
				y+= frameSettings.tileSize;
				x= 0;
				row++;
				
			}
			
			
		}
		
		
		
		
	}
	
	
	
}
