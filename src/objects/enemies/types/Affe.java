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
        super(-500, -400, Main.getScreen().getMonitorWidth()/16, Main.getScreen().getMonitorHeight()/6, 3, "resources/enemies/affe.png");
        setSpeed(1);
        setAlive(true);
        findXandYforSpwan();
        threading();
    }

    @Override
    public void findXandYforSpwan() {
        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(85,(y-getHeight())-(y/5)))); //Formel vehinder dass affe unten aus bildschrim lauft

    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Affe");
        move.start();
    }

    public void move () {
        int yfactor= (int)(Main.getScreen().getMonitorHeight()/7.2);  //Y wert /streckung von sin kurve in y richtung
        //int xfactor= (int) (Main.getScreen().getMonitorWidth()/4.8);  // parameter für die Streckung in x achse

        double sinFactor= 1/(double) yfactor; // streckung in x
        int spwanhigh=getY();
        //System.out.println(sinFactor);

        while (isAlive()) {
            setX(getX()-getSpeed());

            setY(
                    (int) ((Math.sin(sinFactor * (double )getX()))  * yfactor + spwanhigh)
            );

            checkIfOutOfScreen();
            Util.sleep(30);
        }
    }

}









