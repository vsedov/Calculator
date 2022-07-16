package com.rhulcw.stack;


/**
 * The Type Enum {@linkplain Type}.
 *
 * @author Vivian Sedov
 */

public enum Type {
  /**
   * Type Information.<br>
   * Number Float : {@linkplain #NUMBER}<br>
   */
  NUMBER,
  /**
   * Type Information.<br>
   * SYMBOL Symbol : {@linkplain #SYMBOL}<br>
   */
  SYMBOL,
  /**
   * Type Information.<br>
   * STRING String  : {@linkplain #STRING}<br>
   */
  STRING,
  /**
   * Type Information.<br>
   * INVALID Null : {@linkplain #INVALID}<br>
   */
  INVALID;

  /**
   * toString provided to return current instance.
   *
   * @return current Instance.
   */
  @Override
  public String toString() {
    return this.name();
  }
}