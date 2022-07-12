package objects.enemies.types;

import main.Main;
import main.Util;
import objects.bullets.types.Laser;
import objects.enemies.Enemies;

import java.util.Random;

public class Dwarf extends Enemies {

    public static void createInstance(){
        Dwarf temp = new Dwarf();
        getInstances().get(2).add(temp);
    }

    private Dwarf(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
    }


    private Dwarf(){
        super(-500, -400, Main.getScreen().getMonitorWidth()/21, Main.getScreen().getMonitorHeight()/11, 3, "resources/enemies/zwerg.png");
        setSpeed(0.7);
        findXandYforSpwan();
        threading();

    }



    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Dwarf");
        move.start();
    }


    public void move() {
        while (isAlive()) {
            while(getY() > 10){
                setY(getY() - getSpeed());
                setX(getX() - getSpeed());
                Util.sleep(20);
            }
            Laser.createInstance(getX(), getY(), false, "down");
            Util.sleep(1200);
            while(getY() < Main.getScreen().getMonitorHeight()-400){ //TODO: Dynamischer Wert
                setY(getY() + getSpeed());
                Util.sleep(20);
                checkIfOutOfScreen();
            }


            /*
            setX(getX()-10);
           // setY (getY()-20);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //

            checkIfOutOfScreen();
            Util.sleep(20);

             */
        }
    }

}

