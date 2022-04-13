package com.example.game.test;



import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.awt.Color;
import javax.swing.JColorChooser;

public class Test {

    public static void main(String[] args) throws IOException {


        //enumo1v1();
        //enumo2v1(HDMOVE, HDMOVE.getSpeed());
        // bla();
        bild();
    }


    public static void bla() {
        for (double i = 0; i < 10; i += 0.1) {
            double a = 2 * Math.sin(i) + 2;
            System.out.println(a + " ");
        }

    }

    public static void enumo1v1() {
        int a = Beispiel.ENUM1.getBspInt();
        boolean b = Beispiel.ENUM1.getBspBool();
        String c = Beispiel.ENUM1.getBspString();
        System.out.println(a + " " + b + " " + c);
    }
   /* public void enumo2v1(Enum t, int sp, Rectangle rectangle){

        Random zufall = new Random();
        int n = zufall.nextInt(10);

        for (int x = 20; x> 0; x-= sp){
        double y = MobMove.bew(t, n, x);
           y=Math.round(y*100);
           int y1 = (int)y;
        main.updatePosition(x , y1, rectangle);}
    }*/

    public static void bild() throws IOException {
        File file = new File("src/main/resources/com/example/game/enemy/Bannane.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);

        JFrame jFrame = new JFrame("Hadiuz made it");

        jFrame.setLayout(new FlowLayout());
        jFrame.add(new JLabel("Hallo"));

        jFrame.setSize(550, 620);
        JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
      /*  Color farbe = JColorChooser.showDialog(null,
                "Farbauswahl", null);
        System.out.println(farbe);*/

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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