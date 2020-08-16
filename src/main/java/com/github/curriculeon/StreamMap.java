package com.github.curriculeon;

import java.util.stream.Stream;
import java.util.Arrays;
/**
 * Created by leon on 5/24/17.
 */
public class StreamMap {
    /**
     * Section 8.3
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */ //TODO
    public static Stream<String> letters(String someWord)
    {
        //return null;
        return Arrays.asList(someWord.split("")).stream();
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<Stream<String>> wordsMap(String... someWords)
    {
        //return null;
        return Arrays
                .asList(someWords)
                .stream()
                .map(str -> letters(str));
    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<String> wordsFlatMap(String... stringArray)
    {
       // return null;
        return Arrays
                .asList(stringArray)
                .stream()
                .flatMap(str -> letters(str));
    }
}