package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;

/**
 * Created by leon on 5/25/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestConverterArray implements TestConversionAgent {

    @Override
    public PersonConversionAgent<Person[]> getConversionAgent() {
        return new ArrayConverter(999);
    }
}