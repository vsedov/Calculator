package com.rhulcw.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class PostFixTest on {@linkplain PostFixCaculator} class.
 *
 * @author Vivian Sedov
 */

class PostFixTest {
  private static PostFixCaculator postFixTestInst;

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
  static void setUpBeforeClass() throws Exception {
    postFixTestInst = new PostFixCaculator();
  }

  /**
   * simpleEvaluationTest test on {@linkplain PostFixCaculator#evaluate(String)}.
   * This is without any string Evaluation. <br>
   * Such that the string needs whitespaces for now.
   *
   * @throws UserStringExecption incorrect string
   */
  @Test
  void simpleEvaluationTest() throws UserStringExecption { // Test Case 1
    // Evaluation of simple 5 + 5 = 10
    final Map<String, Float> stringMap = new HashMap<String, Float>();

    // Dynamic stringMap to add test cases // Inline Test 1
    stringMap.put("5 5 +", (float) 10);
    stringMap.put("20 20 +", (float) 40);
    stringMap.put("5 5 *", (float) 25);
    stringMap.put("5 4 *", (float) 20);
    stringMap.put("6 2 / 1 2 + *", (float) 9); // more complex query.

    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);
      StringEval test = new StringEval();
      assertEquals(answer, postFixTestInst.evaluate(test.postFixCheck(postFixExpr)));
    }
    // Further tests :
  }

  /**
   * Deal with zero division error test.
   *
   * @throws UserStringExecption the user string execption
   */
  @Test
  void dealWithZeroDivisionErrorTest() throws UserStringExecption {
    // @formatter:off
    UserStringExecption e = assertThrows(
              UserStringExecption.class,
              () -> {
          postFixTestInst.evaluate("0 5 /");
          
        }
      );
    // @formatter:on
    assertEquals("Zero division error", e.getMessage());
  }

  /**
   * ComplexQueries test on {@linkplain PostFixCaculator#evaluate(String)}.
   *
   * @throws UserStringExecption incorrect string
   */
  @Test
  void complexQueries() throws UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();
    stringMap.put("4 8 3 * +", (float) 28);
    stringMap.put("78 30 0.5 28 8 + * - 6 / +", (float) 80);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 * +", (float) 7.12);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 +", (float) 3.4);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 - +", (float) 3.72);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 / +", (float) 5.02);

    stringMap.put("6   2   /   1   2   + *", (float) 9);

    StringEval test = new StringEval();
    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      // Aditional test - where i wanted to see if the stringEval would work - working perfectly.

      assertEquals(answer, postFixTestInst.evaluate(test.postFixCheck(postFixExpr)));
    }
  }

  /** CandidateRelase 0 Tests
   * @throws UserStringExecption
   * @throws EmptyStackException
   *
   */
  @Test
  void candRelease0PostFixQueries() throws EmptyStackException, UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();
    stringMap.put("2 + 6 * 3 / 4 - 2", (float) 2);
    stringMap.put("2+4/5*5 3", (float) 3);

    StringEval test = new StringEval();
    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      // Aditional test - where i wanted to see if the stringEval would work - working perfectly.

      assertEquals(answer, postFixTestInst.evaluate(test.postFixCheck(postFixExpr)));
    }
  }

  /** CandidateRelase 1 Tests
   * @throws UserStringExecption
   * @throws EmptyStackException
   *
   */
  @Test
  void candRelease1PostFixQueries() throws EmptyStackException, UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();
    stringMap.put("2.1 2 + 5.2 + 7.2 - 7.1 *", (float) 14.91);
    stringMap.put("6 2 / 1 2 + +", (float) 6);

    StringEval test = new StringEval();
    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      assertEquals(answer, postFixTestInst.evaluate(test.postFixCheck(postFixExpr)));
    }
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {}
}
