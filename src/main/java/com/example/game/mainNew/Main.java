package com.example.game.mainNew;
//NEW

import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> daten;



    private static boolean pause;

    public static void main(String[] args) {
        Screen s = Screen.getInstance();
        daten = new HashMap<>();

    }

    public static void updateDataTags(){
        //TODO: Wo 0 steht muss die entsprechende Datenquelle eingetragen werden
        daten.put("Score",0);
        daten.put("Lives",0);
        daten.put("Level",0);
        daten.put("Time", 0);
    }

    public static HashMap getDataTags(){
        updateDataTags();
        return daten;
    }

    public static boolean isPause() {
        return pause;
    }

    public static void setPause(boolean pause) {
        pause = pause;
    }
}
