package objects;

import main.Main;
import main.Util;

import java.awt.*;


public class Tag extends GameObjects{

    private final String text, data;

    public Tag(int x, int y, int width, int height, String filepathSkin, String text) {
        this(x, y, width, height, filepathSkin, text, "");
    }

    public Tag(int x, int y, int width, int height, String filepathSkin, String text, String data){
        super(x, y, width, height, filepathSkin);

        this.text = text;
        this.data = data;

        updateTag();
        getJLabel().setForeground(Color.white);
        //TODO: JLabel in den Vordergrund stellen
    }

    public void updateTag(){
        if(data.equals("")){
            getJLabel().setText(text);
        } else if(data.equals("time")){
            int min = Util.readTimerMin();
            int sec = Util.readTimerSec() - min * 60;
            if(sec < 10){
                getJLabel().setText(text + min + ":0" + sec);
            } else {
                getJLabel().setText(text + min + ":" + sec);
            }

        } else if(data.equals("lives")){
            getJLabel().setIcon(Player.getLivesIcon((int) Main.getDataTags().get(data), getHeight()));

        } else if(data.equals("score") && text == null){
            getJLabel().setIcon(Player.getScoreIcon((int) Main.getDataTags().get(data), getWidth()));

        } else{
            int value = (int) Main.getDataTags().get(data);
            getJLabel().setText(text + value);
            System.out.println("Tag: " + text + " " + value);
        }
    }

}