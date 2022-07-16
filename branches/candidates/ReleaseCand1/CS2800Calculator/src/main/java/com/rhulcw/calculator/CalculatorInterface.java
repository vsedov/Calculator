package com.rhulcw.calculator;

import com.rhulcw.stack.OpStack;
import com.rhulcw.stack.Symbol;

/**
 * The Interface CalculatorInterface.
 *
 * @author Vivian Sedov
 */
public interface CalculatorInterface {
  /**
   * Convert String to Symbol.
   *
   * @param stringSymbol the string symbol
   * @return the symbol type of the string
   */
  private static Symbol convert(String stringSymbol) {
    return Symbol.convertToSymbol(stringSymbol);
  }

  /**
   * In fix switch used in {@linkplain InFixCalculator#evaluate(String)}.
   * Checks  the converted value and pushes what the symbol type is.
   *
   * @param operatorStack the operator stack
   * @param symbol the symbol
   * @return the op stack
   */
  public static OpStack inFixSwitch(OpStack operatorStack, String symbol) {
    Symbol convertion = convert(symbol);
    switch (convertion) {
      case PLUS:
        operatorStack.push(Symbol.PLUS);
        break;
      case MINUS:
        operatorStack.push(Symbol.MINUS);
        break;
      case TIMES:
        operatorStack.push(Symbol.TIMES);
        break;
      case DIVIDE:
        operatorStack.push(Symbol.DIVIDE);
        break;
      default:
        break;
    }
    return operatorStack;
  }

  /**
   * Post fix switch for {@linkplain PostFixCaculator#evaluate}.
   *
   * @param symbol string to be converted.
   * @param evaluation1 floating evaluation of initial pop
   * @param evaluation2 floating evaluation of second pop
   * @return the float, returns calculated expression to be pushed on the stack
   * @throws UserStringExecption the user string execption
   */
  public default float postFixSwitch(String symbol, float evaluation1, float evaluation2)
          throws UserStringExecption {
    Symbol convert = convert(symbol);

    switch (convert) {
      case PLUS:
        return (evaluation2 + evaluation1);
      case MINUS:
        return (evaluation2 - evaluation1);
      case TIMES:
        return (evaluation2 * evaluation1);
      case DIVIDE:
        // So you dont have a zero division error - 0 / 5 for example.
        if (evaluation2 == 0) {
          throw new UserStringExecption("Zero division error");
        }
        return (evaluation2 / evaluation1);
      default:
        throw new UserStringExecption("Invalid input, somethign went wrong!!");
    }
  }
}
