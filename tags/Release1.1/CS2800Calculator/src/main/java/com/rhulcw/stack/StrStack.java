package com.rhulcw.stack;

import java.util.EmptyStackException;

/**
 * Stack for  {@linkplain Entry#Entry(String)}<br>
 * Which is Pushed into {@linkplain StrStack#stringStack}.
 *
 * @author Vivian Sedov
 *
 */
public class StrStack {
  /**
   * Instance of {@link Stack}.
   */
  private Stack stringStack = new Stack();

  /**
   * Push converts a String into a {@linkplain Entry#Entry(String)}<br>
   * Which is Pushed into {@linkplain NumStack#numberStack}.
   *
   * @param string being added to the stack
   */
  public void push(String string) {
    Entry stringEntry = new Entry(string);
    stringStack.push(stringEntry);
  }

  /**
   * returns and removes top element from {@linkplain #stringStack} using
   * {@linkplain Stack#pop()} and to retrieve the value {@linkplain Entry#getString()}.
   *
   * @return {@link Entry#getString()}
   * @throws EmptyStackException : Stack is empty
   */
  public String pop() throws EmptyStackException {
    try {
      return stringStack.pop().getString();
    } catch (BadType e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Size of the current list.
   *
   * @return {@linkplain StrStack#stringStack}
   */
  public int getSize() {
    return stringStack.size();
  }

  /**
   * Returns the current Stack.
   *
   * @return {@linkplain StrStack#stringStack}
   */
  public Stack getStack() {
    return this.stringStack;
  }

  /**
   * return True if {@linkplain #stringStack} is empty.
   *
   * @return boolean value determining if empty stack.
   *
   */
  public Boolean isEmpty() {
    return this.getSize() == 0;
  }
}
