package com.github.curriculeon.anthropoid;

import com.github.curriculeon.tools.logging.LoggerHandler;
import com.github.curriculeon.tools.logging.LoggerWarehouse;
import com.github.curriculeon.tools.ReflectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */

/**
 * TODO s implemented by Monica Deshmukh 8/3/2020
 */

public final class PersonWarehouse implements Iterable<Person> {
    private final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private final List<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public List<String> getNames() {
         Stream<String> streamOfNames = people.stream().map(Person::getName);
         return  streamOfNames.collect(Collectors.toList());
        //return null;
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    //convert the List to HashSet. Hashset does not allow duplicate values.
    public Stream<Person> getUniquelyNamedPeople() {
        /*List<String> names = this.getNames();
        HashSet<String> uniqueNames = new HashSet<>(names);
        Stream<String> uniqueNamesStream = uniqueNames.stream();
        One liner for the above code is as follows*/
        Stream<String> uniqueNamesStream = new HashSet<>(this.getNames()).stream();
        Stream<Person> peopleWithUniqueNames = people
                                             .stream()
                                             .filter(person -> person.getName().equals(uniqueNamesStream));
        return peopleWithUniqueNames;
        //return null;
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        Stream<Person> peopleWithUniqueNames = this.getUniquelyNamedPeople();

        return peopleWithUniqueNames
                .filter(person -> person.getName().charAt(0) == character);
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        Stream<Person> peopleWithUniqueNames = this.getUniquelyNamedPeople();
        return peopleWithUniqueNames.limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    //Collect stream elements into Map using Collectors.toMap() and Collectors.groupingBy() methods
    //using Java 8 Stream APIs. Convert stream to map using Java stream APIs.
    //If the stream elements have the unique map key field then we can use Collectors.toMap()
    // to collect elements to map in Map<keyObj, Element> format
    public Map<Long, String> getIdToNameMap() {
       Map<Long, String> idToNameMap = people.stream()
                                        .collect(Collectors.toMap(Person::getPersonalId, Person::getName));
       return idToNameMap;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
        Stream<String> streamOfAliases = this.getAllAliases();
        return Stream.of(streamOfAliases);
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        String[] aliases = (String[])people
                                    .stream()
                                    .map(Person::getAliases).toArray();
        return Stream.of(aliases);
        //return null;
    }

    // DO NOT MODIFY
    public Boolean contains(Person p) {
        return people.contains(p);
    }

    // DO NOT MODIFY
    public void clear() {
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size();
    }

    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
