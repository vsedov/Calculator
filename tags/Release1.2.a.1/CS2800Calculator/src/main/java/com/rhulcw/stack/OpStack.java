package com.rhulcw.stack;

import java.util.EmptyStackException;

/**
 * Stack for  {@linkplain Entry#Entry(Symbol)}<br>
 * Which is Pushed into {@linkplain OpStack#operatorStack}.
 *
 * @author Vivian Sedov
 *
 */
public class OpStack {
  /**
   * Instance of {@link Stack}.
   */
  private Stack operatorStack = new Stack();

  /**
   * Push Symbol type to {@linkplain Entry#Entry(Symbol)}<br>
   * Which is Pushed into {@linkplain OpStack#operatorStack}.
   *
   * @param symbol being added to the stack
   */
  public void push(Symbol symbol) {
    Entry symbolEntry = new Entry(symbol);
    getOperatorStack().push(symbolEntry);
  }

  /**
   * returns and removes top element from {@linkplain #operatorStack} using
   * {@linkplain Stack#pop()} and to retrieve the value {@linkplain Entry#getSymbol()}.
   *
   * @return {@link Entry#getSymbol()}
   * @throws EmptyStackException : Stack is empty
   */
  public Symbol pop() throws EmptyStackException {
    try {
      // Casting allows the return type allows direct access to functions within symbol.
      return getOperatorStack().pop().getSymbol();
    } catch (BadType e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Size of the current list.
   *
   * @return {@linkplain OpStack#operatorStack} size
   */
  public int getSize() {
    return this.getOperatorStack().size();
  }

  /**
   * Return if is empty.
   *
   * @returns true if {@link #operatorStack} is empty.
   */
  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  /**
   * Return current stack.
   *
   * @returns current stack {@linkplain OpStack#operatorStack}
   */
  public Stack getOperatorStack() {
    return operatorStack;
  }
}
