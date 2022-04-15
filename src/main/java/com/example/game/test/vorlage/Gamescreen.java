package com.example.game.test.vorlage;

import javax.swing.*;
import java.awt.*;

public class Gamescreen extends JPanel {

    JLabel mainChar;
    ImageIcon icon;
    //ATTRIBUTE
    public Gamescreen(Frame f){

    }

    //ZEICHENMETHODE
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(300, 300, 100, 100);
        g.fillRect(100, 100, 100, 100);


      
    }
}