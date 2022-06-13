package com.example.game.mainNew;
//NEW

import com.example.game.objects.Tag;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private static Screen instance;

    private Screen(){ //Singleton Pattern
        initSettings();

    }

    public static Screen getInstance(){
        if(instance == null){
            instance = new Screen();
        }
        return instance;
    }

    private int monitorWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int monitorHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    private void initSettings() {
        //initial settings for the window
        autoUpdateScreenDimensions();
        this.setTitle("Blank");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); //TODO: Wenn der Monitor zu klein gezogen wird, soll eine Nachricht kommen, die den User auffordert das Fenster größer zu ziehen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.BLACK);

        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.black);
        this.setVisible(true);
        Keyboard k = Keyboard.getInstance();
        this.addKeyListener(k);

        generateTags();
    }

    private void generateTags() {
        Tag score = new Tag(10, 10,100, 20, null, "Score:", "score");
        Tag lives = new Tag(10, 30,100, 20, null, "Lives:", "lives");
        Tag level = new Tag(10, 50,100, 20, null, "Level:", "level");
        Tag time = new Tag(10, 70,100, 20, null, "Time passed:", "time");


    }


    public void autoUpdateScreenDimensions(){
        monitorHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        monitorWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setSize(monitorWidth, monitorHeight);
        System.out.println("Screen Dimensions: " + monitorWidth + "  " + monitorHeight);
    }


    public int getMonitorHeight() {
        return monitorHeight;
    }
    public int getMonitorWidth() {
        return monitorWidth;
    }
}
