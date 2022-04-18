package com.example.game.test;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.Random;

public class Move extends JFrame implements KeyListener {

    JLabel mainChar;
    JLabel enemy;
    JLabel[] shot = new JLabel[10];
    Random random = new Random();
    ImageIcon icon;
    int k = -1;
    boolean c = false;
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
        // icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");

        //PLAYER
        mainChar = new JLabel();
        mainChar.setBounds(100, 100, 100, 100);
        //mainChar.setIcon(icon);
        //mainChar.setBackground();
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");
        mainChar.setIcon(icon);
        mainChar.setOpaque(true);
        this.add(mainChar);


        //ENEMY
        Enemy enemyR = new Enemy(EnemyE.AFFE, 600, 300);
        enemy = new JLabel();
        enemy.setBounds(enemyR.getX(), enemyR.getY(), enemyR.getWidth(), enemyR.getHeight());
        enemy.setBackground(Color.GREEN);
        //Icon iconB = new ImageIcon("src/main/resources/com/example/game/enemy/Bannane.png");
        //enemy.setIcon(enemyR.getSkin());
        enemy.setOpaque(true);
        this.add(enemy);
        //this.setVisible(true);



        //THREAD
        Thread t = new Thread(() -> enemyMove());
        t.start();
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

    public void sleep(long millis) {
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



            if (PvE(mainChar, enemy)) {
                mainChar.setLocation(10, 500);
                System.out.println("Colision was detected!");
            }
            for (int i = 0; i < shot.length; i++) {
                if (enemy.getX() + enemy.getWidth() >= shot[i].getX() + shot[i].getWidth() && enemy.getY() + enemy.getHeight() >= shot[i].getY() + (shot[i].getHeight() / 2)
                && enemy.getX() <= shot[i].getX() + shot[i].getWidth()&&enemy.getY()<=shot[i].getY()+(shot[i].getHeight()/2)){
                    c=true;

                }
            }
        }
    }
        public boolean PvE(JLabel mobA, JLabel mobB){
        //mobA = Hitbox; mobB = Punkte
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
        for(int x = shot[k1].getX(); x<1900; x+=4){
            //if (c){x=2000;}
            shot[k1].setLocation(x, y);
            sleep(10);

        }
    }


    public void enemyMove() {
        for (double x = 1600; x > -3; x--) {
            double y = Math.sin(x / 100) * 100 + 300;
            enemy.setLocation((int) x, (int) y);
            if (c){x=1600;c=false;}
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

                k++;
                int f = k;
                shot[k].setLocation(mainChar.getX() + 100, mainChar.getY() + 50);

                add(shot[k]);

                Thread t2 = new Thread(()-> shot());
                t2.start();


                sleep(20);
                if(k==9){k=-1;}

                System.out.println("Hallo");
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