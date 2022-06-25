package objects.enemies;

import main.Util;

public class Affe extends Enemies {
    public Affe(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
        setIstamLeben(true);
    }

    public Affe(){
        super(500, 400, 100, 100, 3, "resources/player/Spaceship.png");
    }



    public void spwan(){


    }


    public void move() {
        while (true) {
            setX(getX()+15);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread

            System.out.println("moved: x: " + getX() + " y: " + getY());
            Util.sleep(200);
        }
    }

    public void checkCollision(){

    }
}



