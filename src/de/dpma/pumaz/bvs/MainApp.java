package de.dpma.pumaz.bvs;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static DatabaseConnection dbcon = null;

	Logger log = Logger.getLogger(MainApp.class.getName());

	@Override
	public void start(Stage primaryStage) throws Exception, ClassNotFoundException, SQLException {

		log.info("Oberfläche wird initalisiert");
		FXML_GUI fxml_gui = new FXML_GUI();
		fxml_gui.primaryStage = primaryStage;

		fxml_gui.initRootLayout(false);
		fxml_gui.showLogin();
		log.info("Die Oberfläche wurde initalisiert");
	}

	public static void main(String[] args) {

		try {
			dbcon = new DatabaseConnection();
			launch(args);
			// UserDAO userDao = new UserDAO(dbcon.getConnection());
			// userDao.insertUser(new User(12345, "Flo", "Seidl", "Kekskuchen",
			// 0));
			//
			// BookDAO bookDao = new BookDAO(dbcon.getConnection());
			// bookDao.insertBook(new Book("Tolles Buch", "Toller Autor", 2015,
			// "0000000000", 1));
			// for (Book b : bookDao.searchBooks("toll")) {
			// System.out.println(b.getName());
			// }
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
