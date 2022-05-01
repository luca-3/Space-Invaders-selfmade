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

    static double steigung = 0;
    static boolean abstand1 = false;


    MobMoveE() {

    }
    public static void bool(){
        while (true){
            abstand1 = true;
            Move.sleep(2500);
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
                steigung = 0;
            } else if (abstand1){
                steigung = ((py-y)/(px-x));
                abstand1 = false;
            }
            return y-steigung;
        }
        return 0;
    }
}