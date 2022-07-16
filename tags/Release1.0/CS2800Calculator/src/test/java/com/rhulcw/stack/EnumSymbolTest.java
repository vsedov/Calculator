package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class EnumSymbolTest Test: {@linkplain Symbol} class.
 *
 * @author Vivian Sedov
 */

class EnumSymbolTest {
  private static Symbol symbolLBracket;
  private static Symbol symbolRBracket;
  private static Symbol symbolTimes;
  private static Symbol symbolDivide;
  private static Symbol symbolPlus;
  private static Symbol symbolMinus;
  private static Symbol symbolInvalid;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    System.out.println("Setting up Symbol Test ");

    // Initialise Every Symbol type
    symbolLBracket = Symbol.LEFT_BRACKET;
    symbolRBracket = Symbol.RIGHT_BRACKET;
    symbolTimes = Symbol.TIMES;
    symbolDivide = Symbol.DIVIDE;
    symbolPlus = Symbol.PLUS;
    symbolMinus = Symbol.MINUS;
    symbolInvalid = Symbol.INVALID;
  }

  /**
   * Test Symbol Through Method {@linkplain Symbol.getSymbol}.
   */
  @Test
  void getSymbolsTest() { // Test_1
    // Match symbols to make sure that the symbols are correct when - calling getSymbol
    assertSame("(", symbolLBracket.getSymbol());
    assertSame(")", symbolRBracket.getSymbol());
    assertSame("*", symbolTimes.getSymbol());
    assertSame("/", symbolDivide.getSymbol());
    assertSame("+", symbolPlus.getSymbol());
    assertSame("-", symbolMinus.getSymbol());
    assertSame("", symbolInvalid.getSymbol());
  }

  /**
   * Test Priority Through Method {@linkplain Symbol.getPriority}.
   */
  @Test
  void getPriorityTest() { // Test_2
    // Test to match the symbolName - with priorities - ensuring that it is correct
    assertSame(5, symbolLBracket.getPriority());
    assertSame(5, symbolRBracket.getPriority());
    assertSame(3, symbolTimes.getPriority());
    assertSame(3, symbolDivide.getPriority());
    assertSame(2, symbolPlus.getPriority());
    // Symbol Plus and Minus can be the same
    assertSame(2, symbolMinus.getPriority());
    assertSame(1, symbolInvalid.getPriority());
  }

  /**
   * Return Symbol from string using {@linkplain Symbol#symbolMap}
   * on {@linkplain Symbol#convertToSymbol(String)}.
   */
  @Test
  void stringToSymbolTest() { // Test 3
    // ensuring that each valid String returns a Symbol Type

    assertSame(symbolLBracket, Symbol.convertToSymbol("("));
    assertSame(symbolRBracket, Symbol.convertToSymbol(")"));
    assertSame(symbolTimes, Symbol.convertToSymbol("*"));
    assertSame(symbolDivide, Symbol.convertToSymbol("/"));
    assertSame(symbolPlus, Symbol.convertToSymbol("+"));
    assertSame(symbolMinus, Symbol.convertToSymbol("-"));
    assertSame(symbolInvalid, Symbol.convertToSymbol(""));
  }

  /**
   * Expect null from unknown string using {@linkplain Symbol#symbolMap}
   * on {@linkplain Symbol#convertToSymbol(String)}.
   */
  @Test
  void unkownStringOnConvertSymbol() { // Continuation of Test 4
    assertSame(null, Symbol.convertToSymbol("Foo"));
  }

  /**
   * toSting overwrite test. {@linkplain Symbol.toString}.
   */
  @Test
  void toStringTest() { // Test 5
    assertEquals("Current symbol is ( With a priority of 5", symbolLBracket.toString());
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
    System.out.println("Tearing Down Symbol Test");
  }
}
