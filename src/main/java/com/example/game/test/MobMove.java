package com.example.game.test;

public enum MobMove {

    NMOVE(1),
    HDMOVE(1)
    ;

    private final int speed;


    MobMove(int speed){
        this.speed = speed;

    }
    public int gibSpeed(){
        return this.speed;
    }




    public static double bew(Enum move, int n, int x){
        double y;

        if (MobMove.NMOVE.equals(move)) {
            y = n;
            return y;
        } else if (MobMove.HDMOVE.equals(move)) {
            y = Math.sin(x) + 2 + n;
            return y;
        }
        return 0;
    }
}
