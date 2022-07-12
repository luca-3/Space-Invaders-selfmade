package objects.enemies.types;

import main.Main;
import main.Util;
import objects.enemies.Enemies;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class Unicorn extends Enemies {

    class Vector { //Behilfsklasse
        public Vector (int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }

    double steigung;
    double c;

    private Vector velocity;



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
        velocity = new Vector(20, 20);
        findXandYforSpwan();
        threading();
    }


    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Unicorn");
        move.start();
    }

    public void move() {


        while (isAlive()) {

            if(getX() > Main.getPlayer().getX()){
                Vector newV = berechneSteigung();
                velocity.x = (velocity.x * 5 + (newV.x)) / 6;
                velocity.y = (velocity.y * 5 + (newV.y)) / 6;

            }

            setLocation(getX() - velocity.x, getY() - velocity.y);
            checkIfOutOfScreen();

            Util.sleep(20);

        }
    }

    public Vector berechneSteigung(){
        /*
        this.steigung = (getY() - (double)Main.getPlayer().getY()) / ((double) getX()- (double)Main.getPlayer().getX());
        this.c = ((double) (Main.getPlayer().getY())) - ((double)Main.getPlayer().getX()*steigung);
         */

        int xDiff =  getX() - Main.getPlayer().getX();
        int yDiff =  getY() - Main.getPlayer().getY();
        xDiff = (xDiff > 0) ? 10 : -10;
        yDiff = (yDiff > 0) ? (yDiff / 10) : -(yDiff / 10);



        return new Vector(xDiff, yDiff);
    }


}




