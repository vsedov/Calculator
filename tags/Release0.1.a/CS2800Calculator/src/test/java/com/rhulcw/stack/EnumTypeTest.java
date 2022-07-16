package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class EnumTypeTest Test: {@linkplain Type} class.
 *
 * @author Vivian Sedov
 */

class EnumTypeTest {

  /**
   * Sets the up before class.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    System.out.println("Setting up Type Test ");
  }

  /**
   * TypeEnum Test {@linkplain Type}.
   * Tests Instances
   */
  @Test
  void createEnumTest() { // Test_1
    final Type typeCreationInvalid = Type.INVALID;
    final Type typeCreationNumber = Type.NUMBER;
    final Type typeCreationSymbol = Type.SYMBOL;
    final Type typeCreationStrings = Type.STRING;

    assertEquals("INVALID", typeCreationInvalid.toString());
    assertEquals("NUMBER", typeCreationNumber.toString());
    assertEquals("SYMBOL", typeCreationSymbol.toString());
    assertEquals("STRING", typeCreationStrings.toString());
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
    System.out.println("Tearing down Type Test");
  }
}
