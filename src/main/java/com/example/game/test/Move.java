package com.example.game.test;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.Random;

public class Move extends JFrame implements KeyListener {

    int diff = 10;
    JLabel mainChar;
    JLabel[] enemy = new JLabel[3];
    JLabel[] shot = new JLabel[11];
    Random random = new Random();
    ImageIcon icon;
    int k = -1;
    int shotZähler = 0;
    boolean[] c = new boolean[enemy.length];
    boolean[] d = new boolean[shot.length];
    int leben = 7;

    public Move() {

        //init settings JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 800);
        this.setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(null);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);


        //PLAYER
        mainChar = new JLabel();
        mainChar.setBounds(100, 100, 100, 100);
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");
        mainChar.setIcon(icon);
        mainChar.setOpaque(true);
        this.add(mainChar);


        //ENEMY
        Enemy enemyR = new Enemy(EnemyE.AFFE, 600, 300);
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = new JLabel();
            enemy[i].setBounds(enemyR.getX(), enemyR.getY()*i, enemyR.getWidth(), enemyR.getHeight());
            enemy[i].setBackground(Color.GREEN);
            //Icon iconB = new ImageIcon("src/main/resources/com/example/game/enemy/Bannane.png");
            //enemy.setIcon(enemyR.getSkin());
            enemy[i].setOpaque(true);
            this.add(enemy[i]);

        }






        //THREAD
        Thread[] t = new Thread[3];
        for (int i = 0; i < t.length; i++) {
            int s = i;
            t[i]= new Thread(() -> enemyMove(s));
            t[i].start();
        }

        Thread t1 = new Thread(() -> collision());
        t1.start();


        for (int i = 0; i < shot.length; i++) {
            shot[i] = new JLabel();
            shot[i].setBounds(0,0,40,20);

            if(i==2){shot[i].setBackground(Color.MAGENTA);}
            else {shot[i].setBackground(Color.ORANGE);}
            shot[i].setOpaque(true);
            add(shot[i]);
        }

    }


    public static void main(String[] args) {
        new Move();

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void collision() {

        while (true) {
            sleep(10);

            //System.out.println(mainChar.getX()+100+" "+enemy.getX());


            for (int i = 0; i < enemy.length; i++) {
                if (PvE(mainChar, enemy[i])) {
                    mainChar.setLocation(10, 500);
                    System.out.println("Colision was detected!");
                }
            }
            for (int i = 0; i < shot.length; i++) {
                for (int j = 0; j < enemy.length; j++) {
                    if (PvB(enemy[j], shot[i])) {
                    c[j] = true;
                    d[i] = true;
                    }
                }
            }

        }
    }
        public boolean PvB(JLabel Player, JLabel Bullet){
            return Player.getX() + Player.getWidth() >= Bullet.getX() + Bullet.getWidth() && Player.getY() + Player.getHeight() >= Bullet.getY() + (Bullet.getHeight() / 2)
                    && Player.getX() <= Bullet.getX() + Bullet.getWidth() && Player.getY() <= Bullet.getY() + (Bullet.getHeight() / 2);
        }
        public boolean PvE(JLabel mobA, JLabel mobB){
        //mobA = hitbox; mobB = points

            final int hitboxWidth = mobB.getWidth();
            final int hitboxHeight = mobB.getHeight();
            final int X_OBJ_ONE = mobA.getX();
            final int Y_OBJ_ONE = mobA.getY();
            final int X_OBJ_TWO = mobB.getX();
            final int Y_OBJ_TWO = mobB.getY();
            if (X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO || //Oben Links
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight || //Unten Links
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO || // Oben Rechts
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight|| //Unten Rechts
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight/2 && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight/2|| // Mitte Links
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO+hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight/2 && X_OBJ_ONE <= X_OBJ_TWO+hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight/2|| // Mitte Rechts
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth/2 && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth/2 && Y_OBJ_ONE <= Y_OBJ_TWO || // Mitte Oben
                    X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth/2 && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO/2 + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight // Mitte Unten
            ){return true;}
            return  false;
        }

    public void shot(){
      //int k =  random.nextInt(4);
        int k1 = k;
        int y = shot[k1].getY();
        for(int x = shot[k1].getX(); x<2000; x+=4){
            if (d[k1]){x=2000; d[k1]=false;}
            shot[k1].setLocation(x, y);
            sleep(10);

        }
        shotZähler--;
    }


    public void enemyMove(int i) {
        int[] base = new int[3];

            base[i] = enemy[i].getY();


        for (double x = 1600; x > -3; x--) {

                double y = Math.sin(x / 100) * 100 + base[i];
                enemy[i].setLocation((int) x, (int) y);
                if (c[i]){x=1600;c[i]=false;}
                if (x==0){x=1600;}
                sleep(5);


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
            case ' ':
            if(shotZähler<shot.length) {
                k++;
                int f = k;
                shot[k].setLocation(mainChar.getX() + 100, mainChar.getY() + 50);

                add(shot[k]);

                Thread t2 = new Thread(() -> shot());
                t2.start();


                sleep(20);
                if (k == 9) {
                    k = -1;
                }
                shotZähler++;
                System.out.println("Hallo");
            }
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