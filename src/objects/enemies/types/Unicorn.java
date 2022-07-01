package objects.enemies.types;

import main.Main;
import main.Util;
import objects.enemies.Enemies;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Unicorn extends Enemies {

    int steigung=0;

    public static void createInstance(){
        Unicorn temp = new Unicorn();
        getInstances().get(4).add(temp);
    }

    private Unicorn(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
    }


    private Unicorn(){
        super(-500, -400, 64, 64, 4, "resources/enemies/unicorn.png");
        setSpeed(1);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan(){

        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(0,y)));
        berechneSteigung();
    }

    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move() {

        while (isAlive()) {
            setX(getX() - getRateSpeed());

            setY(

                    getY() +((steigung * getX()) / 50)

            );
            System.out.println(getY());

            if(getX()<Main.getScreen().getMonitorWidth()/2){
                berechneSteigung();
            }
            checkIfOutOfScreen();
            Util.sleep(20);
        }
    }


    public void berechneSteigung(){
        this .steigung= 1/4;  // TODO formel passt nicht

    }




}




