package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

public class Kitty extends Enemies {
    public Kitty(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
        setIstamLeben(true);
    }


    public Kitty(){
        super(-500, -400, 75, 75, 10000, "resources/enemies/kitty.png");  //TODO dynamische Wert bei width und Height  und dateiName ändern
        setSpeed(1);
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
        int maxX= getScreen().getMonitorWidth()/8;
        int x=0;
        while (true) {
             if( getX()-10 <x){
                x= getX()+10;
            }else {
               x= getX()-10;
            }  ;  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //
            setX(x);

            Util.sleep(20);
        }
    }




}

