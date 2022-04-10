package com.example.game.test;

import java.util.Random;

import static com.example.game.test.MobMove.NMOVE;
import static java.lang.Integer.parseInt;

public class Test {

    public static void main(String[] args) {


       //enumo1v1();
        enumo2v1();
       // bla();
    }


    public static void bla(){
        for(double i =0; i<10; i+= 0.1) {
            double a = 2*Math.sin(i)+2;
            System.out.println(a+" ");
        }

    }
    public static void enumo1v1(){
        int a = Beispiel.ENUM1.getBspInt();
        boolean b = Beispiel.ENUM1.getBspBool();
        String c = Beispiel.ENUM1.getBspString();
        System.out.println(a+" "+b+" "+c);
    }
    public static void enumo2v1(){

        Random zufall = new Random();
        int n = zufall.nextInt(10);

        for (int x = 20; x> 0; x--){
        double y = MobMove.bew(NMOVE, n, x);
        System.out.println(y);}
    }
}
