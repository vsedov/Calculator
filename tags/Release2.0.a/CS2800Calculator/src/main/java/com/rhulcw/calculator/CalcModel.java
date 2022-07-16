package com.rhulcw.calculator;

import com.rhulcw.stack.BadType;
import java.util.EmptyStackException;

/**
 * The CalcModel will parse the StringEval before evaluating the String.
 *
 * @author Vivian Sedov
 */
public class CalcModel {

  /**
   * InFix Evaluation using the following methods.
   * {@linkplain StringEval#inFixCheck(String)}<br>
   * {@linkplain InFixCalculator#evaluate(String)}.
   *
   * @param inFixString the in fix string
   * @return the float
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type
   * @throws UserStringExecption the user string execption
   */
  public static float inFixEvaluation(String inFixString)
          throws EmptyStackException, BadType, UserStringExecption {
    return InFixCalculator.evaluate(new StringEval().inFixCheck(inFixString));
  }

  /**
   * Post fix evaluation uses evaluates String post Fix to Float with StringEvaluation.
   * {@linkplain StringEval#postFixCheck(String)}<br>
   * {@linkplain PostFixCaculator#evaluate(String)}.
   *
   * @param postFixExpr the post fix expr
   * @return the float
   * @throws UserStringExecption if issue with stack / userString
   * @throws EmptyStackException if empty stack
   */
  public static Float postFixEvaluation(String postFixExpr)
          throws EmptyStackException, UserStringExecption {
    return (new PostFixCaculator().evaluate(new StringEval().postFixCheck(postFixExpr)));
  }
}
