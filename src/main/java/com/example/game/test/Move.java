package com.example.game.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move extends JFrame implements KeyListener {

    public static void main(String[] args) {
        new Move();
    }

    JLabel mainChar;
    ImageIcon icon;

    public Move(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        // icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");

        mainChar = new JLabel();
        mainChar.setBounds(0, 0, 100, 100);
        mainChar.setIcon(icon);
        mainChar.setBackground(Color.red);
        mainChar.setOpaque(true);
        this.getContentPane().setBackground(Color.black);
        this.add(mainChar);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        switch(e.getKeyChar()) {
            case 'a': mainChar.setLocation(mainChar.getX()-10, mainChar.getY());
                break;
            case 'w': mainChar.setLocation(mainChar.getX(), mainChar.getY()-10);
                break;
            case 's': mainChar.setLocation(mainChar.getX(), mainChar.getY()+10);
                break;
            case 'd': mainChar.setLocation(mainChar.getX()+10, mainChar.getY());
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
        switch(e.getKeyCode()) {
            case 37: mainChar.setLocation(mainChar.getX()-10, mainChar.getY());
                break;
            case 38: mainChar.setLocation(mainChar.getX(), mainChar.getY()-10);
                break;
            case 39: mainChar.setLocation(mainChar.getX()+10, mainChar.getY());
                break;
            case 40: mainChar.setLocation(mainChar.getX(), mainChar.getY()+10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
}
