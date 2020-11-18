package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;

import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestConverterStream implements TestConversionAgent {

    @Override
    public PersonConversionAgent<Stream<Person>> getConversionAgent() {
        return new StreamConverter(999);
    }
}