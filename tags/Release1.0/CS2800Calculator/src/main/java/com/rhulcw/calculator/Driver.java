package com.rhulcw.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class {@linkplain Driver} Starts the GUI.
 *
 * @author Vivian Sedov
 */
public class Driver extends Application {

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
