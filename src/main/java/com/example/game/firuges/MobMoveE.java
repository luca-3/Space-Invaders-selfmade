package com.example.game.firuges;

public enum MobMoveE {

    NMOVE(EnemyE.AFFE), // Normel Move
    HDMOVE(null), // High Down Move
    SMOVE(null), // Speed Move
    PMOVE(null),// parabel Move
    EHDMOVE(EnemyE.BANANE)// Extrem High Down
    ;


    private final int speed;


    MobMoveE(EnemyE enemy) {
        this.speed = enemy.getSpeed();
    }



    public static double bew(Enum move, int spawnHight, double x){

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
        }
        return 0;
    }
}