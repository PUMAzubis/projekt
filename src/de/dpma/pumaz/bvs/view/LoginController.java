package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;

public class LoginController {
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	public void handleExit() {
		
		DatabaseConnection data = null;
		try {
			data.closeConnection();
		}
		catch (SQLException e) {
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
