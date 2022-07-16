package com.rhulcw.stack;

/**
 * Class BadType.
 *
 * @author Vivian Sedov
 */
public class BadType extends Exception {
  /**
   * serialVersionUid initiated for exception type.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new bad type.
   *
   * @param message the message
   */
  public BadType(String message) {
    super(message);
  }
}
