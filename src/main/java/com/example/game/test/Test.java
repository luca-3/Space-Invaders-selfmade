package com.example.game.test;

public class Test {

    public static void main(String[] args) {

       Enum1(Beispiel.ENUM1);
       // bla();
    }


    public static void bla(){
        for(double i =0; i<10; i+= 0.1) {
            double a = 2*Math.sin(i)+2;
            System.out.println(a+" ");
        }

    }
    public static void Enum1(Enum enum1){

        System.out.println(enum1);
    }
}
