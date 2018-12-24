package org.topcode.thread;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleRunnable implements Runnable {

    private boolean finished = false;

    @Override
    public void run() {
        System.out.println("I am a simple runnable!");
        finished = true;
    }

    public boolean isFininshed() {
        return finished;
    }
}
