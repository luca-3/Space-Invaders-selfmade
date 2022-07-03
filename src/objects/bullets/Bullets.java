package objects.bullets;

import main.Main;
import main.Util;
import objects.GameObjects;
import objects.bullets.types.Laser;
import objects.enemies.types.*;

import java.util.ArrayList;

public abstract class Bullets extends GameObjects {

    private int speed;

    private boolean alive, isPlayerFriendly;

    private static ArrayList<ArrayList> instances;

    public Bullets(int x, int y, int width, int height, boolean isPlayerFriendly, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        setAlive(true);
        this.isPlayerFriendly = isPlayerFriendly;
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

    public void gotHit(){

        Bullethandler.deleteBullet(this);

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

    public boolean isPlayerFriendly() {
        return isPlayerFriendly;
    }

    public void setPlayerFriendly(boolean playerFriendly) {
        isPlayerFriendly = playerFriendly;
    }

}
