package objects.enemies;

import objects.GameObjects;

public abstract class Enemies extends GameObjects {

    private int healthpoints, speed ;
    private boolean istamLeben;



    public Enemies(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        this.healthpoints = healthpoints;
        this.istamLeben=true;
    }

    public abstract void move();


    public void setIstamLeben(boolean istamLeben) {
        this.istamLeben = istamLeben;
    }
    public boolean isIstamLeben() {
        return istamLeben;
    }

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
