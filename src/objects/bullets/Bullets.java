package objects.bullets;

import main.Main;
import objects.GameObjects;
import objects.bullets.types.Laser;
import objects.enemies.types.*;

import java.util.ArrayList;

public abstract class Bullets extends GameObjects {

    private int speed;


    private boolean alive;

    private static ArrayList<ArrayList> instances;

    public Bullets(int x, int y, int width, int height, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
    }

    public abstract void move();


    public abstract void threading();

    public static void createLists(){
        instances = new ArrayList<>();

        ArrayList<Laser> instancesL = new ArrayList<>();
        ArrayList<Puffy> instancesP = new ArrayList<>();
;

        instances.add(instancesL);
        instances.add(instancesP);


        System.out.println("I am really special");
    }


    public static ArrayList<ArrayList> getInstances(){
        return instances;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed= (int) (Main.getScreen().getMonitorWidth()/130*speed);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
