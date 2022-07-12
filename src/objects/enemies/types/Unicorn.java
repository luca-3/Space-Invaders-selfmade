package objects.enemies.types;

import main.Main;
import main.Util;
import objects.enemies.Enemies;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Unicorn extends Enemies {

    double steigung;
    double c;

    public static void createInstance(){
        Unicorn temp = new Unicorn();
        getInstances().get(4).add(temp);
    }

    private Unicorn(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(1);
    }


    private Unicorn(){
        super(-500, -400, Main.getScreen().getMonitorWidth()/30, Main.getScreen().getMonitorHeight()/17, 4, "resources/enemies/unicorn.png");
        setSpeed(1.5);
        findXandYforSpwan();
        berechneSteigung();
        threading();
    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Unicorn");
        move.start();
    }

    public void move() {
        int i = 0;

        while (isAlive()) {
            /*
            i++;
            if(i > 50){ //aktualisiert die Steigung jede Sekunde (50*20=1000ms)
                berechneSteigung();
                i = 0;
            }

            //setX(getX()-getRateSpeed());
            setX(getX()-getSpeed());
            setY( (int) (  ((double)getX() * steigung) + c ) );
            checkIfOutOfScreen();

            Util.sleep(20);
             */
            setX(getX()-getSpeed());
            if(getX() < 100) setAlive(false);
            Util.sleep(200);
        }
    }


    public void berechneSteigung(){
        this .steigung=  (getY()- (double)Main.getPlayer().getY())/((double) getX()- (double)Main.getPlayer().getX());  ;  // TODO formel passt nicht
        this.c= ((double) (Main.getPlayer().getY())) -((double)Main.getPlayer().getX()*steigung);


    }




}




