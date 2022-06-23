package objects.enemies;

import objects.GameObjects;

public abstract class Enemies extends GameObjects {

    private int healthpoints, speed;
    
    public Enemies(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        this.healthpoints = healthpoints;
    }

    public abstract void move();

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
