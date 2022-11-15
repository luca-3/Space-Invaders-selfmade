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



        this.homeScreen.setBounds(-1, 0, Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight());
        this.homeScreen.setVisible(true);
        this.homeScreen.setLayout(null);
        this.homeScreen.setBackground(Color.blue);







    }

    public void setButton() {

        int tempWidth= (int)((double)Main.getScreen().getMonitorWidth()/4.8);

        start = new JButton("Spiel starten");
        start.setBounds(Main.getScreen().getMonitorWidth()/2-(tempWidth/2),(int)((double)Main.getScreen().getMonitorHeight()/5.4),(int)((double)Main.getScreen().getMonitorWidth()/4.8), (int)((double) Main.getScreen().getMonitorHeight()/18));
        start.setBackground(buttonbackground);
        homeScreen.add(start);


        ende = new JButton("Spiel enden");
        ende.setBounds(Main.getScreen().getMonitorWidth()/2-(tempWidth/2),(int)((double)Main.getScreen().getMonitorHeight()/2.7),(int) ((double) Main.getScreen().getMonitorWidth()/4.8) ,(int)((double) Main.getScreen().getMonitorHeight()/18));
        ende.setBackground(buttonbackground);
        homeScreen.add(ende);



        settings = new JButton(" Settings");
        settings.setBounds(Main.getScreen().getMonitorWidth()/2-(tempWidth/2),(int)((double)Main.getScreen().getMonitorHeight()/1.8),(int) ((double) Main.getScreen().getMonitorWidth()/4.8),(int)((double) Main.getScreen().getMonitorHeight()/18));
        settings.setBackground(buttonbackground);
        homeScreen.add(settings);

        Main.getScreen().getLayeredPane().add(homeScreen);


        while(Keyboard.isSPressed()==false){

            if(Keyboard.isSPressed()){
                removePanels();
                Main.startGame();

            }

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
            System.out.println("Homescreen: Game started");
            Main.startGame();


        }

    }

    public void removePanels(){

        Main.getScreen().getLayeredPane().removeAll();
        Main.getScreen().getLayeredPane().repaint();
    }





}



