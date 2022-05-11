package com.example.game.figures;

import com.example.game.main.EnemyHandler;
import com.example.game.main.Main;
import com.example.game.main.Screen;

import java.util.Arrays;



public enum MobMoveE {

    NMOVE(), // Normal Move
    HDMOVE(), // High Down Move
    BMOVE(), // Bananen Move
    PMOVE(),// parabel Move
    EHDMOVE(),// Extrem High Down
    VERMOVE(), //Verfolgung-mode
    RAINBOW(),//Regenbogen kotze
    LASER(),
    ;
    /*
    So machst du ein Mob Move Enum:
    1. Erstelle ein Name, der deine art von Bewegung beschreibt.
    2. Du musst jetzt mithilfe von spwanHight, x und y eine Formel
    in der Methode bew machen welches y returned.
    Extra: Jetzt kannst du denn MobMoveE in der EnemyE Klasse nutzen.
     */
    static final double[] steigung = new double[100];
    static final boolean[] abstand1 = new boolean[steigung.length];
    static boolean abstand2;
    MobMoveE() {}

    public static void bool(){ //rate of calculation for gradient (unicorn)
       Thread a1 = new Thread(MobMoveE::setAbstand1);
       Thread a2 = new Thread(MobMoveE::setAbstand2);
       a1.start(); a2.start();

    }
    public static void setAbstand1(){
        while (Main.getInstance().isGameRun()){
            Arrays.fill(abstand1, true);
            Main.sleep(250); //update rate of search
        }
    }
    public static void setAbstand2(){
        while (Main.getInstance().isGameRun()){
            abstand2 = true;
            Main.sleep(5000); //update rate of search
        }
    }


    public static double bew(MobMoveE move, int spawnHight, double x, double y, int id){

        switch (move) {
            case NMOVE -> {
                return spawnHight;
            }
            case HDMOVE -> {
                return Math.sin(x / 100) * 100 + spawnHight;
            }
            case BMOVE -> {
                if(abstand2 && x < Main.getScreen().width-200){
                    Thread b = new Thread(()-> Main.getScreen().enemyShot((int)y + 40, (int)x));
                    b.start();
                    abstand2 = false;
                }
                return Math.sin(x / 100) * 100 + spawnHight;
            }
            case PMOVE -> {
                return -x * x + spawnHight;
            }
            case EHDMOVE -> {
                return Math.sin(x / 100) * 200 + spawnHight;
            }
            case VERMOVE -> {
                Screen s = Main.getScreen();
                int px = s.mainChar.getX();
                int py = s.mainChar.getY()-Main.player.getWidth();
                if (x + 64 < px) {
                    steigung[id] = 0;
                } else if (abstand1[id]) {
                    steigung[id] = ((py - y) / (px - x));
                    abstand1[id] = false;

                }
                return y - steigung[id];
            }
            case RAINBOW -> {
                double y2 = y - EnemyHandler.enemies.get(id).getSpeed();
                if (y2 <= 0) {
                    return  Main.getScreen().rainbow(id);
                }
                return y2;
            }
            case LASER -> {
                Main.getScreen().spaceCat((int)y, id);
                return y;
            }
        }
        return 0;
    }

}