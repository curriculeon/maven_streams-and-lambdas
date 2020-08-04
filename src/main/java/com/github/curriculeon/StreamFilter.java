package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.tools.RandomUtils;
import com.github.curriculeon.tools.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */

/**
 * TODO s implemented by Monica Deshmukh 8/3/2020
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        //generate random starting character
        this.startingCharacter = StringUtils.capitalizeFirstChar(RandomUtils.createString('A', 'Z', 1));
        this.personStream = generatePersonsStream(startingCharacter);
        //this(Stream.empty(), null);
    }
    //helper methods to generate a stream of hundred persons with same starting character which is a randomly generated capital letter.
    private Stream<Person> generatePersonsStream(String startingCharacter) {
        Stream personStream = IntStream
                .range(0, 100)
                .mapToObj(x -> generateRandomPersonStream(startingCharacter));
        return personStream;
        //return null;
    }

    private Person generateRandomPersonStream(String startingCharacter){
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString(startingCharacter.charAt(0), 'e', 5));
        String[] aliases = RandomUtils.createStrings('a', 'z', 3, 5);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, isMale, personalId, birthDate, aliases);
        return randomPerson;
    }
    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Stream.of(people), startingCharacter);
        //this(Stream.empty(), null);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(people.stream(), startingCharacter);
        //this(Stream.empty(), null);
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
        Stream<Person> streamOfPersons = this.personStream
                                    .filter(person -> {
                                        char p = person.getName().charAt(0);
                                        return (p == this.startingCharacter.charAt(0));
                                    });
        return streamOfPersons.collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
            return this.personStream
                    .filter(person ->
                    person.getName().charAt(0) == this.startingCharacter.charAt(0))
                    .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return this.personStream
                .filter(person ->
                        person.getName().charAt(0) == this.startingCharacter.charAt(0))
                .toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Stream<Person> streamOfPersons = this.personStream
                .filter(person -> {
                    char p = person.getName().charAt(0);
                    return (p == this.startingCharacter.charAt(0));
                });
        return streamOfPersons.toArray(Person[]::new);
    }

}
