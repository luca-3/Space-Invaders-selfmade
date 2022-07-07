package objects.bullets.types;

import main.Util;
import objects.bullets.Bullets;

public class Laser extends Bullets {

    private String direction;


    public static void createInstance(int spawnX, int spawnY, boolean isPlayerFriendly, String direction) {
        Laser temp = new Laser(spawnX,spawnY,40, 20, isPlayerFriendly, direction, "resources/enemies/affe.png");
        getInstances().get(0).add(temp);
    }



    private Laser(int x, int y, int width, int height, boolean isPlayerFriendly, String direction, String filepathSkin) {
        super(x, y, width, height, isPlayerFriendly, filepathSkin);
        setSpeed(1);
        threading();
        this.direction = direction;
    }

    @Override
    public void threading() {
        Thread movement = new Thread(this::move);
        movement.setName("S - Laser");
        movement.start();
    }

    @Override
    public void move() {
        while(getX() > 100){
            switch (getDirection()){
                //TODO: change Skin to fit the direction
                case "left":
                    setX(getX() - getSpeed());
                    break;
                case "right":
                    setX(getX() + getSpeed());
                    break;
                case "up":
                    setY(getY() - getSpeed());
                    break;
                case "down":
                    setY(getY() + getSpeed());
                    break;
            }

            Util.sleep(100);
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


}
