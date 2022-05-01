package com.example.game.firuges;

public enum Level {
        LEVELBLANK(1 , 2, 0)
    ;

    private int affe;
    private int unicorn;
    private int enemyBlank2;

    Level(int affe, int unicorn, int enemyBlank2){
        this.affe = affe;
        this.unicorn = unicorn;
        this.enemyBlank2 = enemyBlank2;
    }

    public int getNumberAffe(){return affe;}
    public int getNumberUnicorns(){return unicorn;}
    public int getNumberEnemyBlank2() {return enemyBlank2;}

}
