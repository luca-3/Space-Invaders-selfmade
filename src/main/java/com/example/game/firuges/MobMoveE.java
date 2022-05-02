package com.example.game.firuges;

import com.example.game.main.Main;
import com.example.game.main.Screen;


public enum MobMoveE {

    NMOVE(), // Normel Move
    HDMOVE(), // High Down Move
    SMOVE(), // Speed Move
    PMOVE(),// parabel Move
    EHDMOVE(),// Extrem High Down
    VERMOVE(), //Verfolgungsmove
    RAINBOW(),//Regenbogenkotze

    ;
    /*
    So machst du ein Mob Move Enum:
    1. Erstelle ein Name, der deine art von Bewegung beschreibt.
    2. Du musst jetzt mithilfe von spwanHight, x und y eine Formel
    in der Methode bew machen welches y returned.
    Extra: Jetzt kannst du denn MobMoveE in der EnemyE Klasse nutzen.
     */
    static double[] steigung = new double[100];
    static boolean[] abstand1 = new boolean[steigung.length];
    static int counter = 0;
    MobMoveE() {}
    public static void bool(){
        while (true){
            for (int i = 0; i < abstand1.length; i++) {
                abstand1[i] = true;
            }

            Main.sleep(250); //update rate of search
        }
    }


    public static double bew(MobMoveE move, int spawnHight, double x, double y, int id){

        switch (move) {
            case NMOVE, SMOVE -> {
                return spawnHight;
            }
            case HDMOVE-> {
                return Math.sin(x / 100) * 100 + spawnHight;
            }
            case PMOVE-> {
                return -x * x + spawnHight;
            }
            case EHDMOVE-> {
                return Math.sin(x / 100) * 200 + spawnHight;
            }
            case VERMOVE-> {
                Screen s = Main.getScreen();
                int px = s.getMainX();
                int py = s.getMainY();
                if (x + 64 < px) {
                    steigung[id] = 0;
                } else if (abstand1[id]) {
                    steigung[id] = ((py - y) / (px - x));
                    abstand1[id] = false;

                }
                return y - steigung[id];
            }
            case RAINBOW -> {
                double y2 = y - 1;
                if (y2 <= 0) {
                    Main.getScreen().rainbow(id);
                    return 500;
                }
                return y2;
            }

        }
        return 0;
    }
}