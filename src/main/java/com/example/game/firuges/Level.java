package com.example.game.firuges;

public enum Level {
        LEVELBLANK(3 , 0, 0)
    ;
    private int affe;
    private int enemyBlank1;
    private int enemyBlank2;

    Level(int affe, int enemyBlank1, int enemyBlank2){
        this.affe = affe;
        this.enemyBlank1 = enemyBlank1;
        this.enemyBlank2 = enemyBlank2;


    }

    public int getAffe(){return affe;}
    public int getEnemyBlank1(){return enemyBlank1;}
    public int getEnemyBlank2() {return enemyBlank2;}


}
