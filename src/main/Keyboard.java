package main;
//NEW

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static Keyboard instance;
    private static boolean wKey, aKey, sKey, dKey, spaceKey;

    private Keyboard(){ //Singleton Pattern

    }

    public static Keyboard getInstance(){
        if(instance == null){
            instance = new Keyboard();
        }
        return instance;
    }


    @Override
    public void keyTyped(KeyEvent e){

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
            case 'p' -> Main.setPause(!Main.isPause());
        }
    }


    public static boolean isWPressed() {
        return wKey;
    }

    public static boolean isAPressed() {
        return aKey;
    }

    public static boolean isSPressed() {
        return sKey;
    }

    public static boolean isDPressed() {
        return dKey;
    }

    public static boolean isSpacePressed() {
        return spaceKey;
    }

}