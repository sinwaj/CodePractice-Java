package org.topcode;

import org.junit.Test;
import org.topcode.thread.SimpleRunnable;
import org.topcode.thread.SimpleThread;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleRunnableTest {
    @Test
    public void testSimpleRunnable() throws Exception{
        SimpleRunnable simpleRunnable  = new SimpleRunnable();

        new Thread(simpleRunnable).start();

        Thread.sleep(1000);

        assert simpleRunnable.isFininshed();
    }
}
