package main;
//NEW

public class Util {

    private static int startTime;

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startTimer(){
        startTime = (int) System.currentTimeMillis();
    }

    public static int readTimerMillis(){
        return (int) System.currentTimeMillis() - startTime;
    }

    public static int readTimerSec(){
        return (int) (System.currentTimeMillis() - startTime) / 1000;
    }

    public static int readTimerMin(){
        return (int) (System.currentTimeMillis() - startTime) / 60000;
    }
}
