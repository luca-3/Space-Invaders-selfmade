package com.example.game.test.vorlageFerheng;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.FrameSettings;
import main.KeyBinding;

public class Player extends Entity{
	
	FrameSettings fs;
	KeyBinding kb;
	
	public Player(FrameSettings fs, KeyBinding kb) {
		this.fs = fs;
		this.kb = kb;
		
		solidArea = new Rectangle();
		solidArea.x = 19;
		solidArea.y = 28;
		solidArea.height = 35;
		solidArea.width = 29;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues () {
		x = 100;
		y = 100;
		speed = 4;
		speed_diagonal = 3;
		direction = "down";
		
	}
	
	public void getPlayerImage() {
		try {
			down = ImageIO.read(getClass().getResourceAsStream("/player/down_standing.png"));
			down_w1 = ImageIO.read(getClass().getResourceAsStream("/player/down_walk1.png"));
			down_w2 = ImageIO.read(getClass().getResourceAsStream("/player/down_walk2.png"));
			
			up = ImageIO.read(getClass().getResourceAsStream("/player/up_standing .png"));
			up_w1 = ImageIO.read(getClass().getResourceAsStream("/player/up_walk1.png"));
			up_w2 = ImageIO.read(getClass().getResourceAsStream("/player/up_walk2.png"));
			
			right = ImageIO.read(getClass().getResourceAsStream("/player/right_standing.png"));
			right_w1 = ImageIO.read(getClass().getResourceAsStream("/player/right_walk1.png"));
			right_w2 = ImageIO.read(getClass().getResourceAsStream("/player/right_walk2.png"));
			
			left = ImageIO.read(getClass().getResourceAsStream("/player/left_standing.png"));
			left_w1 = ImageIO.read(getClass().getResourceAsStream("/player/left_walk1.png"));
			left_w2 = ImageIO.read(getClass().getResourceAsStream("/player/left_walk2.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(KeyBinding.upPressed == true || KeyBinding.leftPressed == true || KeyBinding.rightPressed == true || KeyBinding.downPressed == true) {
		
			
			if (KeyBinding.upPressed == true && KeyBinding.leftPressed == true){
				direction = "upLeft";
			}else if (KeyBinding.upPressed == true && KeyBinding.rightPressed == true){
				direction = "upRight";
			}else if (KeyBinding.downPressed == true && KeyBinding.rightPressed == true){
				direction = "downRight";
			}else if (KeyBinding.downPressed == true && KeyBinding.leftPressed == true){
				direction = "downLeft";
			}else if (KeyBinding.upPressed == true) {
				direction = "up";
				
			}else if(KeyBinding.downPressed == true) {
				direction = "down";
				
				//HIER MAP UPDATE!!! --> map[n][] --> n-1  ---> 0 --> n
				
			}else if(KeyBinding.leftPressed == true) {
				direction = "left";
				
			}else if(KeyBinding.rightPressed == true) {
				direction = "right";
				
			}
			
			
			collisionOn = false;
			fs.cColission.checkTile(this);
			
			if (collisionOn == false) {
				switch (direction) {
				case "up": y -= speed;		break;
				case "upLeft": 	y-= speed_diagonal;
								x-= speed_diagonal; break;
				
				case "upRight": y-= speed_diagonal;
								x+= speed_diagonal; break;

				case "down": y += speed;		break;
				case "downLeft":	y+= speed_diagonal;
									x-= speed_diagonal; break;
				case "downRight":	y+= speed_diagonal;
									x+= speed_diagonal; break;
				
				case "right": x+= speed;	break;
				case "left": x-= speed;		break;
				
				}
			}
			
				
				spriteCounter++;
				if (spriteCounter > 12) {
					if(spriteNum == 1) {
						spriteNum = 2;
					}else if (spriteNum == 2) {
						spriteNum = 1;
					}else if (spriteNum == 0) {
						spriteNum = 1;
					}
					
					spriteCounter = 0;
				}
		
		}else {
			spriteNum = 0;
		}
		
	}
		public void draw(Graphics2D g2) {
			
			
			BufferedImage image = null;
			
			switch(direction) {
				case "up":
					if (spriteNum == 0) {
						image = up;
					}
					if (spriteNum == 1) {
						image = up_w1;
					}
					if (spriteNum == 2) {
						image = up_w2;
					}
					
					break;
					
				case "upLeft":
					if (spriteNum == 0) {
						image = up;
					}
					if (spriteNum == 1) {
						image = up_w1;
					}
					if (spriteNum == 2) {
						image = up_w2;
					}
					
					break;
				case "upRight":
					if (spriteNum == 0) {
						image = up;
					}
					if (spriteNum == 1) {
						image = up_w1;
					}
					if (spriteNum == 2) {
						image = up_w2;
					}
					
					break;
				case "down":
					if (spriteNum == 0) {
						image = down;
					}
					if (spriteNum == 1) {
						image = down_w1;
					}
					if (spriteNum == 2) {
						image = down_w2;
					}
					break;
				case "downLeft":
					if (spriteNum == 0) {
						image = down;
					}
					if (spriteNum == 1) {
						image = down_w1;
					}
					if (spriteNum == 2) {
						image = down_w2;
					}
					break;
				case "downRight":
					if (spriteNum == 0) {
						image = down;
					}
					if (spriteNum == 1) {
						image = down_w1;
					}
					if (spriteNum == 2) {
						image = down_w2;
					}
					break;
				case "right":
					if (spriteNum == 0) {
						image = right;
					}
					if (spriteNum == 1) {
						image = right_w1;
					}
					if (spriteNum == 2) {
						image = right_w2;
					}
					break;
					
				case "left":
					if (spriteNum == 0) {
						image = left;
					}
					if (spriteNum == 1) {
						image = left_w1;
					}
					if (spriteNum == 2) {
						image = left_w2;
					}
					break;
				
			}
			
			g2.drawImage(image, x, y, fs.tileSize, fs.tileSize, null);
		}
	
}
