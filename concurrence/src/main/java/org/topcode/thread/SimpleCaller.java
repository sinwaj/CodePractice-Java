package org.topcode.thread;

import java.util.concurrent.Callable;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleCaller implements Callable<String> {
    private boolean finished = false;

    @Override
    public String call() throws Exception {
        return String.valueOf(!finished);
    }

    public boolean isFininshed() {
        return finished;
    }
}
