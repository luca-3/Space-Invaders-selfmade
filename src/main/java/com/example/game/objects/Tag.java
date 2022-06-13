package com.example.game.objects;

import com.example.game.mainNew.Main;


public class Tag extends GameObjects{





    public Tag(int x, int y, int width, int height, String filepathSkin, String text) {
        this(x, y, width, height, filepathSkin, text, "");



    }

    public Tag(int x, int y, int width, int height, String filepathSkin, String text, String data){
        super(x, y, width, height, filepathSkin);

        if(data.equals("")){
            getJLabel().setText(text);
        }else{
            int value = (int) Main.getDataTags().get(data);
            getJLabel().setText(text + value);
        }


    }


}
