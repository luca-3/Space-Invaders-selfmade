package com.example.game.firuges;

public enum Level {
        LEVELBLANK(1 , 1, 0)
    ;
    private int affe;
    private int ziel;
    private int enemyBlank2;

    Level(int affe, int ziel, int enemyBlank2){
        this.affe = affe;
        this.ziel = ziel;
        this.enemyBlank2 = enemyBlank2;


    }

    public int getAffe(){return affe;}
    public int getZiel(){return ziel;}
    public int getEnemyBlank2() {return enemyBlank2;}


}
