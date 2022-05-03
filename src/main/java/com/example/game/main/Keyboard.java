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
            case 'a':
                aKey = true;
                break;
            case 'w':
                wKey = true;
                break;
            case 's':
                sKey = true;
                break;
            case 'd':
                dKey = true;
                break;
            case ' ':
                spaceKey = true;
                break;

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                aKey = false;
                break;
            case 'w':
                wKey = false;
                break;
            case 's':
                sKey = false;
                break;
            case 'd':
                dKey = false;
                break;
            case ' ':
                spaceKey = false;
                break;
            case 'm':
                Main.getScreen().setPause();
            break;
        }
    }

}
