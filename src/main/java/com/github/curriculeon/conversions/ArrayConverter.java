package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
    private static PersonFactory personFactory = PersonFactory.getInstance();
    public ArrayConverter(Person... people) {
        super(people);
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(personFactory::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        return Stream.of(toArray()).collect(Collectors.toList());
    }

    //TODO
    public Stream<Person> toStream() {
        return Stream.of(toArray());
    }

    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
