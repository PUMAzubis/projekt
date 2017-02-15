package de.dpma.pumaz.bvs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.BookDAO;
import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import de.dpma.pumaz.bvs.model.Book;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;

	private BorderPane rootLayout;

	Logger log = Logger.getLogger(MainApp.class.getName());

	@Override
	public void start(Stage primaryStage) throws Exception, ClassNotFoundException, SQLException {

		this.primaryStage = primaryStage;
		initRootLayout();
		showLogin();
	}

	private void showLogin() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));

			AnchorPane login;
			login = (AnchorPane) loader.load();
			rootLayout.setCenter(login);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initRootLayout() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		DatabaseConnection dbcon = null;
		try {
			dbcon = new DatabaseConnection();
			BookDAO bookDao = new BookDAO(dbcon.getConnection());
			bookDao.insertBuch(new Book("Tolles Buch", "Toller Autor", 2016, "0000000000", 1));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbcon.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		launch(args);

	}
}
