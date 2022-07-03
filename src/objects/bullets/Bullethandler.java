package objects.bullets;

import main.Main;
import main.Util;
import objects.enemies.Enemies;

import java.util.ArrayList;

public class Bullethandler {

    public static void colisionBvE(){
        //System.out.println("colisionBvE");
        while(!Main.isPause()){
            //System.out.println("loop - colisionBvE");
            ArrayList<ArrayList> bullets = Bullets.getInstances();
            ArrayList<ArrayList> enemys = Enemies.getInstances();

            for (int i = 0; i < bullets.size(); i++) {
                for (int j = 0; j < bullets.get(i).size(); j++){
                    Bullets bullet = (Bullets) bullets.get(i).get(j);

                    //System.out.println(bullet.isAlive());
                    if (bullet.isAlive()){
                        //Bullet with Player
                        if (!bullet.isPlayerFriendly()){
                            if (Util.rectCollision(Main.getPlayer().getJLabel(), bullet.getJLabel())){
                                Main.getPlayer().gotHit();
                                System.out.println("Player got hit");
                                bullet.gotHit();
                            }
                        }


                        //Bullet with Enemy
                        for (int k = 0; k < enemys.size(); k++) {
                            for (int l = 0; l < enemys.get(k).size(); l++) {
                                Enemies enemy = (Enemies) enemys.get(k).get(l);
                                if (Util.rectCollision(bullet.getJLabel(), enemy.getJLabel())){
                                    enemy.manipulateHealthpoints(-1);
                                    System.out.println("Enemy got hit");
                                    bullet.gotHit();
                                }
                            }
                        }

                    }
                }
            }
            Util.sleep(200);
        }


    }


    public static void deleteBullet(Bullets bullet){
        bullet.setAlive(false);
        bullet.getJLabel().setIcon(null);
        bullet.getJLabel().setIcon(Util.resizeImage(bullet.getWidth(), bullet.getHeight(), "resources/enemies/unicorn.png"));

    }

}
