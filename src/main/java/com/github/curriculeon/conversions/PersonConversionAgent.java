package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;

/**
 * Created by leon on 5/31/17.
 * The purpose of this class is to convert between different types of Person Collections
 * @param <ObjectSequentDataType> some sequence of Person objects
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
abstract public class PersonConversionAgent<ObjectSequentDataType> extends ConversionAgent<ObjectSequentDataType, Person> {
    public PersonConversionAgent(ObjectSequentDataType personObjectSequence) {
        super(personObjectSequence);
    }
}
