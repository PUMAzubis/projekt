package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Über");
		
		alert.setHeaderText("Über");
		
		String s ="Das Programm wurde erstellt von Florian Seidl, Kenneth Böhmer, Kinan Saeb, Abdahllah Al-Maskari und Alexander Bacher";
		
		alert.setContentText(s);
		
		alert.show();

	}
}
