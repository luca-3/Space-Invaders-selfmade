package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

public class Kitty extends Enemies {

    public static void createInstance(){
        Kitty temp = new Kitty();
        getInstances().get(3).add(temp);
    }

    private Kitty(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
    }


    private Kitty(){
        super(-500, -400, 75, 75, 10000, "resources/enemies/kitty.png");  //TODO dynamische Wert bei width und Height  und dateiName ändern
        setSpeed(1);
        findXandYforSpwan();
        threading();
    }

    public void findXandYforSpwan(){
        int y =getScreen().getMonitorHeight();
        int x= getScreen().getMonitorWidth();
        setX   ((int )(Math.random() * (x - (x-x/8)) + (x-(x/8))));
        setY( (int) (Math.random()*((y-30)-50)+ 50) );
    }




    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void move() {
        int maxX = getScreen().getMonitorWidth()/8;
        int x = 0;
        while (isAlive()) {
             if (getX() - 15 < x){
                x = getX() + 15;
            }else {
               x = getX() - 15;
            }  ;  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //
            setX(x);

            //TODO ifmplement method to kill kitty after shoot
            setAlive(false);

            Util.sleep(1000);
        }
    }




}

