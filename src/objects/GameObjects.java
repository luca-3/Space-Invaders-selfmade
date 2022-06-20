package objects;
//NEW

import main.Main;
import main.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class GameObjects {

    private int width, height, x, y, speed;
    private JLabel label;
    private Screen s;
    private Icon skin;

    public GameObjects(int x, int y, int width, int height, String filepathSkin) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.s = Main.getScreen();
        try{
            BufferedImage img = ImageIO.read(new File(filepathSkin));
            Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            this.skin = new ImageIcon(dimg);
        }catch (Exception e){
            System.out.println("Error while resizing skin: " + e);
        }

        label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(skin);
        s.add(label);
    }

    public void move(){
        System.out.println("move");
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

    public Screen getScreen() {
        return s;
    }

    public JLabel getJLabel(){
        return label;
    }

}
