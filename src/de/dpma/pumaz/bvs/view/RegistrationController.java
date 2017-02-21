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
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Tooltip textFieldFirstNameToolTip;
	
	@FXML
	private Tooltip textFieldLastNameToolTip;
	
	@FXML
	private Tooltip textFieldPasswordToolTip;
	
	@FXML
	private Tooltip buttonRegisterToolTip;
	
	@FXML
	private Tooltip buttonBackToolTip;
	
	@FXML
	private TextField workerIdTextField;
	
	@FXML
	private TextField firstNameTextField;
	
	@FXML
	private TextField lastNameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private Label workIdLabel;
	
	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;
	
	@FXML
	private Label passwordLabel;
	
	@FXML
	private Label hintLabel;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button completeButton;
	
	@FXML
	private Label headerLabel;
	
	public RegistrationController() {
		//
		// textFieldWorkerIdToolTip.setText("Type in your identification
		// number");
		// textFieldFirstNameToolTip.setText("Type in your first name");
		// textFieldLastNameToolTip.setText("Type in your last name");
		// textFieldPasswordToolTip.setText("Type in your password");
		// buttonRegisterToolTip.setText("Click to complete your registration");
		// buttonBackToolTip.setText("Click to get back to the last window");
		// workerIdTextField.setText("Identification number");
		// firstNameTextField.setText("First name");
		// lastNameTextField.setText("Last name");
		// passwordTextField.setText("Password");
		// workIdLabel.setText("Identification number");
		// firstNameLabel.setText("First name");
		// lastNameLabel.setText("Last name");
		// passwordLabel.setText("Password");
		// hintLabel.setText("Fields marked with * are required ");
		// backButton.setText("Back");
		// completeButton.setText("Complete");
		// headerLabel.setText("Registration");
		//
		//
		//
		//
		//
		// textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		// textFieldFirstNameToolTip.setText("Vorname eingeben");
		// textFieldLastNameToolTip.setText("Nachname eingeben");
		// textFieldPasswordToolTip.setText("Passwort eingeben");
		// buttonRegisterToolTip.setText("Dr�cken um Registration
		// abzuschliessen");
		// buttonBackToolTip.setText("Dr�cken um zur�ck zu gelangen");
		// workerIdTextField.setText("Ausweisnummer");
		// firstNameTextField.setText("Vorname");
		// lastNameTextField.setText("Nachname");
		// passwordTextField.setText("Passwort");
		// workIdLabel.setText("Ausweisnummer");
		// firstNameLabel.setText("Vorname");
		// lastNameLabel.setText("Nachname");
		// passwordLabel.setText("Passwort");
		// hintLabel.setText("Mit * markierte Felder sind Pflichtfelder ");
		// backButton.setText("Zur�ck");
		// completeButton.setText("Abschlie�en");
		// headerLabel.setText("Registrieren");
	}
	
	RootLayoutController root = new RootLayoutController();
	
	User searchUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	// Registrierungsangaben pr�fen und Registrierung durchf�hren
	public void handleRegister() throws SQLException {
		
		if (workerIdTextField.getText().isEmpty() || !isNumeric(workerIdTextField.getText())
				|| workerIdTextField.getText().length() > 5) {
			root.handleDialog("Ausweisnummer ung�ltig",
					"Es wurde keine g�ltige Ausweisnummer angegeben. Bitte geben Sie eine valide Ausweisnummer an und versuchen Sie es erneut.",
					"warning");
			
			log.info("Keine g�ltige Ausweisnummer");
			return;
		}
		
		if (passwordTextField.getText().isEmpty() || passwordTextField.getText().length() < 8) {
			root.handleDialog("Passwort unsicher",
					"Das von Ihnen angegebene Passwort erf�llt nicht unsere Sicherheitsstandards. Bitte geben Sie ein Passwort an, welches mindestens 8 Zeichen lang ist und versuchen Sie es erneut.",
					"warning");
			log.info("Unsicheres Passwort");
			return;
		}
		
		if (firstNameTextField.getText().isEmpty() || firstNameTextField.getText().length() < 2) {
			root.handleDialog("Vorname ung�ltig",
					"Der von Ihnen gew�hlte Vorname ist ung�ltig. Bitte �berpr�fen Sie die Eingabe und versuchen Sie es erneut.",
					"warning");
			log.info("Ung�ltiger Vorname");
			return;
		}
		
		if (lastNameTextField.getText().isEmpty() || lastNameTextField.getText().length() < 2) {
			root.handleDialog("Nachname ung�ltig",
					"Der von Ihnen gew�hlte Nachname ist ung�ltig. Bitte �berpr�fen Sie die Eingabe und versuchen Sie es erneut.",
					"warning");
			
			log.info("Ung�ltiger Nachname");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		searchUser = UserDao.findUser(new User(Integer.parseInt(workerIdTextField.getText())));
		if (searchUser.getForename() != null) {
			root.handleDialog("Mitarbeiter bereits vorhanden",
					"Es wurde bereits ein Mitarbeiter mit dieser Ausweisnummer registriert. Bitte w�hlen Sie eine andere und versuchen Sie es erneut.",
					"warning");
			log.info("Mitarbeiter mit gleicher Ausweisnummer wurde gefunden, Registrierung nicht m�glich");
		}
		else {
			System.out.println("Mitarbeiter mit gleicher Ausweisnummer nicht gefunden, Registrierung fortfahren");
			UserDao.insertUser(new User(Integer.parseInt(workerIdTextField.getText()), firstNameTextField.getText(),
					lastNameTextField.getText(), passwordTextField.getText(), 0));
			root.handleDialog("Mitarbeiter erfolgreich angelegt", "", "info");
			log.info("Mitarbeiter angelegt");
		}
	}
	
	// Check ob String eine Zahl ist. Um die Ausweisnummer zu pr�fen.
	public static boolean isNumeric(String str) {
		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
}
