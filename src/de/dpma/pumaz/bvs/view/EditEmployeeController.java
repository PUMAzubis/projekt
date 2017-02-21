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
	private Tooltip textFieldPasswordToolTip;
	
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
	
	@FXML
	private Label headerLabel;
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(EditEmployeeController.class.getName());
	
	public EditEmployeeController() {
		// textFieldFirstNameToolTip.setText("Type in your first name");
		// textFieldLastNameToolTip.setText("Type in your last name");
		// textFieldWorkerIdToolTip.setText("Type in your identification
		// number");
		// textFieldPasswordToolTip.setText("Type in your desired password");
		// buttonSafeToolTip.setText("Click to save");
		// buttonCancelToolTip.setText("Click to cancel");
		// firstNameLabel.setText("First name");
		// lastNameLabel.setText("Last name");
		// workerIdLabel.setText("Identification number");
		// passwordLabel.setText("Password");
		// hintLabel.setText("Fields marked with an asterisk* are obligatory.");
		// saveButton.setText("Save");
		// cancelButton.setText("Cancel");
		// firstNameTextField.setText("First name");
		// lastNameTextField.setText("Last name");
		// workerIdTextField.setText("Identification number");
		// passwordTextField.setText("Password");
		// headerLabel.setText("Edit Employees");
		//
		//
		//
		//
		//
		// textFieldFirstNameToolTip.setText("Vornamen eingeben");
		// textFieldLastNameToolTip.setText("Nachnamen eingeben");
		// textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		// textFieldPasswordToolTip.setText("Passwort eingeben");
		// buttonSafeToolTip.setText("Drücken um zu speichern");
		// buttonCancelToolTip.setText("Drücken um abzubrechen");
		// firstNameLabel.setText("Vorname*:");
		// lastNameLabel.setText("Nachname*:");
		// workerIdLabel.setText("Ausweisnummer*:");
		// passwordLabel.setText("Passwort*:");
		// hintLabel.setText("Mit * markierte Felder müssen ausgefüllt
		// werden.");
		// saveButton.setText("Speichern");
		// cancelButton.setText("Abbrechen");
		// firstNameTextField.setText("Vorname");
		// lastNameTextField.setText("Nachname");
		// workerIdTextField.setText("Ausweisnummer");
		// passwordTextField.setText("Passwort");
		// headerLabel.setText("Mitarbeiter bearbeiten");
	}
	
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
