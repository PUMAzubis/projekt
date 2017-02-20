package de.dpma.pumaz.bvs.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

public class EditEmployeeController {

	@FXML 
	private Tooltip textfieldvornameToolTip;
	@FXML 
	private Tooltip textfieldnachnameToolTip;
	@FXML 
	private Tooltip textfieldausweisnummerToolTip;
	@FXML 
	private Tooltip textfieldpasswortToolTip;
	@FXML 
	private Tooltip buttonsafeToolTip;
	@FXML 
	private Tooltip buttoncancelToolTip;
	@FXML
	private Label firstnameLabel;
	
	@FXML 
	private Label lastnameLabel;
	
	@FXML
	private Label workidLabel;
	
	@FXML
	private Label passwordLabel;
	
	@FXML
	private Label hintLabel;
	
	@FXML 
	private Button saveButton;
	
	@FXML
	private Button cancelButton;
}
