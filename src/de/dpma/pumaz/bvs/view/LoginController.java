package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
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

	public void handleLogin() throws SQLException {
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		System.out.println(identificationNumberText.getText());
		loginUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		if (loginUser.getForename().isEmpty()) {
			// TODO: Alert ausgeben, sysout removen
			System.out.println("Mitarbeiter nicht gefunden");
		} else {
			System.out.println("Mitarbeiter gefunden");
			if (loginUser.checkPassword(passwordText.getText(), loginUser.getPassword())) {
				// TODO: Weiterleiten, sysout removen
				System.out.println("Passwort richtig, User einloggen");
			} else {
				// TODO: Alert anzeigen, sysout removen
				System.out.println("Passwort falsch");
			}
		}
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
