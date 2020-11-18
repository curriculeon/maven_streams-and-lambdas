package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public interface TestConversionAgent<T extends PersonConversionAgent<Person>> {
    T getConversionAgent();

    default List<Person> getPersonList() {
        return getConversionAgent().toList();
    }

    default Person[] getPersonArray() {
        return getConversionAgent().toArray();
    }

    default Stream<Person> getPersonStream() {
        return getConversionAgent().toStream();
    }


    @Test
    default void testCount() {
        int listSize = getPersonList().size();
        int arrayLength = getPersonArray().length;
        int streamCount = (int) getPersonStream().count();

        Assert.assertEquals(listSize, arrayLength);
        Assert.assertEquals(listSize, streamCount);
    }

    @Test
    default void testToList() {
        List<Person> list = getPersonList();
        Person[] array = getPersonArray();
        for (int i = 0; i < list.size(); i++) {
            long listId = list.get(i).getPersonalId();
            long arrayId = array[i].getPersonalId();

            Assert.assertEquals(listId, arrayId);
        }
    }


    @Test
    default void testToStream() {
        List<Person> people = getPersonStream().collect(Collectors.toList());
        Person[] array = getPersonArray();

        for (int i = 0; i < people.size(); i++) {
            long arrayId = array[i].getPersonalId();
            long streamId = people.get(i).getPersonalId();

            Assert.assertEquals(streamId, arrayId);
        }
    }

    @Test
    default void testToArray() {
        Person[] array = getPersonArray();
        List<Person> list = getPersonList();

        for (int i = 0; i < array.length; i++) {
            long arrayId = array[i].getPersonalId();
            long listId = list.get(i).getPersonalId();

            Assert.assertEquals(listId, arrayId);
        }
    }
}
