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
 * The Class {@linkplain CalcModelTest} on {@linkplain CalcModel} class.
 *
 * @author Vivian Sedov
 */
class CalcModelTest {
  /** instaNCE OF InFix. */
  static CalcModel evaluation;

  /**
   * Sets the up before class.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  static void setUpBeforeClass() {
    evaluation = new CalcModel();
  }

  /**
   * In fix test evaluation on {@linkplain CalcModel#inFixEvaluation(String)}
   *
   * @throws EmptyStackException the empty stack exception
   * @throws BadType the bad type
   * @throws UserStringExecption the user string execption
   */
  @Test
  void inFixTestEvaluation() throws EmptyStackException, BadType, UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();

    stringMap.put("(3.5 + 30)", (float) 33.5);
    stringMap.put("3.4 + 4", (float) 7.4);
    stringMap.put("3 . 4 + 4", (float) 7.4);
    stringMap.put("3 . 4 + 4.5", (float) 7.9);

    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);

      assertEquals(answer, CalcModel.inFixEvaluation(postFixExpr));
    }
  }

  
  /**
   * Testing the complex Quireis used in PostFixTest on {@linkplain CalcModel#postFixEvaluation(String)}.
   *
   * @throws UserStringExecption incorrect string
   */
  @Test
  void complexQueries() throws UserStringExecption {
    final Map<String, Float> stringMap = new HashMap<String, Float>();
    stringMap.put("4 8 3 * +", (float) 28);
    //comment out to pass 
    stringMap.put("78 30 0.5 28 8 + * - 6 / +", (float) 80);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 * +", (float) 7.12);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 +", (float) 3.4);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 - +", (float) 3.72);
    stringMap.put("5.9 5.3 - 7.2 * 1.4 2 / +", (float) 5.02);

    stringMap.put("6   2   /   1   2   + *", (float) 9);
    stringMap.put("62  2  /   1   2   + *", (float) 93);

    
    for (String postFixExpr : stringMap.keySet()) {
      float answer = stringMap.get(postFixExpr);
      assertEquals(answer, CalcModel.postFixEvaluation(postFixExpr));
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
