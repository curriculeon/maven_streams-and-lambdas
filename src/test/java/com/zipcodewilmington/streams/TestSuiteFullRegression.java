package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.TestPersonFactory;
import com.zipcodewilmington.streams.anthropoid.TestSuiteAnthropoidRegression;
import com.zipcodewilmington.streams.conversions.TestSuiteConversionRegression;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestStreamFilter.class,
        TestSuiteAnthropoidRegression.class,
        TestSuiteConversionRegression.class
})

/**
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class TestSuiteFullRegression {
}
