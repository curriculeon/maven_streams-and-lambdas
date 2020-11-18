package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;

import java.util.List;

/**
 * Created by leon on 5/25/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestConverterList implements TestConversionAgent {

    @Override
    public PersonConversionAgent<List<Person>> getConversionAgent() {
        return new ListConverter(999);
    }
}