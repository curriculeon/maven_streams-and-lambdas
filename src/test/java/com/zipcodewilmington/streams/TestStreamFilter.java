package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.tools.StringUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 5/2/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestStreamFilter {
    private StreamFilter streamFilter;

    @Before
    public void setup() {
        streamFilter = new StreamFilter();
    }

    @Test
    public void testToListMultiLine() {
        testFilter(streamFilter.toListMultiLine());
    }

    @Test
    public void testToListOneLine() {
        testFilter(streamFilter.toListOneLine());
    }

    @Test
    public void testToArrayMultiLine() {
        testFilter(streamFilter.toArrayMultiLine());
    }

    @Test
    public void testToArrayOneLine() {
        testFilter(streamFilter.toArrayOneLine());
    }


    private void testFilter(Person[] persons) {
        testFilter(Arrays.asList(persons));
    }

    private void testFilter(List<Person> persons) {
        for (Person p : persons) {
            assert (StringUtils.isPalindromeIgnoreCase(p.getName()));
        }
    }
}
