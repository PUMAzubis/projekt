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
		buttonRegisterToolTip.setText("Drücken um zu registrieren");
		buttonPasswordForgotToolTip.setText("Drücken um Passwort zurückzusetzen");
		buttonLoginToolTip.setText("Drücken um einzuloggen");
		textFieldPasswordToolTip.setText("Passwort eingeben");
		textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		
	}
	
	
	
	Stage stage = new Stage();
	
	BorderPane borderPane = new BorderPane();
	
	FXML_GUI fxml_gui;
	
	RootLayoutController root = new RootLayoutController();
	
	User loginUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	// Eingaben prüfen und Nutzer einloggen
	public void handleLogin() throws SQLException {
		
		if (workerIdTextField.getText().isEmpty() || !isNumeric(workerIdTextField.getText())
				|| workerIdTextField.getText().length() > 5) {
			// TODO: Alert anzeigen
			log.info("Keine gültige Ausweisnummer");
			return;
		}
		
		if (passwordTextField.getText().isEmpty() || passwordTextField.getText().length() < 8) {
			// TODO: Alert anzeigen
			log.info("Kein gültiges Passwort");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		loginUser = UserDao.findUser(new User(Integer.parseInt(workerIdTextField.getText())));
		if (loginUser.getForename() == null) {
			// TODO: Alert anzeigen
			log.info("Mitarbeiter nicht gefunden");
		}
		else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordTextField.getText(), loginUser.getPassword())) {
				// TODO: Weiterleiten
				log.info("Passwort richtig, User einloggen");
				root.handleGUI("bookList");
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
		
		//
		root.handleGUI("register");
		// fxml_gui = new FXML_GUI(stage, borderPane, "register");
	}
}
