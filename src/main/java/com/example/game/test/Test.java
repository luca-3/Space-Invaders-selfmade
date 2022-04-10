package com.example.game.test;

import java.io.File;
import java.util.Random;
import static com.example.game.test.MobMove.HDMOVE;
import static com.example.game.test.MobMove.NMOVE;
import static java.lang.Integer.parseInt;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    public static void enumo2v1(Enum t, int sp){

        Random zufall = new Random();
        int n = zufall.nextInt(10);

        for (int x = 20; x> 0; x-= sp){
        double y = MobMove.bew(t, n, x);
           y=  Math.round(y*100)/100.0;
        System.out.println("("+x+"|"+y+")");}
    }

    public static void bild () throws IOException {
        File file = new File("C:\\Users\\David\\Downloads\\115-0.jpg");
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
        Color farbe = JColorChooser.showDialog(null,
                "Farbauswahl", null);
        System.out.println(farbe);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
