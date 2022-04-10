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




    public static double bew(Enum move, int spawnHight, int x){

        if (MobMove.NMOVE.equals(move)) {
           return spawnHight;

        } else if (MobMove.HDMOVE.equals(move)) {
            return Math.sin(x/5)*50;

        } else if (MobMove.SMOVE.equals(move)) {
           return spawnHight;
        }
        else if (MobMove.PMOVE.equals(move)) {
            return -x*x;
        }
        return 0;
    }
}
