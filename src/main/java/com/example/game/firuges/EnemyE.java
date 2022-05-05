package com.example.game.firuges;

import javax.swing.*;

import java.util.List;


public enum EnemyE {
    AFFE(100, 200, 3,  2, MobMoveE.BMOVE,"src/main/resources/com/example/game/enemy/Spaceship.png"),
    UNICORN(64, 64, 2 , 4, MobMoveE.VERMOVE, "src/main/resources/com/example/game/enemy/Test.png"),
    DWARF(75, 125, 1, 3, MobMoveE.RAINBOW, "src/main/resources/com/example/game/enemy/Zwerg.png"),
    PUFFY(50, 50, 1, 6, MobMoveE.NMOVE, "src/main/resources/com/example/game/enemy/Spaceship.png"),
    KITTY(75, 75, 1, 10000, MobMoveE.LASER, "src/main/resources/com/example/game/enemy/Kitty.png"),

    ;
    /*
    So machst du ein Enemy Enum:
    1. Erstelle ein Enum unter den Anderen wie oben schon gemacht.
    2. Ergänzt du diesen Enemy in Level (Enum) dazu gehört Konstruktor und get Methode.
    3. Als Nächstes in EnemyE.getSize das passende case ergänzen.
        Glückwunsch du hast Erfolgreich ein neuen Enemy erstellt.
     */

    private final int width;
    private final int height;
    private final int speed;// Max speed = 100
    private final Icon skin;
    private final int hp;
    private final MobMoveE move;

    public static int getSize(EnemyE e, Level l){
        switch (e){
            case AFFE -> {return l.getNumberAffe();}
            case UNICORN -> {return l.getNumberUnicorns();}
            case DWARF -> {return l.getNumberDwarf();}
            case PUFFY -> {return l.getNumberPuffy();}
            case KITTY -> {return l.getNumberKitty();}
        }
        return 0;
    }

     EnemyE(int width, int height, int hp, int speed,MobMoveE m, String skin) {
        this.width = width;
        this.height = height;
        this.skin = new ImageIcon(skin); // creates icon object from incoming path
        this.hp = hp;
        this.move = m;
        this.speed = speed;
    }

    public int getSpeed() {return speed;}
    public int getHp() {return hp;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public MobMoveE getMove(){return move;}
    public Icon getSkin() {return skin;}



    public static int getSpeed(EnemyE a) {return a.getSpeed();}
    public static int getHp(EnemyE a) {return a.getHp();}
    public static int getWidth(EnemyE a) {return a.getWidth();}
    public static int getHeight(EnemyE a) {return a.getHeight();}
    public static MobMoveE getMove(EnemyE a){return a.getMove();}
    public static Icon getSkin(EnemyE a) {return a.getSkin();}

    public static final List<EnemyE> VALUES = List.of(values());
    public static final int SIZE = VALUES.size();
}



