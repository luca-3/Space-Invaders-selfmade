package com.example.game.test.vorlage;

import com.example.game.test.vorlage.Gamescreen;

public class GUI {

    private Frame f;
    private Gamescreen painting;

    public GUI() {
        this.f = new Frame("Game", -1, -1, 1000, 800);
        this.painting = new Gamescreen(this.f);
        this.f.getContentPane().add(this.painting);
        this.f.setupFrame();
    }
}
