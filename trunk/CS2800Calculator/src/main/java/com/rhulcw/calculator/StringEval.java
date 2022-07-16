package com.rhulcw.calculator;

import java.util.Stack;

/**
 * Class {@linkplain StringEval}.
 * Adds white space to a string ensuring the calculation will be correct.
 *
 * @author Vivian Sedov
 */
public class StringEval {

  /**
   * Compare the current ith value with i+1<br>
   * Ensuring that the first value is a digit compared to the second i+1 value<br>
   * being a character.
   *
   * @param currentString string from the main source
   * @param i the ith position of the string
   * @return the boolean, returns true if i is a digit and i+1 is not
   */
  private Boolean currentSingleDigit(String currentString, int i) {
    // Compare current character ensuring that it is a digit - and
    // checking if the next value is not a digit.
    return (
      Character.isDigit(currentString.charAt(i)) 
      &&
      !Character.isDigit(currentString.charAt(i + 1))
      );
  }

  /**
   * Compare the current ith value with i+1<br>
   * Ensuring that the first value is not a digit compared to the second i+1 value<br>
   * being a number.
   *
   * @param currentString string from the main source
   * @param i the ith position of the string
   * @return the boolean, returns true if i is a digit and i+1 is not
   */
  private Boolean secondSingleDigit(String currentString, int i) {
    return (
      !Character.isDigit(currentString.charAt(i)) 
      &&
      Character.isDigit(currentString.charAt(i + 1))
      );
  }

  /**
   * Compare the current ith value with i+1<br>
   * Ensuring that the first value is not a digit compared to the second i+1 value<br>
   * also not being a digit.
   *
   * @param currentString string from the main source
   * @param i the ith position of the string
   * @return the boolean, returns true if i is a digit and i+1 is not
   */
  private Boolean bothNotDigits(String currentString, int i) {
    return (
      !Character.isDigit(currentString.charAt(i)) 
      &&
      !Character.isDigit(currentString.charAt(i + 1))
      );
  }

  /**
   * Bracket valid Function will check if the string is valid or no.
   *
   * @param string the inFix Expression
   * @return the boolean
   */
  public boolean bracketValid(String string) {
    if (string.isEmpty()) {
      return true;
    }
    Stack<Character> bracketStack = new Stack<>();

    for (int i = 0; i < string.length(); i++) {
      char currentChar = string.charAt(i);
      if (currentChar == '(') {
        bracketStack.push(')');
      } else if (currentChar == ')' && bracketStack.isEmpty()) {
        return false;
      } else if (!(bracketStack.isEmpty()) && currentChar == ')') {
        bracketStack.pop();
      }
    }
    return bracketStack.isEmpty();
  }

  /**
   * Post fix check, ensures that the format is correct for the user input.
   *
   * @param currentString postFix String to be evaluated
   * @return returns a correctly formated post fix expression
   */
  public String postFixCheck(String currentString) {
    // Ref :
    // - https://www.tutorialspoint.com/check-if-the-string-has-only-unicode-digits-or-space-in-java
    // @formatter:off

    for (int i = 0; i < currentString.length() - 1; i++) {
      if (
              // Example : 5+ would be evaluated here
              Boolean.TRUE.equals(currentSingleDigit(currentString, i))
              ||
              // Example : +5 would be evaluated here
              Boolean.TRUE.equals(secondSingleDigit(currentString, i))
              ||
              // Example : ++ would be evaluated here
              Boolean.TRUE.equals((bothNotDigits(currentString, i)))) {
        // -----------------Inside of IfStatement-----------------------
        
        // Have to Check if there is a floating point value in either 
        // the first or second ith value - so we dont add extra spaces
        if (currentString.charAt(i + 1) == '.' || currentString.charAt(i) == '.') {
          continue;
        }
        currentString = currentString.substring(0, i + 1) + " " 
                + currentString.substring(i + 1, currentString.length());
        // ^^ - Adding a white space so long as it is not a number using the 
        // functions listed above.
        
        i++; // This needs to be updated manually to change current character
        // --------------------------------------------------
        

      }
      
    }
    // @formatter:on

    return currentString.replaceAll("\\s+", " ");
  }

  /**
   * String evaluation: Evaluates the current String for Infix expressions.
   * First Checks the brackets within the currentString if they are valid using <br>
   * {@linkplain StringEval#bracketValid(String)}.
   *
   * @param currentString the current string
   * @return the string the new reformatedString.
   */
  public String inFixCheck(String currentString) {
    // Use the evaluation string
    currentString = "( " + currentString + " )";

    if (Boolean.FALSE.equals(bracketValid(currentString))) {
      return null;
    }
    StringBuilder formatedString = new StringBuilder();
    // We have to add the brackets here no matter what - otherwise the priorites will get messed up
    currentString = currentString.replaceAll("\\s", "");

    for (int i = 0; i < currentString.length(); i++) {
      formatedString.append(currentString.charAt(i)).append(" ");
    }

    for (int i = 0; i < formatedString.length() - 2; i++) {
      // @formatter:off
      Boolean flag =
              (
          Character.isDigit(formatedString.charAt(i + 2)) 
          &&
          Character.isDigit(formatedString.charAt(i))
        );
      // @on


      if (Boolean.TRUE.equals(flag)) {
        formatedString.deleteCharAt(i + 1);
      }
    }

    // this deletes the final white space as its not needed
    formatedString.deleteCharAt(formatedString.length() - 1);

    return formatedString.toString();
  }
}
