package com.rhulcw.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class stringEvalTest on {@linkplain StringEvalTest} class.
 *
 * @author Vivian Sedov
 */
class StringEvalTest {
  /** instaNCE OF StringEval. */
  static StringEval stringFix;

  /**
   * Sets the up before class.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  static void setUpBeforeClass() {
    stringFix = new StringEval();
  }

  /**
   * Evaluate mixed and spaced type of strings - this allows valid input for calc.
   * {@linkplain InFixCalculator} Input formatter.
   */
  @Test
  void stringEvaluation() { // Test 1
    String noWhiteSpaces = "(50+5+5+5+5)";
    String mixedWhiteSpaces = "( (59+59) * 5+5 ) *4";
    assertEquals("( ( 50 + 5 + 5 + 5 + 5 ) )", stringFix.inFixCheck(noWhiteSpaces));
    // @formatter:off
    assertEquals(
                "( ( ( 59 + 59 ) * 5 + 5 ) * 4 )",
                stringFix.inFixCheck(mixedWhiteSpaces)
    );
    //@formatter:on

  }

  /**
   * Multiple dig evaluation for a string.
   */
  @Test
  void multipleDigEvaluation() { // Test 2
    String noWhiteSpaces = "(5000000+5+5+5+5)";
    String mixedWhiteSpaces = "( (593+59) * 5+5 ) *4";
    // @formatter:off

    assertEquals(
            "( ( 5000000 + 5 + 5 + 5 + 5 ) )",
            stringFix.inFixCheck(noWhiteSpaces)
    );
    assertEquals(
              "( ( ( 593 + 59 ) * 5 + 5 ) * 4 )",
              stringFix.inFixCheck(mixedWhiteSpaces));
    // @formatter:on

  }

  /**
   * Last dig is multiple values.
   */
  @Test
  void lastmultipleDigEvaluation() { //test 3
    String noWhiteSpaces = "(5000000+5+5+5+5000000)";
    String mixedWhiteSpaces = "( (593+59) * 5+5 ) *400+200";
    // @formatter:off

    assertEquals(
            "( ( 5000000 + 5 + 5 + 5 + 5000000 ) )",
            stringFix.inFixCheck(noWhiteSpaces)
    );
    assertEquals(
              "( ( ( 593 + 59 ) * 5 + 5 ) * 400 + 200 )",
              stringFix.inFixCheck(mixedWhiteSpaces));
    // @formatter:on

  }

  /**
   * Test PostFix expressions {@linkplain StringEval#validPostFix(String)}.
   */
  @Test
  void postFixStringEval() { // test 4
    assertEquals("3 3 +", stringFix.postFixCheck("3 3+"));
    assertEquals("33 3 +", stringFix.postFixCheck("33 3+"));
    assertEquals("333333 3 +", stringFix.postFixCheck("333333 3+"));
    assertEquals("333333 30 +", stringFix.postFixCheck("333333 30+"));
    assertEquals("6 2 / 1 2 + *", stringFix.postFixCheck("6 2 / 1 2 +*"));
  }

  /**
   * Test PostFix expressions {@linkplain StringEval#validPostFix(String)}.
   * This will evaluate strings such as /12+* -> Which should return / 12 + *
   */
  @Test
  void postFixStringEvalNumberInfront() {
    assertEquals("62 / 12 + *", stringFix.postFixCheck("62/12+*"));
    assertEquals(
      "5.9 5.3 - 7.2 * 1.4 2 / +",
      stringFix.postFixCheck("5.9 5.3 - 7.2 * 1.4 2 / +")
    );
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {}
}
