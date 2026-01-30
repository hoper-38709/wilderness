package com.wilderness.examples;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions.assertEquals;


// JUNIT 5 Test
public class CalculatorTest {


    @Test
    void lambdaAddition() {
        Calculator additionCalculator = (a, b) -> a + b;
        int resultAddition = additionCalculator.calculate(5, 3);
        assertThat(additionCalculator.calculate(5, 3),is(8));

        String amIFinie ="fine";
        assertEquals("fine",amIFinie);
    }

}
