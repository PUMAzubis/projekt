package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.DatabaseConnection;
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
		loginUser = UserDao.findUser(new User(Integer.parseInt(identificationNumberText.getText())));
		System.out.println(loginUser);
	}

	public void handleExit() {

		DatabaseConnection data = null;
		try {
			data.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void handleAbout() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(LoginController.class.getResource("RootLayout.fxml"));
	}
}
