package com.codewave.demo;

import org.junit.jupiter.api.Test;

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

        int expectedValue = 1;
        int actualValue = 1;
        assertEquals(expectedValue, actualValue);
        
        //assertEquals(1, 1); // after static method

        
    }
}
