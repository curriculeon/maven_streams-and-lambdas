package com.github.curriculeon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 */

/**
 * Implememented by Monica Deshmukh 08/03/2020
 */
public class StreamMap {
    /**
     * Section 8.3
     * @param someWord - word to convert to Stream<String>
     * @return - a Stream of single characters
     */ //TODO
    public static Stream<String> letters(String someWord) {
        return Stream.of(someWord.split(""));
        //return null;
    }

    /**
     * @param someWords - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<Stream<String>> wordsMap(String... someWords) {
        /*Stream<String> streamOfLetters = Stream
                                        .of(someWords)
                                        .flatMap(str -> letters(str));*/
        return Stream.of(wordsFlatMap(someWords));
    }

    /**
     * @param stringArray - variable amount of String arguments
     * @return - a Stream of several Streams of single characters
     */ //TODO
    public static Stream<String> wordsFlatMap(String... stringArray) {
        Stream<String> streamOfWords = Stream
                                    .of(stringArray)
                                      .flatMap(str -> letters(str));
        return streamOfWords;
    }
}