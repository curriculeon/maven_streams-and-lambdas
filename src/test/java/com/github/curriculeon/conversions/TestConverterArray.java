package com.github.curriculeon.conversions;

import com.github.curriculeon.TestConstants;

/**
 * Created by leon on 5/25/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestConverterArray extends TestConversionAgent implements TestConstants {
    public TestConverterArray() {
        super(new ArrayConverter(collectionSize));
    }
}