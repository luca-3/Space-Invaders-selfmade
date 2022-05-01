package com.example.game.firuges;

public enum Level {
        LEVELBLANK(1 , 2, 0, 0, 0)
    ;

    private int affe;
    private int unicorn;
    private int dwarf;
    private int puffy;
    private int kitty;

    Level(int affe, int unicorn, int dwarf, int puffy, int kitty){
        this.affe = affe;
        this.unicorn = unicorn;
        this.dwarf = dwarf;
        this.puffy = puffy;
        this.kitty = kitty;
    }

    public int getNumberAffe(){return affe;}
    public int getNumberUnicorns(){return unicorn;}
    public int getNumberDwarf() {return dwarf;}
    public int getNumberPuffy() {return puffy;}
    public int getNumberKitty() {return kitty;}

}
