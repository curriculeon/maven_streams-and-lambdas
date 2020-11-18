package com.github.curriculeon.anthropoid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leon on 08/10/2018.
 */
public class TestUniquelyNamedPersons {

    private PersonWarehouse warehouse;
    private PersonFactory factory;

    @Before
    public void setup() {
        this.factory = new PersonFactory();
        this.warehouse = new PersonWarehouse();

        Stream
                .generate(factory::createRandomPerson)
                .limit(99999)
                .forEach(warehouse::addPerson);
    }


    @Test
    public void testGetUniquelyNamedPeople() {
        // when
        List<String> actualList = warehouse
                .getUniquelyNamedPeople()
                .map(Person::getName)
                .collect(Collectors.toList());

        // then
        List<String> expectedList = this.deriveUniqueNames(warehouse);
        Assert.assertEquals(expectedList.toString(), actualList.toString());
    }

    @Test
    public void testGetFirstNUniquelyNamedPeople() {
        // : Given
        Integer valueOfN = 2;

        // when
        List<String> actual = warehouse
                .getFirstNUniquelyNamedPeople(valueOfN)
                .map(Person::getName)
                .collect(Collectors.toList());

        // then
        List<String> uniqueNameDerivation = this.deriveUniqueNames(warehouse);
        List<String> expected = uniqueNameDerivation.subList(0, valueOfN);
        Assert.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    public void testGetUniquelyNamedPeopleStartingWith() {
        // when
        Character startingCharacter = 'a';

        List<String> actual = warehouse
                .getUniquelyNamedPeopleStartingWith(startingCharacter)
                .map(Person::getName)
                .collect(Collectors.toList());

        // Then
        actual.forEach(name -> Assert.assertTrue(name.startsWith(startingCharacter.toString())));
    }


    private List<String> deriveUniqueNames(PersonWarehouse warehouse) {
        // derive unique names
        List<String> expectedList = new ArrayList<>();
        for (Person person : warehouse) {
            String personName = person.getName();
            Assert.assertNotNull(warehouse.getNames());
            boolean isUnique = Collections.frequency(warehouse.getNames(), personName) == 1;
            if (isUnique) {
                expectedList.add(personName);
            }
        }
        return expectedList;
    }

}
