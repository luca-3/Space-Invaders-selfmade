package com.example.game.main;

import com.example.game.figures.Enemy;
import com.example.game.figures.EnemyE;
import com.example.game.figures.MobMoveE;
import com.example.game.figures.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Screen extends JFrame {
    public JLabel[] enemyArr = new JLabel[100];
    int countEnemy, countBullet = 0;
    JLabel score, lives, level, pauseJ, startJ;
    public JLabel mainChar;
    JLabel[] shot = new JLabel[10]; //number of shots available
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int k = -1;
    boolean[] hit = new boolean[enemyArr.length];
    boolean[] d = new boolean[shot.length];
    public boolean levelEnd;
    boolean pause = false;


    public Screen() {
        //initial settings for the window
        this.setSize(this.width, this.height);
        this.setTitle("Blank");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.BLACK);
        System.out.println("Screen Dimensions: " + width + "  " + height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.black);
        this.setVisible(true);
        Keyboard k = new Keyboard();
        this.addKeyListener(k);

        //init settings for GUI elements, wich are always on the screen
        this.score = new JLabel("Score: " + Player.score);
        this.score.setBounds(10, 10, 100, 20);
        this.score.setForeground(Color.white);
        this.add(score);

        this.lives = new JLabel("Lives: " + Player.hp);
        this.lives.setBounds(10, 30, 100, 20);
        this.lives.setForeground(Color.white);
        this.add(lives);

        this.level = new JLabel("Level: " + Main.getEnemyHandler().getLevel());
        this.level.setBounds(10, 50, 100, 20);
        this.level.setForeground(Color.white);
        this.add(level);
        /*
        levelType = new JLabel("Level: " + EnemyHandler.levelE);
        levelType.setBounds(10, 70, 180, 20);
        levelType.setForeground(Color.white);
        add(levelType);
         */

        this.pauseJ = new JLabel("Pause");
        this.pauseJ.setBounds(-100, -100, 100, 40);
        this.pauseJ.setForeground(Color.white);
        this.add(pauseJ);

        this.startJ = new JLabel("Drücke k zum starten");
        this.startJ.setBounds(width/2-100, height/2, 200, 40);
        this.startJ.setForeground(Color.white);
        this.add(startJ);

        this.mainChar = new JLabel();
        this.mainChar.setBounds(100, 100, Main.player.getWidth(), Main.player.getWidth());
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/TempMain.png");
        this.mainChar.setIcon(icon);
        this.mainChar.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.mainChar.setOpaque(true);
        this.add(mainChar);



        //TODO:false nicht mehr notwendig, wenn Klassensystem steht
        //init generation of bullets off-screen
        for (int i = 0; i < this.shot.length; i++) {
            this.shot[i] = new JLabel();
            this.shot[i].setBounds(0, -20, 40, 20);

            if (i == 2) {
                this.shot[i].setBackground(Color.MAGENTA);
            } else {
                this.shot[i].setBackground(Color.ORANGE);
            }
            this.shot[i].setOpaque(true);
            add(this.shot[i]);
        }

    }
    //TODO:false in Methoden aufteilen: threathing (Main), hpUpdater (Player), checkHits (EnemyHandler)
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
       // Thread levelType = new Thread(this::updateLevelType);

        wT.start();
        aT.start();
        sT.start();
        dT.start();
        spaceT.start();
        upScore.start();
        upHP.start();
        upLevel.start();
        endLevel.start();
       // levelType.start();

        while (Main.getInstance().isGameRun()) {

            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) { //EnemyHandler.getAnzahlE() statt. length IMMER BEACHTEN!
                if (EnemyHandler.rectCollision(this.mainChar, this.enemyArr[i])) {
                    this.mainChar.setLocation(10, 10);
                    Player.hp -= 1;
                }
            }
            for (int i = 0; i < this.shot.length; i++) {
                for (int j = 0; j < EnemyHandler.getAnzahlE(); j++) {
                    if (EnemyHandler.rectCollision(this.enemyArr[j], this.shot[i])) {
                        EnemyHandler.enemies.get(j).hpHit(1);
                        this.d[i] = true;
                        Player.score += 10;
                    }
                }
            }
            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) {
                if(EnemyHandler.enemies.get(i).getHp()<=0){
                    this.hit[i] = true;
                }
            }
            if(Player.hp <= 0) Main.setGameRun(false);

            Main.sleep(10); //update rate collision detection
        }

    }

    public void updateScore() {
        while (Main.getInstance().isGameRun()) this.score.setText("Score: " + Player.score);
    }
    public void updateLives() {
        while (Main.getInstance().isGameRun()) this.lives.setText("Lives: " + Player.hp);
    }
    public void updateLevel() {
        while (Main.getInstance().isGameRun()) this.level.setText("Level: " + Main.getEnemyHandler().getLevel());
    }
    //public void updateLevelType() {while (Main.getInstance().isGameRun()) levelType.setText("Level Type: " + EnemyHandler.levelE);}

    //TODO:true bewegen nach Level
    public void levelEnd() {
        Main.sleep(5000);
        while (Main.getInstance().isGameRun()) {
            int count = 0;
            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) {
                if (this.enemyArr[i].getX() < -10) {
                    count++;
                }
            }
            if (EnemyHandler.getAnzahlE() > 1){
                if (count == EnemyHandler.getAnzahlE()) {
                    this.levelEnd = true;
                    this.countEnemy = 0;
                    Main.getEnemyHandler().setLevel(Main.getEnemyHandler().getLevel() + 1);
                    System.out.println("level End");
                    Main.sleep(1000);

                }
            }
            Main.sleep(500);
        }
    }

    //TODO:true Umbauen, dass die Funktionalität, der von GameRun eintspricht
    public void setPause(){
        if (this.pause){
            this.pause = false;
            this.pauseJ.setLocation(-100, -100);
        }else {
            this.pause = true;
            this.pauseJ.setLocation(this.width/2, this.height/2);
        }

    }

    //TODO:false In abstrakte Klassenstruktur aufnehmen (so dass Enemy ein child von GameObjects ist)
    //Enemy to JLabel
    public int addEnemy(Enemy object) {
        JLabel temp = new JLabel();
        temp.setBounds(object.getX(), object.getY(), object.getWidth(), object.getHeight());
        temp.setIcon(object.getSkin());
        temp.setOpaque(true);
        temp.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.enemyArr[this.countEnemy] = temp;
        this.add(this.enemyArr[this.countEnemy]);
        this.countEnemy++;
        return this.countEnemy - 1;
    }


    //TODO:false nach EnemyHandler bewegen
    public void move(int id, EnemyE e, int startX) {
        int spawn = this.enemyArr[id].getY();
        double y1 = spawn;
        for (double x = startX; x > -250; x-=e.getSpeed()) {
            while (this.pause){
                Main.sleep(1000);
            }
            double y = MobMoveE.bew(e.getMove(), spawn, x, y1, id);
            if (y < -100) {
                y = 1200;
            } else if (y > 1200) {
                y = -100;
            }
            if (!Main.getInstance().isGameRun()) x = -300;
            y1 = y;
            this.enemyArr[id].setLocation((int) x, (int) y);
            Main.sleep(10);

            if (this.hit[id]) {
                x = -200;
                this.hit[id] = false;
            }
        }
    }

    //TODO:false ist in abstrakter Klassenstruktur nicht mehr notwendig (GameObject Shot wir dann durch move() bewegt
    public void shot() {
        //int k =  random.nextInt(4);
        int k1 = this.k;
        int y = this.shot[k1].getY();
        for (int x = this.shot[k1].getX(); x < this.width; x += 6) {
            if (this.d[k1]) {
                x = this.width-1;
                this.d[k1] = false;
            }
            this.shot[k1].setLocation(x, y);
            while (this.pause) Main.sleep(100);
            Main.sleep(10);

        }
        this.shot[k1].setLocation(3000, -1000);
        this.countBullet--;
    }

    //TODO:false
    public int rainbow(int id){
        Random random = new Random();

        JLabel rainbow = new JLabel();
        int z = this.enemyArr[id].getX()-80;
        rainbow.setBounds(z, 10, 80, 80);
        Icon icon = new ImageIcon("src/main/resources/com/example/game/enemy/Rainbow.png");
        rainbow.setIcon(icon);
        //rainbow.setBackground(Color.RED);
        rainbow.setOpaque(true);
        this.add(rainbow);
        for (int i = 0; i < this.height; i+= 10) {
            rainbow.setLocation(z, i);
            while (this.pause) Main.sleep(1000);
            if(this.hit[id]) this.enemyArr[id].setLocation(-200, 0);
            if(EnemyHandler.rectCollision(rainbow, this.mainChar)) {
                this.mainChar.setLocation(10,10);
                Player.hp--;}
            Main.sleep(10);
        }
        rainbow.setLocation(-300, 0);
        this.remove(rainbow);
        int r = random.nextInt(this.height-200);
        for (int y = 0; y < r; y++) {
            while (this.pause) Main.sleep(100);
            this.enemyArr[id].setLocation(z, y);
            if(this.hit[id])return y;
            Main.sleep(5);
        }
        return r;
    }

    public void spaceCat(int y, int id){
        for (int i = this.width-60; i > this.width-220 ; i--) {
            this.enemyArr[id].setLocation(i, y);
            while (this.pause) Main.sleep(100);
            Main.sleep(25);
        }

        enemyShot(y+30, this.width-220);
        for (int i = this.width-220; i < this.width; i+=3) {
            this.enemyArr[id].setLocation(i, y);
            while (this.pause) Main.sleep(100);
            Main.sleep(25);
        }
        this.enemyArr[id].setLocation(-300, y);
        EnemyHandler.moveT[id].stop();
    }

    //TODO:false in Klassensystem nicht mehr notwendig
    public void enemyShot(int y, int x) {
        JLabel laser = new JLabel();
        laser.setBounds(0, -20, 40, 20);
        laser.setBackground(Color.MAGENTA);
        laser.setOpaque(true);
        this.add(laser);
        for (int i = x; i > -100 ; i-=10) {
            laser.setLocation(i, y);
            if(EnemyHandler.rectCollision(this.mainChar, laser)){
                this.mainChar.setLocation(10, 10);
                Player.hp -= 1;
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(5);
        }
        remove(laser);
    }

    /*
    public void enemyShot(int y, int x, int width, int height, String skin ) {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("src/main/resources/com/example/game/enemy/Banane.gif")));
        JLabel laser = new JLabel(imageIcon);
        ((ImageIcon) imageIcon).setImageObserver(laser);
        laser.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        laser.setBounds(200, 200, width, height);
        laser.setOpaque(true);
        this.add(laser);
        Main.sleep(10000);

        for (int i = x; i > -100 ; i-=10) {
            laser.setLocation(i, y);
            if(PvB(this.mainChar, laser)){
                this.mainChar.setLocation(10, 10);
                Player.hp -= 1;
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(5);
        }
        remove(laser);
    }

    */


    //TODO:false Klassensystem notwendig; dann dort in Player
    private void w() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.wKey) {
                if (this.mainChar.getY() - 10 > 0) mainChar.setLocation(mainChar.getX(), mainChar.getY() - Main.player.getSpeed());
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void a() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.aKey) {
                if (this.mainChar.getX() - 10 > 0) this.mainChar.setLocation(this.mainChar.getX() - Main.player.getSpeed(), this.mainChar.getY());
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void s() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.sKey) {
                if (this.mainChar.getY() < height) this.mainChar.setLocation(this.mainChar.getX(), this.mainChar.getY() + Main.player.getSpeed());
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void d() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.dKey) {
                if (this.mainChar.getX() + 10 < 1840) this.mainChar.setLocation(this.mainChar.getX() + Main.player.getSpeed(), this.mainChar.getY());
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(20);
        }
    }
    private void space() {
        while (Main.getInstance().isGameRun()) {
            if (Keyboard.spaceKey) {
                if (this.countBullet < this.shot.length) {
                    this.k++;
                    this.shot[this.k].setLocation(this.mainChar.getX() + 100, this.mainChar.getY() + 50);
                    add(this.shot[k]);

                    Thread t2 = new Thread(this::shot);
                    t2.start();

                    Main.sleep(200);
                    if (this.k == this.shot.length - 1) {
                        this.k = -1;
                    }
                    this.countBullet++;
                }
            }
            while (this.pause) Main.sleep(100);
            Main.sleep(20);
        }
    }

}