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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML 
	private Tooltip ausweissnummertextfieldToolTip;
	
	@FXML 
	private Tooltip passworttextfieldToolTip;
	@FXML 
	private Tooltip buttonLoginToolTip;
	@FXML 
	private Tooltip buttonpasswortforgotToolTip;
	@FXML 
	private Tooltip buttonregisterToolTip;
	
	@FXML
	private TextField identificationNumberText;
	
	@FXML
	private TextField passwordText;
	
	Stage stage = new Stage();
	
	BorderPane borderPane = new BorderPane();
	
	FXML_GUI fxml_gui;
	
	RootLayoutController root = new RootLayoutController();
	
	User loginUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	// Eingaben prüfen und Nutzer einloggen
	public void handleLogin() throws SQLException {
		
		if (identificationNumberText.getText().isEmpty() || !isNumeric(identificationNumberText.getText())
				|| identificationNumberText.getText().length() > 5) {
			// TODO: Alert anzeigen
			root.handleDialog("Ausweisnummer ungültig",
					"Es wurde keine gültiges Passwort angegeben. Bitte geben Sie ein valides Passwort an und versuchen Sie es erneut.",		
					 			"warning");
			log.info("Keine gültige Ausweisnummer");
			return;
		}
		
		if (passwordText.getText().isEmpty() || passwordText.getText().length() < 8) {
			root.handleDialog("Passwort ungültig",
					"Es wurde keine gültiges Passwort angegeben. Bitte geben Sie ein valides Passwort an und versuchen Sie es erneut.",		
					 				"warning");
			log.info("Kein gültiges Passwort");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		loginUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (loginUser.getForename() == null) {
			root.handleDialog("Kein Benutzer gefunden",
					"Es wurde kein Benutzer anhand der von Ihnen übergebenen Daten gefunden. Bitte überprüfen Sie diese und versuchen Sie es erneut.",		
					 					"warning");
			log.info("Mitarbeiter nicht gefunden");
		}
		else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordText.getText(), loginUser.getPassword())) {
				// TODO: Weiterleiten
				log.info("Passwort richtig, User einloggen");
				root.handleGUI("booklist");
			} else {
				root.handleDialog("Kein Benutzer gefunden",
						"Es wurde kein Benutzer anahnd der von Ihnen übergebenen Daten gefunden. Bitte überprüfen Sie diese und versuchen Sie es erneut.",
						"warning");
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
