package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConverter extends PersonConversionAgent<Stream<Person>> {
    private static PersonFactory personFactory = PersonFactory.getInstance();
    private final List<Person> personList;
    public StreamConverter(Stream<Person> people) {
        super(people);
        this.personList = super.objectSequence.collect(Collectors.toList());
    }

    public StreamConverter(int collectionSize) {
        this(Stream
                .generate(personFactory::createRandomPerson)
                .limit(collectionSize));
    }

    // TODO
    public List<Person> toList() {
        return toStream().collect(Collectors.toList());
    }

    // TODO
    public Stream<Person> toStream() {
        return super.objectSequence;
    }

    // TODO
    public Person[] toArray() {
        return toStream().toArray(Person[]::new);
    }
}
