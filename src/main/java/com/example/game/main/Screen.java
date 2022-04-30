package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.MobMoveE;
import com.example.game.firuges.Player;
import com.example.game.test.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//Screen
public class Screen extends JFrame implements KeyListener {

    JFrame s=new JFrame();
    ArrayList<JLabel> objectsList = new ArrayList<>();
    JLabel[] arrJLabel = new JLabel[12];
    Thread[] arrThread = new Thread[arrJLabel.length];
    JLabel background;
    JLabel score;
    JLabel lives;
    JLabel level;
    JLabel mainChar;
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

        this.addKeyListener(this);

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

        mainChar = new JLabel();
        mainChar.setBounds(100, 100, 100, 100);
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");
        mainChar.setIcon(icon);
        mainChar.setOpaque(true);
        this.add(mainChar);

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
      /*  while (true){
        this.update(this.getGraphics());
        Move.sleep(20000);
        }
        */
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
    public int addEnemy(Enemy object){
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
        return zähler-1;

    }

    public void move(int id, EnemyE e){
        System.out.println(arrJLabel[id].getY());
        int spawn = arrJLabel[id].getY();
        for (double x = 2000; x > 0; x--) {

           double y =  MobMoveE.bew(e.getMove(), spawn, x);
            arrJLabel[id].setLocation((int) x, (int) y);
            Move.sleep(100/e.getSpeed());
            if (x == 1){x=2000;}
        }


    }


    @Override
    public void keyTyped(KeyEvent e) {
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
            case ' ':

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}



}


