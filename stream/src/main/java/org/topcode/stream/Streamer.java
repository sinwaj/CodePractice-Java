package org.topcode.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class Streamer {
    public final static String CONTENT = "Hello World,There is a cat in the zoo!";

    public List<String> split(String content) {
        String[] parts = content.split("\\PL+");
        return Arrays.asList(parts);
    }

    public List<String> filter(List<String> datas, int size) {
        return datas.stream()
                .filter(w -> w.length() >= size)
                .collect(Collectors.toList());
    }

    public List<String> toLow(List<String> datas) {
        return datas.stream()
                .map(w->w.toLowerCase())
                .collect(Collectors.toList());
    }

}
