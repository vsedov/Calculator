package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class OpStackTest Test: {@linkplain opStack} class.
 *
 * @author Vivian Sedov
 */
class OpStackTest {
  /**
   * The test stack.
   */
  private OpStack testStack = new OpStack();

  /**
   * Setup for each Test.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  void setUp() throws Exception { // Initial Test
    this.testStack = new OpStack();
  }

  /**
   * Push a testSymbol using {@linkplain OpStack#push(Symbol)} to add to the stack.
   */
  @Test
  void opStackPushFunction() { // Test 2
    Symbol testSymbol = Symbol.PLUS;
    this.testStack.push(testSymbol);
    
  }

  /**
   * Test {@linkplain OpStack#push(Symbol)} and check size using
   * {@linkplain OpStack#getSize()}.
   */
  @Test
  void opStackPushGetSize() { // Test 3
    Symbol testSymbol = Symbol.PLUS;
    this.testStack.push(testSymbol);

    assertEquals(1, this.testStack.getSize());
    assertEquals(testSymbol, this.testStack.pop());
  }

  /**
   * Test {@linkplain OpStack#pop()} Due to the different methods that
   * {@linkplain Symbol} has, ensuring entities are the same.
   */
  @Test
  void opGetSymbolTest() { // Test 4
    Symbol testSymbol = Symbol.PLUS;
    // I wanted to ensure that Symbol still works .
    Symbol temp = Symbol.convertToSymbol("+");
    this.testStack.push(testSymbol);

    assertEquals(temp.getSymbol(), this.testStack.pop().getSymbol());

    this.testStack.push(temp);
    assertEquals(temp.getPriority(), this.testStack.pop().getPriority());
  }

  /**
   *  Check if {@linkplain opStack#pop()} pops and returns an Symbol. <br>
   *  Ensure that if nothing is able to return an error shall be thrown.
   *
   */
  @Test
  void opStackPopTestEmptyStackException() { // Test 5
    Symbol testSymbol1 = Symbol.PLUS;
    Symbol testSymbol2 = Symbol.MINUS;

    this.testStack.push(testSymbol1);
    this.testStack.push(testSymbol2);

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
   * Simple Test for {@linkplain opStack#isEmpty()}.
   */
  @Test
  void isEmptyTest() { // Test 4
    Symbol testSymbol1 = Symbol.PLUS;
    Symbol testSymbol2 = Symbol.MINUS;
    Symbol testSymbol3 = Symbol.INVALID;

    this.testStack.push(testSymbol3);
    this.testStack.push(testSymbol2);
    this.testStack.push(testSymbol1);

    this.testStack.pop();
    this.testStack.pop();

    assertFalse(this.testStack.isEmpty());

    this.testStack.pop();

    assertTrue(this.testStack.isEmpty());
  }

  /**
   * Tear down for each Test.
   *
   * @throws Exception the exception
   */
  @AfterEach
  void tearDown() throws Exception {}
}
