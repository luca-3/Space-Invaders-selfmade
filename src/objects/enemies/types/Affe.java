package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

public class Affe extends Enemies {

    public static void createInstance(){
        Affe temp = new Affe();
        getInstances().get(0).add(temp);
    }

    private Affe(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
    }

    private Affe() {
        super(-500, -400, 120, 190, 3, "resources/enemies/affe.png"); //TODO dynamische Wert bei widht und Height  und dateiName ändern
        setSpeed(2);
        setAlive(true);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan() {

        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX((int) (Math.random() * (x - (x - x / 8)) + (x - (x / 8))));
        setY((int) (Math.random() * (y - 30) + 30));


    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move () {
        while (isAlive()) {
            setX(getX() - 10);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (Sin curve Move)//
         //   setY(int) (Math.sin(getX()/100)*200));  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (Sin curve Move)//

            checkIfOutOfScreen();
            Util.sleep(20);
        }
    }

}









