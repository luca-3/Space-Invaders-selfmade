package com.example.game;

public enum Beispiel {

    ENUM1(3, true, "Hallo"),
    ENUM2(6000, false, "Bye")
    ;

    private final int bspInt;
    private final boolean bspBool;
    private final String bspString;

    Beispiel(int bspInt, boolean bspBool, String bspString){
        this.bspInt = bspInt;
        this.bspBool = bspBool;
        this.bspString = bspString;
    }

}
