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
        List<String> tempPersonList = new ArrayList<>();
        people.forEach(person -> tempPersonList.add(person.getName()) );
        return tempPersonList;
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {
        List<Person> tempArray = new ArrayList<>();
        List<String> names = getNames();
        people.stream().filter(person -> Collections.frequency(names,person.getName()) ==1 ).forEach(tempArray::add);
        return  tempArray.stream();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        List<Person> tempList = new ArrayList<>();
        people.stream().filter(person -> person.getName().charAt(0) == character).forEach(tempList:: add);
        return tempList.stream();
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        List<Person> tempList = new ArrayList<>();
        getUniquelyNamedPeople().limit(n).forEach(tempList:: add);
        return tempList.stream();
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
        Map<Long,String> tempMap = new HashMap<>();
        people.forEach(person -> tempMap.put(person.getPersonalId(), person.getName()));
        return tempMap;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
        List<Stream<String>> outerList = new ArrayList<>();
        people.forEach(person -> outerList.add(Arrays.stream(person.getAliases()).sequential()));

        return outerList.stream();
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        List<String> aliases = new ArrayList<>();
        getNestedAliases().forEach(x -> x.forEach(aliases::add));
        return aliases.stream();
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
