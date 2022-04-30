package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.Player;
import com.example.game.test.Move;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//Screen
public class Screen extends JFrame {

    JFrame s=new JFrame();
    ArrayList<JLabel> objectsList = new ArrayList<>();
    JLabel[] arrJLabel = new JLabel[12];
    Thread[] arrThread = new Thread[arrJLabel.length];
    JLabel background;
    JLabel score;
    JLabel lives;
    JLabel level;
    public static int width = 1500;
    public static int height = 800;
    public boolean gameOver = false;
    public boolean gameWon = false;
    int zähler = 0;

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
        setVisible(true);

        JButton button = new JButton("click me");
        button.addActionListener(e ->
        {
            System.out.println("Hi");
        });
        button.setBounds(130,200,100,40);
        s.add(button);

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
        this.add(object);
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
        while (true){
        this.update(this.getGraphics());
        Move.sleep(100);
        }
    }


   /* public void add(Object object) {
        this.add(object);
    }*/

    public void remove(Object object) {
        this.remove(object);
    }

    public void repaint() {
        this.repaint();
    }

    //Enemy to JLabel
    public void addEnemy(Enemy object){
        JLabel temp = new JLabel();
        temp.setBounds(object.getX(), object.getY(), object.getWidth(), object.getHeight());
        temp.setIcon(object.getSkin());
        temp.setOpaque(true);

        arrJLabel[zähler] = new JLabel();
        arrJLabel[zähler] = temp;
        this.add(arrJLabel[zähler]);


        //objectsList.set(zähler, temp);
        //addObject(objectsList.get(zähler));
        zähler++;

    }




}


