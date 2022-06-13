package com.example.game.objects;
//NEW

import com.example.game.main.Main;
import com.example.game.main.Screen;

import javax.swing.*;

public abstract class GameObjects {

    private int width;
    private int height;
    private int x;
    private int y;



    private int speed;

    private JLabel label;



    private com.example.game.mainNew.Screen s;

    private Icon skin;

    public GameObjects(int x, int y, int width, int height, String filepathSkin) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.s = com.example.game.mainNew.Screen.getInstance();
        this.skin = new ImageIcon(filepathSkin);

        label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(skin);
        s.add(label);
    }

    public void move(){
        System.out.println("move");
    }
    public void remove(Object x){ //del objects

        label.setVisible(false);
        label=null;
        x=null;
        //TODO: funktion der folgenden zeilen prüfen
        System.gc();
        System.runFinalization();
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

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        label.setLocation(x, y);
    }


    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public com.example.game.mainNew.Screen getScreen() {
        return s;
    }

    public JLabel getJLabel(){
        return label;
    }

}
