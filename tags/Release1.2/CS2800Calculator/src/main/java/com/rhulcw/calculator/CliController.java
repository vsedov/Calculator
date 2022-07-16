package com.rhulcw.calculator;

import com.rhulcw.stack.BadType;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Class CliController.
 * Cli interface  you can get access to the cli variant or you can get access to the gui.
 *
 * @author Vivian Sedov
 */
public class CliController {

  /**
   * Cli method will call one of {@linkplain PostFixCaculator} or {@linkplain InFixCalculator}.<br>
   * This will print out the answer, so long as the string is valid using {@linkplain StringEval}.
   *
   * @param scanner scan from initial scnable input.
   * @throws UserStringExecption if the string is incorrect
   * @throws EmptyStackException if the stack is empty
   */
  public static void launchCli(Scanner scanner)
          throws EmptyStackException, UserStringExecption {
    System.out.println("Cli Mode\n");

    System.out.println("Enter\n1: Post Fix\n2: Infix\n3: Exit");

    int option = scanner.nextInt();
    scanner.nextLine();
    switch (option) {
      case (1):
      default:
        System.out.println("Please enter a valid post fix expression\n");
        String postFixVal = scanner.nextLine();

        System.out.println("Current expression: " + postFixVal);
        try {
          // call postFix Caculator, and create a new stringEvaluate and call psotFix check -
          // which will check the string
          // and return a safe value that can get processed
          System.out.println(
            new PostFixCaculator().evaluate(new StringEval().postFixCheck(postFixVal))
          );
          break;
        } catch (EmptyStackException | UserStringExecption e) {
          e.printStackTrace();
        }
        break;
      case (2):
        System.out.println("Please enter a valid  expression\n");
        String inFixVal = scanner.nextLine();
        System.out.println("Your current value is " + inFixVal);
        try {
          System.out.println(
                  InFixCalculator.evaluate(new StringEval().inFixCheck(inFixVal))
          );
          break;
        } catch (EmptyStackException | UserStringExecption | BadType e) {
          e.printStackTrace();
        }
    }
    // Will return back to the output menu
  }

  /**
   * Gets the options.
   *
   * @return the options
   */
  public static String getOptions() {
    // @formatter:off
    return (
      "Calculator option\n" 
      +
      "1. Cli Varient\n" 
      +
      "   | 1.1 PostFix\n" 
      +
      "   | 1.2 InFix\n" 
      +
      "2. Gui\n" 
      +
      "3. Exit\n"
      );
    // @formatter:on

  }

  /**
   * Leave will exit the commandline, completly.
   */
  private static void leave(Scanner input) {
    System.out.println("enter 1 to go back to menue, enter  0 to exit");
    double userChoice = input.nextDouble();

    if (userChoice == 1) {
      outputMenue(input);
    } else {
      input.close();
    }
  }

  /**
   * Output menu , allows access towards {@linkplain CliController#launchGui()}<br>
   * and {@linkplain CliController#launchCli()}.
   *
   * @param input Scanner type to be parsed around.
   * @throws EmptyStackException Stack within the calculator is empty.
   */
  private static int outputMenue(Scanner input) throws EmptyStackException {
    System.out.println(getOptions());
    try (input) {
      System.out.println("Enter a integer value from 1: cli  to 2: Gui 3: exit ");
      double userChoice = input.nextDouble();

      System.out.println("Your Choice was " + userChoice);

      if (userChoice == 1) {
        launchCli(input);
        leave(input);
      } else if (userChoice == 2) {
        input.close();
        return -1;
      } else if (userChoice == 3) {
        leave(input);
      }
    } catch (EmptyStackException | UserStringExecption e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws Exception for the driver gui
   */
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    int x = CliController.outputMenue(input);
    if (x == -1) {
      Driver.main(args);
    }
  }
}
