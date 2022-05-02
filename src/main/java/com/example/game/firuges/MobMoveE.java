package com.example.game.firuges;

import com.example.game.main.Main;
import com.example.game.main.Screen;
import com.example.game.test.Move;

public enum MobMoveE {

    NMOVE(), // Normel Move
    HDMOVE(), // High Down Move
    SMOVE(), // Speed Move
    PMOVE(),// parabel Move
    EHDMOVE(),// Extrem High Down
    VERMOVE(), //Verfolgungsmove


    ;

    static double[] steigung = new double[1];
    static boolean[] abstand1 = new boolean[steigung.length];
    static int counter = 0;

    MobMoveE() {

    }
    public static void bool(){
        while (true){
            for (int i = 0; i < abstand1.length; i++) {
                abstand1[i] = true;
            }

            Move.sleep(250); //update rate of search
        }
    }


    public static double bew(MobMoveE move, int spawnHight, double x, double y){

        if (MobMoveE.NMOVE.equals(move)) {
           return spawnHight;

        } else if (MobMoveE.HDMOVE.equals(move)) {
            return Math.sin(x/100)*100+spawnHight;

        } else if (MobMoveE.SMOVE.equals(move)) {
           return spawnHight;
        }
        else if (MobMoveE.PMOVE.equals(move)) {
            return -x*x+spawnHight;
        }else if (MobMoveE.EHDMOVE.equals(move)) {
            return Math.sin(x / 100) * 200 + spawnHight;
        }else if(MobMoveE.VERMOVE.equals(move)){
            Screen s = Main.getScreen();
            int px = s.getMainX();
            int py = s.getMainY();
            if(x+64<px){
                steigung[counter] = 0;
            } else if (abstand1[counter]){
                steigung[counter] = ((py-y)/(px-x));
                abstand1[counter] = false;
                counter++;
                if (counter == steigung.length) {
                    counter = 0;
                }
            }
            return y-steigung[counter];
        }
        return 0;
    }
}