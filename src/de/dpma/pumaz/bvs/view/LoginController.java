package de.dpma.pumaz.bvs.view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	
	@FXML
	private TextField identificationNumberText;
	
	@FXML
	private TextField passwordText;
	
	FXML_GUI fxml_gui;
	
	User loginUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	// Eingaben prüfen und Nutzer einloggen
	public void handleLogin() throws SQLException {
		
		if (identificationNumberText.getText().isEmpty() || !isNumeric(identificationNumberText.getText())
				|| identificationNumberText.getText().length() > 5) {
			// TODO: Alert anzeigen
			log.info("Keine gültige Ausweisnummer");
			return;
		}
		
		if (passwordText.getText().isEmpty() || passwordText.getText().length() < 8) {
			// TODO: Alert anzeigen
			log.info("Kein gültiges Passwort");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		loginUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (loginUser.getForename() == null) {
			// TODO: Alert anzeigen
			log.info("Mitarbeiter nicht gefunden");
		}
		else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordText.getText(), loginUser.getPassword())) {
				// TODO: Weiterleiten
				log.info("Passwort richtig, User einloggen");
			}
			else {
				// TODO: Alert anzeigen
				log.info("Passwort falsch");
			}
		}
	}
	
	// Check ob String eine Zahl ist. Um die Ausweisnummer zu prüfen.
	public static boolean isNumeric(String str) {
		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
	@FXML
	public void handleRegistration() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/Registration.fxml"));
			AnchorPane register;
			register = (AnchorPane) loader.load();
			fxml_gui.rootLayout.setCenter(register);
			fxml_gui.primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
