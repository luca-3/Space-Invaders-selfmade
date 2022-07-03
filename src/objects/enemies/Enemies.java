package objects.enemies;

import main.Main;
import objects.GameObjects;
import objects.enemies.types.*;

import java.util.ArrayList;

public abstract class Enemies extends GameObjects {

    private int healthpoints;

    private double speed;
    private boolean alive = true;



    private int rateSpeed;
    private static ArrayList<ArrayList> instances;

    public Enemies(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        this.healthpoints = healthpoints;
        this.alive = true;
    }


    public abstract void move();
    public abstract void threading();

    public static void createLists(){
        if(instances != null) {
            for(ArrayList list : instances) {
                list.clear();
            }
            System.out.println("Enemy lists cleared");
            return;

        }
        instances = new ArrayList<>(5);

        ArrayList<Affe> instancesA = new ArrayList<>();
        ArrayList<Puffy> instancesP = new ArrayList<>();
        ArrayList<Dwarf> instancesD = new ArrayList<>();
        ArrayList<Kitty> instancesK = new ArrayList<>();
        ArrayList<Unicorn> instancesU = new ArrayList<>();

        instances.add(instancesA);
        instances.add(instancesP);
        instances.add(instancesD);
        instances.add(instancesK);
        instances.add(instancesU);

        System.out.println("I am special");

    }

    public void checkIfOutOfScreen() {
        if (getX() < 500 - getWidth()) {
            setAlive(false);
        }
    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public double getSpeed() {
        return speed;
    }

    public static ArrayList<ArrayList> getInstances() {
        return instances;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        rateSpeed = Main.getScreen().getMonitorWidth()/130+speed;
    }
    public int getRateSpeed() {
        return rateSpeed;
    }

    public void setRateSpeed(int rateSpeed) {this.rateSpeed = rateSpeed;}
}
