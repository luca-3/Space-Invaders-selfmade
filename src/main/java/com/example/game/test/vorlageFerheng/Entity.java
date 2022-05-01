package com.example.game.test.vorlageFerheng;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int x,y,speed, speed_diagonal;
	
	public BufferedImage  up, down, left, right, left_w1, left_w2, up_w1, up_w2, down_w1, down_w2, right_w1, right_w2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 0;
	
	public Rectangle solidArea;
	public boolean collisionOn;
}
