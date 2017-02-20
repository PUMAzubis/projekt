package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class EditEmployeeController {
	
	@FXML
	private Tooltip textFieldFirstNameToolTip;
	
	@FXML
	private Tooltip textFieldLastNameToolTip;
	
	@FXML
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Tooltip textFieldPasswortToolTip;
	
	@FXML
	private Tooltip buttonSafeToolTip;
	
	@FXML
	private Tooltip buttonCancelToolTip;
	
	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;
	
	@FXML
	private Label workerIdLabel;
	
	@FXML
	private Label passwordLabel;
	
	@FXML
	private Label hintLabel;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private TextField firstNameTextField;
	
	@FXML
	private TextField lastNameTextField;
	
	@FXML
	private TextField workerIdTextField;
	
	@FXML
	private TextField passwordTextField;
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(EditEmployeeController.class.getName());
	
	public void handleEditFistName() throws SQLException {
		
	}
	
	public void handleEditLastName() throws SQLException {
		
	}
	
	public void handleEditWorkerID() throws SQLException {
		
	}
	
	public void handleEditPassword() throws SQLException {
		
	}
	
	public void handleSave() throws SQLException {
		
	}
	
	public void handleCancel() throws SQLException {
		
	}
}
