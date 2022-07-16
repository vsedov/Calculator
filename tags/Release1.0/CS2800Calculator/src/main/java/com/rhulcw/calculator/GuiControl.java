package com.rhulcw.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Class {@linkplain GuiControl} Controller for GUI.
 *
 * @author Vivian Sedov
 */
public class GuiControl {
  /** The input. */
  @FXML
  private TextField input;

  /** The total area. */
  @FXML
  private TextField totalArea;
  
  /** The total area. */
  @FXML
  private TextField history;


  /** The calculate. */
  @FXML
  private Button calculate = null;

  /** Infix - if not infix you know postix, if both then assume infix. */
  @FXML
  private CheckBox infix;

  /** postFix - if not infix you know postix, if both then assume infix. */
  @FXML
  private CheckBox postfix;
}
