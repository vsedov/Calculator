package com.rhulcw.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rhulcw.stack.BadType;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class {@linkplain InFixTest} on {@linkplain InFixCaculator} class.
 *
 * @author Vivian Sedov
 */
class InFixTest {
  /** instaNCE OF InFix. */
  static InFixCalculator inFix;

  /*
   * Ref :
   *  Examples for this question were taken from :
   *            https://www.free-online-calculator-use.com/infix-to-postfix-converter.html
   */

  /**
   * Sets the up before class.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  static void setUpBeforeClass() {
    inFix = new InFixCalculator();
  }

  /**
   * Evaluation test test duel bracketed string values.<br>
   * This tests the function {@linkplain InFixCalculator#evaluate(String)}.
   *
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type execption if incorrect type is given.
   * @throws UserStringExecption the user string execption
   */
  @Test
  void evaluationTest() throws EmptyStackException, BadType, UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();

    stringMap.put("( 5 * 5 * 5 )", (float) 125); //Inline Test 1
    stringMap.put("( 5 * 4 )", (float) 20);
    stringMap.put("( 5 + 5 )", (float) 10);
    // @formatter:off
    stringMap.put(
            "( ( ( ( 3 + 2 + 3 ) * 2 + 3 ) * ( ( 5 ) / 2 ) + 1 ) / 5 )",
            (float) 9.7
    );
    // @formatter:on

    stringMap.put("( 5 + ( 7 * 20 / 2 ) + ( 5 / 5 ) )", (float) 76);

    stringMap.put("( ( 5 * ( 6 + 7 ) ) - 2 )", (float) 63.0);

    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      assertEquals(answer, InFixCalculator.evaluate(postFixExpr));
    }
  }

  /**
   * Evaluation test test duel bracketed string values.<br>
   * This tests the function {@linkplain InFixCalculator#evaluate(String)}.<br>
   * Updates the string using the function {@linkplain StringEval#inFixCheck(String)}.
   *
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type execption if incorrect type is given.
   * @throws UserStringExecption the user string execption
   */
  @Test
  // @formatter:off
  void withStringEvalEvaluationTest()
          throws EmptyStackException, BadType, UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();

    stringMap.put("(5*5*5)", (float) 125); //Inline Test 1
    stringMap.put("(5*4)", (float) 20);
    stringMap.put("( 5+5 )", (float) 10);
    stringMap.put("((((3+2+3)*2+3)*((5)/2)+1)/5)", (float) 9.7);
    stringMap.put("((5*(6+7))-2)/30", (float) 2.1);
    stringMap.put("((5*(6+7))-2)/30 * (14 * 10)", (float) 294.0);
    stringMap.put("((5*(6+7))-2)/30 * (14 * 10) / 10 + 40 / 100", (float) 29.8);
    stringMap.put("5 + 10 * ( 5 + (5 / 20) / 10 )", (float) 55.25);
    stringMap.put("5 + 10 * ( 5 + (5 / 20) / 10 ) / 200", (float) 5.25);

    
    StringEval stringCleaner = new StringEval();
    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      assertEquals(
              answer,
              InFixCalculator.evaluate(stringCleaner.inFixCheck(postFixExpr))
      );
    }
    // @formatter:on

    // Tests were added on as different functions were made
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {}
}
