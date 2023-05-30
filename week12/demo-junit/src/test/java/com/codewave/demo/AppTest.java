package com.codewave.demo;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions; 

import static org.junit.jupiter.api.Assertions.assertEquals; // static import method

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        Assertions.assertEquals(1, 1); // static method
        int expectedValue = 1;
        int actualValue = 1;
        assertEquals(expectedValue, actualValue); // after static import
    }


}
