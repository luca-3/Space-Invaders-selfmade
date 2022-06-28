package objects.enemies.types;

import main.Util;
import objects.enemies.Enemies;

import java.util.Random;

public class Puffy extends Enemies {

    public static void createInstance(){
        Puffy temp = new Puffy();
        getInstances().get(1).add(temp);
    }

    private Puffy(int x, int y, int width, int height, int healthpoints, String filepathSkin, int speed) {
    super(x, y, width, height, healthpoints, filepathSkin);
    setSpeed(speed);
    setAlive(true);
}


    private Puffy(){
        super(-500, -400, 50, 50, 6, "resources/enemies/puffy-big.png");  //TODO dynamische Wert bei widht und Height
        setSpeed(2);

        findXandYforSpwan();
        threading();
    }

    public void threading() {
        Thread move = new Thread(this::move);
        move.start();
    }

    public void findXandYforSpwan(){

        Random r = new Random();
        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX( (int)  (r.nextDouble((x-x/(20)),x)));;
        setY((int) (r.nextDouble(0,y)));

    }



    public void move() {
        int  x= getScreen().getMonitorWidth()/2;
        while (isAlive()) {

            setX(getX()-getRateSpeed());

            if(getX()<x){
                                   //TOdo pufferfisch explodiert
            }

            checkIfOutOfScreen();

            Util.sleep(20);
        }
    }

}




