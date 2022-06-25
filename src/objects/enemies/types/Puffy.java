package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

public class Puffy extends Enemies {
    public Puffy(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
    super(x, y, width, height, healthpoints, filepathSkin);
    setSpeed(speed);
    setIstamLeben(true);
}


    public Puffy(){
        super(-500, -400, 50, 50, 6, "Spaceship.png");  //TODO dynamische Wert bei widht und Height  und dateiName ändern
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
        int  x= getScreen().getMonitorWidth()/2;
        while (true) {



            setX(getX()-10);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread  //

            if(getX()<x){
                                     //tODO Funktion Pufferfisch Explodiert
            }

            Util.sleep(20);
        }
    }




}




