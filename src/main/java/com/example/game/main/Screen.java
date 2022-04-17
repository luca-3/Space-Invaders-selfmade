package com.example.game.main;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    public Screen(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int)size.getWidth(), (int)size.getHeight());
        this.setLayout(null);
        this.getContentPane().setBackground(Color.black);
    }

    public void update() {
        //Method to update the location of the Objects on Screen

    }

}
