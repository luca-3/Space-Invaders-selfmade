package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

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
        super(-500, -400, 92, 96, 3, "resources/enemies/zwerg.png");  //TODO dynamische Wert bei widht und Height  und dateiName ändern
        setSpeed(1);
        findXandYforSpwan();
        threading();

    }

    public void findXandYforSpwan(){

        int y =getScreen().getMonitorHeight();
        int x= getScreen().getMonitorWidth();
        setX   ((int )(Math.random() * (x - (x-x/8)) + (x-(x/8))));
        setY( (int) (Math.random()*((y-50)-30)+ 30) );

    }



    public void threading() {
        Thread move = new Thread(this::move);
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

