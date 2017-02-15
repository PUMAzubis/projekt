package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField identificationNumberText;
	@FXML
	private TextField passwordText;

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
		} else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordText.getText(), loginUser.getPassword())) {
				// TODO: Weiterleiten
				log.info("Passwort richtig, User einloggen");
			} else {
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

	public void handleExit() {

		try {
			MainApp.dbcon.closeConnection();
			System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleAbout() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(LoginController.class.getResource("RootLayout.fxml"));
	}
}
