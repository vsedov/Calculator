package com.rhulcw.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This Class tests {@link Stack} Class.
 *
 * @author Vivian Sedov
 */
class StackTest {
  /**
   * The test stack.
   */
  private static Stack testStack;

  /**
   * Sets the up before class.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    System.out.println("Setup For Stack Test");
    testStack = new Stack();
  }

  /**
   * Test get entry {@linkplain Stack}.
   */
  @Test
  void testGetEntryStack() {
    Stack getTestStack = new Stack();

    // Double check that it is an instance of stack
    assertEquals(true, getTestStack instanceof Stack);
  }

  /**
   * Test push entry using {@linkplain Stack#push(Entry)}.
   */
  @Test
  void testPushEntry() {
    Stack pushTestStack = new Stack();

    // This can be any of the Entry types
    Entry testEntry = new Entry(10);

    pushTestStack.push(testEntry);

    assertEquals(pushTestStack.getEntries().get(0), testEntry);
  }

  /**
   * Test {@linkplain Entry#Entry(float)} entry on current stack.
   * Push using {@linkplain Stack#push(Entry)}
   */
  @Test
  void testNumberEntry() {
    Stack numberStackTest = new Stack();
    int entryNumber;

    // add numbers 0 through 20
    for (entryNumber = 0; entryNumber < 20; entryNumber++) {
      numberStackTest.push(new Entry(entryNumber));
    }

    List<Entry> stackList = numberStackTest.getEntries();

    for (Entry numberEntry : stackList) {
      assertEquals(Type.NUMBER, numberEntry.getType());
    }
  }

  /**
   * Test {@linkplain Entry#Entry(String)} entry on current stack.
   * Push using {@linkplain Stack#push(Entry)}
   *
   * @throws BadType : due to the getvalue
   */
  @Test
  void testStringEntry() throws BadType {
    String[] stringEntry = { "entry1", "entry2", "entry3", "entry4" };
    Stack stringStackTest = new Stack();
    for (int i = 0; i < stringEntry.length; i++) {
      stringStackTest.push(new Entry(stringEntry[i]));
    }

    List<Entry> stackList = stringStackTest.getEntries();

    for (Entry strEntry : stackList) {
      assertEquals(Type.STRING, strEntry.getType());
    }
  }

  /**
   * Test {@linkplain Entry#Entry(Symbol)} entry on current stack.
   * Push using {@linkplain Stack#push(Entry)}

   * @throws BadType : throws
   */
  @Test
  void testSymbolEntry() throws BadType {
    Entry[] symbolEntry = {
      new Entry(Symbol.LEFT_BRACKET),
      new Entry(Symbol.RIGHT_BRACKET),
      new Entry(Symbol.TIMES),
      new Entry(Symbol.DIVIDE),
      new Entry(Symbol.PLUS),
      new Entry(Symbol.MINUS),
      new Entry(Symbol.INVALID)
    };

    Stack symbolStackTest = new Stack();

    for (int i = 0; i < symbolEntry.length; i++) {
      symbolStackTest.push(symbolEntry[i]);
    }

    List<Entry> stackList = symbolStackTest.getEntries();

    for (Entry symEntry : stackList) {
      assertEquals(Type.SYMBOL, symEntry.getType());
    }
  }

  /**
   * tesAllEntry Add three values onto localStack.
   */
  @Test
  void testAllEntry() {
    Entry symbolOne = new Entry(Symbol.LEFT_BRACKET);
    Entry stringTwo = new Entry("SecondValue");
    Entry numberThree = new Entry(10);

    testStack.push(symbolOne);
    testStack.push(stringTwo);
    testStack.push(numberThree);
    
  }

  /**
   * Test size using {@linkplain Stack#size()}.
   */
  @Test
  void testSize() {
    int stackSize = 3;
    int currentStackSize = testStack.size();

    assertEquals(stackSize, currentStackSize);
  }

  /**
   * Test pop exception Catch EmptyStackExecption.
   */
  @Test
  void testPopExecption() {
    Stack newStack = new Stack();
    try {
      newStack.pop();
      // if the newStack is empty
      fail(" something wrong with pop ");
    } catch (EmptyStackException e) {
      e.getMessage();
    }
  }

  /**
   * Test {@linkplain Stack#pop()} with {@linkplain Stack#size()}.
   * Make sure that pop and size are intune with each other.
   */
  @Test
  void testPopEntryReturn() {
    Entry afterPop = testStack.pop();
    
    assertEquals(new Entry(10), afterPop);
    assertEquals(2, testStack.size());

    try {
      assertEquals(new Entry("SecondValue"), testStack.pop());
      assertEquals(1, testStack.size());

      assertEquals(new Entry(Symbol.LEFT_BRACKET), testStack.pop());
      assertEquals(0, testStack.size());
    } catch (EmptyStackException e) {
      assertEquals(null, e.getMessage());
    }
  }

  /**
   * Test {@linkplain Stack#top()} returning newest entry.
   *
   * @throws EmptyStackException the empty stack exception
   */
  @Test
  void testTop() throws EmptyStackException {
    Stack newTestStack = new Stack();

    Entry firstEntry = new Entry("FirstEntry");
    newTestStack.push(firstEntry);
    Entry firstEntryFromStack = newTestStack.top();

    assertEquals(firstEntry, firstEntryFromStack);

    Entry secondEntry = new Entry(Symbol.DIVIDE);
    newTestStack.push(secondEntry);
    Entry secondEntryFromStack = newTestStack.top();

    assertEquals(secondEntry, secondEntryFromStack);

    // Test Size
    assertEquals(2, newTestStack.size());
  }

  /**
   * Test top method {@linkplain Stack#Top()} Exception.
   *
   * @throws EmptyStackException the empty stack exception
   */
  @Test
  void testTopExecption() throws EmptyStackException {
    Stack emptyStack = new Stack();
    try {
      emptyStack.top();
      fail(" SomethingWrong with your top valu ");
    } catch (EmptyStackException execptionOfEmptyStack) {
      execptionOfEmptyStack.getMessage();
    }
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
    System.out.println("TearDown For Stack Test");
  }
}
