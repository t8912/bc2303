package com.codewave;

import org.junit.jupiter.api.Test;

import com.codewave.model.Coin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1); //left -> expected result; right -> actual result
    }

    @Test
    void testCoin() {
        Coin coin1 = new Coin(BigDecimal.valueOf(1000), "Bitcoin", "@x1234");
        Coin coin2 = new Coin(BigDecimal.valueOf(1000), "Bitcoin", "@x2345");
        //assertEquals(coin1.equals(coin2), true); // callsuper=false
        assertEquals(coin1.equals(coin2), false); // callsuper=true

        System.out.println(coin1.toString());
    }
}
