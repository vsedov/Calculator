package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class EntryTest Test: {@linkplain Entry} class.
 *
 * @author Vivian Sedov
 */
class EntryTest {
  /**
   * EntryTest Class Static Parameters.<br>
   * float_input  instance of {@linkplain Entry} for {@linkplain Type.NUMBER}<br>
   * symbol_input instance of {@linkplain Entry} for {@linkplain Type.SYMBOL}<br>
   * string_input instance of {@linkplain Entry} for {@linkplain Type.STRING}<br>
   */
  private static Entry float_input;
  private static Entry symbol_input;
  private static Entry string_input;

  /**
   * Sets the up before class.<br>
   * Takes in Constructor For each Entry Float, Symbol , String<br>
   * {@linkplain Entry} <br>
   * {@linkplain Float}<br>
   * {@linkplain SYMBOL}<br>
   * {@linkplain String}<br>
   *
   * @throws Exception on setup
   */
  @BeforeAll
  static void setUpBeforeClass() throws Exception { // Test
    System.out.println("Setup For Entry Test");
    float_input = new Entry(8);
    symbol_input = new Entry(Symbol.LEFT_BRACKET);
    string_input = new Entry("this_is_a_string");
  }

  /**
   * Gets the string test.
   * {@link Entry} Confirms Entry type for String is {@linkplain Entry#getString()}
   *
   * @throws BadType
   *
   * @returns true as values are the same
   */
  @Test
  void entrygetStringTest() throws BadType { // Test 1
    assertEquals("this_is_a_string", string_input.getString());
  }

  /**
   * Entry get symbol test.
   * {@link Entry} Confirms Entry type for Symbol is {@linkplain Entry#getSymbol()}
   *
   * @throws BadType Exception
   * @returns true as values are the same
   */
  @Test
  void entryGetSymbolTest() throws BadType { // Pass
    assertEquals(Symbol.LEFT_BRACKET, symbol_input.getSymbol());
  }

  /**
   * Entry get value test.
   * {@link Entry} Confirms Entry type for Number is {@linkplain Entry#getValue()}
   *
   * @throws BadType Exception
   * @returns true as values are the same
   */
  @Test
  void entryGetValueTest() throws BadType { // Pass
    assertEquals(8, float_input.getValue());
  }

  /**
   * Gets the string exception test.
   * Methods are called on wrong Types
   *
   * {@link Type#SYMBOL} with {@link Entry#getString()}
   * Catches Bad type error - Verified error message
   */
  @Test
  void getStringExceptionTest() {
    // @formatter:off
    BadType e = assertThrows(
            BadType.class,
            () -> {
        symbol_input.getString();
      }
    );
    // @formatter:on
    assertEquals("String input is required", e.getMessage());
  }

  /**
   * Gets the symbol exception test.
   * Methods are called on wrong Types
   *
   * {@link Type#NUMBER} with {@link Entry#getSymbol()}
   * Catches Bad type error - Verified error message
   */
  @Test
  void getSymbolExceptionTest() {
    // @formatter:off
    BadType e = assertThrows(
            BadType.class,
            () -> {
        float_input.getSymbol();
      }
    );
    // @formatter:on
    assertEquals("Symbol input is required", e.getMessage());
  }

  /**
   * Gets the value exception test.
   * Methods are called on wrong Types
   *
   * {@link Type#SYMBOL} with {@link Entry#getValue()}
   * Catches Bad type error - Verified error message
   */
  @Test
  void getValueExceptionTest() {
    // @formatter:off
    BadType e = assertThrows(
            BadType.class,
            () -> {
        symbol_input.getValue();
      }
    );
    // @formatter:on
    assertEquals("Float input  is required", e.getMessage());
  }

  /**
   * Verifies Type with Float input.
   *
   * {@link Type} with {@link Entry#getType()}
   *
   */
  @Test
  void entryTypeTest() {
    assertEquals(Type.NUMBER, float_input.getType());
    assertEquals(Type.SYMBOL, symbol_input.getType());
    assertEquals(Type.STRING, string_input.getType());
  }

  /**
   * Verifies Entry method {@link Entry#toString()}.
   *
   */
  @Test
  void toStringTest() {
    assertEquals("8.0", float_input.toString());
    assertEquals(Symbol.LEFT_BRACKET.getSymbol(), symbol_input.toString());
    assertEquals("this_is_a_string", string_input.toString());
  }

  /**
   * Equal helper.
   *
   * @param entry1 the entry 1 {@link Entry}
   * @param entry2 the entry 2 {@link Entry}
   * @return true, if entry_1 equals entry_2 is symmetric
   */
  boolean equalHelper(Entry entry1, Entry entry2) {
    return entry1.equals(entry2) && entry2.equals(entry1);
  }

  /**
   * Hash helper.
   *
   * @param entry1 the entry 1 {@link Entry}
   * @param entry2 the entry 2 {@link Entry}
   * @return true, if the hashes are the same .
   */
  boolean hashHelper(Entry entry1, Entry entry2) {
    return entry1.hashCode() == entry2.hashCode();
  }

  /**
   * Override hash test.
   * Check overwrite {@link Entry#equals(Object)} , {@link Entry#hashCode()} is valid
   * Test Strings and verify Hash and Equal both work.
   */
  @Test
  void overrideHashTest() {
    // Compare Symbol and Float values to make sure they are not equal .
    assertFalse(equalHelper(float_input, symbol_input));
    assertFalse(hashHelper(float_input, symbol_input));

    // Compare String and a symbol to see if they are the same .
    Entry[] symbolString = {
      new Entry("("),
      new Entry(")"),
      new Entry("*"),
      new Entry("/"),
      new Entry("+"),
      new Entry("-"),
      new Entry("")
    };
    Entry[] symbolEnumSymbol = {
      new Entry(Symbol.LEFT_BRACKET),
      new Entry(Symbol.RIGHT_BRACKET),
      new Entry(Symbol.TIMES),
      new Entry(Symbol.DIVIDE),
      new Entry(Symbol.PLUS),
      new Entry(Symbol.MINUS),
      new Entry(Symbol.INVALID)
    };

    // o(n²) Compare Each one just to be sure .
    for (Entry entry1 : symbolString) {
      for (Entry entry2 : symbolEnumSymbol) {
        assertFalse(equalHelper(entry1, entry2));
        assertFalse(hashHelper(entry1, entry2));
      }
    }
    // Ensuring that all values mentioned are the same - using Hashhelper , equalHelper, SameString

    // o(n)
    for (int i = 0; i < 6; i++) {
      assertTrue(symbolEnumSymbol[i].sameString(symbolString[i]));
    }
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
    System.out.println("Tear Down For Entry Test");
  }
}
