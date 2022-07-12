package objects.enemies.types;

import main.Main;
import main.Util;
import objects.bullets.types.YellowCharge;
import objects.enemies.Enemies;

import java.util.Random;

public class Kitty extends Enemies {

    public static void createInstance() {
        Kitty temp = new Kitty();
        getInstances().get(3).add(temp);
    }

    private Kitty(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
    }


    private Kitty() {
        super(-500, -400, Main.getScreen().getMonitorWidth()/26,Main.getScreen().getMonitorHeight()/15 , 10000, "resources/enemies/kitty.png");
        setSpeed(2);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan() {
        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int) (r.nextDouble( (x/(20)) , x) ));
        setY((int) (r.nextDouble( 0,(y-Main.getScreen().getMonitorHeight()/19) - getHeight()) ));

    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Kitty");
        move.start();
    }

    public void move() {

        while (isAlive()) {

            while (getX() > Main.getScreen().getMonitorWidth() - Main.getScreen().getMonitorWidth() /15) {
                setX(getX() - getSpeed());

                Util.sleep(100);
            }
            Util.sleep(1000);
            YellowCharge.createInstance(getX(), getY() + 14, false, "left");
            Util.sleep(500);

            while (getX() < Main.getScreen().getMonitorWidth()) {
                setX(getX() + getSpeed());
                Util.sleep(100);
            }

            setAlive(false);


        }


    }
}






