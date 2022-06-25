package main;
//NEW

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Util {

    private static int startTime;

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon resizeImage(int width, int height, String filepathSkin) {
        try{
            BufferedImage img = ImageIO.read(new File(filepathSkin));
            Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }catch (Exception e){
            System.out.println("Error while resizing skin: " + e);
        }
        return null;
    }

    public static void startTimer(){
        startTime = (int) System.currentTimeMillis();
    }

    public static int readTimerMillis(){
        return (int) System.currentTimeMillis() - startTime;
    }

    public static int readTimerSec(){
        return (int) (System.currentTimeMillis() - startTime) / 1000;
    }

    public static int readTimerMin(){
        return (int) (System.currentTimeMillis() - startTime) / 60000;
    }


}
