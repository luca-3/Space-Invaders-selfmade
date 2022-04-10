package com.example.game.test;

public enum MobMove {

    NMOVE(1), //Normel Move
    HDMOVE(1), // High Down Move
    SMOVE(2), // Speed Move
    PMOVE(1) // parabel Move
    ;


    private final int speed;


    MobMove(int speed){
        this.speed = speed;

    }
    public int getSpeed(){
        return this.speed;
    }




    public static double bew(Enum move, int x){
        double y;

        if (MobMove.NMOVE.equals(move)) {
           return y = 0;

        } else if (MobMove.HDMOVE.equals(move)) {
            return y = Math.sin(x);

        } else if (MobMove.SMOVE.equals(move)) {
           return y = 0;
        }
        else if (MobMove.PMOVE.equals(move)) {
            return y = -x*x;
        }
        return 0;
    }
}
