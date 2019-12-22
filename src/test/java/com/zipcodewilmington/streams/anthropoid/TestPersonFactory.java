package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.TestConstants;
import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/24/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestPersonFactory implements TestConstants {
    private PersonWarehouse warehouse;
    private PersonFactory factory;

    @Before
    public void setup() {
        this.factory = new PersonFactory();
        this.warehouse = new PersonWarehouse();

        factory
                .createPersonList(9999)
                .forEach(warehouse::addPerson);
    }



    @Test
    public final void testCreateRandomPersonList() {
        // Given

        // When
        List<Person> personList = factory.createPersonList(collectionSize);

        // Then
        Assert.assertEquals(collectionSize, personList.size());
        personList.forEach(this::ensurePersonHasNonNullFields);
    }


    @Test
    public final void testCreateRandomPersonArray() {
        // Given

        // When
        Person[] personArray = factory.createPersonArray(collectionSize);

        // Then
        Assert.assertEquals(collectionSize, personArray.length);
        Arrays.asList(personArray).forEach(this::ensurePersonHasNonNullFields);
    }


    @Test
    public final void testCreateRandomPersonStream() {
        // Given

        // When
        List<Person> personStream = factory
                .createPersonStream(collectionSize)
                .collect(Collectors.toList()); // copying to list prevents IllegalStateException

        // Then
        Assert.assertEquals(collectionSize, personStream.size());
        personStream.forEach(this::ensurePersonHasNonNullFields);
    }


    private void ensurePersonHasNonNullFields(Person person) {
        String messageCheckKey = "Ensuring field is non-null";
        String messageCheckValue = "Ensuring field-value is non-null";

        HashMap<Field, String> fieldMap = ReflectionUtils.getFieldMap(person);
        for (Map.Entry<Field, String> entry : fieldMap.entrySet()) {
            Field key = entry.getKey();
            String value = entry.getValue();

            Assert.assertTrue(messageCheckKey, key != null);
            Assert.assertTrue(messageCheckValue, value != null);
        }
    }
}
