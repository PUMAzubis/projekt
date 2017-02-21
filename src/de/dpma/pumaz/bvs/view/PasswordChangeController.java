package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class PasswordChangeController {
	
	@FXML 
	private Tooltip textFieldOldPasswordToolTip;
	@FXML
	private Tooltip textFieldNewPasswordToolTip;
	@FXML
	private Tooltip textFieldNewPasswordConfirmToolTip;
	@FXML
	private Tooltip buttonBackToolTip;
	@FXML
	private Tooltip buttonConfirmToolTip;
	@FXML
	private TextField oldPasswordTextField;
	@FXML
	private TextField newPasswordTextField;
	@FXML
	private TextField confirmNewPasswordTextField;
	@FXML
	private Label oldPasswordLabel;
	@FXML
	private Label newPasswordLabel;
	@FXML
	private Label confirmNewPasswordLabel;
	@FXML
	private Label hintLabel;
	@FXML
	private Button backButton;
	@FXML 
	private Button saveButton;
	@FXML
	private Label headerLabel;
	
	public PasswordChangeController() {

textFieldOldPasswordToolTip.setText("Type in your old password");
textFieldNewPasswordToolTip.setText("Type in your new password");
textFieldNewPasswordConfirmToolTip.setText("Confirm your new password by typing it in again");
buttonBackToolTip.setText("Click to get back to the last window");
buttonConfirmToolTip.setText("Click to confirm");
oldPasswordTextField.setText("Old password");
newPasswordTextField.setText("New password");
confirmNewPasswordTextField.setText("Confirm new password");
oldPasswordLabel.setText("Old password");
newPasswordLabel.setText("New password");
confirmNewPasswordLabel.setText("Confirm new password");
hintLabel.setText("Fields marked with * are required ");
backButton.setText("Back");
saveButton.setText("Save");
headerLabel.setText("Change Password");


textFieldOldPasswordToolTip.setText("Altes Passwort eingeben");
textFieldNewPasswordToolTip.setText("Neues Passwort eingeben");
textFieldNewPasswordConfirmToolTip.setText("Neues Passwort bestätigen, durch wiederholte Eingabe");
buttonBackToolTip.setText("Drücken um zurück zu gelangen");
buttonConfirmToolTip.setText("Drücken um zu bestätigen");
oldPasswordTextField.setText("Altes Passwort eingeben");
newPasswordTextField.setText("Neues Passwort eingeben");
confirmNewPasswordTextField.setText("Neues Passwort bestätigen");
oldPasswordLabel.setText("Altes Passwort");
newPasswordLabel.setText("Neues Passwort");
confirmNewPasswordLabel.setText("Neues Passwort bestätigen");
hintLabel.setText("Mit * markierte Felder sind Pflichtfelder");
backButton.setText("Zurück");
saveButton.setText("Speichern");
headerLabel.setText("Passwort ändern");
	}
	
	Logger log = Logger.getLogger(PasswordChangeController.class.getName());
	
	//public void handlePasswordChange()throws SQLException {
		//if(oldPasswordText.getText().isEmpty() || newPasswordText.getText().isEmpty() || confirmNewPasswordText.getText().isEmpty()){
			//log.info("Passwortfelder müssen ausgefüllt werden!");
			//return;
		//}
	//	if(newPasswordText.getText().length() < 8 || newPasswordText.getText().isEmpty()){
		//	log.info("Unsicheres Passwort!");
		//	return;
		//}
		//if(!confirmNewPasswordText.getText().equals(newPasswordText)){
		//	log.info("Passwort falsch wiederholt!");
		//	return;
		//}
	
	public void handleOldPasswordText() throws SQLException{		
	}		
			
	public void handleNewPasswordText() throws SQLException{		
	}		
			
	public void handleConfirmNewPasswordText() throws SQLException{		
	}		
			
	public void handleConfirm() throws SQLException{		
	}		
			
	public void handleBack() throws SQLException{		
	}		
	
}
