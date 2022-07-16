package com.rhulcw.stack;

import java.util.Objects;

/**
 * The Class {@linkplain Entry}.
 *
 * @author Vivian Sedov
 */

public class Entry {
  /**
   * Variables with the following types. <br>
   * str : {@linkplain String}<br>
   * number : {@linkplain Float}<br>
   * currentSymbol : {@linkplain Symbol}<br>
   * type : {@linkplain Type}<br>
   */
  private String str;
  private float number;
  private Symbol currentSymbol;
  private Type type;

  /**
   * Instantiates a new entry.
   * Stores float into {@linkplain #number} Stores Type of Symbol in {@linkplain #type}
   *
   * @param number : Define Type for Entry of Floating Number
   */
  public Entry(float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Instantiates a new entry. Stores Symbol into {@linkplain #currentSymbol}
   * Stores Type of Symbol in {@linkplain #type}
   *
   * @param whichSymbol : Define Type for Entry of Symbol
   */
  public Entry(Symbol whichSymbol) {
    this.currentSymbol = whichSymbol;
    this.type = Type.SYMBOL;
  }

  /**
   * Instantiates a new entry. Stores String into {@linkplain #str} Stores Type of
   * Symbol in {@linkplain #type}
   *
   * @param str : Define Type for Entry of String
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Gets the string.
   *
   * @return the string
   * @throws BadType if type is not String
   */
  public String getString() throws BadType {
    if (this.type != Type.STRING) {
      throw new BadType("String input is required");
    }
    return this.str;
  }

  /**
   * Gets the symbol.
   *
   * @return the symbol
   * @throws BadType the bad type
   */
  public Symbol getSymbol() throws BadType {
    if (this.type != Type.SYMBOL) {
      throw new BadType("Symbol input is required");
    }
    return this.currentSymbol;
  }

  /**
   * Gets Floating Value.
   *
   * @return the floating value
   * @throws BadType : if Type is not NUMBER
   */
  public float getValue() throws BadType {
    if (this.type != Type.NUMBER) {
      throw new BadType("Float input  is required");
    }
    return this.number;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Averted ToString method.
   *
   * @return instance type with String
   */
  @Override
  public String toString() {
    // Checks the current type - if it is Type - then returns a formated String

    if (this.getType().equals(Type.NUMBER)) {
      return String.valueOf(this.number);
    } else if (this.getType().equals(Type.SYMBOL)) {
      return this.currentSymbol.getSymbol();
    } else if (this.getType().equals(Type.STRING)) {
      return str;
    }

    return this.getType() + "This type was not found please try again";
  }

  /**
   * checks for the Same symbol.
   *
   * @param obj : Entry  Object
   * @return true, if successful
   */
  public boolean sameSymbol(Entry obj) {
    return this.currentSymbol.name().equals(obj.currentSymbol.name());
  }

  /**
   * Checks for the same string.
   *
   * @param obj : Entry Object
   * @return true, if successful
   */
  public boolean sameString(Entry obj) {
    return this.toString().equals(obj.toString());
  }

  /**
   * Checks for the same type.
   *
   * @param obj : Entry Object
   * @return true, if successful
   */
  public boolean sameType(Entry obj) {
    return this.type.equals(obj.type);
  }

  /**
   * Override HashCode.
   *
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.toString(), this.type);
  }

  /**
   * Overided Equals.
   *
   * @param obj of type Object
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;
    return (this.sameString(other) && this.sameType(other));
  }
}
