package objects.bullets.types;

import main.Util;
import objects.bullets.Bullets;

public class Laser extends Bullets {

    private String direction;


    public static void createInstance(int spawnX, int spawnY, String direction) {
        Laser temp = new Laser(spawnX,spawnY,40, 20, "right", "resources/enemies/affe.png");
        getInstances().get(0).add(temp);
    }



    private Laser(int x, int y, int width, int height, String direction, String filepathSkin) {
        super(x, y, width, height, filepathSkin);
        setSpeed(1);
        threading();
        this.direction = direction;
    }
    @Override
    public void threading() {
        Thread movement = new Thread(this::move);
        movement.start();
    }


    @Override
    public void move() {
        while(getX() > 100){
            switch (getDirection()){
                case "left":
                    setX((int) (getX() - getSpeed()));
                    break;
                case "right":
                    setX((int) (getX() + getSpeed()));
                    break;
                case "up":
                    setY((int) (getY() - getSpeed()));
                    break;
                case "down":
                    setY((int) (getY() + getSpeed()));
                    break;
            }

            Util.sleep(100);
        }
    }

    public String getDirection() {
        return direction;
    }


}
