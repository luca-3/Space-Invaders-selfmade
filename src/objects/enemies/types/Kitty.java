package objects.enemies.types;

import main.Main;
import main.Util;
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
        super(-500, -400, 75, 75, 10000, "resources/enemies/kitty.png");  //TODO dynamische Wert bei width und Height  und dateiName ändern
        setSpeed(2);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan() {
        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(0,y)));
    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move() {

        while (isAlive()) {

            while (getX() > Main.getScreen().getMonitorWidth() - Main.getScreen().getMonitorWidth() /15) {
                setX(getX() - getRateSpeed());

                Util.sleep(100);
            }
            Util.sleep(1000);

            while (getX() < Main.getScreen().getMonitorWidth()) {
                setX(getX() + getRateSpeed());
                Util.sleep(100);
            }

            setAlive(false);


        }


    }
}






