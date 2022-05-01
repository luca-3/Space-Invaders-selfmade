package com.example.game.main;

import com.example.game.firuges.Enemy;
import com.example.game.firuges.EnemyE;
import com.example.game.firuges.MobMoveE;
import com.example.game.firuges.Player;
import com.example.game.test.Move;

import javax.swing.*;
import java.awt.*;

//Screen
public class Screen extends JFrame {

    JLabel[] affe = new JLabel[100];
    JLabel[] dwarf = new JLabel[10];
    JLabel[] unicorn = new JLabel[10];
    JLabel[] kitty = new JLabel[10];
    JLabel[] puffy = new JLabel[10];
    int countAffe, countDwarf, countUnicorn, countKitty, countPuffy, countBullet = 0;

    JLabel background;
    JLabel score;
    JLabel lives;
    JLabel level;
    JLabel mainChar;
    JLabel[] shot = new JLabel[10];
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    int k = -1;
    boolean[] hit = new boolean[affe.length];
    boolean[] d = new boolean[shot.length];
    boolean wKey;
    boolean aKey;
    boolean sKey;
    boolean dKey;

    public Screen() {
        setSize(width, height);
        setTitle("Blank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        System.out.println("Screen Dimensions: " + width + "  " + height);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setBackground(Color.black);
        setVisible(true);


        //this.addKeyListener(l);
        Keyboard k = new Keyboard();
        this.addKeyListener(k);

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


    public void updateScore() {while (true)score.setText("Score: " + Player.score);}
    public void updateLives() {while (true)lives.setText("Lives: " + Player.hp);}
    public void updateLevel() {while (true)level.setText("Level: " + EnemyHandler.level);}


    public void start(){ //start the game

        Thread wT = new Thread(()-> w());
        Thread aT = new Thread(()-> a());
        Thread sT = new Thread(()-> s());
        Thread dT = new Thread(()-> d());
        Thread spaceT = new Thread(()-> space());
        Thread upScore = new Thread(()-> updateScore());
        Thread upHP = new Thread(() -> updateLives());

        wT.start();
        aT.start();
        sT.start();
        dT.start();
        spaceT.start();
        upScore.start();
        upHP.start();


        while (true){

            for (int i = 0; i < EnemyHandler.getAnzahlE(); i++) { //EnemyHandler.getAnzahlE() statt .length IMMER BEACHTEN!!!
                if (PvE(mainChar, affe[i])) {
                    mainChar.setLocation(10, 500);
                    Player.editHP(-1);
                }
            }
            for (int i = 0; i < shot.length; i++) {
                for (int j = 0; j < EnemyHandler.getAnzahlE(); j++) {
                    if (PvB(affe[j], shot[i])) {
                        hit[j] = true;
                        d[i] = true;
                        Player.editScore(10);
                    }
                }
            }


        Move.sleep(100); //update Rate Kolliotiona
        }
        //this.update(this.getGraphics());
    }



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
        EnemyE typ = object.getTyp();

        affe[countAffe] = new JLabel();
        affe[countAffe] = temp;
        this.add(affe[countAffe]);
        countAffe++;
        return countAffe -1;


    }

    public void move(int id, EnemyE e, int startX){
        int spawn = affe[id].getY();
        double y1 = spawn;
        for (double x = startX; x > -100; x--) {
            double y =  MobMoveE.bew(e.getMove(), spawn, x, y1);
            if(y < -100){
                y=1200;
            } else if (y> 1200){
                y=-100;
            }
            y1 = y;
            affe[id].setLocation((int) x, (int) y);
            Move.sleep(100/e.getSpeed());
            if (x == 1) x=1800;
            if(hit[id]){
                x = 1800;
                hit[id] = false;
            }

        }
    }
    /*
    public void bannane(int id){
        while (true){
            [100-bannanenZähler] = new JLabel();
            [100-bannanenZähler].setBounds([id].getX(), [id].getY()+100, EnemyE.BANANE.getWidth(), EnemyE.BANANE.getHeight());
            [100-bannanenZähler].setIcon(EnemyE.BANANE.getSkin());
            [100-bannanenZähler].setOpaque(true);
            this.add([100-bannanenZähler]);
            move(100-bannanenZähler, EnemyE.BANANE, [100-bannanenZähler].getX());
            bannanenZähler++;
            Move.sleep(4000);
        }
    }
*/

    public void shot(){
        //int k =  random.nextInt(4);
        int k1 = k;
        int y = shot[k1].getY();
        for(int x = shot[k1].getX(); x<2000; x+=4){
            if (d[k1]){x=2000; d[k1]=false;}
            shot[k1].setLocation(x, y);
            Move.sleep(10);

        }
        countBullet--;
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





    public void w(){while (true){
        if (Keyboard.wKey) {
        if (mainChar.getY()-10>0)mainChar.setLocation(mainChar.getX(), mainChar.getY() - 10);}Move.sleep(20);}}
    public void a(){while (true){
        if (Keyboard.aKey) {
        if (mainChar.getX()-10>0)mainChar.setLocation(mainChar.getX() - 10, mainChar.getY());}Move.sleep(20);}}
    public void s(){while (true){
        if (Keyboard.sKey) {
        if (mainChar.getY()< 1080) mainChar.setLocation(mainChar.getX(), mainChar.getY() + 10);}Move.sleep(20);}}
    public void d(){while (true){
        if(Keyboard.dKey){
            if (mainChar.getX()+10<1920) mainChar.setLocation(mainChar.getX()+ 10, mainChar.getY() );}Move.sleep(20);}}
    public void space(){while (true){
        if(Keyboard.spaceKey){
            if(countBullet <shot.length) {
                k++;
                int f = k;
                shot[k].setLocation(mainChar.getX() + 100, mainChar.getY() + 50);
                add(shot[k]);

                Thread t2 = new Thread(() -> shot());
                t2.start();

                Move.sleep(200);
                if (k == 9) {
                    k = -1;
                }
                countBullet++;
            }
        }
        Move.sleep(20);
    }
    }

    public int getMainX(){return mainChar.getX();}
    public int getMainY(){return mainChar.getY();}
}