package com.example.game.main;

import com.example.game.firuges.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {

    ArrayList<JLabel> objectsList = new ArrayList<>();
    JLabel background;
    JLabel score;
    JLabel lives;
    JLabel level;
    public static int width = 1500;
    public static int height = 800;
    public boolean gameOver = false;
    public boolean gameWon = false;

    public Screen() {
        setSize(width, height);
        setTitle("Blank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(Color.black);
        background = new JLabel();
        background.setBounds(0, 0, 800, 600);
        //background.setForeground(Color.black);
        getContentPane().setBackground(Color.black);
        //background.setIcon(new ImageIcon("src/main/resources/background.png"));
        add(background);

        score = new JLabel("Score: " + Player.score);
        score.setBounds(10, 10, 100, 20);
        score.setForeground(Color.white);
        add(score);

        lives = new JLabel("Lives: " + Player.hp);
        lives.setBounds(10, 30, 100, 20);
        lives.setForeground(Color.white);
        add(lives);

        level = new JLabel("Level: " + EnemyHandler.level);
        level.setBounds(10, 50, 100, 20);
        level.setForeground(Color.white);
        add(level);
    }

    public void addObject(JLabel object) {
        objectsList.add(object);
        add(object);
    }

    public void removeObject(JLabel object) {
        objectsList.remove(object);
        remove(object);
    }

    public void updateScore() {
        score.setText("Score: " + Player.score);
    }

    public void updateLives() {
        lives.setText("Lives: " + Player.hp);
    }

    public void updateLevel() {
        level.setText("Level: " + EnemyHandler.level);
    }




    public void start(){ //start the game
        this.setVisible(true);


        this.update(this.getGraphics());
    }




    public void add(Object object) {
        this.add(object);
    }

    public void remove(Object object) {
        this.remove(object);
    }

    public void repaint() {
        this.repaint();
    }
}


