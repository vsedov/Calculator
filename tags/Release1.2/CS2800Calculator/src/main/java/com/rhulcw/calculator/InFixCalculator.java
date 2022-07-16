package com.rhulcw.calculator;

import com.rhulcw.stack.BadType;
import com.rhulcw.stack.Entry;
import com.rhulcw.stack.OpStack;
import com.rhulcw.stack.Symbol;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Scanner;

/**
 * Class {@linkplain InFixCalculator} Evaluates Expressions of the following type.#
 * Standard (infix) Notation:- ( 5 âˆ—( 6 + 7 ) ) âˆ’ 2 evaluates as 63.0
 *
 * @author Vivian Sedov
 */
public class InFixCalculator implements CalculatorInterface {
  /*
   * Ref :
   *      1. https://www.javatpoint.com/shunting-yard-algorithm-in-java
   *      2. https://slaystudy.com/infix-to-postfix/
   */

  /**
   * The Constant postFixConv Refers to {@linkplain PostFixCaculator}.
   */
  private static final PostFixCaculator postFixConv = new PostFixCaculator();

  /**
   * The Constant symbolMap, Refers to {@linkplain Symbol#symbolMap}.
   */
  private static final Map<String, Symbol> symbolMap = Symbol.getSymbolmap();

  // these expressions are not required . - statically remove them .
  static {
    symbolMap.remove("(");
    symbolMap.remove(")");
    symbolMap.remove("");
  }

  /**
   * Ensure Symbol is the same by checking Symbol type.
   * Using {@linkplain Entry#sameSymbol(Entry)} we can check if the type is the same.
   *
   * @param currentString type
   * @return true, if successful
   */
  public static boolean isSymbolType(String currentString) {
    // Have to convert this into  symbol

    return symbolMap.containsKey(currentString);
  }

  /**
   * Checks if is integer.
   *
   * @param currentString the current string
   * @return true, if is integer
   */
  public static boolean isInteger(String currentString) {
    try {
      Integer.parseInt(currentString);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    // only got here if we didn't return false
    return true;
  }

  /**
   * returns the current priority of the string.
   *
   * @param ssymbolString should be a string variant of a symbol type
   * @return the priority of the current symbol calling {@linkplain Symbol#getPriority()}
   */
  private static int priority(String symbolString) {
    return symbolMap.get(symbolString).getPriority();
  }

  /**
   * Gets the top symbol from the stack.<br>
   * Calls the following functions : <br>
   * {@linkplain OpStack#getOperatorStack()} returns the operatorStack.<br>
   * {@linkplain Stack#top()} returns the top value.<br>
   * {@linkplain Entry#getSymbol()} returns a Symbol.
   *
   * @param operatorStack the operator stack
   * @return the symbol from stack
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type
   */
  public static Symbol getTopSymbolFromStack(OpStack operatorStack)
          throws EmptyStackException, BadType {
    return operatorStack.getOperatorStack().top().getSymbol();
  }

  /**
   * evaluate formated String as currentString.
   *
   * @param currentString String to be evaluated
   * @return calls {@linkplain PostFixCaculator#evaluate(String)} on stringbuffer.
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type
   * @throws UserStringExecption the user string execption
   */
  // @formatter:off
  public static float evaluate(String currentString)
          throws EmptyStackException, BadType, UserStringExecption {
    // Create post Fix string using string builder
    StringBuilder postFixString = new StringBuilder();

    try (Scanner evalScan = new Scanner(currentString)) {
      OpStack operatorStack = new OpStack();

      while (evalScan.hasNext()) {
        String currentValue = evalScan.next();
        if (currentValue.equals(".")) {
          postFixString.append(".").append("");
          continue;
        }
        
        if (currentValue.equals(Symbol.LEFT_BRACKET.getSymbol())) {
          operatorStack.push(Symbol.LEFT_BRACKET);
          
        } else if (isInteger(currentValue)) {
          postFixString.append(currentValue).append(" ");
          
        } else if (currentValue.equals(Symbol.RIGHT_BRACKET.getSymbol())) {
          // ----------------------------------------------------------------
          // get the top value from the stack, and check if the top() is not a left bracket.
          while (getTopSymbolFromStack(operatorStack) != Symbol.LEFT_BRACKET) {
            postFixString.append(operatorStack.pop().getSymbol()).append(" ");
            // Refer to reference 2 - this method was taken from that.
            // Pop the initial value get the symbol and append that with the white space
            //onto the postFix String . 
          }
          operatorStack.pop();
          // ----------------------------------------------------------------
        } else if (isSymbolType(currentValue)) {
          // ----------------------------------------------------------------
          while (
            isSymbolType(getTopSymbolFromStack(operatorStack).getSymbol())
            &&
            priority(getTopSymbolFromStack(operatorStack).getSymbol()) 
                >=
            priority(currentValue)
          ) {
            // While the top value is a symbol - and the priorities are >= current 
            // append the new symbol onto the list.
            postFixString.append(operatorStack.pop().getSymbol()).append(" ");
          }
          // Call the interface to check the value
          operatorStack = (CalculatorInterface.inFixSwitch(operatorStack, currentValue));

        }
      }
    }
    for (int i = 0; i < postFixString.length() - 1; i++) {
      if (!(Character.isDigit(i) && Character.isDigit(i + 1))) {
        if (postFixString.charAt(i + 1) == '.') {
          postFixString.deleteCharAt(i);
        }
      }
        
    }

    // @formatter:on
    // call postFix to create an evaluation and return an answer for toString.
    return postFixConv.evaluate(postFixString.toString());
  }
}
