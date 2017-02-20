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

public class RegistrationController {

	@FXML
	private TextField identificationNumberText;
	@FXML
	private TextField forenameText;
	@FXML
	private TextField surnameText;
	@FXML
	private TextField passwordText;
	@FXML
	private Label workIDLabel;
	@FXML 
	private Label firstnameLabel;
	@FXML
	private Label lastnameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label hintLabel;
	@FXML
	private Button backButton;
	@FXML 
	private Button completeButton;

	User searchUser;

	Logger log = Logger.getLogger(LoginController.class.getName());

	// Registrierungsangaben prüfen und Registrierung durchführen
	public void handleRegister() throws SQLException {
		if (identificationNumberText.getText().isEmpty() || !isNumeric(identificationNumberText.getText())
				|| identificationNumberText.getText().length() > 5) {
			// TODO: Alert anzeigen
			log.info("Keine gültige Ausweisnummer");
			return;
		}

		if (passwordText.getText().isEmpty() || passwordText.getText().length() < 8) {
			// TODO: Alert anzeigen
			log.info("Unsicheres Passwort");
			return;
		}

		if (forenameText.getText().isEmpty() || forenameText.getText().length() < 2) {
			// TODO: Alert anzeigen
			log.info("Ungültiger Vorname");
			return;
		}

		if (surnameText.getText().isEmpty() || surnameText.getText().length() < 2) {
			// TODO: Alert anzeigen
			log.info("Ungültiger Nachname");
			return;
		}

		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		searchUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (searchUser.getForename() != null) {
			// TODO: Alert anzeigen
			log.info("Mitarbeiter mit gleicher Ausweisnummer wurde gefunden, Registrierung nicht möglich");
		} else {
			System.out.println("Mitarbeiter mit gleicher Ausweisnummer nicht gefunden, Registrierung fortfahren");
			UserDao.insertUser(new User(Integer.parseInt(identificationNumberText.getText()), forenameText.getText(),
					surnameText.getText(), passwordText.getText(), 0));
			// TODO: Alert anzeigen
			log.info("Mitarbeiter angelegt");
		}
	}

	// Check ob String eine Zahl ist. Um die Ausweisnummer zu prüfen.
	public static boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
}
