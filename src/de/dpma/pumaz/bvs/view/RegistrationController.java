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

public class RegistrationController {

	@FXML 
	private Tooltip textFieldAusweissToolTip;
	@FXML 
	private Tooltip textFieldVornameToolTip;
	@FXML 
	private Tooltip textFieldNachnameToolTip;
	@FXML 
	private Tooltip textFieldPasswortToolTip;
	@FXML 
	private Tooltip buttonRegistrierenabschliessenToolTip;
	@FXML 
	private Tooltip buttonzurueckToolTip;
	
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
	
	RootLayoutController root = new RootLayoutController();		
	

	User searchUser;

	Logger log = Logger.getLogger(LoginController.class.getName());

	// Registrierungsangaben prüfen und Registrierung durchführen
	public void handleRegister() throws SQLException {
		if (identificationNumberText.getText().isEmpty() || !isNumeric(identificationNumberText.getText())
				|| identificationNumberText.getText().length() > 5) {
			root.handleDialog("Ausweisnummer ungültig",
					"Es wurde keine gültige Ausweisnummer angegeben. Bitte geben Sie eine valide Ausweisnummer an und versuchen Sie es erneut.",		
					 					"warning");
			
			log.info("Keine gültige Ausweisnummer");
			return;
		}

		if (passwordText.getText().isEmpty() || passwordText.getText().length() < 8) {
			root.handleDialog("Passwort unsicher",
					"Das von Ihnen angegebene Passwort erfüllt nicht unsere Sicherheitsstandards. Bitte geben Sie ein Passwort an, welches mindestens 8 Zeichen lang ist und versuchen Sie es erneut.",		
					 				"warning");
			log.info("Unsicheres Passwort");
			return;
		}

		if (forenameText.getText().isEmpty() || forenameText.getText().length() < 2) {
			root.handleDialog("Vorname ungültig",
					"Der von Ihnen gewählte Vorname ist ungültig. Bitte überprüfen Sie die Eingabe und versuchen Sie es erneut.",		
									"warning");
			log.info("Ungültiger Vorname");
			return;
		}

		if (surnameText.getText().isEmpty() || surnameText.getText().length() < 2) {
			root.handleDialog("Nachname ungültig",
					"Der von Ihnen gewählte Nachname ist ungültig. Bitte überprüfen Sie die Eingabe und versuchen Sie es erneut.",		
					 					"warning");
			
			log.info("Ungültiger Nachname");
			return;
		}

		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		searchUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (searchUser.getForename() != null) {
			root.handleDialog("Mitarbeiter bereits vorhanden",
					"Es wurde bereits ein Mitarbeiter mit dieser Ausweisnummer registriert. Bitte wählen Sie eine andere und versuchen Sie es erneut.",		
					 				"warning");
			log.info("Mitarbeiter mit gleicher Ausweisnummer wurde gefunden, Registrierung nicht möglich");
		} else {
			System.out.println("Mitarbeiter mit gleicher Ausweisnummer nicht gefunden, Registrierung fortfahren");
			UserDao.insertUser(new User(Integer.parseInt(identificationNumberText.getText()), forenameText.getText(),
					surnameText.getText(), passwordText.getText(), 0));
			root.handleDialog("Mitarbeiter erfolgreich angelegt", "", "info");
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
