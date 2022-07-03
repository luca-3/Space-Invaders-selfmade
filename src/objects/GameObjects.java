package objects;

import main.Main;
import main.Screen;
import main.Util;

import javax.swing.*;
import java.awt.*;

public abstract class GameObjects {

    private int width, height, x, y;
   private JLabel label;
    private Screen s;
    private Icon skin;

    public GameObjects(int x, int y, int width, int height, String filepathSkin) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.s = Main.getScreen();
        if(filepathSkin != null) this.skin = Util.resizeImage(width, height, filepathSkin);

        label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setBackground(Color.RED);
        label.setIcon(skin);
        s.getLayeredPane().add(label);
   }

    public void setLabel(JLabel label) {
        this.label = label;
        s.getLayeredPane().add(label);
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

    public void removeJLabel(){
        label.setVisible(false);
    }



    public Screen getScreen() {
        return s;
    }

    public JLabel getJLabel(){
        return label;
    }

    public void setHeight(int height) {
        this.height = height;
        getJLabel().setBounds(getX(), getY(), width, height);
    }

    public void setWidth(int width) {
        this.width = width;
        getJLabel().setBounds(getX(), getY(), width, height);
    }
}
