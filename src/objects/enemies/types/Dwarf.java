package objects.enemies.types;

import main.Main;
import main.Util;
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
        setSpeed(1);
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
            setX(getX()-10);
           // setY (getY()-20);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //

            checkIfOutOfScreen();
            Util.sleep(20);
        }
    }

}

