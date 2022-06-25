package objects.enemies;

import main.Util;

public class
Dwarf extends Enemies{
    public Dwarf(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(speed);
        setIstamLeben(true);
    }


    public Dwarf(){
        super(-500, -400, 75, 125, 3, "Spaceship.png");  //TODO dynamische Wert bei widht und Height  und dateiName ändern
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
        while (true) {
            setX(getX()-1);
            setY (getY()-150);                                         // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (High/Down Move) //
            Util.sleep(20);
        }
    }




}

