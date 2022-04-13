package com.example.game.firuges;

public enum EnemyEnum {

    ;
    private String skin;
    private int hp;
    private MobMove move;



    EnemyEnum(String skin, int hp, MobMove move) {
        this.skin=skin;
        this.hp=hp;
        this.move=move;


    }


}
