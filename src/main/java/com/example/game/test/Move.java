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
    JLabel enemy;
    ImageIcon icon;

    public Move(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1900, 1000);

        this.setLayout(null);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.black);
        // icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");

        mainChar = new JLabel();
        mainChar.setBounds(0, 0, 100, 100);
        mainChar.setIcon(icon);
        mainChar.setBackground(Color.red);
        mainChar.setOpaque(true);

        this.add(mainChar);
        this.setVisible(true);
        enemy = new JLabel();
        Thread t = new Thread(()->enemy());
        t.start();
        Thread t1 = new Thread(()->collition());
        t1.start();

    }

    public void collition(){
        while (true){
            sleep2(100);
            //System.out.println(mainChar.getX()+100+" "+enemy.getX());
            if(mainChar.getX()+100>=enemy.getX()&&mainChar.getY()+100>=enemy.getY()&&mainChar.getX()<=enemy.getX()&&mainChar.getY()<=enemy.getY()||
                    mainChar.getX()+100>=enemy.getX()&&mainChar.getY()+100>=enemy.getY()+100&&mainChar.getX()<=enemy.getX()&&mainChar.getY()<=enemy.getY()+100||
                    mainChar.getX()+100>=enemy.getX()+100&&mainChar.getY()+100>=enemy.getY()&&mainChar.getX()<=enemy.getX()+100&&mainChar.getY()<=enemy.getY()||
                    mainChar.getX()+100>=enemy.getX()+100&&mainChar.getY()+100>=enemy.getY()+100&&mainChar.getX()<=enemy.getX()+100&&mainChar.getY()<=enemy.getY()+100
            ){
                mainChar.setLocation(10, 500);
                System.out.println("So What");
            }
        }
    }

    public void enemy(){
        enemy = new JLabel();
        enemy.setBounds(500, 500, 100, 100);

        enemy.setBackground(Color.GREEN);
        enemy.setOpaque(true);

        this.add(enemy);
        this.setVisible(true);
        enemyMove();
    }

    public void enemyMove(){
        for (double x = 1900; x > -3; x--) {
            double y = Math.sin(x/100)*100+500;

            enemy.setLocation((int) x , (int) y);
            if (x==0){x=1920;}
            sleep2(10);
        }
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
        //System.out.println("You released key char: " + e.getKeyChar());
        //System.out.println("You released key code: " + e.getKeyCode());
    }

    public static Exception sleep2(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            return ignored;
        }
        return null;
    }
}

