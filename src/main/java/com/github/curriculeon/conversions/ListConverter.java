package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */

/**
 * TODO s implemented by Monica Deshmukh 8/3/2020
 */
public final class ListConverter extends PersonConversionAgent<List<Person>> {
    public ListConverter(List<Person> people) {
        super(people);
    }

    public ListConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Person> toList() {
        return super.objectSequence;
    }

    //TODO
    public Stream<Person> toStream() {
        return super.objectSequence.stream();
        //return null;
    }

    //TODO
    public Person[] toArray() {
        Person[] personArray = new Person[super.objectSequence.size()];
        return super.objectSequence.toArray(personArray);
        //return null;
    }
}
