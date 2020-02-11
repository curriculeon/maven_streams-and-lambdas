package com.github.curriculeon.anthropoid;

import com.github.curriculeon.tools.logging.LoggerHandler;
import com.github.curriculeon.tools.logging.LoggerWarehouse;
import com.github.curriculeon.tools.ReflectionUtils;

import java.util.*;
import java.util.stream.Collector;
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
        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());

        return names;
    }


    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {

        List<Person> uniquelyNamedPeople = new ArrayList<>();

        Map<String, List<Person>> peopleByName = people.stream().collect(
                Collectors.groupingBy(Person::getName));

        peopleByName
                .values()
                .stream()
                .filter(peopleWithSameName -> peopleWithSameName.size() == 1)
                .forEach(
                        peopleWithSameName -> uniquelyNamedPeople.add(peopleWithSameName.get(0)));
        return uniquelyNamedPeople.parallelStream();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {

        Stream<Person> personStream = getUniquelyNamedPeople();
        return personStream.filter(person -> person.getName().startsWith(Character.toString(character)));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        Stream<Person> personStream = getUniquelyNamedPeople();

        return personStream.limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
        Map<Long, String> map = new HashMap<>();
        this.people.stream().forEach(person -> map.put(person.getPersonalId(), person.getName()));
        return map;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {

        List<Stream<String>> lists = new ArrayList<>();
        people.stream().forEach(person -> lists.add(Arrays.asList(person.getAliases()).stream()));
        return lists.stream();
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        List<String> list = new ArrayList<>();
        people.stream().flatMap(person -> Stream.of(person.getAliases())).forEach(list::add);
        return list.stream();
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
