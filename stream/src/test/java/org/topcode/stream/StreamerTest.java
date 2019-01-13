package org.topcode.stream;

import org.junit.Test;
import org.topcode.thread.Streamer;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by sinwaj on 2018/12/24.
 */
public class StreamerTest {
    @Test
    public void testSplit() throws Exception{
        //given
        String input = Streamer.CONTENT;
        List<String> expectWords = Arrays.asList(new String[]{
                "Hello", "World", "There", "is", "a", "cat", "in", "the", "zoo"});

        //when
        List<String> actualWords = new Streamer().split(input);


        //then
        assertThat(actualWords,is(expectWords));
        System.out.println(actualWords);
    }
}
