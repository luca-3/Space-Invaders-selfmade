package com.example.game.test;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;

public class Move extends JFrame implements KeyListener {

    JLabel mainChar;
    JLabel enemy;
    ImageIcon icon;
    public Move() {

        //init settings JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.black);
        // icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");

        //PLAYER
        mainChar = new JLabel();
        mainChar.setBounds(0, 0, 100, 100);
        //mainChar.setIcon(icon);
        //mainChar.setBackground();
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");
        mainChar.setIcon(icon);
        mainChar.setOpaque(true);
        this.add(mainChar);
        this.setVisible(true);

        //ENEMY
        Enemy enemyR = new Enemy(EnemyE.AFFE, 600, 300);
        enemy = new JLabel();
        enemy.setBounds(enemyR.getX(), enemyR.getY(), enemyR.getWidth(), enemyR.getHeight());
        enemy.setBackground(Color.GREEN);
        //Icon iconB = new ImageIcon("src/main/resources/com/example/game/enemy/Bannane.png");
        //enemy.setIcon(enemyR.getSkin());
        enemy.setOpaque(true);
        this.add(enemy);
        this.setVisible(true);

        //THREAD
        Thread t = new Thread(() -> enemyMove());
        t.start();
        Thread t1 = new Thread(() -> collision());
        t1.start();
    }

    public static void main(String[] args) {
        new Move();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }

    public void collision() {

        while (true) {
            sleep(10);

            //System.out.println(mainChar.getX()+100+" "+enemy.getX());
            if (mainChar.getX() + 100 >= enemy.getX() && mainChar.getY() + 100 >= enemy.getY() && mainChar.getX() <= enemy.getX() && mainChar.getY() <= enemy.getY() ||
                    mainChar.getX() + 100 >= enemy.getX() && mainChar.getY() + 100 >= enemy.getY() + 100 && mainChar.getX() <= enemy.getX() && mainChar.getY() <= enemy.getY() + 100 ||
                    mainChar.getX() + 100 >= enemy.getX() + 100 && mainChar.getY() + 100 >= enemy.getY() && mainChar.getX() <= enemy.getX() + 100 && mainChar.getY() <= enemy.getY() ||
                    mainChar.getX() + 100 >= enemy.getX() + 100 && mainChar.getY() + 100 >= enemy.getY() + 100 && mainChar.getX() <= enemy.getX() + 100 && mainChar.getY() <= enemy.getY() + 100
            ) {
                mainChar.setLocation(10, 500);
                System.out.println("So What");
            }
        }
    }


    public void enemyMove() {
        for (double x = 600; x > -3; x--) {
            double y = Math.sin(x / 100) * 100 + 300;

            enemy.setLocation((int) x, (int) y);
            if (x == 0) {
                x = 600;
            }
            sleep(10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        switch (e.getKeyChar()) {
            case 'a':
                if (mainChar.getX() - 10 > 0) {
                    mainChar.setLocation(mainChar.getX() - 10, mainChar.getY());
                }
                break;
            case 'w':
                if (mainChar.getY() - 10 > 30) {
                    mainChar.setLocation(mainChar.getX(), mainChar.getY() - 10);
                }
                break;
            case 's':
                if (mainChar.getY() + 110 < 1040) {
                    mainChar.setLocation(mainChar.getX(), mainChar.getY() + 10);
                }
                break;
            case 'd':
                if (mainChar.getX() + 10 < 1900) {
                    mainChar.setLocation(mainChar.getX() + 10, mainChar.getY());
                }
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
       /* switch(e.getKeyCode()) {
            case 37: mainChar.setLocation(mainChar.getX()-10, mainChar.getY());
                break;
            case 38: mainChar.setLocation(mainChar.getX(), mainChar.getY()-10);
                break;
            case 39: mainChar.setLocation(mainChar.getX()+10, mainChar.getY());
                break;
            case 40: mainChar.setLocation(mainChar.getX(), mainChar.getY()+10);
                break;
        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
        //System.out.println("You released key char: " + e.getKeyChar());
        //System.out.println("You released key code: " + e.getKeyCode());
    }
}

