package de.dpma.pumaz.bvs.view;

import java.util.logging.Logger;
import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class PasswordResetController {
	
	@FXML 
	private Tooltip buttonBackToolTip;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Label headerLabel;
	
	@FXML
	private Label textLabel;
	
	@FXML
	private Label text2Label;
	
	public PasswordResetController() {
		buttonBackToolTip.setText("Click to get back to the last window");
		backButton.setText("Back");
		headerLabel.setText("Password reset");
		textLabel.setText("If you forgot the password to your personal account, ");
		text2Label.setText("please contact one of the administrators listed below.");
		
		
		
		
		buttonBackToolTip.setText("Dr�cken um zur�ck zu gelangen");
		backButton.setText("Zur�ck");
		headerLabel.setText("Passwort zur�cksetzen");
		textLabel.setText("Wenn Sie das Passwort zu Ihrem pers�nlichen Account vergessen haben, ");
		text2Label.setText("kontaktieren Sie bitte einen der unten genannten Administratoren per Email.");
	}
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(PasswordResetController.class.getName());
	
	public void handleBack(){
	}
}
