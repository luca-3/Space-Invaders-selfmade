package objects;
//NEW

import main.Keyboard;
import main.Main;
import main.Util;
import objects.bullets.types.Laser;
import objects.enemies.EnemyHandler;

import javax.swing.*;

public class Player extends GameObjects {

    private int healthpoints, score, levelPlayer;
    private final int initialHeight, initialWidth;
    int speed = 10;

    boolean invulnerable = false;


    public Player() {
        super(500, 500, Main.getScreen().getMonitorWidth()/16, Main.getScreen().getMonitorHeight()/9, "resources/player/Spaceship.png");

        this.score = 0;
        this.healthpoints = 3;
        this.levelPlayer = 1;
        this.initialHeight = getHeight();
        this.initialWidth = getWidth();
    }


    public void reset(){
        setX(500);
        setY(500);
        this.score = 0;
        this.healthpoints = 3;
        this.levelPlayer = 1;
    }

    public void gotHit(){
        manipulateHealthpoints(-1);
        setLocation(500, 500);
        //TODO: Respawn Animation

        new Thread(() -> setInvulnerable(2000)).start();
        //setInvulnerable(2500);
    }

    private void setInvulnerable(int millis) {
        if(!invulnerable){
            invulnerable = true;
            for(int i = 4; i >= 0; i--){
                updateGraphicsForShieldState(i);
                if(i == 0) setX(getX()+24); //to compensate for the different sizes of the skins with and without shields
                //Equation to split the wait time to make it look like the shield is being taken away slowly
                int sleepTime = (int) ((millis - millis / 4) + ((100 * millis/1500) - (millis - millis / 4) ) / (1 + Math.pow(i / 3.117136, 46.77973)));
                Util.sleep(sleepTime);
            }
            invulnerable = false;
        }
    }

    public void checkIfDead(){
        if(healthpoints <= 0){
            reset();
            //TODO: Hier könnte man das Level zurücksetzen, die Gegnerliste leeren und so einen "neustart" auslösen
            EnemyHandler.reset();
            //TODO: Game Over message
        }
    }

    public void updateGraphicsForShieldState(int shieldState){
        //shieldState = 0 - 4, where 0 is no shield and 1 - 4 is the shield in different sizes
        if(shieldState == 0){
            getJLabel().setIcon(Util.resizeImage(initialWidth, initialHeight, "resources/player/Spaceship.png"));
            return;
        }

        String iconPath = String.format("resources/player/player-with-bubble-shield-%dof4.png", shieldState);
        //int width = 40 * shieldState - 8;
        setHeight((int) (initialHeight * 1.2));
        setWidth((int) (initialWidth * 1.2));

        Icon icon = Util.resizeImage(getWidth(), getHeight(), iconPath);
        getJLabel().setIcon(icon);
    }


    public void move() {
        int xShift, yShift;

        while (!Main.isPause()) {
            xShift = 0;
            yShift = 0;
            if (Keyboard.isWPressed()) {
                if (getY() > 0) yShift -= speed;
            }
            if (Keyboard.isAPressed()){
                if (getX() > 0) xShift -= speed;
            }
            if (Keyboard.isSPressed()){
                if (getY() < getScreen().getMonitorHeight() - getHeight()) yShift += speed;
            }
            if (Keyboard.isDPressed()) {
                if (getX() < getScreen().getMonitorWidth() - getWidth()) xShift += speed;
            }
            setLocation(getX() + xShift, getY() + yShift);

            while (Main.isPause()) Util.sleep(100);
            Util.sleep(20);
        }
    }

    
    public void shoot() {
        while (!Main.isPause()) {
            if (Keyboard.isSpacePressed()) {

                Laser.createInstance(getX(), getY(), true, "right");
                Laser.createInstance(getX(), getY() + getHeight(), true, "right");
            }
            while (Main.isPause()) Util.sleep(100);
            Util.sleep(400);
        }
    }

    public static Icon getLivesIcon(int numberOfLives, int heightJLabel) {
        numberOfLives = (numberOfLives == 0) ? 3 : numberOfLives; //if numberOfLives is 0, set it to 3 (to prevent the program from looking for a picture with a picture 0 hearts)
        String iconPath = String.format("resources/player/heart%d.png", numberOfLives);
        int width = 40 * numberOfLives - 8;
        Icon icon = Util.resizeImage(width, heightJLabel, iconPath);

        return icon;
    }

    public static Icon getScoreIcon(int score, int widthJLabel) {
        int numberOfDigits = (score == 0) ? 0 : Math.min(score / 100, 22);
        String iconPath = String.format("resources/player/scorebar/scorebar-%d.png", numberOfDigits);
        int height = widthJLabel / 24 * 5;
        Icon icon = Util.resizeImage(widthJLabel, height , iconPath);

        return icon;
    }


    public void setHealthpoints(int hp){
        this.healthpoints = hp;
        checkIfDead();
    }

    public int getHealthpoints(){
        return healthpoints;
    }

    public void manipulateHealthpoints(int hp){
        this.healthpoints += hp;
        checkIfDead();
    }

    public void setScore(int score) {
        this.score = score;

        //TODO: Score im Screen aktualisieren
    }

    public int getScore() {
        return score;
    }


    public void manipulateScore(int score) {
        this.score += score;

        //TODO: Score im Screen aktualisieren
    }

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevelPlayer() {
        return levelPlayer;
    }

    public void setLevelPlayer(int levelPlayer) {
        this.levelPlayer = levelPlayer;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }
}
