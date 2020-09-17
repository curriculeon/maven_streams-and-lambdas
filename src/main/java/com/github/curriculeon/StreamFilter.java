package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;
import com.github.curriculeon.tools.RandomUtils;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
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
        this(Stream
                        .generate(new PersonFactory()::createRandomPerson) // <Class name>::<method name>
                        .limit(100),
                RandomUtils.createCharacter('A', 'Z'));
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Stream.of(people), startingCharacter);
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
     */
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        Predicate<Person> filterClause = person -> person.getName().startsWith(this.startingCharacter);
        Stream<Person> filteredStream = personStream.filter(filterClause);
        List<Person> filteredList = filteredStream.collect(Collectors.toList());
        return filteredList;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .toArray(Person[]::new); // call the class constructor (ClassName::new)
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Predicate<Person> filterClause = person -> person.getName().startsWith(this.startingCharacter);
        Stream<Person> filteredStream = personStream.filter(filterClause);
        Person[] filteredArray= filteredStream.toArray(Person[]::new); // call the class constructor (ClassName::new)
        return filteredArray;
    }

}
