package com.example.game.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//class for getting key inputs
public class KeyEventHandler implements KeyListener {

    public boolean w, a, s, d;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            w = true;
        }
        if (key == KeyEvent.VK_A) {
            a = true;
        }
        if (key == KeyEvent.VK_S) {
            s = true;
        }
        if (key == KeyEvent.VK_D) {
            d = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            w = false;
        }
        if (key == KeyEvent.VK_A) {
            a = false;
        }
        if (key == KeyEvent.VK_S) {
            s = false;
        }
        if (key == KeyEvent.VK_D) {
            d = false;
        }
    }

    //getters
    public boolean getW() {
        return w;
    }
    public boolean getA() {
        return a;
    }
    public boolean getS() {
        return s;
    }
    public boolean getD() {
        return d;
    }

}

