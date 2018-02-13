package com.utils;

/**
 * Created by Alexandr Trostyanko
 * Operations with time
 */
public class TimeUtils {

    /**
     * waiting for seconds
     * @param timeoutInSeconds timeout in seconds for wait
     */
    public static void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * waiting for seconds
     * @param timeoutInMillis timeout in seconds for wait
     */
    public static boolean waitForMillis(int timeoutInMillis) {
        try {
            Thread.sleep(timeoutInMillis);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
