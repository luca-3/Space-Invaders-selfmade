package main;
//NEW

import objects.Tag;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private Tag score, lives, time, level;

    public Screen(){ //Singleton Pattern
        Util.sleep(1000); //slow initialization

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


    }


    private int monitorWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int monitorHeight = Toolkit.getDefaultToolkit().getScreenSize().height;


    public void generateTags() {
        score = new Tag(10, 10,120, 20, null, "Score: ", "score");
        lives = new Tag(10, 30,120, 20, null, "Lives: ", "lives");
        level = new Tag(10, 50,120, 20, null, "Level: ", "level");
        time = new Tag(10, 70,200, 20, null, "Time passed: ", "time");
    }

    public void updateTags(){
        while(!Main.isPause()){
            score.updateTag();
            lives.updateTag();
            level.updateTag();
            time.updateTag();
            Util.sleep(200);
            while(Main.isPause()) Util.sleep(1000);
        }
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
