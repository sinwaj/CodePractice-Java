package org.topcode.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class Streamer  {
    public final static String CONTENT = "Hello World,There is a cat in the zoo!";

    public List<String> split(String content) {
        String[] parts = content.split("\\PL+");
        return Arrays.asList(parts);
    }

}
