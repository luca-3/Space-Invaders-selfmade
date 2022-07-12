package objects.enemies.types;

import main.Main;
import main.Util;
import objects.enemies.Enemies;
import javax.swing.*;
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
        super(-500, -400, Main.getScreen().getMonitorWidth()/19, Main.getScreen().getMonitorHeight()/11, 2, "resources/enemies/puffy-small.png");
        setSpeed(2);

        findXandYforSpwan();
        threading();
    }

    public void threading() {
        Thread move = new Thread(this::move);
        move.setName("Puffy");
        move.start();
    }


    public void move() {
        int  x= getScreen().getMonitorWidth()/2;
        boolean isBig=false;
        while (isAlive()) {

            setX(getX()-getSpeed());

            if(getX()<x && isBig==false){
                isBig=true;

                       setLabel("resources/enemies/puffy-big.png");
            }

            checkIfOutOfScreen();

            Util.sleep(20);
        }
    }

    public void setLabel( String filepathSkin ) {
        Icon skin = null;
        int tempWidht= (int) (getWidth()*1.25);
        int tempHeight= (int)(getHeight()*1.25);
        if(filepathSkin != null)  skin = (Util.resizeImage(tempWidht, tempHeight, filepathSkin));
        removeJLabel();
        JLabel label = new JLabel();
        label.setBounds(getX(), getY(),tempWidht , tempHeight);
        label.setIcon(skin);
        setLabel(label);

    }


}






