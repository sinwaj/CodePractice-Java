package org.topcode;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.topcode.thread.SimpleCaller;
import org.topcode.thread.SimpleRunnable;

import java.util.concurrent.FutureTask;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class SimpleCallerTest {
    @Test
    public void testSimpleRunnable() throws Exception{
        //given
        FutureTask<String> futureTask = new FutureTask<>(new SimpleCaller());

        //when
        new Thread(futureTask).start();

        String result = futureTask.get();

        //then
        assertThat(result,is("true"));
    }
}
