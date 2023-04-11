package com.codewave;

import java.math.BigDecimal;

import javax.sound.sampled.SourceDataLine;

import com.codewave.model.Coin;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
       // System.out.println("Hello World!");
       Coin coin = Coin.builder()//
       .marketCap(BigDecimal.valueOf(1000))
       .description("I'm Bitcoin")
       .build();

       Coin coin2 = Coin.builder().build();
       System.out.println(coin.toString());
       
    }
}
