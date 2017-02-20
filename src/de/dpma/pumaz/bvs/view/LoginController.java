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
	
	// Eingaben pr�fen und Nutzer einloggen
	public void handleLogin() throws SQLException {
		
		if (identificationNumberText.getText().isEmpty() || !isNumeric(identificationNumberText.getText())
				|| identificationNumberText.getText().length() > 5) {
			// TODO: Alert anzeigen
			log.info("Keine g�ltige Ausweisnummer");
			return;
		}
		
		if (passwordText.getText().isEmpty() || passwordText.getText().length() < 8) {
			// TODO: Alert anzeigen
			log.info("Kein g�ltiges Passwort");
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
				root.handleGUI("booklist");
			}
			else {
				// TODO: Alert anzeigen
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
		
		//
		root.handleGUI("register");
		// fxml_gui = new FXML_GUI(stage, borderPane, "register");
	}
}
