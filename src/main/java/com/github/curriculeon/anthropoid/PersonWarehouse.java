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
     */
    public List<String> getNames() {
        return people
                .stream() // converting the 'people' list (as a source) to stream - intermediate operation
                .map(Person::getName)//takes one name from stream Person - - intermediate operation
                .collect(Collectors.toList()); // collect the final stream and return a List - terminal operation
    }


    /**
     * @return list of uniquely named Person objects
     */
    public Stream<Person> getUniquelyNamedPeople() {
        return people
                .stream()
                .filter(person -> Collections.frequency(getNames(), person.getName()) == 1); // white-label people whose name occurs exactly once
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        return getUniquelyNamedPeople()
                .filter(person -> person.getName().startsWith(character.toString()));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        List<Person> tempList = new ArrayList<>();
        getUniquelyNamedPeople().limit(n).forEach(tempList::add);
        return tempList.stream();
    }


    /**
     * @return a mapping of Person Id to the respective Person name
     */
    public Map<Long, String> getIdToNameMap() { //Long Id - key, String name - value
        return people
                .stream() // convert map to stream
                .collect(Collectors.toMap(Person::getPersonalId, Person::getName)); // collect the final stream to return map instance
    }


    /**
     * @return Stream of Stream of Aliases
     */
    public Stream<Stream<String>> getNestedAliases() {
        List<Stream<String>> outerList = new ArrayList<>();
        people.forEach(person -> outerList.add(Arrays.stream(person.getAliases()).sequential()));

        return outerList.stream();
    }


    /**
     * @return Stream of all Aliases
     */
    public Stream<String> getAllAliases() {
        List<String> aliases = new ArrayList<>();
        getNestedAliases().forEach(x -> x.forEach(aliases::add));
        return aliases.stream();
    }


    // DO NOT MODIFY
    public Boolean contains(Person p) { // return type: boolean; parameters: (Object element ) (Person p)
        return people.contains(p); //ArrayList people contain Person p
        // The contains() method checks whether an ArrayList contains the specified element.
        // Returns true if an element exists and false if not.
    }

    // DO NOT MODIFY
    public void clear() { // (java.util.ArrayList) clear() method removes all of the elements from this list.
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size(); //find the length or size of ArrayList
    }

    // The iterator() method of ArrayList class is used to get an iterator
    // over the elements in this list in proper sequence.
    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator(); // returns iterator over the elements in this list in proper sequence, to retrieve elements one by one
    }
}