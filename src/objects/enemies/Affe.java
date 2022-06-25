package objects.enemies;

import main.Util;

public class Affe extends Enemies {
    public Affe(int x, int y, int width, int height, int healthpoints, String filepathSkin) {
        super(x, y, width, height, healthpoints, filepathSkin);
        setSpeed(20);
        setIstamLeben(true);
    }

    public Affe() {
        super(-500, -400, 120, 190, 3, "resources/enemies/affe.png"); //TODO dynamische Wert bei widht und Height  und dateiName ändern
        setSpeed(2);
        setIstamLeben(true);
        findXandYforSpwan();
    }

    public void findXandYforSpwan() {

        int y = getScreen().getMonitorHeight();
        int x = getScreen().getMonitorWidth();
        setX((int) (Math.random() * (x - (x - x / 8)) + (x - (x / 8))));
        setY((int) (Math.random() * (y - 30) + 30));


    }
    public void move () {
        while (true) {
            setX(getX() - 10);  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (Sin curve Move)//
            setY(
                    (int) (Math.sin(getX()/100)*200)
            );  // TODO 15 nur temporaren Wert , --> hier dynamisch Wert impletieren und Thread (Sin curve Move)//

            Util.sleep(20);
        }
    }
}









