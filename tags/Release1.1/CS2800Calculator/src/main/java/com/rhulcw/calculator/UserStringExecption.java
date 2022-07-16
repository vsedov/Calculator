package com.rhulcw.calculator;

/**
 * Class {@linkplain UserStringExecption}, this is thrown when you have an empty stack.
 * Or when there is an issue with the string it self.
 *
 * @author Vivian Sedov
 */

//Ref: https://www.geeksforgeeks.org/serialversionuid-in-java/

public class UserStringExecption extends Exception {
  /**
   * SerialVersionUID is used to ensure that during deserialization the same class
   * (that was used during serialize process) is loaded.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Allow message from Exception.
   *
   * @param value which is the information of the Exception type.
   */
  public UserStringExecption(String value) {
    super(value);
  }
}
