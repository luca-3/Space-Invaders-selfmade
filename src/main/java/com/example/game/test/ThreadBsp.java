package com.example.game.test;

public class ThreadBsp {


        public static void main(String[] args) {
            System.out.println("Start");
            Thread it1 = new Thread(()-> v1(1));
            Thread it2 = new Thread(()-> v2());
            Thread it3 = new Thread(()-> v3());
            Thread it4 = new Thread(()-> v1(2));
            it1.start();
          //  it2.start();
           // it3.start();
            it4.start();
            System.out.println("main ende");
        }
        public static void v1(int a) {
            for(int i = 0; i< 20; i++) {
                if(a==1){
                System.out.println("alles");}
                else if(a==2){
                    System.out.println("nix");}
                sleep2(1000);
            }
        }
        public static void v2() {
            for(int i = 0; i< 20; i++) {
                System.out.println("b");
                sleep2(1000);
            }
        }
        public static void v3() {
            for(int i = 0; i< 20; i++) {
                System.out.println("c");
                sleep2(1000);
            }
        }
        public static Exception sleep2(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ignored) {
                return ignored;
            }
            return null;
        }
    }

