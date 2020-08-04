package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        Random rand = new Random();
        List<Person>  tempList = new ArrayList<>();
        PersonFactory factory = new PersonFactory();
        Stream.generate(factory::createRandomPerson)
                .limit(100)
                .forEach(tempList::add);
        char randomChar = (char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
        this.personStream = tempList.stream();
        this.startingCharacter = String.valueOf(randomChar);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {

        this(Arrays.stream(people).sequential(), startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {

        this(people.stream(), startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        List<Person> tempList = new ArrayList<>();
        personStream
                .filter(person ->  person.getName().charAt(0) == this.startingCharacter.charAt(0))
                .forEach(tempList::add);
        return tempList;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        List<Person> tempList = new ArrayList<>();
        personStream.filter(person ->  person.getName().charAt(0) == this.startingCharacter.charAt(0)).forEach(tempList::add);
        return tempList;
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        List<Person> tempList = new ArrayList<>();
        personStream.filter(person ->  person.getName().charAt(0) == this.startingCharacter.charAt(0)).forEach(tempList::add);
        return tempList.toArray(new Person[0]);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        List<Person> tempList = new ArrayList<>();
        personStream
                .filter(person ->  person.getName().charAt(0) == this.startingCharacter.charAt(0))
                .forEach(tempList::add);
        return tempList.toArray(new Person[0]);
    }

}
