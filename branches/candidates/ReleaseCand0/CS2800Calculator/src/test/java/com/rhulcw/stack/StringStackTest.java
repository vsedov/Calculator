package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class StringStackTest Test: {@linkplain StrStack} class.
 *
 * @author Vivian Sedov
 */
class StringStackTest {
  private StrStack testStack = new StrStack();

  /**
   * Setup for each Test.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  void setUp() throws Exception { // Initial Test
    this.testStack = new StrStack();
  }

  /**
   * Push a testString using {@linkplain StrStack#push(String)} to add to the stack.
   */
  @Test
  void strStackPushFunction() { // Test 2
    String testString = "foo_world";
    this.testStack.push(testString);
  }

  /**
   * Test {@linkplain StrStack#push(String)} and check size using
   * {@linkplain StrStack#getSize()}.
   */
  @Test
  void strStackPushGetSize() { // Test 3
    String testString = "foo_world";
    this.testStack.push(testString);

    assertEquals(1, this.testStack.getSize());
  }

  /**
   * Simple Test for {@linkplain StrStack#isEmpty()}.
   */
  @Test
  void simpleIsEmptyTest() { // Test 4
    assertTrue(this.testStack.isEmpty());
  }

  /*
   * Test {@linkplain StrStack#pop()} ensuring return of the poped value from the stack.
   */
  @Test
  void strStackPopTest() { // Test 5
    String string1 = "4+5";
    String string2 = "5+4";

    this.testStack.push(string1);
    this.testStack.push(string2);

    assertEquals(string2, this.testStack.pop());
  }

  /**
   *  Check if {@linkplain StrStack#pop()} pops and returns an item. <br>
   *  Ensure that if nothing is able to return an error shall be thrown.
   *
   */
  @Test
  void numStackPopTestEmptyStackException() { // Test 6
    this.testStack.push("Test");
    this.testStack.push("Test2");

    // Formatter required to be turned off, due to autoformat error . 
    // @formatter:off
    assertThrows(
            EmptyStackException.class,
            () -> {
            testStack.pop();
            testStack.pop();
            testStack.pop();

      }
    );
    // @formatter:on
  }

  /**
   * Function to Test the following functions<br>
   * {@linkplain StrStack#push(String)}<br>
   * {@linkplain StrStack#pop()}<br>
   * {@linkplain StrStack#isEmpty()}<br>
   * Test to make sure that all functions work in unison.
   */
  @Test
  void testAllFunctions() {
    String testString = "String";
    String testString2 = "String";

    this.testStack.push(testString);
    this.testStack.push(testString2);

    assertEquals(2, this.testStack.getSize());
    try {
      // @formatter:off
      assertThrows(
              EmptyStackException.class,
              () -> {
          testStack.pop();
          testStack.pop();
          testStack.pop();
        }
      );

      // @formatter:on

      assertEquals(0, testStack.getSize());

      assertTrue(this.testStack.isEmpty());
    } catch (EmptyStackException e) {
      e.printStackTrace();
      fail("Somethign wrong with the code");
    }
  }

  /**
   * Tear down for each Test.
   *
   * @throws Exception the exception
   */
  @AfterEach
  void tearDown() throws Exception {}
}
