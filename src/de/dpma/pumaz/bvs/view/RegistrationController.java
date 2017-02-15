package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.fxml.FXML;
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

	User registerUser;

	Logger log = Logger.getLogger(LoginController.class.getName());

	public void handleRegister() throws SQLException {
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		System.out.println(identificationNumberText.getText());
		loginUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (loginUser.getForename().isEmpty()) {
			// TODO: Alert ausgeben
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
}
