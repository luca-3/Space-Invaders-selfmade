package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

public class Unicorn extends Enemies {

    public Unicorn(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
        setIstamLeben(true);
    }


    public Unicorn(){
        super(-500, -400, 64, 64, 4, "Spaceship.png");
        setSpeed(2);
        setIstamLeben(true);
        findXandYforSpwan();
    }

    public void findXandYforSpwan(){

        int y =getScreen().getMonitorHeight();
        int x= getScreen().getMonitorWidth();
        setX   ((int )(Math.random() * (x - (x-x/8)) + (x-(x/8))));
        setY( (int) (Math.random()*(y-30)+ 30) );

    }






    public void move() {
        while (true) {
            setX(getX()-70);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (Verflogung Move) //

            System.out.println("moved: x: " + getX() + " y: " + getY());
            Util.sleep(200);
        }
    }




}




