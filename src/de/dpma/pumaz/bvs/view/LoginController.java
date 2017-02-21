package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Tooltip textFieldPasswordToolTip;
	
	@FXML
	private Tooltip buttonLoginToolTip;
	
	@FXML
	private Tooltip buttonPasswordForgotToolTip;
	
	@FXML
	private Tooltip buttonRegisterToolTip;
	
	@FXML
	private TextField workerIdTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private Label headerLabel;
	
	@FXML 
	private Label passwordLabel;
	
	@FXML
	private Label workerIdLabel;
	
	@FXML 
	private Label hintLabel;
	
	public LoginController() {
		hintLabel.setText("Fields marked with * are obligatory");
		workerIdLabel.setText("Identification number");
		passwordLabel.setText("Password");
		headerLabel.setText("Library management software");
		passwordTextField.setText("Password");
		workerIdTextField.setText("Identification number");
		buttonRegisterToolTip.setText("Click to register");
		buttonPasswordForgotToolTip.setText("Click if you forgot your password");
		buttonLoginToolTip.setText("Click to login");
		textFieldPasswordToolTip.setText("Type in your password");
		textFieldWorkerIdToolTip.setText("Type in your identification number");
		
		hintLabel.setText("Felder mit * markiert sind Pflichtfelder");
		workerIdLabel.setText("Ausweisnummer");
		passwordLabel.setText("Passwort");
		headerLabel.setText("Bibliotheksverwaltungssystem");
		passwordTextField.setText("Passwort");
		workerIdTextField.setText("Ausweisnummer");
		buttonRegisterToolTip.setText("Dr�cken um zu registrieren");
		buttonPasswordForgotToolTip.setText("Dr�cken um Passwort zur�ckzusetzen");
		buttonLoginToolTip.setText("Dr�cken um einzuloggen");
		textFieldPasswordToolTip.setText("Passwort eingeben");
		textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		
	}
	
	
	
	Stage stage = new Stage();
	
	BorderPane borderPane = new BorderPane();
	
	FXML_GUI fxml_gui;
	
	RootLayoutController root = new RootLayoutController();
	
	User loginUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	// Eingaben pr�fen und Nutzer einloggen
	public void handleLogin() throws SQLException {
		
		if (workerIdTextField.getText().isEmpty() || !isNumeric(workerIdTextField.getText())
				|| workerIdTextField.getText().length() > 5) {
			root.handleDialog("Ausweisnummer ung�ltig",
					"Es wurde keine g�ltiges Passwort angegeben. Bitte geben Sie ein valides Passwort an und versuchen Sie es erneut.",
					"warning");
			log.info("Keine g�ltige Ausweisnummer");
			return;
		}
		
		if (passwordTextField.getText().isEmpty() || passwordTextField.getText().length() < 8) {
			root.handleDialog("Passwort ung�ltig",
					"Es wurde keine g�ltiges Passwort angegeben. Bitte geben Sie ein valides Passwort an und versuchen Sie es erneut.",
					"warning");
			log.info("Kein g�ltiges Passwort");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		loginUser = UserDao.findUser(new User(Integer.parseInt(workerIdTextField.getText())));
		if (loginUser.getForename() == null) {
			root.handleDialog("Kein Benutzer gefunden",
					"Es wurde kein Benutzer anhand der von Ihnen �bergebenen Daten gefunden. Bitte �berpr�fen Sie diese und versuchen Sie es erneut.",
					"warning");
			log.info("Mitarbeiter nicht gefunden");
		}
		else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordTextField.getText(), loginUser.getPassword())) {
				
				log.info("Passwort richtig, User einloggen");
				root.handleGUI("bookList");
			}
			else {
				root.handleDialog("Kein Benutzer gefunden",
						"Es wurde kein Benutzer anahnd der von Ihnen �bergebenen Daten gefunden. Bitte �berpr�fen Sie diese und versuchen Sie es erneut.",
						"warning");
				log.info("Passwort falsch");
			}
		}
	}
	
	// Check ob String eine Zahl ist. Um die Ausweisnummer zu pr�fen.
	public static boolean isNumeric(String str) {
		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
	@FXML
	public void handleRegistration() {
		
		root.handleGUI("register");
	}
}
