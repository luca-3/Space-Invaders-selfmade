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
            ArrayList<Bullets> bullets = Bullets.getInstances();
            //System.out.println(bullets.size() + " - " + bullets);


            for (int i = 0; i < bullets.size(); i++) {
                //System.out.println(bullet.isAlive());
                if (bullets.get(i).isAlive()){
                    checkCollisionWithPlayer(bullets.get(i));
                    checkCollisionWithEnemys(bullets.get(i));
                } else if(!bullets.get(i).isAlive()) {
                    bullets.get(i).removeJLabel();
                    bullets.set(i, null);
                    bullets.remove(i);
                }
            }
            Util.sleep(20);
        }
    }

    private static void checkCollisionWithEnemys(Bullets bullet) {
        ArrayList<ArrayList> enemys = Enemies.getInstances();

        //Bullet with Enemy
        for (int k = 0; k < enemys.size(); k++) {
            if(bullet.isPlayerFriendly()){
                for (int l = 0; l < enemys.get(k).size(); l++) {

                    Enemies enemy = (Enemies) enemys.get(k).get(l);

                    if (enemy.getJLabel() != null && Util.rectCollision(bullet.getJLabel(), enemy.getJLabel())){
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

}
