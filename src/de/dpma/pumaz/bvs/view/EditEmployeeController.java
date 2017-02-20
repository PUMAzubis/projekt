package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;		
import java.util.logging.Logger;		
		
import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
		
		@FXML
		private TextField firstNameText;
		@FXML		
		private TextField lastNameText;		
		@FXML		
		private TextField workIdText;		
		@FXML		
		private TextField passwordText;		
	 	
	
	public EditEmployeeController() {
		textfieldvornameToolTip.setText("Type in your first name");
		textfieldnachnameToolTip.setText("Type in your last name");
		textfieldausweisnummerToolTip.setText("Type in your identification number");
		textfieldpasswortToolTip.setText("Type in your desired password");
		buttonsafeToolTip.setText("Click to save");
		buttoncancelToolTip.setText("Click to cancel");
		firstnameLabel.setText("First name");
		lastnameLabel.setText("Last name");
		workidLabel.setText("Identification number");
		passwordLabel.setText("Password");
		hintLabel.setText("Fields marked with an asterisk* are obligatory.");
		saveButton.setText("Save");
		cancelButton.setText("Cancel");
		firstNameText.setText("First name");
		lastNameText.setText("Last name");
		workIdText.setText("Identification number");		
		passwordText.setText("Password");
	}
	Stage stage = new Stage();		
	 			
	 FXML_GUI fxml_gui;		
	 			
	 Logger log = Logger.getLogger(EditEmployeeController.class.getName());		
	 			
	 public void handleEditFistName() throws SQLException{		
	 }		
	 			
	 public void handleEditLastName() throws SQLException{		
	 }		
	 			
	 public void handleEditWorkID() throws SQLException{		
	 }		
	 			
	 public void handleEditPassword() throws SQLException{		
	 }		
	 			
	 public void handleSave() throws SQLException{		
	 }		
	 			
	 public void handleCancel() throws SQLException{		
	 }
}
