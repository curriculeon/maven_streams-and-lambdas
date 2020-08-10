package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
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
        PersonFactory personFactory = new PersonFactory();
        this.personStream = personFactory.createPersonStream(100);
        char randomChar = (char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
        this.startingCharacter = Character.toString(randomChar);
        //this(Stream.empty(), null);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        List<Person> personList = Arrays.asList(people);
        this.personStream = personList.stream();
        this.startingCharacter = startingCharacter.toString();
        //this(personList, startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    //public StreamFilter(List<Person> people, Character startingCharacter) {
      //  this(Stream.empty(), null);
    //}





    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        List<Person> listOfNamesWithStartingCharacter;
        listOfNamesWithStartingCharacter = this.personStream
                                            .filter(person -> person.getName().startsWith(this.startingCharacter))
                                            .collect(Collectors.toList());
        return listOfNamesWithStartingCharacter;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        List<Person> listOfPersons;
        listOfPersons = this.personStream
                            .filter(person -> person.getName().startsWith(this.startingCharacter))
                            .collect(Collectors.toList());

        return listOfPersons;
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        Person[] arrayOfPersons;
        arrayOfPersons = this.personStream
                                .filter(person -> person.getName().startsWith(this.startingCharacter))
                                .toArray(Person[]::new);
        return arrayOfPersons;
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Person[] arrayOfPersons;
        arrayOfPersons = this.personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .toArray(Person[]::new);
        return arrayOfPersons;
    }

}
