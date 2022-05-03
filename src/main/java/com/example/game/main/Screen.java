package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.MobMoveE;
import com.example.game.firuges.Player;
import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    JLabel[] enemyArr = new JLabel[100];
    int countEnemy, countBullet = 0;
    JLabel score;
    JLabel lives;
    JLabel level;
    JLabel levelType;
    JLabel pauseJ;
    public JLabel mainChar;
    JLabel[] shot = new JLabel[10]; //number of shots available
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int k = -1;
    boolean[] hit = new boolean[enemyArr.length];
    boolean[] d = new boolean[shot.length];
    public boolean levelEnd;
    boolean pause= false;

    public Screen() {
        //initial settings for the window
        setSize(width, height);
        setTitle("Blank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.black);
        System.out.println("Screen Dimensions: " + width + "  " + height);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(Color.black);
        setVisible(true);
        Keyboard k = new Keyboard();
        this.addKeyListener(k);

        //init settings for GUI elements, wich are always on the screen
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

        levelType = new JLabel("Level: " + EnemyHandler.levelE);
        levelType.setBounds(10, 70, 180, 20);
        levelType.setForeground(Color.white);
        add(levelType);

        pauseJ = new JLabel("Pause");
        pauseJ.setBounds(-100, -100, 100, 40);
        pauseJ.setForeground(Color.white);
        add(pauseJ);

        mainChar = new JLabel();
        mainChar.setBounds(100, 100, Main.player.getWidth(), Main.player.getWidth());
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Spaceship.png");
        mainChar.setIcon(icon);
        mainChar.setOpaque(true);
        add(mainChar);

        //init generation of bullets off-screen
        for (int i = 0; i < shot.length; i++) {
            shot[i] = new JLabel();
            shot[i].setBounds(0, -20, 40, 20);

            if (i == 2) {
                shot[i].setBackground(Color.MAGENTA);
            } else {
                shot[i].setBackground(Color.ORANGE);
            }
            shot[i].setOpaque(true);
            add(shot[i]);
        }

    }

    public void start() { //start the game

        Thread wT = new Thread(this::w);
        Thread aT = new Thread(this::a);
        Thread sT = new Thread(this::s);
        Thread dT = new Thread(this::d);
        Thread spaceT = new Thread(this::space);
        Thread upScore = new Thread(this::updateScore);
        Thread upHP = new Thread(this::updateLives);
        Thread upLevel = new Thread(this::updateLevel);
        Thread endLevel = new Thread(this::levelEnd);
        Thread levelType = new Thread(this::updateLevelType);

        wT.start();
        aT.start();
        sT.start();
        dT.start();
        spaceT.start();
        upScore.start();
        upHP.start();
        upLevel.start();
        endLevel.start();
        levelType.start();


        while (true) {

            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) { //EnemyHandler.getAnzahlE() statt. length IMMER BEACHTEN!
                if (PvE(mainChar, enemyArr[i])) {
                    mainChar.setLocation(10, 10);
                    Player.editHP(-1);
                }
            }
            for (int i = 0; i < shot.length; i++) {
                for (int j = 0; j < EnemyHandler.getAnzahlE(); j++) {
                    if (PvB(enemyArr[j], shot[i])) {
                        EnemyHandler.enemies.get(j).hpHit(1);
                        d[i] = true;
                        Player.editScore(10);
                    }
                }
            }
            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) {
                if(EnemyHandler.enemies.get(i).getHp()<=0){
                    hit[i] = true;
                }
            }

            Main.sleep(10); //update rate collision detection
        }
        //this.update(this.getGraphics());
    }

    public void updateScore() {
        while (true) score.setText("Score: " + Player.score);
    }
    public void updateLives() {
        while (true) lives.setText("Lives: " + Player.hp);
    }
    public void updateLevel() {
        while (true) level.setText("Level: " + EnemyHandler.level);
    }
    public void updateLevelType() {
        while (true) levelType.setText("Level Type: " + EnemyHandler.levelE);
    }


    public void levelEnd() {
        while (true) {
            int count = 0;
            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) {
                if (enemyArr[i].getX() < -10) {
                    count++;
                }
            }
            if (EnemyHandler.getAnzahlE() > 1){
                if (count == EnemyHandler.getAnzahlE()) {
                    levelEnd = true;
                    countEnemy = 0;
                    EnemyHandler.level++;
                    System.out.println("level End");
                    Main.sleep(1000);

                }
            }
            Main.sleep(500);
        }
    }

    public void setPause(){
        if (pause){
            pause = false;
            pauseJ.setLocation(-100, -100);
        }else {
            pause = true;
            pauseJ.setLocation(width/2, height/2);
        }

    }

    //Enemy to JLabel
    public int addEnemy(Enemy object) {
        JLabel temp = new JLabel();
        temp.setBounds(object.getX(), object.getY(), object.getWidth(), object.getHeight());
        temp.setIcon(object.getSkin());
        temp.setOpaque(true);

        enemyArr[countEnemy] = new JLabel();
        enemyArr[countEnemy] = temp;
        this.add(enemyArr[countEnemy]);
        countEnemy++;
        return countEnemy - 1;
    }

    public void move(int id, EnemyE e, int startX) {
        int spawn = enemyArr[id].getY();
        double y1 = spawn;
        for (double x = startX; x > -250; x-=e.getSpeed()) {
            while (pause){
                Main.sleep(1000);
            }
            double y = MobMoveE.bew(e.getMove(), spawn, x, y1, id);
            if (y < -100) {
                y = 1200;
            } else if (y > 1200) {
                y = -100;
            }
            y1 = y;
            enemyArr[id].setLocation((int) x, (int) y);
            Main.sleep(10);
            //if (x == 1) x=1800;
            if (hit[id]) {
                x = -200;
                hit[id] = false;
            }
        }
    }

    public void shot() {
        //int k =  random.nextInt(4);
        int k1 = k;
        int y = shot[k1].getY();
        for (int x = shot[k1].getX(); x < 2000; x += 4) {
            if (d[k1]) {
                x = 3000;
                d[k1] = false;
            }
            shot[k1].setLocation(x, y);
            while (pause) Main.sleep(100);
            Main.sleep(10);

        }
        shot[k1].setLocation(3000, -1000);
        countBullet--;
    }
    public void rainbow(int id){
        JLabel rainbow =new JLabel();
        int z = enemyArr[id].getX()-80;
        rainbow.setBounds(z, 10, 80, 80);
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Rainbow.png");
        rainbow.setIcon(icon);
        //rainbow.setBackground(Color.RED);
        rainbow.setOpaque(true);
        this.add(rainbow);
        for (int i = 0; i < height; i+= 10) {
            rainbow.setLocation(z, i);
            while (pause) Main.sleep(1000);
            if(hit[id]) enemyArr[id].setLocation(-300, 0);
            if(PvE(rainbow, mainChar)) {
                mainChar.setLocation(10,10);
                Player.hp--;}
            Main.sleep(10);
        }
        rainbow.setLocation(-300, 0);
        this.remove(rainbow);
        for (int y = 0; y < 500; y++) {
            while (pause) Main.sleep(100);
            if(hit[id])return;
            enemyArr[id].setLocation(z, y);
            Main.sleep(5);
        }
    }

    public boolean PvB(JLabel Player, JLabel Bullet) {
        return Player.getX() + Player.getWidth() >= Bullet.getX() + Bullet.getWidth() && Player.getY() + Player.getHeight() >= Bullet.getY() + (Bullet.getHeight() / 2)
                && Player.getX() <= Bullet.getX() + Bullet.getWidth() && Player.getY() <= Bullet.getY() + (Bullet.getHeight() / 2) ||
                Player.getX() + Player.getWidth() >= Bullet.getX() && Player.getY() + Player.getHeight() >= Bullet.getY() + (Bullet.getHeight() / 2)
                        && Player.getX() <= Bullet.getX() && Player.getY() <= Bullet.getY() + (Bullet.getHeight() / 2);
    }
    public boolean PvE(JLabel mobA, JLabel mobB) {
        //mobA = hitbox; mobB = points
        final int hitboxWidth = mobB.getWidth();
        final int hitboxHeight = mobB.getHeight();
        final int X_OBJ_ONE = mobA.getX();
        final int Y_OBJ_ONE = mobA.getY();
        final int X_OBJ_TWO = mobB.getX();
        final int Y_OBJ_TWO = mobB.getY();
        // Mitte Unten
        return X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO || //Oben Links
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight || //Unten Links
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO || // Oben Rechts
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight || //Unten Rechts
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight / 2 && X_OBJ_ONE <= X_OBJ_TWO && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight / 2 || // Mitte Links
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight / 2 && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight / 2 || // Mitte Rechts
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth / 2 && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO && X_OBJ_ONE <= X_OBJ_TWO + hitboxWidth / 2 && Y_OBJ_ONE <= Y_OBJ_TWO || // Mitte Oben
                X_OBJ_ONE + hitboxWidth >= X_OBJ_TWO + hitboxWidth / 2 && Y_OBJ_ONE + hitboxWidth >= Y_OBJ_TWO + hitboxHeight && X_OBJ_ONE <= X_OBJ_TWO / 2 + hitboxWidth && Y_OBJ_ONE <= Y_OBJ_TWO + hitboxHeight;
    }

    public void w() {
        while (true) {
            if (Keyboard.wKey) {
                if (mainChar.getY() - 10 > 0) mainChar.setLocation(mainChar.getX(), mainChar.getY() - 10);
            }
            while (pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    public void a() {
        while (true) {
            if (Keyboard.aKey) {
                if (mainChar.getX() - 10 > 0) mainChar.setLocation(mainChar.getX() - 10, mainChar.getY());
            }
            while (pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    public void s() {
        while (true) {
            if (Keyboard.sKey) {
                if (mainChar.getY() < height) mainChar.setLocation(mainChar.getX(), mainChar.getY() + 10);
            }
            while (pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    public void d() {
        while (true) {
            if (Keyboard.dKey) {
                if (mainChar.getX() + 10 < width) mainChar.setLocation(mainChar.getX() + 10, mainChar.getY());
            }
            while (pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    public void space() {
        while (true) {
            if (Keyboard.spaceKey) {
                if (countBullet < shot.length) {
                    k++;
                    shot[k].setLocation(mainChar.getX() + 100, mainChar.getY() + 50);
                    add(shot[k]);

                    Thread t2 = new Thread(this::shot);
                    t2.start();

                    Main.sleep(200);
                    if (k == shot.length - 1) {
                        k = -1;
                    }
                    countBullet++;
                }
            }
            while (pause) Main.sleep(100);
            Main.sleep(20);
        }
    }

}