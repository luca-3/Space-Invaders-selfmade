package objects.enemies;

import main.Main;
import main.Screen;
import objects.GameObjects;
import objects.enemies.types.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Enemies extends GameObjects {

    private int healthpoints;

    private int speed;
    private boolean alive = true;


    private static ArrayList<ArrayList> instances;

    public Enemies(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        this.healthpoints = healthpoints;
        this.alive = true;
    }


    public abstract void move();

    public abstract void threading();

    public static void createLists() {
        if (instances != null) {
            for (ArrayList list : instances) {
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
        if(!this.alive){
            removeJLabel();

            EnemyHandler.deleteDeadEnemies();
        }
    }

    public void findXandYforSpwan() {
        Random r = new Random();
        setX(
                Main.getScreen().getMonitorWidth() + 20
        );
        setY(
                (int) (r.nextDouble(0, Main.getScreen().getMonitorHeight() - getHeight())) //(getScreen().getMonitorWidth() - Main.getScreen().getMonitorHeight()/19) - getHeight())
        );

    }

    public boolean isAlive() {
        return alive;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
        checkIfDead();
    }

    public void manipulateHealthpoints(int healthpoints){
        this.healthpoints += healthpoints;
        checkIfDead();
    }

    private void checkIfDead() {
        if (healthpoints <= 0) {
            setAlive(false);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public static ArrayList<ArrayList> getInstances() {
        return instances;
    }

    public void setSpeed(double speed) {
        this.speed = (int) (Main.getScreen().getMonitorWidth() / 130 * speed);
    }


}
