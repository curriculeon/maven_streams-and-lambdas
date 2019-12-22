package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/31/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestPersonWarehouse {

    private PersonWarehouse warehouse;
    private PersonFactory factory;

    @Before
    public void setup() {
        this.factory = new PersonFactory();
        this.warehouse = new PersonWarehouse();

        Stream
                .generate(factory::createRandomPerson)
                .limit(9999)
                .forEach(warehouse::addPerson);
    }

    @Test
    public void testAddPerson() {
        // given
        Person person = factory.createRandomPerson();

        // when
        warehouse.addPerson(person);

        // then
        Assert.assertTrue(warehouse.contains(person));
    }

    @Test
    public void testGetIdToNameMap() {
        // when
        Map<Long, String> warehouseNameMap = warehouse.getIdToNameMap();
        Map<Long, String> localNameMap = new HashMap<>();
        for (Person person : warehouse) {
            long id = person.getPersonalId();
            String name = person.getName();
            localNameMap.put(id, name);
        }

        // then
        Iterator<Map.Entry<Long, String>> it = localNameMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, String> pair = it.next();
            long pairKey = pair.getKey();
            String pairValue = pair.getValue();
            String mapValue = warehouseNameMap.get(pairKey);

            Assert.assertTrue(mapValue.equals(pairValue));
        }
    }


    @Test
    public void testGetNames() {
        List<String> warehouseNames = warehouse.getNames();
        List<String> localNames = new ArrayList<>();
        for (Person person : warehouse) {
            localNames.add(person.getName());
        }

        Assert.assertEquals(localNames.toString(), warehouseNames.toString());
    }
}
