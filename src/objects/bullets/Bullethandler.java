package objects.bullets;

import main.Main;
import main.Util;
import objects.enemies.Enemies;

import java.util.ArrayList;

public class Bullethandler {

    public static void collision(){
        //System.out.println("colisionBvE");
        while(!Main.isPause()){
            //System.out.println("loop - colisionBvE");
            ArrayList<ArrayList> bullets = Bullets.getInstances();


            for (int i = 0; i < bullets.size(); i++) {
                for (int j = 0; j < bullets.get(i).size(); j++){
                    Bullets bullet = (Bullets) bullets.get(i).get(j);

                    //System.out.println(bullet.isAlive());
                    if (bullet.isAlive()){
                        checkCollisionWithPlayer(bullet);
                        checkCollisionWithEnemys(bullet);
                    }
                }
            }
            Util.sleep(200);
        }
    }

    private static void checkCollisionWithEnemys(Bullets bullet) {
        ArrayList<ArrayList> enemys = Enemies.getInstances();

        //Bullet with Enemy
        for (int k = 0; k < enemys.size(); k++) {
            if(bullet.isPlayerFriendly()){
                for (int l = 0; l < enemys.get(k).size(); l++) {
                    Enemies enemy = (Enemies) enemys.get(k).get(l);
                    if (Util.rectCollision(bullet.getJLabel(), enemy.getJLabel())){
                        enemy.manipulateHealthpoints(-1);
                        bullet.gotHit();
                        Main.getPlayer().manipulateScore(10);
                    }
                }
            }
        }

    }

    private static void checkCollisionWithPlayer(Bullets bullet) {
        //Bullet with Player
        if (!bullet.isPlayerFriendly() && !Main.getPlayer().isInvulnerable()){
            if (Util.rectCollision(Main.getPlayer().getJLabel(), bullet.getJLabel())){
                bullet.gotHit();
                Main.getPlayer().gotHit();
                System.out.println("Player got hit");
            }
        }
    }


    public static void deleteBullet(Bullets bullet){
        bullet.setAlive(false);
        bullet.getJLabel().setIcon(null);
        //TODO: remove from ArrayList
        bullet.getJLabel().setIcon(Util.resizeImage(bullet.getWidth(), bullet.getHeight(), "resources/enemies/unicorn.png"));

    }

}
