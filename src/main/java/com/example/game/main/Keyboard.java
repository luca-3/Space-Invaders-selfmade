package com.example.game.main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {


    public static boolean wKey;
    public static boolean aKey;
    public static boolean sKey;
    public static boolean dKey;

    public static boolean spaceKey;


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> aKey = true;
            case 'w' -> wKey = true;
            case 's' -> sKey = true;
            case 'd' -> dKey = true;
            case ' ' -> spaceKey = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> aKey = false;
            case 'w' -> wKey = false;
            case 's' -> sKey = false;
            case 'd' -> dKey = false;
            case ' ' -> spaceKey = false;
            case 'm' -> Main.getScreen().setPause();
            case 'k' -> Main.startSpiel();
        }
    }


}
