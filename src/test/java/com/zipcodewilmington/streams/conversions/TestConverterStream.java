package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.TestConstants;

/**
 * Created by leon on 5/25/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestConverterStream extends TestConversionAgent implements TestConstants {
    public TestConverterStream() {
        super(new StreamConverter(collectionSize));
    }
}