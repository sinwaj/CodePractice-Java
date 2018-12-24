package org.topcode;

import org.junit.Test;
import org.topcode.thread.SimpleThread;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleThreadTest {
    @Test
    public void testSimpleThread() throws Exception{
        SimpleThread simpleThread = new SimpleThread();

        simpleThread.start();

        Thread.sleep(1000);

        assert simpleThread.isFininshed();
    }
}
