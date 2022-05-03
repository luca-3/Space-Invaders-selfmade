package com.example.game.firuges;

import java.util.List;
import java.util.Random;

public enum Level {
        TESTLEVEL(2, 1, 1, 0, 0),
        LEVEL_ONE(0,2,2,0,0),
        LEVEL_TWO(0,2,2,0,0),
        LEVEL_THREE(0,2,2,0,0),
        LEVEL_FOUR(0,2,2,0,0),
        LEVEL_FIVE(0,2,2,0,0),
        LEVEL_SIX(0,2,2,0,0),
        LEVEL_SEVEN(0,2,2,0,0),
    ;
    /*
    So machst du ein Level Enum:
    Du musst nur die angaben zur Anzahl der jeweiligen Gegner machen, aber
    wenn dir das zu langweilig kannst du r.nextInt(x1, x2) wobei (x1 = mindestzahl
    und x2 = maximalzahl) um Ungewissheit über die Anzahl der Gegner entsteht.
    */


    private final int affe;
    private final int unicorn;
    private final int dwarf;
    private final int puffy;
    private final int kitty;

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


    private static final List<Level> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Level randomLevel()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
