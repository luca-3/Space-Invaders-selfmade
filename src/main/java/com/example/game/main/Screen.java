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
    JLabel[] arrJLabel = new JLabel[100];
    Thread[] arrThread = new Thread[arrJLabel.length];
    JLabel background;
    JLabel score;
    JLabel lives;
    JLabel level;
    JLabel mainChar;
    JLabel[] shot = new JLabel[10];
    public static int width = 1500;
    public static int height = 800;
    public boolean gameOver = false;
    public boolean gameWon = false;
    int zähler = 0;
    int shotZähler = 0;
    int bannanenZähler = 1;
    int k = -1;
    boolean[] c = new boolean[arrJLabel.length];
    boolean[] d = new boolean[shot.length];


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

        for (int i = 0; i < shot.length; i++) {
            shot[i] = new JLabel();
            shot[i].setBounds(0,-20,40,20);

            if(i==2){shot[i].setBackground(Color.MAGENTA);}
            else {shot[i].setBackground(Color.ORANGE);}
            shot[i].setOpaque(true);
            add(shot[i]);
        }

    }

    public void addObject(JLabel object) {this.add(object);}
    public void removeObject(JLabel object) {objectsList.remove(object);remove(object);}

    public void updateScore() {score.setText("Score: " + Player.score);}
    public void updateLives() {lives.setText("Lives: " + Player.hp);}
    public void updateLevel() {level.setText("Level: " + EnemyHandler.level);}



    public void start(){ //start the game
        while (true){

            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) { //EnemyHandler.getAnzahlE() statt arrJLabel.length IMMER BEACHTEN!!!
                if (PvE(mainChar, arrJLabel[i])) {
                    mainChar.setLocation(10, 500);

                }
            }


            for (int i = 0; i < shot.length; i++) {
                for (int j = 0; j < EnemyHandler.getAnzahlE(); j++) {
                    if (PvB(arrJLabel[j], shot[i])) {
                         c[j] = true;
                         d[i] = true;

                    }
                }
            }


        Move.sleep(2);
        }
        //this.update(this.getGraphics());
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

    public void move(int id, EnemyE e, int startX){
        int spawn = arrJLabel[id].getY();
        double y1 = spawn;
        for (double x = startX; x > -100; x--) {
           double y =  MobMoveE.bew(e.getMove(), spawn, x, y1);
            y1 = y;
            arrJLabel[id].setLocation((int) x, (int) y);
            Move.sleep(100/e.getSpeed());
            if (x == 1){x=1800;}
            if(c[id]){x= 1800; c[id]=false;}
        }
    }
    public void bannane(int id){
        while (true){
            arrJLabel[100-bannanenZähler] = new JLabel();
            arrJLabel[100-bannanenZähler].setBounds(arrJLabel[id].getX(), arrJLabel[id].getY()+100, EnemyE.BANANE.getWidth(), EnemyE.BANANE.getHeight());
            arrJLabel[100-bannanenZähler].setIcon(EnemyE.BANANE.getSkin());
            arrJLabel[100-bannanenZähler].setOpaque(true);
            this.add(arrJLabel[100-bannanenZähler]);
            move(100-bannanenZähler, EnemyE.BANANE, arrJLabel[100-bannanenZähler].getX());
            bannanenZähler++;
            Move.sleep(4000);
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
                if (mainChar.getY() - 10 > 0) {
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

                    Move.sleep(20);
                    if (k == 9) {
                        k = -1;
                    }
                    shotZähler++;

                }
        }
    }

    public void shot(){
        //int k =  random.nextInt(4);
        int k1 = k;
        int y = shot[k1].getY();
        for(int x = shot[k1].getX(); x<2000; x+=4){
            if (d[k1]){x=2000; d[k1]=false;}
            shot[k1].setLocation(x, y);
            Move.sleep(10);

        }
        shotZähler--;
    }
    public boolean PvB(JLabel Player, JLabel Bullet){
        if (Player.getX() + Player.getWidth() >= Bullet.getX() + Bullet.getWidth() && Player.getY() + Player.getHeight() >= Bullet.getY() + (Bullet.getHeight() / 2)
                && Player.getX() <= Bullet.getX() + Bullet.getWidth() &&Player.getY()<=Bullet.getY()+(Bullet.getHeight()/2)||
                Player.getX() + Player.getWidth() >= Bullet.getX() && Player.getY() + Player.getHeight() >= Bullet.getY() + (Bullet.getHeight() / 2)
                        && Player.getX() <= Bullet.getX()  &&Player.getY()<=Bullet.getY()+(Bullet.getHeight()/2)){return true;}
        return false;
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


    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public int getMainX(){return mainChar.getX();}
    public int getMainY(){return mainChar.getY();}
}