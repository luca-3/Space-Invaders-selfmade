package com.example.game.test;

import java.util.Random;
import java.util.Scanner;

public class ThreadBsp {
static Random random = new Random();
static boolean bool = true;
static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("Start");
            Thread it1 = new Thread(()-> v1(1));
            Thread it2 = new Thread(()-> v2());
            Thread it3 = new Thread(()-> v3());
            Thread it4 = new Thread(()-> v1(2));
           // it1.start();
           // it2.start();
            it3.start();
           // it4.start();
            /*
            for (int i = 0; i < 10; i++) {
                int r = random.nextInt(3);
                System.out.println(r);
            }*/
            while (bool){sleep2(3000);
            }
            System.out.println("main end");
        }
        public static void v1(int a) {
            for(int i = 0; i< 5; i++) {
                if(a==1){
                System.out.println("alles");}
                else if(a==2){
                    System.out.println("nix");}
                sleep2(1000);
            }
        }
        public static void v2() {
            for(int i = 0; i< 5; i++) {
                System.out.println("halb");
                sleep2(1000);
            }
        }
        public static void v3() {
           while (true){
               int i = scanner.nextInt();
               System.out.println(i);
               if(i == 2) bool = false ;
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

         /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                Enemy name = new Enemy(EnemyEnum.BANNANE);
                root.getChildren().add(name.getObject());
            }
        }).start(); */
    }

