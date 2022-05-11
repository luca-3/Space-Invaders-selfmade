package com.example.game.figures;

//Test Klassen für Abstraktion

abstract class GameObjects {
    private int width;
    private int x;
    private int y;

    public void move(){
        System.out.println("test: Parent");
    }
}

class Test extends GameObjects {
    private int width;
    private int x;
    private int y;

    @Override
    public void move(){
        System.out.println("test: Child"+width);
    }
}

class ZweiterTest extends GameObjects {
    static Test test = new Test();

    public static void main(String[] args) {
        test.move();
    }

}
