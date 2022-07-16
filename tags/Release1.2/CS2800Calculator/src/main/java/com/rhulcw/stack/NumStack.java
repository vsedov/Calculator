package com.rhulcw.stack;

import java.util.EmptyStackException;

/**
 * The Class {@linkplain NumStack}.
 * This Class Further uses the {@linkplain Stack} through inheritance of Stack Instance.
 *
 * @author Vivian Sedov
 */
public class NumStack {
  /** The num stack. */
  Stack numberStack = new Stack();

  /**
   * Push converts a float into a {@linkplain Entry#Entry(float)}<br>
   * Which is Pushed into {@linkplain NumStack#numberStack}.
   *
   * @param number the number
   */
  public void push(float number) {
    Entry newEntry = new Entry(number);
    numberStack.push(newEntry);
  }

  /**
   * Size of the current list.
   *
   * @return {@linkplain NumStack#numberStack}
   */
  public int getSize() {
    return numberStack.size();
  }

  /**
   * returns and removes top element from {@linkplain #numberStack} using
   * {@linkplain Stack#pop()} and to retrieve the value {@linkplain Entry#getValue()}.
   *
   * @return {@link Entry#getValue()}
   * @throws EmptyStackException : Stack is empty
   */
  public float pop() throws EmptyStackException {
    try {
      // Pop will return a Entry type - getValue() will return the value.
      return numberStack.pop().getValue();
    } catch (BadType e) {
      // If the entry is not a float - then we will get a BadType Exception.
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * return True if {@linkplain #numberStack} is empty.
   *
   * @return boolean value determining if empty stack.
   *
   */
  public Boolean isEmpty() {
    return this.getSize() == 0;
  }
}
