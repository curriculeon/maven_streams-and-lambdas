package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */

/**
 * TODO s implemented by Monica Deshmukh 8/3/2020
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        return Arrays.asList(this.toArray());
        //return null;
    }

    //TODO
    public Stream<Person> toStream() {
        return Stream.of(this.toArray());
    }

    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
