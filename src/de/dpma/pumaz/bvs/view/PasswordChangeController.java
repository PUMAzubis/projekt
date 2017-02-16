package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PasswordChangeController {
	
	
	@FXML
	private TextField oldPasswordText;
	@FXML
	private TextField newPasswordText;
	@FXML
	private TextField confirmNewPasswordText;
	
	Logger log = Logger.getLogger(PasswordChangeController.class.getName());
	
	public void handlePasswordChange()throws SQLException {
		if(oldPasswordText.getText().isEmpty() || newPasswordText.getText().isEmpty() || confirmNewPasswordText.getText().isEmpty()){
			log.info("Passwortfelder müssen ausgefüllt werden!");
			return;
		}
		if(newPasswordText.getText().length() < 8 || newPasswordText.getText().isEmpty()){
			log.info("Unsicheres Passwort!");
			return;
		}
		if(!confirmNewPasswordText.getText().equals(newPasswordText)){
			log.info("Passwort falsch wiederholt!");
			return;
		}
		
		
	}
}
