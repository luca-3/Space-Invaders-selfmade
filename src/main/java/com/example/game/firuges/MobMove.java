package com.example.game.firuges;

public enum MobMove {

    NMOVE(1), //Normel Move
    HDMOVE(1), // High Down Move
    SMOVE(2), // Speed Move
    PMOVE(1),// parabel Move
    EHDMOVE(1)// Extrem Highdown
    ;


    private final int speed;


    MobMove(int speed){
        this.speed = speed;

    }
    public int getSpeed(){
        return this.speed;
    }




    public static double bew(Enum move, int spawnHight, double x){

        if (MobMove.NMOVE.equals(move)) {
           return spawnHight;

        } else if (MobMove.HDMOVE.equals(move)) {
            return Math.sin(x/100)*100+spawnHight;

        } else if (MobMove.SMOVE.equals(move)) {
           return spawnHight;
        }
        else if (MobMove.PMOVE.equals(move)) {
            return -x*x+spawnHight;
        }else if (MobMove.EHDMOVE.equals(move)) {
            return Math.sin(x / 100) * 200 + spawnHight;
        }
        return 0;
    }
}