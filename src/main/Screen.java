package main;
//NEW

import objects.Tag;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private Tag score, lives, time, level, nonGraphicScore;

    private JLayeredPane layeredPane;

    private int monitorWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int monitorHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Screen(){ //Singleton Pattern
        Util.sleep(1000); //slow initialization

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, this.monitorWidth, this.monitorHeight);

        //initial settings for the window
        autoUpdateScreenDimensions();
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); //TODO: Wenn der Monitor zu klein gezogen wird, soll eine Nachricht kommen, die den User auffordert das Fenster größer zu ziehen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
          add(layeredPane);


        Keyboard k = Keyboard.getInstance();
        this.addKeyListener(k);


    }

    public void startGame(){
        backgroundSettings();
        generateTags();



    }
    public  void backgroundSettings(){
        //Background




        JLabel backgrond = new JLabel();
        backgrond.setBounds(-1,0,this.monitorWidth, this.monitorHeight);
        //backgrond.setIcon(Util.resizeImage(this.monitorWidth, this.monitorHeight, "resources/map/background-sky-edit.png"));
        backgrond.setIcon(Util.resizeImage(this.monitorWidth, this.monitorHeight, "resources/map/main_image_star-forming_region_carina_nircam_final-5mb-edit.png"));
        Main.getScreen().getLayeredPane().add(backgrond, 1);
        backgrond.setLocation(0,0); //to force the Background to render




        this.setVisible(true);
    }



    public void generateTags() {
        lives = new Tag(10, 10 ,120, 32, null, "Lives: ", "lives"); //height should be a multiple of 8
        score = new Tag(10, 50,120, 20, null, null, "score");
        level = new Tag(10, 100,120, 20, null, "Level: ", "level");
        time = new Tag(10, 120,200, 20, null, "Time passed: ", "time");
        nonGraphicScore = new Tag(10, 70,120, 20, null, "Score: ", "score");

    }

    public void updateTags(){
        while(!Main.isPause()){
            score.updateTag();
            lives.updateTag();
            level.updateTag();
            time.updateTag();
            nonGraphicScore.updateTag();
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

    public void removePanels(){

        Main.getScreen().getLayeredPane().removeAll();
        Main.getScreen().getLayeredPane().repaint();
    }

    public int getMonitorHeight() {
        return monitorHeight;
    }
    public int getMonitorWidth() {
        return monitorWidth;
    }
}
