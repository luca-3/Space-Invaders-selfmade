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
        setSpeed(20);
    }


    private Unicorn(){
        super(-500, -400, Main.getScreen().getMonitorWidth()/30, Main.getScreen().getMonitorHeight()/17, 4, "resources/enemies/unicorn.png");
        setSpeed(10);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan(){

        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(0,(y-Main.getScreen().getMonitorHeight()/19)-getHeight())));
        berechneSteigung();
    }

    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move() {

        while (isAlive()) {

            setX(getX()-getRateSpeed());
            setY( (int) (  ((double)getX() * steigung) + c ) );
            checkIfOutOfScreen();


            Util.sleep(20);
        }
    }


    public void berechneSteigung(){
        this .steigung=  (getY()- (double)Main.getPlayer().getY())/((double) getX()- (double)Main.getPlayer().getX());  ;  // TODO formel passt nicht
        this.c= ((double) (Main.getPlayer().getY())) -((double)Main.getPlayer().getX()*steigung);


    }




}




