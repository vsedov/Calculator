package com.rhulcw.calculator;

import com.rhulcw.stack.BadType;
import java.util.EmptyStackException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class {@linkplain Driver} Starts the GUI.
 *
 * @author Vivian Sedov
 */
public class Driver extends Application {
  /** The input. */
  @FXML
  private TextField input;

  /** The output will be updated depending on what the user entered. */
  @FXML
  private TextField output;

  /** The list - will be a textarea that will contain previous inputs. */
  @FXML
  private TextArea list;

  /** The calculate. */
  @FXML
  private Button calculate = null;

  /** Infix - if not infix you know postix, if both then assume infix. */
  @FXML
  private CheckBox infix;

  /** postFix - if not infix you know postix, if both then assume infix. */
  @FXML
  private CheckBox postfix;

  /** The progress for easteregg. */
  @FXML
  private ProgressBar progress = new ProgressBar();

  /** The ammount to update the progress bar. */
  private double ammount = 0.1;

  /**
   * Post fix or in fix.
   * if postFix is selsected wil return false:
   * prompting postfix to be run.
   *
   * @return boolean False True
   */
  private Boolean postFixOrInFix() {
    return infix.isSelected();
  }

  /**
   * Buttom press.
   */
  @FXML
  public void userValue(ActionEvent event) throws UserStringExecption {
    String userInput = input.getText();
    // have a list of user inputs
    list.appendText(userInput + "\n");

    progress.setProgress(ammount);
    ammount = ammount + 0.1;

    try {
      if (Boolean.TRUE.equals(postFixOrInFix())) {
        output.setText(
                String.valueOf(CalcModel.inFixEvaluation(userInput))
        );
      } else {
        output.setText(String.valueOf(CalcModel.postFixEvaluation(userInput)));
      }
    } catch (EmptyStackException | UserStringExecption | BadType e) {
      e.printStackTrace();
      output.setText("error, you have entered incorrectly");
    }
    // Require the user to enter 10 questions to get the special number
    if (progress.getProgress() == (double) 0.9999999999999999) {
      output.setText("16052005");
    }
  }

  /**
   * Used to start the javaFX application/window.
   *
   */
  public void start(Stage stage) throws Exception {
    /*
     * Ref:
     *      1. https://www.educba.com/javafx-fxml/
     *
     */
    Parent root = FXMLLoader.load(getClass().getResource("/calcGUI.fxml"));

    Scene sc = new Scene(root, 300, 300);
    stage.setTitle("Welcom to the GUI");
    stage.setScene(sc);
    stage.show();
  }

  /**
   * main : Start program with launch.
   *
   * @param args , passed for the gui.
   * @throws Exception if startup issues occour.
   */
  public static void main(String[] args) throws Exception {
    launch(args);
  }
}
