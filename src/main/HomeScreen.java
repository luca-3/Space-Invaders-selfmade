package main;




import javax.swing.*;
import javax.swing.plaf.multi.MultiListUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.StandardSocketOptions;
import java.util.Scanner;
import java.util.Set;

public class HomeScreen  {
    private JPanel homeScreen;
    private JButton start;
    private JButton items;
    private JButton settings;
    private JButton ende;
    private JLabel background;

    private Screen Sc= Main.getScreen();
    private Color buttonbackground = new Color(68, 173, 73);


    private boolean homeScreenisActiv=true;

    private JPanel panel;

    public HomeScreen() {

        setHomescreen();
        setButton();

    }

    public void setHomescreen() {
        homeScreen = new JPanel();
        background = new JLabel();


        this.homeScreen.setBounds(0, 0, Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight());
        this.homeScreen.setVisible(true);

        this.background.setBounds(0, 0, Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight());
        background.setIcon(Util.resizeImage( Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight(), "resources/enemies/affe.png"));
        this.background.setVisible(true);

        this.homeScreen.add(background);
         Main.getScreen().getLayeredPane().add(homeScreen);


    }

    public void setButton() {
        start = new JButton("Spiel starten");
        start.setBounds((homeScreen.getWidth() / 2), 200, 2000, 50);
        start.setBackground(buttonbackground);
        Main.getScreen().getLayeredPane().add(start);

        ende = new JButton("Spiel enden");
        ende.setBounds((homeScreen.getWidth() / 2), 400, 2000, 50);
        ende.setBackground(buttonbackground);
        Main.getScreen().getLayeredPane().add(ende);

        items = new JButton("items");
        items.setBounds((homeScreen.getWidth() / 2), 600, 2000, 50);
        items.setBackground(buttonbackground);
        Main.getScreen().getLayeredPane().add(items);


        settings = new JButton(" Settings");
        settings.setBounds((homeScreen.getWidth() / 2), 800, 2000, 50);
        settings.setBackground(buttonbackground);
        Main.getScreen().getLayeredPane().add(settings);


        while(homeScreenisActiv){
          Scanner sc = new Scanner(System.in);
            System.out.println("Gebe Zahl ein");
            int a=sc.nextInt();
            testA(a);
            Util.sleep(1000);



        }


   }




    public void testA( int a) {
        if (a == 1 && homeScreenisActiv) {
            homeScreenisActiv=false;


            removePanels();
            System.out.println("Hallloaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Main.startGame();


        }

    }

    public void removePanels(){

        Main.getScreen().getLayeredPane().removeAll();
        Main.getScreen().getLayeredPane().repaint();
    }





}



