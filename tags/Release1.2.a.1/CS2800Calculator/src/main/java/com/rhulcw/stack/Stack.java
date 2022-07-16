package com.rhulcw.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The Class {@linkplain Stack}.
 *
 * @author Vivian Sedov
 */

public class Stack {
  /**
   * The size of the stack.
   */
  private int stackSize = 0;

  /**
   * Holds {@linkplain Entry} Instances in ArrayList.
   */
  private List<Entry> entries = new ArrayList<>();

  /**
   *  Gets ArrayList of current {@linkplain Stack#entries}.
   *
   *  @return {@linkplain Stack#entries}
   */
  public List<Entry> getEntries() {
    return entries;
  }

  /**
   * Push Function.
   * {@linkplain Entry} for Instances to {@linkplain Stack#entries}
   *
   * @param entry instance of {@linkplain Entry}
   */
  public void push(Entry entry) {
    this.entries.add(entry);
    this.stackSize++;
  }

  /**
   * Return Top entry of the stack.
   *
   * @return the {@linkplain Entry}
   * @throws EmptyStackException the empty stack exception
   */
  public Entry top() throws EmptyStackException {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }
    return this.entries.get(this.stackSize - 1);
  }

  /**
   * Pop Top of List on  {@linkplain Stack#entries}.
   *
   * @return new entry on top
   * @throws EmptyStackException the empty stack exception
   */
  public Entry pop() throws EmptyStackException {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }

    Entry tmp = top();
    this.entries.remove(--stackSize);
    return tmp;
  }

  /**
   * Prints all elements within  {@linkplain Stack#entries}.
   *
   */
  public void printStack() {
    for (Entry itemEntry : this.entries) {
      System.out.println(itemEntry.toString());
    }
  }

  /**
   * Size of the current list.
   *
   * @return {@linkplain Stack#stackSize}
   */
  public int size() {
    return this.stackSize;
  }

  /**
   * Checks if list is empty.
   *
   * @return boolean if size is zero.
   */
  private boolean isEmpty() {
    return this.stackSize == 0;
  }
}
