package objects.enemies;

import main.Util;

public class Affe extends Enemies {
    public Affe(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
    }

    public Affe(){
        super(500, 400, 100, 100, 3, "Spaceship.png");
    }

    @Override
    public void move() {
        while (true) {

            System.out.println("moved: x: " + getX() + " y: " + getY());
            Util.sleep(200);
        }
    }
}