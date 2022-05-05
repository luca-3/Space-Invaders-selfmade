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
            case 'a' -> this.aKey = true;
            case 'w' -> this.wKey = true;
            case 's' -> this.sKey = true;
            case 'd' -> this.dKey = true;
            case ' ' -> this.spaceKey = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> this.aKey = false;
            case 'w' -> this.wKey = false;
            case 's' -> this.sKey = false;
            case 'd' -> this.dKey = false;
            case ' ' -> this.spaceKey = false;
            case 'm' -> Main.getScreen().setPause();
            case 'k' -> Main.startSpiel();
        }
    }


}
