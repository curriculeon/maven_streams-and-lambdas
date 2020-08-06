package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
        Random random = new Random();
        char randomChar=(char)(random.nextInt(26)+'A');
        this.startingCharacter=randomChar+"";
        this.personStream = Stream.generate(()->(new PersonFactory()).createRandomPerson()).limit(100);
        //this(Stream.empty(), null);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this( Arrays.stream(people), startingCharacter);
        //this(Stream.empty(), null);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this( people.stream(), startingCharacter);
       // this(Stream.empty(), null);
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
        List<Person> personList = new ArrayList<>();
                personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .collect(Collectors.toList());
        return personList;
        //return null;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .collect(Collectors.toList());
        //return personList;

        //return null;
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        List<Person> personList = new ArrayList<>();
                personStream
                .filter(person -> person.getName().charAt(0) == this.startingCharacter.charAt(0))
                .forEach(personList :: add );
                return personList.toArray(new Person[0]);

        //return null;
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        List<Person> personList = new ArrayList<>();
         personStream
                .filter(person -> person.getName().charAt(0) == this.startingCharacter.charAt(0))
                .forEach(personList :: add);
        return personList.toArray(new Person[0]);
    }

}
