package com.example.game.firuges;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Level {
        TESTLEVEL(2, 0, 1, 0, 0)
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


    private static final List<Level> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Level randomLevel()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
