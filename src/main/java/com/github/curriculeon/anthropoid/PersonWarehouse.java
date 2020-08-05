package com.github.curriculeon.anthropoid;

import com.github.curriculeon.tools.logging.LoggerHandler;
import com.github.curriculeon.tools.logging.LoggerWarehouse;
import com.github.curriculeon.tools.ReflectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        List<Person> uniquelyNamedPeople = new LinkedList<>();

        Map<String, List<Person>> peopleByName = people.stream().collect(
                Collectors.groupingBy(Person::getName));

        peopleByName
                .values()
                .stream()
                //.filter(peopleWithSameName -> peopleWithSameName.size() == 1)
                .forEach(
                        record -> uniquelyNamedPeople.add(record.get(0)));
        return uniquelyNamedPeople.parallelStream();
    }

    public Map<String, List<Person>> test()
    {
        Map<String, List<Person>> peopleByName = people.stream().collect(
                Collectors.groupingBy(Person::getName));
        return peopleByName;
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

    public static void main(String [] args)
    {
        /*String [] aliases = new String[]{"alias1", "alias2"};
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Person person = new Person("john", true, 1L, format.parse("2000-06-30"), aliases);
            Person person1 = new Person("susan", false, 2L, format.parse("2000-05-20"), aliases);
            Person person2 = new Person("alice", false, 3L, format.parse("2000-04-20"), aliases);
            Person person3 = new Person("eve", false, 4L, format.parse("1999-05-20"), aliases);
            Person person4 = new Person("eve", false, 5L, format.parse("1999-05-20"), aliases);


            PersonWarehouse people = new PersonWarehouse();
            people.addPerson(person);
            people.addPerson(person1);
            people.addPerson(person2);
            people.addPerson(person3);
            people.addPerson(person4);

            //people.getUniquelyNamedPeople().forEach(p -> System.out.println(p.getName()));
        }catch (ParseException pe)
        {
            pe.printStackTrace();
        }*/
        PersonWarehouse warehouse;
        PersonFactory factory;
        factory = new PersonFactory();
        warehouse = new PersonWarehouse();

        Map<String, List<Person>> map = new LinkedHashMap<>();

        Stream
                .generate(factory::createRandomPerson)
                .limit(9999)
                .forEach(warehouse::addPerson);

        map = warehouse.test();
        Set<String> names = map.keySet();

        for(int i = 0; i < map.size(); i++)
            if(map.get(names.toArray()[i]).size() > 1)
                System.out.println(map.get(names.toArray()[i]));


    }
}
