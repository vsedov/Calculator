package com.rhulcw.calculator;

import com.rhulcw.stack.NumStack;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Class {@linkplain PostFixCaculator} Evaluates Expressions of the following type.#
 * (5 6 7 + ∗ 2 − evaluates as 63.0)
 *
 * @author Vivian Sedov
 */

// Reverse Polish is PostFixCaculator
public class PostFixCaculator implements CalculatorInterface {
  /**
   * The Constant numStack references {@linkplain NumStack}.
   */
  public static final NumStack numStack = new NumStack();

  /**
   * This is where the formated string will be evaluated to return an answer.
   *
   * @param currentString Formated String will be evaluated
   * @return float will be the answer
   * @throws UserStringExecption {@linkplain UserStringExecption}<br>
   */
  public float evaluate(String currentString)
          throws UserStringExecption, EmptyStackException {
    // Reference : https://www.tutorialspoint.com/Evaluate-Postfix-Expression

    // we have to use a scanner due a string can have a floating value,
    //hence why for loop cant be used.
      
      
    try (Scanner evalScan = new Scanner(currentString)) {
      while (evalScan.hasNext()) {
        if (evalScan.hasNextFloat()) {
          numStack.push(evalScan.nextFloat());
        } else {
          String currentSymbol = evalScan.next();
          numStack.push(postFixSwitch(currentSymbol, numStack.pop(), numStack.pop()));
          // refer to https://en.wikipedia.org/wiki/Reverse_Polish_notation For further info.

        }
      }
    }

    // rounding required to meet test cases
    return (float) (Math.round(numStack.pop() * 100) / 100.00);
  }
}
