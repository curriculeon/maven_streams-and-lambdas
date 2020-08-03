package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.tools.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final char startingCharacter;
    
    /**
     * No arg constructor
     */
    public StreamFilter() {
        this(Stream.empty(), RandomUtils.createCharacter('A', 'Z'));
    }
    
    /**
     * @param people            - Array of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Stream.empty(), startingCharacter);
    }
    
    /**
     * @param people            - List of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(Stream.empty(), startingCharacter);
    }
    
    
    /**
     * @param people            - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter;
    }
    
    
    /**
     * Using multi-line lambda syntax
     *
     * @return a list of person object whose name starts with `this.startingCharacter`
     */
    public List<Person> toListMultiLine() {
        return personStream
                .filter(person -> {
                    return person.getName()
                            .toCharArray()[0] == startingCharacter;
                })
                .collect(Collectors.toList());
    }
    
    
    /**
     * Using one-line lambda syntax
     *
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */
    public List<Person> toListOneLine() {
        return personStream.filter(person -> person.getName().toCharArray()[0] == startingCharacter).collect(Collectors.toList());
    }
    
    
    /**
     * Using one-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */
    public Person[] toArrayOneLine() {
        return toListOneLine().toArray(Person[]::new);
    }
    
    
    /**
     * Using multi-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */
    public Person[] toArrayMultiLine() {
        return toListMultiLine().toArray(Person[]::new);
    }
    
}
