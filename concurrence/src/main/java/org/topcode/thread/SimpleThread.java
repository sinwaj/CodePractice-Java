package org.topcode.thread;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleThread extends Thread{
    private boolean finished = false;
    public void run() {
        System.out.println("I am running!");
        finished = true;
    }

    public boolean IsFininshed() {
        return finished;
    }
}
