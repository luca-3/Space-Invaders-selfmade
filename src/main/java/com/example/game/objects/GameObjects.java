package com.example.game.objects;

import com.example.game.main.Main;
import com.example.game.main.Screen;

import javax.swing.*;

abstract class GameObjects {


    private int width;
    private int height;
    private int x;
    private int y;



    private int speed;

    private JLabel label;

    private Screen s;

    private Icon skin;

    public GameObjects(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.s = Main.getScreen();
        this.skin = new ImageIcon(getClass().getResource("/img/player.png"));

        label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(skin);
        s.add(label);
    }

    public void move(){

    }



    //Getter and Setter
    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        label.setLocation(x, y);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        label.setLocation(x, y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
