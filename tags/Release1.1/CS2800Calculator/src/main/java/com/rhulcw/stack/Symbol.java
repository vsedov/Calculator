package com.rhulcw.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * The Symbol Enum {@linkplain Symbol}.
 *
 * @author Vivian Sedov
 */

public enum Symbol {
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * Left Bracket "(" : Priority(5) : {@linkplain #LEFT_BRACKET}<br>
   */
  LEFT_BRACKET("(", 5),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * Right Bracket ")" : Priority(5) : {@linkplain #RIGHT_BRACKET}<br>
   */
  RIGHT_BRACKET(")", 5),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * TIMES "*" : Priority(3) : {@linkplain #TIMES}<br>
   */
  TIMES("*", 3),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * DIVIDE "/" : Priority(3) : {@linkplain #DIVIDE}<br>
   */
  DIVIDE("/", 3),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * PLUS "+" : Priority(2) : {@linkplain #PLUS}<br>
   */
  PLUS("+", 2),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * MINUS "-" : Priority(2) : {@linkplain #MINUS}<br>
   */
  MINUS("-", 2),
  /**
   * Enumeration Type with {@linkplain #priority}.<br>
   * INVALID "" : Priority(5) : {@linkplain #INVALID}<br>
   */
  INVALID("", 1);

  /**
   * Priority Value to identify precedence. defined from {@linkplain #Symbol}.
   */
  private final int priority;

  /**
   * Current Symbol defined from {@linkplain #Symbol}.
   */
  private final String currentSymbol;

  /**
   * Have a symbolMaP Between {@linkplain String} and {@linkplain Symbol}.
   */
  private static final Map<String, Symbol> symbolMap = new HashMap<>();

  // static add all values within the symbolMap
  static {
    getSymbolmap().put("(", Symbol.LEFT_BRACKET);
    getSymbolmap().put(")", Symbol.RIGHT_BRACKET);
    getSymbolmap().put("*", Symbol.TIMES);
    getSymbolmap().put("/", Symbol.DIVIDE);
    getSymbolmap().put("+", Symbol.PLUS);
    getSymbolmap().put("-", Symbol.MINUS);
    getSymbolmap().put("", Symbol.INVALID);
  }

  /**
   * Instantiates a new symbol.
   *
   * @param currentSymbol :
   * @param priority Number :
   */
  Symbol(String currentSymbol, int priority) {
    this.priority = priority;
    this.currentSymbol = currentSymbol;
  }

  /**
   * GetSymbol Current Symbol .
   *
   * @return {@linkplain #currentSymbol}
   */
  public String getSymbol() {
    return this.currentSymbol;
  }

  /**
   * Gets the priority.
   *
   * @return {@linkplain #priority}
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Converts any given string into a {@linkplain Symbol} Type.
   *
   * @return {@linkplain Symbol}
   */
  public static Symbol convertToSymbol(String toConvert) {
    if (getSymbolmap().containsKey(toConvert)) {
      return getSymbolmap().get(toConvert);
    }
    return null;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    // @formatter:off
    return (
      "Current symbol is " + this.getSymbol() + " With a priority of " + this.priority
      );
    // @formatter:on

  }

  /**
   * Gets the {@linkplain Symbol#symbolMap}.
   *
   * @return the symbolmap
   */
  public static Map<String, Symbol> getSymbolmap() {
    return symbolMap;
  }
}
