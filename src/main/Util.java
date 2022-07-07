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
        //resize images initially to fit the screen
        //if image is already in the right size, no need to resize it. Then get it from resources/data/images/
        String filename =  "colorsInverted-" + Main.isColorsInverted() + "-" + width + "x" + height + replaceSlash(filepathSkin);
        ImageIcon icon = getBufferedImage(filename);
        if(icon != null) return icon;


        checkDict("resources/data/images/");

        //get Image from the filepathSkin and resize it with the given width and height
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filepathSkin));
        } catch (Exception e) {
            System.out.println("Error while reading image: " + e);
        }

        //assert img != null; //assures that the image is not null, if it is, the program will throw an AssertionError exception
        Image image = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = toBufferedImage(image);
        if(Main.isColorsInverted()) bufferedImage = invertColors(bufferedImage); //Boolean check if you want to invert the colors of the image
        //TODO: inversion of color in name of the buffered image

        //Save new Image in main/data/images/
        try {
            boolean written = ImageIO.write(bufferedImage, "png", new File("resources/data/images/" + filename));
            if(written) System.out.println("Image written: " + filename);
            //ImageIO.createImageOutputStream(new File("resources/data/images/" + filename));
        } catch (Exception e) {
            System.out.println("Error while writing image: " + e);
        }

        return new ImageIcon(bufferedImage);
    }

    private static void checkDict(String path) {
        //check if the directory exists, if not create it
        File directory = new File(path);
        if (! directory.exists()){
            directory.mkdirs();
        }
    }


    private static ImageIcon getBufferedImage(String filename){

        //iterate folder to find image that matches the filepathSkin as name
        File folder = new File("resources/data/images/");
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) return null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().equals(filename)) {
                    return new ImageIcon(file.getPath());
                }
            }
        }
        return null;
    }


    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    private static String replaceSlash(String filepathSkin) {
        return filepathSkin.replace("/", "-");
    }

    public static BufferedImage loadImage(String path){
        try{
            return ImageIO.read(new File(path));
        }catch (Exception e){
            System.out.println("Error while loading image: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage invertColors(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;
                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;
                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);
            }
        }
        return img;
    }

    private static boolean rangeIntersect(int min, int max, int min1, int max1) {
        return Math.max(min, max) >= Math.min(min1, max1) &&
                Math.min(min, max) <= Math.max(min1, max1);
    }

    public static boolean rectCollision(JLabel rect, JLabel rect1) {
        return rangeIntersect(rect.getX(), rect.getX() + rect.getWidth(), rect1.getX(), rect1.getX() + rect1.getWidth()) &&
                rangeIntersect(rect.getY(), rect.getY() + rect.getHeight(), rect1.getY(), rect1.getY() + rect1.getHeight());
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
