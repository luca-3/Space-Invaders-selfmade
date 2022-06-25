package objects.enemies;

import main.Util;

public class Kitty extends Enemies{
    public Kitty(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
        setIstamLeben(true);
    }


    public Kitty(){
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
            setX(getX()-500);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //

            System.out.println("moved: x: " + getX() + " y: " + getY());
            Util.sleep(200);
        }
    }




}

