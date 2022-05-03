package com.example.game.firuges;

import com.example.game.main.EnemyHandler;

import java.util.Random;

public class Level {




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

    public Level(){
        int[] numberOfEnemy = generateLevel();
        this.affe = numberOfEnemy[0];
        this.unicorn = numberOfEnemy[1];
        this.dwarf = numberOfEnemy[2];
        this.puffy = numberOfEnemy[3];
        this.kitty = numberOfEnemy[4];
    }


    public int[] generateLevel(){
        Random r = new Random();
        int numberEnemy = (int) (Math.sqrt(EnemyHandler.level - 1) * 2.5 + 2); //formula to calculate the number of enemy dependent on the current level
        int[] enumInput = new int[EnemyE.SIZE]; //number of Enemy, wich exists and can be an input of the Level enum

        for (int i = numberEnemy; i > 0; i--){
            if (enumInput[4] < 5){
                int position = r.nextInt(0,enumInput.length - 1);
                enumInput[position] += 1;
            } else {
                int position = r.nextInt(0,enumInput.length - 2);
                enumInput[position] += 1;
            }

        }
        System.out.println("rand");

        return enumInput;
    }

    public int getNumberAffe(){return affe;}
    public int getNumberUnicorns(){return unicorn;}
    public int getNumberDwarf() {return dwarf;}
    public int getNumberPuffy() {return puffy;}
    public int getNumberKitty() {return kitty;}



}
