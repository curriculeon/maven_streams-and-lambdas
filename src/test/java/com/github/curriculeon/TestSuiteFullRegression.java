package com.github.curriculeon;

import com.github.curriculeon.anthropoid.TestSuiteAnthropoidRegression;
import com.github.curriculeon.conversions.TestSuiteConversionRegression;
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
