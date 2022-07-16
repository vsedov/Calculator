package com.rhulcw.calculator;

import com.rhulcw.stack.NumStack;
import com.rhulcw.stack.Symbol;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Class {@linkplain PostFixCaculator} Evaluates Expressions of the following type.#
 * (5 6 7 + ∗ 2 − evaluates as 63.0)
 *
 * @author Vivian Sedov
 */

// Reverse Polish is PostFixCaculator
public class PostFixCaculator {
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
    // Reference : https://www.tutorialcup.com/interview/stack/evaluation-of-postfix-expression.html
    float evaluation1;
    float evaluation2;
    // we have to use a scanner due a string can have a floating value.
    try (Scanner evalScan = new Scanner(currentString)) {
      while (evalScan.hasNext()) {
        if (evalScan.hasNextFloat()) {
          numStack.push(evalScan.nextFloat());
        } else {
          String currentSymbol = evalScan.next();

          evaluation1 = numStack.pop();
          evaluation2 = numStack.pop();
          // refer to https://en.wikipedia.org/wiki/Reverse_Polish_notation For further info.

          Symbol convert = Symbol.convertToSymbol(currentSymbol);

          switch (convert) {
            case PLUS:
              numStack.push(evaluation2 + evaluation1);
              break;
            case MINUS:
              numStack.push(evaluation2 - evaluation1);
              break;
            case TIMES:
              numStack.push(evaluation2 * evaluation1);
              break;
            case DIVIDE:
              // So you dont have a zero division error - 0 / 5 for example.
              if (evaluation2 == 0) {
                throw new UserStringExecption("Zero division error");
              }
              numStack.push(evaluation2 / evaluation1);
              break;
            default:
              throw new UserStringExecption("Invalid input, somethign went wrong!!");
          }
        }
      }
    }

    // rounding required to meet test cases
    return (float) (Math.round(numStack.pop() * 100) / 100.00);
  }
}
