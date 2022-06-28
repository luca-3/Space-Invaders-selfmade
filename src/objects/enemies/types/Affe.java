package objects.enemies.types;

import main.Main;
import main.Util;
import objects.enemies.Enemies;

import java.sql.SQLOutput;
import java.util.Random;

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
        setSpeed(1);
        setAlive(true);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan() {

        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(85,(y-getHeight())-(y/5)))); //Formel vehinder dass affe unten aus bildschrim lauft

    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move () {
        int yfactor= (int)(Main.getScreen().getMonitorHeight()/13.5);  //Y wert /streckung von sin kurve in y richtung
        int xfactor= (int) (Main.getScreen().getMonitorWidth()/19.2);  // parameter für die Streckung in x achse

        double sinFactor= 1/(double) yfactor; // streckung in x
        int spwanhigh=getY();
        System.out.println(sinFactor);

        while (isAlive()) {
            setX(getX()-getRateSpeed());

            setY(
                    (int) ((Math.sin(sinFactor * (double )getX()))  * yfactor + spwanhigh)
            );

            checkIfOutOfScreen();
            Util.sleep(50);
        }
    }

}









