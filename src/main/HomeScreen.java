package main;

import objects.Tag;

import javax.swing.*;
import javax.swing.plaf.multi.MultiListUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.StandardSocketOptions;
import java.util.Set;


    public class HomeScreen implements ActionListener {

        private JPanel homeScreen;
        private JButton start;

        private JButton items;
        private JButton einstellungen;
        private JButton ende;
        private ImageIcon backgroundI;

        private JLayeredPane background;


        private Color buttonbackground = new Color(72, 173, 68);



        public HomeScreen(){

            //Background


            JLabel backgrond = new JLabel();
            backgrond.setBounds(-1,0,Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight());
            backgrond.setIcon(Util.resizeImage(Main.getScreen().getMonitorWidth(), Main.getScreen().getMonitorHeight(), "resources/map/background-sky.png"));
            Main.getScreen().getLayeredPane().add(backgrond, 1);
            Main.getScreen().getLayeredPane().add(Main.getScreen().getLayeredPane());
            backgrond.setLocation(0,0); //to force the Background to render


            //Mouse event

            setButton();

            Main.getScreen().setVisible(true);

        }
        public void setScreenNull(){

            Main.getScreen().setScore().();

        }

        public void setButton(){
            start= new JButton("start");
            start.setBounds(Main.getScreen().getMonitorWidth()/2,(Main.getScreen().getMonitorHeight()/4),200,50);
            start.setBackground(buttonbackground);
            background.add(start);

            ende= new JButton("ende");
            ende.setBounds(Main.getScreen().getMonitorWidth()/2,(Main.getScreen().getMonitorHeight()/4)*2,200,50);
            ende.setBackground(buttonbackground);
            background.add(ende);

            items= new JButton("items");
            items.setBounds(Main.getScreen().getMonitorWidth()/2,(Main.getScreen().getMonitorHeight()/4)*3,200,50);
            items.setBackground(buttonbackground);
            background.add(items);

            einstellungen= new JButton("einstellung");
            einstellungen.setBounds(Main.getScreen().getMonitorWidth()/2,(Main.getScreen().getMonitorHeight()/4)*3,200,50);
            einstellungen.setBackground(buttonbackground);
            einstellungen.add(ende);

            while(true){
                start.addActionListener(this);
                ende.addActionListener(this);
                items.addActionListener(this);
                einstellungen.addActionListener(this);
                Util.sleep(500);
            }


        }




        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals(start)){
                System.out.println("start");
            } else if (e.getActionCommand().equals(ende)) {
                System.out.println("start");

            } else if (e.getActionCommand().equals(items)) {
                System.out.println("start");

            } else if (e.getActionCommand().equals(ende)) {
                System.out.println("start");

            }
        }
    }



