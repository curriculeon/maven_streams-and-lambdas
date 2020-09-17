package com.github.curriculeon;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */
public class StreamMap {
    /**
     * Section 8.3
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */
    public static Stream<String> letters(String someWord) {
        return Arrays.asList(someWord.split("")).stream(); // The split() method is used to split a string into an array of substrings, and returns the new array.
        //and then to stream() of single characters
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        return Arrays
                .asList(someWords)
                .stream()
                .map(str -> letters(str)); // takes a Stream and transform it to another Stream. It applies a function on each element of Stream and store return value into new Stream.
    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */
    public static Stream<String> wordsFlatMap(String... stringArray) {
        return Arrays
                .asList(stringArray)
                .stream()
                .flatMap(str -> letters(str)); // flatMap() is used for both transformation and flattening - transforms to one level structure.
    }
}