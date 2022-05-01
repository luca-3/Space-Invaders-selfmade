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


    ;

    static double steigung = 0;



    MobMoveE() {

    }



    public static double bew(Enum move, int spawnHight, double x, double y){

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
            int px = s.getMainX(); int py = s.getMainY();
            if(x+64<px){steigung = 0;}
            else if (x%500==0){steigung = ((py-y)/(px-x));}
            return y-steigung;
        }
        return 0;
    }
}