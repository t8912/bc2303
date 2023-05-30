package com.codewave.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LeetCodeTest {

  static LeetCode lc = null;

  @BeforeAll // before all test cases, execute one time
  static void before() {
    lc = new LeetCodeHolder();
  }

  @Test
  void testSum() {
    assertEquals(3, lc.sum(1, 2));
    assertEquals(-3, lc.sum(0, -3));
    assertEquals(0, lc.sum(0, 0));
    assertEquals(3, lc.sum(-1, 4));
  }

  @Test
  void testMax() {
    assertEquals(7, lc.max(new int[] { 1, 3, 7 }));
    assertEquals(-1, lc.max(new int[] { -1, -3, -9 }));
    assertEquals(0, lc.max(new int[] { 0 }));
    assertThrows(IllegalArgumentException.class, () -> lc.max(new int[] {}));
    assertDoesNotThrow(() -> lc.max(new int[] { 1, 2 }));
  }

  @Test
  void testFindCapitalLetter() {
    assertEquals("BD", lc.findCapitalLetter("aBcD")); // false
    assertEquals("R", lc.findCapitalLetter("R"));
    assertEquals("", lc.findCapitalLetter("i")); // "" or null
    assertEquals("", lc.findCapitalLetter(""));
    assertThrows(IllegalArgumentException.class, () -> lc.findCapitalLetter(null));
    assertDoesNotThrow(() -> lc.findCapitalLetter(""));
  }

}
