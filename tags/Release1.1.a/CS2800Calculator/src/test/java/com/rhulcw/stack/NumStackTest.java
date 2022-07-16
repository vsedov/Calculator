package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class NumStackTest Test: {@linkplain NumStack} class.
 *
 * @author Vivian Sedov
 */

class NumStackTest {
  NumStack currentNumStack = new NumStack();
  float firstFloat;
  float secondFloat;

  /**
   * Initial Test - creating and checking instance of
   * {@linkplain NumStack} related to {@linkplain Stack}.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  void setUp() throws Exception { // Test 1
    this.currentNumStack = new NumStack();
    this.firstFloat = (float) Math.random();
    this.secondFloat = (float) Math.random();
  }

  /**
   * numStack to push a float on to {@linkplain Stack}
   * using {@linkplain numStack#push(float)}.
   */
  @Test
  void numStackPushTest() { // Test 2
    // Push some random value into list
    float someFloat = (float) Math.random();
    currentNumStack.push(someFloat);

    assertEquals(1, currentNumStack.numberStack.size());
  }

  /**
   * get size of {@linkplain numStack}.
   */
  @Test
  void getNumStackSizeTest() { // Test 3
    currentNumStack.push(firstFloat);
    currentNumStack.push(secondFloat);

    assertEquals(2, currentNumStack.getSize());
  }

  /**
   * Check if {@linkplain NumStack#pop()} pops and returns an item.
   */
  @Test
  void numStackPopTest() throws BadType { // Test 4
    currentNumStack.push(firstFloat);
    currentNumStack.push(secondFloat);

    assertEquals(secondFloat, currentNumStack.pop(), "Float dont match");
  }

  /**
   *  Check if {@linkplain NumStack#pop()} pops and returns an item. <br>
   *  Ensure that if nothing is able to return an error shall be thrown.
   *
   */
  @Test
  void numStackPopTestEmpty() { // Test 5
    currentNumStack.push(firstFloat);
    assertEquals(firstFloat, currentNumStack.pop(), "Float dont match");
    // Formatter required to be turned off, due to autoformat error . 
    // @formatter:off
    assertThrows(
            EmptyStackException.class,
            () -> {
        currentNumStack.pop();
        currentNumStack.pop();
      }
    );
    // @formatter:on
  }

  /**
   * Check if the {@linkplain NumStack#numberStack} is empty.
   */
  @Test
  void isEmptyTest() { // Test 6
    currentNumStack.push(firstFloat);
    currentNumStack.push(secondFloat);

    currentNumStack.pop();
    currentNumStack.pop();

    assertTrue(currentNumStack.isEmpty());
  }

  /**
   * Tear down for each Test.
   *
   * @throws Exception the exception
   */
  @AfterEach
  void tearDown() throws Exception {}
}
