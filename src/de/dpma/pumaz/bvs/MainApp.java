package de.dpma.pumaz.bvs;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	Logger log = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DatabaseConnection dbcon = null;
		try {
			dbcon = new DatabaseConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbcon.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
